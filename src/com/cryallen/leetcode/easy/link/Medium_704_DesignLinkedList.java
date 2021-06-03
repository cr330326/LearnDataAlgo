package com.cryallen.leetcode.easy.link;

/***
 * 707. 设计链表
 * @author Allen
 * @DATE 2020-06-02
 ***/
public class Medium_704_DesignLinkedList {

    /**
     * 707. 设计链表
     * <p>
     * 地址：https://leetcode-cn.com/problems/design-linked-list/
     * </p>
     设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

     在链表类中实现这些功能：

     get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

     示例：
     MyLinkedList linkedList = new MyLinkedList();
     linkedList.addAtHead(1);
     linkedList.addAtTail(3);
     linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
     linkedList.get(1);            //返回2
     linkedList.deleteAtIndex(1);  //现在链表是1-> 3
     linkedList.get(1);            //返回3

     所有val值都在 [1, 1000] 之内。
     操作次数将在  [1, 1000] 之内。
     请不要使用内置的 LinkedList 库。
     *
     * 思路：
     **链表操作的两种方式：**

     1. 直接使用原来的链表来进行操作。
     2. 设置一个虚拟头结点在进行操作。
     *
     * 标签：链表
     *
     * */
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        int param_1 = obj.get(0);
        obj.addAtHead(1);
        obj.addAtTail(2);
        obj.addAtIndex(1,3);
        obj.deleteAtIndex(1);

        System.out.println("#####FirstNode顺序#####");
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

    public static class MyLinkedList {

        //size存储链表元素的个数
        int size;
        //虚拟头结点
        ListNode head;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        //获取第index个节点的数值
        public int get(int index) {
            //如果index非法，返回-1
            if(index < 0 || index >= size){
                return -1;
            }
            ListNode curr = head;
            //包含一个虚拟头节点，所以查找第 index+1 个节点
            for (int i = 0; i <= index; i++){
                curr = curr.next;
            }
            return curr.val;
        }

        //在链表最前面插入一个节点
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        //在链表的最后插入一个节点
        public void addAtTail(int val) {
            //在链表的最后插入一个节点
            addAtIndex(size, val);
        }

        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        // 如果 index 大于链表的长度，则返回空
        public void addAtIndex(int index, int val) {
            if(index > size){
                return;
            }
            if(index < 0){
                index = 0;
            }
            size ++;
            //找到要插入节点的前驱
            ListNode pred = head;
            for (int i = 0; i < index; i++){
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        //删除第index个节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
    }
}
