package week1.palindrome_linked_list;

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
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode tmp = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (prev.val != slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }

}
