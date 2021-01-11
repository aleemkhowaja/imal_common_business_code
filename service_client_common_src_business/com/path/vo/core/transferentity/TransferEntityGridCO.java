package com.path.vo.core.transferentity;

import java.math.BigDecimal;
import com.path.dbmaps.vo.CTS_TRANSFER_ENTITY_DETVO;
import com.path.lib.vo.BaseVO;

public class TransferEntityGridCO extends BaseVO
{
	private CTS_TRANSFER_ENTITY_DETVO transferEntityDetVO = new CTS_TRANSFER_ENTITY_DETVO();
	private BigDecimal branchCode;
	private BigDecimal appNo;
	private String cifDesc;
	private String statusDesc;
	private String cifStatus;
	private String cifStatusDesc;
	

	public CTS_TRANSFER_ENTITY_DETVO getTransferEntityDetVO()
	{
		return transferEntityDetVO;
	}

	public void setTransferEntityDetVO(CTS_TRANSFER_ENTITY_DETVO transferEntityDetVO)
	{
		this.transferEntityDetVO = transferEntityDetVO;
	}

	
	public BigDecimal getBranchCode()
	{
		return branchCode;
	}

	
	public void setBranchCode(BigDecimal branchCode)
	{
		this.branchCode = branchCode;
	}

	
	public BigDecimal getAppNo()
	{
		return appNo;
	}

	
	public void setAppNo(BigDecimal appNo)
	{
		this.appNo = appNo;
	}

	
	public String getCifDesc()
	{
		return cifDesc;
	}

	
	public void setCifDesc(String cifDesc)
	{
		this.cifDesc = cifDesc;
	}

	
	public String getStatusDesc()
	{
		return statusDesc;
	}

	
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}

	
	public String getCifStatus()
	{
		return cifStatus;
	}

	
	public void setCifStatus(String cifStatus)
	{
		this.cifStatus = cifStatus;
	}

	
	public String getCifStatusDesc()
	{
		return cifStatusDesc;
	}

	
	public void setCifStatusDesc(String cifStatusDesc)
	{
		this.cifStatusDesc = cifStatusDesc;
	}
	
}
