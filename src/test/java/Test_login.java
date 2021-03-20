import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test_login {
    WebDriver driver;
    Page_login loginPage;
    Util util;

    @BeforeClass
    public void beforeClass() {

        loginPage = new Page_login(driver);
        driver = loginPage.getChromeDriver();
        util = new Util();
        loginPage.visit("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

    }

    @Test
    public void login_TEST() {

        String user = "test001@yopmail.com";


        try {

            loginPage.signIn(user);

            //En caso de que exista un bug se tomara un Screenshot evidenciando el problema
        } catch (Exception e) {
            util.takeScreenshot(driver,"Login");
            assertTrue(false);
        }
    }

  @AfterClass
  public void afterClass() { driver.quit();
   }


}
