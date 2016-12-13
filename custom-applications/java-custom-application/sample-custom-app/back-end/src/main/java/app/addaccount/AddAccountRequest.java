package app.addaccount;

import app.Request;

class AddAccountRequest implements Request {

    private String username;
    private String accountowner;
    private String grouplist;

    @Override
    public String getTemplate() {
        return "/{companyKey}/addaccount" +
                "?username={username}" +
                "&grouplist={grouplist}" +
                "&accountowner={accountowner}" +
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

    public String getGrouplist() {
        return grouplist;
    }

    public void setGrouplist(String grouplist) {
        this.grouplist = grouplist;
    }
}
