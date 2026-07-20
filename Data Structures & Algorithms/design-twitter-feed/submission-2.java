class Twitter {

    public record Tweet(int tweetId, int count){}

    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, List<Tweet>> userTweets;
    static int count = 0;

    public Twitter() {
        followerMap = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(tweetId,++count));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>((p,q)-> p.count()-q.count()); 
        Set<Integer> followers = followerMap.getOrDefault(userId, new HashSet<>());
        followers.add(userId);
        for(int follower: followers){
            List<Tweet> tweets = userTweets.getOrDefault(follower, new ArrayList<>());
            for(Tweet tweet: tweets){
                minHeap.offer(tweet);
                if(minHeap.size()>10) minHeap.poll();
            } 
        }
        List<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(0,minHeap.poll().tweetId());
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followerMap.get(followerId).remove((Integer)followeeId);
    }
}
