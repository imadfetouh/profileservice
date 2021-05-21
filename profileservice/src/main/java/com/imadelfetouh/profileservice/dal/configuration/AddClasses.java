package com.imadelfetouh.profileservice.dal.configuration;

import com.imadelfetouh.profileservice.dal.ormmodel.*;
import org.hibernate.cfg.Configuration;

public class AddClasses {

    private static final AddClasses addClasses = new AddClasses();

    private AddClasses() {

    }

    public static AddClasses getInstance() {
        return addClasses;
    }

    public void setClasses(Configuration configuration) {
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Profile.class);
        configuration.addAnnotatedClass(Tweet.class);
        configuration.addAnnotatedClass(Following.class);
        configuration.addAnnotatedClass(Like.class);
    }
}
