package com.imadelfetouh.profileservice;

import com.imadelfetouh.profileservice.dal.configuration.Executer;
import com.imadelfetouh.profileservice.dal.configuration.SessionType;
import com.imadelfetouh.profileservice.dal.db.ProfileDalDB;
import com.imadelfetouh.profileservice.model.dto.ProfileDTO;
import com.imadelfetouh.profileservice.model.response.ResponseModel;
import com.imadelfetouh.profileservice.model.response.ResponseType;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProfileRabbitTest {

    @BeforeAll
    static void setupDatabase() {
        Executer<Void> executer = new Executer<>(SessionType.WRITE);
        executer.execute(new SetupTestDatabase());
    }

    @Test
    @Order(1)
    void getUsersCorrect() {
        ProfileDalDB profileDalDB = new ProfileDalDB();

        ResponseModel<ProfileDTO> responseModel = profileDalDB.getProfile("u123", "u123");

        Assertions.assertEquals(ResponseType.CORRECT, responseModel.getResponseType());
        Assertions.assertEquals("imad", responseModel.getData().getUsername());
        Assertions.assertEquals("u123", responseModel.getData().getUserId());

    }

}
