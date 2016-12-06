public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return -1;
        Queue<Integer> l1 = new LinkedList<>();
        l1.offer(1);
        Queue<Integer> l2 = new LinkedList<>(l1);
        Queue<Integer> l3 = new LinkedList<>(l1);
        int result = 1;
        for (int i = 1; i < n; i++) {
            int n1 = l1.peek() * 2;
            int n2 = l2.peek() * 3;
            int n3 = l3.peek() * 5;
            result = Math.min(n1, Math.min(n2, n3));
            if (result == n1)
                l1.poll();
            if (result == n2)
                l2.poll();
            if (result == n3)
                l3.poll();
            l1.offer(result);
            l2.offer(result);
            l3.offer(result);
        }
        return result;
    }
}

// an easy way to optimize is to abandon the queues but adpot 3 ints storing the index of result array.
