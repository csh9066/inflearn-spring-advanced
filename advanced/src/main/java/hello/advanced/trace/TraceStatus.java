package hello.advanced.trace;

import lombok.Getter;

/**
 * @since       2023.01.17
 * @author      seunglo
 * @description trace status
 **********************************************************************************************************************/
@Getter
public class TraceStatus {

    private TraceId traceId;

    private Long startTimeMs;

    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }
}