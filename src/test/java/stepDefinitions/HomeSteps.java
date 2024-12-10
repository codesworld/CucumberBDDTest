package stepDefinitions;

import pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.ConfigReader;
import utils.WebDriverManager;

import java.util.List;

public class HomeSteps {
    private HomePage homePage;

    @Given("I navigate to the homepage")
    public void i_navigate_to_the_homepage() {
        homePage = new HomePage();
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        System.out.println(homePage.getNavbarText());
        Assert.assertEquals(expectedTitle, homePage.getHomePageTitle());
    }

    @Then("the navigation list should contain the following items")
    public void the_navigation_list_should_contain_the_following_items(List<String> expectedNavItems) {
        List<String> actualNavItems = homePage.getNavListTexts();
        Assert.assertTrue("Navigation list items do not match!", actualNavItems.contains(expectedNavItems.get(1)));
    }

    @Then("the categories list should contain the following items")
    public void the_categories_list_should_contain_the_following_items(List<String> expectedCategories) {
        List<String> actualCategories = homePage.getCategoriesTexts();
        System.out.println(expectedCategories);
        Assert.assertTrue("Category list items do not match!", actualCategories.contains(expectedCategories.get(1)));
    }
}
