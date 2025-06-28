package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.BstackRunner;

import java.time.Duration;

public class KolkataBugbashTest extends BstackRunner {

    @Test
    void singleTest() {
        driver.get("https://kolkata.bugbash.live/");
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("StackDemo"));
        String product_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='1']/p"))).getText();
        WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='1']/div[4]")));
        cart_btn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("float-cart__content")));
        final String product_in_cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]"))).getText();
        Assertions.assertTrue(product_name.matches(product_in_cart), "Product add to the cart - Failed!");
    }

    @Test
    public void testLogin() throws Exception {

        try {
            driver.get("https://kolkata.bugbash.live/signin");

            // Replace selectors with actual input names/ids
            driver.findElement(By.id("username")).sendKeys("demouser");
            driver.findElement(By.id("password")).sendKeys("testingisfun99");
            driver.findElement(By.id("login-btn")).click();

            // Optionally assert login success
            System.out.println("Login attempted.");

        } finally {
            driver.quit();
        }
    }
}
