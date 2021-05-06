package com.imadelfetouh.profileservice.startup;

import com.imadelfetouh.profileservice.rabbit.thread.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Profile("!test")
@Component
public class RabbitListeners implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Executor executor = Executors.newScheduledThreadPool(5);

        AddUserThread addUserThread = new AddUserThread();
        executor.execute(addUserThread);

        DeleteUserThread deleteUserThread = new DeleteUserThread();
        executor.execute(deleteUserThread);

        AddTweetThread addTweetThread = new AddTweetThread();
        executor.execute(addTweetThread);

        AddFollowingThread addFollowingThread = new AddFollowingThread();
        executor.execute(addFollowingThread);

        AddLikeThread addLikeThread = new AddLikeThread();
        executor.execute(addLikeThread);
    }
}
