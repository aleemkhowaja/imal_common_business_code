package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class FMS_FACILITY_ASSETVO extends FMS_FACILITY_ASSETVOKey
{
    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.CATEGORY_CODE
     */
    private BigDecimal CATEGORY_CODE;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.CLASS_CODE
     */
    private BigDecimal CLASS_CODE;

    /**
     * This field corresponds to the database column FMS_FACILITY_ASSET.SL_NO
     */
    private BigDecimal SL_NO;

    /**
     * This field corresponds to the database column FMS_FACILITY_ASSET.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column FMS_FACILITY_ASSET.QUANTITY
     */
    private BigDecimal QUANTITY;

    /**
     * This field corresponds to the database column FMS_FACILITY_ASSET.UNIT
     */
    private String UNIT;

    /**
     * This field corresponds to the database column FMS_FACILITY_ASSET.CURRENCY
     */
    private BigDecimal CURRENCY;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.UNIT_COST
     */
    private BigDecimal UNIT_COST;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.EXCH_RATE
     */
    private BigDecimal EXCH_RATE;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.ASSET_VALUE
     */
    private BigDecimal ASSET_VALUE;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.SALVAGE_PERCENT
     */
    private BigDecimal SALVAGE_PERCENT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.SALVAGE_VALUE
     */
    private BigDecimal SALVAGE_VALUE;

    /**
     * This field corresponds to the database column FMS_FACILITY_ASSET.VAT_CODE
     */
    private BigDecimal VAT_CODE;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.VAT_PERCENT
     */
    private BigDecimal VAT_PERCENT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.VAT_AMOUNT
     */
    private BigDecimal VAT_AMOUNT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.ASSET_WITH_VAT_VALUE
     */
    private BigDecimal ASSET_WITH_VAT_VALUE;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.DOWN_PAYMENT_PERC
     */
    private BigDecimal DOWN_PAYMENT_PERC;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.DOWN_PAYMENT_AMT
     */
    private BigDecimal DOWN_PAYMENT_AMT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.SECURITY_DEPOSIT_PERC
     */
    private BigDecimal SECURITY_DEPOSIT_PERC;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.SECURITY_DEPOSIT_AMT
     */
    private BigDecimal SECURITY_DEPOSIT_AMT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_PERC
     */
    private BigDecimal HAMISH_AL_JIDDIYA_PERC;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_PERC
     */
    private BigDecimal HAMISH_DOWN_PAYMENT_PERC;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.BALLOON_PERC
     */
    private BigDecimal BALLOON_PERC;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_AMT
     */
    private BigDecimal HAMISH_AL_JIDDIYA_AMT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.CASH_COLLATTERALS_AMT
     */
    private BigDecimal CASH_COLLATTERALS_AMT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_AMT
     */
    private BigDecimal HAMISH_DOWN_PAYMENT_AMT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.REFUND_TYPE
     */
    private BigDecimal REFUND_AMOUNT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.INSURANCE_CODE
     */
    private BigDecimal INSURANCE_CODE;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.INSURANCE_RATE
     */
    private BigDecimal INSURANCE_RATE;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.INSURANCE_AMOUNT
     */
    private BigDecimal INSURANCE_AMOUNT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.VENDOR_DOWN_PAYMENT_AMT
     */
    private BigDecimal VENDOR_DOWN_PAYMENT_AMT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.VENDOR_DOWN_PAYMENT_PERC
     */
    private BigDecimal VENDOR_DOWN_PAYMENT_PERC;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.PROFIT_RATE
     */
    private BigDecimal PROFIT_RATE;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.INSURANCE_VAT_CODE
     */
    private BigDecimal INSURANCE_VAT_CODE;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.INSURANCE_VAT_AMOUNT
     */
    private BigDecimal INSURANCE_VAT_AMOUNT;

    /**
     * This field corresponds to the database column
     * FMS_FACILITY_ASSET.BALLOON_AMOUNT
     */
    private BigDecimal BALLOON_AMOUNT;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.CATEGORY_CODE
     *
     * @return the value of FMS_FACILITY_ASSET.CATEGORY_CODE
     */
    public BigDecimal getCATEGORY_CODE()
    {
	return CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.CATEGORY_CODE
     *
     * @param CATEGORY_CODE the value for FMS_FACILITY_ASSET.CATEGORY_CODE
     */
    public void setCATEGORY_CODE(BigDecimal CATEGORY_CODE)
    {
	this.CATEGORY_CODE = CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.CLASS_CODE
     *
     * @return the value of FMS_FACILITY_ASSET.CLASS_CODE
     */
    public BigDecimal getCLASS_CODE()
    {
	return CLASS_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.CLASS_CODE
     *
     * @param CLASS_CODE the value for FMS_FACILITY_ASSET.CLASS_CODE
     */
    public void setCLASS_CODE(BigDecimal CLASS_CODE)
    {
	this.CLASS_CODE = CLASS_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.SL_NO
     *
     * @return the value of FMS_FACILITY_ASSET.SL_NO
     */
    public BigDecimal getSL_NO()
    {
	return SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.SL_NO
     *
     * @param SL_NO the value for FMS_FACILITY_ASSET.SL_NO
     */
    public void setSL_NO(BigDecimal SL_NO)
    {
	this.SL_NO = SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.CIF_NO
     *
     * @return the value of FMS_FACILITY_ASSET.CIF_NO
     */
    public BigDecimal getCIF_NO()
    {
	return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.CIF_NO
     *
     * @param CIF_NO the value for FMS_FACILITY_ASSET.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO)
    {
	this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.QUANTITY
     *
     * @return the value of FMS_FACILITY_ASSET.QUANTITY
     */
    public BigDecimal getQUANTITY()
    {
	return QUANTITY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.QUANTITY
     *
     * @param QUANTITY the value for FMS_FACILITY_ASSET.QUANTITY
     */
    public void setQUANTITY(BigDecimal QUANTITY)
    {
	this.QUANTITY = QUANTITY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.UNIT
     *
     * @return the value of FMS_FACILITY_ASSET.UNIT
     */
    public String getUNIT()
    {
	return UNIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.UNIT
     *
     * @param UNIT the value for FMS_FACILITY_ASSET.UNIT
     */
    public void setUNIT(String UNIT)
    {
	this.UNIT = UNIT == null ? null : UNIT.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.CURRENCY
     *
     * @return the value of FMS_FACILITY_ASSET.CURRENCY
     */
    public BigDecimal getCURRENCY()
    {
	return CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.CURRENCY
     *
     * @param CURRENCY the value for FMS_FACILITY_ASSET.CURRENCY
     */
    public void setCURRENCY(BigDecimal CURRENCY)
    {
	this.CURRENCY = CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.UNIT_COST
     *
     * @return the value of FMS_FACILITY_ASSET.UNIT_COST
     */
    public BigDecimal getUNIT_COST()
    {
	return UNIT_COST;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.UNIT_COST
     *
     * @param UNIT_COST the value for FMS_FACILITY_ASSET.UNIT_COST
     */
    public void setUNIT_COST(BigDecimal UNIT_COST)
    {
	this.UNIT_COST = UNIT_COST;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.EXCH_RATE
     *
     * @return the value of FMS_FACILITY_ASSET.EXCH_RATE
     */
    public BigDecimal getEXCH_RATE()
    {
	return EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.EXCH_RATE
     *
     * @param EXCH_RATE the value for FMS_FACILITY_ASSET.EXCH_RATE
     */
    public void setEXCH_RATE(BigDecimal EXCH_RATE)
    {
	this.EXCH_RATE = EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.ASSET_VALUE
     *
     * @return the value of FMS_FACILITY_ASSET.ASSET_VALUE
     */
    public BigDecimal getASSET_VALUE()
    {
	return ASSET_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.ASSET_VALUE
     *
     * @param ASSET_VALUE the value for FMS_FACILITY_ASSET.ASSET_VALUE
     */
    public void setASSET_VALUE(BigDecimal ASSET_VALUE)
    {
	this.ASSET_VALUE = ASSET_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.SALVAGE_PERCENT
     *
     * @return the value of FMS_FACILITY_ASSET.SALVAGE_PERCENT
     */
    public BigDecimal getSALVAGE_PERCENT()
    {
	return SALVAGE_PERCENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.SALVAGE_PERCENT
     *
     * @param SALVAGE_PERCENT the value for FMS_FACILITY_ASSET.SALVAGE_PERCENT
     */
    public void setSALVAGE_PERCENT(BigDecimal SALVAGE_PERCENT)
    {
	this.SALVAGE_PERCENT = SALVAGE_PERCENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.SALVAGE_VALUE
     *
     * @return the value of FMS_FACILITY_ASSET.SALVAGE_VALUE
     */
    public BigDecimal getSALVAGE_VALUE()
    {
	return SALVAGE_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.SALVAGE_VALUE
     *
     * @param SALVAGE_VALUE the value for FMS_FACILITY_ASSET.SALVAGE_VALUE
     */
    public void setSALVAGE_VALUE(BigDecimal SALVAGE_VALUE)
    {
	this.SALVAGE_VALUE = SALVAGE_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.VAT_CODE
     *
     * @return the value of FMS_FACILITY_ASSET.VAT_CODE
     */
    public BigDecimal getVAT_CODE()
    {
	return VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.VAT_CODE
     *
     * @param VAT_CODE the value for FMS_FACILITY_ASSET.VAT_CODE
     */
    public void setVAT_CODE(BigDecimal VAT_CODE)
    {
	this.VAT_CODE = VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.VAT_PERCENT
     *
     * @return the value of FMS_FACILITY_ASSET.VAT_PERCENT
     */
    public BigDecimal getVAT_PERCENT()
    {
	return VAT_PERCENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.VAT_PERCENT
     *
     * @param VAT_PERCENT the value for FMS_FACILITY_ASSET.VAT_PERCENT
     */
    public void setVAT_PERCENT(BigDecimal VAT_PERCENT)
    {
	this.VAT_PERCENT = VAT_PERCENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.VAT_AMOUNT
     *
     * @return the value of FMS_FACILITY_ASSET.VAT_AMOUNT
     */
    public BigDecimal getVAT_AMOUNT()
    {
	return VAT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.VAT_AMOUNT
     *
     * @param VAT_AMOUNT the value for FMS_FACILITY_ASSET.VAT_AMOUNT
     */
    public void setVAT_AMOUNT(BigDecimal VAT_AMOUNT)
    {
	this.VAT_AMOUNT = VAT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.ASSET_WITH_VAT_VALUE
     *
     * @return the value of FMS_FACILITY_ASSET.ASSET_WITH_VAT_VALUE
     */
    public BigDecimal getASSET_WITH_VAT_VALUE()
    {
	return ASSET_WITH_VAT_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.ASSET_WITH_VAT_VALUE
     *
     * @param ASSET_WITH_VAT_VALUE the value for
     *            FMS_FACILITY_ASSET.ASSET_WITH_VAT_VALUE
     */
    public void setASSET_WITH_VAT_VALUE(BigDecimal ASSET_WITH_VAT_VALUE)
    {
	this.ASSET_WITH_VAT_VALUE = ASSET_WITH_VAT_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.DOWN_PAYMENT_PERC
     *
     * @return the value of FMS_FACILITY_ASSET.DOWN_PAYMENT_PERC
     */
    public BigDecimal getDOWN_PAYMENT_PERC()
    {
	return DOWN_PAYMENT_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.DOWN_PAYMENT_PERC
     *
     * @param DOWN_PAYMENT_PERC the value for
     *            FMS_FACILITY_ASSET.DOWN_PAYMENT_PERC
     */
    public void setDOWN_PAYMENT_PERC(BigDecimal DOWN_PAYMENT_PERC)
    {
	this.DOWN_PAYMENT_PERC = DOWN_PAYMENT_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.DOWN_PAYMENT_AMT
     *
     * @return the value of FMS_FACILITY_ASSET.DOWN_PAYMENT_AMT
     */
    public BigDecimal getDOWN_PAYMENT_AMT()
    {
	return DOWN_PAYMENT_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.DOWN_PAYMENT_AMT
     *
     * @param DOWN_PAYMENT_AMT the value for FMS_FACILITY_ASSET.DOWN_PAYMENT_AMT
     */
    public void setDOWN_PAYMENT_AMT(BigDecimal DOWN_PAYMENT_AMT)
    {
	this.DOWN_PAYMENT_AMT = DOWN_PAYMENT_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.SECURITY_DEPOSIT_PERC
     *
     * @return the value of FMS_FACILITY_ASSET.SECURITY_DEPOSIT_PERC
     */
    public BigDecimal getSECURITY_DEPOSIT_PERC()
    {
	return SECURITY_DEPOSIT_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.SECURITY_DEPOSIT_PERC
     *
     * @param SECURITY_DEPOSIT_PERC the value for
     *            FMS_FACILITY_ASSET.SECURITY_DEPOSIT_PERC
     */
    public void setSECURITY_DEPOSIT_PERC(BigDecimal SECURITY_DEPOSIT_PERC)
    {
	this.SECURITY_DEPOSIT_PERC = SECURITY_DEPOSIT_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.SECURITY_DEPOSIT_AMT
     *
     * @return the value of FMS_FACILITY_ASSET.SECURITY_DEPOSIT_AMT
     */
    public BigDecimal getSECURITY_DEPOSIT_AMT()
    {
	return SECURITY_DEPOSIT_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.SECURITY_DEPOSIT_AMT
     *
     * @param SECURITY_DEPOSIT_AMT the value for
     *            FMS_FACILITY_ASSET.SECURITY_DEPOSIT_AMT
     */
    public void setSECURITY_DEPOSIT_AMT(BigDecimal SECURITY_DEPOSIT_AMT)
    {
	this.SECURITY_DEPOSIT_AMT = SECURITY_DEPOSIT_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_PERC
     *
     * @return the value of FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_PERC
     */
    public BigDecimal getHAMISH_AL_JIDDIYA_PERC()
    {
	return HAMISH_AL_JIDDIYA_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_PERC
     *
     * @param HAMISH_AL_JIDDIYA_PERC the value for
     *            FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_PERC
     */
    public void setHAMISH_AL_JIDDIYA_PERC(BigDecimal HAMISH_AL_JIDDIYA_PERC)
    {
	this.HAMISH_AL_JIDDIYA_PERC = HAMISH_AL_JIDDIYA_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_PERC
     *
     * @return the value of FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_PERC
     */
    public BigDecimal getHAMISH_DOWN_PAYMENT_PERC()
    {
	return HAMISH_DOWN_PAYMENT_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_PERC
     *
     * @param HAMISH_DOWN_PAYMENT_PERC the value for
     *            FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_PERC
     */
    public void setHAMISH_DOWN_PAYMENT_PERC(BigDecimal HAMISH_DOWN_PAYMENT_PERC)
    {
	this.HAMISH_DOWN_PAYMENT_PERC = HAMISH_DOWN_PAYMENT_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.BALLOON_PERC
     *
     * @return the value of FMS_FACILITY_ASSET.BALLOON_PERC
     */
    public BigDecimal getBALLOON_PERC()
    {
	return BALLOON_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.BALLOON_PERC
     *
     * @param BALLOON_PERC the value for FMS_FACILITY_ASSET.BALLOON_PERC
     */
    public void setBALLOON_PERC(BigDecimal BALLOON_PERC)
    {
	this.BALLOON_PERC = BALLOON_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_AMT
     *
     * @return the value of FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_AMT
     */
    public BigDecimal getHAMISH_AL_JIDDIYA_AMT()
    {
	return HAMISH_AL_JIDDIYA_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_AMT
     *
     * @param HAMISH_AL_JIDDIYA_AMT the value for
     *            FMS_FACILITY_ASSET.HAMISH_AL_JIDDIYA_AMT
     */
    public void setHAMISH_AL_JIDDIYA_AMT(BigDecimal HAMISH_AL_JIDDIYA_AMT)
    {
	this.HAMISH_AL_JIDDIYA_AMT = HAMISH_AL_JIDDIYA_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.CASH_COLLATTERALS_AMT
     *
     * @return the value of FMS_FACILITY_ASSET.CASH_COLLATTERALS_AMT
     */
    public BigDecimal getCASH_COLLATTERALS_AMT()
    {
	return CASH_COLLATTERALS_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.CASH_COLLATTERALS_AMT
     *
     * @param CASH_COLLATTERALS_AMT the value for
     *            FMS_FACILITY_ASSET.CASH_COLLATTERALS_AMT
     */
    public void setCASH_COLLATTERALS_AMT(BigDecimal CASH_COLLATTERALS_AMT)
    {
	this.CASH_COLLATTERALS_AMT = CASH_COLLATTERALS_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_AMT
     *
     * @return the value of FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_AMT
     */
    public BigDecimal getHAMISH_DOWN_PAYMENT_AMT()
    {
	return HAMISH_DOWN_PAYMENT_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_AMT
     *
     * @param HAMISH_DOWN_PAYMENT_AMT the value for
     *            FMS_FACILITY_ASSET.HAMISH_DOWN_PAYMENT_AMT
     */
    public void setHAMISH_DOWN_PAYMENT_AMT(BigDecimal HAMISH_DOWN_PAYMENT_AMT)
    {
	this.HAMISH_DOWN_PAYMENT_AMT = HAMISH_DOWN_PAYMENT_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column FMS_FACILITY_ASSET.REFUND_TYPE
     *
     * @return the value of FMS_FACILITY_ASSET.REFUND_TYPE
     */
    public BigDecimal getREFUND_AMOUNT()
    {
	return REFUND_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column FMS_FACILITY_ASSET.REFUND_TYPE
     *
     * @param REFUND_TYPE the value for FMS_FACILITY_ASSET.REFUND_TYPE
     */
    public void setREFUND_AMOUNT(BigDecimal REFUND_AMOUNT)
    {
	this.REFUND_AMOUNT = REFUND_AMOUNT;
    }

    public BigDecimal getINSURANCE_CODE()
    {
	return INSURANCE_CODE;
    }

    public void setINSURANCE_CODE(BigDecimal INSURANCE_CODE)
    {
	this.INSURANCE_CODE = INSURANCE_CODE;
    }

    public BigDecimal getINSURANCE_RATE()
    {
	return INSURANCE_RATE;
    }

    public void setINSURANCE_RATE(BigDecimal INSURANCE_RATE)
    {
	this.INSURANCE_RATE = INSURANCE_RATE;
    }

    public BigDecimal getINSURANCE_AMOUNT()
    {
	return INSURANCE_AMOUNT;
    }

    public void setINSURANCE_AMOUNT(BigDecimal INSURANCE_AMOUNT)
    {
	this.INSURANCE_AMOUNT = INSURANCE_AMOUNT;
    }

    public BigDecimal getVENDOR_DOWN_PAYMENT_AMT()
    {
	return VENDOR_DOWN_PAYMENT_AMT;
    }

    public void setVENDOR_DOWN_PAYMENT_AMT(BigDecimal VENDOR_DOWN_PAYMENT_AMT)
    {
	this.VENDOR_DOWN_PAYMENT_AMT = VENDOR_DOWN_PAYMENT_AMT;
    }

    public BigDecimal getVENDOR_DOWN_PAYMENT_PERC()
    {
	return VENDOR_DOWN_PAYMENT_PERC;
    }

    public void setVENDOR_DOWN_PAYMENT_PERC(BigDecimal VENDOR_DOWN_PAYMENT_PERC)
    {
	this.VENDOR_DOWN_PAYMENT_PERC = VENDOR_DOWN_PAYMENT_PERC;
    }

    public BigDecimal getPROFIT_RATE()
    {
	return PROFIT_RATE;
    }

    public void setPROFIT_RATE(BigDecimal PROFIT_RATE)
    {
	this.PROFIT_RATE = PROFIT_RATE;
    }

    public BigDecimal getINSURANCE_VAT_CODE()
    {
	return INSURANCE_VAT_CODE;
    }

    public void setINSURANCE_VAT_CODE(BigDecimal INSURANCE_VAT_CODE)
    {
	this.INSURANCE_VAT_CODE = INSURANCE_VAT_CODE;
    }

    public BigDecimal getINSURANCE_VAT_AMOUNT()
    {
	return INSURANCE_VAT_AMOUNT;
    }

    public void setINSURANCE_VAT_AMOUNT(BigDecimal INSURANCE_VAT_AMOUNT)
    {
	this.INSURANCE_VAT_AMOUNT = INSURANCE_VAT_AMOUNT;
    }

    public BigDecimal getBALLOON_AMOUNT()
    {
	return BALLOON_AMOUNT;
    }

    public void setBALLOON_AMOUNT(BigDecimal BALLOON_AMOUNT)
    {
	this.BALLOON_AMOUNT = BALLOON_AMOUNT;
    }
}