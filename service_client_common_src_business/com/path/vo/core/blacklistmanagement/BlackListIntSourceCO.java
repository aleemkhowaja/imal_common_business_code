package com.path.vo.core.blacklistmanagement;

import java.math.BigDecimal;
import java.util.HashMap;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_BLACKLISTVO;
import com.path.dbmaps.vo.DF_DATA_FILEVO;
import com.path.dbmaps.vo.OFAC_MAINVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.UN_MAINVO;
import com.path.vo.core.common.RetailBaseVO;

public class BlackListIntSourceCO extends RetailBaseVO
{
    private CIFVO cifVO = new CIFVO();
    private CIF_BLACKLISTVO cif_BlackListVO = new CIF_BLACKLISTVO();
    private OFAC_MAINVO ofac_MainVO = new OFAC_MAINVO();
    private UN_MAINVO un_MainVO = new UN_MAINVO();
    private DF_DATA_FILEVO dfDataFileVO = new DF_DATA_FILEVO();
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();


    private String LONG_NAME;
    private String STR_DOB;
    private String statusDesc;
    private String rowId;
    private BigDecimal oldBlackListed;

    private String checkedList;
    private String fromWhere;
    private String currentDate;

    private String confirmMsg;
    
    private String REFERENCE_NUMBER;

    public CIFVO getCifVO()
    {
	return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public CIF_BLACKLISTVO getCif_BlackListVO()
    {
	return cif_BlackListVO;
    }

    public void setCif_BlackListVO(CIF_BLACKLISTVO cifBlackListVO)
    {
	cif_BlackListVO = cifBlackListVO;
    }

    public OFAC_MAINVO getOfac_MainVO()
    {
	return ofac_MainVO;
    }

    public void setOfac_MainVO(OFAC_MAINVO ofacMainVO)
    {
	ofac_MainVO = ofacMainVO;
    }

    public UN_MAINVO getUn_MainVO()
    {
	return un_MainVO;
    }

    public void setUn_MainVO(UN_MAINVO unMainVO)
    {
	un_MainVO = unMainVO;
    }

    public String getLONG_NAME()
    {
	return LONG_NAME;
    }

    public void setLONG_NAME(String lONGNAME)
    {
	LONG_NAME = lONGNAME;
    }

    public String getSTR_DOB()
    {
	return STR_DOB;
    }

    public void setSTR_DOB(String sTRDOB)
    {
	STR_DOB = sTRDOB;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public String getRowId()
    {
	return rowId;
    }

    public void setRowId(String rowId)
    {
	this.rowId = rowId;
    }

    public String getCheckedList()
    {
	return checkedList;
    }

    public void setCheckedList(String checkedList)
    {
	this.checkedList = checkedList;
    }

    public String getFromWhere()
    {
	return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
	this.fromWhere = fromWhere;
    }

    public String getCurrentDate()
    {
	return currentDate;
    }

    public void setCurrentDate(String currentDate)
    {
	this.currentDate = currentDate;
    }

    public String getConfirmMsg()
    {
	return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg)
    {
	this.confirmMsg = confirmMsg;
    }

    public BigDecimal getOldBlackListed()
    {
	return oldBlackListed;
    }

    public void setOldBlackListed(BigDecimal oldBlackListed)
    {
	this.oldBlackListed = oldBlackListed;
    }

	
	public String getREFERENCE_NUMBER()
	{
		return REFERENCE_NUMBER;
	}

	
	public void setREFERENCE_NUMBER(String rEFERENCE_NUMBER)
	{
		REFERENCE_NUMBER = rEFERENCE_NUMBER;
	}

	
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
	{
		return buisnessElement;
	}

	
	public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
	{
		this.buisnessElement = buisnessElement;
	}

	public DF_DATA_FILEVO getDfDataFileVO() {
		return dfDataFileVO;
	}

	public void setDfDataFileVO(DF_DATA_FILEVO dfDataFileVO) {
		this.dfDataFileVO = dfDataFileVO;
	}
	
	

}
