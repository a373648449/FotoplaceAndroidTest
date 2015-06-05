package com.fotoplace.test.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 类BasePage.java的实现描述：TODO 抽取APP中公共的界面元素
 *
 * @author guoqiang 2015年4月20日 上午11:33:57
 */
public class BasePage {
	
	@FindBy(className = AndroidClassNameTest.EditText)
	   public static WebElement edittext;

	@FindBy(className = AndroidClassNameTest.TextView)
	    public static WebElement  TextView;
	
	@FindBy(className = AndroidClassNameTest.ImageView )
	   public static WebElement ImageView;
	
	@FindBy(className = AndroidClassNameTest.ImageButtion)
	    public static WebElement ImageButtion;
	
	@FindBy(className = AndroidClassNameTest.LinearLayout)
	   public static WebElement LinearLayout;
	
	@FindBy(className = AndroidClassNameTest.RelativeLayout)
	    public static WebElement RelativeLayout;
}
