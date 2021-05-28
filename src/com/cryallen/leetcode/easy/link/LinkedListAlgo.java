package com.cryallen.leetcode.easy.link;

public class LinkedListAlgo {

    public static void main(String[] args) {
        Node node1 = createNode(1);
        Node node2 = new Node(2,node1);
        Node node3 = new Node(3,node2);
        Node node4 = new Node(4,node3);
        Node node5 = new Node(5,node4);

        System.out.println("#####单链表未反转前顺序#####");
        printAll(node5);

        Node node6 = reverse(node5);
        System.out.println("#####单链表反转后顺序#####");
        printAll(node6);
    }

    // 单链表反转
    public static Node reverse(Node list) {
        Node curr = list, pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 单链表反转
    public static Node reverseTest(Node list) {
        Node curr = list;
        Node pre = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
