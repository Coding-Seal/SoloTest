package Tests;

import Pages.GroupsPage;
import Pages.BookMarkGroupPage;
import Pages.BookMarkPage;
import Pages.FeedPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class GroupBookMarkTest extends BaseTest{

    /**
     * Данные для работы тестов
     */

    private BookMarkGroupPage BOOKMARK_GROUP_PAGE;

    @DisplayName("Correct group added")
    @Test
    public void goToGroupPage() {
        FeedPage feedPage = new FeedPage();

        GroupsPage groupsPage = feedPage.goToGroupsPage();
        String groupID = groupsPage.getFirstGroupID();
        groupsPage.addFirstGroupToBookmarks().goToFeedPage();
        BookMarkPage BOOKMARKS_PAGE = feedPage.goToBookmarksPage();

        BOOKMARK_GROUP_PAGE = BOOKMARKS_PAGE.goToGroupBookmarks();
        String BookmarkGroupID = BOOKMARK_GROUP_PAGE.getFirstGroupID();

        assertWithMessage("Comparing IDs of groups (should equal)").that(groupID).contains(BookmarkGroupID);
    }
    @AfterEach
    public void tidyUp(){
        BOOKMARK_GROUP_PAGE.deleteAllBookmarks();

    }

}