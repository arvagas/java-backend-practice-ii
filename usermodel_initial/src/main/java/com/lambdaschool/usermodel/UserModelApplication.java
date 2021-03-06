package com.lambdaschool.usermodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Main class to start the application.
 */
@SpringBootApplication
@EnableJpaAuditing // tells Spring to have Entity listeners work, default is not running
public class UserModelApplication
{

    /**
     * Main method to start the application.
     *
     * @param args Not used in this application.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(UserModelApplication.class,
                              args);
    }
}
