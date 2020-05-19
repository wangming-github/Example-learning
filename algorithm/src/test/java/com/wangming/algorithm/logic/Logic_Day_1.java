package com.wangming.algorithm.logic;

import org.junit.Test;

/**
 * @version V7.0
 * @auther WangMing
 * @date 2019-07-05 16:58
 * @description
 */
public class Logic_Day_1 {


    @Test
    public void Test1() {

        boolean a = true;
        boolean b = false;

        //&,&&,|,||,! ^

        System.out.println(a & b);
        System.out.println(a && b);
        System.out.println(a | b);
        System.out.println(a || b);
        System.out.println(!a | b);
        System.out.println(a ^ b);//相异


        //逻辑& 和短路&&的区别
    }


    //逻辑& 和短路&&的区别
    @Test
    public void Test2() {

        boolean a = true;
        boolean b = false;

        int i = 1;
        int j = 1;

        if (b & (i++) > 0) {
            System.out.println("天气不错");
        } else {
            System.out.println("今天下雨");
        }
        //&不管左边是true还是false，右边都会计算
        //|不管左边是true还是false，右边都会计算
        System.out.println(i);

        if (b && (j++) > 0) {
            System.out.println("天气不错");
        } else {
            System.out.println("今天下雨");
        }

        //&& 当左边是false，右边不会计算 建议使用
        //|| 当左边是true，右边不会计算 建议使用
        System.out.println(j);


    }

}
