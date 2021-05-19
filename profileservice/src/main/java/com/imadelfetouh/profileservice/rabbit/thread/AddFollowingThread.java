package com.imadelfetouh.profileservice.rabbit.thread;

import com.imadelfetouh.profileservice.rabbit.delivercallback.AddFollowingDeliverCallback;
import com.rabbitmq.client.DeliverCallback;
import java.util.logging.Logger;

public class AddFollowingThread implements Runnable {

    private Logger logger = Logger.getLogger(AddFollowingThread.class.getName());

    private final String queue_name;
    private final String exchange_name;
    private final DeliverCallback deliverCallback;

    public AddFollowingThread() {
        queue_name = "profileservice_addfollowingconsumer";
        exchange_name = "addfollowingexchange";
        deliverCallback = new AddFollowingDeliverCallback();
    }

    @Override
    public void run() {
        StartConsuming startConsuming = new StartConsuming(queue_name, exchange_name, deliverCallback);
        startConsuming.start();
    }
}
