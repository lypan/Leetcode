public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(Collections.nCopies(rowIndex + 1, 0));

        list.set(0, 1);

        // because the new value is current value and its left value
        // when we go from the right, the left value won't be replaced
        // so we don't have to store the old current value to be used for next update
        for(int i = 1; i <= rowIndex; i ++) {
            for(int j = i; j >= 1; j --) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }

        return list;
    }
}
