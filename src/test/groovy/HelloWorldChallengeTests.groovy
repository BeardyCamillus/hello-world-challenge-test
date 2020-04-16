import org.testng.annotations.Test

class HelloWorldChallengeTests extends TestBase {

    @Test
    void testHelloMessageReceiving() {
        ClientsApiSteps.createClient(userName, 200)
        ClientsApiSteps.checkClientExists(userName)
        String xSessionId = LoginApiSteps.login(userName)
        HelloApiSteps.getAndCheckHelloMessage(xSessionId, "Ok", userName)
    }

    @Test
    void testHelloMessageAfterLogout() {
        ClientsApiSteps.createClient(userName)
        String xSessionId = LoginApiSteps.login(userName)
        LogoutApiSteps.logout(userName)
        HelloApiSteps.getAndCheckHelloMessage(xSessionId, "Unauthorized", null)
    }
}
