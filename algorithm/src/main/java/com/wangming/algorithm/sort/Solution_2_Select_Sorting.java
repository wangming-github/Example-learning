package com.wangming.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 * ————————————————————————————————————————————————————————————————————————————————————————————————————
 * 选择排序(select sorting)也是一种简单的排序方法。
 * 它的基本思想是:第一次从 arr[0]~arr[n-1]中选取最小值，
 * 与 arr[0]交换，第二次从 arr[1]~arr[n-1]中选取最小值，
 * 与 arr[1]交换，第三次从 arr[2]~arr[n-1]中选取最小值，
 * 与 arr[2] 交换，...，第 i 次从 arr[i-1]~arr[n-1]中选取最小值，
 * 与 arr[i-1]交换，..., 第 n-1 次从 arr[n-2]~arr[n-1]中选取最小值，
 * 与 arr[n-2]交换，总共通过 n-1 次，得到一个按排序码从小到大排列的有序序列。
 * ————————————————————————————————————————————————————————————————————————————————————————————————————
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-09-06 14:10
 */


public class Solution_2_Select_Sorting {

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

        //然后依次判断每一次循环
        for (int j = 0; j < nums.length - 1; j++) {

            int minIndex = j;//定义当前循环最小值下标为0
            int min = nums[minIndex];//即当前小值为:nums[minIndex];

            //判断当前值和后续每一个值的大小; i初始值已经为定义最小值的下一位
            for (int i = j + 1; i < nums.length; i++) {
                if (min > nums[i]) {//如果后面的值小于当前定义的最小值，则重新定义最小值
                    minIndex = i;
                    min = nums[i];
                }
            }

            //找到本轮的最小值为 min 最小值下标为 minIndex
            //然后和第一位进行替换;先把最小值的位置放第一位的数字；让后第一位放最小数；注意顺序
            //要是当前定义位置就是最小值位置就不需要调换位置
            if (minIndex != j) {
                nums[minIndex] = nums[j];
                nums[j] = min;
            }

        }
        return nums;
    }



    /*
     *******************原始***********************
     *  [101   34   119   1]
     *******************第一次排序******************
     *  [1   34   119   101]
     *******************第二次排序******************
     *  [1   34   119   101]
     *******************第三次排序******************
     *  [1   34   101   119]
     *******************结束**********************
     * 总计：
     * 1.进行数组.size-1次循环
     * 2.每次排序次又是一个循环，循环规则
     * 2.1.先假定当前数最小
     * 2.2.然后和后面的每个数字比较，如果发现有比当前数更小数，就重新确定最小数和其下标
     * 2.3.当遍历到数组最后就得到本轮最小数和下标。
     * 2.4.交换第一个数，和最小数位置。
     */

    public static void selectSortingV1(int[] arr) {

        //使用逐步推倒，理解选择排序
        //(算法思想:先简单后复杂，可以把复杂算法拆分成简单问题然后逐步解决)

        //==============第一轮:让当前数和后面的每一个数进行比较==============
        //第一次排序 先找到最小的数字
        int minIndex = 0;//假定当前最小数索引为0；
        int min = arr[0];
        for (int i = 0 + 1; i < arr.length; i++) {
            if (min > arr[i]) {//说明当前位置的后一个数是目前的最小数，重置下最小值及其下标
                minIndex = i;
                min = arr[i];
            }
        }
        //交换：将最小值，放在第一位
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        System.out.println("第一轮:" + Arrays.toString(arr));//[1, 34, 119, 101]


        //==============第二轮:让当前数和后面的每一个数进行比较==============
        minIndex = 1;//假定当前最小数索引为0；
        min = arr[1];
        for (int i = 1 + 1; i < arr.length; i++) {
            if (min > arr[i]) {//说明当前位置的后一个数是目前的最小数，重置下最小值及其下标
                minIndex = i;
                min = arr[i];
            }
        }
        //交换：将最小值，放在第二位
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第二轮:" + Arrays.toString(arr));//[1, 34, 119, 101]


        //==============第三轮:让当前数和后面的每一个数进行比较==============
        minIndex = 2;//假定当前最小数索引为0；
        min = arr[2];
        for (int i = 2 + 1; i < arr.length; i++) {
            if (min > arr[i]) {//说明当前位置的后一个数是目前的最小数，重置下最小值及其下标
                minIndex = i;
                min = arr[i];
            }
        }
        //交换：将最小值，放在第二位
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("第三轮:" + Arrays.toString(arr));//[1, 34, 101, 119]

    }

    //总结：
    //时间复杂度：O(n²)
    public static void selectSortingV2(int[] arr) {

        //使用逐步推倒，理解选择排序
        //(算法思想:先简单后复杂，可以把复杂算法拆分成简单问题然后逐步解决)

        for (int j = 0; j < arr.length - 1; j++) {
            int minIndex = j;//假定当前最小数索引为0；
            int min = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                // 只需要改变大于号为小于号就可以实现 从大到小
                if (min > arr[i]) {//说明当前位置的后一个数是目前的最小数，重置下最小值及其下标
                    minIndex = i;
                    min = arr[i];
                }
            }
            //交换：将最小值，放在第一位
            if (minIndex != j) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
        }


    }

    public static void main(String[] args) {

        int[] arr = {101, 34, 119, 1};

        int[] arr_2 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr_2[i] = (int) (Math.random() * 80000);//0~80000
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("排序前时间:" + simpleDateFormat.format(new Date()));//80000 排序前时间:2019-09-09 14:15:16:800
        System.out.println("排序前:" + Arrays.toString(arr));
        //selectSortingV1(arr);
        selectSortingV2(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
        System.out.println("排序后时间:" + simpleDateFormat.format(new Date()));//80000 排序后时间:2019-09-09 14:15:20:090
    }


}
