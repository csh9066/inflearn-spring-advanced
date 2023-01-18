package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;

/**
 * @since       2023.01.17
 * @author      seunglo
 * @description log trace
 **********************************************************************************************************************/
public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}