package br.com.digio.digioteste.config.trace;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.opentracing.Span;
import io.opentracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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

    @Pointcut("@annotation(Trace)")
    public void pointcutTrace() {
    }

    @Before("pointcutTrace()")
    public void beforeTrace(final JoinPoint joinPoint) {
        Span span = tracer.buildSpan(joinPoint.getSignature().getName()).start();
        span.setTag("input", joinPoint.toString());
        log.info(joinPoint.getArgs().toString());
        spanMap.put(tracer.activeSpan().context().toSpanId(), span);
    }

    @AfterReturning(pointcut = "pointcutTrace()", returning = "retorno")
    public void afterTrace(final JoinPoint joinPoint, final Object retorno) throws JsonProcessingException {
        Span span = spanMap.get(tracer.activeSpan().context().toSpanId());
        log.warn(joinPoint.toString());
        log.warn(objectMapper.writeValueAsString(retorno));
        span.finish();
    }

}
