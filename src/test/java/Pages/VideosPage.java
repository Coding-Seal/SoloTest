package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;

public class VideosPage {

    private final ElementsCollection VIDEO_CARDS = $$x("//a[@class='video-card_lk']");
    private final SelenideElement VIDEO_MENU = $x("//div[@class='video-card_menu']");
    private final SelenideElement ADD_TO_BOOKMARK_BUTTON = $x("//a[contains(@href, 'ADD_TO_BOOKMARKS')]");
    private final SelenideElement BACK_TO_FEED_BUTTON = $x("//*[contains(@href, '/feed')]");
    public VideosPage addFirstVideoToBookMarks() {
        VIDEO_CARDS.first().shouldBe(visible).hover();
        VIDEO_MENU.shouldBe(visible).hover().click();
        ADD_TO_BOOKMARK_BUTTON.shouldBe(visible).hover().click();
        return this;
    }

    public String getHrefFirstPage() {
        return VIDEO_CARDS.first().shouldBe(visible).getAttribute("href");
    }

    public void goToFeedPage() {
        BACK_TO_FEED_BUTTON.shouldBe(visible).click();
    }
}
