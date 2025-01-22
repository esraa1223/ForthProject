package MyPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class Parameters {
	WebDriver driver=new ChromeDriver();
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	Random rand=new Random();
	String RandomIndex=Integer.toString(rand.nextInt(1800,2000));
	String MyQueryToAdd="insert into employees (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) values ("+RandomIndex+ ",\'Tariq\',\'Zeyad\',\'x2311',\'tariq@yahoo.com\',6,1102,\'Engineer\')";
	String MyQueryToUpdate="update employees set lastName='Noor' where employeeNumber="+RandomIndex;
	String MyQueryToRead="select * from employees where employeenumber="+RandomIndex;
	String MyQueryToDelete="delete from employees where employeeNumber="+RandomIndex;
	String WebSite="https://codenboxautomationlab.com/practice/";
	public void TakeScreenShot() throws IOException {
		Date mynewdate= new Date();
		System.out.println(mynewdate);
		String myFile=mynewdate.toString().replace(":","-");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		java.io.File myScreenShot = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(myScreenShot,new java.io.File("./screenshotfolder/",myFile+".jpg"));


	}
	
}
