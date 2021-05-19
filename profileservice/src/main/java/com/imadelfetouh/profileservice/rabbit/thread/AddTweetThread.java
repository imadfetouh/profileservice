package com.imadelfetouh.profileservice.rabbit.thread;

import com.imadelfetouh.profileservice.rabbit.delivercallback.AddTweetDeliverCallback;
import com.rabbitmq.client.DeliverCallback;
import java.util.logging.Logger;

public class AddTweetThread implements Runnable {

    private Logger logger = Logger.getLogger(AddUserThread.class.getName());

    private final String queue_name;
    private final String exchange_name;
    private final DeliverCallback deliverCallback;

    public AddTweetThread() {
        queue_name = "profileservice_addtweetconsumer";
        exchange_name = "addtweetexchange";
        deliverCallback = new AddTweetDeliverCallback();
    }

    @Override
    public void run() {
        StartConsuming startConsuming = new StartConsuming(queue_name, exchange_name, deliverCallback);
        startConsuming.start();
    }
}
