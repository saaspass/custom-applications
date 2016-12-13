package app.registerbyuser;

import app.Request;

class RegisterByUserRequest implements Request {

    private String username;
    private String saaspassid;
    private String otp;
    private boolean isadaccount;

    @Override
    public String getTemplate() {
        return "/applications/{appKey}/registerbyuser" +
                "?username={username}" +
                "&saaspassid={saaspassid}" +
                "&otp={otp}" +
                "&isadaccount={isadaccount}" +
                "&token={appToken}";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSaaspassid() {
        return saaspassid;
    }

    public void setSaaspassid(String saaspassid) {
        this.saaspassid = saaspassid;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public boolean getIsadaccount() {
        return isadaccount;
    }

    public void setIsadaccount(boolean isadaccount) {
        this.isadaccount = isadaccount;
    }
}
