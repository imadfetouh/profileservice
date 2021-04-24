package com.imadelfetouh.profileservice.startup;

import com.imadelfetouh.profileservice.rabbit.thread.AddTweetThread;
import com.imadelfetouh.profileservice.rabbit.thread.AddUserThread;
import com.imadelfetouh.profileservice.rabbit.thread.DeleteUserThread;
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
        Executor executor = Executors.newScheduledThreadPool(3);

        AddUserThread addUserThread = new AddUserThread();
        executor.execute(addUserThread);

        DeleteUserThread deleteUserThread = new DeleteUserThread();
        executor.execute(deleteUserThread);

        AddTweetThread addTweetThread = new AddTweetThread();
        executor.execute(addTweetThread);
    }
}
