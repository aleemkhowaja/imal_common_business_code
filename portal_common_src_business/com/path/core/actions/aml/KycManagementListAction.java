package com.path.core.actions.aml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.path.bo.core.aml.KycManagementBO;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.dbmaps.vo.S_APPVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.aml.KycManagementCO;
import com.path.vo.core.aml.KycManagementSC;
import net.sf.json.JSONException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * KycManagementListAction.java used to
 */
public class KycManagementListAction extends GridBaseAction
{

	private KycManagementBO kycManagementBO;
	private KycManagementSC kycManagementSC = new KycManagementSC();
	private List<KycManagementCO> KycManagementList = new ArrayList<KycManagementCO>();

	public String loadData() throws JSONException
	{
		String[] searchCol = { "CODE", "CIF_NO", "STATUS_DESC" };

		HashMap dateSearchColsHashMap = new HashMap();
		dateSearchColsHashMap.put("DATE_OPENED", "");
		try
		{
			/**
			 * copy the details related to search cifGroupSC to the SC
			 */
			SessionCO sessionCO = returnSessionObject();
			kycManagementSC.setSearchCols(searchCol);
			kycManagementSC.setDateSearchCols(dateSearchColsHashMap);
			copyproperties(kycManagementSC);

			kycManagementSC.setCompCode(sessionCO.getCompanyCode());
			kycManagementSC.setBranchCode(sessionCO.getBranchCode());
			kycManagementSC.setLovTypeId(BlackListSourceConstant.LOV_TYPE);

			kycManagementSC.setLanguage(sessionCO.getLanguage());
			kycManagementSC.setProgRef(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()));

			kycManagementSC.setIvCrud(getIv_crud());
			S_APPVO sAppVO = new S_APPVO();
			sAppVO.setAPP_NAME(sessionCO.getCurrentAppName());
			sAppVO = returnCommonLibBO().returnApplication(sAppVO);

			kycManagementSC.setProgRef(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()));
			/**
			 * set number of rows to be displayed in the page of grid, and the total number of records for first time load only
			 */
			if (checkNbRec(kycManagementSC))
			{
				setRecords(kycManagementBO.kycManagementCount(kycManagementSC));
			}

			/**
			 * set the collection into gridModel attribute defined at JSP grid tag
			 */
			KycManagementList = kycManagementBO.kycManagementList(kycManagementSC);
			setGridModel(KycManagementList);

		}
		catch (Exception e)
		{
			log.error("Error Loading Grid of Stock Exchange");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public void setKycManagementBO(KycManagementBO kycManagementBO)
	{
		this.kycManagementBO = kycManagementBO;
	}
	
	public Object getModel()
	{
		return kycManagementSC;
	}

}
