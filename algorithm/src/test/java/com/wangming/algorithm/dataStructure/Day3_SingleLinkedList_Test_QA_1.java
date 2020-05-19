package com.wangming.algorithm.dataStructure;

import org.junit.Before;
import org.junit.Test;

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
public class Day3_SingleLinkedList_Test_QA_1 {

    //创建链表
    SingleLinkedList singleLinkedList = new SingleLinkedList();

    //测试单向链表
    @Before
    public void before() {
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "卢勇", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode heroNode5 = new HeroNode(5, "史进", "九纹龙");
        //HeroNode heroNode6 = new HeroNode(6, "朱武", "神机军师");
        //HeroNode heroNode7 = new HeroNode(7, "陈达", "跳涧虎");
        //HeroNode heroNode8 = new HeroNode(8, "杨春", "白花蛇");
        //HeroNode heroNode9 = new HeroNode(9, "鲁智深", "花和尚");
        //HeroNode heroNode10 = new HeroNode(10, "李忠", "打虎将");
        //HeroNode heroNode11 = new HeroNode(11, "周通", "小霸王");
        //HeroNode heroNode12 = new HeroNode(12, "燕顺", "锦毛虎");
        //HeroNode heroNode13 = new HeroNode(13, "柴进", "小旋风");
        //HeroNode heroNode14 = new HeroNode(14, "朱贵", "旱地忽律");
        //HeroNode heroNode15 = new HeroNode(15, "杜迁", "摸着天");
        //HeroNode heroNode16 = new HeroNode(16, "宋万", "云里金刚");
        //HeroNode heroNode17 = new HeroNode(17, "杨志", "青面兽");
        //HeroNode heroNode18 = new HeroNode(18, "索超", "急先锋");
        //HeroNode heroNode19 = new HeroNode(19, "朱仝", "美髯公");
        //HeroNode heroNode20 = new HeroNode(20, "王英", "矮脚虎");


        //有序添加
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode5);
        //singleLinkedList.addByOrder(heroNode6);
        //singleLinkedList.addByOrder(heroNode8);
        //singleLinkedList.addByOrder(heroNode7);
        //singleLinkedList.addByOrder(heroNode9);
        //singleLinkedList.addByOrder(heroNode10);
        //singleLinkedList.addByOrder(heroNode13);
        //singleLinkedList.addByOrder(heroNode11);
        //singleLinkedList.addByOrder(heroNode12);
        //singleLinkedList.addByOrder(heroNode14);
        //singleLinkedList.addByOrder(heroNode15);
        //singleLinkedList.addByOrder(heroNode16);
        //singleLinkedList.addByOrder(heroNode17);
        //singleLinkedList.addByOrder(heroNode18);
        //singleLinkedList.addByOrder(heroNode19);
        //singleLinkedList.addByOrder(heroNode20);

        singleLinkedList.list();
    }


    /*
     * 描述：求单链表中有效节点的个数
     * 如果是头节点的链表不需要统计头节点
     * node:链表头
     */
    public static int getNodeLength(HeroNode headNode) {

        int nodeLength = 0;

        if (headNode.next == null) {
            System.out.println("链表为空!");
            return nodeLength;
        }

        //声明临时变量用于遍历，不统计头节点，临时变量默认指向头节点的下个节点。
        HeroNode temp = headNode.next;
        //写法1
        //while (true) {
        //    if (temp == null) {//链表遍历结束
        //        break;
        //    }
        //
        //    nodeLength++;
        //    temp = temp.next;
        //}

        //写法2
        while (temp != null) {
            nodeLength++;
            temp = temp.next;
        }

        return nodeLength;
    }

    @Test
    public void test1() {
        System.out.println("链表有效数据为:" + getNodeLength(singleLinkedList.getHead()));
    }

    /*
     *
     * 描述：2) 查找单链表中的倒数第k个结点
     * 思路：
     * 1.传进来链表的头节点,和倒数的节点位置
     * 2.倒序遍历节点信息（但是是单链表不能逆向遍历）/计算倒序节点是正序是第几个节点:(有效节点个数-倒序index)=正序节点个数
     * 3.找出第N个节点 找到返回 没找到null
     */
    public static HeroNode getNodeByKeyDESC(HeroNode headNode, int indexDESC) {

        if (headNode.next == null) {
            return null;
        }

        //1.计算倒序节点正序时的位置
        int length = getNodeLength(headNode);
        if ((indexDESC <= 0) || (length < indexDESC)) {
            System.out.println(indexDESC + "节点不存在！");
            return null;
        }


        //2.找出第N个节点
        HeroNode temp = headNode.next;

        //写法1
        //int i = 0;
        //while (true) {
        //    if (temp == null) {//1.计算倒序节点正序时的位置时做了判断
        //        break;
        //    }
        //    if (i == indexESC) {
        //        break;
        //    }
        //    i++;
        //    temp = temp.next;
        //}


        //写法2
        int indexESC = length - indexDESC;
        for (int i = 0; i < indexESC; i++) {
            temp = temp.next;
        }
        System.out.println("倒数第 " + indexDESC + " (" + indexESC + ") 个节点:" + temp);
        return temp;
    }

    @Test
    public void test2() {
        getNodeByKeyDESC(singleLinkedList.getHead(), 20);
    }


    /*
     *
     * 描述：3)单链表的反转【腾讯面试题，有点难度】
     * 自拟思路：
     * 1.获取要翻转的链表长度
     * 2.获取到最后一个节点的 temp1 ，将头节点(head)指向 temp1
     * 3.在获取最后第二个节点 temp2 ，将第一个节点(temp1)指向 temp2
     * 4.在获取最后第三个节点 temp3 ，将第二个节点(temp1)指向 temp3
     * 5.......类推，取到length个为止。
     * 6.此时原先单向链表已经完成翻转。
     *
     *
     *
     *
     *
     */
    public HeroNode getNodeOverturn(HeroNode head) {


        //v1.0
        ////如果当前链表为空或者有且仅有一个节点 无需翻转
        //if ((head.next == null) || head.next.next == null) {
        //    return null;
        //}
        //
        ////1.创建一个新链表的head
        //HeroNode newNodeHead = new HeroNode(0, "", "");
        ////2.声明临时变量[temp]用于遍历原始链表;
        //HeroNode temp = head.next;
        ////3.声明next用于指向当前节点[temp]的下一个节点;
        //HeroNode next = null;
        ////遍历原来的链表，每遍历到一个节点就将其取出放在新链表newNodeHead的最前端。
        //while (temp != null) {
        //    next = temp.next; //先保存,当前节点的下一个节点,因为后面有用
        //    temp.next = newNodeHead.next; //将temp下一个节点 指向新的链表的最前端
        //    newNodeHead.next = temp;
        //    temp = next;//让temp后移
        //}
        //head.next = newNodeHead.next;


        //v2.0熟悉了反转链表之后
        HeroNode pre = null;
        HeroNode curr = head.next;//传递进来的链表也是默认带头的，所以从不带头的开始
        HeroNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 因为是带头的 需要声明一个空的链表头
        HeroNode newNodeHead = new HeroNode(0, "", "");
        newNodeHead.next = pre;
        return newNodeHead;
    }

    @Test
    public void test3() {
        System.out.println("单链表的反转【腾讯面试题，有点难度】结果如下：");
        HeroNode head = getNodeOverturn(singleLinkedList.getHead());
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }


}


