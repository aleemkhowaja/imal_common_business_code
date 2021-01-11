 package com.path.bo.common.signature;

import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.S_AUDIT_ACTION_DTLVO;
import com.path.dbmaps.vo.S_SIGN_ANNVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.signature.SignatureSC;

public interface SignatureBO
{
 

    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO retrieveSignatureFormData(SignatureCO signatureCO)throws BaseException;
    
    
    /**
     * Retrieves all signatures for a CIF 
     * @return
     * @throws BaseException
     */
    public List<SignatureCO>  retrieveAllSignaturesForCIF(SignatureCO signatureCO)throws BaseException;
    
    /**
     * Retrieves all signatures for a Account
     * @return
     * @throws BaseException
     */
    public List<SignatureCO>  retrieveAllSignaturesForAcc(SignatureCO signatureCO)throws BaseException;
    
    /****
     * Method for selecting signatures based on the access privilege. 
     * @param signatureSC
     * @return
     * @throws BaseException
     */
    public List<SignatureCO> selectSignatureList(SignatureSC signatureSC)throws BaseException;
    
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws BaseException
     */
    
    public Integer selectSignatureListCount(SignatureSC signatureSC)throws BaseException;
    
 
   
	 /**
	  * Returns the copy signature list  
	  * @param signatureSC
	  * @return
	  * @throws BaseException
	  */
    public List<SignatureCO> selectCopySignatureList(SignatureSC signatureSC)throws BaseException;
    	
    /****
     * Method for generating the action type for signature screen based on the access privileges that the user holds. 
     * @param signatureSC
     * @return
     * @throws BaseException
     */
    public SignatureSC generateActionTypeBasedOnPrivileges(SignatureSC signatureSC)throws BaseException; 
    
    /****
     * Select the signature details for a specific signature
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO selectSignatureDetails(SignatureCO signatureCO)throws BaseException;
    
    /****
     * Method for getting the signature image for a specific account
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public byte[] selectSignatureImage(SignatureCO signatureCO) throws BaseException;
    
 
	
	/****
	 * Method for adding new signature for a specific CIF/Account
	 * @param signatureCO
	 * @return
	 * @throws BaseException
	 */
	public SignatureCO addSignatureDetails(SignatureCO signatureCO)throws BaseException;
	
	/**
	 * Method for updating signature for a specific CIF/Account
	 * @param signatureCO
	 * @return
	 * @throws BaseException
	 */
	
	public SignatureCO updateSignatureDetails(SignatureCO signatureCO)throws BaseException;
	
	/**
	 * 
	 * @param signatureCOList
	 * @throws BaseException
	 */
	public SignatureCO deleteSignatures(List<SignatureCO> signatureCOList, SignatureCO signatureCO)throws BaseException;
	
	/**
	 * 
	 * @param signatureCOList
	 * @throws BaseException
	 */
	
	public SignatureCO approveSignatures(List<SignatureCO> signatureCOList, SignatureCO signatureCO)throws BaseException;
	
	/**
	 * 
	 * @param signatureCOList
	 * @throws BaseException
	 */
	public SignatureCO rejectSignatures(List<SignatureCO> signatureCOList, SignatureCO signatureCO) throws BaseException;
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws BaseException
     */
    public ArrayList<String> getSignaturePrivilegeList(SignatureSC signatureSC)throws BaseException;
    
    /**
     * Returns document list
     * @param signatureSC
     * @return
     */
    
    public ArrayList<SignatureCO> selectDocumentList(SignatureSC signatureSC)throws BaseException;
    
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public  byte[] selectDocumentImage(SignatureCO signatureCO) throws BaseException;
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO selectDocumentDetails(SignatureCO signatureCO)throws BaseException ;
    
    
    /**
     * Add Document details
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO addDocumentDetails(SignatureCO signatureCO)throws BaseException;
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO updateDocumentDetails(SignatureCO signatureCO)throws BaseException;
    
    /**
     * 
     * @param signatureCOList
     * @throws BaseException
     */
    
    public void deleteDocuments(List<SignatureCO> signatureCOList)throws BaseException;
    
    /**
     * 
     * @param signatureCOList
     * @throws BaseException
     */
    public void approveDocuments(List<SignatureCO> signatureCOList)throws BaseException;
    
    
    /**
     * 
     * @param signatureCOList
     * @throws BaseException
     */
    public void rejectDocuments(List<SignatureCO> signatureCOList)throws BaseException;
    
    /**
     * Retrieves General annotation 
     * @param signatureCO
     * @throws BaseException
     */
    public S_SIGN_ANNVO retrieveGeneralAnnotation(S_SIGN_ANNVO signAnnVO)throws BaseException;
    
    
    /**
     * 
     * @param signAnnVO
     * @throws BaseException
     */
    public void saveGeneralAnnotation(S_SIGN_ANNVO signAnnVO)throws BaseException;
    
    /**
     * 
     * @param signatureCO
     * @throws BaseException
     */
    public ArrayList<SignatureCO> retrieveSignatureAccounts(SignatureSC signatureSC)throws BaseException;
    
    /**
     * 
     * @param signatureCO
     * @param copyAccSignatureCO
     * @throws BaseException
     */
    public void copySignature(SignatureCO signatureCO,SignatureCO copyAccSignatureCO)throws BaseException;
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public Integer selectCifObjectCount(SignatureCO signatureCO)throws BaseException;
    
    /**
     * 
     * @return
     * @throws BaseException
     */
    public PTH_CTRLVO getPTH_CTRLVO()throws BaseException;
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws BaseException
     */
    public ArrayList<String> getDocumentPrivilegeList(SignatureSC signatureSC)throws BaseException;
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws BaseException
     */
    public ArrayList<String> getPhotoPrivilegeList(SignatureSC signatureSC)throws BaseException;
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public ArrayList<SignatureCO> retrieveCopySignatureList(SignatureCO signatureCO) throws BaseException;
    
     
    
    /**
     * 
     * @return
     * @throws BaseException
     */
    public CURRENCIESVO getAccCurrencyDesc(CURRENCIESVOKey key) throws BaseException;
    
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws BaseException
     */
    public String selectEnforceSignLimit(SignatureSC signatureSC)throws BaseException;
    
    public void updateSignAudit(SignatureCO signatureCO, ArrayList<S_AUDIT_ACTION_DTLVO> sAuditActionDtlVOs,
	    String windowRef, String actionType) throws BaseException;

    
    public SignatureCO validateCheckedSignatures(SignatureCO signatureCO)throws BaseException;
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO dependencyByAuthCif(SignatureCO signatureCO)throws BaseException;
    
   
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO dependencyByIdNo(SignatureCO signatureCO)throws BaseException;


    
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public SignatureCO getSignCIFdetails(SignatureCO signatureCO)throws BaseException;
    
    public SignatureCO defaultIdByAuthSigAndInst(SignatureCO signatureCO) throws BaseException;
   
}