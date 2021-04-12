package leetcode.link.node;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("、" + val);
        ListNode node = this;
        ListNode tempNode = node.next;
        while (tempNode != null) {
            sb.append("、" + tempNode.val);
            tempNode = tempNode.next;
        }
        return sb.substring(1);
    }
}
