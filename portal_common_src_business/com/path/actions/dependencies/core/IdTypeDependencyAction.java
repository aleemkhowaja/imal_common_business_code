package com.path.actions.dependencies.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.idtype.IdTypeBO;
import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.vo.common.SessionCO;
import com.path.vo.core.blacklistmanagement.BlackListIdsCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.idtype.IdTypeSC;

public class IdTypeDependencyAction extends RetailBaseAction
{
    private IdTypeBO idTypeBO;
    private ID_TYPESVO idTypeVO;
    private IdTypeSC idTypeSC = new IdTypeSC();
    private BigDecimal idTypeCode;
    
    //fboukarroum 82940 - AMANA110094 - Alpha - Numeric characters in FOM - MORE CONTACT - ID field
    private String idNoCode;
    private BigDecimal cifCode;
    private String blackListIdsStr;
    
    private FomCO fomCO = new FomCO();

    public String dependencyByIdTypeCode()
    {
	try
	{

	    if(BigDecimal.ZERO.compareTo(idTypeCode) == 0)
	    {
		idTypeVO = new ID_TYPESVO();
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Id_Type_key" });
	    }
//	    if(NumberUtil.isEmptyDecimal(idTypeCode))
//	    {
//		idTypeVO = new ID_TYPESVO();
//	    }
//	    else
//	    {
		SessionCO sessionCO = returnSessionObject();
		idTypeSC.setCompCode(sessionCO.getCompanyCode());
		idTypeSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
		idTypeSC.setIdTypeCode(idTypeCode);
		if(StringUtil.isNotEmpty(blackListIdsStr))
		{
		    GridUpdates gridData = getGridUpdates(blackListIdsStr, BlackListIdsCO.class, true);
		    idTypeSC.setIdTypeCOList(gridData.getLstAllRec());
		}
		fomCO = idTypeBO.returnIdTypeById(idTypeSC);
		idTypeVO = fomCO.getIdTypesVO();
		setAdditionalScreenParams(fomCO.getBuisnessElement());
//	    }
	}
	catch(Exception e)
	{
	    //log.error(e, "Error in dependencyByIdTypeCode method of IdTypeDependencyAction");
	    if(idTypeVO != null)
	    {
		idTypeVO.setCODE(null);
	    }
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String dependencyByIdNo(){
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    idTypeSC.setCompCode(sessionCO.getCompanyCode());
	    idTypeSC.setPreferredLanguage(sessionCO.getPreferredLanguage());

	    if(StringUtil.isNotEmpty(blackListIdsStr))
	    {
		GridUpdates gridData = getGridUpdates(blackListIdsStr, BlackListIdsCO.class, true);
		List blackListIdsStrList = gridData.getLstAllRec();
		idTypeSC.setIdTypeCOList(blackListIdsStrList);
	    }
	    idTypeVO = idTypeBO.dependencyByIdNo( idTypeSC);
	}
	catch(Exception e)
	{
	    idTypeSC = null;
	    log.error(e, "Error in dependencyByIdNo method of IdTypeDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /*
     * fboukarroum 82940 - AMANA110094 - Alpha - Numeric characters in FOM - MORE CONTACT - ID field
     * 
     * This method to check the Id number of a Id types triggered on the change in this field 
     * it invokes an error message if there is mismatch between the id_no and id_type format	
     */
    public String validateIdsIdNo()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    idTypeSC.setCompCode(sessionCO.getCompanyCode());
	    idTypeSC.setBranchCode(sessionCO.getBranchCode());
	    idTypeSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    if(!NumberUtil.isEmptyDecimal(idTypeCode))
	    {
		idTypeSC.setIdTypeCode(idTypeCode);
//		if(!NumberUtil.isEmptyDecimal(idNoCode))
//		{
		    idTypeSC.setIdNoCode(idNoCode);
		    idTypeBO.validateIdsIdNo(idTypeSC);

		    NumberUtil.resetEmptyValues(fomCO);
		    fomCO.getCifVO().setCOMP_CODE(sessionCO.getCompanyCode());
		    fomCO.getCifVO().setBRANCH_CODE(sessionCO.getBranchCode());
		    fomCO.getCifVO().setCIF_NO(NumberUtil.nullToZero(cifCode));
		    //Hasan Bug#666032 DASI180213 02/05/2018
		    fomCO.getCifVO().setID_TYPE(idTypeSC.getIdTypeCode2());
		    fomCO.setLoginCompCode(sessionCO.getCompanyCode());
		    fomCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    fomCO.setRunningDate(sessionCO.getRunningDateRET());

		    // set the ID_NO and ID_TYPE to maintain the usage of
		    // validateIdNo
		    fomCO.setCivilCodeValue(idNoCode.toString());
		    fomCO.setCivilCodeField("ID_TYPE");
		    fomCO.setIdTypeValue(idTypeCode);

		    fillSessionData();
		    fomCO= idTypeBO.checkDuplicateIdNo(fomCO);
		    if(fomCO.getWarningListCode().size() > 0)
		    {
		    	
		  //  String[] msg= new String[] { " ",fomCO.getCifVO().getID_NO(), "ALREADY_USED_WITH_CIF", " ", "500"};
			String[] msgList = fomCO.getCtsMsgParam().get(fomCO.getWarningListCode().get(0));
			StringBuffer messages = new StringBuffer();
			for(String msg : msgList)
			{
			    messages.append(getText(msg));

			}
		    	
			StringBuffer errMsg = new StringBuffer(returnCommonLibBO().returnTranslErrorMessage(fomCO.getWarningListCode().get(0),
				returnSessionObject().getLanguage()));
			errMsg.append(" " + messages.toString());

			set_warning(errMsg.toString());
			
		    }
//		}
//		else //Bug # 407484 -- [John Massaad] (-9999 when deleting ID_NO) 
//		{
//		  setIdNoCode(null);
//	        }
	    }
	}
	catch(Exception e)
	{
	    setIdTypeCode(null);
	    setIdNoCode(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public void fillSessionData() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	fomCO.setLoginCompCode(sessionCO.getCompanyCode());
	fomCO.setLoginBraCode(sessionCO.getBranchCode());
	fomCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	fomCO.setOriginBraCode(sessionCO.getBranchCode());
	fomCO.setRunningDate(sessionCO.getRunningDateRET());
	fomCO.setAppName(sessionCO.getCurrentAppName());
	fomCO.setLanguage(sessionCO.getLanguage());
	fomCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
	fomCO.setLoginTellerCode(sessionCO.getCtsTellerVO().getCODE());
	fomCO.setUserIsBranchManager(sessionCO.getCtsTellerVO().getUSER_IS_BRANCH_MANAGER());
	fomCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
	fomCO.setCrud(getIv_crud());
	fomCO.setOpt(get_pageRef());
	fomCO.setCtsTellerVO(sessionCO.getCtsTellerVO());
	fomCO.setLoginUserId(sessionCO.getUserName());
    }   
    public ID_TYPESVO getIdTypeVO()
    {
	return idTypeVO;
    }

    public void setIdTypeVO(ID_TYPESVO idTypeVO)
    {
	this.idTypeVO = idTypeVO;
    }

    public BigDecimal getIdTypeCode()
    {
	return idTypeCode;
    }

    public void setIdTypeCode(BigDecimal idTypeCode)
    {
	this.idTypeCode = idTypeCode;
    }

    public void setIdTypeBO(IdTypeBO idTypeBO)
    {
	this.idTypeBO = idTypeBO;
    }

    public String getBlackListIdsStr()
    {
	return blackListIdsStr;
    }

    public void setBlackListIdsStr(String blackListIdsStr)
    {
	this.blackListIdsStr = blackListIdsStr;
    }

    public IdTypeSC getIdTypeSC()
    {
        return idTypeSC;
    }

    public void setIdTypeSC(IdTypeSC idTypeSC)
    {
        this.idTypeSC = idTypeSC;
    }
    
    public FomCO getFomCO()
    {
        return fomCO;
    }

    public BigDecimal getCifCode()
    {
        return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
        this.cifCode = cifCode;
    }

    public void setFomCO(FomCO fomCO)
    {
        this.fomCO = fomCO;
    }
    
    public String getIdNoCode()
    {
        return idNoCode;
    }

    public void setIdNoCode(String idNoCode)
    {
        this.idNoCode = idNoCode;
    }
}
