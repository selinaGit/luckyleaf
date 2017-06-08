package tiger.com.luckyleaf.charpt1;

import java.util.*;

/**

 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 ===============================
 Your runtime beats 1.34 % of java submissions.
 */
public class LC347TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b)->(a.getValue() - b.getValue()));

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){

            if (heap.size() < k) {
                heap.add(entry);
            } else {
                heap.add(entry);
                heap.poll();
            }
        }

        LinkedList<Integer> output = new LinkedList<>();
        while (!heap.isEmpty()){
            Map.Entry<Integer, Integer> entry = heap.poll();
            output.addFirst(entry.getKey());
        }
        return output;
    }

}
