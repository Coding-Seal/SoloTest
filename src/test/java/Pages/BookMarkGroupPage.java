package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$;

public class BookMarkGroupPage {
    private final List<BookMarkGroupCard> BOOKMARK_CARDS;
    private final SelenideElement LAST_LOADED_ITEM = $x("//div[@class='mailru-visibility-check']");
    private final SelenideElement BOOKMARKS_EMPTY_SIGN = $x("//div[@class='stub-empty __v2  ']");
    private final static By GROUP_CARDS_SELECTOR = By.xpath("//div[contains(@class, 'bookmarks-card-decorator__menu')]");

    public BookMarkGroupPage() {
        check();
        ElementsCollection groupCards = $$(GROUP_CARDS_SELECTOR);
        BOOKMARK_CARDS = groupCards.asFixedIterable().stream().map(BookMarkGroupCard::new).collect(Collectors.toList());
    }

    public String getFirstGroupID() {
        return BOOKMARK_CARDS.get(0).getGroupID();
    }
    public void deleteAllBookmarks(){
        BOOKMARK_CARDS.forEach(BookMarkGroupCard::deleteBookmark);
        BOOKMARKS_EMPTY_SIGN.shouldBe(visible);
    }
    public void check() {
        LAST_LOADED_ITEM.shouldBe(visible, Duration.ofSeconds(6));
    }
}

