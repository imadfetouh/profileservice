package com.imadelfetouh.profileservice.dal.configuration;

import com.imadelfetouh.profileservice.model.response.ResponseModel;
import org.hibernate.Session;

public interface QueryExecuter<T> {

    ResponseModel<T> executeQuery(Session session);
}
