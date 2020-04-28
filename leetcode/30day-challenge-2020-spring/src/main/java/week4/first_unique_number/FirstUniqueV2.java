package week4.first_unique_number;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * First Unique Number.
 *
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 * <ul>
 *     <li>FirstUnique(int[] nums) Initializes the object with the numbers in the queue.</li>
 *     <li>int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.</li>
 *     <li>void add(int value) insert value to the queue.</li>
 * </ul>
 *
 * <b>Example 1:</b>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 *
 * <b>Example 2:</b>
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 *
 * <b>Example 3:</b>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 *
 * <b>Constraints:</b>
 * <ul>
 *     <li>1 <= nums.length <= 10^5</li>
 *     <li>1 <= nums[i] <= 10^8</li>
 *     <li>1 <= value <= 10^8</li>
 *     <li>At most 50000 calls will be made to showFirstUnique and add.</li>
 * </ul>
 *
 * <b>Hint #1:</b> Use doubly Linked list with hashmap of pointers to linked list nodes. add unique number to
 * the linked list. When add is called check if the added number is unique then it have to be added to
 * the linked list and if it is repeated remove it from the linked list if exists. When showFirstUnique is called
 * retrieve the head of the linked list.
 * <b>Hint #2:</b> Use queue and check that first element of the queue is always unique.
 * <b>Hint #3:</b> Use set or heap to make running time of each function O(logn).
 */
public class FirstUniqueV2 {

    private final Queue<Integer> queue = new LinkedList<>();
    private final Map<Integer, Integer> map = new HashMap<>();

    public FirstUniqueV2(int[] nums) {
        for (int num: nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        Integer head = queue.peek();
        return head == null ? -1 : head;
    }

    public void add(int value) {
        if (map.containsKey(value)) {
            queue.removeIf(num -> num.equals(value));
        } else {
            queue.offer(value);
            map.put(value, value);
        }
    }

}
