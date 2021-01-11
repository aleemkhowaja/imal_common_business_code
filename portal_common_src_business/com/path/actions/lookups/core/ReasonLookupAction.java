/**
 * 
 */
package com.path.actions.lookups.core;

import java.util.List;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.reason.ReasonBO;
import com.path.dbmaps.vo.AML_REASONVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.reason.ReasonSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * @author: nabilfeghali
 * 
 *          ReasonLookupAction.java used to
 */
public class ReasonLookupAction extends LookupBaseAction
{

	private ReasonBO reasonBO;
	private ReasonSC criteria = new ReasonSC();
	private List<CTSREASONSVO> reasonVOList;
//	private List<AML_REASONVO> amlReasonVOList; // added by nour for #864398

	private String reasonCode;

	public Object getModel()
	{
		return criteria;
	}

	/**
	 * Build a Grid inside the LiveSearch ...
	 */
	public String drawingReasonGrid()
	{
		SessionCO sessionCO = returnSessionObject();//added by nour 
		try
		{
//			if (!FomConstant.AML.equals(sessionCO.getCurrentAppName())) // added by nour for #864398
//			{
				String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB" };
				String[] colType = { "number", "text", "text" };

				// Boolean[] hidden = { true, false, false };
				String[] titles = { getText("Code__key"), getText("Lkp_Reason_En_key"), getText("Lkp_Reason_Ar_key") };
				// String[] width = { "0", "250", "250" };

				/*
				 * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory, 1=Arabic Hidden and English Mandatory, 2= Arabic Visible
				 * and Mandatory And English Mandatory , 3= Arabic Visible and Mandatory English Not Mandatory).
				 */
				if (returnSessionObject().getHideArabicColumns())
				{
					name = new String[] { "CODE", "BRIEF_NAME_ENG" };
					colType = new String[] { "text", "text" };
					titles = new String[] { getText("Code__key"), getText("Lkp_Reason_En_key") };
				}
				/**
				 * Defining The Grid ...
				 */
				LookupGrid grid = new LookupGrid();
				grid.setCaption(getText("Lkp_Reason_Caption_key"));
				grid.setRowNum("5");
				grid.setUrl("/pathdesktop/ReasonLookup_loadReasonLookup");
				
				if (FomConstant.AML.equals(sessionCO.getCurrentAppName())) // added by nour for #864398
				{
					setReasonCode("true");
				}

				List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
				
					lsGridColumn.get(0).setHidden(true);
					if ("true".equalsIgnoreCase(getReasonCode()))
					{
						lsGridColumn.get(0).setHidden(false);
						lsGridColumn.get(0).setWidth("100");
					}
				
				lookup(grid, lsGridColumn, null, criteria);
			// if need to show code in lookup
			/*
			 * if("true".equalsIgnoreCase(getReasonCode())) { hidden[0] = false; titles[0] = getText("Code__key"); width[0] = "100"; }
			 */
			

			

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	/**
	 * This method is to get data from BO and load them in a grid inside the liveSearch component.
	 * 
	 * @return
	 */
	public String loadReasonLookup()
	{
		try
		{
			setSearchFilter(criteria);
			copyproperties(criteria);

			SessionCO sessionCO = returnSessionObject();
			String originOptRef = "";
			if (StringUtil.isNotEmpty(get_pageRef()))
			{
				originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
			}
			if (FomConstant.MAINTENANCE_OPT.equals(originOptRef) && null == criteria.getScreenSrc() && !"1".equals(criteria.getFromExemptedFilerLookup()))
			{
				criteria.setReason_type(FomConstant.CIF_FATCA_REASON_TYPE_DEFAULT);
				if (FomConstant.CIF_FATCA_STATUS_US_ACC_Holder.equals(criteria.getStatus()))
				{
					criteria.setReason_type(FomConstant.CIF_FATCA_REASON_TYPE_US_ACC_Holder);
				}
			}
			criteria.setCompCode(sessionCO.getCompanyCode());

			if (FomConstant.AML.equals(sessionCO.getCurrentAppName())) // added by nour for #864398
			{
				 criteria.setReason_type(FomConstant.REASON_BR);

			}
				setRecords(reasonBO.reasonLookupCount(criteria));
				reasonVOList = reasonBO.reasonLookupList(criteria);
				setGridModel(reasonVOList);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	/**
	 * @PB : w_lookup_bill_purpose
	 * @param reasonsBO
	 */
	public String drawingBillPurposeGrid()
	{

	    String[] columnArr[] = { { "CODE", "number", getText("Code_key") },
			{ "BRIEF_NAME_ENG", "text", getText("Brief_Name_key") },
			{ "LONG_NAME_ENG", "text", getText("Long_Name_eng_key") },
			{ "BRIEF_NAME_ARAB", "text", getText("Brief_Name_Arab_key") },
			{ "LONG_NAME", "text", getText("Long_Name_Arab_key") } };

		try
		{
		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Code__key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/ReasonLookup_loadBillPurposeLookup");
		    lookup(grid, criteria, columnArr);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return SUCCESS;
	}

	/**
	 * This method is to get data from BO and load them in a grid inside the liveSearch component.
	 * 
	 */
	public String loadBillPurposeLookup()
	{
		SessionCO sessionCO;
		try
		{
			setSearchFilter(criteria);
			copyproperties(criteria);
			sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
			criteria.setReason_type("4");
			setRecords(reasonBO.loadBillPurposeCount(criteria));
			reasonVOList = reasonBO.loadBillPurposeList(criteria);
			setGridModel(reasonVOList);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}

		return SUCCESS;
	}

	public void setReasonBO(ReasonBO reasonsBO)
	{
		this.reasonBO = reasonsBO;
	}

	public ReasonSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(ReasonSC criteria)
	{
		this.criteria = criteria;
	}

	public List<CTSREASONSVO> getReasonVOList()
	{
		return reasonVOList;
	}

	public void setReasonVOList(List<CTSREASONSVO> reasonVOList)
	{
		this.reasonVOList = reasonVOList;
	}

	public String getReasonCode()
	{
		return reasonCode;
	}

	public void setReasonCode(String reasonCode)
	{
		this.reasonCode = reasonCode;
	}

//	public List<AML_REASONVO> getAmlReasonVOList()
//	{
//		return amlReasonVOList;
//	}
//
//	public void setAmlReasonVOList(List<AML_REASONVO> amlReasonVOList)
//	{
//		this.amlReasonVOList = amlReasonVOList;
//	}

}
