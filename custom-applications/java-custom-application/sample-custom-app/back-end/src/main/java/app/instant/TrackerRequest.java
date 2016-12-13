package app.instant;

import app.Request;

class TrackerRequest implements Request {

    private String tracker;
    private String account;

    public TrackerRequest() {
    }

    public TrackerRequest(String tracker, String account) {
        this.tracker = tracker;
        this.account = account;
    }

    @Override
    public String getTemplate() {
        return "/applications/{appKey}/trackers/{tracker}" +
                "?account={account}" +
                "&token={appToken}";
    }

    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
