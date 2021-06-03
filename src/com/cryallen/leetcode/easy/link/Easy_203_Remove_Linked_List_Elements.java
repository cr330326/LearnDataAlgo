package com.cryallen.leetcode.easy.link;

/***
 * 203. 移除链表元素
 * @author Allen
 * @DATE 2020-05-29
 ***/
public class Easy_203_Remove_Linked_List_Elements {

    /**
     * 203. 移除链表元素
     * <p>
     * 地址：https://leetcode-cn.com/problems/remove-linked-list-elements/
     * </p>
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *
     * 示例：
     *
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     *
     * */
    public static void main(String[] args) {
        ListNode FirstNode1 = createNode(1);
        ListNode FirstNode2 = createNode(2);
        ListNode FirstNode3 = createNode(6);
        ListNode FirstNode4 = createNode(3);
        ListNode FirstNode5 = createNode(4);
        ListNode FirstNode6 = createNode(5);
        ListNode FirstNode7 = createNode(6);
        FirstNode1.next = FirstNode2;
        FirstNode2.next = FirstNode3;
        FirstNode3.next = FirstNode4;
        FirstNode4.next = FirstNode5;
        FirstNode5.next = FirstNode6;
        FirstNode6.next = FirstNode7;

        System.out.println("#####FirstNode顺序#####");
        printAll(FirstNode1);

        ListNode removeResult = removeElements(FirstNode1,6);
        System.out.println("#####RemoveElement#####");
        printAll(removeResult);
    }

    /**
     * 不添加虚拟节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        // 处理删除头结点，单独对头结点进行处理
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 已经为null，提前退出
        if (head == null) {
            return head;
        }

        // 已确定当前head.val != val 指向当前头节点 带哨兵节点方式实现
        ListNode pre = head;
        // 指向下一个节点
        ListNode curr = head.next;
        // 每次循环，判断下当前指针是否还要下一个指向
        while (curr != null) {
            if(curr.val == val){
                pre.next = curr.next;
            }else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
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
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
   }
}
