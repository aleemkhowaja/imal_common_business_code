package com.path.vo.core.cheque;

import java.io.Serializable;

import com.path.dbmaps.vo.CTSCHEQUEBOOK_DESIGNVO;
import com.path.dbmaps.vo.CTSCHEQUESVO;
import com.path.vo.core.common.RetailBaseVO;

public class ChequeCO extends RetailBaseVO implements Serializable
{
    private CTSCHEQUESVO ctsCheques = new CTSCHEQUESVO();
    private CTSCHEQUEBOOK_DESIGNVO ctsDesign = new CTSCHEQUEBOOK_DESIGNVO();
    private String leaves;
    private String types;

    public CTSCHEQUESVO getCtsCheques()
    {
	return ctsCheques;
    }

    public void setCtsCheques(CTSCHEQUESVO ctsCheques)
    {
	this.ctsCheques = ctsCheques;
    }

    public CTSCHEQUEBOOK_DESIGNVO getCtsDesign()
    {
	return ctsDesign;
    }

    public void setCtsDesign(CTSCHEQUEBOOK_DESIGNVO ctsDesign)
    {
	this.ctsDesign = ctsDesign;
    }

    public String getLeaves()
    {
	return leaves;
    }

    public void setLeaves(String leaves)
    {
	this.leaves = leaves;
    }

    public String getTypes()
    {
	return types;
    }

    public void setTypes(String types)
    {
	this.types = types;
    }

}
