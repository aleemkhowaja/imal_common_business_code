package com.path.bo.core.certificatetypes;

import java.util.List;

import com.path.dbmaps.vo.CTSCERTIFICATE_TYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.certificatetypes.CertificateTypesSC;



public interface CertificateTypesBO

{
      public int getcertificateypesCount(CertificateTypesSC certificateTypesSC) throws BaseException;
	public List<CTSCERTIFICATE_TYPEVO> getcertificateTypesList(CertificateTypesSC certificateTypesSC) throws BaseException;
}
