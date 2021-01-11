package com.path.vo.core.blacklistcontrolrecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ControlRecordCO.java used to
 */
public class BlackListControlRecordCO extends RetailBaseVO
{

	private CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	private CIFCONTROLVO oldCifControlVO = new CIFCONTROLVO();

	private String ivCrud;
	private BigDecimal LovTypeId;
	private String ProgRef;
	private int isRTLDir;
	private ArrayList<SmartCO> smartCOList;
	private Date runningDateTime;
	private BigDecimal compCode;
	private String saveUpdateFlag;
	private BigDecimal dualParam;
	private BigDecimal method;
	private String statusDesc;

	private String BLCKL_FST_NAME;
	private String BLCKL_SEC_NAME;
	private String BLCKL_LAST_NAME;
	private String BLCKL_THRD_NAME;
	private String BLCKL_BPLACE;
	private String BLCKL_BDATE;
	private String BLCKL_MOTHER_LNAME;
	private String BLCKL_IDNO;
	private String BLCKL_REGNO;
	private String BLCKL_BNAME;
	private String BLCKL_LNAME;
	private String BLCKL_NATION;
	private String BLCKL_REGION;
	private String BLCKL_COUNTRY;
	private String BLCKL_LEGAL;
	private String APPLY_BLKLST_ON_WALKIN_CUST_YN;
	private String BLCKL_MOTHER_FNAME;
	private BigDecimal cancelFlag;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private String BLCKL_TRX_NONFINANCE_YN;


	public CIFCONTROLVO getCifControlVO()
	{
		return cifControlVO;
	}

	public void setCifControlVO(CIFCONTROLVO cifControlVO)
	{
		this.cifControlVO = cifControlVO;
	}

	public String getIvCrud()
	{
		return ivCrud;
	}

	public void setIvCrud(String ivCrud)
	{
		this.ivCrud = ivCrud;
	}

	public BigDecimal getLovTypeId()
	{
		return LovTypeId;
	}

	public void setLovTypeId(BigDecimal lovTypeId)
	{
		LovTypeId = lovTypeId;
	}

	public String getProgRef()
	{
		return ProgRef;
	}

	public void setProgRef(String progRef)
	{
		ProgRef = progRef;
	}

	public int getIsRTLDir()
	{
		return isRTLDir;
	}

	public void setIsRTLDir(int isRTLDir)
	{
		this.isRTLDir = isRTLDir;
	}

	public ArrayList<SmartCO> getSmartCOList()
	{
		return smartCOList;
	}

	public void setSmartCOList(ArrayList<SmartCO> smartCOList)
	{
		this.smartCOList = smartCOList;
	}

	public Date getRunningDateTime()
	{
		return runningDateTime;
	}

	public void setRunningDateTime(Date runningDateTime)
	{
		this.runningDateTime = runningDateTime;
	}

	public BigDecimal getCompCode()
	{
		return compCode;
	}

	public void setCompCode(BigDecimal compCode)
	{
		this.compCode = compCode;
	}

	public CIFCONTROLVO getOldCifControlVO()
	{
		return oldCifControlVO;
	}

	public void setOldCifControlVO(CIFCONTROLVO oldCifControlVO)
	{
		this.oldCifControlVO = oldCifControlVO;
	}

	public String getSaveUpdateFlag()
	{
		return saveUpdateFlag;
	}

	public void setSaveUpdateFlag(String saveUpdateFlag)
	{
		this.saveUpdateFlag = saveUpdateFlag;
	}

	public String getBLCKL_FST_NAME()
	{
		return BLCKL_FST_NAME;
	}

	public void setBLCKL_FST_NAME(String bLCKL_FST_NAME)
	{
		BLCKL_FST_NAME = bLCKL_FST_NAME;
	}

	public String getBLCKL_SEC_NAME()
	{
		return BLCKL_SEC_NAME;
	}

	public void setBLCKL_SEC_NAME(String bLCKL_SEC_NAME)
	{
		BLCKL_SEC_NAME = bLCKL_SEC_NAME;
	}

	public String getBLCKL_LAST_NAME()
	{
		return BLCKL_LAST_NAME;
	}

	public void setBLCKL_LAST_NAME(String bLCKL_LAST_NAME)
	{
		BLCKL_LAST_NAME = bLCKL_LAST_NAME;
	}

	public String getBLCKL_THRD_NAME()
	{
		return BLCKL_THRD_NAME;
	}

	public void setBLCKL_THRD_NAME(String bLCKL_THRD_NAME)
	{
		BLCKL_THRD_NAME = bLCKL_THRD_NAME;
	}

	public String getBLCKL_BPLACE()
	{
		return BLCKL_BPLACE;
	}

	public void setBLCKL_BPLACE(String bLCKL_BPLACE)
	{
		BLCKL_BPLACE = bLCKL_BPLACE;
	}

	public String getBLCKL_BDATE()
	{
		return BLCKL_BDATE;
	}

	public void setBLCKL_BDATE(String bLCKL_BDATE)
	{
		BLCKL_BDATE = bLCKL_BDATE;
	}

	public String getBLCKL_MOTHER_LNAME()
	{
		return BLCKL_MOTHER_LNAME;
	}

	public void setBLCKL_MOTHER_LNAME(String bLCKL_MOTHER_LNAME)
	{
		BLCKL_MOTHER_LNAME = bLCKL_MOTHER_LNAME;
	}

	public String getBLCKL_IDNO()
	{
		return BLCKL_IDNO;
	}

	public void setBLCKL_IDNO(String bLCKL_IDNO)
	{
		BLCKL_IDNO = bLCKL_IDNO;
	}

	public String getBLCKL_REGNO()
	{
		return BLCKL_REGNO;
	}

	public void setBLCKL_REGNO(String bLCKL_REGNO)
	{
		BLCKL_REGNO = bLCKL_REGNO;
	}

	public String getBLCKL_BNAME()
	{
		return BLCKL_BNAME;
	}

	public void setBLCKL_BNAME(String bLCKL_BNAME)
	{
		BLCKL_BNAME = bLCKL_BNAME;
	}

	public String getBLCKL_LNAME()
	{
		return BLCKL_LNAME;
	}

	public void setBLCKL_LNAME(String bLCKL_LNAME)
	{
		BLCKL_LNAME = bLCKL_LNAME;
	}

	public String getBLCKL_NATION()
	{
		return BLCKL_NATION;
	}

	public void setBLCKL_NATION(String bLCKL_NATION)
	{
		BLCKL_NATION = bLCKL_NATION;
	}

	public String getBLCKL_REGION()
	{
		return BLCKL_REGION;
	}

	public void setBLCKL_REGION(String bLCKL_REGION)
	{
		BLCKL_REGION = bLCKL_REGION;
	}

	public String getBLCKL_COUNTRY()
	{
		return BLCKL_COUNTRY;
	}

	public void setBLCKL_COUNTRY(String bLCKL_COUNTRY)
	{
		BLCKL_COUNTRY = bLCKL_COUNTRY;
	}

	public String getBLCKL_LEGAL()
	{
		return BLCKL_LEGAL;
	}

	public void setBLCKL_LEGAL(String bLCKL_LEGAL)
	{
		BLCKL_LEGAL = bLCKL_LEGAL;
	}

	public String getAPPLY_BLKLST_ON_WALKIN_CUST_YN()
	{
		return APPLY_BLKLST_ON_WALKIN_CUST_YN;
	}

	public void setAPPLY_BLKLST_ON_WALKIN_CUST_YN(String aPPLY_BLKLST_ON_WALKIN_CUST_YN)
	{
		APPLY_BLKLST_ON_WALKIN_CUST_YN = aPPLY_BLKLST_ON_WALKIN_CUST_YN;
	}

	public String getBLCKL_MOTHER_FNAME()
	{
		return BLCKL_MOTHER_FNAME;
	}

	public void setBLCKL_MOTHER_FNAME(String bLCKL_MOTHER_FNAME)
	{
		BLCKL_MOTHER_FNAME = bLCKL_MOTHER_FNAME;
	}

	public BigDecimal getDualParam()
	{
		return dualParam;
	}

	public void setDualParam(BigDecimal dualParam)
	{
		this.dualParam = dualParam;
	}

	public BigDecimal getMethod()
	{
		return method;
	}

	public void setMethod(BigDecimal method)
	{
		this.method = method;
	}

	public String getStatusDesc()
	{
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}

	public BigDecimal getCancelFlag()
	{
		return cancelFlag;
	}

	public void setCancelFlag(BigDecimal cancelFlag)
	{
		this.cancelFlag = cancelFlag;
	}

	
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getScreenParam()
	{
		return screenParam;
	}

	
	public void setScreenParam(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam)
	{
		this.screenParam = screenParam;
	}
	
	public String getBLCKL_TRX_NONFINANCE_YN()
	{
	    return BLCKL_TRX_NONFINANCE_YN;
	}

	public void setBLCKL_TRX_NONFINANCE_YN(String BLCKL_TRX_NONFINANCE_YN)
	{
	    this.BLCKL_TRX_NONFINANCE_YN = BLCKL_TRX_NONFINANCE_YN;
	}

}
