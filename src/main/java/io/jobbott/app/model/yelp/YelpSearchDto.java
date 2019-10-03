package io.jobbott.app.model.yelp;

import io.aexp.nodes.graphql.annotations.GraphQLArgument;
import io.aexp.nodes.graphql.annotations.GraphQLProperty;
import io.jobbott.app.model.yelp.objects.Business;
import lombok.Data;

import java.util.List;

@Data
@GraphQLProperty(name="search", arguments = {
        @GraphQLArgument(name = "term", type = "String"),
        @GraphQLArgument(name = "location", type = "String")
})
public class YelpSearchDto {
    @GraphQLProperty(name = "total")
    private String businessCount;
    @GraphQLProperty(name = "business")
    private List<Business> businesses;
}
