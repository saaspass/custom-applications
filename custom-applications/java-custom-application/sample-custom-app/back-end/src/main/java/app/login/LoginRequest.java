package app.login;

import app.Request;

class LoginRequest implements Request {

    private String username;
    private String otp;

    @Override
    public String getTemplate() {
        return "/applications/{appKey}/otpchecks" +
                "?username={username}" +
                "&otp={otp}" +
                "&token={appToken}";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
