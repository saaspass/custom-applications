package app;

import app.error.ErrorResponse;
import app.error.MyResponseErrorHandler;
import app.error.RestApiException;
import app.error.RestErrorEnum;
import app.token.ApplicationTokenService;
import app.token.CompanyTokenService;
import app.token.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Service
public class SpService {

    private static final Logger log = LoggerFactory.getLogger(SpService.class);

    @Autowired
    private CompanyTokenService companyTokenService;

    @Autowired
    private ApplicationTokenService applicationTokenService;

    @Value("${saaspass.api.url}")
    private String spApiUrl;

    @Value("${saaspass.company.key}")
    private String spCompanyKey;

    @Value("${saaspass.company.secret}")
    private String spCompanySecret;

    @Value("${saaspass.app.key}")
    private String spAppKey;

    @Value("${saaspass.app.password}")
    private String spAppPassword;

    public <T> ResponseEntity<?> execute(Request request, Class<T> responseType) {

        if (request.getTemplate().contains("{appToken}")) {
            return execute(request, applicationTokenService, responseType);
        }

        if (request.getTemplate().contains("{companyToken}")) {
            return execute(request, companyTokenService, responseType);
        }

        return execute(request, "", responseType);
    }

    private <T> ResponseEntity<?> execute(Request request, TokenService tokenService, Class<T> responseType) {

        ResponseEntity<?> r = execute(request, tokenService.getValue(), responseType);

        if (r.getStatusCode() == FORBIDDEN) {
            ErrorResponse error = (ErrorResponse) r.getBody();
            if (error != null && error.getName() == RestErrorEnum.EXPIRED_TOKEN) {
                r = execute(request, tokenService.getNewValue(), responseType);
            }
        }

        return r;
    }

    private <T> ResponseEntity<?> execute(Request request, String token, Class<T> responseType) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new MyResponseErrorHandler());

        try {
            T data = restTemplate.getForObject(toUrl(request, token), responseType);
            return ResponseEntity.ok(data);
        } catch (RestApiException e) {
            return ResponseEntity.status(e.getStatusCode())
                    .body(e.getErrorResponse());
        }
    }

    private String toUrl(Request request, String token) {

        String url = spApiUrl + request.getTemplate();
        url = url.replace("{companyKey}", spCompanyKey);
        url = url.replace("{companySecret}", spCompanySecret);
        url = url.replace("{companyToken}", token);
        url = url.replace("{appKey}", spAppKey);
        url = url.replace("{appPassword}", spAppPassword);
        url = url.replace("{appToken}", token);
        url = format(url, request);

        log.info(url);

        return url;
    }

    private String format(String url, Request request) {
        for (Map.Entry<String, Object> entry : map(request).entrySet()) {
            Object value = entry.getValue();
            String replacement = value == null ? "" : String.valueOf(value);
            url = url.replace("{" + entry.getKey() + "}", replacement);
        }
        return url;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> map(Request request) {
        return new ObjectMapper().convertValue(request, Map.class);
    }
}
