import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_login extends Base {


    By INPUT_username = By.id("usernameOrEmail");
    By BTN_continue= By.xpath("//button[@locale=\"en\"]");

    public Page_login(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }


    public void signIn(String user) {

        sendKeys(user, INPUT_username);
        click(BTN_continue);

        }

    }

