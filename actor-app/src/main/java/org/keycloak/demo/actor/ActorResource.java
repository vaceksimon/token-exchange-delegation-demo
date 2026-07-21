package org.keycloak.demo.actor;

import io.quarkus.oidc.client.Tokens;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/actor")
public class ActorResource {

    @Inject
    Tokens tokens;

    @Inject
    @RestClient
    SubjectRestClient subjectRestClient;

    private String subjectToken;
    private String actorToken;

    @GET
    @Path("/subject-token")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSubjectToken() {
        subjectToken = subjectRestClient.getSubjectToken();
        return subjectToken;
    }

    @GET
    @Path("/token")
    public String getActorToken() {
        actorToken = tokens.getAccessToken();
        return actorToken;
    }
}
