package com.path.bo.core.certificate.impl;

import java.util.List;

import com.path.bo.core.certificate.CertificateLookupBO;
import com.path.dao.core.certificate.CertificateCodeLookupDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.certificate.CertificateLookupCO;
import com.path.vo.core.certificate.CertificateLookupSC;



/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CertificateLookupBOImpl.java used to
 */
public class CertificateLookupBOImpl extends BaseBO implements CertificateLookupBO
{
    CertificateCodeLookupDAO certificateCodeLookupDAO;
    
    /**
     * Method used to return Lookup Count of Certificate
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     */
    public int returnCertificateLookupCount(CertificateLookupSC criteria) throws BaseException
    {		
	return certificateCodeLookupDAO.returnCertificateLookupCount(criteria);
    }

    /**
     * Method used to return Lookup List of Certificate
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List returnCertificateLookup(CertificateLookupSC criteria) throws BaseException
    {
	return certificateCodeLookupDAO.returnCertificateLookup(criteria);
    }

    /**
     * Method used to return dependency of Certificate
     * 
     * @param criteria Search Criteria Parameter
     * @return CTSCERTIFICATEVO Result object for dependency
     * @throws BaseException
     */
    public CertificateLookupCO dependencyForCertificateCode(CertificateLookupSC criteria) throws BaseException
    {
	CertificateLookupCO certifcateLookupCO = new CertificateLookupCO();
	if(!NumberUtil.isEmptyDecimal(criteria.getCertificateCode()))
	{
	    certifcateLookupCO = certificateCodeLookupDAO.dependencyForCertificateCode(criteria);
	    if(certifcateLookupCO.getCtscertificateVO() == null)
	    {
		throw new BOException("Invalid/Missing Certificate Code");
	    }
	    
	    criteria.setBranchCode(certifcateLookupCO.getCtscertificateVO().getBRANCH());
	    certifcateLookupCO.setCtscertificateAccVO(certificateCodeLookupDAO.returnCreditAccFromCertificate(criteria));
	    if(certifcateLookupCO.getCtscertificateAccVO() == null)
	    {
		certifcateLookupCO.setCtscertificateVO(null);
		throw new BOException("Invalid/Missing Credit Account for the Certificate Code");
	    }
	}
	return certifcateLookupCO;
    }

    public CertificateCodeLookupDAO getCertificateCodeLookupDAO()
    {
        return certificateCodeLookupDAO;
    }

    public void setCertificateCodeLookupDAO(CertificateCodeLookupDAO certificateCodeLookupDAO)
    {
        this.certificateCodeLookupDAO = certificateCodeLookupDAO;
    }


}
