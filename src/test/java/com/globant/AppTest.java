package com.globant;

import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @BeforeSuite
    public void openBrowser(){
        System.out.println("Opening browser");
        System.out.println("");
    }

    @BeforeClass
    public void checkAccount(){
        System.out.println("Check if account is valid");
        System.out.println("");
    }

    @BeforeMethod
    public void cleanCookies(){
        System.out.println("Cleaning cookies");
        System.out.println("");
    }

    @BeforeMethod
    public void goToPage(){
        System.out.println("Going to https://www.espnqa.com/?_adbock=true&src=com&espn=cloud");
        System.out.println("");
    }

    @Test(priority = 1)
    public void login(){
        System.out.println("Logging in");
        System.out.println("");
    }

    @Test(priority = 2)
    public void logout(){
        System.out.println("Logging out");
        System.out.println("");
    }

    @Test(priority = 3)
    public void disableUser(){
        System.out.println("disabling the user");
        System.out.println("");
    }

    @AfterSuite
    public void closeBrowser(){
        System.out.println("Closing browser");
    }
}
