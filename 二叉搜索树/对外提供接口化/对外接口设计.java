package 二叉搜索树.对外提供接口化;

public class 对外接口设计 {
    private String name="对外接口设计";
    private Dog dog;

    public void Visit(Dog dog){
        dog.change();
    }

    class Dog{
        public void change(){
            name="kiwi";
        }
    }
    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        对外接口设计 s = new 对外接口设计();
        s.Visit(s.new Dog());
        System.out.println(s.getName());

    }
}
