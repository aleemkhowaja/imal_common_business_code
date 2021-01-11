package com.path.dao.core.certificate;

import java.util.List;

import com.path.dbmaps.vo.CTSCERTIFICATEACCVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.certificate.CertificateLookupCO;
import com.path.vo.core.certificate.CertificateLookupSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryDAO.java used to
 */
public interface CertificateCodeLookupDAO
{
    public int returnCertificateLookupCount(CertificateLookupSC criteria) throws DAOException;

    public List returnCertificateLookup(CertificateLookupSC criteria) throws DAOException;

    public CertificateLookupCO dependencyForCertificateCode(CertificateLookupSC criteria) throws DAOException;

    public CTSCERTIFICATEACCVO returnCreditAccFromCertificate (CertificateLookupSC criteria) throws DAOException;
}