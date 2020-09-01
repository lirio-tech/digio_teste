package br.com.digio.digioteste.config.trace;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JaegerTraceTests {

    @Test
    public void testInputOutput() {
        String wlc = test("Diego");
        System.out.println(wlc);
    }

    @LogTrace
    public String test(String name) {
        return String.format("Hi, %s", name);
    }

}
