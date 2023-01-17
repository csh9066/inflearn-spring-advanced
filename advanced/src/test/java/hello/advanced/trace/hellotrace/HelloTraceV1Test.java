package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {

    HelloTraceV1 trace = new HelloTraceV1();

    @Test
    void begin_end() {
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException("bad"));
    }

}