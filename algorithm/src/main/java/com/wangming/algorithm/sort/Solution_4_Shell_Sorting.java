package com.wangming.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 描述：希尔排序:
 * 在插入排序的基础上做了优化,调整数据位置，尽可能的让数组有序。
 * ————————————————————————————————————————————————————————————————————————————————————————————————————
 */


public class Solution_4_Shell_Sorting {


    //逐步推导
    public static void shellSort(int[] nums) {

        int temp = 0;
        //第一轮 排序前:[8, 9, 1, 7, 2, 3, 5, 4, 6, 0]
        for (int i = 5; i < nums.length; i++) {//将10个数据分为5组(逻辑上分组)
            for (int j = i - 5; j >= 0; j -= 5) {//遍历各组所有的元素(共5组，每组2个元素)
                if (nums[j] > nums[j + 5]) {//如果当前元素大于加上步长的那个元素，则交换(从小到大)
                    temp = nums[j];
                    nums[j] = nums[j + 5];
                    nums[j + 5] = temp;
                }
            }
        }
        //第一轮 排序后:[3, 5, 1, 6, 0, 8, 9, 4, 7, 2]

        //第二轮 排序前:[3, 5, 1, 6, 0, 8, 9, 4, 7, 2]
        for (int i = 2; i < nums.length; i++) {//将10个数据分为5/2=2组(逻辑上分组)
            for (int j = i - 2; j >= 0; j -= 2) {//遍历各组所有的元素(共5组，每组2个元素)
                if (nums[j] > nums[j + 2]) {//如果当前元素大于加上步长的那个元素，则交换(从小到大)
                    temp = nums[j];
                    nums[j] = nums[j + 2];
                    nums[j + 2] = temp;
                }
            }
        }
        //第二轮 排序后:[0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
        //第三轮 排序前:[0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
        for (int i = 1; i < nums.length; i++) {//将10个数据分为5/2/2=1组(逻辑上分组)
            for (int j = i - 1; j >= 0; j -= 1) {//遍历各组所有的元素(共5组，每组2个元素)
                if (nums[j] > nums[j + 1]) {//如果当前元素大于加上步长的那个元素，则交换(从小到大)
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        //第三轮 排序后:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    /**
     * 根据上方法推导出:希尔排序-交换法-相比插入排序变慢了好多
     *
     * @see #shellSort(int[])
     */
    public static void shellSortV2(int[] nums) {

        int temp = 0;
        int count = 0;
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {// gap /= 2 每次的分组
            for (int i = gap; i < nums.length; i++) {//将10个数据分为5组(逻辑上分组)
                for (int j = i - gap; j >= 0; j -= gap) {//遍历各组所有的元素(共5组，每组2个元素)
                    if (nums[j] > nums[j + gap]) {//如果当前元素大于加上步长的那个元素，则交换(从小到大)
                        temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
                }
            }
            System.out.println("第" + (++count) + "轮:" + Arrays.toString(nums).substring(0, 100));
        }
    }


    /**
     * 根据上方法推导出:希尔排序-移位法
     *
     * @see #shellSort(int[])
     */
    public static int[] shellSortV3(int[] nums) {

        for (int gap = nums.length / 2; gap >= 1; gap = gap / 2) {  // 增量 gap, 并逐步的缩小增量
            for (int i = gap; i < nums.length; i++) {// 从第 gap 个元素，逐个对其所在的组进行直接插入排序
                int j = i;
                int temp = nums[j];
                while (j - gap >= 0 && temp < nums[j - gap]) {
                    nums[j] = nums[j - gap]; //移动
                    j -= gap;
                }
                nums[j] = temp;//当退出 while 后，就给 temp 找到插入的位置
            }
        }
        return nums;
    }


    public static void main(String[] args) {

        int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] nums_2 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            nums_2[i] = (int) (Math.random() * 80000);//0~80000
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("排序前时间:" + simpleDateFormat.format(new Date()));
        System.out.println("排序前:" + Arrays.toString(nums));
        shellSortV3(nums);
        System.out.println("排序后:" + Arrays.toString(nums));
        System.out.println("排序后时间:" + simpleDateFormat.format(new Date()));
        // 交换 排序前时间:2019-09-12 17:14:33:333  交换 排序后时间:2019-09-12 17:14:40:295
        // 移位 排序前时间:2019-09-12 17:28:54:871  移位 排序后时间:2019-09-12 17:28:54:983
    }

}
