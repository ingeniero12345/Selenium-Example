package com.hernan.test;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestPSLInternetExplorer {
  private WebDriver driver;
  private String baseUrl;
  private String baseUrl2;
  private String baseUrl3;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  //@Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.ie.driver","src/test/resources/IEDriverServer.exe");
    driver = new InternetExplorerDriver();
    baseUrl = "http://automatizacion.herokuapp.com/hnieto/addDoctor";
    baseUrl2 = "http://automatizacion.herokuapp.com/hnieto/addPatient";
    baseUrl3 = "http://automatizacion.herokuapp.com/hnieto/appointmentScheduling";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

 // @Test
  public void testPSLInternetExplorer() throws Exception {
    driver.get(baseUrl + "");
    //driver.findElement(By.linkText("Agregar Doctor")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Manuel");
    driver.findElement(By.id("last_name")).clear();
    driver.findElement(By.id("last_name")).sendKeys("Patarrollo");
    driver.findElement(By.id("telephone")).clear();
    driver.findElement(By.id("telephone")).sendKeys("435435");
    driver.findElement(By.id("identification")).clear();
    driver.findElement(By.id("identification")).sendKeys("12345");
    driver.findElement(By.linkText("Guardar")).click();
    driver.findElement(By.linkText("Inicio")).click();
   // driver.findElement(By.linkText("Agregar Paciente")).click();
    driver.get(baseUrl2 + "");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("hernan");
    driver.findElement(By.name("last_name")).clear();
    driver.findElement(By.name("last_name")).sendKeys("nieto");
    driver.findElement(By.name("telephone")).clear();
    driver.findElement(By.name("telephone")).sendKeys("35t5");
    driver.findElement(By.name("identification")).clear();
    driver.findElement(By.name("identification")).sendKeys("654321");
    driver.findElement(By.linkText("Guardar")).click();
    driver.findElement(By.linkText("Inicio")).click();
    //driver.findElement(By.linkText("Agendar Cita")).click();
    driver.get(baseUrl3 + "");
    driver.findElement(By.id("datepicker")).click();
    driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[3]/td")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("54321");
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("654321");
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("12345");
  
    driver.findElement(By.linkText("Guardar")).click();
 
    try {
    	TimeUnit.SECONDS.sleep(2);
        assertEquals("Guardado:", driver.findElement(By.cssSelector("h3.panel-title")).getText());
     } catch (Error e) {
         verificationErrors.append(e.toString());
       }
    driver.findElement(By.linkText("Inicio")).click();
  }

  //@After
  public void tearDown() throws Exception {
  //  driver.quit();
	  driver.close();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
