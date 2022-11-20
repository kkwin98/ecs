package com.example.ecs.net;

public class Ecdw {

    private String rspnsCode, rspnsMssage, ecdwAdres, ecdwTyCode;

    public String getRspnsCode() {
        return rspnsCode;
    }

    public void setRspnsCode(String rspnsCode) {
        this.rspnsCode = rspnsCode;
    }

    public String getRspnsMssage() {
        return rspnsMssage;
    }

    public void setRspnsMssage(String rspnsMssage) {
        this.rspnsMssage = rspnsMssage;
    }

    public String getEcdwAdres() {
        return ecdwAdres;
    }

    public void setEcdwAdres(String ecdwAdres) {
        this.ecdwAdres = ecdwAdres;
    }

    public String getEcdwTyCode() {
        return ecdwTyCode;
    }

    public void setEcdwTyCode(String ecdwTyCode) {
        this.ecdwTyCode = ecdwTyCode;
    }

    @Override
    public String toString() {
        return "Ecdw{" +
                "rspnsCode='" + rspnsCode + '\'' +
                ", rspnsMssage='" + rspnsMssage + '\'' +
                ", ecdwAdres='" + ecdwAdres + '\'' +
                ", ecdwTyCode='" + ecdwTyCode + '\'' +
                '}';
    }
}
