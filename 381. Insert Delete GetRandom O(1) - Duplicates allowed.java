public class RandomizedCollection {

    private Map<Integer, Set<Integer>> map;
    private List<Integer> nums;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isContain = map.containsKey(val);
        if(!isContain) {
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !isContain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {

        if(!map.containsKey(val))return false;
        int index = map.get(val).iterator().next();
        int lastElement = nums.get(nums.size() - 1);
        int lastIndex = nums.size() - 1;

        map.get(val).remove(index);
        nums.set(index, lastElement);

        // same element should not be added back
        if(index != lastIndex) {
            map.get(lastElement).remove(lastIndex);
            map.get(lastElement).add(index);
        }

        nums.remove(lastIndex);
        if(map.get(val).isEmpty())map.remove(val);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */ 
