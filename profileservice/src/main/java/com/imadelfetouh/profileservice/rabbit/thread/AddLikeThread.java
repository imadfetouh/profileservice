package com.imadelfetouh.profileservice.rabbit.thread;

import com.imadelfetouh.profileservice.rabbit.RabbitNonStopConsumer;
import com.imadelfetouh.profileservice.rabbit.consumer.DefaultConsumer;
import com.imadelfetouh.profileservice.rabbit.delivercallback.AddLikeDeliverCallback;
import com.imadelfetouh.profileservice.rabbit.delivercallback.AddTweetDeliverCallback;
import com.rabbitmq.client.DeliverCallback;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddLikeThread implements Runnable {

    private Logger logger = Logger.getLogger(AddLikeThread.class.getName());

    private final String queue_name;
    private final String exchange_name;
    private final DeliverCallback deliverCallback;

    public AddLikeThread() {
        queue_name = "profileservice_addlikeconsumer";
        exchange_name = "addlikeexchange";
        deliverCallback = new AddLikeDeliverCallback();
    }

    @Override
    public void run() {
        while(true) {
            try {
                RabbitNonStopConsumer rabbitNonStopConsumer = new RabbitNonStopConsumer();
                DefaultConsumer defaultConsumer = new DefaultConsumer(queue_name, exchange_name, deliverCallback);

                rabbitNonStopConsumer.consume(defaultConsumer);
            } catch (Exception e) {
                logger.log(Level.ALL, e.getMessage());
            }
        }
    }
}
