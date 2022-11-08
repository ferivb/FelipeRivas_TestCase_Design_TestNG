package com.globant;

import org.testng.annotations.Test;

public class AccountDeactivationTest extends AppTest{

    @Test
    public void deactivateAccount(){
        log.info("Click on the top right person icon");
        log.info("Click on 'ESPN profile'");
        log.info("Click on the top right person icon");
        log.info("Scroll down and click on delete account");
        log.info("Click on 'Yes, delete this account'");
        log.info("Click on Ok");
        System.out.println("");
    }

}
