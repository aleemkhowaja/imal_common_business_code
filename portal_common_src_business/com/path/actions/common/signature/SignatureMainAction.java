/**
 * 
 */
package com.path.actions.common.signature;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URLConnection;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.path.actions.common.scan.SignaturePadConverter;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.limitschema.LimitSchemaBO;
import com.path.bo.common.limitschema.LimitSchemaConstant;
import com.path.bo.common.signature.SignatureBO;
import com.path.bo.common.signature.SignatureConstant;
import com.path.bo.core.account.AccountsConstant;
import com.path.bo.core.common.CoreCommonBO;
import com.path.dbmaps.vo.CIFOBJECTVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.LIMIT_SCHEMAVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_OBJECTVO;
import com.path.dbmaps.vo.S_SCANVO;
import com.path.dbmaps.vo.S_SIGN_ANNVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.limitschema.LimitSchemaCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.signature.SigCapSignatureCO;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.signature.SignatureSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.rits.cloning.Cloner;
import com.path.bo.common.audit.AuditConstant;
/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Navas
 *
 * SignatureMainAction.java used to handle all action related to Signature management
 */
public class SignatureMainAction extends BaseAction
{
	private SignatureBO signatureBO;    
	private LimitSchemaBO limitSchemaBO;	 
	private SignatureSC signatureSC =  new SignatureSC();
	private SignatureCO signatureCO =  new SignatureCO();
	private S_SIGN_ANNVO genAnnotation;
	private List signGroupList = new ArrayList<SelectCO>();
	private List<SignatureCO> signatureCOList = new ArrayList<SignatureCO>();
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String fileImgPath;
	
	private String signTempFileName;
        
	//private final String signFileDir=	ServletActionContext.getServletContext().getRealPath("/")+"\\signatures\\";
	private String signFileDir=	FileUtil.getFileURLByName("repository")+File.separator+"signatures"+File.separator;
	
	
	private String tstMsg = "No Error";
	
	private ArrayList<String> privilegeList;
	
	private String secondaryId  = "";// secondary id used to reuse signatureMaint page
	
	private boolean signAvailConfirmed  ;
	private boolean copySignAvailable;
	
	private boolean docTabVisible;	
	private boolean photoTabVisible;
	private boolean limitSchemaTabVisible;
	private boolean copySignTabVisible;
	private boolean signTabVisible;
		
		
	private String signOption;
	private String signCaptStr;
	private TrxMgntCO trxMgntCO;
	private boolean initialLoad;
	private LIMIT_SCHEMAVO limitSchemaVO;
	private List<SelectCO> keySignInstructionsList = new ArrayList<SelectCO>();
	private SigCapSignatureCO sigCapSignatureCO;
	private CoreCommonBO coreCommonBO;
	
	public String  openSignatureFromAccounts(){
		try {
		 SessionCO sessionObject = returnSessionObject();		  
		 //TODO check unclaimed amount 
		if("2".equals(sessionObject.getCtsTellerVO().getVIEW_DORMANT_ACC())&&"T".equals(signatureSC.getParentPageStatus())&&"1".equals(signatureSC.getIsUnclamied())){			
				throw new BOException("1".equals(signatureSC.getIsUnclamied())?30092:1992);			
		 }
		
		signatureSC.setValidationDateStr(DateUtil.format(signatureSC.getValidationDate(),"dd/MM/yyyy"));
		
		} catch (BOException e) {
			handleException(e,"","");
			
		}
		//lstr_sign.s_type  = 'A'
		//signatureSC.setFlag("M"); TODO TO BE REPLACE WITH READONLY CHECKING
		
		
		return "signatureMainPage";
	}
 
	
	
	
	public void setSignatureBO(SignatureBO signatureBO) {
		this.signatureBO = signatureBO;
	}
	/****
	 * Method to load the popup for the signature screen
	 * @return
	 */
	public String loadSignatureTabs(){
		try{ 
			initialLoad =  true;
			String sigScreen = loadSignatureForm();
			if(SignatureConstant.SIGCAP_SIG_SCREEN.equals(sigScreen))
			{
			    return SignatureConstant.SIGCAP_SIG_SCREEN;
			}
			loadGeneralAnnotation();
			signatureSC.setValidationDateStr(DateUtil.format(signatureSC.getValidationDate(),"dd/MM/yyyy"));
		}
		catch (Exception e) {
		    handleException(e, null, null);
		    return SUCCESS;
		}
		return "signatureMainPage";
	}
	
	private void setPrivilegeProperties(){
		if(privilegeList.contains(SignatureConstant.SIGN002R)){
			signatureSC.setEdit(getText("btn.edit"));
		}
		if(privilegeList.contains(SignatureConstant.SIGN002C)){
			signatureSC.setChangeAmount(getText("Change_Amount_key"));
		}
	
		
		 
		signatureSC.setDetails(getText("View_key"));
		 
		
	}
	/**
	 * Open signature form screen based on mode specifid in signatureCO.viewMode
	 * Add -A
	 * View - V
	 * Edit change amount - EC
	 * Edit all - E
	 * 
	 */
	public String loadSignatureForm() throws BaseException {
	    	SignatureSC paramSignSC = (SignatureSC)ServletActionContext.getRequest().getAttribute("signatureSC");
	    	//Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
		 SelectSC selSC;	
		 selSC = new SelectSC(SignatureConstant.KEY_SIGN_INSTRUCTIONS_LOV_TYPE);
		 selSC.setOrderCriteria("ORDER");
		 keySignInstructionsList = returnLOV(selSC);
		 if( paramSignSC!=null)
		 {
		     signatureSC =  paramSignSC;
		 }
	 	    SessionCO sessionObject = returnSessionObject();	
	 	     	
	 	    signatureSC.setCompCode(sessionObject.getCompanyCode());
	 	    if(signatureSC.getBranchCode()==null)//if the branch code is not send from the client,setting the session branch code.
	 	    {
	 		//BUG#263205
	 		//signatureSC.setBranchCode(sessionObject.getBranchCode());
	 		signatureSC.setBranchCode(BigDecimal.ZERO);
	 	    }
	 	    signatureSC.setUserId(sessionObject.getUserName());
	 	    signatureSC.setAppName(sessionObject.getCurrentAppName());
	 	    //if the call came when opening the sign from an open event
	 	    Cloner cloner = new Cloner();
	 	    if(initialLoad){
	 		
	 		signatureSC.setViewSelectedSignMessage(returnCommonLibBO().returnTranslErrorMessage(MessageCodes.VIEW_ALL_SELECTED_SIGNATURE, sessionObject.getLanguage()));
	 		
		 	    PTH_CTRLVO pathCtrlVO  = signatureBO.getPTH_CTRLVO();
				if(pathCtrlVO==null)
				{
				    throw new BOException(MessageCodes.CANNOT_PROCEED);				
				}
		 	    signatureSC.setObjType(SignatureConstant.SIGNATURE);//Signatures	 	    
		 	    signatureSC.setLangCode(sessionObject.getLanguage());
		 	    signatureSC.setLovType(SignatureConstant.SIGN_STATUS_CODE);
		 	    signatureSC.setPreferredLanguage(sessionObject.getPreferredLanguage());
		 	    signatureSC.setSignMode(pathCtrlVO.getSIGN_MODE());
		 	    signatureSC.setSignNoteMand(pathCtrlVO.getSIGN_NOTE_MAND());
		 	    //Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
		 	    signatureCO.getScanVO().setSIGN_INSTRUCTIONS("O");
		 	    
		 	    if(signatureSC.isShowAcceptCancelBtns())
		 	    {
		 		signatureSC.setStatus("P");
		 	    }
		 	    //sigcap
		 	   SigCapSignatureCO sigCapResultCO = coreCommonBO.retSignatureScreen(signatureSC);
		 	   if(sigCapResultCO == null)
	        	    {
	        		String[] param = { getText("SigCapUnavailable_key") };
	        		throw new BOException(MessageCodes.COMMON_WARNING, param);
	        	    }
                	    String sigScreen = sigCapResultCO.getSigScreen();
                	    if(SignatureConstant.SIGCAP_SIG_SCREEN.equals(sigScreen))
                	    {
                       		sigCapSignatureCO = new SigCapSignatureCO();
                		sigCapSignatureCO.setSigAaccountReference(signatureSC.getAccountReference());
                		sigCapSignatureCO.setSigCapUrl(sigCapResultCO.getSigCapUrl());
                		sigCapSignatureCO.setSigCapAmount(signatureSC.getAmount());
                		getAdditionalScreenParams().putAll(sigCapResultCO.getBusinessHm());
                		return sigScreen;
                	    }
                	    //#650085 DASI180166 - Issue in Signature
                	    if(signatureSC.isReadOnly()&&signatureSC.isShowAcceptCancelBtns())
		 	    	{
		 	    	    signatureSC.setExcludedStatuses("'D'");
		 	    	}
		 	    //
                	    
		 	    //end sigcap
		 	    Integer signCount	=	  signatureBO.selectSignatureListCount(signatureSC);
		 	    //get count of CIF signatures if account signatures are empty
		 	    if(signCount==0&&"A".equals(signatureSC.getSignatureTp())&&(signatureSC.isShowAcceptCancelBtns()||("DASHBOARDSCRN").equals(signatureSC.getScreenName() /*TP432476*/) )){//&&signatureSC.isReadOnly()		 	 
		 	    	SignatureSC cifSignatureSC = cloner.deepClone(signatureSC);
		 	    	cifSignatureSC.setSignatureTp("C");
		 	    	//BUG 308647 AGIBI150164 - Limit schema not working properly
		 	    	signatureSC.setSignatureTp("C");
		 	    	//
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
		 	    	
		 	    	signCount	=	signatureBO.selectSignatureListCount(cifSignatureSC);
		 	    	
		 	    }
		 	   if(signCount==0&&signatureSC.isReadOnly()&&signatureSC.isShowAcceptCancelBtns()){
		 	    	String[] param = {getText("no_signatures_found_key")};
		 	    	throw new BOException(MessageCodes.COMMON_WARNING,param);
		 	    }
		 	   
		 	   //retrieve limit schema checking flag 
			 	  if(signatureSC.isShowAcceptCancelBtns()){	 		  
			 			if(signatureSC.getSignatureTp().equals("C")){
			 			        if(signatureSC.getValidationDate() == null)
			 			        {
			 			           signatureSC.setValidationDate(DateUtil.nullToInitDate(null));
			 			        }
			 				signatureSC.setEnforceSign(limitSchemaBO.returnLimitSchemaCountForACCOrCIF(signatureSC)>0?"1":"0");					 
						}
						else{
//							String enforceSign  = signatureBO.selectEnforceSignLimit(paramSignSC);
							//signatureSC.setEnforceSign(enforceSign==null?"0":enforceSign);
							signatureSC.setEnforceSign("1");//TODO testing purpose remove this line and uncomment the one above
							
						}
			 			if("Y".equals(signatureSC.getValidateFlag())){
							if("0".equals(pathCtrlVO.getFILTER_SIGN())){
								signatureSC.setApplyFilter("0");
							}
							else{
								signatureSC.setApplyFilter(SignatureConstant.TRS_PROGRAM.equals(signatureSC.getProgram())?"1":"0");
									 
								}
							}
						else{
							signatureSC.setApplyFilter("0");
						}
			 		  
			 	  }	
			 	signatureCO.setUnlimitedFlag(true); //Hala - BUG685701
	 	    } 
 

	 	 
	 	    retrieveSignGroup();
	 	    
	 	   SignatureSC privilegeSignatureSC = cloner.deepClone(signatureSC); 
	 	   privilegeSignatureSC.setBranchCode(sessionObject.getBranchCode());
	 	  privilegeSignatureSC.setProfType(NumberUtil.nullToZero(returnCommonLibBO().returnPthCtrl().getPOP_PROF_MOD_ACCESS()));
	 	   privilegeList  = signatureBO.getSignaturePrivilegeList(privilegeSignatureSC);
	 	   String viewMode =  signatureCO.getViewMode();
	 	    setPrivilegeProperties();
		   if(SignatureConstant.EDIT_ALL_MODE.equals(viewMode)||SignatureConstant.EDIT_CHANGE_AMOUNT_MODE.equals(viewMode)||SignatureConstant.VIEW_MODE.equals(viewMode)){//EDIT MODE
	 	    	signatureCO.getCifObjectVO().setCOMP_CODE(sessionObject.getCompanyCode());
	 	 	    signatureCO.getCifObjectVO().setBRANCH_CODE(signatureSC.getBranchCode());
	 	 	  signatureCO.setPreferredLanguage(sessionObject.getPreferredLanguage());  
	 	 	    signatureCO = signatureBO.selectSignatureDetails(signatureCO);
	 	 	    
	 	 	    if(signatureCO != null)
	 	 	    {
	 	 		//#756390 - GAB180087 - Hala Al Sheikh
	 	 		applyRetrieveAudit(AuditConstant.SIGNATURE_KEY_REF, signatureCO.getCifObjectVO(), signatureCO);
	 	 		signatureCO.setSetSignAuditTrxNbr(getAuditTrxNbr());
	 	 		//set_auditJsonStr(returnSerializedStrFromObj(signatureCO));
	 	 	    }
	 	 	    signatureCO.setUnlimitedFlag(signatureCO.getScanVO()==null?true:BigDecimal.ONE.equals(signatureCO.getScanVO().getDEFAULT_UNLIMITED()));//scanvo will be null on form loaded in add mode
	 	    }
		   else
		   {								   
                        signatureCO.setUnlimitedFlag(true); //Hala - BUG685701
                	    // EWBI160037 -- [John Massaad]
                	    if(NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getAUTH_CIF_NO()))
                	    {
                		signatureCO.getCifObjectVO().setAUTH_CIF_NO(signatureSC.getCifNo());
                		signatureCO.getCifVO().setCIF_NO(signatureSC.getCifNo());
                		signatureCO.getCifVO().setCOMP_CODE(sessionObject.getCompanyCode());
                		//#573892-EWB170023-Modification CIF: Manque l audit de lutilisateur modificateur
                		 signatureCO.getCifObjectVO().setBRANCH_CODE(signatureSC.getBranchCode());
                		 //
                		signatureCO.setPreferredLanguage(sessionObject.getPreferredLanguage());
                
                		signatureCO = signatureBO.getSignCIFdetails(signatureCO);
                	    }
                	    // EWBI160037 -- [John Massaad]
		   }
		   if(SignatureConstant.TRS_PROGRAM.equals(signatureSC.getProgram())){
			   signatureCO.setViewMode(SignatureConstant.VIEW_MODE);
		   }
		   else{
			   signatureCO.setViewMode(viewMode);
		   }
		   signatureCO.setUnlimitedFlag(signatureCO.getScanVO()==null?true:BigDecimal.ONE.equals(signatureCO.getScanVO().getDEFAULT_UNLIMITED()));//scanvo will be null on form loaded in add mode
		   if(SignatureConstant.IS_CIF.equals(signatureSC.getSignatureTp())){
			   signatureCO.setCurrencyDesc(sessionObject.getBaseCurrencyName());
		   }
		   else{
			   CURRENCIESVOKey  key  =  new CURRENCIESVOKey();
			   key.setCOMP_CODE(sessionObject.getCompanyCode());
			   key.setCURRENCY_CODE(NumberUtil.nullEmptyToValue(signatureCO.getCifObjectVO().getAMOUNT_CY(), signatureSC.getCurrencyCode()));
			   signatureCO.setCurrencyDesc(signatureBO.getAccCurrencyDesc(key).getBRIEF_DESC_ENG());
		   }
		   setTabVisibility(signatureSC);//sets the visibilty of tabs.
            	if(signatureSC.isReadOnly())
            	{
            	    set_recReadOnly("true");
            	}
            	else
            	{
            	    setFormFieldProperties(signatureCO, viewMode);
            	}
		 
		return "signatureFormPage";
	}
	
	//Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
	public String signInstDependency() throws BaseException
	{    
	 try 
	 {
	    signatureCO.getScanVO().setINST_OTHER_VALUE("");
	    setOtherValueProperties();
	    
	    signatureCO= signatureBO.defaultIdByAuthSigAndInst(signatureCO);
	    setDefaultedIDReadOnly(signatureCO.isIdDefaulted());
	}
	catch(Exception e)
	{
	    setDefaultedIDReadOnly(false);
	    signatureCO.getScanVO().setSIGN_INSTRUCTIONS(null);
	    handleException(e, null, null);
	}
	    return SUCCESS;
	}
//id:1077811 Details:SBI200521 - Creating a CIF for Mandate Signature in Asaan Account falha TAR:SBI200521
	private void setDefaultedIDReadOnly(boolean defaulted)
	{
	    BigDecimal readonly=BigDecimal.ZERO;
	    if(defaulted)
	    {
		readonly=BigDecimal.ONE;
	    }
	    SYS_PARAM_SCREEN_DISPLAYVO businessElement1 = new SYS_PARAM_SCREEN_DISPLAYVO();
	     businessElement1.setIS_READONLY(readonly);	
	    
		if(getAdditionalScreenParams().containsKey("lookuptxt_scanVO_ID_TYPE"))
		{
		  getAdditionalScreenParams().get("lookuptxt_scanVO_ID_TYPE").setIS_READONLY(readonly);
		}
		else
		{
		    getAdditionalScreenParams().put("lookuptxt_scanVO_ID_TYPE",businessElement1);
		}
		
		if(getAdditionalScreenParams().containsKey("signatureCO_idTypeDesc"))
		{
		  getAdditionalScreenParams().get("signatureCO_idTypeDesc").setIS_READONLY(readonly);
		}
		else
		{
		    getAdditionalScreenParams().put("signatureCO_idTypeDesc",businessElement1);
		}
		
		if(getAdditionalScreenParams().containsKey("scanVO_ID_NO"))
		{
		  getAdditionalScreenParams().get("scanVO_ID_NO").setIS_READONLY(readonly);
		}
		else
		{
		    getAdditionalScreenParams().put("scanVO_ID_NO",businessElement1);
		}
		   
	
	}
	//id:1077811 Details:SBI200521 - Creating a CIF for Mandate Signature in Asaan Account falha TAR:SBI200521

    // Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
    private void setOtherValueProperties() throws BaseException
    {

	RequiredFieldsSC criteria = new RequiredFieldsSC();
	SessionCO sessionCO = returnSessionObject(); 
	criteria.setAppName(sessionCO.getCurrentAppName());
	criteria.setLangCode(sessionCO.getLanguage());
	criteria.setProgRef(get_pageRef());
	criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	criteria.setLoginUserId(sessionCO.getUserName());
	criteria.setCompCode(sessionCO.getCompanyCode());
	criteria.setBranchCode(sessionCO.getBranchCode());
	signatureCO.setCompCode(sessionCO.getCompanyCode());
	
	if("C".equals(signatureSC.getSignatureTp()))
	{
	    criteria.setCifType(signatureSC.getCifType());
	    if(NumberUtil.nullToZero(signatureSC.getCifNo()).compareTo(BigDecimal.ZERO) == 1)
	    {
		criteria.setCifNo(signatureSC.getCifNo());
	    }
	    criteria.setEntityType(ConstantsCommon.ENTITY_CIF_TYPE_LOV);
	    criteria.setEntityCode(signatureSC.getCifType());
	}
	
	Map<String, Object> hm = new HashMap<String, Object>();
	hm.put(ConstantsCommon.ENTITY_CIF_TYPE_LOV, signatureSC.getCifType());
	hm.put(ConstantsCommon.ENTITY_COUNTRY_ID_LOV, null);
	criteria.setEntityTypeInfosMap(hm);
	
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> returnMapRequiredData = returnCommonLibBO()
		.returnMapRequiredData(criteria);
	SYS_PARAM_SCREEN_DISPLAYVO codeBusinessElementVO;
	BigDecimal visibleSignInst = BigDecimal.ONE;
	if(returnMapRequiredData != null && returnMapRequiredData.get("signatureCO.scanVO.SIGN_INSTRUCTIONS") != null)
	{
	    codeBusinessElementVO = returnMapRequiredData.get("signatureCO.scanVO.SIGN_INSTRUCTIONS");
	    visibleSignInst = NumberUtil.nullEmptyToValue(codeBusinessElementVO.getIS_VISIBLE(), BigDecimal.ONE);
	}

	BigDecimal state = BigDecimal.ZERO;
	String signInstructions = StringUtil.nullToEmpty(signatureCO.getScanVO().getSIGN_INSTRUCTIONS());
	if("O".equals(signInstructions) && BigDecimal.ONE.compareTo(visibleSignInst) == 0)
	{
	    state = BigDecimal.ONE;
	}

	SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	businessElement.setIS_VISIBLE(state);
	// Hala - BUG685701
	//Bug#751543
	businessElement.setIS_MANDATORY(state);
	getAdditionalScreenParams().put("instructionsOtherValue", businessElement);
	// getAdditionalScreenParams().put("signDesc",businessElement);

	//Added by Maria Chamieh for SBI170183
	BigDecimal state1 = BigDecimal.ZERO;
	if("1".equals(signatureSC.getIsAsaanAcc()) && 
		"A".equals(signatureSC.getSignatureTp()) && 
		    "M".equals(signInstructions) 
		    	&& BigDecimal.ONE.compareTo(visibleSignInst) == 0)
	{
	    state1 = BigDecimal.ONE;
	}
	SYS_PARAM_SCREEN_DISPLAYVO businessElement1 = new SYS_PARAM_SCREEN_DISPLAYVO();
	businessElement1.setIS_VISIBLE(state1);
	businessElement1.setIS_MANDATORY(state1);
	getAdditionalScreenParams().put("lookuptxt_scanVO_ID_TYPE", businessElement1);
	getAdditionalScreenParams().put("signatureCO_idTypeDesc", businessElement1);
	getAdditionalScreenParams().put("scanVO_ID_NO", businessElement1);
	// end maria
    }

	private void setTabVisibility(SignatureSC signatureSC)throws BaseException{		
		PTH_CTRLVO pthCtrlVO		=	signatureBO.getPTH_CTRLVO();
		setDocTabVisible(pthCtrlVO.getSHOW_SIGN_DOC().equals(BigDecimal.ONE));//DOCUMENT VISIBILITY
		setPhotoTabVisible(pthCtrlVO.getSHOW_SIGN_PHO().equals(BigDecimal.ONE));//PHOTO VISIBILITY
		//limit schema visibility
		if(!(SignatureConstant.TRS_PROGRAM.equals(signatureSC.getProgram())&&"1".equals(signatureSC.getApplyFilter()))){			 
			limitSchemaTabVisible= "1".equals(signatureSC.getSignMode())&&privilegeList.contains(SignatureConstant.SIGN001L);			 
		}
		// copy signature visibility
		 copySignTabVisible= privilegeList.contains(SignatureConstant.SIGN002CP)&&signatureSC.getSignatureTp().equals("A"); 
		 //sign details tab visibility
		 signTabVisible = privilegeList.contains(SignatureConstant.SIGN001)||privilegeList.contains(SignatureConstant.SIGN002);
		 
		 //Fix Issue #242395 and #242411 Override by the value of signatureSC.getCopySignTabVisible if it has been passed in parameter
		 if(signatureSC.getCopySignTabVisible() != null)
		 {
		     copySignTabVisible = signatureSC.getCopySignTabVisible();
		 }
		}
		
		
 
	
	
	
	public String populateCopySignature(){
		
		try {
			secondaryId = SignatureConstant.SECONDARY_ID_COPY;
			SessionCO sessionObject = returnSessionObject();	
		 	signatureSC.setCompCode(sessionObject.getCompanyCode());
		 	if(NumberUtil.isEmptyDecimal(signatureSC.getBranchCode()))//if the branch code is not send from the client,setting the session branch code.
		 	{
		 	    signatureSC.setBranchCode(sessionObject.getBranchCode());
		 	}
		 	 signatureSC.setUserId(sessionObject.getUserName());
		 	 signatureSC.setAppName(sessionObject.getCurrentAppName());
		 	Cloner cloner = new Cloner();
		 	SignatureSC privilegeSignatureSC = cloner.deepClone(signatureSC); 
		 	privilegeSignatureSC.setBranchCode(sessionObject.getBranchCode());
		 	privilegeSignatureSC.setProfType(NumberUtil.nullToZero(returnCommonLibBO().returnPthCtrl().getPOP_PROF_MOD_ACCESS()));
			privilegeList  =signatureBO.getSignaturePrivilegeList(privilegeSignatureSC);
			set_recReadOnly("true");
		} catch (BaseException e) {
			handleException(e, null, null);
		}
		
		return "copySignaturePage";
	}
	
	
	public String loadCopySignatureForm(){
	
 	    try {
	 	   	retrieveSignGroup();
	 	    String viewMode =  signatureCO.getViewMode();
			SessionCO sessionCO   = returnSessionObject();
			setParamFromIndex(signatureCO.getIndex(),signatureCO);			 	    
 	    	signatureCO = signatureBO.selectSignatureDetails(signatureCO);
 	    	signatureCO.setViewMode(viewMode); 
 	    	signatureCO.setUnlimitedFlag(signatureCO.getScanVO()==null?true:BigDecimal.ONE.equals(signatureCO.getScanVO().getDEFAULT_UNLIMITED()));//scanvo will be null on form loaded in add mode
 	    	if(signatureCO.getCurrencyDesc()==null)
 	    	{
 	    	    signatureCO.setCurrencyDesc(sessionCO.getBaseCurrencyName());
 	    	}
 	    	  set_recReadOnly("true");
 	    	 secondaryId = SignatureConstant.SECONDARY_ID_COPY;
		} catch (BaseException e) {
			handleException(e, null, null);
			return ERROR_ACTION;
		}
		
		
		return "signatureFormPage";
	}
	
	 private void setParamFromIndex(String accNo,SignatureCO signatureCO){
	    	String[]  accNoArr = accNo.split("-"); 
	    	signatureCO.getCifObjectVO().setCOMP_CODE(new BigDecimal(accNoArr[0]));
	    	signatureCO.getCifObjectVO().setBRANCH_CODE(new BigDecimal(accNoArr[1]));
	    	signatureCO.getCifObjectVO().setACC_CY(new BigDecimal(accNoArr[2]));
	    	signatureCO.getCifObjectVO().setACC_GL(new BigDecimal(accNoArr[3]));
	    	signatureCO.getCifObjectVO().setACC_CIF(new BigDecimal(accNoArr[4]));
	    	signatureCO.getCifObjectVO().setACC_SL(new BigDecimal(accNoArr[5])); 
	    	 
	    	
	    }
	 
    public String copySignatures()
    {
	try
	{
	    // contains the account no from where the sign needs to be copied
	    SignatureCO copyAccSignatureCO = new SignatureCO();
	    copyAccSignatureCO.setCifObjectVO(new CIFOBJECTVO());
	    setParamFromIndex(signatureCO.getIndex(), copyAccSignatureCO);
	    copyAccSignatureCO.setSignatureTp(signatureSC.getSignatureTp());
	    signatureCO.getCifObjectVO().setCOMP_CODE(returnSessionObject().getCompanyCode());
	    signatureCO.applyTraceProps(returnSessionObject().getCurrentAppName(), returnSessionObject().getUserName(), get_pageRef());
	    if(!isSignAvailConfirmed() && signatureBO.selectCifObjectCount(signatureCO) != 0)
	    {
		setCopySignAvailable(true);
		throw new BOException(MessageCodes.SIGN_ALREADY_EXIST_FOR_ACC, ConstantsCommon.CONFIRM_MSG_TYPE);
	    }
	    
	    AuditRefCO refCO = initAuditRefCO();
	    signatureCO.setAuditRefCO(refCO);
	    
	    signatureBO.copySignature(signatureCO, copyAccSignatureCO);

	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
	
	
	public String loadDocumentForm(){
		 secondaryId =SignatureConstant.DOCUMENT.equals(signatureCO.getScanVO().getDOC_TYPE())?"_doc":"_photo";
		 String viewMode =  signatureCO.getViewMode(); 
		 SessionCO sessionObject = returnSessionObject();
		 if(SignatureConstant.EDIT_ALL_MODE.equals(viewMode) ||SignatureConstant.VIEW_MODE.equals(viewMode)){//EDIT MODE			    
	 	    	signatureCO.getCifObjectVO().setCOMP_CODE(sessionObject.getCompanyCode());	 	    	 
	 		 	signatureCO.getCifObjectVO().setBRANCH_CODE(signatureSC.getBranchCode()==null?sessionObject.getBranchCode():signatureSC.getBranchCode());
	 	        try {
					signatureCO = signatureBO.selectDocumentDetails(signatureCO);
					signatureCO.setViewMode(viewMode);
					signatureCO.setDefaultPhoto(signatureCO.getCifObjectVO().getDEFAULT_PHOTO().equals(BigDecimal.ONE));
				} catch (BaseException e) {
					handleException(e, "", "");
				} 	    	
	 	    }		 
		 if(signatureSC.isReadOnly()||SignatureConstant.VIEW_MODE.equals(viewMode))
		 {
		     set_recReadOnly("true");
		 }
		 if(!SignatureConstant.VIEW_MODE.equals(viewMode))
		 {
		     setDocumentFormProperties();
		 }
		 
		return "documentFormPage";
	}
	
	
	public void setDocumentFormProperties(){
		SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		businessElement.setELEMENT_NAME("signatureCO.scanVO.DESCRIPTION");			
		businessElement.setIS_MANDATORY(BigDecimal.ONE);			 
		getAdditionalScreenParams().put("signatureCO.scanVO.DESCRIPTION",businessElement);		
	}
	
	/**
	 * IIAB120556 - Signature Privilege Expiry
	 * @author nabilfeghali
	 */
	public void checkRequiredExpiryDate()
	{
	    if(Boolean.valueOf(signatureSC.getExpiryDateRequired()))
	    {	
	    	SYS_PARAM_SCREEN_DISPLAYVO expiryDateElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	    	expiryDateElement.setELEMENT_NAME(SignatureConstant.SIGN_EXPIRY_DATE_NAME);			
	    	expiryDateElement.setIS_MANDATORY(BigDecimal.ONE);			 
		getAdditionalScreenParams().put(SignatureConstant.SIGN_EXPIRY_DATE_NAME,expiryDateElement);
		
		SYS_PARAM_SCREEN_DISPLAYVO unlimitedElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		unlimitedElement.setELEMENT_NAME(SignatureConstant.SIGN_UNLIMITED_NAME);			
		unlimitedElement.setIS_READONLY(BigDecimal.ONE);			 
		getAdditionalScreenParams().put(SignatureConstant.SIGN_UNLIMITED_NAME,unlimitedElement);
		
		signatureCO.setUnlimitedFlag(false);
	    }	
	}
	
	/**
	 * NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
	 */
	private void checkSignatureExpiryDateRequired() throws BaseException
	{
	    //TONY NOUH 24/11/2014 Bug 243905 system is allowing the user to save a signature without defining a valid expiry date
	    if(signatureCO.getScanVO().getEXP_DATE() == null && !signatureCO.getUnlimitedFlag())
	    {
		throw new BOException(MessageCodes.Enter_valid_expiry_date);
	    }
	    
	    if(Boolean.valueOf(signatureSC.getExpiryDateRequired()) 
		    && signatureCO.getScanVO() != null 
		    	&& signatureCO.getScanVO().getEXP_DATE() == null)
	    {
		throw new BOException(MessageCodes.EXP_DATE_REQUIRED_FOR_SIGN);
	    }
	    
	    //NABIL FEGHALI - FIX BUG #155530
	    if(signatureCO.getScanVO().getEXP_DATE() != null
		    && signatureCO.getScanVO().getEXP_DATE().compareTo(returnSessionObject().getRunningDateRET()) < 0)
	    {
		throw new BOException(MessageCodes.Enter_valid_expiry_date);
	    }
	}
	
    public String loadDocumentList()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    secondaryId = SignatureConstant.DOCUMENT.equals(signatureSC.getDocType()) ? "_doc" : "_photo";
	    signatureCO.setViewMode(SignatureConstant.ADD_MODE);
	    signatureCO.setScanVO(new S_SCANVO());
	    signatureCO.getScanVO().setDOC_TYPE(signatureSC.getDocType());
	    signatureSC.setCompCode(sessionObject.getCompanyCode());
	    // signatureSC.setDetails("View");//TODO replace it with privilege
	    // signatureSC.setEdit("Rename");//TODO replace it with privilege
	    signatureSC.setUserId(sessionObject.getUserName());
	    signatureSC.setAppName(sessionObject.getCurrentAppName());
	    Cloner cloner = new Cloner();
	    SignatureSC privilegeSignatureSC = cloner.deepClone(signatureSC); 
	    privilegeSignatureSC.setBranchCode(sessionObject.getBranchCode());
	    privilegeSignatureSC.setProfType(NumberUtil.nullToZero(returnCommonLibBO().returnPthCtrl().getPOP_PROF_MOD_ACCESS()));
	    if(SignatureConstant.DOCUMENT.equals(signatureSC.getDocType()))
	    {
		privilegeList = signatureBO.getDocumentPrivilegeList(privilegeSignatureSC);
		signatureSC.setDetails(privilegeList.contains(SignatureConstant.DOC001) ? "View" : "");
		signatureSC.setEdit(privilegeList.contains(SignatureConstant.DOC002R) ? "Rename" : "");
	    }
	    else
	    {
		privilegeList = signatureBO.getPhotoPrivilegeList(privilegeSignatureSC);
		signatureSC.setDetails(privilegeList.contains(SignatureConstant.PHO001) ? "View" : "");
		signatureSC.setEdit(privilegeList.contains(SignatureConstant.PHO002R) ? "Rename" : "");
	    }
	    set_recReadOnly(String.valueOf(signatureSC.isReadOnly()));
	    setDocumentFormProperties();
	}
	catch(BaseException e)
	{
	    handleException(e, "", "");

	}
	return "documentListPage";
    }
	
	
	
	
	private void setFormFieldProperties(SignatureCO signatureCO,String viewMode) throws BaseException{
	    	SessionCO sessionCO = returnSessionObject();
	    	RequiredFieldsSC criteria = new RequiredFieldsSC();
		criteria.setAppName(sessionCO.getCurrentAppName());
		criteria.setLangCode(sessionCO.getLanguage());
		criteria.setProgRef(get_pageRef());
		criteria.setCompCode(sessionCO.getCompanyCode());
		if(AccountsConstant.FOM_SCREEN_SRC.equals(signatureSC.getScreenName()))
		{
		    criteria.setCifType(signatureSC.getCifNo());
			
		    criteria.setBranchCode(sessionCO.getBranchCode());
		    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    criteria.setLoginUserId(sessionCO.getUserName());
			
		    Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>();
		    entityTypeInfosMap.put(ConstantsCommon.ENTITY_CIF_TYPE_LOV, signatureSC.getCifNo());
        
        	    entityTypeInfosMap.put(ConstantsCommon.ENTITY_COUNTRY_ID_LOV, signatureCO.getCifVO().getCOUNTRY());
			
        	    entityTypeInfosMap.put(ConstantsCommon.ENTITY_CIF_NO_LOV, signatureSC.getCifNo());
    		
		    criteria.setEntityTypeInfosMap(entityTypeInfosMap);
		    
		    criteria.setCifNo(signatureCO.getCifVO().getCIF_TYPE());
		}

		HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = returnCommonLibBO().returnMapRequiredData(criteria);
		
		String[] bussiness = {"signatureCO.cifObjectVO.AUTH_CIF_NO", "signatureCO.authCifDesc", "signatureCO.scanVO.DESCRIPTION",
			"signatureCO.cifObjectVO.AMOUNT", "signatureCO.currencyDesc", "signatureCO.cifObjectVO.GROUP_ID",
			"signatureCO.scanVO.EXP_DATE", "signatureCO.unlimitedFlag", "signatureCO.scanVO.ANNOTATION",
			"signatureCO.signatureAnnotationVO.ANNOTATION"};
        	if(elementHashmap != null)
        	{
        	    for(String b : bussiness)
        	    {
        		if(elementHashmap.get(b) != null)
        		{
        		    getAdditionalScreenParams().put(b, elementHashmap.get(b));
        		}
        	    }
        	}
		
		if(SignatureConstant.ADD_MODE.equals(viewMode)){
		    	//Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
		    	// setSignDescFieldProperty();
			signatureCO.getScanVO().setSIGN_INSTRUCTIONS("O");
		    	setOtherValueProperties();
			//setExpDateFieldProperty(signatureCO);
		}
		else if (SignatureConstant.VIEW_MODE.equals(viewMode)) {//VIEW MODE - ALL FIELDS ARE READONLY
			set_recReadOnly("true");
		    	//Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
			setOtherValueProperties();
		}
		else if (SignatureConstant.EDIT_CHANGE_AMOUNT_MODE.equals(viewMode)) {//ONLY LIMIT AMOUNT IS EDITABLE 
			set_recReadOnly("true");
			setLimitAmountFieldProperty(true);
			setExpDateFieldProperty(signatureCO);
			//Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
			setOtherValueProperties();
		} 
		else if(SignatureConstant.EDIT_ALL_MODE.equals(viewMode)){
		    	//Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
		    	// setSignDescFieldProperty();
		    	setOtherValueProperties();
	            	
			setLimitAmountFieldProperty(false);
			setExpDateFieldProperty(signatureCO);
		}
			
		//EWBI160037 -- [John Massaad]
        	if(AccountsConstant.ACCOUNTS_SCREEN_SRC.equals(signatureSC.getScreenName()))
        	{
        	    SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
    	    	    if(getAdditionalScreenParams().get("signatureCO.cifObjectVO.AUTH_CIF_NO") != null)
    	    	    {
    	    		businessElement =  getAdditionalScreenParams().get("signatureCO.cifObjectVO.AUTH_CIF_NO");
    	    	    }
    	    	    else
    	    	    {    
    	    		businessElement.setELEMENT_NAME("signatureCO.cifObjectVO.AUTH_CIF_NO");
    	    	    }
        	    businessElement.setIS_READONLY(BigDecimal.ZERO);
        	    getAdditionalScreenParams().put("signatureCO.cifObjectVO.AUTH_CIF_NO", businessElement);
        
        	}
        	//EWBI160037 -- [John Massaad]
	
		//NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
		checkRequiredExpiryDate();
	}
	
	
 
	private void setExpDateFieldProperty(SignatureCO signatureCO){
		SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
		if(getAdditionalScreenParams().get("signatureCO.scanVO.EXP_DATE") != null)
		{
		    businessElement =  getAdditionalScreenParams().get("signatureCO.scanVO.EXP_DATE");
		}
		else
		{    
		    businessElement.setELEMENT_NAME("signatureCO.scanVO.EXP_DATE");
		}
		businessElement.setIS_READONLY(signatureCO.getScanVO()==null?BigDecimal.ONE:signatureCO.getScanVO().getDEFAULT_UNLIMITED());			 
		getAdditionalScreenParams().put("signatureCO.scanVO.EXP_DATE",businessElement);
	}
	
	private void setSignDescFieldProperty(){
	    	SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	    	if(getAdditionalScreenParams().get("signatureCO.scanVO.DESCRIPTION") != null)
	    	{
	    	    businessElement =  getAdditionalScreenParams().get("signatureCO.scanVO.DESCRIPTION");
	    	}
	    	else
	    	{    
	    	    businessElement.setELEMENT_NAME("signatureCO.scanVO.DESCRIPTION");
	    	}
		businessElement.setIS_MANDATORY(BigDecimal.ONE);			 
		getAdditionalScreenParams().put("signatureCO.scanVO.DESCRIPTION",businessElement);
		
	}
	
	private void setLimitAmountFieldProperty(boolean enable){
	    	SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	    	if(getAdditionalScreenParams().get("signatureCO.cifObjectVO.AMOUNT") != null)
	    	{
	    	    businessElement =  getAdditionalScreenParams().get("signatureCO.cifObjectVO.AMOUNT");
	    	}
	    	else
	    	{    
	    	    businessElement.setELEMENT_NAME("signatureCO.cifObjectVO.AMOUNT");
	    	}
		businessElement.setIS_READONLY(enable?BigDecimal.ZERO:BigDecimal.ONE);	 
		businessElement.setIS_MANDATORY(enable?BigDecimal.ONE:BigDecimal.ZERO);		
		businessElement.setOverWriteReadOnly(enable);
		getAdditionalScreenParams().put("signatureCO.cifObjectVO.AMOUNT",businessElement);
		
	}
	
	 

    /**
     * Method to write Scanned Signatures in JSP page
     */
    public void loadSignatureImage(){
		try{
			SessionCO sessionCO = returnSessionObject();
			NumberUtil.resetEmptyValues(signatureCO);
			signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());
			if(NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getBRANCH_CODE()))
			{
			    log.error("cifObjectVO.BRANCH_CODE is null or empty");
			    signatureCO.getCifObjectVO().setBRANCH_CODE(sessionCO.getBranchCode());
			}
			if(NumberUtil.isEmptyDecimal(signatureSC.getBranchCode()))
			{
			    log.error("signatureSC.branchCode is null or empty");
			}
			else if(signatureSC.getBranchCode().compareTo(signatureCO.getCifObjectVO().getBRANCH_CODE()) != 0)
    			{
			    log.error("signatureSC.branchCode: " + signatureSC.getBranchCode() + " \n cifObjectVO.BRANCH_CODE: "
            			+ signatureCO.getCifObjectVO().getBRANCH_CODE());
			}
		    byte[] signatureImage = signatureBO.selectSignatureImage(signatureCO);

		    String contentType = "";
		    if(signatureImage != null ) 
		    {
			InputStream is = new ByteArrayInputStream(signatureImage);
			contentType = URLConnection.guessContentTypeFromStream(is);
			if(contentType == null)
			{
			    contentType = returnImageType(signatureImage);
			    contentType = "image/" + contentType;
			}
			    
		    }
		    		    

		    HttpServletResponse response = ServletActionContext.getResponse();
		    setServletResponse(response);

		    InputStream is = new BufferedInputStream(new ByteArrayInputStream(signatureImage));
		    String mimeType = HttpURLConnection.guessContentTypeFromStream(is);
		    response.setContentType(mimeType == null ? ConstantsCommon.PHOTO_EXTENSION_PNG : mimeType);
		    
		    response.getOutputStream().write(signatureImage);
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
		}
		catch(Exception ex){
		    handleException(ex, null, null);
		}
    }
    

    public static String returnImageType(byte[] xmlInput)
    {
//     byte[] xmlInput = readFile(new File("C:\\Denisk\\BMP 256.bmp"));
//     byte[] xmlInput = readFile(new File("C:\\Denisk\\PNG signature.png"));
//       byte[] xmlInput = readFile(new File("C:\\Denisk\\TIFF image.tif"));
       
         byte[] bmpBytes = new byte[2];
         bmpBytes[0] = (byte) 0x42;
         bmpBytes[1] = (byte) 0x4D;
          int scriptByteLen = xmlInput.length;
          int imgTypeLen = bmpBytes.length;
          String imgType = null;
         if(scriptByteLen >= imgTypeLen )
         {
               imgType = "BMP";
              for(int j = 0; j < imgTypeLen; j++)
              {
                  if(bmpBytes[j] != xmlInput[j])
                  {
                     imgType = null;
                     break;
                  }
              }
              
          }
         // check for PNG
         if(imgType == null)
         {
             bmpBytes = new byte[4];
                bmpBytes[0] = (byte) 0x89;
                bmpBytes[1] = (byte) 0x50;
                bmpBytes[2] = (byte) 0x4E;
                bmpBytes[3] = (byte) 0x47;
                
                scriptByteLen = xmlInput.length;
                 imgTypeLen = bmpBytes.length;
                if(scriptByteLen >= imgTypeLen )
                {
                      imgType = "PNG";
                     for(int j = 0; j < imgTypeLen; j++)
                     {
                         if(bmpBytes[j] != xmlInput[j])
                         {
                           imgType = null;
                           break;
                         }
                     }
                     
                 }
         }
         
         // check for GIF
         if(imgType == null)
         {
             bmpBytes = new byte[4];
                bmpBytes[0] = (byte) 0x47;
                bmpBytes[1] = (byte) 0x49;
                bmpBytes[2] = (byte) 0x46;
                bmpBytes[3] = (byte) 0x38;
                
                scriptByteLen = xmlInput.length;
                 imgTypeLen = bmpBytes.length;
                if(scriptByteLen >= imgTypeLen )
                {
                      imgType = "GIF";
                     for(int j = 0; j < imgTypeLen; j++)
                     {
                         if(bmpBytes[j] != xmlInput[j])
                         {
                           imgType = null;
                           break;
                         }
                     }
                     
                 }
         }
         
       // check for JPG FFD8FFE0
         if(imgType == null)
         {
             bmpBytes = new byte[4];
             bmpBytes[0] = (byte) 0xFF;
             bmpBytes[1] = (byte) 0xD8;
             bmpBytes[2] = (byte) 0xFF;
             bmpBytes[3] = (byte) 0xE0;

             scriptByteLen = xmlInput.length;
             imgTypeLen = bmpBytes.length;
             if(scriptByteLen >= imgTypeLen )
             {
                imgType = "JPG";
                for(int j = 0; j < imgTypeLen; j++)
                {
                    if(bmpBytes[j] != xmlInput[j])
                    {
                       imgType = null;
                       break;
                    }
                }

             }
         }
         
       // check for TIF  49492A
         if(imgType == null)
         {
             bmpBytes = new byte[3];
             bmpBytes[0] = (byte) 0x49;
             bmpBytes[1] = (byte) 0x49;
             bmpBytes[2] = (byte) 0x2A;

             scriptByteLen = xmlInput.length;
             imgTypeLen = bmpBytes.length;
             if(scriptByteLen >= imgTypeLen )
             {
                imgType = "TIFF";
                for(int j = 0; j < imgTypeLen; j++)
                {
                    if(bmpBytes[j] != xmlInput[j])
                    {
                       imgType = null;
                       break;
                    }
                }

             }
         }
         if(imgType == null)
         {
             imgType = "JPEG";
         }
        return imgType;
    }
    
    
    public void loadDocumentImage(){
		try{
			SessionCO sessionCO = returnSessionObject();
			NumberUtil.resetEmptyValues(signatureCO);
			signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());
			//signatureCO.getCifObjectVO().setBRANCH_CODE(sessionCO.getBranchCode());
		    byte[] signatureImage = signatureBO.selectDocumentImage(signatureCO);

		    String contentType = "";
		    if(signatureImage != null ) 
		    {
			InputStream is = new ByteArrayInputStream(signatureImage);
			contentType = URLConnection.guessContentTypeFromStream(is);
			if(contentType == null)
			{
			    contentType = returnImageType(signatureImage);
			    contentType = "image/" + contentType;
			}    
		    }
		    		    

		    HttpServletResponse response = ServletActionContext.getResponse();
		    setServletResponse(response);  
		    if (contentType != null ) 
		    {
			response.setContentType(contentType); 
		    }
		    else
		    {
			 response.setContentType("image/jpeg");
		    }  
		    response.getOutputStream().write(signatureImage);
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
		}
		catch(Exception ex){
		    handleException(ex, null, null);
		}
    
    }
    
    public String loadSignatureImageScreen(){
		return "signatureImageScreen";
    }
	/**
	 * Retrieves signature groups combo list
	 */
	private void retrieveSignGroup() {
		try {		
			List signGrpList = new ArrayList<SelectCO>();
			SelectCO defaultSelect =  new SelectCO();
			defaultSelect.setDescValue(getText("None_key"));
			signGrpList.add(defaultSelect);
			signGrpList.addAll(returnLOV(new SelectSC(SignatureConstant.SIGN_GRP_LOV_ID)));			
			setSignGroupList(signGrpList);
		} catch (BaseException e) {
			handleException(e, "Error retrieving signature group", "");
		}
	}
	
	/**
	 * View all signatures based on CIF 
	 */
	public String viewAllSignaturesForCIF(){
		try {
		SessionCO sessionCO = returnSessionObject();		 
		signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());
		if(signatureCO.getCifObjectVO().getBRANCH_CODE()==null)//if the branch code is not send from the client,setting the session branch code.
		{
		    signatureCO.getCifObjectVO().setBRANCH_CODE(sessionCO.getBranchCode());	
		}
		 signatureCOList=signatureBO.retrieveAllSignaturesForCIF(signatureCO);
		 
		} catch (Exception e) {
			 handleException(e, null,null);
		}
		return "viewAllSignaturesForCIF";
		
	}
	
	/**
	 * View all signatures based on Account
	 */
	
	public String viewAllSignaturesForAcc(){
		try {
			SessionCO sessionCO = returnSessionObject();
			signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());
			if(signatureCO.getCifObjectVO().getBRANCH_CODE()==null)//if the branch code is not send from the client,setting the session branch code.
			{
			    signatureCO.getCifObjectVO().setBRANCH_CODE(sessionCO.getBranchCode());
			}
			
			signatureCOList=signatureBO.retrieveAllSignaturesForAcc(signatureCO);
			
			
			//load CIF signatures if account signatures are empty
		 	if(signatureCOList.isEmpty()&&"A".equals(signatureSC.getSignatureTp())&&signatureSC.isShowAcceptCancelBtns()){//&&signatureSC.isReadOnly()
		 	  	
		 	    	SignatureSC cifSignatureSC = (new Cloner()).deepClone(signatureSC);
		 	    	
		 	    	cifSignatureSC.setCompCode(sessionCO.getCompanyCode());//branch cod will be send from client	 	   
		 	    	cifSignatureSC.setObjType(SignatureConstant.SIGNATURE);//Signatures
		 	    	cifSignatureSC.setValidationDate(sessionCO.getRunningDateRET());
		 	    	cifSignatureSC.setUserId(sessionCO.getUserName());
		 	    	cifSignatureSC.setAppName(sessionCO.getCurrentAppName());
		 	    	cifSignatureSC.setLangCode(sessionCO.getLanguage());
		 	    	cifSignatureSC.setLovType(SignatureConstant.SIGN_STATUS_CODE);
		 	    	cifSignatureSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
			 	
		 	    	cifSignatureSC.setSignatureTp("C");
		 	    	cifSignatureSC.setGlCode(BigDecimal.ZERO);
		 	    	cifSignatureSC.setSlNo(BigDecimal.ZERO);
		 	    	cifSignatureSC.setCurrencyCode(BigDecimal.ZERO);
		 	    	cifSignatureSC.setStatus("P");
		 	    	cifSignatureSC.setCifNo(signatureCO.getCifObjectVO().getCIF_NO());
		 	    	
		 	    	CifSC criteria = new CifSC();
		 	    	criteria.setComp_code(sessionCO.getCompanyCode());
		 	    	criteria.setCif_no(signatureCO.getCifObjectVO().getCIF_NO());
		 	    	
		 	    	CIFVO cifVO = returnCommonLibBO().returnCIF(criteria);
		 	    	if(cifVO == null)
		 	    	{
		 	    	    throw new BOException(MessageCodes.ERROR_RETRIEVE_SIGN);
		 	    	}
		 	    	cifSignatureSC.setBranchCode(cifVO.getBRANCH_CODE()); 
		 	    	signatureSC.setBranchCode(cifVO.getBRANCH_CODE());
		 	    	
		 	    	signatureCOList	=	signatureBO.selectSignatureList(cifSignatureSC);
		 	    	
		 	} 
			//
			
		} catch (RuntimeException e) {
		    throw e;
		} catch (Exception e) {
			 handleException(e, null,null);
		}
		
		return "viewAllSignaturesForAcc";
 
	}
	
	
	/****
	 * Set the common properties in CIFOBJECT/SSCAN/SOBJECT
	 */
	private void setSignatureCOProperties(){
		SessionCO sessionCO =returnSessionObject();
		signatureCO.applyTraceProps(sessionCO.getCurrentAppName(), sessionCO.getUserName(), get_pageRef());
		signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());
		signatureCO.setRunningDate(sessionCO.getRunningDateRET());
		 if(signatureCO.getCifObjectVO().getBRANCH_CODE()==null){//if the branch code is not send from the client,setting the session branch code.
			 signatureCO.getCifObjectVO().setBRANCH_CODE(sessionCO.getBranchCode());
			 signatureCO.getScanVO().setBRANCH_CODE(sessionCO.getBranchCode());
		 }
		 else{
			 signatureCO.getScanVO().setBRANCH_CODE( signatureCO.getCifObjectVO().getBRANCH_CODE());
		 }
		
		signatureCO.getCifObjectVO().setCREATED_BY(sessionCO.getUserName());//this value will be used in both save and update as s_sign_modif new entry might be created on update			
		signatureCO.getScanVO().setCOMP_CODE(sessionCO.getCompanyCode());			
		signatureCO.setSignObjectVO(new S_OBJECTVO());			

					
		signatureCO.getCifObjectVO().setACC_CIF(signatureCO.getCifObjectVO().getCIF_NO());
	    if(SignatureConstant.IS_CIF.equals(signatureSC.getSignatureTp())){
	    	signatureCO.getCifObjectVO().setACC_CY(BigDecimal.ZERO);
			signatureCO.getCifObjectVO().setACC_GL(BigDecimal.ZERO);
			signatureCO.getCifObjectVO().setACC_SL(BigDecimal.ZERO); 
	    }
		
		
		
		
	}
	
	/****
	 * Method for adding new signature for a specific CIF/Account
	 * @param signatureCO
	 * @return	
	 */
	public String saveSignature(){
		try {
			SessionCO sessionCO =returnSessionObject();
			setSignatureCOProperties();
			//NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
			checkSignatureExpiryDateRequired();
			//EWBI160037 --[John Massaad]
			signatureCO.setLoginBraCode(sessionCO.getBranchCode());
			//EWBI160037 --[John Massaad]
			if(SignatureConstant.IS_CIF.equals(signatureSC.getSignatureTp()))
			{
				signatureCO.getCifObjectVO().setAMOUNT_CY(sessionCO.getBaseCurrencyCode());
			}
			else
			{
				signatureCO.getCifObjectVO().setAMOUNT_CY(signatureCO.getCifObjectVO().getACC_CY());
			}		
			 //Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
                	 RequiredFieldsSC criteria = new RequiredFieldsSC();
                	 criteria.setAppName(sessionCO.getCurrentAppName());
                	 criteria.setLangCode(sessionCO.getLanguage());
                	 criteria.setProgRef(get_pageRef());
                	 criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
                	 criteria.setLoginUserId(sessionCO.getUserName());
                	 criteria.setCompCode(sessionCO.getCompanyCode());
                	 criteria.setBranchCode(sessionCO.getBranchCode());
                	 
                	 if("C".equals(signatureSC.getSignatureTp()))
                	 {
                		criteria.setCifType(signatureSC.getCifType());
                		if(NumberUtil.nullToZero(signatureSC.getCifNo()).compareTo(BigDecimal.ZERO) == 1)
                		{
                		    criteria.setCifNo(signatureSC.getCifNo());
                		}
                		criteria.setEntityType(ConstantsCommon.ENTITY_CIF_TYPE_LOV);
                		criteria.setEntityCode(signatureSC.getCifType());
                	 }
                	 Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>();
             		entityTypeInfosMap.put(ConstantsCommon.ENTITY_CIF_TYPE_LOV, signatureSC.getCifType());
             		entityTypeInfosMap.put(ConstantsCommon.ENTITY_VT_TYPE_LOV, null);

             		entityTypeInfosMap.put(ConstantsCommon.ENTITY_COUNTRY_ID_LOV, signatureSC.getCountryID()); 
             		
             		criteria.setEntityTypeInfosMap(entityTypeInfosMap);
				
			 HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> returnMapRequiredData = returnCommonLibBO().returnMapRequiredData(
				 criteria);		
			 SYS_PARAM_SCREEN_DISPLAYVO codeBusinessElementVO;
			 BigDecimal visibleSignInst = BigDecimal.ONE;
			 if(returnMapRequiredData != null && returnMapRequiredData.get("signatureCO.scanVO.SIGN_INSTRUCTIONS") != null)
			  {
			     codeBusinessElementVO = returnMapRequiredData.get("signatureCO.scanVO.SIGN_INSTRUCTIONS");
			     visibleSignInst = NumberUtil.nullEmptyToValue(codeBusinessElementVO.getIS_VISIBLE(), BigDecimal.ONE);
			  }
				 
			 if(BigDecimal.ZERO.compareTo(visibleSignInst)==0)
			  {  
			     signatureCO.getScanVO().setSIGN_INSTRUCTIONS("");
			  }
			
			if(SignatureConstant.ADD_MODE.equals(signatureCO.getViewMode()))
			{
			 // Bug 316141 -- [John Massaad] Get Image Extension and save it to S_SCAN.SC_FORMAT
				String imageName = signatureCO.getImageName();
				
				String SC_FORMAT="";
				 
				// Bug 316141 -- [John Massaad]Get Image Extension and save it to S_SCAN.SC_FORMAT 
				if(StringUtil.isNotEmpty(imageName))
				{
				    int index = imageName.lastIndexOf('.');
				 // Bug 340581 -- [John Massaad] reading the SC_FORMAT from signatureCO.getScanVO().getSC_FORMAT() rather than SC_FORMAT
		    if(-1 == index) // in case the image is scanned 
		    {
			SC_FORMAT = ConstantsCommon.SCANNED_EXT.substring(ConstantsCommon.SCANNED_EXT.lastIndexOf('.') + 1).toUpperCase();
			signTempFileName = imageName + ConstantsCommon.SCANNED_EXT;
			signFileDir = FileUtil.getFileURLByName("repository") + File.separator + "scanned"
				+ File.separator;
		    }
		    else // in case the image is imported from an existing file/folder.
		    {
			SC_FORMAT = (imageName.substring(index + 1)).toUpperCase();
			
		    }
		    signatureCO.getScanVO().setSC_FORMAT(SC_FORMAT);
		 // Bug 340581 -- [John Massaad] reading the SC_FORMAT from signatureCO.getScanVO().getSC_FORMAT() rather than SC_FORMAT
		}
		// Bug 316141 -- [John Massaad]Get Image Extension and save it to S_SCAN.SC_FORMAT
		signatureCO.getScanVO().setDEFAULT_UNLIMITED(
			(signatureCO.getUnlimitedFlag() != null && signatureCO.getUnlimitedFlag()) ? BigDecimal.ONE
				: BigDecimal.ZERO);
		
			    signatureCO.getScanVO().setDEFAULT_UNLIMITED((signatureCO.getUnlimitedFlag() != null && signatureCO.getUnlimitedFlag())?BigDecimal.ONE:BigDecimal.ZERO);
		if("C".equals(signOption))
		{
		    signatureCO.getSignObjectVO().setOLE_OBJECT(SignaturePadConverter.convertSignature(signCaptStr));
		    signatureCO.getCifObjectVO().setOBJECT_TYPE(SignatureConstant.SIGNATURE);
		    signatureCO.getScanVO().setDOC_TYPE(SignatureConstant.SIGNATURE);
		    signatureCO = signatureBO.addSignatureDetails(signatureCO);
		}
		else
		{
		    File signImage = new PathFileSecure(signFileDir, signTempFileName);
				//limit the size of the file to be below of 200 MB = 200000000 bytes 
				signatureCO.getSignObjectVO().setOLE_OBJECT(PathFileSecure.readFileToByteArray(signImage,200000000));
		    // signatureCO.getScanVO().setDOC_TYPE(SignatureConstant.SIGNATURE_FILE_TYPES.get(fileUploadContentType));
		    signatureCO.getScanVO().setDOC_TYPE(SignatureConstant.SIGNATURE);
		    // Bug 316141 -- [John Massaad] sending the Image Extension
		    // Bug 340581 -- [John Massaad] reading the SC_FORMAT from signatureCO.getScanVO().getSC_FORMAT() rather than SC_FORMAT 
		    signatureCO.getScanVO().setSC_FORMAT(signatureCO.getScanVO().getSC_FORMAT());
		    // Bug 340581 -- [John Massaad] reading the SC_FORMAT from signatureCO.getScanVO().getSC_FORMAT() rather than SC_FORMAT
		    signatureCO.getCifObjectVO().setOBJECT_TYPE(SignatureConstant.SIGNATURE);
		    
		    //#756390 - GAB180087 - Hala Al Sheikh 
		    AuditRefCO refCO = initAuditRefCO();
		    refCO.setKeyRef(AuditConstant.SIGNATURE_KEY_REF);
		    refCO.setOperationType(AuditConstant.CREATED);
		    signatureCO.setAuditRefCO(refCO);
		    //End GAB180087
		   
		    signatureCO = signatureBO.addSignatureDetails(signatureCO);
		    if(signatureCO != null)
		    {
			// EWBI160091 (403157)- reset the hidden value
			signatureCO.setCompCodeCif(NumberUtil.nullToZero(signatureCO.getCompCodeCif()));
		    }
		    boolean delReslt = signImage.delete();
		    // just to consume the result
		    log.debug("File " + signTempFileName + " delete operation = " + delReslt);
		}
	    }
			else if(SignatureConstant.EDIT_ALL_MODE.equals(signatureCO.getViewMode())){
		signatureCO.setAuditObj(returnAuditObject(signatureCO.getClass()));
		
		signatureCO.getScanVO().setDEFAULT_UNLIMITED((signatureCO.getUnlimitedFlag() != null && signatureCO.getUnlimitedFlag()) ? BigDecimal.ONE: BigDecimal.ZERO);
			        //BUG TP#803441 -BTII170018
				//signatureCO.getCifObjectVO().setAMOUNT_CY(sessionCO.getBaseCurrencyCode());//TODO need verify
		signatureCO.getCifObjectVO().setMODIFIED_BY(sessionCO.getUserName());
		//#756390 - GAB180087 - Hala Al Sheikh 
		 AuditRefCO refCO = initAuditRefCO();
		    refCO.setKeyRef(AuditConstant.SIGNATURE_KEY_REF);
		    refCO.setOperationType(AuditConstant.UPDATE);
		    signatureCO.setAuditRefCO(refCO);
		//End GAB180087		
		signatureCO = signatureBO.updateSignatureDetails(signatureCO);
	    }
			else if(SignatureConstant.EDIT_CHANGE_AMOUNT_MODE.equals(signatureCO.getViewMode())){
		signatureCO.setAuditObj(returnAuditObject(signatureCO.getClass()));
		
		signatureCO.getCifObjectVO().setMODIFIED_BY(sessionCO.getUserName());
		//#756390 - GAB180087 - Hala Al Sheikh 
		 AuditRefCO refCO = initAuditRefCO();
		    refCO.setKeyRef(AuditConstant.SIGNATURE_KEY_REF);
		    refCO.setOperationType(AuditConstant.UPDATE);
		    signatureCO.setAuditRefCO(refCO); 
		//End GAB180087		
		signatureCO = signatureBO.updateSignatureDetails(signatureCO);

	    }

	}
	catch(IOException e)
	{
	    handleException(e, null, null);
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
			handleException(e, null, null);
	}
	return SUCCESS;
    }
	
	
	public String deleteSignatures() {
		SessionCO sessionCO =returnSessionObject();
		 for (SignatureCO signatureCO: signatureCOList) {
			signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());//branch code will be send from client			
			signatureCO.getCifObjectVO().setDELETED_BY(sessionCO.getUserName());
			signatureCO.applyTraceProps(sessionCO.getCurrentAppName(), sessionCO.getUserName(), get_pageRef());
		}		
		try {
		    	//#756390 - GAB180087 - Commented by Hala Al Sheikh 
		    	//AuditRefCO refCO = initAuditRefCO();
		    	//signatureCO.setAuditRefCO(refCO);
                	if(signatureCOList != null && signatureCOList.size() > 0)
                	{
                	   signatureCO.getCifObjectVO().setBRANCH_CODE(signatureCOList.get(0).getCifObjectVO().getBRANCH_CODE());
                	   signatureCO.getCifObjectVO().setACC_CY(signatureCOList.get(0).getCifObjectVO().getACC_CY());
                	   signatureCO.getCifObjectVO().setACC_GL(signatureCOList.get(0).getCifObjectVO().getACC_GL());
                	   signatureCO.getCifObjectVO().setACC_CIF(signatureCOList.get(0).getCifObjectVO().getACC_CIF());
                	   signatureCO.getCifObjectVO().setACC_SL(signatureCOList.get(0).getCifObjectVO().getACC_SL());
                	}
		    	signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());
		    	signatureCO.setRunningDate(sessionCO.getRunningDateRET());
		    	//#756390 - GAB180087 - Hala Al Sheikh 
			signatureCO.setUserId(sessionCO.getUserName());
			signatureCO.setCompCode(sessionCO.getCompanyCode());
			signatureCO.setLoginBraCode(sessionCO.getBranchCode());
			if(signatureCO != null)
			{
			    set_auditJsonStr(returnSerializedStrFromObj(signatureCO));
			}
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.SIGNATURE_KEY_REF);
			refCO.setOperationType(AuditConstant.DELETE);
			signatureCO.setAuditRefCO(refCO);
			signatureCO.setAuditObj(returnAuditObject(signatureCO.getClass()));
			//End GAB180087		    	
		    	signatureCO = signatureBO.deleteSignatures(signatureCOList, signatureCO);
	    if(signatureCO != null)
	    {
		// EWBI160091 (403157)- reset the hidden value
		signatureCO.setCompCodeCif(NumberUtil.nullToZero(signatureCO.getCompCodeCif()));
	    }
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);

		}
		
		return SUCCESS;
	}
	
	
	public String approveSignatures(){
		SessionCO sessionCO =returnSessionObject();		
		 for (SignatureCO signatureCO: signatureCOList) {
			signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());//branch code will be send from client			 
			//signatureCO.setSignatureTp("C");
			signatureCO.getCifObjectVO().setAUTHORISED_BY(sessionCO.getUserName());
			
		}		
		try {
		    signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());
		    signatureCO.setRunningDate(sessionCO.getRunningDateRET());
		    signatureCO = signatureBO.approveSignatures(signatureCOList, signatureCO);
		} catch (BaseException e) {
			handleException(e, null, null);
		}
		
		return SUCCESS;
	
	
		
	}
	
	public String rejectSignatures(){	
		try {
			SessionCO sessionCO =returnSessionObject();
			 for (SignatureCO signatureCO: signatureCOList) {
				signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());//branch code will be send from client				 
			}	
		    	signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());
		    	signatureCO.setRunningDate(sessionCO.getRunningDateRET());
		    	signatureCO = signatureBO.rejectSignatures(signatureCOList, signatureCO);
		} catch (BaseException e) {
			handleException(e, null, null);
		}
		
		return SUCCESS;
	
	}
	
	
	
	public String saveDocument(){
		try {
		SessionCO sessionCO =returnSessionObject();
		setSignatureCOProperties();			
		//signatureCO.getScanVO().setDOC_TYPE(SignatureConstant.DOCUMENT);
		signatureCO.getCifObjectVO().setDEFAULT_PHOTO(signatureCO.isDefaultPhoto()?BigDecimal.ONE:BigDecimal.ZERO);
		if(SignatureConstant.ADD_MODE.equals(signatureCO.getViewMode())){
			File signImage = new PathFileSecure(signFileDir, signTempFileName);
			//limit the size of the file to be below of 200 MB = 200000000 bytes 
			signatureCO.getSignObjectVO().setOLE_OBJECT(PathFileSecure.readFileToByteArray(signImage,200000000));			
			signatureCO.getCifObjectVO().setOBJECT_TYPE(SignatureConstant.DOCUMENT);					
			signatureBO.addDocumentDetails(signatureCO);
			boolean delReslt = signImage.delete();
			//just to consume the result
			log.debug("File "+signTempFileName+" delete operation = "+delReslt);
		}
		else{
			signatureCO.getCifObjectVO().setMODIFIED_BY(sessionCO.getUserName());			
			signatureBO.updateDocumentDetails(signatureCO);
		}
		} catch (IOException e) {
			handleException(e, null,null);
			e.printStackTrace();

		} catch (BaseException e) {
			handleException(e, null,null);
			e.printStackTrace();
		}
		catch (Exception e)
		{
			handleException(e, null,null);
		}
		return SUCCESS;
		
		
		
		
	}
	 
	public String deleteDocuments() {
		SessionCO sessionCO =returnSessionObject();
		 for (SignatureCO signatureCO: signatureCOList) {
			signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());//branch code will be send from client			
			signatureCO.getCifObjectVO().setDELETED_BY(sessionCO.getUserName());
		}		
		try {
			signatureBO.deleteDocuments(signatureCOList);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	public String approveDocuments(){
		SessionCO sessionCO =returnSessionObject();		
		 for (SignatureCO signatureCO: signatureCOList) {
			signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());//branch code will be send from client			
			signatureCO.getCifObjectVO().setAUTHORISED_BY(sessionCO.getUserName());
			
		}		
		try {
			signatureBO.approveDocuments(signatureCOList);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	
	
		
	}
	
	
	public String rejectDocuments(){
		SessionCO sessionCO =returnSessionObject();
		 for (SignatureCO signatureCO: signatureCOList) {
			signatureCO.getCifObjectVO().setCOMP_CODE(sessionCO.getCompanyCode());//branch code will be send from client				 
		}		
		try {
			signatureBO.rejectDocuments(signatureCOList);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	
	}
	
 
	/**
	 * loading image from saved file under repository
	 */
	 public void loadImage()
	    {
		String fileName = fileImgPath;
		try
		{
		    byte[] data = new byte[0];
		    if(!StringUtil.nullToEmpty(fileName).isEmpty())
		    {
			String newPath = signFileDir + fileName;
			File file = new PathFileSecure(newPath);
			if(file.exists())
			{
			    FileInputStream fos = new FileInputStream(file);
			    byte[] b = new byte[fos.available()];
			    fos.read(b);
			    fos.close();
			    data = b;
			}
		    }
		    HttpServletResponse response = ServletActionContext.getResponse();
		    response.setContentLength(data.length);
		    //#BUG 678996 image preview not available in IE
		    response.setContentType(fileUploadContentType);
		    ServletOutputStream ouputStream = response.getOutputStream();
		    ouputStream.write(data, 0, data.length);
		    ouputStream.flush();
		    ouputStream.close();
		}
		catch(Exception e)
		{
		    log.error(e, "Image could not be loaded loadImage method");
		}
	    }
	
	

	public String uploadSignatureImg() throws Exception{	
		if(!signTempFileName.isEmpty()){//if not empty that means a different file has been selected and the previous one should be deleted
		 File oldFile = null;
		try
		{
		    oldFile = new PathFileSecure(signFileDir, signTempFileName);
		}
		catch(Exception e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		 boolean delReslt=  oldFile.delete();
		//just to consume the result
		 log.debug("File "+signTempFileName+" delete operation = "+delReslt);
		}
		File signFolder = new PathFileSecure(signFileDir);
		
		try
        	{
        	    if(fileUploadContentType != null && !fileUploadContentType.startsWith("image"))
            
            	    {
            		// throw new BOException("invalid file type");
            
            	    }
            	    String fileExt = FilenameUtils.getExtension(fileUploadFileName);
        	    if(fileExt != null && !fileExt.equalsIgnoreCase("JPG") && !fileExt.equalsIgnoreCase("JPEG")
        		    && !fileExt.equalsIgnoreCase("JFIF") && !fileExt.equalsIgnoreCase("TIFF")
        		    && !fileExt.equalsIgnoreCase("GIF") && !fileExt.equalsIgnoreCase("PNG")
        		    && !fileExt.equalsIgnoreCase("BMP")
        		    && !fileExt.equalsIgnoreCase("BPG") && !fileExt.equalsIgnoreCase("WebP") )
        	    {
        		throw new BOException("invalid file type");
        
        	    }
        	}
        	catch(Exception ex)
        	{
        	    handleException(ex, null, null);
        
        	}

        	if(!signFolder.exists())
        	{
        	    boolean mkDirReslt = signFolder.mkdir();
        	    // just to consume the result
        	    log.debug("Directory " + signFileDir + " create operation = " + mkDirReslt);
            	}

		
		//File destination = new File(signFileDir, fileUpload.getName());		
		//boolean renameRslt = fileUpload.renameTo(destination);
		 // just to consume the result
    	    	//log.debug("Rename of File " + fileUpload.getName() + "  operation = " + renameRslt);
        	byte[] content = null ;
		try
		{
		    //limit the size of the file to be below of 200 MB = 200000000 bytes 
		    content = PathFileSecure.readFileToByteArray(fileUpload,200000000);

		    double bytes =  content.length;
		    double kilobytes = (bytes / 1024);
		    PTH_CTRLVO pathCtrlVO  = signatureBO.getPTH_CTRLVO();
			if(pathCtrlVO==null)
			{
			    throw new BOException(MessageCodes.CANNOT_PROCEED);				
			}
			/*CDMI180131*/
		    if(  NumberUtil.nullToZero(pathCtrlVO.getSIGN_LIMIT_SIZE()).compareTo(BigDecimal.ZERO)>0  && new BigDecimal(kilobytes).compareTo(pathCtrlVO.getSIGN_LIMIT_SIZE()) > 0)
    		    {
			throw new BOException (MessageCodes.PARAM1_CANNOT_BE_GREATER_THAN_PARAM2, new String[] {getText("file_size_key"),String.valueOf(pathCtrlVO.getSIGN_LIMIT_SIZE())+" KB"});
    		    }
		  
		  
		}
		catch(IOException ioEx)
		{
		    handleException(ioEx, "Error in readFileToByteArray fileUpload", null);
		}
		catch(Exception ex)
		{
		    handleException(ex, null, null);
		}
		try
		{
		    FileOutputStream fOut = new FileOutputStream(signFileDir+fileUpload.getName());
		    fOut.write(content);
		    fOut.close();
		}
		catch(Exception ex)
		{
		    handleException(ex, "Error in function : saveToRepository, class: FileUtil", null);
		}
		
		try {
			fileImgPath = URLEncoder.encode(fileUpload.getName(),"UTF-8");
			 
		} catch (UnsupportedEncodingException e) {			 
			handleException(e, "Error in signature upload", null);
			 
		} 
		  
		 return "signUploadStatus";
	}
	

	
    public void loadGeneralAnnotation()
    {
	S_SIGN_ANNVO signAnnVO = new S_SIGN_ANNVO();
	signAnnVO.setCOMP_CODE(signatureSC.getCompCode());
	signAnnVO.setOBJECT_CODE(BigDecimal.ZERO);
	signAnnVO.setBRANCH_CODE(signatureSC.getBranchCode());
	signAnnVO.setCURRENCY_CODE(
		signatureSC.getCurrencyCode() == null ? BigDecimal.ZERO : signatureSC.getCurrencyCode());
	signAnnVO.setGL_CODE(signatureSC.getGlCode() == null ? BigDecimal.ZERO : signatureSC.getGlCode());
	signAnnVO.setCIF_SUB_NO(signatureSC.getCifNo());
	signAnnVO.setSL_NO(signatureSC.getSlNo() == null ? BigDecimal.ZERO : signatureSC.getSlNo());
	if("C".equals(signatureSC.getSignatureTp()))
	{
	    signAnnVO.setCURRENCY_CODE(BigDecimal.ZERO);
	    signAnnVO.setGL_CODE(BigDecimal.ZERO);
	    signAnnVO.setCIF_SUB_NO(signatureSC.getCifNo());
	    signAnnVO.setSL_NO(BigDecimal.ZERO);
	}
	try
	{
	    genAnnotation = signatureBO.retrieveGeneralAnnotation(signAnnVO);
	    
	    /**
	     * @author RaniaAlBitar AUBBH170088 - Signature Enquiry - CSM R14.1
	     */
	    
	    SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	    
	    if(signatureCO.getOpt() != null)
	    {
		SessionCO sessionCO = returnSessionObject();
		RequiredFieldsSC requiredFieldsSC = new RequiredFieldsSC();
		
		requiredFieldsSC.setCompCode(sessionCO.getCompanyCode());
		requiredFieldsSC.setBranchCode(sessionCO.getBranchCode());
		requiredFieldsSC.setAppName(sessionCO.getCurrentAppName());
		requiredFieldsSC.setProgRef(signatureCO.getOpt());
		requiredFieldsSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
		requiredFieldsSC.setLoginUserId(sessionCO.getUserName());
		requiredFieldsSC.setElementName("genAnnotation.ANNOTATION");
		
		businessElement = returnCommonLibBO().returnParamScreenDisplay(requiredFieldsSC);
	    }
	    else
	    {
		businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	    }
	    
	    if(businessElement == null)
	    {
		businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	    }

	    businessElement.setIS_READONLY(privilegeList.contains(SignatureConstant.SIGN002R) ? BigDecimal.ZERO : BigDecimal.ONE);
	    getAdditionalScreenParams().put("genAnnotation.ANNOTATION", businessElement);
	    
	    businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	    businessElement.setIS_READONLY(privilegeList.contains(SignatureConstant.SIGN002R) ? BigDecimal.ZERO : BigDecimal.ONE);
	    getAdditionalScreenParams().put("saveSignGenAnnoation", businessElement);
	    getAdditionalScreenParams().put("clearSignGenAnnoation", businessElement);
	}
	catch(BaseException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
	
	public String loadSignAnnotation()
	{
	    try
	    {
		signatureSC.setCompCode(returnSessionObject().getCompanyCode());
		if(NumberUtil.isEmptyDecimal(signatureCO.getCifObjectVO().getBRANCH_CODE()))
		{
		    signatureSC.setBranchCode(returnSessionObject().getBranchCode());
		}
		else
		{
		    signatureSC.setBranchCode(signatureCO.getCifObjectVO().getBRANCH_CODE());
		}
		signatureSC.setCurrencyCode(signatureCO.getCifObjectVO().getACC_CY());
		signatureSC.setGlCode(signatureCO.getCifObjectVO().getACC_GL());
		signatureSC.setCifNo(signatureCO.getCifObjectVO().getACC_CIF());
		signatureSC.setSlNo(signatureCO.getCifObjectVO().getACC_SL());
		loadGeneralAnnotation(); 
	    }
	    catch(Exception e)
	    {
		handleException(e, null, null);
	    }
	    return "sigAnnotationPage";
	}
	
	public String saveGeneralAnnotation(){
		SessionCO sessionCO =returnSessionObject();
		genAnnotation.setCOMP_CODE(sessionCO.getCompanyCode());
		genAnnotation.setOBJECT_CODE(BigDecimal.ZERO);			
		if(SignatureConstant.IS_CIF.equals(signatureSC.getSignatureTp())){
			genAnnotation.setCURRENCY_CODE(BigDecimal.ZERO);
			genAnnotation.setGL_CODE(BigDecimal.ZERO);
			genAnnotation.setSL_NO(BigDecimal.ZERO); 
	    }
		try {
			signatureBO.saveGeneralAnnotation(genAnnotation);
		} catch (BaseException e) {
			handleException(e,"Error Save Annotation", null);
			e.printStackTrace();
		}		
		return SUCCESS;
	}
	
	/**
	 * Returns limit amount based on groupId combination
	 * @param eg:signatureSC.groupIds :'AABCCCCD'
	 * @return limitSchemaVO: object which matches the groupIds combination or null
	 */
	public String returnLimitAmtForGroupCombination(){
		try {
			BigDecimal trxType =  new BigDecimal(signatureSC.getTrxType());
			String groupIdRegex = buildLimitSchemaGroupIdRegex();
			String groupIdsLov [];
			//signatureSC.setValidationDate(returnSessionObject().getRunningDateRET());
			signatureSC.setCompCode(returnSessionObject().getCompanyCode());
			groupIdsLov = groupIdRegex.split(",");
			List<LimitSchemaCO> limitSchemaCOList  = limitSchemaBO.returnLimitSchemaForACCOrCIF(signatureSC);
		
			/*This algorithm is to compare at each line of the signature, the schema of the related line with the the schema defined in CSMADMIN
			 * 
			 * */
			String caracterRetrieved = "";
			
			for (LimitSchemaCO limitSchemaCO : limitSchemaCOList) {
				String groupIds = getLimitSchemaGroupIds(limitSchemaCO);
				String doCalculation = "false";
				int ll_count_a = 0 ,  ll_count_b = 0 ,  ll_count_c = 0 ,  ll_count_d = 0 ,  ll_count_e = 0 ,  ll_count_f = 0 ,  ll_count_g = 0 ,  ll_count_h = 0 ,  ll_count_i = 0 ,  ll_count_j = 0 , numberOfLetterMatching = 0 , numberMatched = 0 , countLeterToMatch =0 ;
				for (int i=0; i<groupIds.length();i++)
				{
				    caracterRetrieved = groupIds.substring(i,i+1); 
				    if (caracterRetrieved.equals("A"))
				    {
					ll_count_a = ll_count_a + 1;
					if (ll_count_a == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				    else if (caracterRetrieved.equals("B"))
				    {
					ll_count_b = ll_count_b + 1;
					if (ll_count_b == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				    else if (caracterRetrieved.equals("C"))
				    {
					ll_count_c = ll_count_c + 1;
					if (ll_count_c == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				    else if (caracterRetrieved.equals("D"))
				    {
					ll_count_d = ll_count_d + 1;
					if (ll_count_d == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				    else if (caracterRetrieved.equals("E"))
				    {
					ll_count_e = ll_count_e + 1;
					if (ll_count_e == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				    else if (caracterRetrieved.equals("F"))
				    {
					ll_count_f = ll_count_f + 1;
					if (ll_count_f == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				    else if (caracterRetrieved.equals("G"))
				    {
					ll_count_g = ll_count_g + 1;
					if (ll_count_g == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				    else if (caracterRetrieved.equals("H"))
				    {
					ll_count_h = ll_count_h + 1;
					if (ll_count_h == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				    else if (caracterRetrieved.equals("I"))
				    {
					ll_count_i = ll_count_i + 1; 
					if (ll_count_i == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				    else if (caracterRetrieved.equals("J"))
				    {
					ll_count_j = ll_count_j + 1;
					if (ll_count_j == 1 )
					{
					 numberOfLetterMatching ++ ;
					}
				    }
				}
				
				
				 for (int i=0;i<groupIdsLov.length;i++)
				      {
				        if(!groupIdsLov[i].contains("{0}"))
				        {   
				            countLeterToMatch++;
				            /*If every letter matches with the same count of CSMADMIN configuration */
					  if ((groupIdsLov[i].contains("A")&& groupIdsLov[i].contains("{"+ll_count_a+"}"))|| (groupIdsLov[i].contains("B")&& groupIdsLov[i].contains("{"+ll_count_b+"}")) || (groupIdsLov[i].contains("C")&& groupIdsLov[i].contains("{"+ll_count_c+"}"))
						|| (groupIdsLov[i].contains("D")&& groupIdsLov[i].contains("{"+ll_count_d+"}")) || (groupIdsLov[i].contains("E")&& groupIdsLov[i].contains("{"+ll_count_e+"}")) || (groupIdsLov[i].contains("F")&& groupIdsLov[i].contains("{"+ll_count_f+"}"))
						|| (groupIdsLov[i].contains("G")&& groupIdsLov[i].contains("{"+ll_count_g+"}")) || (groupIdsLov[i].contains("H")&& groupIdsLov[i].contains("{"+ll_count_h+"}")) || (groupIdsLov[i].contains("I")&& groupIdsLov[i].contains("{"+ll_count_i+"}"))
						|| (groupIdsLov[i].contains("J")&& groupIdsLov[i].contains("{"+ll_count_j+"}")))
					  {
					    // doCalculation = "true";
					      numberMatched ++ ;
					  }
				        }
				      } /*If we have for ex: ACCB  the numberOfLetterMatching wil be = 3 and in case they are matching the numberMatched will be = 3*/
				  if (numberMatched == numberOfLetterMatching && countLeterToMatch == numberMatched )
				  {
				      doCalculation = "true";
				  }
				if(/*groupIds.matches(groupIdRegex)*/doCalculation.equals("true")){
					if(trxType.equals(limitSchemaCO.getLimitSchemaVO().getTRX_TYPE())||BigDecimal.ZERO.equals(limitSchemaCO.getLimitSchemaVO().getTRX_TYPE())){
						checkLimitAmtRange(limitSchemaCO.getLimitSchemaVO());
						limitSchemaVO =  limitSchemaCO.getLimitSchemaVO();
					}
					break;
				 }				
			}
			
			/**************************************/
			
		
			 
			
		} catch (BaseException e) {
			handleException(e,"", "");
			e.printStackTrace();
		}		
		return SUCCESS;
		
	}
	
	
	    private void checkLimitAmtRange(LIMIT_SCHEMAVO limitSchemaVO){         
	        BigDecimal limitMaxAmt = BigDecimal.valueOf(99999999999.99);
	        //Bug # 419101 EWBI160176 -- [John Massaad]
	        if(NumberUtil.emptyDecimalToZero(limitSchemaVO.getLIMIT_AMT()).compareTo(limitMaxAmt)>0){
	            limitSchemaVO.setLIMIT_AMT(limitMaxAmt);
	        }
	    }
	
	/**
	 * Concatenates all the group ids in to a single string
	 * @return
	 */
	private String getLimitSchemaGroupIds(LimitSchemaCO limitSchemaCO){
		LIMIT_SCHEMAVO limitSchemaVO = limitSchemaCO.getLimitSchemaVO();
		StringBuilder groupIds =  new StringBuilder();
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP1()));
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP2()));
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP3()));
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP4()));
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP5()));
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP6()));
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP7()));
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP8()));
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP9()));
		groupIds.append(StringUtil.nullToEmpty(limitSchemaVO.getGROUP10()));			
		return groupIds.toString();
		
	}
	
    private String buildLimitSchemaGroupIdRegex() throws BaseException
    {
	StringBuilder groupIdRegex = new StringBuilder();
	SelectSC selSC = new SelectSC(LimitSchemaConstant.LOV_TRANS_ID_LIMIT_SCHEMA);

	ArrayList<SelectCO> returnLOV = (ArrayList<SelectCO>) returnLOV(selSC);
	for(int i = 0; i < returnLOV.size(); i++)
	{
	    groupIdRegex.append(returnLOV.get(i).getCode());
	    groupIdRegex.append("{");
	    groupIdRegex.append(StringUtils.countMatches(signatureSC.getGroupIds(), returnLOV.get(i).getCode()));
	    groupIdRegex.append("}");
	    if(i + 1 < returnLOV.size())
	    {
		groupIdRegex.append(",");
	    }
		    }
		    groupIdRegex.append("?");		
		    
		return groupIdRegex.toString();
	}
	
	  
    /**
     * EWBI100037 -- [John Massaad]
     * This method is used to validate the signature expiry date. So if the Running date > signature Epiry date a cannot proceed exception is raised
     * The related signature is not allowed to be used
     * 
     * @return
     */
    public String validateCheckedSignatures()

    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    signatureCO.setCompCode(sessionObject.getCompanyCode());
	    signatureCO.setRunningDate(sessionObject.getRunningDateRET());
	    signatureCO.setUserId(sessionObject.getUserName());
	    signatureCO.setPreferredLanguage(sessionObject.getPreferredLanguage());

	    if(StringUtil.isNotEmpty(signatureCO.getCheckedSignaturesGridUpdates()))
	    {
		GridUpdates gu = getGridUpdates(signatureCO.getCheckedSignaturesGridUpdates(), SignatureCO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    signatureCO.setCheckedSignaturesList((gu.getLstAllRec()));
		}
	    }

	    signatureCO = signatureBO.validateCheckedSignatures(signatureCO);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


  //Added by Maria Chamieh for SBI170183
    public String dependencyByIdNo()

    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    signatureCO.setCompCode(sessionObject.getCompanyCode());
	    signatureCO.setPreferredLanguage(sessionObject.getPreferredLanguage());

	    signatureCO = signatureBO.dependencyByIdNo(signatureCO);

	}
	catch(Exception e)
	{
	    signatureCO.getScanVO().setID_NO(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setSignGroupList(List<SelectSC> signGroupList)
    {
	this.signGroupList = signGroupList;

    }

	
	

    //Hala Al sheikh - BUG SBI200093 
    public String dependencyByAuthCifNo()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    signatureCO.setCompCode(sessionObject.getCompanyCode());
	    signatureCO.setUserId(sessionObject.getUserName());
	    signatureCO.setPreferredLanguage(sessionObject.getPreferredLanguage());
	    signatureCO = signatureBO.dependencyByAuthCif(signatureCO);
	    setDefaultedIDReadOnly(signatureCO.isIdDefaulted());//id:1077811 Details:SBI200521 - Creating a CIF for Mandate Signature in Asaan Account falha TAR:SBI200521
	}
	catch(Exception e)
	{
	    setDefaultedIDReadOnly(false);//id:1077811 Details:SBI200521 - Creating a CIF for Mandate Signature in Asaan Account falha TAR:SBI200521
	    signatureCO.getCifObjectVO().setAUTH_CIF_NO(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    //End Hala
    

	public List<SelectSC> getSignGroupList() {
		return signGroupList;
	}

	public void setSignatureCO(SignatureCO signatureCO) {
		this.signatureCO = signatureCO;
	}

	public SignatureCO getSignatureCO() {
		return signatureCO;
	}
	public SignatureSC getSignatureSC() {
		return signatureSC;
	}

	public void setSignatureSC(SignatureSC signatureSC) {
		this.signatureSC = signatureSC;
	}
	public void setSignatureCOList(List<SignatureCO> signatureCOList) {
		this.signatureCOList = signatureCOList;
	}
	public List<SignatureCO> getSignatureCOList() {
		return signatureCOList;
	}
	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	public void setFileImgPath(String fileImgPath) {
		this.fileImgPath = fileImgPath;
	}
	public String getFileImgPath() {
		return fileImgPath;
	}
	public String getSignTempFileName() {
		return signTempFileName;
	}
	public void setSignTempFileName(String signTempFileName) {
		this.signTempFileName = signTempFileName;
	}
	public void setTstMsg(String tstMsg) {
		this.tstMsg = tstMsg;
	}
	public String getTstMsg() {
		return tstMsg;
	}
	public void setPrivilegeList(ArrayList<String> privilegeList) {
		this.privilegeList = privilegeList;
	}
	public ArrayList<String> getPrivilegeList() {
		return privilegeList;
	}
	public void setGenAnnotation(S_SIGN_ANNVO genAnnotation) {
		this.genAnnotation = genAnnotation;
	}
	public S_SIGN_ANNVO getGenAnnotation() {
		return genAnnotation;
	}
	public void setSecondaryId(String secondaryId) {
		this.secondaryId = secondaryId;
	}
	public String getSecondaryId() {
		return secondaryId;
	}
 
	public void setSignAvailConfirmed(boolean signAvailConfirmed) {
		this.signAvailConfirmed = signAvailConfirmed;
	}
	public boolean isSignAvailConfirmed() {
		return signAvailConfirmed;
	}
	public void setSignOption(String signOption)
	{
	    this.signOption = signOption;
	}
	public String getSignOption()
	{
	    return signOption;
	}
	public void setSignCaptStr(String signCaptStr)
	{
	    this.signCaptStr = signCaptStr;
	}
	public String getSignCaptStr()
	{
	    return signCaptStr;
	}
 
	public boolean isCopySignAvailable() {
		return copySignAvailable;
	}


	public void setCopySignAvailable(boolean copySignAvailable) {
		this.copySignAvailable = copySignAvailable;
	}

	
	
	public boolean isDocTabVisible() {
		return docTabVisible;
	}


	public void setDocTabVisible(boolean docTabVisible) {
		this.docTabVisible = docTabVisible;
	}


	public boolean isPhotoTabVisible() {
		return photoTabVisible;
	}


	public void setPhotoTabVisible(boolean photoTabVisible) {
		this.photoTabVisible = photoTabVisible;
	}
	
 
	
	
	
	
	
	
	public TrxMgntCO getTrxMgntCO() {
		return trxMgntCO;
	}




	public void setTrxMgntCO(TrxMgntCO trxMgntCO) {
		this.trxMgntCO = trxMgntCO;
	}
	
	public void setLimitSchemaBO(LimitSchemaBO limitSchemaBO) {
		this.limitSchemaBO = limitSchemaBO;
	}


	public boolean isLimitSchemaTabVisible() {
		return limitSchemaTabVisible;
	}


	public void setLimitSchemaTabVisible(boolean limitSchemaTabVisible) {
		this.limitSchemaTabVisible = limitSchemaTabVisible;
	}


	public boolean isCopySignTabVisible() {
		return copySignTabVisible;
	}


	public void setCopySignTabVisible(boolean copySignTabVisible) {
		this.copySignTabVisible = copySignTabVisible;
	}


	public void setSignTabVisible(boolean signTabVisible) {
		this.signTabVisible = signTabVisible;
	}


	public boolean isSignTabVisible() {
		return signTabVisible;
	}


	public LIMIT_SCHEMAVO getLimitSchemaVO() {
		return limitSchemaVO;
	}


	public void setLimitSchemaVO(LIMIT_SCHEMAVO limitSchemaVO) {
		this.limitSchemaVO = limitSchemaVO;
	}


	public List<SelectCO> getKeySignInstructionsList()
	{
	    return keySignInstructionsList;
	}

	public void setKeySignInstructionsList(List<SelectCO> keySignInstructionsList)
	{
	    this.keySignInstructionsList = keySignInstructionsList;
	}

	public SigCapSignatureCO getSigCapSignatureCO()
	{
	    return sigCapSignatureCO;
	}




	public void setCoreCommonBO(CoreCommonBO coreCommonBO)
	{
	    this.coreCommonBO = coreCommonBO;
	}




	public void setSigCapSignatureCO(SigCapSignatureCO sigCapSignatureCO)
	{
	    this.sigCapSignatureCO = sigCapSignatureCO;
	}
	
}
