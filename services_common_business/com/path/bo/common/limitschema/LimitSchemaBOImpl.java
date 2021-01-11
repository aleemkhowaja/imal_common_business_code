/**
 *
 */
package com.path.bo.common.limitschema;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.signature.SignatureBO;
import com.path.bo.common.signature.SignatureConstant;
import com.path.bo.core.account.AccountsConstant;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.dao.common.limitschema.LimitSchemaDAO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.LIMIT_SCHEMAVO;
import com.path.dbmaps.vo.LIMIT_SCHEMA_TEMPVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.limitschema.LimitSchemaCO;
import com.path.vo.common.limitschema.LimitSchemaSC;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.signature.SignatureSC;
import com.path.vo.core.cif.CifSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 *
 * @author: raees
 *
 * LimitSchemaBOImpl.java used to
 */
public class LimitSchemaBOImpl extends RetailBaseBO implements LimitSchemaBO
{
    private LimitSchemaDAO limitSchemaDAO;
    private SignatureBO signatureBO;
    /**
     * Method to return the limit schema grid data based on the criteria
     * @param limitSchemaSC
     * @ return List<LimitSchemaCO>
     * @throws BaseException
     */
    public List<LimitSchemaCO> returnLimitSchemaList(LimitSchemaSC limitSchemaSC) throws BaseException
    {
	return limitSchemaDAO.returnLimitSchemaList(limitSchemaSC);
    }


    /**
     * Method to return the count of limit schema based on the criteria
     * @param limitSchemaSC
     * @return  int
     * @throws BaseException
     */
    public int returnLimitSchemaListCount(LimitSchemaSC limitSchemaSC) throws BaseException
    {
	return limitSchemaDAO.returnLimitSchemaListCount(limitSchemaSC);
    }

    /**
     * @param limitSchemaDAO the limitSchemaDAO to set
     */
    public void setLimitSchemaDAO(LimitSchemaDAO limitSchemaDAO)
    {
        this.limitSchemaDAO = limitSchemaDAO;
    }

    /**
     * Method to validate the mandatory fields filled the grid to allow add new record
     * @param limitSchemaList
     * @throws BaseException
     */
    public void validateAddNewRow(List<LimitSchemaCO> limitSchemaList) throws BaseException
    {
	int gridSize = limitSchemaList.size();
	LimitSchemaCO limitSchemaCO = limitSchemaList.get(gridSize-1);
	
	if(NumberUtil.isEmptyDecimal(limitSchemaCO.getLimitSchemaVO().getTRX_TYPE()))
	{
	    throw new BOException(MessageCodes.CANNOT_BE_EMPTY, new String[] { "Type_key" });
	}
	
	BigDecimal limitAMT = limitSchemaCO.getLimitSchemaVO().getLIMIT_AMT();
	if("Y".equals(limitSchemaCO.getUnlimited()))
	{
	    limitAMT = BigDecimal.ZERO;
	}
	
	BigDecimal neverEXPIRE = limitSchemaCO.getLimitSchemaVO().getNEVER_EXPIRE();
	if(BigDecimal.ONE.compareTo(neverEXPIRE) == 0)
	{
	    limitSchemaCO.getLimitSchemaVO().setEFFECTIVE_FROM(null);
	    limitSchemaCO.getLimitSchemaVO().setEFFECTIVE_TO(null);
	}
	else
	{
	    Date effectiveFROM = limitSchemaCO.getLimitSchemaVO().getEFFECTIVE_FROM();
	    Date effectiveTO = limitSchemaCO.getLimitSchemaVO().getEFFECTIVE_TO();
	    Calendar calObj = Calendar.getInstance();
	    calObj.set(1900, 01, 01);
	    Date date = calObj.getTime();
	    if((effectiveFROM == null && effectiveTO != null) || (effectiveTO == null && effectiveFROM != null)
		    || (effectiveFROM == null && effectiveTO == null) || (effectiveFROM.before(date))
		    || (effectiveTO.before(date)))
	    {
		throw new BOException(MessageCodes.ENTER_A_VALID_DATE);
	    }

	    if(effectiveFROM.after(effectiveTO))
	    {
		throw new BOException(MessageCodes.TODATE_GREATER_FROMDATE);
	    }
	}

	String group1 = limitSchemaCO.getLimitSchemaVO().getGROUP1();
	if(group1 == null || "".equals(group1) || limitAMT == null)
	{
	    if(group1 == null || "".equals(group1))
	    {
		throw new BOException(MessageCodes.CANNOT_BE_EMPTY, new String[] { "Group1_key" });
	    }
	    else if(limitAMT != null)
	    {
		throw new BOException(MessageCodes.CANNOT_BE_EMPTY, new String[] { "Limit_Amount_key" });
	    }
	}
	else
	{
	    // uf_check_combinations
	    ufCheckCombinations(limitSchemaCO, limitSchemaList);
	}
    }

    /**
     * Method to check the combinations of the group values in the grid
     * if isAllowAllGroupCombination in limitSchemaCO is true then it will check combination for all group
     * else it will check combination for group 1,2,3,4
     * uf_check_combinations
     * @param limitSchemaCO
     * @param limitSchemaList
     * @throws BaseException
     */
    private void ufCheckCombinations(LimitSchemaCO limitSchemaCO, List<LimitSchemaCO> limitSchemaList) throws BaseException
    {
	ArrayList<String> list2;
	ArrayList<String> list1 = new ArrayList<String>();
	list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP1());
        list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP2());
        list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP3());
        list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP4());
        if(limitSchemaCO.isAllowAllGroupCombination()){
            list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP5());
            list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP6());
            list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP7());
            list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP8());
            list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP9());
            list1.add(limitSchemaCO.getLimitSchemaVO().getGROUP10());
        }
        Collections.sort(list1);
	for(LimitSchemaCO alimitSchemaCO :limitSchemaList)
	{
	    if(limitSchemaCO.getLimitSchemaVO().getLINE().compareTo(alimitSchemaCO.getLimitSchemaVO().getLINE())!=0 && NumberUtil.emptyDecimalToZero(limitSchemaCO.getLimitSchemaVO().getTRX_TYPE()).compareTo(NumberUtil.emptyDecimalToZero(alimitSchemaCO.getLimitSchemaVO().getTRX_TYPE()))==0)
	    {
		list2 = new ArrayList<String>();
                list2.add(alimitSchemaCO.getLimitSchemaVO().getGROUP1());
                list2.add(alimitSchemaCO.getLimitSchemaVO().getGROUP2());
                list2.add(alimitSchemaCO.getLimitSchemaVO().getGROUP3());
                list2.add(alimitSchemaCO.getLimitSchemaVO().getGROUP4());
                if(limitSchemaCO.isAllowAllGroupCombination()){
                    list2.add(limitSchemaCO.getLimitSchemaVO().getGROUP5());
                    list2.add(limitSchemaCO.getLimitSchemaVO().getGROUP6());
                    list2.add(limitSchemaCO.getLimitSchemaVO().getGROUP7());
                    list2.add(limitSchemaCO.getLimitSchemaVO().getGROUP8());
                    list2.add(limitSchemaCO.getLimitSchemaVO().getGROUP9());
                    list2.add(limitSchemaCO.getLimitSchemaVO().getGROUP10());
                }

                Collections.sort(list2);

                if(list1.equals(list2))
		{
		    throw new BOException(MessageCodes.ALREADY_EXISTS_AT_LINE, new String[] {alimitSchemaCO.getLimitSchemaVO().getLINE().toString(),limitSchemaCO.getLimitSchemaVO().getLINE().toString()}, false);
		}
	    }
	}

	//TODO finalize
//	if isnull(ls_cur_group2) then ls_cur_group2 = '1'//Joseph Merhej 28/11/2006 changed to accept one group in a schema
//	    if isnull(ls_cur_group3) then ls_cur_group3 = '2'
//	    if isnull(ls_cur_group4) then ls_cur_group4 = '3'
    }


    /**
     * Method to validate the effective from date on change
     * @param limitSchemaCO
     * @throws BaseException
     */
    public void onChangeEffectiveFromDate(LimitSchemaCO limitSchemaCO) throws BaseException
    {
	Date effectiveFROM = limitSchemaCO.getLimitSchemaVO().getEFFECTIVE_FROM();
	checkDateValidity(effectiveFROM);
	Date effectiveTO = limitSchemaCO.getLimitSchemaVO().getEFFECTIVE_TO();
	if(effectiveFROM != null && effectiveTO != null && effectiveFROM.after(effectiveTO))
	{
	    throw new BOException(MessageCodes.TODATE_GREATER_FROMDATE);
	}
    }

    /**
     * Method to validate the effective to date on change
     * @param limitSchemaCO
     * @throws BaseException
     */
    public void onChangeEffectiveToDate(LimitSchemaCO limitSchemaCO) throws BaseException
    {
	Date effectiveTO = limitSchemaCO.getLimitSchemaVO().getEFFECTIVE_TO();
	checkDateValidity(effectiveTO);
	Date effectiveFROM = limitSchemaCO.getLimitSchemaVO().getEFFECTIVE_FROM();
	if(effectiveFROM != null && effectiveTO != null && effectiveTO.before(effectiveFROM))
	{
	    throw new BOException(MessageCodes.INVALID_DATE_RANGE);
	}

    }

    /**
     * Method used to validate the grid data on save
     * @param limitSchemaList
     * @throws BaseException
     */
    private void validateRecords(List<LimitSchemaCO> limitSchemaList) throws BaseException
    {



	for(LimitSchemaCO limitSchemaCO : limitSchemaList)
	{
	    String group1 = limitSchemaCO.getLimitSchemaVO().getGROUP1();
	    if(group1 == null || "".equals(group1))
	    {
		throw new BOException(MessageCodes.CANNOT_BE_EMPTY, new String[] { "Group1_key" });
	    }

	    BigDecimal limitAMT;
	    if( "Y".equals(limitSchemaCO.getUnlimited()))
	    {
		limitAMT = BigDecimal.ZERO;
	    }
	    else
	    {
		limitAMT = NumberUtil.nullToZero(limitSchemaCO.getLimitSchemaVO().getLIMIT_AMT());
		if(limitAMT.intValue() == 0)
		{
		    throw new BOException(MessageCodes.CANNOT_BE_EMPTY, new String[] { "Limit_Amount_key" });
		}
	    }

	    BigDecimal neverEXPIRE = limitSchemaCO.getLimitSchemaVO().getNEVER_EXPIRE();
	    if(neverEXPIRE.compareTo(BigDecimal.ZERO)!=0){
		onChangeEffectiveFromDate(limitSchemaCO);
		onChangeEffectiveToDate(limitSchemaCO);
	    }
	    ufCheckCombinations(limitSchemaCO,limitSchemaList);
	}
    }

    /**
    * Method to save limit schema
    * @param limitSchemaParamSC
    * @param limitSchemaList
    * @throws BaseException
    */
    public LimitSchemaCO saveLimitSchema(LimitSchemaSC limitSchemaSC, List<LimitSchemaCO> limitSchemaList, LimitSchemaCO limitSchemaCO) throws BaseException
    {
	//Hasan EWBI160091 17/06/2016
	limitSchemaSC.setCompCodeCif(NumberUtil.nullEmptyToValue(limitSchemaSC.getCompCodeCif(),limitSchemaSC.getCompCode()));
	
	limitSchemaSC.setNbRec(-1);
	List<LimitSchemaCO> oldListSchemaCO = returnLimitSchemaList(limitSchemaSC);
	List<LIMIT_SCHEMAVO> oldLstVO = new ArrayList<LIMIT_SCHEMAVO>();
	for (LimitSchemaCO limitSchCO : oldListSchemaCO) 
	{
	    oldLstVO.add(limitSchCO.getLimitSchemaVO());
	}
	if(oldListSchemaCO.isEmpty())
	{
	    oldLstVO.add(new LIMIT_SCHEMAVO());
	}

	if("Account".equals(limitSchemaSC.getScreen()) && limitSchemaList.isEmpty()
		&& "1".equals(limitSchemaSC.getEnforceSignLimit()))
	{
	    throw new BOException("Limit Schema must contain at least one record");
	}

	validateRecords(limitSchemaList);
	CIFVO cifVo = new CIFVO();
	if(limitSchemaCO != null)
	{
	    cifVo.setCOMP_CODE(limitSchemaSC.getCompCodeCif());//Hasan EWBI160091 07/06/2016
	    cifVo.setCIF_NO(limitSchemaSC.getCifSubNo());
	    cifVo.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(limitSchemaCO.getRunningDate()));
	    cifVo.setSTATUS(limitSchemaCO.getCifStatus());
	    // Falha IDB190066 - CIF Status Changed to Inactive When Updating
	    // Signature Details
	    cifVo.setMODIFIED_BY(limitSchemaCO.getAuditRefCO().getUserID());
	    cifVo.setDATE_MODIFIED(commonLibBO.addSystemTimeToDate(limitSchemaCO.getRunningDate()));
	    // Falha IDB190066 - CIF Status Changed to Inactive When Updating
	    // Signature Details
		
	    coreCommonServiceBO.updateMainCifData(cifVo, limitSchemaCO.getCif_UpdateDate());
	}
	limitSchemaDAO.deleteLimitSchema(limitSchemaSC);
	List<LIMIT_SCHEMAVO> newLstVO = new ArrayList<LIMIT_SCHEMAVO>();
	for(LimitSchemaCO limitSchCO: limitSchemaList)
	{
	    genericDAO.insert(limitSchCO.getLimitSchemaVO()) ;
	    newLstVO.add(limitSchCO.getLimitSchemaVO());
	}
	
	if(null != limitSchemaCO && "CIF".equals(limitSchemaCO.getAuditFor()))
	{
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS",Locale.ENGLISH);
	    String formattedDateUpdated = df.format(cifVo.getDATE_UPDATED());
	    limitSchemaCO.setLatestDateUpdated(formattedDateUpdated);
	    limitSchemaCO.getCifVo().setSTATUS(cifVo.getSTATUS());
	    
	    limitSchemaCO.setCifVo(cifVo);
	    
	    auditBO.callAudit(cifVo, coreCommonServiceBO.returnCifAbs(cifVo), limitSchemaCO.getAuditRefCO());
	    auditBO.callAudit(oldLstVO, newLstVO, limitSchemaCO.getAuditRefCO());
	    auditBO.insertAudit(limitSchemaCO.getAuditRefCO());
	    
	    //Hasan EWBI160091 03/06/2016
	    if(FomConstant.FOM_SCREEN_NAME.equals(limitSchemaCO.getFromWhere()))
	    {
		CifSC cifSC = new CifSC();
		cifSC.setCompCode(limitSchemaSC.getCompCode());
		cifSC.setCif_no(cifVo.getCIF_NO());
		cifSC.setCifAlertStatus(FomConstant.CIF_ALERT_STATUS_S);
		cifSC.setFlag(null);
		cifSC = coreCommonServiceBO.callCifUpdate(cifSC);
		if(cifSC != null && !NumberUtil.isEmptyDecimal(cifSC.getCompCodeCif()))
		{
		    limitSchemaCO.getCifVo().setCOMP_CODE(cifSC.getCompCodeCif());
		}
	    }
	}
	
	return limitSchemaCO;
    }

    /**
     * Method to check the date validity
     * @param aDate
     * @throws BaseException
     */
    private void checkDateValidity(Date aDate) throws BaseException
    {
	if(aDate != null){
	    Calendar calendar  = Calendar.getInstance();
	    calendar.set(1900, 1, 1);
	    if( aDate.before(calendar.getTime()))
	    {
		throw new BOException(MessageCodes.ENTER_A_VALID_DATE);
	    }
	}
    }

    /**
     * chekc if the limit schema tab is readonly based   PTH_CTRL.SIGN_MODE="1"
     * @param accountsManagementCO
     * @return
     * @throws BaseException
     */
    public boolean checkIfLimitSchemaIsReadonly(String status,String menuCrud,String saveType) throws BaseException
    {
     boolean returnValue=false;
     boolean modeReadOnly=false;
     PTH_CTRLVO pthCtrl = commonLibBO.returnPthCtrl();

     if  (ConstantsCommon.SIGN_MODE_ON.equals(pthCtrl.getSIGN_MODE()))
    {
	modeReadOnly=true;
    }

     if ( AccountsConstant.SAVE_TYPE_NEW.equals(saveType))
     {
    	 returnValue= modeReadOnly;
     }
     else
     if  (modeReadOnly ||tabIsReadonly(status, menuCrud))
     {
    	 returnValue=true;
     }
     return returnValue;

    }

    /**
     * this function set a tab as read only in case
     * 
     * 1-we are not level opening or maintainance LEVEL 2-we are in maintanance
     * level and status not in('A','I','O','T')
     * 
     * @param accountsManagementCO
     * @return
     * @throws BaseException
     */
    private boolean tabIsReadonly(String status, String crud) throws BaseException
    {
	if((!"M".equals(crud) && !"U".equals(crud))
		|| "D".equals(status)
		|| "R".equals(status)
		|| ("U".equals(crud) && (!"A".equals(status) && (!"O".equals(status)) && (!"I".equals(status)) && (!"T".equals(status)))))
	{
	    return true;
	}
	return false;
    }

    public void saveLimitSchemaFromSign(List<LimitSchemaCO> limitSchemaCOList, boolean isAutoApprove, LimitSchemaCO limitSchemaParam)
	    throws BaseException
    {
	for(LimitSchemaCO limitSchemaCO : limitSchemaCOList)
	{
	    LIMIT_SCHEMAVO limitSchemaVO = limitSchemaCO.getLimitSchemaVO();
	    if("1".equals(limitSchemaCO.getDELETED()))
	    {// status equals D
		if("2".equals(limitSchemaCO.getOrigin()))
		{// ls_orgin equals 2
		    LIMIT_SCHEMA_TEMPVO limitSchemaTempVO = copyPropSchemaToTemp(limitSchemaVO);
		    limitSchemaTempVO.setTO_BE_STATUS("D");
		    genericDAO.update(limitSchemaTempVO);

		}
		else
		{// ls_orgin equals 1
		    if(isAutoApprove)
		    {// auto approve true
			limitSchemaVO.setSTATUS("D");
			genericDAO.update(limitSchemaVO);
		    }
		    else
		    {// auto approve false
			LIMIT_SCHEMA_TEMPVO limitSchemaTempVO = copyPropSchemaToTemp(limitSchemaVO);
			// copy properties to temp
			limitSchemaTempVO.setTO_BE_STATUS("D");
			limitSchemaTempVO.setLINE(new BigDecimal(limitSchemaDAO
				.selectMaxOfLimitSchemaTemp(limitSchemaVO) + 1));
			genericDAO.insert(limitSchemaTempVO);
		    }
		}
	    }
	    else
	    {// status not equal D
		if("1".equals(limitSchemaCO.getADDED()))
		{// ls modif equals 2
		    if(isAutoApprove)
		    { // auto approve true
			limitSchemaVO.setSTATUS("P");
			limitSchemaVO.setLINE(new BigDecimal(limitSchemaDAO.selectMaxOfLimitSchema(limitSchemaVO) + 1));
			genericDAO.insert(limitSchemaVO);
		    }
		    else
		    {// auto approve false
			LIMIT_SCHEMA_TEMPVO limitSchemaTempVO = copyPropSchemaToTemp(limitSchemaVO);
			limitSchemaTempVO.setTO_BE_STATUS("A");
			limitSchemaTempVO.setLINE(new BigDecimal(limitSchemaDAO
				.selectMaxOfLimitSchemaTemp(limitSchemaVO) + 1));
			genericDAO.insert(limitSchemaTempVO);

		    }
		}
		else
		{
		    // ls modif equal 1 - update case
		    if("2".equals(limitSchemaCO.getOrigin()))
		    {
			// ls origin equal 2
			LIMIT_SCHEMA_TEMPVO limitSchemaTempVO = copyPropSchemaToTemp(limitSchemaVO);
			genericDAO.update(limitSchemaTempVO);
		    }
		    else
		    {
			// ls origin not equals 2
			if(isAutoApprove)
			{
			    // auto approve true
			    limitSchemaVO.setSTATUS("P");
			    genericDAO.update(limitSchemaVO);
			}
			else
			{
			    // auto approve false
			    LIMIT_SCHEMA_TEMPVO limitSchemaTempVO = copyPropSchemaToTemp(limitSchemaVO);
			    limitSchemaTempVO.setTO_BE_STATUS("A");
			    limitSchemaTempVO.setLINE( BigDecimal.valueOf(limitSchemaDAO.selectMaxOfLimitSchemaTemp(limitSchemaVO) + 1));
			    genericDAO.insert(limitSchemaTempVO);
			}
		    }
		}
	    }
	}
	if(limitSchemaCOList != null && limitSchemaCOList.size() > 0)
	{
	    SignatureCO signatureCO = new SignatureCO();
	    signatureCO.getCifObjectVO().setCOMP_CODE(limitSchemaCOList.get(0).getLimitSchemaVO().getCOMP_CODE());
	    signatureCO.getCifObjectVO().setBRANCH_CODE(limitSchemaCOList.get(0).getLimitSchemaVO().getACC_BR());
	    signatureCO.getCifObjectVO().setACC_CY(limitSchemaCOList.get(0).getLimitSchemaVO().getACC_CY());
	    signatureCO.getCifObjectVO().setACC_GL(limitSchemaCOList.get(0).getLimitSchemaVO().getACC_GL());
	    signatureCO.getCifObjectVO().setACC_CIF(limitSchemaCOList.get(0).getLimitSchemaVO().getACC_CIF());
	    signatureCO.getCifObjectVO().setACC_SL(limitSchemaCOList.get(0).getLimitSchemaVO().getACC_SL());
	    signatureCO.setAuditRefCO(limitSchemaParam.getAuditRefCO());
	    signatureBO.updateSignAudit(signatureCO, null, SignatureConstant.SIGN001L, AuditConstant.UPDATE);
	}
    }

    private LIMIT_SCHEMA_TEMPVO copyPropSchemaToTemp(LIMIT_SCHEMAVO limitSchemaVO){
    	LIMIT_SCHEMA_TEMPVO schemaTemp =  new LIMIT_SCHEMA_TEMPVO();
    	schemaTemp.setACC_BR(limitSchemaVO.getACC_BR());
    	schemaTemp.setACC_CIF(limitSchemaVO.getACC_CIF());
    	schemaTemp.setACC_CY(limitSchemaVO.getACC_CY());
    	schemaTemp.setACC_GL(limitSchemaVO.getACC_GL());
    	schemaTemp.setACC_SL(limitSchemaVO.getACC_SL());
    	schemaTemp.setCOMP_CODE(limitSchemaVO.getCOMP_CODE());
    	schemaTemp.setLINE(limitSchemaVO.getLINE());
    	schemaTemp.setNEVER_EXPIRE(limitSchemaVO.getNEVER_EXPIRE());
    	//schemaTemp.setORIGIN_LINE(limitSchemaVO.geto);
    	schemaTemp.setTO_BE_GROUP1(limitSchemaVO.getGROUP1());
    	schemaTemp.setTO_BE_GROUP2(limitSchemaVO.getGROUP2());
    	schemaTemp.setTO_BE_GROUP3(limitSchemaVO.getGROUP3());
    	schemaTemp.setTO_BE_GROUP4(limitSchemaVO.getGROUP4());
    	schemaTemp.setTO_BE_GROUP5(limitSchemaVO.getGROUP5());
    	schemaTemp.setTO_BE_GROUP6(limitSchemaVO.getGROUP6());
    	schemaTemp.setTO_BE_GROUP7(limitSchemaVO.getGROUP7());
    	schemaTemp.setTO_BE_GROUP8(limitSchemaVO.getGROUP8());
    	schemaTemp.setTO_BE_GROUP9(limitSchemaVO.getGROUP9());
    	schemaTemp.setTO_BE_LIMIT_AMT(limitSchemaVO.getLIMIT_AMT());
    	schemaTemp.setTO_BE_STATUS(limitSchemaVO.getSTATUS());
    	schemaTemp.setTO_BE_TRX_TYPE(limitSchemaVO.getTRX_TYPE());
    	schemaTemp.setTO_EFFECTIVE_FROM(limitSchemaVO.getEFFECTIVE_FROM());
    	schemaTemp.setTO_EFFECTIVE_TO(limitSchemaVO.getEFFECTIVE_TO());
    	return schemaTemp;

    }


    public void approveLimitSchema(List<LimitSchemaCO> limitSchemaCOList) throws BaseException
    {
	for(LimitSchemaCO limitSchemaCO : limitSchemaCOList)
	{
	    LIMIT_SCHEMAVO limitSchemaVO = limitSchemaCO.getLimitSchemaVO();
	    if(limitSchemaCO.getOrigin() == null)
	    {
		// origin is null
		Integer lineNo = limitSchemaDAO.selectMaxOfLimitSchema(limitSchemaVO);
		limitSchemaVO.setLINE(new BigDecimal(lineNo + 1));
		if("A".equals(limitSchemaVO.getSTATUS()))
		{
		    limitSchemaVO.setSTATUS("P");
		}
		else
		{// status is D
		    limitSchemaVO.setSTATUS("D");
		}
		genericDAO.insert(limitSchemaVO);
	    }
	    else
	    {
		// origin !=null
		if("A".equals(limitSchemaVO.getSTATUS()))
		{
		    limitSchemaVO.setSTATUS("P");
		}
		genericDAO.update(limitSchemaVO);
	    }
	    limitSchemaDAO.deleteLimitSchemaTemp(limitSchemaCOList.get(0).getLimitSchemaVO());
	}
    }


    public void rejectLimitSchema(List<LimitSchemaCO> limitSchemaCOList) throws BaseException{
    	for (LimitSchemaCO limitSchemaCO : limitSchemaCOList) {
    		limitSchemaDAO.deleteLimitSchemaTemp(limitSchemaCO.getLimitSchemaVO());
		}

    }


    public int returnLimitSchemaCountForACCOrCIF(SignatureSC signatureSC)throws BaseException{

    	return limitSchemaDAO.returnlimitSchemaCountForACCOrCIF(signatureSC);
    }

    public List<LimitSchemaCO> returnLimitSchemaForACCOrCIF(SignatureSC signatureSC)throws BaseException{
    	return limitSchemaDAO.returnlimitSchemaForACCOrCIF(signatureSC);
    }

    public SignatureBO getSignatureBO()
    {
        return signatureBO;
    }


    public void setSignatureBO(SignatureBO signatureBO)
    {
        this.signatureBO = signatureBO;
    }


    @Override
    public int checkNegativeComp(LimitSchemaSC limitSchemaSC) throws BaseException
    {
	CifSC criteria = new CifSC();
	criteria.setCompCode(limitSchemaSC.getCompCode());
	criteria.setCif_no(limitSchemaSC.getCifSubNo());
	criteria.setSectionKey(limitSchemaSC.getSectionKey());
	criteria.setCurrAppName(limitSchemaSC.getCurrAppName());
	return coreCommonServiceBO.checkNegativeComp(criteria);
    }

    /**
     * Rania 801289 - Copied from Hasan Bug#566067 - BMOUPI170480 20/09/2017
     */
    @Override
    public LimitSchemaCO initialise(LimitSchemaCO limitSchemaCO) throws BaseException
    {
	limitSchemaCO.setAccesByTeller(coreCommonServiceBO.checkAccesTellerModified(limitSchemaCO.getCtsTellerVO(), NCifMaintenanceConstant.CIF_LIMIT_SCHEMA)) ;
	return limitSchemaCO;
    }
}
