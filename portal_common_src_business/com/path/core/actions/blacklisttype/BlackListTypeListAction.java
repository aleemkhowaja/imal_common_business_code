package com.path.core.actions.blacklisttype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.blacklisttype.BlackListTypeBO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.blacklistsource.BlackListSourceCO;
import com.path.vo.core.blacklisttype.BlackListTypeCO;
import com.path.vo.core.blacklisttype.BlackListTypeSC;
import net.sf.json.JSONException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * BlackListTypeListAction.java used to
 */
public class BlackListTypeListAction extends GridBaseAction
{

	private BlackListTypeBO blackListTypeBO;
	private BlackListTypeSC blackListTypeSC = new BlackListTypeSC();
	private List<BlackListTypeCO> blackListTypeList = new ArrayList<BlackListTypeCO>();

	public String loadData() throws JSONException
	{
		String[] searchCol = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB", "STATUS_DESC" };

		HashMap dateSearchColsHashMap = new HashMap();
		dateSearchColsHashMap.put("DATE_OPENED", "");
		try
		{
			/**
			 * copy the details related to search cifGroupSC to the SC
			 */
			SessionCO sessionCO = returnSessionObject();
			blackListTypeSC.setSearchCols(searchCol);
			blackListTypeSC.setDateSearchCols(dateSearchColsHashMap);
			copyproperties(blackListTypeSC);

			blackListTypeSC.setCompCode(sessionCO.getCompanyCode());

			blackListTypeSC.setLovTypeId(BlackListSourceConstant.LOV_TYPE);

			blackListTypeSC.setLanguage(sessionCO.getLanguage());
			blackListTypeSC.setProgRef(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()));

			blackListTypeSC.setIvCrud(getIv_crud());
			S_APPVO sAppVO = new S_APPVO();
			sAppVO.setAPP_NAME(sessionCO.getCurrentAppName());
			sAppVO = returnCommonLibBO().returnApplication(sAppVO);

			blackListTypeSC.setDualParam(sAppVO.getDUAL_PARAM());

			blackListTypeSC.setProgRef(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()));
			/**
			 * set number of rows to be displayed in the page of grid, and the total number of records for first time load only
			 */
			if (checkNbRec(blackListTypeSC))
			{
				setRecords(blackListTypeBO.blackListTypeByCount(blackListTypeSC));
			}

			/**
			 * set the collection into gridModel attribute defined at JSP grid tag
			 */
			blackListTypeList = blackListTypeBO.blackListTypeByList(blackListTypeSC);
			setGridModel(blackListTypeList);

		}
		catch (Exception e)
		{
			log.error("Error Loading Grid of Stock Exchange");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public void setBlackListTypeBO(BlackListTypeBO blackListTypeBO)
	{
		this.blackListTypeBO = blackListTypeBO;
	}

	public BlackListTypeSC getBlackListTypeSC()
	{
		return blackListTypeSC;
	}

	public void setBlackListTypeSC(BlackListTypeSC blackListTypeSC)
	{
		this.blackListTypeSC = blackListTypeSC;
	}

	public List<BlackListTypeCO> getBlackListTypeList()
	{
		return blackListTypeList;
	}

	public void setBlackListTypeList(List<BlackListTypeCO> blackListTypeList)
	{
		this.blackListTypeList = blackListTypeList;
	}
	public Object getModel()
	{
		return blackListTypeSC;
	}


}
