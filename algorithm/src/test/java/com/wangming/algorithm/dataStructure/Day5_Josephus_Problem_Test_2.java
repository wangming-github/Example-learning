package com.wangming.algorithm.dataStructure;


import org.junit.Before;
import org.junit.Test;

public class Day5_Josephus_Problem_Test_2 {

    Day5_ListNode head = new Day5_ListNode(1);

    @Before
    public void before() {
        Day5_ListNode node2 = new Day5_ListNode(2);
        Day5_ListNode node3 = new Day5_ListNode(3);
        Day5_ListNode node4 = new Day5_ListNode(4);
        Day5_ListNode node5 = new Day5_ListNode(5);

        Day5_ListNode node6 = new Day5_ListNode(6);
        Day5_ListNode node7 = new Day5_ListNode(7);
        Day5_ListNode node8 = new Day5_ListNode(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node2;


    }

    /*
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 思路
     * 利用快慢指正，快的走两步，慢的走一步。如果存在环形链表，快指针就能追上慢指针。
     */
    @Test
    public void hasCycle() {
        boolean b = false;
        Day5_ListNode temp_slow = head;
        Day5_ListNode temp_fast = head;
        while (temp_fast != null && temp_fast.next != null) {
            temp_slow = temp_slow.next;
            temp_fast = temp_fast.next.next;
            if (temp_slow == temp_fast) {
                b = true;
                break;
            }

        }
        System.out.println("是否为环形链表：" + b);
    }

    /*
     *
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 说明：不允许修改给定的链表。
     *
     *
     *
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void detectCycle() {
        boolean b = false;
        Day5_ListNode slow = head;
        Day5_ListNode fast = head;

        /*
         * 1.先利用快慢指针追赶法判断是否存在环
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                b = true;
                break;
            }
        }

        /*
         * 2.存在环
         *         7 ← 6 ← 5
         *         ↓       ↑
         * 0 → 1 → 2 → 3 → 4
         *
         * 快慢指针思路:
         * 如果有环，不妨设表头为 A ,环起点为B ，相遇点为C。
         * 注意到快指针路程必为慢指针两倍
         * 慢指针路程为 AB + BC
         * 快指针路程为 AB + BC + CB +BC == 2（AB + BC）
         * #(有向线段 CB!=BC) 可知 AB = CB
         * 故快慢指针相遇后， 可令一新慢指针 由表头出发，两慢指针必相遇于环起点
         * # 另稍需注意 AB可能重合
         */
        if (b) {
            fast = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            System.out.println("有环!第一位是:" + fast);
        } else {
            System.out.println("没环形....");
        }

    }


}


//这种方法存在一个bug：就是两个指针相遇时不一定在环起点，可能出现在任意环内的任意点上
//while (true) {
//    if (fast == slow) {
//        System.out.println("有环!第一位是:" + fast.next);
//    }
//    slow = slow.next;
//    fast = fast.next;
//}
