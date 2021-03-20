import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public void takeScreenshot (WebDriver driver, String testCase) {

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File folder = new File(System.getProperty("user.dir")+"\\Errores");


            if (!folder.exists()) {
                folder.mkdir();
            }
            FileUtils.copyFile(screenshotFile, new File(folder.getAbsolutePath()+"\\error_"+testCase+"_"+ getDate()+ ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh_mm_ss");
        Date date = new Date();
        return dateFormat.format(date);

  }
}

