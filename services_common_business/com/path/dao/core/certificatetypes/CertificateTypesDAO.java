package com.path.dao.core.certificatetypes;

import java.util.List;

import com.path.dbmaps.vo.CTSCERTIFICATE_TYPEVO;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.certificatetypes.CertificateTypesSC;

public interface CertificateTypesDAO
{

    public int getcertificateypesCount(CertificateTypesSC certificateTypesSC) throws DAOException;
	public List<CTSCERTIFICATE_TYPEVO> getcertificateTypesList(CertificateTypesSC certificateTypesSC) throws DAOException;
    
}
