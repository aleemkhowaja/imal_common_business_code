package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.CTS_REG_BILL_TYPEVO;
import com.path.dbmaps.vo.CTS_REG_BILL_TYPEVOKey;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FomBillTypeCO.java used to
 */
public class FomBillTypeCO extends RetailBaseVO
{
    private CTS_REG_BILL_TYPEVO ctsRegBillType = new CTS_REG_BILL_TYPEVO();

    private String BILL_DESC;
    private String saveType;
    private String accDesc;
    private String addRef;

    public String getAddRef()
    {
        return addRef;
    }

    public void setAddRef(String addRef)
    {
        this.addRef = addRef;
    }

    public String getAccDesc()
    {
        return accDesc;
    }

    public void setAccDesc(String accDesc)
    {
        this.accDesc = accDesc;
    }

    public String getBILL_DESC()
    {
	return BILL_DESC;
    }

    public void setBILL_DESC(String bILLDESC)
    {
	BILL_DESC = bILLDESC;
    }

    public CTS_REG_BILL_TYPEVO getCtsRegBillType()
    {
	return ctsRegBillType;
    }

    public void setCtsRegBillType(CTS_REG_BILL_TYPEVO ctsRegBillType)
    {
	this.ctsRegBillType = ctsRegBillType;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

}
