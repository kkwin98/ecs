package com.example.ecs.net;

import java.util.List;

public class EcsDoc {

    private String rspnsCode,rspnsMssage,totRow;
    private List<Proofs> proofs;

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

    public String getTotRow() {
        return totRow;
    }

    public void setTotRow(String totRow) {
        this.totRow = totRow;
    }

    public List<Proofs> getProofs() {
        return proofs;
    }

    public void setProofs(List<Proofs> proofs) {
        this.proofs = proofs;
    }

    @Override
    public String toString() {
        return "EcsDoc{" +
                "rspnsCode='" + rspnsCode + '\'' +
                ", rspnsMssage='" + rspnsMssage + '\'' +
                ", totRow='" + totRow + '\'' +
                ", proofs=" + proofs +
                '}';
    }

    public class Proofs {

        private String docCpcty, docId, docKndCode, docKndNm;
        private String presentnPosblDt, disuseDocAt, vaildDt, issuDt, issuInsttCode, issuInsttNm;
        private String issuTyCode, applId, applsId, applsKndNm, presentnNm;

        public String getDocCpcty() {
            return docCpcty;
        }

        public void setDocCpcty(String docCpcty) {
            this.docCpcty = docCpcty;
        }

        public String getDocId() {
            return docId;
        }

        public void setDocId(String docId) {
            this.docId = docId;
        }

        public String getDocKndCode() {
            return docKndCode;
        }

        public void setDocKndCode(String docKndCode) {
            this.docKndCode = docKndCode;
        }

        public String getDocKndNm() {
            return docKndNm;
        }

        public void setDocKndNm(String docKndNm) {
            this.docKndNm = docKndNm;
        }

        public String getPresentnPosblDt() {
            return presentnPosblDt;
        }

        public void setPresentnPosblDt(String presentnPosblDt) {
            this.presentnPosblDt = presentnPosblDt;
        }

        public String getDisuseDocAt() {
            return disuseDocAt;
        }

        public void setDisuseDocAt(String disuseDocAt) {
            this.disuseDocAt = disuseDocAt;
        }

        public String getVaildDt() {
            return vaildDt;
        }

        public void setVaildDt(String vaildDt) {
            this.vaildDt = vaildDt;
        }

        public String getIssuDt() {
            return issuDt;
        }

        public void setIssuDt(String issuDt) {
            this.issuDt = issuDt;
        }

        public String getIssuInsttCode() {
            return issuInsttCode;
        }

        public void setIssuInsttCode(String issuInsttCode) {
            this.issuInsttCode = issuInsttCode;
        }

        public String getIssuInsttNm() {
            return issuInsttNm;
        }

        public void setIssuInsttNm(String issuInsttNm) {
            this.issuInsttNm = issuInsttNm;
        }

        public String getIssuTyCode() {
            return issuTyCode;
        }

        public void setIssuTyCode(String issuTyCode) {
            this.issuTyCode = issuTyCode;
        }

        public String getApplId() {
            return applId;
        }

        public void setApplId(String applId) {
            this.applId = applId;
        }

        public String getApplsId() {
            return applsId;
        }

        public void setApplsId(String applsId) {
            this.applsId = applsId;
        }

        public String getApplsKndNm() {
            return applsKndNm;
        }

        public void setApplsKndNm(String applsKndNm) {
            this.applsKndNm = applsKndNm;
        }

        public String getPresentnNm() {
            return presentnNm;
        }

        public void setPresentnNm(String presentnNm) {
            this.presentnNm = presentnNm;
        }

        @Override
        public String toString() {
            return "Proofs{" +
                    "docCpcty='" + docCpcty + '\'' +
                    ", docId='" + docId + '\'' +
                    ", docKndCode='" + docKndCode + '\'' +
                    ", docKndNm='" + docKndNm + '\'' +
                    ", presentnPosblDt='" + presentnPosblDt + '\'' +
                    ", disuseDocAt='" + disuseDocAt + '\'' +
                    ", vaildDt='" + vaildDt + '\'' +
                    ", issuDt='" + issuDt + '\'' +
                    ", issuInsttCode='" + issuInsttCode + '\'' +
                    ", issuInsttNm='" + issuInsttNm + '\'' +
                    ", issuTyCode='" + issuTyCode + '\'' +
                    ", applId='" + applId + '\'' +
                    ", applsId='" + applsId + '\'' +
                    ", applsKndNm='" + applsKndNm + '\'' +
                    ", presentnNm='" + presentnNm + '\'' +
                    '}';
        }
    }

}
