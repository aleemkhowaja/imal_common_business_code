package com.path.dao.common.signature.impl;

 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dao.common.signature.SignatureDAO;
import com.path.dbmaps.vo.CIFOBJECTVO;
import com.path.dbmaps.vo.S_AUDIT_ACTIONSVO;
import com.path.dbmaps.vo.S_SCANVO;
import com.path.dbmaps.vo.S_SIGN_ANNVO;
import com.path.dbmaps.vo.S_SIGN_ANN_TEMPVO;
import com.path.dbmaps.vo.S_SIGN_MODIFVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.signature.SignatureSC;

public class SignatureDAOImpl extends BaseDAO implements SignatureDAO
{
    public ArrayList<String> returnSignatureProgReferences(SignatureSC signatureSC) throws DAOException
    {
	return (ArrayList<String>) getSqlMap().queryForList("signatureMapper.returnSignatureAccessRightsList", signatureSC);
    }
    
    public ArrayList<String> returnDocumentProgReferences(SignatureSC signatureSC) throws DAOException
    {
	return (ArrayList<String>) getSqlMap().queryForList("signatureMapper.returnDocumentAccessRightsList", signatureSC);
    }
    
    
    public ArrayList<String> returnPhotoProgReferences(SignatureSC signatureSC) throws DAOException
    {
	return (ArrayList<String>) getSqlMap().queryForList("signatureMapper.returnPhotoAccessRightsList", signatureSC);
    }
     
    public Integer returnMaxCifObjSeqValue(SignatureCO signatureCO) throws DAOException
    {
    return (Integer) getSqlMap().queryForObject("signatureMapper.returnMaxCifObjSeqValue", signatureCO);		
    }    
    public Integer returnMaxSignModifSeqValue(SignatureCO signatureCO) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("signatureMapper.returnMaxSignModifSeqValue", signatureCO);		
    }
    public void insertCIFOBJECT(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().insert("signatureMapper.insertCIFOBJECT", signatureSC);
    }
    public void insertSSignAnn(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().insert("signatureMapper.insertSSignAnn", signatureSC);
    }
    public void insertSObject(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().insert("signatureMapper.insertSObject", signatureSC);
    }
    public void insertSScan(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().insert("signatureMapper.insertSScan", signatureSC);
    }
    public void insertSSignModif(S_SIGN_MODIFVO signModifVO) throws DAOException
    {
	getSqlMap().insert("signatureMapper.insertSSignModif", signModifVO);
    }
    public void updateObjectBlob(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().update("signatureMapper.updateObjectBlob", signatureSC);
    }
    public void updateCIFOBJECT(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().update("signatureMapper.updateCIFOBJECT", signatureSC);
    }
    
    public void updateSSignModif(S_SIGN_MODIFVO ssignmodifVO) throws DAOException
    {
    	getSqlMap().update("signatureMapper.updateSSignModif", ssignmodifVO);
    }
   
    public SignatureCO returnSignatureBLOB(SignatureSC signatureSC) throws DAOException
    {
	return (SignatureCO) getSqlMap().queryForObject("signatureMapper.returnSignatureBLOB", signatureSC);
    }
    public String returnAnnotation(SignatureSC signatureSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("signatureMapper.returnAnnotation", signatureSC);
    }
    public void updateSScan(S_SCANVO s_scanVO) throws DAOException 
    {    
	getSqlMap().update("signatureMapper.updateSScan", s_scanVO);
    }
    public void deleteSSignAnn(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().delete("signatureMapper.deleteSSignAnn", signatureSC);
    }
    public void deleteSSignModif(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().delete("signatureMapper.deleteSSignModif", signatureSC);
    }
    public ArrayList<SignatureCO> returnSignaturesList(SignatureSC signatureSC) throws DAOException
    {
	return (ArrayList<SignatureCO>) getSqlMap().queryForList("signatureMapper.returnSignaturesList", signatureSC);
    }
    public ArrayList<SignatureCO> returnAllSignaturesList(SignatureSC signatureSC) throws DAOException
    {
	return (ArrayList<SignatureCO>) getSqlMap().queryForList("signatureMapper.returnAllSignaturesList", signatureSC);
    }
    public void updateCIFOBJECTPhoto(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().update("signatureMapper.updateCIFOBJECTPhoto", signatureSC);
    }
     
    public ArrayList<SignatureCO> returnSignaturesTempDeleteList(SignatureSC signatureSC) throws DAOException
    {
	return (ArrayList<SignatureCO>)getSqlMap().queryForList("signatureMapper.returnSignaturesTempDeleteList", signatureSC);
    }
    public ArrayList<SignatureCO> returnSignaturesTempApproveList(SignatureSC signatureSC) throws DAOException
    {
	return (ArrayList<SignatureCO>)getSqlMap().queryForList("signatureMapper.returnSignaturesTempApproveList", signatureSC);
    }
    public void updateSSignAnn(SignatureSC signatureSC) throws DAOException
    {
	getSqlMap().update("signatureMapper.updateSSignAnn", signatureSC);
    }

    
    /**
     * Retrieves signature form data 
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    
    public SignatureCO retrieveSignatureFormData(SignatureCO signatureCO)throws DAOException{
    	return  (SignatureCO) getSqlMap().queryForObject("signatureMapper.retrieveSignatureFormData", signatureCO);
    }
    
    /**
     * Retrieves all signatures for a CIF 
     * @return
     * @throws DAOException
     */
    public List<SignatureCO>  retrieveAllSignaturesForCIF(SignatureCO signatureCO)throws DAOException{
    	return  getSqlMap().queryForList("signatureMapper.selectSignatureViewAllForCIF", signatureCO);
    }
    
    /**
     * Retrieves all signatures for a Acc 
     * @return
     * @throws DAOException
     */
    public List<SignatureCO>  retrieveAllSignaturesForAcc(SignatureCO signatureCO)throws DAOException{
    	return  getSqlMap().queryForList("signatureMapper.selectSignatureViewAllForAcc", signatureCO);
    }


    
    /****
     * Method to select signature list based on the access privilege.
     * @param signatureSC
     * @return List<SignatureCO>
     * @throws DAOException
     */
    public List<SignatureCO> selectSignatureList(SignatureSC signatureSC) throws DAOException{
    	DAOHelper.fixGridMaps(signatureSC, getSqlMap(), "signatureMapper.returnSignaturesListMap");
    	return getSqlMap().queryForList("signatureMapper.selectSignatureList", signatureSC);
    }
    
    /**
     * Returns the signature count
     * @param signatureSC
     * @return
     * @throws DAOException
     */
    public Integer selectSignatureListCount(SignatureSC signatureSC) throws DAOException{    	 
    	return (Integer)getSqlMap().queryForObject("signatureMapper.selectSignatureListCount", signatureSC);
    }
    
    /****
     * Select the signature details for a specific signature
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public SignatureCO selectSignatureDetails(SignatureCO signatureCO)throws DAOException{
    	return (SignatureCO) getSqlMap().queryForObject("signatureMapper.selectSignatureDetails", signatureCO);
    }
    /****
     * Method for fetching the signature image for the specified account.
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public SignatureCO selectSignatureImageFromSObject(SignatureCO signatureCO) throws DAOException{    
    	return  (SignatureCO) getSqlMap().queryForObject("signatureMapper.selectSignatureImageSObject", signatureCO);    		 	
    }
    public SignatureCO selectSignatureImageFromSignModif(SignatureCO signatureCO) throws DAOException{    	
    	return  (SignatureCO) getSqlMap().queryForObject("signatureMapper.selectSignatureImageSSignModif", signatureCO);
    }
    
   
    
    /****
     * Method for getting signature annotation details for a specific account
     * @param signatureCO
     * @return
     */
    public S_SIGN_ANNVO selectSignatureAnnotation(SignatureCO signatureCO) throws DAOException{
    	return (S_SIGN_ANNVO) getSqlMap().queryForObject("signatureMapper.selectSignatureAnnotation", signatureCO);
    }
    
    /****
     * Method for update the signature annotation
     * @param signatureCO
     * @return
     */
    public Integer updateSignatureAnnotation(SignatureCO signatureCO) throws DAOException{
    	return getSqlMap().update("signatureMapper.updateSignatureAnnotation", signatureCO);
    }
    
    /****
     * Method for deleting the signature annotation
     * @param signatureCO
     * @return
     */
    public Integer deleteSignatureAnnotation(SignatureCO signatureCO) throws DAOException{
    	return getSqlMap().delete("signatureMapper.deleteSignatureAnnotation", signatureCO);
    }
    
    /****
     * Method for deleting the signature annotation
     * @param signatureCO
     * @return
     */
    public Object insertSignatureAnnotation(SignatureCO signatureCO) throws DAOException{
    	return getSqlMap().insert("signatureMapper.insertSignatureAnnotation", signatureCO);
    }
    
 
    
    /****
     * Method for update the counter table for locking the row.
     * @param signatureCO
     * @return
     */
/*    public Integer updateCounterForLocking(SignatureCO signatureCO) throws DAOException{
    	return getSqlMap().update("signatureMapper.updateCounterForLocking", signatureCO);
    }*/
    
    /****
     * Method for getting the Max value of object sequence from the table CIFOBJECT.
     * @param signatureCO
     * @return
     */
    public Long selectMaxObjectSequenceForSignature(SignatureCO signatureCO)throws DAOException{
    	return (Long)getSqlMap().queryForObject("signatureMapper.selectMaxObjectSequenceForSignature", signatureCO);
    }
    
    /**
     * Updates S_SIGN_ANN 
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public Object updateS_SIGN_ANN(SignatureCO signatureCO) throws DAOException{
    	return getSqlMap().update("signatureMapper.updateS_SIGN_ANN", signatureCO);
    }
    
    /**
     * Delete S_SIGN_ANN
     * @param signatureCO
     * @return
     * @throws DAOException
     */
    public Object deleteS_SIGN_ANN(SignatureCO signatureCO) throws DAOException{
    	return getSqlMap().delete("signatureMapper.deleteS_SIGN_ANN", signatureCO);
    }
    
  
    public Integer selectCountS_SIGN_ANN(S_SIGN_ANNVO signAnnVO) throws DAOException{
		return (Integer) getSqlMap().queryForObject("signatureMapper.selectCountS_SIGN_ANN", signAnnVO);		
    }
    
    public Integer selectCountS_SIGN_ANN_TEMP(S_SIGN_ANN_TEMPVO signAnnTempVO ) throws DAOException{
		return (Integer) getSqlMap().queryForObject("signatureMapper.selectCountS_SIGN_ANN_TEMP", signAnnTempVO);		
    }
    
    
    public SignatureCO populateSignatureCO(SignatureCO signatureCO)throws DAOException{
    	return (SignatureCO) getSqlMap().queryForObject("signatureMapper.populateSignatureCO", signatureCO);	
    }
 
    
    public ArrayList<SignatureCO> selectDocumentList(SignatureSC signatureSC)throws DAOException{
    	return (ArrayList<SignatureCO>) getSqlMap().queryForList("signatureMapper.selectDocumentList", signatureSC);	
    }
    
	@Override
	public SignatureCO selectDocumentDetails(SignatureCO signatureCO)throws DAOException{		 
		 return (SignatureCO) getSqlMap().queryForObject("signatureMapper.selectDocumentDetails", signatureCO);
	}
	
	
	public ArrayList<SignatureCO> retrieveSignatureAccounts(SignatureSC signatureSC)throws DAOException{
		return (ArrayList<SignatureCO>) getSqlMap().queryForList("signatureMapper.retrieveSignatureAccounts", signatureSC);	
		
	
	}
	public ArrayList<SignatureCO> retrieveCopySignatureList(SignatureCO signatureCO)throws DAOException{
		 return (ArrayList<SignatureCO>) getSqlMap().queryForList("signatureMapper.retrieveCopySignatureList", signatureCO);
	}
	
	public Integer selectCifObjectCount(SignatureCO signatureCO)throws DAOException{
		return (Integer) getSqlMap().queryForObject("signatureMapper.selectCifObjectCount", signatureCO);
	}
	
	public String selectEnforceSignLimit(SignatureSC signatureSC)throws DAOException{
		return (String) getSqlMap().queryForObject("signatureMapper.selectEnforceSignLimit", signatureSC);
	}
	
	public BigDecimal returnMaxAuditDetails(S_AUDIT_ACTIONSVO sAuditActionsVO)throws DAOException
	{
	    return (BigDecimal) getSqlMap().queryForObject("signatureMapper.returnMaxAuditDetails", sAuditActionsVO);
	}
	
	public Integer checkIfExistIdNo(SignatureCO signatureCO)throws DAOException{
		return (Integer) getSqlMap().queryForObject("signatureMapper.checkIfExistIdNo", signatureCO);
	}
	 //EWBI160037 -- [John Massaad]
	 public List<SignatureCO> checkAuthSignsInOriginalCIF(SignatureCO signatureCO) throws DAOException{
	     return getSqlMap().queryForList("signatureMapper.checkAuthSignsInOriginalCIF", signatureCO);
	 }
	 
	 //EWBI160037 -- [John Massaad]
	 public void updateAuthorizedSignsInOrgCIF(CIFOBJECTVO cifObjectVo) throws DAOException{
	      getSqlMap().update("signatureMapper.updateAuthorizedSignsInOrgCIF", cifObjectVo);
	 }
	 
	// Rania - 1077811 - SBI200521
        public Integer checkIfCifHasAccounts(SignatureCO signatureCO) throws DAOException
        {
    	   return (Integer) getSqlMap().queryForObject("signatureMapper.checkIfCifHasAccounts", signatureCO);
        }
        //

    
}