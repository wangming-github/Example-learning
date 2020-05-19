package com.wangming.algorithm.dataStructure;


import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * 单链表的常见面试题有如下:
 * 1) 求单链表中有效节点的个数
 * 2) 查找单链表中的倒数第k个结点【新浪面试题】
 * 3) 单链表的反转【腾讯面试题，有点难度】
 * 4) 从尾到头打印单链表【百度，要求方式1:反向遍历。方式2:Stack栈】
 * 5) 合并两个有序的单链表，合并之后的链表依然有序【课后练习.】
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-07-26 10:10
 */
public class Day3_SingleLinkedList_Test_QA_3 {

    static Day5_ListNode node1 = new Day5_ListNode(1);
    static Day5_ListNode copy_node_q1 = null;
    static Day5_ListNode copy_node_q2 = null;
    static Day5_ListNode copy_node_q3 = null;


    @Before
    public void before() {

        Day5_ListNode node2 = new Day5_ListNode(2);
        Day5_ListNode node3 = new Day5_ListNode(3);
        Day5_ListNode node4 = new Day5_ListNode(4);
        Day5_ListNode node5 = new Day5_ListNode(5);

        Day5_ListNode node6 = new Day5_ListNode(6);
        Day5_ListNode node7 = new Day5_ListNode(7);
        Day5_ListNode node8 = new Day5_ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;


        //复制原链表头
        copy_node_q1 = node1;
        copy_node_q2 = node1;

        //System.out.println("原始:");
        //while (node1 != null) {
        //    System.out.print(node1);
        //    node1 = node1.next;
        //}
        //System.out.println();
    }

    //从尾到头打印单链表
    //1.方法1 先反转在打印，会破坏原链表结构 不建议
    //2.方法2 Stack栈数据结构 将各个节点压入到占中 利用栈的先进后出的特点 实现逆序打印

    @Test
    public void reversePrintNode_v1() {
        /*
         ***************************************************
         *    h
         * 1. ①--->②--->③--->④--->⑤--->null
         *          n
         *
         *    h
         * 2. ①--->null      ②--->③--->④--->⑤--->null
         *           p        n
         *
         *    h
         * 3. ①--->null      ②--->③--->④--->⑤--->null
         *    p               n
         *
         *                    h
         * 4. ①--->null      ②--->③--->④--->⑤--->null
         *    p               n
         ***************************************************
         *                    h
         * 1. ①--->null      ②--->③--->④--->⑤--->null
         *    p                    n
         *
         *    h
         * 2. ②--->①--->null      ③--->④--->⑤--->null
         *          p              n
         *
         *    h
         * 3. ②--->①--->null      ③--->④--->⑤--->null
         *    p                    n
         *
         *                         h
         * 4. ②--->①--->null      ③--->④--->⑤--->null
         *    p                    n
         ***************************************************
         *                         h
         * 1. ②--->①--->null      ③--->④--->⑤--->null
         *    p                          n
         *
         *    h
         * 2. ③--->②--->①--->null      ④--->⑤--->null
         *          p                    n
         *
         *    h
         * 3. ③--->②--->①--->null      ④--->⑤--->null
         *    p                          n
         *
         *                               h
         * 4. ③--->②--->①--->null      ④--->⑤--->null
         *    p                          n
         ***************************************************
         *                               h
         * 1. ③--->②--->①--->null      ④--->⑤--->null
         *    p                               n
         *
         *    h
         * 2. ④--->③--->②--->①--->null      ⑤--->null
         *          p                          n
         *
         *    h
         * 3. ④--->③--->②--->①--->null      ⑤--->null
         *    p                                n
         *
         *                                     h
         * 4. ④--->③--->②--->①--->null      ⑤--->null
         *    p                                n
         ***************************************************
         *                                     h
         * 1. ④--->③--->②--->①--->null      ⑤--->null
         *    p                                      n
         *
         *    h
         * 2. ⑤--->④--->③--->②--->①--->null      null
         *          p                                n
         *
         *    h
         * 3. ⑤--->④--->③--->②--->①--->null      null
         *    p                                      n
         *
         *                                           h
         * 4. ⑤--->④--->③--->②--->①--->null      null
         *    p                                      n
         ***************************************************
         */
        Day5_ListNode head = copy_node_q1;

        Day5_ListNode per = null;
        Day5_ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = per;
            per = head;
            head = next;
        }

        while (per != null) {
            System.out.print(per);
            per = per.next;
        }

    }

    @Test
    public void reversePrintNode_v2() {

        Stack<Day5_ListNode> nodeStack = new Stack<Day5_ListNode>();
        Day5_ListNode head = copy_node_q2;
        while (head != null) {
            nodeStack.push(head);//add
            head = head.next;
        }

        while (nodeStack.size() > 0) {
            System.out.print(nodeStack.pop());
        }
    }


    /*
     *  5) 合并两个有序的单链表，合并之后的链表依然有序【课后练习.】
     * 思路流程
     ***************************************************************************
     *
     *           p           h1                        h2
     *          〇--->       ①--->②--->⑤--->⑦--->⑨   ③--->④--->⑦--->⑧--->⑨
     *          PP                n1                        n2
     *
     *          p    h1                                h2
     * h1 < h2  〇--->①           ②--->⑤--->⑦--->⑨   ③--->④--->⑦--->⑧--->⑨
     *          PP                n1                        n2
     *
     *               p=h1                              h2
     *          〇--->①           ②--->⑤--->⑦--->⑨   ③--->④--->⑦--->⑧--->⑨
     *          PP                n1                        n2
     *
     *                p           h1                   h2
     *          〇--->①           ②--->⑤--->⑦--->⑨   ③--->④--->⑦--->⑧--->⑨
     *          PP                n1                        n2
     ***************************************************************************
     *               p            h1                   h2
     * h1 < h2  〇--->①           ②--->⑤--->⑦--->⑨   ③--->④--->⑦--->⑧--->⑨
     *          PP                      n1                  n2
     *
     *               p     h1                          h2
     * h1 < h2  〇--->①--->②           ⑤--->⑦--->⑨   ③--->④--->⑦--->⑧--->⑨
     *          PP                      n1                  n2
     *
     *                    p/h1                          h2
     * h1 < h2  〇--->①--->②           ⑤--->⑦--->⑨   ③--->④--->⑦--->⑧--->⑨
     *          PP                      n1                  n2
     *
     *                     p            h1              h2
     * h1 < h2  〇--->①--->②           ⑤--->⑦--->⑨   ③--->④--->⑦--->⑧--->⑨
     *          PP                      n1                  n2
     ***************************************************************************
     *
     *                     p    h2      h1
     * h2 < h1  〇--->①--->②--->③      ⑤--->⑦--->⑨   ④--->⑦--->⑧--->⑨
     *          PP                      n1              n2
     *
     *                         p/h2     h1
     * h2 < h1  〇--->①--->②--->③      ⑤--->⑦--->⑨   ④--->⑦--->⑧--->⑨
     *          PP                      n1              n2
     *
     *                           p      h1              h2
     * h2 < h1  〇--->①--->②--->③      ⑤--->⑦--->⑨   ④--->⑦--->⑧--->⑨
     *          PP                      n1              n2
     ***************************************************************************
     */
    public Day5_ListNode mergeTwoLists(Day5_ListNode l1, Day5_ListNode l2) {

        Day5_ListNode p = new Day5_ListNode(0);
        Day5_ListNode PP = p;
        Day5_ListNode nextl1 = null;
        Day5_ListNode nextl2 = null;

        while ((l1 != null) && (l2 != null)) {

            if (l1.val < l2.val) {
                nextl1 = l1.next;
                p.next = l1;
                p = p.next;
                l1 = nextl1;
            } else {
                nextl2 = l2.next;
                p.next = l2;
                p = p.next;
                l2 = nextl2;
            }
        }

        if (l1 == null) {
            p.next = l2;
        }
        if (l2 == null) {
            p.next = l1;
        }

        return PP.next;
    }
}
