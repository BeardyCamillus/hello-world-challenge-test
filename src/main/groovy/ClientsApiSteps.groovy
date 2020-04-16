import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.openapitools.client.model.Client

class ClientsApiSteps extends StepBase {

    static void createClient(String userName, Integer statusCode = 200) {
        def result = helloWorldChallengeApi.challengeClientsPostWithHttpInfo(
                new Client(fullName: userName, username: userName))
        MatcherAssert.assertThat(result.statusCode, Matchers.equalTo(statusCode))
    }

    static checkClientExists(String userName) {
        def result = helloWorldChallengeApi.challengeClientsGetWithHttpInfo()
        MatcherAssert.assertThat(result.data.toString(), Matchers.containsString(userName))
    }
}
