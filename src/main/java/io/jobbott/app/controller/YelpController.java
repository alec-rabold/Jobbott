package io.jobbott.app.controller;

import io.aexp.nodes.graphql.GraphQLResponseEntity;
import io.jobbott.app.model.yelp.YelpSearchDto;
import io.jobbott.app.model.yelp.objects.Business;
import io.jobbott.app.repository.YelpDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/yelp")
public class YelpController {

    @Autowired
    private YelpDao yelpDao;

    @RequestMapping("/test")
    @ResponseBody
    public List<String> search(@RequestParam final String term, @RequestParam final String location) {
        try {
            final GraphQLResponseEntity<YelpSearchDto> responseEntity = yelpDao.query(term, location);
            final List<Business> businesses = responseEntity.getResponse().getBusinesses();
            final List<String> businessNames = new ArrayList<>();
            for(final Business business : businesses) {
                businessNames.add(business.getName());
            }
            return businessNames;
        }
        catch(final Exception e) {
            log.error(e);
            return null;
        }
    }

}
