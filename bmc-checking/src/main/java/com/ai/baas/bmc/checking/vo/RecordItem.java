package com.ai.baas.bmc.checking.vo;

/**
 * Created by xin on 16-3-30.
 */
public class RecordItem {
    private String BSN;
    private String SN;
    private String detail;

    public RecordItem(String SN, String BSN) {
        this.BSN = BSN;
        this.SN = SN;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public String getSN() {
        return SN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordItem that = (RecordItem) o;

        if (!BSN.equals(that.BSN)) return false;
        return SN.equals(that.SN);

    }

    @Override
    public int hashCode() {
        int result = BSN.hashCode();
        result = 31 * result + SN.hashCode();
        return result;
    }

    public String getDetail() {
        return detail;
    }
}
