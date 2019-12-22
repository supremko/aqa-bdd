import com.codeborne.selenide.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

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
    private int sum = 1000;
    private String lastBalanceCard1;
    private String lastBalanceCard2;
    private String newBalanceCard1;
    private String newBalanceCard2;
    private int diffBalanceCard1;
    private int diffBalanceCard2;
    private int lengthBalanceCard1;
    private int lengthBalanceCard2;

    public DashboardPage() {
        heading.shouldBe(visible);
    }


    public void topUpCard1(Data.ListCards listCards) {
        lastBalanceCard1 = $(withText(listCards.getLastNumCard1())).getText();
        lastBalanceCard2 = $(withText(listCards.getLastNumCard2())).getText();
        lengthBalanceCard1 = lastBalanceCard1.length();
        lengthBalanceCard2 = lastBalanceCard2.length();
        lastBalanceCard1 = lastBalanceCard1.substring(29,lengthBalanceCard1-12).trim();
        lastBalanceCard2 = lastBalanceCard2.substring(29,lengthBalanceCard2-12).trim();
        card1btn.click();
        topUpCards.waitUntil(visible,5000);
        amount.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        amount.setValue(Integer.toString(sum));
        from.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        from.setValue(listCards.getCard2());
        topUpBtn.click();
        cards.waitUntil(visible,5000);
        newBalanceCard1 = $(withText(listCards.getLastNumCard1())).getText().substring(29,34).trim();
        newBalanceCard2 = $(withText(listCards.getLastNumCard2())).getText().substring(29,34).trim();
        diffBalanceCard1 = Integer.parseInt(lastBalanceCard1) + sum;
        diffBalanceCard2 = Integer.parseInt(lastBalanceCard2) - sum;
        assertEquals(diffBalanceCard1,Integer.parseInt(newBalanceCard1));
        assertEquals(diffBalanceCard2,Integer.parseInt(newBalanceCard2));
    }

    public void topUpCard2(Data.ListCards listCards) {
        lastBalanceCard1 = $(withText(listCards.getLastNumCard1())).getText();
        lastBalanceCard2 = $(withText(listCards.getLastNumCard2())).getText();
        lengthBalanceCard1 = lastBalanceCard1.length();
        lengthBalanceCard2 = lastBalanceCard2.length();
        lastBalanceCard1 = lastBalanceCard1.substring(29,lengthBalanceCard1-12).trim();
        lastBalanceCard2 = lastBalanceCard2.substring(29,lengthBalanceCard2-12).trim();
        card2btn.click();
        topUpCards.waitUntil(visible,5000);
        amount.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        amount.setValue(Integer.toString(sum));
        from.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        from.setValue(listCards.getCard1());
        topUpBtn.click();
        cards.waitUntil(visible,5000);
        newBalanceCard1 = $(withText(listCards.getLastNumCard1())).getText().substring(29,34).trim();
        newBalanceCard2 = $(withText(listCards.getLastNumCard2())).getText().substring(29,34).trim();
        diffBalanceCard1 = Integer.parseInt(lastBalanceCard1) - sum;
        diffBalanceCard2 = Integer.parseInt(lastBalanceCard2) + sum;
        assertEquals(diffBalanceCard1,Integer.parseInt(newBalanceCard1));
        assertEquals(diffBalanceCard2,Integer.parseInt(newBalanceCard2));
    }
}
