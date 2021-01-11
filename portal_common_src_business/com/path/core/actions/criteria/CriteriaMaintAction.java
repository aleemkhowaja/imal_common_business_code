package com.path.core.actions.criteria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.json.JSONException;
import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.criteria.CriteriaBO;
import com.path.bo.core.criteria.CriteriaConstant;
import com.path.dbmaps.vo.CIFCONTROL_DEFINE_SCORE_RANGEVO;
import com.path.dbmaps.vo.CTS_CRITERIAVO;
import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.CTS_CRITERIA_PARAMVO;
import com.path.dbmaps.vo.IRP_SESSION_ATTRIBUTESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.json.PathJSONUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.core.criteria.CriteriaCO;
import com.path.vo.core.criteria.CriteriaParamCO;
import com.path.vo.core.criteria.CriteriaSC;
import com.path.vo.core.procedureid.ProcedureIdCO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * @author: tonyelkhoury
 * 
 * 
 */
public class CriteriaMaintAction extends RetailBaseAction
{

	private CriteriaCO criteriaCO = new CriteriaCO();
	private BigDecimal criteriaId;// to remove later
	private CriteriaBO criteriaBO;
	private String update1;
	private List<SelectCO> sessionAttrList;
	//
	private List<SelectCO> criteriaUsageList = new ArrayList<SelectCO>();
	//
	private List<CriteriaParamCO> criteriaParamCOList = new ArrayList<CriteriaParamCO>();

	private CriteriaSC criteriaSC = new CriteriaSC();
	private String _entityType;
	private String popupMode;
	//By Bilal For TP#750884
	private String jsonMultiselectArray;
	private BigDecimal _lineNo;
	private String _disabled;
	
	public Object getModel()
	{
		return criteriaCO;
	}

	/**
	 * First function to be executed when loading criteria page
	 * 
	 * @return
	 */
	public String initialiseCriteriaPage()
	{

		try
		{
			SessionCO sessionCO = returnSessionObject();
			fillDefaultValues(sessionCO);
			if (getIv_crud().equalsIgnoreCase("R"))
			{
				set_showNewInfoBtn("true");
				// set_showSmartInfoBtn("false");
				set_recReadOnly("false");

			}
			else
			{
				set_showNewInfoBtn("false");
				// set_showSmartInfoBtn("false");
				set_recReadOnly("true");
			}

			set_searchGridId("criteriaGridTbl_Id");
			// fillMenuOptions();

			SYS_PARAM_SCREEN_DISPLAYVO displayvo = new SYS_PARAM_SCREEN_DISPLAYVO();
			if(CriteriaConstant.PAGE_REF_CRITERIA_SCORING.equals(get_pageRef()))
			{
				displayvo.setIS_VISIBLE(BigDecimal.ONE);
			}
			else
			{
				displayvo.setIS_VISIBLE(BigDecimal.ZERO);
			}
			
//			SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
//        	businessElement.setIS_READONLY((BigDecimal.ONE));
//        	getAdditionalScreenParams().put("view_query_btn", businessElement);
			//setReadOnly_att("true"); //b*b
			
			getAdditionalScreenParams().put("criteriaCO.ctsCriteriaVO.SCORE", displayvo);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return "loadCriteriaPage";
	}

	public void fillDefaultValues(SessionCO sessionCO) throws BaseException
	{
		fillSessionData(sessionCO);

		SelectSC selectSC = new SelectSC(CriteriaConstant.CRITERIA_USAGE_LOV_TYPE);
		criteriaUsageList = returnLOV(selectSC);
		//Added by bilal for TP#750884
		if(CriteriaConstant.APP_NAME_AML.equals(sessionCO.getCurrentAppName()))
		{
			if(CriteriaConstant.PAGE_REF_CRITERIA_BUS_RULE.equals(get_pageRef()))
			{
				for(int i=0; i < criteriaUsageList.size(); i++)
				{
					if(CriteriaConstant.SELECT_CODE_BUS_RULE.equals(criteriaUsageList.get(i).getCode()))
					{
						SelectCO selectCO = new SelectCO();
						selectCO.setCode(criteriaUsageList.get(i).getCode());
						selectCO.setDescValue(criteriaUsageList.get(i).getDescValue());
						criteriaUsageList.clear();
						criteriaUsageList.add(selectCO);
					}
				}
				set_disabled("true");
			}
			else if(CriteriaConstant.PAGE_REF_CRITERIA_SCORING.equals(get_pageRef()))
			{
				for(int i=0; i < criteriaUsageList.size(); i++)
				{
					if(CriteriaConstant.SELECT_CODE_SCORING.equals(criteriaUsageList.get(i).getCode()))
					{
						SelectCO selectCO = new SelectCO();
						selectCO.setCode(criteriaUsageList.get(i).getCode());
						selectCO.setDescValue(criteriaUsageList.get(i).getDescValue());
						criteriaUsageList.clear();
						criteriaUsageList.add(selectCO);
					}
				}
				set_disabled("true");
			}
		}	
		else
		{
			set_disabled("false");
		}
	}

	public void fillSessionData(SessionCO sessionCO) throws BaseException
	{

		criteriaCO.getCtsCriteriaVO().setBRANCH_CODE(sessionCO.getBranchCode());
		criteriaCO.setLoginCompCode(sessionCO.getCompanyCode());
		criteriaCO.setLoginBraCode(sessionCO.getBranchCode());
		criteriaCO.setOriginBraCode(sessionCO.getBranchCode());
		// criteriaCO.setLoginTellerCode(sessionCO.getCtsTellerVO().getCODE());
		criteriaCO.setLoginUserId(sessionCO.getUserName());
		// criteriaCO.getCtsCriteriaVO().setCIF_NO(criteriaCO.getCtsCriteriaVO().getACC_CIF());
		criteriaCO.setOpt(get_pageRef());
		criteriaCO.setRunningDate(sessionCO.getRunningDateRET());
		criteriaCO.setAppName(sessionCO.getCurrentAppName());
		criteriaCO.setLanguage(sessionCO.getLanguage());
		criteriaCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
		if (getIv_crud() != null)
		{
			criteriaCO.setCrud(getIv_crud());
		}
	}

	public String loadCriteriaDetails()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			fillDefaultValues(sessionCO);

			if (!NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE()))
			{

				CriteriaSC criteriaSC = new CriteriaSC();
				criteriaSC.setCompCode(sessionCO.getCompanyCode());
				criteriaSC.setBranchCode(sessionCO.getBranchCode());
				criteriaSC.setLang(sessionCO.getLanguage());
				criteriaSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
				criteriaSC.setCRITERIA_CODE(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE());

				// fill them on other method
				criteriaCO = criteriaBO.returnCriteriaDetails(criteriaSC);
				
				//b*b
//				if(!NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getQUERY_ID()))
//				{
//					//setReadOnly_att("false"); //b*b
//					SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
//		        	businessElement.setIS_READONLY((BigDecimal.ZERO));
//		        	criteriaCO.getHm().put("view_query_btn", businessElement);
//				}
//				else
//				{
//					SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
//		        	businessElement.setIS_READONLY((BigDecimal.ONE));
//		        	criteriaCO.getHm().put("view_query_btn", businessElement);
//				}
				
				criteriaCO.setEditMode("true");
				String test = criteriaCO.getEditMode();

				if (criteriaCO.getHm() != null)
				{
					setAdditionalScreenParams(criteriaCO.getHm());
				}

			}
			// Rania - 718813 - Dynamic Customer Scoring on latest
			else
			{
				SYS_PARAM_SCREEN_DISPLAYVO displayvo = new SYS_PARAM_SCREEN_DISPLAYVO();
				if(CriteriaConstant.PAGE_REF_CRITERIA_SCORING.equals(get_pageRef()))
				{
					displayvo.setIS_VISIBLE(BigDecimal.ONE);
				}
				else
				{
					displayvo.setIS_VISIBLE(BigDecimal.ZERO);
				}
				
				//setReadOnly_att("true"); //b*b
//				SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
//	        	businessElement.setIS_READONLY((BigDecimal.ONE));
//	        	getAdditionalScreenParams().put("view_query_btn", businessElement);
				
				getAdditionalScreenParams().put("criteriaCO.ctsCriteriaVO.SCORE", displayvo);
			}
			// End Rania

			// fillMenuOptions();
			//added by nour for 864398
			criteriaCO.getCtsCriteriaVO().setCOMP_CODE(sessionCO.getCompanyCode());
			applyRetrieveAudit(AuditConstant.CRITERIA_KEY, criteriaCO.getCtsCriteriaVO(), criteriaCO);
			// end nour
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "loadCriteriaMaintPage";
	}

	public BigDecimal getCriteriaId()
	{
		return criteriaId;
	}

	public void setCriteriaId(BigDecimal criteriaId)
	{
		this.criteriaId = criteriaId;
	}

	public String loadProcedure()
	{
		try
		{

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "loadProcedure";
	}

	public String loadProcedureGrid()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			copyproperties(criteriaSC);
			criteriaSC.setCompCode(sessionCO.getCompanyCode());
			criteriaSC.setPreferredLanguage(sessionCO.getPreferredLanguage());

		}
		catch (Exception e)
		{
			log.error(e, "Error in loadProcedureDefGrid");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	// public String checkIfProcedureCanDeleted()
	// {
	// try
	// {
	// fillCoFromSession();
	//
	// criteriaBO.checkIfProcedureCanDeleted(criteriaCO);
	// }
	// catch(Exception ex)
	// {
	// handleException(ex, null, null);
	// }
	// return "success";
	// }

	private void fillCoFromSession()
	{
		SessionCO sessionCO = returnSessionObject();

		criteriaCO.setLanguage(sessionCO.getLanguage());
		criteriaCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
		criteriaCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
		criteriaCO.setRunningDate(sessionCO.getRunningDateRET());
		criteriaCO.setAppName(sessionCO.getCurrentAppName());
		criteriaCO.setOpt(get_pageRef());
		criteriaCO.setCrud(getIv_crud());

	}

	public String saveProcedures()
	{
		try
		{

			if (StringUtil.isNotEmpty(criteriaCO.getProceduresIdCOsStr()))
			{
				GridUpdates gu = getGridUpdates(criteriaCO.getProceduresIdCOsStr(), ProcedureIdCO.class, true);
				if (gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
				{
					criteriaBO.saveProcedures(gu.getLstAllRec());
				}
			}
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String saveNew() throws BaseException
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			fillSessionData(sessionCO);
			// added by nour for 864398
			if (ConstantsCommon.FALSE.equals(criteriaCO.getEditMode()))
				// audit
				{
					AuditRefCO refCO = initAuditRefCO();
					refCO.setOperationType(AuditConstant.CREATED);
					refCO.setKeyRef(AuditConstant.CRITERIA_KEY);
					criteriaCO.setAuditRefCO(refCO);
					
					//by bilal for BUG#973485
					criteriaCO.getCtsCriteriaVO().setCOMP_CODE(criteriaCO.getLoginCompCode());
					criteriaCO.getCtsCriteriaVO().setCRITERIA_CODE(BigDecimal.valueOf(criteriaBO.returnMaxCriteriaCode(criteriaCO)));//bug 969312
				}
				else
				{
					AuditRefCO refCO = initAuditRefCO();
					refCO.setOperationType(AuditConstant.UPDATE);
					refCO.setKeyRef(AuditConstant.CRITERIA_KEY);
					refCO.setTrxNbr(getAuditTrxNbr());
					criteriaCO.setAuditRefCO(refCO);
					criteriaCO.setAuditObj(returnAuditObject(criteriaCO.getClass()));


				}
			// end nour
			
			if (StringUtil.isNotEmpty(criteriaCO.getProceduresParamCOsStr()))
			{
				GridUpdates gu = getGridUpdates(criteriaCO.getProceduresParamCOsStr(), CriteriaParamCO.class, true);
				if (gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
				{
					criteriaCO.setCriteriaProcParamCOLst(gu.getLstAllRec());
					
					//By Bilal For TP#750884
					for(int i=0; i < criteriaCO.getCriteriaProcParamCOLst().size(); i++)
					{
						CriteriaParamCO criteriaParamCO = (CriteriaParamCO) criteriaCO.getCriteriaProcParamCOLst().get(i);
						if(CriteriaConstant.PARAM_CLASS_Q.equals(criteriaParamCO.getCtsCriteriaParamVO().getPARAM_CLASS()))
						{
							//By Bilal For TP#750884 replace param
							if("1".equals(criteriaParamCO.getIsOpened()))
							{
								if(StringUtil.isNotEmpty(criteriaParamCO.getQuerySelectParamGridStr()))
								{
									GridUpdates guMultiselectParam = getGridUpdates(criteriaParamCO.getQuerySelectParamGridStr(),CriteriaParamCO.class, true);
									criteriaCO.getCriteriaProcParamCOLst().get(i).setCriteriaQuerySelectParamCOLst((List<CriteriaParamCO>) guMultiselectParam.getLstAllRec());
								}
							}
							else
							{
								CriteriaSC criteriaSC = new CriteriaSC();
								criteriaSC.setCompCode(criteriaCO.getLoginCompCode());
								criteriaSC.setCRITERIA_CODE(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE());
								criteriaSC.setParamQueryId(criteriaParamCO.getCtsCriteriaParamVO().getPARAM_QUERY_ID());
								List<CriteriaParamCO> lsParamCO = criteriaBO.returnArgumentSelectDetails(criteriaSC);
								criteriaCO.getCriteriaProcParamCOLst().get(i).setCriteriaQuerySelectParamCOLst(lsParamCO);
							}
							//end
							
							if(StringUtil.isNotEmpty(criteriaParamCO.getJsonMultiselectArray()))
							{
								GridUpdates guMultiselect = getGridUpdates(criteriaParamCO.getJsonMultiselectArray(),AML_PARAM_MAPPINGVO.class, true);
								List<AML_PARAM_MAPPINGVO> lstMultiSelect = new ArrayList<AML_PARAM_MAPPINGVO>();
								for(int j=0; j < guMultiselect.getLstAllRec().size(); j++)
								{
									AML_PARAM_MAPPINGVO paramMappingVO = (AML_PARAM_MAPPINGVO) guMultiselect.getLstAllRec().get(j);
									paramMappingVO.setCOMP_CODE(criteriaCO.getLoginCompCode());
									paramMappingVO.setBRANCH_CODE(criteriaCO.getLoginBraCode());
									paramMappingVO.setBUSINESS_RULE_CODE(BigDecimal.ZERO);
									paramMappingVO.setCRITERIA_CODE(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE());
									lstMultiSelect.add(paramMappingVO);
								}
								criteriaCO.getCriteriaProcParamCOLst().get(i).setLstMultiSelect(lstMultiSelect);
							}
						}
					}
					//end
				}
			}

			if (StringUtil.isNotEmpty(criteriaCO.getQueriesParamCOsStr()))
			{
				GridUpdates gu = getGridUpdates(criteriaCO.getQueriesParamCOsStr(), CriteriaParamCO.class, true);
				if (gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
				{
					criteriaCO.setCriteriaQueryParamCOLst((List<CriteriaParamCO>) gu.getLstAllRec());
					
					//By Bilal For TP#750884
					for(int i=0; i < criteriaCO.getCriteriaQueryParamCOLst().size(); i++)
					{
						CriteriaParamCO criteriaParamCO = (CriteriaParamCO) criteriaCO.getCriteriaQueryParamCOLst().get(i);
						if(CriteriaConstant.PARAM_CLASS_Q.equals(criteriaParamCO.getCtsCriteriaParamVO().getPARAM_CLASS()))
						{
							//By Bilal For TP#750884 replace param
							if(StringUtil.isNotEmpty(criteriaParamCO.getQuerySelectParamGridStr()))
							{
								GridUpdates guMultiselectParam = getGridUpdates(criteriaParamCO.getQuerySelectParamGridStr(),CriteriaParamCO.class, true);
								criteriaCO.getCriteriaQueryParamCOLst().get(i).setCriteriaQuerySelectParamCOLst((List<CriteriaParamCO>) guMultiselectParam.getLstAllRec());
							}
							//end
							if(StringUtil.isNotEmpty(criteriaParamCO.getJsonMultiselectArray()))
							{
								GridUpdates guMultiselect = getGridUpdates(criteriaParamCO.getJsonMultiselectArray(),AML_PARAM_MAPPINGVO.class, true);
								List<AML_PARAM_MAPPINGVO> lstMultiSelect = new ArrayList<AML_PARAM_MAPPINGVO>();
								for(int j=0; j < guMultiselect.getLstAllRec().size(); j++)
								{
									AML_PARAM_MAPPINGVO paramMappingVO = (AML_PARAM_MAPPINGVO) guMultiselect.getLstAllRec().get(j);
									paramMappingVO.setCOMP_CODE(criteriaCO.getLoginCompCode());
									paramMappingVO.setBRANCH_CODE(criteriaCO.getLoginBraCode());
									paramMappingVO.setBUSINESS_RULE_CODE(BigDecimal.ZERO);
									paramMappingVO.setCRITERIA_CODE(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE());
									lstMultiSelect.add(paramMappingVO);
								}
								criteriaCO.getCriteriaQueryParamCOLst().get(i).setLstMultiSelect(lstMultiSelect);
							}
						}
					}
					//end
				}
			}

			criteriaCO = criteriaBO.saveCriteria(criteriaCO);
			
			if("true".equals(criteriaCO.getEditMode()))
			{
			    set_warning("Score value for CIFs will be affected. Please update customer scoring for new Scores.");
			}
			

		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String dependencyByCriteriaReference() throws JSONException
	{
		try
		{
			if (!StringUtil.isEmptyString(criteriaCO.getCtsCriteriaVO().getCRITERIA_REFERENCE()))
			{
				SessionCO sessionCO = returnSessionObject();
				criteriaCO.setLoginCompCode(sessionCO.getCompanyCode());
				criteriaCO.setCriteriaReference(criteriaCO.getCtsCriteriaVO().getCRITERIA_REFERENCE().toUpperCase());
				
				criteriaBO.dependencyByCriteriaReference(criteriaCO);
			}
			else
			{
				criteriaCO.getCtsCriteriaVO().setCRITERIA_REFERENCE(null);
			}
		}
		catch (Exception e)
		{
			criteriaCO.getCtsCriteriaVO().setCRITERIA_REFERENCE(null);
			handleException(e, null, null);
		}
		return SUCCESS;
	}
	
	public String dependencyByCriteriaCode() throws JSONException
	{
		try
		{
			if (!NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE()))
			{
				SessionCO sessionCO = returnSessionObject();
				criteriaCO.getCtsCriteriaVO().setCOMP_CODE(sessionCO.getCompanyCode());
				criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE();
				criteriaBO.dependencyByCriteriaCode(criteriaCO);
			}
			else
			{
				criteriaCO.getCtsCriteriaVO().setCRITERIA_CODE(null);
			}
		}
		catch (Exception e)
		{
			criteriaCO.getCtsCriteriaVO().setCRITERIA_CODE(null);
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String loadParam()
	{
		try
		{
			criteriaCO.getEditMode();
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "loadParam";
	}
	
	public String loadParamMultiSelect()
	{
		try
		{
			criteriaCO.getEditMode();
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "loadParamMultiSelect";
	}

	public String loadAvaBenefStatusSelect()
	{
		try
		{
			SelectSC selSC = new SelectSC(CriteriaConstant.CRITERIA_PARAM_CLASS_LOV_TYPE);
			SelectCO co1 = new SelectCO();
			co1.setCode("1");
			co1.setDescValue(" ");

			criteriaUsageList = (ArrayList<SelectCO>) returnLOV(selSC);
			criteriaUsageList.add(co1);

		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String loadSessionAttrNameSelect()
	{

		try
		{
			IRP_SESSION_ATTRIBUTESVO sessionAttrVO = new IRP_SESSION_ATTRIBUTESVO();
			// if(ConstantsCommon.TRANS_SESSION_ARG_SOURCE.toString().equals(getUpdate1()))
			// {
			// sessionAttrVO.setLANG_INDEPENDENT_YN(ConstantsCommon.NO);

			sessionAttrList = new ArrayList<SelectCO>();
			List<IRP_SESSION_ATTRIBUTESVO> list = returnCommonLibBO().returnSessionAttrList(sessionAttrVO);
			SelectCO selectCO;
			Integer i = 1;
			SelectCO selectCO1 = new SelectCO();
			// selectCO1.setCode(i.toString());
			selectCO1.setDescValue(" ");
			sessionAttrList.add(selectCO1);

			for (IRP_SESSION_ATTRIBUTESVO vo : list)
			{
				i++;
				selectCO = new SelectCO();
				selectCO.setCode(vo.getTECHNICAL_NAME());
				selectCO.setDescValue(vo.getATTRIBUTE_NAME());
				sessionAttrList.add(selectCO);
			}

			// }
		}
		catch (BaseException e)
		{
			handleException(e, "Error returning session attributes list", "returnSessAttrList.exceptionMsg._key");
		}

		return SUCCESS;
	}

	/**
	 * @author raniaalbitar
	 * 718813 - Dynamic Customer Scoring on latest
	 * @return
	 */
	
	public String onChangeCriteriaEntity()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteriaCO.getCtsCriteriaVO().setCOMP_CODE(sessionCO.getCompanyCode());
			
			if(NumberUtil.emptyDecimalToNull(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE()) != null)
			{
				criteriaBO.returnCountCriteriaLinkSegment(criteriaCO);
			}
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		
		return SUCCESS;
	}
	
	/**
	 * @author RaniaAlBitar
	 * BMO180147 - Risk Assessment of customers on the basis of products, services and geographic locations
	 * @return
	 */
	
        public String dependencyByScoreValue()
        {
        	try
        	{
        	    SessionCO sessionCO = returnSessionObject();
        	    BigDecimal scoreValue = criteriaCO.getCtsCriteriaVO().getSCORE();
        	    CIFCONTROL_DEFINE_SCORE_RANGEVO cifControlDefineScoreRangeVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO();
        		    
        	    criteriaCO.getCtsCriteriaVO().setCOMP_CODE(sessionCO.getCompanyCode());
        	    
        	    if(NumberUtil.emptyDecimalToNull(criteriaCO.getCtsCriteriaVO().getSCORE()) != null)
        	    {
        		List<CriteriaCO> list = criteriaBO.dependencyByScoreValue(criteriaCO);
        		
        		if(criteriaCO.getCtsCriteriaVO() == null)
			{
			    criteriaCO.setCtsCriteriaVO(new CTS_CRITERIAVO());
			}
			
			criteriaCO.getCtsCriteriaVO().setSCORE(scoreValue);
			
        		for(int i = 0 ; i < list.size(); i++)
        		{
        		    cifControlDefineScoreRangeVO = list.get(i).getCifcontrolDefineScoreRangeVO();
        		    
        		    if(criteriaCO != null && cifControlDefineScoreRangeVO != null)
        		    {
        			
        			
        			if(i == 0 && scoreValue.compareTo(cifControlDefineScoreRangeVO.getFROM_SCORE()) < 0)
        			{
        			    criteriaCO.getCtsCriteriaVO().setSCORE(cifControlDefineScoreRangeVO.getFROM_SCORE());
        			}
        			
        			if(i == (list.size() - 1) && scoreValue.compareTo(cifControlDefineScoreRangeVO.getTO_SCORE()) > 0)
        			{
        			    criteriaCO.getCtsCriteriaVO().setSCORE(cifControlDefineScoreRangeVO.getTO_SCORE());
        			}
        		    }
        		}
        	    }
        	    
        	}
        	catch(Exception e)
        	{
        	    handleException(e, null, null);
        	}
        
        	return SUCCESS;
    
        }
	
	public List<SelectCO> getCriteriaUsageList()
	{
		return criteriaUsageList;
	}

	public void setCriteriaUsageList(List<SelectCO> criteriaUsageList)
	{
		this.criteriaUsageList = criteriaUsageList;
	}

	/**
	 * @param criteriaBO
	 *            the criteriaBO to set
	 */
	public void setCriteriaBO(CriteriaBO criteriaBO)
	{
		this.criteriaBO = criteriaBO;
	}

	public CriteriaCO getCriteriaCO()
	{
		return criteriaCO;
	}

	public void setCriteriaCO(CriteriaCO criteriaCO)
	{
		this.criteriaCO = criteriaCO;
	}

	public List<CriteriaParamCO> getCriteriaParamCOList()
	{
		return criteriaParamCOList;
	}

	public void setCriteriaParamCOList(List<CriteriaParamCO> criteriaParamCOList)
	{
		this.criteriaParamCOList = criteriaParamCOList;
	}

	public CriteriaSC getCriteriaSC()
	{
		return criteriaSC;
	}

	public void setCriteriaSC(CriteriaSC criteriaSC)
	{
		this.criteriaSC = criteriaSC;
	}

	public String getUpdate1()
	{
		return update1;
	}

	public void setUpdate1(String update1)
	{
		this.update1 = update1;
	}

	public List<SelectCO> getSessionAttrList()
	{
		return sessionAttrList;
	}

	public void setSessionAttrList(List<SelectCO> sessionAttrList)
	{
		this.sessionAttrList = sessionAttrList;
	}

	public String get_entityType()
	{
		return _entityType;
	}

	public void set_entityType(String _entityType)
	{
		this._entityType = _entityType;
	}

	public String getPopupMode()
	{
		return popupMode;
	}

	public void setPopupMode(String popupMode)
	{
		this.popupMode = popupMode;
	}

	public String getJsonMultiselectArray() {
		return jsonMultiselectArray;
	}

	public void setJsonMultiselectArray(String jsonMultiselectArray) {
		this.jsonMultiselectArray = jsonMultiselectArray;
	}

	public BigDecimal get_lineNo() {
		return _lineNo;
	}

	public void set_lineNo(BigDecimal _lineNo) {
		this._lineNo = _lineNo;
	}

	public String get_disabled() {
		return _disabled;
	}

	public void set_disabled(String _disabled) {
		this._disabled = _disabled;
	}

}
