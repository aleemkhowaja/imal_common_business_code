package com.path.core.actions.grouping;

import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.path.bo.core.grouping.SegmentGroupingConstant;
import com.path.dbmaps.vo.CTS_SEGMENT_GROUPINGVO;
import com.path.dbmaps.vo.S_LINK_CIF_AMFVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.grouping.SegmentGroupingSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * SegmentGroupingStatusAction.java used to generate Status common Popup for SegmentGrouping
 */
public class SegmentGroupingStatusAction extends GridBaseAction
{

	private SegmentGroupingSC criteria = new SegmentGroupingSC();
	private String url;

	public String search()
	{
		try
		{
			ServletContext application = ServletActionContext.getServletContext();
			String theRealPath = application.getContextPath();
			url = theRealPath + "/path/grouping/SegmentGroupingStatusAction_loadStatusGrid.action?groupCode=" + criteria.getGroupCode();
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
			return ERROR_ACTION;
		}
		return "SUCCESS_STATUS";
	}

	public String loadStatusGrid()
	{
		String[] searchCol = { "userName", "status_desc", "status_date" };
		CTS_SEGMENT_GROUPINGVO ctsSegmentGroupingVO = new CTS_SEGMENT_GROUPINGVO();
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			copyproperties(criteria);

			List<String> colList = SegmentGroupingConstant.segmentGroupingStatusLst;
			SelectSC lovCriteria = new SelectSC();
			lovCriteria.setLanguage(sessionCO.getLanguage());
			lovCriteria.setLovTypeId(SegmentGroupingConstant.LOV_TYPE);

			ctsSegmentGroupingVO.setCOMP_CODE(sessionCO.getCompanyCode());
			ctsSegmentGroupingVO.setGROUP_CODE(criteria.getGroupCode());
			
			List<StatusCO> resultList = returnCommonLibBO().generateStatusList(ctsSegmentGroupingVO, colList, lovCriteria);
			setGridModel(resultList);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public Object getModel()
	{
		return criteria;
	}

	public SegmentGroupingSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(SegmentGroupingSC criteria)
	{
		this.criteria = criteria;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
