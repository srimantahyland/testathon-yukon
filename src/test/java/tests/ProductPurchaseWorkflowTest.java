package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.BstackRunner;

import java.time.Duration;

public class ProductPurchaseWorkflowTest extends BstackRunner {

    @Test
    void testPageTitle() {
        driver.get("https://kolkata.bugbash.live/");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("StackDemo", pageTitle, "Page title does not match");
    }

    @Test
    void testProductListDisplayed() {
        driver.get("https://kolkata.bugbash.live/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-list")));
        Assertions.assertTrue(productList.isDisplayed(), "Product list is not displayed");
    }

    @Test
    void testAddToCartButton() {
        driver.get("https://kolkata.bugbash.live/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.id("product-1")));
        product.click();

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart")));
        addToCartButton.click();

        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart-item-1")));
        Assertions.assertTrue(cartItem.isDisplayed(), "Item was not added to the cart");
    }

    @Test
    void testCheckoutButton() {
        driver.get("https://kolkata.bugbash.live/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        checkoutButton.click();

        WebElement checkoutPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-page")));
        Assertions.assertTrue(checkoutPage.isDisplayed(), "Checkout page is not displayed");
    }

    @Test
    void testPaymentSuccessMessage() {
        driver.get("https://kolkata.bugbash.live/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement payButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("pay-now")));
        payButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment-success")));
        Assertions.assertTrue(successMessage.isDisplayed(), "Payment success message is not displayed");
    }
}