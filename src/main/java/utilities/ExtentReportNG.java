package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
   static ExtentReports extent;
   
   public static ExtentReports ExtentReportGenerator() {
	   String path= System.getProperty("user.dir")+"\\reports\\extentReport.html";
	   ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	   reporter.config().setReportName("Automation Test Result");
	   reporter.config().setDocumentTitle("Tests Result");
	   
	   extent= new ExtentReports();
	   extent.attachReporter(reporter);
	   extent.setSystemInfo("Environment","QA");
	   extent.setSystemInfo("Tested By","Siddheshwar Patil");
	   
	   return extent;
   }
}
