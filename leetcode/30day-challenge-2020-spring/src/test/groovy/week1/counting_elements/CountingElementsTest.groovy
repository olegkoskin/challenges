package week1.counting_elements

import spock.lang.Specification

class CountingElementsTest extends Specification {

    def "CountElements. Sort and binary search."() {
        given:
            def countingElements =  new CountingElements();
        when:
            def count = countingElements.countElements(arr)
        then:
            count == expectedCount
        where:
        arr || expectedCount
        [1,2,3] as int[] || 2
        [1,1,3,3,5,5,7,7] as int[] || 0
        [1,3,2,3,5,0] as int[] || 3
        [1,1,2,2] as int[] || 2
    }

    def "CountElements. Set and contains."() {
        given:
            def countingElements =  new CountingElementsV2();
        when:
            def count = countingElements.countElements(arr)
        then:
            count == expectedCount
        where:
        arr || expectedCount
        [1,2,3] as int[] || 2
        [1,1,3,3,5,5,7,7] as int[] || 0
        [1,3,2,3,5,0] as int[] || 3
        [1,1,2,2] as int[] || 2
    }

}
