package com.imadelfetouh.profileservice.dal.queryexecuter;

import com.imadelfetouh.profileservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.profileservice.model.dto.ProfileDTO;
import com.imadelfetouh.profileservice.model.dto.TweetDTO;
import com.imadelfetouh.profileservice.model.response.ResponseModel;
import com.imadelfetouh.profileservice.model.response.ResponseType;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class GetProfileExecuter implements QueryExecuter<ProfileDTO> {

    private String userId;
    private String ownId;

    public GetProfileExecuter(String userId, String ownId) {
        this.userId = userId;
        this.ownId = ownId;
    }

    @Override
    public ResponseModel<ProfileDTO> executeQuery(Session session) {
        ResponseModel<ProfileDTO> responseModel = new ResponseModel<>();

        Query query = session.createQuery("SELECT new com.imadelfetouh.profileservice.model.dto.ProfileDTO(u.userId, u.username, u.photo, p.bio, p.location, p.website, (SELECT COUNT(f.user.id) FROM Following f WHERE f.user.userId = :userId), (SELECT COUNT(f.userFollowing.id) FROM Following f WHERE f.userFollowing.userId = :userId), (SELECT f.id FROM Following f WHERE f.user.userId = :ownId AND f.userFollowing.userId = :userId)) FROM User u LEFT JOIN u.profile p WHERE u.userId = :userId");
        query.setParameter("userId", userId);
        query.setParameter("ownId", ownId);

        ProfileDTO profileDTO;

        try{
            profileDTO = (ProfileDTO) query.getSingleResult();
            Query queryTweets = session.createQuery("SELECT new com.imadelfetouh.profileservice.model.dto.TweetDTO(t.tweetId, t.content, t.date, t.time, size(t.likes), (CASE WHEN (SELECT l.user FROM t.likes l WHERE l.user.userId = :ownId AND l.tweet.tweetId = t.tweetId) = null then false else true end)) FROM Tweet t WHERE t.user.userId = :userId");
            queryTweets.setParameter("ownId", userId);
            queryTweets.setParameter("userId", userId);
            List<TweetDTO> tweets = queryTweets.getResultList();
            profileDTO.setTweets(tweets);
        }
        catch (NoResultException e) {
            responseModel.setResponseType(ResponseType.USERNOTFOUND);
            return responseModel;
        }

        responseModel.setData(profileDTO);

        responseModel.setResponseType(ResponseType.CORRECT);

        return responseModel;
    }
}
