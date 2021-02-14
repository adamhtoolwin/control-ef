package com.falcon.controlef;

import com.falcon.controlef.controllers.services.VideoService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VideoServiceTests {

    @Autowired
    VideoService vidService1;
    
    @Autowired
    VideoService vidService2;

    @Test
    void getVideoService() {
        Assertions.assertSame(vidService1, vidService2);
    }
}
