package app.token;

import app.Request;

public class CompanyTokenRequest implements Request {

    @Override
    public String getTemplate() {
        return "/{companyKey}/tokens" +
                "?companysecret={companySecret}";
    }
}
