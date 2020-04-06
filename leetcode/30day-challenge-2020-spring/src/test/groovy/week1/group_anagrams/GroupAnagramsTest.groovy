package week1.group_anagrams

import spock.lang.Specification

class GroupAnagramsTest extends Specification {

    def "Group Anagrams."() {
        given:
            def groupAnagrams = new GroupAnagrams()
        when:
            def anagrams = groupAnagrams.groupAnagrams(strs)
        then:
            anagrams.sort()
            anagrams.forEach({ it -> it.sort() })
            expectedAnagrams.sort()
            anagrams == expectedAnagrams
        where:
            strs || expectedAnagrams
            ["eat", "tea", "tan", "ate", "nat", "bat"] as String[] || [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
            ["hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"] as String[] || [["sol"],["wow"],["gap"],["hem"],["yap"],["bum"],["ugh","ugh"],["aha"],["jab"],["eve"],["bop"],["lyx"],["jed"],["iva"],["rod"],["boo"],["brr"],["hog"],["nay"],["mir"],["deb","deb"],["aft"],["dis"],["yea"],["hos"],["rye"],["hey"],["doc"],["bob"],["eel"],["pen"],["job"],["max"],["oho"],["lye"],["ram"],["nap"],["elf"],["qua"],["pup","pup"],["let"],["gym"],["nam"],["bye"],["lon"]]
    }

}
