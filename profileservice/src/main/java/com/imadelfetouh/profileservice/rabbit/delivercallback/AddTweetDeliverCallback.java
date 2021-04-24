package com.imadelfetouh.profileservice.rabbit.delivercallback;

import com.google.gson.Gson;
import com.imadelfetouh.profileservice.dal.configuration.Executer;
import com.imadelfetouh.profileservice.dal.configuration.SessionType;
import com.imadelfetouh.profileservice.dal.queryexecuter.AddTweetExecuter;
import com.imadelfetouh.profileservice.model.dto.NewTweetDTO;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddTweetDeliverCallback implements DeliverCallback {

    private final static Logger logger = Logger.getLogger(AddTweetDeliverCallback.class.getName());

    private Gson gson;

    public AddTweetDeliverCallback() {
        gson = new Gson();
    }

    @Override
    public void handle(String s, Delivery delivery) {
        try {
            String json = new String(delivery.getBody(), StandardCharsets.UTF_8);
            NewTweetDTO newTweetDTO = gson.fromJson(json, NewTweetDTO.class);

            Executer<Void> executer = new Executer<>(SessionType.WRITE);
            executer.execute(new AddTweetExecuter(newTweetDTO));
        }
        catch (Exception e) {
            logger.log(Level.ALL, e.getMessage());
        }
    }
}
