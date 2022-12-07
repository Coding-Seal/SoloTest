package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BookMarkPage {
    private final SelenideElement VIDEO_BOOKMARKS = $x("//*[contains(@href, '/bookmarks/movie')]");
    private final SelenideElement GROUPS_BOOKMARKS = $x("//a[@href='/bookmarks/groups']");
    public BookMarkVideoPage goToVideoBookmarks() throws InterruptedException {
        VIDEO_BOOKMARKS.shouldBe(visible).click();
        return new BookMarkVideoPage();
    }
    public BookMarkGroupPage goToGroupBookmarks() throws InterruptedException {
        GROUPS_BOOKMARKS.shouldBe(visible).click();
        return new BookMarkGroupPage();
    }
}
