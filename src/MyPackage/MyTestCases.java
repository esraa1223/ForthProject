package MyPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters {
	

	
	@BeforeTest
	public void Setup() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/classicmodels", "root","esraa");
		driver.get(WebSite);

	}
	
	@Test(priority = 1)
	public void ADDData() throws SQLException {
	
		stmt=con.createStatement();
		int effectiveRow= stmt.executeUpdate(MyQueryToAdd);
		System.out.println(effectiveRow);
		Assert.assertEquals(effectiveRow, 1);
		
	}
	
	@Test(priority=2,enabled=true)
	public void UpdateData() throws SQLException {

		stmt=con.createStatement();
		int effectiveRow=stmt.executeUpdate(MyQueryToUpdate);
		System.out.println(effectiveRow);
		Assert.assertEquals(effectiveRow, 1);
		
	}
	@Test(priority=3,enabled=true)
	public void ReadData() throws SQLException, InterruptedException, IOException {
		
		stmt=con.createStatement();
		rs=stmt.executeQuery(MyQueryToRead);
		
		while(rs.next())
		{
			String Lastname=rs.getNString("lastName");
			Assert.assertEquals(Lastname.length()>0,true);
			System.out.println(Lastname);
			driver.findElement(By.id("name")).sendKeys(Lastname);
			Thread.sleep(2000);
			TakeScreenShot();
			
		}
		
		
	}
	@Test(priority=3,enabled=false)
	public void DeleteData() throws SQLException {
		
		stmt=con.createStatement();
		int effectiveRow=stmt.executeUpdate(MyQueryToDelete);
		System.out.println(effectiveRow);
		Assert.assertEquals(effectiveRow, 1);
		
	}
	
	
	
	

}
