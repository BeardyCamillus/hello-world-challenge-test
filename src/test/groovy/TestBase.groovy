import org.testng.annotations.BeforeMethod

import java.time.Instant

class TestBase {

    protected String userName

    @BeforeMethod(alwaysRun = true)
    void setup() {
        userName = "user" + Instant.now().getEpochSecond().toString()
    }
}
