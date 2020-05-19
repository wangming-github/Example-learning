```java
package com.example.day_8_SortAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**

 * 冒泡排序(Bubble Sorting)
 *———————————————————————————————————————————————————————————————————————————————————————
 * 冒泡排序(Bubble Sorting)的基本思想是:通过对待排序序列从前向后(从下标较小的元素开始),依次比较相邻元素的值，
 * 若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。
 *———————————————————————————————————————————————————————————————————————————————————————
 * 优化: 因为排序的过程中，各元素不断接近自己的位置，如果一趟比较下来没有进行过交换，就说明序列有序，
 * 因此要在 排序过程中设置一个标志 flag 判断元素是否进行过交换。从而减少不必要的比较。(这里说的优化，可以在冒泡排 序写好后，在进行)
 * ————————————————————————————————————————————————————————————————————————————————————————————————————
   *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-09-06 14:10
   */


public class Solution_1_Bubble_Sorting {

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
        int temp = 0;
        for (int ii = 0; ii < nums.length - 1; ii++) {
            boolean isSort = false;
            for (int i = 0; i < nums.length - 1 - ii; i++) {
                if (nums[i] > nums[i + 1]) {
                    isSort = true;
                    temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
            if (!isSort) {
                break;
            }
        }
        return nums;
    }



    /*
     ******************第一次排序*******************
     *   A   B
     *  [3   9   -1   10   20]    原始
     *
     *       A   B
     *  [3   9   -1   10   20]    1>如果相邻元素逆序就交换
     *
     *            A   B
     *  [3   -1   9   10   20]
     *
     *                 A   B
     *  [3   -1   9   10   20]   20
     ******************第二次排序******************
     *        A   B
     *  [-1   3   9   10   20]
     *
     *            A   B
     *  [-1   3   9   10   20]
     *
     *    A   B
     *  [-1   3   9   10   20]   10   20
     ******************第三次排序******************
     *        A   B
     *  [-1   3   9   10   20]
     *
     *            A   B
     *  [-1   3   9   10   20]  9   10   20
     ******************第四次排序*******************
     *    A   B
     *  [-1   3   9   10   20]  3   9   10   20
     ********************************************
     * 总计：
     * 1.进行数组size-1次循环
     * 2.每次排序次数逐渐减少
     * 3.我们发现在某次排序中一次交换没有，可以提前结束冒泡排序【优化】
     */
    
    public static void bubbleSortingV1(int[] arr) {
    
        //第一次排序:将最大的数字排在最后
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) { //如果相邻元素逆序(前一个大于后一个)就交换
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第一次排序:" + Arrays.toString(arr));
    
        //第二次排序:将第二大的数字排在最后第二
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            if (arr[i] > arr[i + 1]) { //如果相邻元素逆序(前一个大于后一个)就交换
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第二次排序:" + Arrays.toString(arr));
    
        //第三次排序:将第三大的数字排在最后第三
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            if (arr[i] > arr[i + 1]) { //如果相邻元素逆序(前一个大于后一个)就交换
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第三次排序:" + Arrays.toString(arr));


        //第四次排序:将第三大的数字排在最后第四
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            if (arr[i] > arr[i + 1]) { //如果相邻元素逆序(前一个大于后一个)就交换
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第四次排序:" + Arrays.toString(arr));
    
    }


    //冒泡排序
    //时间复杂度:O(n²)
    public static void bubbleSortingV2(int[] arr) {
    
        int temp = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) { //如果相邻元素逆序(前一个大于后一个)就交换
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            System.out.println("第" + (j + 1) + "次排序:" + Arrays.toString(arr));
        }
    
    }


    //冒泡排序-优化
    //时间复杂度:O(n²)
    public static void bubbleSortingV3(int[] arr) {
    
        int temp = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            boolean isSort = false;//是否进行过交换
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) { //如果相邻元素逆序(前一个大于后一个)就交换
    
                    isSort = true;//一次交换都没发生过
    
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
    
            if (!isSort) {//一次交换都没发生过
                break;
            }
        }
    
    }


    public static void main(String[] args) {
    
        int[] arr = {3, 9, -1, 10, -2};
        int[] arr_2 = new int[80];
    
        for (int i = 0; i < 80; i++) {
            arr_2[i] = (int) (Math.random() * 80000);//0~80000
        }
    
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("排序前时间:" + simpleDateFormat.format(new Date()));//80000 数据排序:2019-09-06 16:13:16
        System.out.println("排序前:" + Arrays.toString(arr_2));
        bubbleSortingV3(arr_2);
        System.out.println("排序后:" + Arrays.toString(arr_2));
        System.out.println("排序后时间:" + simpleDateFormat.format(new Date()));//80000 数据排序:2019-09-06 16:13:28
    }


}
```

