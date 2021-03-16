package 栈相关的题;

public class MinStack {
    /** initialize your data structure here. */

    Node head;
    public MinStack() {

    }

    public void push(int x) {
        if(head==null){
            head = new Node(x,x,null);
        }else{
            head = new Node(x,Math.min(x,head.min),head);   //把每次的最小值都保存至head头节点中，再利用头插法进行妙动态规划
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    class Node{
        int val;
        int min;
        Node next;
        public Node(int val,int min,Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}