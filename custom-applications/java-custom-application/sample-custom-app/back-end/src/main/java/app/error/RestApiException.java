package app.error;

import org.springframework.http.HttpStatus;

public class RestApiException extends RuntimeException {

    private HttpStatus statusCode;
    private ErrorResponse errorResponse;

    RestApiException(HttpStatus statusCode, ErrorResponse errorResponse) {
        this.statusCode = statusCode;
        this.errorResponse = errorResponse;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
