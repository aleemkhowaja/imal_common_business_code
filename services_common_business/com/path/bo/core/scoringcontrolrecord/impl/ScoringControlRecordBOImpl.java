package com.path.bo.core.scoringcontrolrecord.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.scoringcontrolrecord.ScoringControlRecordBO;
import com.path.bo.core.scoringcontrolrecord.ScoringControlRecordConstant;
import com.path.dao.core.scoringcontrolrecord.ScoringControlRecordDAO;
import com.path.dbmaps.vo.CIFCONTROL_DEFINE_SCORE_RANGEVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.CheckRequiredCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.smart.SmartSC;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordCO;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ScoringControlRecordBOImpl.java used to
 */
public class ScoringControlRecordBOImpl extends BaseBO implements ScoringControlRecordBO
{

	ScoringControlRecordDAO scoringControlRecordDAO;
	private S_APPVO sAppVO;

	public ScoringControlRecordDAO getScoringControlRecordDAO()
	{
		return scoringControlRecordDAO;
	}

	public void setScoringControlRecordDAO(ScoringControlRecordDAO scoringControlRecordDAO)
	{
		this.scoringControlRecordDAO = scoringControlRecordDAO;
	}

	@Override
	public ScoringControlRecordCO loadData(ScoringControlRecordCO scoringControlRecordCO) throws BaseException, DAOException
	{
		try

		{
			// load data from db
			scoringControlRecordCO = scoringControlRecordDAO.returnData(scoringControlRecordCO);

			if (scoringControlRecordCO == null)
			{
				scoringControlRecordCO = new ScoringControlRecordCO();
				scoringControlRecordCO.setSaveUpdateFlag("1");
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return scoringControlRecordCO;

	}

	@Override
	public Integer scoringControRecordGridCount(ScoringControlRecordSC scoringControlRecordSC) throws BaseException
	{
		return scoringControlRecordDAO.scoringControRecordGridCount(scoringControlRecordSC);
	}

	@Override
	public List<ScoringControlRecordCO> scoringControRecordGrid(ScoringControlRecordSC scoringControlRecordSC) throws BaseException
	{
		return scoringControlRecordDAO.scoringControRecordGrid(scoringControlRecordSC);
	}

	@Override
	public ScoringControlRecordCO dependencyByFromScore(ScoringControlRecordCO scoringControlRecordCO) throws BaseException
	{
		if (scoringControlRecordCO.getCifControlDefineScoreRangeVO().getFROM_SCORE().intValue() <= 0)
		{
			throw new BOException(MessageCodes.VALUE_CANNOT_BE_EQUAL_OR_LESS_THAN_ZERO);
		}
		else
		{
			scoringControlRecordCO.getCifControlDefineScoreRangeVO().setTO_SCORE(null);
		}

		return scoringControlRecordCO;
	}

	public ScoringControlRecordCO dependencyByToScore(ScoringControlRecordCO scoringControlRecordCO) throws BaseException
	{
		if (scoringControlRecordCO.getCifControlDefineScoreRangeVO().getTO_SCORE().intValue() <= 0)
		{
			throw new BOException(MessageCodes.VALUE_CANNOT_BE_EQUAL_OR_LESS_THAN_ZERO);
		}
		else if (scoringControlRecordCO.getCifControlDefineScoreRangeVO().getTO_SCORE().compareTo(CoreCommonConstants.Max) > 0)
		{
			throw new BOException(MessageCodes.VALUE_MUST_BE_LESS_THAN_9999999_999);

		}

		return scoringControlRecordCO;
	}

	@Override
	public ScoringControlRecordCO saveNew(ScoringControlRecordCO scoringControlRecordCO) throws BaseException, DAOException, BOException
	{
		ScoringControlRecordSC scoringControlRecordSC = new ScoringControlRecordSC();

		//by bilal for TP#987360
		//by bilal for BUG#954712
		if (scoringControlRecordCO.getAmlCifControlScoreVO().getSTATUS() == null || StringUtil.isEmptyString(scoringControlRecordCO.getAmlCifControlScoreVO().getSTATUS()))
		{

			validateMandatoryFields(scoringControlRecordCO);

			// SMART Save
			AuditRefCO refCO = scoringControlRecordCO.getAuditRefCO();
			SmartSC smartSC = new SmartSC();
			smartSC.setAppName(refCO.getAppName());
			smartSC.setCompCode(scoringControlRecordCO.getAmlCifControlScoreVO().getCOMP_CODE());
			smartSC.setRunningDate(refCO.getRunningDate());
			smartSC.setUserId(refCO.getUserID());
			smartSC.setProgRef(refCO.getProgRef());
			smartSC.setLanguage(scoringControlRecordCO.getLanguage());

			smartBO.validateAndUpdateSmartDetails(scoringControlRecordCO.getSmartCOList(), smartSC, scoringControlRecordCO.getAuditRefCO(),
					scoringControlRecordCO.getAmlCifControlScoreVO());

			if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam()))
			{
				//by bilal for TP#987360
				scoringControlRecordCO.getAmlCifControlScoreVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(scoringControlRecordCO.getAmlCifControlScoreVO().getCOMP_CODE()));
			}
			
//			//added by bilal for TP#987360
//			if(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getENTITY_STATUS() != null && StringUtil.isNotEmpty(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getENTITY_STATUS()))
//			{
//				scoringControlRecordCO.getAmlCifControlScoreVO().setSTATUS(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getENTITY_STATUS());
//			}
//			else
//			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setSTATUS(ScoringControlRecordConstant.STATUS_ACTIVE);
//			}
			
			scoringControlRecordCO.getAmlCifControlScoreVO().setCREATED_BY(scoringControlRecordCO.getLoginUserId());
			scoringControlRecordCO.getAmlCifControlScoreVO().setCREATED_DATE(commonLibBO.addSystemTimeToDate(scoringControlRecordCO.getRunningDate()));
			Integer row1 = genericDAO.insert(scoringControlRecordCO.getAmlCifControlScoreVO());
			if (row1 == null || row1 < 1)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
			
			//by bilal for TP#987360
			if(ConstantsCommon.ONE.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.TRUE);
			}
			else if(ConstantsCommon.ZERO.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.FALSE);
			}
			//end bilal
			
			 //by bilal for BUG#987360
//			ScoringControlRecordCO scoringControlRecordCO1 = scoringControlRecordDAO.returnDataHeader(scoringControlRecordCO);
//
//			if (scoringControlRecordCO1 != null)
//			{
//				scoringControlRecordCO.getAmlCifControlScoreVO().setSTATUS(scoringControlRecordCO1.getAmlCifControlScoreVO().getSTATUS());
//				scoringControlRecordCO.setStatusDesc(scoringControlRecordCO1.getStatusDesc());
//			}
			//end bilal
			
			NumberUtil.resetEmptyValues(scoringControlRecordCO);
			//scoringControlRecordCO.getAmlCifControlScoreVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(scoringControlRecordCO.getAmlCifControlScoreVO().getCOMP_CODE()));
			auditBO.callAudit(null, scoringControlRecordCO.getAmlCifControlScoreVO(), scoringControlRecordCO.getAuditRefCO());
			//end bilal
		}
		// update
		else
		{

			if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam()))
			{
				//by bilal for TP#987360
				scoringControlRecordCO.getAmlCifControlScoreVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(scoringControlRecordCO.getAmlCifControlScoreVO().getCOMP_CODE()));
			}

			//For TP#987360
			NumberUtil.resetEmptyValues(scoringControlRecordCO.getAmlCifControlScoreVO());

			scoringControlRecordSC.setDualParam(scoringControlRecordCO.getDualParam());
			scoringControlRecordSC.setIvCrud(scoringControlRecordCO.getIvCrud());

			//by bilal for TP#987360
			if(BigDecimal.ZERO.equals(scoringControlRecordCO.getDualParam()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setSTATUS(ScoringControlRecordConstant.STATUS_APPROVED);
			}
			else
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setSTATUS(ScoringControlRecordConstant.STATUS_ACTIVE);
			}
			
			scoringControlRecordCO.getAmlCifControlScoreVO().setMODIFIED_BY(scoringControlRecordCO.getLoginUserId());
			scoringControlRecordCO.getAmlCifControlScoreVO()
					.setMODIFIED_DATE(commonLibBO.addSystemTimeToDate(scoringControlRecordCO.getRunningDate()));
			
			if (CoreCommonConstants.CRUD_MAINTENANCE.equals(scoringControlRecordCO.getIvCrud())
					|| (CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(scoringControlRecordCO.getIvCrud())
							&& !scoringControlRecordCO.getDualParam().equals(BigDecimal.ONE)))
			{
				Integer row1 = genericDAO.update(scoringControlRecordCO.getAmlCifControlScoreVO());
				if (row1 == null || row1 < 1)
				{
					throw new BOException(MessageCodes.RECORD_CHANGED);
				}

			}

			if ((CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(scoringControlRecordCO.getIvCrud()) && scoringControlRecordCO.getDualParam().equals(BigDecimal.ONE)))
			{
				Integer row1 = genericDAO.insert(scoringControlRecordCO.getAmlCifControlScoreVO());
				if (row1 == null || row1 < 1)
				{
					throw new BOException(MessageCodes.RECORD_CHANGED);
				}

				if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam()))
				{
					scoringControlRecordCO.getAmlCifControlScoreVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(scoringControlRecordCO.getAmlCifControlScoreVO().getCOMP_CODE()));

				}

				Integer row2 = scoringControlRecordDAO.updateFlagsControlRecord(scoringControlRecordCO);
				if (row2 == null || row2 < 1)
				{
					throw new BOException(MessageCodes.RECORD_CHANGED);
				}
			}
			
			//by bilal for TP#987360
			if(ConstantsCommon.ONE.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.TRUE);
			}
			else if(ConstantsCommon.ZERO.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.FALSE);
			}
			//end bilal
			
			if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(scoringControlRecordCO.getAmlCifControlScoreVO().getCOMP_CODE()));

			}
			
			ScoringControlRecordCO oldscoringControlRecordCO = (ScoringControlRecordCO) scoringControlRecordCO.getAuditObj();
			oldscoringControlRecordCO.getAmlCifControlScoreVO().setCOMP_CODE(scoringControlRecordCO.getAmlCifControlScoreVO().getCOMP_CODE());	
			scoringControlRecordCO.setOldAmlCifControlScoreVO(oldscoringControlRecordCO.getAmlCifControlScoreVO());

			auditBO.callAudit(scoringControlRecordCO.getOldAmlCifControlScoreVO(), scoringControlRecordCO.getAmlCifControlScoreVO(), scoringControlRecordCO.getAuditRefCO());
			//end bilal

		}
		//end bilal For the header table
		
		//by bilal for TP#987360
		//For the Grid
		if (scoringControlRecordCO.getCifControlDefineScoreRangeVO().getENTITY_STATUS() == null || StringUtil.isEmptyString(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getENTITY_STATUS()))
		{
			ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO> newScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
			
			validateMandatoryFields(scoringControlRecordCO);

			if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam()))
			{
				scoringControlRecordCO.getCifControlDefineScoreRangeVO()
						.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE()));
			}
			
			
			if (scoringControlRecordCO.getAllControlRecordDetailsData() != null)
			{
				if (scoringControlRecordCO.getAllControlRecordDetailsData().size() > 0)
				{
					BigDecimal i = ScoringControlRecordConstant.Zero;

					for (Object objCO : scoringControlRecordCO.getAllControlRecordDetailsData())
					{
						i = (ScoringControlRecordConstant.One).add(i);
						ScoringControlRecordCO addCO = (ScoringControlRecordCO) objCO;
						CIFCONTROL_DEFINE_SCORE_RANGEVO addVO = addCO.getCifControlDefineScoreRangeVO();
						addVO.setCOMP_CODE(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE());
						addVO.setFROM_SCORE(addCO.getCifControlDefineScoreRangeVO().getFROM_SCORE());
						addVO.setTO_SCORE(addCO.getCifControlDefineScoreRangeVO().getTO_SCORE());
						addVO.setRISK_LEVEL(addCO.getCifControlDefineScoreRangeVO().getRISK_LEVEL());
						addVO.setSCORE_CODE(i);
						//by bilal for BUG#954712
						if(BigDecimal.ZERO.equals(scoringControlRecordCO.getDualParam()))
						{
							addVO.setENTITY_STATUS(ScoringControlRecordConstant.STATUS_APPROVED);
						}
						else
						{
							addVO.setENTITY_STATUS(ScoringControlRecordConstant.STATUS_ACTIVE);
						}
						addVO.setCREATED_DATE(scoringControlRecordCO.getAmlCifControlScoreVO().getCREATED_DATE());
						addVO.setCREATED_BY(scoringControlRecordCO.getAmlCifControlScoreVO().getCREATED_BY());

						Integer row = genericDAO.insert(addVO);
						if (row == null || row < 1)
						{
							throw new BOException(MessageCodes.RECORD_CHANGED);
						}
						
						//by bilal for TP#987360
						newScoringControlRecordVO.add(addVO); //added by bilal for TP#987360

					}
				    //by bilal for BUG#973477
//					ScoringControlRecordCO scoringControlRecordCO1 = scoringControlRecordDAO.returnData(scoringControlRecordCO);
//	
//					if (scoringControlRecordCO1 != null)
//					{
//						scoringControlRecordCO.getCifControlDefineScoreRangeVO().setENTITY_STATUS(scoringControlRecordCO1.getCifControlDefineScoreRangeVO().getENTITY_STATUS());
//						//scoringControlRecordCO.setStatusDesc(scoringControlRecordCO1.getStatusDesc());
//					}
					//end bilal
				}
			}
			
			// Audit for SAVE
			// audit save
			NumberUtil.resetEmptyValues(newScoringControlRecordVO);
			
			if (AuditConstant.UPDATE.equals(scoringControlRecordCO.getAuditRefCO().getOperationType()))
			{
				ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO> oldScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
				
				for (int i = 0; i < newScoringControlRecordVO.size(); i++)
				{
					CIFCONTROL_DEFINE_SCORE_RANGEVO newVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO();
					oldScoringControlRecordVO.add(newVO);
					newScoringControlRecordVO.get(i).setCOMP_CODE(null);
					newScoringControlRecordVO.get(i).setCREATED_BY(null);
					newScoringControlRecordVO.get(i).setCREATED_DATE(null);
					newScoringControlRecordVO.get(i).setMODIFIED_BY(null);
					newScoringControlRecordVO.get(i).setMODIFIED_DATE(null);
					newScoringControlRecordVO.get(i).setAPPROVED_BY(null);
					newScoringControlRecordVO.get(i).setAPPROVED_DATE(null);
					newScoringControlRecordVO.get(i).setENTITY_STATUS(null);
				}
				auditBO.callAudit(oldScoringControlRecordVO, newScoringControlRecordVO, scoringControlRecordCO.getAuditRefCO());
			}
		}
		// update
		else
		{

			if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam()))
			{
				scoringControlRecordCO.getCifControlDefineScoreRangeVO()
						.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE()));
			}

			// audit
			scoringControlRecordSC.setCompCode(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE());
			scoringControlRecordSC.setCurrAppName(scoringControlRecordCO.getAppName());
			scoringControlRecordSC.setPreferredLanguage(scoringControlRecordCO.getLanguage());
			scoringControlRecordSC.setNbRec(-1);

			ScoringControlRecordCO oldScoringControlRecordCO = (ScoringControlRecordCO) scoringControlRecordCO.getAuditObj();

			oldScoringControlRecordCO.getCifControlDefineScoreRangeVO().setCREATED_BY("");
			oldScoringControlRecordCO.getCifControlDefineScoreRangeVO().setCREATED_DATE(null);
			oldScoringControlRecordCO.setOldCifControlDefineScoreRangeVO(oldScoringControlRecordCO.getCifControlDefineScoreRangeVO());

			NumberUtil.resetEmptyValues(scoringControlRecordCO.getCifControlDefineScoreRangeVO());

			ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO> oldScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
			ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO> newScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
			if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam()))
			{
				scoringControlRecordSC.setCompCode(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE().multiply(new BigDecimal(-1)));
			}
			scoringControlRecordSC.setDualParam(scoringControlRecordCO.getDualParam());
			scoringControlRecordSC.setIvCrud(scoringControlRecordCO.getIvCrud());

			oldScoringControlRecordCO.setOldAllControlRecordDetailsData(scoringControlRecordDAO.scoringControRecordGrid(scoringControlRecordSC));

			if (oldScoringControlRecordCO.getOldAllControlRecordDetailsData() != null)
			{

				for (int i = 0; i < oldScoringControlRecordCO.getOldAllControlRecordDetailsData().size(); i++)
				{
					oldScoringControlRecordVO.add(i, oldScoringControlRecordCO.getOldAllControlRecordDetailsData().get(i).getCifControlDefineScoreRangeVO());
				}
			}

			// delete grid
			if (ScoringControlRecordConstant.CRUD_MAINTENANCE.equals(scoringControlRecordCO.getIvCrud())
					|| (ScoringControlRecordConstant.CRUD_UPDATE_AFTER_AUTHORIZE.equals(scoringControlRecordCO.getIvCrud())
							&& (!scoringControlRecordCO.getDualParam().equals(BigDecimal.ONE))))
			{
				if (scoringControlRecordCO.getAllControlRecordDetailsData() != null)
				{
					if (scoringControlRecordCO.getAllControlRecordDetailsData().size() >= 0)
					{

						ScoringControlRecordCO addCO = new ScoringControlRecordCO();
						addCO.setCompCode(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE());

						Integer row1 = scoringControlRecordDAO.deleteGrid(addCO);
						if (row1 == null || row1 < 1)
						{
							throw new BOException(MessageCodes.RECORD_CHANGED);
						}

					}
				}

			}

			// update

			if (scoringControlRecordCO.getAllControlRecordDetailsData() != null)
			{
				if (scoringControlRecordCO.getAllControlRecordDetailsData().size() > 0)
				{
					BigDecimal i = ScoringControlRecordConstant.Zero;

					for (Object objCO : scoringControlRecordCO.getAllControlRecordDetailsData())
					{
						i = (ScoringControlRecordConstant.One).add(i);
						ScoringControlRecordCO addCO = (ScoringControlRecordCO) objCO;
						CIFCONTROL_DEFINE_SCORE_RANGEVO addVO = addCO.getCifControlDefineScoreRangeVO();
						addVO.setCOMP_CODE(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE());
						addVO.setFROM_SCORE(addCO.getCifControlDefineScoreRangeVO().getFROM_SCORE());
						addVO.setTO_SCORE(addCO.getCifControlDefineScoreRangeVO().getTO_SCORE());
						addVO.setRISK_LEVEL(addCO.getCifControlDefineScoreRangeVO().getRISK_LEVEL());
						addVO.setSCORE_CODE(i);
						addVO.setRISK(addCO.getCifControlDefineScoreRangeVO().getRISK());
						//by bilal for BUG#954712
						if(BigDecimal.ZERO.equals(scoringControlRecordCO.getDualParam()))
						{
							addVO.setENTITY_STATUS(ScoringControlRecordConstant.STATUS_APPROVED);
						}
						else
						{
							addVO.setENTITY_STATUS(ScoringControlRecordConstant.STATUS_ACTIVE);
						}
						addVO.setMODIFIED_BY(scoringControlRecordCO.getLoginUserId());
						addVO.setMODIFIED_DATE(commonLibBO.addSystemTimeToDate(scoringControlRecordCO.getRunningDate()));
						//by bilal for bug#973477, remove the checking because we can deleted 3 line and add 1 so the checking on size not matching
						//by bilal, internal from christina on update and it's new record added then saved as created_by empty
//						if (oldScoringControlRecordCO.getOldAllControlRecordDetailsData() != null && i.intValue() > oldScoringControlRecordCO.getOldAllControlRecordDetailsData().size())
//						{
							addVO.setCREATED_BY(scoringControlRecordCO.getLoginUserId());
							//addVO.setCREATED_DATE(scoringControlRecordCO.getRunningDate());
						//}
						//end bilal
						scoringControlRecordCO.getCifControlDefineScoreRangeVO().setMODIFIED_BY(scoringControlRecordCO.getLoginUserId());
						scoringControlRecordCO.getCifControlDefineScoreRangeVO()
								.setMODIFIED_DATE(commonLibBO.addSystemTimeToDate(scoringControlRecordCO.getRunningDate()));

						Integer row1 = genericDAO.insert(addVO);
						if (row1 == null || row1 < 1)
						{
							throw new BOException(MessageCodes.RECORD_CHANGED);
						}
						
						newScoringControlRecordVO.add(addVO); //by bilal For BUG#954712
					}
				}
			}
			
			//by bilal for BUG#973477
			if(((ScoringControlRecordConstant.CRUD_MAINTENANCE.equals(scoringControlRecordCO.getIvCrud()) || ScoringControlRecordConstant.CRUD_UPDATE_AFTER_AUTHORIZE.equals(scoringControlRecordCO.getIvCrud()))
					&& (scoringControlRecordCO.getDualParam().equals(BigDecimal.ONE))))
			{
				if(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE().compareTo(BigDecimal.ZERO) < 0)
				{
					scoringControlRecordCO.getCifControlDefineScoreRangeVO()
					.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE()));
				}
				scoringControlRecordDAO.updateDeletedRows(scoringControlRecordCO);
			}
			
			if (oldScoringControlRecordVO.isEmpty())
			{
				oldScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
				for (int i = 0; i < newScoringControlRecordVO.size(); i++)
				{
					CIFCONTROL_DEFINE_SCORE_RANGEVO newVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO();
					oldScoringControlRecordVO.add(newVO);
				}
			}
			if (newScoringControlRecordVO.isEmpty())
			{
				newScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
				for (int i = 0; i < oldScoringControlRecordVO.size(); i++)
				{
					CIFCONTROL_DEFINE_SCORE_RANGEVO newVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO();
					newScoringControlRecordVO.add(newVO);
				}
			}
			
			//by bilal for TP#987360, this for the Audit to hide the below for grid
			for (int i = 0; i < oldScoringControlRecordVO.size(); i++)
			{
				oldScoringControlRecordVO.get(i).setCOMP_CODE(null);
				oldScoringControlRecordVO.get(i).setCREATED_BY(null);
				oldScoringControlRecordVO.get(i).setCREATED_DATE(null);
				oldScoringControlRecordVO.get(i).setMODIFIED_BY(null);
				oldScoringControlRecordVO.get(i).setMODIFIED_DATE(null);
				oldScoringControlRecordVO.get(i).setAPPROVED_BY(null);
				oldScoringControlRecordVO.get(i).setAPPROVED_DATE(null);
				oldScoringControlRecordVO.get(i).setENTITY_STATUS(null);
			}
			
			for (int i = 0; i < newScoringControlRecordVO.size(); i++)
			{
				newScoringControlRecordVO.get(i).setCOMP_CODE(null);
				newScoringControlRecordVO.get(i).setCREATED_BY(null);
				newScoringControlRecordVO.get(i).setCREATED_DATE(null);
				newScoringControlRecordVO.get(i).setMODIFIED_BY(null);
				newScoringControlRecordVO.get(i).setMODIFIED_DATE(null);
				newScoringControlRecordVO.get(i).setAPPROVED_BY(null);
				newScoringControlRecordVO.get(i).setAPPROVED_DATE(null);
				newScoringControlRecordVO.get(i).setENTITY_STATUS(null);
			}
			//end bilal
			
			NumberUtil.resetEmptyValues(newScoringControlRecordVO);
			
			auditBO.callAudit(oldScoringControlRecordVO, newScoringControlRecordVO, scoringControlRecordCO.getAuditRefCO());
		}
		
		//by bilal for TP#987360, this when update and not insert
		if (AuditConstant.UPDATE.equals(scoringControlRecordCO.getAuditRefCO().getOperationType()))
		{
			auditBO.insertAudit(scoringControlRecordCO.getAuditRefCO());
		}
		return scoringControlRecordCO;
	}

	public ScoringControlRecordCO approveScoringControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws BaseException
	{
		ScoringControlRecordSC scoringControlRecordSC = new ScoringControlRecordSC();

		scoringControlRecordCO.getCifControlDefineScoreRangeVO().setENTITY_STATUS(ScoringControlRecordConstant.STATUS_APPROVED);
		scoringControlRecordCO.getCifControlDefineScoreRangeVO().setAPPROVED_BY(scoringControlRecordCO.getLoginUserId());
		scoringControlRecordCO.getCifControlDefineScoreRangeVO().setAPPROVED_DATE(commonLibBO.addSystemTimeToDate(scoringControlRecordCO.getRunningDate()));

		//added by bilal for TP#987360
		scoringControlRecordCO.getAmlCifControlScoreVO().setSTATUS(ScoringControlRecordConstant.STATUS_APPROVED);
		scoringControlRecordCO.getAmlCifControlScoreVO().setAPPROVED_BY(scoringControlRecordCO.getLoginUserId());
		scoringControlRecordCO.getAmlCifControlScoreVO().setAPPROVED_DATE(commonLibBO.addSystemTimeToDate(scoringControlRecordCO.getRunningDate()));
		
		// audit
		scoringControlRecordSC.setCompCode(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE());
		scoringControlRecordSC.setCurrAppName(scoringControlRecordCO.getAppName());
		scoringControlRecordSC.setPreferredLanguage(scoringControlRecordCO.getLanguage());
		scoringControlRecordSC.setNbRec(-1);

		// audit

		ScoringControlRecordCO oldScoringControlRecordCO = (ScoringControlRecordCO) scoringControlRecordCO.getAuditObj();

		ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO> oldScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
		ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO> newScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
		oldScoringControlRecordCO.setOldAllControlRecordDetailsData(scoringControlRecordDAO.scoringControRecordGrid(scoringControlRecordSC));

		if (oldScoringControlRecordCO.getAllControlRecordDetailsData() != null)
		{

			for (int i = 0; i < oldScoringControlRecordCO.getAllControlRecordDetailsData().size(); i++)
			{
				oldScoringControlRecordVO.add(i, oldScoringControlRecordCO.getAllControlRecordDetailsData().get(i).getCifControlDefineScoreRangeVO());
			}
		}

		int errorCode = 0;

		errorCode = commonLibBO.validateMakerChecker(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCREATED_BY(),
				scoringControlRecordCO.getCifControlDefineScoreRangeVO().getMODIFIED_BY(), scoringControlRecordCO.getLoginUserId());

		if (errorCode > 0)
		{
			throw new BOException(errorCode);
		}

		scoringControlRecordCO.applyTraceProps(scoringControlRecordCO.getAppName(), scoringControlRecordCO.getLoginUserId(),
				scoringControlRecordCO.getProgRef());
		Integer row;

		row = scoringControlRecordDAO.approveScoringControlRecord(scoringControlRecordCO);

		//by bilal for BUG#973477
//		if (row == null || row < 1)
//		{
//			throw new BOException(MessageCodes.RECORD_CHANGED);
//		}
		
		if (oldScoringControlRecordVO.isEmpty())
		{
			oldScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
			for (int i = 0; i < newScoringControlRecordVO.size(); i++)
			{
				CIFCONTROL_DEFINE_SCORE_RANGEVO newVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO();
				oldScoringControlRecordVO.add(newVO);
			}
		}
		if (newScoringControlRecordVO.isEmpty())
		{
			newScoringControlRecordVO = new ArrayList<CIFCONTROL_DEFINE_SCORE_RANGEVO>();
			for (int i = 0; i < oldScoringControlRecordVO.size(); i++)
			{
				CIFCONTROL_DEFINE_SCORE_RANGEVO newVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO();
				newScoringControlRecordVO.add(newVO);
			}
		}

		// Update the row
		ScoringControlRecordCO oldScoringCtlRecordCO = (ScoringControlRecordCO) scoringControlRecordCO.getAuditObj();
		//by bilal For BUG#954712
		oldScoringCtlRecordCO.getCifControlDefineScoreRangeVO().setCOMP_CODE(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE());
		oldScoringCtlRecordCO.getCifControlDefineScoreRangeVO().setMODIFIED_BY(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getMODIFIED_BY());
		oldScoringCtlRecordCO.getCifControlDefineScoreRangeVO().setMODIFIED_DATE(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getMODIFIED_DATE());
		oldScoringCtlRecordCO.getCifControlDefineScoreRangeVO().setAPPROVED_BY(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getAPPROVED_BY());
		oldScoringCtlRecordCO.getCifControlDefineScoreRangeVO().setAPPROVED_DATE(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getAPPROVED_DATE());
		oldScoringCtlRecordCO.getCifControlDefineScoreRangeVO().setENTITY_STATUS(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getENTITY_STATUS());
		oldScoringCtlRecordCO.getAmlCifControlScoreVO().setMODIFIED_BY(scoringControlRecordCO.getAmlCifControlScoreVO().getMODIFIED_BY());
		oldScoringCtlRecordCO.getAmlCifControlScoreVO().setMODIFIED_DATE(scoringControlRecordCO.getAmlCifControlScoreVO().getMODIFIED_DATE());
		//by bilal for TP#987360
		auditBO.callAudit(oldScoringCtlRecordCO.getAmlCifControlScoreVO(), scoringControlRecordCO.getAmlCifControlScoreVO(),
				scoringControlRecordCO.getAuditRefCO());
		auditBO.callAudit(oldScoringCtlRecordCO.getCifControlDefineScoreRangeVO(), scoringControlRecordCO.getCifControlDefineScoreRangeVO(),
				scoringControlRecordCO.getAuditRefCO());
		auditBO.insertAudit(scoringControlRecordCO.getAuditRefCO());
		
		return scoringControlRecordCO;
	}

	public ScoringControlRecordCO deleteScoringControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws BaseException
	{
		scoringControlRecordCO.setMethod(scoringControlRecordCO.getMethod());
		scoringControlRecordCO.setDualParam(scoringControlRecordCO.getDualParam());
		int errorCode = 0;

		errorCode = commonLibBO.validateMakerChecker(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCREATED_BY(),
				scoringControlRecordCO.getCifControlDefineScoreRangeVO().getMODIFIED_BY(), scoringControlRecordCO.getLoginUserId());

		if (errorCode > 0)
		{
			throw new BOException(errorCode);
		}
		Integer row;
		if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam()))
		{
			row = scoringControlRecordDAO.deleteScoringControlRecord(scoringControlRecordCO);
			
			//by bilal for BUG#973477
			if(CoreCommonConstants.TWO.equals(scoringControlRecordCO.getMethod()))
			{
				scoringControlRecordDAO.cancelDeletedRows(scoringControlRecordCO);	
			}
			else if(BigDecimal.ONE.equals(scoringControlRecordCO.getMethod()))
			{
				scoringControlRecordDAO.deletedRows(scoringControlRecordCO);
			}
		}

		return scoringControlRecordCO;

	}

	private void validateMandatoryFields(ScoringControlRecordCO scoringControlRecordCO) throws BaseException
	{
		CheckRequiredCO checkRequiredCO = new CheckRequiredCO();
		checkRequiredCO.setCompCode(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getCOMP_CODE());
		checkRequiredCO.setObj_value(scoringControlRecordCO);
		checkRequiredCO.setOpt(scoringControlRecordCO.getOpt());
		checkRequiredCO.setLanguage(scoringControlRecordCO.getLanguage());
		checkRequiredCO.setApp(scoringControlRecordCO.getAppName());
		checkRequiredCO.applyTraceProps(scoringControlRecordCO.getTraceAppName(), scoringControlRecordCO.getTraceUserId(),
				scoringControlRecordCO.getTraceProgRef(), scoringControlRecordCO.getHttpSessionIdForLink());

		commonLibBO.checkRequired(checkRequiredCO);
	}

	@Override
	public ScoringControlRecordCO updateControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws BaseException, DAOException, BOException
	{
		// TODO Auto-generated method stub
		return null;
	}

	public S_APPVO getsAppVO()
	{
		return sAppVO;
	}

	public void setsAppVO(S_APPVO sAppVO)
	{
		this.sAppVO = sAppVO;
	}

	@Override
	public BigDecimal getDualParam(ScoringControlRecordCO scoringControlRecordCO) throws BaseException
	{
		S_APPVO sAppVO = new S_APPVO();
		sAppVO.setAPP_NAME(scoringControlRecordCO.getAppName());
		return commonLibBO.returnApplicationDetails(sAppVO).getDUAL_PARAM();
	}

}
