package com.fotoplace.test.base;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver extends AndroidDriver {
	
	/**
	 * 类Driver.java的封装基类：TODO 类实现描述
	 * 
	 * @author guoqiang 2015年1月12日 下午4:33:32
	 */
	public Driver(URL remoteAddress, Capabilities desiredCapabilities) {
		super(remoteAddress, desiredCapabilities);	
	}
	/**
     * @Title: findElementByTextView
     * @Description: 查找button并点击
     * @param
     * @return
     * @throws
     */ 
     public void findElementByTextViewOnClick() {
         super.findElementByClassName(AndroidClassNameTest.TextView).click();
     }    
     /**
      * @Title: findElementByTextView
      * @Description: 查找button对象
      * @param
      * @return
      * @throws
      */ 
     public WebElement findElementByTextView(){
    	 return super.findElementByClassName(AndroidClassNameTest.TextView);
    	 
     }
     /**
      * @Title: findElementByTextView
      * @Description: 查找button对象
      * @param
      * @return
      * @throws
      */ 
     public List<WebElement> findElementListByTextView(){ 
    	 return super.findElementsByClassName(AndroidClassNameTest.TextView);  	 
     }
     /**
      * @Title: findElementByTextView
      * @Description: 查找多个EditText对象
      * @param
      * @return
      * @throws
      */  
     public WebElement  findElementByEditText(){
		return super.findElementByClassName(AndroidClassNameTest.EditText);   	 
     }
     /**
      * @Title: findElementByEditText
      * @Description: 查找EditTex多个t对象
      * @param
      * @return
      * @throws
      */ 
     public List <WebElement> findElementListEditText(){
		return super.findElementsByClassName(AndroidClassNameTest.EditText);  	 
     }
     /**
      * @Title: findLinearLayout
      * @Description: 查找并点击LinearLayoutt
      * @param
      * @return
      * @throws
      */
     public void findElemnentLinearLayoutOnclick(){
    	 super.findElementByClassName(AndroidClassNameTest.LinearLayout).click();
    	 
     }
     /**
      * @Title: findLinearLayout
      * @Description: 查找LinearLayoutt对象
      * @param
      * @return
      * @throws
      */
     public WebElement findElemnentLinearLayout(){
		return super.findElementByClassName(AndroidClassNameTest.LinearLayout);
    	 
     }
     /**
      * @Title: findLinearLayout
      * @Description: 查找LinearLayoutt多个对象
      * @param
      * @return
      * @throws
      */
     public List<WebElement> findElementListLinearLayout(){
    	 return super.findElementsByClassName(AndroidClassNameTest.LinearLayout);
     }
     
     /**
      * @Title: RelativeLayout
      * @Description:查找并点击RelativeLayout
      * @param
      * @return
      * @throws
      */
     public void findElementRelativeLayout(){
    	   super.findElementByClassName(AndroidClassNameTest.RelativeLayout).click();
    	 
     }
     /**
      * @Title: RelativeLayout
      * @Description:查找findElementByRelativeLayout对象
      * @param
      * @return
      * @throws
      */
    public WebElement findElementByRelativeLayout(){
		return super.findElementByClassName(AndroidClassNameTest.RelativeLayout);
    	
    }
    /**
     * @Title: RelativeLayout
     * @Description:查找多个findElementListRelativeLayout对象
     * @param
     * @return
     * @throws
     */
     public List<WebElement> findElementListRelativeLayout(){
		return super.findElementsByClassName(AndroidClassNameTest.RelativeLayout);
    	 
     }
     /**
      * @Title: findElementImageViewOnclick
      * @Description:查找并点击 ImageView
      * @param
      * @return
      * @throws
      */
     public void findElementImageViewOnclick(){
    	 super.findElementByClassName(AndroidClassNameTest.ImageView).click(); 	 
     }
     /**
      * @Title: findElementImageViewOnclick
      * @Description:查找ImageView对象
      * @param
      * @return
      * @throws
      */
     public  WebElement findElementByImageView(){
		return super.findElementByClassName(AndroidClassNameTest.ImageView);
    	 
     }
     /**
      * @Title: findElementImageViewOnclick
      * @Description:查找多个ImageView对象
      * @param
      * @return
      * @throws
      */
    public List<WebElement> findElementListImageview(){
		return super.findElementsByClassName(AndroidClassNameTest.ImageView);
    	
    }
    /**
     * @Title: findElementImageButtonOnclick
     * @Description:查找并点击ButtonOnclick
     * @param
     * @return
     * @throws
     */
    public void findElementImageButtonOnclick(){
    	super.findElementByClassName(AndroidClassNameTest.ImageButtion).click();
    }
    /**
     * @Title: findElementImageButtonOnclick
     * @Description:查找ButtonOnclick对象
     * @param
     * @return
     * @throws
     */
    public WebElement findElementByImageButton(){
		return super.findElementByClassName(AndroidClassNameTest.ImageButtion);
    	
    }
    /**
     * @Title: findElementImageButtonOnclick
     * @Description:查找多个ButtonOnclick对象
     * @param
     * @return
     * @throws
     */
    public List<WebElement> findElementListImageButton(){
		return super.findElementsByClassName(AndroidClassNameTest.ImageButtion);
    	
    }
}