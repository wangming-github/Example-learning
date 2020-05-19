package com.wangming.algorithm.dataStructure;

/**
 * 递归
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-08-21 17:49
 */
public class Day7_Recursion_Test_1 {


    /**
     * 描述：打印问题1
     *
     * @auther MaiZi
     * @date 2019-08-30 15:36
     */

    public static void recursionTest1(int n) {
        if (n > 2) {
            //下面的代码不会执行，会立马开辟栈：recursionTest1(3)
            recursionTest1(n - 1);
        }
        System.out.println("n:" + n);

    }

    /**
     * 描述：打印问题2
     *
     * @auther MaiZi
     * @date 2019-08-30 15:36
     */
    public static void recursionTest2(int n) {
        if (n > 2) {
            recursionTest2(n - 1);
        } else {
            System.out.println("n:" + n);
        }
    }

    /*
     * 描述：阶乘问题1
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n; // 1 * 2 * 3
        }
    }


    /*
     * 描述：给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * 示例:
     *
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @auther MaiZi
     * @date 2019-08-30 16:06
     */
    public static int addDigits(int num) {

        System.out.println("入参>" + num);
        if (num < 10) {
            return num;
        }

        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num = num / 10;
        }
        System.out.println("本次总计:" + sum);
        return addDigits(sum);

    }


    /*
     * 描述：给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * 示例:
     *
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *  除了传统的单纯循环，还可以找规律。
     * 假如一个三位数'abc'，其值大小为s1 = 100 * a + 10 * b + 1 * c，
     * 经过一次各位相加后，变为s2 = a + b + c，
     * 减小的差值为(s1 -s2) = 99 * a + 9 * b，
     * 差值可以被9整除，每一个循环都这样，缩小了9的倍数。
     * 当num小于9，即只有一位时，直接返回num，大于9时，
     * 如果能被9整除，则返回9（因为不可能返回0也不可能返回两位数及以上的值），
     * 如果不能被整除，就返回被9除的余数。
     *
     * @auther MaiZi
     * @date 2019-08-30 16:42
     */
    public static int addDigits1(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }


    public static void main(String[] args) {
        //recursionTest1(4);
        //recursionTest2(4);
        //System.out.println(factorial(10));
        //System.out.println(addDigits1(1234));


    }
}
