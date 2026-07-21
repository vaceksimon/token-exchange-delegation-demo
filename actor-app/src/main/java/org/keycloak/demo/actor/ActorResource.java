package org.keycloak.demo.actor;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/actor")
public class ActorResource {

    @Inject
    @RestClient
    SubjectRestClient subjectRestClient;

    @GET
    @Path("/token")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSubjectToken() {
        return subjectRestClient.getSubjectToken();
    }
}
