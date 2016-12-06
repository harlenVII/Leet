public class Twitter {
    class Tweet implements Comparable<Tweet>{
        int id;
        int user;
        long time;
        Tweet(int id, int user, long time) {
            this.id = id;
            this.user = user;
            this.time = time;
        }
        public int compareTo(Tweet o) {
            return (int)(this.time - o.time);
        }
    }
    
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> newsMap;
    private long time;
    
    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<>();
        newsMap = new HashMap<>();
        time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        newsMap.computeIfAbsent(userId, k -> new ArrayList<Tweet>()).add(new Tweet(tweetId, userId, this.time++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>(10);
        PriorityQueue<Tweet> tweets = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        List<Tweet> tempTweets = newsMap.get(userId);
        if (tempTweets != null && tempTweets.size() > 0) {
            indexMap.put(userId, tempTweets.size() - 1);
            tweets.offer(tempTweets.get(tempTweets.size() - 1));
        }
        if (followMap.get(userId) != null) {
            for (int id : followMap.get(userId)) {
                if (id == userId)
                    continue;
                tempTweets = newsMap.get(id);
                if (tempTweets != null && tempTweets.size() > 0) {
                    indexMap.put(id, tempTweets.size() - 1);
                    tweets.offer(tempTweets.get(tempTweets.size() - 1));
                }
            }
        }
        for (int i = 0; i < 10 && tweets.size() > 0; i++) {
            Tweet tempT = tweets.poll();
            result.add(tempT.id);
            tempTweets = newsMap.get(tempT.user);
            int tempIndex = indexMap.get(tempT.user);
            if (tempIndex > 0) {
                tweets.offer(tempTweets.get(tempIndex - 1));
                indexMap.put(tempT.user, tempIndex - 1);
            }
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.get(followerId) != null)
            followMap.get(followerId).remove(new Integer(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
