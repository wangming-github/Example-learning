package com.wangming.algorithm.sort;

/**
 * 选择排序
 * 选择排序(select sorting)也是一种简单的排序方法。
 * 它的基本思想是:第一次从 arr[0]~arr[n-1]中选取最小值，
 * 与 arr[0]交换，第二次从 arr[1]~arr[n-1]中选取最小值，
 * 与 arr[1]交换，第三次从 arr[2]~arr[n-1]中选取最小值，
 * 与 arr[2] 交换，...，第 i 次从 arr[i-1]~arr[n-1]中选取最小值，
 * 与 arr[i-1]交换，..., 第 n-1 次从 arr[n-2]~arr[n-1]中选取最小值，
 * 与 arr[n-2]交换，总共通过 n-1 次，得到一个按排序码从小到大排列的有序序列。
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-09-06 14:10
 */


public class Solution_2_Select_Sorting_Review {

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

    /*
     * 思路：
     * 第一次：从第一位开始： 找到本轮的最小数，找到其下标，并将其和第一位的数做调换。
     * 第二次：从第二位开始： 找到本轮的最小数，找到其下标，并将其和第二位的数做调换。
     * ......
     */
    public int[] sortArray(int[] nums) {

        ////第一次
        //int minIndex = 0;  //假定当前，最小数字下标
        //int min = nums[minIndex]; //则最小数
        ////当前数依次和其后面每一个数字做比较
        //for (int i = 0 + 1; i < nums.length; i++) {
        //
        //    //判断大小
        //    if (min > nums[i]) {
        //        //说明后面的树比当前数还小，重新指定最小数
        //        minIndex = i;
        //        min = nums[minIndex];
        //    }
        //
        //    //调换位置
        //    if (minIndex != 0) {
        //        nums[minIndex] = nums[0];
        //        nums[0] = min;
        //    }
        //}

        //第 j 次
        for (int j = 0; j < nums.length - 1; j++) {
            //第一次
            int minIndex = j;  //假定当前，最小数字下标
            int min = nums[minIndex]; //则最小数
            //当前数依次和其后面每一个数字做比较
            for (int i = 0 + j; i < nums.length; i++) {

                //判断大小
                if (min > nums[i]) {
                    //说明后面的树比当前数还小，重新指定最小数
                    minIndex = i;
                    min = nums[minIndex];
                }

                //调换位置
                if (minIndex != j) {
                    nums[minIndex] = nums[j];
                    nums[j] = min;
                }
            }
        }
        return nums;
    }


}
