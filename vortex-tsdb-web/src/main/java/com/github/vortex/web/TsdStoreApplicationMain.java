package com.github.vortex.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.doodler.common.Constants;
import com.github.doodler.common.utils.NetUtils;
import com.github.vortex.tsd.EnableTsdStoreServer;

/**
 * 
 * @Description: TsdStoreApplicationMain
 * @Author: Fred Feng
 * @Date: 02/01/2025
 * @Version 1.0.0
 */
@EnableTsdStoreServer
@SpringBootApplication
public class TsdStoreApplicationMain {

    public static void main(String[] args) {
        int serverPort =
                NetUtils.getRandomPort(Constants.SERVER_PORT_FROM, Constants.SERVER_PORT_TO);
        System.setProperty("server.port", String.valueOf(serverPort));
        System.out.println("serverPort: " + serverPort);
        SpringApplication.run(TsdStoreApplicationMain.class, args);
    }
}
