package hello.advanced.trace;

import lombok.Getter;

import java.util.UUID;

/**
 * @since       2023.01.17
 * @author      seunglo
 * @description trace id
 **********************************************************************************************************************/
@Getter
public class TraceId {

    private String id;

    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8);
    }

    public TraceId nextLevelId() {
        return new TraceId(id, level + 1);
    }

    public TraceId previousLevelId() {
        if (isFirstLevel()) {
            throw new IllegalStateException("가장 첫번째 레벨입니다.");
        }

        return new TraceId(id, level + 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }
}