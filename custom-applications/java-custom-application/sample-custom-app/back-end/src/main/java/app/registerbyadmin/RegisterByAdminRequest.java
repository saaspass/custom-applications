package app.registerbyadmin;

import app.Request;

class RegisterByAdminRequest implements Request {

    private String username;
    private String accountowner;
    private boolean isadaccount;

    @Override
    public String getTemplate() {
        return "/applications/{appKey}/registerbyadmin" +
                "?username={username}" +
                "&accountowner={accountowner}" +
                "&isadaccount={isadaccount}" +
                "&token={appToken}";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountowner() {
        return accountowner;
    }

    public void setAccountowner(String accountowner) {
        this.accountowner = accountowner;
    }

    public boolean getIsadaccount() {
        return isadaccount;
    }

    public void setIsadaccount(boolean isadaccount) {
        this.isadaccount = isadaccount;
    }
}
