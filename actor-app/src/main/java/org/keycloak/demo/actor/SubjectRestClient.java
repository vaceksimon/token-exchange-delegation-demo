package org.keycloak.demo.actor;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/subject")
@RegisterRestClient(configKey = "subject-app")
public interface SubjectRestClient {

    @GET
    @Path("/token")
    String getSubjectToken();
}
