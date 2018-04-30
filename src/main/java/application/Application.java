package application;


import application.service.FileStorageService;
import application.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;

/**
 * Created by ManhNguyen on 10/11/17.
 */
@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages = "application")
public class Application {

    private static final Logger logger = LogManager.getLogger(Application.class);

    @Resource
    FileStorageService storageService;

    @Resource
    UserService userService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
