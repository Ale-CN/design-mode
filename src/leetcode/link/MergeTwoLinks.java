package leetcode.link;

public class MergeTwoLinks {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        Node n2 = new Node(1);
        n2.next = new Node(1);
        n2.next.next = new Node(5);

        Node result = merge2(n1, n2);

        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
    }

    static Node merge(Node n1, Node n2) {
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;
        Node dummyHead = new Node(-1); // 虚拟头，引用一直指向Node(-1)
        Node cur = dummyHead; // 当前节点位置，用来拼接新链表
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        // 合并后 n1 和 n2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        cur.next = n1 == null ? n2 : n1;

        return dummyHead.next;
    }

    /**
     * 递归方式
     *
     * @param n1
     * @param n2
     * @return
     */
    static Node merge2(Node n1, Node n2) {
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;
            // 1 2 3
            // 1 1 5
        if (n1.val < n2.val) {
            n1.next = merge2(n1.next, n2);
            return n1;
        } else {
            n2.next = merge2(n1, n2.next);
            return n2;
        }

    }

    static class Node {
        int val;
        Node next;

        public Node(int v) {
            this.val = v;
            next = null;
        }
    }
}
