package com.path.dao.core.certificate.impl;

import java.util.List;

import com.path.dao.core.certificate.CertificateCodeLookupDAO;
import com.path.dbmaps.vo.CTSCERTIFICATEACCVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.certificate.CertificateLookupCO;
import com.path.vo.core.certificate.CertificateLookupSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CertificateCodeLookupDAOImpl.java used to
 */
public class CertificateCodeLookupDAOImpl extends BaseDAO implements CertificateCodeLookupDAO
{
    /**
     * Method used to return Lookup Count of CertificateCode
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */	       	
    public int returnCertificateLookupCount(CertificateLookupSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "certificateLookupMapper.resCertificateLookupMap");
	return ((Integer) getSqlMap().queryForObject("certificateLookupMapper.returnCertificateLookupCount", criteria))
		.intValue();
    }

    /**
     * Method used to return Lookup of CertificateCode
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List returnCertificateLookup(CertificateLookupSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "certificateLookupMapper.resCertificateLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("certificateLookupMapper.returnCertificateLookup", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("certificateLookupMapper.returnCertificateLookup", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    /**
     * Method used to return dependency for CertificateCode
     * 
     * @param criteria Search Criteria Parameter
     * @return CTSCERTIFICATEVO Result Object
     * @throws DAOException
     */
    public CertificateLookupCO dependencyForCertificateCode(CertificateLookupSC criteria) throws DAOException
    {
	return (CertificateLookupCO) getSqlMap().queryForObject("certificateLookupMapper.dependencyForCertificate", criteria);
    }

    @Override
    public CTSCERTIFICATEACCVO returnCreditAccFromCertificate(CertificateLookupSC criteria) throws DAOException
    {
	return (CTSCERTIFICATEACCVO) getSqlMap().queryForObject("certificateLookupMapper.returnCreditAccFromCertificate", criteria);
    }
}
