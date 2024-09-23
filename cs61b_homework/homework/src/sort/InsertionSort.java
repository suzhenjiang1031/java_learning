package sort;

import java.util.Arrays;

public class InsertionSort {

    // 插入排序函数
    public static void insertionSort(int[] array) {
        // 从第二个元素开始，因为第一个元素默认已经排序
        for (int i = 1; i < array.length; i++) {
            // 当前待排序的元素
            int current = array[i];
            int j = i - 1;

            // 在已排序部分中找到合适的插入位置
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // 元素右移
                j--;
            }
            // 插入当前元素
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        // 创建一个待排序的数组
        int[] array = {12, 11, 13, 5, 6};

        // 输出排序前的数组
        System.out.println("Original array: " + Arrays.toString(array));

        // 调用插入排序算法
        insertionSort(array);

        // 输出排序后的数组
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
