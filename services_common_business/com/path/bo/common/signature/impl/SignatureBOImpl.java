package com.path.bo.common.signature.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.signature.SignatureBO;
import com.path.bo.common.signature.SignatureConstant;
import com.path.bo.core.authsignatories.AuthSignatoriesBO;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dao.common.signature.SignatureDAO;
import com.path.dbmaps.vo.CIFOBJECTVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.S_AUDIT_ACTIONSVO;
import com.path.dbmaps.vo.S_AUDIT_ACTION_DTLVO;
import com.path.dbmaps.vo.S_SCANVO;
import com.path.dbmaps.vo.S_SIGN_ANNVO;
import com.path.dbmaps.vo.S_SIGN_ANN_TEMPVO;
import com.path.dbmaps.vo.S_SIGN_MODIFVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.signature.SignatureSC;
import com.path.vo.core.authsignatories.AuthSignatoriesCO;
import com.path.vo.core.authsignatories.AuthSignatoriesSC;
import com.path.vo.core.cif.CifSC;

public class SignatureBOImpl extends RetailBaseBO implements SignatureBO
{
    private SignatureDAO signatureDAO;
    //EWBI160037 -- [John Massaad]
    private CifBO cifBO;
    private AuthSignatoriesBO authSignatoriesBO;
    

    public SignatureDAO getSignatureDAO()
    {
	return signatureDAO;
    }

    public void setSignatureDAO(SignatureDAO signatureDAO)
    {
	this.signatureDAO = signatureDAO;
    }
 
    
    private Date retrieveSystemDate() throws BaseException
    {
	return commonLibBO.returnSystemDateNoTime();
    }
    
    
    
    
    public SignatureCO deleteSignatures(List<SignatureCO> signatureCOList, SignatureCO signatureCOParam)
	    throws BaseException
    {
	boolean isSignModeZero = isSignModeZero();
	callAlertTable(signatureCOParam);
	if(signatureCOList != null && !signatureCOList.isEmpty())
	{
	    //callAlertTable(signatureCOParam);
	    for(SignatureCO signatureCO : signatureCOList)
	    {
		setSignatureCOApprovalProperties(signatureCO);
		if(isSignModeZero)
		{
		    if(signatureCO.isAutoApprove())
		    {
			signatureCO.getCifObjectVO().setSTATUS("D");
		    }
		    else
		    {
			signatureCO.getCifObjectVO().setTO_BE_STATUS("D");
		    }
		    signatureCO.getCifObjectVO().setDATE_DELETED(signatureCO.getRunningDate());
		    signatureCO.getCifObjectVO().setDELETED_BY(signatureCO.getUserId());
		    //#573892-EWB170023-Modification CIF: Manque l audit de l utilisateur modificateur
		    signatureCO.getCifObjectVO().setCOMP_CODE(NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getCOMP_CODE()));
		signatureCO.getCifObjectVO().setBRANCH_CODE(NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getBRANCH_CODE()));
		signatureCO.getCifObjectVO().setACC_CIF(NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getACC_CIF()));
		signatureCOParam.getCifObjectVO().setOBJECT_SEQ(NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getOBJECT_SEQ()));
		signatureCOParam.getCifObjectVO().setACC_CY(NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getACC_CY()));
		signatureCOParam.getCifObjectVO().setACC_GL(NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getACC_GL()));
		signatureCOParam.getCifObjectVO().setCIF_NO(NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getCIF_NO()));
		signatureCOParam.getCifObjectVO().setACC_SL(NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getACC_SL()));


		
		    SignatureCO olddeletedsignatureCO = (SignatureCO) signatureCOParam.getAuditObj();
		    auditBO.callAudit(olddeletedsignatureCO.getCifObjectVO(), signatureCOParam.getCifObjectVO(),
			    signatureCOParam.getAuditRefCO());
		    auditBO.insertAudit(signatureCOParam.getAuditRefCO());
		    // #573892-EWB170023-Modification CIF: Manque l audit de l utilisateur modificateur
		    updateCIFObject(signatureCO);

		}
		else
		{ // SIGN MODE==1
		    // the records comes from signmodif table
		    if(signatureCO.getOrigin().equals("1"))
		    {
			S_SIGN_MODIFVO signModifVO = new S_SIGN_MODIFVO();
			setSSignModifPKKeys(signatureCO, signModifVO);
			signModifVO.setTO_BE_STATUS("D");
			signModifVO.setTO_BE_DELETED_BY(signatureCO.getUserId());
			signModifVO.setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
			signModifVO.setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
			genericDAO.update(signModifVO);
		    }
		    else
		    {// ORIGIN ==2
//			signatureCO.getCifObjectVO().setSTATUS("D");
//			if(signatureCO.isAutoApprove())
//			{
//			    signatureCO.getCifObjectVO().setDATE_DELETED(signatureCO.getRunningDate());
//			    signatureCO.getCifObjectVO().setDELETED_BY(signatureCO.getUserId());
//			    updateCIFObject(signatureCO);
//			}
			
			
			   if(signatureCO.isAutoApprove())
			    {
			       signatureCO.getCifObjectVO().setSTATUS("D");
			    }
			    else
			    {
				signatureCO.getCifObjectVO().setTO_BE_STATUS("D");
			    }
			    signatureCO.getCifObjectVO().setDATE_DELETED(signatureCO.getRunningDate());
			    signatureCO.getCifObjectVO().setDELETED_BY(signatureCO.getUserId());
			    updateCIFObject(signatureCO);
			   
//			else
//			{
//			    SignatureCO obsoleteSignatureCO = signatureDAO.populateSignatureCO(signatureCO);
//			    // TODO replace it with signatureCO.getRunningDate() 
//			    if (obsoleteSignatureCO != null)
//			    {
//
//				    obsoleteSignatureCO.getCifObjectVO().setDATE_CREATED(retrieveSystemDate());
//				    // populate signatureCO data from DB.
//				    insertSignTempCreation(obsoleteSignatureCO);
//			    }
//			}
		    }
		}
	    }
	    updateSignAudit(signatureCOParam, null, SignatureConstant.SIGN002D, AuditConstant.DELETE);
	}

	return signatureCOParam;
    }   
 
    public SignatureCO approveSignatures(List<SignatureCO> signatureCOList, SignatureCO signatureCOParam)throws BaseException{
     	boolean isSignModeZero		=	isSignModeZero() ;
     	Date sysDate  = retrieveSystemDate();
    	callAlertTable(signatureCOParam);
    	for (SignatureCO signatureCO : signatureCOList) {
    		if(isSignModeZero){
    			if("D".equals(signatureCO.getCifObjectVO().getTO_BE_STATUS())){
    				signatureCO.getCifObjectVO().setSTATUS("D");
    				signatureCO.getCifObjectVO().setTO_BE_STATUS("");   
    				signatureCO.getCifObjectVO().setDATE_DELETED(sysDate);
    			}
    			else{
    				signatureCO.getCifObjectVO().setSTATUS("P");
    				signatureCO.getCifObjectVO().setTO_BE_STATUS("");
    			}
    			signatureCO.getCifObjectVO().setDATE_AUTHORISED(sysDate);			
    			updateCIFObject(signatureCO);    		
    		}
    		else{//SIGN_MODE==1
    			//Retrieving values from S_SIGN_MODIF AND SIGN ANN TEMP table to insert/update to CIFOBJECT related tables    
    			signatureCO.setFetchImg(true);//flag to fetch byte array of image also 
    			SignatureCO signCOModif = signatureDAO.selectSignatureDetails(signatureCO);  
    			signCOModif.getCifObjectVO().setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
    			signCOModif.getCifObjectVO().setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
    		  
    			
    			if("D".equals(signatureCO.getCifObjectVO().getTO_BE_STATUS())){
    				signatureCO.getCifObjectVO().setSTATUS("D");
    				signatureCO.getCifObjectVO().setTO_BE_STATUS("");    	
    				signatureCO.getCifObjectVO().setDATE_AUTHORISED(sysDate);			
    	    			updateCIFObject(signatureCO);  
    			}
    			else{
    				signatureCO.getCifObjectVO().setSTATUS("P");
    				signatureCO.getCifObjectVO().setTO_BE_STATUS("");
    			}
    			if ( !"D".equals(signatureCO.getCifObjectVO().getSTATUS()))
    			{
    			    
    			 //if origin code not null means there is a record in cifobject to be updated with values from s_sign_modif.
    			if(signCOModif.getOriginObjectCode()==null && signCOModif.getOriginObjectSeq() == null )
    			{
    			    	signCOModif.getCifObjectVO().setSTATUS("P");
				signCOModif.getCifObjectVO().setDATE_CREATED(sysDate);
				signCOModif.getCifObjectVO().setCREATED_BY("");//TODO
				signCOModif.getCifObjectVO().setDATE_AUTHORISED(sysDate);
				signCOModif.getCifObjectVO().setAUTHORISED_BY("");//TODO
				insertSignCreation(signCOModif);
				deleteSignModif(signatureCO);
				deleteSignAnnTemp(signatureCO);
			 
    				
    			}
    			else
    			{
    				
    			    	signatureCO.getCifObjectVO().setDATE_AUTHORISED(sysDate);    				
				signatureCO.getCifObjectVO().setOBJECT_CODE(signCOModif.getOriginObjectCode());
				signatureCO.getCifObjectVO().setOBJECT_SEQ(signCOModif.getOriginObjectSeq());
				signatureCO.getCifObjectVO().setAMOUNT(signCOModif.getCifObjectVO().getAMOUNT());
				signatureCO.getCifObjectVO().setAMOUNT_CY(signCOModif.getCifObjectVO().getAMOUNT_CY());
				signatureCO.getCifObjectVO().setGROUP_ID(signCOModif.getCifObjectVO().getGROUP_ID());
				updateCIFObject(signatureCO);
			
        			S_SCANVO scanVO =  new S_SCANVO();
        			scanVO.setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
        			scanVO.setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
        			scanVO.setANNOTATION(signCOModif.getScanVO().getANNOTATION());
        			scanVO.setEXP_DATE(signCOModif.getScanVO().getEXP_DATE());
        			scanVO.setDEFAULT_UNLIMITED(signCOModif.getScanVO().getDEFAULT_UNLIMITED());
        			scanVO.setDESCRIPTION(signCOModif.getScanVO().getDESCRIPTION());
        			scanVO.setDOC_TYPE("S");
        			signatureCO.setScanVO(scanVO);
        			updateScan(signatureCO); 
        			
        			S_SIGN_ANNVO signAnnVO   =  new S_SIGN_ANNVO(); // retrieving value from annotation table to insert/update annotation from sign modif temp table
        			setSSignAnnPKKeys(signatureCO, signAnnVO);        			 
        			signAnnVO =  (S_SIGN_ANNVO)genericDAO.selectByPK(signAnnVO);   
        			
        			if(signCOModif.getSignatureAnnotationVO()!=null){//no notes present in the temp table itself
                			if(signAnnVO==null){//no notes present for the signature 
                				signAnnVO = new S_SIGN_ANNVO();
                				setSSignAnnPKKeys(signatureCO, signAnnVO);
                				signAnnVO.setANNOTATION(signCOModif.getSignatureAnnotationVO().getANNOTATION());
                				signAnnVO.setOBJECT_CODE(signCOModif.getOriginObjectCode());        				
                				genericDAO.insert(signAnnVO);
                			}
                			else{// notes are available
                				signAnnVO.setANNOTATION(signCOModif.getSignatureAnnotationVO().getANNOTATION());
                				genericDAO.update(signAnnVO);
                				
                			}  
        			}
        			deleteSignModif(signCOModif);
        			deleteSignAnnTemp(signCOModif);
    			}

    			}
    		}
    	}   	
    	return signatureCOParam;
    }
    
    
    public SignatureCO rejectSignatures(List<SignatureCO> signatureCOList, SignatureCO signatureCOParam)throws BaseException{
    	boolean isSignModeZero		=	isSignModeZero() ;
    	callAlertTable(signatureCOParam);  	
    	for (SignatureCO signatureCO : signatureCOList) {
    		if(isSignModeZero){    		 
    			signatureCO.getCifObjectVO().setTO_BE_STATUS("");    			 
    			signatureCO.getCifObjectVO().setDATE_AUTHORISED(retrieveSystemDate());
				signatureCO.getCifObjectVO().setAUTHORISED_BY(signatureCO.getUserId());				
    			updateCIFObject(signatureCO);    
    		}
    		else{
    			deleteSignModif(signatureCO);
    			deleteSignAnnTemp(signatureCO);
    		}
    	}
    	return signatureCOParam;
    }
    
  
    private void deleteSignModif(SignatureCO signatureCO)throws BaseException{
    	S_SIGN_MODIFVO signModifVO  =  new S_SIGN_MODIFVO();
    	setSSignModifPKKeys(signatureCO, signModifVO);    	
    	genericDAO.delete(signModifVO);
    	
    	
    }
    
    private void deleteSignAnnTemp(SignatureCO signatureCO)throws BaseException{
    	S_SIGN_ANN_TEMPVO  signAnnTempVO  = new S_SIGN_ANN_TEMPVO();
    	setSSignAnnTempPKKeys(signatureCO, signAnnTempVO);
    	genericDAO.delete(signAnnTempVO);
    }
    

    // uo_allsignatures.ue_post_open
/*    public ArrayList<SignatureCO> returnallSignatures(SignatureSC signatureSC) throws BaseException
    {
	checkPthCtrlValues(signatureSC);
	String applyFilter;
	ArrayList<SignatureCO> sigCO;
	String isCIF = SignatureConstant.IS_CIF;
	ArrayList<LIMIT_SCHEMAVO> limitSchemaVO;
	String groupID = signatureSC.getGroupID();
	String enforceSign;
	int i, j;
	BigDecimal amount;
	
	if (signatureSC.getSignatureTp().equals(isCIF))
	{
	    signatureSC.setApplyFilter("0");
	    limitSchemaVO = signatureDAO.returnLimitSchemaList(signatureSC);
	    
	    if (limitSchemaVO.size() > 0)
	    {
		enforceSign = "1";
	    }
	    else
	    {
		enforceSign = "0";
	    }
	    
	    signatureSC.setEnforceSign(enforceSign);
	}
	else
	{
	    //TODO: check if we can add enforce_sign_limit from AMF
	    //to original query of the calling screen instead of 
	    //querying the AMF here.
	    //now it's assumed it's retrieved and passed in SC
	    // instead of calling below query
	    //SELECT ENFORCE_SIGN_LIMIT
	    //INTO :is_enforce_sign
	    //FROM AMF
	    //WHERE COMP_CODE     = :GV_COMPANY_CODE
	    //AND	BRANCH_CODE   = :istr_sign.branch
	    //AND	CURRENCY_CODE = :istr_sign.CURRENCY
	    //AND	GL_CODE       = :istr_sign.GL
	    //AND	CIF_SUB_NO    = :istr_sign.CIF
	    //AND	SL_NO         = :istr_sign.SL
	    
	    enforceSign = signatureSC.getEnforceSign();
	}
	
	if (signatureSC.getValidateFlag().equals("Y"))
	{
	    if (signatureSC.getFilterSign().equals("0"))
	    {
		applyFilter = "0";
	    }
	    else
	    {
		if (signatureSC.getAppName().equals("TRS"))
		{
		    applyFilter = "1";
		}
		else
		{
		    applyFilter = "0";
		}
	    }
	}
	else
	{
	    applyFilter = "0";
	}
	
	sigCO = signatureDAO.returnAllSignaturesList(signatureSC);

	if (signatureSC.getAppName().equals("TRS"))
	{
	    if (((signatureSC.getSignatureTp().equals("C") && enforceSign.equals("0")) 
		    || (!signatureSC.getSignatureTp().equals("C") && enforceSign == null && !enforceSign.equals("1")))
		&& (signatureSC.getGroupID() != null && !signatureSC.getGroupID().trim().equals("")))
	    {
		for (i = 0; i < sigCO.size(); i++)
		{
		    if (sigCO.get(i).getCifObjectVO().getGROUP_ID().equals(groupID))
		    {
			//sigCO.get(i).setChecked(1);
		    }
		}
	    }
	}
	
	if (applyFilter.equals("1"))
	{
	    if (enforceSign.equals("1"))
	    {
		signatureSC.setApplyFilter(applyFilter);
		limitSchemaVO = signatureDAO.returnLimitSchemaList(signatureSC);
		for (i = 0; i < sigCO.size(); i++)
		{
		    groupID = sigCO.get(i).getCifObjectVO().getGROUP_ID();
		    
		    if (!groupID.trim().equals("") || groupID != null)
		    {
			for (j = 0; j < limitSchemaVO.size(); j++)
			{
			    if(limitSchemaVO.get(i).getGROUP1().equals(groupID)
				    || limitSchemaVO.get(i).getGROUP2().equals(groupID)
				    || limitSchemaVO.get(i).getGROUP3().equals(groupID)
				    || limitSchemaVO.get(i).getGROUP4().equals(groupID)
				    || limitSchemaVO.get(i).getGROUP5().equals(groupID)
				    || limitSchemaVO.get(i).getGROUP6().equals(groupID)
				    || limitSchemaVO.get(i).getGROUP7().equals(groupID)
				    || limitSchemaVO.get(i).getGROUP8().equals(groupID)
				    || limitSchemaVO.get(i).getGROUP9().equals(groupID)
				    || limitSchemaVO.get(i).getGROUP10().equals(groupID))
			    {
				sigCO.remove(i);
				i--;
				break;
			    }
			}	
		    }
		    else
		    {
			sigCO.remove(i);
			i--;
		    }
		}
	    }
	    else
	    {
		for (i = 0; i < sigCO.size(); i++)
		{
		    amount = sigCO.get(i).getCifObjectVO().getAMOUNT();
		    if (!amount.equals(0) && amount.compareTo(signatureSC.getAmount()) == -1)
		    {
			sigCO.remove(i);
			i--;
		    }
		}
	    }
	}
	
	return sigCO;
    }
    */


    
    /**
     * Retrieves the signature form data
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO retrieveSignatureFormData(SignatureCO signatureCO)throws BaseException{
    	return signatureDAO.retrieveSignatureFormData(signatureCO);
    }

	@Override
	public List<SignatureCO> retrieveAllSignaturesForCIF(SignatureCO signatureCO) throws BaseException {
		return signatureDAO.retrieveAllSignaturesForCIF(signatureCO);
		
	}
	
	@Override
	public List<SignatureCO> retrieveAllSignaturesForAcc(SignatureCO signatureCO) throws BaseException {
		return signatureDAO.retrieveAllSignaturesForAcc(signatureCO);
		
	}

    //=======================================================================================================================================
    /****
     * Method for selecting signatures based on the access privilege. 
     * SIGN001  - VIEW ALL SIGNATURES -- (VIEW ONLY) ALL APPROVED SIGNATURES WILL BE SHOWN WITH "DETAILS" LINK AS ACTION TYPE
     * SIGN002  - MANAGE SIGNATURES	  --  VIEW + ANY OF THE BELOW 	
     * SIGN002R - EDIT SIGNATURE	  --  VIEW + EDIT SIGNATURE
     * SIGN002C - CHANGE AMOUNT		  --  VIEW + CHANGE AMOUNT
     * SIGN002P - APPROVE SIGNATURE   --  ??
     * SIGN002D - DELETE SIGNATURE    --  ??
     * 
     * 
     */
    public List<SignatureCO> selectSignatureList(SignatureSC signatureSC)throws BaseException{
    	
    	
    	generateActionTypeBasedOnPrivileges(signatureSC);
    	/*if(signatureSC.getDetails() == null && signatureSC.getEdit() == null && signatureSC.getChangeAmount() == null)
    		throw new BOException(MessageCodes.NO_ACCESS); */
    	signatureSC.setPreferredLanguage("L");//TODO Assess the PB code and apply those before selecting the records
    	//signatureSC.setFilterSign("1");
    	PTH_CTRLVO pthCtrlVO = commonLibBO.returnPthCtrl();
    	signatureSC.setSignMode(pthCtrlVO.getSIGN_MODE());
    	if("Y".equals(signatureSC.getValidateFlag()))
    	{
    	    if("0".equals(pthCtrlVO.getFILTER_SIGN()))
    	    {
    		signatureSC.setFilterSign("0");
    	    }
    	    else
    	    {
    		if(SignatureConstant.TRS_PROGRAM.equals(signatureSC.getProgram()))
    		{
    		    signatureSC.setFilterSign("1");
    		}
    		else
    		{
    		    signatureSC.setFilterSign("0");
    		}
    	    }
    	}
    	else
    	{
    	    signatureSC.setFilterSign("0");
    	}
    	
    	//EWBI160037 --[John Massaad] -- fill line numbers
    	List <SignatureCO> signList = signatureDAO.selectSignatureList(signatureSC);
    	
    	BigDecimal lineNo = BigDecimal.ONE;
    	
    	if(signList != null && signList.size() > 0)
	{
	    for(int i = 0; i < signList.size(); i++)
	    {
		signList.get(i).setLineNo(lineNo);
		
		lineNo = lineNo.add(BigDecimal.ONE);
	    }
	}
    	return signList;
    	//End Hala
    }
    /**
     * Return signature count
     * @param signatureSC
     * @return
     * @throws BaseException
     */
    
    public Integer selectSignatureListCount(SignatureSC signatureSC)throws BaseException{
	
	PTH_CTRLVO pthCtrlVO = commonLibBO.returnPthCtrl();
	if("Y".equals(signatureSC.getValidateFlag()))
    	{
    	    if("0".equals(pthCtrlVO.getFILTER_SIGN()))
    	    {
    		signatureSC.setFilterSign("0");
    	    }
    	    else
    	    {
    		if(SignatureConstant.TRS_PROGRAM.equals(signatureSC.getProgram()))
    		{
    		    signatureSC.setFilterSign("1");
    		}
    		else
    		{
    		    signatureSC.setFilterSign("0");
    		}
    	    }
    	}
    	else
    	{
    	    signatureSC.setFilterSign("0");
    	}
    	return signatureDAO.selectSignatureListCount(signatureSC);
    }
    
    public List<SignatureCO> selectCopySignatureList(SignatureSC signatureSC)throws BaseException{
    	signatureSC.setSignMode(commonLibBO.returnPthCtrl().getSIGN_MODE());    	
    	return signatureDAO.selectSignatureList(signatureSC);
    }
    
    
    
    
    
    public ArrayList<String> getSignaturePrivilegeList(SignatureSC signatureSC)throws BaseException{
    	return signatureDAO.returnSignatureProgReferences(signatureSC);
    }
    
    public ArrayList<String> getDocumentPrivilegeList(SignatureSC signatureSC)throws BaseException{
    	return signatureDAO.returnDocumentProgReferences(signatureSC);
    }
    
    
    public ArrayList<String> getPhotoPrivilegeList(SignatureSC signatureSC)throws BaseException{
    	return signatureDAO.returnPhotoProgReferences(signatureSC);
    }
    
    

    /****
     * Method for checking the privilege for user user to view, edit,change signature list
     * @param signatureSC
     * @throws BaseException
     * @throws BOException
     */   
    
	public SignatureSC generateActionTypeBasedOnPrivileges(SignatureSC signatureSC)throws BaseException {
		
		ArrayList<String> privilegesToCheck		=	new ArrayList<String>();
    	privilegesToCheck.add(SignatureConstant.SIGN001);
    	privilegesToCheck.add(SignatureConstant.SIGN002);
    	privilegesToCheck.add(SignatureConstant.SIGN002R);
    	privilegesToCheck.add(SignatureConstant.SIGN002C);
    	signatureSC.setPrivilegesToCheck(privilegesToCheck);
    	
    	CommonLibSC commonLibSC = new CommonLibSC();
        commonLibSC.setPrivilegesToCheck(privilegesToCheck);
        commonLibSC.setCompCode(signatureSC.getCompCode());
        commonLibSC.setBranchCode(signatureSC.getBranchCode());
        commonLibSC.setUserId(signatureSC.getUserId());
        commonLibSC.setAppName(signatureSC.getAppName());
      //  ArrayList<String> privilegesAllocated 	=  (ArrayList<String>) commonLibBO.checkAccessPrivilegeForUser(commonLibSC);
    	
        /*
    	if(privilegesAllocated.contains(SignatureConstant.SIGN002)){//Manage Signature
    			//signatureSC.setDetails("Details");
    		if(privilegesAllocated.contains(SignatureConstant.SIGN002R)){// Edit
    			//signatureSC.setEdit("Edit");
    		}
    		if(privilegesAllocated.contains(SignatureConstant.SIGN002C)){//Change Amount
    			//signatureSC.setChangeAmount("ChangeAmount");
    		}
    	}
    	else if(privilegesAllocated.contains(SignatureConstant.SIGN001)){//View
    			//signatureSC.setDetails("Details");
    	}
    	*/
    	return signatureSC;
	}
    
    /****
     * Select the signature details for a specific signature
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO selectSignatureDetails(SignatureCO signatureCOP) throws BaseException
    {

	SignatureCO signatureCO = signatureDAO.selectSignatureDetails(signatureCOP);
	signatureCO
		.setUnlimitedFlag(BigDecimal.ONE.compareTo(signatureCO.getScanVO().getDEFAULT_UNLIMITED()) == 0 ? true
			: false);

	return signatureCO;
    }
	
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO selectDocumentDetails(SignatureCO signatureCOP) throws BaseException
    {
	 
	return signatureDAO.selectDocumentDetails(signatureCOP);
    }
	
	
	
	/****
	 * Method for getting the signature image for a specific account
	 */
	public byte[] selectSignatureImage(SignatureCO signatureCOParam) throws BaseException
	{		
	    SignatureCO signatureCO = signatureCOParam;
	    if(null == signatureCO)
	    {
		return null;
	    }
		 if(SignatureConstant.SIGN_MODIF_ORIGIN.equals(signatureCO.getOrigin()))
		 {//sign mode==1
		     if(signatureCO.getOriginObjectCode() == null)
		     {
			 signatureCO = signatureDAO.selectSignatureImageFromSignModif(signatureCO);
			 return (null==signatureCO)?null:signatureCO.getOleObject();
		     }
		     else
		     {
			 //the original record was created in cifobject table
			 signatureCO.getCifObjectVO().setOBJECT_CODE(signatureCO.getOriginObjectCode());//setting original code to fetch the image
			 signatureCO = signatureDAO.selectSignatureImageFromSObject(signatureCO);
			 return (null==signatureCO)?null:signatureCO.getOleObject();			 
		     }
		 }
		 else
		 {//sign mode==2
		     signatureCO = signatureDAO.selectSignatureImageFromSObject(signatureCO);
		     return (null==signatureCO)?null:signatureCO.getOleObject();
		 }
	 
	}
	
	public byte[] selectDocumentImage(SignatureCO signatureCO) throws BaseException{
		 return signatureDAO.selectSignatureImageFromSObject(signatureCO).getOleObject();
	}


    public SignatureCO callAlertTable(SignatureCO signatureCO) throws BaseException
    {
	if(FomConstant.FOM_SCREEN_NAME.equals(signatureCO.getScreenName()))
	{
	    //Hasan EWBI160091 17/06/2016
	    CifSC criteria = new CifSC();
	    criteria.setCompCode(signatureCO.getCifObjectVO().getCOMP_CODE());
	    criteria.setCif_no(signatureCO.getCifObjectVO().getCIF_NO());
	    criteria.setSectionKey(signatureCO.getOpt());
	    criteria.setCurrAppName("RET");
	    BigDecimal compCode = signatureCO.getCifObjectVO().getCOMP_CODE();
	    int cpt = coreCommonServiceBO.checkNegativeComp(criteria);
	    if(cpt == 1)
	    {
		compCode = compCode.negate();
	    }
	    // End Hasan
	    CIFVO cifVO = new CIFVO();
	    cifVO.setCIF_NO(signatureCO.getCifObjectVO().getCIF_NO());
	    cifVO.setCOMP_CODE(compCode);//Hasan EWBI160091 17/06/2016
	    cifVO.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(signatureCO.getRunningDate()));
	    cifVO.setSTATUS(signatureCO.getCifStatus());
	    // Falha IDB190066 - CIF Status Changed to Inactive When Updating
	    // Signature Details
	    if(signatureCO.getAuditRefCO() != null)
	    {
		cifVO.setMODIFIED_BY(signatureCO.getAuditRefCO().getUserID());
	    }
	    else
	    {
		cifVO.setMODIFIED_BY(signatureCO.getTraceUserId());
	    }
	    cifVO.setDATE_MODIFIED(commonLibBO.addSystemTimeToDate(signatureCO.getRunningDate()));
	    // Falha IDB190066 - CIF Status Changed to Inactive When Updating
	    // Signature Details
	    signatureCO.setCifVO(coreCommonServiceBO.updateMainCifData(cifVO, signatureCO.getUpdateDate()));
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS",Locale.ENGLISH);
	    signatureCO.setLatestupdateDate(df.format(signatureCO.getCifVO().getDATE_UPDATED()));
	    
	    // Hasan EWBI160091 17/06/2016
	    CifSC cifSC = new CifSC();
	    cifSC.setCompCode(signatureCO.getCifObjectVO().getCOMP_CODE());
	    cifSC.setCif_no(signatureCO.getCifObjectVO().getCIF_NO());
	    cifSC.setCifAlertStatus(FomConstant.CIF_ALERT_STATUS_S);
	    cifSC.setFlag(null);
	    cifSC = coreCommonServiceBO.callCifUpdate(cifSC);
	    if(cifSC != null && !NumberUtil.isEmptyDecimal(cifSC.getCompCodeCif()))
	    {
		signatureCO.setCompCodeCif(cifSC.getCompCodeCif());
	    }
	    
	}
	return signatureCO;
    }
	/****
	 * Method for adding new signature for a specific CIF/Account
	 * @param signatureCO
	 * @return
	 * @throws BaseException
	 */
	
    public SignatureCO addSignatureDetails(SignatureCO signatureCO) throws BaseException
    {
	callAlertTable(signatureCO);
	setSignatureCOInsertProperties(signatureCO);
	if(isSignModeZero() || signatureCO.isAutoApprove())
	{
	    insertSignCreation(signatureCO);
	}
	else
	{	 						
	    /*
	      if(signatureCO.isAutoApprove())
	      {
	      	//TODO check auto approval flag details/also check whether auto approve condition can be added as or condition in the above if insertSignCreation(signatureCO); 
	      }
	      else{
	     */				 
	    insertSignTempCreation(signatureCO);  
	    // }			
	}
  if(!("1").equals(StringUtil.nullToEmpty(signatureCO.getFromCopySignature())))
  {
	//  insert audit #573892-EWB170023-Modification CIF: Manque l audit de l utilisateur modificateur
	auditBO.callAudit(null, signatureCO.getCifObjectVO(), signatureCO.getAuditRefCO());
	// #573892
	updateSignAudit(signatureCO, null, SignatureConstant.SIGN002A, AuditConstant.CREATED);
  }
	return signatureCO;
    }
	
	
	private void setSignatureCOInsertProperties(SignatureCO signatureCO)throws BaseException{	 
		signatureCO.getCifObjectVO().setDATE_CREATED(retrieveSystemDate());
		setSignatureCOApprovalProperties(signatureCO);
	}

	private void setSignatureCOUpdateProperties(SignatureCO signatureCO)throws BaseException{	 
		signatureCO.getCifObjectVO().setDATE_MODIFIED(retrieveSystemDate());	
		signatureCO.getCifObjectVO().setDATE_CREATED(retrieveSystemDate());//this is required to set the value of TO_BE_CREATED in SIGN_MODIF
		setSignatureCOApprovalProperties(signatureCO);
	}
	
	private void setSignatureCOApprovalProperties(SignatureCO signatureCO) {
		if(signatureCO.isAutoApprove()){
			signatureCO.getCifObjectVO().setSTATUS("P");
			signatureCO.getCifObjectVO().setAUTHORISED_BY(signatureCO.getUserId());
			signatureCO.getCifObjectVO().setDATE_AUTHORISED(signatureCO.getRunningDate());			
		}
		else{
			signatureCO.getCifObjectVO().setSTATUS("A");			
		}
	}
	

	private void insertSignTempCreation(SignatureCO signatureCO)
			throws BaseException {
		signatureCO.setOriginObjectCode(signatureCO.getCifObjectVO().getOBJECT_CODE());
		signatureCO.setOriginObjectSeq(signatureCO.getCifObjectVO().getOBJECT_SEQ());
		signatureCO.getCifObjectVO().setOBJECT_CODE(getMaxCounter(signatureCO,SignatureConstant.TRX_TYPE_901));
		signatureCO.getCifObjectVO().setOBJECT_SEQ( getMaxObjSeqForSignModif(signatureCO));
		insertSSignModif(signatureCO);
		insertSSignAnnTemp(signatureCO);
	}

	private void insertSignCreation(SignatureCO signatureCO)
			throws BaseException {
		signatureCO.getCifObjectVO().setACC_CY(NumberUtil.nullEmptyToValue(signatureCO.getCifObjectVO().getACC_CY(), BigDecimal.ZERO));
		signatureCO.getCifObjectVO().setACC_GL(NumberUtil.nullEmptyToValue(signatureCO.getCifObjectVO().getACC_GL(), BigDecimal.ZERO));
		signatureCO.getCifObjectVO().setACC_SL(NumberUtil.nullEmptyToValue(signatureCO.getCifObjectVO().getACC_SL(), BigDecimal.ZERO));
		
	    	signatureCO.getCifObjectVO().setOBJECT_CODE(getMaxCounter(signatureCO,SignatureConstant.TRX_TYPE_900));
		signatureCO.getCifObjectVO().setOBJECT_SEQ(getMaxObjSeqCIFObject(signatureCO));
		insertScanObject(signatureCO);
		insertCIFObject(signatureCO);
		insertSignAnnotation(signatureCO);
		insertScan(signatureCO);
		insertScanObject(signatureCO);
	}
	
 
	
	public SignatureCO updateSignatureDetails(SignatureCO signatureCO)throws BaseException{	 
	    	callAlertTable(signatureCO);
		setSignatureCOUpdateProperties(signatureCO);
		if(isSignModeZero()){//SIGN_MODE == 0						
			updateCIFObject(signatureCO);
			updateSignAnnotation(signatureCO);
			//Abdo TP332909 02/10/2015
//			updateScan(signatureCO);
			signatureCO.getScanVO().setCODE(signatureCO.getCifObjectVO().getOBJECT_CODE());
			signatureDAO.updateSScan(signatureCO.getScanVO());
			//End Abdo
			
			//EWBI160037 -- [John Massaad]
			 //check if the flag View Authorized Signatories Signatures is checked
			 CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
			 ctsControlVO.setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
			 ctsControlVO.setBRANCH_CODE(signatureCO.getLoginBraCode());
				
			 ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);
			  
			if(ctsControlVO !=null && "1".equals(ctsControlVO.getVIEW_AUTHORIZED_SIGNATORY_YN()))
			{
			    
			    //check if the authorized signatory signature exists in other main CIFs
			    if(FomConstant.FOM_SCREEN_NAME.equals(signatureCO.getScreenName()))
		           {
				
				ArrayList<SignatureCO> signatureCOList	= (ArrayList<SignatureCO>) signatureDAO.checkAuthSignsInOriginalCIF(signatureCO);
				
				if(!signatureCOList.isEmpty())
				{
				    //Update CIFOBJECT fields (UPDATABLE COLUMNS) in all authorized signatures attached to original CIFs
				    for(int i = 0; i < signatureCOList.size(); i++)
				    {
				      CIFOBJECTVO authSignsInOriginalCIF = signatureCOList.get(i).getCifObjectVO();
				      
				      CIFOBJECTVO originalSigns = new CIFOBJECTVO();
				      //PK
				      originalSigns.setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
				      originalSigns.setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
				      originalSigns.setACC_CY(signatureCO.getCifObjectVO().getACC_CY());
				      originalSigns.setACC_GL(signatureCO.getCifObjectVO().getACC_GL());
				      originalSigns.setCIF_NO(authSignsInOriginalCIF.getCIF_NO());
				      originalSigns.setACC_CIF(authSignsInOriginalCIF.getACC_CIF());
				      originalSigns.setACC_SL(signatureCO.getCifObjectVO().getACC_SL());
				      originalSigns.setOBJECT_CODE(signatureCO.getCifObjectVO().getOBJECT_CODE());
//				     
				      //PK
				      //UPDATABLE COLUMNS
				      originalSigns.setAMOUNT(signatureCO.getCifObjectVO().getAMOUNT());
				      originalSigns.setAMOUNT_CY(signatureCO.getCifObjectVO().getAMOUNT_CY());
				      originalSigns.setGROUP_ID(signatureCO.getCifObjectVO().getGROUP_ID());
				      originalSigns.setDEFAULT_PHOTO(signatureCO.getCifObjectVO().getDEFAULT_PHOTO());
				      originalSigns.setTYPE(signatureCO.getCifObjectVO().getTYPE());
				      //UPDATABLE COLUMNS
				      
				      signatureDAO.updateAuthorizedSignsInOrgCIF(originalSigns);
				      
				      
				    
				    }
				}
				
				
		           }
			}
			//EWBI160037 -- [John Massaad]
			
		}
		else{//SIGN_MODE ==1	
			if(signatureCO.getOrigin().equals("1")){//the record is from temp table(S_SIGN_MODIF)
				 
				//Abdo TP 09/10/2015
					//updateSignModif(signatureCO);
					signatureDAO.updateSSignModif(buildSSignModifObject(signatureCO));
					//End Abdo
				 
				 updateSSignAnnTemp(signatureCO);
			}
			else{//the record is from creation related table(CIFObject)
			  if(signatureCO.isAutoApprove()){
				  updateCIFObject(signatureCO);
				  updateSignAnnotation(signatureCO);
				//Abdo TP332909 02/10/2015
//					updateScan(signatureCO);
					signatureCO.getScanVO().setCODE(signatureCO.getCifObjectVO().getOBJECT_CODE());
					signatureDAO.updateSScan(signatureCO.getScanVO());
					//End Abdo
			  }
			  else{// the record from creation table should be moved to temp tables since the sign mode is 1
				  signatureCO.setOriginObjectCode(signatureCO.getCifObjectVO().getOBJECT_CODE());
				  signatureCO.setOriginObjectSeq(signatureCO.getCifObjectVO().getOBJECT_SEQ());
				  signatureCO.getCifObjectVO().setOBJECT_SEQ(getMaxObjSeqForSignModif(signatureCO));
				  signatureCO.getCifObjectVO().setOBJECT_CODE(getMaxCounter(signatureCO,SignatureConstant.TRX_TYPE_901));
				  insertSSignModif(signatureCO);
				  insertSSignAnnTemp(signatureCO);
			  }
			  
			}
			
			
			
			
/*			if(signatureCO.isAutoApprove()){
			 
				insertCIFObject(signatureCO.getCifObjectVO(),objectCode,objectSequence);
				insertSignAnnotation(signatureCO);  
				insertScan(signatureCO);
				insertScanObject(signatureCO);
			}
			else{
				objectCode =getMaxCounter(signatureCO,SignatureConstant.TRX_TYPE_901);
				insertScanObject(signatureCO);
				insertSSignModif(signatureCO);
				insertSignAnnotation(signatureCO);  
			}
			*/
			
			
		}
		
		//  UPDATE #573892-EWB170023-Modification CIF: Manque l audit de l utilisateur modificateur
		SignatureCO oldsignatureCO = (SignatureCO) signatureCO.getAuditObj();
		if(null != oldsignatureCO.getCifObjectVO() && null != signatureCO.getCifObjectVO()  )
		{
		auditBO.callAudit(oldsignatureCO.getCifObjectVO(), signatureCO.getCifObjectVO(), signatureCO.getAuditRefCO());
		}
		if(null != oldsignatureCO.getScanVO() && null != signatureCO.getScanVO()  )
		{
		auditBO.callAudit(oldsignatureCO.getScanVO(), signatureCO.getScanVO(), signatureCO.getAuditRefCO());
		}
		if(null != oldsignatureCO.getSignatureAnnotationVO() && null != signatureCO.getSignatureAnnotationVO()  )
		{
		auditBO.callAudit(oldsignatureCO.getSignatureAnnotationVO(), signatureCO.getSignatureAnnotationVO(), signatureCO.getAuditRefCO());
		}
		auditBO.insertAudit(signatureCO.getAuditRefCO());
		// #573892
		
		returnSignatureAuditChanges(signatureCO);
		return signatureCO;
	}
	
	private void returnSignatureAuditChanges(SignatureCO signatureCO) throws BaseException
	{
	    SignatureCO oldSignatureCO = (SignatureCO) signatureCO.getAuditObj();
	    if(oldSignatureCO != null)
	    {
	        if(SignatureConstant.EDIT_ALL_MODE.equals(signatureCO.getViewMode()))
	        {
	    	/*
	    	 * description
	    	 */
	    	ArrayList<S_AUDIT_ACTION_DTLVO> sAuditActionDtlVOs = new ArrayList<S_AUDIT_ACTION_DTLVO>();
	    	String oldDescription = StringUtil.nullEmptyToValue(oldSignatureCO.getScanVO().getDESCRIPTION(), null);
	    	String newDescription = StringUtil.nullEmptyToValue(signatureCO.getScanVO().getDESCRIPTION(), null);
	    	if((oldDescription != null && newDescription == null) || (oldDescription == null && newDescription != null) || 
	    		(oldDescription != null && newDescription != null && !oldDescription.equals(newDescription)))
	    	{
	    	    oldDescription = oldDescription == null ? "" : oldDescription;
	    	    newDescription = newDescription == null ? "" : newDescription;
	    	    S_AUDIT_ACTION_DTLVO sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
	    	    sAuditActionDtlVO.setFIELD_NAME("Description");
	    	    sAuditActionDtlVO.setOLD_VALUE(oldDescription);
	    	    sAuditActionDtlVO.setNEW_VALUE(newDescription);
	    	    sAuditActionDtlVOs.add(sAuditActionDtlVO);
	    	}
	    	
	    	/*
	    	 * annotation
	    	 */
	    	String oldAnnotation = StringUtil.nullEmptyToValue(oldSignatureCO.getScanVO().getANNOTATION(), null);
	    	String newAnnotation = StringUtil.nullEmptyToValue(signatureCO.getScanVO().getANNOTATION(), null);
	    	if((oldAnnotation != null && newAnnotation == null) || (oldAnnotation == null && newAnnotation != null) || 
	    		(oldAnnotation != null && newAnnotation != null && !oldAnnotation.equals(newAnnotation)))
	    	{
	    	    oldAnnotation = oldAnnotation == null ? "" : oldAnnotation;
	    	    newAnnotation = newAnnotation == null ? "" : newAnnotation;
	    	    S_AUDIT_ACTION_DTLVO sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
	    	    sAuditActionDtlVO.setFIELD_NAME("Annotation");
	    	    sAuditActionDtlVO.setOLD_VALUE(oldAnnotation);
	    	    sAuditActionDtlVO.setNEW_VALUE(newAnnotation);
	    	    sAuditActionDtlVOs.add(sAuditActionDtlVO);
	    	}
	    	
	    	/*
	    	 * EXP_DATE
	    	 */
	    	Date oldExpDate = oldSignatureCO.getScanVO().getEXP_DATE();
	    	Date newExpDate = signatureCO.getScanVO().getEXP_DATE();
	    	if((oldExpDate != null && newExpDate == null) || (oldExpDate == null && newExpDate != null) || 
	    		(oldExpDate != null && newExpDate != null && oldExpDate.compareTo(newExpDate) != 0))
	    	{
	    	    String oldExpDateStr = oldExpDate == null ? "" : oldExpDate.toString();
	    	    String newExpDateStr = newExpDate == null ? "" : newExpDate.toString();
	    	    S_AUDIT_ACTION_DTLVO sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
	    	    sAuditActionDtlVO.setFIELD_NAME("Sign-Date");
	    	    sAuditActionDtlVO.setOLD_VALUE(oldExpDateStr);
	    	    sAuditActionDtlVO.setNEW_VALUE(newExpDateStr);
	    	    sAuditActionDtlVOs.add(sAuditActionDtlVO);
	    	}
	    	
	    	/*
	    	 * EXP_DATE
	    	 */
	    	BigDecimal oldUnlimitedFlag = NumberUtil.emptyDecimalToNull(oldSignatureCO.getScanVO().getDEFAULT_UNLIMITED());
	    	BigDecimal newUnlimitedFlag = NumberUtil.emptyDecimalToNull(signatureCO.getScanVO().getDEFAULT_UNLIMITED());
	    	if((oldUnlimitedFlag != null && newUnlimitedFlag == null) || (oldUnlimitedFlag == null && newUnlimitedFlag != null) || 
	    		(oldUnlimitedFlag != null && newUnlimitedFlag != null && oldUnlimitedFlag.compareTo(newUnlimitedFlag) != 0))
	    	{
	    	    String oldUnlimitedFlagStr = oldUnlimitedFlag == null ? "" : oldUnlimitedFlag.toString();
	    	    String newUnlimitedFlagStr = newUnlimitedFlag == null ? "" : newUnlimitedFlag.toString();
	    	    S_AUDIT_ACTION_DTLVO sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
	    	    sAuditActionDtlVO.setFIELD_NAME("Unlimited");
	    	    sAuditActionDtlVO.setOLD_VALUE(oldUnlimitedFlagStr);
	    	    sAuditActionDtlVO.setNEW_VALUE(newUnlimitedFlagStr);
	    	    sAuditActionDtlVOs.add(sAuditActionDtlVO);
	    	}
	    	
	    	/*
	    	 * Group
	    	 */
	    	String oldGroup = StringUtil.nullEmptyToValue(oldSignatureCO.getCifObjectVO().getGROUP_ID(), null);
	    	String newGroup = StringUtil.nullEmptyToValue(signatureCO.getCifObjectVO().getGROUP_ID(), null);
	    	if((oldGroup != null && newGroup == null) || (oldGroup == null && newGroup != null) || 
	    		(oldGroup != null && newGroup != null && !oldGroup.equals(newGroup)))
	    	{
	    	    oldGroup = oldGroup == null ? "" : oldGroup;
	    	    newGroup = newGroup == null ? "" : newGroup;
	    	    S_AUDIT_ACTION_DTLVO sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
	    	    sAuditActionDtlVO.setFIELD_NAME("Group");
	    	    sAuditActionDtlVO.setOLD_VALUE(oldGroup);
	    	    sAuditActionDtlVO.setNEW_VALUE(newGroup);
	    	    sAuditActionDtlVOs.add(sAuditActionDtlVO);
	    	}
	    	if(sAuditActionDtlVOs.size() > 0)
	    	{
	    	    updateSignAudit(signatureCO, sAuditActionDtlVOs, SignatureConstant.SIGN002R, AuditConstant.UPDATE);
	    	}
	        }
	        else if(SignatureConstant.EDIT_CHANGE_AMOUNT_MODE.equals(signatureCO.getViewMode()))
	        {
	    	/*
	    	 * Amount
	    	 */
	    	ArrayList<S_AUDIT_ACTION_DTLVO> sAuditActionDtlVOs = new ArrayList<S_AUDIT_ACTION_DTLVO>();
	    	BigDecimal oldAmount = NumberUtil.emptyDecimalToNull(oldSignatureCO.getCifObjectVO().getAMOUNT());
	    	BigDecimal newAmount = NumberUtil.emptyDecimalToNull(signatureCO.getCifObjectVO().getAMOUNT());
	    	if((oldAmount != null && newAmount == null) || (oldAmount == null && newAmount != null) || 
	    		(oldAmount != null && newAmount != null && oldAmount.compareTo(newAmount) != 0))
	    	{
	    	    String oldAmountStr = oldAmount == null ? "" : oldAmount.toString();
	    	    String newAmountStr = newAmount == null ? "" : newAmount.toString();
	    	    S_AUDIT_ACTION_DTLVO sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
	    	    sAuditActionDtlVO.setFIELD_NAME("Amount");
	    	    sAuditActionDtlVO.setOLD_VALUE(oldAmountStr);
	    	    sAuditActionDtlVO.setNEW_VALUE(newAmountStr);
	    	    sAuditActionDtlVOs.add(sAuditActionDtlVO);
	    	}
	    	if(sAuditActionDtlVOs.size() > 0)
	    	{
	    	    updateSignAudit(signatureCO, sAuditActionDtlVOs, SignatureConstant.SIGN002C, AuditConstant.UPDATE);
	    	}
	        }

	    }
	}
	
	
	private void updateSignAnnotation(SignatureCO signatureCO)throws BaseException{
		setSignAnnotationProp(signatureCO);
		if(signatureCO.getSignatureAnnotationVO().getANNOTATION().isEmpty()){			
			signatureDAO.deleteS_SIGN_ANN(signatureCO);
		}
		else{			
			if(signatureDAO.selectCountS_SIGN_ANN(signatureCO.getSignatureAnnotationVO())==0)
			{
			    genericDAO.insert(signatureCO.getSignatureAnnotationVO());
			}
			else
			{
			    signatureDAO.updateS_SIGN_ANN(signatureCO);
			}
			
		}
		
	}
	
	 
	
	private void updateScan(SignatureCO signatureCO)throws BaseException{
		signatureCO.getScanVO().setCODE(signatureCO.getCifObjectVO().getOBJECT_CODE());	
		genericDAO.update(signatureCO.getScanVO());	
	}
	
	private void updateCIFObject(SignatureCO signatureCO)throws BaseException{
		genericDAO.update(signatureCO.getCifObjectVO());
	}
	
	
	public void copySignature(SignatureCO signatureCO,SignatureCO copyAccSignatureCO)throws BaseException{
		ArrayList<SignatureCO> copySignaturCOList  = signatureDAO.retrieveCopySignatureList(copyAccSignatureCO);
		for (SignatureCO copySignatureCO : copySignaturCOList) {
			copySignatureCO.getCifObjectVO().setACC_CIF(signatureCO.getCifObjectVO().getACC_CIF());
			copySignatureCO.getCifObjectVO().setACC_CY(signatureCO.getCifObjectVO().getACC_CY());
			copySignatureCO.getCifObjectVO().setACC_GL(signatureCO.getCifObjectVO().getACC_GL());
			copySignatureCO.getCifObjectVO().setACC_SL(signatureCO.getCifObjectVO().getACC_SL());
			copySignatureCO.getCifObjectVO().setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());//#837555 JAIZUP190181 - System not copying the existing signature

			copySignatureCO.getCifObjectVO().setOBJECT_CODE(null);
			copySignatureCO.getCifObjectVO().setOBJECT_SEQ(null);
			copySignatureCO.setFromCopySignature("1");
			copySignatureCO.setAuditRefCO(signatureCO.getAuditRefCO());
			addSignatureDetails(copySignatureCO);
		}

		
	}
	
	public ArrayList<SignatureCO> retrieveCopySignatureList(SignatureCO signatureCO) throws BaseException{
		return signatureDAO.retrieveCopySignatureList(signatureCO);
	}
	
	
	
	/**
	 * Build S_SIGN_MODIFVO object from CIFObject,Scan,signobject
	 * @param signatureCO
	 * @return
	 */
	
	private void setSSignModifPKKeys(SignatureCO signatureCO,S_SIGN_MODIFVO signModifVO){
		 signModifVO.setACC_CIF(signatureCO.getCifObjectVO().getACC_CIF());
		 signModifVO.setCIF_NO(signatureCO.getCifObjectVO().getACC_CIF());
		 signModifVO.setACC_CY(signatureCO.getCifObjectVO().getACC_CY());
		 signModifVO.setACC_GL(signatureCO.getCifObjectVO().getACC_GL());
		 signModifVO.setACC_SL(signatureCO.getCifObjectVO().getACC_SL());
		 signModifVO.setOBJECT_CODE(signatureCO.getCifObjectVO().getOBJECT_CODE());
		 signModifVO.setOBJECT_SEQ(signatureCO.getCifObjectVO().getOBJECT_SEQ());
		 signModifVO.setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
		 signModifVO.setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
	}
	
	
	private void setSSignAnnTempPKKeys(SignatureCO signatureCO,S_SIGN_ANN_TEMPVO signAnnTempVO){
		 signAnnTempVO.setCIF_SUB_NO(signatureCO.getCifObjectVO().getACC_CIF());		 
		 signAnnTempVO.setCURRENCY_CODE(signatureCO.getCifObjectVO().getACC_CY());
		 signAnnTempVO.setGL_CODE(signatureCO.getCifObjectVO().getACC_GL());
		 signAnnTempVO.setSL_NO(signatureCO.getCifObjectVO().getACC_SL());
		 signAnnTempVO.setOBJECT_CODE(signatureCO.getCifObjectVO().getOBJECT_CODE()); 
		 signAnnTempVO.setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
		 signAnnTempVO.setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
	 
	}
	
	
	private void setSSignAnnPKKeys(SignatureCO signatureCO,S_SIGN_ANNVO signAnnVO){
		 signAnnVO.setCIF_SUB_NO(signatureCO.getCifObjectVO().getACC_CIF());		 
		 signAnnVO.setCURRENCY_CODE(signatureCO.getCifObjectVO().getACC_CY());
		 signAnnVO.setGL_CODE(signatureCO.getCifObjectVO().getACC_GL());
		 signAnnVO.setSL_NO(signatureCO.getCifObjectVO().getACC_SL());
		 signAnnVO.setOBJECT_CODE(signatureCO.getCifObjectVO().getOBJECT_CODE());
		 signAnnVO.setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
		 signAnnVO.setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
	}
	
	private S_SIGN_MODIFVO buildSSignModifObject(SignatureCO signatureCO){
		 S_SIGN_MODIFVO signModifVO = new S_SIGN_MODIFVO();
		 setSSignModifPKKeys(signatureCO,signModifVO);
		 signModifVO.setTO_BE_AMOUNT(signatureCO.getCifObjectVO().getAMOUNT());
		 signModifVO.setTO_BE_AMOUNT_CY(signatureCO.getCifObjectVO().getAMOUNT_CY());
		 signModifVO.setTO_BE_GROUP_ID(signatureCO.getCifObjectVO().getGROUP_ID());
		 signModifVO.setTO_BE_DEFAULT_PHOTO(signatureCO.getCifObjectVO().getDEFAULT_PHOTO());
		 signModifVO.setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
		 signModifVO.setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
		 signModifVO.setTO_BE_DATE_CREATED(signatureCO.getCifObjectVO().getDATE_CREATED());
		 signModifVO.setTO_BE_CREATED_BY(signatureCO.getCifObjectVO().getCREATED_BY());
		 signModifVO.setTO_BE_OBJECT_TYPE(SignatureConstant.SIGNATURE);
		// signModifVO.setTO_BE_STATUS(signatureCO.getCifObjectVO().getSTATUS());		 
		 signModifVO.setTO_BE_STATUS(null);
		 signModifVO.setORIGIN_CODE(signatureCO.getOriginObjectCode());
		 signModifVO.setORIGIN_SEQ(signatureCO.getOriginObjectSeq());

		 
		 signModifVO.setTO_BE_DESCRIPTION(signatureCO.getScanVO().getDESCRIPTION());
		 signModifVO.setTO_BE_ANNOTATION(signatureCO.getScanVO().getANNOTATION());
		 signModifVO.setTO_BE_EXP_DATE(signatureCO.getScanVO().getEXP_DATE());	
		 signModifVO.setTO_BE_DEFAULT_UNLIMITED(signatureCO.getScanVO().getDEFAULT_UNLIMITED());
		 //Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
		 signModifVO.setTO_BE_SIGN_INSTRUCTIONS(signatureCO.getScanVO().getSIGN_INSTRUCTIONS());
		 signModifVO.setTO_BE_INST_OTHER_VALUE(signatureCO.getScanVO().getINST_OTHER_VALUE());
		 
		 signModifVO.setOLE_OBJECT(signatureCO.getSignObjectVO().getOLE_OBJECT());
		 signModifVO.setAUTH_CIF_NO(signatureCO.getCifObjectVO().getAUTH_CIF_NO());
		 
		 return signModifVO;
	
		
		
	}
	
	/**
	 * Insert in to sign modif
	 * @param signatureCO
	 * @throws BaseException
	 */	
	private void insertSSignModif(SignatureCO signatureCO)throws BaseException{	
		genericDAO.insert(buildSSignModifObject(signatureCO));
		 
	}
	
	private void updateSignModif(SignatureCO signatureCO)throws BaseException{
		genericDAO.update(buildSSignModifObject(signatureCO));
	}
	
	
	private S_SIGN_ANN_TEMPVO buildSSignAnnTempObject(SignatureCO signatureCO){
		S_SIGN_ANN_TEMPVO signAnnTempVO = new S_SIGN_ANN_TEMPVO();
		signAnnTempVO.setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
		signAnnTempVO.setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
		signAnnTempVO.setCURRENCY_CODE(signatureCO.getCifObjectVO().getACC_CY());
		signAnnTempVO.setCIF_SUB_NO(signatureCO.getCifObjectVO().getACC_CIF());
		signAnnTempVO.setGL_CODE(signatureCO.getCifObjectVO().getACC_GL());
		signAnnTempVO.setSL_NO(signatureCO.getCifObjectVO().getACC_SL());		
		
		signAnnTempVO.setOBJECT_CODE(signatureCO.getCifObjectVO().getOBJECT_CODE());		
		signAnnTempVO.setTO_BE_ANNOTATION(signatureCO.getSignatureAnnotationVO().getANNOTATION());
		
		return signAnnTempVO;
	}
	
	
	private void updateSSignAnnTemp(SignatureCO signatureCO)throws BaseException{
		S_SIGN_ANN_TEMPVO signAnnTempVO = buildSSignAnnTempObject(signatureCO);
		if(signatureCO.getSignatureAnnotationVO().getANNOTATION().isEmpty())
		{
		    genericDAO.delete(signAnnTempVO);
		}
		else{
			if(signatureDAO.selectCountS_SIGN_ANN_TEMP(signAnnTempVO)==0)
			{
			    genericDAO.insert(signAnnTempVO);
			}
			else
			{
			    genericDAO.update(signAnnTempVO);
			}
		}
	}
	private void insertSSignAnnTemp(SignatureCO signatureCO)throws BaseException{	
	
		if(signatureCO.getSignatureAnnotationVO()!=null&&!signatureCO.getSignatureAnnotationVO().getANNOTATION().isEmpty())
		{
			genericDAO.insert(buildSSignAnnTempObject(signatureCO));
		}
	}
	
	/**
	 * Check the SIGN mode from path control table
	 * @return
	 * @throws BaseException
	 */
	private boolean isSignModeZero()throws BaseException{
		PTH_CTRLVO pthCtrlVO		=	getPTH_CTRLVO();				
		return "0".equals(pthCtrlVO.getSIGN_MODE());
	}
	
	
	public PTH_CTRLVO getPTH_CTRLVO()throws BaseException{
		PTH_CTRLVO pthCtrlVO		=	commonLibBO.returnPthCtrl();
		if(pthCtrlVO==null)
		{
			throw new BOException("Path control entry not available");//TODO error message;
		}
		return pthCtrlVO;
	}
	
	/**
	 * Get max from Counter table
	 * @param signatureCO
	 * @return
	 * @throws BaseException
	 */
	private BigDecimal getMaxCounter(SignatureCO signatureCO,BigDecimal trxNo)throws BaseException{
		return commonLibBO.returnCOUNTER(signatureCO.getCifObjectVO().getCOMP_CODE(),signatureCO.getCifObjectVO().getBRANCH_CODE(),trxNo
			, signatureCO.getTraceAppName(), signatureCO.getTraceUserId(), signatureCO.getTraceProgRef());
	}
	
	/**
	 * Get max object seq for CIFObject
	 * @param signatureCO
	 * @return
	 * @throws BaseException
	 */
	private BigDecimal getMaxObjSeqCIFObject(SignatureCO signatureCO)throws BaseException{
		// signatureCO.setCIFObject(true);
		 Integer maxObjSeq = signatureDAO.returnMaxCifObjSeqValue(signatureCO);
		 return maxObjSeq==null?BigDecimal.ONE:new BigDecimal(maxObjSeq+1);
	}
	/**
	 * Get max object seq for Sign Modif
	 * @param signatureCO
	 * @return
	 * @throws BaseException
	 */
	private BigDecimal getMaxObjSeqForSignModif(SignatureCO signatureCO)throws BaseException{
		// signatureCO.setCIFObject(false);
		 Integer maxObjSeq = signatureDAO.returnMaxSignModifSeqValue(signatureCO);
		 return maxObjSeq==null?BigDecimal.ONE:new BigDecimal(maxObjSeq+1);	
	}

	
	private void insertCIFObject(SignatureCO signatureCO)throws BaseException{ 
		genericDAO.insert(signatureCO.getCifObjectVO());//Inserting a new record : Fill all data from JSP ,action class (userId,compCode,etc...)
	}
	
    /**
     * BUG 289283
     * update default photo to zero for the cif object different than the current one
     * @param signatureCO
     * @author tonynouh
     */
    private void updateDefaultPhoto(SignatureCO signatureCO) throws BaseException
    {
	if(!NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getOBJECT_SEQ())
		&& !NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getCOMP_CODE())
		&& !NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getBRANCH_CODE())
		&& !NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getCIF_NO())
		&& !NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getACC_CY())
		&& !NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getACC_GL())
		&& !NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getACC_SL())
		/*&& StringUtil.isNotEmpty(signatureCO.getCifObjectVO().getOBJECT_TYPE())*/)
	{
	    if(NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getDEFAULT_PHOTO()).equals(BigDecimal.ONE))
	    {
		SignatureSC signatureSC = new SignatureSC();
		signatureSC.setObjSeq(signatureCO.getCifObjectVO().getOBJECT_SEQ());
		signatureSC.setCompCode(signatureCO.getCifObjectVO().getCOMP_CODE());
		signatureSC.setBranchCode(signatureCO.getCifObjectVO().getBRANCH_CODE());
		signatureSC.setCifNo(signatureCO.getCifObjectVO().getCIF_NO());
		signatureSC.setCurrencyCode(signatureCO.getCifObjectVO().getACC_CY());
		signatureSC.setGlCode(signatureCO.getCifObjectVO().getACC_GL());
		signatureSC.setSlNo(signatureCO.getCifObjectVO().getACC_SL());
//		signatureSC.setObjType(signatureCO.getCifObjectVO().getOBJECT_TYPE());
		//since now the object type is saved as 'D' for the documents and photos
		signatureSC.setObjType("D");
		signatureDAO.updateCIFOBJECTPhoto(signatureSC);
	    }
	}
    }
 
	private void insertSignAnnotation(SignatureCO  signatureCO)throws BaseException{
		if(signatureCO.getSignatureAnnotationVO()!=null){//Inserting a new Record in General Annotation table		
			setSignAnnotationProp(signatureCO);		 
			genericDAO.insert(signatureCO.getSignatureAnnotationVO());
		}
	}

	private void setSignAnnotationProp(SignatureCO signatureCO) {
		signatureCO.getSignatureAnnotationVO().setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
		signatureCO.getSignatureAnnotationVO().setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
		signatureCO.getSignatureAnnotationVO().setCURRENCY_CODE(signatureCO.getCifObjectVO().getACC_CY());
		signatureCO.getSignatureAnnotationVO().setGL_CODE(signatureCO.getCifObjectVO().getACC_GL());
		signatureCO.getSignatureAnnotationVO().setCIF_SUB_NO(signatureCO.getCifObjectVO().getACC_CIF());
		signatureCO.getSignatureAnnotationVO().setSL_NO(signatureCO.getCifObjectVO().getACC_SL());
		signatureCO.getSignatureAnnotationVO().setOBJECT_CODE(signatureCO.getCifObjectVO().getOBJECT_CODE());
	}
	
	private void insertScan(SignatureCO signatureCO)throws BaseException{
		if(signatureCO.getScanVO()!=null){
			signatureCO.getScanVO().setCODE(signatureCO.getCifObjectVO().getOBJECT_CODE());
			/* 
			 * BUG#229118
			 * fill primary keys when inserting to the table
			 */
			if(NumberUtil.isEmptyDecimal(signatureCO.getScanVO().getCOMP_CODE()))
			{
			    signatureCO.getScanVO().setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
			}
			if(NumberUtil.isEmptyDecimal(signatureCO.getScanVO().getBRANCH_CODE()))
			{
			    signatureCO.getScanVO().setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
			}
			genericDAO.insert(signatureCO.getScanVO());//Inserting a new record : Prepare the object S_SCANVO from JSP and action class.
		}
	}
	
	private void insertScanObject(SignatureCO signatureCO)throws BaseException{
		if(signatureCO.getSignObjectVO()!=null){
			signatureCO.getSignObjectVO().setCODE(signatureCO.getCifObjectVO().getOBJECT_CODE());
			signatureCO.getSignObjectVO().setCOMP_CODE(signatureCO.getCifObjectVO().getCOMP_CODE());
			signatureCO.getSignObjectVO().setBRANCH_CODE(signatureCO.getCifObjectVO().getBRANCH_CODE());
			genericDAO.insert(signatureCO.getSignObjectVO());// Inserting the image into S_OBJECT table : Prepare the object from JSP and action class.
		}
	}
	
 

	@Override
	public ArrayList<SignatureCO> selectDocumentList(SignatureSC signatureSC)
			throws BaseException {
		return signatureDAO.selectDocumentList(signatureSC);
		
	}
	
	
	public SignatureCO addDocumentDetails(SignatureCO signatureCO)throws BaseException{	
		setSignatureCOInsertProperties(signatureCO);
	 	insertSignCreation(signatureCO);
	 	
		//update default photo
		updateDefaultPhoto(signatureCO);
		
		return signatureCO;
	}
	
	public SignatureCO updateDocumentDetails(SignatureCO signatureCO)throws BaseException{
		setSignatureCOUpdateProperties(signatureCO);	 						
		updateCIFObject(signatureCO);
		
		//update default photo
		updateDefaultPhoto(signatureCO);
		
		updateScan(signatureCO);	
		return signatureCO;
	}

	@Override
	public void deleteDocuments(List<SignatureCO> signatureCOList)
			throws BaseException {
		for (SignatureCO signatureCO : signatureCOList) {
    		setSignatureCOApprovalProperties(signatureCO);			 
			if(signatureCO.isAutoApprove())
			{
			    signatureCO.getCifObjectVO().setSTATUS("D");
			}
			else
			{
			    signatureCO.getCifObjectVO().setTO_BE_STATUS("D");
			}				
		 signatureCO.getCifObjectVO().setDATE_DELETED(signatureCO.getRunningDate());
		 signatureCO.getCifObjectVO().setDELETED_BY(signatureCO.getUserId());
		 updateCIFObject(signatureCO);
		
		}
	}
	
	public void approveDocuments(List<SignatureCO> signatureCOList)throws BaseException{		
		Date sysDate  = retrieveSystemDate();
    	for (SignatureCO signatureCO : signatureCOList) {    		 
    			if("D".equals(signatureCO.getCifObjectVO().getTO_BE_STATUS())){
    				signatureCO.getCifObjectVO().setSTATUS("D");
    				signatureCO.getCifObjectVO().setTO_BE_STATUS("");   
    				signatureCO.getCifObjectVO().setDATE_DELETED(sysDate);
    			}
    			else{
    				signatureCO.getCifObjectVO().setSTATUS("P");
    				signatureCO.getCifObjectVO().setTO_BE_STATUS("");
    			}
    			signatureCO.getCifObjectVO().setDATE_AUTHORISED(sysDate);			
    			updateCIFObject(signatureCO);    		
    		 
		
    	}
	}
	 public void rejectDocuments(List<SignatureCO> signatureCOList)throws BaseException{	     	
	    	for (SignatureCO signatureCO : signatureCOList) {	    	 		 
	    			signatureCO.getCifObjectVO().setTO_BE_STATUS("");    			 
	    			signatureCO.getCifObjectVO().setDATE_AUTHORISED(retrieveSystemDate());
					signatureCO.getCifObjectVO().setAUTHORISED_BY(signatureCO.getUserId());				
	    			updateCIFObject(signatureCO);    
	    		}
	    		 
	    }
	 
	 
	  public S_SIGN_ANNVO retrieveGeneralAnnotation(S_SIGN_ANNVO signAnnVO)throws BaseException{
		 return  (S_SIGN_ANNVO)genericDAO.selectByPK(signAnnVO);
		  
	  }
	  
	  public void saveGeneralAnnotation(S_SIGN_ANNVO signAnnVO)throws BaseException{
		  boolean isGenAnnAvailable = genericDAO.selectByPK(signAnnVO)!=null;
		  if(isGenAnnAvailable ){
			  if("".equals(signAnnVO.getANNOTATION()))
			{
			    genericDAO.delete(signAnnVO);
			}
			else
			{
			    genericDAO.update(signAnnVO);
			}
		  }
		  else{
			  genericDAO.insert(signAnnVO);
		  }
	  }
	
	  
	  public ArrayList<SignatureCO> retrieveSignatureAccounts(SignatureSC signatureSC)throws BaseException{
		 return signatureDAO.retrieveSignatureAccounts(signatureSC);
		  
	  }
	  
	  public Integer selectCifObjectCount(SignatureCO signatureCO)throws BaseException{
		  return signatureDAO.selectCifObjectCount(signatureCO);
	  }
	
	
	  
	  public CURRENCIESVO getAccCurrencyDesc(CURRENCIESVOKey key) throws BaseException{
		  return (CURRENCIESVO)genericDAO.selectByPK(key);
		  
	  }
	  
	  public String selectEnforceSignLimit(SignatureSC signatureSC)throws BaseException{
		  return signatureDAO.selectEnforceSignLimit(signatureSC);
	  }
	  
	  public void updateSignAudit(SignatureCO signatureCO, ArrayList<S_AUDIT_ACTION_DTLVO> sAuditActionDtlVOs,
		    String windowRef, String actionType) throws BaseException
	    {
		AuditRefCO auditRefCO = signatureCO.getAuditRefCO();
		boolean enableAudit = auditBO.checkAuditEnabled(auditRefCO);
		if(!enableAudit)
		{
		    return;
		}
		BigDecimal compCode = signatureCO.getCifObjectVO().getCOMP_CODE();
		BigDecimal branchCode = NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getBRANCH_CODE());
		BigDecimal currencyCode = NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getACC_CY());
		BigDecimal glCode = NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getACC_GL());
		BigDecimal cifNo = NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getACC_CIF());
		BigDecimal slNo = NumberUtil.emptyDecimalToZero(signatureCO.getCifObjectVO().getACC_SL());
		String signKey = NumberUtil.format(compCode, "0000") + NumberUtil.format(branchCode, "0000")
			+ NumberUtil.format(currencyCode, "000") + NumberUtil.format(glCode, "000000")
			+ NumberUtil.format(cifNo, "00000000") + NumberUtil.format(slNo, "000");

		S_AUDIT_ACTIONSVO sAuditActionsVO = new S_AUDIT_ACTIONSVO();
		sAuditActionsVO.setAPP_NAME(auditRefCO.getAppName());
		sAuditActionsVO.setPROG_REF(windowRef);
		sAuditActionsVO.setTRX_NBR(signKey);
		sAuditActionsVO.setACTION_DATE(commonLibBO.returnSystemDateWithTime());
		sAuditActionsVO.setACTION_TYPE(actionType);
		sAuditActionsVO.setUSER_ID(auditRefCO.getUserID());
		sAuditActionsVO.setMACHINE_ID(auditRefCO.getMachineID());
		sAuditActionsVO.setRUNNING_DATE(auditRefCO.getRunningDate());
		genericDAO.insert(sAuditActionsVO);

		if(AuditConstant.UPDATE.equals(actionType) && !SignatureConstant.SIGN001L.equals(windowRef))
		{
		    if(sAuditActionDtlVOs != null && sAuditActionDtlVOs.size() > 0)
		    {
			S_AUDIT_ACTION_DTLVO sAuditActionDtlVO;
			for(int i = 0; i < sAuditActionDtlVOs.size(); i++)
			{
			    if(sAuditActionDtlVOs.get(i).getFIELD_NAME() == null
				    || "".equals(sAuditActionDtlVOs.get(i).getFIELD_NAME().trim()))
			    {
				continue;
			    }
			    BigDecimal maxLineNo = signatureDAO.returnMaxAuditDetails(sAuditActionsVO);
			    if(maxLineNo == null || maxLineNo.compareTo(BigDecimal.ZERO) == 0)
			    {
				maxLineNo = BigDecimal.ONE;
			    }
			    else
			    {
				maxLineNo = maxLineNo.add(BigDecimal.ONE);
			    }
			    sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
			    sAuditActionDtlVO.setAPP_NAME(auditRefCO.getAppName());
			    sAuditActionDtlVO.setPROG_REF(windowRef);
			    sAuditActionDtlVO.setTRX_NUMBER(signKey);
			    sAuditActionDtlVO.setACTION_DATE(sAuditActionsVO.getACTION_DATE());
			    sAuditActionDtlVO.setLINE_NUMBER(maxLineNo);
			    sAuditActionDtlVO.setFIELD_NAME(sAuditActionDtlVOs.get(i).getFIELD_NAME());
			    sAuditActionDtlVO.setOLD_VALUE(sAuditActionDtlVOs.get(i).getOLD_VALUE());
			    sAuditActionDtlVO.setNEW_VALUE(sAuditActionDtlVOs.get(i).getNEW_VALUE());
			    sAuditActionDtlVO.setRUNNING_DATE(auditRefCO.getRunningDate());
			    genericDAO.insert(sAuditActionDtlVO);
			}
		    }
		}
	    }

	  
    /**
     * EWBI100037 -- [John Massaad] This method checks at first if the CIF_NO is
     * valid and second if the CIF_NO is an authorized CIF of the main CIF
     */
    @Override
    public SignatureCO dependencyByAuthCif(SignatureCO signatureCO) throws BaseException
    {
	if(NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getAUTH_CIF_NO()))
	{
	    signatureCO.setCifObjectVO(new CIFOBJECTVO());

	    return signatureCO;
	}
	else
	{
	    CifSC criteria = new CifSC();
	    criteria.setUserId(signatureCO.getUserId());
	    criteria.setCompCode(signatureCO.getCompCode());
	    criteria.setCif_no(signatureCO.getCifObjectVO().getAUTH_CIF_NO());
	    criteria.setRetExpIfExsits("1");
	    CIFVO cifVO = cifBO.returnCifByNo(criteria);

	    // Bug #337065
	    if(cifVO == null)
	    {
		signatureCO.setCifObjectVO(new CIFOBJECTVO());
	    }
	    else
	    {

		AuthSignatoriesSC authSignatoriesSC = new AuthSignatoriesSC();

		authSignatoriesSC.setCompCode(signatureCO.getCompCode());
		authSignatoriesSC.setCifNo(signatureCO.getCifVO().getCIF_NO());
		authSignatoriesSC.setAuthCifNo(signatureCO.getCifObjectVO().getAUTH_CIF_NO());

		if(signatureCO.getCifObjectVO().getAUTH_CIF_NO().compareTo(signatureCO.getCifVO().getCIF_NO()) != 0)
		{
		    List<AuthSignatoriesCO> authSignatoriesList = authSignatoriesBO.checkAuthorizedCIFNo(authSignatoriesSC);

		    if(authSignatoriesList.isEmpty())
		    {
			throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
		    }

		}
		if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(signatureCO.getPreferredLanguage()))
		{
		    signatureCO.setAuthCifDesc(cifVO.getSHORT_NAME_ARAB());
		}
		else
		{
		    signatureCO.setAuthCifDesc(cifVO.getSHORT_NAME_ENG());
		}

	    }

	}
	
	defaultIdByAuthSigAndInst(signatureCO);
	
	return signatureCO;
    }

    /**
     * EWBI160037 [John Massaad] Thi method retrieves the "Signature CIF
     * Description" (AuthCIFDesc) on initial load and on new events.
     */
    @Override
    public SignatureCO getSignCIFdetails(SignatureCO signatureCO) throws BaseException
    {
	CifSC cifSC = new CifSC();
	cifSC.setComp_code(signatureCO.getCifVO().getCOMP_CODE());
	cifSC.setCif_no(signatureCO.getCifVO().getCIF_NO());
	cifSC.setLang(signatureCO.getPreferredLanguage());
	CIFCO cifCO = cifBO.returnCIFinfo(cifSC);
	if(cifCO != null)
	{
	    signatureCO.setAuthCifDesc(cifCO.getSHORT_NAME());
	}
	return signatureCO;
    }

    /**
     * BI100037 -- [John Massaad]
     */
    @Override
    public SignatureCO validateCheckedSignatures(SignatureCO signatureCO) throws BaseException
    {
	if(signatureCO.getCheckedSignaturesList() != null && signatureCO.getCheckedSignaturesList().size() > 0)
	{
	    Date signExprityDate = null;
	    Date runningDate = signatureCO.getRunningDate();
	    BigDecimal lineNo = null;
	    BigDecimal defaultUnlimitedExpDate = null;
	    StringBuffer rowNumbers = new StringBuffer();

	    // Search in (denominationAmendCurrencies) Grid if you enter
	    // the same Currency code
	    for(int i = 0; i < signatureCO.getCheckedSignaturesList().size(); i++)
	    {
		signExprityDate = signatureCO.getCheckedSignaturesList().get(i).getScanVO().getEXP_DATE();
		defaultUnlimitedExpDate = signatureCO.getCheckedSignaturesList().get(i).getScanVO()
			.getDEFAULT_UNLIMITED();
		lineNo = signatureCO.getCheckedSignaturesList().get(i).getLineNo();
		if(BigDecimal.ONE.compareTo(defaultUnlimitedExpDate) != 0 && signExprityDate != null)
		{
		    if(SignatureConstant.TRS_PROGRAM.equals(signatureCO.getScreenName()))
		    {
			if(signatureCO.getValidationDate() != null
				&& signatureCO.getValidationDate().compareTo(signExprityDate) > 0)
			{
			    // concatinate the row number of expired signatures
			    rowNumbers.append(lineNo);
			    rowNumbers.append(",");
			}
		    }
		    else
		    {
			if(runningDate.compareTo(signExprityDate) > 0)
			{
			    // concatinate the row number of expired signatures
			    rowNumbers.append(lineNo);
			    rowNumbers.append(",");
			}
		    }
		}
	    }
	    int lastIndOfComma = rowNumbers.lastIndexOf(",");

	    if(lastIndOfComma != -1)
	    {
		String strExtraComma = rowNumbers.substring(lastIndOfComma);
		// remove extra comma
		if(strExtraComma.length() == 1)
		{
		    rowNumbers.deleteCharAt(lastIndOfComma);
		}

		if(StringUtil.isNotEmpty(rowNumbers.toString()))
		{
		    throw new BOException(MessageCodes.THE_SIGNATURE_IN_RECORD_PARAM_IS_EXPIRED,
			    new String[] { rowNumbers.toString() });
		}
	    }
	}

	return signatureCO;
    }
    
    public SignatureCO dependencyByIdNo(SignatureCO signatureCO) throws BaseException
    {
	// check if exist same idno
	Integer existIdNo = signatureDAO.checkIfExistIdNo(signatureCO);
	if(existIdNo > 0) {
	    throw new BOException(MessageCodes.MANDATE_IS_USED_IN_ANOTHER_ACCOUNT);
	}
	
	return signatureCO;
    }
    
  //id:1077811 Details:SBI200521 - Creating a CIF for Mandate Signature in Asaan Account falha TAR:SBI200521  
    public SignatureCO defaultIdByAuthSigAndInst(SignatureCO signatureCO) throws BaseException
    {
	
	   
	    if("M".equals(signatureCO.getScanVO().getSIGN_INSTRUCTIONS()) && !NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getAUTH_CIF_NO()))
	    {
	    CIFVO cifVO=new CIFVO();
	    cifVO.setCIF_NO(signatureCO.getCifObjectVO().getAUTH_CIF_NO());
	    cifVO.setCOMP_CODE(signatureCO.getCompCode());
	    cifVO=(CIFVO)genericDAO.selectByPK(cifVO);
	    if(cifVO!=null&&!NumberUtil.isEmptyDecimal(cifVO.getID_TYPE())&&!StringUtil.isEmptyString(cifVO.getID_NO()))
	    {
	    signatureCO.getScanVO().setID_TYPE(cifVO.getID_TYPE());
	    signatureCO.getScanVO().setID_NO(cifVO.getID_NO());
	    Integer existIdNo = signatureDAO.checkIfExistIdNo(signatureCO); 
	    
	    Integer cifExistInAccounts = signatureDAO.checkIfCifHasAccounts(signatureCO); //Rania - 1077811 - Details:SBI200521
	    
	    if(existIdNo > 0 || cifExistInAccounts > 0) {
		signatureCO.getScanVO().setID_TYPE(null);
		signatureCO.getScanVO().setID_NO(null); 
		signatureCO.setIdTypeDesc(null);
		    throw new BOException(MessageCodes.MANDATE_IS_USED_IN_ANOTHER_ACCOUNT);
		}
	    }
	    ID_TYPESVO id_TYPESVO=new ID_TYPESVO();
	    id_TYPESVO.setCODE(cifVO.getID_TYPE());
	    id_TYPESVO.setCOMP_CODE(cifVO.getCOMP_CODE());
	    id_TYPESVO=(ID_TYPESVO)genericDAO.selectByPK(id_TYPESVO);
	    signatureCO.setIdTypeDesc(id_TYPESVO.getDESC_ENG());
	    signatureCO.setIdDefaulted(true);
	    }
	    
    	    	
	    return signatureCO;
    }
   // id:1077811 Details:SBI200521 - Creating a CIF for Mandate Signature in Asaan Account falha TAR:SBI200521

    public CifBO getCifBO()
    {
        return cifBO;
    }

    public void setCifBO(CifBO cifBO)
    {
        this.cifBO = cifBO;
    }

    public AuthSignatoriesBO getAuthSignatoriesBO()
    {
        return authSignatoriesBO;
    }

    public void setAuthSignatoriesBO(AuthSignatoriesBO authSignatoriesBO)
    {
        this.authSignatoriesBO = authSignatoriesBO;
    }   
	  
}