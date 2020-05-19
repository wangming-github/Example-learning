package com.wangming.algorithm.dataStructure;

import org.junit.Before;
import org.junit.Test;


class Solution {

    /*
     * Q1:
     * 描述：反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @auther MaiZi
     * @date 2019-08-01 15:57
     */
    public static Day5_ListNode reverseList(Day5_ListNode head) {

        Day5_ListNode pre = null;  //上一个节点 或者 理解为新节点的第一个位置
        Day5_ListNode next = null; //下一个节点

        while (head != null) {
            next = head.next;//临时节点，暂存当前节点的下一节点，用于后移
            head.next = pre; //将当前指针指向的节点由他原本的变为新的 pre
            pre = head;      //前指针 pre 指向刚才 curr 的新的移动过来的元素位置
            head = next;     //curr 又刚才移动元素的位置后移到刚才next的位置
        }

        return pre;
    }


    /*
     * Q2:
     * 描述：反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
     *
     * Java 1ms，时间空间均90+。
     * 实现思路 ：以1->2->3->4->5, m = 2, n=4 为例:
     * 1.定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
     * 2.当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
     * 3.当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
     * 1->4->3->2->5.
     *
     * @auther MaiZi
     * @date 2019-08-01 15:55
     */
    public static Day5_ListNode reverseBetween(Day5_ListNode head, int m, int n) {

        /*
         * 思路就是
         * 将反转链表的第一个位置节点找出来 将它后面的节点放在他的前面
         * 而且不能断链表 不能断就需要将 后面链表的后面那个和第一个位置拼接起来 前驱不部分和反转第一个元素拼接起来
         * 指针每次指向反转部分的第一个位置的下一个位置。
         * 再将第一个位置和下下一个位置拼接
         * 似乎明白了一些东西
         * 断开的链表必须有一个指针指向它的头
         * 要插入的位置也要有一个直线指向其
         * 整个链表也要有一个指针指向头
         * 其次 XXX.next  =  head.next
         * 等号前面的next把他当做一条线去连接谁 而不是想成一个对象
         * 等号后面next把他当做一个节点 而不是一个线
         *
         *    p     h
         * 1. ①--->②--->③--->④--->⑤
         *
         *    p     h
         * 2. ①--->②--->③--->④--->⑤
         *               n
         *
         *    p     h
         * 3. ①--->②--->④--->⑤    ③--->
         *               nn         n
         *
         *    p              h
         * 4. ①--->    ③--->②--->④--->⑤
         *              n
         *
         *    p          h
         * 5. ①--->③--->②--->④--->⑤
         *          n
         *
         * 1.找出开始反转节点的第一个节点 ② 声明为头结点h
         * 2.找出头结点的下一个节点 ③ 声明为 n
         * 3.将h头结点指向 n的下一个节点
         * 4.将 n节点指向头结点
         * 5.将前驱节点指向n结点
         * 经过上面的步骤：
         * ①--->②--->③--->④--->⑤
         * ①--->③--->②--->④--->⑤
         * 此时我们的h依然为2 p依然为1 n循环变量在替换
         *
         *
         *    p          h
         * 6. ①--->③--->②--->④--->⑤
         *                     n
         *
         *    p          h
         * 7. ①--->③--->②--->⑤    ④--->
         *                          n
         *
         *    p                    h
         * 8. ①--->    ④--->③--->②--->⑤
         *              n
         *
         *    p                h
         * 9. ①--->④--->③--->②--->⑤
         *          n
         *
         * 经过上面的步骤已经反转不部分链表完成，整个流程
         * ①--->②--->③--->④--->⑤
         * ①--->③--->②--->④--->⑤
         * ①--->④--->③--->②--->⑤
         */


        Day5_ListNode node = new Day5_ListNode(0);
        node.next = head;
        Day5_ListNode per = node;
        for (int i = 1; i < m; i++) {
            per = per.next;
        }
        head = per.next;

        Day5_ListNode next = null;
        for (int i = m; i < n; i++) {
            next = head.next;
            head.next = next.next;
            next.next = per.next;
            per.next = next;
        }

        return node.next;
    }

}

public class Day3_SingleLinkedList_Test_QA_2 {

    static Day5_ListNode node1 = new Day5_ListNode(1);
    static Day5_ListNode copy_node_q1 = null;
    static Day5_ListNode copy_node_q2 = null;


    @Before
    public void before() {

        Day5_ListNode node2 = new Day5_ListNode(2);
        Day5_ListNode node3 = new Day5_ListNode(3);
        Day5_ListNode node4 = new Day5_ListNode(4);
        Day5_ListNode node5 = new Day5_ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        //复制原链表头
        copy_node_q1 = node1;
        copy_node_q2 = node1;

        System.out.println("原始:");
        while (node1 != null) {
            System.out.print(node1);
            node1 = node1.next;
        }
        System.out.println();


    }

    @Test
    public void test1() {
        System.out.println("Q1描述：反转一个单链表。:");
        Day5_ListNode newNode_q1 = Solution.reverseList(copy_node_q1);
        while (newNode_q1 != null) {
            System.out.print(newNode_q1);
            newNode_q1 = newNode_q1.next;
        }
    }

    @Test
    public void test2() {
        System.out.println();
        System.out.println("Q2描述：反转从位置 2 到 4 的链表。请使用一趟扫描完成反转:");
        Day5_ListNode newNode_q2 = Solution.reverseBetween(copy_node_q2, 2, 4);
        while (newNode_q2 != null) {
            System.out.print(newNode_q2);
            newNode_q2 = newNode_q2.next;
        }
    }


}

