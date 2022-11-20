package com.example.ecs;

import java.io.Serializable;

public class ListData implements Serializable {

    private String insttNm;
    private String docNm;
    private String issuDt;
    private String validDt;


    public ListData() {}

    public ListData(String insttNm, String docNm, String issuDt, String validDt) {
        this.insttNm = insttNm;
        this.docNm = docNm;
        this.issuDt = issuDt;
        this.validDt = validDt;
    }

    public String getInsttNm() {
        return insttNm;
    }

    public void setInsttNm(String insttNm) {
        this.insttNm = insttNm;
    }

    public String getDocNm() {
        return docNm;
    }

    public void setDocNm(String docNm) {
        this.docNm = docNm;
    }

    public String getIssuDt() {
        return issuDt;
    }

    public void setIssuDt(String issuDt) {
        this.issuDt = issuDt;
    }

    public String getValidDt() {
        return validDt;
    }

    public void setValidDt(String validDt) {
        this.validDt = validDt;
    }


    @Override
    public String toString() {
        return "ListData{" +
                "insttNm='" + insttNm + '\'' +
                ", docNm='" + docNm + '\'' +
                ", issuDt='" + issuDt + '\'' +
                ", validDt='" + validDt + '\'' +
                '}';
    }
}
