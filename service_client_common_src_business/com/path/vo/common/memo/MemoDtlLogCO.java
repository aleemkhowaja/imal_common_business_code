package com.path.vo.common.memo;

import com.path.dbmaps.vo.CTSMEMO_LOGVO;
 
public class MemoDtlLogCO extends MemoDtlCO {
	
	private CTSMEMO_LOGVO ctsMemoLogVO;
	private String accNo;

 

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public CTSMEMO_LOGVO getCtsMemoLogVO() {
		return ctsMemoLogVO;
	}

	public void setCtsMemoLogVO(CTSMEMO_LOGVO ctsMemoLogVO) {
		this.ctsMemoLogVO = ctsMemoLogVO;
	}
	
	
}
