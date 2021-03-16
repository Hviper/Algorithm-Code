package 链表题;

public class _234_回文链表 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        ListNode mid_Node = find_midNode(head);
        //这里是让中心节点的（下一个）节点翻转
        ListNode new_Node=reverse(mid_Node.next);
        while(new_Node!=null){           //直至翻转后的节点全部走完为止【因为右边的节点元素小于等于左边元素，左边元素=左边回文+中间节点】
            if(new_Node.val!=head.val){
                return false;
            }
            new_Node = new_Node.next;
            head = head.next;
        }
        return true;
    }
    //快慢指针法找中心节点  【中心节点的定义：右半部分链表头节点的前一个节点】
    public ListNode find_midNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        //快指针没有走完就不能结束，【可以手动画，当节点有奇数个的时候和节点有偶数个的情况】
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //头插法翻转链表     【必须快速默写出来】
    public ListNode reverse(ListNode node){
        ListNode head = null;         //设置需要返回的头节点设置为全局变量方便返回
        while(node!=null){
            ListNode temp = node.next;
            node.next = head;
            head = node;
            node = temp;
        }
        return head;
    }
}
