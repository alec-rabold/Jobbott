package io.jobbott.app.model.yelp.objects;

import io.aexp.nodes.graphql.annotations.GraphQLProperty;
import lombok.Data;

@Data
public class Hours {
    @GraphQLProperty(name = "hours_type")
    private String hoursType;
    @GraphQLProperty(name = "open")
    private OpenHours[] openHours;
    @GraphQLProperty(name = "is_open_now")
    private Boolean isOpenNow;
}
