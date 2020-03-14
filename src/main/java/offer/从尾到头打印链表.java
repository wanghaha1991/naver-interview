package offer;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class 从尾到头打印链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        Stack<Integer> nums = new Stack<>();
        while (head != null){
            nums.push(head.val);
            head = head.next;
        }
        int[] result = new int[nums.size()];
        int i = 0;
        while (!nums.isEmpty()){
            result[i] = nums.pop();
            i++;
        }
        return result;
    }

}
