package Pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class BookMarkPage {
    private final SelenideElement LAST_LOADED_ITEM = $x("//div[@class='mailru-visibility-check']");
    private final SelenideElement VIDEO_BOOKMARKS = $x("//*[contains(@href, '/bookmarks/movie')]");
    private final SelenideElement GROUPS_BOOKMARKS = $x("//a[@href='/bookmarks/groups']");
    public BookMarkPage(){
        check();
    }
    public BookMarkVideoPage goToVideoBookmarks(){
        VIDEO_BOOKMARKS.shouldBe(visible).click();
        return new BookMarkVideoPage();
    }
    public BookMarkGroupPage goToGroupBookmarks(){
        GROUPS_BOOKMARKS.shouldBe(visible).click();
        return new BookMarkGroupPage();
    }
    public void check() {
        LAST_LOADED_ITEM.shouldBe(visible, Duration.ofSeconds(6));
    }
}
