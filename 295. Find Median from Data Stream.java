class MedianFinder {
    private Queue<Integer> maxPq;
    private Queue<Integer> minPq;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxPq = new PriorityQueue<>((Integer a, Integer b) -> b - a);
        minPq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxPq.offer(num);
        minPq.offer(maxPq.poll());
        if(minPq.size() > maxPq.size())maxPq.offer(minPq.poll());
    }

    public double findMedian() {
        if(maxPq.size() == minPq.size())return (maxPq.peek() + minPq.peek()) / 2.0;
        else return maxPq.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
