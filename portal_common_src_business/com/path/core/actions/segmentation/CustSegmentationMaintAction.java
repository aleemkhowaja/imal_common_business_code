package com.path.core.actions.segmentation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.segmentation.CustSegmentationBO;
import com.path.bo.core.segmentation.CustSegmentationConstant;
import com.path.dbmaps.vo.CTS_CIF_SEG_FINAL_TMPVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.core.segmentation.CustSegmentationCO;
import com.path.vo.core.segmentation.CustSegmentationParamCO;
import com.path.vo.core.segmentation.CustSegmentationSC;
import com.path.vo.core.segmentation.ExcludeCIFSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * CustSegmentationMaintAction.java used to
 */
public class CustSegmentationMaintAction extends RetailBaseAction
{

	protected final static String LOADJSON = "loadJson";
	private List<SelectCO> logicalOperatorDropDown = new ArrayList<SelectCO>();
	private List<SelectCO> rightOperatorDropDown = new ArrayList<SelectCO>();
	private List<SelectCO> leftOperatorDropDown = new ArrayList<SelectCO>();
	private boolean _newRecord = true;
	protected String custSegmentationDetailList_Id_gridUpdate, custSegmentationDetailList_Id_gridAllRecords;
	protected String excludeCifGridUpdates;
	protected CustSegmentationCO custSegmentationCO = new CustSegmentationCO();
	protected CustSegmentationBO custSegmentationBO;

	private BigDecimal segmentCode;
	protected CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
	private HashMap<String, String> typeRadioMap = new HashMap<String, String>();
	private String typeRadioMapDefaultValue;
	private AlertsBO alertsBO; // Rania - Customers Segmentation

	private void fillSessionVariables() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		custSegmentationCO.setCrud(getIv_crud());
		custSegmentationCO.setLanguage(sessionCO.getLanguage());
		custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
		custSegmentationCO.setLoginBraCode(sessionCO.getBranchCode());
		custSegmentationCO.setRunningDate(sessionCO.getRunningDateRET());
		custSegmentationCO.setLoginUserId(sessionCO.getUserName());
		custSegmentationCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
		custSegmentationCO.setOpt(get_pageRef());
		custSegmentationCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
		custSegmentationCO.setAppName(sessionCO.getCurrentAppName());

		custSegmentationCO.setCompanyName(sessionCO.getCompanyName());
		custSegmentationCO.setCompanyArabName(sessionCO.getCompanyArabName());
		custSegmentationCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
		custSegmentationCO.setBaseCurrencyName(sessionCO.getBaseCurrencyName());
		custSegmentationCO.setBaseCurrDecPoint(sessionCO.getBaseCurrDecPoint());
		custSegmentationCO.setExposCurCode(sessionCO.getExposCurCode());
		custSegmentationCO.setExposCurName(sessionCO.getExposCurName());
		custSegmentationCO.setClientType(sessionCO.getClientType());
		custSegmentationCO.setFiscalYear(sessionCO.getFiscalYear());
		custSegmentationCO.setIsRTLDir(sessionCO.getIsRTLDir());
		custSegmentationCO.setBranchName(sessionCO.getBranchName());
	}

	/**
	 * load from left menu
	 * 
	 * @author joycekanazeh
	 * @return
	 */

	public String loadCustSegmentationPage()
	{
		try
		{
			initializeMethod();
			set_searchGridId("custSegmentationListGridTbl_Id");
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "custSegmentationList";
	}

	public String initialize()
	{
		try
		{
			initializeMethod();
		}
		catch (BaseException e)
		{
			handleException(e, null, null);
		}
		return "custSegmentationMaint";
	}

	/**
	 * Abdo Define Priorities 09/08/2017
	 * 
	 * @return
	 */
	public String initializeDefPriorities()
	{
		return "loadSegDefPriorities";
	}

	public String loadCustSegmentationGrid()
	{
		try
		{
			fillSessionVariables();
			set_searchGridId("segDefPrioritiesGridTbl_Id");
			CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
			custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
			custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
			custSegmentationSC.setCrudMode(getIv_crud());
			custSegmentationSC.setLovTypeId(CustSegmentationConstant.LOV_TYPE);
			custSegmentationSC.setLanguage(custSegmentationCO.getLanguage());
			custSegmentationCO.setCrud(getIv_crud());
			custSegmentationSC.setSectionKey("CSG00SEGDP");
			custSegmentationSC.setIsSegmentationScore("S"); // Rania - Customers Segmentation
			custSegmentationSC.setCurrAppName(custSegmentationCO.getAppName());
			custSegmentationSC.setNbRec(-1);
			List Lst = custSegmentationBO.returnCustSegmentationList(custSegmentationSC);
			setGridModel(Lst);

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "success";// "loadSegDefPriorities";
	}

	/**
	 * 
	 * load detail page (double click)
	 */

	public String retrieveCustSegment()
	{
		try
		{
			fillSessionVariables();
			showCrudButtonsByAccess();

			CustSegmentationSC custSegmentationSC = new CustSegmentationSC();

			custSegmentationCO = custSegmentationBO.initialiseData(custSegmentationCO, _newRecord);
			setAdditionalScreenParams(custSegmentationCO.getBuisnessElement());

			if (custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE() != null)
			{
				custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
				custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
				custSegmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
				custSegmentationSC.setCrudMode(getIv_crud());
				custSegmentationSC.setLovTypeId(CustSegmentationConstant.LOV_TYPE); // take
				// it
				// from
				// session
				custSegmentationSC.setLanguage(custSegmentationCO.getLanguage()); // take
				// it
				// from
				// session
				custSegmentationCO.setCrud(getIv_crud());

				custSegmentationSC.setIsSegmentationScore(returnSegmentType());

				custSegmentationCO = custSegmentationBO.returnCustSegmentationForm(custSegmentationSC);

				// retriving detail gridView ()
				setGridModel(custSegmentationBO.returnListOfCustomerSegmentation(custSegmentationSC));

				List<CustSegmentationCO> gridModel = new ArrayList<CustSegmentationCO>();

				gridModel = getGridModel();
				// display expression
				displayExpressions(gridModel);
			}

			if ("R".equals(getIv_crud())
					&& ("".equals(custSegmentationCO.getCtsSegmentVO().getSTATUS()) || "A".equals(custSegmentationCO.getCtsSegmentVO().getSTATUS()))) // Rania - 718813 - Dynamic Customer Scoring on latest
			{
				set_showNewInfoBtn(ConstantsCommon.TRUE);
				set_showSmartInfoBtn(ConstantsCommon.FALSE);
			}
			// Rania - 718813 - Dynamic Customer Scoring on latest
			else if ("R".equals(getIv_crud())
					&& !("".equals(custSegmentationCO.getCtsSegmentVO().getSTATUS()) || "A".equals(custSegmentationCO.getCtsSegmentVO().getSTATUS())))
			{
				set_showNewInfoBtn(ConstantsCommon.TRUE);
				set_showSmartInfoBtn(ConstantsCommon.FALSE);
				set_recReadOnly(ConstantsCommon.TRUE);
			}
			// End Rania
			else if ("P".equals(getIv_crud()))
			{
				set_showNewInfoBtn(ConstantsCommon.FALSE);
				set_showSmartInfoBtn(ConstantsCommon.FALSE);
				set_recReadOnly(ConstantsCommon.TRUE);
			}
			else if (CustSegmentationConstant.UPDATE_AFTER_APPROVE_IVCRUD.equals(getIv_crud()))
			{
				set_showNewInfoBtn(ConstantsCommon.TRUE);
				set_showSmartInfoBtn(ConstantsCommon.FALSE);
				set_recReadOnly(ConstantsCommon.FALSE);
			}
			// Rania - 718813 - Dynamic Customer Scoring on latest
			else if (CustSegmentationConstant.SUSPEND.equals(getIv_crud()) || CustSegmentationConstant.APPROVE_SUSPEND.equals(getIv_crud())
					|| CustSegmentationConstant.REACTIVATE.equals(getIv_crud()) || CustSegmentationConstant.APPROVE_REACTIVATE.equals(getIv_crud())
					|| CustSegmentationConstant.CANCEL.equals(getIv_crud()) || CustSegmentationConstant.APPROVE_CANCEL.equals(getIv_crud()))
			{
				set_showNewInfoBtn(ConstantsCommon.FALSE);
				set_showSmartInfoBtn(ConstantsCommon.FALSE);
				set_recReadOnly(ConstantsCommon.TRUE);
			}
			// End Rania

			applyRetrieveAudit(AuditConstant.CUST_SEGMENTATION_SCREEN_KEY_REF, custSegmentationCO.getCtsSegmentVO(), custSegmentationCO);

			custSegmentationCO.setIsSegmentationScore(returnSegmentType()); // Rania - 718813 - Dynamic Customer Scoring on latest
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return "custSegmentationMaint";
	}

	public String loadSegParams()
	{
		// List<CustSegmentationCO> segmentationParamList =
		// custSegmentationCO.getGridAddList();
		// for(int i = 0; i < segmentationParamList.size(); i++)
		// {
		// List<CustSegmentationParamCO> queryParamCOList =
		// segmentationParamList.get(i).getQueryParamCOList();
		// for(int j = 0; j < queryParamCOList.size(); j++)
		// {
		//
		// }
		// }

		// try
		// {
		// custSegmentationCO =
		// custSegmentationBO.returnCriteriaDetails(criteriaSC);
		// }
		// catch(BaseException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		custSegmentationSC.setProcParamGridPK("procParamGridTbl_Id_" + custSegmentationSC.getCriteria_code() + "_" + custSegmentationSC.getLineNo());
		custSegmentationSC.setQueryParamGridPK("queryParamGridTbl_Id_" + custSegmentationSC.getCriteria_code() + "_" + custSegmentationSC.getLineNo());
		custSegmentationSC.setProgRef(get_pageRef()); //Rania - 718813 - Dynamic Customer Scoring on latest


		return "loadSegParams";
	}

	public String saveSegDefPriorities()
	{
		GridUpdates gridData, gridAllData;
		try
		{
			fillSessionVariables();
			if (StringUtil.isNotEmpty(custSegmentationDetailList_Id_gridUpdate))
			{
				gridData = getGridUpdates(custSegmentationDetailList_Id_gridUpdate, CustSegmentationCO.class, false);
				gridAllData = getGridUpdates(custSegmentationDetailList_Id_gridAllRecords, CustSegmentationCO.class, true);
				// custSegmentationCO.setGridAddList(gridData.getLstAdd());
				custSegmentationCO.setGridUpdateList(gridData.getLstModify());
				custSegmentationCO.setGridAllList(gridAllData.getLstAllRec());
				// custSegmentationCO.setGridDeleteList(gridData.getLstDelete());
				// custSegmentationCO.setGridUpdateList(gridData.getLstModify());
				// fillSegDefPriorties_gridUpdates(custSegmentationCO.getGridUpdateList());
				custSegmentationCO = custSegmentationBO.updateDefPriorties(custSegmentationCO);
			}
			else
			{
				throw new BOException(MessageCodes.NO_DATA_TO_SAVE_INSERT_RECORD);
			}
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "successjson";
	}

	private void fillSegDefPriorties_gridUpdates(List<CustSegmentationCO> list)
	{
		try
		{
			if (StringUtil.isNotEmpty(custSegmentationDetailList_Id_gridUpdate))
			{
				GridUpdates gridData = getGridUpdates(custSegmentationDetailList_Id_gridUpdate, CustSegmentationCO.class, false);

				custSegmentationCO.setGridAddList(gridData.getLstAdd());
				String queryParamGridUpdate, procParamGridUpdate;
				for (int i = 0; i < custSegmentationCO.getGridAddList().size(); i++)
				{
					queryParamGridUpdate = custSegmentationCO.getGridAddList().get(i).getQueryParamGridStr();
					GridUpdates queryGridData = getGridUpdates(queryParamGridUpdate, CustSegmentationParamCO.class, true);
					custSegmentationCO.getGridAddList().get(i).setQueryParamCOList(queryGridData.getLstAllRec());

					procParamGridUpdate = custSegmentationCO.getGridAddList().get(i).getProcParamGridStr();
					GridUpdates procGridData = getGridUpdates(procParamGridUpdate, CustSegmentationParamCO.class, true);
					custSegmentationCO.getGridAddList().get(i).setProcParamCOList(procGridData.getLstAllRec());
				}
				custSegmentationCO.setGridDeleteList(gridData.getLstDelete());
				custSegmentationCO.setGridUpdateList(gridData.getLstModify());
			}
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
	}

	private void displayExpressions(List<CustSegmentationCO> gridModel) throws BaseException
	{
		String displayExpression = "";
		for (int i = 0; i < gridModel.size(); i++)
		{
			CustSegmentationCO custSegCO = gridModel.get(i);

			SessionCO sessionCO = returnSessionObject();
			custSegCO.setLoginCompCode(sessionCO.getCompanyCode());
			custSegCO.setLoginBraCode(sessionCO.getBranchCode());

			if (custSegCO.getCtsSegmentDetVO().getLOGICAL_OPERATOR() != null)
			{
				displayExpression = displayExpression.concat(" " + custSegCO.getCtsSegmentDetVO().getLOGICAL_OPERATOR());
			}
			if (custSegCO.getCtsSegmentDetVO().getLEFT_OPERATOR() != null)
			{
				displayExpression = displayExpression.concat(" " + custSegCO.getCtsSegmentDetVO().getLEFT_OPERATOR());
			}
			if (custSegCO.getCtsSegmentDetVO().getCRITERIA_CODE() != null)
			{

				custSegCO = custSegmentationBO.dependencyByCriteriaCode(custSegCO);
				displayExpression = displayExpression.concat(" " + custSegCO.getCriteriaDesc());
			}
			if (custSegCO.getCtsSegmentDetVO().getRIGHT_OPERATOR() != null)
			{
				displayExpression = displayExpression.concat(" " + custSegCO.getCtsSegmentDetVO().getRIGHT_OPERATOR());
			}
		}
		if (displayExpression == null || displayExpression == "")
		{
			displayExpression = " ";
		}
		else
		{
			custSegmentationCO.setDisplayExpression(displayExpression);
		}
	}

	private void initializeMethod() throws BaseException
	{
		fillSessionVariables();
		showCrudButtonsByAccess();

		// check iv crud : Maintenace // approve
		custSegmentationCO = custSegmentationBO.initialiseData(custSegmentationCO, _newRecord);
		setAdditionalScreenParams(custSegmentationCO.getBuisnessElement());

		if ("R".equals(getIv_crud()))
		{
			set_showNewInfoBtn(ConstantsCommon.TRUE);
			set_showSmartInfoBtn(ConstantsCommon.FALSE);
			set_recReadOnly(ConstantsCommon.FALSE);
			set_showRecordLogsBtn(ConstantsCommon.FALSE);
		}

		// set_recReadOnly(ConstantsCommon.TRUE);
		else if ("P".equals(getIv_crud()))
		{
			set_showNewInfoBtn(ConstantsCommon.FALSE);
			set_showSmartInfoBtn(ConstantsCommon.FALSE);
			set_recReadOnly(ConstantsCommon.TRUE);
			set_showRecordLogsBtn(ConstantsCommon.FALSE);
		}
		else if (CustSegmentationConstant.UPDATE_AFTER_APPROVE_IVCRUD.equals(getIv_crud()))
		{
			set_showNewInfoBtn(ConstantsCommon.FALSE);
			set_showSmartInfoBtn(ConstantsCommon.FALSE);
			set_recReadOnly(ConstantsCommon.FALSE);
			set_showRecordLogsBtn(ConstantsCommon.FALSE);
		}

		custSegmentationCO.setIsSegmentationScore(returnSegmentType()); //Rania - 718813 - Dynamic Customer Scoring on latest
		custSegmentationCO.getCtsSegmentVO().setSTATUS("A");
		custSegmentationCO.setStatusdesc(getText("Active_key"));
	}

	public String loadLogicalOperatorDropDown()
	{
		try
		{
			List<SelectCO> lst = new ArrayList<SelectCO>();

			SelectCO co1 = new SelectCO();
			co1.setCode("AND");
			co1.setDescValue("AND");
			lst.add(co1);

			SelectCO co2 = new SelectCO();
			co2.setCode("OR");
			co2.setDescValue("OR");
			lst.add(co2);
			logicalOperatorDropDown = lst;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "successjson";
	}

	public String loadRightOperatorDropDown()
	{
		try
		{
			List<SelectCO> lst = new ArrayList<SelectCO>();

			SelectCO co = new SelectCO();
			co.setCode(" ");
			co.setDescValue(" ");
			lst.add(co);

			SelectCO co1 = new SelectCO();
			co1.setCode(")");
			co1.setDescValue(")");
			lst.add(co1);
			rightOperatorDropDown = lst;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "successjson";
	}

	public String loadLeftOperatorDropDown()
	{
		try
		{
			List<SelectCO> lst = new ArrayList<SelectCO>();

			SelectCO co = new SelectCO();
			co.setCode(" ");
			co.setDescValue(" ");
			lst.add(co);

			SelectCO co1 = new SelectCO();
			co1.setCode("(");
			co1.setDescValue("(");
			lst.add(co1);
			leftOperatorDropDown = lst;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "successjson";
	}

	private void fillCustSegmentationListGrid() throws BOException
	{
		String queryParamGridUpdate, procParamGridUpdate;
		
		if (StringUtil.isNotEmpty(custSegmentationDetailList_Id_gridAllRecords))
		{
			GridUpdates gridData1 = getGridUpdates(custSegmentationDetailList_Id_gridAllRecords, CustSegmentationCO.class, true);
			if (gridData1.getLstAllRec().isEmpty())
			{
				throw new BOException(MessageCodes.NO_DATA_TO_SAVE_INSERT_RECORD);
			}
			else
			{
				custSegmentationCO.setGridAllList(gridData1.getLstAllRec());
			}
		}

		for (int i = 0; i < custSegmentationCO.getGridAllList().size(); i++)
		{
			queryParamGridUpdate = custSegmentationCO.getGridAllList().get(i).getQueryParamGridStr();
			if (StringUtil.isNotEmpty(queryParamGridUpdate))
			{
				GridUpdates queryGridData = getGridUpdates(queryParamGridUpdate, CustSegmentationParamCO.class, true);
				custSegmentationCO.getGridAllList().get(i).setQueryParamCOList(queryGridData.getLstAllRec());
			}

			procParamGridUpdate = custSegmentationCO.getGridAllList().get(i).getProcParamGridStr();
			if (StringUtil.isNotEmpty(procParamGridUpdate))
			{
				GridUpdates procGridData = getGridUpdates(procParamGridUpdate, CustSegmentationParamCO.class, true);
				custSegmentationCO.getGridAllList().get(i).setProcParamCOList(procGridData.getLstAllRec());
			}
		}
		
		/*if (StringUtil.isNotEmpty(custSegmentationDetailList_Id_gridUpdate))
		{
			GridUpdates gridData = getGridUpdates(custSegmentationDetailList_Id_gridUpdate, CustSegmentationCO.class, false);

			custSegmentationCO.setGridAddList(gridData.getLstAdd());
			String queryParamGridUpdate, procParamGridUpdate;
			for (int i = 0; i < custSegmentationCO.getGridAddList().size(); i++)
			{
				queryParamGridUpdate = custSegmentationCO.getGridAddList().get(i).getQueryParamGridStr();
				if (StringUtil.isNotEmpty(queryParamGridUpdate))
				{
					GridUpdates queryGridData = getGridUpdates(queryParamGridUpdate, CustSegmentationParamCO.class, true);
					custSegmentationCO.getGridAddList().get(i).setQueryParamCOList(queryGridData.getLstAllRec());
				}

				procParamGridUpdate = custSegmentationCO.getGridAddList().get(i).getProcParamGridStr();
				if (StringUtil.isNotEmpty(procParamGridUpdate))
				{
					GridUpdates procGridData = getGridUpdates(procParamGridUpdate, CustSegmentationParamCO.class, true);
					custSegmentationCO.getGridAddList().get(i).setProcParamCOList(procGridData.getLstAllRec());
				}
			}
			custSegmentationCO.setGridDeleteList(gridData.getLstDelete());
			custSegmentationCO.setGridUpdateList(gridData.getLstModify());
			for (int i = 0; i < custSegmentationCO.getGridUpdateList().size(); i++)
			{
				queryParamGridUpdate = custSegmentationCO.getGridUpdateList().get(i).getQueryParamGridStr();
				
				if(!"".equals(queryParamGridUpdate))
				{
					GridUpdates queryGridData = getGridUpdates(queryParamGridUpdate, CustSegmentationParamCO.class, true);
					custSegmentationCO.getGridUpdateList().get(i).setQueryParamCOList(queryGridData.getLstAllRec());
				}
				
				procParamGridUpdate = custSegmentationCO.getGridUpdateList().get(i).getProcParamGridStr();
				
				if(!"".equals(procParamGridUpdate))
				{
					GridUpdates procGridData = getGridUpdates(procParamGridUpdate, CustSegmentationParamCO.class, true);
					
				}
			}
		}*/
		/*else
		{
			throw new BOException(MessageCodes.NO_DATA_TO_SAVE_INSERT_RECORD);
		}*/
	}

	public String saveSegment()
	{
		GridUpdates gridData;// = new GridUpdates();
		try
		{
			if("A".equals(custSegmentationCO.getCtsSegmentVO().getSTATUS()) || "UP".equals(getIv_crud()))
			{
				fillSessionVariables();
				
				// prepare CIF EXCLUDE GRID ITEMS
				prepareGridUpdates();
				fillCustSegmentationListGrid();
				
				// Rania - 718813 - Dynamic Customer Scoring on latest
				List<CustSegmentationCO> custSegmentationCOList = null;
				
				custSegmentationCO.setIsSegmentationScore(returnSegmentType());
				
				if ("SC".equals(custSegmentationCO.getIsSegmentationScore()) && is_newRecord())
				{
					custSegmentationCOList = custSegmentationCO.getGridAddList();
				}
				else if ("SC".equals(custSegmentationCO.getIsSegmentationScore()) && !is_newRecord())
				{
					custSegmentationCOList = custSegmentationCO.getGridAllList();
				}
				
				if(custSegmentationCO.getGridAllList() != null)
		    		{
		    		    for(int i = 0; i < custSegmentationCO.getGridAllList().size(); i++)
		    		    {
		    			if(NumberUtil.emptyDecimalToNull(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getCRITERIA_CODE()) == null)
		    			{
		    			    throw new BOException(MessageCodes.VALUES_MISSING);
		    			}
		    		    }
		    		}
				// End Rania
				
				AuditRefCO refCO = initAuditRefCO();
				refCO.setKeyRef(AuditConstant.CUST_SEGMENTATION_SCREEN_KEY_REF);
				custSegmentationCO.setAuditRefCO(refCO);
				
				custSegmentationCO.getCtsSegmentVO().setSEGMENT_TYPE(returnSegmentType()); // Rania - 718813 - Dynamic Customer Scoring on latest
				custSegmentationCO.setIsSegmentationScore(returnSegmentType()); // Rania - 718813 - Dynamic Customer Scoring on latest
				if (is_newRecord()) // on new
				{
					refCO.setOperationType(AuditConstant.CREATED);
					custSegmentationCO = custSegmentationBO.saveNewSegment(custSegmentationCO);
				}
				else
					// retrieve
				{
					refCO.setOperationType(AuditConstant.UPDATE);
					custSegmentationCO.setAuditObj(returnAuditObject(custSegmentationCO.getClass()));
					
					if ("SC".equals(custSegmentationCO.getIsSegmentationScore()))
					{
						custSegmentationCO.setGridAllList(custSegmentationCOList); // Rania - 718813 - Dynamic Customer Scoring on latest
					}
					custSegmentationCO = custSegmentationBO.updateSegment(custSegmentationCO);
				}
			}
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "successjson";
	}

	public String trialProcess()
	{
		GridUpdates gridData;// = new GridUpdates();
		try
		{
			fillSessionVariables();

			// prepare CIF EXCLUDE GRID ITEMS
			// prepareGridUpdates(); Commented to save the exclude CIF when
			// closign the popup
			fillCustSegmentationListGrid();

			// AuditRefCO refCO = initAuditRefCO();
			// refCO.setKeyRef(AuditConstant.CUST_SEGMENTATION_SCREEN_KEY_REF);
			// refCO.setOperationType(AuditConstant.UPDATE);
			// custSegmentationCO.setAuditRefCO(refCO);
			// custSegmentationCO.setAuditObj(returnAuditObject(custSegmentationCO.getClass()));

			custSegmentationCO.setIsSegmentationScore(returnSegmentType()); // Rania - 718813 - Dynamic Customer Scoring on latest

			custSegmentationCO = custSegmentationBO.trialProcess(custSegmentationCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "successjson";
	}

	public String saveExcludeCif()
	{
		try
		{
			fillSessionVariables();
			prepareGridUpdates();
			custSegmentationCO.setIsSegmentationScore(returnSegmentType()); //Rania - 718813 - Dynamic Customer Scoring on latest
			custSegmentationBO.saveExcludeCifGrid(custSegmentationCO, false);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "successjson";
	}

	private void prepareGridUpdates() throws BaseException
	{
		/*
		 * fill exclude CIF grid data
		 */
		if (StringUtil.isNotEmpty(custSegmentationCO.getExcludeCifGridUpdates()))
		{
			GridUpdates gu = getGridUpdates(custSegmentationCO.getExcludeCifGridUpdates(), CustSegmentationCO.class, true);
			if (gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
			{
				custSegmentationCO.setExcludeCifListCOs(gu.getLstAllRec());
			}
		}
	}

	public String initializeExcludeCifDialogue()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
			custSegmentationCO.setIsSegmentationScore(returnSegmentType()); //Rania - 718813 - Dynamic Customer Scoring on latest
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, "Error in loading populateExcludeCifPopup", null);
		}
		return "populateExcludeCifPopup";
	}

	public String loadCifOfTrialSegmentationProcessPopup()
	{
		return "cifTrialSegmentationPopup";
	}

	public String returnCifOfTrialSegmentationProcessPopup()
	{
		try
		{
			fillSessionVariables();
			CustSegmentationSC custSegmetnationSC = new CustSegmentationSC();
			custSegmetnationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
			custSegmetnationSC.setUserId(custSegmentationCO.getLoginUserId());
			custSegmetnationSC.setIsSegmentationScore(returnSegmentType()); //Rania - 718813 - Dynamic Customer Scoring on latest
			
			copyproperties(custSegmetnationSC);

			if (checkNbRec(custSegmetnationSC))
			{
				setRecords(custSegmentationBO.getCifOfTrialSegmentationProcessListCount(custSegmetnationSC));
			}

			List<CTS_CIF_SEG_FINAL_TMPVO> list = custSegmentationBO.getCifOfTrialSegmentationProcessList(custSegmetnationSC);
			setGridModel(list);
		}
		catch (Exception e)
		{
			log.error(e, e.getMessage());
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	// Reject Segment
	public String rejectSegment()
	{
		try
		{
			fillSessionVariables();

			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.CUST_SEGMENTATION_SCREEN_KEY_REF);
			custSegmentationCO.setAuditRefCO(refCO);
			refCO.setOperationType(AuditConstant.UPDATE);

			custSegmentationCO.setIsSegmentationScore(returnSegmentType());
			custSegmentationCO = custSegmentationBO.rejectSegment(custSegmentationCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "successjson";
	}

	// Approve Segment
	public String approveSegment()
	{
		try
		{
			fillSessionVariables();
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.CUST_SEGMENTATION_SCREEN_KEY_REF);
			custSegmentationCO.setAuditRefCO(refCO);
			refCO.setOperationType(AuditConstant.UPDATE);
			custSegmentationCO.setIsSegmentationScore(returnSegmentType());

			if (custSegmentationCO.getCtsSegmentVO().getDATE_UPDATED() != null)
			{
				custSegmentationCO = custSegmentationBO.checkDateUpdated(custSegmentationCO);
			}

			custSegmentationCO.setIsSegmentationScore(returnSegmentType());
			custSegmentationCO = custSegmentationBO.approveSegment(custSegmentationCO);

			/*
			 * S_TODO_DETVO currentSTodoDet = new S_TODO_DETVO(); if(NumberUtil.isEmptyDecimal(custSegmentationCO.getAlertsParamCO().getTodoCode()) ||
			 * NumberUtil.isEmptyDecimal(custSegmentationCO.getAlertsParamCO().getTodoLine())) {
			 * currentSTodoDet.setCOMP_CODE(custSegmentationCO.getAlertsParamCO().getCompCode());
			 * currentSTodoDet.setBRANCH_CODE(custSegmentationCO.getAlertsParamCO().getBranchCode());
			 * currentSTodoDet.setTODO_APPLICATION(custSegmentationCO.getAlertsParamCO().getAppName());
			 * currentSTodoDet.setTODO_PROG_REF(custSegmentationCO.getAlertsParamCO().getProgRef());
			 * currentSTodoDet.setTODO_PARAM(custSegmentationCO.getAlertsParamCO().getTodoParam());
			 * currentSTodoDet.setTODO_ALERT(custSegmentationCO.getAlertsParamCO().getOldTodoAlert()); } else {
			 * currentSTodoDet.setTODO_CODE(custSegmentationCO.getAlertsParamCO().getTodoCode());
			 * currentSTodoDet.setTODO_LINE(custSegmentationCO.getAlertsParamCO().getTodoLine()); currentSTodoDet =
			 * alertsBO.returnSTodoDet(currentSTodoDet); }
			 * 
			 * AlertsParamCO alertsParamCO = new AlertsParamCO(); alertsParamCO.setUserAck(custSegmentationCO.getCtsSegmentVO().getCREATED_BY());
			 * alertsParamCO.setTellerId(custSegmentationCO.getLoginUserId());
			 * alertsParamCO.setDateReceived(custSegmentationCO.getAlertsParamCO().getDateReceived()); alertsParamCO.setTrsNo(BigDecimal.ZERO);
			 * alertsParamCO.setTodoAlert(AlertsConstants.SEGMENTATION_APPROVE_TODO_ALERT); alertsBO.fAlertAcknowledgment(currentSTodoDet, alertsParamCO);
			 */
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "successjson";
	}

	private void checkGridChanges() throws Exception
	{
		if (StringUtil.isNotEmpty(custSegmentationDetailList_Id_gridUpdate)) // custSegmentationDetailList_Id_gridUpdate
		{
			GridUpdates gridData = getGridUpdates(custSegmentationDetailList_Id_gridUpdate, CustSegmentationCO.class, true);
			if (gridData.getLstAllRec().isEmpty())
			{
				throw new BOException(MessageCodes.NO_DATA_TO_SAVE_INSERT_RECORD);
			}
			else
			{
				custSegmentationCO.setGridAllList(gridData.getLstAllRec());
			}
		}
		else
		{
			throw new BOException(MessageCodes.NO_DATA_TO_SAVE_INSERT_RECORD);
		}
	}

	public String loadExcludeCifGrid()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			if (getSegmentCode() != null)
			{
				ExcludeCIFSC excludeCIFSC = new ExcludeCIFSC();
				// set in SC
				excludeCIFSC.setSegment_code(getSegmentCode());
				excludeCIFSC.setCompCode(sessionCO.getCompanyCode());
				excludeCIFSC.setSegmentType(custSegmentationCO.getIsSegmentationScore()); //Rania - 718813 - Dynamic Customer Scoring on latest
				
				copyproperties(excludeCIFSC);
				if (checkNbRec(excludeCIFSC))
				{
					setRecords(custSegmentationBO.returnExcludeCIFsDetailListCount(excludeCIFSC));
				}
				setGridModel(custSegmentationBO.returnExcludeCIFsDetailList(excludeCIFSC));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, "Error in loading populateExcludeCifPopup", null);
		}
		return "success";
	}

	public String loadCustSegmentationProcessPage()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			fillRadioMap();
			setTypeRadioMapDefaultValue("TP");
			custSegmentationSC.setProcessDate(sessionCO.getRunningDateRET());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, "Error in loading loadCustSegmentationProcessPage", null);
		}
		if ("P".equals(getIv_crud()))
		{
			return "loadCustSegProcessGrid";
		}
		return "loadCustSegmentationProcessPage";
	}

	private void fillRadioMap()
	{
		typeRadioMap.put("TP", getText("Trial_key"));
		typeRadioMap.put("FP", getText("Final_key"));
	}

	public String loadCustSegProcessGrid()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, "Error in loading loadCustSegProcessGrid", null);
		}
		return "loadCustSegProcessGrid";
	}

	/**
	 * @Desc show/hide buttons based on their access rights configured in SADS
	 */
	private void showCrudButtonsByAccess() throws BaseException
	{
		String[] optDetailsArr = returnCommonLibBO().returnOptDetailsList(returnSessionObject().getCurrentAppName(), get_pageRef());
		String parentOpt = "";
		if (optDetailsArr != null && optDetailsArr.length > 3)
		{
			// hold the parent prog_ref dynamically
			parentOpt = StringUtil.nullToEmpty(optDetailsArr[3]);
		}

		String menuButtonAccess = "";

		if (ConstantsCommon.CRUD_MAINTAIN.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(CustSegmentationConstant.MAINT_IVCRUD);
		}

		else if (ConstantsCommon.CRUD_APPROVE.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(ConstantsCommon.CRUD_APPROVE);
		}
		else if (CustSegmentationConstant.UPDATE_AFTER_APPROVE_IVCRUD.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(CustSegmentationConstant.UPDATE_AFTER_APPROVE_IVCRUD);
		}
		// Rania - 718813 - Dynamic Customer Scoring on latest
		else if (CustSegmentationConstant.SUSPEND.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(CustSegmentationConstant.SUSPEND);
		}
		else if (CustSegmentationConstant.APPROVE_SUSPEND.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(CustSegmentationConstant.APPROVE_SUSPEND);
		}
		else if (CustSegmentationConstant.REACTIVATE.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat("R");
		}
		else if (CustSegmentationConstant.APPROVE_REACTIVATE.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(CustSegmentationConstant.APPROVE_REACTIVATE);
		}
		else if (CustSegmentationConstant.CANCEL.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(CustSegmentationConstant.CANCEL);
		}
		else if (CustSegmentationConstant.APPROVE_CANCEL.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(CustSegmentationConstant.APPROVE_CANCEL);
		}
		// End Rania

		ServletActionContext.getRequest().setAttribute("menuButtonAccess", menuButtonAccess);
	}

	public String runTrialSegmentationProcess() throws BaseException
	{
		fillSessionVariables();

		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
		custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		custSegmentationSC.setUserId(custSegmentationCO.getLoginUserId());

		custSegmentationSC = custSegmentationBO.runTrialSegmentationProcess(custSegmentationSC);

		if (custSegmentationSC.getErrorMessage() != null)
		{
			throw new BOException(custSegmentationSC.getErrorMessage());
		}

		return "successjson";
	}

	public String approveCustSegProcess()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationSC.setUserId(sessionCO.getUserName());
			custSegmentationSC.setCompCode(sessionCO.getCompanyCode());
			custSegmentationSC.setStatus("P");
			custSegmentationBO.approveCustSegProcess(custSegmentationSC);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	public String rejectCustSegProcess()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationSC.setCompCode(sessionCO.getCompanyCode());
			custSegmentationBO.rejectCustSegProcess(custSegmentationSC);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	public String permanentRejectCustSegProcess()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationSC.setCompCode(sessionCO.getCompanyCode());
			custSegmentationSC.setIsSegmentationScore(returnSegmentType()); //Rania - 718813 - Dynamic Customer Scoring on latest
			custSegmentationBO.permanentRejectCustSegProcess(custSegmentationSC);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	/**
	 * @author raniaalbitar
	 * @param custSegmentationBO
	 *            718813 - Dynamic Customer Scoring on latest suspendSegment
	 */
	public String suspendSegment()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationCO.setRunningDate(sessionCO.getRunningDateRET());
			custSegmentationCO.setLoginUserId(sessionCO.getUserName());
			custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
			custSegmentationCO.setCrud(CustSegmentationConstant.SUSPEND);
			custSegmentationCO.setIsSegmentationScore(returnSegmentType());
			custSegmentationBO.updateSegmentHeader(custSegmentationCO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	/**
	 * @author raniaalbitar
	 * @param custSegmentationBO
	 *            718813 - Dynamic Customer Scoring on latest approveSuspendSegment
	 */
	public String approveSuspendSegment()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationCO.setRunningDate(sessionCO.getRunningDateRET());
			custSegmentationCO.setLoginUserId(sessionCO.getUserName());
			custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
			custSegmentationCO.setCrud(CustSegmentationConstant.APPROVE_SUSPEND);
			custSegmentationCO.setIsSegmentationScore(returnSegmentType());

			custSegmentationBO.updateSegmentHeader(custSegmentationCO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	/**
	 * @author raniaalbitar
	 * @param custSegmentationBO
	 *            718813 - Dynamic Customer Scoring on latest reactivateSegment
	 */
	public String reactivateSegment()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationCO.setRunningDate(sessionCO.getRunningDateRET());
			custSegmentationCO.setLoginUserId(sessionCO.getUserName());
			custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
			custSegmentationCO.setCrud(CustSegmentationConstant.REACTIVATE);
			custSegmentationCO.setIsSegmentationScore(returnSegmentType());

			custSegmentationBO.updateSegmentHeader(custSegmentationCO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	/**
	 * @author raniaalbitar
	 * @param custSegmentationBO
	 *            718813 - Dynamic Customer Scoring on latest approveReactivateSegment
	 */
	public String approveReactivateSegment()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationCO.setRunningDate(sessionCO.getRunningDateRET());
			custSegmentationCO.setLoginUserId(sessionCO.getUserName());
			custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
			custSegmentationCO.setCrud(CustSegmentationConstant.APPROVE_REACTIVATE);
			custSegmentationCO.setIsSegmentationScore(returnSegmentType());

			custSegmentationBO.updateSegmentHeader(custSegmentationCO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	/**
	 * @author raniaalbitar
	 * @param custSegmentationBO
	 *            718813 - Dynamic Customer Scoring on latest cancelSegment
	 */
	public String cancelSegment()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationCO.setRunningDate(sessionCO.getRunningDateRET());
			custSegmentationCO.setLoginUserId(sessionCO.getUserName());
			custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
			custSegmentationCO.setCrud(CustSegmentationConstant.CANCEL);
			custSegmentationCO.setIsSegmentationScore(returnSegmentType());

			custSegmentationBO.updateSegmentHeader(custSegmentationCO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	/**
	 * @author raniaalbitar
	 * @param custSegmentationBO
	 *            718813 - Dynamic Customer Scoring on latest approveCancelSegment
	 */
	public String approveCancelSegment()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationCO.setRunningDate(sessionCO.getRunningDateRET());
			custSegmentationCO.setLoginUserId(sessionCO.getUserName());
			custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
			custSegmentationCO.setCrud(CustSegmentationConstant.APPROVE_CANCEL);
			custSegmentationCO.setIsSegmentationScore(returnSegmentType());

			custSegmentationBO.updateSegmentHeader(custSegmentationCO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	/**
	 * @author raniaalbitar
	 * @param custSegmentationBO
	 *            718813 - Dynamic Customer Scoring on latest
	 */

	public String loadUpdateCustomerScoring()
	{
		return "custScoringProcess";
	}

	/**
	 * @author raniaalbitar
	 * @param custSegmentationBO
	 *            718813 - Dynamic Customer Scoring on latest
	 */
	public String custScoreProcess()
	{
		try
		{
			List<CustSegmentationCO> custSegmentationCOList = new ArrayList<>();

			if (custSegmentationSC != null && (NumberUtil.emptyDecimalToNull(custSegmentationSC.getCifNo()) == null))
			{
				throw new BOException(MessageCodes.FILL_CIF_FOR_SCORE_PROCESS);
			}
			
			if (custSegmentationSC != null && (NumberUtil.emptyDecimalToNull(custSegmentationSC.getSegmentCode()) == null))
			{
				throw new BOException(MessageCodes.FILL_SEGMENT_FOR_SCORE_PROCESS);
			}

			fillSessionVariables();

			custSegmentationCO.setIsSegmentationScore("SC");

			custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
			custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
			custSegmentationSC.setSegment_code(custSegmentationSC.getSegmentCode());
			custSegmentationSC.setIsSegmentationScore("SC");

			custSegmentationCOList = custSegmentationBO.returnCustSegmentationDetails(custSegmentationSC);

			custSegmentationCO.setGridAllList(custSegmentationCOList);
			custSegmentationCO.setCifNo(custSegmentationSC.getCifNo());
			custSegmentationCO.getCtsSegmentVO().setSEGMENT_CODE(custSegmentationSC.getSegment_code());
			custSegmentationSC.setFromBranch(custSegmentationSC.getBranchCode());
			custSegmentationSC.setToBranch(custSegmentationSC.getBranchCode());
			custSegmentationSC.setFromCif(custSegmentationSC.getCifNo());
			custSegmentationSC.setToCif(custSegmentationSC.getCifNo());

			custSegmentationBO.deleteFromCTS_SEG_CIF_EXEC_RESULT_TEMP(custSegmentationSC);
			custSegmentationBO.deleteFromCTS_SEG_CIF_EXEC_RESULT(custSegmentationSC);

			custSegmentationCO = custSegmentationBO.trialProcess(custSegmentationCO);

			custSegmentationSC.setUserId(custSegmentationCO.getLoginUserId());
			custSegmentationSC.setProcessType("FP");

			custSegmentationBO.insertSegProcessResult(custSegmentationSC);

			custSegmentationSC.setScore(custSegmentationCO.getScore());
			custSegmentationSC.setRunningDate(custSegmentationCO.getRunningDate());
			custSegmentationBO.insertAmlCifScoreResult(custSegmentationSC);
			
			if(custSegmentationCO.getErrorMessage() == null || "".equals(custSegmentationCO.getErrorMessage()))
			{
				set_warning("Process is executed successfully");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			handleException(e, null, null);
		}
		return "successjson";
	}

	/**
	 * @author raniaalbitar
	 * @param custSegmentationBO
	 *            718813 - Dynamic Customer Scoring on latest
	 */

	public String totalPercentageValidation()
	{
		try
		{
			GridUpdates gridData = getGridUpdates(custSegmentationDetailList_Id_gridAllRecords, CustSegmentationCO.class, true);
			custSegmentationCO.setGridAllList(gridData.getLstAllRec());

			custSegmentationBO.totalPercentageValidation(custSegmentationCO);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}

		return "successjson";
	}

	public String deleteSegment()
	{
		try
		{
			fillSessionVariables();
			custSegmentationCO.setIsSegmentationScore(returnSegmentType()); //Rania - 718813 - Dynamic Customer Scoring on latest
			custSegmentationBO.deleteSegment(custSegmentationCO);
		}

		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "successjson";
	}

	public String returnSegmentType()
	{
		String isSegmentScore = "S";

		if (get_pageRef() != null && get_pageRef().contains("CSC00"))
		{
			isSegmentScore = "SC";
		}
		else if (get_pageRef() != null && get_pageRef().contains("CSG00"))
		{
			isSegmentScore = "S";
		}

		return isSegmentScore;
	}

	/**
	 * @author RaniaAlBitar
	 * ABSAI180073
	 * @param custSegmentationBO
	 */
	
	public String returnQueryID()
        {
        	try
        	{
        	    SessionCO sessionCO = returnSessionObject();

        	    custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
        	    
        	    custSegmentationCO = custSegmentationBO.returnQueryID(custSegmentationCO);
        	}
        	catch(Exception ex)
        	{
        	    handleException(ex, null, null);
        	}
        
        	return "successjson";
    
        }
	
	public void setCustSegmentationBO(CustSegmentationBO custSegmentationBO)
	{
		this.custSegmentationBO = custSegmentationBO;
	}

	public CustSegmentationCO getCustSegmentationCO()
	{
		return custSegmentationCO;
	}

	public void setCustSegmentationCO(CustSegmentationCO custSegmentationCO)
	{
		this.custSegmentationCO = custSegmentationCO;
	}

	public List<SelectCO> getLogicalOperatorDropDown()
	{
		return logicalOperatorDropDown;
	}

	public void setLogicalOperatorDropDown(List<SelectCO> logicalOperatorDropDown)
	{
		this.logicalOperatorDropDown = logicalOperatorDropDown;
	}

	public List<SelectCO> getRightOperatorDropDown()
	{
		return rightOperatorDropDown;
	}

	public void setRightOperatorDropDown(List<SelectCO> rightOperatorDropDown)
	{
		this.rightOperatorDropDown = rightOperatorDropDown;
	}

	public List<SelectCO> getLeftOperatorDropDown()
	{
		return leftOperatorDropDown;
	}

	public void setLeftOperatorDropDown(List<SelectCO> leftOperatorDropDown)
	{
		this.leftOperatorDropDown = leftOperatorDropDown;
	}

	public String getCustSegmentationDetailList_Id_gridUpdate()
	{
		return custSegmentationDetailList_Id_gridUpdate;
	}

	public void setCustSegmentationDetailList_Id_gridUpdate(String custSegmentationDetailListIdGridUpdate)
	{
		custSegmentationDetailList_Id_gridUpdate = custSegmentationDetailListIdGridUpdate;
	}

	public String getCustSegmentationDetailList_Id_gridAllRecords()
	{
		return custSegmentationDetailList_Id_gridAllRecords;
	}

	public void setCustSegmentationDetailList_Id_gridAllRecords(String custSegmentationDetailListIdGridAllRecords)
	{
		custSegmentationDetailList_Id_gridAllRecords = custSegmentationDetailListIdGridAllRecords;
	}

	public boolean is_newRecord()
	{
		return _newRecord;
	}

	public void set_newRecord(boolean newRecord)
	{
		_newRecord = newRecord;
	}

	public BigDecimal getSegmentCode()
	{
		return segmentCode;
	}

	public void setSegmentCode(BigDecimal segmentCode)
	{
		this.segmentCode = segmentCode;
	}

	public String getExcludeCifGridUpdates()
	{
		return excludeCifGridUpdates;
	}

	public void setExcludeCifGridUpdates(String excludeCifGridUpdates)
	{
		this.excludeCifGridUpdates = excludeCifGridUpdates;
	}

	public CustSegmentationSC getCustSegmentationSC()
	{
		return custSegmentationSC;
	}

	public void setCustSegmentationSC(CustSegmentationSC custSegmentationSC)
	{
		this.custSegmentationSC = custSegmentationSC;
	}

	public HashMap<String, String> getTypeRadioMap()
	{
		return typeRadioMap;
	}

	public void setTypeRadioMap(HashMap<String, String> typeRadioMap)
	{
		this.typeRadioMap = typeRadioMap;
	}

	public String getTypeRadioMapDefaultValue()
	{
		return typeRadioMapDefaultValue;
	}

	public void setTypeRadioMapDefaultValue(String typeRadioMapDefaultValue)
	{
		this.typeRadioMapDefaultValue = typeRadioMapDefaultValue;
	}

	public void setAlertsBO(AlertsBO alertsBO)
	{
		this.alertsBO = alertsBO;
	}
}
