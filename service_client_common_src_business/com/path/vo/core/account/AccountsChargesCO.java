package com.path.vo.core.account;

import com.path.dbmaps.vo.AMF_CHARGESVO;
import com.path.lib.vo.BaseVO;

public class AccountsChargesCO extends BaseVO
{
    private AMF_CHARGESVO amfChargesVO;
    private String chargeSchemaDesc;

    public AMF_CHARGESVO getAmfChargesVO()
    {
	return amfChargesVO;
    }

    public void setAmfChargesVO(AMF_CHARGESVO amfChargesVO)
    {
	this.amfChargesVO = amfChargesVO;
    }

    public String getChargeSchemaDesc()
    {
	return chargeSchemaDesc;
    }

    public void setChargeSchemaDesc(String chargeSchemaDesc)
    {
	this.chargeSchemaDesc = chargeSchemaDesc;
    }
}
