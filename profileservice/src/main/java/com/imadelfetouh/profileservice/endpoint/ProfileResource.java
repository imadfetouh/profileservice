package com.imadelfetouh.profileservice.endpoint;

import com.google.gson.Gson;
import com.imadelfetouh.profileservice.dalinterface.ProfileDal;
import com.imadelfetouh.profileservice.model.dto.ProfileDTO;
import com.imadelfetouh.profileservice.model.jwt.UserData;
import com.imadelfetouh.profileservice.model.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileResource {

    @Autowired
    private ProfileDal profileDal;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDTO> getProfile(@RequestAttribute("userdata") String userDataString) {
        Gson gson = new Gson();
        UserData userData = gson.fromJson(userDataString, UserData.class);

        ResponseModel<ProfileDTO> responseModel = profileDal.getProfile(userData.getUserId());

        return ResponseEntity.ok().body(responseModel.getData());
    }
}
