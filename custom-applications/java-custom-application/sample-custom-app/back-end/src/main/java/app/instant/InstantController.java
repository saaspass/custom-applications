package app.instant;

import app.ApiController;
import app.SpService;
import app.mytoken.TokenResponse;
import app.mytoken.Tokens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
class InstantController extends ApiController {

    private static final Logger log = LoggerFactory.getLogger(InstantController.class);

    @Autowired
    private SpService spService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping(value = "/instant-login", method = POST)
    private ResponseEntity<?> instantLogin(@RequestHeader String username,
                                           @RequestHeader String session,
                                           @RequestHeader String tracker) {

        log.info("/instant-login {username: {}, session: {}, tracker: {}}", username, session, tracker);

        TrackerRequest request = new TrackerRequest(tracker, username);
        ResponseEntity<?> r = spService.execute(request, TrackerResponse.class);
        if (r.getStatusCode() != OK) {
            return r;
        }

        String destination = "/topic/instant-login/" + session;
        TokenResponse payload = new TokenResponse(Tokens.generate(username));
        simpMessagingTemplate.convertAndSend(destination, payload);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/instant-registration", method = POST)
    private ResponseEntity<?> instantRegister(@RequestHeader String username,
                                              @RequestHeader String session,
                                              @RequestHeader String tracker) {

        log.info("/instant-registration {username: {}, session: {}, tracker: {}}", username, session, tracker);

        TrackerRequest request = new TrackerRequest(tracker, username);
        ResponseEntity<?> r = spService.execute(request, TrackerResponse.class);
        if (r.getStatusCode() != OK) {
            return r;
        }

        String destination = "/topic/instant-registration/" + session;
        TokenResponse payload = new TokenResponse(Tokens.generate(username));
        simpMessagingTemplate.convertAndSend(destination, payload);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/sso", method = GET)
    private ResponseEntity<?> sso(TrackerRequest request) {

        log.info("/sso {account: {}, tracker: {}}", request.getAccount(), request.getTracker());

        ResponseEntity<?> r = spService.execute(request, TrackerResponse.class);
        if (r.getStatusCode() != OK) {
            return r;
        }

        String token = Tokens.generate(request.getAccount());
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
