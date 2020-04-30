package week1.maximum_subarray

import spock.lang.Specification

class MaximumSubarrayTest extends Specification {

    def "MaxSubArray. Kadane’s Algorithm"() {
        given:
            def maximumSubarray = new MaximumSubarray()
        when:
            def sum = maximumSubarray.maxSubArray(nums)
        then:
            sum == expectedSum
        where:
            expectedSum || nums
             6 || [-2, 1, -3, 4, -1, 2, 1, -5, 4] as int[]
            -1 || [-1] as int[]
            -1 || [-2, -1] as int[]
             6 || [1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4] as int[]
            -1 || [-2, -3, -1] as int[]
    }
    
    def "MaxSubArray. Divide and conquer approach."() {
        given:
            def maximumSubarray = new MaximumSubarrayV2()
        when:
            def sum = maximumSubarray.maxSubArray(nums)
        then:
            sum == expectedSum
        where:
            expectedSum || nums
             6 || [-2, 1, -3, 4, -1, 2, 1, -5, 4] as int[]
            -1 || [-1] as int[]
            -1 || [-2, -1] as int[]
             6 || [1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4] as int[]
            -1 || [-2, -3, -1] as int[]
    }
    
    def "MaxSubArray. Brute force approach."() {
        given:
            def maximumSubarray = new MaximumSubarrayV3()
        when:
            def sum = maximumSubarray.maxSubArray(nums)
        then:
            sum == expectedSum
        where:
            expectedSum || nums
             6 || [-2, 1, -3, 4, -1, 2, 1, -5, 4] as int[]
            -1 || [-1] as int[]
            -1 || [-2, -1] as int[]
             6 || [1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4] as int[]
            -1 || [-2, -3, -1] as int[]
    }
}
