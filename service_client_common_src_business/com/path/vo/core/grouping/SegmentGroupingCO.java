package com.path.vo.core.grouping;

import java.util.Date;
import java.util.HashMap;
import com.path.dbmaps.vo.CTS_SEGMENT_GROUPINGVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * SegmentGroupingCO.java used to
 */
public class SegmentGroupingCO extends RetailBaseVO
{

	private CTS_SEGMENT_GROUPINGVO ctsSegmentGroupingVO = new CTS_SEGMENT_GROUPINGVO();
	private String statusDesc;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

	public CTS_SEGMENT_GROUPINGVO getCtsSegmentGroupingVO()
	{
		return ctsSegmentGroupingVO;
	}

	public void setCtsSegmentGroupingVO(CTS_SEGMENT_GROUPINGVO ctsSegmentGroupingVO)
	{
		this.ctsSegmentGroupingVO = ctsSegmentGroupingVO;
	}

	public String getStatusDesc()
	{
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
	{
		return buisnessElement;
	}

	public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
	{
		this.buisnessElement = buisnessElement;
	}
}
