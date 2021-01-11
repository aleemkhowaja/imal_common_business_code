package com.path.dao.core.certificatetypes.impl;

import java.util.List;

import com.path.dao.core.certificatetypes.CertificateTypesDAO;
import com.path.dbmaps.vo.CTSCERTIFICATE_TYPEVO;

import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.certificatetypes.CertificateTypesSC;


public class CertificateTypesDAOImpl  extends BaseDAO implements CertificateTypesDAO
{

    
    public int getcertificateypesCount(CertificateTypesSC certificateTypesSC) throws DAOException
	{
		DAOHelper.fixGridMaps(certificateTypesSC, getSqlMap(), "CTSCERTIFICATE_TYPESMapper.getTypesList_ResMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("CTSCERTIFICATE_TYPESMapper.getTypesCount", certificateTypesSC)).intValue();
		return nb;
	}


	public List<CTSCERTIFICATE_TYPEVO> getcertificateTypesList(CertificateTypesSC certificateTypesSC) throws DAOException
	{
		DAOHelper.fixGridMaps(certificateTypesSC, getSqlMap(), "CTSCERTIFICATE_TYPESMapper.getTypesList_ResMap");
		if(certificateTypesSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("CTSCERTIFICATE_TYPESMapper.getTypesList", certificateTypesSC);
		}
		else
		{
			return getSqlMap().queryForList("CTSCERTIFICATE_TYPESMapper.getTypesList", certificateTypesSC, certificateTypesSC.getRecToskip(), certificateTypesSC.getNbRec());
		}
	}
    
}
