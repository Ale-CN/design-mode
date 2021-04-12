package chainOfResponsibility;

public abstract class AbstractHandler {
    /**组长审批假天数*/
    protected static final int MIN = 1;
    /**部门经理审批假天数*/
    protected static final int MIDDLE = 3;
    /**CEO审批假天数*/
    protected static final int MAX = 30;
    /**审批人姓名*/
    protected String handlerName = "";
    /**审批结果信息*/
    protected String delResult = "";

    /**下一个审批者*/
    private AbstractHandler nextHandler;

    public AbstractHandler(){}

    public AbstractHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**处理请假的请求，子类实现*/
    public abstract String handler(int day);
}
