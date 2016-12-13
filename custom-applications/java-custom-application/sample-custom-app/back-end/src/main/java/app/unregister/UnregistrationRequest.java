package app.unregister;

import app.Request;

class UnregistrationRequest implements Request {

    private String username;

    @Override
    public String getTemplate() {
        return "/applications/{appKey}/unregister" +
                "?username={username}" +
                "&token={appToken}";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
