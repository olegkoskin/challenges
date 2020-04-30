package week4.lru_cache

import spock.lang.Specification

class LRUCacheTest extends Specification {

    def "LRU Cache"() {
        when:
            def cache = ca
            cache.put(1, 1);
            cache.put(2, 2);

        then:
            assert cache.get(1) == 1       // returns 1

        when:
            cache.put(3, 3);    // evicts key 2

        then:
            assert cache.get(2) == -1       // returns -1 (not found)

        when:
            cache.put(4, 4);    // evicts key 1

        then:
            assert cache.get(1) == -1       // returns -1 (not found)
            assert cache.get(3) == 3       // returns 3
            assert cache.get(4) == 4       // returns 4

        where:
            ca << [new LRUCache(2), new LRUCacheV2(2)]
    }

    def "LRU Cache. #2"() {
        when:
            def cache = ca
            cache.put(1, 1);
            cache.put(2, 2);
            cache.put(3, 3);
            cache.put(4, 4); // evicts key 1

        then:
            assert cache.get(4) == 4
            assert cache.get(3) == 3
            assert cache.get(2) == 2
            assert cache.get(1) == -1

        when:
            cache.put(5,5); // evicts key 4

        then:
            assert cache.get(1) == -1
            assert cache.get(2) == 2
            assert cache.get(3) == 3
            assert cache.get(4) == -1
            assert cache.get(5) == 5

        where:
            ca << [new LRUCache(3), new LRUCacheV2(3)]
    }

    def "LRU Cache. #3"() {
        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        //[null,null,null,1,null,-1,null,-1,3,4]
        when:
            def cache = ca
            cache.put(1, 1);
            cache.put(2, 2);

        then:
            assert cache.get(1) == 1

        when:
            cache.put(3, 3); // evicts key 2

        then:
            assert cache.get(2) == -1

        when:
            cache.put(4, 4); // evicts key 1

        then:
            assert cache.get(1) == -1
            assert cache.get(3) == 3
            assert cache.get(4) == 4

        where:
            ca << [new LRUCache(2), new LRUCacheV2(2)]
    }

}
