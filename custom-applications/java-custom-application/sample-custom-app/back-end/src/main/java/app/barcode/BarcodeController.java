package app.barcode;

import app.ApiController;
import app.SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
class BarcodeController extends ApiController {

    @Autowired
    private SpService spService;

    @RequestMapping(value = "/barcode", method = GET)
    private ResponseEntity<?> barcode(BarcodeRequest request) {
        return spService.execute(request, BarcodeResponse.class);
    }
}
