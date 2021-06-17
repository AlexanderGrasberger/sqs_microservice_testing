package org.sqs.contract.testing.provider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v2/user")
public class UserController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser() {
        return new User();
    }
}