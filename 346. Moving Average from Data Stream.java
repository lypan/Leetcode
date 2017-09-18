class MovingAverage {

    private Queue<Integer> queue;
    private int maxSize;
    private double currentSum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        maxSize = size;
        currentSum = 0;
    }

    public double next(int val) {
        if(queue.size() == maxSize) {
            int headValue = queue.remove();
            currentSum -= headValue;
        }
        currentSum += val;
        queue.add(val);
        return currentSum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
