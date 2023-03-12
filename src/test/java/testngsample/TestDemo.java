package testngsample;

import org.testng.annotations.*;

public class TestDemo {
    @Test(priority = 1)
    public void test1() {
        System.out.println("test 1");
    }

    @Test(priority = 1)
    public void Test1() {
        System.out.println("Test 1");
    }

    @Test(priority = -10)
    public void test2() {
        System.out.println("Test 2");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before groups");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After groups");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }

}
