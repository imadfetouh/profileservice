package com.imadelfetouh.profileservice.dal.queryexecuter;

import com.imadelfetouh.profileservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.profileservice.dal.ormmodel.Profile;
import com.imadelfetouh.profileservice.dal.ormmodel.User;
import com.imadelfetouh.profileservice.model.dto.NewUserDTO;
import com.imadelfetouh.profileservice.model.response.ResponseModel;
import com.imadelfetouh.profileservice.model.response.ResponseType;
import org.hibernate.Session;

public class AddUserExecuter implements QueryExecuter<Void> {

    private NewUserDTO newUserDTO;

    public AddUserExecuter(NewUserDTO newUserDTO) {
        this.newUserDTO = newUserDTO;
    }

    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        Profile profile = new Profile(newUserDTO.getProfile().getProfileId(), newUserDTO.getProfile().getBio(), newUserDTO.getProfile().getLocation(), newUserDTO.getProfile().getWebsite());

        User user = new User(newUserDTO.getUserId(), newUserDTO.getUsername(), newUserDTO.getPhoto(), profile);

        session.persist(profile);
        session.persist(user);

        session.getTransaction().commit();

        responseModel.setResponseType(ResponseType.CORRECT);

        return responseModel;
    }
}
