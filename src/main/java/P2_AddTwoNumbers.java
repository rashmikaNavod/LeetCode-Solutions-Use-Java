import java.util.ArrayList;
import java.util.List;

/**

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class P2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        int carry_number = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode node1 = l1;
        ListNode node2 = l2;

        while (node1!=null || node2!=null || carry_number != 0){
            int x = (node1 != null) ? node1.val : 0;
            int y = (node2 != null) ? node2.val : 0;

            int total = x + y + carry_number;
            carry_number = total / 10;
            current.next = new ListNode(total % 10);
            current = current.next;

            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {

        P2_AddTwoNumbers solution = new P2_AddTwoNumbers();

        int[] nums1 = {7,4,3};
        ListNode dummy1 = new ListNode(0);
        ListNode current1 = dummy1;
        for (int n : nums1){
            current1.next = new ListNode(n);
            current1 = current1.next;
        }
        ListNode list1 = dummy1.next;

//      sankaya adu ganak nam mehem hdgnn puluwn
        ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode resultHead = solution.addTwoNumbers(list1,list2);
        ListNode temp = resultHead;
        List<Integer> finalResultList = new ArrayList<>();
        while (temp != null){
            finalResultList.add(temp.val);
            temp = temp.next;
        }

        System.out.println("The Sum is: " + finalResultList);
    }

}
