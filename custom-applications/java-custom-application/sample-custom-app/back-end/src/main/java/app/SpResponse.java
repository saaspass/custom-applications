package app;

public class SpResponse {

    private String resultMessage;
    private boolean isVerified;
    private boolean isPendingOnEmail;
    private boolean isAccountOwnerBlocked;
    private String warning;

    public String getResultMessage() {
        return resultMessage;
    }

    public boolean getIsVerified() {
        return isVerified;
    }

    public boolean getIsPendingOnEmail() {
        return isPendingOnEmail;
    }

    public boolean getIsAccountOwnerBlocked() {
        return isAccountOwnerBlocked;
    }

    public String getWarning() {
        return warning;
    }
}
