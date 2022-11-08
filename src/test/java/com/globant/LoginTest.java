package com.globant;

import org.testng.annotations.Test;

public class LoginTest extends AppTest{

    @Test
    public void testingLogin(){
        log.info("Click on the top right person icon");
        log.info("Click on the 'log in' option");
        log.info("Enter username: valid_user");
        log.info("Enter password: ********");
        log.info("Click on 'log in'");
        System.out.println("");
    }
}
