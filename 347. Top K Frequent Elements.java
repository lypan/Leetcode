public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // key:number value, value:frequency
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // index:frequency, value:number value
        // + 1 because index start from 0 while frequency start from 1
        List<Integer>[] frequencyList = new ArrayList[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer numVal = entry.getKey();
            Integer numFreq = entry.getValue();

            if(frequencyList[numFreq] == null)frequencyList[numFreq] = new ArrayList<Integer>();
            frequencyList[numFreq].add(numVal);
        }

        // index:frequency, value:number value
        List<Integer> result = new ArrayList<>();
        for(int i = frequencyList.length - 1; i >= 0 && result.size() < k; i --) {
            if(frequencyList[i] != null)result.addAll(frequencyList[i]);
        }

        return result;
    }
}
