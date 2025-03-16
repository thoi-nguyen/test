package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        if (extent == null) {
            extent = new ExtentReports();

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter( "extent-report.html");
            sparkReporter.config().setReportName("Test Automation Report");
            sparkReporter.config().setDocumentTitle("Test Report");
            sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);

            sparkReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
            sparkReporter.config().setEncoding("utf-8");

            extent.attachReporter(sparkReporter);
//            return extent;
            // Set system information
//            extent.setSystemInfo("OS", "Windows 10");
//            extent.setSystemInfo("Browsers", "Chrome, Edge, Firefox");
//            extent.setSystemInfo("Author", "ChienPM");
//            extent.setSystemInfo("Test Suite", "ChienPM_Selenium_FinalTest_1");
        }
        return extent;
    }
}
