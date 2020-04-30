package week3.search_in_rotated_sorted_array

import spock.lang.Specification

class SearchInRotatedSortedArrayTest extends Specification {

    def "Search in Rotated Sorted Array. Two sub-arrays"() {
        given:
            def searchInRotatedSortedArray = new SearchInRotatedSortedArray()
        when:
            def index = searchInRotatedSortedArray.search(nums, target)
        then:
            assert index == expected : "$target should be at $expected index in array"
        where:
            nums                     | target || expected
            [1] as int[]             | 0      || -1
            [1, 3] as int[]          | 0      || -1
            [4,5,6,7,0,1,2] as int[] | 4      || 0
            [4,5,6,7,0,1,2] as int[] | 3      || -1
            [3,4,5,6,1,2] as int[]   | 2      || 5
            [5,6,1,2,3,4] as int[]   | 8      || -1
            [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 7 || 15
    }

    def "Search in Rotated Sorted Array."() {
        given:
            def searchInRotatedSortedArray = new SearchInRotatedSortedArrayV2()
        when:
            def index = searchInRotatedSortedArray.search(nums, target)
        then:
            assert index == expected : "$target should be at $expected index in array"
        where:
            nums                     | target || expected
            [1] as int[]             | 0      || -1
            [1, 3] as int[]          | 0      || -1
            [4,5,6,7,0,1,2] as int[] | 4      || 0
            [4,5,6,7,0,1,2] as int[] | 3      || -1
            [3,4,5,6,1,2] as int[]   | 2      || 5
            [5,6,1,2,3,4] as int[]   | 8      || -1
            [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 7 || 15
    }

}
