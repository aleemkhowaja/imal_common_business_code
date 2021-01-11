package com.path.bo.core.segmentation.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.amlcif.AmlCifBO;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.common.CoreCommonProcedureBO;
import com.path.bo.core.criteria.CriteriaBO;
import com.path.bo.core.criteria.CriteriaConstant;
import com.path.bo.core.procedureid.ProcedureIdBO;
import com.path.bo.core.queryid.QueryIdBO;
import com.path.bo.core.segmentation.CustSegmentationBO;
import com.path.bo.core.segmentation.CustSegmentationConstant;
import com.path.bo.reporting.CommonReportingBO;
import com.path.dao.core.segmentation.CustSegmentationDAO;
import com.path.dbmaps.vo.AML_CUSTOMERVO;
import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_CRITERIAVO;
import com.path.dbmaps.vo.CTS_SEGMENTVO;
import com.path.dbmaps.vo.CTS_SEGMENT_CIF_EXCLUDEVO;
import com.path.dbmaps.vo.CTS_SEGMENT_DETVOWithBLOBs;
import com.path.dbmaps.vo.CTS_SEGMENT_PARAMVO;
import com.path.dbmaps.vo.IRP_REP_ARGUMENTSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.expression.lib.util.DateUtil;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.remote.RmiServiceCaller;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.audit.TrackPropCO;
import com.path.vo.core.alerts.AlertsRequestParamSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.criteria.CriteriaParamCO;
import com.path.vo.core.criteria.CriteriaSC;
import com.path.vo.core.procedureid.ProcedureIdCO;
import com.path.vo.core.procedureid.ProcedureIdSC;
import com.path.vo.core.queryid.QueryIdCO;
import com.path.vo.core.queryid.QueryIdSC;
import com.path.vo.core.segmentation.CustSegmentationCO;
import com.path.vo.core.segmentation.CustSegmentationParamCO;
import com.path.vo.core.segmentation.CustSegmentationProcessCO;
import com.path.vo.core.segmentation.CustSegmentationSC;
import com.path.vo.core.segmentation.ExcludeCIFSC;
import com.rits.cloning.Cloner;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * CustSegmentationBOImpl.java used to
 */
public class CustSegmentationBOImpl extends BaseBO implements CustSegmentationBO
{

	private CustSegmentationDAO custSegmentationDAO;
	private CriteriaBO criteriaBO;
	private ProcedureIdBO procedureIdBO;
	private CoreCommonProcedureBO coreCommonProcedureBO;
	private CifBO cifBO;
	private QueryIdBO queryIdBO;
	private AmlCifBO amlCifBO;// added by nour for 777000
	private AlertsBO alertsBO;

	/**
	 * Method used to return Count of CustSegmentation
	 * 
	 * @param criteria
	 *            Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws BaseException
	 */
	public int returnCustSegmentationListCount(CustSegmentationSC criteria) throws BaseException
	{
		return custSegmentationDAO.returnCustSegmentationListCount(criteria);
	}

	/**
	 * Method used to return List of CustSegmentation
	 * 
	 * @param criteria
	 *            Search Criteria Parameter
	 * @return List Result
	 * @throws BaseException
	 */
	public List returnCustSegmentationList(CustSegmentationSC criteria) throws BaseException
	{
		return custSegmentationDAO.returnCustSegmentationList(criteria);
	}

	public CustSegmentationCO returnCustSegmentationForm(CustSegmentationSC custSegmentationSC) throws BaseException
	{

		CustSegmentationCO custSegmentationCO = custSegmentationDAO.returnCustSegmentationForm(custSegmentationSC);
		// added by nour
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(custSegmentationCO.getLoginCompCode());
		reqFieldSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		reqFieldSC.setProgRef(custSegmentationCO.getProgRef());
		reqFieldSC.setAppName(custSegmentationCO.getAppName());

		if ((CustSegmentationConstant.MAINT.equalsIgnoreCase(custSegmentationSC.getCrudMode())
				&& (CustSegmentationConstant.STATUS_SUSPEND.equals(custSegmentationCO.getCtsSegmentVO().getSTATUS())
						|| CustSegmentationConstant.SUSPEND.equals(custSegmentationCO.getCtsSegmentVO().getSTATUS())
						|| CustSegmentationConstant.STATUS_REACTIVATE.equals(custSegmentationCO.getCtsSegmentVO().getSTATUS())))
				|| CustSegmentationConstant.SUSPEND.equalsIgnoreCase(custSegmentationSC.getCrudMode())
				|| CustSegmentationConstant.APPROVE_SUSPEND.equalsIgnoreCase(custSegmentationSC.getCrudMode())
				|| CustSegmentationConstant.REACTIVATE.equalsIgnoreCase(custSegmentationSC.getCrudMode())
				|| CustSegmentationConstant.APPROVE_REACTIVATE.equalsIgnoreCase(custSegmentationSC.getCrudMode())

		)
		{
			String readony;

			if (CustSegmentationConstant.SUSPEND.equalsIgnoreCase(custSegmentationSC.getCrudMode()))
			{
				readony = ConstantsCommon.ZERO;
			}
			else
			{
				readony = ConstantsCommon.ONE;
			}

			applyDynScreenDisplay(new String[] { "suspend_reason" }, ConstantsCommon.ACTION_TYPE_READONLY, readony,
					custSegmentationCO.getScreenParam(), reqFieldSC);
			applyDynScreenDisplay(new String[] { "suspend_reason" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ONE,
					custSegmentationCO.getScreenParam(), reqFieldSC);
//			applyDynScreenDisplay(new String[] { "reasonName" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ONE, custSegmentationCO.getScreenParam(),
//					reqFieldSC);

//			applyDynScreenDisplay(new String[] { "lookuptxt_suspend_reason_ref" }, ConstantsCommon.ACTION_TYPE_READONLY, ConstantsCommon.ONE,
//					custSegmentationCO.getScreenParam(), reqFieldSC);
//			applyDynScreenDisplay(new String[] { "lookuptxt_suspend_reason_ref" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ONE,
//					custSegmentationCO.getScreenParam(), reqFieldSC);
//			applyDynScreenDisplay(new String[] { "reasonNameRef" }, ConstantsCommon.ACTION_TYPE_READONLY, ConstantsCommon.ONE,
//					custSegmentationCO.getScreenParam(), reqFieldSC);
//			applyDynScreenDisplay(new String[] { "reasonNameRef" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ONE,
//					custSegmentationCO.getScreenParam(), reqFieldSC);

		}
		else if ((CustSegmentationConstant.MAINT.equalsIgnoreCase(custSegmentationSC.getCrudMode())
				&& !(CustSegmentationConstant.STATUS_SUSPEND.equals(custSegmentationCO.getCtsSegmentVO().getSTATUS()))
				&& !(CustSegmentationConstant.SUSPEND.equals(custSegmentationCO.getCtsSegmentVO().getSTATUS())))

				|| (CustSegmentationConstant.APPROVE_CRUD.equals(custSegmentationSC.getCrudMode())))
		{

			applyDynScreenDisplay(new String[] { "suspend_reason" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ZERO,
					custSegmentationCO.getScreenParam(), reqFieldSC);
//			applyDynScreenDisplay(new String[] { "reasonName" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ZERO, custSegmentationCO.getScreenParam(),
//					reqFieldSC);

//			applyDynScreenDisplay(new String[] { "lookuptxt_suspend_reason_ref" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ZERO,
//					custSegmentationCO.getScreenParam(), reqFieldSC);
//			applyDynScreenDisplay(new String[] { "reasonNameRef" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ZERO,
//					custSegmentationCO.getScreenParam(), reqFieldSC);

		}

		if (CustSegmentationConstant.WEEKLY.equals(custSegmentationCO.getCtsSegmentVO().getPERIODICITY()))
		{
			applyDynScreenDisplay(new String[] { "day" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ONE, custSegmentationCO.getScreenParam(),
					reqFieldSC);// added by nour
			applyDynScreenDisplay(new String[] { "lbl_On" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ONE, custSegmentationCO.getScreenParam(),
					reqFieldSC);// added by nour
		}
		// end nour

		return custSegmentationCO;
	}

	public CustSegmentationCO dependencyBySegmentCode(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();

		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
		// custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		custSegmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		custSegmentationSC.setIsSegmentationScore(custSegmentationCO.getCtsSegmentVO().getSEGMENT_TYPE());
		
		if(!custSegmentationCO.getOpt().startsWith("DT00CE"))
		{
		    int numberOfSegments = custSegmentationDAO.dependencyBySegmentCode(custSegmentationSC);
    
		    if(numberOfSegments == 1)
		    {
			throw new BOException(MessageCodes.SEGMENT_CODE_ALREADY_EXISTS);
		    }
		}
		else
		{		    		    
		    custSegmentationCO.setCtsSegmentVO(custSegmentationDAO.returnSegmentCodeForDependency(custSegmentationSC));
		}
		return custSegmentationCO;
	}

	public List returnCustSegmentationDetailList(CustSegmentationSC criteria) throws BaseException
	{
		return custSegmentationDAO.returnCustSegmentationDetailList(criteria);
	}

	public int returnCustSegmentationDetailListCount(CustSegmentationSC criteria) throws BaseException
	{

		return custSegmentationDAO.returnCustSegmentationDetailListCount(criteria);
	}

	@Override
	public CustSegmentationCO saveNewSegment(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		NumberUtil.resetEmptyValues(custSegmentationCO.getCtsSegmentDetVO());
		// Added By Ali for TP#864398
		if (custSegmentationCO.getCtsSegmentVO().getSTATUS().equals(CustSegmentationConstant.STATUS_APPROVED))
		{
			CustSegmentationSC createria = new CustSegmentationSC();
			createria.setCompCode(custSegmentationCO.getLoginCompCode());
			createria.setIsSegmentationScore(CustSegmentationConstant.BUSINESS_RULES);
			custSegmentationCO.getCtsSegmentVO().setSTATUS(CustSegmentationConstant.STATUS_ACTIVE);
			int duplicateCode = custSegmentationDAO.getSegmentCodeMax(createria) + 1;
			BigDecimal dupCode = new BigDecimal(duplicateCode);

			custSegmentationCO.getCtsSegmentVO().setSEGMENT_CODE(dupCode);

		}

		Boolean newRecord = true;

		// RANIA CHECK
		/*
		 * if (custSegmentationCO.getParamIsOpen() == 0) {
		 * 
		 * throw new BOException(MessageCodes.CHECK_PARAMS_BEFORE_SAVING);
		 * 
		 * }
		 */

		/*
		 * ArrayList<BaseException> msgArr = new ArrayList<BaseException>(); if (custSegmentationCO.getGridAddList() == null ||
		 * custSegmentationCO.getGridAddList().isEmpty()) { msgArr.add(new BaseException(MessageCodes.NO_DATA_TO_SAVE_INSERT_RECORD)); }
		 * 
		 * if (!msgArr.isEmpty()) { throw new BOException(msgArr); }
		 */

		Integer countLeftOperator = 0, countRightOperator = 0, size = 0;
		validateBracketsNbr(custSegmentationCO, size, countLeftOperator, countRightOperator);

		// if there is no left operator are equal to right operator then insert
		// all rows
		BigDecimal lineNumber = new BigDecimal(1);

		totalPercentageValidation(custSegmentationCO); // Rania - 718813 - Dynamic Customer Scoring on latest

		CustSegmentationSC criteria = new CustSegmentationSC();

		if (custSegmentationCO.getGridAllList() != null)
		{
			List<CustSegmentationParamCO> custSegmentationParamListCO = new ArrayList<>();

			for (int i = 0; i < custSegmentationCO.getGridAllList().size(); i++)
			{
				if ("".equals(custSegmentationCO.getGridAllList().get(i).getQueryParamGridStr()))
				{
					criteria.setCompCode(custSegmentationCO.getLoginCompCode());
					criteria.setBranchCode(custSegmentationCO.getLoginBraCode());
					criteria.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());
					criteria.setCriteria_code(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
					criteria.setNbRec(-1);
					criteria.setENTITY_TYPE("Q");
					criteria.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());// By Bilal For TP#750884
					criteria.setLineNo(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getLINE_NO()); // By Bilal For TP#750884
					custSegmentationParamListCO = returnSegmentationParamList(criteria);
					custSegmentationCO.getGridAllList().get(i).setQueryParamCOList(custSegmentationParamListCO);
				}
				else
				{
					custSegmentationParamListCO = custSegmentationCO.getGridAllList().get(i).getQueryParamCOList();

					if (custSegmentationParamListCO.size() > 0)
					{
						for (int j = 0; j < custSegmentationParamListCO.size(); j++)
						{
							/*
							 * if ("1".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())) { throw new
							 * BOException(MessageCodes.INVALID_MISSING_PROCEDURE_ARGUMENT); }
							 */
							if ("D".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}

							if ("F".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}

							if ("S".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}

							if ("1".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
							{
								throw new BOException(MessageCodes.INVALID_MISSING_QUERY_ARGUMENT);
							}

							if (("".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									|| custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS() == null)
									&& ("".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE())
											|| custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE() == null))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}
							// By Bilal For TP#750884
							if ("Q".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (NumberUtil.isEmptyDecimal(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_QUERY_ID())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}
						}
					}
				}

				if ("".equals(custSegmentationCO.getGridAllList().get(i).getProcParamGridStr()))
				{

					criteria.setCompCode(custSegmentationCO.getLoginCompCode());
					criteria.setBranchCode(custSegmentationCO.getLoginBraCode());
					criteria.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on latest
					criteria.setCriteria_code(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
					criteria.setNbRec(-1);
					criteria.setENTITY_TYPE("P");
					criteria.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());// By Bilal For TP#750884
					criteria.setLineNo(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getLINE_NO()); // By Bilal For TP#750884
					custSegmentationParamListCO = returnSegmentationParamList(criteria);
					custSegmentationCO.getGridAllList().get(i).setProcParamCOList(custSegmentationParamListCO); // By Bilal For TP#750884
				}
				else // By Bilal For TP#750884, add case else for proc Param
				{
					custSegmentationParamListCO = custSegmentationCO.getGridAllList().get(i).getProcParamCOList(); // By Bilal For TP#750884

					if (custSegmentationParamListCO.size() > 0)
					{
						for (int j = 0; j < custSegmentationParamListCO.size(); j++)
						{
							if ("1".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
							{
								throw new BOException(MessageCodes.INVALID_MISSING_PROCEDURE_ARGUMENT);
							}

							if ("F".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}

							if ("D".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}

							if ("S".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}
							// By Bilal For TP#750884
							if ("Q".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (NumberUtil.isEmptyDecimal(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_QUERY_ID())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}
						}
					}
				}
			}
		}

		updateSegmentationParam(custSegmentationCO, custSegmentationCO.getGridAllList(), "A");

		// Rania - 718813 - Dynamic Customer Scoring on latest
		/*if ("SC".equals(custSegmentationCO.getIsSegmentationScore()))
		{*/
			custSegmentationCO = processSegment(custSegmentationCO);
//		}
		// End Rania

		if (custSegmentationCO.getGridAllList() != null)
		{
			for (CustSegmentationCO rowCO : custSegmentationCO.getGridAllList())
			{
				NumberUtil.resetEmptyValues(rowCO);

				if (!NumberUtil.isEmptyDecimal(rowCO.getCtsSegmentDetVO().getCRITERIA_CODE()))
				{
					rowCO.getCtsSegmentDetVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
					rowCO.getCtsSegmentDetVO().setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
					rowCO.getCtsSegmentDetVO().setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
					rowCO.getCtsSegmentDetVO().setLINE_NO((lineNumber));
					rowCO.getCtsSegmentDetVO().setQUERY_DETAILS(rowCO.getCtsSegmentDetVO().getQUERY_DETAILS());
					rowCO.getCtsSegmentDetVO().setPROC_DETAILS(rowCO.getCtsSegmentDetVO().getPROC_DETAILS());// By Bilal For TP#750884
					lineNumber = lineNumber.add(new BigDecimal(1));

					rowCO.getCtsSegmentDetVO().setSEGMENT_TYPE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_TYPE());

					genericDAO.insert(rowCO.getCtsSegmentDetVO());
				}
				else
				{
					if (!CustSegmentationConstant.BUSINESS_RULES.equals(custSegmentationCO.getIsSegmentationScore())) // added by nour for #864398
					{
						throw new BOException(MessageCodes.CANNOT_SAVE_CRITERION_CODE_MISSING);
					}
					else if (CustSegmentationConstant.BUSINESS_RULES.equals(custSegmentationCO.getIsSegmentationScore()))
					{
						throw new BOException(MessageCodes.CANNOT_SAVE_BUSINESS_RULECRITERION_CODE_MISSING);

					}
				}
			}
		}

		// Commented since the user can add, many times, the same criterion

		// List<CustSegmentationCO> gridModel = new
		// ArrayList<CustSegmentationCO>();
		// gridModel = custSegmentationCO.getGridAllList();
		// if((gridModel.size() != 0))
		// {
		// checkDuplicateCriterion(gridModel, custSegmentationCO);
		// }

		CustSegmentationCO baseRecord = new CustSegmentationCO();

		baseRecord.getCtsSegmentVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
		baseRecord.getCtsSegmentVO().setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
		baseRecord.getCtsSegmentVO().setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		baseRecord.getCtsSegmentVO().setSEGMENT_DESC(custSegmentationCO.getCtsSegmentVO().getSEGMENT_DESC());
		// baseRecord.getCtsSegmentVO().setPRIORITY(custSegmentationCO.getCtsSegmentVO().getPRIORITY());

		// Added By Ali for TP#864398
		if (CustSegmentationConstant.BUSINESS_RULES.equals(custSegmentationCO.getIsSegmentationScore()))
		{
			baseRecord.getCtsSegmentVO().setLONG_DESC_ENG(custSegmentationCO.getCtsSegmentVO().getLONG_DESC_ENG());
			baseRecord.getCtsSegmentVO().setSTART_DATE(custSegmentationCO.getCtsSegmentVO().getSTART_DATE());
			baseRecord.getCtsSegmentVO().setEND_DATE(custSegmentationCO.getCtsSegmentVO().getEND_DATE());
		}

		// Added By Nour for TP#864398
		if (CustSegmentationConstant.BUSINESS_RULES.equals(custSegmentationCO.getIsSegmentationScore()))
		{
			baseRecord.getCtsSegmentVO().setPERIODICITY(custSegmentationCO.getCtsSegmentVO().getPERIODICITY());
			baseRecord.getCtsSegmentVO().setDAY(custSegmentationCO.getCtsSegmentVO().getDAY());
		}

		baseRecord.getCtsSegmentVO().setSTATUS(CustSegmentationConstant.STATUS_ACTIVE);
		baseRecord.getCtsSegmentVO().setCREATED_BY(custSegmentationCO.getLoginUserId());
		baseRecord.getCtsSegmentVO().setDATE_CREATED(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
		baseRecord.getCtsSegmentVO().setSEGMENT_TYPE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_TYPE()); // Rania - 718813 - Dynamic Customer Scoring
		baseRecord.getCtsSegmentVO().setGROUP_CODE(custSegmentationCO.getCtsSegmentVO().getGROUP_CODE());  //Rania - Customers Segmentation

																												// on latest
		baseRecord.getCtsSegmentVO().setMAIN_SCORE_YN(custSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()); // Rania - ABSAI180073
		// added by nour for bug 955568
		baseRecord.getCtsSegmentVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
		int count= custSegmentationDAO.returnMainScore(baseRecord);

		if((baseRecord.getCtsSegmentVO().getMAIN_SCORE_YN())!=null && ((baseRecord.getCtsSegmentVO().getMAIN_SCORE_YN()).equals(CustSegmentationConstant.CHECKED)&& count>=1))
		{
		  throw new BOException(MessageCodes.MAIN_SCORE_IS_ALREADY_CHECHED); // 7119
		}
		genericDAO.insert(baseRecord.getCtsSegmentVO());

		// Commented to save the exclude CIF when closign the popup
		// saveExcludeCifGrid(custSegmentationCO, newRecord);

		if (baseRecord != null)
		{
			custSegmentationCO.setAuditObj(custSegmentationCO.getCtsSegmentVO());
		}
		NumberUtil.resetEmptyValues(baseRecord.getCtsSegmentVO());

		custSegmentationCO.setCtsSegmentVO(baseRecord.getCtsSegmentVO());
		auditBO.callAudit(null, custSegmentationCO.getCtsSegmentVO(), custSegmentationCO.getAuditRefCO());// added by nour for 777000

		return custSegmentationCO;
	}

	/*
	 * save query and proc params
	 */
	private void updateSegmentationParam(CustSegmentationCO custSegmentationCO, List<CustSegmentationCO> segmentationParamList, String action)
			throws BaseException
	{
		if (segmentationParamList != null)
		{
			int nbOccurrence = 0, lineNumber1;
			BigDecimal lineNumber = BigDecimal.ZERO;
			BigDecimal lineNumber2 = BigDecimal.ZERO;

			if ("U".equals(action))
			{
				CustSegmentationSC segmentationSC = new CustSegmentationSC();
				segmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
				segmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
				segmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
				segmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());
				custSegmentationDAO.deleteSegmentationParamForAllLines(segmentationSC);
			}

			for (int i = 0; i < segmentationParamList.size(); i++)
			{
				List<CustSegmentationParamCO> custSegmentationParamListCO = new ArrayList<>();

				CustSegmentationSC criteria = new CustSegmentationSC();

				// By Bilal For TP#750884 Commented
				// if (!"true".equals(segmentationParamList.get(i).getSegmentationParamOpened())/* && "U".equals(action)*/)
				// {
				// criteria.setCompCode(custSegmentationCO.getLoginCompCode());
				// criteria.setBranchCode(custSegmentationCO.getLoginBraCode());
				// criteria.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore()); //Rania - 718813 - Dynamic Customer Scoring on latest
				// criteria.setCriteria_code(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
				// criteria.setNbRec(-1);
				// criteria.setENTITY_TYPE("Q");
				// custSegmentationParamListCO = returnSegmentationParamList(criteria);
				// }
				// By Bilal For TP#750884 end commented

				/*
				 * if (!"true".equals(segmentationParamList.get(i).getSegmentationParamOpened()) && "A".equals(action)) {
				 * criteria.setCompCode(custSegmentationCO.getLoginCompCode()); criteria.setBranchCode(custSegmentationCO.getLoginBraCode());
				 * criteria.setNbRec(-1);
				 * 
				 * /* if (!"true".equals(segmentationParamList.get(i).getSegmentationParamOpened()) && "A".equals(action)) {
				 * criteria.setCompCode(custSegmentationCO.getLoginCompCode()); criteria.setBranchCode(custSegmentationCO.getLoginBraCode());
				 * criteria.setNbRec(-1);
				 * 
				 * if (criteria.getProgRef() != null && criteria.getProgRef().contains("CSC00")) { criteria.setIsSegmentationScore("SC"); } else if
				 * (criteria.getProgRef() != null && criteria.getProgRef().contains("CSG00")) {
				 * criteria.setIsSegmentationScore(CustSegmentationConstant.SEGMENTATION); }
				 * 
				 * custSegmentationParamListCO = returnSegmentationParamList(criteria); }
				 */

				/*
				 * if ("true".equals(segmentationParamList.get(i).getSegmentationParamOpened())) {
				 */
				CTS_CRITERIAVO criteriaVO = new CTS_CRITERIAVO();
				criteriaVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
				criteriaVO.setCRITERIA_CODE(segmentationParamList.get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
				criteriaVO = (CTS_CRITERIAVO) genericDAO.selectByPK(criteriaVO);

				/*
				 * if ("U".equals(action)) { CustSegmentationSC segmentationSC = new CustSegmentationSC();
				 * segmentationSC.setCompCode(custSegmentationCO.getLoginCompCode()); segmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
				 * segmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
				 * segmentationSC.setLineNo(segmentationParamList.get(i).getCtsSegmentDetVO().getLINE_NO());
				 * segmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on
				 * latest custSegmentationDAO.deleteSegmentationParam(segmentationSC); }
				 */

				List<CustSegmentationParamCO> queryParamCOList = segmentationParamList.get(i).getQueryParamCOList();

				// By Bilal For TP#750884 Commented
				// if (!"true".equals(segmentationParamList.get(i).getSegmentationParamOpened()))
				// {
				// queryParamCOList = custSegmentationParamListCO;
				// }

				if (queryParamCOList != null && !queryParamCOList.isEmpty())
				{
					List<CustSegmentationParamCO> lstSelectParam; // By Bilal For TP#750884

					// By Bilal For TP#750884
					custSegmentationCO.setCriteriaCode(segmentationParamList.get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
					custSegmentationCO.setEntityTypeParam("Q");
					custSegmentationDAO.deleteOldListSelected(custSegmentationCO);

					for (int j = 0; j < queryParamCOList.size(); j++)
					{

						if ("1".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						{
							throw new BOException(MessageCodes.INVALID_MISSING_PROCEDURE_ARGUMENT);
						}

						if ("F".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
								&& (!StringUtil.isNotEmpty(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
						{
							throw new BOException(MessageCodes.VALUES_MISSING);
						}
						// Modified By Ali for TP#864398
						if (CustSegmentationConstant.SEGMENTATION.equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
								&& (!StringUtil.isNotEmpty(queryParamCOList.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME())))
						{
							throw new BOException(MessageCodes.VALUES_MISSING);
						}

						if (("".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
								|| queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS() == null)
								&& ("".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_VALUE())
										|| queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_VALUE() == null))
						{
							throw new BOException(MessageCodes.VALUES_MISSING);
						}

						// --
						//
						// if((CustSegmentationConstant.SEGMENTATION.equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
						// && StringUtil
						// .isEmptyString(queryParamCOList.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME()))
						// ||
						// (("D".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
						// ||
						// "F".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						// && StringUtil.isEmptyString(
						// queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
						// {
						// throw new
						// BOException(MessageCodes.INVALID_MISSING_QUERY_ARGUMENT);
						// }

						if ("1".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						{
							throw new BOException(MessageCodes.INVALID_MISSING_QUERY_ARGUMENT);
						}

						// By Bilal For TP#750884
						if ("Q".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
								&& (NumberUtil.isEmptyDecimal(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_QUERY_ID())))
						{
							throw new BOException(MessageCodes.VALUES_MISSING);
						}

						BigDecimal segLineNo = segmentationParamList.get(i).getCtsSegmentDetVO().getLINE_NO();

						queryParamCOList.get(j).getCtsSegmentParamVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
						queryParamCOList.get(j).getCtsSegmentParamVO().setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
						queryParamCOList.get(j).getCtsSegmentParamVO().setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
						queryParamCOList.get(j).getCtsSegmentParamVO().setENTITY_TYPE("Q");
						queryParamCOList.get(j).getCtsSegmentParamVO().setENTITY_ID(criteriaVO.getQUERY_ID());
						// +2 since the first segLineNo has 1 as value and not 0
						queryParamCOList.get(j).getCtsSegmentParamVO().setSEG_LINE_NO(NumberUtil.isEmptyDecimal(segLineNo) ? new BigDecimal(i + 2) : segLineNo);

						if (NumberUtil.emptyDecimalToNull(segmentationParamList.get(i).getCtsSegmentDetVO().getLINE_NO()) == null)
						{
							nbOccurrence = nbOccurrence + 1;
							criteria.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());
							criteria.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
							lineNumber1 = custSegmentationDAO.returnSegCriteriaDetailsCount(criteria);
							lineNumber = new BigDecimal(lineNumber1);

							queryParamCOList.get(j).getCtsSegmentParamVO().setSEG_LINE_NO(lineNumber.add(BigDecimal.ONE));
						}

						if (nbOccurrence > 0 && NumberUtil.emptyDecimalToNull(segmentationParamList.get(i).getCtsSegmentDetVO().getLINE_NO()) == null)
						{
							queryParamCOList.get(j).getCtsSegmentParamVO().setSEG_LINE_NO(lineNumber.add(new BigDecimal(nbOccurrence)));
						}

						queryParamCOList.get(j).getCtsSegmentParamVO().setLINE_NO(BigDecimal.valueOf(j + 1));
						queryParamCOList.get(j).getCtsSegmentParamVO().setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());

						// by Bilal For TP#750884
						BigDecimal gaArgId = BigDecimal.valueOf(getMaxGaArgId(new CustSegmentationSC()));
						queryParamCOList.get(j).getCtsSegmentParamVO().setGA_ARG_ID(gaArgId);
						// end bilal

						genericDAO.insert(queryParamCOList.get(j).getCtsSegmentParamVO());

						// by Bilal For TP#750884
						if ("S".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						{
							AML_PARAM_MAPPINGVO amlMappingVO = new AML_PARAM_MAPPINGVO();
							BigDecimal lineNoMap = BigDecimal.valueOf(getMaxLineNo(new CustSegmentationSC()));
							amlMappingVO.setGA_ARG_ID(gaArgId);
							amlMappingVO.setLINE_NO(lineNoMap);
							amlMappingVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
							amlMappingVO.setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
							amlMappingVO.setBUSINESS_RULE_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
							amlMappingVO.setCRITERIA_CODE(segmentationParamList.get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
							amlMappingVO.setPARAM_ENTITY_TYPE(custSegmentationCO.getEntityTypeParam());
							amlMappingVO.setPARAM_NAME(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_NAME());
							amlMappingVO.setPARAM_SESSION_ATTR(queryParamCOList.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME());
							genericDAO.insert(amlMappingVO);
						}

						if ("D".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						{
							AML_PARAM_MAPPINGVO amlMappingVO = new AML_PARAM_MAPPINGVO();
							BigDecimal lineNoMap = BigDecimal.valueOf(getMaxLineNo(new CustSegmentationSC()));
							amlMappingVO.setGA_ARG_ID(gaArgId);
							amlMappingVO.setLINE_NO(lineNoMap);
							amlMappingVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
							amlMappingVO.setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
							amlMappingVO.setBUSINESS_RULE_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
							amlMappingVO.setCRITERIA_CODE(segmentationParamList.get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
							amlMappingVO.setPARAM_ENTITY_TYPE(custSegmentationCO.getEntityTypeParam());
							amlMappingVO.setPARAM_NAME(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_NAME());
							amlMappingVO.setPARAM_VALUE(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_VALUE());
							genericDAO.insert(amlMappingVO);
						}
						// end bilal

						// By Bilal For TP#750884
						custSegmentationCO.setQueryParamId(queryParamCOList.get(j).getOldQueryIdParam());

						// By Bilal For TP#750884
						if ("Q".equals(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						{

							// By Bilal For TP#750884 replace param
							lstSelectParam = queryParamCOList.get(j).getSegQuerySelectParamCOLst();
							if (lstSelectParam != null && lstSelectParam.size() > 0)
							{
								if ("U".equals(action))
								{
									CustSegmentationSC custSegmentSC = new CustSegmentationSC();
									custSegmentSC.setCompCode(custSegmentationCO.getLoginCompCode());
									custSegmentSC.setBranchCode(custSegmentationCO.getLoginBraCode());
									custSegmentSC.setENTITY_TYPE("M");
									custSegmentSC.setENTITY_ID(queryParamCOList.get(j).getCtsSegmentParamVO().getENTITY_ID());
									custSegmentSC.setPARAM_CLASS("F");
									custSegmentSC.setQueryId(custSegmentationCO.getQueryParamId());
									custSegmentSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
									custSegmentSC.setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());
									custSegmentSC.setSEG_LINE_NO(queryParamCOList.get(j).getCtsSegmentParamVO().getSEG_LINE_NO());
									custSegmentationDAO.deleteSegmentationSelectParam(custSegmentSC);
								}

								for (int k = 0; k < lstSelectParam.size(); k++)
								{
									lstSelectParam.get(k).getCtsSegmentParamVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
									lstSelectParam.get(k).getCtsSegmentParamVO().setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
									// lstSelectParam.get(k).getCtsSegmentParamVO().setGA_ARG_ID(gaArgId); //need to insert because it's primary key
									// sequentiel
									lstSelectParam.get(k).getCtsSegmentParamVO().setENTITY_TYPE("M");
									lstSelectParam.get(k).getCtsSegmentParamVO().setENTITY_ID(queryParamCOList.get(j).getCtsSegmentParamVO().getENTITY_ID());
									lstSelectParam.get(k).getCtsSegmentParamVO().setLINE_NO(BigDecimal.valueOf(queryParamCOList.size() + k + 1));
									lstSelectParam.get(k).getCtsSegmentParamVO().setPARAM_CLASS("F");
									lstSelectParam.get(k).getCtsSegmentParamVO()
											.setPARAM_QUERY_ID(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_QUERY_ID());
									lstSelectParam.get(k).getCtsSegmentParamVO().setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
									lstSelectParam.get(k).getCtsSegmentParamVO()
											.setSEG_LINE_NO(queryParamCOList.get(j).getCtsSegmentParamVO().getSEG_LINE_NO());
									lstSelectParam.get(k).getCtsSegmentParamVO().setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());
									genericDAO.insert(lstSelectParam.get(k).getCtsSegmentParamVO());
								}
							}

							// custSegmentationCO.setEntityTypeParam("Q");
							// end

							for (int k = 0; k < queryParamCOList.get(j).getLstMultiSelect().size(); k++)
							{
								BigDecimal lineNo = BigDecimal.valueOf(getMaxLineNo(new CustSegmentationSC()));
								queryParamCOList.get(j).getLstMultiSelect().get(k).setLINE_NO(lineNo);
								queryParamCOList.get(j).getLstMultiSelect().get(k).setGA_ARG_ID(gaArgId);
								queryParamCOList.get(j).getLstMultiSelect().get(k).setCOMP_CODE(custSegmentationCO.getLoginCompCode());
								queryParamCOList.get(j).getLstMultiSelect().get(k).setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
								queryParamCOList.get(j).getLstMultiSelect().get(k)
										.setBUSINESS_RULE_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
								queryParamCOList.get(j).getLstMultiSelect().get(k).setCRITERIA_CODE(custSegmentationCO.getCriteriaCode());
								queryParamCOList.get(j).getLstMultiSelect().get(k).setPARAM_ENTITY_TYPE(custSegmentationCO.getEntityTypeParam());
								queryParamCOList.get(j).getLstMultiSelect().get(k)
										.setQUERY_PARAM_ID(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_QUERY_ID());
								queryParamCOList.get(j).getLstMultiSelect().get(k)
										.setPARAM_NAME(queryParamCOList.get(j).getCtsSegmentParamVO().getPARAM_NAME());
								genericDAO.insert(queryParamCOList.get(j).getLstMultiSelect().get(k));
							}
						}
						// end
					}
				}

				// By Bilal For TP#750884 Commented
				// if (!"true".equals(segmentationParamList.get(i).getSegmentationParamOpened()))
				// {
				// criteria.setCompCode(custSegmentationCO.getLoginCompCode());
				// criteria.setBranchCode(custSegmentationCO.getLoginBraCode());
				// criteria.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());
				// criteria.setCriteria_code(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
				// criteria.setNbRec(-1);
				// criteria.setENTITY_TYPE("P");
				// custSegmentationParamListCO = returnSegmentationParamList(criteria);
				// }

				List<CustSegmentationParamCO> procParamCOList = segmentationParamList.get(i).getProcParamCOList();

				// By Bilal For TP#750884 Commented
				// if (!"true".equals(segmentationParamList.get(i).getSegmentationParamOpened()))
				// {
				// procParamCOList = custSegmentationParamListCO;
				// }

				if (procParamCOList != null && !procParamCOList.isEmpty())
				{
					List<CustSegmentationParamCO> lstSelectParam; // By Bilal For TP#750884

					// By Bilal For TP#750884
					custSegmentationCO.setCriteriaCode(segmentationParamList.get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
					custSegmentationCO.setEntityTypeParam("P");
					custSegmentationDAO.deleteOldListSelected(custSegmentationCO);

					for (int j = 0; j < procParamCOList.size(); j++)
					{

						if ("1".equals(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						{

							throw new BOException(MessageCodes.INVALID_MISSING_PROCEDURE_ARGUMENT);

						}

						if ("F".equals(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
								&& (!StringUtil.isNotEmpty(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
						{
							throw new BOException(MessageCodes.VALUES_MISSING);
						}

						if ("D".equals(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
								&& (!StringUtil.isNotEmpty(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
						{
							throw new BOException(MessageCodes.VALUES_MISSING);
						}

						// By Bilal For TP#750884
						if ("Q".equals(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
								&& (NumberUtil.isEmptyDecimal(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_QUERY_ID())))
						{
							throw new BOException(MessageCodes.VALUES_MISSING);
						}

						// Modified By Ali for TP#864398
						if (CustSegmentationConstant.SEGMENTATION.equals(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
								&& (!StringUtil.isNotEmpty(procParamCOList.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME())))
						{
							throw new BOException(MessageCodes.VALUES_MISSING);
						}
						BigDecimal segLineNo = segmentationParamList.get(i).getCtsSegmentDetVO().getLINE_NO();

						procParamCOList.get(j).getCtsSegmentParamVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
						procParamCOList.get(j).getCtsSegmentParamVO().setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
						procParamCOList.get(j).getCtsSegmentParamVO().setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
						procParamCOList.get(j).getCtsSegmentParamVO().setENTITY_TYPE("P");
						procParamCOList.get(j).getCtsSegmentParamVO().setENTITY_ID(criteriaVO.getPROCEDURE_ID());
						// +2 since the first segLineNo has 1 as value and not 0
						procParamCOList.get(j).getCtsSegmentParamVO().setSEG_LINE_NO(NumberUtil.isEmptyDecimal(segLineNo) ? new BigDecimal(i + 2) : segLineNo);
						procParamCOList.get(j).getCtsSegmentParamVO().setLINE_NO(BigDecimal.valueOf(j + 1));
						procParamCOList.get(j).getCtsSegmentParamVO().setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());

						// by Bilal For TP#750884
						BigDecimal gaArgId = BigDecimal.valueOf(getMaxGaArgId(new CustSegmentationSC()));
						procParamCOList.get(j).getCtsSegmentParamVO().setGA_ARG_ID(gaArgId);
						// end bilal

						genericDAO.insert(procParamCOList.get(j).getCtsSegmentParamVO());

						// By Bilal For TP#750884
						custSegmentationCO.setQueryParamId(procParamCOList.get(j).getOldQueryIdParam());

						// by Bilal For TP#750884
						if ("S".equals(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						{
							AML_PARAM_MAPPINGVO amlMappingVO = new AML_PARAM_MAPPINGVO();
							BigDecimal lineNoMap = BigDecimal.valueOf(getMaxLineNo(new CustSegmentationSC()));
							amlMappingVO.setGA_ARG_ID(gaArgId);
							amlMappingVO.setLINE_NO(lineNoMap);
							amlMappingVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
							amlMappingVO.setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
							amlMappingVO.setBUSINESS_RULE_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
							amlMappingVO.setCRITERIA_CODE(segmentationParamList.get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
							amlMappingVO.setPARAM_ENTITY_TYPE(custSegmentationCO.getEntityTypeParam());
							amlMappingVO.setPARAM_NAME(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_NAME());
							amlMappingVO.setPARAM_SESSION_ATTR(procParamCOList.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME());
							genericDAO.insert(amlMappingVO);
						}

						if ("D".equals(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						{
							AML_PARAM_MAPPINGVO amlMappingVO = new AML_PARAM_MAPPINGVO();
							BigDecimal lineNoMap = BigDecimal.valueOf(getMaxLineNo(new CustSegmentationSC()));
							amlMappingVO.setGA_ARG_ID(gaArgId);
							amlMappingVO.setLINE_NO(lineNoMap);
							amlMappingVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
							amlMappingVO.setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
							amlMappingVO.setBUSINESS_RULE_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
							amlMappingVO.setCRITERIA_CODE(segmentationParamList.get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
							amlMappingVO.setPARAM_ENTITY_TYPE(custSegmentationCO.getEntityTypeParam());
							amlMappingVO.setPARAM_NAME(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_NAME());
							amlMappingVO.setPARAM_VALUE(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_VALUE());
							genericDAO.insert(amlMappingVO);
						}
						// end bilal

						// By Bilal For TP#750884
						if ("Q".equals(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
						{
							// By Bilal For TP#750884 replace param
							lstSelectParam = procParamCOList.get(j).getSegQuerySelectParamCOLst();
							if (lstSelectParam != null && lstSelectParam.size() > 0)
							{
								if ("U".equals(action))
								{
									CustSegmentationSC custSegmentSC = new CustSegmentationSC();
									custSegmentSC.setCompCode(custSegmentationCO.getLoginCompCode());
									custSegmentSC.setBranchCode(custSegmentationCO.getLoginBraCode());
									custSegmentSC.setENTITY_TYPE("M");
									custSegmentSC.setENTITY_ID(procParamCOList.get(j).getCtsSegmentParamVO().getENTITY_ID());
									custSegmentSC.setPARAM_CLASS("F");
									custSegmentSC.setQueryId(custSegmentationCO.getQueryParamId());
									custSegmentSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
									custSegmentSC.setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());
									custSegmentSC.setSEG_LINE_NO(procParamCOList.get(j).getCtsSegmentParamVO().getSEG_LINE_NO());
									custSegmentationDAO.deleteSegmentationSelectParam(custSegmentSC);
								}

								for (int k = 0; k < lstSelectParam.size(); k++)
								{
									lstSelectParam.get(k).getCtsSegmentParamVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
									lstSelectParam.get(k).getCtsSegmentParamVO().setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
									// lstSelectParam.get(k).getCtsSegmentParamVO().setGA_ARG_ID(gaArgId); //need to insert because it's primary key
									// sequentiel
									lstSelectParam.get(k).getCtsSegmentParamVO().setENTITY_TYPE("M");
									lstSelectParam.get(k).getCtsSegmentParamVO().setENTITY_ID(procParamCOList.get(j).getCtsSegmentParamVO().getENTITY_ID());
									lstSelectParam.get(k).getCtsSegmentParamVO().setLINE_NO(BigDecimal.valueOf(procParamCOList.size() + k + 1));
									lstSelectParam.get(k).getCtsSegmentParamVO().setPARAM_CLASS("F");
									lstSelectParam.get(k).getCtsSegmentParamVO()
											.setPARAM_QUERY_ID(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_QUERY_ID());
									lstSelectParam.get(k).getCtsSegmentParamVO().setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
									lstSelectParam.get(k).getCtsSegmentParamVO().setSEG_LINE_NO(procParamCOList.get(j).getCtsSegmentParamVO().getSEG_LINE_NO());
									lstSelectParam.get(k).getCtsSegmentParamVO().setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());
									genericDAO.insert(lstSelectParam.get(k).getCtsSegmentParamVO());
								}
							}

							for (int k = 0; k < procParamCOList.get(j).getLstMultiSelect().size(); k++)
							{
								BigDecimal lineNo = BigDecimal.valueOf(getMaxLineNo(new CustSegmentationSC()));
								procParamCOList.get(j).getLstMultiSelect().get(k).setLINE_NO(lineNo);
								procParamCOList.get(j).getLstMultiSelect().get(k).setGA_ARG_ID(gaArgId);
								procParamCOList.get(j).getLstMultiSelect().get(k).setCOMP_CODE(custSegmentationCO.getLoginCompCode());
								procParamCOList.get(j).getLstMultiSelect().get(k).setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
								procParamCOList.get(j).getLstMultiSelect().get(k).setBUSINESS_RULE_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
								procParamCOList.get(j).getLstMultiSelect().get(k).setCRITERIA_CODE(custSegmentationCO.getCriteriaCode());
								procParamCOList.get(j).getLstMultiSelect().get(k).setPARAM_ENTITY_TYPE(custSegmentationCO.getEntityTypeParam());
								procParamCOList.get(j).getLstMultiSelect().get(k)
										.setQUERY_PARAM_ID(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_QUERY_ID());
								procParamCOList.get(j).getLstMultiSelect().get(k).setPARAM_NAME(procParamCOList.get(j).getCtsSegmentParamVO().getPARAM_NAME());
								genericDAO.insert(procParamCOList.get(j).getLstMultiSelect().get(k));
							}
						}
						// end By Bilal For TP#750884
					}
					// }
				}
			}
		}
	}

	public CustSegmentationCO dependencyByCriteriaCode(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		int exits = 0;
		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();

		custSegmentationSC.setCriteria_code(custSegmentationCO.getCtsSegmentDetVO().getCRITERIA_CODE());
		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
		custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		custSegmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore()); // By Bilal For TP#750884
		exits = custSegmentationDAO.dependencyByCriteriaCode(custSegmentationSC);

		if (exits == 1)
		{
			String criteriaDesc = custSegmentationDAO.returnCriteriaDesc(custSegmentationSC);
			custSegmentationCO.setCriteriaDesc(criteriaDesc);
		}
		else
		{
			throw new BOException(MessageCodes.INVALID_CRITERIA_CODE);
		}
		return custSegmentationCO;
	}

	@Override
	public List returnExcludeCIFsDetailList(ExcludeCIFSC excludeCIFSC) throws BaseException
	{
		return custSegmentationDAO.returnExcludeCIFsDetailList(excludeCIFSC);
	}

	@Override
	public int returnExcludeCIFsDetailListCount(ExcludeCIFSC excludeCIFSC) throws BaseException
	{
		return custSegmentationDAO.returnExcludeCIFsDetailListCount(excludeCIFSC);
	}

	public CustSegmentationCO updateSegment(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		Boolean newRecord = false;

		List<CustSegmentationCO> newList = new ArrayList<CustSegmentationCO>();
		CustSegmentationSC criteria = new CustSegmentationSC();

		// in Header Column : COMP_CODE/SEGMENT_CODE / BRANCH_CODE
		// //MODIFIED_BY,DATE_MODIFIED,DATE_UPDATED
		// UPDATED
		
		criteria.setAppName("RET");
		criteria.setProgRef("CSG00SEGMT");

		// this list will hold the required exceptions
		ArrayList<BaseException> msgArr = new ArrayList<BaseException>();
		if ((custSegmentationCO.getGridUpdateList() == null || custSegmentationCO.getGridUpdateList().isEmpty())
				&& (custSegmentationCO.getGridDeleteList() == null || custSegmentationCO.getGridDeleteList().isEmpty())
				&& (custSegmentationCO.getGridAddList() == null || custSegmentationCO.getGridAddList().isEmpty()))
		{

			if (custSegmentationCO.getGridAllList() != null)
			{
				for (int i = 0; i < custSegmentationCO.getGridAllList().size(); i++)
				{
					List<CustSegmentationParamCO> custSegmentationParamListCO = new ArrayList<>();

					if ("".equals(custSegmentationCO.getGridAllList().get(i).getQueryParamGridStr()))
					{

						criteria.setCompCode(custSegmentationCO.getLoginCompCode());
						criteria.setBranchCode(custSegmentationCO.getLoginBraCode());
						criteria.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on latest
						criteria.setCriteria_code(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
						criteria.setNbRec(-1);
						criteria.setENTITY_TYPE("Q");
						criteria.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());// By Bilal For TP#750884
						criteria.setLineNo(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getLINE_NO()); // By Bilal For TP#750884
						custSegmentationParamListCO = returnSegmentationParamList(criteria);
						custSegmentationCO.getGridAllList().get(i).setQueryParamCOList(custSegmentationParamListCO); // By Bilal For TP#750884
					}
					else
					{
						custSegmentationParamListCO = custSegmentationCO.getGridAllList().get(i).getQueryParamCOList();
					}
					if (custSegmentationParamListCO.size() > 0)
					{
						for (int j = 0; j < custSegmentationParamListCO.size(); j++)
						{
							/*
							 * if ("1".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())) { throw new
							 * BOException(MessageCodes.INVALID_MISSING_PROCEDURE_ARGUMENT); }
							 */

							if ("D".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}

							if ("F".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}

							if ("S".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
									&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME())))
							{
								throw new BOException(MessageCodes.VALUES_MISSING);
							}

							if ("1".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
							{
								throw new BOException(MessageCodes.INVALID_MISSING_QUERY_ARGUMENT);
							}
						}
					}

					if ("".equals(custSegmentationCO.getGridAllList().get(i).getProcParamGridStr()))
					{

						criteria.setCompCode(custSegmentationCO.getLoginCompCode());
						criteria.setBranchCode(custSegmentationCO.getLoginBraCode());
						criteria.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on latest
						criteria.setCriteria_code(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
						criteria.setNbRec(-1);
						criteria.setENTITY_TYPE("P");
						criteria.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());// By Bilal For TP#750884
						criteria.setLineNo(custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().getLINE_NO()); // By Bilal For TP#750884
						custSegmentationParamListCO = returnSegmentationParamList(criteria);
						custSegmentationCO.getGridAllList().get(i).setProcParamCOList(custSegmentationParamListCO); // By Bilal For TP#750884

						if (custSegmentationParamListCO.size() > 0)
						{
							for (int j = 0; j < custSegmentationParamListCO.size(); j++)
							{
								if ("1".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS()))
								{
									throw new BOException(MessageCodes.INVALID_MISSING_PROCEDURE_ARGUMENT);
								}

								if ("F".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
										&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
								{
									throw new BOException(MessageCodes.VALUES_MISSING);
								}

								if ("D".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
										&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_VALUE())))
								{
									throw new BOException(MessageCodes.VALUES_MISSING);
								}

								if ("S".equals(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getPARAM_CLASS())
										&& (!StringUtil.isNotEmpty(custSegmentationParamListCO.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME())))
								{
									throw new BOException(MessageCodes.VALUES_MISSING);
								}
							}
						}
					}

				}
			}
			// msgArr.add(new BaseException(MessageCodes.NO_DATA_TO_SAVE_INSERT_RECORD));
		}

		if (!msgArr.isEmpty())
		{
			throw new BOException(msgArr);
		}

		totalPercentageValidation(custSegmentationCO); // Rania - 718813 - Dynamic Customer Scoring on latest

		CustSegmentationSC temp = new CustSegmentationSC();
		temp.setCompCode(custSegmentationCO.getLoginCompCode());
		temp.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		temp.setIvCrud(custSegmentationCO.getCrud());
		temp.setIsRejected(BigDecimal.ZERO);
		temp.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());

		if (!CustSegmentationConstant.BUSINESS_RULES.equals(custSegmentationCO.getIsSegmentationScore())
				&& CustSegmentationConstant.UPDATE_AFTER_APPROVE_IVCRUD.equals(custSegmentationCO.getCrud())) // adde by nour
		{
			coreCommonProcedureBO.runAlertSegmentation(temp);
		}
		if (custSegmentationCO.getGridUpdateList() != null && !custSegmentationCO.getGridUpdateList().isEmpty())
		{
			// f_checkaccess_without_message in ue_confirm
			CommonLibSC commonLibSC = new CommonLibSC();
			commonLibSC.setCompCode(custSegmentationCO.getLoginCompCode());
			commonLibSC.setBranchCode(custSegmentationCO.getLoginBraCode());
			commonLibSC.setAppName(custSegmentationCO.getAppName());
			commonLibSC.setUserId(custSegmentationCO.getLoginUserId());
			commonLibSC.setProgRef(custSegmentationCO.getOpt() + ConstantsCommon.UPDATE_MODE);
			commonLibSC.setProfType(NumberUtil.nullToZero(commonLibBO.returnPthCtrl().getPOP_PROF_MOD_ACCESS()));
			Integer updateStatus = commonLibBO.checkAccessByProgRef(commonLibSC);
			commonLibSC.setProgRef(custSegmentationCO.getOpt() + ConstantsCommon.CREATE_MODE);

			if (updateStatus == 1)
			{
				return null;
			}
			Integer createStatus = commonLibBO.checkAccessByProgRef(commonLibSC);
			if (updateStatus == 1 && createStatus != 1)
			{
				return null;
			}
		}

		NumberUtil.resetEmptyValues(custSegmentationCO.getCtsSegmentVO());
		custSegmentationCO.getCtsSegmentVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
		// List<CustSegmentationCO> newList = new
		// ArrayList<CustSegmentationCO>();
		// upon update we should insert,update each record

		// update rows in grid View

		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
		custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		custSegmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		// custSegmentationSC.setLineNo(lineNo);

		// all list
		Integer countLeftOperator = 0, countRightOperator = 0, size = 0;
		validateBracketsNbr(custSegmentationCO, size, countLeftOperator, countRightOperator);

		// Commented since the user can add, many times, the same criterion

		// List<CustSegmentationCO> gridModel = new
		// ArrayList<CustSegmentationCO>();
		// gridModel = custSegmentationCO.getGridAllList();
		// if((gridModel.size() != 0))
		// {
		// checkDuplicateCriterion(gridModel, custSegmentationCO);
		// }

		updateSegmentationParam(custSegmentationCO, custSegmentationCO.getGridAllList(), "U");

		// Rania - 718813 - Dynamic Customer Scoring on latest
		/*if ("SC".equals(custSegmentationCO.getIsSegmentationScore()))
		{*/
			processSegment(custSegmentationCO);
//		}
		// End Rania

		if (custSegmentationCO.getCtsSegmentVO().getDATE_UPDATED() != null)
		{
			custSegmentationCO = checkDateUpdated(custSegmentationCO);
		}

		updateSegmentHeader(custSegmentationCO);

		CustSegmentationSC cusSegSC = new CustSegmentationSC();
		cusSegSC.setCompCode(custSegmentationCO.getLoginCompCode());
		cusSegSC.setNbRec(-1);
		cusSegSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		cusSegSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		cusSegSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());

		List<CustSegmentationCO> oldList = returnCustSegmentationDetailList(cusSegSC);
		List<CTS_SEGMENT_DETVOWithBLOBs> oldListDetailsVO = new ArrayList<CTS_SEGMENT_DETVOWithBLOBs>();
		if (oldList != null && (oldList.size() >= 1)) // modify by nour for 777000 (=1)
		{
			for (int i = 0; i < oldList.size(); i++)
			{
				oldListDetailsVO.add(oldList.get(i).getCtsSegmentDetVO());
			}
		}
		else
		{
			oldListDetailsVO.add(new CTS_SEGMENT_DETVOWithBLOBs());
		}

		// updated rows

		custSegmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		custSegmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());
		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());

		custSegmentationDAO.deleteSegmentationDetails(custSegmentationSC);
		BigDecimal lineNo = BigDecimal.ZERO;

		for (Object objCO : custSegmentationCO.getGridAllList())
		{
			lineNo = lineNo.add(BigDecimal.ONE);

			CustSegmentationCO updatedCO = (CustSegmentationCO) objCO;
			NumberUtil.resetEmptyValues(updatedCO.getCtsSegmentDetVO());
			CTS_SEGMENT_DETVOWithBLOBs updateVO = updatedCO.getCtsSegmentDetVO();
			updateVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
			updateVO.setLINE_NO(lineNo);// updateVO.setLINE_NO(updatedCO.getCtsSegmentDetVO().getLINE_NO());
			updateVO.setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
			updateVO.setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());
			updateVO.setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
			// updateVO.setMARKET_INDEX_TICKER(stfCommodityMarketPriceCO.getCtsComMarketPriceDetailsVO().getMARKET_INDEX_TICKER());

			genericDAO.insert(updateVO);
		}

		// added rows

		// BigDecimal lineNumber = custSegmentationCO.getGridAllList().size();
		custSegmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());
		int lineNumber1 = custSegmentationDAO.returnSegCriteriaDetailsCount(custSegmentationSC);
		BigDecimal lineNumber = new BigDecimal(lineNumber1);

		// NumberUtil.resetEmptyValues(custSegmentationCO.getCtsSegmentDetVO().getCRITERIA_CODE());

		if (custSegmentationCO.getGridAddList() != null)
		{
			for (CustSegmentationCO rowCO : custSegmentationCO.getGridAddList())
			{
				if (!NumberUtil.isEmptyDecimal(rowCO.getCtsSegmentDetVO().getCRITERIA_CODE()))
				{
					rowCO.getCtsSegmentDetVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
					rowCO.getCtsSegmentDetVO().setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
					rowCO.getCtsSegmentDetVO().setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
					rowCO.getCtsSegmentDetVO().setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());
					// LINE_NO
					lineNumber = lineNumber.add(BigDecimal.ONE);
					rowCO.getCtsSegmentDetVO().setLINE_NO((lineNumber));
					// lineNumber = lineNumber.add(BigDecimal.ONE); // INCREMENT
					// LINE_NO TO 1

					genericDAO.insert(rowCO.getCtsSegmentDetVO());
				}
				else
				{
					throw new BOException(MessageCodes.CANNOT_SAVE_CRITERION_CODE_MISSING);
				}
			}
		}

		updateSegmentationParam(custSegmentationCO, custSegmentationCO.getGridAddList(), "A");

		int lineNumber2 = 0;

		if (custSegmentationCO.getGridDeleteList() != null)
		{
			lineNumber2 = custSegmentationCO.getGridDeleteList().size();
		}

		BigDecimal lineNumber3 = new BigDecimal(lineNumber1);

		if (custSegmentationCO.getGridDeleteList() != null)
		{
			for (CustSegmentationCO rowCO : custSegmentationCO.getGridDeleteList())
			{
				rowCO.getCtsSegmentDetVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
				rowCO.getCtsSegmentDetVO().setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
				rowCO.getCtsSegmentDetVO().setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
				// LINE_NO
				rowCO.getCtsSegmentDetVO().setLINE_NO(rowCO.getCtsSegmentDetVO().getLINE_NO());
				rowCO.getCtsSegmentDetVO().setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on
																											// latest
				lineNumber3 = lineNumber3.subtract(BigDecimal.ONE); // INCREMENT
				// LINE_NO TO 1
				genericDAO.delete(rowCO.getCtsSegmentDetVO());

				CustSegmentationSC segmentationSC = new CustSegmentationSC();
				segmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
				segmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
				segmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
				segmentationSC.setLineNo(rowCO.getCtsSegmentDetVO().getLINE_NO());
				segmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on latest
				custSegmentationDAO.deleteSegmentationParam(segmentationSC);
			}
		}
		newList = returnCustSegmentationDetailList(cusSegSC);
		List<CTS_SEGMENT_DETVOWithBLOBs> newListDetailsVO = new ArrayList<CTS_SEGMENT_DETVOWithBLOBs>();
		if (newList != null && newList.size() > 0)
		{
			for (int i = 0; i < newList.size(); i++)
			{
				newListDetailsVO.add(newList.get(i).getCtsSegmentDetVO());
			}
			//by bilal moved inside the checking if exist at least one rows in details
			auditBO.callAudit(oldListDetailsVO, newListDetailsVO, custSegmentationCO.getAuditRefCO()); // for
		}
		
		auditBO.insertAudit(custSegmentationCO.getAuditRefCO());
		
		CustSegmentationCO oldCustSegmentationCO = (CustSegmentationCO) custSegmentationCO.getAuditObj(); // added by nour for 777000

		// Commented to save the exclude CIF when closign the popup
		// saveExcludeCifGrid(custSegmentationCO, newRecord);
		
		//Rania - Customers Segmentation
		//Send Notification Alert
		AlertsRequestParamSC alertsRequestParamSC = new  AlertsRequestParamSC();
		
		alertsRequestParamSC.setSenderUserId(custSegmentationCO.getLoginUserId());
		alertsRequestParamSC.setCompCode(custSegmentationCO.getLoginCompCode());
		alertsRequestParamSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		alertsRequestParamSC.setTodoApplication("RET");
		alertsRequestParamSC.setDateReceived(custSegmentationCO.getRunningDate());
		alertsRequestParamSC.setTodoParam(NumberUtil.emptyDecimalToZero(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE()).toString());
		alertsRequestParamSC.setTodoAlert("@N");
		alertsRequestParamSC.setTodoProgRef("CSG00SEGMT");
		String desc = "";
		desc = "Segment ".concat(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE().toString()).concat(" has been updated, Please run segmentation process");
		alertsRequestParamSC.setAlertDesc(desc);
		
        	ArrayList<CTSTELLERVO> accessBySegmentProcessUserList = custSegmentationDAO.returnUsrAccessBySegmentProcess(criteria);
        	for(int i = 0; i < accessBySegmentProcessUserList.size(); i++)
        	{
        	    alertsRequestParamSC.setReceiverUserId(accessBySegmentProcessUserList.get(i).getUSER_ID());
        	    alertsBO.sendAlert(alertsRequestParamSC);
        	}
		
		//End Rania		

		// added by nour for 777000
		if (CoreCommonConstants.AML.equals(custSegmentationCO.getAppName()))
		{
			TrackPropCO trackPropCO = auditBO.copyAuditProps(custSegmentationCO.getAuditRefCO());
			trackPropCO.setCoInstanceName("custSegmentationCO");
			trackPropCO.setVoMainPropRef("ctsSegmentVO");
			trackPropCO.setTrackVoMainPropRef(true);
			trackPropCO.setVoPropertiesNames("");
			auditBO.callTrackChanges(oldCustSegmentationCO, custSegmentationCO, trackPropCO);

		}
		// end nour

		return custSegmentationCO;
	}

	// CHECK DATE UPDATE
	public CustSegmentationCO checkDateUpdated(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
		custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		custSegmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		custSegmentationSC.setDateUpdated(custSegmentationCO.getCtsSegmentVO().getDATE_UPDATED());
		custSegmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());

		int count = custSegmentationDAO.checkDateUpdated(custSegmentationSC);
		if (count == 0)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}
		return custSegmentationCO;
	}

	private void checkDuplicateExcludeCIFDetails(List<CustSegmentationCO> gridModel, CustSegmentationCO custSegCO, ArrayList<BaseException> msgArr)
			throws BOException
	{
		if (gridModel != null)
		{
			// if same cif is inc

			// fill the array (cifExcluded)
			Set<BigDecimal> cifExcluded = new HashSet<BigDecimal>();
			for (int i = 0; i < gridModel.size(); i++)
			{
				CustSegmentationCO rowCO = gridModel.get(i);
				if ((custSegCO.getLoginCompCode() != null) && (rowCO.getCtsSegmentCifExcludeVO().getCIF_NO() != null)
						&& (custSegCO.getCtsSegmentVO().getSEGMENT_CODE() != null))
				{
					if (cifExcluded.contains(rowCO.getCtsSegmentCifExcludeVO().getCIF_NO()))
					{
						throw new BOException(MessageCodes.DUPLICATE_ACCOUNT_NUMBER);
					}
					else
					{
						cifExcluded.add(rowCO.getCtsSegmentCifExcludeVO().getCIF_NO());
					}
				}
			}
		}
	}

	// SAVE EXCLUDE CIF GRID
	public void saveExcludeCifGrid(CustSegmentationCO custSegCO, Boolean newRecord) throws BaseException
	{
		if (StringUtil.isNotEmpty(custSegCO.getExcludeCifGridUpdates()))
		{
			ArrayList<BaseException> msgArr = new ArrayList();

			List<CustSegmentationCO> gridModel = custSegCO.getExcludeCifListCOs();

			// we execute this code if the exclude cif grid does not have any
			// record. (i.e deleting all the records)
			if (gridModel == null)
			{
				// delete all cif related to segment
				ExcludeCIFSC excludeCIFSC = new ExcludeCIFSC();
				excludeCIFSC.setCompCode(custSegCO.getLoginCompCode());
				excludeCIFSC.setSegment_code(custSegCO.getCtsSegmentVO().getSEGMENT_CODE());
				excludeCIFSC.setSegmentType(custSegCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on latest
				custSegmentationDAO.deleteCtsCifSegmentExclude(excludeCIFSC);
			}

			if (gridModel != null && gridModel.size() != 0)
			{
				gridModel = custSegCO.getExcludeCifListCOs();
				checkDuplicateExcludeCIFDetails(gridModel, custSegCO, msgArr);

				// delete all cif related to segment
				ExcludeCIFSC excludeCIFSC = new ExcludeCIFSC();
				excludeCIFSC.setCompCode(custSegCO.getLoginCompCode());
				excludeCIFSC.setSegment_code(custSegCO.getCtsSegmentVO().getSEGMENT_CODE());
				excludeCIFSC.setSegmentType(custSegCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on latest
				custSegmentationDAO.deleteCtsCifSegmentExclude(excludeCIFSC);

				// insert all CIF to segment
				for (int i = 0; i < gridModel.size(); i++)
				{
					CustSegmentationCO rowCO = gridModel.get(i);
					CTS_SEGMENT_CIF_EXCLUDEVO ctsSegmentExcludeVO = new CTS_SEGMENT_CIF_EXCLUDEVO();

					if ((custSegCO.getLoginCompCode() != null) && (rowCO.getCtsSegmentCifExcludeVO().getCIF_NO() != null)
							&& (custSegCO.getCtsSegmentVO().getSEGMENT_CODE() != null))
					{
						ctsSegmentExcludeVO.setCOMP_CODE(custSegCO.getLoginCompCode());
						ctsSegmentExcludeVO.setSEGMENT_CODE(custSegCO.getCtsSegmentVO().getSEGMENT_CODE());
						ctsSegmentExcludeVO.setCIF_NO(rowCO.getCtsSegmentCifExcludeVO().getCIF_NO());
						ctsSegmentExcludeVO.setSEGMENT_TYPE(custSegCO.getIsSegmentationScore());
						genericDAO.insert(ctsSegmentExcludeVO);
					}
				}
			}
		}
	}

	public CustSegmentationCO approveSegment(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		CustSegmentationSC temp = new CustSegmentationSC();
		temp.setCompCode(custSegmentationCO.getLoginCompCode());
		temp.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		temp.setIvCrud(custSegmentationCO.getCrud());
		temp.setIsRejected(BigDecimal.ZERO);
		temp.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());
		temp.setAppName("RET");
		temp.setProgRef("CSG00SEGP");

		// Added By Ali for TP#864398
		if (!CustSegmentationConstant.BUSINESS_RULES.equals(custSegmentationCO.getIsSegmentationScore()))
		{
			coreCommonProcedureBO.runAlertSegmentation(temp);
		}

		// custSegmentationCO : CTS_SEGMENT (header table )
		if (custSegmentationCO.getCtsSegmentVO().getDATE_UPDATED() != null)
		{
			custSegmentationCO = checkDateUpdated(custSegmentationCO);
		}
		custSegmentationCO.getCtsSegmentVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
		custSegmentationCO.getCtsSegmentVO().setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
		custSegmentationCO.getCtsSegmentVO().setSTATUS(CustSegmentationConstant.STATUS_APPROVED);
		custSegmentationCO.getCtsSegmentVO().setAPPROVED_BY(custSegmentationCO.getLoginUserId());
		custSegmentationCO.getCtsSegmentVO().setDATE_APPROVED(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
		custSegmentationCO.getCtsSegmentVO().setDATE_UPDATED(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
		custSegmentationCO.getCtsSegmentVO().setBRANCH_CODE(custSegmentationCO.getLoginBraCode());// added by nour for 777000
		// added by nour for 777000
		
			int errorCode = 0;

			errorCode = commonLibBO.validateMakerChecker(custSegmentationCO.getCtsSegmentVO().getCREATED_BY(),
					custSegmentationCO.getCtsSegmentVO().getMODIFIED_BY(), custSegmentationCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}

			custSegmentationCO.applyTraceProps(custSegmentationCO.getAppName(), custSegmentationCO.getLoginUserId(), custSegmentationCO.getProgRef());
		
		custSegmentationDAO.approveSegment(custSegmentationCO);
		// added by nour for 777000

		CustSegmentationCO oldCustSegmentationCO = new CustSegmentationCO();
		oldCustSegmentationCO = (CustSegmentationCO) custSegmentationCO.getAuditObj();
		NumberUtil.resetEmptyValues(custSegmentationCO.getCtsSegmentVO());
		
		//by bilal for TP#936108
		if(ConstantsCommon.TRUE.equals(oldCustSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()))
		{
			oldCustSegmentationCO.getCtsSegmentVO().setMAIN_SCORE_YN(ConstantsCommon.ONE);
		}
		else if(ConstantsCommon.FALSE.equals(oldCustSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()))
		{
			oldCustSegmentationCO.getCtsSegmentVO().setMAIN_SCORE_YN(ConstantsCommon.ZERO);
		}
		//end bilal
		
		auditBO.callAudit(oldCustSegmentationCO.getCtsSegmentVO(), custSegmentationCO.getCtsSegmentVO(), custSegmentationCO.getAuditRefCO());
		auditBO.insertAudit(custSegmentationCO.getAuditRefCO());
		if (CoreCommonConstants.AML.equals(custSegmentationCO.getAppName()))
		{
			

			// Changes tracking TrackPropCO trackCO
			TrackPropCO trackCO = auditBO.copyAuditProps(custSegmentationCO.getAuditRefCO());
			trackCO.setOperationType(AuditConstant.APPROVE); // the newCO shall
			// be null when we use this method upon // approve/reject.
			trackCO.setVoMainPropRef("ctsSegmentVO");
			auditBO.callTrackChanges(oldCustSegmentationCO, null, trackCO);
		}
		
		//Rania - Customers Segmentation
		//Send Notification Alert
		AlertsRequestParamSC alertsRequestParamSC = new  AlertsRequestParamSC();

		alertsRequestParamSC.setSenderUserId(custSegmentationCO.getLoginUserId());
//		alertsRequestParamSC.setReceiverUserId(custSegmentationCO.getLoginUserId());
		alertsRequestParamSC.setCompCode(custSegmentationCO.getLoginCompCode());
		alertsRequestParamSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		alertsRequestParamSC.setTodoApplication("RET");
		alertsRequestParamSC.setDateReceived(custSegmentationCO.getRunningDate());
		alertsRequestParamSC.setTodoParam(NumberUtil.emptyDecimalToZero(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE()).toString());
		alertsRequestParamSC.setTodoAlert("@N");
		alertsRequestParamSC.setTodoProgRef("CSG00SEGP");
		alertsRequestParamSC.setAlertDesc(CustSegmentationConstant.PLEASE_RUN_SEG_PROCESS);
		
		ArrayList<CTSTELLERVO> accessBySegmentProcessUserList = custSegmentationDAO.returnUsrAccessBySegmentProcess(temp);
        	for(int i = 0; i < accessBySegmentProcessUserList.size(); i++)
        	{
        	    alertsRequestParamSC.setReceiverUserId(accessBySegmentProcessUserList.get(i).getUSER_ID());
        	    alertsBO.sendAlert(alertsRequestParamSC);
        	}
        	

		//End Rania
		

		return custSegmentationCO;
	}

	public CustSegmentationCO rejectSegment(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		if ("P".equals(custSegmentationCO.getCrud()) && CustSegmentationConstant.STATUS_APPROVED.equals(custSegmentationCO.getCtsSegmentVO().getOLD_STATUS()))
		{
			// call the procedure
			CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
			custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
			custSegmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
			custSegmentationSC.setIvCrud(custSegmentationCO.getCrud());
			custSegmentationSC.setIsRejected(BigDecimal.ONE);
			custSegmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());
			coreCommonProcedureBO.runAlertSegmentation(custSegmentationSC);
		}
		else if ("P".equals(custSegmentationCO.getCrud()) && (StringUtil.isEmptyString(custSegmentationCO.getCtsSegmentVO().getOLD_STATUS())
				|| "A".equals(custSegmentationCO.getCtsSegmentVO().getOLD_STATUS())))
		{
			if (custSegmentationCO.getCtsSegmentVO().getDATE_UPDATED() != null)
			{
				custSegmentationCO = checkDateUpdated(custSegmentationCO);
			}
			custSegmentationCO.getCtsSegmentVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
			custSegmentationCO.getCtsSegmentVO().setREJECTED_BY(custSegmentationCO.getLoginUserId());
			custSegmentationCO.getCtsSegmentVO().setDATE_REJECTED(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
			custSegmentationCO.getCtsSegmentVO().setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
			custSegmentationCO.getCtsSegmentVO().setSTATUS(CustSegmentationConstant.STATUS_APPROVE_REJECTED);
			custSegmentationCO.getCtsSegmentVO().setDATE_UPDATED(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
			custSegmentationDAO.rejectSegment(custSegmentationCO);
		}

		return custSegmentationCO;
	}

	public CustSegmentationCO initialiseData(CustSegmentationCO custSegmentationCO, Boolean newRecord) throws BaseException
	{
		if ("R".equals(custSegmentationCO.getCrud()) && custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE() == null)
		{
			applyDynScreenDisplay("code", "custSegmentationCO.ctsSegmentVO.SEGMENT_CODE", ConstantsCommon.ACTION_TYPE_MANDATORY, "1",
					custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("code", "custSegmentationCO.ctsSegmentVO.SEGMENT_CODE", ConstantsCommon.ACTION_TYPE_READONLY, "0",
					custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("segmentDesc", "custSegmentationCO.ctsSegmentVO.SEGMENT_DESC", ConstantsCommon.ACTION_TYPE_MANDATORY, "1",
					custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("segmentDesc", "custSegmentationCO.ctsSegmentVO.SEGMENT_DESC", ConstantsCommon.ACTION_TYPE_READONLY, "0",
					custSegmentationCO.getBuisnessElement(), null);

			applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_READONLY, "1", custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("excludeCif", "excludeCif", ConstantsCommon.ACTION_TYPE_READONLY, "1", custSegmentationCO.getBuisnessElement(), null);
		}
		else if ("R".equals(custSegmentationCO.getCrud()) || "UP".equals(custSegmentationCO.getCrud()))
		{
			applyDynScreenDisplay("code", "custSegmentationCO.ctsSegmentVO.SEGMENT_CODE", ConstantsCommon.ACTION_TYPE_READONLY, "1",
					custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("segmentDesc", "custSegmentationCO.ctsSegmentVO.SEGMENT_DESC", ConstantsCommon.ACTION_TYPE_READONLY, "0",
					custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_READONLY, "0", custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("excludeCif", "excludeCif", ConstantsCommon.ACTION_TYPE_READONLY, "0", custSegmentationCO.getBuisnessElement(), null);
		}
		else
		{
			applyDynScreenDisplay("code", "custSegmentationCO.ctsSegmentVO.SEGMENT_CODE", ConstantsCommon.ACTION_TYPE_READONLY, "1",
					custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("segmentDesc", "custSegmentationCO.ctsSegmentVO.SEGMENT_DESC", ConstantsCommon.ACTION_TYPE_READONLY, "1",
					custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_READONLY, "1", custSegmentationCO.getBuisnessElement(), null);
			applyDynScreenDisplay("excludeCif", "excludeCif", ConstantsCommon.ACTION_TYPE_READONLY, "0", custSegmentationCO.getBuisnessElement(), null);
		}

		/**
		 * added by nour for tp #864398
		 * 
		 */

		if (!CustSegmentationConstant.SUSPEND.equals(custSegmentationCO.getCrud()))
		{
			applyDynScreenDisplay("suspend_reason", "custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF", ConstantsCommon.ACTION_TYPE_VISIBLE, "0",
					custSegmentationCO.getBuisnessElement(), null);
//			applyDynScreenDisplay("reasonName", "custSegmentationCO.reasonName", ConstantsCommon.ACTION_TYPE_VISIBLE, "0",
//					custSegmentationCO.getBuisnessElement(), null);

//			applyDynScreenDisplay("suspend_reason_ref", "custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF", ConstantsCommon.ACTION_TYPE_VISIBLE, "0",
//					custSegmentationCO.getBuisnessElement(), null);
//			applyDynScreenDisplay("reasonNameRef", "custSegmentationCO.reasonNameRef", ConstantsCommon.ACTION_TYPE_VISIBLE, "0",
//					custSegmentationCO.getBuisnessElement(), null);
		}

		if (CustSegmentationConstant.MAINT.equals(custSegmentationCO.getCrud()) || CustSegmentationConstant.STATUS_APPROVED.equals(custSegmentationCO.getCrud())
				|| CustSegmentationConstant.UPDATE_AFTER_APPROVE_IVCRUD.equals(custSegmentationCO.getCrud())
				|| CustSegmentationConstant.SUSPEND.equals(custSegmentationCO.getCrud())
				|| CustSegmentationConstant.APPROVE_SUSPEND.equals(custSegmentationCO.getCrud())
				|| CustSegmentationConstant.REACTIVATE.equals(custSegmentationCO.getCrud()))
		{
			applyDynScreenDisplay(new String[] { "day" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ZERO, custSegmentationCO.getBuisnessElement(),
					null);// added by nour
			applyDynScreenDisplay(new String[] { "lbl_On" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ZERO, custSegmentationCO.getBuisnessElement(),
					null);// added by nour

		}
		// added by nour for request 974623

//		if (CustSegmentationConstant.APPROVE_SUSPEND.equals(custSegmentationCO.getCrud())||CustSegmentationConstant.REACTIVATE.equals(custSegmentationCO.getCrud())||CustSegmentationConstant.APPROVE_REACTIVATE.equals(custSegmentationCO.getCrud()) )
//		{
//
//			applyDynScreenDisplay("suspend_reason", "custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF", ConstantsCommon.ACTION_TYPE_VISIBLE, "1",
//					custSegmentationCO.getBuisnessElement(), null);
//			
//		}

		applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", custSegmentationCO.getBuisnessElement(), null); // Rania
																																						// -
																																						// 718813
																																						// -
																																						// Dynamic
																																						// Customer
																																						// Scoring
																																						// on
																																						// latest

		// Rania - ABSAI180073
		CIFCONTROLVO cifControlVO = new CIFCONTROLVO();

		cifControlVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());

		cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);

		if (cifControlVO != null)
		{
			custSegmentationCO.setScoringCalcCriteria(cifControlVO.getSCORING_CALC_CRITERIA_LIST());
		}
		
		if("S".equals(custSegmentationCO.getIsSegmentationScore()))
		{
		    applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", custSegmentationCO.getBuisnessElement(), null);    
		}
		else
		{
		    applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", custSegmentationCO.getBuisnessElement(), null); // Rania - 718813 - Dynamic Customer Scoring on latest
		}

		return custSegmentationCO;
	}

	@Override
	public CustSegmentationCO updateSegmentHeader(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		CTS_SEGMENTVO ctsSegmentVO = new CTS_SEGMENTVO();
		ctsSegmentVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
		ctsSegmentVO.setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
		ctsSegmentVO.setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		ctsSegmentVO.setSEGMENT_DESC(custSegmentationCO.getCtsSegmentVO().getSEGMENT_DESC());
		ctsSegmentVO.setMODIFIED_BY(custSegmentationCO.getLoginUserId()); 
		ctsSegmentVO.setDATE_MODIFIED(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
		// ctsSegmentVO.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
		//ctsSegmentVO.setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());
		ctsSegmentVO.setGROUP_CODE(custSegmentationCO.getCtsSegmentVO().getGROUP_CODE()); // Rania - Customers Segmentation Enhancement
		ctsSegmentVO.setMAIN_SCORE_YN(custSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()); // Rania - ABSAI180073
		ctsSegmentVO.setSUSPEND_REASON_CODE(custSegmentationCO.getCtsSegmentVO().getSUSPEND_REASON_CODE());// added by nour for 864398
		ctsSegmentVO.setSUSPEND_REASON_REF(custSegmentationCO.getCtsSegmentVO().getSUSPEND_REASON_REF());
		// added by nour for 864398
		ctsSegmentVO.setLONG_DESC_ENG(custSegmentationCO.getCtsSegmentVO().getLONG_DESC_ENG());// added by nour for 864398
		ctsSegmentVO.setPERIODICITY(custSegmentationCO.getCtsSegmentVO().getPERIODICITY());
		ctsSegmentVO.setDAY(custSegmentationCO.getCtsSegmentVO().getDAY());
		ctsSegmentVO.setCREATED_BY(custSegmentationCO.getCtsSegmentVO().getCREATED_BY());
		ctsSegmentVO.setDATE_CREATED(custSegmentationCO.getCtsSegmentVO().getDATE_CREATED());
		ctsSegmentVO.setSEGMENT_TYPE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_TYPE());
		ctsSegmentVO.setCREATED_BY(custSegmentationCO.getCtsSegmentVO().getCREATED_BY());
		ctsSegmentVO.setDATE_CREATED(custSegmentationCO.getCtsSegmentVO().getDATE_CREATED());
		ctsSegmentVO.setDATE_UPDATED(custSegmentationCO.getCtsSegmentVO().getDATE_UPDATED());
		ctsSegmentVO.setAPPROVED_BY(custSegmentationCO.getCtsSegmentVO().getAPPROVED_BY());
		ctsSegmentVO.setDATE_APPROVED(custSegmentationCO.getCtsSegmentVO().getDATE_APPROVED());
		// END NOUR
		String crudValue = custSegmentationCO.getCrud();

		// commented by bilal because change the progRef of update after approve in business rule screen to BR00CUP
		// if (CustSegmentationConstant.UPDATE_AFTER_APPROVE.equals(crudValue))// added by nour
		// {
		// ctsSegmentVO.setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
		// ctsSegmentVO.setSTATUS(CustSegmentationConstant.STATUS_ACTIVE);
		// }
		if (CustSegmentationConstant.UPDATE_AFTER_APPROVE_IVCRUD.equals(crudValue))
		{
			ctsSegmentVO.setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
			ctsSegmentVO.setSTATUS(CustSegmentationConstant.STATUS_ACTIVE);
	
		}
		else if (CustSegmentationConstant.SUSPEND.equals(crudValue))
		{
			ctsSegmentVO.setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
			ctsSegmentVO.setTO_SUSPEND_BY(custSegmentationCO.getLoginUserId());
			ctsSegmentVO.setTO_SUSPEND_DATE(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
			ctsSegmentVO.setSTATUS(CustSegmentationConstant.STATUS_SUSPEND);
	
		}
		else if (CustSegmentationConstant.APPROVE_SUSPEND.equals(crudValue))
		{
			ctsSegmentVO.setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
			ctsSegmentVO.setSUSPENDED_BY(custSegmentationCO.getLoginUserId());
			ctsSegmentVO.setSUSPENDED_DATE(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
			ctsSegmentVO.setSTATUS(CustSegmentationConstant.STATUS_APPROVE_SUSPEND);
			// added by nour for 777000
			int errorCode = 0;

			errorCode = commonLibBO.validateMakerChecker(custSegmentationCO.getCtsSegmentVO().getCREATED_BY(),
					ctsSegmentVO.getSUSPENDED_BY(), custSegmentationCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}

			custSegmentationCO.applyTraceProps(custSegmentationCO.getAppName(), custSegmentationCO.getLoginUserId(), custSegmentationCO.getProgRef());
		}
		else if (CustSegmentationConstant.REACTIVATE.equals(crudValue))
		{
			ctsSegmentVO.setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
			ctsSegmentVO.setTO_REACTIVATE_BY(custSegmentationCO.getLoginUserId());
			ctsSegmentVO.setTO_REACTIVATE_DATE(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
			ctsSegmentVO.setSTATUS(CustSegmentationConstant.STATUS_REACTIVATE);
		}
		else if (CustSegmentationConstant.APPROVE_REACTIVATE.equals(crudValue))
		{
			ctsSegmentVO.setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
			ctsSegmentVO.setREACTIVATED_BY(custSegmentationCO.getLoginUserId());
			ctsSegmentVO.setREACTIVATED_DATE(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
			ctsSegmentVO.setSTATUS(CustSegmentationConstant.STATUS_APPROVE_REACTIVATE);// Rania - ABSAI180073
			ctsSegmentVO.setSUSPEND_REASON_CODE(null);;
			// added by nour for 777000
			int errorCode = 0; 

			errorCode = commonLibBO.validateMakerChecker(custSegmentationCO.getCtsSegmentVO().getCREATED_BY(),
					ctsSegmentVO.getREACTIVATED_BY(), custSegmentationCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}

			custSegmentationCO.applyTraceProps(custSegmentationCO.getAppName(), custSegmentationCO.getLoginUserId(), custSegmentationCO.getProgRef());
		}
		else if (CustSegmentationConstant.CANCEL.equals(crudValue))
		{
			ctsSegmentVO.setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
			ctsSegmentVO.setTO_CANCEL_BY(custSegmentationCO.getLoginUserId());
			ctsSegmentVO.setTO_CANCEL_DATE(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
			ctsSegmentVO.setSTATUS(CustSegmentationConstant.STATUS_CANCEL);
		}
		else if (CustSegmentationConstant.APPROVE_CANCEL.equals(crudValue))
		{
			ctsSegmentVO.setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS());
			ctsSegmentVO.setCANCELED_BY(custSegmentationCO.getLoginUserId());
			ctsSegmentVO.setCANCELED_DATE(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
			ctsSegmentVO.setSTATUS(CustSegmentationConstant.STATUS_APPROVE_CANCEL);
			// added by nour for 777000
			int errorCode = 0;

			errorCode = commonLibBO.validateMakerChecker(custSegmentationCO.getCtsSegmentVO().getCREATED_BY(),
					ctsSegmentVO.getCANCELED_BY(), custSegmentationCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}

			custSegmentationCO.applyTraceProps(custSegmentationCO.getAppName(), custSegmentationCO.getLoginUserId(), custSegmentationCO.getProgRef());
		}
		else
		{
			ctsSegmentVO.setSTATUS(CustSegmentationConstant.STATUS_ACTIVE);
			ctsSegmentVO.setOLD_STATUS(custSegmentationCO.getCtsSegmentVO().getSTATUS()); //by bilal when test the audit from Lina
			
		}

		CustSegmentationCO oldCustSegmentationCO = (CustSegmentationCO) custSegmentationCO.getAuditObj();
		NumberUtil.resetEmptyValues(custSegmentationCO.getCtsSegmentVO());
		custSegmentationCO.getCtsSegmentVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
		custSegmentationCO.setCtsSegmentVO(ctsSegmentVO);// added by nour for 777000

		if (oldCustSegmentationCO != null)
		{
			oldCustSegmentationCO.getCtsSegmentVO().setCOMP_CODE(custSegmentationCO.getLoginCompCode());
			NumberUtil.resetEmptyValues(custSegmentationCO.getCtsSegmentVO());// added by nour for 864398
			
			//by bilal for TP#936108
			if(ConstantsCommon.TRUE.equals(oldCustSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()))
			{
				oldCustSegmentationCO.getCtsSegmentVO().setMAIN_SCORE_YN(ConstantsCommon.ONE);
			}
			else if(ConstantsCommon.FALSE.equals(oldCustSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()))
			{
				oldCustSegmentationCO.getCtsSegmentVO().setMAIN_SCORE_YN(ConstantsCommon.ZERO);
			}
			//end bilal
			
			auditBO.callAudit(oldCustSegmentationCO.getCtsSegmentVO(), custSegmentationCO.getCtsSegmentVO(), custSegmentationCO.getAuditRefCO());
			if (CustSegmentationConstant.SUSPEND.equals(crudValue)||
					CustSegmentationConstant.APPROVE_SUSPEND.equals(crudValue)||
					CustSegmentationConstant.REACTIVATE.equals(crudValue)|| 
					CustSegmentationConstant.APPROVE_REACTIVATE.equals(crudValue)||
					CustSegmentationConstant.CANCEL.equals(crudValue)||
					CustSegmentationConstant.APPROVE_CANCEL.equals(crudValue))
			{
			auditBO.insertAudit(custSegmentationCO.getAuditRefCO());// added by nour for 777000

			}
			}
		// added by nour for BUG #955568
		int count = custSegmentationDAO.returnMainScore(custSegmentationCO);

		if ((custSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN())!=null && ((custSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()).equals(CustSegmentationConstant.CHECKED) && count >= 1))
		{
			throw new BOException(MessageCodes.MAIN_SCORE_IS_ALREADY_CHECHED); // 39086 nour msg changes
		}
		// END #955568

		genericDAO.update(ctsSegmentVO);

		return custSegmentationCO;
	}

	public List returnListOfCustomerSegmentation(CustSegmentationSC criteria) throws BaseException
	{
		return custSegmentationDAO.returnListOfCustomerSegmentation(criteria);
	}

	/**
	 * Validate number of brackets () in the gridView Detail
	 * 
	 * @param custSegCo
	 * @param size
	 * @param countLeftOperator
	 * @param countRightOperator
	 * @throws BOException
	 */

	private void validateBracketsNbr(CustSegmentationCO custSegCo, Integer size, Integer countLeftOperator, Integer countRightOperator) throws BOException
	{
		// Added By Ali for TP#864398
		if (custSegCo.getGridAllList().size() > 0) // added by bilal
		{
			custSegCo.getGridAllList().get(0).getCtsSegmentDetVO().setLOGICAL_OPERATOR(CustSegmentationConstant.FIRST_ROW_LOGICAL_OPERATOR_VALUE);

			for (CustSegmentationCO rowCO : custSegCo.getGridAllList())
			{
				if (rowCO.getCtsSegmentDetVO().getLEFT_OPERATOR().equals("("))
				{
					countLeftOperator++;
				}
				if (rowCO.getCtsSegmentDetVO().getRIGHT_OPERATOR().equals(")"))
				{
					countRightOperator++;
				}
				
				if (countRightOperator > countLeftOperator )
				{
					if ( !(custSegCo.getIsSegmentationScore().equals(CustSegmentationConstant.SCORING)))
					{
					throw new BOException(MessageCodes.CANNOT_SAVE_BRACKETS_SHOULD_BE_CLOSED); // 39086
					}
					else
					{
						throw new BOException(MessageCodes.CANNOT_SAVE_SCORE_BRACKETS_SHOULD_BE_CLOSED);//7117
					}
				}
			
				
				size++;
			}

			if ((!countLeftOperator.equals(countRightOperator)) && (custSegCo.getGridAllList().size() == size))
			{
				if ( !(custSegCo.getIsSegmentationScore().equals(CustSegmentationConstant.SCORING)))
				{
				throw new BOException(MessageCodes.CANNOT_SAVE_BRACKETS_SHOULD_BE_CLOSED); // 39086
				}
				else
				{
					throw new BOException(MessageCodes.CANNOT_SAVE_SCORE_BRACKETS_SHOULD_BE_CLOSED);//7117
				}
			}
		}
	}

	/**
	 * check if there is a duplicate criterion in grid View Detail
	 */
	private void checkDuplicateCriterion(List<CustSegmentationCO> gridModel, CustSegmentationCO custSegCO) throws BOException
	{
		if (gridModel != null)
		{
			// if there is a duplicated criterion then threw Error

			// fill the array (cifExcluded)
			Set<BigDecimal> criterionsSet = new HashSet<BigDecimal>();
			for (int i = 0; i < gridModel.size(); i++)
			{
				CustSegmentationCO rowCO = gridModel.get(i);
				if ((custSegCO.getLoginCompCode() != null) && (rowCO.getCtsSegmentDetVO().getLINE_NO() != null)
						&& (custSegCO.getCtsSegmentVO().getSEGMENT_CODE() != null))
				{
					if (criterionsSet.contains(rowCO.getCtsSegmentDetVO().getCRITERIA_CODE()))
					{
						throw new BOException(MessageCodes.CANNOT_SAVE_DUPLICATED_CRITERIONS);
					}
					else
					{
						criterionsSet.add(rowCO.getCtsSegmentDetVO().getCRITERIA_CODE());
					}
				}
			}
		}
	}

	// Abdo Define priorities 10/08/2017
	public CustSegmentationCO updateDefPriorties(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		ArrayList<BigDecimal> al = new ArrayList<BigDecimal>();
		ArrayList<BigDecimal> alNew = new ArrayList<BigDecimal>();

		// Rania - Customers Segmentation
		BigDecimal i = BigDecimal.ZERO;
		HashMap<BigDecimal, BigDecimal> hmap = new HashMap<BigDecimal, BigDecimal>();

		for (Object objCO : custSegmentationCO.getGridAllList())
		{
			CustSegmentationCO updateCO = (CustSegmentationCO) objCO;
			CTS_SEGMENTVO updateVO = updateCO.getCtsSegmentVO();

			hmap.put(updateVO.getSEGMENT_CODE(), updateVO.getAMENDED_PRIORITY());
			al.add(updateVO.getAMENDED_PRIORITY());

			i = i.add(BigDecimal.ONE);
		}

		Collections.sort(al);

		for (int j = 0; j < al.size(); j++)
		{
			for (Object objCO : custSegmentationCO.getGridAllList())
			{
				CustSegmentationCO updateCO = (CustSegmentationCO) objCO;
				CTS_SEGMENTVO updateVO = updateCO.getCtsSegmentVO();

				if (updateVO.getAMENDED_PRIORITY().compareTo(al.get(j)) == 0)
				{
					alNew.add(updateVO.getSEGMENT_CODE());
				}
			}
		}

		for (int j = 0; j < al.size(); j++)
		{
			CTS_SEGMENTVO updateVO = new CTS_SEGMENTVO();

			updateVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
			updateVO.setSEGMENT_CODE(alNew.get(j));
			updateVO.setPRIORITY(new BigDecimal(j + 1));
			updateVO.setAMENDED_PRIORITY(new BigDecimal((j + 1) * 10));
			updateVO.setSTATUS(CustSegmentationConstant.STATUS_ACTIVE);
			updateVO.setSEGMENT_TYPE("S"); // Rania - Customers Segmentation
			genericDAO.update(updateVO);
		}

		// End Rania

		/*
		 * for(Object objCO : custSegmentationCO.getGridUpdateList()) { CustSegmentationCO updateCO = (CustSegmentationCO) objCO; CTS_SEGMENTVO updateVO =
		 * updateCO.getCtsSegmentVO();
		 * 
		 * updateVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode()); updateVO.setSEGMENT_CODE(updateVO.getSEGMENT_CODE());
		 * updateVO.setSTATUS(CustSegmentationConstant.STATUS_ACTIVE); genericDAO.update(updateVO); }
		 */

		return custSegmentationCO;
	}

	public CustSegmentationSC runTrialSegmentationProcess(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		// Rania - 718813 - Dynamic Customer Scoring on latest
		if ("SC".equals(custSegmentationSC.getIsSegmentationScore()))
		{
			custSegmentationSC = coreCommonProcedureBO.runTrialScoringProcess(custSegmentationSC);
		}
		else if ("S".equals(custSegmentationSC.getIsSegmentationScore()))
		{
			custSegmentationSC = coreCommonProcedureBO.runTrialSegmentationProcess(custSegmentationSC);
		}

		return custSegmentationSC;
	}

	public int returnSegmentationParamListCount(CustSegmentationSC criteriaSC) throws BaseException
	{
		int count = custSegmentationDAO.returnSegmentationParamListCount(criteriaSC);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<CustSegmentationParamCO> returnSegmentationParamList(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		List<CustSegmentationParamCO> list = new ArrayList<CustSegmentationParamCO>();
		CTS_CRITERIAVO criteriaVO = new CTS_CRITERIAVO();
		criteriaVO.setCOMP_CODE(custSegmentationSC.getCompCode());
		criteriaVO.setCRITERIA_CODE(custSegmentationSC.getCriteria_code());
		criteriaVO = (CTS_CRITERIAVO) genericDAO.selectByPK(criteriaVO);

		// added by nour for tp#864398
		if (criteriaVO == null)
		{
			criteriaVO = new CTS_CRITERIAVO();
		}
		// end nour

		BigDecimal entityId;

		if ("P".equals(custSegmentationSC.getENTITY_TYPE()) && criteriaVO != null)
		{
			entityId = criteriaVO.getPROCEDURE_ID();

			if (entityId != null)
			{
				custSegmentationSC.setENTITY_ID(entityId);

				int segProcQueryParamCount = custSegmentationDAO.checkSegProcQueryParamExists(custSegmentationSC);
				if (segProcQueryParamCount > 0)
				{
					ProcedureIdSC procedureIdSC = new ProcedureIdSC();
					procedureIdSC.setProcId(entityId);
					ProcedureIdCO procedureIdCO = procedureIdBO.dependencyByProcId(procedureIdSC);
					if (procedureIdCO != null) // By Bilal For TP#750884
					{
						custSegmentationSC.setEntityName(procedureIdCO.getProcName());
					}
					else
					{
						custSegmentationSC.setEntityName("");
					}

					list = custSegmentationDAO.returnSegmentationParamList(custSegmentationSC);

					// By Bilal For TP#750884
					list = fillListMultiSelect(list, custSegmentationSC);
					// end
				}
				else
				{
					CriteriaSC criteriaSC = new CriteriaSC();
					criteriaSC.setCompCode(custSegmentationSC.getCompCode());
					criteriaSC.setBRANCH_CODE(custSegmentationSC.getBranchCode());
					criteriaSC.setCRITERIA_CODE(custSegmentationSC.getCriteria_code());
					criteriaSC.setENTITY_TYPE(custSegmentationSC.getENTITY_TYPE());
					criteriaSC.setENTITY_ID(entityId);

					ProcedureIdSC procedureIdSC = new ProcedureIdSC();
					procedureIdSC.setProcId(entityId);
					ProcedureIdCO procedureIdCO = procedureIdBO.dependencyByProcId(procedureIdSC);
					criteriaSC.setEntityName(procedureIdCO.getProcName());
					criteriaSC.setNbRec(-1);
					List<CriteriaParamCO> criteriaParamList = criteriaBO.returnCriteriaParamListResult(criteriaSC);

					// By Bilal For TP#750884
					criteriaParamList = fillListMultiSelect(criteriaParamList, custSegmentationSC);

					if (criteriaParamList != null && criteriaParamList.size() > 0)
					{
						CustSegmentationParamCO custSegmentationParamCO;
						for (int i = 0; i < criteriaParamList.size(); i++)
						{
							custSegmentationParamCO = new CustSegmentationParamCO();
							PathPropertyUtil.copyProperties(criteriaParamList.get(i), custSegmentationParamCO,
									"ctsCriteriaParamVO.PARAM_ORDER ctsSegmentParamVO.PARAM_ORDER",
									"ctsCriteriaParamVO.PARAM_TYPE ctsSegmentParamVO.PARAM_TYPE", "ctsCriteriaParamVO.PARAM_NAME ctsSegmentParamVO.PARAM_NAME",
									"ctsCriteriaParamVO.PARAM_VALUE ctsSegmentParamVO.PARAM_VALUE",
									"ctsCriteriaParamVO.SESSION_ATTR_NAME ctsSegmentParamVO.SESSION_ATTR_NAME",
									"ctsCriteriaParamVO.PARAM_CLASS ctsSegmentParamVO.PARAM_CLASS",
									"ctsCriteriaParamVO.PARAM_QUERY_ID ctsSegmentParamVO.PARAM_QUERY_ID", "jsonMultiselectArray jsonMultiselectArray",
									"lstMultiSelect lstMultiSelect", "ctsCriteriaParamVO.ENTITY_ID ctsSegmentParamVO.ENTITY_ID"); // By Bilal For TP#750884
							custSegmentationParamCO.getCtsSegmentParamVO().setSEGMENT_CODE(custSegmentationSC.getSegment_code()); // By Bilal For TP#750884
																																	// param query
							custSegmentationParamCO.setIsSegmentationScore(custSegmentationSC.getIsSegmentationScore()); // By Bilal For TP#750884 param
																															// query
							list.add(custSegmentationParamCO);
						}
					}
				}
			}
		}
		else if (("Q".equals(custSegmentationSC.getENTITY_TYPE()) || "M".equals(custSegmentationSC.getENTITY_TYPE())) && criteriaVO != null) // By Bilal For
																																				// TP#750884
																																				// param
																																				// query
		{
			// By Bilal For TP#750884 param query
			if ("Q".equals(custSegmentationSC.getENTITY_TYPE()))
			{
				entityId = criteriaVO.getQUERY_ID();
			}
			else
			{
				entityId = custSegmentationSC.getENTITY_ID();
			}

			try
			{
				if (entityId != null)
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

					HashMap<String, Object> hashIn = new HashMap<String, Object>();
					hashIn.put("queryId", entityId);
					ArrayList<HashMap<String, Object>> hashList = commonReportingBO.returnArgListByQryId(hashIn);
					if (hashList != null)
					{
						custSegmentationSC.setENTITY_ID(entityId);

						int segProcQueryParamCount = custSegmentationDAO.checkSegProcQueryParamExists(custSegmentationSC);
						if (segProcQueryParamCount > 0)
						{
							for (int i = 0; i < hashList.size(); i++)
							{

								if (commonLibBO.returnIsSybase() == 1)
								{
									custSegmentationSC.setParamName("@" + hashList.get(i).get("argument_NAME"));

								}

								else
								{
									custSegmentationSC.setParamName((String) hashList.get(i).get("argument_NAME"));
								}

								CustSegmentationParamCO custSegmentationParamCO = custSegmentationDAO.returnArgumentDetailsResult(custSegmentationSC);
								if (custSegmentationParamCO == null)
								{
									custSegmentationParamCO = new CustSegmentationParamCO();
								}

								if (commonLibBO.returnIsSybase() == 1)
								{
									custSegmentationParamCO.getCtsSegmentParamVO().setPARAM_NAME("@" + hashList.get(i).get("argument_NAME"));
									custSegmentationParamCO.getCtsSegmentParamVO().setPARAM_ORDER(new BigDecimal(i + 1));
								}

								else
								{

									custSegmentationParamCO.getCtsSegmentParamVO().setPARAM_NAME((String) hashList.get(i).get("argument_NAME"));
									custSegmentationParamCO.getCtsSegmentParamVO().setPARAM_ORDER(new BigDecimal(i + 1));
								}

								custSegmentationParamCO.getCtsSegmentParamVO().setPARAM_TYPE((String) hashList.get(i).get("argument_TYPE"));

								list.add(custSegmentationParamCO);
							}

							// By Bilal For TP#750884
							list = fillListMultiSelect(list, custSegmentationSC);

						}
						else
						{
							List<CriteriaParamCO> criteriaParamList = new ArrayList<CriteriaParamCO>();
							for (int i = 0; i < hashList.size(); i++)
							{
								CriteriaSC criteriaSC = new CriteriaSC();
								criteriaSC.setCompCode(custSegmentationSC.getCompCode());
								criteriaSC.setBRANCH_CODE(custSegmentationSC.getBranchCode());
								criteriaSC.setCRITERIA_CODE(custSegmentationSC.getCriteria_code());
								criteriaSC.setENTITY_TYPE(custSegmentationSC.getENTITY_TYPE());
								criteriaSC.setENTITY_ID(entityId);
								if (commonLibBO.returnIsSybase() == 1)
								{
									criteriaSC.setParamName("@" + hashList.get(i).get("argument_NAME"));
								}

								else
								{

									criteriaSC.setParamName((String) hashList.get(i).get("argument_NAME"));
								}
								CriteriaParamCO criteriaParamCO = criteriaBO.returnArgumentDetailsResult(criteriaSC);
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

								criteriaParamList.add(criteriaParamCO);

							}

							// By Bilal For TP#750884
							criteriaParamList = fillListMultiSelect(criteriaParamList, custSegmentationSC);

							if (criteriaParamList != null && criteriaParamList.size() > 0)
							{
								CustSegmentationParamCO custSegmentationParamCO;
								for (int i = 0; i < criteriaParamList.size(); i++)
								{
									custSegmentationParamCO = new CustSegmentationParamCO();
									PathPropertyUtil.copyProperties(criteriaParamList.get(i), custSegmentationParamCO,
											"ctsCriteriaParamVO.PARAM_ORDER ctsSegmentParamVO.PARAM_ORDER",
											"ctsCriteriaParamVO.PARAM_TYPE ctsSegmentParamVO.PARAM_TYPE",
											"ctsCriteriaParamVO.PARAM_NAME ctsSegmentParamVO.PARAM_NAME",
											"ctsCriteriaParamVO.PARAM_VALUE ctsSegmentParamVO.PARAM_VALUE",
											"ctsCriteriaParamVO.SESSION_ATTR_NAME ctsSegmentParamVO.SESSION_ATTR_NAME",
											"ctsCriteriaParamVO.PARAM_CLASS ctsSegmentParamVO.PARAM_CLASS",
											"ctsCriteriaParamVO.PARAM_QUERY_ID ctsSegmentParamVO.PARAM_QUERY_ID", "jsonMultiselectArray jsonMultiselectArray",
											"lstMultiSelect lstMultiSelect", "ctsCriteriaParamVO.ENTITY_ID ctsSegmentParamVO.ENTITY_ID"); // By Bilal For
																																			// TP#750884
									custSegmentationParamCO.getCtsSegmentParamVO().setSEGMENT_CODE(custSegmentationSC.getSegment_code()); // By Bilal For
																																			// TP#750884
																																			// param query
									custSegmentationParamCO.setIsSegmentationScore(custSegmentationSC.getIsSegmentationScore()); // By Bilal For TP#750884
																																	// param query
									list.add(custSegmentationParamCO);
								}
							}
						}

					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}

	public CustSegmentationCO processSegment(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		List<CustSegmentationCO> custSegmentationCOs = custSegmentationCO.getGridAllList();
		if (custSegmentationCOs != null && !custSegmentationCOs.isEmpty())
		{
			BigDecimal criteriaCode, queryId, procedureId;
			for (int i = 0; i < custSegmentationCOs.size(); i++)
			{
				if (NumberUtil.emptyDecimalToNull(custSegmentationCOs.get(i).getCtsSegmentDetVO().getCRITERIA_CODE()) != null)
				{
					criteriaCode = NumberUtil.emptyDecimalToNull(custSegmentationCOs.get(i).getCtsSegmentDetVO().getCRITERIA_CODE());
					CTS_CRITERIAVO criteriaVO = new CTS_CRITERIAVO();
					criteriaVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
					// added by nour for tp ##864398
					if (criteriaCode != null)
					{
						criteriaVO.setCRITERIA_CODE(criteriaCode);
						criteriaVO = (CTS_CRITERIAVO) genericDAO.selectByPK(criteriaVO);
					}

					if (criteriaVO != null)
					{
						queryId = criteriaVO.getQUERY_ID();
						if (queryId != null)
						{
							// modified by bilal for TP#750884
							List<CustSegmentationParamCO> custSegmentationParamCOs = new ArrayList<CustSegmentationParamCO>();
							if (ConstantsCommon.ONE.equals(custSegmentationCO.getIsFromProcess())) // set as one if called from process
							{
								CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
								custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
								custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
								custSegmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
								custSegmentationSC.setLineNo(custSegmentationCOs.get(i).getCtsSegmentDetVO().getLINE_NO());
								custSegmentationSC.setENTITY_TYPE("Q");
								custSegmentationSC.setENTITY_ID(queryId);
								custSegmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer
																														// Scoring on latest
								custSegmentationParamCOs = custSegmentationDAO.returnArgumentParamsDetails(custSegmentationSC);
							}
							else
							{
								// Rania - 718813 - Dynamic Customer Scoring on latest
								if (/*"SC".equals(custSegmentationCO.getIsSegmentationScore()) && */custSegmentationParamCOs.size() == 0)
								{
									custSegmentationParamCOs = custSegmentationCOs.get(i).getQueryParamCOList();
								}
								// End Rania
							}

							if (custSegmentationParamCOs != null)
							{
								StringBuffer queryStr = new StringBuffer();
								try
								{
									String reportUrl = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "reporting.serviceURL");
									if (reportUrl == null)
									{
										throw new BOException("Invalid reporting URL");
									}
									String checkReportingUrlService = reportUrl.concat("commonReportingBOService");
									CommonReportingBO commonReportingBO = (CommonReportingBO) RmiServiceCaller.returnRmiInterface(checkReportingUrlService,
											CommonReportingBO.class);

									IRP_REP_ARGUMENTSVO queryArgVO;
									ArrayList<HashMap<String, Object>> newArgsMapList = new ArrayList<HashMap<String, Object>>();
									CTS_SEGMENT_PARAMVO segmentationParamVO;
									for (int j = 0; j < custSegmentationParamCOs.size(); j++)
									{
										segmentationParamVO = custSegmentationParamCOs.get(j).getCtsSegmentParamVO();

										if (!"Q".equals(segmentationParamVO.getPARAM_CLASS())) // By Bilal For TP#750884 replaced query param
										{
											if (commonLibBO.returnIsSybase() == 1)
											{
												segmentationParamVO.setPARAM_NAME(segmentationParamVO.getPARAM_NAME().replace("@", ""));
											}

											queryArgVO = new IRP_REP_ARGUMENTSVO();
											PathPropertyUtil.copyProperties(segmentationParamVO, queryArgVO, "PARAM_NAME ARGUMENT_NAME",
													"PARAM_TYPE ARGUMENT_TYPE", "PARAM_VALUE ARGUMENT_VALUE", "SESSION_ATTR_NAME SESSION_ATTR_NAME",
													"PARAM_ORDER ARGUMENT_ORDER");

											// Modified By Bilal For TP#750884 Requested
											if (StringUtil.isNotEmpty(custSegmentationParamCOs.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME()))
											{
												// queryArgVO.setARGUMENT_VALUE(custSegmentationParamCOs.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME());
												queryArgVO.setARGUMENT_VALUE(
														"$P{".concat(custSegmentationParamCOs.get(j).getCtsSegmentParamVO().getPARAM_NAME()).concat("}"));
												// queryArgVO.setARGUMENT_VALUE(prepareSessionValues(custSegmentationCO,
												// custSegmentationParamCOs.get(j).getCtsSegmentParamVO().getSESSION_ATTR_NAME()));
											}

											// By Bilal for TP#750884
											if ("D".equals(segmentationParamVO.getPARAM_CLASS()))
											{
												//added by bilal for TP#930349
												if ("VARCHAR".equals(segmentationParamVO.getPARAM_TYPE().toUpperCase()) || "VARCHAR2".equals(segmentationParamVO.getPARAM_TYPE().toUpperCase())
														|| "CHAR".equals(segmentationParamVO.getPARAM_TYPE().toUpperCase()))
												{
													queryArgVO.setARGUMENT_VALUE(
															"$P!{".concat(custSegmentationParamCOs.get(j).getCtsSegmentParamVO().getPARAM_NAME()).concat("}"));
												}
												else
												{
													queryArgVO.setARGUMENT_VALUE(
															"$P{".concat(custSegmentationParamCOs.get(j).getCtsSegmentParamVO().getPARAM_NAME()).concat("}"));
												}
											}

											newArgsMapList.add(PathPropertyUtil.convertToMap(queryArgVO));
										}
									}

									queryStr = commonReportingBO.returnQuerySyntaxWithReplacedArgs(queryId, newArgsMapList);
									if (queryStr != null)
									{
										String newQuery = queryStr.toString();
										newQuery = newQuery.replace("'", "''");
										// We added this line for the following reason:
										// when a VARCHAR is defined from the query
										// designer and drag and drop to the
										// query canvas,
										// the $P!{C_RESIDENT_TYPE} will be surrounded
										// by single quotes ('$P!{C_RESIDENT_TYPE}')
										// therefore when we want to replace
										// "''''" by "'"
										// it results in 4 single quote from each side;
										// which results in an error when running the
										// segmentation process.
										newQuery = newQuery.replace("''''", "'");
										newQuery = newQuery.replace("''", "'");
										queryStr = new StringBuffer(newQuery);

										CTS_SEGMENT_DETVOWithBLOBs segmentVO = new CTS_SEGMENT_DETVOWithBLOBs();
										segmentVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
										segmentVO.setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
										segmentVO.setLINE_NO(custSegmentationCOs.get(i).getCtsSegmentDetVO().getLINE_NO());
										segmentVO.setQUERY_DETAILS(queryStr.toString());
										segmentVO.setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore());
										genericDAO.update(segmentVO);

										custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().setQUERY_DETAILS(queryStr.toString());// Rania -
																																				// 718813 -
																																				// Dynamic
																																				// Customer
																																				// Scoring
																																				// on latest

									}
								}
								catch (Exception ex)
								{
									ex.printStackTrace();
								}
							}
						}
						procedureId = criteriaVO.getPROCEDURE_ID();
						if (procedureId != null)
						{
							ProcedureIdSC procedureIdSC = new ProcedureIdSC();
							procedureIdSC.setProcId(procedureId);
							ProcedureIdCO procedureIdCO = procedureIdBO.dependencyByProcId(procedureIdSC);
							String procedureName = procedureIdCO.getProcName();
							// modified by bilal for TP#750884
							List<CustSegmentationParamCO> custSegmentationParamCOs = new ArrayList<CustSegmentationParamCO>();
							CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
							custSegmentationSC.setEntityName(procedureName);
							if (ConstantsCommon.ONE.equals(custSegmentationCO.getIsFromProcess())) // set as one if called from process
							{
								custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
								custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
								custSegmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
								custSegmentationSC.setLineNo(custSegmentationCOs.get(i).getCtsSegmentDetVO().getLINE_NO());
								custSegmentationSC.setENTITY_TYPE("P");
								custSegmentationSC.setENTITY_ID(procedureId);
								// custSegmentationSC.setEntityName(procedureName);
								custSegmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer
																														// Scoring on latest
								custSegmentationParamCOs = custSegmentationDAO.returnArgumentParamsDetails(custSegmentationSC);
							}
							else
							{
								// Rania - 718813 - Dynamic Customer Scoring on latest
								if ("SC".equals(custSegmentationCO.getIsSegmentationScore()) || "BR".equals(custSegmentationCO.getIsSegmentationScore()))
								{
									custSegmentationParamCOs = custSegmentationCOs.get(i).getProcParamCOList();
								}
								// End Rania
							}

							if (custSegmentationParamCOs != null)
							{
								StringBuffer procedureStr = new StringBuffer();
								boolean inArgsExists = false;
								if (commonLibBO.returnIsSybase() == 1)
								{
									procedureStr.append("begin OUT_EXISTS EXEC ").append(procedureName).append(" ");
								}
								else
								{
									procedureStr.append("DECLARE OUT_EXISTS begin ").append(procedureName).append("("); // By Bilal For TP#750884
								}
								String argumentValue = "", argumentType, outPutDeclare = "", outVariable = "";
								for (int x = 0; x < custSegmentationParamCOs.size(); x++)
								{
									inArgsExists = true;
									argumentValue = custSegmentationParamCOs.get(x).getCtsSegmentParamVO().getPARAM_VALUE();

									// Modified By Bilal For TP#750884 Requested
									if (StringUtil.isNotEmpty(custSegmentationParamCOs.get(x).getCtsSegmentParamVO().getSESSION_ATTR_NAME()))
									{
										// argumentValue = custSegmentationParamCOs.get(x).getCtsSegmentParamVO().getSESSION_ATTR_NAME();
										argumentValue = "$P{".concat(custSegmentationParamCOs.get(x).getCtsSegmentParamVO().getPARAM_NAME()).concat("}");
										// argumentValue = prepareSessionValues(custSegmentationCO,
										// custSegmentationParamCOs.get(x).getCtsSegmentParamVO().getSESSION_ATTR_NAME());
									}

									// By Bilal for TP#750884
									if ("D".equals(custSegmentationParamCOs.get(x).getCtsSegmentParamVO().getPARAM_CLASS()))
									{
										argumentValue = "$P{".concat(custSegmentationParamCOs.get(x).getCtsSegmentParamVO().getPARAM_NAME()).concat("}");
									}

									argumentType = custSegmentationParamCOs.get(x).getCtsSegmentParamVO().getPARAM_TYPE();
									if (StringUtil.isNotEmpty(argumentType))
									{
										if ("VARCHAR".equals(argumentType.toUpperCase()) || "VARCHAR2".equals(argumentType.toUpperCase())
												|| "CHAR".equals(argumentType.toUpperCase()))
										{
											argumentValue = "'" + argumentValue + "'"; // By Bilal For TP#750884
										}
										else if ("DATE".equals(argumentType.toUpperCase()) || "DATETIME".equals(argumentType.toUpperCase()))
										{
											if (commonLibBO.returnIsSybase() == 1)
											{
												argumentValue = "CONVERT(DATE, '" + argumentValue + "', 103)"; // By Bilal For TP#750884
											}
											else
											{
												argumentValue = "to_date('" + argumentValue + "', 'dd/MM/yy')"; // By Bilal For TP#750884
											}
										}
									}

									if ("Q".equals(custSegmentationParamCOs.get(x).getCtsSegmentParamVO().getPARAM_CLASS())) // By Bilal For TP#750884
																																// replaced query param
									{
										argumentValue = null;
									}

									if (x > 0)
									{
										procedureStr.append(", ");
									}
									procedureStr.append(argumentValue);
								}

								List<String> outArguments = custSegmentationDAO.returnOutArgs(custSegmentationSC);
								if (outArguments != null)
								{
									for (int k = 0; k < outArguments.size(); k++)
									{
										argumentType = outArguments.get(k);
										if (StringUtil.isNotEmpty(argumentType))
										{
											if ("VARCHAR".equals(argumentType.toUpperCase()) || "VARCHAR2".equals(argumentType.toUpperCase())
													|| "CHAR".equals(argumentType.toUpperCase()))
											{
												if (commonLibBO.returnIsSybase() == 1)
												{
													outPutDeclare = outPutDeclare + "DECLARE @LS_" + k + " VARCHAR(500) ";
													outVariable = "@LS_" + k + " OUT";
												}
												else
												{
													outPutDeclare = outPutDeclare + "LS_" + k + " VARCHAR(500); "; // By Bilal For TP#750884
													outVariable = "LS_" + k;
												}
											}
											else if ("DATE".equals(argumentType.toUpperCase()) || "DATETIME".equals(argumentType.toUpperCase()))
											{
												if (commonLibBO.returnIsSybase() == 1)
												{
													outPutDeclare = outPutDeclare + "DECLARE @LD_" + k + " DATETIME ";
													outVariable = "@LD_" + k + " OUT";
												}
												else
												{
													outPutDeclare = outPutDeclare + "LD_" + k + " DATE; "; // By Bilal For TP#750884
													outVariable = "LD_" + k;
												}
											}
											else if ("NUMBER".equals(argumentType.toUpperCase()) || "NUMERIC".equals(argumentType.toUpperCase()))
											{
												if (commonLibBO.returnIsSybase() == 1)
												{
													outPutDeclare = outPutDeclare + "DECLARE @LL_" + k + " NUMERIC(38) "; // By Bilal For TP#750884
													outVariable = "@LL_" + k + " OUT";
												}
												else
												{
													outPutDeclare = outPutDeclare + "LL_" + k + " NUMBER(38); "; // By Bilal For TP#750884
													outVariable = "LL_" + k;
												}
											}
										}

										if (inArgsExists)
										{
											procedureStr.append(", ");
										}
										procedureStr.append(outVariable);
									}
								}
								if (outPutDeclare != null && !outPutDeclare.isEmpty())
								{
									String newPrc = procedureStr.toString();
									newPrc = newPrc.replace("OUT_EXISTS ", outPutDeclare);
									procedureStr = new StringBuffer(newPrc);
								}
								else
								{
									String newPrc = procedureStr.toString();
									newPrc = newPrc.replace("OUT_EXISTS ", "");
									procedureStr = new StringBuffer(newPrc);
								}
								if (commonLibBO.returnIsSybase() == 1)
								{
									procedureStr.append(" end ");
								}
								else
								{
									procedureStr.append("); end;");
								}

								CTS_SEGMENT_DETVOWithBLOBs segmentVO = new CTS_SEGMENT_DETVOWithBLOBs();
								segmentVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
								segmentVO.setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
								segmentVO.setLINE_NO(custSegmentationCOs.get(i).getCtsSegmentDetVO().getLINE_NO());
								segmentVO.setPROC_DETAILS(procedureStr.toString());
								segmentVO.setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on
																										// latest
								genericDAO.update(segmentVO);

								custSegmentationCO.getGridAllList().get(i).getCtsSegmentDetVO().setPROC_DETAILS(procedureStr.toString()); // By Bilal For
																																			// TP#750884
							}
						}
					}
				}
			}
		}

		return custSegmentationCO;
	}

	private String prepareSessionValues(CustSegmentationCO custSegmentationCO, String sessionArgument) throws BaseException
	{
		String sessionValue = null;
		if ("c_c".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getLoginCompCode());
		}
		else if ("c_d".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getCompanyName());
		}
		else if ("c_a_d".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getCompanyArabName());
		}
		else if ("b_c".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getLoginBraCode());
		}
		else if ("u_i".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getLoginUserId());
		}
		else if ("r_d".equals(sessionArgument))
		{
			sessionValue = DateUtil.format(custSegmentationCO.getRunningDate(), "dd/MM/yyyy");
		}
		else if ("b_c_c".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getBaseCurrencyCode());
		}
		else if ("b_c_n".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getBaseCurrencyName());
		}
		else if ("b_c_d".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getBaseCurrDecPoint());
		}
		else if ("e_c_c".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getExposCurCode());
		}
		else if ("e_c_n".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getExposCurName());
		}
		else if ("a".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getAppName());
		}
		else if ("c_t".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getClientType());
		}
		else if ("f_y".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getFiscalYear());
		}
		else if ("l".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getLanguage());
		}
		else if ("rtl".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getIsRTLDir());
		}
		else if ("b_d".equals(sessionArgument))
		{
			sessionValue = String.valueOf(custSegmentationCO.getBranchName());
		}
		return sessionValue;
	}

	public CustSegmentationCO trialProcess(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		// custSegmentationCO.setIsSegmentationScore("S"); //Rania - 718813 - Dynamic Customer Scoring on latest
		custSegmentationCO.setIsFromProcess(ConstantsCommon.ONE); // by bilal for TP#750884
		processSegment(custSegmentationCO);

		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
		custSegmentationSC.setBranchCode(custSegmentationCO.getLoginBraCode());
		custSegmentationSC.setUserId(custSegmentationCO.getLoginUserId());
		custSegmentationSC.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		custSegmentationSC.setIsSegmentationScore(custSegmentationCO.getIsSegmentationScore());
		custSegmentationSC.setCifNo(custSegmentationCO.getCifNo());
		// added by bilal for add some arguments in P_RET_SCORING_PROCESS
		custSegmentationSC.setCurrAppName(custSegmentationCO.getAppName());
		custSegmentationSC.setRunningDate(custSegmentationCO.getRunningDate());
		custSegmentationSC.setLanguage(custSegmentationCO.getLanguage());
		// end bilal

		custSegmentationSC = this.runTrialSegmentationProcess(custSegmentationSC);

		custSegmentationCO.setScore(custSegmentationSC.getScore());// Rania - 718813 - Dynamic Customer Scoring on latest

		if (custSegmentationSC.getErrorMessage() != null)
		{
			throw new BOException(custSegmentationSC.getErrorMessage());
		}

		custSegmentationCO.setErrorMessage(custSegmentationSC.getErrorMessage()); // Rania - 718813 - Dynamic Customer Scoring on latest

		// ###############################################
		// this.getCifOfTrialSegmentationProcess(temp);

		return custSegmentationCO;
	}

	@Override
	public CustSegmentationSC validateBranchCode(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		BRANCHESVO branchesVO = new BRANCHESVO();
		branchesVO.setCOMP_CODE(custSegmentationSC.getCompCode());
		branchesVO.setBRANCH_CODE(custSegmentationSC.getBranchCode());
		branchesVO = (BRANCHESVO) genericDAO.selectByPK(branchesVO);

		if (branchesVO == null || (branchesVO != null && branchesVO.getBRANCH_CODE() == null))
		{
			custSegmentationSC.setBranchCode(null);
			throw new BOException(MessageCodes.INVALID_BRANCH_CODE);
		}
		else
		{
			if (!NumberUtil.isEmptyDecimal(custSegmentationSC.getFromBranch()) || !NumberUtil.isEmptyDecimal(custSegmentationSC.getToBranch()))
			{
				int fromToBranch = (NumberUtil.emptyDecimalToNull(custSegmentationSC.getFromBranch()) == null
						? custSegmentationSC.getToBranch().compareTo(branchesVO.getBRANCH_CODE())
						: branchesVO.getBRANCH_CODE().compareTo(custSegmentationSC.getFromBranch()));
				if (fromToBranch == -1)
				{
					custSegmentationSC.setBranchCode(null);
					throw new BOException(MessageCodes.TO_BRANCH_CANNOT_BE_LESS_THAN_FROM_BRANCH);
				}
			}
		}

		return custSegmentationSC;
	}

	@Override
	public void loadCustSegmentationProcessGrid(CustSegmentationSC criteria) throws BaseException
	{
	    
	    	String automaticApprove = "0";
	    	CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
	    	
		criteria.setSord(null);
		criteria.setSidx(null);
		
		custSegmentationDAO.deleteFromCTS_SEG_CIF_EXEC_RESULT_TEMP(criteria);
		custSegmentationDAO.deleteFromCTS_SEG_CIF_EXEC_RESULT(criteria);
	
		List<CustSegmentationCO> ctsSegmentVOList = custSegmentationDAO.returnCustSegmentationList(criteria);
		List<CustSegmentationCO> ctsSegmentVOForCifList = custSegmentationDAO.returnCifListForProcess(criteria);
		    
		if(ctsSegmentVOForCifList.size() > 0)
		{
		    for (CustSegmentationCO custSegmentationCOCif : ctsSegmentVOForCifList)
		    {
			criteria.setCifNo(custSegmentationCOCif.getCifNo());
			
			if("FP".equals(criteria.getProcessType()))
	        	{
	        	    custSegmentationDAO.updateSegmentHistory(criteria);
	        	}
			
			if (ctsSegmentVOList.size() > 0)
			{
			    for (CustSegmentationCO custSegmentationCO : ctsSegmentVOList)
			    {
				criteria.setBranchCode(custSegmentationCO.getCtsSegmentVO().getBRANCH_CODE());
				criteria.setSegment_code(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
				
				custSegmentationSC =this.runTrialSegmentationProcess(criteria);
				
				
				if(NumberUtil.emptyDecimalToZero(custSegmentationSC.getIsClassified()).compareTo(BigDecimal.ONE) == 0 
					&& "FP".equals(criteria.getProcessType()))
    			{
    			    custSegmentationDAO.insertSegmentHistory(criteria);
    			}
				
			    }
			    criteria.setIsSegmentationScore("S");
			    custSegmentationDAO.insertSegProcessResult(criteria);
			    
			    
			  CTS_SEGMENTVO ctsSegmentVO =  custSegmentationDAO.checkAutoApprove(criteria);
			    
			   if(ctsSegmentVO != null && "1".equals(ctsSegmentVO.getAUTOMATIC_APPROVE_YN()) && "FP".equals(criteria.getProcessType()))
			    {
				criteria.setStatus("P");
				criteria.setSegment_code(ctsSegmentVO.getSEGMENT_CODE());
				approveCustSegProcess(criteria);
			    }
			    
			}
			
		/*// Rania - Customers Segmentation Enhancement
		if("FP".equals(criteria.getProcessType()))
		{
		    custSegmentationDAO.updateSegmentHistory(criteria);
		    custSegmentationDAO.insertSegmentHistory(criteria);
		}
		// End Rania
*/		    }
		    
    	    // Rania - Customers Segmentation
    	    // Send Notification Alert
    	    AlertsRequestParamSC alertsRequestParamSC = new AlertsRequestParamSC();
    
    	    alertsRequestParamSC.setSenderUserId(criteria.getUserId());
    	    alertsRequestParamSC.setCompCode(criteria.getCompCode());
    	    alertsRequestParamSC.setBranchCode(criteria.getBranchCode());
    	    alertsRequestParamSC.setTodoApplication("RET");
    	    alertsRequestParamSC.setDateReceived(criteria.getRunningDate());
    	    alertsRequestParamSC.setTodoParam("1");
    	    alertsRequestParamSC.setTodoAlert("@N");
    	    alertsRequestParamSC.setTodoProgRef("CSG00SEGSPMT");
    	    String desc = "";
    	    desc = CustSegmentationConstant.SEG_PROCESS_UPDATED_PLEASE_TAKE_ACTION;
    	    alertsRequestParamSC.setAlertDesc(desc);
    
    	    ArrayList<CTSTELLERVO> accessBySegmentProcessUserList = custSegmentationDAO.returnUsrAccessBySegmentProcess(criteria);
    	    
    	    for(int i = 0; i < accessBySegmentProcessUserList.size(); i++)
    	    {
    		alertsRequestParamSC.setReceiverUserId(accessBySegmentProcessUserList.get(i).getUSER_ID());
    		alertsBO.sendAlert(alertsRequestParamSC);
    	    }
    	    // End Rania
		}
		
		    fillRecommendedDate(criteria);	
	}
	
	private void fillRecommendedDate(CustSegmentationSC criteria) throws BaseException
	{
	   
	    CustSegmentationSC custSegmentationSc  =(new Cloner()).deepClone(criteria);
	    
	    custSegmentationSc.setStatus("A");
	    
	    //no need since automatic approve
	    /*if("TP".equals(custSegmentationSc.getProcessType()))
	    {
		custSegmentationSc.setStatus("A");
	    }
	    else  if("FP".equals(custSegmentationSc.getProcessType()))		
	    {
		custSegmentationSc.setStatus("P");
	    }*/
	    
   
	    custSegmentationSc.setNbRec(-1);
	    
	    List<CustSegmentationProcessCO> listOfFinalrecords = returnCustSegmentationProcessList(custSegmentationSc);
	    
	    
	    for(CustSegmentationProcessCO listCO : listOfFinalrecords)
	    {
		BigDecimal currentSegment =listCO.getCurrentSegment();
		BigDecimal recommendedSegment = listCO.getCtsSegmentCifExResVO().getRECOMMENED_SEGMENT();
		listCO.setLoginUserId(custSegmentationSc.getUserId());
		
		//if recommend and current are different
		if(listCO.getCtsSegmentCifExResVO() != null &&  !NumberUtil.isEmptyDecimal(currentSegment)
			 && !NumberUtil.isEmptyDecimal(recommendedSegment) 
			 && currentSegment.compareTo(recommendedSegment) != 0)
		{
		    
		      if( checkHistoryRecordExists(listCO)>0)		    
		      {			  
			  continue;
		      }
		      else 
		      {
			  custSegmentationDAO.fillRecommendedDateHistory(listCO);	  
		      }
		}
		
	    }
	      
	}


	@Override
	public CustSegmentationSC dependencyByCif(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		CifSC criteria = new CifSC();
		criteria.setCompCode(custSegmentationSC.getCompCode());
		criteria.setUserId(custSegmentationSC.getUserId());
		criteria.setCif_no(custSegmentationSC.getCifNo());

		if (!CoreCommonConstants.AML.equals(custSegmentationSC.getAppName()))
		{
			CIFVO cifVO = cifBO.returnCifByNo(criteria);

			if (cifVO == null || (cifVO != null && cifVO.getCIF_NO() == null))
			{
				custSegmentationSC.setCifNo(null);
				throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
			}
			else
			{
				if ("AR".equals(criteria.getLang()))
				{
					custSegmentationSC.setCifDesc(cifVO.getSHORT_NAME_AR());
				}
				else
				{
					custSegmentationSC.setCifDesc(cifVO.getSHORT_NAME_ENG());
				}
			}
		}
		else // added by nour for 777000
		{

			AML_CUSTOMERVO cifVO = amlCifBO.returnCifByNo(criteria);

			if (cifVO == null || (cifVO != null && cifVO.getCIF_NO() == null))
			{
				custSegmentationSC.setCifNo(null);
				throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
			}
			else
			{
				if ("AR".equals(criteria.getLang()))
				{
					custSegmentationSC.setCifDesc(cifVO.getSHORT_NAME_ARAB());
				}
				else
				{
					custSegmentationSC.setCifDesc(cifVO.getSHORT_NAME_ENG());
				}
			}

		}
		return custSegmentationSC;
	}

	@Override
	public Integer returnCustSegmentationProcessListCount(CustSegmentationSC criteria) throws BaseException
	{
		return custSegmentationDAO.returnCustSegmentationProcessListCount(criteria);
	}

	@Override
	public List returnCustSegmentationProcessList(CustSegmentationSC criteria) throws BaseException
	{
		return custSegmentationDAO.returnCustSegmentationProcessList(criteria);
	}

	@Override
	public Integer getCifOfTrialSegmentationProcessListCount(CustSegmentationSC criteriaSC) throws BaseException
	{
		return custSegmentationDAO.getCifOfTrialSegmentationProcessListCount(criteriaSC);
	}

	@Override
	public List getCifOfTrialSegmentationProcessList(CustSegmentationSC criteriaSC) throws BaseException
	{
		return custSegmentationDAO.getCifOfTrialSegmentationProcessList(criteriaSC);
	}

	@Override
	public void approveCustSegProcess(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		CIF_EXTENDEDVO cifExt = new CIF_EXTENDEDVO();
		cifExt.setCOMP_CODE(custSegmentationSC.getCompCode());
		cifExt.setCIF_NO(custSegmentationSC.getCifNo());

		cifExt.setSEGMENT_CODE(custSegmentationSC.getSegment_code());

		if ((CIF_EXTENDEDVO) genericDAO.selectByPK(cifExt) == null)
		{

			genericDAO.insert(cifExt);
		}
		else
		{
			genericDAO.update(cifExt);
		}

		custSegmentationDAO.approveCustSegProcess(custSegmentationSC);
		custSegmentationDAO.updateSegmentHistory(custSegmentationSC);
        	custSegmentationDAO.insertSegmentHistory(custSegmentationSC);
	}

	@Override
	public void rejectCustSegProcess(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		custSegmentationDAO.rejectCustSegProcess(custSegmentationSC);
	}

	@Override
	public void permanentRejectCustSegProcess(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		custSegmentationDAO.rejectCustSegProcess(custSegmentationSC);
		CTS_SEGMENT_CIF_EXCLUDEVO ctsSegmentCifExcludeVO = new CTS_SEGMENT_CIF_EXCLUDEVO();
		ctsSegmentCifExcludeVO.setCOMP_CODE(custSegmentationSC.getCompCode());
		ctsSegmentCifExcludeVO.setCIF_NO(custSegmentationSC.getCifNo());
		ctsSegmentCifExcludeVO.setSEGMENT_CODE(custSegmentationSC.getSegment_code());
		ctsSegmentCifExcludeVO.setSEGMENT_TYPE(custSegmentationSC.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on latest
		genericDAO.insert(ctsSegmentCifExcludeVO);
	}

	/**
	 * @author raniaalbitar
	 * @param criteria
	 * @return
	 * @throws BaseException
	 *             718813 - Dynamic Customer Scoring on latest
	 */
	public int returnSegmentationLookupCount(GridParamsSC criteria) throws BaseException
	{
		return custSegmentationDAO.returnSegmentationLookupCount(criteria);
	}

	public List returnSegmentationLookup(GridParamsSC criteria) throws BaseException
	{
		return custSegmentationDAO.returnSegmentationLookup(criteria);
	}

	/**
	 * @author raniaalbitar 718813 - Dynamic Customer Scoring on latest
	 */
	public CustSegmentationSC dependencyByMainCif(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		CifSC criteria = new CifSC();
		criteria.setCompCode(custSegmentationSC.getCompCode());
		criteria.setUserId(custSegmentationSC.getUserId());
		criteria.setCif_no(custSegmentationSC.getCifNo());

		// if (!CoreCommonConstants.AML.equals(custSegmentationSC.getAppName()))
		// {
		CIFVO cifVO = cifBO.returnCifByNo(criteria);

		if (cifVO == null || (cifVO != null && cifVO.getCIF_NO() == null))
		{
			custSegmentationSC.setCifNo(null);
			throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
		}
		else
		{
			if ("AR".equals(criteria.getLang()))
			{
				custSegmentationSC.setCifDesc(cifVO.getSHORT_NAME_AR());
			}
			else
			{
				custSegmentationSC.setCifDesc(cifVO.getSHORT_NAME_ENG());
			}
		}
		// }
		// else // added by nour for 777000
		// {
		//
		// AML_CUSTOMERVO cifVO = amlCifBO.returnCifByNo(criteria);
		//
		// if (cifVO == null || (cifVO != null && cifVO.getCIF_NO() == null))
		// {
		// custSegmentationSC.setCifNo(null);
		// throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
		// }
		// else
		// {
		// if ("AR".equals(criteria.getLang()))
		// {
		// custSegmentationSC.setCifDesc(cifVO.getSHORT_NAME_ARAB());
		// }
		// else
		// {
		// custSegmentationSC.setCifDesc(cifVO.getSHORT_NAME_ENG());
		// }
		// }
		//
		// }

		return custSegmentationSC;
	}

	/**
	 * @author raniaalbitar 718813 - Dynamic Customer Scoring on latest
	 */
	public CustSegmentationSC dependencyByMainSegmentCode(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		if(NumberUtil.emptyDecimalToNull(custSegmentationSC.getSegmentCode()) != null)
		{

		    CustSegmentationSC criteria = (new Cloner()).deepClone(custSegmentationSC);

		    custSegmentationSC = custSegmentationDAO.returnMainSegmentCode(custSegmentationSC);

		    if(custSegmentationSC == null || (custSegmentationSC != null
			    && NumberUtil.emptyDecimalToNull(custSegmentationSC.getSegmentCode()) == null))
		    {
			throw new BOException(MessageCodes.INVALID_MISSING_SEGMENT_CODE);
		    }

		    if(custSegmentationSC != null && !NumberUtil.isEmptyDecimal(custSegmentationSC.getSegmentCode())
			    && "S".equals(criteria.getIsSegmentationScore()))
		    {
			checkSegmentCodeAccess(criteria);
		    }
		}

		custSegmentationSC.setSegmentCode(NumberUtil.emptyDecimalToNull(custSegmentationSC.getSegmentCode()));

		return custSegmentationSC;
	    }

	
	
	private void checkSegmentCodeAccess(CustSegmentationSC criteria) throws BaseException
	{
	     int allowedSegmentCount = custSegmentationDAO.returnUserAccessSegmentCount(criteria);
	    
	     if(allowedSegmentCount == 0)
	     {
		 throw new BOException(MessageCodes.USER_NO_ACCESS, new String[] { "segment_code_key" });
	     }
	}
	
	
	/**
	 * @author raniaalbitar 718813 - Dynamic Customer Scoring on latest
	 */
	public CustSegmentationSC dependencyByGroupCode(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		if (NumberUtil.emptyDecimalToNull(custSegmentationSC.getGroupCode()) != null)
		{
			custSegmentationSC = custSegmentationDAO.returnSegmentGroupCode(custSegmentationSC);

			if (custSegmentationSC == null || (custSegmentationSC != null && NumberUtil.emptyDecimalToNull(custSegmentationSC.getGroupCode()) == null))
			{
				throw new BOException(MessageCodes.INVALID_MISSING_GROUP_CODE);
			}
		}

		custSegmentationSC.setGroupCode(NumberUtil.emptyDecimalToNull(custSegmentationSC.getGroupCode()));

		return custSegmentationSC;
	}

	/**
	 * @author raniaalbitar
	 * @param criteria
	 * @throws BaseException
	 *             718813 - Dynamic Customer Scoring on latest
	 */

	public void deleteFromCTS_SEG_CIF_EXEC_RESULT_TEMP(CustSegmentationSC criteria) throws BaseException
	{
		custSegmentationDAO.deleteFromCTS_SEG_CIF_EXEC_RESULT_TEMP(criteria);
	}

	/**
	 * @author raniaalbitar
	 * @param criteria
	 * @throws BaseException
	 *             718813 - Dynamic Customer Scoring on latest
	 */

	public void deleteFromCTS_SEG_CIF_EXEC_RESULT(CustSegmentationSC criteria) throws BaseException
	{
		custSegmentationDAO.deleteFromCTS_SEG_CIF_EXEC_RESULT_TEMP(criteria);
	}

	/**
	 * @author raniaalbitar 718813 - Dynamic Customer Scoring on latest
	 */

	public List<CustSegmentationCO> returnCustSegmentationDetails(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		return custSegmentationDAO.returnCustSegmentationDetails(custSegmentationSC);
	}

	/**
	 * @author raniaalbitar 718813 - Dynamic Customer Scoring on latest
	 */

	public void insertSegProcessResult(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		custSegmentationDAO.insertSegProcessResult(custSegmentationSC);
	}

	public void totalPercentageValidation(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		BigDecimal totalLabelPerc = BigDecimal.ZERO;

		CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
		cifControlVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());

		cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);

		Map<String, CTS_SEGMENT_DETVOWithBLOBs> hm = new HashMap<String, CTS_SEGMENT_DETVOWithBLOBs>();

		if ("SC".equals(custSegmentationCO.getCtsSegmentVO().getSEGMENT_TYPE()))
		{
			for (CustSegmentationCO rowCO : custSegmentationCO.getGridAllList())
			{
				if (NumberUtil.emptyDecimalToNull(rowCO.getCtsSegmentDetVO().getLABEL_CODE()) == null
						&& (cifControlVO != null )) // Rania - ABSAI180073 //&& "C".equals(cifControlVO.getSCORING_CALC_CRITERIA_LIST()) //by bilal for TP#935532
				{
					throw new BOException(MessageCodes.MISSING_LABEL_CODE);
				}

				if (hm.size() == 0)
				{
					hm.put(rowCO.getCtsSegmentDetVO().getLABEL_CODE().toString(), rowCO.getCtsSegmentDetVO());
				}
				else
				{

					for (int i = 0; i < hm.size(); i++)
					{
						if (hm.get(rowCO.getCtsSegmentDetVO().getLABEL_CODE().toString()) != null && rowCO.getCtsSegmentDetVO().getLABEL_CODE()
								.compareTo(hm.get(rowCO.getCtsSegmentDetVO().getLABEL_CODE().toString()).getLABEL_CODE()) == 0)
						{
							if (rowCO.getCtsSegmentDetVO().getLABEL_PERC()
									.compareTo(hm.get(rowCO.getCtsSegmentDetVO().getLABEL_CODE().toString()).getLABEL_PERC()) != 0)
							{
								throw new BOException(MessageCodes.PERC_MUST_BE_UNIQUE_PER_LABEL_CODE);
							}
						}
						else
						{
							hm.put(rowCO.getCtsSegmentDetVO().getLABEL_CODE().toString(), rowCO.getCtsSegmentDetVO());
						}
					}
				}
			}
			//commented by bilal for BUG#935532
			//&& "C".equals(cifControlVO.getSCORING_CALC_CRITERIA_LIST()) // Rania// -// ABSAI180073
			if (!"dep".equals(custSegmentationCO.getFromDepFunc()) && (cifControlVO != null)) 
			{
				for (Map.Entry<String, CTS_SEGMENT_DETVOWithBLOBs> entry : hm.entrySet())
				{
					totalLabelPerc = totalLabelPerc.add(NumberUtil.emptyDecimalToZero(entry.getValue().getLABEL_PERC()));
				}
				if ((totalLabelPerc.compareTo(new BigDecimal(100)) > 0 || totalLabelPerc.compareTo(new BigDecimal(100)) < 0) && hm.size() > 0)
				{
					throw new BOException(MessageCodes.PERC_MUST_NOT_EXCEED_HUNDRED);
				}
			}
		}
	}

	/**
	 * @author raniaalbitar 718813 - Dynamic Customer Scoring on latest
	 */
	public void insertAmlCifScoreResult(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		custSegmentationDAO.insertAmlCifScoreResult(custSegmentationSC);
	}

	public void deleteSegment(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
		CTS_SEGMENTVO deleteVO = new CTS_SEGMENTVO();

		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());
		custSegmentationSC.setSegmentCode(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		// Added By Ali for TP#864398
		if (!custSegmentationCO.getIsSegmentationScore().equals(CustSegmentationConstant.BUSINESS_RULES))
		{
			int count = custSegmentationDAO.returnCifCountBySegment(custSegmentationSC);

			if (count > 0)
			{
				throw new BOException(MessageCodes.CANNOT_DELETE_CIF_LINKED_TO_SEGMENT);
			}
		}
	
		deleteVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
		deleteVO.setSEGMENT_CODE(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE());
		deleteVO.setSTATUS("D");
		deleteVO.setDELETED_BY(custSegmentationCO.getLoginUserId());
		deleteVO.setDELETED_DATE(commonLibBO.addSystemTimeToDate(custSegmentationCO.getRunningDate()));
		deleteVO.setSEGMENT_TYPE(custSegmentationCO.getIsSegmentationScore()); // Rania - 718813 - Dynamic Customer Scoring on latest
		// added by nour for 777000
		deleteVO.setBRANCH_CODE(custSegmentationCO.getLoginBraCode());
		deleteVO.setDAY(custSegmentationCO.getCtsSegmentVO().getDAY());
		deleteVO.setSEGMENT_DESC(custSegmentationCO.getCtsSegmentVO().getSEGMENT_DESC());
		deleteVO.setLONG_DESC_ENG(custSegmentationCO.getCtsSegmentVO().getLONG_DESC_ENG());
		deleteVO.setCREATED_BY(custSegmentationCO.getCtsSegmentVO().getCREATED_BY());
		deleteVO.setPERIODICITY(custSegmentationCO.getCtsSegmentVO().getPERIODICITY());
		deleteVO.setDATE_UPDATED(custSegmentationCO.getCtsSegmentVO().getDATE_UPDATED());
		deleteVO.setDATE_CREATED(custSegmentationCO.getCtsSegmentVO().getDATE_CREATED());
		// end nour 
		
		//by bilal for TP#936108
		if(ConstantsCommon.TRUE.equals(custSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()))
		{
			custSegmentationCO.getCtsSegmentVO().setMAIN_SCORE_YN(ConstantsCommon.ONE);
		}
		else if(ConstantsCommon.FALSE.equals(custSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()))
		{
			custSegmentationCO.getCtsSegmentVO().setMAIN_SCORE_YN(ConstantsCommon.ZERO);
		}
		//end bilal
		
		deleteVO.setMAIN_SCORE_YN(custSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN());//by bilal for TP#936108
		genericDAO.update(deleteVO);
		// added by nour for 777000;
		// Update the row
		NumberUtil.resetEmptyValues(deleteVO);// added by nour for 864398

		custSegmentationCO.setCtsSegmentVO(deleteVO);
		CustSegmentationCO oldCustSegmentationCO = (CustSegmentationCO) custSegmentationCO.getAuditObj();
		
		//by bilal for TP#936108
		if(ConstantsCommon.TRUE.equals(oldCustSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()))
		{
			oldCustSegmentationCO.getCtsSegmentVO().setMAIN_SCORE_YN(ConstantsCommon.ONE);
		}
		else if(ConstantsCommon.FALSE.equals(oldCustSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()))
		{
			oldCustSegmentationCO.getCtsSegmentVO().setMAIN_SCORE_YN(ConstantsCommon.ZERO);
		}
		//end bilal
		
		auditBO.callAudit(oldCustSegmentationCO.getCtsSegmentVO(),deleteVO, custSegmentationCO.getAuditRefCO());
		auditBO.insertAudit(custSegmentationCO.getAuditRefCO());
		// end nour
	}

	/**
	 * Added By Ali for TP#864398
	 */
	public CustSegmentationCO validateStartEndDates(CustSegmentationCO tempCO) throws BaseException
	{
		Date startDate = tempCO.getCtsSegmentVO().getSTART_DATE();
		Date endDate = tempCO.getCtsSegmentVO().getEND_DATE();

		if (startDate != null && endDate != null)
		{
			// Start Date greater than End Date
			if (startDate.compareTo(endDate) == 1)
			{
				throw new BOException(MessageCodes.START_DATE_MUST_BE_BEFORE_END_DATE);
			}

			else if (startDate.compareTo(endDate) > 1)
			{
				throw new BOException(MessageCodes.END_DATE_MUST_BE_AFTER_START_DATE);
			}
		}

		return tempCO;
	}

	/**
	 * Added By Ali for TP#864398
	 */
	public CustSegmentationCO hideShowSuspensionReason(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		applyDynScreenDisplay("SUSPENSION_REASON", "custSegmentationCO.ctsSegmentVO.SUSPENSION_REASON", ConstantsCommon.ACTION_TYPE_READONLY, "0",
				custSegmentationCO.getBuisnessElement(), null);

		return custSegmentationCO;
	}

	/**
	 * Added By nour for TP#864398
	 */

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> updateAfterAppVis(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		SYS_PARAM_SCREEN_DISPLAYVO businessElement;
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(custSegmentationCO.getCtsSegmentVO().getCOMP_CODE());
		reqFieldSC.setProgRef(custSegmentationCO.getProgRef());
		reqFieldSC.setAppName(custSegmentationCO.getAppName());
		reqFieldSC.setBranchCode(custSegmentationCO.getCtsSegmentVO().getBRANCH_CODE());
//		if (CustSegmentationConstant.AML_APP.equals(custSegmentationCO.getAppName()))
//		{
//			businessElement = custSegmentationCO.getHm().get("lookuptxt_suspend_reason_ref");
//
//			if (businessElement == null)
//			{
//				businessElement = custSegmentationCO.getHm().get("custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF");
//
//				if (businessElement == null)
//				{
//					reqFieldSC.setElementName("custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF");
//					businessElement = commonLibBO.returnParamScreenDisplay(reqFieldSC);
//				}
//			}
//
//			businessElement.setIS_MANDATORY(BigDecimal.ONE);
//			businessElement.setOverWriteReadOnly(true);
//			businessElement.setIS_READONLY(BigDecimal.ZERO);
//			custSegmentationCO.getHm().put("lookuptxt_suspend_reason_ref", businessElement);
//			custSegmentationCO.getHm().put("custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF", businessElement);
//		}
//		else
//		{
		 // commented by nour for request  974623

//			businessElement = custSegmentationCO.getHm().get("lookuptxt_suspend_reason");
//			if (businessElement == null)
//			{
//				businessElement = custSegmentationCO.getHm().get("custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_CODE");
//
//				if (businessElement == null)
//				{
//					reqFieldSC.setElementName("custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_CODE");
//					businessElement = commonLibBO.returnParamScreenDisplay(reqFieldSC);
//				}
//			}
//
//			businessElement.setIS_MANDATORY(BigDecimal.ONE);
//			businessElement.setOverWriteReadOnly(true);
//			businessElement.setIS_READONLY(BigDecimal.ZERO);
//			custSegmentationCO.getHm().put("lookuptxt_suspend_reason", businessElement);
//			custSegmentationCO.getHm().put("custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_CODE", businessElement);
		// end nour
//		}
		businessElement = custSegmentationCO.getHm().get("suspend_reason");
		if (businessElement == null)
		{
			businessElement = custSegmentationCO.getHm().get("custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF");

			if (businessElement == null)
			{
				reqFieldSC.setElementName("custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF");
				businessElement = commonLibBO.returnParamScreenDisplay(reqFieldSC);
			}
		}

		businessElement.setIS_MANDATORY(BigDecimal.ONE);
		businessElement.setOverWriteReadOnly(true);
		businessElement.setIS_READONLY(BigDecimal.ZERO);
		custSegmentationCO.getHm().put("suspend_reason", businessElement);
		custSegmentationCO.getHm().put("custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF", businessElement);
		return custSegmentationCO.getHm();
	}

	public CustSegmentationCO dependencyByReasonCode(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		int exits = 0;
		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();

		custSegmentationSC.setReasonCode(custSegmentationCO.getCtsSegmentVO().getSUSPEND_REASON_CODE());
		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());

		exits = custSegmentationDAO.dependencyByReasonCode(custSegmentationSC);

		if (exits == 1)
		{
			String criteriaDesc = custSegmentationDAO.returnReasonDesc(custSegmentationSC);
			custSegmentationCO.setReasonName(criteriaDesc);
		}
		else
		{
			throw new BOException(MessageCodes.INVALID_MISSING_REASON);
		}
		return custSegmentationCO;
	}

	@Override
	public CustSegmentationCO dependencyByReasonRef(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		int exits = 0;
		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();

		custSegmentationSC.setReasonRef(custSegmentationCO.getCtsSegmentVO().getSUSPEND_REASON_REF());
		custSegmentationSC.setCompCode(custSegmentationCO.getLoginCompCode());

		exits = custSegmentationDAO.dependencyByReasonRef(custSegmentationSC);

		if (exits == 1)
		{
			String criteriaDesc = custSegmentationDAO.returnReasonDesc(custSegmentationSC);
			custSegmentationCO.setReasonNameRef(criteriaDesc);
		}
		else
		{
			throw new BOException(MessageCodes.INVALID_MISSING_REASON);
		}
		return custSegmentationCO;
	}

	@Override
	public CustSegmentationCO dependencyByPeriodicity(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		if (CustSegmentationConstant.WEEKLY.equals(custSegmentationCO.getCtsSegmentVO().getPERIODICITY()))
		{
			RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
			reqFieldSC.setCompCode(custSegmentationCO.getLoginCompCode());
			reqFieldSC.setBranchCode(custSegmentationCO.getLoginBraCode());
			reqFieldSC.setProgRef(custSegmentationCO.getProgRef());
			reqFieldSC.setAppName(custSegmentationCO.getAppName());
			applyDynScreenDisplay(new String[] { "day" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ONE, custSegmentationCO.getScreenParam(),
					reqFieldSC);

			applyDynScreenDisplay(new String[] { "lbl_On" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ONE, custSegmentationCO.getScreenParam(),
					reqFieldSC);

		}
		else
		{
			RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
			reqFieldSC.setCompCode(custSegmentationCO.getLoginCompCode());
			reqFieldSC.setBranchCode(custSegmentationCO.getLoginBraCode());
			reqFieldSC.setProgRef(custSegmentationCO.getProgRef());
			reqFieldSC.setAppName(custSegmentationCO.getAppName());
			applyDynScreenDisplay(new String[] { "day" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ZERO, custSegmentationCO.getScreenParam(),
					reqFieldSC);
			applyDynScreenDisplay(new String[] { "lbl_On" }, ConstantsCommon.ACTION_TYPE_VISIBLE, ConstantsCommon.ZERO, custSegmentationCO.getScreenParam(),
					reqFieldSC);

		}

		return custSegmentationCO;
	}

	public CustSegmentationDAO getCustSegmentationDAO()
	{
		return custSegmentationDAO;
	}

	public void setCustSegmentationDAO(CustSegmentationDAO custSegmentationDAO)
	{
		this.custSegmentationDAO = custSegmentationDAO;
	}

	public CriteriaBO getCriteriaBO()
	{
		return criteriaBO;
	}

	public void setCriteriaBO(CriteriaBO criteriaBO)
	{
		this.criteriaBO = criteriaBO;
	}

	public ProcedureIdBO getProcedureIdBO()
	{
		return procedureIdBO;
	}

	public void setProcedureIdBO(ProcedureIdBO procedureIdBO)
	{
		this.procedureIdBO = procedureIdBO;
	}

	public CifBO getCifBO()
	{
		return cifBO;
	}

	public void setCifBO(CifBO cifBO)
	{
		this.cifBO = cifBO;
	}

	public CoreCommonProcedureBO getCoreCommonProcedureBO()
	{
		return coreCommonProcedureBO;
	}

	public void setCoreCommonProcedureBO(CoreCommonProcedureBO coreCommonProcedureBO)
	{
		this.coreCommonProcedureBO = coreCommonProcedureBO;
	}

	// By Bilal For TP#750884
	@Override
	public List<AML_PARAM_MAPPINGVO> loadMultiSelectListGrid(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		return custSegmentationDAO.loadMultiSelectListGrid(custSegmentationSC);
	}

	// By Bilal For TP#750884
	public Integer getMaxLineNo(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		int lineNo = 0;

		lineNo = NumberUtil.nullToZero(custSegmentationDAO.getMaxLineNo(custSegmentationSC));

		lineNo++;

		return lineNo;
	}

	// By Bilal For TP#750884
	public Integer getMaxGaArgId(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		int gaArgId = 0;

		gaArgId = NumberUtil.nullToZero(custSegmentationDAO.getMaxGaArgId(custSegmentationSC));

		gaArgId++;

		return gaArgId;
	}

	/**
	 * Add new function to called when retrieved from CriteriaParam or CtsSegmentationParam
	 * 
	 * @param list
	 * @param custSegmentationSC
	 * @return list
	 * @throws BaseException
	 */
	public List fillListMultiSelect(List list, CustSegmentationSC custSegmentationSC) throws BaseException
	{
		List list1 = list;
		CustSegmentationSC custSegmentationSC1 = custSegmentationSC;
		BigDecimal segmentCode = custSegmentationSC.getSegment_code();
		try
		{
			for (int i = 0; i < list1.size(); i++)
			{
				if ((list1.get(i) instanceof CustSegmentationParamCO))
				{
					if (((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().getPARAM_NAME().contains("_rule_code")
							|| ((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().getPARAM_NAME().contains("_RULE_CODE"))
					{
						((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().setPARAM_VALUE(segmentCode.toString());
						((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().setPARAM_CLASS("F");
					}
					if (((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().getPARAM_NAME().contains("criteria_code")
							|| ((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().getPARAM_NAME().contains("CRITERIA_CODE"))
					{
						((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().setPARAM_VALUE(custSegmentationSC.getCriteria_code().toString());
						((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().setPARAM_CLASS("F");
					}
					if ("M".equals(((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().getENTITY_TYPE()))
					{
						((CustSegmentationParamCO) list1.get(i)).setQuerySelectParamGridStr(
								"{\"root\":".concat(PathJSONUtil.serialize(((CustSegmentationParamCO) list1.get(i)), null, null, false, true)).concat("}"));
					}
					else
					{
						if (CriteriaConstant.PARAM_CLASS_Q.equals(((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().getPARAM_CLASS()))
						{
							custSegmentationSC1.setQueryId(((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().getPARAM_QUERY_ID());
							//by bilal, on load get all value where criteria and business rule not into consideration the param name
							custSegmentationSC1.setParamName(((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().getPARAM_NAME());
							List<AML_PARAM_MAPPINGVO> lstMultiSelect;
							lstMultiSelect = loadMultiSelectListGrid(custSegmentationSC1);
							((CustSegmentationParamCO) list1.get(i))
									.setJsonMultiselectArray("{\"root\":".concat(PathJSONUtil.serialize(lstMultiSelect, null, null, false, true)).concat("}"));
							((CustSegmentationParamCO) list1.get(i)).setLstMultiSelect(lstMultiSelect);
							((CustSegmentationParamCO) list1.get(i))
									.setOldQueryIdParam(((CustSegmentationParamCO) list1.get(i)).getCtsSegmentParamVO().getPARAM_QUERY_ID());
						}
					}
					((CustSegmentationParamCO) list1.get(i)).setIsSegmentationScore(custSegmentationSC.getIsSegmentationScore()); // by bilal for TP#750884
				}
				else if ((list1.get(i) instanceof CriteriaParamCO))
				{
					if (((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().getPARAM_NAME().contains("_rule_code")
							|| ((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().getPARAM_NAME().contains("_RULE_CODE"))
					{
						((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().setPARAM_VALUE(segmentCode.toString());
						((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().setPARAM_CLASS("F");
					}
					if (((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().getPARAM_NAME().contains("criteria_code")
							|| ((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().getPARAM_NAME().contains("CRITERIA_CODE"))
					{
						((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().setPARAM_VALUE(custSegmentationSC.getCriteria_code().toString());
						((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().setPARAM_CLASS("F");
					}
					if ("M".equals(((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().getENTITY_TYPE()))
					{
						((CriteriaParamCO) list1.get(i)).setQuerySelectParamGridStr(
								"{\"root\":".concat(PathJSONUtil.serialize(((CriteriaParamCO) list1.get(i)), null, null, false, true)).concat("}"));
					}
					else
					{
						if (CriteriaConstant.PARAM_CLASS_Q.equals(((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().getPARAM_CLASS()))
						{
							custSegmentationSC1.setQueryId(((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().getPARAM_QUERY_ID());
							custSegmentationSC1.setSegment_code(BigDecimal.ZERO);
							List<AML_PARAM_MAPPINGVO> lstMultiSelect = loadMultiSelectListGrid(custSegmentationSC1);
							((CriteriaParamCO) list1.get(i))
									.setJsonMultiselectArray("{\"root\":".concat(PathJSONUtil.serialize(lstMultiSelect, null, null, false, true)).concat("}"));
							((CriteriaParamCO) list1.get(i)).setLstMultiSelect(lstMultiSelect);
							((CriteriaParamCO) list1.get(i)).setOldQueryIdParam(((CriteriaParamCO) list1.get(i)).getCtsCriteriaParamVO().getPARAM_QUERY_ID());
						}
					}
				}
			}
			custSegmentationSC.setSegment_code(segmentCode);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return list1;
	}

	@Override
	public List<CustSegmentationParamCO> returnReplaceArgumentSelect(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		return custSegmentationDAO.returnReplaceArgumentSelect(custSegmentationSC);
	}

	/**
	 * @author RaniaAlBitar ABSAI180073
	 * @return
	 */
	public void insertCifScoreResult(CustSegmentationSC custSegmentationSC) throws BaseException
	{
		custSegmentationDAO.insertCifScoreResult(custSegmentationSC);
	}

	/**
	 * @author RaniaAlBitar ABSAI180073
	 * @return
	 */

	public int dependencyByMainScore(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		return custSegmentationDAO.returnMainScoreCount(custSegmentationCO);
	}

	public CustSegmentationCO returnQueryID(CustSegmentationCO custSegmentationCO) throws BaseException
	{
		QueryIdSC queryIdSC = new QueryIdSC();
		QueryIdCO queryIdCO = new QueryIdCO();

		CTS_CRITERIAVO ctsCriteriaVO = new CTS_CRITERIAVO();
		ctsCriteriaVO.setCOMP_CODE(custSegmentationCO.getLoginCompCode());
		ctsCriteriaVO.setCRITERIA_CODE(custSegmentationCO.getCtsSegmentDetVO().getCRITERIA_CODE());

		ctsCriteriaVO = (CTS_CRITERIAVO) genericDAO.selectByPK(ctsCriteriaVO);

		if (ctsCriteriaVO != null)
		{
			if (ctsCriteriaVO.getQUERY_ID() != null && !NumberUtil.isEmptyDecimal(ctsCriteriaVO.getQUERY_ID()))
			{ // By Bilal For TP#750884
				custSegmentationCO.setQueryID(ctsCriteriaVO.getQUERY_ID());
				queryIdSC.setQueryId(ctsCriteriaVO.getQUERY_ID());
				queryIdCO = queryIdBO.dependencyByQueryId(queryIdSC);

				if (queryIdCO != null)
				{
					custSegmentationCO.setQueryDesc(queryIdCO.getQueryName());
				}
			}
		}

		return custSegmentationCO;
	}
	//
	
	public void setQueryIdBO(QueryIdBO queryIdBO)
	{
		this.queryIdBO = queryIdBO;
	}

	public void setAmlCifBO(AmlCifBO amlCifBO)
	{
		this.amlCifBO = amlCifBO;
	}

	public void setAlertsBO(AlertsBO alertsBO)
	{
	    this.alertsBO = alertsBO;
	}
	
	@Override
	public CTS_SEGMENTVO returnSegmentCodeForDependency(CustSegmentationSC custSegmentationSC) throws BaseException
	{
	   return custSegmentationDAO.returnSegmentCodeForDependency(custSegmentationSC);
	} 
	
	private int checkHistoryRecordExists(CustSegmentationProcessCO listCO) throws BaseException
	{
	    
	    return custSegmentationDAO.checkHistoryRecordExists(listCO);
	}

}
