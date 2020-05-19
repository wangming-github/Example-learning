package com.wangming.algorithm.dataStructure;

/*
 * 环形单向链表
 * ①--->②--->③--->④--->⑤
 * Josephu 约瑟夫问题为:设编号为 1，2，... n 的 n 个人围坐一圈，
 * 约定编号为 k(1<=k<=n)的人从 1 开始报数，数到 m 的那个人出列，
 * 它的下一位又从1开始报数，数到 m 的那个人又出列，依次类推，
 * 直到所有人出列为止，由 此产生一个出队编号的序列。
 * ===>
 * ②--->④--->①--->⑤--->③
 */


/*
 * 描述：
 * 构建一个单向环形链表思路
 * 1.先创建第一个节点①，让 first 指向该节点，并且形成环形 ①--->①。
 * 2.后面我们每创建一个节点，就将其接入到环形链表中 ①--->②--->①
 * 遍历
 * 当前节点.next = first时遍历结束
 */


//创建节点
class BoyNode {
    private int id;
    private BoyNode next;

    public BoyNode(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BoyNode{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }
}

//构建一个单向环形链表
class CycleSingleLinkedList {

    //创建一个指向第一个小孩的节点
    public BoyNode first = new BoyNode(-1);

    public void add(int num) {

        if (num < 1) {
            System.out.println("参数数据错误!");
            return;
        }

        //创建环形链表
        BoyNode cur = null; //声明变量创建
        for (int i = 1; i <= num; i++) {
            BoyNode newBoyNode = new BoyNode(i);

            //自己指向自己
            if (i == 1) {
                first = newBoyNode;
                first.setNext(newBoyNode);
                cur = first;//让cur指向第一个小孩
            } else {
                cur.setNext(newBoyNode);//将原始节点的最后节点指向新的节点
                newBoyNode.setNext(first);//将新的节点指向第一个节点
                cur = newBoyNode;//将临时节点指向最后节点
            }
        }
    }


    public void list() {
        if (first == null) {
            System.out.println("没有任何小孩!");
            return;
        }

        //因为 first 不能动
        BoyNode boy = first;
        while (boy != null) {
            System.out.print("-" + boy.getId() + "-");
            if (boy.getNext() == first) {
                System.out.println("遍历结束!");
                break;
            }
            boy = boy.getNext();
        }
    }

    /*
     * 根据输入生成出圈顺序
     * 1.创建一个辅助指针，开始应该指向环形链表最后的节点。即，拿去它的下一个节点为第一个节点。
     * 2.当小孩报数时，让 first 和 helper 同时移动M-1次；
     * 3.这时将小孩节点出圈。
     *   first = first.next;
     *   helper.next=first;
     *
     * startId 从第几个开始
     * skypeId 每次数几个
     * count 总数
     */
    public void out(int startId, int skpeId, int count) {

        //校验
        if ((first == null) || (startId > count) || (skpeId < 1)) {
            return;
        }


        BoyNode helper = first; //创建辅助指针帮助出圈
        while (helper != null) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //先确定到报数的小孩的位置移动到 k-1 位置
        System.out.println("最后节点 helper：" + helper);
        for (int i = 0; i <= startId - 1; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }

        System.out.println("移动到报数节点 helper：" + helper);
        System.out.println("移动到报数节点 first：" + first);
        //当小孩报数时，让first和helper同时移动 m-1次；然后出圈；
        //循环操作，直到圈里只有一个节点
        while (true) {
            if (first == helper) {
                break;
            }

            for (int j = 0; j <= count - 1; j++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.println("出圈小孩：" + first);
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后的小孩：" + first);
    }

}

public class Day5_Josephus_Problem_Test_1 {
    public static void main(String[] args) {
        CycleSingleLinkedList cycleSingleLinkedList = new CycleSingleLinkedList();

        cycleSingleLinkedList.add(5);
        cycleSingleLinkedList.list();
        cycleSingleLinkedList.out(1, 2, 5);

    }
}
