package com.fotoplace.test.base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonParser;
import com.pajk.test.utils.CommonUtil;
import com.pajk.test.utils.ConfigProperty;
import com.pajk.test.utils.LogUtil;
 

/**
 * 类DriverOperate.java的实现描述：TODO 类实现描述
 * 
 * @author guoqiang 2015年1月12日 下午4:33:32
 */
@Test
public class DriverOperate {

/*    private static final JsonParser parser = new JsonParser();

    protected static Driver       driver = null;

    public void init(Object obj) {
    	
        PageFactory.initElements(driver, obj);
    }

    public static Driver createDriver() throws MalformedURLException {
    	
        String appiumURL = ConfigProperty.get("appiumURL");
        DesiredCapabilities capability = new DesiredCapabilities();
        File classrootpath = new File(System.getProperty("user.dir"));
        File appDir = new File(classrootpath, ConfigProperty.get("appDir"));
        File app = new File(appDir, ConfigProperty.get("app"));
        capability.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
        capability.setCapability("device", ConfigProperty.get("device"));
        capability.setCapability(CapabilityType.BROWSER_NAME, "");
        capability.setCapability(CapabilityType.VERSION, ConfigProperty.get("version"));
        capability.setCapability("deviceName", ConfigProperty.get("deviceName"));
        capability.setCapability("app", app.getAbsolutePath());
        capability.setCapability("app-package", ConfigProperty.get("app-package"));
        capability.setCapability("app-activity", ConfigProperty.get("app-activity"));
        capability.setCapability("appWaitLoginActivity", "cc.fotoplace.app.ui.login.LoginActivity");
        //中文包的支持
        capability.setCapability("unicodeKeyboard", true);
        capability.setCapability("resetKeyboard", true);
        String sessionAppium = getSessionInAppium(appiumURL);
        // 读取当前服务器上是否有Session
        if (sessionAppium != "") {
            String sessionLocal = getLocalSession();
            // 判断上次的Session 和服务器上的Session是否一致
            if (sessionAppium.equals(sessionLocal)) {
                // 一致，则删除该Session
                deleteSession(sessionAppium, appiumURL);
            } else {
                // 不一致，说明有其他人正在使用中
                System.err.println("Android机器正在被其他用户的程序使用，请稍会再试");
            }
        }
        // 如果无，则直接创建新的Session
        driver = new Driver(new URL(appiumURL), capability);
        // 设置默认等待时间是60秒
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // 保持创建的Session在本地
        sessionAppium = getSessionInAppium(appiumURL);
        saveSession(sessionAppium);
        
        return driver;
    }

    public static void stopDriver() {
        driver.quit();
    }

    
  private static String getSessionInAppium(String url) {
        String jsonStr = "";
        String sessionId = "";
        url = url + "/status";
        try {
            jsonStr = doGet(url);
        } catch (Exception e) {
            // e.printStackTrace();
            LogUtil.info("无法访问Appium服务,请检查Appium服务是否启动,IP地址是否正确或服务器是否锁屏.");
            return null;
        }
        try {
            // jsonStr = jsonStr.replaceFirst("/n", "");
            sessionId = parser.parse(jsonStr).getAsJsonObject().get("sessionId").getAsString();
            // System.out.println("sessionId:"+sessionId);
        } catch (Exception e) {
            return "";
        }
        return sessionId;
    }

   private static String getLocalSession() {
        return readFile();
    }

    public static String readFile() {
        File file = new File("session.txt");
        BufferedReader reader = null;
        String tempString = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            tempString = reader.readLine();
            reader.close();
        } catch (IOException e) {
            // e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return tempString;
    }

    public static void saveFile(String sessionID) {
        String filename = "session.txt";
        try {
            OutputStream os = new FileOutputStream(filename);
            os.write(sessionID.getBytes());
            os.close();
        } catch (IOException ex) {
            LogUtil.info("保存session失败");
        }
    }

      private static String doGet(String urlStr) throws Exception {
        // System.out.println("GET:" + urlStr);
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        System.setProperty("sun.net.client.defaultConnectTimeout", "3000");
        System.setProperty("sun.net.client.defaultReadTimeout", "3000");

        conn.setRequestMethod("GET");

        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        conn.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        String result = "";
        while ((line = br.readLine()) != null) {
            result += line;
        }
        System.out.println(result);
        br.close();
        return result;
    }

    private static void doDelete(String urlStr) throws Exception {
        System.out.println("DELETE:" + urlStr);
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("DELETE");
        if (conn.getResponseCode() == 200) {
            // System.out.println("成功");
        } else {
            // System.out.println(conn.getResponseCode());
        }
    }

    private static void deleteSession(String sessionID, String url) {
        url = url + "/session/" + sessionID;
        try {
            doDelete(url);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.info("删除Session失败");
        }
    }

    private static void saveSession(String sessionAppium) {
        saveFile(sessionAppium);
    }
    */
	
	
	private AppiumDriver driver;
	
       @BeforeTest
       public void setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps/ContactManager");
        File app = new File(appDir, "fotoplace_v2.3.4.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
        capabilities.setCapability("deviceName","9c4e536f");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "cc.fotoplace.app");
        capabilities.setCapability("appActivity", "cc.fotoplace.app.ui.InitActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
       System.out.println("tettttt");
       }

       @AfterTest
       public void tearDown() throws Exception {
           driver.quit();
       }

    @Test
    public void  UserLogin(){
        	
        WebElement el = driver.findElement(By.id("cc.fotoplace.app:id/btn_register"));
    	CommonUtil.sleep(3000);
    	el.click();
     	CommonUtil.sleep(3000);
     	
  /*   	WebElement username = driver.findElement(By.id("cc.fotoplace.app:id/edit_username"));
     	username.sendKeys("13774294435");
     	CommonUtil.sleep(2000);
     	
     	WebElement password = driver.findElement(By.id("cc.fotoplace.app:id/edit_pwd"));
        password.sendKeys("zxcv1234");
     	CommonUtil.sleep(1000);
     	
     	WebElement loginButtion =  driver.findElement(By.id("cc.fotoplace.app:id/txt_sure"));
     	loginButtion.click();*/
     
    }
    
}
