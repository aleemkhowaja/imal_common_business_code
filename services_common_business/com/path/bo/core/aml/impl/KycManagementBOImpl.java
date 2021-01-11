package com.path.bo.core.aml.impl;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.address.AddressCommonBO;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.aml.KycManagementBO;
import com.path.bo.core.aml.KycManagementConstant;
import com.path.bo.core.blacklistcontrolrecord.BlackListControlRecordConstant;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.blacklisttype.BlackListTypeConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dao.core.aml.KycManagementDAO;
import com.path.dbmaps.vo.CIF1VO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.CIF_KYCVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTS_CIF_KYC_DETAILSVO;
import com.path.dbmaps.vo.CTS_DYN_CIF_KYCVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.countries.CountriesCO;
import com.path.vo.common.CheckRequiredCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.address.AddressCommonSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.audit.TrackPropCO;
import com.path.vo.common.smart.SmartSC;
import com.path.vo.core.aml.KycManagementCO;
import com.path.vo.core.aml.KycManagementSC;
import com.path.vo.core.csmfom.CIFCountryInfoCO;
import com.path.vo.core.csmfom.CIFKycFinancialInfoCountryCO;
import com.path.vo.core.csmfom.CIF_KYC_FINANCIAL_INFOCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomCifAddressCO;
import com.path.vo.core.csmfom.FomPopUpSceensSC;
import com.path.vo.core.csmfom.FomSC;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * KycManagementBOImpl.java used to
 */
public class KycManagementBOImpl extends BaseBO implements KycManagementBO
{

	KycManagementDAO kycManagementDAO;
	private CoreCommonServiceBO coreCommonServiceBO;
	private AddressCommonBO addressBO;

	public KycManagementCO returnKycManagement(KycManagementSC kycManagementSC) throws BaseException
	{
		KycManagementCO kycManagementCO;
		kycManagementCO = kycManagementDAO.returnKycManagement(kycManagementSC);

		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(kycManagementCO.getLoginCompCode());
		reqFieldSC.setBranchCode(kycManagementCO.getLoginBraCode());
		reqFieldSC.setProgRef(kycManagementCO.getProgRef());
		reqFieldSC.setAppName(kycManagementCO.getAppName());
		applyDynScreenDisplay(new String[] { "CODE" }, ConstantsCommon.ACTION_TYPE_READONLY, BlackListSourceConstant.ONE, kycManagementCO.getScreenParam(),
				reqFieldSC);
		applyDynScreenDisplay(new String[] { "lookuptxt_CIF_NO" }, ConstantsCommon.ACTION_TYPE_READONLY, KycManagementConstant.ONE,
				kycManagementCO.getScreenParam(), reqFieldSC);


		return kycManagementCO;

	}

	@Override
	public Integer kycManagementCount(KycManagementSC kycManagementSC) throws BaseException
	{
		return kycManagementDAO.kycManagementCount(kycManagementSC);

	}

	@Override
	public List<KycManagementCO> kycManagementList(KycManagementSC kycManagementSC) throws BaseException
	{
		return kycManagementDAO.kycManagementList(kycManagementSC);

	}

	public KycManagementDAO getKycManagementDAO()
	{
		return kycManagementDAO;
	}

	public void setKycManagementDAO(KycManagementDAO kycManagementDAO)
	{
		this.kycManagementDAO = kycManagementDAO;
	}

	@Override
	public KycManagementCO returnDepByCode(KycManagementCO kycManagementCO) throws BaseException
	{
		if (kycManagementCO.getAmlKycVO().getCODE().intValue() <= 0)
		{
			throw new BOException(MessageCodes.VALUE_CANNOT_BE_EQUAL_OR_LESS_THAN_ZERO);
		}
		else
		{

			int count = kycManagementDAO.returnCodeDuplicateByCode(kycManagementCO);

			if (count >= 1)
			{
				throw new BOException(MessageCodes.DUPLICATE_VALUE);

			}

			return kycManagementCO;
		}
	}

	@Override
	public KycManagementCO saveKyc(KycManagementCO kycManagementCO, FomCO fomCO) throws BaseException
	{
		// validate mandatory fields
		validateMandatoryFields(kycManagementCO);

		// SMART Save
		AuditRefCO refCO = kycManagementCO.getAuditRefCO();
		SmartSC smartSC = new SmartSC();
		smartSC.setAppName(refCO.getAppName());
		smartSC.setCompCode(kycManagementCO.getAmlKycVO().getCOMP_CODE());
		smartSC.setBranchCode(kycManagementCO.getAmlKycVO().getBRANCH_CODE());
		smartSC.setRunningDate(refCO.getRunningDate());
		smartSC.setUserId(refCO.getUserID());
		smartSC.setProgRef(refCO.getProgRef());
		smartSC.setLanguage(kycManagementCO.getLanguage());

		kycManagementCO.getAmlKycVO().setCOMP_CODE(kycManagementCO.getAmlKycVO().getCOMP_CODE());

		kycManagementCO.getAmlKycVO().setENTITY_STATUS(KycManagementConstant.STATUS_ACTIVE);
		kycManagementCO.setRunningDate(commonLibBO.addSystemTimeToDate(kycManagementCO.getRunningDate()));

		kycManagementCO.getAmlKycVO().setCREATED_DATE(kycManagementCO.getRunningDate());
		kycManagementCO.getAmlKycVO().setCREATED_BY(kycManagementCO.getLoginUserId());

		Integer row = genericDAO.insert(kycManagementCO.getAmlKycVO());
		if (row == null || row < BlackListTypeConstant.INT_ONE)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}
		saveAmlKYCDetailsRec(fomCO);// Save in cif_kyc table
		saveAdditionnalKycProps(fomCO, false);// Save in CTS_DYN_CIF_KYC
		// saving Passport.
		saveAMLCifPassport(fomCO);

		// Audit for SAVE
		// audit save
		NumberUtil.resetEmptyValues(kycManagementCO.getAmlKycVO());
		auditBO.callAudit(null, kycManagementCO.getAmlKycVO(), kycManagementCO.getAuditRefCO());

		return kycManagementCO;
	}

	public void saveAMLCifPassport(FomCO fomCO) throws BaseException
	{
		if (!NumberUtil.isEmptyDecimal(fomCO.getCif1VO().getCOMP_CODE()))
		{
			checkDataFomCifPassport(fomCO);
			fomCO.getCif1VO().setCIF_NO(fomCO.getCifVO().getCIF_NO());

			CIF1VO cif1VO = new CIF1VO();
			cif1VO.setCOMP_CODE(fomCO.getCif1VO().getCOMP_CODE());
			cif1VO.setCIF_NO(fomCO.getCifVO().getCIF_NO());
			cif1VO = (CIF1VO) genericDAO.selectByPK(cif1VO);

			if (cif1VO == null)
			{
				cif1VO = new CIF1VO();
			}

			genericDAO.delete(fomCO.getCif1VO());
			genericDAO.insert(fomCO.getCif1VO());

			NumberUtil.resetEmptyValues(cif1VO);
			NumberUtil.resetEmptyValues(fomCO.getCif1VO());

		}
	}

	public void checkDataFomCifPassport(FomCO fomCO) throws BaseException
	{

		String pcInd = StringUtil.nullToEmpty(fomCO.getCifVO().getPC_IND());
		String pasportNo = StringUtil.nullToEmpty(fomCO.getCif1VO().getPASPORT_NO());
		String passportIssuePlace = StringUtil.nullToEmpty(fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE());
		Date passportIssueDate = (fomCO.getCif1VO().getPASSPORT_ISSUE_DATE());
		Date passportExpiryDate = (fomCO.getCif1VO().getPASSPORT_EXPIRY_DATE());

		String vtInd = StringUtil.nullToEmpty(fomCO.getRifCttVO().getVT_IND());
		String client = StringUtil.nullToEmpty(fomCO.getRifCttVO().getCLIENT());
		String passportMandatory = StringUtil.nullToEmpty(fomCO.getRifCttVO().getPASSPORT_MANDATORY());

		/******************************* checking passport mandatory based **********************************/
		if (fomCO.getRifCttVO() != null)
		{
			if (fomCO.getRifCttVO().getPASSPORT_MANDATORY().equals(KycManagementConstant.PASSPORT_MANDATORY_ON)
					&& vtInd.equals(KycManagementConstant.CIF_IS_INDIVIDUAL))
			{
				checkMandatory(pasportNo, null, null, MessageCodes.INVALID_MISSING.intValue(), new String[] { "Passport_No_key" });
				checkMandatory(passportExpiryDate, null, null, MessageCodes.INVALID_MISSING.intValue(), new String[] { "Expiry_Date_key" });
			}

			/******************************* checking passport mandatory **********************************/

			if (passportIssueDate != null && passportExpiryDate != null && passportIssueDate.compareTo(passportExpiryDate) >= 0)
			{
				throw new BOException(MessageCodes.EXPIRY_DATE_GREATER_ISSUING_DATE, new String[] { "Passport_Info_key" }, true);
			}

			if (pcInd.equals(KycManagementConstant.CATEGORY_CLIENT) && vtInd.equals(KycManagementConstant.CIF_IS_INDIVIDUAL)
					&& client.equals(KycManagementConstant.CIF_IS_CLIENT) && passportMandatory.equals(KycManagementConstant.PASSPORT_MANDATORY_ON))
			{

				if ("".equals(pasportNo))
				{
					throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Passport_No_key" });
				}
				if ("".equals(passportIssuePlace))
				{
					throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Place_Of_Issuance_key" });
				}
				if (passportIssueDate == null)
				{
					throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Date_Of_Issuance_key" });
				}
				if (passportExpiryDate == null)
				{
					throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Expiry_Date_key" });
				}
			}
		}
	}

	@Override
	public KycManagementCO updateKyc(KycManagementCO kycManagementCO, FomCO fomCO) throws BaseException
	{
		KycManagementCO oldKycManagementCO = (KycManagementCO) kycManagementCO.getAuditObj();
		kycManagementCO.setOldAmlKycVO(oldKycManagementCO.getAmlKycVO());

		kycManagementCO.getAmlKycVO().setCOMP_CODE(kycManagementCO.getAmlKycVO().getCOMP_CODE());
		fomCO.getCifKYCVO().setCOMP_CODE(kycManagementCO.getAmlKycVO().getCOMP_CODE());
		fomCO.getCif1VO().setCOMP_CODE(kycManagementCO.getAmlKycVO().getCOMP_CODE());
		fomCO.getCifVO().setCOMP_CODE(kycManagementCO.getAmlKycVO().getCOMP_CODE());
		kycManagementCO.getAmlKycVO().setENTITY_STATUS(BlackListTypeConstant.STATUS_ACTIVE);

		kycManagementCO.getAmlKycVO().setMODIFIED_BY(kycManagementCO.getLoginUserId());
		kycManagementCO.getAmlKycVO().setMODIFIED_DATE(commonLibBO.addSystemTimeToDate(kycManagementCO.getRunningDate()));

		if (CoreCommonConstants.CRUD_MAINTENANCE.equals(kycManagementCO.getIvCrud())
				|| (CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(kycManagementCO.getIvCrud())))
		{
			Integer row1 = genericDAO.update(kycManagementCO.getAmlKycVO());
			if (row1 == null || row1 < BlackListControlRecordConstant.INT_ONE)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
			saveAmlKYCDetailsRec(fomCO);// Save in cif_kyc table
			saveAdditionnalKycProps(fomCO, false);// Save in CTS_DYN_CIF_KYC
			// saving Passport.
			saveAMLCifPassport(fomCO);

		}

		NumberUtil.resetEmptyValues(kycManagementCO.getAmlKycVO());

		auditBO.callAudit(kycManagementCO.getOldAmlKycVO(), kycManagementCO.getAmlKycVO(), kycManagementCO.getAuditRefCO());
		auditBO.insertAudit(kycManagementCO.getAuditRefCO());

		TrackPropCO trackPropCO = auditBO.copyAuditProps(kycManagementCO.getAuditRefCO());
		trackPropCO.setCoInstanceName("fomCO");
		trackPropCO.setVoMainPropRef("amlKycVO");
		trackPropCO.setTrackVoMainPropRef(true);
		trackPropCO.setVoPropertiesNames("");
		auditBO.callTrackChanges(oldKycManagementCO, kycManagementCO, trackPropCO);
		return kycManagementCO;
	}

	@Override
	public KycManagementCO deleteRecord(KycManagementCO kycManagementCO, AuditRefCO refCO) throws BaseException
	{
		kycManagementCO.setMethod(kycManagementCO.getMethod());

		if (kycManagementCO.getDelete().equals(BigDecimal.ONE))
		{
			kycManagementCO.getAmlKycVO().setENTITY_STATUS(CoreCommonConstants.STATUS_DELETED);
			kycManagementCO.getAmlKycVO().setDELETED_BY(kycManagementCO.getLoginUserId());
			kycManagementCO.getAmlKycVO().setDELETED_DATE(commonLibBO.addSystemTimeToDate(kycManagementCO.getRunningDate()));
		}

		Integer row = genericDAO.update(kycManagementCO.getAmlKycVO());
		if (row == null || row < 1)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		// Update the row
		KycManagementCO oldKycManagementCO = (KycManagementCO) kycManagementCO.getAuditObj();

		kycManagementCO.setOldAmlKycVO(kycManagementCO.getAmlKycVO());

		oldKycManagementCO.setOldAmlKycVO(oldKycManagementCO.getAmlKycVO());
		auditBO.callAudit(oldKycManagementCO.getAmlKycVO(), kycManagementCO.getAmlKycVO(), kycManagementCO.getAuditRefCO());
		auditBO.insertAudit(kycManagementCO.getAuditRefCO());

		return kycManagementCO;
	}

	@Override
	public KycManagementCO approveKyc(KycManagementCO kycManagementCO) throws BaseException
	{
		kycManagementCO.getAmlKycVO().setENTITY_STATUS(CoreCommonConstants.STATUS_APPROVED);
		kycManagementCO.getAmlKycVO().setAPPROVED_BY(kycManagementCO.getLoginUserId());
		kycManagementCO.getAmlKycVO().setAPPROVED_DATE(commonLibBO.addSystemTimeToDate(kycManagementCO.getRunningDate()));

		int errorCode = 0;

		errorCode = commonLibBO.validateMakerChecker(kycManagementCO.getAmlKycVO().getCREATED_BY(), kycManagementCO.getAmlKycVO().getMODIFIED_BY(),
				kycManagementCO.getLoginUserId());

		if (errorCode > 0)
		{
			throw new BOException(errorCode);
		}

		kycManagementCO.applyTraceProps(kycManagementCO.getAppName(), kycManagementCO.getLoginUserId(), kycManagementCO.getProgRef());
		Integer row;

		row = kycManagementDAO.approveKyc(kycManagementCO);

		if (row == null || row < 1)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		// Update the row
		KycManagementCO oldKycManagementCO = (KycManagementCO) kycManagementCO.getAuditObj();

		kycManagementCO.setOldAmlKycVO(kycManagementCO.getAmlKycVO());

		oldKycManagementCO.setOldAmlKycVO(oldKycManagementCO.getAmlKycVO());
		auditBO.callAudit(oldKycManagementCO.getAmlKycVO(), kycManagementCO.getAmlKycVO(), kycManagementCO.getAuditRefCO());
		auditBO.insertAudit(kycManagementCO.getAuditRefCO());
		// Changes tracking TrackPropCO trackCO
		TrackPropCO trackCO = auditBO.copyAuditProps(kycManagementCO.getAuditRefCO());
		trackCO.setOperationType(AuditConstant.APPROVE); // the newCO shall
		// be null when we use this method upon // approve/reject.
		trackCO.setVoMainPropRef("amlKycVO");
		auditBO.callTrackChanges(oldKycManagementCO, null, trackCO);

		return kycManagementCO;
	}

	public KycManagementCO returnDepByCifCode(KycManagementCO kycManagementCO) throws BaseException
	{
	
		checkCif(kycManagementCO);
		if (kycManagementCO.getAmlKycVO().getCIF_NO().intValue() < 0)
		{
			throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
		}
		else
		{
			int count = kycManagementDAO.returnCodeDuplicateByCifCode(kycManagementCO);

			if (count >= 1)
			{
				throw new BOException(MessageCodes.RECORD_ALREADY_EXISTS_FOR_THIS_CIF);

			}

			else
			{
				KycManagementCO kycManagementCO1 = kycManagementDAO.returnCifCode(kycManagementCO);

				if (kycManagementCO1 ==null||kycManagementCO1.getCifVO().getSTATUS()== null)
				{
					throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
				}
				else if (!kycManagementCO1.getCifVO().getSTATUS().equals(KycManagementConstant.STATUS_ACTIVE))
				{
					throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
				}

				else
				{
					kycManagementCO.setDesc(kycManagementCO1.getCifVO().getSHORT_NAME_ENG());
					kycManagementCO.setCifType(kycManagementCO1.getCifVO().getCIF_TYPE());
					kycManagementCO.setCifStatus(kycManagementCO1.getCifVO().getSTATUS());
					kycManagementCO.setCifLanguage(kycManagementCO1.getCifLanguage());// changed by nour for bug 975557 to read from CO directly 
					kycManagementCO.getRifcttVO().setVT_IND(kycManagementCO1.getRifcttVO().getVT_IND());

				}
			}
			return kycManagementCO;
		}
	}

	private void validateMandatoryFields(KycManagementCO kycManagementCO) throws BaseException
	{
		CheckRequiredCO checkRequiredCO = new CheckRequiredCO();
		checkRequiredCO.setCompCode(kycManagementCO.getAmlKycVO().getCOMP_CODE());
		checkRequiredCO.setObj_value(kycManagementCO);
		checkRequiredCO.setOpt(kycManagementCO.getOpt());
		checkRequiredCO.setLanguage(kycManagementCO.getLanguage());
		checkRequiredCO.setApp(kycManagementCO.getAppName());
		checkRequiredCO.applyTraceProps(kycManagementCO.getTraceAppName(), kycManagementCO.getTraceUserId(), kycManagementCO.getTraceProgRef(),
				kycManagementCO.getHttpSessionIdForLink());

		commonLibBO.checkRequired(checkRequiredCO);
	}

	@Override
	public FomCO returnAMLKycDetailsRec(FomCO fomCO) throws BaseException
	{
		CIF_KYCVO cifKyc = new CIF_KYCVO();

		cifKyc.setCOMP_CODE(fomCO.getLoginCompCode());
		cifKyc.setCIF_NO(fomCO.getCifVO().getCIF_NO());
		cifKyc = (CIF_KYCVO) genericDAO.selectByPK(cifKyc);
		if (cifKyc == null)
		{
			handleFatcaCompliantType(fomCO);
		}
		else
		{
			fomCO.setCifKYCVO(cifKyc);

		}
		return fomCO;
	}

	@Override
	public ArrayList<CTS_DYN_CIF_KYCVO> retDynScreenValues(FomSC fomSC, Date retDate, FomCO fomCO) throws BaseException
	{
		ArrayList<CTS_DYN_CIF_KYCVO> list = kycManagementDAO.retDynScreenValues(fomSC);
		if (list.isEmpty())
		{
			CTS_DYN_CIF_KYCVO vo = new CTS_DYN_CIF_KYCVO();
			vo.setELEMENT_ID(KycManagementConstant.KYC_UPDATE_DATE);
			vo.setCIF_NO(fomSC.getCifNo());
			vo.setCOMP_CODE(fomSC.getCompCode());
			vo.setSCREEN_ID(fomSC.getBaseCurrencyCode());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss:SSS");
			vo.setELEMENT_VALUE(sdf.format(retDate));
			list.add(vo);
		}
		return list;
	}

	@Override
	public FomCO checkAmlKYCMandatoryFields(FomCO fomCOParam) throws BaseException
	{
		FomCO fomCO = fomCOParam;
		ArrayList<BaseException> eceptionList = new ArrayList<BaseException>();
		try
		{
			amlKycMandFieldsChecking(fomCO);

		}
		catch (BOException e)
		{
			eceptionList.add(e);
		}

		if (!eceptionList.isEmpty())
		{
			throw new BOException(eceptionList);
		}
		return fomCO;
	}

	public boolean amlKycMandFieldsChecking(FomCO fomCO) throws BaseException
	{
		// TODO, keep only the part of flag 0
		boolean bReturn = true;
		CommonLibSC sc = new CommonLibSC();
		sc.setAppName(KycManagementConstant.AML);
		sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
// commented by nour the checking of the cif language for bug id 975868
//		if (KycManagementConstant.A.equals(fomCO.getCifVO().getLANGUAGE()))
//		{
//			sc.setLanguage(KycManagementConstant.ARABIC);
//			fomCO.setLanguage(KycManagementConstant.ARABIC); 
//		}
//		else
//		{
			sc.setLanguage(fomCO.getLanguage());
		//}
		String transMessage;
		// KYC
		// OPENING_ACC_PURPOSE

//		if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getOPENING_ACC_PURPOSE()).equals(""))
//		{
//			sc.setKeyLabelCode("purposeofopeningAcc_key");
//			transMessage = commonLibBO.returnKeyLabelTrans(sc);
//			throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
//		}

		// POLITICAL_MEMBER_SPEC
		if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN()).equals("")
				|| fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN().equals(KycManagementConstant.MINUS_ONE))
		{
			sc.setKeyLabelCode("confirmpoliticalmember_key");
			transMessage = commonLibBO.returnKeyLabelTrans(sc);
			throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
		}

		// INCOME_BUSINESS_YN

//		if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getINCOME_BUSINESS_YN()).equals("")
//				|| fomCO.getCifKYCVO().getINCOME_BUSINESS_YN().equals(KycManagementConstant.MINUS_ONE))
//		{
//			sc.setKeyLabelCode("business_key");
//			transMessage = commonLibBO.returnKeyLabelTrans(sc);
//			throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
//		}

		if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getINCOME_BUSINESS_YN()))
		{
			if (NumberUtil.emptyDecimalToZero(fomCO.getCifKYCVO().getBUSINESS_ECO_SECTOR_CODE()).compareTo(BigDecimal.ZERO) == 0)
			{
				sc.setKeyLabelCode("economic_sector_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}
			if (fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME() == null || fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME().isEmpty())
			{
				sc.setKeyLabelCode("business_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);

			}
			if (NumberUtil.emptyDecimalToZero(fomCO.getCifKYCVO().getINCOME_BUSINESS_COUNTRY()).compareTo(BigDecimal.ZERO) == 0)
			{
				sc.setKeyLabelCode("country_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);

			}
		}

		// ESTIMATED_INCOME_AMOUNT
//		if (fomCO.getCifKYCVO().getESTIMATED_INCOME_AMOUNT() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getESTIMATED_INCOME_AMOUNT()) > 0)
//		{
//			sc.setKeyLabelCode("estimatedincome_key");
//			transMessage = commonLibBO.returnKeyLabelTrans(sc);
//			throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
//
//		}
//
//		if (!StringUtil.isNotEmpty(fomCO.getCifKYCVO().getINCOME_PERIODICITY())
//				|| (KycManagementConstant.THREE.equals(fomCO.getCifKYCVO().getINCOME_PERIODICITY())
//						&& (fomCO.getCifKYCVO().getOTHER_INCOME_SPEC() == null || fomCO.getCifKYCVO().getOTHER_INCOME_SPEC().isEmpty())))
//		{
//			sc.setKeyLabelCode("estimatedincome_key");
//			transMessage = commonLibBO.returnKeyLabelTrans(sc);
//			throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
//		}

		// OTHER_PASSPORT_YN
		if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getOTHER_PASSPORT_YN()).equals("")
				|| fomCO.getCifKYCVO().getOTHER_PASSPORT_YN().equals(KycManagementConstant.MINUS_ONE))
		{
			sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
			sc.setKeyLabelCode("do_you_have_another_passport_key");
			transMessage = commonLibBO.returnKeyLabelTrans(sc);
			throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
		}

		if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN()).equals("")
				|| fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN().equals(KycManagementConstant.MINUS_ONE))
		{
			sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
			sc.setKeyLabelCode("areyougreencardholder_key");
			transMessage = commonLibBO.returnKeyLabelTrans(sc);
			throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
		}

		if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN()))
		{
			KycManagementSC kycManagementSC = new KycManagementSC();
			kycManagementSC.setCompCode(fomCO.getLoginCompCode());
			kycManagementSC.setCifNo(fomCO.getCifVO().getCIF_NO());
			if (retCifCountryInfoCount(kycManagementSC) <= 0)
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("areyougreencardholder_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}
		}

		// OTHER_COUNTRY_TEL_ADDRESS_YN
		if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN()).equals("")
				|| fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN().equals(KycManagementConstant.MINUS_ONE))
		{
			sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
			sc.setKeyLabelCode("addresstelephoneothercountry_key");
			transMessage = commonLibBO.returnKeyLabelTrans(sc);
			throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
		}

		if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN()))
		{
			FomSC fomSC = new FomSC();
			fomSC.setCompCode(fomCO.getLoginCompCode());
			fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
			if (retCifAddressCount(fomSC) <= 0)
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("addresstelephoneothercountry_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}
		}

		return bReturn;
	}

	// TODO : check method
	// - Needed for cifType mandatory expression
	public FomCO returnNameDetails(KycManagementSC kycManagementSC) throws BaseException
	{
		FomCO fomCO = new FomCO();
		HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMap = null;

		RequiredFieldsSC criteria = new RequiredFieldsSC();
		criteria.setAppName(kycManagementSC.getCurrAppName());
		criteria.setLangCode(kycManagementSC.getPreferredLanguage());
		criteria.setProgRef(kycManagementSC.getProgRef());

		criteria.setCifType(kycManagementSC.getCifType());

		if (NumberUtil.nullToZero(kycManagementSC.getCifNo()).compareTo(BigDecimal.ZERO) == 1)
		{
			criteria.setCifNo(kycManagementSC.getCifNo());
		}
		criteria.setPreferredLanguage(kycManagementSC.getPreferredLanguage());
		criteria.setEntityType(KycManagementConstant.ENTITY_CIF_TYPE_LOV);
		criteria.setEntityCode(kycManagementSC.getCifType());
		criteria.setLoginUserId(kycManagementSC.getUserId());
		criteria.setCompCode(kycManagementSC.getCompCode());
		criteria.setBranchCode(kycManagementSC.getBranchCode());

		if (null != kycManagementSC.getCurrAppName() && null != kycManagementSC.getProgRef())
		{
			businessMap = commonLibBO.returnMapRequiredData(criteria);
		}

		if (NumberUtil.nullToZero(kycManagementSC.getCifNo()).compareTo(BigDecimal.ZERO) == 1)
		{
		}

		if (null != kycManagementSC.getCurrAppName() && null != kycManagementSC.getProgRef())
		{
			fomCO.setBuisnessElement(businessMap);
		}

		return fomCO;

	}

	/**
	 * Enhance the checking on the US Passport dependencyByPassportNumber
	 */
	@Override
	public FomCO dependencyByPassportNumber(FomCO fomCO) throws BaseException
	{
		if (!StringUtil.isNotEmpty((fomCO.getCif1VO().getPASPORT_NO())))
		{
			fomCO.getCif1VO().setPASPORT_NO(null);
		}

		fomCO.getCif1VO().setCOUNTRY_OF_ISSUANCE(null);
		fomCO.setCif1VOCountryOfIssuanceDesc(null);
		return fomCO;
	}

	@Override
	public FomCO dependencyByPassportNumber2(FomCO fomCO) throws BaseException
	{
		if (!StringUtil.isNotEmpty((fomCO.getCif1VO().getPASSPORT_NO2())))
		{
			fomCO.getCif1VO().setPASSPORT_NO2(null);
		}
		fomCO.getCif1VO().setCOUNTRY_OF_ISSUANCE2(null);
		fomCO.setCif1VOCountryOfIssuance2Desc(null);

		return fomCO;
	}

	/**
	 * Enhance the checking on the US Passport dependencyByPassportNumber1
	 */
	@Override
	public FomCO dependencyByPassportNumber3(FomCO fomCO) throws BaseException
	{
		if (!StringUtil.isNotEmpty((fomCO.getCif1VO().getPASSPORT_NO3())))
		{
			fomCO.getCif1VO().setPASSPORT_NO3(null);
		}

		fomCO.getCif1VO().setCOUNTRY_OF_ISSUANCE3(null);
		fomCO.setCif1VOCountryOfIssuance3Desc(null);
		return fomCO;
	}

	public int retCifCountryInfoCount(KycManagementSC kycManagementSC) throws BaseException
	{
		return kycManagementDAO.retCifCountryInfoGridCount(kycManagementSC);
	}

	public int retKycFinancialInfoCount(KycManagementSC kycManagementSC) throws BaseException
	{
		return kycManagementDAO.retKycFinancialInfoCount(kycManagementSC);
	}

	public int retCifAddressCount(FomSC fomSC) throws BaseException
	{
		return kycManagementDAO.retCifAddressCount(fomSC);
	}

	@Override
	public ArrayList<COUNTRIESVO> retYmcFinancialCountries(FomSC fomSC) throws BaseException
	{
		return kycManagementDAO.retYmcFinancialCountries(fomSC);
	}

	public CIF_KYC_FINANCIAL_INFOCO formatUSTin(KycManagementSC kycManagementSC) throws BaseException
	{
		CIF_KYC_FINANCIAL_INFOCO cifKycFinancialInfoCO = new CIF_KYC_FINANCIAL_INFOCO();
		commonLibBO.applyDynScreenDisplay("taxPyerInt", "", ConstantsCommon.ACTION_TYPE_VALUE, "", cifKycFinancialInfoCO.getHm(), null);
		kycManagementSC.setCountry(kycManagementSC.getCountry());
		if (kycManagementDAO.countUSControl(kycManagementSC).compareTo(BigDecimal.ZERO) == 0)
		{
			commonLibBO.applyDynScreenDisplay("taxPyerInt", "", ConstantsCommon.ACTION_TYPE_TXTFORMAT, "", cifKycFinancialInfoCO.getHm(), null);
		}
		else
		{
			commonLibBO.applyDynScreenDisplay("taxPyerInt", "", ConstantsCommon.ACTION_TYPE_TXTFORMAT, "##-#######", cifKycFinancialInfoCO.getHm(), null);
		}
		return cifKycFinancialInfoCO;
	}

	@Override
	public List<CIFCountryInfoCO> retCifCountryInfoGridWithoutPagination(FomSC fomSC) throws BaseException
	{
		return kycManagementDAO.retCifCountryInfoGridWithoutPagination(fomSC);

	}

	@Override
	public int retCifCountryInfoCount(FomSC fomSC) throws BaseException
	{
		return kycManagementDAO.retCifCountryInfoGridCount(fomSC);

	}

	@Override
	public int retYmcFinancialCountriesCount(FomSC fomSC) throws BaseException
	{
		return kycManagementDAO.retYmcFinancialCountriesCount(fomSC);

	}

	public void saveInGrid(CIF_KYC_FINANCIAL_INFOCO cifKycFinancialInfoCO) throws DAOException
	{

		FomSC fomSC = new FomSC();
		fomSC.setCompCode(cifKycFinancialInfoCO.getCifKycFinancialInfoVO().getCOMP_CODE());
		fomSC.setCifNo(cifKycFinancialInfoCO.getCifKycFinancialInfoVO().getCIF_NO());

		if (cifKycFinancialInfoCO.getCifKycFinancialInfoCountryCOs() != null && !cifKycFinancialInfoCO.getCifKycFinancialInfoCountryCOs().isEmpty())
		{
			kycManagementDAO.deleteAllINGrid(fomSC);
			for (CIFKycFinancialInfoCountryCO cifKycFinancialInfoCountryCO : cifKycFinancialInfoCO.getCifKycFinancialInfoCountryCOs())
			{
				cifKycFinancialInfoCountryCO.getCifKycFinancialInfoCountryVO().setCOMP_CODE(cifKycFinancialInfoCO.getCifKycFinancialInfoVO().getCOMP_CODE());
				cifKycFinancialInfoCountryCO.getCifKycFinancialInfoCountryVO().setLINE_NO(cifKycFinancialInfoCO.getCifKycFinancialInfoVO().getLINE_NO());
				cifKycFinancialInfoCountryCO.getCifKycFinancialInfoCountryVO().setCIF_NO(cifKycFinancialInfoCO.getCifKycFinancialInfoVO().getCIF_NO());
				genericDAO.insert(cifKycFinancialInfoCountryCO.getCifKycFinancialInfoCountryVO());
			}
		}
		else if (StringUtil.nullToEmpty(cifKycFinancialInfoCO.getInGridStr()).length() > 0)
		{
			kycManagementDAO.deleteAllINGrid(fomSC);
		}

	}

	public void saveCifCountryInfo(List<CIFCountryInfoCO> cifCountryInfoList, FomSC fomSC) throws BaseException
	{

		kycManagementDAO.deleteCifCountryInfo(fomSC);
		for (CIFCountryInfoCO cifCountryInfoCO : cifCountryInfoList)
		{
			cifCountryInfoCO.getCifCountryInfoVO().setCOMP_CODE(fomSC.getCompCode());
			cifCountryInfoCO.getCifCountryInfoVO().setCIF_NO(fomSC.getCifNo());
			genericDAO.insert(cifCountryInfoCO.getCifCountryInfoVO());
		}
	}

	public CIFVO saveFomCifMoreAddress(FomCifAddressCO cifAddressCO, AddressCommonCO addressCO) throws BaseException
	{
		Integer AccessDescriptionNumber = KycManagementConstant.MORE_ADDRESSES;
		CIFVO cifVo = new CIFVO();
		boolean checkAcess = coreCommonServiceBO.checkIfDataCanModified(cifAddressCO.getCtsTellerVO(), cifAddressCO.getCifStatus(), cifAddressCO.getIv_crud(),
				AccessDescriptionNumber);
		if (checkAcess)
		{
			FomCO fomCO = new FomCO();
			fomCO.setLoginCompCode(addressCO.getLoginCompCode());
			fomCO.setLoginBraCode(addressCO.getLoginBraCode());
			fomCO.setPreferredLanguage(addressCO.getPreferredLanguage());
			fomCO.setLoginUserId(addressCO.getLoginUserId());
			fomCO.setAppName(addressCO.getAppName());

			CIFVO checkAddressCifVo = new CIFVO();
			checkAddressCifVo.setCOMP_CODE(cifAddressCO.getCifAddressVO().getCOMP_CODE());
			checkAddressCifVo.setCIF_NO(cifAddressCO.getCifAddressVO().getCIF_NO());
			checkAddressCifVo = (CIFVO) genericDAO.selectByPK(checkAddressCifVo);
			fomCO.setCifVO(checkAddressCifVo);
			fomCO.getCifAddressCO().setCifAddressVO(cifAddressCO.getCifAddressVO());
			fomCO.setAddressCommonCO(addressCO);
			checkDataCifAdress(fomCO);
			cifVo.setCIF_NO(cifAddressCO.getCifAddressVO().getCIF_NO());
			cifVo.setCOMP_CODE(cifAddressCO.getCifAddressVO().getCOMP_CODE());
			cifVo.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(cifAddressCO.getRunningDate()));
			fomCO.setRunningDate(commonLibBO.addSystemTimeToDate(cifAddressCO.getRunningDate()));
			cifVo.setSTATUS(cifAddressCO.getCifStatus());
			fomCO.setFromMoreAddressButton(true);

			fomCO.setLoginCompCode(cifAddressCO.getCifAddressVO().getCOMP_CODE());

			updateMainCifData(cifVo, cifAddressCO.getCif_UpdateDate());

			BigDecimal cifNo = cifAddressCO.getCifAddressVO().getCIF_NO();
			fomCO.setAuditRefCO(cifAddressCO.getAuditRefCO());
			if (cifAddressCO.getSaveType().equals(KycManagementConstant.C))
			{
				FomPopUpSceensSC fomPopUpSceensSC = new FomPopUpSceensSC();
				fomPopUpSceensSC.setCompCode(cifAddressCO.getCifAddressVO().getCOMP_CODE());
				fomPopUpSceensSC.setCifNo(cifNo);
				fomPopUpSceensSC.setUseLineNo(KycManagementConstant.ONE);
				fomPopUpSceensSC.setTableName("CIF_ADDRESS");
				int lineNo = returnMaxLineNo(fomPopUpSceensSC);
				lineNo++;

				cifAddressCO.getCifAddressVO().setLINE_NO(new BigDecimal(lineNo));
				fomCO.setCifAddressCO(cifAddressCO);
				saveFomCifAddress(fomCO);
			}
			else if (cifAddressCO.getSaveType().equals(KycManagementConstant.M))
			{

				manageAntiFraud(cifAddressCO);

				CIF_ADDRESSVO cifAdressVO = cifAddressCO.getCifAddressVO();
				cifAdressVO.setTEL(unformatPhoneNumber(cifAdressVO.getTEL()));
				cifAdressVO.setWORK_TEL(unformatPhoneNumber(cifAdressVO.getWORK_TEL()));
				cifAdressVO.setMOBILE(unformatPhoneNumber(cifAdressVO.getMOBILE()));
				cifAdressVO.setOTHER_TEL(unformatPhoneNumber(cifAdressVO.getOTHER_TEL()));
				cifAdressVO.setFAX(unformatPhoneNumber(cifAdressVO.getFAX()));
				auditBO.callAudit(genericDAO.selectByPK(cifAddressCO.getCifAddressVO()), cifAdressVO, cifAddressCO.getAuditRefCO());
				fomCO.setCifAddressCO(cifAddressCO);
				saveFomCifAddress(fomCO);
			}
			auditBO.insertAudit(cifAddressCO.getAuditRefCO());

		}

		return cifVo;
	}

	public CIFVO updateMainCifData(CIFVO cifVO, Date dateUpdated) throws BaseException
	{
		FomCO fomCO = new FomCO();
		fomCO.setCifVO(cifVO);
		fomCO.setDateUpdated(dateUpdated);
		if (FomConstant.STATUS_ACTIVE.equals(fomCO.getCifVO().getSTATUS()))
		{
			fomCO.getCifVO().setSTATUS(FomConstant.STATUS_INACTIVE);
		}
		int row = kycManagementDAO.updateMainCifData(fomCO);
		if (row < 1)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		return cifVO;
	}

	public void checkDataCifAdress(FomCO fomCO) throws BaseException
	{
		CIFVO cifVO = fomCO.getCifVO();
		CIF_ADDRESSVO cifAdressVO = fomCO.getCifAddressCO().getCifAddressVO();
		BigDecimal compCode = cifAdressVO.getCOMP_CODE();
		cifAdressVO.setCOMP_CODE(compCode);
		cifAdressVO.setCIF_NO(cifAdressVO.getCIF_NO());
		CIFCONTROLVO cifControlSC = new CIFCONTROLVO();
		cifControlSC.setCOMP_CODE(cifAdressVO.getCOMP_CODE());
		CIFCONTROLVO cifControlVO = commonLibBO.returnCifControlDetails(cifControlSC);
		if (fomCO.getCifAddressCO().getCifAddressVO().getLINE_NO().intValue() == 0)
		{
			checkMissingDfltAdd(fomCO.getCifAddressCO());
		}
		String mendatoryAddress = StringUtil.nullToEmpty(cifControlVO.getMENDATORY_ADDRESS());
		String ewalletYN = StringUtil.nullToEmpty(fomCO.getCifAddressCO().getCifAddressVO().getE_WALLET_YN());// maureena

		/******************************* checking mandatory of Engilsh CifAdress ***********************************************************/

		if (ConstantsCommon.ZERO.equals(ewalletYN))
		{
			if (KycManagementConstant.L.equals(cifVO.getLANGUAGE()))
			{
				if (((KycManagementConstant.ONE.equals(mendatoryAddress)) && KycManagementConstant.L.equals(cifVO.getLANGUAGE()))
						&& cifAdressVO.getADDRESS1_ENG() == null)
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.TWO.equals(mendatoryAddress) && (cifAdressVO.getADDRESS1_ENG() == null || cifAdressVO.getADDRESS2_ENG() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.THREE.equals(mendatoryAddress)
						&& (cifAdressVO.getADDRESS1_ENG() == null || cifAdressVO.getADDRESS2_ENG() == null || cifAdressVO.getADDRESS3_ENG() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.FOUR.equals(mendatoryAddress) && (cifAdressVO.getADDRESS1_ENG() == null || cifAdressVO.getADDRESS2_ENG() == null
						|| cifAdressVO.getADDRESS3_ENG() == null || cifAdressVO.getADDRESS4_ENG() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.FIVE.equals(mendatoryAddress) && (cifAdressVO.getADDRESS1_ENG() == null || cifAdressVO.getADDRESS2_ENG() == null
						|| cifAdressVO.getADDRESS3_ENG() == null || cifAdressVO.getADDRESS4_ENG() == null || cifAdressVO.getCITY_ENG() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.SIX.equals(mendatoryAddress)
						&& (cifAdressVO.getADDRESS1_ENG() == null || cifAdressVO.getADDRESS2_ENG() == null || cifAdressVO.getADDRESS3_ENG() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

			}

			/*************************** checking mandatory of Arbic CifAdress ************************************/

			if ("A".equals(cifVO.getLANGUAGE()))
			{
				if ((KycManagementConstant.ONE.equals(mendatoryAddress)) && cifAdressVO.getADDRESS1_ARAB() == null)
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.TWO.equals(mendatoryAddress) && (cifAdressVO.getADDRESS1_ARAB() == null || cifAdressVO.getADDRESS2_ARAB() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.THREE.equals(mendatoryAddress)
						&& (cifAdressVO.getADDRESS1_ARAB() == null || cifAdressVO.getADDRESS2_ARAB() == null || cifAdressVO.getADDRESS3_ARAB() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.FOUR.equals(mendatoryAddress) && (cifAdressVO.getADDRESS1_ARAB() == null || cifAdressVO.getADDRESS2_ARAB() == null
						|| cifAdressVO.getADDRESS3_ARAB() == null || cifAdressVO.getADDRESS4_ARAB() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.FIVE.equals(mendatoryAddress) && (cifAdressVO.getADDRESS1_ARAB() == null || cifAdressVO.getADDRESS2_ARAB() == null
						|| cifAdressVO.getADDRESS3_ARAB() == null || cifAdressVO.getADDRESS4_ARAB() == null || cifAdressVO.getCITY_ARAB() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				if (KycManagementConstant.SIX.equals(mendatoryAddress)
						&& (cifAdressVO.getADDRESS1_ARAB() == null || cifAdressVO.getADDRESS2_ARAB() == null || cifAdressVO.getADDRESS3_ARAB() == null))
				{
					throw new BOException(MessageCodes.ADREES_ARE_MISING);
				}

				/********************************** END *******************************/
			}
			// }

			CTSCONTROLVO ctsControlSC = new CTSCONTROLVO();
			ctsControlSC.setCOMP_CODE(compCode);
			ctsControlSC.setBRANCH_CODE(cifAdressVO.getBRANCH_CODE());
			CTSCONTROLVO ctsControlVO = (CTSCONTROLVO) genericDAO.selectByPK(ctsControlSC);
			if (ctsControlVO != null)
			{
				String inwardOutwardClrChq = StringUtil.nullEmptyToValue(ctsControlVO.getINWARD_OUTWARD_CLR_CHQ(), "0");

				/******************************* checking country code **********************************/
				checkMandatory(cifAdressVO.getCOUNTRY(), "0", "0", 369, new String[] { "Country_key" });
				/******************************* checking country code **********************************/

				/******************************* checking city code **********************************/
				checkMandatory(cifAdressVO.getCITY_CODE(), inwardOutwardClrChq, ConstantsCommon.BA_ALGERIA.toString(), 369, new String[] { "City_key" });
				/******************************* checking city code **********************************/
				/******************************* checking Sector code **********************************/
				checkMandatory(cifAdressVO.getSECTOR_CODE(), inwardOutwardClrChq, ConstantsCommon.BA_ALGERIA.toString(), 369, new String[] { "Sector__key" });
			}
			/******************************* checking Sector code **********************************/

			/******************************* checking Region code **********************************/
			if (fomCO.getCifAddressCO().getCifAddressVO().getLINE_NO().intValue() == 0)
			{
				String regionIsMandatory = StringUtil.nullToEmpty(cifControlVO.getREGION_IS_MANDATORY());

				checkMandatory(cifAdressVO.getREGION(), regionIsMandatory, KycManagementConstant.Y, 315, new String[] { "Region_key" });
			}
			/************************************** End **********************************/

			/************************************** checking Telephone **********************************/

			Integer telphoneCode = Integer.valueOf(0);
			COUNTRIESVO countriesSC = new COUNTRIESVO();
			countriesSC.setCOMP_CODE(compCode);
			BigDecimal countryCode = NumberUtil.nullToZero(fomCO.getCifVO().getCOUNTRY());
			countriesSC.setCOUNTRY_CODE(countryCode);
			COUNTRIESVO countrieVO = (COUNTRIESVO) genericDAO.selectByPK(countriesSC);
			if (countrieVO != null)
			{
				telphoneCode = NumberUtil.nullToZero(countrieVO.getTELEPHONE_CODE()).intValue();
			}
			telphoneCode = NumberUtil.nullToZero(telphoneCode);

			if (((!StringUtil.isNotEmpty(cifAdressVO.getTEL()) && !StringUtil.isNotEmpty(cifAdressVO.getWORK_TEL())
					&& !StringUtil.isNotEmpty(cifAdressVO.getMOBILE()) && !StringUtil.isNotEmpty(cifAdressVO.getOTHER_TEL()))
					|| ("".equals(cifAdressVO.getTEL()) && "".equals(cifAdressVO.getWORK_TEL()) && "".equals(cifAdressVO.getMOBILE())
							&& "".equals(cifAdressVO.getOTHER_TEL())))
					&& (!(KycManagementConstant.TWO.equals(cifControlVO.getADDRESS_DTL_SOURCE()))))
			{
				throw new BOException(MessageCodes.TELEPHONES_ARE_MISING);
			}

			int telphoneCodelegnth = telphoneCode.toString().length();
			if (cifAdressVO.getTEL() != null && !"".equals(cifAdressVO.getTEL())
					&& (StringUtil.nullToEmpty(cifAdressVO.getTEL()).length()) <= telphoneCode.toString().length())
			{
				cifAdressVO.setTEL(null);
			}
			if (cifAdressVO.getWORK_TEL() != null && !"".equals(cifAdressVO.getWORK_TEL())
					&& (StringUtil.nullToEmpty(cifAdressVO.getWORK_TEL()).length()) <= telphoneCodelegnth)
			{
				cifAdressVO.setWORK_TEL(null);
			}

			if (cifAdressVO.getMOBILE() != null && !"".equals(cifAdressVO.getMOBILE())
					&& (StringUtil.nullToEmpty(cifAdressVO.getMOBILE()).length()) <= telphoneCodelegnth)
			{
				cifAdressVO.setMOBILE(null);
			}

			if (cifAdressVO.getOTHER_TEL() != null && !"".equals(cifAdressVO.getOTHER_TEL())
					&& (StringUtil.nullToEmpty(cifAdressVO.getOTHER_TEL()).length()) <= telphoneCodelegnth)
			{
				cifAdressVO.setOTHER_TEL(null);
			}

			/************************************** End checking Telephone **********************************/

			/************************************** checking P.O.BOX **********************************/
			String modeComm = StringUtil.nullToEmpty(cifVO.getMODE_COMM());

			if (modeComm.equals(KycManagementConstant.MODE_COMM_POBOX))
			{
				if (cifAdressVO.getPOBOX_AREA() == null)
				{
					throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "PO_BOX_KEY" });
				}

				/******************************* checking P.O.BOX **********************************/
				checkMandatory(cifVO.getDESCRIPTION(), cifControlVO.getPOBOX_MANDATORY(), KycManagementConstant.ONE, 369, new String[] { "P.O_Box_key" });
				/******************************* checkingP.O.BOX **********************************/
				/******************************* checking Postal Code **********************************/
				String postalCodeType = StringUtil.nullToEmpty(cifControlVO.getPOSTAL_CODE_TYPE());

				if (KycManagementConstant.N.equals(postalCodeType))
				{
					checkMandatory(cifAdressVO.getPOSTAL_CODE(), cifControlVO.getPOBOX_MANDATORY(), KycManagementConstant.ONE, 369,
							new String[] { "Postal_Code_key" });
				}
				else
				{
					checkMandatory(cifAdressVO.getPOSTAL_CODE1(), cifControlVO.getPOBOX_MANDATORY(), KycManagementConstant.ONE, 369,
							new String[] { "Postal_Code_key" });
				}
				/******************************* END **********************************/

			}
			if (modeComm.equals(KycManagementConstant.MODE_COMM_EMAIL)

					&& StringUtil.nullToEmpty(cifAdressVO.getEMAIL()).equals(""))
			{
				throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Email_key" });
			}

			fomCO.getAddressCommonCO().getCifVO().setCIF_TYPE(fomCO.getCifVO().getCIF_TYPE());
			if (fomCO.getCifAddressCO() != null && fomCO.getCifAddressCO().getCifAddressVO() != null)
			{
				fomCO.getAddressCommonCO().setCOUNTRY(fomCO.getCifAddressCO().getCifAddressVO().getCOUNTRY());
			}
			fomCO.getAddressCommonCO().setCOMP_CODE(fomCO.getLoginCompCode());
			fomCO.getAddressCommonCO().setBRANCH_CODE(fomCO.getLoginBraCode());
			fomCO.getAddressCommonCO().setPreferredLanguage(fomCO.getPreferredLanguage());
			fomCO.getAddressCommonCO().setLoginUserId(fomCO.getLoginUserId());
			fomCO.getAddressCommonCO().setAppName(fomCO.getAppName());

			checkDataFomCifMoreAddress(fomCO.getAddressCommonCO());
		}
		else
		{
			Integer telphoneCode = Integer.valueOf(0);
			COUNTRIESVO countriesSC = new COUNTRIESVO();
			countriesSC.setCOMP_CODE(compCode);
			BigDecimal countryCode = NumberUtil.nullToZero(fomCO.getCifVO().getCOUNTRY());
			countriesSC.setCOUNTRY_CODE(countryCode);
			COUNTRIESVO countrieVO = (COUNTRIESVO) genericDAO.selectByPK(countriesSC);
			if (countrieVO != null)
			{
				telphoneCode = NumberUtil.nullToZero(countrieVO.getTELEPHONE_CODE()).intValue();
			}
			telphoneCode = NumberUtil.nullToZero(telphoneCode);
			int telphoneCodelegnth = telphoneCode.toString().length();
			if ((StringUtil.nullToEmpty(cifAdressVO.getMOBILE()).length()) <= telphoneCode.toString().length()
					|| !StringUtil.isNotEmpty(cifAdressVO.getMOBILE()) || "".equals(cifAdressVO.getMOBILE()))
			{
				throw new BOException(MessageCodes.TELEPHONES_ARE_MISING);
			}
		}

	}

	/**
	 * this function is used to check if we have a field equal to null or isempty and alert Bo exception
	 */
	public boolean checkMandatory(Object valueVO, Object valueControl, String valuemand, int msgNumber, String... msg) throws BaseException
	{
		if (valueControl == null || "".equals(valueControl))
		{
			if (null == valueVO || "".equals(valueVO))
			{
				throw new BOException(msgNumber, msg);
			}
		}
		else
		{
			if ((null == valueVO || "".equals(valueVO)) && valueControl.toString().equals(valuemand))
			{
				throw new BOException(msgNumber, msg);
			}
		}
		return false;
	}

	/**
	 * this function check if we have default address value in other address
	 * 
	 * @param addressCommonCO
	 * @throws BaseException
	 */
	public void checkMissingDfltAdd(FomCifAddressCO fomCifAddressCO) throws BaseException
	{
		AddressCommonSC criteria = new AddressCommonSC();
		AddressCommonCO addressCommonCO = new AddressCommonCO();
		PathPropertyUtil.copyProperties(fomCifAddressCO.getCifAddressVO(), addressCommonCO);
		if (NumberUtil.isNumberPositive(addressCommonCO.getCIF_NO()))
		{
			criteria.setCompCode(addressCommonCO.getCOMP_CODE());
			criteria.setCifNo(addressCommonCO.getCIF_NO());
			criteria.setDefaultAdd(KycManagementConstant.DEFAULT_ADDRESS);
			criteria.setNbRec(-1);
			List<AddressCommonCO> addressList = addressBO.returnAddressList(criteria);
			if (addressCommonCO.getDEFAULT_ADD() == null)
			{
				addressCommonCO.setDEFAULT_ADD("0");
			}
			if (addressList.isEmpty() && (addressCommonCO.getDEFAULT_ADD().equals("0")))
			{
				throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Default_Address_key" });
			}
		}
	}

	public void saveFomCifAddress(FomCO fomCO) throws BaseException
	{
		// TODO check from where the data of cif will be sent
		// database or action
		CIF_ADDRESSVO cifAdressVO = fomCO.getCifAddressCO().getCifAddressVO();
		cifAdressVO.setBRANCH_CODE(NumberUtil.nullEmptyToValue(fomCO.getCifVO().getBRANCH_CODE(), fomCO.getLoginBraCode()));
		cifAdressVO.setBRANCH_CODE(NumberUtil.nullEmptyToValue(fomCO.getCifVO().getBRANCH_CODE(), fomCO.getLoginBraCode()));
		cifAdressVO.setCIF_NO(fomCO.getCifVO().getCIF_NO());
		if (NumberUtil.isEmptyDecimal(cifAdressVO.getLINE_NO()))
		{
			cifAdressVO.setLINE_NO(BigDecimal.ZERO);
			checkDataCifAdress(fomCO);
		}

		// pass CountriesCO to get phone extension
		CountriesCO countriesCO = new CountriesCO();
		fomCO.getCountriesVO().setCOMP_CODE(fomCO.getLoginCompCode());
		if (!NumberUtil.isEmptyDecimal(fomCO.getAddressCommonCO().getCOUNTRY()))
		{
			fomCO.getCountriesVO().setCOUNTRY_CODE(fomCO.getAddressCommonCO().getCOUNTRY());
			fomCO.setCountriesVO((COUNTRIESVO) genericDAO.selectByPK(fomCO.getCountriesVO()));
		}
		countriesCO.setCountriesVO(fomCO.getCountriesVO());
		countriesCO.setRegionCode(fomCO.getAddressCommonCO().getREGION());
		countriesCO.getCifAddressVO().setTEL(fomCO.getAddressCommonCO().getTEL());
		countriesCO.getCifAddressVO().setWORK_TEL(fomCO.getAddressCommonCO().getWORK_TEL());
		countriesCO.getCifAddressVO().setMOBILE(fomCO.getAddressCommonCO().getMOBILE());
		countriesCO.getCifAddressVO().setOTHER_TEL(fomCO.getAddressCommonCO().getOTHER_TEL());
		countriesCO.getCifAddressVO().setFAX(fomCO.getAddressCommonCO().getFAX());

		HashMap<String, String> hm = coreCommonServiceBO.returnPhoneByCountry(countriesCO);
		// if there is a format applied, so we should unformat the fields,
		// otherwise we keep as it is
		if (hm != null && !hm.isEmpty())
		{
			cifAdressVO.setTEL(unformatPhoneNumber(cifAdressVO.getTEL()));
			cifAdressVO.setWORK_TEL(unformatPhoneNumber(cifAdressVO.getWORK_TEL()));
			cifAdressVO.setMOBILE(unformatPhoneNumber(cifAdressVO.getMOBILE()));
			cifAdressVO.setOTHER_TEL(unformatPhoneNumber(cifAdressVO.getOTHER_TEL()));
			cifAdressVO.setFAX(unformatPhoneNumber(cifAdressVO.getFAX()));
		}

		if (KycManagementConstant.C.equals(fomCO.getCifAddressCO().getSaveType()))
		{
			genericDAO.delete(cifAdressVO);
			genericDAO.insert(cifAdressVO);
			auditBO.callAudit(new CIF_ADDRESSVO(), cifAdressVO, fomCO.getAuditRefCO());
		}
		else if (KycManagementConstant.M.equals(fomCO.getCifAddressCO().getSaveType()))
		{
			CIF_ADDRESSVO cifAdressOldVO = new CIF_ADDRESSVO();
			if (!fomCO.isFromMoreAddressButton())
			{
				cifAdressOldVO = (CIF_ADDRESSVO) genericDAO.selectByPK(cifAdressVO);
			}

			cifAdressVO.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(fomCO.getRunningDate()));
			Integer updater = genericDAO.update(cifAdressVO);
			if (updater.compareTo(Integer.valueOf(0)) == 0)
			{
				genericDAO.insert(cifAdressVO);
			}

			if (!fomCO.isFromMoreAddressButton())
			{
				NumberUtil.resetEmptyValues(cifAdressVO);
				NumberUtil.resetEmptyValues(cifAdressOldVO);
				auditBO.callAudit(cifAdressOldVO, cifAdressVO, fomCO.getAuditRefCO());
			}

		}
		if (!fomCO.isFromMoreAddressButton())
		{
			auditBO.insertAudit(fomCO.getAuditRefCO());
		}

		// System is checking on default address box
		// without considering the defaulted address from CIF
		AddressCommonCO addressCommonCO = new AddressCommonCO();
		addressCommonCO.setScreenName("FOM");
		addressCommonCO.setLoginCompCode(cifAdressVO.getCOMP_CODE());
		addressCommonCO.setCIF_NO(cifAdressVO.getCIF_NO());
		addressBO.checkAddressDefaultAddrFlag(addressCommonCO);
	}

	private void manageAntiFraud(FomCifAddressCO cifAddressCO) throws BaseException
	{

		// - Online Integration with IMAL and Anti-Fraud Management system

		CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
		ctsControlVO.setCOMP_CODE(cifAddressCO.getCifAddressVO().getCOMP_CODE());
		ctsControlVO.setBRANCH_CODE(cifAddressCO.getCifAddressVO().getBRANCH_CODE());
		ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);

		FomCifAddressCO cifAddCO = cifAddressCO;
		if (KycManagementConstant.ONE.equals(ctsControlVO.getCIF_EMAIL_AMENDEMENT_YN())
				|| KycManagementConstant.ONE.equals(ctsControlVO.getCIF_MOBILE_NO_AMENDEMENT_YN()))
		{

			CIF_ADDRESSVO cifAddressVO = new CIF_ADDRESSVO();
			cifAddressVO.setCOMP_CODE(cifAddCO.getCifAddressVO().getCOMP_CODE());
			cifAddressVO.setCIF_NO(cifAddCO.getCifAddressVO().getCIF_NO());
			cifAddressVO.setLINE_NO(cifAddCO.getCifAddressVO().getLINE_NO());
			cifAddressVO = (CIF_ADDRESSVO) genericDAO.selectByPK(cifAddressVO);

			if (!StringUtil.nullToEmpty(cifAddCO.getCifAddressVO().getMOBILE()).equals(StringUtil.nullToEmpty(cifAddressVO.getMOBILE())))
			{
				cifAddCO.getCifAddressVO().setOLD_MOBILE(cifAddressVO.getMOBILE());
				cifAddCO.getCifAddressVO().setLAST_CHANGE_MOBILE_EMAIL(KycManagementConstant.ONE);
				cifAddCO.getCifAddressVO().setLAST_DATE_MOBILE_EMAIL(commonLibBO.returnSystemDateWithTime());

			}

			if (!StringUtil.nullToEmpty(cifAddCO.getCifAddressVO().getEMAIL()).equals(StringUtil.nullToEmpty(cifAddressVO.getEMAIL())))
			{
				cifAddCO.getCifAddressVO().setOLD_EMAIL(cifAddressVO.getEMAIL());
				cifAddCO.getCifAddressVO().setLAST_CHANGE_MOBILE_EMAIL(KycManagementConstant.ONE);
				cifAddCO.getCifAddressVO().setLAST_DATE_MOBILE_EMAIL(commonLibBO.returnSystemDateWithTime());

			}

			if ("".equals(StringUtil.nullToEmpty(cifAddressVO.getMOBILE())))
			{
				cifAddCO.getCifAddressVO().setMOBILE(KycManagementConstant.MINUS_ONE);
			}

			if ("".equals(StringUtil.nullToEmpty(cifAddressVO.getEMAIL())))
			{
				cifAddCO.getCifAddressVO().setEMAIL(KycManagementConstant.MINUS_ONE);
			}
		}
	}

	/**
	 * @description this function is used to unformat a phone number in order to be saved in the database
	 * @param phoneFormatted
	 *            TODO should be moved to StringUtil but no access
	 */
	public String unformatPhoneNumber(String phoneFormatted)
	{
		// if the value is null it doesn't need unformat
		if (StringUtil.isNotEmpty(phoneFormatted))
		{
			Pattern p = Pattern.compile(ConstantsCommon.PHONE_REGEX, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
			return p.matcher(phoneFormatted).replaceAll("");
		}
		return phoneFormatted;
	}

	/**
	 * 
	 * 
	 * On save Check CIF Address section fields validity
	 * 
	 */
	public void checkDataFomCifMoreAddress(AddressCommonCO addressCommonCO) throws BaseException
	{
		if (!NumberUtil.isEmptyDecimal(addressCommonCO.getCITY_CODE()))

		{
			coreCommonServiceBO.checkAddressCityCode(addressCommonCO);

		}

		if (!NumberUtil.isEmptyDecimal(addressCommonCO.getCOUNTRY()))

		{
			coreCommonServiceBO.checkAddressCountry(addressCommonCO);

		}

		if (addressCommonCO.getFROM_DATE() != null)

		{
			checkAddressDate(addressCommonCO);

		}

		if (addressCommonCO.getTO_DATE() != null)

		{
			checkAddressDate(addressCommonCO);

		}

		if (!NumberUtil.isEmptyDecimal(addressCommonCO.getCIF_NO()))
		{
			addressCommonCO.setScreenName("KYCManagment");
			addressCommonCO.setLoginCompCode(addressCommonCO.getCOMP_CODE());
			addressBO.checkAddressDefaultAddrFlag(addressCommonCO);
		}

		if (addressCommonCO.getEXPIRY_DATE() != null)

		{
			Date expDte, systemDate;
			expDte = addressCommonCO.getEXPIRY_DATE();
			systemDate = addressCommonCO.getSystemDate();

			checkAddressExpDte(systemDate, expDte);

		}

		if (addressCommonCO.getPermnAddrFlag() != null)

		{

			checkAddressPermnntAdd(addressCommonCO);

		}

		if (!NumberUtil.isEmptyDecimal(addressCommonCO.getPOBOX_AREA()))

		{
			coreCommonServiceBO.checkAddressPoBoxArea(addressCommonCO);

		}

		if (!NumberUtil.isEmptyDecimal(addressCommonCO.getREGION()))

		{
			coreCommonServiceBO.checkAddressRegion(addressCommonCO);

		}

		if (!NumberUtil.isEmptyDecimal(addressCommonCO.getSECTOR_CODE()))

		{
			coreCommonServiceBO.checkAddressSectorCode(addressCommonCO);

		}

	}

	public void checkAddressExpDte(Date systemDate, Date expDte) throws BaseException
	{
		if (systemDate != null && expDte != null && systemDate.compareTo(expDte) > 0)
		{
			throw new BOException(MessageCodes.INVALID_DATE);
		}
	}

	public void checkAddressPermnntAdd(AddressCommonCO addressCommonCO) throws BaseException
	{
		AddressCommonSC criteria = new AddressCommonSC();

		if (NumberUtil.isNumberPositive(addressCommonCO.getCIF_NO()))
		{

			criteria.setCompCode(addressCommonCO.getCOMP_CODE());
			criteria.setCifNo(addressCommonCO.getCIF_NO());
			criteria.setPermAdd(KycManagementConstant.PERMANENT_ADDRESS);
			criteria.setLineNo(addressCommonCO.getLINE_NO());
			List<AddressCommonCO> addressList = addressBO.returnPermanentAddress(criteria);
			if (!addressList.isEmpty() && ((KycManagementConstant.Y).equalsIgnoreCase(addressCommonCO.getPERM_ADDRESS())))
			{
				throw new BOException(MessageCodes.PERMANENT_ADDRESS_IS_ALREADY_SET);
			}

			else if ("K001MT".equals(addressCommonCO.getOpt()))
			{
				CIF_ADDRESSVO cifAddressVO = new CIF_ADDRESSVO();
				cifAddressVO.setCIF_NO(addressCommonCO.getCIF_NO());
				cifAddressVO.setCOMP_CODE(addressCommonCO.getCOMP_CODE());
				cifAddressVO.setLINE_NO(BigDecimal.ZERO);
				cifAddressVO.setPERM_ADDRESS(addressCommonCO.getPERM_ADDRESS());
				genericDAO.update(cifAddressVO);
			}
		}
	}

	public void checkAddressDate(AddressCommonCO addressCommonCO) throws BaseException
	{
		Date fromDate = addressCommonCO.getFROM_DATE();

		if (fromDate != null && fromDate.before(DateUtil.parseDate("01/01/1900", "DD/MM/YYYY")))
		{
			throw new BOException(MessageCodes.INVALID_DATE);
		}
		Date toDate = addressCommonCO.getTO_DATE();
		if (toDate != null && toDate.before(DateUtil.parseDate("01/01/1900", "DD/MM/YYYY")))
		{
			throw new BOException(MessageCodes.INVALID_DATE);
		}

		if (fromDate != null && toDate != null)
		{
			compareDateFromDateTO(fromDate, toDate);

			if (DateUtil.getYearDifference(fromDate, toDate) > 100)
			{
				throw new BOException(MessageCodes.INVALID_DATE);
			}
		}

		if (fromDate != null && toDate == null && fromDate.before(DateUtil.parseDate("01/01/1900", "DD/MM/YYYY"))
				&& fromDate.after(DateUtil.parseDate("01/01/2100", "DD/MM/YYYY")))
		{
			throw new BOException(MessageCodes.INVALID_DATE);
		}
	}

	public void compareDateFromDateTO(Date DateFrom, Date DateTo) throws BaseException
	{

		if (DateFrom != null && DateTo != null

				&& DateFrom.after(DateTo))
		{

			throw new BOException(MessageCodes.TODATE_GREATER_FROMDATE);

		}

	}

	/*
	 * 
	 * 
	 * /** This method is to insert a new record or update KYCDetails Screen
	 */

	public void saveAmlKYCDetailsRec(FomCO fomCO1) throws BaseException
	{
		FomCO fomCO = fomCO1;

		if (NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_NO()))
		{
			return;
		}

		if (!(KycManagementConstant.ONE.equals(fomCO.getFomKYCIsloaded())))
		{
			fomCO = returnAMLKycDetailsRec(fomCO);
		}

		String tin = fomCO.getCifKYCVO().getTIN();
		if (!StringUtil.nullToEmpty(tin).isEmpty())
		{
			fomCO.getCifKYCVO().setTIN(tin.substring(0, 2) + tin.substring(3, tin.length()));
		}
//		if (!Boolean.valueOf(fomCO.getIsFromAlert())
//				&& (!KycManagementConstant.ONE.equals(fomCO.getFomKYCIsloaded()) || NumberUtil.isEmptyDecimal(fomCO.getScreenId())))
//		{
//			CIF_KYCVO cifKycVO = new CIF_KYCVO();
//			cifKycVO.setCOMP_CODE(fomCO.getCifVO().getCOMP_CODE());
//			cifKycVO.setCIF_NO(fomCO.getCifVO().getCIF_NO());
//
//			cifKycVO = (CIF_KYCVO) genericDAO.selectByPK(cifKycVO);
//
//			if (cifKycVO != null)
//			{
//				fomCO.setCifKYCVO(cifKycVO);
//				fomCO.setCrsSignYN(KycManagementConstant.N);
//			}
//			else
//			{
//				fomCO.getCifKYCVO().setCIF_ALREADY_EXIST_YN(KycManagementConstant.ZERO);
//			}
//
//		}

		fomCO = checkFomKYCMandatoryFields(fomCO);

		if (KycManagementConstant.ONE.equals(fomCO.getFomKYCIsloaded()))
		{
			CIF_KYCVO cifKycFromDB = new CIF_KYCVO();
			cifKycFromDB.setCOMP_CODE(fomCO.getLoginCompCode());
			cifKycFromDB.setCIF_NO(fomCO.getCifVO().getCIF_NO());
			cifKycFromDB = (CIF_KYCVO) genericDAO.selectByPK(cifKycFromDB);
			fomCO.getCifKYCVO().setCOMP_CODE(fomCO.getLoginCompCode());
			fomCO.getCifKYCVO().setCIF_NO(fomCO.getCifVO().getCIF_NO()); // -KYC Audit
//			if (fomCO.getCifKYCVO().getLONG_STAY_IN_COUNTRY_YN().equals(KycManagementConstant.MINUS_ONE))
//			{
//				fomCO.getCifKYCVO().setLONG_STAY_IN_COUNTRY_YN(KycManagementConstant.N);
//			}
			// added by nour for bug 974497
			if (fomCO.getCifKYCVO().getOTHER_PASSPORT_YN() != null && fomCO.getCifKYCVO().getOTHER_PASSPORT_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				fomCO.getCifKYCVO().setOTHER_PASSPORT_YN(KycManagementConstant.N);
			}
			if (fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN() != null && fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				fomCO.getCifKYCVO().setPOLITICAL_MEMBER_YN(KycManagementConstant.N);
			}
			if (fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN() != null
					&& fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				fomCO.getCifKYCVO().setOTHER_COUNTRY_TEL_ADDRESS_YN(KycManagementConstant.N);
			}
			if (fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN() != null
					&& fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				fomCO.getCifKYCVO().setPERM_RESID_OR_GREENCARD_YN(KycManagementConstant.N);
			}
			// end bug 974497
			if (fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME()!=null && fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME().equals(KycManagementConstant.MINUS_ONE))
			{
            	fomCO.getCifKYCVO().setSOURCE_ADDITIONAL_INCOME(KycManagementConstant.N);

			}
			if (fomCO.getCifKYCVO().getOWNER_SIGNATORY_PEP_YN()!=null && fomCO.getCifKYCVO().getOWNER_SIGNATORY_PEP_YN().equals(KycManagementConstant.MINUS_ONE))
			{
            	fomCO.getCifKYCVO().setOWNER_SIGNATORY_PEP_YN(KycManagementConstant.N);

			}
			
			if (fomCO.getCifKYCVO().getSIGNATORY_STAFF_RELATIVE_YN()!=null && fomCO.getCifKYCVO().getSIGNATORY_STAFF_RELATIVE_YN().equals(KycManagementConstant.MINUS_ONE))
			{
            	fomCO.getCifKYCVO().setSIGNATORY_STAFF_RELATIVE_YN(KycManagementConstant.N);

			}
			
			if (fomCO.getCifKYCVO().getCOMP_HOLDING_ENTITY_YN()!=null && fomCO.getCifKYCVO().getCOMP_HOLDING_ENTITY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
            	fomCO.getCifKYCVO().setCOMP_HOLDING_ENTITY_YN(KycManagementConstant.N);

			}
			
			if (fomCO.getCifKYCVO().getCOMP_STOCK_EXCHANGE_YN()!=null && fomCO.getCifKYCVO().getCOMP_STOCK_EXCHANGE_YN().equals(KycManagementConstant.MINUS_ONE))
			{
            	fomCO.getCifKYCVO().setCOMP_STOCK_EXCHANGE_YN(KycManagementConstant.N);

			}
			
			if (fomCO.getCifKYCVO().getENTITY_SUDSIDIARY_YN()!=null && fomCO.getCifKYCVO().getENTITY_SUDSIDIARY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
            	fomCO.getCifKYCVO().setENTITY_SUDSIDIARY_YN(KycManagementConstant.N);

			}
			
			if (fomCO.getCifKYCVO().getRECEIVE_FOREIGN_INCOME_YN()!=null && fomCO.getCifKYCVO().getRECEIVE_FOREIGN_INCOME_YN().equals(KycManagementConstant.MINUS_ONE))
			{
            	fomCO.getCifKYCVO().setRECEIVE_FOREIGN_INCOME_YN(KycManagementConstant.N);

			}
			genericDAO.delete(fomCO.getCifKYCVO());
			// fomCO.setRunningDate(commonLibBO.addSystemTimeToDate(fomCO.getRunningDate()));
			fomCO.getCifKYCVO().setKYC_UPDATE_DATE(fomCO.getRunningDate());
			genericDAO.insert(fomCO.getCifKYCVO());
		}
	}

	/**
	 * 
	 * This method is to retrieve FOMKYC Form records
	 */

	public FomCO checkFomKYCMandatoryFields(FomCO fomCOParam) throws BaseException
	{
		FomCO fomCO = fomCOParam;
		ArrayList<BaseException> eceptionList = new ArrayList<BaseException>();
		try
		{
			checkCifKycStatus(fomCO);

		}
		catch (BOException e)
		{
			eceptionList.add(e);
		}
		try
		{
			handleFatcaCompliantType(fomCO);
		}
		catch (BOException e)
		{
			eceptionList.add(e);
		}

		if (!eceptionList.isEmpty())
		{
			throw new BOException(eceptionList);
		}
		return fomCO;
	}

	public FomCO checkCifKycStatus(FomCO fomCO) throws BaseException
	{
		String cifAlreadyExist = StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getCIF_ALREADY_EXIST_YN(), "0");
		boolean kycMandatory = returnKycMandatory(fomCO);

		if (!fomKycMandatoryFields(fomCO) && (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getCOMPLETED_BY_CALL_YN())
				|| FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getRELUCTANT_YN())))
		{
			fomKycMandFieldsChecking(fomCO);
		}

		if (kycMandatory)
		{
			if (KycManagementConstant.ONE.equals(fomCO.getRifCttVO().getALLOW_KYC_NOT_COMPLETED()) || (KycManagementConstant.ONE.equals(cifAlreadyExist)
					&& KycManagementConstant.ONE.equals(fomCO.getRifCttVO().getALLOW_PROCEED_OUTSTANDING_YN())))
			{
				if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getCOMPLETED_BY_CALL_YN()))
				{
					fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_COMPLETED_BY_CALL);
				}
				else if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getRELUCTANT_YN()))
				{
					fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_RECALCITRANT);
				}
				else if (!fomKycMandatoryFields(fomCO))
				{
					fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_OUTSTANDING);
					fomCO.getCifKYCVO().setCOMPLETED_BY_CALL_YN(FomConstant.KYC_NO);
					fomCO.getCifKYCVO().setRELUCTANT_YN(FomConstant.KYC_NO);
				}
				else
				{
					fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_COMPLETED);
				}
			}
			else // KYC is mandatory and ALLOW_PROCEED_OUTSTANDING_YN unchecked
			{// Check if the KYC details are all filled correctly. If any error
				// arises don't allow to proceed
				if (!fomKycMandatoryFields(fomCO))
				{
					if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getCOMPLETED_BY_CALL_YN()))
					{
						fomCO.getCifKYCVO().setCOMPLETED_BY_CALL_YN(FomConstant.KYC_NO);
					}
					else if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getRELUCTANT_YN()))
					{
						fomCO.getCifKYCVO().setRELUCTANT_YN(FomConstant.KYC_NO);
					}
					else
					{
						fomKycMandFieldsChecking(fomCO);
					}
				}
				else // !fomKycMandatoryFields(fomCO) all mandatory fields are
						// filled
				{
					if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getCOMPLETED_BY_CALL_YN()))
					{
						fomCO.getCifVO().setKYC_COMPLETED(KycManagementConstant.C);
					}
					else if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getRELUCTANT_YN()))
					{
						fomCO.getCifVO().setKYC_COMPLETED(KycManagementConstant.R);
					}
					else
					{
						fomCO.getCifVO().setKYC_COMPLETED(KycManagementConstant.Y);
					}
				}

			}

			if (KycManagementConstant.ONE.equals(cifAlreadyExist) && KycManagementConstant.ZERO.equals(fomCO.getRifCttVO().getALLOW_PROCEED_OUTSTANDING_YN()))
			{
				if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getCOMPLETED_BY_CALL_YN()))
				{
					fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_COMPLETED_BY_CALL);
				}
				else if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getRELUCTANT_YN()))
				{
					fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_RECALCITRANT);
				}
				else
				{
					fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_COMPLETED);
				}
			}

		} // end manadatory

		else
		{// KYC not Mandatory
			if (!fomKycMandatoryFields(fomCO))
			{
				fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_OUTSTANDING);
				fomCO.getCifKYCVO().setCOMPLETED_BY_CALL_YN(FomConstant.KYC_NO);
				fomCO.getCifKYCVO().setRELUCTANT_YN(FomConstant.KYC_NO);
			}
			else if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getCOMPLETED_BY_CALL_YN()))
			{
				fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_COMPLETED_BY_CALL);
			}
			else if (FomConstant.KYC_YES.equals(fomCO.getCifKYCVO().getRELUCTANT_YN()))
			{
				fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_RECALCITRANT);
			}
			else
			{
				fomCO.getCifVO().setKYC_COMPLETED(FomConstant.KYC_COMPLETED);
			}
		}

		return fomCO;
	}

	/**
	 * @author abdowazen US 382751 - BB KYC with Dynamic Screen
	 */
	// TODO
	public boolean fomKycMandatoryFields(FomCO fomCO) throws BaseException
	{
		boolean bReturn = true;
		if ("0".equals(fomCO.getRifCttVO().getAPPLY_CORPORATE_KYC_YN()))
		{// KYC
			// OPENING_ACC_PURPOSE

			if (fomCO.getCifKYCVO().getOPENING_ACC_PURPOSE() == null || fomCO.getCifKYCVO().getOPENING_ACC_PURPOSE().isEmpty())
			{

				return bReturn = false;
			}

			// POLITICAL_MEMBER_SPEC
			if (fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN() == null || fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN().isEmpty()
					|| fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN())
					&& (fomCO.getCifKYCVO().getPOLITICAL_MEMBER_SPEC() == null || fomCO.getCifKYCVO().getPOLITICAL_MEMBER_SPEC().isEmpty()))
			{

				return bReturn = false;
			}

			// source Of Wealth
			if (!StringUtil.isNotEmpty(fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME())
					|| (KycManagementConstant.O.equals(fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME())
							&& (fomCO.getCifKYCVO().getSOURCE_SPEC() == null || fomCO.getCifKYCVO().getSOURCE_SPEC().isEmpty())))
			{
				return bReturn = false;
			}

			// INCOME_BUSINESS_YN

			if (fomCO.getCifKYCVO().getINCOME_BUSINESS_YN() == null || fomCO.getCifKYCVO().getINCOME_BUSINESS_YN().isEmpty()
					|| fomCO.getCifKYCVO().getINCOME_BUSINESS_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}

			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getINCOME_BUSINESS_YN()))
			{
				if (NumberUtil.emptyDecimalToZero(fomCO.getCifKYCVO().getBUSINESS_ECO_SECTOR_CODE()).compareTo(BigDecimal.ZERO) == 0)
				{
					return bReturn = false;
				}
				if (fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME() == null || fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME().isEmpty())
				{

					return bReturn = false;

				}
				if (NumberUtil.emptyDecimalToZero(fomCO.getCifKYCVO().getINCOME_BUSINESS_COUNTRY()).compareTo(BigDecimal.ZERO) == 0)
				{

					return bReturn = false;

				}
			}

			// ESTIMATED_INCOME_AMOUNT
			if (fomCO.getCifKYCVO().getESTIMATED_INCOME_AMOUNT() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getESTIMATED_INCOME_AMOUNT()) > 0)
			{

				return bReturn = false;

			}

			if (!StringUtil.isNotEmpty(fomCO.getCifKYCVO().getINCOME_PERIODICITY())
					|| (KycManagementConstant.THREE.equals(fomCO.getCifKYCVO().getINCOME_PERIODICITY())
							&& (fomCO.getCifKYCVO().getOTHER_INCOME_SPEC() == null || fomCO.getCifKYCVO().getOTHER_INCOME_SPEC().isEmpty())))
			{
				return bReturn = false;
			}

			// OTHER_PASSPORT_YN
			if (fomCO.getCifKYCVO().getOTHER_PASSPORT_YN() == null || fomCO.getCifKYCVO().getOTHER_PASSPORT_YN().isEmpty()
					|| fomCO.getCifKYCVO().getOTHER_PASSPORT_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}

			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOTHER_PASSPORT_YN()))
			{
				if (fomCO.getCifKYCVO().getOTHER_PASSPORT_COUNTRY() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getOTHER_PASSPORT_COUNTRY()) > 0)
				{
					return bReturn = false;
				}
			}

			// PERM_RESID_OR_GREENCARD_YN
			if (fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN() == null || fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN().isEmpty()
					|| fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				if (retCifCountryInfoCount(fomSC) <= 0)
					return bReturn = false;
			}

			// TAX_PAYER_ANY_COUNTRY_YN
			if (fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN() == null || fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN().isEmpty()
					|| fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (!StringUtil.isNotEmpty(fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN())
					|| KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2("E");
				if (retKycFinancialInfoCount(fomSC) <= 0)
					return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN() == null || fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN().isEmpty()
					|| fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			// OTHER_COUNTRY_TEL_ADDRESS_YN
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				if (retCifAddressCount(fomSC) <= 0)
					return bReturn = false;
			}

			// STAND_INSTR_OUT_COUNTRY_YN
			if (fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN() == null || fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN().isEmpty()
					|| fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}
			// checking on kyc_financial_info
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_SO_BENEFICIARIES);
				int count = retKycFinancialInfoCount(fomSC);
				if (count <= 0)
					return bReturn = false;
			}

			// ATTORNEY_OUTSIDE_COUNTRY_YN
			// TODO checking on kyc_financial_info
			if (fomCO.getCifKYCVO().getATTORNEY_OUTSIDE_COUNTRY_YN() == null || fomCO.getCifKYCVO().getATTORNEY_OUTSIDE_COUNTRY_YN().isEmpty()
					|| fomCO.getCifKYCVO().getATTORNEY_OUTSIDE_COUNTRY_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getATTORNEY_OUTSIDE_COUNTRY_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_AUTHORIZED_SIGNATORIES);
				if (retKycFinancialInfoCount(fomSC) <= 0)
					return bReturn = false;
			}

			// Check on passport info
			// At least one passport info should be filled

			if (!StringUtil.isNotEmpty(fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN())
					|| fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}

			if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOTHER_PASSPORT_YN()))
			{
				boolean passInfo1Filled = ((fomCO.getCif1VO().getPASPORT_NO() != null && !fomCO.getCif1VO().getPASPORT_NO().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_DATE() != null)
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE() != null && !fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_EXPIRY_DATE() != null));

				boolean passInfo2Filled = ((fomCO.getCif1VO().getPASSPORT_NO2() != null && !fomCO.getCif1VO().getPASSPORT_NO2().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_DATE2() != null)
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE2() != null && !fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE2().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_EXPIRY_DATE2() != null));

				boolean passInfo3Filled = ((fomCO.getCif1VO().getPASSPORT_NO3() != null && !fomCO.getCif1VO().getPASSPORT_NO3().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_DATE3() != null)
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE3() != null && !fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE3().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_EXPIRY_DATE3() != null));

				if (!passInfo1Filled && !passInfo2Filled && !passInfo3Filled)
				{
					return bReturn = false;
				}
			}

		}

		else // INSTITUTION FOR YMC
		{
			// OPENING_ACC_PURPOSE
			if (fomCO.getCifKYCVO().getOPENING_ACC_PURPOSE() == null || fomCO.getCifKYCVO().getOPENING_ACC_PURPOSE().isEmpty())
			{

				return bReturn = false;
			}
			// OTHER_OPENING_ACC_PURPOSE
			if ((fomCO.getCifKYCVO().getOTHER_OPENING_ACC_PURPOSE() == null || fomCO.getCifKYCVO().getOTHER_OPENING_ACC_PURPOSE().isEmpty())
					&& "Other".equals(fomCO.getCifKYCVO().getOPENING_ACC_PURPOSE()))
			{

				return bReturn = false;
			}
			// financial_ins_code
			if (fomCO.getCifKYCVO().getFINANCIAL_INS_CODE() == null || fomCO.getCifKYCVO().getFINANCIAL_INS_CODE().compareTo(BigDecimal.ZERO) < 0)
			{

				return bReturn = false;
			}
			if (fomCO.getCifKYCVO().getFINANCIAL_INS_CODE() == null || fomCO.getCifKYCVO().getFINANCIAL_INS_CODE().compareTo(BigDecimal.ZERO) < 0)
			{

				return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getOWNER_SIGNATORY_PEP_YN() == null || fomCO.getCifKYCVO().getOWNER_SIGNATORY_PEP_YN().isEmpty()
					|| fomCO.getCifKYCVO().getOWNER_SIGNATORY_PEP_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOWNER_SIGNATORY_PEP_YN()))
			{
				if (StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getPRESIDENT_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getPRIME_MINISTER_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getPARLIAMENT_SPEAKER_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getHEAD_PUBLIC_AUTH_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getHEAD_MILITARY_AUTH_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getHEAD_DEPARTMENT_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getDIPLOMAT_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getDIPLOMAT_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getCHAIRMAN_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getCHIEF_JUDGE_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getCONNECTION_WITH_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO)
						&& StringUtil.nullEmptyToValue(fomCO.getCifKYCVO().getRELATIVE_WITH_PEP_YN(), ConstantsCommon.ZERO).equals(ConstantsCommon.ZERO))
				{
					bReturn = false;
				}
			}

			if (KycManagementConstant.ONE.equals(fomCO.getCifKYCVO().getCONNECTION_WITH_PEP_YN()))
			{
				if (fomCO.getCifKYCVO().getNAME_PEP() == null || fomCO.getCifKYCVO().getNAME_PEP().isEmpty())
				{
					return bReturn = false;
				}
				if (fomCO.getCifKYCVO().getRELATION_NATURE_PEP() == null || fomCO.getCifKYCVO().getRELATION_NATURE_PEP().isEmpty())
				{
					return bReturn = false;
				}
			}
			if (KycManagementConstant.ONE.equals(fomCO.getCifKYCVO().getRELATIVE_WITH_PEP_YN()))
			{
				if (fomCO.getCifKYCVO().getRELATIVE_NAME() == null || fomCO.getCifKYCVO().getRELATIVE_NAME().isEmpty())
				{
					return bReturn = false;
				}
				if (fomCO.getCifKYCVO().getRELATIVE_RELATION_NATURE() == null || fomCO.getCifKYCVO().getRELATIVE_RELATION_NATURE().isEmpty())
				{
					return bReturn = false;
				}
			}

			if (fomCO.getCifKYCVO().getSIGNATORY_STAFF_RELATIVE_YN() == null || fomCO.getCifKYCVO().getSIGNATORY_STAFF_RELATIVE_YN().isEmpty()
					|| fomCO.getCifKYCVO().getSIGNATORY_STAFF_RELATIVE_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}

			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getSIGNATORY_STAFF_RELATIVE_YN()))
			{
				if (fomCO.getCifKYCVO().getSTAFF_MEMBER_NAME() == null || fomCO.getCifKYCVO().getSTAFF_MEMBER_NAME().isEmpty())
				{
					return bReturn = false;
				}
				if (fomCO.getCifKYCVO().getSTAFF_RELATION_DEGREE() == null || fomCO.getCifKYCVO().getSTAFF_RELATION_DEGREE().isEmpty())
				{
					return bReturn = false;
				}
			}

			if (fomCO.getCifKYCVO().getRECEIVE_FOREIGN_INCOME_YN() == null || fomCO.getCifKYCVO().getRECEIVE_FOREIGN_INCOME_YN().isEmpty()
					|| fomCO.getCifKYCVO().getRECEIVE_FOREIGN_INCOME_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getRECEIVE_FOREIGN_INCOME_YN()))
			{
				if (NumberUtil.emptyDecimalToZero(fomCO.getCifKYCVO().getRECEIVE_INCOME_COUNTRY_CODE()).compareTo(BigDecimal.ZERO) == 0)
				{
					return bReturn = false;
				}
				if ((fomCO.getCifKYCVO().getINCOME_INTREST_YN() == null || "0".equals(fomCO.getCifKYCVO().getINCOME_INTREST_YN()))
						&& (fomCO.getCifKYCVO().getINCOME_RENTS_YN() == null || "0".equals(fomCO.getCifKYCVO().getINCOME_RENTS_YN()))
						&& (fomCO.getCifKYCVO().getINCOME_CAPITAL_YN() == null || "0".equals(fomCO.getCifKYCVO().getINCOME_CAPITAL_YN()))
						&& (fomCO.getCifKYCVO().getOTHER_INCOME_YN() == null || "0".equals(fomCO.getCifKYCVO().getOTHER_INCOME_YN())))
				{
					return bReturn = false;
				}

				if (KycManagementConstant.ONE.equals(fomCO.getCifKYCVO().getOTHER_INCOME_YN()))
				{
					if (fomCO.getCifKYCVO().getOTHER_INCOME() == null || fomCO.getCifKYCVO().getOTHER_INCOME().isEmpty())
					{
						return bReturn = false;
					}

				}
			}

			if (fomCO.getCifKYCVO().getFOREIGN_COMPANY_YN() == null || fomCO.getCifKYCVO().getFOREIGN_COMPANY_YN().isEmpty()
					|| fomCO.getCifKYCVO().getFOREIGN_COMPANY_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getFOREIGN_COMPANY_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2("D");
				if (retKycFinancialInfoCount(fomSC) <= 0)
					return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getCOMP_FOREIGN_ADDRESS_YN() == null || fomCO.getCifKYCVO().getCOMP_FOREIGN_ADDRESS_YN().isEmpty()
					|| fomCO.getCifKYCVO().getCOMP_FOREIGN_ADDRESS_YN().equals(KycManagementConstant.MINUS_ONE))
			{

				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getCOMP_FOREIGN_ADDRESS_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				if (retCifAddressCount(fomSC) <= 0)
					return bReturn = false;
			}
			if (fomCO.getCifKYCVO().getCOMP_OWN_EXCEEDING_PERC_YN() == null || fomCO.getCifKYCVO().getCOMP_OWN_EXCEEDING_PERC_YN().isEmpty()
					|| fomCO.getCifKYCVO().getCOMP_OWN_EXCEEDING_PERC_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getCOMP_OWN_EXCEEDING_PERC_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_COMP_OWN_EXCEED_PERC);
				if (retKycFinancialInfoCount(fomSC) <= 0)
					return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getPARTNER_EXCEEDING_PERC_YN() == null || fomCO.getCifKYCVO().getPARTNER_EXCEEDING_PERC_YN().isEmpty()
					|| fomCO.getCifKYCVO().getPARTNER_EXCEEDING_PERC_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getPARTNER_EXCEEDING_PERC_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_PARTNER_OWN_EXCEED_PERC);
				if (retKycFinancialInfoCount(fomSC) <= 0)
					return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getSO_FOREIGN_TRANSFER_YN() == null || fomCO.getCifKYCVO().getSO_FOREIGN_TRANSFER_YN().isEmpty()
					|| fomCO.getCifKYCVO().getSO_FOREIGN_TRANSFER_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getSO_FOREIGN_TRANSFER_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_SO_BENEFICIARIES);
				if (retKycFinancialInfoCount(fomSC) <= 0)
					return bReturn = false;
			}
			if (fomCO.getCifKYCVO().getATTORNEY_FOREIGN_ADDRESS_YN() == null || fomCO.getCifKYCVO().getATTORNEY_FOREIGN_ADDRESS_YN().isEmpty()
					|| fomCO.getCifKYCVO().getATTORNEY_FOREIGN_ADDRESS_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getATTORNEY_FOREIGN_ADDRESS_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_ATTORNEY_FOREIGN_ADDRESS);
				if (retKycFinancialInfoCount(fomSC) <= 0)
					return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getTYPE_OF_ACCOUNT() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getTYPE_OF_ACCOUNT()) > 0)
			{
				return bReturn = false;
			}
			if (fomCO.getCifKYCVO().getCOMP_LEGAL_ENTITY() == null || fomCO.getCifKYCVO().getCOMP_LEGAL_ENTITY().isEmpty())
			{
				return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getCOMP_STOCK_EXCHANGE_YN() == null || fomCO.getCifKYCVO().getCOMP_STOCK_EXCHANGE_YN().isEmpty()
					|| fomCO.getCifKYCVO().getCOMP_STOCK_EXCHANGE_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getCOMP_STOCK_EXCHANGE_YN()))
			{
				if (fomCO.getCifKYCVO().getREF_REG_STOCK_EXCHANGE() == null || fomCO.getCifKYCVO().getREF_REG_STOCK_EXCHANGE().isEmpty())
				{
					return bReturn = false;
				}
				if (fomCO.getCifKYCVO().getREGULATOR_ENTITY() == null || fomCO.getCifKYCVO().getREGULATOR_ENTITY().isEmpty())
				{
					return bReturn = false;
				}
			}

			if (fomCO.getCifKYCVO().getENTITY_SUDSIDIARY_YN() == null || fomCO.getCifKYCVO().getENTITY_SUDSIDIARY_YN().isEmpty()
					|| fomCO.getCifKYCVO().getENTITY_SUDSIDIARY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getENTITY_SUDSIDIARY_YN()))
			{
				if (fomCO.getCifKYCVO().getPARENT_ENTITY() == null || fomCO.getCifKYCVO().getPARENT_ENTITY().isEmpty())
				{
					return bReturn = false;
				}
			}

			if (fomCO.getCifKYCVO().getCOMP_HOLDING_ENTITY_YN() == null || fomCO.getCifKYCVO().getCOMP_HOLDING_ENTITY_YN().isEmpty()
					|| fomCO.getCifKYCVO().getCOMP_HOLDING_ENTITY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getCOMP_HOLDING_ENTITY_YN()))
			{
				if (fomCO.getCifKYCVO().getDETAILS_SUBSIDIARY_ENTITIES() == null || fomCO.getCifKYCVO().getDETAILS_SUBSIDIARY_ENTITIES().isEmpty())
				{
					return bReturn = false;
				}
			}
			// }

			if (fomCO.getCifKYCVO().getEXPECTED_INCOME() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getEXPECTED_INCOME()) >= 0)
			{
				return bReturn = false;
			}
			if (fomCO.getCifKYCVO().getINCOME_FREQUENCY_TYPE() == null || fomCO.getCifKYCVO().getINCOME_FREQUENCY_TYPE().isEmpty())
			{
				return bReturn = false;
			}
			if (fomCO.getCifKYCVO().getINCOME_THROUGH() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getINCOME_THROUGH()) >= 0)
			{
				return bReturn = false;
			}
			if (fomCO.getCifKYCVO().getSOURCE_WEALTH() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getSOURCE_WEALTH()) >= 0)
			{
				return bReturn = false;
			}
			if (fomCO.getCifKYCVO().getPAID_CAPITAL() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getPAID_CAPITAL()) >= 0)
			{
				return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getINITIAL_DEPOSIT() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getINITIAL_DEPOSIT()) >= 0)
			{
				return bReturn = false;
			}
			if (fomCO.getCifKYCVO().getDEPOSIT_THROUGH() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getDEPOSIT_THROUGH()) >= 0)
			{
				return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getOTHER_EXIST_BANK_YN() == null || fomCO.getCifKYCVO().getOTHER_EXIST_BANK_YN().isEmpty()
					|| fomCO.getCifKYCVO().getOTHER_EXIST_BANK_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOTHER_EXIST_BANK_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2("O");
				if (retKycFinancialInfoCount(fomSC) <= 0)
					return bReturn = false;
			}

			if (fomCO.getCifKYCVO().getCOMP_PHONE_YN() == null || fomCO.getCifKYCVO().getCOMP_PHONE_YN().isEmpty()
					|| fomCO.getCifKYCVO().getCOMP_PHONE_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				return bReturn = false;
			}
			else if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getCOMP_PHONE_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2("H");
				if (retKycFinancialInfoCount(fomSC) <= 0)
					return bReturn = false;
			}
			// }

			FomSC fomSC = new FomSC();
			fomSC.setCompCode(fomCO.getLoginCompCode());
			fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
			fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_ACTUAL_BENEFICIARIES);
			if (retKycFinancialInfoCount(fomSC) <= 0)
			{
				return bReturn = false;

			}
			fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_AUTHORIZED_SIGNATORIES);
			if (retKycFinancialInfoCount(fomSC) <= 0)
			{
				return bReturn = false;
			}
			fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_BOARD_MEMBERS_MANAGERS);
			if (retKycFinancialInfoCount(fomSC) <= 0)
			{
				return bReturn = false;
			}
			fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_SHAREHOLDERS);
			if (retKycFinancialInfoCount(fomSC) <= 0)
			{
				return bReturn = false;
			}
		}

		if (StringUtil.nullToEmpty(fomCO.getCrsSignYN()).equals("") || fomCO.getCrsSignYN().equals(KycManagementConstant.MINUS_ONE))
		{
			return bReturn = false;
		}
		return bReturn;
	}

	// TODO

	public boolean fomKycMandFieldsChecking(FomCO fomCO) throws BaseException
	{
		boolean bReturn = true;
		CommonLibSC sc = new CommonLibSC();
		sc.setAppName(ConstantsCommon.RET_APP_NAME);
		sc.setProgRef(ConstantsCommon.PROGREF_ROOT);

		if (KycManagementConstant.A.equals(fomCO.getCifVO().getLANGUAGE()))
		{
			sc.setLanguage("AR");
		}
		else
		{
			sc.setLanguage(fomCO.getLanguage());
		}
		String transMessage;
		if ("0".equals(fomCO.getRifCttVO().getAPPLY_CORPORATE_KYC_YN()))
		{// KYC
			// OPENING_ACC_PURPOSE

			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getOPENING_ACC_PURPOSE()).equals(""))
			{
				sc.setKeyLabelCode("purposeOfOpeningAcc_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			// POLITICAL_MEMBER_SPEC
			// FIX ISSUE #224920 replace "1" by KycManagementConstant.Y
			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN()).equals("")
					|| fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN().equals(KycManagementConstant.MINUS_ONE)
					|| (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN())
							&& StringUtil.nullToEmpty(fomCO.getCifKYCVO().getPOLITICAL_MEMBER_SPEC()).equals("")))
			{
				sc.setKeyLabelCode("confirmPoliticalMember_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			// INCOME_BUSINESS_YN

			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getINCOME_BUSINESS_YN()).equals("")
					|| fomCO.getCifKYCVO().getINCOME_BUSINESS_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				sc.setKeyLabelCode("business_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getINCOME_BUSINESS_YN()))
			{
				if (NumberUtil.emptyDecimalToZero(fomCO.getCifKYCVO().getBUSINESS_ECO_SECTOR_CODE()).compareTo(BigDecimal.ZERO) == 0)
				{
					sc.setKeyLabelCode("economic_sector_key");
					transMessage = commonLibBO.returnKeyLabelTrans(sc);
					throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
				}
				if (fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME() == null || fomCO.getCifKYCVO().getSOURCE_ADDITIONAL_INCOME().isEmpty())
				{
					sc.setKeyLabelCode("business_key");
					transMessage = commonLibBO.returnKeyLabelTrans(sc);
					throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);

				}
				if (NumberUtil.emptyDecimalToZero(fomCO.getCifKYCVO().getINCOME_BUSINESS_COUNTRY()).compareTo(BigDecimal.ZERO) == 0)
				{
					sc.setKeyLabelCode("Country_key");
					transMessage = commonLibBO.returnKeyLabelTrans(sc);
					throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);

				}
			}

			// ESTIMATED_INCOME_AMOUNT
			if (fomCO.getCifKYCVO().getESTIMATED_INCOME_AMOUNT() == null || BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getESTIMATED_INCOME_AMOUNT()) > 0)
			{
				sc.setKeyLabelCode("estimatedIncome_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);

			}

			if (!StringUtil.isNotEmpty(fomCO.getCifKYCVO().getINCOME_PERIODICITY())
					|| (KycManagementConstant.THREE.equals(fomCO.getCifKYCVO().getINCOME_PERIODICITY())
							&& (fomCO.getCifKYCVO().getOTHER_INCOME_SPEC() == null || fomCO.getCifKYCVO().getOTHER_INCOME_SPEC().isEmpty())))
			{
				sc.setKeyLabelCode("estimatedIncome_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			// OTHER_PASSPORT_YN
			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getOTHER_PASSPORT_YN()).equals("")
					|| fomCO.getCifKYCVO().getOTHER_PASSPORT_YN().equals(KycManagementConstant.MINUS_ONE)
					|| (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOTHER_PASSPORT_YN()) && (fomCO.getCifKYCVO().getOTHER_PASSPORT_COUNTRY() == null
							|| BigDecimal.ZERO.compareTo(fomCO.getCifKYCVO().getOTHER_PASSPORT_COUNTRY()) > 0)))
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("do_you_have_another_passport_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN()).equals("")
					|| fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("areyougreencardholder_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				if (retCifCountryInfoCount(fomSC) <= 0)
				{
					sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
					sc.setKeyLabelCode("areyougreencardholder_key");
					transMessage = commonLibBO.returnKeyLabelTrans(sc);
					throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, transMessage, true);
				}
			}

			// TAX_PAYER_ANY_COUNTRY_YN
			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN()).equals("")
					|| fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("areyoutaxpayer_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			if (!StringUtil.isNotEmpty(fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN())
					|| KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2("E");
				if (retKycFinancialInfoCount(fomSC) <= 0)
				{
					sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
					sc.setKeyLabelCode("areyoutaxpayer_key");
					transMessage = commonLibBO.returnKeyLabelTrans(sc);
					throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
				}
			}

			// OTHER_COUNTRY_TEL_ADDRESS_YN
			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN()).equals("")
					|| fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("addresstelephoneothercountry_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOTHER_COUNTRY_TEL_ADDRESS_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				if (retCifAddressCount(fomSC) <= 0)
				{
					sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
					sc.setKeyLabelCode("addresstelephoneothercountry_key");
					transMessage = commonLibBO.returnKeyLabelTrans(sc);
					throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
				}
			}

			// STAND_INSTR_OUT_COUNTRY_YN
			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN()).equals("")
					|| fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("standinginstroutsidecountry_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}
			// checking on kyc_financial_info
			if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_SO_BENEFICIARIES);
				int count = retKycFinancialInfoCount(fomSC);
				if (count <= 0)
				{
					sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
					sc.setKeyLabelCode("standinginstroutsidecountry_key");
					transMessage = commonLibBO.returnKeyLabelTrans(sc);
					throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
				}
			}

			// ATTORNEY_OUTSIDE_COUNTRY_YN
			// checking on kyc_financial_info
			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getATTORNEY_OUTSIDE_COUNTRY_YN()).equals("")
					|| fomCO.getCifKYCVO().getATTORNEY_OUTSIDE_COUNTRY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("powerattorneykey");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getATTORNEY_OUTSIDE_COUNTRY_YN()))
			{
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(fomCO.getLoginCompCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_AUTHORIZED_SIGNATORIES);
				if (retKycFinancialInfoCount(fomSC) <= 0)
				{
					sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
					sc.setKeyLabelCode("powerattorneykey");
					transMessage = commonLibBO.returnKeyLabelTrans(sc);
					throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
				}
			}

			// Check on passport info
			// At least one passport info should be filled

			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN()).equals("")
					|| fomCO.getCifKYCVO().getSTAND_INSTR_OUT_COUNTRY_YN().equals(KycManagementConstant.MINUS_ONE))
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("standinginstroutsidecountry_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOTHER_PASSPORT_YN()))
			{
				boolean passInfo1Filled = ((fomCO.getCif1VO().getPASPORT_NO() != null && !fomCO.getCif1VO().getPASPORT_NO().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_DATE() != null)
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE() != null && !fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_EXPIRY_DATE() != null));

				boolean passInfo2Filled = ((fomCO.getCif1VO().getPASSPORT_NO2() != null && !fomCO.getCif1VO().getPASSPORT_NO2().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_DATE2() != null)
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE2() != null && !fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE2().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_EXPIRY_DATE2() != null));

				boolean passInfo3Filled = ((fomCO.getCif1VO().getPASSPORT_NO3() != null && !fomCO.getCif1VO().getPASSPORT_NO3().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_DATE3() != null)
						&& (fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE3() != null && !fomCO.getCif1VO().getPASSPORT_ISSUE_PLACE3().isEmpty())
						&& (fomCO.getCif1VO().getPASSPORT_EXPIRY_DATE3() != null));

				if (!passInfo1Filled && !passInfo2Filled && !passInfo3Filled)
				{
					// check if passport information empty also in database
					CIF1VO cif1VO = new CIF1VO();
					cif1VO.setCOMP_CODE(fomCO.getLoginCompCode());
					cif1VO.setCIF_NO(fomCO.getCifVO().getCIF_NO());
					cif1VO = (CIF1VO) genericDAO.selectByPK(cif1VO);
					if (cif1VO == null)
					{
						passInfo1Filled = false;
						passInfo2Filled = false;
						passInfo3Filled = false;
					}
					else
					{
						passInfo1Filled = ((cif1VO.getPASPORT_NO() != null && !cif1VO.getPASPORT_NO().isEmpty()) && (cif1VO.getPASSPORT_ISSUE_DATE() != null)
								&& (cif1VO.getPASSPORT_ISSUE_PLACE() != null && !cif1VO.getPASSPORT_ISSUE_PLACE().isEmpty())
								&& (cif1VO.getPASSPORT_EXPIRY_DATE() != null));

						passInfo2Filled = ((cif1VO.getPASSPORT_NO2() != null && !cif1VO.getPASSPORT_NO2().isEmpty())
								&& (cif1VO.getPASSPORT_ISSUE_DATE2() != null)
								&& (cif1VO.getPASSPORT_ISSUE_PLACE2() != null && !cif1VO.getPASSPORT_ISSUE_PLACE2().isEmpty())
								&& (cif1VO.getPASSPORT_EXPIRY_DATE2() != null));

						passInfo3Filled = ((cif1VO.getPASSPORT_NO3() != null && !cif1VO.getPASSPORT_NO3().isEmpty())
								&& (cif1VO.getPASSPORT_ISSUE_DATE3() != null)
								&& (cif1VO.getPASSPORT_ISSUE_PLACE3() != null && !cif1VO.getPASSPORT_ISSUE_PLACE3().isEmpty())
								&& (cif1VO.getPASSPORT_EXPIRY_DATE3() != null));
					}
					if (!passInfo1Filled && !passInfo2Filled && !passInfo3Filled)
					{
						sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
						sc.setKeyLabelCode("do_you_have_another_passport_key");
						transMessage = commonLibBO.returnKeyLabelTrans(sc);
						throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
					}
				}
			}

		}

		else // INSTITUTION FOR YMC
		{
			// OPENING_ACC_PURPOSE
			if (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getOPENING_ACC_PURPOSE()).equals("")
					|| (StringUtil.nullToEmpty(fomCO.getCifKYCVO().getOTHER_OPENING_ACC_PURPOSE()).equals("")
							&& "Other".equals(fomCO.getCifKYCVO().getOPENING_ACC_PURPOSE())))
			{
				sc.setKeyLabelCode("purposeOfOpeningAcc_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			FomSC fomSC = new FomSC();
			fomSC.setCompCode(fomCO.getLoginCompCode());
			fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
			fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_ACTUAL_BENEFICIARIES);
			if (retKycFinancialInfoCount(fomSC) <= 0)
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("actualBenef_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);

			}
			fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_AUTHORIZED_SIGNATORIES);
			if (retKycFinancialInfoCount(fomSC) <= 0)
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("authSignatories_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}
			fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_BOARD_MEMBERS_MANAGERS);
			if (retKycFinancialInfoCount(fomSC) <= 0)
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("boardmembersmanagers_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}
			fomSC.setADD_STRING2(FomConstant.FINANCIAL_INFO_SHAREHOLDERS);
			if (retKycFinancialInfoCount(fomSC) <= 0)
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("shareholders_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}

			if (StringUtil.nullToEmpty(fomCO.getCrsSignYN()).equals("") || fomCO.getCrsSignYN().equals(KycManagementConstant.MINUS_ONE))
			{
				sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
				sc.setKeyLabelCode("did_the_customer_fill_and_sign_the_common_reporting_standard_key");
				transMessage = commonLibBO.returnKeyLabelTrans(sc);
				throw new BOException(MessageCodes.KYC_DETAILS_ARE_MISSING, new String[] { transMessage }, true);
			}
		}

		return bReturn;
	}

	public int retKycFinancialInfoCount(FomSC fomSC) throws BaseException
	{
		return kycManagementDAO.retKycFinancialInfoCount(fomSC);
	}

	/**
	 * Adding business rules to the HashMap to CIF Screen
	 * 
	 * @param elementId
	 * @param elementName
	 * @param actionType
	 * @param value
	 * @throws BaseException
	 */
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> addActionToFOMElement(String elementId, String elementName, String actionType, Object value1,
			HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo) throws BaseException
	{
		return coreCommonServiceBO.addActionToFOMElement(elementId, elementName, actionType, value1, businessMapToApplyTo);
	}

	private boolean returnKycMandatory(FomCO fomCO) throws BaseException
	{

		boolean bRetrun = false;
		if (fomCO.getRifCttVO() == null || NumberUtil.isEmptyDecimal(fomCO.getRifCttVO().getTYPE_CODE()))
		{
			RIFCTTVO rifCttVO = returnCifTypeDetails(fomCO.getLoginCompCode(), fomCO.getCifVO().getCIF_TYPE());
			if (rifCttVO != null)
			{
				fomCO.setRifCttVO(rifCttVO);
			}
		}
		if (KycManagementConstant.Y.equals(fomCO.getRifCttVO().getKYC_MANDATORY_YN()))
			bRetrun = true;

		return bRetrun;
	}

	public RIFCTTVO returnCifTypeDetails(BigDecimal companyCode, BigDecimal cifTypeCode) throws BaseException
	{
		RIFCTTVO rifCttVO = new RIFCTTVO();
		rifCttVO.setCOMP_CODE(companyCode);
		rifCttVO.setTYPE_CODE(cifTypeCode);
		return (RIFCTTVO) genericDAO.selectByPK(rifCttVO);
	}

	public FomCO handleFatcaCompliantType(FomCO fomCO) throws BaseException
	{
		if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getRELUCTANT_YN()))
		{
			fomCO.getCifKYCVO().setFATCA_COMPLIANT_TYPE("D");
		}
		else
		{
			FomSC fomSC = new FomSC();
			fomSC.setCompCode(fomCO.getLoginCompCode());
			fomSC.setNationality(fomCO.getCifVO().getNATION_CODE());
			fomSC.setCountry(fomCO.getCifVO().getCOUNTRY());
			fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
			if (ConstantsCommon.YES.equals(fomCO.getCifKYCVO().getOTHER_PASSPORT_YN()))
			{
				fomSC.setCountry2(fomCO.getCifKYCVO().getOTHER_PASSPORT_COUNTRY());
			}
			if (ConstantsCommon.YES.equals(fomCO.getCifKYCVO().getPERM_RESID_OR_GREENCARD_YN()))
			{
				fomSC.setCountry3(fomCO.getCifKYCVO().getPERM_RESID_COUNTRY_CODE());
			}
			if (ConstantsCommon.YES.equals(fomCO.getCifKYCVO().getTAX_PAYER_ANY_COUNTRY_YN()))
			{
				fomSC.setCountry4(fomCO.getCifKYCVO().getTAX_PAYER_COUNTRY_CODE());
			}

			if (KycManagementConstant.CIF_IS_INDIVIDUAL.equals(fomCO.getRifCttVO().getVT_IND()))
			{
				fomSC.setADD_STRING2(KycManagementConstant.E);
			}
			else
			{
				fomSC.setADD_STRING2(KycManagementConstant.D);
			}

			fomSC.setCountry1(fomCO.getCifVO().getCOUNTRY_OF_BIRTH());

		}
		return fomCO;
	}

	public FomCO onFomKYCLoad(FomCO fomCOParam) throws BaseException
	{
		FomCO fomCO = fomCOParam;
		/*
		 * to define the format of amount by currency
		 */

		NumberUtil.resetEmptyValues(fomCO);
		RequiredFieldsSC criteria = new RequiredFieldsSC();
		criteria.setCompCode(fomCO.getLoginCompCode());
		criteria.setBranchCode(fomCO.getLoginBraCode());
		criteria.setPreferredLanguage(fomCO.getLoginPreferrredLanguage());
		criteria.setLoginUserId(fomCO.getLoginUserId());
		criteria.setAppName(fomCO.getAppName());
		criteria.setLangCode(fomCO.getLanguage());
		criteria.setProgRef(FomConstant.PARENT_OPT);

		Map<String, Object> hm = new HashMap<String, Object>();

		hm.put(ConstantsCommon.ENTITY_CIF_TYPE_LOV, fomCO.getCifVO().getCIF_TYPE());
		hm.put(ConstantsCommon.ENTITY_COUNTRY_ID_LOV, fomCO.getAddressCommonCO().getCOUNTRY());
		criteria.setEntityTypeInfosMap(hm);

		if (!NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_TYPE()))
		{
			criteria.setCifType(fomCO.getCifVO().getCIF_TYPE());
		}
		if (!NumberUtil.isEmptyDecimal(fomCO.getAddressCommonCO().getCOUNTRY()))
		{
			criteria.setCountryId(fomCO.getAddressCommonCO().getCOUNTRY());

		}

		if (NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_TYPE()))
		{
			criteria.setCifType(BigDecimal.ZERO);
		}
		else
		{
			criteria.setCifType(fomCO.getCifVO().getCIF_TYPE());
		}

		HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> requiredMap = commonLibBO.returnMapRequiredData(criteria);

		requiredMap.get("fomCO.cifKYCVO.OPENING_ACC_PURPOSE");

		fomCO.setBuisnessElement(requiredMap);

		fomKYCSetEstimatedIncomeFormat(fomCO);

		if (null == fomCO.getCifKYCVO())
		{
			return fomCO;
		}

		if (KycManagementConstant.ONE.equals(fomCO.getCifKYCVO().getPOLITICAL_MEMBER_YN()))
		{
			addActionToFOMElement("politicalMember_pleaseSpecify", ConstantsCommon.ACTION_TYPE_READONLY, "0", fomCO);
		}
		if (KycManagementConstant.ONE.equals(fomCO.getCifKYCVO().getOTHER_PASSPORT_YN()))
		{
			addActionToFOMElement("lookuptxt_passportCountry", ConstantsCommon.ACTION_TYPE_READONLY, "0", fomCO);
		}

		if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getOTHER_INCOME_YN()) || "true".equals(fomCO.getCifKYCVO().getINCOME_BUSINESS_YN()))
		{
			addActionToFOMElement("otherIncomeSpec", ConstantsCommon.ACTION_TYPE_READONLY, "0", fomCO);
		}
		if (KycManagementConstant.THREE.equals(fomCO.getCifKYCVO().getINCOME_PERIODICITY()))
		{
			addActionToFOMElement("estimatedIncomePleaseSpecify", ConstantsCommon.ACTION_TYPE_READONLY, "0", fomCO);
		}
		if (KycManagementConstant.Y.equals(fomCO.getCifKYCVO().getSOURCE_OTHER_YN()) || "true".equals(fomCO.getCifKYCVO().getINCOME_BUSINESS_YN()))
		{
			addActionToFOMElement("otherSourceSpec", ConstantsCommon.ACTION_TYPE_READONLY, "0", fomCO);
		}

		// Load KYC address
		FomSC fomSC = new FomSC();
		fomSC.setCompCode(fomCO.getLoginCompCode());
		fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
		List<CIF_ADDRESSVO> cifKycAddressList = kycManagementDAO.returnFomKycAddress(fomSC);
		CIF_ADDRESSVO cifKycAddress = cifKycAddressList.isEmpty() ? null : cifKycAddressList.get(0);
		if (cifKycAddress != null && KycManagementConstant.ONE.equals(fomCO.getIsEmptyScreen()))
		{
			fomCO.setKycAddressCountryCode(cifKycAddress.getCOUNTRY());
			fomCO.setKycAddressState(cifKycAddress.getSTATE_ENG());
			fomCO.setKycAddressGovernate(cifKycAddress.getGOVERNERATE_ENG());
			if (!NumberUtil.isEmptyDecimal(cifKycAddress.getPOSTAL_CODE()))
			{
				fomCO.setKycAddressPostalCode(cifKycAddress.getPOSTAL_CODE().setScale(0, BigDecimal.ROUND_DOWN));
			}
			fomCO.setKycAddressEmail(cifKycAddress.getEMAIL());
			fomCO.setKycStreet(cifKycAddress.getADDRESS2_ENG());
			fomCO.setKycAvenue(cifKycAddress.getADDRESS3_ENG());
			fomCO.setKycBlock(cifKycAddress.getADDRESS1_ENG());
			fomCO.setKycHouseBuildling(cifKycAddress.getADDRESS4_ENG());
			fomCO.setKycTel(cifKycAddress.getTEL());
			fomCO.setKycFax(cifKycAddress.getFAX());
			fomCO.setKycRegion(cifKycAddress.getREGION());
			fomCO.setKycPoBox(cifKycAddress.getPO_BOX());
			fomCO.setKycAddressPoboxCode(cifKycAddress.getPO_BOX());
		}
		FomCO fomCODesc = kycManagementDAO.returnFomKycDescription(fomCO);

		if (fomCODesc != null)
		{
			PathPropertyUtil.copyProperties(fomCODesc, fomCO, "countryKYCDesc countryKYCDesc", "incomeBusinessCntryDesc incomeBusinessCntryDesc",
					"kycOpeningAccPurposeDesc kycOpeningAccPurposeDesc", "kycResidentBankName kycResidentBankName",
					"kycBusinessEcoSectorDesc kycBusinessEcoSectorDesc", "kycGreenCardCountryDesc kycGreenCardCountryDesc",
					"kycLongStayCountryDesc kycLongStayCountryDesc", "kycTaxPayerCountryDesc kycTaxPayerCountryDesc",
					"kycStandInstrCountryDesc kycStandInstrCountryDesc", "kycRemitterBenefNationalityDesc kycRemitterBenefNationalityDesc",
					"kycAttorneyCountryDesc kycAttorneyCountryDesc", "kycStandInstrCountryDesc kycStandInstrCountryDesc",
					"kycAddressCountryDesc kycAddressCountryDesc", "kycAddressPostalCodeDesc kycAddressPostalCodeDesc", "kycRegionDesc kycRegionDesc",
					"ymcTypeOfAccountDesc ymcTypeOfAccountDesc", "kycSourceOfWealth kycSourceOfWealth", "ymcOtherCntryDesc ymcOtherCntryDesc",
					"compCountryDesc compCountryDesc", "recvIncomeCntryDesc recvIncomeCntryDesc", "incomeThroughDesc incomeThroughDesc",
					"depositThroughDesc depositThroughDesc", "ymcStatusDesc ymcStatusDesc");
		}

		if (FomConstant.KYC_COMPLETED.equals(fomCO.getCifVO().getKYC_COMPLETED()))
		{
			fomCO.getCifKYCVO().setKYC_FORM(KycManagementConstant.ONE);
			fomCO.getCifKYCVO().setACC_OPEN_FORM(KycManagementConstant.ONE);
			fomCO.getCifKYCVO().setCR(KycManagementConstant.ONE);
			fomCO.getCifKYCVO().setMEMS_ARTS(KycManagementConstant.ONE);
		}

		String tin = fomCO.getCifKYCVO().getTIN();
		if (!StringUtil.nullToEmpty(tin).isEmpty())
		{
			fomCO.getCifKYCVO().setTIN(tin.substring(0, 2) + "-" + tin.substring(2, tin.length()));
		}

		fomCO.setTinMinLengthMessage(commonLibBO.returnTranslErrorMessage(MessageCodes.LENGTH_OF_PARAM2_SHOULD_BE_EQUAL_TO_PARAM1, new String[] { "9", "TIN" },
				fomCO.getLanguage()));

		return fomCO;
	}

	public FomCO fomKYCSetEstimatedIncomeFormat(FomCO fomCO) throws BaseException
	{
		String currecnyFormatter = CommonMethods.currencyMask(fomCO.getBaseCurrDecPoint());
		addActionToFOMElement("estimatedIncome", ConstantsCommon.ACTION_TYPE_DECFORMAT, currecnyFormatter, fomCO);
		addActionToFOMElement("estimatedIncome", ConstantsCommon.ACTION_TYPE_MAXLENGTH, KycManagementConstant.ADDRESS_DETAILS_MAX_LENGTH, fomCO);
		return fomCO;
	}

	public FomCO addActionToFOMElement(String element, String actionType, Object value1, FomCO fomCO) throws BaseException
	{
		return coreCommonServiceBO.addActionToFOMElement(element, actionType, value1, fomCO);
	}

	public FomCO addActionToFOMElement(List<String> elementsList, String actionType, Object value1, FomCO fomCO) throws BaseException
	{
		Object value = value1;
		RequiredFieldsSC criteria = new RequiredFieldsSC();
		criteria.setAppName(fomCO.getAppName());
		criteria.setLangCode(fomCO.getLanguage());
		criteria.setProgRef((null == fomCO.getOpt()) ? FomConstant.MAINTENANCE_OPT : fomCO.getOpt());
		criteria.setCompCode(fomCO.getLoginCompCode());

		Map<String, Object> hm = new HashMap<String, Object>();

		hm.put(ConstantsCommon.ENTITY_CIF_TYPE_LOV, fomCO.getCifVO().getCIF_TYPE());
		hm.put(ConstantsCommon.ENTITY_COUNTRY_ID_LOV, fomCO.getAddressCommonCO().getCOUNTRY());
		hm.put(ConstantsCommon.ENTITY_CIF_TYPE_DISPLAY, fomCO.getCifVO().getCIF_TYPE());

		criteria.setEntityTypeInfosMap(hm);
		criteria.setEntityType(ConstantsCommon.ENTITY_CIF_TYPE_LOV);

		if (fomCO.getCifVO().getTYPE() == null)
		{
			criteria.getEntityTypeInfosMap().put(ConstantsCommon.ENTITY_VT_TYPE_DISPLAY, "V");
		}
		else
		{
			criteria.getEntityTypeInfosMap().put(ConstantsCommon.ENTITY_VT_TYPE_DISPLAY, fomCO.getCifVO().getTYPE());
		}
		if (!NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_TYPE()))
		{
			criteria.setCifType(fomCO.getCifVO().getCIF_TYPE());
		}
		if (!NumberUtil.isEmptyDecimal(fomCO.getAddressCommonCO().getCOUNTRY()))
		{
			criteria.setCountryId(fomCO.getAddressCommonCO().getCOUNTRY());
		}
		if (!NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_NO()))
		{
			criteria.setEntityCode(fomCO.getCifVO().getCIF_NO());
		}
		applyDynScreenDisplay(elementsList.toArray(new String[elementsList.size()]), actionType, null == value ? null : value.toString(),
				fomCO.getBuisnessElement(), criteria);
		return fomCO;
	}

	/**
	 * Method to save additionnal props in kyc screen
	 * 
	 * @param fomCOParam
	 * @throws BaseException
	 */

	public void saveAdditionnalKycProps(FomCO fomCOParam, boolean validateOnly) throws BaseException
	{
		try
		{
			FomCO fomCO = fomCOParam;
			BigDecimal compCode = fomCO.getLoginCompCode();
			String updates = fomCO.getAdditionnalKycProps();
			String cifNo = fomCO.getCifVO().getCIF_NO().toPlainString();
			BigDecimal screenId = fomCO.getScreenId();
			String runningRetDate = new SimpleDateFormat("dd/MM/YYYY").format(fomCO.getRunningDate()), foreignCompAnswer = "", fatcaCountry = "",
					fatcaNationality = "", compEin = "", compCountryCode = "", fomNationality = "";
			JSONObject obj;
			HashMap<String, Object> hm;
			CTS_DYN_CIF_KYCVO dynKycVO;
			JSONObject jsonFilter;
			JSONArray jsonModel;
			Object[] modelArr;
			if (updates != null)
			{
				String[] arr = updates.split("&");

				StringBuffer sb = new StringBuffer("{\"root\":[");
				for (int i = 0; i < arr.length; i++)
				{
					if (i == arr.length - 1)
					{
						sb.append("{\"" + arr[i].replace("=", "\":\"") + "\"}" + "]}");
					}
					else
					{
						sb.append("{\"" + arr[i].replace("=", "\":\"") + "\"},");
					}
				}

				jsonFilter = (JSONObject) JSONSerializer.toJSON(sb.toString());
				jsonModel = jsonFilter.getJSONArray("root");
				modelArr = jsonModel.toArray();

				String theKey;
				Field[] fields;
				boolean notFound = true;

				for (int i = 0; i < modelArr.length; i++)
				{
					obj = (JSONObject) modelArr[i];
					hm = (HashMap) JSONObject.toBean(obj, HashMap.class);
					for (Map.Entry<String, Object> e : hm.entrySet())
					{
						theKey = e.getKey();
						if (theKey.contains("fomCO.") || theKey.contains("__checkbox_fomCO."))
						{
							if (theKey.indexOf(".cifKYCVO.") > 0)
							{
								fields = CIF_KYCVO.class.getDeclaredFields();
								for (int j = 0; j < fields.length; j++)
								{
									if (fields[j].getName().equals(theKey.substring(theKey.lastIndexOf(".") + 1, theKey.length())))
									{
										notFound = false;
										break;
									}
								}
							}
							else if (theKey.indexOf(".ctsCifKycDetailsVO.") > 0)
							{
								fields = CTS_CIF_KYC_DETAILSVO.class.getDeclaredFields();
								for (int j = 0; j < fields.length; j++)
								{
									if (fields[j].getName().equals(theKey.substring(theKey.lastIndexOf(".") + 1, theKey.length())))
									{
										notFound = false;
										break;
									}
								}
							}
							else
							{
								fields = FomCO.class.getDeclaredFields();
								for (int j = 0; j < fields.length; j++)
								{
									if (fields[j].getName().equals(theKey.substring(theKey.lastIndexOf(".") + 1, theKey.length()))
											&& !theKey.equals("fomCO.crsSignYN"))
									{
										notFound = false;
										break;
									}
								}
							}
						}
						// insert into dynamic table if field not found
						if (notFound && !KycManagementConstant.KYC_DYN_FLAGS.contains(theKey))
						{
							dynKycVO = new CTS_DYN_CIF_KYCVO();
							dynKycVO.setCOMP_CODE(compCode);
							dynKycVO.setELEMENT_ID(theKey);
							if ("kycUpdateDate".equals(theKey))
							{
								dynKycVO.setELEMENT_VALUE(runningRetDate.toString());
							}
							else if (((String) (e.getValue())).contains("%2F"))
							{
								dynKycVO.setELEMENT_VALUE(((String) e.getValue()).replace("%2F", "/"));
							}
							else
							{
								dynKycVO.setELEMENT_VALUE(StringUtil.isNotEmpty(((String) e.getValue())) ? ((String) e.getValue()).replace("+", " ") : "");
							}

							if (StringUtil.nullToEmpty(dynKycVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.FOREIGN_COMPANY_YN")
									|| StringUtil.nullToEmpty(dynKycVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.TAX_PAYER_ANY_COUNTRY_YNOUNTRY_YN"))
							{
								foreignCompAnswer = dynKycVO.getELEMENT_VALUE();
							}
							if (StringUtil.nullToEmpty(dynKycVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.COMP_COUNTRY_CODE"))
							{
								compCountryCode = dynKycVO.getELEMENT_VALUE();
							}
							if (StringUtil.nullToEmpty(dynKycVO.getELEMENT_ID()).endsWith("fatcaCountry"))
							{
								fatcaCountry = dynKycVO.getELEMENT_VALUE();
							}
							if (StringUtil.nullToEmpty(dynKycVO.getELEMENT_ID()).endsWith("fatcaNationality"))
							{
								fatcaNationality = dynKycVO.getELEMENT_VALUE();
							}
							if (StringUtil.nullToEmpty(dynKycVO.getELEMENT_ID()).endsWith("fomNationality"))
							{
								fomNationality = dynKycVO.getELEMENT_VALUE();
							}
							if (StringUtil.nullToEmpty(dynKycVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.COMP_EIN")
									|| StringUtil.nullToEmpty(dynKycVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.TIN"))
							{
								compEin = dynKycVO.getELEMENT_VALUE();
							}

							dynKycVO.setSCREEN_ID(screenId);
							dynKycVO.setCIF_NO(new BigDecimal(cifNo));
							validateQuestions(dynKycVO);
							if (!validateOnly)
							{
								fillButtonInfoQuery(dynKycVO);

								if (ConstantsCommon.YES.equals(fomCO.getCifControlVO().getALLOW_ONLINE_CHECKING_YN()))
								{
									saveAdditionnalKycProps_NewTrans(dynKycVO);
								}
								else
								{
									genericDAO.delete(dynKycVO);
									genericDAO.insert(dynKycVO);
								}
							}
						}
					}
					notFound = true;
				}
			}
			if ((ConstantsCommon.YES.equals(foreignCompAnswer) && (compCountryCode.equals(fatcaCountry) || fatcaNationality.equals(fomNationality))
					&& (compEin.equals("") || compEin.equals("__-______")))
					|| (ConstantsCommon.NO.equals(foreignCompAnswer) && fatcaNationality.equals(fomNationality)
							&& (compEin.equals("") || compEin.equals("__-______"))))
			{
				throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "TIN_EIN_key" });
			}

		}
		catch (Exception e)
		{
			log.error(e, null);
			throw new BaseException(e);
		}
	}

	private void validateQuestions(CTS_DYN_CIF_KYCVO dynKycVO) throws BaseException
	{
		if (ConstantsCommon.YES.equals(dynKycVO.getELEMENT_VALUE()))
		{
			switch (dynKycVO.getELEMENT_ID())
			{
				case KycManagementConstant.RECEIVE_FOREING_INCOME:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_FOREIGN_INCOME, dynKycVO, "Foreign Income");
					break;
				case KycManagementConstant.FOREIGN_COMPANY:
					// validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_FOREIGN_COUNTRY,dynKycVO);
					break;
				case KycManagementConstant.COMP_OWN_EXCEEDING_PERC:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_COMPANY_DETAILS, dynKycVO, "Company Details");
					break;
				case KycManagementConstant.PARTNER_EXCEEDING_PERC:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_PARTNER_DETAILS, dynKycVO, "Partner Details");
					break;
				case KycManagementConstant.COMP_FOREIGN_ADDRESS:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_FOREIGN_COUNTRY, dynKycVO, "Foreign Country");
					break;
				case KycManagementConstant.SO_FOREIGN_TRANSFER:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_INTER_SO, dynKycVO, "International Standing Order");
					break;
				case KycManagementConstant.ATTORNEY_FOREIGN_ADDRESS:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_FOREIGN_AUTO_SIGNATORIES, dynKycVO, "Foreign Authorized Signatory");
					break;
				case KycManagementConstant.COMP_PHONE_YN:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_PHONE_NUMBERS, dynKycVO, "Phone Numbers");
					break;
				case KycManagementConstant.OTHER_EXIST_BANK_YN:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_ACC_DETAILS, dynKycVO, "Account Details");
					break;
				case KycManagementConstant.OTHER_PASSPORT:
					break;
				case KycManagementConstant.OTHER_ID_NO:
					// TODO
					break;
				case KycManagementConstant.PERMANENT_RESIDENT:
					// TODO
					break;
				case KycManagementConstant.STAYOTHERCOUNTRY:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_PERIOD_OUTSIDE_COUNTRY, dynKycVO, "Number Of Days");
					break;
				case KycManagementConstant.TAX_PAYER_ANY_COUNTRY:
					// TODO
					break;
				case KycManagementConstant.HAVE_OTHER_ID:
					// TODO
					break;
				case KycManagementConstant.OTHER_ADDRESS:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_ADDRESSES, dynKycVO, "Addresses");
					break;
				case KycManagementConstant.HAVE_OTHER_STAND:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_BENEFECIARY, dynKycVO, "Beneficary");
					break;
				case KycManagementConstant.ISSUE_OF_ATTORNEY:
					validateFinancialInfo(KycManagementConstant.FINANCIAL_TYPE_ISSUE_OF_ATTORNY, dynKycVO, "Power Of Attorney");
					break;

				default:
					break;
			}
		}
	}

	private void validateFinancialInfo(String financialType, CTS_DYN_CIF_KYCVO dynamicQuestion, String question) throws BOException, DAOException
	{
		FomSC fomSC = new FomSC();
		fomSC.setCompCode(dynamicQuestion.getCOMP_CODE());
		fomSC.setCifNo(dynamicQuestion.getCIF_NO());
		fomSC.setADD_STRING2(financialType);
		if (kycManagementDAO.retKycFinancialInfoCount(fomSC) == 0)
		{
			throw new BOException(MessageCodes.MISSING_INFO_FOR_QUESTION_PARAM, new String[] { question });
		}
	}

	private void fillButtonInfoQuery(CTS_DYN_CIF_KYCVO dynamicVO)
	{

		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.COMP_COUNTRY_CODE"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_DYN_CIF_KYC#@#ELEMENT_ID~@~scrElemHm.fomCO.cifKYCVO.COMP_COUNTRY_CODE!@!ELEMENT_VALUE");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.OTHER_ID_NO_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~I!@!ID_TYPE");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.RECEIVE_FOREIGN_INCOME_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~F!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.FOREIGN_COMPANY_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_DYN_CIF_KYC#@#ELEMENT_ID~@~scrElemHm.fomCO.cifKYCVO.COMP_COUNTRY_CODE!@!ELEMENT_VALUE");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.COMP_OWN_EXCEEDING_PERC_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~7!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.PARTNER_EXCEEDING_PERC_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~6!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.COMP_FOREIGN_ADDRESS_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~C!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.SO_FOREIGN_TRANSFER_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~8!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.ATTORNEY_FOREIGN_ADDRESS_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~9!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.COMP_PHONE_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~P!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.OTHER_EXIST_BANK_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~O!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.OTHER_PASSPORT_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF#@#'1'~@~1!@!COUNTRY_OF_ISSUANCE1");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("FOMCO.CIFKYCVO.STAYOTHERCOUNTRY_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~N!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.TAX_PAYER_ANY_COUNTRY_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_DYN_CIF_KYC#@#ELEMENT_ID~@~scrElemHm.fomCO.cifKYCVO.TAX_PAYER_COUNTRY_CODE!@!ELEMENT_VALUE");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("fomCO.cifKYCVO.PERMANENT_RESIDENT_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_COUNTRY_INFO#@#'1'~@~1!@!COUNTRY_CODE");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("FOMCO.CIFKYCVO.OTHER_ADDRESS_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~A!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("FOMCO.CIFKYCVO.HAVE_OTHER_STAND_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~B!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("FOMCO.CIFKYCVO.ISSUE_OF_ATTORNEY_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANCIAL_INFO#@#KYC_FINANCIAL_TYPE~@~T!@!KYC_FINANCIAL_COUNTRY");
			return;
		}
		if (StringUtil.nullToEmpty(dynamicVO.getELEMENT_ID()).endsWith("FOMCO.CIFKYCVO.HAVE_OTHER_ID_YN"))
		{
			dynamicVO.setBUTTON_INFO_QUERY("ITR_CIF_KYC_FINANC_INFO_CNTRY#@#'1'~@~1!@!COUNTRY_CODE");
			return;
		}

	}
	@Override
	public KycManagementCO checkCif(KycManagementCO kycManagementCO) throws BaseException
	{
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(kycManagementCO.getLoginCompCode());
		reqFieldSC.setBranchCode(kycManagementCO.getLoginBraCode());
		reqFieldSC.setProgRef(kycManagementCO.getProgRef());
		reqFieldSC.setAppName(kycManagementCO.getAppName());

	
		if (NumberUtil.isEmptyDecimal(kycManagementCO.getAmlKycVO().getCIF_NO()))
		{
			applyDynScreenDisplay(new String[] { "kyc_details_btn" }, ConstantsCommon.ACTION_TYPE_VISIBLE, KycManagementConstant.ZERO,
					kycManagementCO.getScreenParam(), reqFieldSC);
		}
		else
		{
			applyDynScreenDisplay(new String[] { "kyc_details_btn" }, ConstantsCommon.ACTION_TYPE_VISIBLE, KycManagementConstant.ONE,
					kycManagementCO.getScreenParam(), reqFieldSC);
		}

		return kycManagementCO;
	}
	public void saveAdditionnalKycProps_NewTrans(CTS_DYN_CIF_KYCVO dynKycVO) throws BaseException
	{
		genericDAO.delete(dynKycVO);
		genericDAO.insert(dynKycVO);
	}

	/**
	 * this function is a general function used to get the max line no for any popup screen used in screen.
	 */
	public int returnMaxLineNo(FomPopUpSceensSC fomPopUpSceensSC) throws BaseException
	{
		return kycManagementDAO.returnMaxLineNo(fomPopUpSceensSC);
	}

	public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
	{
		this.coreCommonServiceBO = coreCommonServiceBO;
	}

	public void setAddressBO(AddressCommonBO addressBO)
	{
		this.addressBO = addressBO;
	}

}
