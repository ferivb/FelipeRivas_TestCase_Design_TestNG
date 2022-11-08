package com.globant;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.logging.Logger;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static final Logger log = Logger.getLogger(String.valueOf(AppTest.class));

    @BeforeTest
    public void checkIfValidAccount(){
        boolean loginSuccess = false;
        log.info("Opening browser");
        log.info("Navigating to: https://www.espnqa.com/?_adbock=true&src=com&espn=cloud");
        log.info("Clicking on top right option");
        log.info("Clicking on login");
        log.info("Typing in user and password");
        loginSuccess = true;
        Assert.assertTrue(loginSuccess);
        System.out.println("");
    }

    @BeforeClass
    public void openBrowser(){
        log.info("Opening Browser");
        System.out.println("");
    }

    @BeforeMethod
    public void navigateToESPNHome(){
        log.info("Double clicking the address bar");
        log.info("Entering the address: https://www.espnqa.com/?_adbock=true&src=com&espn=cloud");
        log.info("Pressing Enter");
        System.out.println("");
    }

    @AfterMethod
    public void clearingCookies(){
        log.info("Cleaning all cookies");
        System.out.println("");
    }

    @AfterClass
    public void closeBrowser(){
        log.info("Click on the right top corner exit button");
        System.out.println("");
    }

}
