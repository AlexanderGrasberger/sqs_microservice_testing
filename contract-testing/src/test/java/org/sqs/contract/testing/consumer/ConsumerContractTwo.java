package org.sqs.contract.testing.consumer;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.Matchers;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sqs.contract.testing.consumer.two.ConsumerTwoUser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "UserProvider")
public class ConsumerContractTwo {

    @Pact(provider="UserProvider", consumer="UserConsumerTwo")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .given("test state")
                .uponReceiving("Contract testing with pact")
                .path("/user")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(new PactDslJsonBody().id()
                        .and("firstName", "Max", Matchers.string().getMatcher())
                        .and("lastName", "Musterman", Matchers.string().getMatcher()))
                .toPact();
    }

    @Test
    void testConsumer(MockServer mockServer) throws IOException {
        HttpResponse response = UserConsumer.getUser(mockServer.getUrl());

        String json = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
        ConsumerTwoUser user = new Gson().fromJson(json, ConsumerTwoUser.class);

        assert response.getStatusLine().getStatusCode() == 200;
        assert user != null;
    }

}
