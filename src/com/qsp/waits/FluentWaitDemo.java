package com.qsp.waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.qsp.utils.DriverUtils;

public class FluentWaitDemo {

	
	public static <F> void main(String[] args) {
		WebDriver driver = DriverUtils.getMyDriver();
		
		driver.get("file:///D:/QSP_EclipseWS/SeleniumPractice/html/CounterText.html");
		
		FluentWait<WebElement> wait = new FluentWait<WebElement>
				(driver.findElement(By.id("counter")))
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class)
				.ignoring(Exception.class);
		
		//https://github.com/AravindaHB/QSP_27_APR
		
		Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>() {
			@Override
			public Boolean apply(WebElement ele) {
				if(ele.getText().equals("3"))
				{
					System.out.println("Found text ......");
					return true;
				}
				else
				{
					System.out.println("waiting......");
					return false;
				}
				//return null;
			}
		};
		wait.until(fun);
		driver.close();
		System.out.println("done");
	}
	
}
