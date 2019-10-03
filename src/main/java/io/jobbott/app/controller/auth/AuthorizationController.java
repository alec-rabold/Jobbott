package io.jobbott.app.controller.auth;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static io.jobbott.app.util.Constants.*;

@Log4j2
@Controller
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    private OAuth20Service linkedinAuth;

    @GetMapping("/linkedin")
    public String authorization() {
        return "redirect:" + linkedinAuth.getAuthorizationUrl();
    }

    @GetMapping("/linkedin/callback")
    @ResponseBody
    public String home(@RequestParam("code") final String authorizationCode) {
        try {
            final OAuth2AccessToken accessToken = linkedinAuth.getAccessToken(authorizationCode);
            final OAuthRequest request = new OAuthRequest(Verb.GET, LINKEDIN_ME_ENDPOINT);
            linkedinAuth.signRequest(accessToken, request);
            final Response response = linkedinAuth.execute(request);
            return response.getBody();
        }
        catch(final Exception e) {
            log.error(e);
        }
        return "error";
    }
}
