package com.parag.seleniumdesign.test.command;

import com.parag.seleniumdesign.command.HomePage;
import com.parag.seleniumdesign.test.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage(){
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest(){
        this.homePage.goTo();
        /*
         for(ElementValidator ev : this.homePage.getElementValidators())
         {
        boolean resutlts= ev.validate();
         Assert.assertTrue(resutlts);
         }
         * 
         * 
         */
        
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));
    }

}
