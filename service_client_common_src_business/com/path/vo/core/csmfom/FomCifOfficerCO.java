package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIF_OFFICERVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

 public class FomCifOfficerCO extends  RetailBaseVO
 {
	private CIF_OFFICERVO cifOfficerVO = new CIF_OFFICERVO();
	CTSTELLERVO ctsTellerVO = new CTSTELLERVO() ;
	private String deptDesc;
	private String divDesc;
	private String roleDesc;
	private BigDecimal compCode;
	private String saveType;
	private String cifStatus;
	private String language;
	private BigDecimal brancheCode;
	private String iv_crud;
	private Date cif_UpdateDate ;
	

	private Boolean accesByTeller=true;
   
	public BigDecimal getBrancheCode() {
		return brancheCode;
	}
	public void setBrancheCode(BigDecimal brancheCode) {
		this.brancheCode = brancheCode;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSaveType()
	{
	    return saveType;
	}
	public void setSaveType(String saveType)
	{
	    this.saveType = saveType;
	}
	 
	public String getDeptDesc()
	{
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc)
	{
		this.deptDesc = deptDesc;
	}
	public String getDivDesc()
	{
		return divDesc;
	}
	public void setDivDesc(String divDesc)
	{
		this.divDesc = divDesc;
	}
	public String getRoleDesc()
	{
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc)
	{
		this.roleDesc = roleDesc;
	}
	public void setCompCode(BigDecimal compCode)
	{
		this.compCode = compCode;
	}
	public BigDecimal getCompCode()
	{
		return compCode;
	}
	public CIF_OFFICERVO getCifOfficerVO()
	{
		return cifOfficerVO;
	}
	public void setCifOfficerVO(CIF_OFFICERVO cifOfficerVO)
	{
		this.cifOfficerVO = cifOfficerVO;
	}
	public CTSTELLERVO getCtsTellerVO()
	{
		return ctsTellerVO;
	}
	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
	{
		this.ctsTellerVO = ctsTellerVO;
	}
	public String getCifStatus() {
		return cifStatus;
	}
	public void setCifStatus(String cifStatus) {
		this.cifStatus = cifStatus;
	}
	public String getIv_crud() {
		return iv_crud;
	}
	public void setIv_crud(String ivCrud) {
		iv_crud = ivCrud;
	}
	public Date getCif_UpdateDate() {
		return cif_UpdateDate;
	}
	public void setCif_UpdateDate(Date cifUpdateDate) {
		cif_UpdateDate = cifUpdateDate;
	}
	public Boolean getAccesByTeller()
	{
		return accesByTeller;
	}
	public void setAccesByTeller(Boolean accesByTeller)
	{
		this.accesByTeller = accesByTeller;
	}
  
 }