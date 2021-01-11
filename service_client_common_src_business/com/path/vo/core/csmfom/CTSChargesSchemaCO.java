package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.CTSCHARGES_SCHEMAVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 */
public class CTSChargesSchemaCO extends BaseVO
{
    private CTSCHARGES_SCHEMAVO ctsChargesSchemaVO = new CTSCHARGES_SCHEMAVO();
    private String CHARGES_DESC;

    public String getCHARGES_DESC()
    {
	return CHARGES_DESC;
    }

    public void setCHARGES_DESC(String cHARGESDESC)
    {
	CHARGES_DESC = cHARGESDESC;
    }

    public CTSCHARGES_SCHEMAVO getCtsChargesSchemaVO()
    {
	return ctsChargesSchemaVO;
    }

    public void setCtsChargesSchemaVO(CTSCHARGES_SCHEMAVO ctsChargesSchemaVO)
    {
	this.ctsChargesSchemaVO = ctsChargesSchemaVO;
    }
}
