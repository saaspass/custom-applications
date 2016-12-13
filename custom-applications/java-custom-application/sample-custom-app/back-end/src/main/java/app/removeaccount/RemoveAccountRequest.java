package app.removeaccount;

import app.Request;

class RemoveAccountRequest implements Request {

    private String username;

    @Override
    public String getTemplate() {
        return "/{companyKey}/removeaccount" +
                "?username={username}" +
                "&token={companyToken}";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
