class MovingAverage {
public:
    /** Initialize your data structure here. */
    queue<int> myQueue;
    int maxSize;
    double currentSum;
    MovingAverage(int size) {
        maxSize = size;
        currentSum = 0;
    }

    double next(int val) {
        if(myQueue.size() == maxSize) {
            currentSum -= myQueue.front();
            myQueue.pop();
        }
        myQueue.push(val);
        currentSum += val;
        return currentSum / myQueue.size();
    }
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
