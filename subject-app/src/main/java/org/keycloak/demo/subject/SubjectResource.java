package org.keycloak.demo.subject;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/subject")
@Authenticated
public class SubjectResource {

    @Inject
    JsonWebToken accessToken;

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public String login() {
        return accessToken.getRawToken();
    }
}
