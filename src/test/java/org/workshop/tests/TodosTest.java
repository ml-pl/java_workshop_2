package org.workshop.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.workshop.framework.pages.Todos;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.testng.Assert.assertEquals;


public class TodosTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void openAndCountTodos() {
        assertEquals(2, Todos.openTodos(driver).numberOfTodos());
    }

    @Test
    public void addTodoAndVerifyThatNumberOfTodosIncreased(){
        Todos.openTodos(driver)
                .addTodo("Some description")
                .verifyCountOfTodos(3);
    }

    @Test
    public void checkATodoAndVerifyThatRemainingCountDecreased(){
        Todos.openTodos(driver);
        throw new NotImplementedException();
    }
}
