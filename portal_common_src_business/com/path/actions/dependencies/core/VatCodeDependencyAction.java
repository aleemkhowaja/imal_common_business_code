package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.vatcode.VatCodeBO;
import com.path.dbmaps.vo.TRSVATVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.vatcode.VatCodeSC;

public class VatCodeDependencyAction extends RetailBaseAction{
	
	private VatCodeBO vatCodeBO;	
	private TRSVATVO vatCodeVO;	
	VatCodeSC vatCodeSC;	
	public String dependancyByVatCode()
	{
		try 
		{
			SessionCO sessionCO = returnSessionObject();
			vatCodeSC.setCompCode(sessionCO.getCompanyCode());
			vatCodeSC.setBranchCode(sessionCO.getBranchCode());
			vatCodeVO = vatCodeBO.returnVatCodeById(vatCodeSC);
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in DependancyBy vatCode method");
			vatCodeVO = new TRSVATVO();
			handleException(e, null, null);
		}

		return SUCCESS;
	}
	
	public void setVatCodeBO(VatCodeBO vatCodeBO) {
		this.vatCodeBO = vatCodeBO;
	}


	public TRSVATVO getVatCodeVO() {
		return vatCodeVO;
	}

	public void setVatCodeVO(TRSVATVO vatCodeVO) {
		this.vatCodeVO = vatCodeVO;
	}

	

	public VatCodeSC getVatCodeSC() {
		return vatCodeSC;
	}


	public void setVatCodeSC(VatCodeSC vatCodeSC) {
		this.vatCodeSC = vatCodeSC;
	}
}
