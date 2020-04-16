import org.openapitools.client.model.LogoutRequest

class LogoutApiSteps extends StepBase {

    static void logout(String username) {
        helloWorldChallengeApi.challengeLogoutPost(new LogoutRequest(username: username))
    }
}
