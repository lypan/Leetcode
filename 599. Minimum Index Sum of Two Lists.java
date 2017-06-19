public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < list1.length; i ++) map.put(list1[i], i);

        int min_sum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        for(int i = 0; i < list2.length; i ++) {
            String str = list2[i];

            if(map.containsKey(str)) {
                int j = map.get(str);
                int sum = i + j;

                if(sum < min_sum){
                    // discard larger sum
                    result.clear();
                    // first element
                    result.add(str);
                    min_sum = sum;
                }
                // if ties exist
                else if(sum == min_sum)result.add(str);

                // impossible to find smaller sums
                if(i > min_sum)break;
            }
        }

        return result.toArray(new String[0]);
    }
}
