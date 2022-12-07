package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.impl.Waiter;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BookMarkVideoPage {
    private final List<BookMarkVideoCard> BOOKMARK_CARDS;
    private final By BOOKMARKS_EMPTY_SIGN = By.xpath("//div[@class='stub-empty __v2  ']");

    public BookMarkVideoPage() throws InterruptedException {
                Thread.sleep(1000);

        ElementsCollection videoCards = $$x("//div[contains(@class, 'bookmarks-card-decorator__menu')]");
//        Stream<BookMarkVideoCard> cards = videoCards.stream().map(BookMarkVideoCard::new);
//        BOOKMARK_CARDS = cards.toList();
        BOOKMARK_CARDS = videoCards.asFixedIterable().stream().map(BookMarkVideoCard::new).collect(Collectors.toList());
    }

    public String getFirstVideoHref() { //FIXME
        return BOOKMARK_CARDS.get(0).getVideoHref();
    }
    public void deleteAllBookmarks(){
        BOOKMARK_CARDS.forEach(BookMarkVideoCard::deleteBookmark);
        $(BOOKMARKS_EMPTY_SIGN).shouldBe(visible);
    }

}
