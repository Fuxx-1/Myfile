package org.example.sort;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-31 8:54
 */
public class SortUtil {
    public static void main(String[] args) {
//        int[] a = {669, 308, 609, 564, 376, 778, 335, 527, 643, 289, 557, 728, 410, 539, 719, 643, 460, 592, 97, 523, 532, 632, 360, 22, 766, 245, 314, 421, 12, 805, 156, 88, 819, 857, 904, 881}; // , 8, 3, 2, 1, 4, 0, 9
        int[] a = {5, 2, 4, 1, 3, 6, 0}; // , 8, 3, 2, 1, 4, 0, 9
//        Random random = new Random();
//        Integer[] a = new Integer[random.nextInt(100)]; // , 8, 3, 2, 1, 4, 0, 9
//        for (int i = 0; i < a.length; i++) {
//            a[i] = random.nextInt(1000);
//        }
        int[] b = a.clone();
        sort(a, 0, a.length - 1);
//        quickSort(a, (a1, a2) -> {
//            return (Integer) a1 - (Integer) a2 < 0;
//        });
        System.out.println(Arrays.toString(a));
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
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

    public static void quickSort(Object[] arr, BiFunction<Object, Object, Boolean> compareTo) {
        Queue<InterVal> queue = new LinkedList<>();
        queue.offer(new InterVal(0, arr.length - 1));
        while (queue.size() > 0) {
            InterVal interVal = queue.poll();
            int l = interVal.l, r = interVal.r;
            if (l >= r) continue;
            Object mid = arr[(l + r) / 2];
            while (l < r) {
                if (arr[l].equals(arr[r])) {
                    r--;
                }
                while (compareTo.apply(arr[l], mid)) l++;
                while (compareTo.apply(mid, arr[r])) r--;
                swap(arr, l, r);
//                print(arr, mid);
            }
            System.out.println(Arrays.toString(arr));
            if (interVal.l < interVal.r) {
                queue.offer(new InterVal(interVal.l, Math.max(l - 1, 0)));
                queue.offer(new InterVal(Math.min(l + 1, arr.length), interVal.r));
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


    private static void print(Object[] arr, Object mid) {
        System.out.print("[ ");
        for (Object o : arr) {
            if (!o.equals(mid)) System.out.print(o + ", ");
            else System.out.print("{" + o + "}, ");
        }
        System.out.print("]\n");
    }

    private static void sort(int[] nums, int left, int right) {
        int l = left - 1, r = right + 1;
        if (left >= right) return;
        int mid = nums[(left + right) / 2 + 1];
        while (l < r) {
            while (nums[++l] < mid) ;
            while (mid < nums[--r]) ;
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }

        }
        sort(nums, left, l - 1);
        sort(nums, l, right);
    }
}
