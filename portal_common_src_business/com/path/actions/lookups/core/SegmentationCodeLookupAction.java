package com.path.actions.lookups.core;

import com.path.bo.core.segmentation.CustSegmentationBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.segmentation.CustSegmentationSC;

public class SegmentationCodeLookupAction extends LookupBaseAction
{
	private CustSegmentationSC criteria = new CustSegmentationSC();
	private CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
	private CustSegmentationBO custSegmentationBO;
	
	public String constructSegmentationCodeLookup()
	{
		try
		{
			String[] name = { "SEGMENT_CODE", "SEGMENT_DESC"};
			String[] colType = { "number", "text"};
			String[] titles = { getText("segment_code_key"), getText("segment_desc_key")};

			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("segment_key"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/SegmentationCodeLookupAction_fillSegmentationLookup");

			lookup(grid, criteria, name, colType, titles);
		}
		catch (Exception e)
		{
			log.error(e, "Error in constructProviderLookup of SegmentationCodeLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String fillSegmentationLookup()
	{
		try
		{
			copyproperties(criteria);
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());

			if (checkNbRec(criteria))
			{
				setRecords(custSegmentationBO.returnSegmentationLookupCount(criteria));
			}
			setGridModel(custSegmentationBO.returnSegmentationLookup(criteria));
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

	public void setCustSegmentationBO(CustSegmentationBO custSegmentationBO)
	{
		this.custSegmentationBO = custSegmentationBO;
	}
}
