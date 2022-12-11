package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BookMarkVideoPage {
    private final List<BookMarkVideoCard> BOOKMARK_CARDS;
    private final SelenideElement LAST_LOADED_ITEM = $x("//div[@class='mailru-visibility-check']");
    private final By BOOKMARKS_EMPTY_SIGN = By.xpath("//div[@class='stub-empty __v2  ']");

    public BookMarkVideoPage(){
        check();
        ElementsCollection videoCards = $$x("//div[contains(@class, 'bookmarks-card-decorator__menu')]");
        BOOKMARK_CARDS = videoCards.asFixedIterable().stream().map(BookMarkVideoCard::new).collect(Collectors.toList());
    }

    public String getFirstVideoHref() {
        return BOOKMARK_CARDS.get(0).getVideoHref();
    }
    public void deleteAllBookmarks(){
        BOOKMARK_CARDS.forEach(BookMarkVideoCard::deleteBookmark);
        $(BOOKMARKS_EMPTY_SIGN).shouldBe(visible);
    }
    public void check() {
        LAST_LOADED_ITEM.shouldBe(visible, Duration.ofSeconds(6));
    }

}
