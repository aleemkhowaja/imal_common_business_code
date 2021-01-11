package com.path.core.bo.blacklistmanagement.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.core.bo.blacklistmanagement.BlackListLogBO;
import com.path.core.dao.blacklistmanagement.BlackListLogDAO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.dbmaps.vo.TFSADVICEVO;
import com.path.dbmaps.vo.TFSBILLVO;
import com.path.dbmaps.vo.TFSCTRL1VO;
import com.path.dbmaps.vo.TFSLC1VO;
import com.path.dbmaps.vo.TFSLC2VO;
import com.path.dbmaps.vo.TFSLCREQUEST1VO;
import com.path.dbmaps.vo.TFSLCREQUEST2VO;
import com.path.dbmaps.vo.TFSLGVO;
import com.path.dbmaps.vo.TFSTRXVO;
import com.path.dbmaps.vo.TFS_ADVANCE_PAYMENTVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.CommonLibSC;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.blacklistmanagement.BlackListLogCO;
import com.path.vo.core.blacklistmanagement.BlackListLogSC;
import com.path.vo.core.blacklistmanagement.BlackListNameMatchCO;
import com.path.vo.core.blacklistmanagement.BlackListReasonCO;

public class BlackListLogBOImpl extends RetailBaseBO implements BlackListLogBO
{

    private BlackListLogDAO blackListLogDAO;
    private AlertsBO alertsBO;
   
    public Integer loadBlackListLogGridCount(BlackListLogSC blackListLogSC) throws BaseException
    {
	return blackListLogDAO.loadBlackListLogGridCount(blackListLogSC);
    }

  
    public List<BlackListLogCO> loadBlackListLogGrid(BlackListLogSC blackListLogSC) throws BaseException
    {
	return blackListLogDAO.loadBlackListLogGrid(blackListLogSC);
    }
    
    public Integer loadBlackListReasonGridCount(BlackListLogSC blackListLogSC) throws BaseException
    {
	return blackListLogDAO.loadBlackListReasonGridCount(blackListLogSC);
    }

  
    public List<BlackListReasonCO> loadBlackListReasonPageGrid(BlackListLogSC blackListLogSC) throws BaseException
    {
	return blackListLogDAO.loadBlackListReasonPageGrid(blackListLogSC);
    }
    
    public Integer loadBlackListNameMatchGridCount(BlackListLogSC blackListLogSC) throws BaseException
    {
	return blackListLogDAO.loadBlackListNameMatchGridCount(blackListLogSC);
    }

  
    public List<BlackListNameMatchCO> loadBlackListNameMatchPageGrid(BlackListLogSC blackListLogSC) throws BaseException
    {
	return blackListLogDAO.loadBlackListNameMatchPageGrid(blackListLogSC);
    }


    public BlackListLogDAO getBlackListLogDAO()
    {
        return blackListLogDAO;
    }


    public void setBlackListLogDAO(BlackListLogDAO blackListLogDAO)
    {
	this.blackListLogDAO = blackListLogDAO;
    }
    public void process(BlackListLogCO blackListLogCO) throws BaseException
    {
	//added by rany for tpid:514489-SBI170088 tfa blacklist checking
	//used for TFA checkings
	String todoException = null,rejectedStatus = null,ValidateStatus=null,status = null;
	TFSCTRL1VO tfsctrl1VO = new TFSCTRL1VO();
	tfsctrl1VO.setCOMP_CODE(blackListLogCO.getCompCode());
	tfsctrl1VO.setBRANCH(blackListLogCO.getBranchCode());
	tfsctrl1VO = (TFSCTRL1VO)genericDAO.selectByPK(tfsctrl1VO);
	if(tfsctrl1VO !=null)
	{
	   if("1".equals(tfsctrl1VO.getVALIDATE_MANDAT()))
	   {
	       rejectedStatus = AlertsConstants.STATUS_REJECTED_1;//"Y"
	       ValidateStatus = "L";//validate
	   }
	   else
	   {
	       rejectedStatus = AlertsConstants.STATUS_REJECTED_2;//"J"
	       ValidateStatus = "A";//active dummy
	   }
	}
	//end rany
	
	for(int i = 0; i < blackListLogCO.getBlackListLog().size(); i++)
	{
	    if(("2".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE())) && 
		    StringUtil.isEmptyString(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getREMARK_VALUE()))
	    {
		throw new BOException(MessageCodes.PARAM1_IS_MISSING_INVALID, new String[] { "remark_value_key" });
		
	    }
	    
	    //blackListLogDAO.updateBlackListLog(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO());
	    NumberUtil.resetEmptyValues(blackListLogCO);
	    if (blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getCRITERIA_MATCH_PERCENT().compareTo(new BigDecimal(-9999999))==0)
	    {
		blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().setCRITERIA_MATCH_PERCENT(new BigDecimal(0));
	    }
	    blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().setCOMP_CODE(blackListLogCO.getCompCode());
	    blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().setBRANCH_CODE(blackListLogCO.getBranchCode());
	    
	    int result = genericDAO.update(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO());
	    if(result < 1)
	    {
		throw new BOException(MessageCodes.RECORD_HAS_CHANGED);
	    }
	    
	    if(("1".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE())) || 
		    ("2".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))) 
	    {
		//added by rany for tpid:514489-SBI170088 tfa blacklist checking
		blackListLogCO.setEntityType(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE());
		blackListLogCO.setTrxNbr(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_NO());
		//end rany
		blackListLogCO.setTodoParam(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_NO());
		
		S_TODO_DETVO sToDoDetVo = new S_TODO_DETVO();
		S_TODO_DETVO sToDoDetVOAlert = blackListLogDAO.returnSTODOVOData(blackListLogCO);
		if(sToDoDetVOAlert != null)
		{
			AlertsSC alertsSC = new AlertsSC();
			alertsSC.setTellerId(blackListLogCO.getUserId());
			alertsSC.setUserId( sToDoDetVOAlert.getRECEIVED_FROM());
			alertsSC.setUserAction(AlertsConstants.USER_ACTION_G);
			alertsSC.setJobAction(AlertsConstants.JOB_ACTION_G);
			alertsSC = alertsBO.callToDoDet(alertsSC);
			
			sToDoDetVo.setTODO_CODE(alertsSC.getTodoCode());
			sToDoDetVo.setTODO_LINE(alertsSC.getTodoLine());
			sToDoDetVo.setCOMP_CODE(blackListLogCO.getCompCode());
			sToDoDetVo.setBRANCH_CODE(blackListLogCO.getBranchCode());
			sToDoDetVo.setDISTRIBUTION_TYPE(AlertsConstants.DISTRIBUTION_TYPE_B);
			sToDoDetVo.setDISTRIBUTION_TO(AlertsConstants.DISTRIBUTION_TO_U);
			sToDoDetVo.setBRIEF_NAME_ENG(TrxMgntConstant.BLACK_LIST_LOG);
			sToDoDetVo.setBRIEF_NAME_ARAB(TrxMgntConstant.BLACK_LIST_LOG);
			sToDoDetVo.setTODO_TYPE(AlertsConstants.TODO_TYPE_P);
			sToDoDetVo.setTODO_APPLICATION(blackListLogCO.getAppName());
			sToDoDetVo.setTODO_PARAM(blackListLogCO.getTodoParam().toString());
			
			if (!(StringUtil.isEmptyString(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getREMARK_VALUE())))
        		{
        		    sToDoDetVo.setTODO_EXCEP_ENG(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getREMARK_VALUE());
        		}
			
			if("CIF".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))
			{
			    if("1".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))
			    {
				sToDoDetVo.setTODO_ALERT("CCA");
			    }
			    else if("2".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))
			    {
				
				sToDoDetVo.setTODO_ALERT("CCR");
			    }
			    sToDoDetVo.setTODO_PROG_REF("F00I1MT");
			}
			
			else if ("TRX".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())||"Trx".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))
			{
			    if("1".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))
			    {
				sToDoDetVo.setTODO_ALERT("CTA");
			    }
			    else if("2".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))
			    {
				sToDoDetVo.setTODO_ALERT("CTR");
			    }
			    sToDoDetVo.setTODO_PROG_REF("D001MT");
			}
			
			//TFA part added by rany for tpid:514489-SBI170088 tfa blacklist checking
			else if(AlertsConstants.ILC.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
				|| AlertsConstants.ELC.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
				|| AlertsConstants.LG.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
				|| AlertsConstants.IBL.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
				|| AlertsConstants.EBL.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
				|| AlertsConstants.ADV.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
				|| AlertsConstants.IAD.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
				|| AlertsConstants.EAD.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
				|| AlertsConstants.EBD.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))
			{
			    String type = null,tableName,entityKey = null,opt = null;
			    BigDecimal compCode= new BigDecimal(0),branch= new BigDecimal(0),trxNumber= new BigDecimal(0),lcYear = new BigDecimal(0),trxType= new BigDecimal(0),tfsTrxNbr= new BigDecimal(0);
			    entityKey 	= sToDoDetVOAlert.getTODO_PARAM();
			    
			    CommonLibSC sc = new CommonLibSC();
  			    sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
  			    sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
  			    sc.setLanguage(blackListLogCO.getLanguage());
  			    sc.setKeyLabelCode("record_key");
			    String record = commonLibBO.returnKeyLabelTrans(sc);
			    sc.setKeyLabelCode("Rejected_key");
			    String rejected = commonLibBO.returnKeyLabelTrans(sc);
			    sc.setAppName(ConstantsCommon.TFA_APP_NAME);
			    sc.setKeyLabelCode("Is_key");
			    String is = commonLibBO.returnKeyLabelTrans(sc);
			    sc.setKeyLabelCode("Validated_key");
			    String validated = commonLibBO.returnKeyLabelTrans(sc);	
			    
			    //update status to validate
			    if("1".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))
			    {
				status = ValidateStatus;
			    }
			    //update status to reject
			    if("2".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))
			    {
				status= rejectedStatus;
				
      			    	todoException = record + " " + blackListLogCO.getTodoParam().toString() + " " + is + " " + rejected + ":" + blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getREMARK_VALUE(); 
			    } 
			    
			    if(AlertsConstants.ILC.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())//IMPORT_LC
				    || AlertsConstants.ELC.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))//EXPORT_LC
			    {
				    //OLC01P/OLC02P/OLCA3P/OLCL3P/OLCG3P/OLC04P/OLC05P/OLC07P for import lc
				    //LCL1P/ILCL2P/ILCG2P/ILC03P for export lc
        			    tableName 	= entityKey.substring(0,6);
			    
        			    if(AlertsConstants.TFSLC1.equals(tableName))
        			    {
        				compCode= new BigDecimal(entityKey.substring(12,16));
             			    	branch	= new BigDecimal(entityKey.substring(16,20));
        				type 	= entityKey.substring(20,21);
        				lcYear	= new BigDecimal(entityKey.substring(21,25));
        				trxNumber = new BigDecimal(entityKey.substring(25,35));
        				trxType = new BigDecimal(entityKey.substring(35,39));
        				tfsTrxNbr = new BigDecimal(entityKey.substring(39,51));
        				
        				if((AlertsConstants.ILC.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
        					&& AlertsConstants.TRX_TYPE_DECLARATION.equals(trxType))//request IMPORT_LC 1005
        					 || AlertsConstants.ELC.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))//EXPORT_LC
   					 {
       				     		opt = entityKey.substring(6,12);
   					 }
        				 else if(AlertsConstants.ILC.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())
        					&& AlertsConstants.TRX_TYPE_ISSUE.equals(trxType))//issuance IMPORT_LC 1010
   					 {
        				     opt = "OLC02MT";
        				     if("1".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))
        				     {
        					 todoException = record + " " + blackListLogCO.getTodoParam().toString() + " " + is + " " + validated ;
        				     }
   					 }
        				
    				    	TFSLC1VO tfslc1VO = new TFSLC1VO();
    				    	tfslc1VO.setCOMP_CODE(compCode);
    				    	tfslc1VO.setBRANCH(branch);
    				    	tfslc1VO.setLC_TYPE(type);
    				    	tfslc1VO.setLC_YEAR(lcYear);
    				    	tfslc1VO.setLC_NBR(trxNumber);
    				    	tfslc1VO.setLC_STATUS(status);
    				    	genericDAO.update(tfslc1VO);
    				    	
    				    	TFSLC2VO tfslc2VO = new TFSLC2VO();
    				    	tfslc2VO.setCOMP_CODE(compCode);
    				    	tfslc2VO.setBRANCH(branch);
    				    	tfslc2VO.setLC_TYPE(type);
				    	tfslc2VO.setLC_YEAR(lcYear);
				    	tfslc2VO.setLC_NBR(trxNumber);
				    	tfslc2VO.setLC_STATUS(status);
				    	genericDAO.update(tfslc2VO);
        			    }
        			    else if(AlertsConstants.TFSTRX.equals(tableName))
        			    {
        				opt	= entityKey.substring(6,12);
        				compCode= new BigDecimal(entityKey.substring(12,16));
             			    	branch	= new BigDecimal(entityKey.substring(16,20));
        				trxType = new BigDecimal(entityKey.substring(20,24));
        				tfsTrxNbr = new BigDecimal(entityKey.substring(24,36));
        				type 	= entityKey.substring(36,37);			
        			    }
        			    else//TFSLCREQUEST1
        			    {
        				tableName = entityKey.substring(0,13);
        				opt	= entityKey.substring(13,19);
        				compCode= new BigDecimal(entityKey.substring(19,23));
             			    	branch	= new BigDecimal(entityKey.substring(23,27));
        				type 	= entityKey.substring(27,28);
          				lcYear	= new BigDecimal(entityKey.substring(28,32));
          				trxNumber = new BigDecimal(entityKey.substring(32,42));
          				trxType = new BigDecimal(entityKey.substring(42,46));
          				tfsTrxNbr = new BigDecimal(entityKey.substring(46,58));
          				
      				    	TFSLCREQUEST1VO tfslcRequest1VO = new TFSLCREQUEST1VO();
      				    	tfslcRequest1VO.setCOMP_CODE(compCode);
      				    	tfslcRequest1VO.setBRANCH(branch);
      				    	tfslcRequest1VO.setLC_TYPE(type);
      				    	tfslcRequest1VO.setLC_YEAR(lcYear);
      				    	tfslcRequest1VO.setLC_NBR(trxNumber);
      				    	tfslcRequest1VO.setSTATUS(status);
      				    	genericDAO.update(tfslcRequest1VO);
      				    	
      				    	TFSLCREQUEST2VO tfslcRequest2VO = new TFSLCREQUEST2VO();
				    	tfslcRequest2VO.setCOMP_CODE(compCode);
				    	tfslcRequest2VO.setBRANCH(branch);
				    	tfslcRequest2VO.setLC_TYPE(type);
				    	tfslcRequest2VO.setLC_YEAR(lcYear);
				    	tfslcRequest2VO.setLC_NBR(trxNumber);
				    	tfslcRequest2VO.setSTATUS(status);
				    	genericDAO.update(tfslcRequest2VO);
        			    }
        			    
        			    // update status to reject or validate should be done also when updating TFSLC1 or TFSLCREQUEST1.
        			    TFSTRXVO tfstrxVO = new TFSTRXVO();
        			    tfstrxVO.setCOMP_CODE(compCode);
        			    tfstrxVO.setBRANCH(branch);
        			    tfstrxVO.setTRX_TYPE(trxType);
        			    tfstrxVO.setTRX_NBR(tfsTrxNbr);
        			    tfstrxVO.setLC_TYPE(type);
        			    tfstrxVO.setSTATUS(status);
        			    genericDAO.update(tfstrxVO);
			    }
			    else if(AlertsConstants.LG.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))//LETTER_GUARANTEE
			    {
				tableName = entityKey.substring(0,5);
				type	= "G";
				
     			    	if(AlertsConstants.TFSLG.equals(tableName))
     			    	{
     			    	    opt		= entityKey.substring(5,10);//LG01P/LG02P/
     			    	    compCode	= new BigDecimal(entityKey.substring(10,14));
     			    	    branch	= new BigDecimal(entityKey.substring(14,18));
     			    	    trxNumber 	= new BigDecimal(entityKey.substring(18,28));
     			    	    trxType 	= new BigDecimal(entityKey.substring(28,32));
     			    	    tfsTrxNbr	= new BigDecimal(entityKey.substring(32,44));
     			    	    
     			    	    TFSLGVO tfslgVO = new TFSLGVO();
     			    	    tfslgVO.setCOMP_CODE(compCode);
     			    	    tfslgVO.setBRANCH(branch);
     			    	    tfslgVO.setREQUISITION_NBR(trxNumber);
     			    	    if(AlertsConstants.TRX_TYPE_ISSUE.equals(trxType))//issuance 1010
     			    	    {
     			    		tfslgVO.setLG_STATUS(status);
     			    	    }
     			    	    if(AlertsConstants.TRX_TYPE_DECLARATION.equals(trxType))//request 1005
     			    	    {
     			    		tfslgVO.setSTATUS(status);
     			    	    }
     			    	    genericDAO.update(tfslgVO);
     			    	}
     			    	else//TFSTRX
     			    	{
     			    	    tableName 	= entityKey.substring(0,6);
     			    	    opt		= entityKey.substring(6,10);//LG3P
         			    
     			    	    if("LG3P".equals(opt))
     			    	    {
     			    		compCode= new BigDecimal(entityKey.substring(10,14));
     			    		branch	= new BigDecimal(entityKey.substring(14,18));
     			    		trxType = new BigDecimal(entityKey.substring(18,22));
     			    		tfsTrxNbr = new BigDecimal(entityKey.substring(22,34));
     			    	    }
     			    	    else//LGA3P/LGL3P
     			    	    {
     			    		opt = entityKey.substring(6,11);
     			    		compCode= new BigDecimal(entityKey.substring(11,15));
			    		branch	= new BigDecimal(entityKey.substring(15,19));
			    		trxType = new BigDecimal(entityKey.substring(19,23));
			    		tfsTrxNbr = new BigDecimal(entityKey.substring(23,35));
     			    	    }
     			    	}
 			    	//update status to reject should be done also when updating TFSLG.
     			    	TFSTRXVO tfstrxVO = new TFSTRXVO();
     			    	tfstrxVO.setCOMP_CODE(compCode);
     			    	tfstrxVO.setBRANCH(branch);
     			    	tfstrxVO.setTRX_TYPE(trxType);
     			    	tfstrxVO.setTRX_NBR(tfsTrxNbr);
     			    	tfstrxVO.setLC_TYPE(type);
     			    	tfstrxVO.setSTATUS(status);
     			    	genericDAO.update(tfstrxVO);
			    }
			    else if(AlertsConstants.IBL.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))//IMPORT_BILL
			    {
				tableName = entityKey.substring(0,7);
			    
    			    	if(AlertsConstants.TFSBILL.equals(tableName))
    			    	{
    			    	    opt 	= entityKey.substring(7,12);//IB01P COLLECTION
    			    	    compCode	= new BigDecimal(entityKey.substring(12,16));
    			    	    branch	= new BigDecimal(entityKey.substring(16,20));
    			    	    type 	= entityKey.substring(20,21);
    			    	    trxNumber 	= new BigDecimal(entityKey.substring(21,31));
    			    	    trxType 	= new BigDecimal(entityKey.substring(31,35));
    			    	    tfsTrxNbr	= new BigDecimal(entityKey.substring(35,47));
    			    	    
    			    	    TFSBILLVO tfsBillVO = new TFSBILLVO();
    			    	    tfsBillVO.setCOMP_CODE(compCode);
    			    	    tfsBillVO.setBRANCH(branch);
    			    	    tfsBillVO.setBILL_TYPE(type);
    			    	    tfsBillVO.setBILL_NBR(trxNumber);
    			    	    tfsBillVO.setSTATUS(status);
    			    	    genericDAO.update(tfsBillVO);
    			    	}
    			    	else//TFSTRX
    			    	{
    			    	    tableName 	= entityKey.substring(0,6);
    			    	    opt 	= entityKey.substring(6,12);
    			    	    
    			    	    if("IB11DP".equals(opt))//BILL DECLARATION IMPORT
    			    	    {
    			    		compCode	= new BigDecimal(entityKey.substring(12,16));
    			    		branch		= new BigDecimal(entityKey.substring(16,20));
    			    		trxType 	= new BigDecimal(entityKey.substring(20,24));
    			    		tfsTrxNbr 	= new BigDecimal(entityKey.substring(24,36));
    			    		type 		= entityKey.substring(36,37);	
    			    	    }
    			    	    else//IB09P SHIPPING GUAR /IB02P SETTLEMENT///IBA5P/IBL5P/OBG5P/IB05P AMENDMENTS
    			    	    {
    			    		opt 		= entityKey.substring(6,11);
    			    		compCode	= new BigDecimal(entityKey.substring(11,15));
    			    		branch		= new BigDecimal(entityKey.substring(15,19));
    			    		trxType		= new BigDecimal(entityKey.substring(19,23));
    			    		tfsTrxNbr 	= new BigDecimal(entityKey.substring(23,35));
    			    		type 		= entityKey.substring(35,36);
    			    	    }
    			    	}
    			    	TFSTRXVO tfstrxVO = new TFSTRXVO();
    			    	tfstrxVO.setCOMP_CODE(compCode);
    			    	tfstrxVO.setBRANCH(branch);
    			    	tfstrxVO.setTRX_TYPE(trxType);
    			    	tfstrxVO.setTRX_NBR(tfsTrxNbr);
    			    	tfstrxVO.setLC_TYPE(type);
    			    	tfstrxVO.setSTATUS(status);
    			    	genericDAO.update(tfstrxVO);
			    }
			    else if(AlertsConstants.EBL.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))//EXPORT_BILL
			    {
				tableName = entityKey.substring(0,7);
				    
    			    	if(AlertsConstants.TFSBILL.equals(tableName))
    			    	{
    			    	    opt 	= entityKey.substring(7,12);//OB01P
    			    	    compCode	= new BigDecimal(entityKey.substring(12,16));
    			    	    branch	= new BigDecimal(entityKey.substring(16,20));
    			    	    type 	= entityKey.substring(20,21);
    			    	    trxNumber 	= new BigDecimal(entityKey.substring(21,31));
    			    	    trxType 	= new BigDecimal(entityKey.substring(31,35));
    			    	    tfsTrxNbr	= new BigDecimal(entityKey.substring(35,47));
    			    	    
    			    	    TFSBILLVO tfsBillVO = new TFSBILLVO();
    			    	    tfsBillVO.setCOMP_CODE(compCode);
    			    	    tfsBillVO.setBRANCH(branch);
    			    	    tfsBillVO.setBILL_TYPE(type);
    			    	    tfsBillVO.setBILL_NBR(trxNumber);
    			    	    tfsBillVO.setSTATUS(status);
    			    	    genericDAO.update(tfsBillVO);
    			    	}
    			    	else//TFSTRX 
    			    	{
    			    	    tableName 	= entityKey.substring(0,6);
    			    	    opt 	= entityKey.substring(6,11);//OBL5P/OBL5P/OBG5P/OB02P
    			    	    compCode	= new BigDecimal(entityKey.substring(11,15));
    			    	    branch	= new BigDecimal(entityKey.substring(15,19));
    			    	    trxType	= new BigDecimal(entityKey.substring(19,23));
    			    	    tfsTrxNbr 	= new BigDecimal(entityKey.substring(23,35));
    			    	    type 	= entityKey.substring(35,36);
    			    	}
    			    	
    			    	TFSTRXVO tfstrxVO = new TFSTRXVO();
    			    	tfstrxVO.setCOMP_CODE(compCode);
    			    	tfstrxVO.setBRANCH(branch);
    			    	tfstrxVO.setTRX_TYPE(trxType);
    			    	tfstrxVO.setTRX_NBR(tfsTrxNbr);
			    	tfstrxVO.setLC_TYPE(type);
			    	tfstrxVO.setSTATUS(status);
			    	genericDAO.update(tfstrxVO);
			    }
			    else if(AlertsConstants.ADV.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))//ADVICE
			    {
				opt="AD01P";
				tableName = entityKey.substring(0,9);
     			    	compCode= new BigDecimal(entityKey.substring(9,13));
     			    	branch	= new BigDecimal(entityKey.substring(13,17));
     			    	trxNumber = new BigDecimal(entityKey.substring(17,33));
     			    	trxType	  = new BigDecimal(2012);
     			    	type	  = "Z";
     			    	tfsTrxNbr = new BigDecimal(entityKey.substring(21,33));
     			    	
     			    	//update status to reject
     			   	if("2".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))
			    	{
     			   	    TFSADVICEVO tfsAdviceVO = new TFSADVICEVO();
     			   	    tfsAdviceVO.setCOMP_CODE(compCode);
     			   	    tfsAdviceVO.setBRANCH_CODE(branch);
     			   	    tfsAdviceVO.setSERIAL_NO(trxNumber);
     			   	    tfsAdviceVO.setSTATUS("D");
			    	    genericDAO.update(tfsAdviceVO);
			    	    
			    	    TFSTRXVO tfstrxVO = new TFSTRXVO();
			    	    tfstrxVO.setCOMP_CODE(compCode);
			    	    tfstrxVO.setBRANCH(branch);
			    	    tfstrxVO.setTRX_TYPE(trxType);
			    	    tfstrxVO.setTRX_NBR(tfsTrxNbr);
			    	    tfstrxVO.setLC_TYPE(type);
			    	    tfstrxVO.setSTATUS("D");
			    	    genericDAO.update(tfstrxVO);
			    	}
			    }
			    else if(AlertsConstants.IAD.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())//IMPORT_LC_ADVANCE_PAYMENT
				    || AlertsConstants.EAD.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())//EXPORT_LC_ADVANCE_PAYMENT
				    || AlertsConstants.EBD.equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))//EXPORT_BILL_ADVANCE_PAYMENT
			    {
				tableName = entityKey.substring(0,19);
				opt 	  = entityKey.substring(19,24);
				
				if("OB09P".equals(opt))
				{
				    compCode	= new BigDecimal(entityKey.substring(24,28));
				    branch	= new BigDecimal(entityKey.substring(28,32));
				    type	= entityKey.substring(32,33);
				    trxNumber 	= new BigDecimal(entityKey.substring(33,43));
				    tfsTrxNbr 	= new BigDecimal(entityKey.substring(43,55));
				    trxType 	= new BigDecimal(entityKey.substring(55,59));
				}
				else//OLC08P,ILC06P
				{
				    opt		= entityKey.substring(19,25);
				    compCode	= new BigDecimal(entityKey.substring(25,29));
				    branch	= new BigDecimal(entityKey.substring(29,33));
				    type	= entityKey.substring(33,34);
				    trxNumber 	= new BigDecimal(entityKey.substring(34,44));
				    tfsTrxNbr 	= new BigDecimal(entityKey.substring(44,56));
				    trxType 	= new BigDecimal(entityKey.substring(56,60));
				}
				
 			   	TFS_ADVANCE_PAYMENTVO tfsAdvancepaymentVO = new TFS_ADVANCE_PAYMENTVO();
     			   	tfsAdvancepaymentVO.setCOMP_CODE(compCode);
     			   	tfsAdvancepaymentVO.setBRANCH_CODE(branch);
     			   	tfsAdvancepaymentVO.setTRX_NBR(trxNumber);
     			   	tfsAdvancepaymentVO.setDOC_TYPE(type);
     			   	tfsAdvancepaymentVO.setSTATUS(status);
			    	genericDAO.update(tfsAdvancepaymentVO);
			    	
			    	TFSTRXVO tfstrxVO = new TFSTRXVO();
    			    	tfstrxVO.setCOMP_CODE(compCode);
    			    	tfstrxVO.setBRANCH(branch);
    			    	tfstrxVO.setTRX_TYPE(trxType);
    			    	tfstrxVO.setTRX_NBR(tfsTrxNbr);
    			    	tfstrxVO.setLC_TYPE(type);
    			    	tfstrxVO.setSTATUS(status);
    			    	genericDAO.update(tfstrxVO);
			    	
			    }
			   
			    
			    //approve and  opt = OLC02MT cz there is no approve on issuance of import lc,so we validate and we send info alert to user
			    if("1".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()) && "OLC02MT".equals(opt))
			    {
				sToDoDetVo.setTODO_ALERT(AlertsConstants.BLR);
				sToDoDetVo.setTODO_EXCEP_ENG(todoException);//overwrite the above TODO_EXCEP_ENG
			    }
			    else if("1".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))//approve
			    {
				 sToDoDetVo.setTODO_ALERT(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE());
				 String todoParam = NumberUtil.addLeadingZeros(compCode, 4) + NumberUtil.addLeadingZeros(branch,4)+NumberUtil.addLeadingZeros(trxType,4)+ type + NumberUtil.addLeadingZeros(tfsTrxNbr,12);
				 sToDoDetVo.setTODO_PARAM(todoParam);//overwrite the above todoparam
				 sToDoDetVo.setBRIEF_NAME_ENG(TrxMgntConstant.ACTION_APPROVE);//overwrite the above BRIEF NAME ENG
				 sToDoDetVo.setBRIEF_NAME_ARAB(TrxMgntConstant.ACTION_APPROVE);//overwrite the above  BRIEF NAME ARAB
			    }
			    else if("2".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE()))//reject
			    {
				sToDoDetVo.setTODO_ALERT(AlertsConstants.BLR);
				sToDoDetVo.setTODO_EXCEP_ENG(todoException);//overwrite the above TODO_EXCEP_ENG
			    }
			    sToDoDetVo.setTODO_PROG_REF(opt);
			    sToDoDetVo.setTODO_APPLICATION(ConstantsCommon.TFA_APP_NAME);//overwrite the above app name
			    
			}//end rany
			
			sToDoDetVo.setUSER_ID(sToDoDetVOAlert.getRECEIVED_FROM());		
			sToDoDetVo.setTODO_PRIORITY(AlertsConstants.TODO_PRIORITY_A);
			sToDoDetVo.setTODO_STATUS(AlertsConstants.STATUS_ACTIVE);
			sToDoDetVo.setALLOW_TO_SEND(BigDecimal.ONE);
			sToDoDetVo.setDATE_RECEIVED(blackListLogCO.getRunningDate());
			sToDoDetVo.setRECEIVED_FROM(sToDoDetVOAlert.getUSER_ID());
			sToDoDetVo.setTODO_CHECKED(AlertsConstants.TODO_CHECKED_U);
			sToDoDetVo.setJOB_ID(alertsSC.getJobId());
			sToDoDetVo.setTODO_EXECUTION(AlertsConstants.TODO_EXECUTION_N);
			
			Calendar calendar = GregorianCalendar.getInstance();
			Date dateReceived = commonLibBO.returnSystemDateWithTime();
			calendar.setTime(dateReceived);
			CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
			ctsControlVO.setCOMP_CODE(blackListLogCO.getCompCode());
			ctsControlVO.setBRANCH_CODE(blackListLogCO.getBranchCode());
			ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);
			calendar.add(Calendar.SECOND,NumberUtil.emptyDecimalToZero(ctsControlVO.getALERT_WAIT_TIME()).intValue());
			sToDoDetVo.setALERT_WAITING_TIME(calendar.getTime());
			sToDoDetVo.setTODO_EXECUTION(AlertsConstants.TODO_EXECUTION_N);
			
		    // String transMessage = "";
		    // CommonLibSC sc = new CommonLibSC();
		    // sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		    // sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
		    // sc.setKeyLabelCode(FomConstant.BLACKLIST_LOG_COMPLIANCE_ACTION.toLowerCase());
		    // sc.setLanguage("EN");
		    // transMessage = commonLibBO.returnKeyLabelTrans(sc);
		    // sToDoDetVo.setTODO_EXCEP_ENG(transMessage);
		    // sc.setLanguage("AR");
		    // transMessage = commonLibBO.returnKeyLabelTrans(sc);
		}
		
		if("2".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getACTION_TYPE())
			&& ("TRX".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()) ||"Trx".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()) 
				|| "CIF".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())))
		{
			
		    if ("TRX".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE())||"Trx".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))
		    {
			BigDecimal entityNo = blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_NO();
			blackListLogCO.setEntityNo(entityNo);
			blackListLogCO.setTrsType(TrxMgntConstant.TRS_TYPE_CSM);
			blackListLogCO.setCbInd(TrxMgntConstant.CLIENT_CB_IND);
			blackListLogDAO.updateBlckListTrxStatus(blackListLogCO);
		    }
		    
		    else if("CIF".equals(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_TYPE()))
		    {
			CIFVO cifVO = new CIFVO();
			cifVO.setCOMP_CODE(blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getCOMP_CODE());
			BigDecimal entityNo = blackListLogCO.getBlackListLog().get(i).getCtsBlackListLogVO().getENTITY_NO();
			//blackListLogCO.setEntityNo(entityNo);
			cifVO.setCIF_NO(entityNo);
			cifVO.setSTATUS("D");
			genericDAO.update(cifVO);
			//blackListLogDAO.updateBlckListCIFStatus(blackListLogCO);
		    }
		}
		
		if(sToDoDetVOAlert!=null)//id:1010915 Details:SBI200257 - Black List Log S_TODO_DET Issue TAR:SBI200257
		    //no need to send ack if no alert is sent in the first place
		{   
		alertsBO.saveAlert(sToDoDetVo);
		}
	    }//end if 1 or 2
	}//end for loop
    }


    public AlertsBO getAlertsBO()
    {
	return alertsBO;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
	this.alertsBO = alertsBO;
    }

}
