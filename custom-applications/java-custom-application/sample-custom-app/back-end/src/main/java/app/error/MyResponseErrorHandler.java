package app.error;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class MyResponseErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        try {
            ErrorResponse errorResponse = new ObjectMapper().readValue(response.getBody(), ErrorResponse.class);
            throw new RestApiException(response.getStatusCode(), errorResponse);
        } catch (JsonParseException e) {
            String message = response.getRawStatusCode() + " - " + response.getStatusText();
            throw new RestApiException(response.getStatusCode(), new ErrorResponse(message));
        }
    }
}
