public class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    double median;
    boolean isFirst = true;
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (isFirst) {
            left.offer(num);
            isFirst = false;
            median = num;
            return;
        }
        if (num <= median) 
            left.offer(num);
        else
            right.offer(num);
        if (left.size() - right.size() == 2) {
            right.offer(left.poll());
            median = (left.peek() + right.peek()) / 2.0;
        } else if (left.size() - right.size() == -2) {
            left.offer(right.poll());
            median = (left.peek() + right.peek()) / 2.0;
        } else if (left.size() - right.size() == 1)
            median = left.peek();
        else if (left.size() - right.size() == -1)
            median = right.peek();
        else 
            median = (left.peek() + right.peek()) / 2.0;
    }

    // Returns the median of current data stream
    public double findMedian() {
        return median;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
