package org.sqs.contract.testing.provider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/user")
public class LegacyUserController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public LegacyUser getUser() {
        return new LegacyUser();
    }
}