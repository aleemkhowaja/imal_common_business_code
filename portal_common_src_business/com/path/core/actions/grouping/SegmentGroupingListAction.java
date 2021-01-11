package com.path.core.actions.grouping;

import com.path.bo.core.grouping.SegmentGroupingBO;
import com.path.bo.core.grouping.SegmentGroupingConstant;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.grouping.SegmentGroupingSC;

public class SegmentGroupingListAction extends GridBaseAction
{
	private SegmentGroupingBO segmentGroupingBO;
	private SegmentGroupingSC criteria = new SegmentGroupingSC();

	public String loadSegmentGroupingGrid()
	{
		try
		{
			String[] searchCol = {"GROUP_CODE", "DESCRIPTION", "PRIORITY", "STATUS"};
			SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setLovTypeId(SegmentGroupingConstant.LOV_TYPE);
			criteria.setLanguage(sessionCO.getLanguage());
			
			if("SG00GMT".equals(get_pageRef()))
			{
				criteria.setIvCrud("R");
			}
			else if("SG00GP".equals(get_pageRef()))
			{
				criteria.setIvCrud("P");
			}
			else if("SG00GUP".equals(get_pageRef()))
			{
				criteria.setIvCrud("UP");
			}
			
			copyproperties(criteria);
			if(checkNbRec(criteria))
			{
				setRecords(segmentGroupingBO.returnSegmentGroupingListCount(criteria));
			}
			setGridModel(segmentGroupingBO.returnSegmentGroupingList(criteria));
		}
		catch(Exception e)
		{
			log.error(e, "Error in loadSegmentGroupingGrid of SegmentGroupingListAction");
			handleException(e, null, null);
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
	public void setSegmentGroupingBO(SegmentGroupingBO segmentGroupingBO)
	{
		this.segmentGroupingBO = segmentGroupingBO;
	}
}
