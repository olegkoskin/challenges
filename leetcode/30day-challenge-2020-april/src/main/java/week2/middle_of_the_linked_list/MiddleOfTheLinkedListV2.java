package week2.middle_of_the_linked_list;

/**
 * Middle of the Linked List.
 * <p>
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * <p>
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * Note:
 * <ul>
 *     <li>The number of nodes in the given list will be between 1 and 100.</li>
 * </ul>
 */
public class MiddleOfTheLinkedListV2 {

    /**
     * While loop with size.
     *
     * @param head head or the list
     * @return middle node
     */
    public ListNode middleNode(ListNode head) {
        ListNode middle = null;
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int middleIndex = size / 2;
        middle = head;
        while (middleIndex > 0) {
            middle = middle.next;
            middleIndex--;
        }
        return middle;
    }

}
