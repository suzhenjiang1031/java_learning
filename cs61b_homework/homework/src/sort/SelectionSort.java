package sort;

import java.util.Arrays;

public class SelectionSort {

    // 选择排序函数
    public static void selectionSort(int[] array) {
        int n = array.length;

        // 逐一遍历数组
        for (int i = 0; i < n - 1; i++) {
            // 假设当前的元素是最小的
            int minIndex = i;

            // 找到未排序部分中的最小元素
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // 将找到的最小元素与当前元素交换
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个待排序的数组
        int[] array = {64, 25, 12, 22, 11};

        // 输出排序前的数组
        System.out.println("Original array: " + Arrays.toString(array));

        // 调用选择排序算法
        selectionSort(array);

        // 输出排序后的数组
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

