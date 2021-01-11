package com.path.vo.core.blacklistmanagement;

import com.path.dbmaps.vo.MOSBLACKLIST_IDVOKey;
import com.path.lib.vo.BaseVO;

 public class BlackListIdsCO extends  BaseVO
 {
	private MOSBLACKLIST_IDVOKey blackListIdVO = new MOSBLACKLIST_IDVOKey();
	private String idTypeDesc;
	
	
	public String getIdTypeDesc()
	{
		return idTypeDesc;
	}

	public void setIdTypeDesc(String idTypeDesc)
	{
		this.idTypeDesc = idTypeDesc;
	}

	public MOSBLACKLIST_IDVOKey getBlackListIdVO()
	{
		return blackListIdVO;
	}

	public void setBlackListIdVO(MOSBLACKLIST_IDVOKey blackListIdVO)
	{
		this.blackListIdVO = blackListIdVO;
	}
 }