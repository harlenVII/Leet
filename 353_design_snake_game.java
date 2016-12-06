public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    int score;
    Deque<Integer> snake;
    Set<Integer> set;
    int width;
    int height;
    int[][] food;
    int curFood;
    public SnakeGame(int width, int height, int[][] food) {
        score = 0;
        snake = new LinkedList<>();
        snake.offerFirst(0);
        set = new HashSet<>();
        set.add(0);
        this.width = width;
        this.height = height;
        this.food = food; // do i need to make a copy here?
        curFood = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] curHead = new int[]{snake.peekFirst() / width, snake.peekFirst() % width};
        int[] nextHead = new int[2];
        nextHead[0] = curHead[0];
        nextHead[1] = curHead[1];
        switch (direction.charAt(0)) {
            case 'U':
                nextHead[0]--;
                break;
            case 'L':
                nextHead[1]--;
                break;
            case 'R':
                nextHead[1]++;
                break;
            case 'D':
                nextHead[0]++;
                break;
        }
        
        // boarder
        if (nextHead[0] < 0 || nextHead[1] < 0 || nextHead[0] == height || nextHead[1] == width)
            return -1;
        
        // eating food?
        if (curFood < food.length && nextHead[0] == food[curFood][0] && nextHead[1] == food[curFood][1]) {
            curFood++;
            score++;
        } else {
            set.remove(snake.peekLast());
            snake.pollLast();
        }
        
        // eating self?
        // must place here because of the tail maybe is polled or not
        if (set.contains(nextHead[0] * width + nextHead[1]))
            return -1;
        
        // add newHead
        snake.offerFirst(nextHead[0] * width + nextHead[1]);
        set.add(nextHead[0] * width + nextHead[1]);
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
