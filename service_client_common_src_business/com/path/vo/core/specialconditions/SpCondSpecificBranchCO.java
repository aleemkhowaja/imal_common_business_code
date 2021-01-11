package com.path.vo.core.specialconditions;

import com.path.dbmaps.vo.CTSSPCOND_RESTRICTED_BRANCHVO;
import com.path.vo.core.common.RetailBaseVO;

@SuppressWarnings("serial")
public final class SpCondSpecificBranchCO extends RetailBaseVO
{

    private CTSSPCOND_RESTRICTED_BRANCHVO spResctrictedBranchVO = new CTSSPCOND_RESTRICTED_BRANCHVO();
    private String spBranchDesc;
	
    public CTSSPCOND_RESTRICTED_BRANCHVO getSpResctrictedBranchVO() {
		return spResctrictedBranchVO;
	} 
	public void setSpResctrictedBranchVO(
			CTSSPCOND_RESTRICTED_BRANCHVO spResctrictedBranchVO) {
		this.spResctrictedBranchVO = spResctrictedBranchVO;
	}
	public String getSpBranchDesc() {
		return spBranchDesc;
	}
	public void setSpBranchDesc(String spBranchDesc) {
		this.spBranchDesc = spBranchDesc;
	}



   

   }
