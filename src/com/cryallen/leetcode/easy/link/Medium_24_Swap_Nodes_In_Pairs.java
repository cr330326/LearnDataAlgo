package com.cryallen.leetcode.easy.link;

import java.util.List;

/***
 * 24. 两两交换链表中的节点
 * @author Allen
 * @DATE 2020-06-03
 ***/
public class Medium_24_Swap_Nodes_In_Pairs {

    /**
     * 24. 两两交换链表中的节点
     * <p>
     * 地址：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     * </p>
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例：
     *
     输入：head = [1,2,3,4]
     输出：[2,1,4,3]

     输入：head = [1]
     输出：[1]
     *
     * 思路：
     *！
     *
     * 提示：
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
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

        ListNode swapPairs1 = swapPairs1(FirstNode1);
        System.out.println("#####SwapPairs1#####");
        printAll(swapPairs1);

        ListNode swapPair2 = swapPairs2(FirstNode1);
        System.out.println("#####SwapPairs2#####");
        printAll(swapPair2);
    }

    // 链表交换，用递归的方式
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {  //递归的终止条件，当没有节点或当下只有一个节点，则不需要两两交换
            return head;
        }
        ListNode newHead = head.next;  //原始节点链表的第二个节点为新的头节点
        //新的头结点之后，原始链表的第二个节点，则原始链表中的其余节点的头节点是 newHead.next
        //令 head.next = swapPairs(newHead.next)，表示将其余节点进行两两交换，交换后的新的头节点为 head 的下一个节点
        head.next = swapPairs1(newHead.next);
        //然后令 newHead.next = head，即完成了所有节点的交换,
        newHead.next = head;
        //最后返回新的节点
        return newHead;
    }

    // 链表交换，迭代法，
    /*
    * 创建哑结点 dummyHead，令 dummyHead.next = head。令 temp 表示当前到达的节点，初始时 temp = dummyHead。每次需要交换 temp 后面的两个节点。

    如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。

    具体而言，交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，因此需要进行如下操作。

    temp.next = node2
    node1.next = node2.next
    node2.next = node1
    完成上述操作之后，节点关系即变成 temp -> node2 -> node1。再令 temp = node1，对链表中的其余节点进行两两交换，直到全部节点都被两两交换。

    两两交换链表中的节点之后，新的链表的头节点是 dummyHead.next，返回新的链表的头节点即可。
    *
    * */
    public static ListNode swapPairs2(ListNode head) {
        ListNode dummyHead= new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null){
            ListNode node1 = curr.next;
            ListNode node2 = curr.next.next;
            curr.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            curr = node1;
        }
        return dummyHead.next;
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
      ListNode(int x) {
          val = x;
      }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
   }
}
