/**
 * 
 */
package com.path.vo.common.trxtypecharges;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRXTYPE_CHARGESVO;

public class TrxTypeChargesCommonCO extends  CTSTRXTYPE_CHARGESVO implements Serializable
{
	private String TRX_TYPE_NAME;
	private String CHARGE_NAME;
	private String TRX_TYPE_STATUS;
	private CTSTELLERVO ctsTellerVO = new CTSTELLERVO() ;
	private String cifStatus;
	private String iv_crud;
	private Date cif_UpdateDate ;
	private BigDecimal CIF_NO;
    private BigDecimal COMP_CODE;
    private Boolean accesByTeller=true;
    private Date runningDate;
    private BigDecimal compCodeCif;
    private String checkApprovedByAccess;
    
	public final String getCheckApprovedByAccess()
    {
        return checkApprovedByAccess;
    }
    public final void setCheckApprovedByAccess(String checkApprovedByAccess)
    {
        this.checkApprovedByAccess = checkApprovedByAccess;
    }
	public String getTRX_TYPE_NAME()
	{
		return TRX_TYPE_NAME;
	}
	public void setTRX_TYPE_NAME(String tRXTYPENAME)
	{
		TRX_TYPE_NAME = tRXTYPENAME;
	}
	public String getCHARGE_NAME()
	{
		return CHARGE_NAME;
	}
	public void setCHARGE_NAME(String cHARGENAME)
	{
		CHARGE_NAME = cHARGENAME;
	}
	public CTSTELLERVO getCtsTellerVO()
	{
		return ctsTellerVO;
	}
	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
	{
		this.ctsTellerVO = ctsTellerVO;
	}
	public String getCifStatus()
	{
		return cifStatus;
	}
	public void setCifStatus(String cifStatus)
	{
		this.cifStatus = cifStatus;
	}
	public String getIv_crud()
	{
		return iv_crud;
	}
	public void setIv_crud(String ivCrud)
	{
		iv_crud = ivCrud;
	}
	public Date getCif_UpdateDate()
	{
		return cif_UpdateDate;
	}
	public void setCif_UpdateDate(Date cifUpdateDate)
	{
		cif_UpdateDate = cifUpdateDate;
	}
	public BigDecimal getCIF_NO()
	{
		return CIF_NO;
	}
	public void setCIF_NO(BigDecimal cIFNO)
	{
		CIF_NO = cIFNO;
	}
	public BigDecimal getCOMP_CODE()
	{
		return COMP_CODE;
	}
	public void setCOMP_CODE(BigDecimal cOMPCODE)
	{
		COMP_CODE = cOMPCODE;
	}
	public String getTRX_TYPE_STATUS()
	{
		return TRX_TYPE_STATUS;
	}
	public void setTRX_TYPE_STATUS(String tRXTYPESTATUS)
	{
		TRX_TYPE_STATUS = tRXTYPESTATUS;
	}
	public Boolean getAccesByTeller()
	{
		return accesByTeller;
	}
	public void setAccesByTeller(Boolean accesByTeller)
	{
		this.accesByTeller = accesByTeller;
	}
	public Date getRunningDate()
	{
	    return runningDate;
	}
	public void setRunningDate(Date runningDate)
	{
	    this.runningDate = runningDate;
	}
	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}
	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}
}
