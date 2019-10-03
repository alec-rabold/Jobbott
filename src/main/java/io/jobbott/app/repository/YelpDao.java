package io.jobbott.app.repository;

import com.google.common.collect.ImmutableMap;
import io.aexp.nodes.graphql.*;
import io.jobbott.app.model.yelp.YelpSearchDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import static io.jobbott.app.util.Constants.*;

@Log4j2
public class YelpDao {

    @Autowired
    private Environment env;

    public GraphQLResponseEntity<YelpSearchDto> query(final String term, final String location) {
        log.info("term:" + term + ", location:" + location);
        try {
            final Argument<String> termArg = new Argument("term", term);
            final Argument<String> locationArg = new Argument("location", location);
            final Arguments arguments = new Arguments("search", termArg, locationArg);

            final GraphQLTemplate graphQLTemplate = new GraphQLTemplate();
            final GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                    .url(YELP_GRAPHQL_ENDPOINT)
                    .request(YelpSearchDto.class)
                    .arguments(arguments)
                    .headers(ImmutableMap.of("Authorization", "Bearer " + env.getProperty(API_KEY_YELP)))
                    .build();
            final GraphQLResponseEntity<YelpSearchDto> responseEntity = graphQLTemplate.query(requestEntity, YelpSearchDto.class);
            return responseEntity;
        }
        catch(final Exception e) {
            log.error(e);
        }
        return new GraphQLResponseEntity<>();
    }



}
