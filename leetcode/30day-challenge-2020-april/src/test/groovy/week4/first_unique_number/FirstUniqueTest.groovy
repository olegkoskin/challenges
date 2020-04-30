package week4.first_unique_number

import spock.lang.Specification

class FirstUniqueTest extends Specification {

    def "First Unique Number. Example 1."() {
        given:
            def firstUnique = Unique.newInstance([2, 3, 5] as int[]);
        when:
            def stub = 1
        then:
            assert firstUnique.showFirstUnique() == 2 : "should return 2"
        when: "the queue is now [2,3,5,5]"
            firstUnique.add(5)
        then:
            assert firstUnique.showFirstUnique() == 2 : "should return 2"
        when: "the queue is now [2,3,5,5,2]"
            firstUnique.add(2)
        then:
            assert firstUnique.showFirstUnique() == 3 : "should return 3"
        when: "the queue is now [2,3,5,5,2,3]"
            firstUnique.add(3)
        then:
            assert firstUnique.showFirstUnique() == -1 : "should return -1"
        where:
        Unique << [FirstUnique.class, FirstUniqueV2.class]
    }

    def "First Unique Number. Example 2"() {
        given:
            def firstUnique = Unique.newInstance([7,7,7,7,7,7] as int[]);
        when:
            def stub = 1
        then:
            assert firstUnique.showFirstUnique() == -1 : "should return -1"
        when:
            firstUnique.add(7) // the queue is now [7,7,7,7,7,7,7]
            firstUnique.add(3) // the queue is now [7,7,7,7,7,7,7,3]
            firstUnique.add(3) // the queue is now [7,7,7,7,7,7,7,3,3]
            firstUnique.add(7) // the queue is now [7,7,7,7,7,7,7,3,3,7]
            firstUnique.add(17) // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        then:
            assert firstUnique.showFirstUnique() == 17 : "should return 17"
        where:
        Unique << [FirstUnique.class, FirstUniqueV2.class]
    }

    def "First Unique Number. Example 3"() {
        given:
            def firstUnique = Unique.newInstance([809] as int[]);
        when:
            def stub = 1
        then:
            assert firstUnique.showFirstUnique() == 809 : "return 809"
        when: "the queue is now [809,809]"
            firstUnique.add(809)
        then:
            assert firstUnique.showFirstUnique() == -1 : "should return -1"
        where:
        Unique << [FirstUnique.class, FirstUniqueV2.class]
    }

}
