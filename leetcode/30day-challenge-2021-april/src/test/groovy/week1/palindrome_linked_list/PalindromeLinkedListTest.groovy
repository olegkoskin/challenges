package week1.palindrome_linked_list

import spock.lang.Specification

class PalindromeLinkedListTest extends Specification {

    def "Palindrome Linked List. Reverting"() {
        given:
            def palindromeLinkedList = new PalindromeLinkedList()
        when:
            def result = palindromeLinkedList.isPalindrome(head)
        then:
            result == expectedResult
        where:
            expectedResult || head
            true || new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))
            true || new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))
            false || new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))))
            false || new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))))
            false || new ListNode(1, new ListNode(2))
    }

    def "Palindrome Linked List. Brute force"() {
        given:
            def palindromeLinkedList = new PalindromeLinkedListV2()
        when:
            def result = palindromeLinkedList.isPalindrome(head)
        then:
            result == expectedResult
        where:
            expectedResult || head
            true || new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))
            true || new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))
            false || new ListNode(1, new ListNode(2))
    }

    def "Palindrome Linked List. Stack"() {
        given:
            def palindromeLinkedList = new PalindromeLinkedListV3()
        when:
            def result = palindromeLinkedList.isPalindrome(head)
        then:
            result == expectedResult
        where:
            expectedResult || head
            true || new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))
            true || new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))
            false || new ListNode(1, new ListNode(2))
    }

    def "Palindrome Linked List. Recursion"() {
        given:
        def palindromeLinkedList = new PalindromeLinkedListV4()
        when:
        def result = palindromeLinkedList.isPalindrome(head)
        then:
        result == expectedResult
        where:
        expectedResult || head
        true || new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))
        true || new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))
        false || new ListNode(1, new ListNode(2))
    }

}
