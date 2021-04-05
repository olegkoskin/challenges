package week1.palindrome_linked_list;

import java.util.ArrayList;
import java.util.List;

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
public class PalindromeLinkedListV2 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return true;
        }

        ListNode tail = head;
        List<Integer> list = new ArrayList<>();
        do {
            list.add(tail.val);
            tail = tail.next;
        } while (tail != null);

        int i = 0;
        int j = list.size() - 1;
        boolean flag = false;
        for (; j - i >= 1; i++, j--) {
            int h = list.get(i);
            int t = list.get(j);
            if (h == t) {
                flag = true;
                continue;
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }

}
