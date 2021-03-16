package 二叉搜索树.测试;
import java.util.LinkedList;
import java.util.Queue;

public class test {

    private new_Node root;


    public static void main(String[] args) {
        test test = new test();
        int[] arr={52,12,89,28,99,47,84,29,68,16};
        for (int i = 0; i < arr.length; i++) {
            test.add(new new_Node(arr[i]));
        }

        test.list();
        System.out.println();
        test.Middle_list(test.root);


        new_Node r = test.find_R(28);
        System.out.println("找到的元素为："+r.date);

    }

    public void Middle_list(new_Node node){
        if(node==null)return;
        Middle_list(node.left);
        System.out.print(node.date+"\t");
        Middle_list(node.right);
    }

    //递归找到对应元素的接口的实现
    private new_Node find_R(new_Node node,int target){
        if(node==null)return null;
        if(node.date==target)return node;
        return node.date>target?find_R(node.left,target):find_R(node.right,target);
    }
    public new_Node find_R(int target){
        return find_R(root,target);
    }






    //争对中序遍历而言（根据元素找该节点的前驱节点）,
    // 对于中序遍历而言，找一个元素的前序节点，在该节点的left不为Null情况下一定是在left中寻找，
    // left为Null，找该元素的前序节点可以逆向思维，找一个元素（该节点的前序）的后继节点，即在右节点找后继
    public new_Node find_preNode(int element){
        new_Node node=findBy_element(element);
        if(node==null)return null;
        new_Node temp=node;
        if(temp.left!=null){
            temp=temp.left;
            while (temp.right!=null){
                temp=temp.right;
            }
            return temp;
        }
        //temp.parent.right!=temp 和 temp==temp.parent.left 异曲同工
        while (temp.parent!=null && temp==temp.parent.left){
            //从上面while循环中可以断定：退出循环的原因有两种：1.temp的parent为null，或者找到了 temp == temp.parent.right
            temp=temp.parent;
        }
        return temp.parent;     //假如temp.parent为空（root节点）也是这样返回，返回为空，因为temp.parent==null

    }

    public boolean remove(int element){
        new_Node currentNode=findBy_element(element);         //返回需要删除的该元素的当前节点
        assert currentNode != null;
        if(currentNode.hasTwoChild()){
            new_Node preNode = find_preNode(element);         //找前驱节点
            currentNode.date=preNode.date;           //前驱节点取代当前需要删除的节点
            currentNode=preNode;            //都要删除当前节点
        }

        //能来到这里说明需要删除的节点都为一个度或者0个度
        if(currentNode.isLeaf() && currentNode.parent.left==currentNode){
            currentNode.parent.left=null;
            return true;
        }
        else if(currentNode.isLeaf() && currentNode.parent.right==currentNode){
            currentNode.parent.right=null;
            return true;
        }
        if(!currentNode.isLeaf() && currentNode.parent.left==currentNode){
            currentNode.parent.left=currentNode.left==null?currentNode.right:currentNode.left;
            return true;
        }
        else if(!currentNode.isLeaf() && currentNode.parent.right==currentNode){
            currentNode.parent.left=currentNode.right==null?currentNode.left:currentNode.right;
            return true;
        }
        return false;
    }

    //想链表一样查找
    private new_Node findBy_element(int element){
        new_Node temp=root;
        while (temp!=null){
            if(temp.date==element)return temp;
            if(temp.date>element){
                temp=temp.left;
            }
            else {
                temp=temp.right;
            }
        }
        return null;    //找到最后发现temp为空退出，说明不存在返回null
    }


    public boolean isComplete_Tree(){
        if(root==null)return false;
        Queue<new_Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag=false;
        while (!queue.isEmpty()){
            new_Node poll = queue.poll();
            if(flag && !poll.isLeaf()){
                return false;
            }
            if(poll.left!=null){
                queue.offer(poll.left);
            }else {
                if(poll.right != null)return false;
            }
            if(poll.right!=null){
                queue.offer(poll.right);
            }else {
                flag=true;
            }
        }
        return true;
    }











    //判断是否为一个完全二叉树，用层序遍历法！
    public boolean isCompleteTree(){
        if(root==null)return false;
        Queue<new_Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag=false;
        while(!queue.isEmpty()){
            new_Node poll = queue.poll();

            //标志位：专门为flag=true的代码准备的执行代码！！！
            if(flag && !poll.isLeaf()){
                return false;
            }
            if(poll.left!=null){
                queue.offer(poll.left);
            }else {            //能来到else说明前面的if中条件不符合，即poll.left==null
                if(poll.right!=null){
                    return false;
                }
            }
            //经过上面的判断有两种情况：一：left不为空，二：left为空但是right为空
            if(poll.right!=null){
                queue.offer(poll.right);
            }else {           //能来到else说明前面的if中条件不符合，即poll.right==null.即需要判断poll.left
                flag=true;            //针对只有一个left的情况，对poll.left这个节点判断，需要该节点为叶子节点
            }
        }
        return true;
    }

    public void list(){
        if(root==null)return;
        Queue<new_Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            new_Node poll = queue.poll();
            System.out.print(poll.date+"\t");
            if(poll.left!=null){
                queue.offer(poll.left);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
            }
        }
    }

    public int get_height(){
        if(root==null)return 0;
        Queue<new_Node> queue = new LinkedList<>();
        queue.offer(root);
        int temp=1;      //根节点出发，所以为int temp = 1
        int height=0;
        while (!queue.isEmpty()){
            new_Node poll = queue.poll();
            temp--;
            if(poll.left!=null){
                queue.offer(poll.left);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
            }
            if(temp==0){
                temp=queue.size();
                height++;
            }
        }
        return height;
    }

    //递归求高度
    public int height(new_Node node){
        if(node==null)return 0;
        return 1+Math.max(height(node.left),height(node.right));
    }


    //找合适的位置进行插入
    public void add(new_Node node){
        if(root==null){
            root=node;
            node.parent=null;
            return;
        }
        new_Node temp=root;
        new_Node parent=root;
        while (temp!=null){
            parent=temp;
            if(temp.date>node.date){
                temp=temp.left;
            }
            //只能选择一个，类似单链表
            else if(temp.date<node.date){
                temp=temp.right;
            }
            else return;
        }
        if(parent.date>node.date){
            parent.left=node;
            node.parent=parent;
            return;
        }
        parent.right=node;
        node.parent=parent;
    }

    static class new_Node{
        public new_Node parent;
        public new_Node left;
        public new_Node right;
        public int date;
        public new_Node(int date){
            this.date=date;
        }

        public boolean isLeaf(){
            return (this.left==null && this.right==null);
        }
        public boolean hasTwoChild(){
            return (this.left!=null && this.right!=null);
        }
    }
}
