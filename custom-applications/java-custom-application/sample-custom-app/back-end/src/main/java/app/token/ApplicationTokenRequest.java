package app.token;

import app.Request;

public class ApplicationTokenRequest implements Request {

    @Override
    public String getTemplate() {
        return "/applications/{appKey}/tokens" +
                "?password={appPassword}";
    }
}
