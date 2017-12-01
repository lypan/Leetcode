/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweight = 0;
        int weight = 0;
        while(!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for(int i = 0; i < nestedList.size(); i ++) {
                NestedInteger current = nestedList.get(i);
                if(current.isInteger())unweight += current.getInteger();
                else nextLevel.addAll(current.getList());
            }
            weight += unweight;
            nestedList = nextLevel;
        }
        return weight;
    }
}


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<List<Integer>> level = new ArrayList<>();
        dfs(nestedList, 1, level);
        int sum = 0;
        for(int i = 0; i < level.size(); i ++) {
            List<Integer> list = level.get(i);
            for(int j = 0; j < list.size(); j ++) {
                sum += (level.size() - i) * list.get(j);
            }
        }
        return sum;
    }

    public void dfs(List<NestedInteger> nestedList, int depth, List<List<Integer>> level) {
        if(level.size() < depth)level.add(new ArrayList<>());
        for(int i = 0; i < nestedList.size(); i ++) {
            NestedInteger current = nestedList.get(i);
            if(current.isInteger())level.get(depth - 1).add(current.getInteger());
            else dfs(current.getList(), depth + 1, level);
        }
    }
}
