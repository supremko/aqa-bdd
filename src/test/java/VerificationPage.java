import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyBtn = $("[data-test-id=action-verify]");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public void availableVerifyBtn() {
        verifyBtn.shouldBe(visible);
    }

    public DashboardPage verify(Data.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyBtn.click();
        return new DashboardPage();
    }
}
