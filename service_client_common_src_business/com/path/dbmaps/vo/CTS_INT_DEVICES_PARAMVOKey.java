package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_INT_DEVICES_PARAMVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_INT_DEVICES_PARAM.DEVICE_CODE
     */
    private BigDecimal DEVICE_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_INT_DEVICES_PARAM.DEVICE_CODE
     *
     * @return the value of CTS_INT_DEVICES_PARAM.DEVICE_CODE
     */
    public BigDecimal getDEVICE_CODE() {
        return DEVICE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_INT_DEVICES_PARAM.DEVICE_CODE
     *
     * @param DEVICE_CODE the value for CTS_INT_DEVICES_PARAM.DEVICE_CODE
     */
    public void setDEVICE_CODE(BigDecimal DEVICE_CODE) {
        this.DEVICE_CODE = DEVICE_CODE;
    }
}