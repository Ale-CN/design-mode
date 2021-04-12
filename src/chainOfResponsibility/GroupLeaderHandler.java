package chainOfResponsibility;

import java.util.Random;

public class GroupLeaderHandler extends AbstractHandler {

    public GroupLeaderHandler() {
    }

    public GroupLeaderHandler(AbstractHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handler(int day) {
        if (day <= 0) {
            throw new IllegalArgumentException("day must bigger than zero!!!");
        }
        if (day >= MAX) {
            delResult = "组长审批不通过,";
            return delResult;
        }
        String delResult = null;
        // 模拟审批通过 or 拒绝
        if (new Random().nextInt(2) > 0.5) {
            delResult = "组长审批通过,";
        } else {
            delResult = "组长审批不通过,";
            return delResult;
        }
        if (day <= MIN) {
            return delResult;
        } else {
            if (getNextHandler() != null) {
                delResult += getNextHandler().handler(day);
            }
        }
        return delResult;
    }
}
