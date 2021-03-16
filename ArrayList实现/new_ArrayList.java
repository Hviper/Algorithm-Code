package ArrayList实现;


import java.lang.Integer;
public class new_ArrayList<E> {
    //size-1表示索引
    private int size=0;
    private E[] elements;
    private final int Default_length=10;
    public static void main(String[] args) {
        new_ArrayList<Integer> new_arrayList = new new_ArrayList<>();
        Integer integer1 = 15;
        Integer integer2 = 6;
        Integer integer3 = 154;
        new_arrayList.add(integer1);
        new_arrayList.add(integer2);
        new_arrayList.add(integer3);
        System.out.println(new_arrayList.toString());
        System.gc();
    }

    public new_ArrayList(int size){
        elements =(E[])new Object[size];
    }

    public new_ArrayList(){
        elements =(E[]) new Object[Default_length];
    }


    public void add(E element){
        //判断确保容量足够
        ensureCapacity(size+1);

        elements[size++]=element;
    }

    public void remove(){
        size--;
    }
    public void remove(int index){
        for(int i=index+1;i<size;i++){
            elements[i-1]=elements[i];
        }
        elements[--size]=null;
    }

    public void insert(int index,E element){
        if(index<0 || index>size-1){
            throw new IndexOutOfBoundsException("数组越界！");
        }
        if(size<elements.length){
            for(int i=size-1;i>=index;i--){
                elements[i+1]=elements[i];
            }
            elements[index]=element;
            size++;
        }

    }
    public E get(){
        return elements[size-1];
    }
    public void list(){
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]+"\t");
        }
    }

    private void ensureCapacity(int capacity){
        if(capacity< elements.length){return;}
        //扩充原来的1.5倍
        int new_capacity=capacity+capacity>>1;
        E[] new_element= (E[])new Object[new_capacity];
        for (int i = 0; i < size; i++) {         //本来（size-1）就是指下标最大的索引
            new_element[i]=elements[i];
        }
        elements=new_element;
    }

    //根据索引来判断是否越界 【封装成一个方法，这样使得代码更加精简！】
    public void IndexOutOf_Arraylist(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("数组越界。。。size="+size+",index="+index);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i=0;i<size;i++){
            if(i!=0){
                stringBuilder.append(", ").append(elements[i]);
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("回收成功");
    }
}
