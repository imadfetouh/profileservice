package com.imadelfetouh.profileservice;

import com.imadelfetouh.profileservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.profileservice.dal.ormmodel.Profile;
import com.imadelfetouh.profileservice.dal.ormmodel.Tweet;
import com.imadelfetouh.profileservice.dal.ormmodel.User;
import com.imadelfetouh.profileservice.model.response.ResponseModel;
import org.hibernate.Session;

public class SetupTestDatabase implements QueryExecuter<Void> {
    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        Profile profile = new Profile("p123", "bio", "location", "website");
        User user = new User("u123", "imad", "imad.jpg", profile);

        session.persist(profile);
        session.persist(user);

        session.getTransaction().commit();

        return responseModel;
    }
}
