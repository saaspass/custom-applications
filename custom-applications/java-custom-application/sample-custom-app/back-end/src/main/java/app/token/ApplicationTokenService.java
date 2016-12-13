package app.token;

import app.SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicationTokenService implements TokenService {

    @Autowired
    private SpService spService;

    private String value;

    @Override
    public String getValue() {
        return value == null ? getNewValue() : value;
    }

    @Override
    public String getNewValue() {
        ApplicationTokenRequest request = new ApplicationTokenRequest();
        ResponseEntity<?> response = spService.execute(request, TokenResponse.class);
        TokenResponse body = (TokenResponse) response.getBody();
        return value = body.getToken();
    }
}
