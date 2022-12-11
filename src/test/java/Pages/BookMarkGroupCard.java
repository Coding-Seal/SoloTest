package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

public class BookMarkGroupCard {
    private final SelenideElement DELETE_BOOKMARK_BUTTON = $x("//a[@class='u-menu-v2_li']");
    private final By DOTS_BUTTON = By.xpath(".//div[contains(@class,'bookmark-shortcut-menu-anchor')]");
    private final By IMAGE = By.xpath(".//img[@class='bookmarks-menu-group-card__img']");
    private final SelenideElement ITEM;

    public BookMarkGroupCard(SelenideElement item){
        this.ITEM = item;
    }
    public String getGroupID(){
        String href = ITEM.shouldBe(visible).getAttribute("id");
        assert href != null;
        return href.substring(href.lastIndexOf("_")+1);
    }
    public void deleteBookmark(){
        ITEM.$(IMAGE).shouldBe(visible).hover();
        ITEM.$(DOTS_BUTTON).shouldBe(visible).hover().click();
        $(DELETE_BOOKMARK_BUTTON).shouldBe(visible).hover().click();
    }
}
