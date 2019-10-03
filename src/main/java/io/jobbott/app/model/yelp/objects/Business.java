package io.jobbott.app.model.yelp.objects;

import io.aexp.nodes.graphql.annotations.GraphQLProperty;
import lombok.Data;

@Data
public class Business {
    private String name;
    private String id;
    private String alias;
    @GraphQLProperty(name = "is_closed")
    private Boolean isClosed;
    private String url;
    private String phone;
    @GraphQLProperty(name = "review_count")
    private Integer reviewCount;
    private Double rating;
    private String price;
    private Double distance;
    private Location location;
    private String[] photos;
//    private Hours[] hours;
}
