class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    int top;
    // Push element x onto stack.
    public void push(int x) {
        top = x;
        queue.offer(top);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            if (i == size - 2)
                top = queue.peek();
            queue.offer(queue.poll());
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
