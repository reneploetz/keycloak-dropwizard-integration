package de.ahus1.lottery.adapter.dropwizard.pages;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage<T extends Page> extends Page {

    @Drone
    private WebDriver browser;

    @FindBy(name = "username")
    private WebElement fieldUsername;

    @FindBy(name = "password")
    private WebElement fieldPassword;

    @FindBy(name = "login")
    private WebElement buttonLogin;

    private Class<T> clazz;

    @Override
    public void verify() {
        assertThat(browser.getTitle()).isEqualTo("Sign in to test");
    }

    public T login(String login, String password) {
        fieldUsername.sendKeys(login);
        fieldPassword.sendKeys(password);
        buttonLogin.click();
        return createPage(clazz);
    }

    public void setReturnPage(Class<T> returnPage) {
        this.clazz = returnPage;
    }
}
