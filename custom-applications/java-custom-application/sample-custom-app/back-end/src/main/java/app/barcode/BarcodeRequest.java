package app.barcode;

import app.Request;

class BarcodeRequest implements Request {

    private BarcodeType type;
    private String session;

    @Override
    public String getTemplate() {
        return "/applications/{appKey}/barcodes" +
                "?type={type}" +
                "&session={session}" +
                "&token={appToken}";
    }

    public BarcodeType getType() {
        return type;
    }

    public void setType(BarcodeType type) {
        this.type = type;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    private enum BarcodeType {
        IL, IR, BT, ILIR, ILBT
    }
}
