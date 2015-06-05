package com.fotoplace.test.modl;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

import com.fotoplace.test.base.BaseTest;

public class LoginModl  extends BaseTest{
	
	   public void LoginPage(AndroidDriver driver){
		   PageFactory.initElements(driver, this);
	   }
	   
	   

}
