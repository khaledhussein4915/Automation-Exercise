package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Framework {
    WebDriver browser;


    public Framework(WebDriver browser)
    {
        this.browser = browser;
        browser.manage().window().maximize();
    }

    public Framework()
    {
        this.browser = new ChromeDriver();
        browser.manage().window().maximize();
    }
    //------------------------------------------------------------//
    public void implicitlyWait(int second)
    {
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    public WebElement findElement (By loctator)
    {
        return browser.findElement(loctator);
    }

    public WebElement explicitlyWaitElementVisibility (int second, By locator)
    {
        return new WebDriverWait(browser, Duration.ofSeconds(second)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void explicitWaitForUrl (String url, int second)
    {
        new WebDriverWait(browser, Duration.ofSeconds(second)).until(ExpectedConditions.urlToBe(url));
    }

    public void explicitlyWaitVoid (Duration duration, By locator)
    {
        new WebDriverWait( browser,duration)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void fluentWait (By locator ,Duration duration1 , Duration duration2 )
    {
        new FluentWait<>(browser)
                .withTimeout(duration1)
                .pollingEvery(duration2)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void navigatesToURL (String URL)
    {
        browser.navigate().to(URL);
    }

    public String getpageURL()
    {
        return browser.getCurrentUrl();
    }

    public String getpageTitle()
    {
        return browser.getTitle();
    }

    public void clickonElement (By locator)
    {

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        browser.findElement(locator).click();

    }

    public void righclick (By locator)
    {
        Actions actions = new Actions(browser);
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.contextClick(browser.findElement(locator)).perform();

    }

    public void doubleclick (By locator)
    {
        Actions actions = new Actions(browser);
        actions.doubleClick(browser.findElement(locator)).perform();

    }
    public void  sendKeys ( By locator , String text )
    {

        browser.findElement(locator).sendKeys(text);
    }
    public void sendKeysInt (By locator, int number )
    {
        String textValue = String.valueOf(number);

        // Now pass the String to the sendKeys method
        browser.findElement(locator).sendKeys(textValue);

    }

    public String getText ( By locator )
    {
        return browser.findElement(locator).getText();

    }

    public void selectdropdownbyVisableText ( By locator ,String visabletext )
    {

        Select dropdownlist = new Select(browser.findElement(locator));
        dropdownlist.selectByVisibleText(visabletext);

    }

    public void selectdropdownbyValue ( By locator , String value )
    {

        Select dropdownlist = new Select(browser.findElement(locator));
        dropdownlist.selectByValue(value);

    }

    public void selectdropdownbyIndex ( By locator ,int index )
    {

        Select dropDownList = new Select(browser.findElement(locator));
        dropDownList.selectByIndex(index);

    }

    public void dragAndDrop(By sourceLocator, By targetLocator) {
        Actions action = new Actions(browser);
        WebElement source = browser.findElement(sourceLocator);
        WebElement target = browser.findElement(targetLocator);
        action.dragAndDrop(source, target).perform();

    }
    public void checkCheckbox(By locator)
    {
        WebElement checkbox = browser.findElement(locator);
        if ( !checkbox.isSelected())
            checkbox.click();

    }

    public void uncheckCheckbox(By locator)
    {
        // Uncheck a checkbox if currently checked.
        WebElement checkbox = browser.findElement(locator);
        if ( checkbox.isSelected())
            checkbox.click();
    }

    public void selectRadioButton(By locator) {
        WebElement radioButton = browser.findElement(locator);

        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    public void hoverelement (By locator){
        Actions a1 = new Actions(browser);
        WebElement targetelement = browser.findElement(locator);
        a1.moveToElement(targetelement).perform();
    }

    public void scrollToElement(By locator )
    {
        Actions a1 = new Actions(browser);
        WebElement elementlocation = browser.findElement(locator);
        a1.scrollToElement(elementlocation);
    }

    public File takeScreenShot (String name , String path ) throws IOException {
        File src = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
        String timestamb = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
        File destination = new File(path + name + timestamb + ".png");
        FileHandler.copy(src,destination);

        return destination;

    }

    public void switchBetweenTabs(String windowHandel )
    {
        browser.switchTo().window(windowHandel);
    }

    public void closeAlert ()
    {
        browser.switchTo().alert().dismiss();
    }

    public void acceptAlert ()
    {
        browser.switchTo().alert().accept();
    }

    public String getAlertText ()
    {
        return browser.switchTo().alert().getText();
    }

    public void sendAlertText (String texttosend)
    {
        browser.switchTo().alert().sendKeys(texttosend);
    }


    public void closeProgramme()
    {
        browser.close();
    }

    public void generalRefresh(WebDriver browser) {
        browser.navigate().refresh();
    }

    //Generate random email

    public String generateRandomEmail ()
    {
        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();
        return  randomEmail;
    }
    public void  killAds() {
        try {
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) browser;
            String script =" const elements = document.getElementsByClassName('adsbygoogle');"+

                    "for (let el of elements) {"+
                    " el.style.display = '';"+
                    "await new Promise((resolve, reject)=>{ setTimeout(()=>resolve(),5000)}); console.log('ad removed')"+
                    "el.style.display = 'none';"+
                    "}";

            js.executeScript(script);
        } catch (Exception e) {
            System.out.println("Could not remove ads: " + e.getMessage());
        }




}}