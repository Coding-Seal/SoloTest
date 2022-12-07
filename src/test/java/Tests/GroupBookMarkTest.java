package Tests;

import Pages.*;
import org.junit.After;
import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class GroupBookMarkTest extends BaseTest{

    /**
     * Данные для работы тестов
     */
    private static final String OK_BASE_URL = "https://ok.ru/";
    private static final String LOGIN = "technoPol13";
    private static final String PASSWORD = "technoPolis2022";

    private BookMarkGroupPage BOOKMARK_GROUP_PAGE;

    @Test
    public void goToGroupPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN).setPasswordOnBlock(PASSWORD).pressInputButton();

        FeedPage feedPage = new FeedPage();

        GroupsPage groupsPage = feedPage.goToGroupsPage();
        String groupID = groupsPage.getFirstGroupID();
        groupsPage.addFirstGroupToBookmarks().goToFeedPage();
        BookMarkPage BOOKMARKS_PAGE = feedPage.goToBookmarksPage();

        BOOKMARK_GROUP_PAGE = BOOKMARKS_PAGE.goToGroupBookmarks();
        String BookmarkGroupID = BOOKMARK_GROUP_PAGE.getFirstGroupID();

        assertWithMessage("Comparing IDs of groups (should equal)").that(groupID).contains(BookmarkGroupID);
    }
    @After
    public void tidyUp(){
        BOOKMARK_GROUP_PAGE.deleteAllBookmarks();

    }

}