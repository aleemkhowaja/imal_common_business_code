package com.path.actions.common.address;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.address.AddressCommonBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.address.AddressCommonSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: lvalappil
 * 
 *          AddressCommonListAction.java used to
 */
public class AddressCommonListAction extends GridBaseAction
{

    private List<AddressCommonCO> addressList = new ArrayList<AddressCommonCO>();
    private AddressCommonCO addressCO = new AddressCommonCO();
    private AddressCommonBO addressBO;
    private AddressCommonSC criteria = new AddressCommonSC();
    private BigDecimal brCode;
    private BigDecimal cifCode;
    private BigDecimal slNo;
    private BigDecimal glCode;
    private BigDecimal cyCode;
    private Boolean _popupBtnFlag = true;
    private Boolean _addressReadOnlyMode = false;
    private String screenLang;
    private String addrScreenMode;
    private String fromAddMethod;// flag to identify whether call is from Add
				 // button of popup
    private String callingScreen;
    
    //Added by Mark Ayoub on 02/06/2018 - Needed for cifType mandatory expression
    private BigDecimal cifType;
    //End Mark
    private boolean fromFomKyc;
    
    public String loadMoreAddressGrid()
    {
	String[] searchCol = { "LINE_NO", "countryDesc", "ADDRESS1_ENG", "ADDRESS2_ENG", "TEL", "FAX" };
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(criteria))
	    {
		setRecords(addressBO.returnAllAddressListCount(criteria));
	    }
	    addressList = addressBO.returnAllAddressList(criteria);
	    setGridModel(addressList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error Loading More Address Grid ");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String loadFOMMoreAddressGrid()
    {
	String[] searchCol = { "LINE_NO", "countryDesc", "ADDRESS1_ENG", "ADDRESS2_ENG", "TEL", "FAX" };
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    
	    //EWBI160091 10/06/2016
	    if(NumberUtil.isEmptyDecimal(criteria.getCompCodeCif()) || NumberUtil.isNumberPositive(criteria.getCompCodeCif()))
	    {
		int cpt = addressBO.checkNegativeComp(criteria);
		if(cpt == 1)
		{
		    criteria.setCompCodeCif(criteria.getCompCode().negate());
		}
	    }
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(addressBO.returnAddressListCount(criteria));
	    }
	    addressList = addressBO.returnAddressList(criteria);
	    setGridModel(addressList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error Loading Grid of FOM More Address");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String loadAccountMoreAddressGrid()
    {
	String[] searchCol = { "LINE_NO", "countryDesc", "ADDRESS1_ENG", "ADDRESS2_ENG", "TEL", "FAX" };
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(criteria))
	    {
		setRecords(addressBO.returnAccountAddressListCount(criteria));
	    }
	    addressList = addressBO.returnAccountAddressList(criteria);
	    setGridModel(addressList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error Loading Grid of Account More Address");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // Action called when More Address button in FOM Screen is clicked
    public String populateMoreAddressPopupforFOM() throws BaseException
    {
	String returnSrt = "";
	returnSrt = criteria.isFromFomKyc()==true ? "populateMoreAddressPopupforFOMKYC" : fromAddMethod == null ? "populateMoreAddressPopupforFOM" : "populateMoreAddressAdd";

	// modifications to handle the Address Section Arabic switching
	setScreenLang(returnSessionObject().getLanguage());
	addressCO.setAddrScreenMode("P");// To define as pop up
	addressCO.setScreenName(FomConstant.FOM_SCREEN_NAME);
	addressCO.setCIF_NO(cifCode);
	addressCO.setLoginCompCode( returnSessionObject().getCompanyCode());
	//EWBI160091 (403157)- Modification of CIF;
	addressCO.setCOMP_CODE(NumberUtil.nullEmptyToValue(addressCO.getCompCodeCif(), returnSessionObject().getCompanyCode()));
        //EWBI160173 -- [John Massaad]
        addressCO.setBRANCH_CODE(returnSessionObject().getBranchCode());
        addressCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
        addressCO.setLoginUserId(returnSessionObject().getUserName());
        addressCO.setAppName(returnSessionObject().getCurrentAppName());
        addressCO.setOpt(get_pageRef());
       //EWBI160173 -- [mfalha]
	
	
	//Added by Mark Ayoub on 02/06/2018 - Needed for cifType mandatory expression
	SessionCO sessionCO = returnSessionObject();
	addressCO.setOpt(get_pageRef());
	addressCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
	addressCO.setAppName(sessionCO.getCurrentAppName());
	addressCO.setLoginUserId(sessionCO.getUserName());
	addressCO.setCifType(cifType);
	//End Mark

	if(addrScreenMode != null && addrScreenMode.equalsIgnoreCase("true"))
	{
	    // if no permission for teller addrScreenMode == true
	    addressCO.setAccesByTeller(false);
	}
	if( (!getIv_crud().equalsIgnoreCase("R") && !FomConstant.AML.equals(addressCO.getAppName())) || (FomConstant.AML.equals(addressCO.getAppName()) && !getIv_crud().equalsIgnoreCase("R") && !getIv_crud().equalsIgnoreCase("U")) || (addrScreenMode != null && addrScreenMode.equalsIgnoreCase("true"))) // if no permission for teller addrScreenMode == true //changed by nour for #925559: add app name and new checking 
	{
	    set_popupBtnFlag(false);
	    //Rania 801289 - Copied from Hasan Bug#566067 - BMOUPI170480 20/09/2017
	    // set_addressReadOnlyMode(true);
	    set_recReadOnly("true");
	}

	addressCO = addressBO.addressDisplayManagement(addressCO);

	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(returnSessionObject().getCompanyCode());
	cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	if(cifControlVO != null)
	{
	    addressCO.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	}
	
	if(!addressCO.getBuisnessElement().isEmpty())
	{
	    setAdditionalScreenParams(addressCO.getBuisnessElement());
	}
	return returnSrt;
    }

    public String populateMoreAddressPopupforAccounts()
    {
	String returnSrt = "";
	returnSrt = fromAddMethod == null ? "populateMoreAddressPopupforAccounts" : "populateMoreAddressAdd";

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    getAddrScreenMode();
	    // modifications to handle the Address Section Arabic switching
	    setScreenLang(sessionCO.getLanguage());
	    addressCO.setLoginCompCode(sessionCO.getCompanyCode());
	    addressCO.setLoginBraCode(sessionCO.getBranchCode());
	    addressCO.setAddrScreenMode("P");// To define as pop up
	    addressCO.setScreenName("ACCOUNT");

	    addressCO.setLoginCompCode(sessionCO.getCompanyCode());
	    addressCO.setLoginBraCode(sessionCO.getBranchCode());
	    addressCO.setACC_BR(criteria.getBranchCode());
	    addressCO.setACC_CY(criteria.getCyCode());
	    addressCO.setACC_GL(criteria.getGlCode());
	    addressCO.setACC_CIF(criteria.getCifNo());
	    addressCO.setACC_SL(criteria.getSlNo());
	    addressCO.setDefaultAddressFromCif(criteria.isDefaultAddressFromCif());
	    addressCO.setMoreAddressWindowOpened(criteria.isMoreAddressWindowOpened());
	    addressCO = addressBO.initialiseAddressSreen(addressCO);
	    setAdditionalScreenParams(addressCO.getBuisnessElement());

	    if(get_addressReadOnlyMode())
	    {
		set_popupBtnFlag(false);
	    }

	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(returnSessionObject().getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	    if(cifControlVO != null)
	    {
		addressCO.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	    }
	    
	}

	catch(Exception e)
	{
	    log.error(e, "Error Loading form of Account More Address");
	    handleException(e, null, null);
	}

	return returnSrt;

    }

    // Action called when More Address button in LC Screen is clicked
    public String populateMoreAddressPopup()
    {

	try
	{

	    // modifications to handle the Address Section Arabic switching
	    setScreenLang(returnSessionObject().getLanguage());// getting screen
							       // Language from
							       // session
	    addressCO.setAddrScreenMode("P");// To define as pop up
	    addressCO.setScreenName(callingScreen);
	    addressCO.setCIF_NO(cifCode);
	    addressCO.setCOMP_CODE(returnSessionObject().getCompanyCode());
	    addressCO.setBRANCH_CODE(returnSessionObject().getBranchCode());
	    
	    //EWBI160173 -- [mfalha]
      
            addressCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
            addressCO.setLoginUserId(returnSessionObject().getUserName());
            addressCO.setAppName(returnSessionObject().getCurrentAppName());
            addressCO.setOpt(get_pageRef());
           //EWBI160173 -- [mfalha]
	    
	    // if no permission for teller addrScreenMode == true
	    if("true".equalsIgnoreCase(StringUtil.nullToEmpty(addrScreenMode)))
	    {
		addressCO.setAccesByTeller(false);
	    }
	    addressCO.setOpt(get_pageRef());
	    addressCO.setAppName(returnSessionObject().getCurrentAppName());

	    addressCO = addressBO.addressDisplayManagement(addressCO);

	    if(!addressCO.getBuisnessElement().isEmpty())
	    {
		setAdditionalScreenParams(addressCO.getBuisnessElement());
	    }

	}
	catch(Exception e)
	{
	    log.error(e, "Error in populateMoreAddressPopup of AddressCommonListAction");
	    handleException(e, null, null);
	}

	return "populateMoreAddressPopupforFOM";
    }

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public AddressCommonSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(AddressCommonSC criteria)
    {
	this.criteria = criteria;
    }

    public void setAddressBO(AddressCommonBO addressBO)
    {
	this.addressBO = addressBO;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    // Page Ref modified by adding "P" for Address Pop Up and "M" for Main Page
    public String get_addressPageRef()
    {
	return get_pageRef() + "P";
    }

    public AddressCommonCO getAddressCO()
    {
	return addressCO;
    }

    public void setAddressCO(AddressCommonCO addressCO)
    {
	this.addressCO = addressCO;
    }

    public Boolean get_popupBtnFlag()
    {
	return _popupBtnFlag;
    }

    public void set_popupBtnFlag(Boolean popupBtnFlag)
    {
	_popupBtnFlag = popupBtnFlag;
    }

    public Boolean get_addressReadOnlyMode()
    {
	return _addressReadOnlyMode;
    }

    public void set_addressReadOnlyMode(Boolean addressReadOnlyMode)
    {
	_addressReadOnlyMode = addressReadOnlyMode;
    }

    public String getScreenLang()
    {
	return screenLang;
    }

    public void setScreenLang(String screenLang)
    {
	this.screenLang = screenLang;
    }

    public String getAddrScreenMode()
    {
	return addrScreenMode;
    }

    public void setAddrScreenMode(String addrScreenMode)
    {
	this.addrScreenMode = addrScreenMode;
    }

    public String getFromAddMethod()
    {
	return fromAddMethod;
    }

    public void setFromAddMethod(String fromAddMethod)
    {
	this.fromAddMethod = fromAddMethod;
    }

    public String getCallingScreen()
    {
	return callingScreen;
    }

    public void setCallingScreen(String callingScreen)
    {
	this.callingScreen = callingScreen;
    }

    public BigDecimal getSlNo()
    {
	return slNo;
    }

    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public BigDecimal getCyCode()
    {
	return cyCode;
    }

    public void setCyCode(BigDecimal cyCode)
    {
	this.cyCode = cyCode;
    }

    public BigDecimal getBrCode()
    {
	return brCode;
    }

    public void setBrCode(BigDecimal brCode)
    {
	this.brCode = brCode;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public Boolean getFromFomKyc()
    {
        return fromFomKyc;
    }

    public void setFromFomKyc(Boolean fromFomKyc)
    {
        this.fromFomKyc = fromFomKyc;
    }

}
