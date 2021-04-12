package leetcode.link;

public class MergeKLists {


    private ListNode header;
    private ListNode tail;

    public ListNode mergeKLists(ListNode[] lists) {
        while (lists != null && lists.length > 0) {
            ListNode result = new ListNode(getMin(lists));
            if (header == null || tail == null) {
                if (result.val != Integer.MAX_VALUE) {
                    header = tail = result;
                }
            } else {
                if (result.val != Integer.MAX_VALUE) {
                    tail.next = result;
                    tail = result;
                }
            }
            if (result.val == Integer.MAX_VALUE)
                break;
        }
        return header;
    }

    public int getMin(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int rtnVal = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            int tmin = min;
            int nodeval = lists[i].val;
            min = Math.min(min, nodeval);
            if (min != tmin)
                index = i;
        }
        if (lists[index] == null) {
            rtnVal = Integer.MAX_VALUE;
        } else {
            rtnVal = min;
            lists[index] = lists[index].next;
        }
        return rtnVal;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
