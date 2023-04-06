package com.HRM.Practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccCricket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    WebDriver driver = WebDriverManager.chromedriver().create();
    //maximize the browser
    driver.manage().window().maximize();
    driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");  
    
         //TO GET THE TEAM NAMES 
    List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td[2]"));
    /*for(int i=0;i<team.size();i++)
    {
    	System.out.println(team.get(i).getText());
    }
    
    */
     List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
     for(int i=0;i<team.size();i++)
     {
     	System.out.println(team.get(i).getText()+" "+matches.get(i).getText());
     }
     
     ArrayList<String> list = new ArrayList<String>();
      for(int i=0;i<team.size();i++)
      {
    	  list.add(team.get(i).getText());
      }
      for(String myTeam:list)
      {
    	  String rating="//span[.='India']/../following-sibling::td[3]";
    	 
    	  String Rating=driver.findElement(By.xpath(rating)).getText();
    	  System.out.println("team-> "+myTeam+" ->(rating is) ->"+Rating);  
      }
      
      
	}

}
