package week1.group_anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams.
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Note:
 * 1. All inputs will be in lowercase.
 * 2. The order of your output does not matter.
 */
public class GroupAnagrams {

    /**
     * Hash map approach. Key as char array.
     *
     * @param strs strings
     * @return anagrams groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char ch : s.toCharArray()) {
                ca[ch - 'a']++;
            }
            map.computeIfAbsent(String.valueOf(ca), key -> new LinkedList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

}
