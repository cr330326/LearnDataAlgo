package com.cryallen.leetcode.easy.link;

/***
 * 合并两个有序链表
 * @author Allen
 * @DATE 2020-05-19
 ***/
public class Easy_21_MergeTwoSortedLists {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 思路：
     *  我们可以用迭代的方法来实现上述算法。当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
     *
     * 复杂度分析:
     * 时间复杂度：O(n + m) ，其中 n 和 m 分别为两个链表的长度。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)。
     *
     * 空间复杂度：O(1) 。我们只需要常数的空间存放若干变量。
     * 标签：链表
     *
     * */
    public static void main(String[] args) {
        ListNode FirstNode1 = createNode(1);
        ListNode FirstNode2 = createNode(2);
        ListNode FirstNode3 = createNode(4);

        FirstNode1.next = FirstNode2;
        FirstNode2.next = FirstNode3;
        FirstNode3.next = null;

        System.out.println("#####FirstNode顺序#####");
        printAll(FirstNode1);

        ListNode secondNode1 = createNode(1);
        ListNode secondNode2 = createNode(3);
        ListNode secondNode3 = createNode(5);
        secondNode1.next = secondNode2;
        secondNode2.next = secondNode3;
        secondNode3.next = null;

        System.out.println("#####SecondNode顺序#####");
        printAll(secondNode1);

        ListNode mergeNode = mergeTwoLists(FirstNode1,secondNode1);
        System.out.println("#####MergeNode#####");
        printAll(mergeNode);
    }

    // 合并两个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = createNode(-1);
        //设置一个默认指向当前指针
        ListNode preV = preHead;

        //每次循环，当前节点后移
        while (l1 != null && l2 != null) {
            if(l1.val > l2.val){
                preV.next = l2;
                l2 = l2.next;
            }else{
                preV.next = l1;
                l1 = l1.next;
            }
            //当前指针后移
            preV = preV.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        preV.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static ListNode createNode(int value) {
        return new ListNode(value);
    }

    public static void printAll(ListNode list) {
        ListNode p = list;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
   }
}
