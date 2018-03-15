package org.identifiers.cloud.ws.resourcerecommender.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: resource-recommender
 * Package: org.identifiers.cloud.ws.resourcerecommender.models
 * Timestamp: 2018-02-27 11:43
 * ---
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceRecommendation implements Serializable, Comparable<ResourceRecommendation> {
    // This is an index [0,99] on how recommendable is this resource, 0 - not at all, 99 - way to go
    private int recommendationIndex = 0;
    private String recommendationExplanation = "no explanation has been specified";
    // This is the contextual ID of the resource in the current recommendation request
    private String id;
    private String accessURL;

    public int getRecommendationIndex() {
        return recommendationIndex;
    }

    public ResourceRecommendation setRecommendationIndex(int recommendationIndex) {
        this.recommendationIndex = recommendationIndex;
        return this;
    }

    public String getRecommendationExplanation() {
        return recommendationExplanation;
    }

    public ResourceRecommendation setRecommendationExplanation(String recommendationExplanation) {
        this.recommendationExplanation = recommendationExplanation;
        return this;
    }

    public String getId() {
        return id;
    }

    public ResourceRecommendation setId(String id) {
        this.id = id;
        return this;
    }

    public String getAccessURL() {
        return accessURL;
    }

    public ResourceRecommendation setAccessURL(String accessURL) {
        this.accessURL = accessURL;
        return this;
    }

    @Override
    public int compareTo(ResourceRecommendation o) {
        return Integer.compare(recommendationIndex, o.recommendationIndex);
    }
}