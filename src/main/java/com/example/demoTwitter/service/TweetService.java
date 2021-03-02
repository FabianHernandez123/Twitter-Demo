package com.example.demoTwitter.service;

import com.example.demoTwitter.model.Tweet;
import com.example.demoTwitter.model.User;
import com.example.demoTwitter.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    //start wiring methods up?

    public List<Tweet> findAll() {
        //find All the tweets in the repository.
        List<Tweet> tweets = tweetRepository.findAllByOrderByCreatedAtDesc();
        return tweets;
    }

    //putting in User model/entity
    public List<Tweet> findAllByUser(User user) {
        List<Tweet> tweets = tweetRepository.findAllByUserOrderByCreatedAtDesc(user);
        return tweets;
    }

    public List<Tweet> findAllByUsers(List<User> users) {
        List<Tweet> tweets = tweetRepository.findAllByUserInOrderByCreatedDesc(users);
        return tweets;
    }

    public void save(Tweet tweet) {
        tweetRepository.save(tweet);
    }
}
