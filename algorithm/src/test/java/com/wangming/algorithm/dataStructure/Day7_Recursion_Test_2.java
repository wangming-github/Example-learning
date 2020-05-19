package com.wangming.algorithm.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-08-21 17:49
 */
public class Day7_Recursion_Test_2 {


    /**
     * 描述：递归-迷宫问题
     *
     * @auther MaiZi
     * @date 2019-09-02 10:17
     */

    public static void labyrinth() {
        //创建二维数组模拟迷宫
        int[][] map = new int[8][7];

        //使用1表示墙
        //上下墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //挡板
        map[3][1] = 1;
        map[3][2] = 1;


        System.out.println("====输出迷宫====");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        getWay_v2(map, 1, 1);

        System.out.println("====输出迷宫====");
        //输出迷宫
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /*
     * 描述：使用递归回溯走出迷宫 找到返回true
     *
     * 1.map 地图
     * 2.i j 开始位置 出发点[1,1]
     * 3.小球到达 [6,5]表示位置找到
     * 4.当map[i][j] = :  0的时候表示没有走过，1的时候为墙，2的时候通路，3的时候表示已经走过但是走不通
     * 5.走迷宫时需要确定的策略:下->右->上->左 如果走不通就回溯
     *
     *
     *
     * @auther MaiZi
     * @date 2019-09-02 10:28
     */
    public static boolean getWay_v1(int[][] map, int i, int j) {

        if (map[6][5] == 2) {//1.先定义条件何时找到出口
            return true;
        } else {

            if (map[i][j] == 0) {//2.如果当前的点没有走过，按照策略走
                map[i][j] = 2;//3.难点：先假定该点可以走通，到底能不能走通需要按照策略走一次。

                if (getWay_v1(map, i + 1, j)) {//向下走
                    return true;
                } else if (getWay_v1(map, i, j + 1)) {//向右走
                    return true;
                } else if (getWay_v1(map, i - 1, j)) {//向上走
                    return true;
                } else if (getWay_v1(map, i, j - 1)) {//向左走
                    return true;
                } else { //4.说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }

            } else {//5.map[i][j]不等于0,等于1墙不能走，2走过了不能走，3死路，false
                return false;
            }

        }
    }

    /**
     * 描述：使用递归回溯走出迷宫 求最短路径
     * 修改找路的策略，改成 上->右->下->左
     *
     * @auther MaiZi
     * @date 2019-09-02 15:51
     */
    public static boolean getWay_v2(int[][] map, int i, int j) {

        if (map[6][5] == 2) {//1.先定义条件何时找到出口
            return true;
        } else {

            if (map[i][j] == 0) {//2.如果当前的点没有走过，按照策略走
                map[i][j] = 2;//3.难点：先假定该点可以走通，到底能不能走通需要按照策略走一次。

                if (getWay_v2(map, i - 1, j)) {//向上走
                    return true;
                } else if (getWay_v2(map, i, j + 1)) {//向右走
                    return true;
                } else if (getWay_v2(map, i + 1, j)) {//向下走
                    return true;
                } else if (getWay_v2(map, i, j - 1)) {//向左走
                    return true;
                } else { //4.说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }

            } else {//5.map[i][j]不等于0,等于1墙不能走，2走过了不能走，3死路，false
                return false;
            }

        }
    }


    public static void quanPaiLie(String data[], int k) {

        if (k == data.length) {
            StringBuffer celue = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = k; i < data.length; i++) {
            {
                String temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }

            quanPaiLie(data, k + 1);
            {
                String temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String[] chars = new String[]{"上", "下", "左", "右", "东", "西"};
        Map<String, Integer> result = new HashMap<>();
        quanPaiLie(chars, 0);

    }
}
