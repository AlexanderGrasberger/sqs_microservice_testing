package org.sqs.contract.testing.consumer;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class UserConsumer {

    public static void main(String[] args) throws IOException {
        HttpResponse response = getUser("localhost:8080/v1");
    }

    public static HttpResponse getUser(String baseUrl) throws IOException {
        return Request.Get(baseUrl + "/user").execute().returnResponse();
    }

}
