package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.CTSCHARGES_EXEMPTED_BRANCHVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 */
public class CTSChargesExemptedBranchCO extends BaseVO
{
    private CTSCHARGES_EXEMPTED_BRANCHVO ctsChargesExemptedBranchVO = new CTSCHARGES_EXEMPTED_BRANCHVO();
    private String BRANCH_DESC;

    public CTSCHARGES_EXEMPTED_BRANCHVO getCtsChargesExemptedBranchVO()
    {
	return ctsChargesExemptedBranchVO;
    }

    public void setCtsChargesExemptedBranchVO(CTSCHARGES_EXEMPTED_BRANCHVO ctsChargesExemptedBranchVO)
    {
	this.ctsChargesExemptedBranchVO = ctsChargesExemptedBranchVO;
    }

    public String getBRANCH_DESC()
    {
	return BRANCH_DESC;
    }

    public void setBRANCH_DESC(String bRANCHDESC)
    {
	BRANCH_DESC = bRANCHDESC;
    }
}
