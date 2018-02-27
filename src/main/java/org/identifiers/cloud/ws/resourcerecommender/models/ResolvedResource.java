package org.identifiers.cloud.ws.resourcerecommender.models;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: resource-recommender
 * Package: org.identifiers.cloud.ws.resourcerecommender.models
 * Timestamp: 2018-02-27 11:06
 * ---
 */
public class ResolvedResource {
    // Even if we have access to another service that, given a resource ID, could provide information on that resource,
    // these particular attributes exist within the context that resource / provider for a particular Compact ID. In the
    // future, we could include more context information related to the particularities of the current recommendation
    // request to fine tune the recommendation mechanism

    // This field references the ID of the resource within the context of the current Compact ID resolved request
    private String id;
    // This field references the final URL that points to the current resolved resource request
    private String endPointUrl;
    // For this particular resolved resource request, provides information on whether the resource is official or not
    private boolean official;

    public String getId() {
        return id;
    }

    public ResolvedResource setId(String id) {
        this.id = id;
        return this;
    }

    public String getEndPointUrl() {
        return endPointUrl;
    }

    public ResolvedResource setEndPointUrl(String endPointUrl) {
        this.endPointUrl = endPointUrl;
        return this;
    }

    public boolean isOfficial() {
        return official;
    }

    public ResolvedResource setOfficial(boolean official) {
        this.official = official;
        return this;
    }
}
