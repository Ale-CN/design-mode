package chainOfResponsibility;

import java.util.Random;

public class CEOHandler extends AbstractHandler {
    public CEOHandler(){}
    public CEOHandler(AbstractHandler nextHandler) {
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
            delResult = "CEO审批通过,";
        } else {
            delResult = "CEO审批不通过,";
            return delResult;
        }
        if (MIDDLE < day && day < MAX) {
            return delResult;
        } else {
            if (getNextHandler() != null) {
                delResult += getNextHandler().handler(day);
            }
        }
        return delResult;
    }
}
