package io.jobbott.app.util;

public class Constants {

    /** Navigation */
    public static final String URI_HOMEPAGE = "http://localhost:8080";
    public static final String PATH_TO_AUTH = "/auth";
    public static final String PATH_TO_CALLBACK = "/callback";
    public static final String AUTH_LINKEDIN = PATH_TO_AUTH + "/linkedin";
    public static final String CALLBACK_LINKEDIN = AUTH_LINKEDIN + PATH_TO_CALLBACK;

    /** API Requests */
    public static final String LINKEDIN_ME_ENDPOINT = "https://api.linkedin.com/v2/me";
    public static final String YELP_GRAPHQL_ENDPOINT = "https://api.yelp.com/v3/graphql";
    public static final String LINKEDIN_DEFAULT_SCOPE = "r_liteprofile,r_emailaddress,w_member_social";

    /** Servlet config */
    public static final String JSP_VIEW_RESOLVER_PREFIX = "/WEB-INF/classes/templates/";
    public static final String JSP_VIEW_RESOLVER_SUFFIX = ".jsp";

    /** Views */
    public static final String INDEX_VIEW = "index";

    /** Properties */
    public static final String API_KEY_LINKEDIN = "linkedin.clientId";
    public static final String API_SECRET_LINKEDIN = "linkedin.clientSecret";
    public static final String API_KEY_YELP = "yelp.apiKey";
}
