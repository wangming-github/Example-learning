package com.wangming.algorithm.search;

/**
 * 二分查找
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-10-09 18:50
 */
public class Solution_2_BinarySearch {

    public static void main(String[] args) {

        int arr[] = {1, 8, 10, 89, 1000, 1234};// 有顺序的数组

        int index = seqSearch(arr, 11);

        if (index == -1) {
            System.out.println("没有找到到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     */
    public static int seqSearch(int[] arr, int value) {

        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
