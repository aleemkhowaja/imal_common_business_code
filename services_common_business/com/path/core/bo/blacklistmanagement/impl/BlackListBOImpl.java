package com.path.core.bo.blacklistmanagement.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.mosblacklist.MosBlackListBO;
import com.path.core.bo.blacklistmanagement.BlackListBO;
import com.path.core.bo.blacklistmanagement.BlackListConstant;
import com.path.core.dao.blacklistmanagement.BlackListDAO;
import com.path.dao.core.blacklisttype.BlackListTypeDAO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.MOSBLACKLISTVO;
import com.path.dbmaps.vo.MOSBLACKLISTVOKey;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.CheckRequiredCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.audit.TrackPropCO;
import com.path.vo.common.blacklistmanagement.MosBlackListSC;
import com.path.vo.common.smart.SmartSC;
import com.path.vo.core.account.AccountsManagementCO;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.blacklistmanagement.BlackListCO;
import com.path.vo.core.blacklistmanagement.BlackListSC;
import com.path.vo.core.blacklisttype.BlackListTypeSC;
import com.path.vo.core.cif.CifSC;

public class BlackListBOImpl extends RetailBaseBO implements BlackListBO
{
    private BlackListDAO blackListDAO;
    private BlackListTypeDAO blackListTypeDAO;
    private MosBlackListBO mosBlackListBO;
    private CifBO cifBO;
//    private NCifMaintenanceBO nCifMaintenanceBO;
    private AlertsBO alertsBO;
    
    
    
    /*public NCifMaintenanceBO getnCifMaintenanceBO()
    {
        return nCifMaintenanceBO;
    }

    public void setnCifMaintenanceBO(NCifMaintenanceBO nCifMaintenanceBO)
    {
        this.nCifMaintenanceBO = nCifMaintenanceBO;
    }*/

    public MosBlackListBO getMosBlackListBO()
    {
        return mosBlackListBO;
    }

    public void setMosBlackListBO(MosBlackListBO mosBlackListBO)
    {
        this.mosBlackListBO = mosBlackListBO;
    }

    @Override
    public int blackListMgmtCount(BlackListSC criteria) throws BaseException
    {
	return blackListDAO.blackListMgmtCount(criteria);
    }

    @Override
    public List blackListMgmtList(BlackListSC criteria) throws BaseException
    {
	return blackListDAO.blackListMgmtList(criteria);
    }

    @Override
    public BlackListCO getBlackListDetails(BlackListSC criteria) throws BaseException
    {
	return blackListDAO.getBlackListDetails(criteria);
    }

    @Override
    public BlackListCO validateBlackListCode(BlackListCO blackListCO) throws BaseException
    {
	MOSBLACKLISTVO blackListVO = blackListCO.getBlackListVO();

	if(blackListVO != null)
	{
	    NumberUtil.resetEmptyValues(blackListVO);
	  
	    if (blackListVO.getCODE() == null || blackListVO.getCODE().intValue()<=0)
	    {
		throw new BOException(MessageCodes.VALUE_CANNOT_BE_EQUAL_OR_LESS_THAN_ZERO);
	    }
	    //--- add verification for zero and negative values
	
	    MOSBLACKLISTVOKey key = new MOSBLACKLISTVOKey();
	    key.setCOMP_CODE(blackListVO.getCOMP_CODE());
	    key.setCODE(blackListVO.getCODE());
	    MOSBLACKLISTVO mosBlackListVO = (MOSBLACKLISTVO) genericDAO.selectByPK(key);
	    if(mosBlackListVO != null)
	    {
		throw new BOException(MessageCodes.DUPLICATE_VALUE);
	    }
	    
	}
	return blackListCO;
    }

    @Override
    public BlackListCO getBlackListetailsbyDocNo( BlackListCO blackListCO) throws BaseException
    {
	BigDecimal loginCompCode = blackListCO.getLoginCompCode(); 
	String OID_DOCUMENT_NBR = blackListCO.getBlackListVO().getOID_DOCUMENT_NBR();
	
	CifSC cifSC = new CifSC();
	cifSC.setCompCode( loginCompCode);
	cifSC.setId_no(OID_DOCUMENT_NBR);
	ArrayList<BaseException> exception = new ArrayList<BaseException>();
	CIFCO cifCO = new CIFCO();
	int recordCount = returnCifRecordCountbyIdNo(cifSC);
	if(recordCount == 0)
	{
	    cifCO.getCifVO().setID_NO(cifSC.getId_no());
	}
	else
	{
	    List<CIFVO> cifVOList = returnCifNobyIdNo(cifSC);

	    cifSC.setCif_no(cifVOList.get(0).getCIF_NO());
	    cifCO = cifBO.returnCIFDetailsforBlackListt(cifSC);// return the
							       // details
							       // corresponding
							       // to cif no.
	    int blacklistNo = checkCIFisBlacklisted(cifSC);// check cif no. is
							   // black listed
	    if(cifVOList.size() > 1)// if more than one cif
	    {
		// //throw new
		// BOException(MessageCodes.MULTIPLE_CIFS_EXIST_FOR_SAME_ID_NUMBER);
		// exception.add(new
		// BOException(MessageCodes.MULTIPLE_CIFS_EXIST_FOR_SAME_ID_NUMBER));
		if(blacklistNo > 0)// if black listed
		{
		    exception.add(new BOException(MessageCodes.MULTIPLE_CIFS_EXIST_FOR_SAME_ID_NUMBER)); // for
		    // throwing
		    // exception
		}
		else
		{
		    cifCO.setShowDepMsg(true); // for just message display
		}
	    }
	    if(blacklistNo > 0)// if black listed
	    {
		exception.add(new BOException(MessageCodes.ALREADY_BLACKLISTED_WITH_BLACK_NUMBER,
			new String[] { Integer.toString(blacklistNo) }));
	    }
	    if(!exception.isEmpty())
	    {
		throw new BOException(exception);
	    }
	}
	blackListCO.setCifCO( cifCO);
	return blackListCO;
    }

    private Integer returnCifRecordCountbyIdNo(CifSC cifSC) throws BaseException
    {
	return blackListDAO.returnCifRecordCountbyIdNo(cifSC);
    }

    private List returnCifNobyIdNo(CifSC cifSC) throws BaseException
    {
	return blackListDAO.returnCifNobyIdNo(cifSC);
    }

    private Integer checkCIFisBlacklisted(CifSC cifSC) throws BaseException
    {
	return blackListDAO.checkCIFisBlacklisted(cifSC);
    }

    @Override
    public BlackListCO validateAndReturnBirthDate(BlackListCO blackListCO) throws BaseException
    {
	MOSBLACKLISTVO blackListVO = blackListCO.getBlackListVO();

	blackListCO.getBlackListVO().getTYPE();// to do

	if(blackListVO != null)
	{
	    Date birthDate = blackListVO.getDATE_OF_BIRTH();
	    if((birthDate != null
	    
		&&( blackListCO.getRunningDate().compareTo(birthDate) <= 0
			|| "V".equalsIgnoreCase(blackListVO.getTYPE())
			&& DateUtil.parseDate("01/01/1880", "dd/mm/yyyy").compareTo(birthDate) > 0)))
		{
		    throw new BOException(MessageCodes.INVALID_DATE);
		}
	    
	}
	return blackListCO;
    }

    @Override
    public BlackListCO validateAndReturnSourceDate(BlackListCO blackListCO) throws BaseException
    {
	MOSBLACKLISTVO blackListVO = blackListCO.getBlackListVO();

	if(blackListVO != null)
	{
	    Date sourceDate = blackListVO.getSOURCE_DATE();
	    Date runningDate = blackListCO.getRunningDate();
	    checkDateIsValid(sourceDate, runningDate);

	    if(blackListVO.getBLACKLIST_TYPE() != null)
	    {
		MOSBLACKLIST_TYPEVO typeVO = getBlackListTypeData(blackListCO);
		Date revisionDate = null;
		if(typeVO != null)
		{
		    String revisionBasis = typeVO.getREVISION_BASIS();
		    Long revisionPeriod = typeVO.getREVISION_PERIOD().longValue();

		    if(revisionBasis
			    .equalsIgnoreCase(BlackListConstant.BLACK_LIST_TYPE_REVISION_BASIS_SOURCE_DATE_FLAG))// S
		    {
			if(sourceDate == null)
			{
			    revisionDate = null;
			}
			else
			{
			    revisionDate = DateUtil.dateAdd("DD", revisionPeriod, blackListCO.getBlackListVO()
				    .getSOURCE_DATE());
			}
		    }
		    blackListCO.getBlackListVO().setREVISION_DATE(revisionDate);
		}
	    }
	}
	return blackListCO;
    }

    @Override
    public BlackListCO validateAndReturnRevisionDate(BlackListCO blackListCO) throws BaseException
    {
	MOSBLACKLISTVO blackListVO = blackListCO.getBlackListVO();

	if(blackListVO != null)
	{
	    Date issueDate = blackListVO.getOID_DATE_ISSUED();
	    Date revisionDate = blackListVO.getREVISION_DATE();
	    Date sourceDate = blackListVO.getSOURCE_DATE();

	    if(revisionDate != null)
	    {
		if(DateUtil.parseDate("01/01/1900", "dd/mm/yyyy").compareTo(revisionDate) > 0)
		{
		    throw new BOException(MessageCodes.INVALID_DATE);
		}

		else if(issueDate == null)
		{
		    if(sourceDate != null && sourceDate.compareTo(revisionDate) > 0)
		    {
			throw new BOException(MessageCodes.PARAM_IS_GREATER_THAN_PARAM, new String[] {
				"Source_Date_key", "Revision_Date_key" });
		    }
		}
		else if(issueDate.compareTo(revisionDate) > 0)
		{
		    throw new BOException(MessageCodes.PARAM_IS_GREATER_THAN_PARAM, new String[] { "Date_Issued_key",
			    "Revision_Date_key" });
		}
	    }
	}
	return blackListCO;
    }

    @Override
    public BlackListCO validateAndReturnIssueDate(BlackListCO blackListCO) throws BaseException
    {
	MOSBLACKLISTVO blackListVO = blackListCO.getBlackListVO();

	if(blackListVO != null)
	{
	    Date issueDate = blackListVO.getOID_DATE_ISSUED();
	    Date runningDate = blackListCO.getRunningDate();
	    checkDateIsValid(issueDate, runningDate);
	}
	return blackListCO;
    }

    private void checkDateIsValid(Date date, Date runningDate) throws BaseException, BOException
    {
	if(date != null)
	{
	    if(DateUtil.parseDate("01/01/1900", "dd/mm/yyyy").compareTo(date) > 0)
	    {
		throw new BOException(MessageCodes.INVALID_DATE);
	    }
	    else if(date.compareTo(runningDate) > 0)
	    {
		throw new BOException(MessageCodes.ENTERED_DATE_CANNOT_BE_GREATER_THAN_SYSTEM_DATE);
	    }
	}
    }

    @Override
    public List getBlackListIdsList(BlackListSC criteria) throws BaseException
    {
	return blackListDAO.getBlackListIdsList(criteria);
    }

    @Override
    public int getBlackListIdsListCount(BlackListSC criteria) throws BaseException
    {
	return blackListDAO.getBlackListIdsListCount(criteria);
    }

    @Override
    public BlackListCO returnBlackListTypeData(BlackListCO blackListCO) throws BaseException
    {
	Date revisionDate = null;
	MOSBLACKLIST_TYPEVO typeVO = getBlackListTypeData(blackListCO);

	if(typeVO == null)
	{
	    throw new BOException(MessageCodes.VALUE_DOES_NOT_EXIST);
	}
	else
	{
	    String revisionBasis = typeVO.getREVISION_BASIS();
	    Long revisionPeriod = typeVO.getREVISION_PERIOD().longValue();

	    if(revisionBasis.equalsIgnoreCase(BlackListConstant.BLACK_LIST_TYPE_REVISION_BASIS_SOURCE_DATE_FLAG))// S
	    {
		if(blackListCO.getBlackListVO().getSOURCE_DATE() == null)
		{
		    revisionDate = null;
		}
		else
		{
		    revisionDate = DateUtil
		    .dateAdd("DD", revisionPeriod, blackListCO.getBlackListVO().getSOURCE_DATE());
		}
	    }
	    else if(revisionBasis.equalsIgnoreCase(BlackListConstant.BLACK_LIST_TYPE_REVISION_BASIS_CREATE_DATE_FLAG))// C
	    {
		Date createdDate = blackListCO.getBlackListVO().getDATE_CREATED();
		if(createdDate == null)// new date
		{
		    revisionDate = DateUtil.dateAdd("DD", revisionPeriod, blackListCO.getRunningDate());
		}
		else
		{
		    revisionDate = DateUtil.dateAdd("DD", revisionPeriod, createdDate);
		}
	    }
	    else if(revisionBasis.equalsIgnoreCase(BlackListConstant.BLACK_LIST_TYPE_REVISION_BASIS_APPROVE_DATE_FLAG))// P
	    {
		if(blackListCO.getBlackListVO().getDATE_APPROVED() == null)
		{
		    revisionDate = null;
		}
		else
		{
		    revisionDate = DateUtil.dateAdd("DD", revisionPeriod, blackListCO.getBlackListVO()
			    .getDATE_APPROVED());
		}
	    }

	    blackListCO.getBlackListVO().setREVISION_DATE(revisionDate);
	    blackListCO.setTypeDesc(typeVO.getBRIEF_NAME_ENG());
	    blackListCO.getBlackListVO().setBLACKLIST_TYPE(typeVO.getCODE());
	}

	return blackListCO;
    }

    
    private MOSBLACKLIST_TYPEVO getBlackListTypeData(BlackListCO blackListCO) throws DAOException
    {
	BlackListTypeSC criteria = new BlackListTypeSC();
	criteria.setCode(blackListCO.getBlackListVO().getBLACKLIST_TYPE());
	criteria.setCompCode(blackListCO.getBlackListVO().getCOMP_CODE());
	criteria.setPreferredLanguage(blackListCO.getPreferredLanguage());
	return blackListTypeDAO.returnBlackLstTypeforBlackListScreenValidation(criteria);
    }

    
    @Override
    public BlackListCO submitData(BlackListCO blackListCO, String operationType) throws BaseException
    {
	MOSBLACKLISTVO blackListVO = blackListCO.getBlackListVO();

	if(blackListVO != null
	    && blackListVO.getSTATUS() != null)
		{if("DELETE".equalsIgnoreCase(operationType)
			&& BlackListConstant.STATUS_ACTIVE.equalsIgnoreCase(blackListVO.getSTATUS()))
		{
		    throw new BOException(MessageCodes.CANNOT_DELETE);
		}
		else if("APPROVE".equalsIgnoreCase(operationType)
			&& BlackListConstant.STATUS_ACTIVE.equalsIgnoreCase(blackListVO.getSTATUS()))
		{
		    throw new BOException(MessageCodes.CANNOT_APPROVE);
		}
		else if("REVERSE".equalsIgnoreCase(operationType)
			&& BlackListConstant.STATUS_TO_BE_REVERSED.equalsIgnoreCase(blackListVO.getSTATUS()))
		{
		    throw new BOException(MessageCodes.CANNOT_REVERSE);
		}
		}
	return blackListCO;
    }

    public void checkMandatoryFieldsForSave(BlackListCO blackListCO, String operationType) throws BaseException
    {
	ArrayList<BaseException> exception = new ArrayList<BaseException>();
	MOSBLACKLISTVO blackListVO = blackListCO.getBlackListVO();

	BigDecimal blackListCodeNo = NumberUtil.nullToZero(blackListVO.getCODE());

	if(blackListCodeNo.longValue() == 0) // CODE checking
	{
	    exception.add(new BOException(MessageCodes.INVALID_CODE));
	}
	// DOC No checking
	if(!StringUtil.nullToEmpty(blackListVO.getOID_DOCUMENT_NBR().trim()).equals(""))
	{
	    exception.add(new BOException(MessageCodes.MULTIPLE_CIFS_EXIST_FOR_SAME_ID_NUMBER));
	}
	if(!StringUtil.nullToEmpty(blackListVO.getBRIEF_NAME_ENG().trim()).equals(""))
	{
	    exception.add(new BOException(MessageCodes.ENTER_BRIEF_DESC));
	}
	if(!StringUtil.nullToEmpty(blackListVO.getBRIEF_NAME_ARAB().trim()).equals(""))
	{
	    exception.add(new BOException(MessageCodes.ENTER_ARABIC_BRIEF_NAME));
	}
	if(!StringUtil.nullToEmpty(blackListVO.getLONG_NAME_ENG().trim()).equals(""))
	{
	    exception.add(new BOException(MessageCodes.MULTIPLE_CIFS_EXIST_FOR_SAME_ID_NUMBER));
	}
	if(!StringUtil.nullToEmpty(blackListVO.getLONG_NAME_ARAB().trim()).equals(""))
	{
	    exception.add(new BOException(MessageCodes.ENTER_ARABIC_LONG_NAME));
	}

	if(!exception.isEmpty())
	{
	    throw new BOException(exception);
	}
    }

    /**
     * save blackList
     */
    public BlackListCO saveBlackList(BlackListCO blackListCO) throws BaseException
    {
	CheckRequiredCO checkRequiredCO = new CheckRequiredCO();
	/**
	 * Check Required Management ...
	 */
	checkRequiredCO.setCompCode(blackListCO.getLoginCompCode());
	checkRequiredCO.setObj_value(blackListCO);
	checkRequiredCO.setApp(blackListCO.getApp());
	checkRequiredCO.setOpt(blackListCO.getPageRef());
	checkRequiredCO.setLanguage(blackListCO.getLoginPreferrredLanguage());
	commonLibBO.checkRequired(checkRequiredCO);

	

	BlackListSC blackListSC = new BlackListSC();
//	blackListSC.setCif(blackListCO.getBlackListVO().getCIF());
	//#BUG #308648 AGIBI150165 / the black list code should be sent instead of cif [same as PB]
	blackListSC.setCif(blackListCO.getBlackListVO().getCODE());
	blackListSC.setCifFirstNameEng(blackListCO.getBlackListVO().getCIF_FIRST_NAME_ENG());
	blackListSC.setCifSecNameEng(blackListCO.getBlackListVO().getCIF_SEC_NAME_ENG());
	blackListSC.setCifThirdNameEng(blackListCO.getBlackListVO().getCIF_THIRD_NAME_ENG());
	blackListSC.setCifLastNameEng(blackListCO.getBlackListVO().getCIF_LAST_NAME_ENG());
	blackListSC.setLongNameEng(blackListCO.getBlackListVO().getLONG_NAME_ENG());

	blackListSC.setCifFirstNameAr(blackListCO.getBlackListVO().getCIF_FIRST_NAME_AR());
	blackListSC.setCifSecNameAr(blackListCO.getBlackListVO().getCIF_SEC_NAME_AR());
	blackListSC.setCifThirdNameAr(blackListCO.getBlackListVO().getCIF_THIRD_NAME_AR());
	blackListSC.setCifLastNameAr(blackListCO.getBlackListVO().getCIF_LAST_NAME_AR());
	blackListSC.setLongNameAr(blackListCO.getBlackListVO().getLONG_NAME_ARAB());
	blackListSC.setIvCrud("M");
	blackListSC.setCompCode(blackListCO.getLoginCompCode());
	blackListSC.setBranchCode(blackListCO.getLoginBraCode());

	coreCommonProcedureBO.dropHashSoundex();
	coreCommonProcedureBO.createHashSoundex();

	blackListSC = coreCommonProcedureBO.fillCifSoundex(blackListSC);
	
	if(StringUtil.isNotEmpty(blackListSC.getErrorMessage()))
	{
	    throw new BOException(blackListSC.getErrorMessage());
	}
	MOSBLACKLISTVO mosBlackListVO = blackListCO.getBlackListVO();
	coreCommonProcedureBO.dropHashSoundex();
	mosBlackListVO.setCOMP_CODE(blackListCO.getLoginCompCode());
	mosBlackListVO.setBRANCH(blackListCO.getLoginBraCode());
	mosBlackListVO.setSTATUS(BlackListConstant.STATUS_ACTIVE);
	if("saveNew".equals(blackListCO.getActionType()))
	{
	    // insert
	    mosBlackListVO.setCREATED_BY(blackListCO.getUserId());
	    mosBlackListVO.setDATE_CREATED(commonLibBO.addSystemTimeToDate(blackListCO.getRunningDate()));
	   
	    // audit
	    audit(blackListCO, AuditConstant.CREATED);
	    
	   // genericDAO.delete(mosBlackListVO);
	    genericDAO.insert(mosBlackListVO);
	}
	else
	{
	    /*
	     * Update
	     */
	    AlertsSC AlertSC = new AlertsSC();
		AlertSC.setCompCode(blackListCO.getLoginCompCode());
		AlertSC.setBranchCode(blackListCO.getLoginBraCode());
		AlertSC.setAppName(blackListCO.getAppName());
		AlertSC.setTodoAlert("'BR'");
		AlertSC.setTodoParam(blackListCO.getBlackListVO().getCIF().toString());
		AlertSC.setProgRef("BL001P");

		 coreCommonServiceBO.returnSTodoDetByAlert(AlertSC);

	    mosBlackListVO.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(blackListCO.getRunningDate()));
	    mosBlackListVO.setUPDATED_BY(blackListCO.getUserId());
	    if(StringUtil.isNotEmpty(blackListCO.getBlackListVO().getAPPROVED_BY())
			 //   || StringUtil.isNotEmpty(blackListCO.getBlackListVO().getREVERSED_BY())
			    ||(coreCommonServiceBO.returnSTodoDetByAlert(AlertSC) > 0)   )
	    {
		BlackListCO oldBlackListCO = (BlackListCO) blackListCO.getAuditObj();
		TrackPropCO trackPropCO = auditBO.copyAuditProps(blackListCO.getAuditRefCO());
		// coInstanceName IS the instance name of the CO object being
		// tracked
		trackPropCO.setCoInstanceName("blackListCO");
		// VoMainPropRef IS The main VO property name (i.e cifVO, amfVO)
		// to
		// generate the TRX_NBR from. Should be
		// AuditConstant.MAIN_PROP_REF
		// if the CO contains the key values
		trackPropCO.setVoMainPropRef("blackListVO");
		// TrackVoMainPropRef IS a boolean to track the main propRef,
		// this
		// Boolean is true by default and shall be set to false in case
		// the tracking is not on The main VO property (this is useful
		// when
		// saving dialogs without the main form/screen).
		trackPropCO.setTrackVoMainPropRef(true);
		// voPropertiesNames IS the names of the properties (VOs) to be
		// tracked as a comma separated string
		trackPropCO.setVoPropertiesNames("blackListVO");
		auditBO.callTrackChanges(oldBlackListCO, blackListCO, trackPropCO);
	    }
	    genericDAO.update(mosBlackListVO);
	    /*
	     * Record Changed between retrieve and update
	     */
	    audit(blackListCO, AuditConstant.UPDATE);
	}

	// BlackListIds
	BlackListSC criteria = new BlackListSC();
	criteria.setCompCode(blackListCO.getLoginCompCode());
	criteria.setCode(blackListCO.getBlackListVO().getCODE());
	blackListDAO.delete_MosBlacklistIds(criteria);

	if(blackListCO.getBlackListIdsList() != null
	
	    && !blackListCO.getBlackListIdsList().isEmpty())
	    {
		for(int i = 0; i < blackListCO.getBlackListIdsList().size(); i++)
		{
		    blackListCO.getBlackListIdsList().get(i).getBlackListIdVO().setCOMP_CODE(
			    blackListCO.getLoginCompCode());
		    blackListCO.getBlackListIdsList().get(i).getBlackListIdVO().setCODE(
			    blackListCO.getBlackListVO().getCODE());
		    blackListDAO.insert_MosBlacklistIds(blackListCO.getBlackListIdsList().get(i).getBlackListIdVO());
		}
	    }
	 
	return  blackListCO;
    }

    /**
     * delete blackList
     */
    public BlackListCO delete(BlackListCO blackListCO) throws BaseException
    {

	/*
	 * UPDATE STATUS RELATED TO DELETE IN MOSBLACKLIST TABLE.
	 */
	CifSC cifSC = new CifSC();
	
	cifSC.setCompCode(blackListCO.getLoginCompCode());
	cifSC.setCif_no(blackListCO.getBlackListVO().getCIF());
	blackListDAO.updateCifBlackListForDelete(cifSC);

	MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
	
	mosBlackListVO.setUPDATED_BY(blackListCO.getUserId());
	mosBlackListVO.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(blackListCO.getRunningDate()));
	mosBlackListVO.setCOMP_CODE(blackListCO.getLoginCompCode());
	mosBlackListVO.setCODE(blackListCO.getBlackListVO().getCODE());
	mosBlackListVO.setSTATUS("D");
	
	blackListDAO.update(mosBlackListVO);

	/*
	 * audit
	 */
	audit(blackListCO, AuditConstant.DELETE);
	return blackListCO;
    }

    private void audit(BlackListCO blackListCO, String actionType) throws BaseException
    {
	AuditRefCO refCO = blackListCO.getAuditRefCO();
	refCO.setOperationType(actionType);
	refCO.setKeyRef(AuditConstant.BLACK_LIST_KEY_REF);

	if(actionType.equals(AuditConstant.CREATED))
	{
		/**
		 * Smart Management
		 */
		SmartSC smartSC = new SmartSC();
		smartSC.setAppName(refCO.getAppName());
		smartSC.setCompCode(blackListCO.getLoginCompCode());
		smartSC.setBranchCode(blackListCO.getLoginBraCode());
		smartSC.setRunningDate(refCO.getRunningDate());
		smartSC.setUserId(refCO.getUserID());
		smartSC.setProgRef(refCO.getProgRef());
		smartBO.validateAndUpdateSmartDetails(blackListCO.getSmartCOList(), smartSC, refCO, blackListCO.getBlackListVO());
		
	    auditBO.callAudit(null, blackListCO.getBlackListVO(), refCO);
	}
	else
	{
	    BlackListCO oldBlackListCO = (BlackListCO) blackListCO.getAuditObj();
	    auditBO.callAudit(oldBlackListCO.getBlackListVO(), blackListCO.getBlackListVO(), blackListCO
		    .getAuditRefCO());
	    auditBO.insertAudit(blackListCO.getAuditRefCO());
	}
    }

    /**
     * approve blackList
     */
    public BlackListCO approve(BlackListCO blackListCO) throws BaseException
    {
	/*
	 * Approve
	 */
	if(blackListCO.getMessageConfirmed())
	{
	    int errorCode = commonLibBO.validateMakerChecker(blackListCO.getBlackListVO().getCREATED_BY(), blackListCO
		    .getBlackListVO().getUPDATED_BY(), blackListCO.getUserId());
	    /*
	     * VERIFY IF THIS IS NOT USERNAME INSTEAD OF USERID
	     */
	    if(errorCode > 0)
	    {
		throw new BOException(errorCode);
	    }
	    
	    BlackListSC criteria = new BlackListSC();
	    criteria.setCompCode(blackListCO.getLoginCompCode());
	    criteria.setBlackListType(blackListCO.getBlackListVO().getBLACKLIST_TYPE());
	    
	    // set revision date
	    if(!NumberUtil.isEmptyDecimal(blackListCO.getBlackListVO().getBLACKLIST_TYPE()))
	    {
		
		MOSBLACKLIST_TYPEVO blackListtypeVO = blackListDAO.blackListRevisionPeriod(criteria);
		
		if(blackListtypeVO != null)// if("P".equals(BlackListtypeVO.getREVISION_BASIS()))
		{
		    blackListCO.getBlackListVO().setREVISION_DATE(
			    DateUtil.relativeDate(blackListCO.getRunningDate(), blackListtypeVO.getREVISION_PERIOD()
				    .intValue()));
		}
	    }
	    /*
	     * UPDATE STATUS RELATED TO APPROVE IN MOSBLACKLIST TABLE.
	     */
	    CifSC cifSC = new CifSC();
	    cifSC.setCompCode(blackListCO.getLoginCompCode());
	    cifSC.setBlackListCode(blackListCO.getBlackListVO().getCODE());
	    cifSC.setCifCode(blackListCO.getBlackListVO().getCIF());
	    cifSC.setUserId(blackListCO.getLoginUserId());//286482 ABAR130094 Blacklisted CIFs [mfalha]
	    cifBO.updateBlackListedCIF(cifSC);// update BlackList to 1 .
	    
	    criteria.setCif(blackListCO.getBlackListVO().getCIF());
	    criteria.setCode(blackListCO.getBlackListVO().getCODE());
	    criteria.setUserId(blackListCO.getUserId());
	    criteria.setRunningDate(commonLibBO.addSystemTimeToDate(blackListCO.getRunningDate()));
	    criteria.setRevisionDate(blackListCO.getBlackListVO().getREVISION_DATE());
	    criteria.setUserId(blackListCO.getLoginUserId());
	    //Hasan Bug#606401 EWBI170470 10/01/2018
//	    if(!NumberUtil.isEmptyDecimal(cifSC.getCifCode()))
//	    {
		criteria.setTableName("CIF");
		coreCommonProcedureBO.updateFillCifBlacklistMos(criteria);
		criteria.setTableName("CIF_JOINT_DET");
		coreCommonProcedureBO.updateFillCifBlacklistMos(criteria);
		// wf_check_cif_blcklist('CIF_JOINT_DET')
		if(!NumberUtil.isEmptyDecimal(cifSC.getCifCode()))
		{
		    blackListDAO.insert_cifOnCifMosBlackListBasedOnCif(criteria);
		}
		
		if(!"".equals(StringUtil.nullToEmpty(blackListCO.getBlackListVO().getOID_DOCUMENT_NBR())))
		{
		    criteria.setIdNo(blackListCO.getBlackListVO().getOID_DOCUMENT_NBR());
		    blackListDAO.insert_cifOnCifMosBlackListBasedOnDocNo(criteria);
		}
//	    }
	    // was added to cifmapper
	    // if(!NumberUtil.isEmptyDecimal(blackListCO.getBlackListVO().getCIF()))
	    // {
	    // blackListDAO.updateCIF_BlackListed(cifSC); // for the two updates
	    // listed in pb
	    // }
	    
	    // update the Status
	    blackListDAO.updateCifApprovedBlackListStatus(criteria);
	    //335563 ; RET- 50 -Suspending Blacklisted CIF
	    if(!NumberUtil.isEmptyDecimal(blackListCO.getBlackListVO().getCIF()))
	    {
		updateSuspendBlacklist(blackListCO);
	    }
	}
	else
	{
	    throw new BOException(MessageCodes.CONFIRM_APPROVE_PROCESS, ConstantsCommon.CONFIRM_MSG_TYPE);
	}
	/*
	 * audit
	 */
	audit(blackListCO, AuditConstant.UPDATE);
	TrackPropCO trackCO = auditBO.copyAuditProps(blackListCO.getAuditRefCO());
	trackCO.setOperationType(AuditConstant.APPROVE);
	trackCO.setVoMainPropRef("blackListVO");
	// the newCO shall be null when we use this method upon
	// approve/reject.
	auditBO.callTrackChanges(blackListCO.getAuditObj(), null, trackCO);

	/*
	 * Send an acknowledge alert in case of remote approve through openItem
	 * screen. In local approve the acknowledgment will not be sent.
	 */
	 //added by bilal for TP#885556
    if(!BlackListConstant.APP_AML.equals(blackListCO.getAppName()))
    {
		if(blackListCO.getAlertsParamCO() != null && Boolean.valueOf(blackListCO.getIsFromAlert()))
		{
		    alertsBO.updateTodoAndSendAck(blackListCO.getAlertsParamCO());
		}
    }
	return blackListCO;
    }

    
    /**
     * PROC14.1 - EOD
     * 335563 ; RET- 50 -Suspending Blacklisted CIF
     * @author EliasAoun; 12/04/2017 
     * Updating Inactive & Active CIFs &
     *         active/approve facilities when approving a record at the level of
     *         blacklist management screen & reverting old statuses in case
     *         blacklist management record was reversed
     */
    private void updateSuspendBlacklist(BlackListCO blackListCOParam)  throws BaseException
    {
	BlackListCO blackListCO = new BlackListCO();
	PathPropertyUtil.copyProperties(blackListCOParam, blackListCO, "loginCompCode", "loginBraCode",
		"blackListVO.STATUS", "blackListVO.CIF", "runningDate","crud");
	
	blackListCO.setLoginUserId( BlackListConstant.SUSPEND_USER_FROM_EOD);
	blackListCO.setRunningDate(commonLibBO.addSystemTimeToDate(blackListCO.getRunningDate()));
	if(BlackListConstant.CRUD_APPROVE.equals(blackListCOParam.getCrud()))
	{
	    blackListCO.getBlackListVO().setSTATUS(FomConstant.STATUS_SUSPENDED);
	}
	blackListDAO.updateSuspendBlacklistFMS(blackListCO);
	blackListDAO.updateSuspendBlacklistCIF(blackListCO);
	
	// this function set the account status to "suspned"
//	FomCO fomCO = new FomCO();
//	fomCO.getCifVO().setCOMP_CODE(blackListCOParam.getLoginCompCode());
//	fomCO.getCifVO().setCIF_NO(blackListCOParam.getBlackListVO().getCIF());
//	fomCO.setLoginUserId(blackListCO.getLoginUserId());
//	fomCO.setRunningDateWithTime(blackListCOParam.getRunningDate());
//	nCifMaintenanceBO.updateAccountStatus(fomCO, "SUSPENDED");
    }
    

    /**
     * toBeReversed blackList
     */
    public BlackListCO toBeReversed(BlackListCO blackListCO) throws BaseException
    {
	MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
	mosBlackListVO.setCODE(blackListCO.getBlackListVO().getCODE());

	mosBlackListVO.setTO_BE_REVERSED_DATE(commonLibBO.addSystemTimeToDate(blackListCO.getBlackListVO()
		.getTO_BE_REVERSED_DATE()));
	mosBlackListVO.setTO_BE_REVERSED_BY(blackListCO.getLoginUserId());
	mosBlackListVO.setSTATUS(BlackListConstant.STATUS_TO_BE_REVERSED);
	blackListDAO.updateToBeReversed(mosBlackListVO);
	audit(blackListCO, AuditConstant.UPDATE);
	return blackListCO;
    }

    /**
     * reverse blackList
     */
    public BlackListCO reverse(BlackListCO blackListCO) throws BaseException
    {
	if(!blackListCO.getMessageConfirmed())
	{
	    throw new BOException(MessageCodes.CONFIRM_REVERSE_PROCESS, ConstantsCommon.CONFIRM_MSG_TYPE);
	}

	BigDecimal cif = blackListCO.getBlackListVO().getCIF();
	BigDecimal code = blackListCO.getBlackListVO().getCODE();

	MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
	mosBlackListVO.setCOMP_CODE(blackListCO.getBlackListVO().getCOMP_CODE());
	mosBlackListVO.setCIF(cif);
	mosBlackListVO.setCODE(code);

	mosBlackListVO.setSTATUS(BlackListConstant.STATUS_REVERSED);
	mosBlackListVO.setREVERSED_BY(blackListCO.getLoginUserId());
	mosBlackListVO.setDATE_REVERSED(commonLibBO
		.addSystemTimeToDate(blackListCO.getBlackListVO().getDATE_REVERSED()));
	deleteCifMosBlackList(mosBlackListVO);
	blackListDAO.reverse(mosBlackListVO);
	audit(blackListCO, AuditConstant.UPDATE);
	/*
	 * Send an acknowledge alert in case of remote approve through openItem
	 * screen. In local approve the acknowledgment will not be sent.
	 */
	 //added by bilal for TP#885556
    if(!BlackListConstant.APP_AML.equals(blackListCO.getAppName()))
    {
		if(blackListCO.getAlertsParamCO() != null && Boolean.valueOf(blackListCO.getIsFromAlert()))
		{
		    alertsBO.updateTodoAndSendAck(blackListCO.getAlertsParamCO());
		}
    }


	//335563 ; RET- 50 -Suspending Blacklisted CIF
	if(!NumberUtil.isEmptyDecimal(blackListCO.getBlackListVO().getCIF()))
	{
	    updateSuspendBlacklist(blackListCO);
	}
	return blackListCO;
    }
    
    private void deleteCifMosBlackList(MOSBLACKLISTVO mosBlackListVO) throws BaseException
    {
	blackListDAO.deleteCifMosBlackList(mosBlackListVO);	
    }

    /**
     * REJECT BLACK LIST FROM ALERT
     * @param blackListCO
     * @author TonyNouh
     */
    public BlackListCO rejectBlackList(BlackListCO blackListCO) throws BaseException
    {
	BigDecimal cif = blackListCO.getBlackListVO().getCIF();
	BigDecimal code = blackListCO.getBlackListVO().getCODE();

	MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
	mosBlackListVO.setCOMP_CODE(blackListCO.getBlackListVO().getCOMP_CODE());
	mosBlackListVO.setCIF(cif);
	mosBlackListVO.setCODE(code);
	mosBlackListVO.setDATE_UPDATED(blackListCO.getBlackListVO().getDATE_UPDATED());

	if(BlackListConstant.STATUS_ACTIVE.equals(blackListCO.getBlackListVO().getSTATUS()))
	{
	    mosBlackListVO.setREVERSED_BY(blackListCO.getAlertsParamCO().getUserId());
	    mosBlackListVO.setDATE_REVERSED(commonLibBO.addSystemTimeToDate(blackListCO.getRunningDate()));
	}
	else
	{
	    mosBlackListVO.setSTATUS(BlackListConstant.STATUS_REJECTED);
	}
	genericDAO.update(mosBlackListVO);
	audit(blackListCO, AuditConstant.UPDATE);
	/*
	 * Send an acknowledge alert in case of remote approve through openItem
	 * screen. In local approve the acknowledgment will not be sent.
	 */
	 //added by bilal for TP#885556
    if(!BlackListConstant.APP_AML.equals(blackListCO.getAppName()))
    {
		if(blackListCO.getAlertsParamCO() != null && Boolean.valueOf(blackListCO.getIsFromAlert()))
		{
		    alertsBO.updateTodoAndSendAck(blackListCO.getAlertsParamCO());
		}
    }
	return blackListCO;
    }
    
    public CTSTELLERVO returnCtsTellerDetails(CTSTELLERVO ctsTellerVO) throws BaseException
    {
	return (CTSTELLERVO)genericDAO.selectByPK(ctsTellerVO);
    }

    public AlertsBO getAlertsBO()
    {
	return alertsBO;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
	this.alertsBO = alertsBO;
    }

    public BlackListTypeDAO getBlackListTypeDAO()
    {
	return blackListTypeDAO;
    }

    public void setBlackListTypeDAO(BlackListTypeDAO blackListTypeDAO)
    {
	this.blackListTypeDAO = blackListTypeDAO;
    }

    public BlackListDAO getBlackListDAO()
    {
	return blackListDAO;
    }

    public void setBlackListDAO(BlackListDAO blackListDAO)
    {
	this.blackListDAO = blackListDAO;
    }

    public CifBO getCifBO()
    {
	return cifBO;
    }

    public void setCifBO(CifBO cifBO)
    {
	this.cifBO = cifBO;
    }

    
    public BlackListCO dependencyByCIFNo(BlackListCO blackListCO) throws BaseException
    {
    	if(NumberUtil.isEmptyDecimal(blackListCO.getBlackListVO().getCODE()))
    	{
    	    throw new BOException(MessageCodes.PLEASE_DEFINE_THE_BLACKLIST_CODE);
    	}
    	else
    	{
    	    // if cif no is empty, we disable some fields
    	    if(NumberUtil.isEmptyDecimal(blackListCO.getCifCO().getCifVO().getCIF_NO()))
    	    {
    		applyDynScreenDisplay("lookuptxt_blackListVO_LEGAL_STATUS", "blackListCO.blackListVO.LEGAL_STATUS",
    			ConstantsCommon.ACTION_TYPE_READONLY, "0", blackListCO.getHm(), null);
    		blackListCO.getCifCO().getCifVO().setCIF_NO(null);
    	    }
    	    else
    	    {

    		BigDecimal loginCompCode = blackListCO.getLoginCompCode();
    		BigDecimal cifNo = blackListCO.getCifCO().getCifVO().getCIF_NO();

    		CifSC cifSC = new CifSC();
    		cifSC.setCompCode(loginCompCode);
    		cifSC.setCif_no(cifNo);
    		CIFCO cifCO = cifBO.returnCIFDetailsforBlackListt(cifSC);
    		if(cifCO == null)
    		{
    		    throw new BOException(MessageCodes.INVALID_MISSING_CIFCODE);
    		}

    		MosBlackListSC mosBlackListSC = new MosBlackListSC();
    		mosBlackListSC.setCompCode(loginCompCode);
    		mosBlackListSC.setCifNO(cifNo);
    		mosBlackListSC.setStatus("notEmpty");
    		BigDecimal maxBlackListCode = mosBlackListBO.returnBlackListByCIFNO(mosBlackListSC);
    		if(BigDecimal.ZERO.compareTo(NumberUtil.nullToZero(maxBlackListCode)) < 0)
    		{
    		    throw new BOException(MessageCodes.ALREADY_BLACKLISTED_WITH_BLACK_NUMBER,
    			    new String[] { maxBlackListCode.toString() });
    		}

    		applyDynScreenDisplay( new String[]{"lookuptxt_blackListVO_LEGAL_STATUS"},
    			ConstantsCommon.ACTION_TYPE_READONLY, "1", blackListCO.getHm(), null);
    		blackListCO.setCifCO(cifCO);
    	    }

    	}
    	return blackListCO;
        }

    @Override
    public AlertsParamCO returnAlertsParamCO(BlackListCO blackListCO) throws BaseException
    {
	if("1".equals(blackListCO.getUserIsBranchManager()))
	{
	    return null;
	}

	String pageRef = blackListCO.getPageRef();
	String status = blackListCO.getBlackListVO().getSTATUS();
	if(status == null || "".equals(status))
	{
	    status = BlackListConstant.STATUS_ACTIVE;
	}

	//#206033 In case of SAVE AS opt, we should use the original pageRef, to continue the flow. at the end we will change the next progRef base on series SAVE AS
	AlertsParamCO saveAsCO = alertsBO.returnSaveAsOptDetails(blackListCO.getAppName(), pageRef);
	if(saveAsCO != null && saveAsCO.isFromSaveAs())
	{
	    pageRef = saveAsCO.getOriginalProgRef();
	}
	
	
	AlertsParamCO alertsParamCO = new AlertsParamCO();
	
	
	/*
	 * Set the next progRef and todo alert
	 */
	String reference = pageRef.substring(0, 5);
	CommonLibSC sc = new CommonLibSC();
	sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
	sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
	sc.setLanguage(blackListCO.getLanguage());
	
	if(BlackListConstant.STATUS_TO_BE_REVERSED.equals(status) || BlackListConstant.CRUD_TE_BE_REVERSED.equals(blackListCO.getCrud()))
	{
	    alertsParamCO.setTodoAlert(AlertsConstants.BLACK_LIST_TODO_ALERT_REVERSE);

	    sc.setKeyLabelCode(alertsParamCO.getTodoAlert() + AlertsConstants.BLACK_LIST_ALERT_TODO_EXCEP);
	    alertsParamCO.setTodoExcepEnglish(commonLibBO.returnKeyLabelTrans(sc));
	    alertsParamCO.setTodoExcepArabic("");
	    alertsParamCO.setProgRef(reference + AlertsConstants.BLACK_LIST_PROG_REF_REVERSE);
	}
	else
	{
	    alertsParamCO.setTodoAlert(AlertsConstants.BLACK_LIST_TODO_ALERT_APPROVE);
//	    alertsParamCO.setTodoExcepEnglish(getText(alertsParamCO.getTodoAlert() + AlertsConstants.BLACK_LIST_ALERT_TODO_EXCEP));
	    alertsParamCO.setTodoExcepArabic("");
//	    if(BlackListConstant.UPDATE_AFTER_APPROVE_PROG_REF.equals(get_pageRef()))
//		alertsParamCO.setProgRef(reference + AlertsConstants.BLACK_LIST_PROG_REF_UPDATE_AFTER_APPROVE);
//	    else
		alertsParamCO.setProgRef(reference + AlertsConstants.BLACK_LIST_PROG_REF_APPROVE);
	}
	String code = blackListCO.getBlackListVO().getCODE().toString();
	String briefName = ConstantsCommon.PREFERED_LANG_ARABIC.equals(blackListCO.getLoginPreferrredLanguage()) ? blackListCO.getBlackListVO().getBRIEF_NAME_ARAB() : blackListCO.getBlackListVO().getBRIEF_NAME_ENG();
	String longName = ConstantsCommon.PREFERED_LANG_ARABIC.equals(blackListCO.getLoginPreferrredLanguage()) ? blackListCO.getBlackListVO().getLONG_NAME_ARAB() : blackListCO.getBlackListVO().getLONG_NAME_ENG();
	String registerNo = NumberUtil.emptyDecimalToZero(blackListCO.getBlackListVO().getCIF_REGISTER_NO()).toString();
	String cifType = NumberUtil.emptyDecimalToZero(blackListCO.getBlackListVO().getCIF_TYPE()).toString();
	String alertDescriptionPattern = AlertsConstants.BLACK_LIST_TELLER_ALERT_DESCRIPTION_PATTERN;
	String alertDescription = MessageFormat.format(alertDescriptionPattern, code, briefName, longName, registerNo, cifType);
	alertsParamCO.setAlertDescription(alertDescription);
	alertsParamCO.setAlertType(AlertsConstants.BLACK_LIST_ALERT_TYPE);
	alertsParamCO.setReasonCode(AlertsConstants.ACTION_TYPE_X);
	alertsParamCO.setCompCode(blackListCO.getBlackListVO().getCOMP_CODE());
	alertsParamCO.setBranchCode(blackListCO.getLoginBraCode());
	alertsParamCO.setStatus(blackListCO.getStatusDesc());
	alertsParamCO.setAmount(BigDecimal.ZERO);
//	alertsParamCO.setAlertLabelKey(getText(alertsParamCO.getTodoAlert() + AlertsConstants.ALERT_SEND_TITLE_SUFFIX));
	alertsParamCO.setTodoParam(blackListCO.getBlackListVO().getCODE().toString());
	alertsParamCO.setActionType(AlertsConstants.ACTION_TYPE_X);
	alertsParamCO.setDistributionType(AlertsConstants.DISTRIBUTION_TYPE_B);
	alertsParamCO.setDistributionTo(AlertsConstants.DISTRIBUTION_TO_U);

	sc.setKeyLabelCode(alertsParamCO.getTodoAlert() + AlertsConstants.ALERT_SEND_TITLE_SUFFIX);
	alertsParamCO.setBriefNameEnglish(commonLibBO.returnKeyLabelTrans(sc));
	alertsParamCO.setTodoType(AlertsConstants.TODO_TYPE_P);
	alertsParamCO.setTodoPriority(AlertsConstants.TODO_PRIORITY_A);
	alertsParamCO.setTodoChecked(AlertsConstants.TODO_CHECKED_U);
	alertsParamCO.setTodoExecution(AlertsConstants.TODO_EXECUTION_N);
	alertsParamCO.setAllowToSend(BigDecimal.ONE);
	alertsParamCO.setTodoTellerBranch(BigDecimal.ZERO);
	alertsParamCO.setTodoFrBranch(BigDecimal.ZERO);
	alertsParamCO.setTodoTellerId(blackListCO.getCtsTellerVO().getCODE());
	alertsParamCO.setCIF_NO(blackListCO.getBlackListVO().getCODE());
	
	//#206033 In case of SAVE AS opt from series, we should replace the original next progRef by the SAVE AS next progRef
	//In case of SAVE AS opt without series, we should keep the original next progRef
	if(StringUtil.isNotEmpty(alertsParamCO.getProgRef()) && saveAsCO != null && saveAsCO.isFromSeriesSaveAs())
	{
	    CommonLibSC commonLibSc  = new CommonLibSC();
	    commonLibSc.setAppName(blackListCO.getAppName());
	    commonLibSc.setOptReference(alertsParamCO.getProgRef());
	    commonLibSc.setProgRef(saveAsCO.getSeriesProgRef());
	    alertsParamCO.setProgRef(commonLibBO.returnSeriesOptByRef(commonLibSc));
	}

	NumberUtil.resetEmptyValues(alertsParamCO);
	return alertsParamCO;
    }
    
    /**
     *  Hasan BMO160011 26/01/2016 This method check if there is a restriction to create card for a certain cif
     * @param chequeBookCO
     * @throws BaseException
     */
    @Override
    public BlackListCO checkBlackListRestriction(BlackListSC blackListSC) throws BaseException
    {
	BlackListCO blackListCO = new BlackListCO();
	if("save".equals(blackListSC.getMethodName()) 
		|| "approve".equals(blackListSC.getMethodName())
		|| ("dependency".equals(blackListSC.getMethodName()) 
			&& !MessageCodes.COMMON_WARNING.equals(blackListSC.getMsgCode())
			&& BigDecimal.ZERO.equals(NumberUtil.nullToZero(blackListSC.getReasonCode())))
		|| "1".equals(blackListSC.getAutoCreation()))
	{ 
	    BigDecimal reasonCode = blackListSC.getReasonCode();
	    coreCommonProcedureBO.checkBlackListRestriction(blackListSC);

	    if(NumberUtil.nullToZero(blackListSC.getErrorCode()).compareTo(BigDecimal.ZERO) < 0)
	    {
		throw new BOException(blackListSC.getErrorMessage());
	    }
	    
	    blackListCO.setReturnedValue(blackListSC.getReturnedValue());
	    if(!BigDecimal.ZERO.equals(blackListSC.getReturnedValue()))
	    {
		if(BigDecimal.ONE.equals(blackListSC.getReturnedValue()))
		{		    
		    throw new BOException(blackListSC.getErrorMessage());
		}
		else
		{
		    if(("save".equals(blackListSC.getMethodName()) 
				&& BigDecimal.ZERO.equals(NumberUtil.nullToZero(reasonCode)))
				|| "dependency".equals(blackListSC.getMethodName())
				|| ("approve".equals(blackListSC.getMethodName()))
					&& !MessageCodes.COMMON_WARNING.equals(blackListSC.getMsgCode()))
		    {
			if(!"1".equals(blackListSC.getAutoCreation()))
			{
			    throw new BOException(MessageCodes.COMMON_WARNING,
				    new String[] { blackListSC.getErrorMessage() }, ConstantsCommon.CONFIRM_MSG_TYPE,
				    ConstantsCommon.BLACKLISTED_OVERRIDE_RESTRICT_CONFIRMATION);
			}
			else
			{
			    blackListCO.setReasonCode(blackListSC.getReasonCode());
			}
		    }
		    
		    //Hasan Bug#498111 04/04/2017
//		    if("save".equals(blackListSC.getMethodName())
//			    && NumberUtil.nullToZero(reasonCode).compareTo(BigDecimal.ZERO) > 0)
//		    {
//			blackListCO.setWarningMsg(blackListSC.getErrorMessage2());
//		    }
		}
	    }
	}
	return blackListCO;
    }
    
    @Override
    public void updateBlackListReason(BlackListSC blackListSC) throws BaseException
    {
	if(!NumberUtil.isEmptyDecimal(blackListSC.getReasonCode()))
	{
	    if(!"ACCOUNT".equals(blackListSC.getParentRef()))
	    {
		blackListSC.setEntity(String.valueOf(blackListSC.getEntityCode()));
	    }
	    
	    BigDecimal lineNo = selectBlackListReasonLineNo(blackListSC);

	    if(!NumberUtil.isEmptyDecimal(lineNo) && lineNo.compareTo(BigDecimal.ZERO) > 0)
	    {
		blackListSC.setLineNo(lineNo);
		blackListDAO.updateBlackListReason(blackListSC);
	    }
	    else
	    {
		blackListSC.setLineNo(BigDecimal.ONE);
		blackListDAO.insertBlackListReason(blackListSC);
	    }
	}
	
    }

    @Override
    public BigDecimal selectBlackListReasonLineNo(BlackListSC blackListSC) throws BaseException
    {
	return blackListDAO.selectBlackListReasonLineNo(blackListSC);
    }

    
}
