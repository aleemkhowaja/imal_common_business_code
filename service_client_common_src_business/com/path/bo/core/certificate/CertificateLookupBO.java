package com.path.bo.core.certificate;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.certificate.CertificateLookupCO;
import com.path.vo.core.certificate.CertificateLookupSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CertificateLookupBO.java used to
 */
public interface CertificateLookupBO
{
    public int returnCertificateLookupCount(CertificateLookupSC criteria) throws BaseException;

    public List returnCertificateLookup(CertificateLookupSC criteria) throws BaseException;

    public CertificateLookupCO dependencyForCertificateCode(CertificateLookupSC criteria) throws BaseException;
}