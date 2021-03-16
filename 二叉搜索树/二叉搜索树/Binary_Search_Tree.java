package 二叉搜索树.二叉搜索树;

import java.util.LinkedList;
import java.util.Queue;

interface Comparable{
    int comparable();
}

public class Binary_Search_Tree{

    //52	12	89	28	84	99	16	47	68	29
    public static void main(String[] args) {
        Binary_Search_Tree binary_search_tree = new Binary_Search_Tree();


        int[] arr={52,12,89,28,99,47,84,29,68,16};
        for (int i = 0; i < arr.length; i++) {
            Node nodes = new Node(arr[i]);
            binary_search_tree.add(nodes);
        }

        Node byr = binary_search_tree.find_Byr(binary_search_tree.root, 99);
        System.out.println("=--------->"+byr.element);

        Node preNode = binary_search_tree.find_PreNode(99);
        System.out.println("前序节点为："+preNode+"=------->root节点为"+binary_search_tree.root);
        binary_search_tree.Middle_list(binary_search_tree.root);
        System.out.println("\n上面的是中序遍历");

        binary_search_tree.Level_OrderTraversal(new Visitor() {
            @Override
            public void visit(Node node) {
                System.out.print(node.element+"\t");
            }
        });
    }






    private Node root;
    private int size;
    private Visitor visitor;
    public boolean isEmpty(){
        return size==0;
    }



    public void Middle_list(Node node){
        if(node.left!=null){
            Middle_list(node.left);
        }
        System.out.print(node.element+"\t");
        if(node.right!=null){
            Middle_list(node.right);
        }
    }



    //针对中序遍历的结构
    public Node find_PreNode(int element){
        Node node=find_Byr(root,element);
        if(node.left!=null){
            Node temp=node.left;
            while (temp.right!=null){
                temp=temp.right;
            }
            return temp;
        }
        else if(node.parent!=null){
            while (node.parent.right!=node){
                node=node.parent;
            }
            return node.parent;
        }
        return null;              //root
    }



    //递归查找节点Node，通过element  【递归核心：=-----> 明确递归的方法的作用，充分利用其函数作用做事情】
    private Node find_Byr(Node node, int element){
        if(node==null)return null;
        if(node.element==element)return node;

        return node.element>element?find_Byr(node.left,element):find_Byr(node.right,element);
    }






    public void list(Node root){
        if(root==null){return;}
        list(root.left);
        System.out.println(root);
        list(root.right);
    }

    //内部实现前序遍历
    private void preorder(Node node, Visitor visitor){
        if(node==null){return;}
        visitor.visit(node);
        preorder(node.left,visitor);
        preorder(node.right,visitor);

    }
    //对外提供方法（从root开始遍历）
    public void preorder(Visitor visitor){
        preorder(root,visitor);
    }



    //层级遍历
    private void Level_OrderTraversal(Node node, Visitor visitor){
        if(node==null){return;}
        Queue<Node> list=new LinkedList<Node>();
        list.offer(node);
        while (!list.isEmpty()){
            Node poll = list.poll();
            visitor.visit(poll);                   //对poll出来的元素进行处理，可以外界提供接口给外界,让外界实现该接口即可
            if(poll.left!=null){
                list.offer(poll.left);
            }

            if(poll.right!=null){
                list.offer(poll.right);
            }
        }
    }


    public void Level_OrderTraversal(Visitor visitor){
        this.visitor=visitor;
        Level_OrderTraversal(root,visitor);
    }



    //找合适的位置进行添加即可
    public void add(Node node){
        if(root==null){
            root=node;
            size++;
            return;
        }
        Node parentNode=root;     //保存父节点
        Node temp=root;
        while (temp!=null){
            parentNode=temp;
            if(node.element>temp.element){
                temp=temp.right;
            }
            else if(node.element<temp.element){
                temp=temp.left;
            }
            else return;         //等于直接不做处理
        }
        if(node.element<parentNode.element){
            parentNode.left=node;
        }
        else parentNode.right=node;
        size++;
    }

    //类内部创建一个接口，对外公开，让外界访问实现，来达到对类中方法中对数据的处理由外界来设置！！
    public interface Visitor{
        void visit(Node node);
    }


    //根据树的某一个方向（类似链表）进行不断查找！找到返回，没有找到则返回null
    private Node find_Inner(int element){
        Node temp=root;
        while (temp!=null){
            if(temp.element==element){return temp;}
            if(temp.element>element){
                temp=temp.left;
            }
            else {
                temp=temp.right;
            }
        }
        return null;
    }

    public void remove(int element){
        Node item = find_Inner(element);
        if(item==null)return;
        if(item.has_twoChild()){
            Node temp = item.left;
            while (temp.right!=null){      //找前驱节点
                temp=temp.right;
            }
            item.element=temp.element;
            item = temp;   //后面代码就是删除item节点即可
        }
        //删除item节点 （item节点的度必然是 1 或者 0 ） , { replacement:可能为空 }
        Node replacement = item.left!=null ? item.left :item.right;
        if(replacement!=null){        //item为度为一的节点
            replacement.parent=item.parent;
            if(item.parent==null){
                root = replacement;
            }
            else if(item.isRight_child()){
                item.parent.right=replacement;
            }
            else if(item.isLift_child()){
                item.parent.left=replacement;
            }
        }else if(item.parent == null){
            root=null;
        }
        else {
            if(item.isLift_child()){
                item.parent.left=null;
            }else {
                item.parent.right=null;
            }
        }

    }




}

//节点类
class Node {
    public Node left;
    public Node right;
    //增加一个父节点用来记录
    public Node parent;
    public int element;

    public Node(int element){
        this.element=element;
    }

    public boolean has_twoChild(){
        return this.left!=null&&this.right!=null;
    }
    public boolean isLeaf(){
        return this.left==null && this.right==null;
    }
    public boolean has_oneChild(){
        return (!has_twoChild() && this.left!=null || this.right!=null);
    }

    public boolean isLift_child(){
        return this.parent!=null && this.parent.left==this;
    }

    public boolean isRight_child(){
        return this.parent!=null && this.parent.right==this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                '}';
    }
}
