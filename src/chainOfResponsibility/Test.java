package chainOfResponsibility;

/**
 * 概念
 * 责任链，顾名思义，就是用来处理相关事务责任的一条执行链，执行链上有多个节点，
 * 每个节点都有机会（条件匹配）处理请求事务，如果某个节点处理完了就可以根据实际业务需求传递给下一个节点继续处理或者返回处理完毕。
 * <p>
 * 场景
 * 现实中，请假的OA申请，请假天数
 * day < 1 ，只需组长批准即可；
 * 1< day <3，需要部门经理批准；
 * 3< day <30，需要CEO批准；
 * 大于30天，正常不会批准。
 * <p>
 * 链接：https://www.jianshu.com/p/9f7d9775bdda
 * 来源：简书
 */
public class Test {
    public static void main(String[] args) {

        AbstractHandler ceoHandler = new CEOHandler();
        AbstractHandler mgrHandler = new ManagermentHandler(ceoHandler);
        AbstractHandler leaderHandler = new GroupLeaderHandler(mgrHandler);
        int i = 0;
        while (i < 20) {
            i++;
            System.out.println("=====================================");
            System.out.println(leaderHandler.handler(1));
            System.out.println(leaderHandler.handler(3));
            System.out.println(leaderHandler.handler(5));
        }
    }
}
