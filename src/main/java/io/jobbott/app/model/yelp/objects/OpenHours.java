package io.jobbott.app.model.yelp.objects;

import io.aexp.nodes.graphql.annotations.GraphQLProperty;
import lombok.Data;

@Data
public class OpenHours {
    @GraphQLProperty(name = "is_overnight")
    private Boolean isOvernight;
    @GraphQLProperty(name = "start")
    private String startTime;
    @GraphQLProperty(name = "end")
    private String endTime;
    @GraphQLProperty(name = "day")
    private Integer dayOfWeek;
}
