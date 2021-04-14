package com.imadelfetouh.profileservice.dalinterface;

import com.imadelfetouh.profileservice.model.dto.ProfileDTO;
import com.imadelfetouh.profileservice.model.response.ResponseModel;

public interface ProfileDal {

    ResponseModel<ProfileDTO> getProfile(String userId);
}
