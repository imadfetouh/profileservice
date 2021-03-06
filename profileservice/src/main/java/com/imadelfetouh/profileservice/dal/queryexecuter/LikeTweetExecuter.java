package com.imadelfetouh.profileservice.dal.queryexecuter;

import com.imadelfetouh.profileservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.profileservice.dal.ormmodel.Like;
import com.imadelfetouh.profileservice.dal.ormmodel.Tweet;
import com.imadelfetouh.profileservice.dal.ormmodel.User;
import com.imadelfetouh.profileservice.model.response.ResponseModel;
import com.imadelfetouh.profileservice.model.response.ResponseType;
import org.hibernate.Session;

import javax.persistence.Query;

public class LikeTweetExecuter implements QueryExecuter<Void> {

    private String userId;
    private String tweetId;

    public LikeTweetExecuter(String userId, String tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }

    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        User user = getUser(session);
        Tweet tweet = getTweet(session);

        Like like = new Like(tweet, user);

        session.persist(like);

        session.getTransaction().commit();

        responseModel.setResponseType(ResponseType.CORRECT);
        return responseModel;
    }

    private User getUser(Session session) {
        Query query = session.createQuery("SELECT u FROM User u WHERE u.userId = :userId");
        query.setParameter("userId", userId);
        return (User) query.getSingleResult();
    }

    private Tweet getTweet(Session session) {
        Query query = session.createQuery("SELECT t FROM Tweet t WHERE t.tweetId = :tweetId");
        query.setParameter("tweetId", tweetId);
        return (Tweet) query.getSingleResult();
    }
}
