package com.sm.steps;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sm.utils.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ApplicationForm {

	RemoteWebDriver driver;
	WebElement uNameLoc, uPassLoc, signinBtn, userBtn, applicationOption, smartBusOption;
	WebElement frameLoc;
	TestUtil test = new TestUtil();
	Properties prop;
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() throws IOException {
		prop = test.readProp();
		if(prop.getProperty("browser").equals("chrome")) {
			Map<String, Object> pref = new HashMap<String, Object>();
		    pref.put("profile.default_content_setting_values.notifications", 2);
		    ChromeOptions options = new ChromeOptions();
		    options.setExperimentalOption("prefs", pref);
			driver = new ChromeDriver(options);
		}else if(prop.getProperty("browser").equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("siteUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Given("enter valid userName {string}")
	public void enter_valid_user_name(String uName) {
		uNameLoc = driver.findElement(By.id("username"));
		uNameLoc.sendKeys(uName);
	}

	@Given("enter valid password {string}")
	public void enter_valid_password(String uPass) {
		uPassLoc = driver.findElement(By.id("password"));
		uPassLoc.sendKeys(uPass);
	}

	@Given("to click on login button")
	public void to_click_on_login_button() {
		signinBtn = driver.findElement(By.xpath("(//button[@name='submit'])[1]"));
		signinBtn.click();
	}

	@When("to click on user button")
	public void to_click_on_user_button() {
		frameLoc = driver.findElement(By.id("divframe"));
		test.handleFrame(driver, frameLoc);
		userBtn = driver.findElement(By.id("user_info_btn"));
		userBtn.click();
	}
	
	@When("to mouse hover at application tab")
	public void to_mouse_hover_at_application_tab() {
	    applicationOption = driver.findElement(By.id("aprojects"));
	    test.mouseHover(applicationOption, driver);
	}
	
	@When("to mouse hover & click at smart bus tab")
	public void to_mouse_hover_click_at_smart_bus_tab() {
	    smartBusOption = driver.findElement(By.xpath("//a[@title='Smart Bus']"));
	    smartBusOption.click();
	}

}
