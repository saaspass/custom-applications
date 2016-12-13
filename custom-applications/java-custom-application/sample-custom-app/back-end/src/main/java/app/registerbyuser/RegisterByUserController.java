package app.registerbyuser;

import app.ApiController;
import app.SpResponse;
import app.SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
class RegisterByUserController extends ApiController {

    @Autowired
    private SpService spService;

    @RequestMapping(value = "/register-by-user", method = POST)
    private ResponseEntity<?> registerByUser(@RequestBody RegisterByUserRequest request) {
        return spService.execute(request, SpResponse.class);
    }
}
