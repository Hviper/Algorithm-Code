package 链表题;

import java.util.ArrayList;
import java.util.HashMap;

public class _83_删除排序链表中的重复元素 {

    public static void main(String[] args) {
        final ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        
    }

    public ListNode deleteDuplicates(ListNode head) {

        HashMap<ListNode,Integer> hashmap = new HashMap<>();
        //虚拟头节点       【凡是用到过虚拟头节点一般都需要将最后一个元素的指向清空，特别是需要在一个原链表中挑选符合要求的节点嫁接到new_head的末尾的情况】
        ListNode new_head = new ListNode(0);
        ListNode temp = new_head;
        while(head!=null){
            if(!hashmap.containsKey(head)){
                hashmap.put(head,1);
                temp.next = head;
                temp = head;
            }
            head = head.next;
        }
        //最终需要将冗余节点清空，保证new_head的最后一个节点的指向为null
        temp.next = null;
        return new_head.next;
    }
}
