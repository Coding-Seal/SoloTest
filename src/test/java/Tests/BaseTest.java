package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Базовый класс для всех тестов
 */
abstract public class BaseTest {

    /**
     * Инициализация браузера
     */
    public void init() {
        WebDriverManager.edgedriver().setup();
        Configuration.browser = "edge";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @BeforeEach
    public void initTest() {
        init();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}