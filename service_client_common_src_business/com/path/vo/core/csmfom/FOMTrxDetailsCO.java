package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.CTSTRXTYPE_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

public class FOMTrxDetailsCO extends RetailBaseVO
{
    private CTSTRXTYPE_DETVO ctsTrxTypeDetVO = new CTSTRXTYPE_DETVO();
    private BigDecimal cifNo;
    private String trxTypeDesc;
    private String elementName;
    private String trxDetailsPopUpData;
    private String cifStatus;
    private Date cif_UpdateDate;
    private String latestCifupdateDate;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    
    private ArrayList<FOMTrxDetailsCO> fomTrxDetailsListCOs = new ArrayList<FOMTrxDetailsCO>();

    public CTSTRXTYPE_DETVO getCtsTrxTypeDetVO()
    {
        return ctsTrxTypeDetVO;
    }

    public void setCtsTrxTypeDetVO(CTSTRXTYPE_DETVO ctsTrxTypeDetVO)
    {
        this.ctsTrxTypeDetVO = ctsTrxTypeDetVO;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public String getTrxTypeDesc()
    {
        return trxTypeDesc;
    }

    public void setTrxTypeDesc(String trxTypeDesc)
    {
        this.trxTypeDesc = trxTypeDesc;
    }

    public String getElementName()
    {
        return elementName;
    }

    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }

    public String getTrxDetailsPopUpData()
    {
        return trxDetailsPopUpData;
    }

    public void setTrxDetailsPopUpData(String trxDetailsPopUpData)
    {
        this.trxDetailsPopUpData = trxDetailsPopUpData;
    }

    public ArrayList<FOMTrxDetailsCO> getFomTrxDetailsListCOs()
    {
        return fomTrxDetailsListCOs;
    }

    public void setFomTrxDetailsListCOs(ArrayList<FOMTrxDetailsCO> fomTrxDetailsListCOs)
    {
        this.fomTrxDetailsListCOs = fomTrxDetailsListCOs;
    }

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm) {
		this.hm = hm;
	}

	public String getCifStatus() {
		return cifStatus;
	}

	public void setCifStatus(String cifStatus) {
		this.cifStatus = cifStatus;
	}

	public Date getCif_UpdateDate() {
		return cif_UpdateDate;
	}

	public void setCif_UpdateDate(Date cif_UpdateDate) {
		this.cif_UpdateDate = cif_UpdateDate;
	}

	public String getLatestCifupdateDate() {
		return latestCifupdateDate;
	}

	public void setLatestCifupdateDate(String latestCifupdateDate) {
		this.latestCifupdateDate = latestCifupdateDate;
	}
    
}
