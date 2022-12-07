package Tests;

import Pages.*;
import org.junit.After;
import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class VideoBookMarksTest extends BaseTest{

    /**
     * Данные для работы тестов
     */
    private static final String OK_BASE_URL = "https://ok.ru/";
    private static final String LOGIN = "technoPol13";
    private static final String PASSWORD = "technoPolis2022";

    private BookMarkVideoPage BOOKMARK_VIDEO_PAGE;

    @Test
    public void goToVideoPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN).setPasswordOnBlock(PASSWORD).pressInputButton();

        FeedPage feedPage = new FeedPage();

        VideosPage videosPage = feedPage.goToVideoPage();
        String hrefVideo = videosPage.getHrefFirstPage();

        videosPage.addFirstVideoToBookMarks().goToFeedPage();
        BookMarkPage BOOKMARKS_PAGE = feedPage.goToBookmarksPage();

        BOOKMARK_VIDEO_PAGE = BOOKMARKS_PAGE.goToVideoBookmarks();
        String hrefVideoBookmark = BOOKMARK_VIDEO_PAGE.getFirstVideoHref();

        assertWithMessage("Comparing IDs of videos (should equal)").that(hrefVideo).
                endsWith(hrefVideoBookmark.substring(hrefVideoBookmark.lastIndexOf("/")));
    }
    @After
    public void tidyUp(){
        BOOKMARK_VIDEO_PAGE.deleteAllBookmarks();

    }

}
