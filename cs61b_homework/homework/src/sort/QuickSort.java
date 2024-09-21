package sort;

import java.util.Arrays;

public class QuickSort {

    // 快速排序主函数
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取分区点
            int pivotIndex = partition(arr, low, high);
            // 对左半部分进行递归排序
            quickSort(arr, low, pivotIndex - 1);
            // 对右半部分进行递归排序
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 分区函数，返回基准元素的最终位置
    private static int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准值
        int pivot = arr[high];
        int i = low - 1; // i表示小于基准值的区域的最后一个元素的索引

        // 遍历数组，将小于基准值的元素放到左侧
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // 交换元素arr[i]和arr[j]，确保小于基准值的元素在左侧
                swap(arr, i, j);
            }
        }
        // 将基准值放到正确的位置
        swap(arr, i + 1, high);
        return i + 1; // 返回基准值的最终位置
    }

    // 辅助交换函数
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 示例数组
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("排序前的数组: " + Arrays.toString(arr));

        // 调用快速排序
        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}