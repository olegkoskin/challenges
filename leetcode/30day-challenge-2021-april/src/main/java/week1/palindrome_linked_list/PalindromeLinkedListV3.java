package week1.palindrome_linked_list;

import java.util.Stack;

/**
 * <p>Given the <code>head</code> of a singly linked list, return <code>true</code> if it is a palindrome.</p>
 * <p>
 * <b>Example 1:</b> <br/>
 * <b>Input:</b> head = [1,2,2,1] <br/>
 * <b>Output:</b> true <br/>
 * </p>
 * <p>
 * <b>Example 2:</b> <br/>
 * <b>Input:</b> head = [1,2] <br/>
 * <b>Output:</b> false <br/>
 * </p>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>The number of nodes in the list is in the range <code>[1, 105]</code>.</li>
 *     <li><code>0 <= Node.val <= 9</code></li>
 * </ul>
 * </p>
 *
 * Follow up: Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?
 */
public class PalindromeLinkedListV3 {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        Stack<ListNode> stack = new Stack<>();

        while (fast !=null && fast.next != null) {
            stack.push(slow);

            fast = fast.next.next;
            slow = slow. next;
        }

        // if odd length, move one forward away from middle el
        if (fast != null) {
            slow = slow.next;
        }

        // compare 2nd half pf the list to stack
        while (slow != null) {
            ListNode cur = stack.pop();
            if (cur.val != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

}
