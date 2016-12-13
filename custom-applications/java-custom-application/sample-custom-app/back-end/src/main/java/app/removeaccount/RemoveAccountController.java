package app.removeaccount;

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
class RemoveAccountController extends ApiController {

    @Autowired
    private SpService spService;

    @RequestMapping(value = "/remove-account", method = POST)
    private ResponseEntity<?> removeAccount(@RequestHeader String authorization,
                                            @RequestBody RemoveAccountRequest request) {
        try {
            Tokens.authorize(authorization);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401)
                    .body(new ErrorResponse(e.getMessage()));
        }

        return spService.execute(request, SpResponse.class);
    }
}
