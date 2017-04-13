public class Solution {
    public boolean validWordSquare(List<String> words) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        for(int i = 0; i < words.size(); i ++) {
            for(int j = 0; j < words.get(i).length(); j ++) {
                // hashMap store ith column
                if(j < words.size() && words.get(j).length() > i)hashMap.put(i, hashMap.getOrDefault(i, "") + words.get(j).charAt(i));
            }
            System.out.println(hashMap.getOrDefault(i, ""));
        }

        for(int i = 0; i < words.size(); i ++) {
            if(!words.get(i).equals(hashMap.getOrDefault(i, "")))return false;
        }

        return true;
    }
}
// sol2
// public class Solution {
//     public boolean validWordSquare(List<String> words) {
//         if(words == null || words.size() == 0)return true;
//
//         for(int i = 0; i < words.size(); i ++) {
//             int len = words.get(i).length();
//
//             for(int j = 0; j < len; j ++) {
//                 if(j >= words.size() || i >= words.get(j).length() || words.get(j).charAt(i) != words.get(i).charAt(j))
//                     return false;
//             }
//         }
//
//         return true;
//     }
// }
