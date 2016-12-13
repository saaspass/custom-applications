package app.addaccount;

import app.ApiController;
import app.SpService;
import app.SpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
class AddAccountController extends ApiController {

    @Autowired
    private SpService spService;

    @RequestMapping(value = "/add-account", method = POST)
    private ResponseEntity<?> addAccount(@RequestBody AddAccountRequest request) {
        return spService.execute(request, SpResponse.class);
    }
}
