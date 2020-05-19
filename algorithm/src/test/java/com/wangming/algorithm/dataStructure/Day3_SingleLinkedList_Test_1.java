package com.wangming.algorithm.dataStructure;

/**
 * 链表结构特点：
 * ............................链表内存结构图.............................
 * .                                                                  .
 * .        头结构                  地址      data域   next域            .
 * .       _______                         _______ _______            .
 * . head |  150  |                110    |  a2   |  130  |           .
 * .      |_______|                       |_______|_______|           .
 * .                               140    |       |       |           .
 * .                                      |_______|_______|           .
 * .                               100    |  a5   |  120  |           .
 * .                                      |_______|_______|           .
 * .                               180    |  a4   |  100  |           .
 * .                                      |_______|_______|           .
 * .                               120    |  a6   |  NULL |           .
 * .                                      |_______|_______|           .
 * .                               160    |       |       |           .
 * .                                      |_______|_______|           .
 * .                               150    |  a1   |  110  |           .
 * .                                      |_______|_______|           .
 * .                               130    |  a3   |  180  |           .
 * .                                      |_______|_______|           .
 * ....................................................................
 * 1) 链表是以节点的方式来存储,是链式存储.
 * 2) 每个节点包含 data域;next域:指向下一个节点.
 * 3) 如图(链表内存结构图):发现链表的各个节点不一定是连续存储.
 * 4) 链表分带头节点的链表和没有头节点的链表，根据实际的需求来确定.
 * <p>
 * 单链表(带头结点) 逻辑结构示意图如下
 * .............................................单链表(带头结点) 逻辑结构示意图....................................................
 * .                                                                                                                        .
 * .           ________ ______           ________ ______           ________ ______                      ________ ______     .
 * .          |        |      |         |        |      |         |        |      |                    |        |      |    .
 * .    head->|   head |   ---|-------->|   a1   |   ---|-------->|   a2   |   ---|----->  ····  ----->|   an   |  ^   |    .
 * .          |________|______|         |________|______|         |________|______|                    |________|______|    .
 * .                                                                                                                        .
 * ..........................................................................................................................
 * 1)head：头节点，不存放数据，表示单链表的头。
 */

/**
 * 问题
 * 使用带 head 头的单向链表实现 –水浒英雄排行榜管理完成对英雄人物的增删改查操作， 注: 删除和修改,查找
 * 思路:
 * 1>>> 第一种方法在添加英雄时，直接添加到链表的尾部 思路分析示意图:
 * >>>1.添加创建
 * >>>1.1.先创建一个head头节点，作用就是表示单链表的头。
 * >>>1.2.后面每添加一个节点，就添加在链表的最后。
 * >>>2.遍历
 * >>>2.1.通过一个辅助变量遍历整个链表
 * .
 * 2>>> 第二种方式在添加英雄时，根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示) 思路的分析示意图:
 * 思路:
 * >>>1.找到添加节点的位置，通过辅助变量(temp)。找到条件: temp.next.id > newHeroNode.id
 * >>>2.让 新的节点的next域 指向 辅助变量的next域:newNode.next  ==指向==> tempNode.next
 * >>>3.让 temp的next域   指向 新的节点        tempNode.next ==指向==>  newNode
 * .
 * 3>>>修改节点功能
 * 思路:
 * >>>1.先找到该节点，通过遍历。找到条件: temp.id == 修改节点.id
 * >>>2.temp.name = newHeroNode.name; temp.nickname= newHeroNode.nickname
 * .
 * 4>>>删除节点
 * >>>1.先找到该节点，通过遍历。找到条件: temp.next.id == 删除id
 * >>>2.将该节点的next域跳过删除节点指向下下一个节点。temp.next = temp.next.next;
 */
public class Day3_SingleLinkedList_Test_1 {

    //测试单向链表
    public static void main(String[] args) {
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "卢勇", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //无序添加
        //singleLinkedList.add(heroNode1);
        //singleLinkedList.add(heroNode4);
        //singleLinkedList.add(heroNode2);
        //singleLinkedList.add(heroNode3);

        //有序添加
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);

        System.out.println("修改前：");
        singleLinkedList.list();
        //修改
        HeroNode updateHeroNode2 = new HeroNode(2, "小卢", "小玉");
        singleLinkedList.update(updateHeroNode2);
        System.out.println("修改后：");
        singleLinkedList.list();

        singleLinkedList.delete(1);
        singleLinkedList.deleteV2(heroNode2);

        System.out.println("删除后：");
        singleLinkedList.list();

    }
}

//创建单链表
//定义SingleLinkedList管理我们的英雄
class SingleLinkedList {

    //1.初始化头节点，头节点不要动。不存放具体数据
    public HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //2.添加节点到单向链表
    //思路:（不考虑编号顺序）
    //2.1.先找到最后节点
    //2.2.把最后节点的next域指向新的节点
    public void add(HeroNode newHeroNode) {
        //需要一个辅助节点 temp，因为头节点不能动。
        //将temp指向头节点。
        HeroNode temp = head;
        //遍历链表指向最后
        while (true) {
            //找到最后,结束。
            if (temp.next == null) {
                break;
            }
            //当退出while循环时，temp指向了链表的最后
            //没有找到最后
            temp = temp.next;
        }
        //将最后节点的next域指向新的节点。
        temp.next = newHeroNode;
    }


    public void addByOrder(HeroNode newHeroNode) {
        //创建一个临时变量 temp ，存储当前遍历到的节点信息
        //创建 canInsert 用来保存是否可以插入

        //1、将 temp 指向单链表头
        //2、遍历整个链表
        //3、找到要插入的位置。

        boolean canInsert = true;//默认位置存在
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {//链表不存在元素
                break;
            }
            if (temp.next.id > newHeroNode.id) { //找到当前位置了在【temp】和【temp.next】之间
                break;
            }
            if (temp.next.id == newHeroNode.id) {//id已经存在
                canInsert = false;
                break;
            }
            temp = temp.next;
        }

        if (canInsert) {
            newHeroNode.next = temp.next;
            temp.next = newHeroNode;
        } else {
            System.out.println(newHeroNode.id + "已经存在");
        }
    }


    //思路就是把下一个节点的值赋给当前节点，然后将当前节点指向下下个节点
    public void deleteV2(HeroNode node) {
        node.id = node.next.id;
        node.name = node.next.name;
        node.nickName = node.next.nickName;
        node.next = node.next.next;
    }


    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个 temp 辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是 temp.next.id 和 需要删除的节点的 id 比较
    public void delete(int id) {

        if (head.next == null) {
            System.out.println("节点为空!");
            return;
        }

        HeroNode temp = head;
        boolean flag = false;//是否找到了删除节点
        while (true) {
            if (temp.next == null) {//节点遍历完成
                break;
            }

            if (temp.next.id == id) {//找到了
                flag = true;
                break;
            }
            temp = temp.next; //后移 实现遍历
        }

        if (flag) {
            temp.next = temp.next.next;
            //下面这个判断，多此一举，
            //temp.next.next 为NULL 那个next域自动为空
            //if (temp.next.next == null) {
            //    temp.next = null;
            //} else {
            //    temp.next = temp.next.next;
            //}
        } else {
            System.out.println("没有找到删除的节点:" + id);
        }

    }




    public Day5_ListNode removeElements(Day5_ListNode head, int val) {
        Day5_ListNode header = new Day5_ListNode(-1);
        header.next = head;
        Day5_ListNode temp = header;
        while(temp.next != null){
            if(temp.next.val == val ){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return header.next;
    }

    //根据ID修改节点信息，ID不能修改
    //根据updateHeroNode的id进行修改
    public void update(HeroNode updateHeroNode) {

        if (head.next == null) {
            System.out.println("链表为空!");
            return;
        }

        HeroNode temp = head;
        boolean flag = false;

        while (true) {

            if (temp == null) {//链表遍历结束....
                break;
            }

            if (temp.id == updateHeroNode.id) {//找到了
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if (flag) {
            temp.name = updateHeroNode.name;
            temp.nickName = updateHeroNode.nickName;
        } else {
            System.out.println("没有找到编号为" + updateHeroNode.id + "的节点！");
        }

    }


    //3.显示[遍历]单向链表
    public void list() {
        //当链表为空时直接退出
        if (head.next == null) {
            System.out.println("头节点为空!");
            return;
        }

        //当链表不为空时，头节点不能动，需要一个辅助变量来遍历
        HeroNode temp = head.next;//上一步的结果，链表最少有一个数据
        while (true) {
            //是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移，不后移还是死循环
            temp = temp.next;
        }
    }


}

//定义一个Hero节点，每个Hero对象就是一个Hero节点。
class HeroNode {
    public int id;//编号(数据)
    public String name;//名字(数据)
    public String nickName;//昵称(数据)
    public HeroNode next;//指向下一个节点的属性(next)，最后一个为NULL即结束。

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
