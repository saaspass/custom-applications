package app.error;

public class ErrorResponse {

    private RestErrorEnum name;
    private String message;
    private String informationlink;

    public ErrorResponse() {
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public RestErrorEnum getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getInformationlink() {
        return informationlink;
    }
}
