package ru.inger;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Steps {
    private WebDriver webDriver;
    
    @Given("^Open the browser and registration page$")
    public void open() throws Throwable{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.weblancer.net/register/");
    }

    @When("^Enter incorrect the (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void enterIncorrectData
            (String surname, String name, String login,
             String email, String passwd, String cpasswd) throws Throwable {
        webDriver.findElement(By.name("last_name")).sendKeys(surname);
        webDriver.findElement(By.name("first_name")).sendKeys(name);
        webDriver.findElement(By.name("login")).sendKeys(login);
        webDriver.findElement(By.name("email")).sendKeys(email);
        webDriver.findElement(By.name("password")).sendKeys(passwd);
        webDriver.findElement(By.name("confirm_password")).sendKeys(cpasswd);
    }

    @And("^Choose or do not choose the following items: (.+), (.+), (.+), (.+), (.+)$")
    public void chooseOrDoNotChooseTheFollowingItemsBirthDayBirthMonthBirthYearCountryCity
            (boolean birthDay,boolean birthMonth, boolean birthYear, boolean country, boolean city) throws Throwable {
        if (birthDay) {
            WebElement elementBirthDay = webDriver.findElement(By.name("birth_day"));
            Select selectBirthDay = new Select(elementBirthDay);
            selectBirthDay.selectByValue("3");
        }
        if (birthMonth) {
            WebElement elementBirthMonth = webDriver.findElement(By.name("birth_month"));
            Select selectBirthMonth = new Select(elementBirthMonth);
            selectBirthMonth.selectByValue("10");
        }
        if (birthYear) {
            WebElement elementBirthYear = webDriver.findElement(By.name("birth_year"));
            Select selectBirthYear = new Select(elementBirthYear);
            selectBirthYear.selectByValue("1995");
        }
        if (country) {
            WebElement elementCountry = webDriver.findElement(By.name("country_id"));
            Select selectCountry = new Select(elementCountry);
            selectCountry.selectByValue("2");
        }
        if (city) {
            WebElement elementCity = webDriver.findElement(By.name("city_id"));
            Select selectCity = new Select(elementCity);
            selectCity.selectByValue("621");
        }
    }

    @Then("^The registration button is clicked and data is checked$")
    public void theRegistrationButtonIsClickedAndDataIsChecked() throws Throwable {
        webDriver.findElement(By.className("btn")).click();
    }
}
