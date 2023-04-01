import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

// The code filters website rows to show "Rice" and asserts equality.
public class Filter {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(" [type='search']")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.cssSelector(" tr td:nth-child(1)"));

        // Filter the above list of elements by checking if they contain the text "Rice" and store the filtered list in a new variable
        List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice")).collect(Collectors.toList());

        // Assert that the size of both lists are equal
        Assert.assertEquals(veggies.size(), filteredList.size());
    }
}
