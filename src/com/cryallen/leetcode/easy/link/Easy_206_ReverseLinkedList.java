package com.cryallen.leetcode.easy.link;

/***
 * 单链表反转
 * @author Allen
 * @DATE 2020-05-19
 ***/
public class Easy_206_ReverseLinkedList {

    /**
     * 反转一个单链表。
     *
     * 示例：
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * 思路：
     * 在遍历列表时，将当前节点的 \textit{next}next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
     *
     * 复杂度分析:
     * 时间复杂度：O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)。
     *
     * 标签：链表
     *
     * */
    public static void main(String[] args) {
        ListNode FirstNode1 = createNode(1);
        ListNode FirstNode2 = createNode(2);
        ListNode FirstNode3 = createNode(3);
        ListNode FirstNode4 = createNode(4);
        ListNode FirstNode5 = createNode(5);
        FirstNode1.next = FirstNode2;
        FirstNode2.next = FirstNode3;
        FirstNode3.next = FirstNode4;
        FirstNode4.next = FirstNode5;
        FirstNode5.next = null;

        System.out.println("#####FirstNode顺序#####");
        printAll(FirstNode1);

        ListNode reverseNode = reverse(FirstNode1);
        System.out.println("#####ReverseNode#####");
        printAll(reverseNode);
    }

    // 单链表反转
    public static ListNode reverse(ListNode list) {
        //当前指针节点
        ListNode curr = list;
        //前指针节点
        ListNode pre = null;
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            //临时节点，暂存当前节点的下一节点，用于后移
            ListNode next = curr.next;
            //将当前节点指向它前面的节点
            curr.next = pre;
            //前指针后移
            pre = curr;
            //当前指针后移
            curr = next;
        }
        return pre;
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
      ListNode(int x) {
          val = x;
      }
   }
}
