package com.path.bo.core.certificatetypes.impl;

import java.util.List;

import com.path.bo.core.certificatetypes.CertificateTypesBO;
import com.path.dao.core.certificatetypes.CertificateTypesDAO;
import com.path.dbmaps.vo.CTSCERTIFICATE_TYPEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.certificatetypes.CertificateTypesSC;




public class CertificateTypesBOImpl extends BaseBO implements CertificateTypesBO
{
   
    
    private CertificateTypesDAO certificateTypesDAO;
    
    public int  getcertificateypesCount(CertificateTypesSC certificateTypesSC) throws BaseException
	{
	return certificateTypesDAO.getcertificateypesCount(certificateTypesSC);
	}

	public List<CTSCERTIFICATE_TYPEVO> getcertificateTypesList(CertificateTypesSC certificateTypesSC) throws BaseException
	{
	return certificateTypesDAO.getcertificateTypesList(certificateTypesSC);
	}

	public CertificateTypesDAO getCertificateTypesDAO()
	{
	    return certificateTypesDAO;
	}

	public void setCertificateTypesDAO(CertificateTypesDAO certificateTypesDAO)
	{
	    this.certificateTypesDAO = certificateTypesDAO;
	}

	
}
