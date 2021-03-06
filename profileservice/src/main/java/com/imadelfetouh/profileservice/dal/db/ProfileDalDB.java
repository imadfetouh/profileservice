package com.imadelfetouh.profileservice.dal.db;

import com.imadelfetouh.profileservice.dal.configuration.Executer;
import com.imadelfetouh.profileservice.dal.configuration.SessionType;
import com.imadelfetouh.profileservice.dal.queryexecuter.GetProfileExecuter;
import com.imadelfetouh.profileservice.dalinterface.ProfileDal;
import com.imadelfetouh.profileservice.model.dto.ProfileDTO;
import com.imadelfetouh.profileservice.model.response.ResponseModel;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDalDB implements ProfileDal {

    @Override
    public ResponseModel<ProfileDTO> getProfile(String userId, String ownId) {
        Executer<ProfileDTO> executer = new Executer<>(SessionType.READ);
        return executer.execute(new GetProfileExecuter(userId, ownId));
    }
}
