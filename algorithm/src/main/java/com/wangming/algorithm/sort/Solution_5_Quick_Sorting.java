package com.wangming.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
 * 描述：快速排序:
 * 快速排序(Quicksort)是对冒泡排序的一种改进。
 * 基本思想是:通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排 序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 *
 *
 * 快速排序由于排序效率在同为O(N*logN)的几种排序方法中效率较高，因此经常被采用，再加上快速排序思想----
 * 分治法也确实实用，因此很多软件公司的笔试面试，包括像腾讯，微软等知名IT公司都喜欢考这个，还有大大小的程序方面的考试如软考，考研中也常常出现快速排序的身影。
 * 总的说来，要直接默写出快速排序还是有一定难度的，因为本人就自己的理解对快速排序作了下白话解释，希望对大家理解有帮助，达到快速排序，快速搞定。
 *
 *
 *
 * 快速排序是C.R.A.Hoare于1962年提出的一种划分交换排序。它采用了一种分治的策略，通常称其为分治法(Divide-and-ConquerMethod)。
 *
 * 该方法的基本思想是：
 *
 * 1．先从数列中取出一个数作为基准数。
 *
 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 *
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 *
 *
 *
 * 虽然快速排序称为分治法，但分治法这三个字显然无法很好的概括快速排序的全部步骤。因此我的对快速排序作了进一步的说明：挖坑填数+分治法：
 *
 * 先来看实例吧，定义下面再给出（最好能用自己的话来总结定义，这样对实现代码会有帮助）。
 *
 * ┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈
 *
 * 以一个数组作为示例，取区间第一个数为基准数。
 *
 * ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
 * ├   i                                  j   ┤
 * ├   0  1   2   3   4   5   6   7   8   9   ┤
 * ├  72  6  57  88  60  42  83  73  48  85   ┤
 * ┆  72                                      ┆
 * ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯
 *
 * 初始时，
 * ┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈i = 0;  j = 9;   X = a[i] = 72┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈
 * 由于已经将a[0]中的数保存到X中，可以理解成在数组a[0]上挖了个坑，可以将其它数据填充到这来。 从j开始向前找一个比X小或等于X的数。当j=8，符合条件，将a[8]挖出再填到上一个坑a[0]中。a[0]=a[8]; i++;
 *
 *  <<方向数组变为：
 * ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮             ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
 * ├   i                              j      <┤             ├      i                           j      <┤
 * ├   0  1   2   3   4   5   6   7   8   9   ┤    85>72    ├   0  1   2   3   4   5   6   7   8   9   ┤
 * ├   ■  6  57  88  60  42  83  73  48  85   ┤    48<72->  ├  48  6  57  88  60  42  83  73   ■  85   ┤
 * ┆  72                             48  85   ┆             ┆  48                             72  85   ┆
 * ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯             ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯
 *
 *┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈i = 1;   j = 8;   X=72┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈
 *
 * 这样一个坑a[0]就被搞定了，但又形成了一个新坑a[8]，这怎么办了？简单，再找数字来填a[8]这个坑。这次从i开始向后找一个大于X的数，当i=3，符合条件，将a[3]挖出再填到上一个坑中a[8]=a[3]; j--;
 *
 * 数组变为：
 * ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮             ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
 * ├>              i                   j      ┤             ├>             i               j           ┤
 * ├   0   1   2   3   4   5   6   7   8   9  ┤     6<72    ├   0  1   2   3   4   5   6   7   8   9   ┤
 * ├   48  6  57  88  60  42  83  73   ■  85  ┤    57<72    ├  48  6  57   ■  60  42  83  73   88  85  ┤
 * ┆   48  6  57  88                  72  85  ┆    88>72->  ┆  48  6  57  72                   88  85  ┆
 * ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯             ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯
 *
 *┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈i = 3;   j = 7;   X=72┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈
 *
 *
 *
 * 再重复上面的步骤，先从后向前找，再从前向后找。
 *
 * 从j开始向前找，当j=5，符合条件，将a[5]挖出填到上一个坑中，a[3] = a[5]; i++;
 *
 * 从i开始向后找，当i=5时，由于i==j退出。
 *
 * 此时，i = j = 5，而a[5]刚好又是上次挖的坑，因此将X填入a[5]。
 *
 *
 *  <<方向数组变为：
 * ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮             ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
 * ├               i                   j     <┤             ├                  i   j                  <┤
 * ├   0   1   2   3   4   5   6   7   8   9  ┤    73>72    ├   0  1   2   3   4   5   6   7   8   9   ┤
 * ├   48  6  57   ■  60  42  83  73  88  85  ┤    83>72    ├  48  6  57  42  60   ■  83  73   88  85  ┤
 * ┆   48  6  57  72                  88  85  ┆    42<72->  ┆  48  6  57  42      72  83  73   88  85  ┆
 * ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯             ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯
 *
 *┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈i = 4;   j = 5;   X=72┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈
 *
 *
 *  >>方向数组变为：
 * ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮             ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
 * ├>                  i   j                  ┤             ├                  i   j                  <┤
 * ├   0   1   2   3   4   5   6   7   8   9  ┤    60<72    ├   0  1   2   3   4   5   6   7   8   9   ┤
 * ├   48  6  57  42   60  ■  83  73  88  85  ┤             ├  48  6  57  42  60   ■  83  73   88  85  ┤
 * ┆   48  6  57  42      72  83  73  88  85  ┆             ┆  48  6  57  42  60  72  83  73   88  85  ┆
 * ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯             ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯
 *
 *┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈i = 4;   j = 5;   X=72┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈
 *
 * 数组变为：
 * ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮                         ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
 * ├i                   j┤                         ├j                      j┤
 * ├   0  1   2   3   4  ┤                         ├   5   6   7    8   9   ┤
 * ├  48  6  57  42  60  ┤                         ├  72  83  73   88  85   ┤
 * ┆                     ┆                         ┆                        ┆
 * ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯                         ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯
 * ——————————————————————————————————————————————————————————————————————————————————————————————————————
 * ——————————————————————————————————————————————————————————————————————————————————————————————————————
 * ——————————————————————————————————————————————————————————————————————————————————————————————————————
 *
 * 可以看出a[5]前面的数字都小于它，a[5]后面的数字都大于它。因此再对a[0…4]和a[6…9]这二个子区间重复上述步骤就可以了。
 *
 * ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮           ╭┈┈┈┈┈╮           ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
 * ├i                   j┤           ├     ┤           ├  i/j              ┤
 * ├   0  1   2   3   4  ┤           ├   5 ┤           ├   6   7    8   9  ┤
 * ├  48  6  57  42  60  ┤           ├  72 ┤           ├  83  73   88  85  ┤
 * ┆  48             60  ┆           ┆     ┆           ├  73  83   88  85  ┆
 * ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯           ╰┈┈┈┈┈╯           ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯
 *
 *  i = 0;   j = 4;   X=48                            i = 6;  j = 9;  X=83
 * ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮                            ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
 * ├          i   j      ┤                            ├j                j┤
 * ├   0  1   2   3   4  ┤                            ├  6   7    8   9  ┤
 * ├  42  6   ■  57  60  ┤                            ├ 83  73   88  85  ┤
 * ┆  42  6  48  57  60  ┆                            ┆ 73  83   88  85  ┆
 * ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯                            ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯
 * ——————————————————————————————————————————————————————————————————————————————————————————————————————
 * ——————————————————————————————————————————————————————————————————————————————————————————————————————
 * ╭┈┈┈┈┈┈┈┈╮           ╭┈┈┈┈╮           ╭┈┈┈┈┈┈┈┈┈╮                            ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
 * ├        ┤           ├    ┤           ├         ┤                            ├j                j┤
 * ├   0  1 ┤           ├  2 ┤           ├  3   4  ┤                            ├  6   7    8   9  ┤
 * ├  42  6 ┤           ├ 48 ┤           ├ 57  60  ┤                            ├ 73  83   88  85  ┤
 * ┆        ┤           ├    ┤           ├         ┆                            ┆                  ┆
 * ╰┈┈┈┈┈┈┈┈╯           ╰┈┈┈┈╯           ╰┈┈┈┈┈┈┈┈┈╯                            ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯
 *
 *
 *
 * 对挖坑填数进行总结
 *
 * 1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
 *
 * 2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
 *
 * 3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
 *
 * 4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
 * ————————————————
 * 版权声明：本文为CSDN博主「MoreWindows」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/MoreWindows/article/details/6684558
 *
 * @auther MaiZi
 * @date 2019-09-18 16:20
 */


public class Solution_5_Quick_Sorting {


    //逐步推导
    public static void quickSort(int[] nums, int left, int right) {

        int l = left;
        int r = right;
        int index = nums[l];//基准数

        int temp = 0;
        while (l < r) {//循环目的是让比 index 小的放到左边，比 index 大的放在右边

            //在 index 左边找到比index 大于等于 的值 退出
            while (nums[l] < index) {
                l += 1;
            }

            //在index右边找到一个比index 小于等于 的数 退出
            while (nums[r] > index) {
                r -= 1;
            }

            //l > r 时 说明index左边的值都比他小，index右边的值都比他大
            if (l > r) {
                break;
            }

            //交换
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            //交换完后，发现num[l]==index;r --前移
            if (nums[l] == index) {
                r -= 1;
            }

            //交换完后，发现num[r]==index;r --前移
            if (nums[r] == index) {
                l += 1;
            }

        }


        // 如果 l == r, 必须 l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left < r) {
            quickSort(nums, left, r);
        }

        ////向右递归
        if (right > l) {
            quickSort(nums, l, right);
        }


    }


    //快速排序
    public static void quick_sort(int nums[], int l, int r) {
        if (l < r) {

            int i = l, j = r, x = nums[l];
            //i 左下标   j 右下标
            while (i < j) {

                while (i < j && nums[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    nums[i++] = nums[j]; //将nums[j]填到nums[i]中，nums[j]就形成了一个新的坑


                while (i < j && nums[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    nums[j--] = nums[i];
            }

            nums[i] = x;
            quick_sort(nums, l, i - 1); // 递归调用
            quick_sort(nums, i + 1, r);
        }
    }

    public static void main(String[] args) {

        int[] nums = {-9, 78, 0, 23, -567, 70};
        //int[] nums_2 = new int[80000];
        //for (int i = 0; i < 80000; i++) {
        //    nums_2[i] = (int) (Math.random() * 80000);//0~80000
        //}

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("排序前时间:" + simpleDateFormat.format(new Date()));
        System.out.println("排序前:" + Arrays.toString(nums));
        quick_sort(nums, 0, nums.length - 1);
        System.out.println("排序后:" + Arrays.toString(nums));
        System.out.println("排序后时间:" + simpleDateFormat.format(new Date()));
    }

}
