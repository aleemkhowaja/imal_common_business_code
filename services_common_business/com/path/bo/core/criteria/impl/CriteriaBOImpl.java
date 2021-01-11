package com.path.bo.core.criteria.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.criteria.CriteriaBO;
import com.path.bo.core.criteria.CriteriaConstant;
import com.path.bo.reporting.CommonReportingBO;
import com.path.dao.core.criteria.CriteriaDAO;
import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.remote.RmiServiceCaller;
import com.path.vo.common.CheckRequiredCO;
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

public class CriteriaBOImpl extends RetailBaseBO implements CriteriaBO
{

	private CriteriaDAO criteriaDAO;

	private CriteriaCO criteriaCO = new CriteriaCO();
	// private CriteriaSC criteriaSC = new CriteriaSC();
	// String procName;

	/**
	 * @param criteriaDAO
	 *            the criteriaDAO to set
	 */
	public void setCriteriaDAO(CriteriaDAO criteriaDAO)
	{
		this.criteriaDAO = criteriaDAO;
	}

	/**
	 * @return the criteriaDAO
	 */
	public CriteriaDAO getCriteriaDAO()
	{
		return criteriaDAO;
	}

	public List<CriteriaCO> returnCriteriaList(CriteriaSC criteriaSC) throws BaseException
	{
		return criteriaDAO.returnCriteriaList(criteriaSC);
	}

	public Integer returnCriteriaListCount(CriteriaSC criteriaSC) throws BaseException
	{
		return criteriaDAO.returnCriteriaListCount(criteriaSC);
	}

	public CriteriaCO returnCriteriaDetails(CriteriaSC criteriaSC) throws BaseException
	{

		criteriaCO = criteriaDAO.returnCriteriaDetails(criteriaSC);

		if (!NumberUtil.isEmptyDecimal(criteriaSC.getCRITERIA_CODE()))
		{

			applyDynScreenDisplay(CriteriaConstant.CRITERIA_CODE, ConstantsCommon.ACTION_TYPE_READONLY, "1", criteriaCO.getHm(), null);
		}

		// Rania - 718813 - Dynamic Customer Scoring on latest
		if (criteriaCO.getCtsCriteriaVO().getCRITERIA_USAGE().equals("O"))
		{
			applyDynScreenDisplay(CriteriaConstant.SCORE, ConstantsCommon.ACTION_TYPE_VISIBLE, "1", criteriaCO.getHm(), null);
		}
		else
		{
			applyDynScreenDisplay(CriteriaConstant.SCORE, ConstantsCommon.ACTION_TYPE_VISIBLE, "0", criteriaCO.getHm(), null);
		}
		// End Rania

		return criteriaCO;

	}

	public int returnProcedureListCount(CriteriaSC criteriaSC) throws BaseException
	{
		return criteriaDAO.returnProcedureListCount(criteriaSC);
	}

	public List returnProcedureList(CriteriaSC criteriaSC) throws BaseException
	{
		return criteriaDAO.returnProcedureList(criteriaSC);
	}

	// public void checkIfProcedureCanDeleted(CriteriaCO criteriaCO) throws
	// BaseException
	// {
	// if(!NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getCODE())
	// &&
	// !NumberUtil.isEmptyDecimal(criteriaCO.getProcedureIdCO().getCtsCriteriaVO().getLINE_NO()))
	// {
	// CriteriaSC criteriaSC = new CriteriaSC();
	// criteriaSC.setCompCode(criteriaCO.getLoginCompCode());
	// criteriaSC.setProcLineNo(criteriaCO.getProcedureIdCO().getCtsCriteriaVO().getLINE_NO());
	//
	// }
	// }

	public void saveProcedures(ArrayList<ProcedureIdCO> procedureIdCOs) throws BaseException
	{

		String schemaCodeSecond;
		String schemaCodeFirst;
		if (procedureIdCOs == null || procedureIdCOs.isEmpty())
		{
			throw new BOException(MessageCodes.VALUES_MISSING);
		}
		for (int i = 0; i < procedureIdCOs.size(); i++)
		{
			if (procedureIdCOs.get(i).getProcNames() == null || procedureIdCOs.get(i).getProcNames().isEmpty())
			{
				throw new BOException(MessageCodes.VALUES_MISSING);
			}

			for (int j = i + 1; j < procedureIdCOs.size(); j++)
			{
				schemaCodeFirst = procedureIdCOs.get(i).getProcNames();
				schemaCodeSecond = procedureIdCOs.get(j).getProcNames();
				if (schemaCodeFirst.compareTo(schemaCodeSecond) == 0)
				{
					throw new BOException(MessageCodes.DUPLICATE_VALUE);
				}
			}
		}

		for (int i = 0; i < procedureIdCOs.size(); i++)
		{
			String procedureName = procedureIdCOs.get(i).getProcNames();
			String procedureDesc = procedureIdCOs.get(i).getProcDesc();

			int procCode = criteriaDAO.returnProcValue(procedureName);

			if (procCode == 1)
			{

				throw new BOException(MessageCodes.DUPLICATE_VALUE);

			}

			else
			{
				String tableName = "CTS_PROC";

				// get the counter value
				Integer id = criteriaDAO.retCounterVal(tableName);
				if(id == null)
				{
					criteriaDAO.insertCounter(tableName);
					id = 1;
				}
				else
				{
					criteriaDAO.updateCounter(tableName);
				}
				
				ProcedureIdCO procedureIdCO = new ProcedureIdCO();
				procedureIdCO.setProcId(new BigDecimal(id));
				procedureIdCO.setProcNames(procedureName);
				procedureIdCO.setProcDesc(procedureDesc);
				criteriaDAO.saveProcedureDetails(procedureIdCO);
				// genericDAO.commitTransaction();
			}

		}

	}

	public void checkData(CriteriaCO criteriaCO) throws BaseException
	{

//		if (NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE()))
//		{
//			throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "criteria_code_key" });
//		}
		//bug 969312
		CheckRequiredCO checkRequiredCO = new CheckRequiredCO();
		/**
		 * Check Required Management ...
		 */
		checkRequiredCO.setCompCode(criteriaCO.getLoginCompCode());
		checkRequiredCO.setObj_value(criteriaCO);
		checkRequiredCO.setApp(criteriaCO.getAppName());
		checkRequiredCO.setOpt(criteriaCO.getOpt());
		checkRequiredCO.setLanguage(criteriaCO.getLoginPreferrredLanguage());
		commonLibBO.checkRequired(checkRequiredCO);
		//bug 969312
//		if (!StringUtil.isNotEmpty(criteriaCO.getCtsCriteriaVO().getCRITERIA_DESC()))
//		{
//			throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "description_English_key" });
//		}

		// if(NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getQUERY_ID()))
		// {
		// throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "query_id_key" });
		// }

	}

	public CriteriaCO saveCriteria(CriteriaCO criteriaCO) throws BaseException
	{

		Boolean isNew = false;
		
		checkData(criteriaCO);
//		NumberUtil.resetEmptyValues(criteriaCO);

		List<CriteriaParamCO> lstProc = criteriaCO.getCriteriaProcParamCOLst();
		List<CriteriaParamCO> lstQuery = criteriaCO.getCriteriaQueryParamCOLst();

		// Rania - 718813 - Dynamic Customer Scoring on latest
		if ("O".equals(criteriaCO.getCtsCriteriaVO().getCRITERIA_USAGE()) && NumberUtil.emptyDecimalToNull(criteriaCO.getCtsCriteriaVO().getSCORE()) == null)
		{
			throw new BOException(MessageCodes.MISSING_SCORE);
		}
		// End Rania
		
		// Rania - ABSAI180073 - FICA Risk Matrix calculation
    	if(NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getPROCEDURE_ID())
    		&& NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getQUERY_ID()))
    	{
    	    throw new BOException(MessageCodes.VALUES_MISSING);
    	}
    	//
		
		if (!NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getPROCEDURE_ID()))
		{
			// by bilal for BUG#974752
			CriteriaSC criteriaSC = new CriteriaSC();
			criteriaSC.setEntityName(criteriaCO.getProcedureIdCO().getProcName());
			int countArgPrc = criteriaDAO.getArgumentPrcId(criteriaSC);
			if ((lstProc == null || lstProc.isEmpty()) && countArgPrc > 0) {
				throw new BOException(MessageCodes.INVALID_MISSING_PROCEDURE_ARGUMENT);
			}
			// end bilal
		}

		if (!NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getQUERY_ID()))
		{
			//by bilal for BUG#974752
			CriteriaSC criteriaSC = new CriteriaSC();
			criteriaSC.setQueryId(criteriaCO.getCtsCriteriaVO().getQUERY_ID());
			int countArgQry = criteriaDAO.getArgumentQueryId(criteriaSC);
			if((lstQuery == null || lstQuery.isEmpty()) && countArgQry > 0 )
			{
				throw new BOException(MessageCodes.INVALID_MISSING_QUERY_ARGUMENT);
			}
			//end bilal
		}
		
		//BMO180147 - Risk Assessment of customers on the basis of products, services and geographic locations
		if (NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getPROCEDURE_ID()) && NumberUtil.isEmptyDecimal(criteriaCO.getCtsCriteriaVO().getQUERY_ID()))
		{
			throw new BOException(MessageCodes.VALUES_MISSING);
		}
		//
	        //By Bilal For TP#750884 replace param
    	if ((lstProc != null && !lstProc.isEmpty()) || (lstQuery != null && !lstQuery.isEmpty()))
		{
    		criteriaCO.setENTITY_TYPE("M");
			criteriaDAO.deleteCriteriaParam(criteriaCO);
		}
        	
		if (lstProc != null && !lstProc.isEmpty())
		{
			List<CriteriaParamCO> lstSelectParam; //By Bilal For TP#750884
			criteriaCO.setENTITY_TYPE("P");
			criteriaDAO.deleteCriteriaParam(criteriaCO);
			for (int i = 0; i < lstProc.size(); i++)
			{
				//by bilal for BUG#974272
				if (lstProc.get(i).getCtsCriteriaParamVO().getPARAM_CLASS() == null || lstProc.get(i).getCtsCriteriaParamVO().getPARAM_CLASS().isEmpty() || "1".equals(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_CLASS()))
				{
					throw new BOException(MessageCodes.INVALID_MISSING_PROCEDURE_ARGUMENT);
				}

				if ("F".equals(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
						&& (!StringUtil.isNotEmpty(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_VALUE())))
				{
					throw new BOException(MessageCodes.VALUES_MISSING);
				}

				if ("S".equals(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
						&& (!StringUtil.isNotEmpty(lstProc.get(i).getCtsCriteriaParamVO().getSESSION_ATTR_NAME())))
				{
					throw new BOException(MessageCodes.VALUES_MISSING);
				}
				
				//By Bilal For TP#750884
				if ("Q".equals(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
						&& (NumberUtil.isEmptyDecimal(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_QUERY_ID())))
				{
					throw new BOException(MessageCodes.VALUES_MISSING);
				}
				
				//By Bilal For TP#750884
				criteriaCO.setQueryParamId(lstProc.get(i).getOldQueryIdParam());
				criteriaDAO.deleteOldListSelected(criteriaCO);

				// if("F".equals(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
				// &&
				// (lstProc.get(i).getCtsCriteriaParamVO().getSESSION_ATTR_NAME()
				// != null ))
				// {
				// throw new
				// BOException(MessageCodes.INVALID_ENTRY_CANNOT_PROCEED);
				// }

				lstProc.get(i).getCtsCriteriaParamVO().setCOMP_CODE(criteriaCO.getLoginCompCode());
				lstProc.get(i).getCtsCriteriaParamVO().setBRANCH_CODE(criteriaCO.getLoginBraCode());
				lstProc.get(i).getCtsCriteriaParamVO().setCRITERIA_CODE(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE());
				lstProc.get(i).getCtsCriteriaParamVO().setENTITY_TYPE("P");
				lstProc.get(i).getCtsCriteriaParamVO().setENTITY_ID(criteriaCO.getCtsCriteriaVO().getPROCEDURE_ID());
				lstProc.get(i).getCtsCriteriaParamVO().setLINE_NO(BigDecimal.valueOf(i + 1));
				
				//By Bilal For TP#750884
				if(CriteriaConstant.PARAM_CLASS_S.equals(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_CLASS()))
				{
					
				}
				
				genericDAO.insert(lstProc.get(i).getCtsCriteriaParamVO());
				
				//By Bilal For TP#750884
				if(CriteriaConstant.PARAM_CLASS_Q.equals(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_CLASS()))
				{
					//By Bilal For TP#750884 replace param
					lstSelectParam = lstProc.get(i).getCriteriaQuerySelectParamCOLst();
					//By Bilal For TP#750884 for Replace Param of Query Multi Select
//					if (lstSelectParam != null && !lstSelectParam.isEmpty())
//					{
//						criteriaCO.setENTITY_TYPE("M");
//						criteriaDAO.deleteCriteriaParam(criteriaCO);
//					}
					for (int j = 0; j < lstSelectParam.size(); j++)
					{
						lstSelectParam.get(j).getCtsCriteriaParamVO().setCOMP_CODE(criteriaCO.getLoginCompCode());
						lstSelectParam.get(j).getCtsCriteriaParamVO().setBRANCH_CODE(criteriaCO.getLoginBraCode());
						lstSelectParam.get(j).getCtsCriteriaParamVO().setCRITERIA_CODE(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE());
						lstSelectParam.get(j).getCtsCriteriaParamVO().setENTITY_TYPE("M");
						lstSelectParam.get(j).getCtsCriteriaParamVO().setENTITY_ID(criteriaCO.getCtsCriteriaVO().getPROCEDURE_ID());
						lstSelectParam.get(j).getCtsCriteriaParamVO().setLINE_NO(BigDecimal.valueOf(lstProc.size() + j + 1));
						lstSelectParam.get(j).getCtsCriteriaParamVO().setPARAM_CLASS("F");
						lstSelectParam.get(j).getCtsCriteriaParamVO().setPARAM_QUERY_ID(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_QUERY_ID());
						genericDAO.insert(lstSelectParam.get(j).getCtsCriteriaParamVO());
					}
					//end
					
					criteriaCO.setENTITY_TYPE("P");
					for (int j = 0; j < lstProc.get(i).getLstMultiSelect().size(); j++)
					{
						BigDecimal lineNo = BigDecimal.valueOf(getMaxLineNo(new CriteriaSC()));
						lstProc.get(i).getLstMultiSelect().get(j).setLINE_NO(lineNo);
						lstProc.get(i).getLstMultiSelect().get(j).setQUERY_PARAM_ID(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_QUERY_ID());
						lstProc.get(i).getLstMultiSelect().get(j).setPARAM_NAME(lstProc.get(i).getCtsCriteriaParamVO().getPARAM_NAME());
						lstProc.get(i).getLstMultiSelect().get(j).setPARAM_ENTITY_TYPE(criteriaCO.getENTITY_TYPE());
						genericDAO.insert(lstProc.get(i).getLstMultiSelect().get(j));
					}
				}
			}
		}
		//
		// for(int i = 0; i < lstQuery.size(); i++)
		// {
		//
		// if(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_VALUE() == null
		// ||
		// lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_VALUE().isEmpty())
		// {
		//
		// throw new BOException(MessageCodes.VALUES_MISSING);
		//
		// }
		//
		// if("D".equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
		// && (lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_VALUE() == null
		// ||
		// lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_VALUE().isEmpty()))
		// {
		// throw new BOException(MessageCodes.VALUES_MISSING);
		// }
		//
		// if("S".equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
		// && (lstQuery.get(i).getCtsCriteriaParamVO().getSESSION_ATTR_NAME() ==
		// null
		// ||
		// lstQuery.get(i).getCtsCriteriaParamVO().getSESSION_ATTR_NAME().isEmpty()))
		// {
		// throw new BOException(MessageCodes.VALUES_MISSING);
		// }
		//
		// if("S".equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
		// && (lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_VALUE() !=
		// null))
		// {
		// throw new BOException(MessageCodes.INVALID_ENTRY_CANNOT_PROCEED);
		// }
		//
		// if("D".equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
		// && (lstQuery.get(i).getCtsCriteriaParamVO().getSESSION_ATTR_NAME() !=
		// null))
		// {
		// throw new BOException(MessageCodes.INVALID_ENTRY_CANNOT_PROCEED);
		// }
		//
		// lstQuery.get(i).getCtsCriteriaParamVO().setCOMP_CODE(criteriaCO.getLoginCompCode());
		// lstQuery.get(i).getCtsCriteriaParamVO().setBRANCH_CODE(criteriaCO.getLoginBraCode());
		// lstQuery.get(i).getCtsCriteriaParamVO().setCRITERIA_CODE(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE());
		// lstQuery.get(i).getCtsCriteriaParamVO().setENTITY_TYPE("P");
		// lstQuery.get(i).getCtsCriteriaParamVO().setENTITY_ID(criteriaCO.getCtsCriteriaVO().getPROCEDURE_ID());
		//
		// genericDAO.insert(lstQuery.get(i).getCtsCriteriaParamVO());
		//
		// }
		
		if (lstQuery != null && !lstQuery.isEmpty())
		{
			List<CriteriaParamCO> lstSelectParam; //By Bilal For TP#750884
			criteriaCO.setENTITY_TYPE("Q");
			criteriaDAO.deleteCriteriaParam(criteriaCO);
			
			for (int i = 0; i < lstQuery.size(); i++)
			{
				//by bilal for BUG#974272
				if (lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS() == null || lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS().isEmpty() || "1".equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS()))
				{
					throw new BOException(MessageCodes.INVALID_MISSING_QUERY_ARGUMENT);
				}

				if ("F".equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
						&& (!StringUtil.isNotEmpty(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_VALUE())))
				{
					throw new BOException(MessageCodes.VALUES_MISSING);
				}

				if ("S".equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
						&& (!StringUtil.isNotEmpty(lstQuery.get(i).getCtsCriteriaParamVO().getSESSION_ATTR_NAME())))
				{
					throw new BOException(MessageCodes.VALUES_MISSING);
				}
				//By Bilal For TP#750884
				if ("Q".equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS())
						&& (NumberUtil.isEmptyDecimal(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_QUERY_ID())))
				{
					throw new BOException(MessageCodes.VALUES_MISSING);
				}
				
				//By Bilal For TP#750884 Delete then insert from Mapping table
//				if(CriteriaConstant.PARAM_CLASS_Q.equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS()))
//				{
					criteriaCO.setQueryParamId(lstQuery.get(i).getOldQueryIdParam());
					criteriaDAO.deleteOldListSelected(criteriaCO);
				//}
				
				
				lstQuery.get(i).getCtsCriteriaParamVO().setCOMP_CODE(criteriaCO.getLoginCompCode());
				lstQuery.get(i).getCtsCriteriaParamVO().setBRANCH_CODE(criteriaCO.getLoginBraCode());
				lstQuery.get(i).getCtsCriteriaParamVO().setCRITERIA_CODE(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE());
				lstQuery.get(i).getCtsCriteriaParamVO().setENTITY_TYPE("Q");
				lstQuery.get(i).getCtsCriteriaParamVO().setENTITY_ID(criteriaCO.getCtsCriteriaVO().getQUERY_ID());
				lstQuery.get(i).getCtsCriteriaParamVO().setLINE_NO(BigDecimal.valueOf(i + 1));
				genericDAO.insert(lstQuery.get(i).getCtsCriteriaParamVO());
				
				//By Bilal For TP#750884
				if(CriteriaConstant.PARAM_CLASS_Q.equals(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_CLASS()))
				{
					//By Bilal For TP#750884 b*b replace param
					lstSelectParam = lstQuery.get(i).getCriteriaQuerySelectParamCOLst();
					//By Bilal For TP#750884 b*b for Replace Param of Query Multi Select
//					if (lstSelectParam != null && !lstSelectParam.isEmpty())
//					{
//						criteriaCO.setENTITY_TYPE("M");
//						criteriaDAO.deleteCriteriaParam(criteriaCO);
//					}
					for (int j = 0; j < lstSelectParam.size(); j++)
					{
						lstSelectParam.get(j).getCtsCriteriaParamVO().setCOMP_CODE(criteriaCO.getLoginCompCode());
						lstSelectParam.get(j).getCtsCriteriaParamVO().setBRANCH_CODE(criteriaCO.getLoginBraCode());
						lstSelectParam.get(j).getCtsCriteriaParamVO().setCRITERIA_CODE(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE());
						lstSelectParam.get(j).getCtsCriteriaParamVO().setENTITY_TYPE("M");
						lstSelectParam.get(j).getCtsCriteriaParamVO().setENTITY_ID(criteriaCO.getCtsCriteriaVO().getQUERY_ID());
						lstSelectParam.get(j).getCtsCriteriaParamVO().setLINE_NO(BigDecimal.valueOf(lstQuery.size() + j + 1));
						lstSelectParam.get(j).getCtsCriteriaParamVO().setPARAM_CLASS("F");
						lstSelectParam.get(j).getCtsCriteriaParamVO().setPARAM_QUERY_ID(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_QUERY_ID());
						genericDAO.insert(lstSelectParam.get(j).getCtsCriteriaParamVO());
					}
					//end
					
					criteriaCO.setENTITY_TYPE("Q");
					for (int j = 0; j < lstQuery.get(i).getLstMultiSelect().size(); j++)
					{
						BigDecimal lineNo = BigDecimal.valueOf(getMaxLineNo(new CriteriaSC()));
						lstQuery.get(i).getLstMultiSelect().get(j).setLINE_NO(lineNo);
						lstQuery.get(i).getLstMultiSelect().get(j).setQUERY_PARAM_ID(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_QUERY_ID());
						lstQuery.get(i).getLstMultiSelect().get(j).setPARAM_NAME(lstQuery.get(i).getCtsCriteriaParamVO().getPARAM_NAME());
						lstQuery.get(i).getLstMultiSelect().get(j).setPARAM_ENTITY_TYPE(criteriaCO.getENTITY_TYPE());
						genericDAO.insert(lstQuery.get(i).getLstMultiSelect().get(j));
					}
				}
			}
		}

		if ("false".equals(criteriaCO.getEditMode()))
		{
			isNew = true;
			criteriaCO.getCtsCriteriaVO().setCOMP_CODE(criteriaCO.getLoginCompCode());
			criteriaCO.getCtsCriteriaVO().setCREATED_BY(criteriaCO.getLoginUserId());
			Date dateToSetTime = criteriaCO.getRunningDate();
			criteriaCO.getCtsCriteriaVO().setDATE_CREATED(commonLibBO.addSystemTimeToDate(dateToSetTime));
			
			//commented/modified by bilal for BUG#973485
			//BigDecimal citeriaCode = BigDecimal.valueOf(criteriaDAO.returnMaxCriteriaCode(criteriaCO));//bug 969312
			
			criteriaCO.getCtsCriteriaVO().setCRITERIA_CODE(NumberUtil.nullEmptyToValue(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE(), BigDecimal.ONE));//bug 969312
			//end bilal
			
			genericDAO.insert(criteriaCO.getCtsCriteriaVO());
			auditBO.callAudit(null, criteriaCO.getCtsCriteriaVO(), criteriaCO.getAuditRefCO());// added by nour for 864398

		}

		else
		// update
		{
			// added by nour for 864398
						
			CriteriaCO oldCriteriaCO = new CriteriaCO();
			 oldCriteriaCO = (CriteriaCO) criteriaCO.getAuditObj();
			criteriaCO.setOldCtsCriteriaVO(oldCriteriaCO.getCtsCriteriaVO());
			// end nour
						
			//coreCommonBO.checkYrtPeriod(criteriaCO.getLoginCompCode(), criteriaCO.getLoginBraCode(), criteriaCO.getRunningDate()); //Rania - Commented based on #837478
			criteriaCO.getCtsCriteriaVO().setMODIFIED_BY(criteriaCO.getLoginUserId());
			Date dateToSetTime = criteriaCO.getRunningDate();
			criteriaCO.getCtsCriteriaVO().setCOMP_CODE(criteriaCO.getLoginCompCode());
			criteriaCO.getCtsCriteriaVO().setDATE_MODIFIED(commonLibBO.addSystemTimeToDate(dateToSetTime));
			int result = genericDAO.update(criteriaCO.getCtsCriteriaVO());
			if (result <= 0)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
			
			// added by nour for 864398
			NumberUtil.resetEmptyValues(criteriaCO.getCtsCriteriaVO());
			auditBO.callAudit(criteriaCO.getOldCtsCriteriaVO(), criteriaCO.getCtsCriteriaVO(), criteriaCO.getAuditRefCO());
			auditBO.insertAudit(criteriaCO.getAuditRefCO());
			// end nour
					
						
		}

		return criteriaCO;

	}
	//By Bilal For TP#750884
	public Integer getMaxLineNo(CriteriaSC criteriaSC) throws BaseException
	{
		int lineNo = 0;
		
		lineNo = NumberUtil.nullToZero(criteriaDAO.getMaxLineNo(criteriaSC));
		
		lineNo++;
		
		return lineNo;
	}

	public void dependencyByCriteriaCode(CriteriaCO criteriaCO) throws BaseException
	{

		if (BigDecimal.ZERO.compareTo(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE()) > 0 
			|| BigDecimal.ZERO.compareTo(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE()) == 0 )
		{
			throw new BOException(MessageCodes.CANNOT_BE_LESS_EQUAL_TO_ZERO);
		}
		else
		{
			int count = criteriaDAO.checkduplicateCriteriaCode(criteriaCO);
			if (count > 0)
			{
				throw new BOException(MessageCodes.DUPLICATE_VALUE);
			}
		}
	}

	public List<CriteriaParamCO> returnCriteriaParamList(CriteriaSC criteriaSC) throws BaseException
	{
		List<CriteriaParamCO> list = new ArrayList<CriteriaParamCO>();
		if ("P".equals(criteriaSC.getENTITY_TYPE()))
		{
			list = returnCriteriaParamListResult(criteriaSC);
		}
		else if ("Q".equals(criteriaSC.getENTITY_TYPE()) || "M".equals(criteriaSC.getENTITY_TYPE())) //By Bilal For TP#750884
		{
			if (!NumberUtil.isEmptyDecimal(criteriaSC.getENTITY_ID()))
			{
				try
				{
					String reportUrl;

					reportUrl = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "reporting.serviceURL");
					if (reportUrl == null)
					{
						throw new BOException("Invalid reporting URL");
					}
					String checkReportingUrlService = reportUrl.concat("commonReportingBOService");
					CommonReportingBO commonReportingBO = (CommonReportingBO) RmiServiceCaller.returnRmiInterface(checkReportingUrlService,
							CommonReportingBO.class);
					
					BigDecimal entityId = criteriaSC.getENTITY_ID();
					HashMap<String, Object> hashIn = new HashMap<String, Object>();
					hashIn.put("queryId", entityId);
					ArrayList<HashMap<String, Object>> hashList = commonReportingBO.returnArgListByQryId(hashIn);
					if (hashList != null)
					{
						for (int i = 0; i < hashList.size(); i++)
						{
							if (commonLibBO.returnIsSybase() == 1)
							{

								criteriaSC.setParamName("@" + (String) hashList.get(i).get("argument_NAME"));
							}

							else
							{
								criteriaSC.setParamName((String) hashList.get(i).get("argument_NAME"));
							}
							CriteriaParamCO criteriaParamCO = returnArgumentDetailsResult(criteriaSC);
							if (criteriaParamCO == null)
							{
								criteriaParamCO = new CriteriaParamCO();
							}

							if (commonLibBO.returnIsSybase() == 1)
							{
								criteriaParamCO.getCtsCriteriaParamVO().setPARAM_NAME("@" + (String) hashList.get(i).get("argument_NAME"));
								criteriaParamCO.getCtsCriteriaParamVO().setPARAM_ORDER(new BigDecimal(i + 1));
							}

							else
							{
								criteriaParamCO.getCtsCriteriaParamVO().setPARAM_NAME((String) hashList.get(i).get("argument_NAME"));
								criteriaParamCO.getCtsCriteriaParamVO().setPARAM_ORDER(new BigDecimal(i + 1));
							}

							criteriaParamCO.getCtsCriteriaParamVO().setPARAM_TYPE((String) hashList.get(i).get("argument_TYPE"));
							
							//end By Bilal For TP#750884
							

							list.add(criteriaParamCO);

						}
					}
				}
				catch (Exception e)
				{

					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public List<CriteriaParamCO> returnCriteriaParamListResult(CriteriaSC criteriaSC) throws BaseException
	{
		return criteriaDAO.returnCriteriaParamList(criteriaSC);
	}

	public CriteriaParamCO returnArgumentDetailsResult(CriteriaSC criteriaSC) throws BaseException
	{
		return criteriaDAO.returnArgumentDetails(criteriaSC);
	}

	public Integer returnCriteriaParamListCount(CriteriaSC criteriaSC) throws BaseException
	{
		return criteriaDAO.returnCriteriaParamListCount(criteriaSC);
	}

	public void returnCountCriteriaLinkSegment(CriteriaCO criteriaCO) throws BaseException
	{
		int count = criteriaDAO.returnCountCriteriaLinkSegment(criteriaCO);
		
		if(count > 0)
		{
			throw new BOException(MessageCodes.CANNOT_CHANGE_USAGE_CRITERIA_LINKED_TO_SEGMENT); //need to change to handle case busines rule.
		}
	}
	
	/**
	 * @author RaniaAlBitar
	 * ABSAI180073 - FICA Risk Matrix calculation
	 */
	
	public List<CriteriaCO> dependencyByScoreValue(CriteriaCO criteriaCO) throws BaseException
	{
	    List<CriteriaCO> list = new ArrayList<CriteriaCO>();
	    
	    list = criteriaDAO.dependencyByScoreValue(criteriaCO);
	    
	    return list;
	}
	
	@Override
	public List<AML_PARAM_MAPPINGVO> returnQryMultiSelectList(CriteriaSC criteriaSC) throws BaseException {
		return criteriaDAO.returnQryMultiSelectList(criteriaSC);
	}

	@Override
	public Integer returnQryMultiSelectListCount(CriteriaSC criteriaSC) throws BaseException {
		return criteriaDAO.returnQryMultiSelectListCount(criteriaSC);
	}

	@Override
	public List<AML_PARAM_MAPPINGVO> loadMultiSelectListGrid(CriteriaSC criteriaSC) throws BaseException {
		return criteriaDAO.loadMultiSelectListGrid(criteriaSC);
	}

	@Override
	public List<CriteriaParamCO> returnReplaceArgumentSelect(CriteriaSC criteriaSC) throws BaseException {
		return criteriaDAO.returnReplaceArgumentSelect(criteriaSC);
	}

	@Override
	public List<CriteriaParamCO> returnArgumentSelectDetails(CriteriaSC criteriaSC) throws BaseException {
		List<CriteriaParamCO> list = new ArrayList<CriteriaParamCO>();
		List<CriteriaParamCO> list1 = new ArrayList<CriteriaParamCO>();
		list = criteriaDAO.returnArgumentSelectDetails(criteriaSC);
	
		return list;
	}
	
	@Override
	public void dependencyByCriteriaReference(CriteriaCO criteriaCO) throws BaseException
	{
		criteriaCO.getCtsCriteriaVO().setCRITERIA_CODE(NumberUtil.emptyDecimalToNull(criteriaCO.getCtsCriteriaVO().getCRITERIA_CODE()));
		Integer refCount = criteriaDAO.dependencyByCriteriaReference(criteriaCO);
		
		if(refCount > 0)
		{
			throw new BOException(MessageCodes.REFERENCE_ALREADY_IN_USE);
		}
	}

	@Override
	public Integer returnMaxCriteriaCode(CriteriaCO criteriaCO) throws BaseException {
		return criteriaDAO.returnMaxCriteriaCode(criteriaCO);
	}
}
