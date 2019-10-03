package io.jobbott.app.model.yelp.objects;

import io.aexp.nodes.graphql.annotations.GraphQLProperty;
import lombok.Data;

@Data
public class Location {
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    @GraphQLProperty(name = "postal_code")
    private String postalCode;
    private String country;
    @GraphQLProperty(name = "formatted_address")
    private String formattedAddress;
}
