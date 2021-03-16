package 二叉搜索树.对外提供接口化;


public class 节点接口化 {
    public static String name="kiwi";

    public static void text (Visitor visitor){
        visitor.visit(name);
    }
    public interface Visitor{
        void visit(String name);
    }

    public static void main(String[] args) {
        节点接口化.text(new Visitor() {
            @Override
            public void visit(String name) {           //把需要比较或者处理的对象name传给外界，供外界使用,只能看，无法修改
                System.out.println(name.toString()+"接口化了。。。");
            }
        });
    }

}
