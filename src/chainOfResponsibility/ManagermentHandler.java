package chainOfResponsibility;

import java.util.Random;

public class ManagermentHandler extends AbstractHandler {
    public ManagermentHandler() {
    }

    public ManagermentHandler(AbstractHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handler(int day) {
        if (day <= 0) {
            throw new IllegalArgumentException("day must bigger than zero!!!");
        }
        String delResult = null;
        // 模拟审批通过 or 拒绝
        if (new Random().nextInt(2) > 0.5) {
            delResult = "部门经理审批通过,";
        } else {
            delResult = "部门经理审批不通过,";
            return delResult;
        }
        if (MIN < day && day <= MIDDLE) {
            return delResult;
        } else {
            if (getNextHandler() != null) {
                delResult += getNextHandler().handler(day);
            }
        }
        return delResult;
    }
}
