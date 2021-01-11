package com.path.vo.core.ciftrxtypelimit;

import java.io.Serializable;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.dbmaps.vo.CIF_TRXTYPE_LIMITSVO;
import com.path.lib.vo.BaseVO;

public class CifTrxTypeLimitCO extends BaseVO implements Serializable
{

    private CIF_TRXTYPE_LIMITSVO cifTrxtypeLimitVO;
    private CIFVO cifVO;
    private CIF_EXTENDEDVO cif_EXTENDEDVO; //Rakan Makarem - TP#544242 SBI170032 - Title of Account to be of 100 characters
    private String CIF_SHORT_NAME_ENG;
    private String CIF_SHORT_NAME_ARAB;
    private String AMF_BRIEF_NAME_ENG;
    private String AMF_BRIEF_NAME_ARAB;

    private String AMF_ADDITIONAL_REFERENCE;

    public String getCIF_SHORT_NAME_ENG()
    {
	return CIF_SHORT_NAME_ENG;
    }

    public void setCIF_SHORT_NAME_ENG(String cIFSHORTNAMEENG)
    {
	CIF_SHORT_NAME_ENG = cIFSHORTNAMEENG;
    }

    public String getAMF_BRIEF_NAME_ENG()
    {
	return AMF_BRIEF_NAME_ENG;
    }

    public void setAMF_BRIEF_NAME_ENG(String aMFBRIEFNAMEENG)
    {
	AMF_BRIEF_NAME_ENG = aMFBRIEFNAMEENG;
    }

    public CIF_TRXTYPE_LIMITSVO getCifTrxtypeLimitVO()
    {
	return cifTrxtypeLimitVO;
    }

    public void setCifTrxtypeLimitVO(CIF_TRXTYPE_LIMITSVO cifTrxtypeLimitVO)
    {
	this.cifTrxtypeLimitVO = cifTrxtypeLimitVO;
    }

    public String getCIF_SHORT_NAME_ARAB()
    {
	return CIF_SHORT_NAME_ARAB;
    }

    public void setCIF_SHORT_NAME_ARAB(String cIFSHORTNAMEARAB)
    {
	CIF_SHORT_NAME_ARAB = cIFSHORTNAMEARAB;
    }

    public String getAMF_BRIEF_NAME_ARAB()
    {
	return AMF_BRIEF_NAME_ARAB;
    }

    public void setAMF_BRIEF_NAME_ARAB(String aMFBRIEFNAMEARAB)
    {
	AMF_BRIEF_NAME_ARAB = aMFBRIEFNAMEARAB;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

    public String getAMF_ADDITIONAL_REFERENCE()
    {
        return AMF_ADDITIONAL_REFERENCE;
    }

    public void setAMF_ADDITIONAL_REFERENCE(String aMF_ADDITIONAL_REFERENCE)
    {
        AMF_ADDITIONAL_REFERENCE = aMF_ADDITIONAL_REFERENCE;
    }

    public CIF_EXTENDEDVO getCif_EXTENDEDVO()
    {
        return cif_EXTENDEDVO;
    }

    public void setCif_EXTENDEDVO(CIF_EXTENDEDVO cif_EXTENDEDVO)
    {
        this.cif_EXTENDEDVO = cif_EXTENDEDVO;
    }
    

}
