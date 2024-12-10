package pages;

import org.openqa.selenium.By;
import pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

   String navbar = driver.findElement(By.id("nava")).getText();

    public String getHomePageTitle() {
        return driver.getTitle();
    }
    public String getNavbarText() {
        System.out.println(driver.getTitle() + navbar);
        return driver.getTitle();
    }
    @FindBy(css = "ul.navbar-nav li a")
    private List<WebElement> navList;

    @FindBy(css = "#itemc")
    private List<WebElement> categoriesList;

    @FindBy(id = "nameofuser")
    private WebElement nameOfUser;

    public List<String> getNavListTexts() {
        List<String> navTexts = new ArrayList<>();
        for (WebElement nav : navList) {
            navTexts.add(nav.getText());
        }
        return navTexts;
    }

    public String getWelcomeMessageTexts() {
        String message = nameOfUser.getText();
        return message;
    }

    public List<String> getCategoriesTexts() {
        List<String> categoryTexts = new ArrayList<>();
        for (WebElement category : categoriesList) {
            categoryTexts.add(category.getText());
        }
        System.out.println(categoryTexts);
        return categoryTexts;
    }
}
