package Utulities.Listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Utulities.ExtentManager;
import Utulities.ScreenShotUtil;
import Utulities.TestBase;

import java.util.Date;
public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();
    static Date d = new Date();
    static String fileName = "Extent_Report.html";
    static String filePath = System.getProperty("user.dir") + "/target/surefire-reports/" + fileName;
    private static final ExtentReports extent = ExtentManager.createExtentReports(filePath);
    static String methodName;


    @Override
    public void onTestStart(ITestResult result) {


        String className = result.getTestClass().getName();
        methodName = result.getMethod().getMethodName();

        ExtentTest test = extent.createTest(className, methodName);
        testReport.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {


        String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);

    }

    @Override
    public void onTestFailure(ITestResult result) {


        ScreenShotUtil.captureScreenshot();
        testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
                MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotUtil.screenshotName)
                        .build());


        String failureLogg = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        testReport.get().skip(m);
    }


    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext context) {


        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("Test on finish");
        if (extent != null) {

            extent.flush();
        }
    }
}