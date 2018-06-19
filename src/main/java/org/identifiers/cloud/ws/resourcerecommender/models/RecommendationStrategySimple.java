package org.identifiers.cloud.ws.resourcerecommender.models;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: resource-recommender
 * Package: org.identifiers.cloud.ws.resourcerecommender.models
 * Timestamp: 2018-02-27 11:57
 * ---
 */
@Component
public class RecommendationStrategySimple implements RecommendationStrategy {
    @Override
    public List<ResourceRecommendation> getRecommendations(List<ResolvedResource> resolvedResources) {
        AtomicReference<Boolean> thereIsOfficialResource = new AtomicReference<>(false);
        List<ResourceRecommendation> recommendations = resolvedResources.parallelStream().map(resolvedResource -> {
            ResourceRecommendation resourceRecommendation = new ResourceRecommendation()
                    .setAccessURL(resolvedResource.getAccessURL())
                    .setId(resolvedResource.getId());
            // TODO - Implement the function for every entry here
            if (resolvedResource.isOfficial()) {
                thereIsOfficialResource.set(Boolean.TRUE);
                return resourceRecommendation
                        .setRecommendationIndex(100)
                        .setRecommendationExplanation("Official resource in this context");
            }
            return resourceRecommendation
                    .setRecommendationIndex(0)
                    .setRecommendationExplanation("This resource is not official within this context");
        }).collect(Collectors.toList());
        if (recommendations.size() == 1) {
            recommendations.get(0)
                    .setRecommendationIndex(100)
                    .setRecommendationExplanation("This is the ONLY resource available within this context");
            return recommendations;
        }
        // There is no official resource, pick one randomly
        if (!recommendations.isEmpty() && !thereIsOfficialResource.get()) {
            Collections.shuffle(recommendations);
            recommendations.get(0)
                    .setRecommendationIndex(100)
                    .setRecommendationExplanation("There are multiple resources for this case, and none of them is official, " +
                            "so this one has been chosen randomly");
        }
        return recommendations;
    }
}
