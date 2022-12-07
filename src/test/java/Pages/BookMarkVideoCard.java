package Pages;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;


public class BookMarkVideoCard {
    private final By DELETE_BOOKMARK_BUTTON = By.xpath("//a[@class='u-menu-v2_li']");
    private final By DOTS_BUTTON = By.xpath(".//div[contains(@class,'bookmark-shortcut-menu-anchor')]");
    private final By VIDEO = By.xpath(".//a[@class='video-card_lk']");
    private final SelenideElement ITEM;

    public BookMarkVideoCard(SelenideElement item){
        this.ITEM = item.shouldBe(visible);
    }
    public String getVideoHref(){
        return ITEM.$(VIDEO).getAttribute("href");
    }
    public void deleteBookmark(){
        ITEM.$(VIDEO).shouldBe(visible).hover();
        ITEM.$(DOTS_BUTTON).shouldBe(visible).hover().click();
        $(DELETE_BOOKMARK_BUTTON).shouldBe(visible).hover().click();
    }
}
