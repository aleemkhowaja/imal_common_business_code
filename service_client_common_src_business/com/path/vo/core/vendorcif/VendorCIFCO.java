package com.path.vo.core.vendorcif;

import com.path.dbmaps.vo.TRS_VENDORVO;
import com.path.lib.vo.BaseVO;

public class VendorCIFCO extends BaseVO
{
    TRS_VENDORVO trsVendorVO;
    String SHORT_NAME_ENG, LONG_NAME_ENG;
    String SHORT_NAME_ARAB, LONG_NAME_ARAB;
    String ID_NO, ADDITIONAL_REFERENCE;

    public TRS_VENDORVO getTrsVendorVO()
    {
	return trsVendorVO;
    }

    public void setTrsVendorVO(TRS_VENDORVO trsVendorVO)
    {
	this.trsVendorVO = trsVendorVO;
    }

    public String getSHORT_NAME_ENG()
    {
	return SHORT_NAME_ENG;
    }

    public void setSHORT_NAME_ENG(String sHORTNAMEENG)
    {
	SHORT_NAME_ENG = sHORTNAMEENG;
    }

    public String getLONG_NAME_ENG()
    {
	return LONG_NAME_ENG;
    }

    public void setLONG_NAME_ENG(String lONGNAMEENG)
    {
	LONG_NAME_ENG = lONGNAMEENG;
    }

    public String getSHORT_NAME_ARAB()
    {
	return SHORT_NAME_ARAB;
    }

    public void setSHORT_NAME_ARAB(String sHORTNAMEARAB)
    {
	SHORT_NAME_ARAB = sHORTNAMEARAB;
    }

    public String getLONG_NAME_ARAB()
    {
	return LONG_NAME_ARAB;
    }

    public void setLONG_NAME_ARAB(String lONGNAMEARAB)
    {
	LONG_NAME_ARAB = lONGNAMEARAB;
    }

    public String getID_NO()
    {
	return ID_NO;
    }

    public void setID_NO(String iDNO)
    {
	ID_NO = iDNO;
    }

    public String getADDITIONAL_REFERENCE()
    {
	return ADDITIONAL_REFERENCE;
    }

    public void setADDITIONAL_REFERENCE(String aDDITIONALREFERENCE)
    {
	ADDITIONAL_REFERENCE = aDDITIONALREFERENCE;
    }
}
