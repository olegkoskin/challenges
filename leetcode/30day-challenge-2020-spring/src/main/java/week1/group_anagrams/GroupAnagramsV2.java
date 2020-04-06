package week1.group_anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class GroupAnagramsV2 {

    /**
     * Very slo-w-w-w.
     *
     * @param strs strings
     * @return anagrams groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
        boolean[] processed = new boolean[length];
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (processed[i]) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            list.add(group);
            List<Integer> listi = strs[i].chars().boxed().collect(Collectors.toList());
            for (int j = i + 1; j < length; j++) {
                if (processed[j]) {
                    continue;
                }
                List<Integer> listj = strs[j].chars().boxed().collect(Collectors.toList());
                if (equalsIgnoreOrder(listi, listj)) {
                    //if (equalLists(listi, listj)) {
                    processed[j] = true;
                    group.add(strs[j]);
                }
            }
            processed[i] = true;
        }

        return list;
    }

    private boolean equalLists(List<Integer> one, List<Integer> two) {
        if (one == null && two == null) {
            return true;
        }

        if ((one == null && two != null)
                || one != null && two == null
                || one.size() != two.size()) {
            return false;
        }

        //to avoid messing the order of the lists we will use a copy
        //as noted in comments by A. R. S.
        one = new ArrayList<>(one);
        two = new ArrayList<>(two);

        Collections.sort(one);
        Collections.sort(two);
        return one.equals(two);
    }

    private <T> boolean equalsIgnoreOrder(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        Map<T, Integer> map1 = createCountMap(list1);
        Map<T, Integer> map2 = createCountMap(list2);
        return map1.equals(map2);
    }

    private <T> Map<T, Integer> createCountMap(List<T> list) {
        Map<T, Integer> map = new HashMap<T, Integer>();
        for (T value : list) {
            Integer prevCount = map.get(value);
            map.put(value, prevCount == null ? 1 : prevCount + 1);
        }
        return map;
    }

}
