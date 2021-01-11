package com.path.core.actions.blacklistsource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.path.bo.core.blacklistsource.BlackListSourceBO;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.dbmaps.vo.S_APPVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.blacklistsource.BlackListSourceCO;
import com.path.vo.core.blacklistsource.BlackListSourceSC;
import net.sf.json.JSONException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * BlackListSourceListAction.java used to
 */
public class BlackListSourceListAction extends GridBaseAction
{

	private BlackListSourceBO blackListSourceBO;
	private BlackListSourceSC blackListSourceSC = new BlackListSourceSC();
	private List<BlackListSourceCO> blackListSourceList = new ArrayList<BlackListSourceCO>();

	public String loadData() throws JSONException
	{
		String[] searchCol = { "CODE", "CIF_NO", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB", "STATUS_DESC" };

		HashMap dateSearchColsHashMap = new HashMap();
		dateSearchColsHashMap.put("DATE_OPENED", "");
		try
		{
			/**
			 * copy the details related to search cifGroupSC to the SC
			 */
			SessionCO sessionCO = returnSessionObject();
			blackListSourceSC.setSearchCols(searchCol);
			blackListSourceSC.setDateSearchCols(dateSearchColsHashMap);
			copyproperties(blackListSourceSC);

			blackListSourceSC.setCompCode(sessionCO.getCompanyCode());

			blackListSourceSC.setLovTypeId(BlackListSourceConstant.LOV_TYPE);

			blackListSourceSC.setLanguage(sessionCO.getLanguage());
			blackListSourceSC.setProgRef(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()));

			blackListSourceSC.setIvCrud(getIv_crud());
			S_APPVO sAppVO = new S_APPVO();
			sAppVO.setAPP_NAME(sessionCO.getCurrentAppName());
			sAppVO = returnCommonLibBO().returnApplication(sAppVO);

			blackListSourceSC.setDualParam(sAppVO.getDUAL_PARAM());

			blackListSourceSC.setProgRef(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()));
			/**
			 * set number of rows to be displayed in the page of grid, and the total number of records for first time load only
			 */
			if (checkNbRec(blackListSourceSC))
			{
				setRecords(blackListSourceBO.blackListSourceCount(blackListSourceSC));
			}

			/**
			 * set the collection into gridModel attribute defined at JSP grid tag
			 */
			blackListSourceList = blackListSourceBO.blackListSourceList(blackListSourceSC);
			setGridModel(blackListSourceList);

		}
		catch (Exception e)
		{
			log.error("Error Loading Grid of Stock Exchange");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public BlackListSourceBO getBlackListSourceBO()
	{
		return blackListSourceBO;
	}

	public void setBlackListSourceBO(BlackListSourceBO blackListSourceBO)
	{
		this.blackListSourceBO = blackListSourceBO;
	}
	public Object getModel()
	{
		return blackListSourceSC;
	}

}
