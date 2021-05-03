package com.imadelfetouh.profileservice.endpoint;

import com.google.gson.Gson;
import com.imadelfetouh.profileservice.dalinterface.ProfileDal;
import com.imadelfetouh.profileservice.model.dto.ProfileDTO;
import com.imadelfetouh.profileservice.model.jwt.UserData;
import com.imadelfetouh.profileservice.model.response.ResponseModel;
import com.imadelfetouh.profileservice.model.response.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileResource {

    @Autowired
    private ProfileDal profileDal;

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDTO> getProfileFromUser(@RequestAttribute("userdata") String userDataString, @PathVariable("userId") String userId) {
        Gson gson = new Gson();
        UserData userData = gson.fromJson(userDataString, UserData.class);

        ResponseModel<ProfileDTO> responseModel = profileDal.getProfile(userId, userData.getUserId());

        if(responseModel.getResponseType().equals(ResponseType.USERNOTFOUND)) {
            return ResponseEntity.noContent().build();
        }
        else if(responseModel.getResponseType().equals(ResponseType.CORRECT)) {
            return ResponseEntity.ok().body(responseModel.getData());
        }

        return ResponseEntity.status(500).build();
    }
}
