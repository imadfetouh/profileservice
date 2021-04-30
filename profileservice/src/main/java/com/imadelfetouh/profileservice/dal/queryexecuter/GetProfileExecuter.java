package com.imadelfetouh.profileservice.dal.queryexecuter;

import com.imadelfetouh.profileservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.profileservice.dal.ormmodel.Tweet;
import com.imadelfetouh.profileservice.dal.ormmodel.User;
import com.imadelfetouh.profileservice.model.dto.ProfileDTO;
import com.imadelfetouh.profileservice.model.dto.TweetDTO;
import com.imadelfetouh.profileservice.model.response.ResponseModel;
import com.imadelfetouh.profileservice.model.response.ResponseType;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class GetProfileExecuter implements QueryExecuter<ProfileDTO> {

    private String userId;

    public GetProfileExecuter(String userId) {
        this.userId = userId;
    }

    @Override
    public ResponseModel<ProfileDTO> executeQuery(Session session) {
        ResponseModel<ProfileDTO> responseModel = new ResponseModel<>();

        Query query = session.createQuery("SELECT u FROM User u JOIN FETCH u.profile p JOIN FETCH u.tweets t WHERE u.userId = :userId");
        query.setParameter("userId", userId);

        User user;

        try{
            user = (User) query.getSingleResult();
        }
        catch (NoResultException e) {
            responseModel.setResponseType(ResponseType.USERNOTFOUND);
            return responseModel;
        }

        List<TweetDTO> tweets = new ArrayList<>();
        for(Tweet tweet : user.getTweets()) {
            TweetDTO tweetDTO = new TweetDTO(tweet.getTweetId(), tweet.getContent(), tweet.getDate(), tweet.getTime(), tweet.getLikes());
            tweets.add(tweetDTO);
        }

        ProfileDTO profileDTO = new ProfileDTO(userId, user.getUsername(), user.getPhoto(), user.getProfile().getBio(), user.getProfile().getLocation(), user.getProfile().getWebsite(), tweets);

        responseModel.setData(profileDTO);

        responseModel.setResponseType(ResponseType.CORRECT);

        return responseModel;
    }
}
