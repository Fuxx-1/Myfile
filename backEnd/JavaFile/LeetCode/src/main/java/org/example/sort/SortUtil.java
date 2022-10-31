package org.example.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-31 8:54
 */
public class SortUtil {
    public static void main(String[] args) {
        Integer[] a = {5, 7, 6, 8, 3, 2, 1, 4, 0, 9};
        Integer[] b = a.clone();
        bubbleSort(a, (a1, a2) -> {
            return (Integer) a1 - (Integer) a2 > 0;
        });
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.equals(b, a));
    }

    /**
     * 冒泡排序
     *
     * @param arr       数组
     * @param compareTo 比较方法
     */
    public static void bubbleSort(Object[] arr, BiFunction<Object, Object, Boolean> compareTo) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSwap = false; // 标记是否发生交换
            for (int j = i; j < arr.length; j++) {
                if (compareTo.apply(arr[i], arr[j])) {
                    swap(arr, i, j); // 交换 arr[i] 和 arr[j]
                    isSwap = true; // 标记发生交换
                }
            }
            if (!isSwap) return; // 未交换则返回
        }
    }

    public void quickSort(Object[] arr, BiFunction<Object, Object, Boolean> compareTo) {

        Queue<InterVal> queue = new LinkedList<>();
        queue.offer(new InterVal(0, arr.length - 1));
        while (queue.size() > 0) {
            InterVal interVal = queue.poll();
            int left = interVal.l, right = interVal.r;
            int middle = (l + r) / 2, l = left, r = right;
            while (l < r) {
                // 将 middle 外的元素置到 middle 两侧
                
            }
        }
    }

    public static class InterVal {
        public int l;
        public int r;

        public InterVal(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    /**
     * 交换数组中的第 i 个元素和第 j 个元素
     *
     * @param arr 对象数组
     * @param i   元素位置
     * @param j   元素位置
     */
    private static void swap(Object[] arr, Integer i, Integer j) {
        if (i == null || j == null) {
            return;
        }
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
