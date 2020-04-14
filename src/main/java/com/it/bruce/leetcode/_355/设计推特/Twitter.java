package com.it.bruce.leetcode._355.设计推特;

import java.util.*;

public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
    }

    private Map<Integer, Set<Integer>> followeeMap;

    private Map<Integer, Integer> tweetToUserMap;

    private List<Integer> list;

    public Twitter() {
        followeeMap = new HashMap<>();
        tweetToUserMap = new HashMap<>();
        list = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetToUserMap.put(tweetId, userId);
        list.add(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0 && result.size() < 10; i--) {
            int owner = tweetToUserMap.get(list.get(i));
            if (owner == userId || (followeeMap.containsKey(userId) && followeeMap.get(userId).contains(owner))) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!followeeMap.containsKey(followerId)) {
            followeeMap.put(followerId, new HashSet<>());
        }
        followeeMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeMap.containsKey(followerId)) {
            followeeMap.get(followerId).remove(followeeId);
        }
    }
}
