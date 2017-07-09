public class Solution {
    private int count = 0;
    public int countArrangement(int N) {
        int[] result = new int[N];

        for(int i = 0; i < N; i ++){
            result[i] = i + 1;
        }
        permutate(result, 0, N - 1);

        return count;
    }

    public void permutate(int[] result, int leftIdx, int rightIdx) {
        if(leftIdx == rightIdx) {
            if(result[leftIdx] %  (leftIdx + 1) == 0 || (leftIdx + 1) %  result[leftIdx] == 0){
                count ++;
            }
            return;
        }

        for(int i = leftIdx; i <= rightIdx; i ++) {
            swap(result, i, leftIdx);
            if(result[leftIdx] %  (leftIdx + 1) == 0 || (leftIdx + 1) %  result[leftIdx] == 0){
                permutate(result, leftIdx + 1, rightIdx);
            }
            swap(result, i, leftIdx);
        }
    }

    private void swap(int[] array, int leftIdx, int rightIdx) {
        int temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }

}


// sol2
// public class Solution {
//     private int count = 0;
//     public int countArrangement(int N) {
//
//         boolean[] visited = new boolean[N + 1];
//         backTrack(visited, 1, N);
//
//         return count;
//     }
//
//     void backTrack(boolean[] visited, int position, int maxN) {
//         if(position > maxN) {
//             count ++;
//             return;
//         }
//
//         for(int i = 1; i <= maxN; i ++) {
//             if(!visited[i] && (i % position == 0 || position % i == 0)) {
//                 visited[i] = true;
//                 backTrack(visited, position + 1, maxN);
//                 visited[i] = false;
//             }
//         }
//     }
//
// }
