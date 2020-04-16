import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.openapitools.client.model.LoginRequest

class LoginApiSteps extends StepBase{

    static String login(String userName) {
        def result = helloWorldChallengeApi
                .challengeLoginPostWithHttpInfo(new LoginRequest(username: userName))
        MatcherAssert.assertThat(result.statusCode, Matchers.equalTo(200))
        String xSessionId = result.headers.get("x-session-id").first()
        return xSessionId
    }
}
