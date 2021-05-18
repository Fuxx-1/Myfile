import java.util.ArrayList;

public class Arraylist {
    public static void main(String[] args) {



//        clone()	复制一份 arraylist
//        contains()	判断元素是否在 arraylist
//        indexOf()	返回 arraylist 中元素的索引值
//        removeAll()	删除存在于指定集合中的 arraylist 里的所有元素
//        remove()	删除 arraylist 里的单个元素
//        isEmpty()	判断 arraylist 是否为空
//        subList()	截取部分 arraylist 的元素
//        set()	替换 arraylist 中指定索引的元素
//        sort()	对 arraylist 元素进行排序
//        toArray()	将 arraylist 转换为数组
//        toString()	将 arraylist 转换为字符串
//        ensureCapacity()	设置指定容量大小的 arraylist
//        lastIndexOf()	返回指定元素在 arraylist 中最后一次出现的位置
//        retainAll()	保留 arraylist 中在指定集合中也存在的那些元素
//        containsAll()	查看 arraylist 是否包含指定集合中的所有元素
//        trimToSize()	将 arraylist 中的容量调整为数组中的元素个数
//        removeRange()	删除 arraylist 中指定索引之间存在的元素
//        replaceAll()	将给定的操作内容替换掉数组中每一个元素
//        removeIf()	删除所有满足特定条件的 arraylist 元素


        ArrayList<Integer> MyNumber_1 = new ArrayList<>();
        //add()	    将元素插入到指定位置的 arraylist 中
        MyNumber_1.add(12);
        //ArrayList2 用做提供集合
        ArrayList<Integer> MyNumber_2 = new ArrayList<>();
        MyNumber_2.add(1);
        MyNumber_2.add(2);
        MyNumber_2.add(3);
        //addAll()	添加集合中的所有元素到 arraylist 中
        MyNumber_1.addAll(MyNumber_2);
        System.out.println("add()和addAll()方法执行后：");
        for (int i = 0; i < MyNumber_1.size(); i++) {
            //size()	返回 arraylist 里元素数量
            //get()	通过索引值获取 arraylist 中的元素
            System.out.println(MyNumber_1.get(i));
//            System.out.println(MyNumbers.remove(i));
//            //若remove方法传入的是索引值，返回值则为该元素的值
//            System.out.println(MyNumbers.remove(Integer.valueOf(MyNumbers.get(i))));
//            //若remove方法传入的是元素值，返回值则为是否删除成功
        }
        //clear()	删除 arraylist 中的所有元素
        MyNumber_1.clear();
        System.out.println("clear()方法后：");
        //forEach()	遍历 arraylist 中每一个元素并执行特定操作
        MyNumber_1.forEach((item) ->{
            System.out.println(item);
        });
        System.out.println(MyNumber_1.isEmpty());
    }
}
