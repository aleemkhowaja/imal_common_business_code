package com.path.vo.core.certificate;

import com.path.dbmaps.vo.CTSCERTIFICATEACCVO;
import com.path.dbmaps.vo.CTSCERTIFICATEVO;
import com.path.vo.core.common.RetailBaseVO;

public class CertificateLookupCO extends RetailBaseVO
{
    private CTSCERTIFICATEVO ctscertificateVO = new CTSCERTIFICATEVO();
    private CTSCERTIFICATEACCVO ctscertificateAccVO = new CTSCERTIFICATEACCVO();
    
    public void setCtscertificateVO(CTSCERTIFICATEVO ctscertificateVO)
    {
	this.ctscertificateVO = ctscertificateVO;
    }
    public CTSCERTIFICATEVO getCtscertificateVO()
    {
	return ctscertificateVO;
    }
    public void setCtscertificateAccVO(CTSCERTIFICATEACCVO ctscertificateAccVO)
    {
	this.ctscertificateAccVO = ctscertificateAccVO;
    }
    public CTSCERTIFICATEACCVO getCtscertificateAccVO()
    {
	return ctscertificateAccVO;
    }
    
}