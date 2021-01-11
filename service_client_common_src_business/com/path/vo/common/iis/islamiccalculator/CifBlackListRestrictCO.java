package com.path.vo.common.iis.islamiccalculator;

import java.util.Date;

import com.path.dbmaps.vo.BLACKLIST_OVERRIDE_REASONVO;
import com.path.lib.vo.BaseVO;

public class CifBlackListRestrictCO extends BaseVO {

	String blacklist_reason_desc;
	String userId;
	Date runningDate;
	
	BLACKLIST_OVERRIDE_REASONVO blackListOverrideReasonVO;
	String  newRecordYN = "Y";
	String modifiedYN = "N";
	
	public String getBlacklist_reason_desc() {
		return blacklist_reason_desc;
	}
	public void setBlacklist_reason_desc(String blacklist_reason_desc) {
		this.blacklist_reason_desc = blacklist_reason_desc;
	}
	public BLACKLIST_OVERRIDE_REASONVO getBlackListOverrideReasonVO() {
		return blackListOverrideReasonVO;
	}
	public void setBlackListOverrideReasonVO(BLACKLIST_OVERRIDE_REASONVO blackListOverrideReasonVO) {
		this.blackListOverrideReasonVO = blackListOverrideReasonVO;
	}
	public String getNewRecordYN() {
		return newRecordYN;
	}
	public void setNewRecordYN(String newRecordYN) {
		this.newRecordYN = newRecordYN;
	}
	public String getModifiedYN() {
		return modifiedYN;
	}
	public void setModifiedYN(String modifiedYN) {
		this.modifiedYN = modifiedYN;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRunningDate() {
		return runningDate;
	}
	public void setRunningDate(Date runningDate) {
		this.runningDate = runningDate;
	} 
	
}
