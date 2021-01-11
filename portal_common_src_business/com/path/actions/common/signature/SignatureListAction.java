/**
 * 
 */
package com.path.actions.common.signature;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.common.signature.SignatureBO;
import com.path.bo.common.signature.SignatureConstant;
import com.path.dbmaps.vo.CIFOBJECTVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.signature.SignatureSC;
import com.path.vo.core.cif.CifSC;
import com.rits.cloning.Cloner;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Navas
 *
 * SignatureMainAction.java used to handle all action related to Signature management
 */
public class SignatureListAction extends GridBaseAction
{
	private SignatureBO signatureBO;
	private SignatureSC signatureSC = new SignatureSC();
	private String signatureTp;
	/***
	 * Returns the model of general accounts main grid
	 */

	public Object getModel(){
		return signatureSC;
	}
		
	/***
	 * Method for populating the signature grid
	 * @return
	 */
	public String loadSignatureGrid(){
		try{
		    String[] searchCols = {"DESCRIPTION","instructionsDesc","AMOUNT","currencyDesc","GROUP_ID","EXP_DATE","DEFAULT_UNLIMITED","STATUS"};
	 	    SessionCO sessionObject = returnSessionObject();
	 	    signatureSC.setCompCode(sessionObject.getCompanyCode());//branch cod will be send from client	 	   
	 	    signatureSC.setObjType(SignatureConstant.SIGNATURE);//Signatures
	 	    signatureSC.setValidationDate(sessionObject.getRunningDateRET());
	 	    signatureSC.setUserId(sessionObject.getUserName());
	 	    signatureSC.setAppName(sessionObject.getCurrentAppName());
	 	    signatureSC.setLangCode(sessionObject.getLanguage());
	 	    signatureSC.setLovType(SignatureConstant.SIGN_STATUS_CODE);
	 	    signatureSC.setPreferredLanguage(sessionObject.getPreferredLanguage());
	 	    if(signatureSC.isShowAcceptCancelBtns())
	 	    {
	 		signatureSC.setStatus("P");
	 	    }
	 	    if (!("").equals(StringUtil.nullToEmpty(signatureSC.getValidationDateStr())))
	 	    {
	 	   signatureSC.setValidationDate(DateUtil.getFormatedDate(signatureSC.getValidationDateStr()));
	 	    }
	 	    signatureSC.setSearchCols(searchCols);	 	    
	 	    copyproperties(signatureSC);
	 	    ArrayList<SignatureCO> signatureCOList	=	(ArrayList<SignatureCO>) signatureBO.selectSignatureList(signatureSC);
	 	    //load CIF signatures if account signatures are empty
	 	    if(signatureCOList.isEmpty()&&"A".equals(signatureSC.getSignatureTp())&&signatureSC.isShowAcceptCancelBtns()){//&&signatureSC.isReadOnly()
	 	    	SignatureSC cifSignatureSC = (new Cloner()).deepClone(signatureSC);
	 	    	cifSignatureSC.setSignatureTp("C");
	 	    	cifSignatureSC.setGlCode(BigDecimal.ZERO);
	 	    	cifSignatureSC.setSlNo(BigDecimal.ZERO);
	 	    	cifSignatureSC.setCurrencyCode(BigDecimal.ZERO);
	 	    	cifSignatureSC.setStatus("P");
	 	    	
	 	    	CifSC criteria = new CifSC();
	 	    	criteria.setComp_code(sessionObject.getCompanyCode());
	 	    	criteria.setCif_no(cifSignatureSC.getCifNo());
	 	    	
	 	    	CIFVO cifVO = returnCommonLibBO().returnCIF(criteria);
	 	    	if(cifVO == null)
	 	    	{
	 	    	    throw new BOException(MessageCodes.ERROR_RETRIEVE_SIGN);
	 	    	}
	 	    	cifSignatureSC.setBranchCode(cifVO.getBRANCH_CODE()); 
	 	    	signatureSC.setBranchCode(cifVO.getBRANCH_CODE());
	 	    	
	 	    	signatureCOList	=	(ArrayList<SignatureCO>) signatureBO.selectSignatureList(cifSignatureSC);
	 	    	
	 	    } 
	 	    setGridModel(signatureCOList);
	 	    HashMap<String, Object> gridFooterMap = new HashMap<String, Object>();
		    gridFooterMap.put("scanVO.DESCRIPTION", getText("Selected_Sum_key"));	
		    gridFooterMap.put("cifObjectVO.AMOUNT", getText("Unlimited_key"));
		    setUserdata(gridFooterMap);
	 	    
		    
		}
		catch (RuntimeException e)
		{
		    throw e;
		}
		catch(Exception e){		   
		    log.error(e, "Error in Signature List Grid");
		    handleException(e, null, null);
		}
		return SUCCESS;
    }
	
	
	/***
	 * Method for populating the document grid
	 * @return
	 */
	public String loadDocumentGrid(){
		try{
		    String[] searchCols = {"DESCRIPTION","STATUS"};
	 	    SessionCO sessionObject = returnSessionObject();
	 	    signatureSC.setCompCode(sessionObject.getCompanyCode());//branch cod will be send from client	 	   
	 	    signatureSC.setObjType(SignatureConstant.DOCUMENT); 	 
	 	    signatureSC.setLovType(SignatureConstant.SIGN_STATUS_CODE);
	 	    signatureSC.setLangCode(sessionObject.getLanguage());
	 	    signatureSC.setSearchCols(searchCols);	 	 
	 	    copyproperties(signatureSC);
	 	    ArrayList<SignatureCO> signatureCOList	=	signatureBO.selectDocumentList(signatureSC);
	 	    setGridModel(signatureCOList);
	 	   
		}
		catch(Exception e){
		    log.error(e, "Error in Signature List Grid");
		    handleException(e, null, null);
		}
		return SUCCESS;
    }
	
	
	public String loadCopySignatureGrid(){
		try
		{ 	//copyproperties(qryGridSC);
			String nodeId=getNodeid(); 
			SessionCO sessionCO   =  returnSessionObject();
			signatureSC.setCompCode(sessionCO.getCompanyCode());
		
			
			List<SignatureCO> signatureCOList =null;
			if(nodeId==null){//retrieve root elements
				signatureCOList  = signatureBO.retrieveSignatureAccounts(signatureSC);
				for (SignatureCO signatureCO : signatureCOList) {
					signatureCO.setAccNoAndDesc(getFormattedAccNo(signatureCO.getCifObjectVO()));
					signatureCO.setIndex(getAccNodeId(signatureCO.getCifObjectVO()));
					 
				}
			}
			else{
				/*signatureSC.setLangCode(sessionCO.getLanguage());
		 	    signatureSC.setLovType(SignatureConstant.SIGN_STATUS_CODE);
		 	    signatureSC.setObjType(SignatureConstant.SIGNATURE);
		 	    signatureSC.setPreferredLanguage("L");*/
				
				signatureCOList = signatureBO.retrieveCopySignatureList(createSignatureCOFromNodeId(nodeId));
				for (int i = 0; i < signatureCOList.size(); i++) {
					SignatureCO   signatureCO = signatureCOList.get(i);  
					signatureCO.setAccNoAndDesc(signatureCO.getScanVO().getDESCRIPTION());
					signatureCO.setIsLeaf("true");
					signatureCO.setLevel("1");
					signatureCO.setParent(nodeId);
					signatureCO.setIndex(nodeId+"-"+i);
					
				}		
			}
			
			
			setGridModel(signatureCOList);
}
		catch(Exception e)
		{
			
			handleException(e, "Error in Copy Signature Grid","");
			 
		
		}
		return SUCCESS;
		
		
		
	}
	
	
	
    private SignatureCO createSignatureCOFromNodeId(String nodeId){
    	String[]  accNo = nodeId.split("-"); 
    	CIFOBJECTVO cifObjectVO  = new CIFOBJECTVO();    	
    	cifObjectVO.setCOMP_CODE(new BigDecimal(accNo[0]));
    	cifObjectVO.setBRANCH_CODE(new BigDecimal(accNo[1]));
    	cifObjectVO.setACC_CY(new BigDecimal(accNo[2]));
    	cifObjectVO.setACC_GL(new BigDecimal(accNo[3]));
    	cifObjectVO.setACC_CIF(new BigDecimal(accNo[4]));
    	cifObjectVO.setACC_SL(new BigDecimal(accNo[5]));
    	SignatureCO signatureCO   = new SignatureCO();
    	signatureCO.setCifObjectVO(cifObjectVO);
    	signatureCO.setSignatureTp("A");
    	return signatureCO ;	
    	
    }
	
	
	private String getAccNodeId(CIFOBJECTVO cifObjectVO){
		return  returnSessionObject().getCompanyCode()+"-"+cifObjectVO.getBRANCH_CODE()+"-"+
				cifObjectVO.getACC_CY()+"-"+cifObjectVO.getACC_GL()+"-"+
				cifObjectVO.getACC_CIF()+"-"+cifObjectVO.getACC_SL();
		 
	}
	
	private String getFormattedAccNo(CIFOBJECTVO cifObjectVO) {
		return NumberUtil.addLeadingZeros(returnSessionObject().getCompanyCode(), 4).concat("-")
		.concat(NumberUtil.addLeadingZeros(cifObjectVO.getBRANCH_CODE(), 4)).concat("-")
	.concat(NumberUtil.addLeadingZeros(cifObjectVO.getACC_CY(), 3)).concat("-")
	.concat(NumberUtil.addLeadingZeros(cifObjectVO.getACC_GL(), 6)).concat("-")
	.concat(NumberUtil.addLeadingZeros(cifObjectVO.getACC_CIF(), 8)).concat("-")
	.concat(NumberUtil.addLeadingZeros(cifObjectVO.getACC_SL(), 3));
	}
    //TODO

	public void setSignatureBO(SignatureBO signatureBO) {
		this.signatureBO = signatureBO;
	}

	public SignatureSC getSignatureSC() {
		return signatureSC;
	}

	public void setSignatureSC(SignatureSC signatureSC) {
		this.signatureSC = signatureSC;
	}

	public String getSignatureTp() {
		return signatureTp;
	}

	public void setSignatureTp(String signatureTp) {
		this.signatureTp = signatureTp;
	}
	



}

