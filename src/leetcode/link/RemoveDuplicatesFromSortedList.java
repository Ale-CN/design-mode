package leetcode.link;

import leetcode.link.node.ListNode;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode list6 = new ListNode(3);
        ListNode list5 = new ListNode(3, list6);
        ListNode list4 = new ListNode(3, list5);
        ListNode list3 = new ListNode(2, list4);
        ListNode list11 = new ListNode(2, list3);
        ListNode list2 = new ListNode(2, list11);
        ListNode root = new ListNode(1, list2);

        System.out.println("before "+root.toString());

        removeDuplicates(root);

        System.out.println("after  "+root.toString());
    }

    private static ListNode removeDuplicates(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        // eg: 1、2、2、2、3、3、4
        ListNode root = listNode;
        ListNode temp = listNode.next;

        while (temp != null) {
            if (root.val == temp.val) { // 剔除当前重复节点
                root.next = temp.next;
            }else { // 继续比较下一节点
                root = root.next;
            }
            temp = temp.next;
        }

        return listNode;
    }
}
