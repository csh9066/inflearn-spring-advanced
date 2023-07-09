package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TraceTemplate {

    private final LogTrace trace;

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = trace.begin(message);

        T result = null;

        try {
            result = callback.call();
        } catch (Exception e) {
            trace.exception(status, e);
        }

        trace.end(status);

        return result;
    }

}
