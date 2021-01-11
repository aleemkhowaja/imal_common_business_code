package com.path.vo.core.account;

import com.path.dbmaps.vo.CTS_MAIL_DETVO;
import com.path.vo.core.common.RetailBaseVO;

public class CtsMailDetCO extends  RetailBaseVO
{
	CTS_MAIL_DETVO mailDetVO=new CTS_MAIL_DETVO() ;
	private String CHARGE_NAME;
	public CTS_MAIL_DETVO getMailDetVO()
	{
		return mailDetVO;
	}
	public void setMailDetVO(CTS_MAIL_DETVO mailDetVO)
	{
		this.mailDetVO = mailDetVO;
	}
	public String getCHARGE_NAME()
	{
		return CHARGE_NAME;
	}
	public void setCHARGE_NAME(String cHARGENAME)
	{
		CHARGE_NAME = cHARGENAME;
	}
	
	
}