package com.path.actions.lookups.core;

import com.path.bo.core.grouping.SegmentGroupingBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.grouping.SegmentGroupingSC;

public class SegmentGroupingCodeLookupAction extends LookupBaseAction
{
	private GridParamsSC criteria = new GridParamsSC();
	private SegmentGroupingSC segmentGroupingSC = new SegmentGroupingSC();
	private SegmentGroupingBO segmentGroupingBO;
	
	public String constructSegmentGroupingCodeLookup()
	{
		try
		{
			String[] name = { "GROUP_CODE", "DESCRIPTION", "PRIORITY"};
			String[] colType = { "number", "text", "number"};
			String[] titles = { getText("group_code_key"), getText("description_key"), getText("priority_key")};

			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("segment_key"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/SegmentGroupingCodeLookupAction_fillSegmentGroupingLookup");

			lookup(grid, criteria, name, colType, titles);
		}
		catch (Exception e)
		{
			log.error(e, "Error in constructProviderLookup of SegmentGroupingCodeLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String fillSegmentGroupingLookup()
	{
		try
		{
			copyproperties(criteria);
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());

			if (checkNbRec(criteria))
			{
				setRecords(segmentGroupingBO.returnSegmentGroupingLookupCount(criteria));
			}
			setGridModel(segmentGroupingBO.returnSegmentGroupingLookup(criteria));
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public Object getModel()
	{
		return criteria;
	}
	public void setSegmentGroupingBO(SegmentGroupingBO segmentGroupingBO)
	{
		this.segmentGroupingBO = segmentGroupingBO;
	}
}
