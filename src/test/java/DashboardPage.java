import com.codeborne.selenide.*;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement cards = $(withText("Ваши карты"));
    private SelenideElement topUpCards = $(withText("Пополнение карты"));
    private SelenideElement card1btn = $$("[data-test-id=action-deposit]").first()
            .$("[class=button__content]");
    private SelenideElement card2btn = $$("[data-test-id=action-deposit]").last()
            .$("[class=button__content]");
    private SelenideElement amount = $("[data-test-id=amount]").$("[class=input__control");
    private SelenideElement from = $("[data-test-id=from]").$("[class=input__control");
    private SelenideElement topUpBtn = $("[data-test-id=action-transfer").$("[class=button__content]");

    public DashboardPage() {
        heading.shouldBe(visible);
    }


    public void topUpCard1(Data.ListCards listCards) {
        card1btn.click();
        topUpCards.waitUntil(visible,5000);
        amount.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        amount.setValue(Data.getSum().toString());
        from.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        from.setValue(listCards.getCard2());
        topUpBtn.click();
        cards.waitUntil(visible,5000);
    }

    public void topUpCard2(Data.ListCards listCards) {
        card2btn.click();
        topUpCards.waitUntil(visible,5000);
        amount.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        amount.setValue(Data.getSum().toString());
        from.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        from.setValue(listCards.getCard1());
        topUpBtn.click();
        cards.waitUntil(visible,5000);
    }
}
