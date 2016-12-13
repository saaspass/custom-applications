package app.error;

/**
 * A class of error names used for error responses.
 * @author Elizabeta Ilievska
 */
public enum RestErrorEnum {
    /**
     * Invalid resource name.
     */
    INVALID_RESOURCE_ID("Invalid resource ID specified."),
    /**
     * Empty or null value in request.
     */
    EMPTY_OR_NULL_VALUE("Empty or null parameter value."),
    /**
     * Maximum parameter length exceeded.
     */
    MAX_LENGTH_EXCEEDED("Maximum parameter length exceeded."),
    /**
     * Invalid parameter value.
     */
    INVALID_PARAMETER_VALUE("Invalid parameter value."),
    /**
     * Application not found.
     */
    APPLICATION_NOT_FOUND("Application not found."),
    /**
     * SAASPASS Server Error.
     */
    SAASPASS_SERVER_ERROR("SAASPASS internal server error. Please try again."),
    /**
     * Tracker with the specified parameters was not found.
     */
    TRACKER_NOT_FOUND("The specified tracker was not found."),
    /**
     * Invalid OTP value.
     */
    INVALID_OTP("The provided OTP is invalid."),
    /**
     * No active device found for user.
     */
    NO_DEVICE_FOUND("No active device found for user."),
    /**
     * OTP check not allowed from this IP address.
     */
    INVALID_IP("Action not allowed from this IP address."),
    /**
     * Application is not active.
     */
    APPLICATION_NOT_ACTIVE("Application is not active."),
    /**
     * Tracker has expired.
     */
    TRACKER_EXPIRED("Tracker has expired."),
    /**
     * Invalid authentication credentials.
     */
    INVALID_CREDENTIALS("Invalid authentication credentials."),
    /**
     * The provided token has expired. Please re-authenticate.
     */
    EXPIRED_TOKEN("The provided token has expired. Please re-authenticate."),
    /**
     * Action forbidden for this application.
     */
    ACTION_FORBIDDEN_FOR_APPLICATION("Action forbidden for this application."),
    /**
     * User not assigned to application.
     */
    USER_NOT_ASSIGNED_TO_APPLICATION("User not assigned to application"),
    /**
     * User not assigned to company.
     */
    USER_NOT_ASSIGNED_TO_COMPANY("User not assigned to company."),
    /**
     * Invalid RDP session.
     */
    INVALID_RDP_SESSION("Invalid RDP session."),
    /**
     * Expired RDP session.
     */
    EXPIRED_RDP_SESSION("Expired RDP session."),
    /**
     * Invalid JSON request body.
     */
    INVALID_REQUEST("Invalid JSON request body"),
    /**
     * Application type not supported.
     */
    APPLICATION_TYPE_NOT_SUPPORTED("Application type not supported"),

    /**
     * Account already exists.
     */
    ACCOUNT_ALREADY_EXISTS("Account already exists"),

    /**
     * AD account cannot be deleted.
     */
    NOT_ALLOWED_TO_DELETE_AD_ACCOUNT("AD type account cannot be deleted manually"),

    /**
     * AD account cannot be created.
     */
    NOT_ALLOWED_TO_CREATE_AD_ACCOUNT("AD type account cannot be created manually"),

    /**
     * No unique account found.
     */
    NO_UNIQUE_ACCOUNT_FOUND("No unique account found for given username"),

    /**
     * Not allowed to verify (phone account, external email account).
     */
    NOT_ALLOWED_TO_VERIFY_ACCOUNT("This type of account is not allowed to be verified manually"),

    /**
     * Cannot send verification email.
     */
    NOT_ALLOWED_TO_VERIFY_VIA_EMAIL("This type of account is not allowed to be verified via verification email"),

    /**
     * Pending username requires verification data.
     */
    USERNAME_REQUIRES_VERIFICATION_DATA_FOR_REGISTRATION(
            "Active username not found. Registering a new username requires verification data to be provided"),

    /**
     * Group not found.
     */
    GROUP_NOT_FOUND("Group not found"),

    /**
     * Group is not valid to add account.
     */
    NOT_ALLOWED_ADDING_TO_GROUP("Provided group is managed automatically. Adding account manually is not allowed"),

    /**
     * Incorrect credentials.
     */
    INCORRECT_CREDENTIALS("Incorrect credentials. If problem continues, check time/time zone of your mobile device"),

    /**
     * Account already verified for another user.
     */
    ACCOUNT_IS_VERIFIED_FOR_ANOTHER_USER(
            "Account is already verified and the owner is different than the verification data refers"),

    /**
     * Verification data is invalid.
     */
    VERIFICATION_DATA_IS_INVALID("Verification data is invalid"),

    /**
     * Too many requests.
     */
    TOO_MANY_REQUEST("Rate Limit exceeded for this method. Wait till time window resets"),

    /**
     * Account not found.
     */
    ACCOUNT_NOT_FOUND("Account not found"),

    /**
     * Pending account not found.
     */
    PENDING_ACCOUNT_NOT_FOUND("Pending account not found"),

    /**
     * User protected himself with saaspass but username is pending email.
     */
    USER_OPTIONAL_APPLICATION_PENDING_EMAIL_ACCOUNT(
            "User has set protection with SAASPASS but didn't complete the process by verifying his email."
                    + "  User is allowed to login old way until setting protection is completed."),

    /**
     * User protected himself with saaspass but username is pending phone number.
     */
    USER_OPTIONAL_APPLICATION_PENDING_PHONE_ACCOUNT(
            "User has set protection with SAASPASS but didn't complete the process by verifying his phone number."
                    + " User is allowed to login old way until setting protection is completed."),

    /**
     * Not assign user is allowed to login due to optional protection.
     */
    USER_NOT_ASSIGNED_TO_APPLICATION_ALLOWED_LOGIN(
            "User not assigned to application with optional usage. User is allowed to login old way."),
    /**
     * Admin assigned account, but username is pending phone number.
     */
    ADMIN_OPTIONAL_APPLICATION_PENDING_PHONE_ACCOUNT(
            "Admin has assigned user protection with SAASPASS but account is pending phone number."
                    + " User is allowed to login old way until verification is completed."),

    /**
     * Admin assigned account, but username is pending email address.
     */
    ADMIN_OPTIONAL_APPLICATION_PENDING_EMAIL_ACCOUNT(
            "Admin has assigned user protection with SAASPASS but account is pending email."
                    + " User is allowed to login old way until verification is completed."),
    /**
     * Simple username or AD account is pending and assigned to application with optional usage- admin (or user)
     * controlled.
     */
    ADMIN_OPTIONAL_APPLICATION_PENDING_ACCOUNT(
            "Admin has assigned user protection with SAASPASS but hasn't assign SAASPASS owner to it."),

    /** Error enum for ERR_100924. */
    LOGINFAIL_ACCOUNT_NOTASSIGNED_OR_NOTVERIFIED(
            "User account is not assigned to the application or it is not verified"),

    /** Error enum for ERR_100925. */
    LOGINFAIL_OTP_MANDATORY_FOR_ACCOUNT("OTP is mandatory for account that is assigned to application and verified"),

    /** Error enum for ERR_100926. */
    LOGINFAIL_UNVERIFIED_ASSIGNED_ACCOUNT_NOT_ALLOWED(
            "Login with an unverified/assigned account is not allowed for the application"),

    /** Error enum for ERR_100927. */
    LOGINFAIL_UNASSIGNED_ACCOUNT_NOT_ALLOWED(
            "Login with an unverified account that is not assigned to the application is not allowed"),

    /** Error enum for ERR_100928. */
    LOGINFAIL_NONEXIST_ACCOUNT_NOT_ALLOWED("Login with non-existing account is not allowed for the application"),

    /** Error enum for ERR_100929. */
    LOGINFAIL_ACCOUNT_BLOCKED("User account is blocked from login to applications"),

    /** Error enum for ERR_100930. */
    LOGINFAIL_NOTASSIGNED_ALLOWED_IF_ACTIVE(
            "Login with not-assigned account is allowed for application only if account is active"),

    /** Error enum for ERR_100931. */
    LOGINFAIL_NOTASSIGNED_ALLOWED_IF_UNVERIFIED(
            "Login with not-assigned account is allowed for application only if account is unverified"),

    /**
     * Instead of internal error, this one is returned.
     */
    ACTION_NOT_SUCCESSFUL("Action is not successful. Check your parameters or developers page"),

    /**
     * Warning for Account is pending on email verification.
     */
    WARNING_ACCOUNT_PENDING_ON_EMAIL("Account is pending on email verification"),

    /**
     * Warning for user is blocked.
     */
    WARNING_USER_IS_BLOCKED(
            "User is blocked due to security reason. To let user login to applications, he/she should be unblocked from admin portal"),

    /**
     * Warning for account is still assigned to application case.
     */
    WARNING_ACCOUNT_STILL_ASSIGNED_TO_APP(
            "Account is removed from Application Group but it is still assigned to application via some other groups, so user can still login to the application. Use admin portal to remove all assignments in case of need"),

    /**
     * Empty accounts list in response.
     */
    USER_DOESNT_HAVE_ACCOUNTS_IN_COMPANY("No accounts were found for this company."),
    /**
     * Slack user already verified.
     */
    SLACK_USER_ALREADY_VERIFIED("You are already verified with SAASPASS. "
            + "To change the SAASPASS ID for your account please type the command /saaspass reconnect."),
    /**
     * Slack Team was not found in DB.
     */
    SLACK_TEAM_NOT_FOUND("Your Team was not recognized by SAASPASS. Please contact your team administrator.\n"
            + " If you are the administrator,"
            + " please visit https://www.saaspass.com/how-to-install-saasspass-app-commands-to-your-team.html"),
    /**
     * error occured on slack command.
     */
    SLACK_GENERAL_ERROR(
            "A problem occurred. Please try to log in from www.saaspass.com/sd/ or contact us at support@saaspass.com"),

    /**
     * general invalid push login request.
     */
    INVALID_PUSH_LOGIN_REQUEST("Login For this user in not allowed");

    /**
     * Descriptive error message.
     */
    private String message;

    /**
     * Constructor.
     * @param message
     *            - message.
     */
    private RestErrorEnum(final String message) {
        this.message = message;
    }

    /**
     * @return message.
     */
    public String message() {
        return message;
    }
}
