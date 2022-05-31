package Utulities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import static Utulities.TestBase.driver;


public class ScreenShotUtil {

    public static String screenshotName;

    public static String screenshotPath;

    public static void captureScreenshot() {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        screenshotPath = System.getProperty("user.dir") +"/reports/"+screenshotName;

        try {
            FileUtils.copyFile(scrFile, new File(screenshotPath));
        } catch (IOException e) {
            System.out.println("could not save the screenshot");
        }


    }
}
