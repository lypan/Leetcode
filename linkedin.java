import java.util.*;

public class Main {

    public static class Point{

        public int x;
        public int y;
        public double distance;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, Point p) {
            this.x = x;
            this.y = y;
            this.distance = Math.hypot(p.x - x, p.y - y);
        }
    }

    public static void main(String[] args) {
        Integer[] test = {1, 2, 3};

        permuteUnique(test);
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean numberSeen = false;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } else if(s.charAt(i) == '.') {
                if(pointSeen || i > 0 && s.charAt(i - 1) == '-') {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == '-') {
                if(i != 0 || pointSeen) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen;
    }

    public static void maxHeap() {
        PriorityQueue<Point> pq = new PriorityQueue<Point>((p1, p2) -> Double.valueOf(p2.distance).compareTo(p1.distance));
        Point p = new Point(0, 0);
        Point p1 = new Point(10, 10, p);
        Point p2 = new Point(20, 10, p);
        Point p3 = new Point(30, 10, p);

        pq.offer(p1);
        pq.offer(p2);
        pq.offer(p3);
    }
    public static <T> List<List<T>> permuteUnique(T[] nums) {
        List<List<T>> result = new ArrayList<>();
        List<T> temp = new ArrayList<>();
        if(nums == null || nums.length == 0)return result;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, temp, used);
        return result;
    }
    private static <T> void backtrack(T[] nums, List<List<T>> result, List<T> temp, boolean[] used) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(used[i])continue;
            // ensure order must be consistent so there won't be any duplicates
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(nums, result, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
