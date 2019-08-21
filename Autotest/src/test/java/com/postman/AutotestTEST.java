package com.postman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutotestTEST {
	public String username;
	public String password;
	static ChromeDriver driver = new ChromeDriver(); 
	
	public static void checkPage() {
		String title = driver.getTitle();
		if(title.equals("Postman - Sign In")) {
			System.out.println("Не удалось авторизоваться!");
			Assert.assertTrue("Wrong login or password", false);
		} else System.out.println("Авторизация прошла успешно!");
	}
	
	@Before
	public void setInformation() throws FileNotFoundException {
		File file = new File("Information.txt");
		Scanner scanner = new Scanner(file);
		username = scanner.nextLine();
		password = scanner.nextLine();
		scanner.close();
	}
	
	@Test 
	public void testing() throws InterruptedException{ 
		driver.get("https://identity.getpostman.com/login");
		driver.findElementByName("username").sendKeys(username);
		driver.findElementByName("password").sendKeys(password);
		driver.findElementById("sign-in-btn").click();
		Thread.sleep(4000);
		checkPage();
	} 
}
