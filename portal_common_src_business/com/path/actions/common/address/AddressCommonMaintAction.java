package com.path.actions.common.address;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;

import com.opensymphony.xwork2.ActionContext;
import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.address.AddressCommonBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.PathLocalizedTextUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.address.AddressCommonLabelCO;
import com.path.vo.common.address.AddressCommonSC;

public class AddressCommonMaintAction extends RetailBaseAction
{
    private AddressCommonBO addressBO;
    private AddressCommonSC criteria = new AddressCommonSC();
    private String saveType;
    private String lineNbr;
    private BigDecimal cifCode;
    private AddressCommonCO addressCO = new AddressCommonCO();
    private Boolean _addressReadOnlyMode = false;
    private AddressCommonLabelCO addressLabel = new AddressCommonLabelCO();
    private String neededLocale;
    private Boolean tellerCanAccessFlag = true;
    private String callingScreen;
    private String screenLang;
    private boolean fromFomKyc;
    private String type;
    
    public String showFOMAddressDetails()
    {
        try
        {
            BigDecimal cifType = addressCO.getCifType();
            StringUtil.nullToEmpty(lineNbr);
            criteria.setCompCode(returnSessionObject().getCompanyCode());
            setScreenLang(returnSessionObject().getLanguage());
            if(NumberUtil.isEmptyDecimal(cifCode) || StringUtil.nullToEmpty(lineNbr).isEmpty())
            {
                addressCO = new AddressCommonCO();
                if(!NumberUtil.isEmptyDecimal(cifCode))
                {
                    //Added by Mark Ayoub on 02/06/2018 - Needed for cifType mandatory expression
		    SessionCO sessionCO = returnSessionObject();
		    addressCO.setOpt(get_pageRef());
		    addressCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
		    addressCO.setAppName(sessionCO.getCurrentAppName());
		    addressCO.setLoginUserId(sessionCO.getUserName());
		    addressCO.setCifType(cifType);
		    // End Mark
                    addressCO.setCIF_NO(cifCode);
                    addressCO.setCifType(cifType);
                    addressCO.setCOMP_CODE(returnSessionObject().getCompanyCode());
                    addressCO.setBRANCH_CODE(returnSessionObject().getBranchCode());
                    //EWBI160173 -- [mfalha]
                    addressCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
                    addressCO.setLoginUserId(returnSessionObject().getUserName());
                    addressCO.setAppName(returnSessionObject().getCurrentAppName());
                    addressCO.setOpt(get_pageRef());
                   //EWBI160173 -- [mfalha]
                    
                    
                    addressCO = addressBO.addressDisplayManagement(addressCO);
                    if(!addressCO.getBuisnessElement().isEmpty())
                    {
                        setAdditionalScreenParams(addressCO.getBuisnessElement());
                    }
                }
            }
            else
            {
                criteria.setCifNo(cifCode);
                criteria.setLineNo(new BigDecimal(lineNbr));
                addressCO = addressBO.returnAddressDetails(criteria);
                if(addressCO == null)
                {
                    addressCO = new AddressCommonCO();
                    addressCO.setCIF_NO(cifCode);
                    addressCO.setCOMP_CODE(returnSessionObject().getCompanyCode());
                    addressCO.setBRANCH_CODE(returnSessionObject().getBranchCode());
                    //EWBI160173 -- [mfalha]
                    addressCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
                    addressCO.setLoginUserId(returnSessionObject().getUserName());
                    addressCO.setAppName(returnSessionObject().getCurrentAppName());
                    addressCO.setOpt(get_pageRef());
                   //EWBI160173 -- [mfalha]
             
                    addressCO = addressBO.addressDisplayManagement(addressCO);
                }
                else
                {
                    addressCO.setCIF_NO(cifCode);
                    addressCO.setCifType(cifType);
                    addressCO.setCOMP_CODE(returnSessionObject().getCompanyCode());
                    addressCO.setBRANCH_CODE(returnSessionObject().getBranchCode());
                    //EWBI160173 -- [mfalha]
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
		    // End Mark
		    
                    addressCO = addressBO.addressDisplayManagement(addressCO);
                    addressCO
                        .setPermnAddrFlag("Y".equalsIgnoreCase(addressCO.getPERM_ADDRESS()) ? true : false);
                    addressCO.setDefaultAddrFlag("1".equalsIgnoreCase(addressCO.getDEFAULT_ADD())
                        ? true
                        : false);
                    addressCO.setPrintAddrFlag("1".equalsIgnoreCase(StringUtil.nullToEmpty(
                        addressCO.getPRINT_STAT()).toString()) ? true : false);
                    addressCO.seteWalletFlag("1".equalsIgnoreCase(addressCO.getE_WALLET_YN())
                            ? true
                            : false);//bug 757880 maureen
                }
            }

            addressCO.setScreenName(callingScreen);
            // To define as section on main page and not on pop up
            addressCO.setAddrScreenMode("P");
            // check whether to make fields read-only
            if(!getIv_crud().equalsIgnoreCase("R") || !getTellerCanAccessFlag()
                    /*|| "1".equals(addressCO.getIS_KYC_YN())*/ || "TFA".equals(callingScreen))
            {
                addressCO.setAddrScreenMode(getIv_crud());
                set_addressReadOnlyMode(true);
                set_recReadOnly("true");
            }
            
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
        }
        catch(Exception e)
        {
            handleException(e, null, null);
            log.error(e, "Error in showFOMAddressDetails");
        }
        return fromFomKyc==true ? "showFOMAddressDetailsKyc" :"showFOMAddressDetails";
    }

    public String showAccountAddressDetails()
    {
	try
	{
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setBranchCode(returnSessionObject().getBranchCode());
	    addressCO = addressBO.returnAccountAddressDetails(criteria);

	    // To define as section on main page and not on pop up
	    addressCO.setAddrScreenMode("P");
	    // if(!getIv_crud().equalsIgnoreCase("R")) // check whether to make
	    // fields read-only
	    // {
	    addressCO.setAddrScreenMode(getIv_crud());
	    // set_addressReadOnlyMode(true);
	    // }
	    addressCO.setScreenName(callingScreen);
	    
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(returnSessionObject().getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	    if(cifControlVO != null)
	    {
		addressCO.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	    }
	    
	    setAdditionalScreenParams(addressCO.getBuisnessElement());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    log.error(e, "Error in showAccountAddressDetails");
	}
	return "showAccountAddressDetails";
    }
	
  
    public String fetchAddressLabel()
    {
	try
	{
	    getNeededLocale();// en_US
	    Locale old_locale = ActionContext.getContext().getLocale();
	    Locale requested_locale = PathLocalizedTextUtil.localeFromString(getNeededLocale(), null);

	    String language;
	    if(getNeededLocale().equalsIgnoreCase("en_US"))
	    {
		language = "L";
	    }
	    else
	    {
		language = "A";
	    }
	    addressLabel = addressBO.passAddressSectionLabel(returnSessionObject().getCompanyCode(), language);

	    if(addressLabel != null)
	    {
		ActionContext.getContext().setLocale(requested_locale);

		fillAddressLabelCO();
	    }

	    ActionContext.getContext().setLocale(old_locale);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }

    private void fillAddressLabelCO()
    {
	if(addressLabel.getArea() == null)
	{
	    addressLabel.setArea(getText("Area_key"));
	}
	if(addressLabel.getBlock() == null)
	{
	    addressLabel.setBlock(getText("Block_key"));
	}
	if(addressLabel.getBlock_arb() == null)
	{
	    addressLabel.setBlock_arb(getText("Block_Arb_key"));
	}
	if(addressLabel.getStreet() == null)
	{
	    addressLabel.setStreet(getText("Street_key"));
	}
	if(addressLabel.getStreet_arb() == null)
	{
	    addressLabel.setStreet_arb(getText("Street_Arb_key"));
	}
	if(addressLabel.getJada() == null)
	{
	    addressLabel.setJada(getText("Jada_key"));
	}
	if(addressLabel.getJada_arb() == null)
	{
	    addressLabel.setJada_arb(getText("Jada_Arb_key"));
	}
	if(addressLabel.getHouseBuilding() == null)
	{
	    addressLabel.setHouseBuilding(getText("House_Building_key"));
	}
	if(addressLabel.getHouseBuilding_arb() == null)
	{
	    addressLabel.setHouseBuilding_arb(getText("House_Building_Arb_key"));
	}
	if(addressLabel.getCity() == null)
	{
	    addressLabel.setCity(getText("City_key"));
	}
	if(addressLabel.getCity_arb() == null)
	{
	    addressLabel.setCity_arb(getText("City_Arb_key"));
	}
	if(addressLabel.getCountry() == null)
	{
	    addressLabel.setCountry(getText("Country_key"));
	}
	if(addressLabel.getCityCode() == null)
	{
	    addressLabel.setCityCode(getText("City_Code_key"));
	}
	if(addressLabel.getSector() == null)
	{
	    addressLabel.setSector(getText("Sector__key"));
	}
	if(addressLabel.getPostalCode() == null)
	{
	    addressLabel.setPostalCode(getText("Postal_Code_key"));
	}
	if(addressLabel.getPoBox() == null)
	{
	    addressLabel.setPoBox(getText("P.O_Box_key"));
	}
	if(addressLabel.getAddressDesc() == null)
	{
	    addressLabel.setAddressDesc(getText("Address_Description_key"));
	}
	if(addressLabel.getHomeTel() == null)
	{
	    if(StringUtil.nullToEmpty(type).equals("T"))
	    {
		 addressLabel.setHomeTel(getText("Office_Tel_key"));
	    }
	    else
	    {
		 addressLabel.setHomeTel(getText("Home_Tel_key"));
	    }
	}
	if(addressLabel.getWorkTel() == null)
	{
	    addressLabel.setWorkTel(getText("Work_Tel_key"));
	}
	if(addressLabel.getMobile() == null)
	{
	    addressLabel.setMobile(getText("Mobile_key"));
	}
	if(addressLabel.getOtherTel() == null)
	{
	    addressLabel.setOtherTel(getText("Other_Tel_key"));
	}
	if(addressLabel.getFax() == null)
	{
	    addressLabel.setFax(getText("Fax_key"));
	}
	if(addressLabel.getEmail() == null)
	{
	    addressLabel.setEmail(getText("Email_key"));
	}

	if(addressLabel.getFromDate() == null)
	{
	    addressLabel.setFromDate(getText("From_Date_key"));
	}
	if(addressLabel.getToDate() == null)
	{
	    addressLabel.setToDate(getText("To_Date_key"));
	}
	if(addressLabel.getExpiryDate() == null)
	{
	    addressLabel.setExpiryDate(getText("Expiry_Date_key"));
	}
	if(addressLabel.getPermanentAddress() == null)
	{
	    addressLabel.setPermanentAddress(getText("Permanent_Address_key"));
	}
	if(addressLabel.getDefaultAddress() == null)
	{
	    addressLabel.setDefaultAddress(getText("Default_Address_key"));
	}
	if(addressLabel.getPrintStatement() == null)
	{
	    addressLabel.setPrintStatement(getText("Print_Statement__key"));
	}
	if(addressLabel.getMoreAddress() == null)
	{
	    addressLabel.setMoreAddress(getText("More_Addresses_key"));
	}
    }
    
    public String initialiseAddressVisibility()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    addressCO.setCifControlVO(returnCommonLibBO().returnCifControlDetails(cifControlVO));

	    CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	    ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsControlVO.setBRANCH_CODE(sessionCO.getCompanyCode());
	    addressCO.setCtsControl(returnCommonLibBO().returnCtsControlDetails(ctsControlVO));
	    addressCO.setCifType(addressCO.getCifVO().getCIF_TYPE());
	    addressCO.setCOMP_CODE(sessionCO.getCompanyCode());
	    addressCO.setLanguage(sessionCO.getLanguage());
	    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businesRsult = addressBO.initialiseAddressVisibility(addressCO);
	    setAdditionalScreenParams(businesRsult);
    	     /*In FOM the arabic description must be according to the cif language instead of prefferred language BMOUPI170114 - TP:532453*/
    	      addressCO = addressBO.fillDescriptionInSelectedLang (addressCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";
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

    public AddressCommonCO getAddressCO()
    {
	return addressCO;
    }

    public void setAddressCO(AddressCommonCO addressCO)
    {
	this.addressCO = addressCO;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public String getLineNbr()
    {
	return lineNbr;
    }

    public void setLineNbr(String lineNbr)
    {
	this.lineNbr = lineNbr;
    }

    // Page Ref modified by adding "P" for Address Pop Up and "M" for Main Page
    public String get_addressPageRef()
    {
	return get_pageRef() + "P";
    }

    public Boolean get_addressReadOnlyMode()
    {
	return _addressReadOnlyMode;
    }

    public void set_addressReadOnlyMode(Boolean addressReadOnlyMode)
    {
	_addressReadOnlyMode = addressReadOnlyMode;
    }

    public AddressCommonLabelCO getAddressLabel()
    {
	return addressLabel;
    }

    public void setAddressLabel(AddressCommonLabelCO addressLabel)
    {
	this.addressLabel = addressLabel;
    }

    public String getNeededLocale()
    {
	return neededLocale;
    }

    public void setNeededLocale(String neededLocale)
    {
	this.neededLocale = neededLocale;
    }

    public Boolean getTellerCanAccessFlag()
    {
	return tellerCanAccessFlag;
    }

    public void setTellerCanAccessFlag(Boolean tellerCanAccessFlag)
    {
	this.tellerCanAccessFlag = tellerCanAccessFlag;
    }

    public String getCallingScreen()
    {
	return callingScreen;
    }

    public void setCallingScreen(String callingScreen)
    {
	this.callingScreen = callingScreen;
    }

    /**
     * @return the screenLang
     */
    public String getScreenLang()
    {
        return screenLang;
    }

    /**
     * @param screenLang the screenLang to set
     */
    public void setScreenLang(String screenLang)
    {
        this.screenLang = screenLang;
    }

    public boolean isFromFomKyc()
    {
        return fromFomKyc;
    }

    public void setFromFomKyc(boolean fromFomKyc)
    {
        this.fromFomKyc = fromFomKyc;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

}
