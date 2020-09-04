package br.com.digio.digioteste.config.trace;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.opentracing.Span;
import io.opentracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Aspect
@Component
@EnableAspectJAutoProxy
public class JaegerTrace {

    @Autowired
    private Tracer tracer;

    @Autowired
    private ObjectMapper objectMapper;

    private Map<String, Span> spanMap = new HashMap<>();

    @Pointcut("@annotation(LogTrace)")
    public void pointcutTrace() {
    }

    @Before("pointcutTrace()")
    public void beforeTrace(final JoinPoint joinPoint) {
        // TODO tests args input and out
        Span span = tracer.buildSpan(joinPoint.getSignature().getName()).start();
        span.setTag("input", joinPoint.toString());
        if(Objects.nonNull(joinPoint.getArgs())) {
            String inputs = StringUtils.EMPTY;
            for(Object o : joinPoint.getArgs()) {
                inputs += o.toString() + ", ";
            }
            log.info(inputs);
        }
        spanMap.put(tracer.activeSpan().context().toSpanId(), span);
    }

    @AfterReturning(pointcut = "pointcutTrace()", returning = "retorno")
    public void afterTrace(final JoinPoint joinPoint, final Object retorno) throws JsonProcessingException {
        log.info(joinPoint.toString());
        Span span = spanMap.get(tracer.activeSpan().context().toSpanId());
        log.warn(objectMapper.writeValueAsString(retorno));
        span.finish();
    }

}
