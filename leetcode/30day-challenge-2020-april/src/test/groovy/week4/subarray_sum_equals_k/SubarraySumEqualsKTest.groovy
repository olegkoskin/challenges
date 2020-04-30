package week4.subarray_sum_equals_k

import spock.lang.Specification

class SubarraySumEqualsKTest extends Specification {

    def "Subarray Sum Equals K. Hash map"() {
        given:
            def subarraySumEqualsK = new SubarraySumEqualsK()
        when:
            def totalNumber = subarraySumEqualsK.subarraySum(nums, k)
        then:
            assert totalNumber == expected : "Actual $totalNumber. Expected $expected as total number of continuoud subarrays whose sum equals to $k."
        where:
            nums             | k || expected
            //[1,1,1] as int[] | 2 || 2
            //[1,2,3] as int[] | 3 || 2
            //[28,54,7,-70,22,65,-6] as int[] | 100 || 1
            [0,0,0,0,0,0,0,0,0,0] as int[] | 0 || 55
    }

    def "Subarray Sum Equals K. Brute force approach."() {
        given:
            def subarraySumEqualsK = new SubarraySumEqualsKV2()
        when:
            def totalNumber = subarraySumEqualsK.subarraySum(nums, k)
        then:
            assert totalNumber == expected : "Actual $totalNumber. Expected $expected as total number of continuoud subarrays whose sum equals to $k."
        where:
            nums             | k || expected
            //[1,1,1] as int[] | 2 || 2
            //[1,2,3] as int[] | 3 || 2
            //[28,54,7,-70,22,65,-6] as int[] | 100 || 1
            [0,0,0,0,0,0,0,0,0,0] as int[] | 0 || 55
    }

    def "Subarray Sum Equals K. Pre sum"() {
        given:
            def subarraySumEqualsK = new SubarraySumEqualsKV3()
        when:
            def totalNumber = subarraySumEqualsK.subarraySum(nums, k)
        then:
            assert totalNumber == expected : "Actual $totalNumber. Expected $expected as total number of continuoud subarrays whose sum equals to $k."
        where:
            nums             | k || expected
            //[1,1,1] as int[] | 2 || 2
            //[1,2,3] as int[] | 3 || 2
            //[28,54,7,-70,22,65,-6] as int[] | 100 || 1
            [0,0,0,0,0,0,0,0,0,0] as int[] | 0 || 55
    }

}
