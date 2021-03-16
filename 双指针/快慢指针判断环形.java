package 双指针;


/**
 * 方法一：哈希表
 * 思路及算法
 *      最容易想到的方法是遍历所有节点，每次遍历到一个节点时，判断该节点此前是否被访问过。
 *      具体地，我们可以使用哈希表来存储所有已经访问过的节点。每次我们到达一个节点，如果该节点已经存在于哈希表中，则说明该链表是环形链表，
 *      否则就将该节点加入哈希表中。重复这一过程，直到我们遍历完整个链表即可。
 *方法二：快慢指针法
 */
public class 快慢指针判断环形 {
    public static void main(String[] args) {

    }
    public boolean isCircle(Node root){
        if(root == null)return false;
        Node slow = root;
        Node fast = root;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;       //先走再判断吧！！
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
class Node{
    Node next;
    int value;
    public Node(Node next,int value){
        this.next = next;
        this.value = value;
    }
}
