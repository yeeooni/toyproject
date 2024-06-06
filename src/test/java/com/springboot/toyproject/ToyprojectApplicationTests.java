package com.springboot.toyproject;

import com.springboot.toyproject.controller.HelloWorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToyprojectApplicationTests {

    @Autowired
    private HelloWorldController helloWorldController;


    @Test
    void contextLoads() {
        assert helloWorldController != null;
    }
    @Test
    void 헬로월드찍기(){
        //assert helloWorldController.getGreeting().equals("getGreeting");
    }

}
