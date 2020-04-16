import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.openapitools.client.ApiException

class HelloApiSteps extends StepBase {

    static void getAndCheckHelloMessage(String xSessionId, String resultCode, String userName) {
        String receivedMessage = null
        try {
            receivedMessage = helloWorldChallengeApi
                    .challengeHelloGetWithHttpInfo(xSessionId)
                    .data
                    .toString()
        } catch (ApiException apiException) {
            receivedMessage = apiException.responseBody
        }
        StringBuilder builder = new StringBuilder().append("{")
        builder.append("\"resultCode\":\"$resultCode\"")
        if (userName != null) {
            builder.append(",")
            builder.append("\"message\":\"Hello, $userName!\"")
        }
        builder.append("}")
        String expectedMessage = builder.toString()
        MatcherAssert.assertThat(receivedMessage, Matchers.equalTo(expectedMessage))
    }
}
