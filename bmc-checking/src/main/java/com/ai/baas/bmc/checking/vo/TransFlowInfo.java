package com.ai.baas.bmc.checking.vo;

/**
 * Created by xin on 16-3-30.
 */
public class TransFlowInfo {
    private String BSN;
    private String SN;
    private String detail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransFlowInfo that = (TransFlowInfo) o;

        if (!BSN.equals(that.BSN)) return false;
        return SN.equals(that.SN);

    }

    @Override
    public int hashCode() {
        int result = BSN.hashCode();
        result = 31 * result + SN.hashCode();
        return result;
    }
}
