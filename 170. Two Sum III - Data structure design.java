public class TwoSum {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();

            int num1 = key;
            int num2 = value - key;

            if(map.containsKey(num2)) {
                // 1.same value, frequency has to larger than 2
                // 2.different values
                if(num1 == num2 && map.get(num2) >= 2 || num1 != num2)return true;

            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
