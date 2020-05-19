package com.wangming.algorithm.sort;


/**
 * 描述：冒泡排序-复习
 *
 * @auther MaiZi
 * @date 2019-09-09 10:03
 */
public class Solution_1_Bubble_Sorting_Review {

    /*
     * 描述：给定一个整数数组 nums，将该数组升序排列。
     *
     * 示例 1：
     * 输入：[5,2,3,1]
     * 输出：[1,2,3,5]
     * 示例 2：
     *
     * 输入：[5,1,1,2,0,0]
     * 输出：[0,0,1,1,2,5]
     *
     * 提示：
     * 1 <= A.length <= 10000
     * -50000 <= A[i] <= 50000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @auther MaiZi
     * @date 2019-09-06 17:51
     */
    public int[] sortArray(int[] nums) {


        ////第一轮：找出本轮最大的数字，放在最后
        //int temp = 0;
        //boolean isSort1 = false;
        //for (int i = 0; i < nums.length - 1; i++) {
        //    if (nums[i] > nums[i + 1]) {
        //        temp = nums[i + 1];
        //        nums[i + 1] = nums[i];
        //        nums[i] = temp;
        //    }
        //    //如果当不存在调换位置，就提前结束
        //    if (!isSort1) {
        //        break;
        //    }
        //}
        //
        ////第二轮：找出本轮最大的数字，放在最后
        //boolean isSort2 = false;
        //for (int i = 0; i < nums.length - 1 - 1; i++) {
        //    if (nums[i] > nums[i + 1]) {
        //        temp = nums[i + 1];
        //        nums[i + 1] = nums[i];
        //        nums[i] = temp;
        //    }
        //    //如果当不存在调换位置，就提前结束
        //    if (!isSort2) {
        //        break;
        //    }
        //}

        //第 j 轮：找出本轮最大的数字，放在最后
        int temp = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            //优化:如果此次排序没有发生位置调换，则提前结束
            boolean isSort = false;
            for (int i = 0; i < nums.length - 1 - j; i++) {
                if (nums[i] > nums[i + 1]) {
                    isSort = true;
                    temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
                //如果当不存在调换位置，就提前结束
                if (!isSort) {
                    break;
                }

            }
        }


        return nums;
    }


}
