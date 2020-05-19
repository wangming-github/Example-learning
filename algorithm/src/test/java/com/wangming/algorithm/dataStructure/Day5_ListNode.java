package com.wangming.algorithm.dataStructure;


/**
 * 单链表的常见面试题有如下:
 * 1) 反转一个单链表。
 * 2) 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
public class Day5_ListNode {

    int val;
    Day5_ListNode next;

    Day5_ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + "--->";
    }

}
