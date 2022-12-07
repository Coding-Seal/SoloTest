package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Лента одноклассников
 */
public class FeedPage {

    private final SelenideElement GROUPS_PAGE = $x("//*[contains(@href, '/groups')]");
    /**
     * Кнопка перехода на вкладку с видео
     */
    private final SelenideElement VIDEO_PAGE = $x("//a[@href='/video/showcase']");
    private final SelenideElement BOOKMARKS_PAGE = $x("//*[contains(@href, '/bookmarks')]");
    // //*[@id="music_toolbar_button"]/div[2]

    public VideosPage goToVideoPage() {
        VIDEO_PAGE.shouldBe(visible).click();
        return new VideosPage();
    }

    public BookMarkPage goToBookmarksPage() {
        BOOKMARKS_PAGE.shouldBe(visible).click();
        return new BookMarkPage();
    }
    public GroupsPage goToGroupsPage() throws InterruptedException {
        GROUPS_PAGE.shouldBe(visible).click();
        return new GroupsPage();
    }

}