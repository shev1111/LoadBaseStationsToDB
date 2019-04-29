package model;

public class Cell {
    private long lcid;
    private int mcc;
    private int mnc;
    private int lac;
    private int cid;
    private double lat;
    private double lon;
    private double azimuth;
    private String adres;

    public Cell() {
        this.mcc = 255;
        this.mnc = -1;
        this.lac = -1;
        this.cid = -1;
        this.lat = -1;
        this.lon = -1;
        this.azimuth = -1;
        this.adres = "not defined";
    }

    public long getLcid() {
        return lcid;
    }

    public void setLcid() {
        this.lcid = Long.parseLong(String.valueOf(lac)+String.valueOf(cid));
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public int getMnc() {
        return mnc;
    }

    public void setMnc(int mnc) {
        this.mnc = mnc;
    }

    public int getLac() {
        return lac;
    }

    public void setLac(int lac) {
        this.lac = lac;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "lcid=" + lcid +
                ", mcc=" + mcc +
                ", mnc=" + mnc +
                ", lac=" + lac +
                ", cid=" + cid +
                ", lat=" + lat +
                ", lon=" + lon +
                ", azimuth=" + azimuth +
                ", adres='" + adres + '\'' +
                '}';
    }
}
