package com.imadelfetouh.profileservice.rabbit;

import com.rabbitmq.client.Channel;

public interface NonStopConsumer {

    void consume(Channel channel);
}
