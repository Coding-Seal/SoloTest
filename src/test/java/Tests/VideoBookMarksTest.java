package Tests;

import Pages.VideosPage;
import Pages.BookMarkVideoPage;
import Pages.BookMarkPage;
import Pages.FeedPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class VideoBookMarksTest extends BaseTest{

    /**
     * Данные для работы тестов
     */

    private BookMarkVideoPage BOOKMARK_VIDEO_PAGE;

    @DisplayName("Correct video added")
    @Test
    public void goToVideoPage() {

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
    @AfterEach
    public void tidyUp(){
        BOOKMARK_VIDEO_PAGE.deleteAllBookmarks();

    }

}
