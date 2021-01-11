package com.path.vo.core.csmfom;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIF_BANK_DETAILSVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.core.common.RetailBaseVO;

public class FomBankDetailsCO extends RetailBaseVO
{
	private CIF_BANK_DETAILSVO bankDetailsVO = new CIF_BANK_DETAILSVO();
	CTSTELLERVO ctsTellerVO = new CTSTELLERVO() ;
	private String currencyDesc;
	private String language;
	// For check Box on screen
	private Boolean ssiDefaultFlag;
	private String saveType;
	private String cifStatus;
	private String iv_crud;
	private Date cif_UpdateDate ;
	private String currency_Exists_with_flag ;
	private List<SelectCO> chatNonChatDropDown = new ArrayList<SelectCO>();
	private List<SelectCO> swiftChargeDropDown = new ArrayList<SelectCO>();
	private List<SelectCO> swiftTypeDropDown = new ArrayList<SelectCO>();
	private List<SelectCO> currencyUsageFlagDropDown = new ArrayList<SelectCO>();
	private List<SelectCO> appNameDropDown = new ArrayList<SelectCO>();
	private List<SelectCO> categoryDropDown = new ArrayList<SelectCO>();
	HashMap<String  ,SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement =new HashMap<String  ,SYS_PARAM_SCREEN_DISPLAYVO>();
	
	private Boolean accesByTeller=true;
	private String fromRetrieve;
	
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement() {
		return buisnessElement;
	}

	public void setBuisnessElement(
			HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement) {
		this.buisnessElement = buisnessElement;
	}

	public String getCurrency_Exists_with_flag() {
		return currency_Exists_with_flag;
	}

	public void setCurrency_Exists_with_flag(String currencyExistsWithFlag) {
		currency_Exists_with_flag = currencyExistsWithFlag;
	}

	public CIF_BANK_DETAILSVO getBankDetailsVO()
	{
		return bankDetailsVO;
	}

	public void setBankDetailsVO(CIF_BANK_DETAILSVO bankDetailsVO)
	{
		this.bankDetailsVO = bankDetailsVO;
	}

	public String getCurrencyDesc()
	{
		return currencyDesc;
	}

	public void setCurrencyDesc(String currencyDesc)
	{
		this.currencyDesc = currencyDesc;
	}

	public String getSaveType()
	{
		return saveType;
	}

	public void setSaveType(String saveType)
	{
		this.saveType = saveType;
	}

	public Boolean getSsiDefaultFlag()
	{
		return ssiDefaultFlag;
	}

	public void setSsiDefaultFlag(Boolean ssiDefaultFlag)
	{
		this.ssiDefaultFlag = ssiDefaultFlag;
	}

	public CTSTELLERVO getCtsTellerVO() {
		return ctsTellerVO;
	}

	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO) {
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

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public List<SelectCO> getChatNonChatDropDown()
	{
		return chatNonChatDropDown;
	}

	public void setChatNonChatDropDown(List<SelectCO> chatNonChatDropDown)
	{
		this.chatNonChatDropDown = chatNonChatDropDown;
	}

	public List<SelectCO> getSwiftChargeDropDown()
	{
		return swiftChargeDropDown;
	}

	public void setSwiftChargeDropDown(List<SelectCO> swiftChargeDropDown)
	{
		this.swiftChargeDropDown = swiftChargeDropDown;
	}

	public List<SelectCO> getSwiftTypeDropDown()
	{
		return swiftTypeDropDown;
	}

	public void setSwiftTypeDropDown(List<SelectCO> swiftTypeDropDown)
	{
		this.swiftTypeDropDown = swiftTypeDropDown;
	}

	public List<SelectCO> getCurrencyUsageFlagDropDown()
	{
		return currencyUsageFlagDropDown;
	}

	public void setCurrencyUsageFlagDropDown(List<SelectCO> currencyUsageFlagDropDown)
	{
		this.currencyUsageFlagDropDown = currencyUsageFlagDropDown;
	}

	public List<SelectCO> getAppNameDropDown()
	{
		return appNameDropDown;
	}

	public void setAppNameDropDown(List<SelectCO> appNameDropDown)
	{
		this.appNameDropDown = appNameDropDown;
	}

	public List<SelectCO> getCategoryDropDown()
	{
		return categoryDropDown;
	}

	public void setCategoryDropDown(List<SelectCO> categoryDropDown)
	{
		this.categoryDropDown = categoryDropDown;
	}

	public String getFromRetrieve()
	{
	    return fromRetrieve;
	}

	public void setFromRetrieve(String fromRetrieve)
	{
	    this.fromRetrieve = fromRetrieve;
	}
}