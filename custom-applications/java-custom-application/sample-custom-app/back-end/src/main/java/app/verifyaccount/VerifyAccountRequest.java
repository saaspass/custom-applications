package app.verifyaccount;

import app.Request;

class VerifyAccountRequest implements Request {

    private String username;
    private String accountowner;
    private boolean isadaccount;

    @Override
    public String getTemplate() {
        return "/{companyKey}/verifyaccount" +
                "?username={username}" +
                "&accountowner={accountowner}" +
                "&isadaccount={isadaccount}" +
                "&token={companyToken}";
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
