package sort;

import java.util.Arrays;

public class MergeSort {

    // 归并排序主函数
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;  // 如果数组长度小于2，直接返回
        }

        // 找到数组的中间点
        int mid = array.length / 2;

        // 分割数组为两个子数组
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // 递归地对左右子数组进行排序
        mergeSort(left);
        mergeSort(right);

        // 合并左右子数组
        merge(array, left, right);
    }

    // 合并两个有序数组
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 将左右子数组中的元素进行比较，按序放入原数组
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // 将剩余的左子数组元素复制到原数组
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // 将剩余的右子数组元素复制到原数组
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        // 创建待排序的数组
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        // 输出排序前的数组
        System.out.println("Original array: " + Arrays.toString(array));

        // 调用归并排序算法
        mergeSort(array);

        // 输出排序后的数组
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
