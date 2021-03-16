package 二叉搜索树.二叉搜索树;

import java.util.LinkedList;
import java.util.Queue;

public class test {
    private Node root;
    private int size;
    private Visitor visitor;
    public static void main(String[] args) {
        test test = new test();
        for (int i = 0; i < 10; i++) {
            test.add_Node(new Node((int) (Math.random()*100)));
        }

        int height = test.height();
        System.out.println("height="+height);
        test.Level_list(new Visitor() {
            @Override
            public void visit(Node node) {
                System.out.print(node.element+"\t");
            }
        });
    }


    public interface Visitor{
        void visit(Node node);
    }

    public void Level_list(Visitor visitor){
        if(visitor==null){return;}
        this.visitor=visitor;
        Level_list();
    }


    public int height(){
        if(root==null){return 0;}
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        int count=1;
        int height=0;
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            count--;
            if(poll.left!=null){
                queue.offer(poll.left);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
            }
            if(count==0){        //符合条件表示即将要访问下一层
                count=queue.size();     //每次当count==0时更新一下
                height++;
            }
        }
        return height;
    }

    private void Level_list(){
        if(root==null)return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            visitor.visit(poll);
            if(poll.left!=null){
                queue.offer(poll.left);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
            }
        }
    }


    public void add_test(Node node){
        if(root==null){
            root=node;
            return;
        }
        Node temp=root;
        Node parent=root;
        while (temp!=null){
            parent=temp;
            if(temp.element>node.element){
                temp=temp.left;
            }
            if(temp.element<node.element){
                temp=temp.right;
            }
            else return;
        }

    }

    public void add_Node(Node node){
        if(root==null){
            root=node;
            size++;
            return;
        }
        Node temp=root;
        Node parent=root;
        while (temp!=null){
            parent=temp;
            if(node.element>temp.element){   //和单链表不同之处需要规定如何判断插入在左右节点的那个节点
                temp=temp.right;
            }
            else if(node.element<temp.element){
                temp=temp.left;
            }
            else return;
        }
        if(parent.element>node.element){
            parent.left=node;
        }else parent.right=node;
        size++;
    }
}

