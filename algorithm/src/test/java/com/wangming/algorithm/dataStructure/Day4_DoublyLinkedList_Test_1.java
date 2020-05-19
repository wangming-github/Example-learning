package com.wangming.algorithm.dataStructure;

/**
 * 双向链表
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-08-09 17:25
 */

//创建双向链表类
class DoublyHeroNode {
    public int id;//编号(数据)
    public String name;//名字(数据)
    public String nickName;//昵称(数据)
    public DoublyHeroNode next;//指向下一个节点的属性(next)，最后一个为NULL即结束。
    public DoublyHeroNode pre;//指向下一个节点的属性(next)，最后一个为NULL即结束。

    public DoublyHeroNode(int id, String name, String nickName) {
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


/**
 * 描述：
 * 1) 遍历 方和 单链表一样，只是可以向前，也可以向后查找
 * 2) 添加 (默认添加到双向链表的最后)
 * (1) 先找到双向链表的最后这个节点
 * (2) temp.next = newHeroNode
 * (3) newHeroNode.pre = temp;
 * 3) 修改 思路和 原来的单向链表一样.
 * 4) 删除
 * (1) 因为是双向链表，因此，我们可以实现自我删除某个节点
 * (2) 直接找到要删除的这个节点，比如 temp
 * (3) temp.pre.next = temp.next
 * (4) temp.next.pre = temp.pre;
 */
class DoublyLinkedList {

    private DoublyHeroNode head = new DoublyHeroNode(0, "头节点", "头节点");

    public DoublyHeroNode getHead() {
        return head;
    }

    //1) 遍历
    public void list() {

        DoublyHeroNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //2) 添加
    public void add(DoublyHeroNode doublyListNode) {

        DoublyHeroNode temp = head;
        //找到最后一个节点 所以需要找到null的上一个
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = doublyListNode;
        doublyListNode.pre = temp;
    }

    //3) 修改和单向链表一样
    //根据ID修改节点信息，ID不能修改
    //根据updateHeroNode的id进行修改
    public void update(DoublyHeroNode updateDoublyHeroNode) {

        DoublyHeroNode temp = head;
        while (temp != null) {
            if (temp.id == updateDoublyHeroNode.id) {
                temp.name = updateDoublyHeroNode.name;
                temp.nickName = updateDoublyHeroNode.nickName;
            }
            temp = temp.next;
        }

    }

    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个 temp 辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是 temp.next.id 和 需要删除的节点的 id 比较
    public void delete(int id) {
        DoublyHeroNode temp = head;
        while (temp != null) {
            if (temp.id == id) {//找到了
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                System.out.println("删除:" + id);
                break;
            }
            temp = temp.next; //后移 实现遍历
        }
    }


}


public class Day4_DoublyLinkedList_Test_1 {

    public static void main(String[] args) {
        DoublyHeroNode doublyListNode1 = new DoublyHeroNode(1, "宋江", "及时雨");
        DoublyHeroNode doublyListNode2 = new DoublyHeroNode(2, "卢俊义", "玉麒麟");
        DoublyHeroNode doublyListNode3 = new DoublyHeroNode(3, "卢勇", "智多星");
        DoublyHeroNode doublyListNode4 = new DoublyHeroNode(4, "林冲", "豹子头");

        DoublyHeroNode update = new DoublyHeroNode(4, "卢俊义2", "玉麒麟2");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(doublyListNode1);
        doublyLinkedList.add(doublyListNode2);
        doublyLinkedList.add(doublyListNode3);
        doublyLinkedList.add(doublyListNode4);
        doublyLinkedList.list();
        doublyLinkedList.update(update);
        doublyLinkedList.delete(2);
        doublyLinkedList.list();
    }
}
