package org.keycloak.demo.subject;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/subject")
public class SubjectResource {

    @Inject
    JsonWebToken accessToken;

    String rawToken;

    @GET
    @Path("/login")
    @Authenticated
    public Response login() {
        rawToken = accessToken.getRawToken();
        return Response.ok().build();
    }

    @GET
    @Path("/token")
    @Produces(MediaType.TEXT_PLAIN)
    public String getToken() {
       return rawToken;
    }
}
