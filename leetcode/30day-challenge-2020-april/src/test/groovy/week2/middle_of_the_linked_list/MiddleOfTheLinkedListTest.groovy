package week2.middle_of_the_linked_list

import spock.lang.Specification

class MiddleOfTheLinkedListTest extends Specification {

    def "Middle of the Linked List."() {
        given:
            def middleLinkedList = new MiddleOfTheLinkedList();
        when:
            def middle = middleLinkedList.middleNode(head)
        then:
            middle.val == expectedVal
            middle.next != null
        where:
            head || expectedVal
            buildLinkedList([1,2,3,4,5]) || 3
            buildLinkedList([1,2,3,4,5,6]) || 4
            buildLinkedList([1,2,3,4,5,6,7,8,9,10]) || 6
    }

    def "Middle of the Linked List. Two pointers."() {
        given:
            def middleLinkedList = new MiddleOfTheLinkedListV2();
        when:
            def middle = middleLinkedList.middleNode(head)
        then:
            middle.val == expectedVal
            middle.next != null
        where:
            head || expectedVal
            buildLinkedList([1,2,3,4,5]) || 3
            buildLinkedList([1,2,3,4,5,6]) || 4
            buildLinkedList([1,2,3,4,5,6,7,8,9,10]) || 6
    }

    ListNode buildLinkedList(List<Integer> nums) {
        def head = new ListNode(nums[0])
        def cur = head
        for (int i = 1; i < nums.size(); i++) {
            def node = new ListNode(nums[i])
            cur.next = node
            cur = node
        }
        head
    }

}
