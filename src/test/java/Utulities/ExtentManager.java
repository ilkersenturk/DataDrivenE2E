package Utulities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;


    public synchronized static ExtentReports createExtentReports(String filePath) {

        extent = new ExtentReports();
        ExtentSparkReporter htmlReport = new ExtentSparkReporter(filePath);
        extent.attachReporter(htmlReport);


        return extent;


    }
}
