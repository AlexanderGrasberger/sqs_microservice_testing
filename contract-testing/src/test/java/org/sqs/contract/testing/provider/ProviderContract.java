package org.sqs.contract.testing.provider;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Provider("UserProvider")
@PactBroker(url = "http://localhost:9292")
@PactFolder("pacts")
public class ProviderContract {

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        System.setProperty("pact.verifier.publishResults", "true");
        System.setProperty("pact.provider.version", "2.0.0");
        context.verifyInteraction();
    }

    @BeforeEach
    void before(PactVerificationContext context) {
        HttpTestTarget target = new HttpTestTarget("localhost", 8080, "/v2/");
        context.setTarget(target);
    }

    @State("test state")
    public void userContractTest() {}
}