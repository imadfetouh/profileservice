package com.imadelfetouh.profileservice.rabbit.thread;

import com.imadelfetouh.profileservice.rabbit.delivercallback.AddLikeDeliverCallback;
import com.rabbitmq.client.DeliverCallback;
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
        StartConsuming startConsuming = new StartConsuming(queue_name, exchange_name, deliverCallback);
        startConsuming.start();
    }
}
