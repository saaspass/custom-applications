package app.login;

import app.ApiController;
import app.SpService;
import app.error.ErrorResponse;
import app.mytoken.TokenResponse;
import app.mytoken.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
class LoginController extends ApiController {

    @Autowired
    private SpService spService;

    @RequestMapping(value = "/login", method = POST)
    private ResponseEntity<?> login(@RequestBody LoginRequest request) {

        ResponseEntity<?> r = spService.execute(request, LoginResponse.class);

        if (r.getStatusCode() != OK) {
            ErrorResponse error = (ErrorResponse) r.getBody();
            return new ResponseEntity<>(error, r.getStatusCode());
        }

        String token = Tokens.generate(request.getUsername());
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
