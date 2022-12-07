package Pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class BookMarkGroupPage {
    private final List<BookMarkGroupCard> BOOKMARK_CARDS;
    private final By BOOKMARKS_EMPTY_SIGN = By.xpath("//div[@class='stub-empty __v2  ']");

    public BookMarkGroupPage() throws InterruptedException {
        ElementsCollection groupCards = $$x("//div[contains(@class, 'bookmarks-card-decorator__menu')]");
//        Stream<BookMarkGroupCard> cards = groupCards.asFixedIterable().stream().map(BookMarkGroupCard::new);
//        Thread.sleep(100);
//        BOOKMARK_CARDS = cards.collect(Collectors.toList());
        BOOKMARK_CARDS = groupCards.asFixedIterable().stream().map(BookMarkGroupCard::new).collect(Collectors.toList());
        assert (BOOKMARK_CARDS.size() ==groupCards.size()): "BOOKMARK_CARDS.size() !=groupCards.size()";
        // this.bookmarkCards = groupCards.stream().map(BookmarkVideoCard::new).toList();
    }

    public String getFirstGroupID() { //FIXME
        return BOOKMARK_CARDS.get(0).getGroupID();
    }
    public void deleteAllBookmarks(){
        BOOKMARK_CARDS.forEach(BookMarkGroupCard::deleteBookmark);
        $(BOOKMARKS_EMPTY_SIGN).shouldBe(visible);
    }

}

