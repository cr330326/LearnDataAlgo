package com.cryallen.leetcode.easy.link;

import java.util.HashSet;
import java.util.Set;

/***
 * 141. 环形链表
 * @author Allen
 * @DATE 2021-05-11
 ***/
public class Easy_141_Linked_list_cycle {

    /**
     * 141. 环形链表
     * <p>
     * 地址：https://leetcode-cn.com/problems/linked-list-cycle/
     * </p>
     *
     * 给定一个链表，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     * 示例1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 示例2：
     *
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     * 示例3：
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     *
     * 标签：链表
     *
     * */
    public static void main(String[] args) {
        ListNode FirstNode1 = createNode(3);
        ListNode FirstNode2 = createNode(2);
        ListNode FirstNode3 = createNode(0);
        ListNode FirstNode4 = createNode(-4);
        FirstNode1.next = FirstNode2;
        FirstNode2.next = FirstNode3;
        FirstNode3.next = FirstNode4;
        FirstNode4.next = FirstNode1;

        boolean isCycle = hasCycle(FirstNode1);
        System.out.println("isCycle : " + isCycle);
    }

    /***
     * 链表环检测
     * 最容易想到的方法是遍历所有节点，每次遍历到一个节点时，判断该节点此前是否被访问过
     * 具体地，我们可以使用哈希表来存储所有已经访问过的节点。每次我们到达一个节点，如果该节点已经存在于哈希表中，则说明该链表是环形链表，否则就将该节点加入哈希表中。重复这一过程，直到我们遍历完整个链表即可。
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        //当前指针节点
        Set<ListNode> seen = new HashSet<>();
        //循环列表
        while (head != null) {
            if(!seen.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
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
