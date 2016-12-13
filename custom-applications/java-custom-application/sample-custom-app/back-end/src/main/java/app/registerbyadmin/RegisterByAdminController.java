package app.registerbyadmin;

import app.ApiController;
import app.SpResponse;
import app.SpService;
import app.error.ErrorResponse;
import app.mytoken.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
class RegisterByAdminController extends ApiController {

    @Autowired
    private SpService spService;

    @RequestMapping(value = "/register-by-admin", method = POST)
    private ResponseEntity<?> registerByAdmin(@RequestHeader String authorization,
                                              @RequestBody RegisterByAdminRequest request) {
        try {
            Tokens.authorize(authorization);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401)
                    .body(new ErrorResponse(e.getMessage()));
        }

        return spService.execute(request, SpResponse.class);
    }
}
