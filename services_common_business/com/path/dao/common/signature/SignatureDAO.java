package com.path.dao.common.signature;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CIFOBJECTVO;
import com.path.dbmaps.vo.S_AUDIT_ACTIONSVO;
import com.path.dbmaps.vo.S_SCANVO;
import com.path.dbmaps.vo.S_SIGN_ANNVO;
import com.path.dbmaps.vo.S_SIGN_ANN_TEMPVO;
import com.path.dbmaps.vo.S_SIGN_MODIFVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.signature.SignatureSC;

public interface SignatureDAO
{
    /**
     * 
     * @param signatureSC
     * @return
     * @throws DAOException
     */
	public ArrayList<String> returnSignatureProgReferences(SignatureSC signatureSC) throws DAOException;
	
	/**
	 * 
	 * @param signatureSC
	 * @return
	 * @throws DAOException
	 */
	public ArrayList<String> returnDocumentProgReferences(SignatureSC signatureSC) throws DAOException;
	
	/**
	 * 
	 * @param signatureSC
	 * @return
	 * @throws DAOException
	 */
	
	public ArrayList<String> returnPhotoProgReferences(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public Integer returnMaxCifObjSeqValue(SignatureCO signatureCO) throws DAOException;
    
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public Integer returnMaxSignModifSeqValue(SignatureCO signatureCO) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void insertCIFOBJECT(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void insertSSignAnn(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void insertSScan(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void insertSObject(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void insertSSignModif(S_SIGN_MODIFVO signModifVO) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void updateObjectBlob(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void updateCIFOBJECT(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void updateSSignModif(S_SIGN_MODIFVO ssignmodifVO) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws DAOException
     */
    public SignatureCO returnSignatureBLOB(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws DAOException
     */
    public String returnAnnotation(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void updateSScan(S_SCANVO s_scanVO) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void deleteSSignAnn(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void deleteSSignModif(SignatureSC signatureSC) throws DAOException;

    /**
     * 
     * @param signatureSC
     * @return
     * @throws DAOException
     */
    public ArrayList<SignatureCO> returnSignaturesList(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws DAOException
     */
    public ArrayList<SignatureCO> returnAllSignaturesList(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void updateCIFOBJECTPhoto(SignatureSC signatureSC) throws DAOException;
   
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws DAOException
     */
    public ArrayList<SignatureCO> returnSignaturesTempDeleteList(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws DAOException
     */
    public ArrayList<SignatureCO> returnSignaturesTempApproveList(SignatureSC signatureSC) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @throws DAOException
     */
    public void updateSSignAnn(SignatureSC signatureSC) throws DAOException;

    
    /**
     * Retrieves signature form data
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    
    public SignatureCO retrieveSignatureFormData(SignatureCO signatureCO)throws DAOException;
    
    /**
     * Retrieves all signatures for a CIF 
     * @return
     * @throws DAOException
     */
    public List<SignatureCO>  retrieveAllSignaturesForCIF(SignatureCO signatureCO)throws DAOException;
    
    
    /**
     * Retrieves all signatures for a Acc 
     * @return
     * @throws DAOException
     */
    public List<SignatureCO>  retrieveAllSignaturesForAcc(SignatureCO signatureCO)throws DAOException;

    
    /****
     * Method to select signature list based on the access privilege.
     * @param signatureSC
     * @return List<SignatureCO>
     * @throws DAOException
     */
    public List<SignatureCO> selectSignatureList(SignatureSC signatureSC) throws DAOException;
    
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws DAOException
     */
    public Integer selectSignatureListCount(SignatureSC signatureSC) throws DAOException;
    
    /****
     * Select the signature details for a specific signature
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public SignatureCO selectSignatureDetails(SignatureCO signatureCO)throws DAOException;
    
  
    
    /****
     * Method for getting signature annotation details for a specific account
     * @param signatureCO
     * @return
     */
    public S_SIGN_ANNVO selectSignatureAnnotation(SignatureCO signatureCO) throws DAOException;
    
    /****
     * Method for update the signature annotation
     * @param signatureCO
     * @return
     */
    public Integer updateSignatureAnnotation(SignatureCO signatureCO) throws DAOException;
    
    /****
     * Method for deleting the signature annotation
     * @param signatureCO
     * @return
     */
    public Integer deleteSignatureAnnotation(SignatureCO signatureCO) throws DAOException;
    
    /****
     * Method for deleting the signature annotation
     * @param signatureCO
     * @return
     */
    public Object insertSignatureAnnotation(SignatureCO signatureCO) throws DAOException;  
    
    /****
     * Method for update the counter table for locking the row from preventing another update since the table is a master table.
     * @param signatureCO
     * @return
     */
/*    public Integer updateCounterForLocking(SignatureCO signatureCO) throws DAOException;*/
    
    /****
     * Method for getting the Max value of object sequence from the table CIFOBJECT.
     * @param signatureCO
     * @return
     */
    public Long selectMaxObjectSequenceForSignature(SignatureCO signatureCO)throws DAOException;
    
    /**
     * Updates S_SIGN_ANN 
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public Object updateS_SIGN_ANN(SignatureCO signatureCO) throws DAOException ;
    
    /**
     * Delete S_SIGN_ANN
     * @param signatureCO
     * @return
     * @throws BaseException
     */
    public Object deleteS_SIGN_ANN(SignatureCO signatureCO) throws DAOException ;
    
    /**
     * Count of S_SIGN_ANN
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public Integer selectCountS_SIGN_ANN(S_SIGN_ANNVO signAnnVO) throws DAOException;
    
    /**
     *     
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public Integer selectCountS_SIGN_ANN_TEMP(S_SIGN_ANN_TEMPVO signAnnTempVO) throws DAOException;
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public SignatureCO populateSignatureCO(SignatureCO signatureCO)throws DAOException;
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    
    public SignatureCO selectSignatureImageFromSObject(SignatureCO signatureCO) throws DAOException;
    
    
    /**
     * 
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public SignatureCO selectSignatureImageFromSignModif(SignatureCO signatureCO) throws DAOException;
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws DAOException
     */
    public ArrayList<SignatureCO> selectDocumentList(SignatureSC signatureSC)throws DAOException;

    /**
     * 
     * @param signatureCO
     * @return
     */
	public SignatureCO selectDocumentDetails(SignatureCO signatureCO)throws DAOException;
	
	
	/**
	 * 
	 * @param signatureSC
	 * @return
	 * @throws DAOException
	 */
	public ArrayList<SignatureCO> retrieveSignatureAccounts(SignatureSC signatureSC)throws DAOException;
	
	/**
	 * 
	 * @param signatureCO
	 * @return
	 * @throws DAOException
	 */
	public ArrayList<SignatureCO> retrieveCopySignatureList(SignatureCO signatureCO)throws DAOException;
	
	/**
	 * 
	 * @param signatureCO
	 * @return
	 * @throws DAOException
	 */
	public Integer selectCifObjectCount(SignatureCO signatureCO)throws DAOException;
	
	/**
	 * 
	 * @param signatureSC
	 * @return
	 * @throws DAOException
	 */
	public String selectEnforceSignLimit(SignatureSC signatureSC)throws DAOException;
	
	/**
	 * EWBI160037 -- [John Massaad]
	 * @param signatureCO
	 * @return
	 * @throws DAOException
	 */
	public List<SignatureCO> checkAuthSignsInOriginalCIF(SignatureCO signatureCO) throws DAOException;
    
    
	public BigDecimal returnMaxAuditDetails(S_AUDIT_ACTIONSVO sAuditActionsVO)throws DAOException;
	
	/**
	 * 
	 * @param signatureCO
	 * @return
	 * @throws DAOException
	 */
	public Integer checkIfExistIdNo(SignatureCO signatureCO)throws DAOException;

	/**
	 * 
	 * @param signatureCO
	 * @return
	 * @throws DAOException
	 */
	public void updateAuthorizedSignsInOrgCIF(CIFOBJECTVO cifObjectVO) throws DAOException;
	
	public Integer checkIfCifHasAccounts(SignatureCO signatureCO) throws DAOException;

}
