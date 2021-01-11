package com.path.bo.common.address.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.path.bo.admin.countries.CountriesBO;
import com.path.bo.admin.countriesregion.CountriesRegionBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.address.AddressCommonBO;
import com.path.bo.core.account.AccountsElementsConstant;
import com.path.bo.core.cities.CitiesBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.FomElementsConstant;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.bo.core.postalcode.PostalCodeBO;
import com.path.bo.core.proofaddress.ProofAddressBO;
import com.path.bo.core.residencetypes.ResidenceTypesBO;
import com.path.bo.core.sectors.SectorsBO;
import com.path.dao.common.address.AddressCommonDAO;
import com.path.dbmaps.vo.ACC_NV_CONTROLVO;
import com.path.dbmaps.vo.AMF_ADDRESSVO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.CITIESVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.COUNTRIES_REGIONVO;
import com.path.dbmaps.vo.COUNTRIES_TEL_FORMATVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTS_PROOF_ADDRESSVO;
import com.path.dbmaps.vo.POSTAL_CODEVO;
import com.path.dbmaps.vo.RESIDENCE_TYPESVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SECTORSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.countries.CountriesCO;
import com.path.vo.admin.countries.CountriesSC;
import com.path.vo.admin.countriesregion.CountriesRegionSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.address.AddressCommonLabelCO;
import com.path.vo.common.address.AddressCommonSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.cities.CitiesSC;
import com.path.vo.core.postalcode.PostalCodeSC;
import com.path.vo.core.proofaddress.ProofAddressSC;
import com.path.vo.core.residencetypes.ResidenceTypesSC;
import com.path.vo.core.sectors.SectorsSC;

public class AddressCommonBOImpl extends BaseBO implements AddressCommonBO
{
    AddressCommonDAO addressDAO;
    private CoreCommonServiceBO coreCommonServiceBO;
    private CountriesRegionBO countriesRegionBO;
    private CountriesBO countriesBO;
    private CitiesBO citiesBO;
    private SectorsBO sectorsBO;
    private PostalCodeBO postalCodeBO;
    private ResidenceTypesBO residenceTypesBO;
    private ProofAddressBO proofAddressBO;


    @Override
    public AddressCommonCO returnAddressDetails(AddressCommonSC criteria) throws BaseException
    {
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(criteria.getCompCode());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	if(cifControlVO != null)
	{
	    criteria.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	}
	
	return addressDAO.returnAddressDetails(criteria);
    }

    private AddressCommonCO applyPhoneFormat(AddressCommonCO addressCommonCO) throws BaseException
    {
	//TODO fill addressCommonCO.getOpt()
	if(!NumberUtil.isEmptyDecimal(addressCommonCO.getCOUNTRY()))
	{
	    /* Inputs on which the format should be applied */
	    String[] inputDependent = { FomElementsConstant.MOBILE_NAME, FomElementsConstant.TEL_NAME,
		    			FomElementsConstant.WORK_TEL_NAME, FomElementsConstant.OTHER_TEL_NAME, FomElementsConstant.FAX_NAME,
		    			FomElementsConstant.REFERENCES_TEL_NAME + "_" + addressCommonCO.getOpt(),
		    			FomElementsConstant.REFERENCES_FAX_NAME + "_" + addressCommonCO.getOpt() };

	    /* The format value that should be applied on all phone number */
	    String formatValue = "";
	    
	    /* Get the CountriesVo object that contain TELEPHONE_FORMAT */
	    COUNTRIESVO countriesVO = new COUNTRIESVO();
	    countriesVO.setCOMP_CODE(addressCommonCO.getCOMP_CODE().abs());
	    countriesVO.setCOUNTRY_CODE(addressCommonCO.getCOUNTRY());
	    countriesVO = (COUNTRIESVO) genericDAO.selectByPK(countriesVO);
	    if(null != countriesVO)
	    {
		COUNTRIES_TEL_FORMATVO cntryTelFrmatVO = new COUNTRIES_TEL_FORMATVO();
		if(NumberUtil.isNumber(countriesVO.getTELEPHONE_FORMAT()))
		{
		    cntryTelFrmatVO.setLINE_NO(new BigDecimal(countriesVO.getTELEPHONE_FORMAT()));
		}
		else
		{
		    cntryTelFrmatVO.setFORMAT_VALUE(countriesVO.getTELEPHONE_FORMAT());
		}
		if(StringUtil.isNotEmpty(countriesVO.getTELEPHONE_FORMAT()))
		{
		    cntryTelFrmatVO = coreCommonServiceBO.returnCountriesTelFormat(cntryTelFrmatVO);
		}
		else
		{
		    cntryTelFrmatVO = null;
		}

		/* get the telephone code of the region*/
		COUNTRIES_REGIONVO countriesRegionVO = new COUNTRIES_REGIONVO();
		countriesRegionVO.setCOMP_CODE(countriesVO.getCOMP_CODE().abs());
		countriesRegionVO.setCOUNTRY_CODE(countriesVO.getCOUNTRY_CODE());
		countriesRegionVO.setREGION_CODE(NumberUtil.nullEmptyToValue(addressCommonCO.getREGION(), BigDecimal.ZERO));
		countriesRegionVO = (COUNTRIES_REGIONVO) genericDAO.selectByPK(countriesRegionVO);
		String regionTelephoneCode = "";
		if(countriesRegionVO != null)
		{
		    regionTelephoneCode = StringUtil.nullToEmpty(countriesRegionVO.getTELEPHONE_CODE());
		}

		// the code of the country e.g LEBANON(country) : 961
		BigDecimal countryTelephoneCode = countriesVO.getTELEPHONE_CODE();

		if(null == cntryTelFrmatVO)
		{
		    formatValue = "";//Hasan Bug#564457 - SUPT170394 11/10/2017
		}
		else
		{
		    formatValue = StringUtil.replaceInString(cntryTelFrmatVO.getFORMAT_VALUE(), ConstantsCommon.PHONE_REPLACE_WHAT, ConstantsCommon.PHONE_REPLACE_WITH);
		}
		if(!NumberUtil.isEmptyDecimal(countryTelephoneCode) && StringUtil.isNotEmpty(formatValue))
		{
		    // the country code should not traspass this length
		    int telCodeLen = NumberUtil.nullToZero(cntryTelFrmatVO.getTEL_CODE_LEN()).intValue();
		    // add 0 to the left to satisfy the length
		    String stringPhoneCode = String.valueOf(countryTelephoneCode);
		    if(formatValue.contains("+"))
		    {
			if(stringPhoneCode.length() + 2 < telCodeLen)
			{
			    stringPhoneCode = NumberUtil.addLeadingZeros(countryTelephoneCode, telCodeLen - 1);
			}
		    }
		    else
		    {
			stringPhoneCode = NumberUtil.addLeadingZeros(countryTelephoneCode, telCodeLen);
		    }

		    // could be ["(" || "+" || "(+" ]
		    String phoneExtension = "";

		    // to check whether first character is number or not
		    boolean isFirstNumber = ConstantsCommon.PHONE_REPLACE_WITH.equals(formatValue.substring(0, 1));
		    // if first character of the format is not "0"
		    if(!isFirstNumber)
		    {
			phoneExtension = formatValue.substring(0, 1);
			formatValue = formatValue.substring(1, formatValue.length());

			boolean isSecondNumber = ConstantsCommon.PHONE_REPLACE_WITH.equals(formatValue.substring(0, 1));
			// if second character of the format is not a number like
			// "(+000)-(000)-0000000"
			if(!isSecondNumber)
			{
			    phoneExtension = phoneExtension.concat(formatValue.substring(0, 1));
			    formatValue = formatValue.substring(1, formatValue.length());
			}

		    }
		    // after we set the country code(base on telCodeLen), here we
		    // append the regionCode to it (in case it exists)
		    stringPhoneCode = stringPhoneCode.concat(regionTelephoneCode);

		    formatValue = coreCommonServiceBO.replaceCountryExtension(formatValue, stringPhoneCode);
		    formatValue = phoneExtension.concat(formatValue);
		}
	    }
		//id:1042531 Details:DBU190235 - For Wallet checked CIF, the mobile number should not have any format falha	 if(("1").equals(addressCommonCO.getE_WALLET_YN()))

	    if(NumberUtil.isNumberPositive(addressCommonCO.getCIF_NO()))
	    {
		AddressCommonSC criteria = new AddressCommonSC();
		criteria.setCompCode(addressCommonCO.getCOMP_CODE());
		criteria.setCifNo(addressCommonCO.getCIF_NO());
		int countEWallet = addressDAO.returnEWalletCIF(criteria);

		if(countEWallet == 1)
		{

		    List<String> list = new ArrayList<String>(Arrays.asList(inputDependent));
		    list.remove(FomElementsConstant.MOBILE_NAME);
		    inputDependent = list.toArray(new String[0]);
		    
		    Pattern p = Pattern.compile( ConstantsCommon.PHONE_REGEX, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
		    String mobileValue = p.matcher(formatValue).replaceAll("");
		    applyDynScreenDisplay(new String[] { FomElementsConstant.MOBILE_ID }, ConstantsCommon.ACTION_TYPE_VALUE, mobileValue, addressCommonCO.getBuisnessElement(), null);

		}
	    }
		//id:1042531 Details:DBU190235 - For Wallet checked CIF, the mobile number should not have any format falha	 if(("1").equals(addressCommonCO.getE_WALLET_YN()))

	    applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_TXTFORMAT, formatValue, addressCommonCO.getBuisnessElement(), null);
	    if(StringUtil.isNotEmpty(formatValue))
	    {
		applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_MAXLENGTH, String.valueOf(formatValue.length()+1), addressCommonCO.getBuisnessElement(), null);
	    }
	    else
	    {
		applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_MAXLENGTH, NCifMaintenanceConstant.ADDRESS_DETAILS_MAX_LENGTH, addressCommonCO.getBuisnessElement(), null);
	    }
	}
	return addressCommonCO;
    }

    @Override
    public List returnAddressList(AddressCommonSC criteria) throws BaseException
    {
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(criteria.getCompCode());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	if(cifControlVO != null)
	{
	    criteria.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	}
	
	ArrayList<AddressCommonCO> addressList = (ArrayList<AddressCommonCO>) addressDAO.returnAddressList(criteria);
	if(!addressList.isEmpty())
	{
	    for(int i = 0; i < addressList.size(); i++)
	    {
	        //Added due to the bug 252671 to replace "0" by "#" because in the database the CountryTelFormat is saved with "0" format.
		addressList.get(i).setCountryTelFormat(StringUtil.replaceInString(StringUtil.nullToEmpty(addressList.get(i).getCountryTelFormat()),"0", "#"));
	    }
	}

	return addressList;
    }

    @Override
    public List returnDefaultAddress(AddressCommonSC criteria) throws BaseException
    {
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(criteria.getCompCode());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	if(cifControlVO != null)
	{
	    criteria.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	}
	
        return addressDAO.returnDefaultAddress(criteria);
    }

    @Override
    public List returnPermanentAddress(AddressCommonSC criteria) throws BaseException
    {
        return addressDAO.returnPermanentAddress(criteria);
    }

    @Override
    public int returnAddressListCount(AddressCommonSC criteria) throws BaseException
    {
        return addressDAO.returnAddressListCount(criteria);
    }


    public AddressCommonLabelCO passAddressSectionLabel(BigDecimal compCode, String language) throws BaseException
    {
        AddressCommonLabelCO addressLabel = new AddressCommonLabelCO();
        CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
        cifControlVO.setCOMP_CODE(compCode);
        cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
        // check whether to use original Label or label from DB [if '1' label
        // from Data Base else use original label from Data Window]
        String useAddressDesc = StringUtil.nullToEmpty(cifControlVO.getUSE_ADDRESS_DESC());

        if("1".equals(useAddressDesc)) // from Data Base
        {
            if("L".equals(language) || "B".equals(language))
            {
                String address1Eng = StringUtil.nullToEmpty(cifControlVO.getADDRESS1_ENG());
                String address2Eng = StringUtil.nullToEmpty(cifControlVO.getADDRESS2_ENG());
                String address3Eng = StringUtil.nullToEmpty(cifControlVO.getADDRESS3_ENG());
                String address4Eng = StringUtil.nullToEmpty(cifControlVO.getADDRESS4_ENG());
                String cityEng = StringUtil.nullToEmpty(cifControlVO.getCITY_ENG());

                String address1Arab = StringUtil.nullToEmpty(cifControlVO.getADDRESS1_ARAB());
                String address2Arab = StringUtil.nullToEmpty(cifControlVO.getADDRESS2_ARAB());
                String address3Arab = StringUtil.nullToEmpty(cifControlVO.getADDRESS3_ARAB());
                String address4Arab = StringUtil.nullToEmpty(cifControlVO.getADDRESS4_ARAB());
                String cityArab = StringUtil.nullToEmpty(cifControlVO.getCITY_ARAB());

                String regionEng = StringUtil.nullToEmpty(cifControlVO.getREGION_ENG());
                String countryEng = StringUtil.nullToEmpty(cifControlVO.getCOUNTRY_ENG());
                String poboxAreaEng = StringUtil.nullToEmpty(cifControlVO.getPOBOX_AREA_ENG());
                String postalCodeEng = StringUtil.nullToEmpty(cifControlVO.getPOSTAL_CODE_ENG());
                String telEng = StringUtil.nullToEmpty(cifControlVO.getTEL_ENG());
                String workTelEng = StringUtil.nullToEmpty(cifControlVO.getWORK_TEL_ENG());
                String mobileEng = StringUtil.nullToEmpty(cifControlVO.getMOBILE_ENG());
                String otherTelEng = StringUtil.nullToEmpty(cifControlVO.getOTHER_TEL_ENG());
                String faxEng = StringUtil.nullToEmpty(cifControlVO.getFAX_ENG());
                String emailEng = StringUtil.nullToEmpty(cifControlVO.getEMAIL_ENG());
                String cityCodeEng = StringUtil.nullToEmpty(cifControlVO.getCITY_CODE_ENG());
                String sectorCodeEng = StringUtil.nullToEmpty(cifControlVO.getSECTOR_ENG());

                addressLabel.setBlock(address1Eng);
                addressLabel.setStreet(address2Eng);
                addressLabel.setJada(address3Eng);
                addressLabel.setHouseBuilding(address4Eng);
                addressLabel.setCity(cityEng);

                addressLabel.setBlock_arb(address1Arab);
                addressLabel.setStreet_arb(address2Arab);
                addressLabel.setJada_arb(address3Arab);
                addressLabel.setHouseBuilding_arb(address4Arab);
                addressLabel.setCity_arb(cityArab);

                addressLabel.setArea(regionEng);
                addressLabel.setCountry(countryEng);
                addressLabel.setPoBox(poboxAreaEng);
                addressLabel.setPostalCode(postalCodeEng);
                addressLabel.setHomeTel(telEng);
                addressLabel.setWorkTel(workTelEng);
                addressLabel.setMobile(mobileEng);
                addressLabel.setOtherTel(otherTelEng);
                addressLabel.setFax(faxEng);
                addressLabel.setEmail(emailEng);
                addressLabel.setCityCode(cityCodeEng);
                addressLabel.setSector(sectorCodeEng);
            }
            else
            {
                String address1Eng = StringUtil.nullToEmpty(cifControlVO.getADDRESS1_ENG());
                String address2Eng = StringUtil.nullToEmpty(cifControlVO.getADDRESS2_ENG());
                String address3Eng = StringUtil.nullToEmpty(cifControlVO.getADDRESS3_ENG());
                String address4Eng = StringUtil.nullToEmpty(cifControlVO.getADDRESS4_ENG());
                String cityEng = StringUtil.nullToEmpty(cifControlVO.getCITY_ENG());

                String address1Arab = StringUtil.nullToEmpty(cifControlVO.getADDRESS1_ARAB());
                String address2Arab = StringUtil.nullToEmpty(cifControlVO.getADDRESS2_ARAB());
                String address3Arab = StringUtil.nullToEmpty(cifControlVO.getADDRESS3_ARAB());
                String address4Arab = StringUtil.nullToEmpty(cifControlVO.getADDRESS4_ARAB());
                String cityArab = StringUtil.nullToEmpty(cifControlVO.getCITY_ARAB());

                String regionArab = StringUtil.nullToEmpty(cifControlVO.getREGION_ARAB());
                String countryArab = StringUtil.nullToEmpty(cifControlVO.getCOUNTRY_ARAB());
                String poboxAreaArab = StringUtil.nullToEmpty(cifControlVO.getPOBOX_AREA_ARAB());
                String postalCodeArab = StringUtil.nullToEmpty(cifControlVO.getPOSTAL_CODE_ARAB());
                String telArab = StringUtil.nullToEmpty(cifControlVO.getTEL_ARAB());
                String workTelArab = StringUtil.nullToEmpty(cifControlVO.getWORK_TEL_ARAB());
                String mobileArab = StringUtil.nullToEmpty(cifControlVO.getMOBILE_ARAB());
                String otherTelArab = StringUtil.nullToEmpty(cifControlVO.getOTHER_TEL_ARAB());
                String faxArab = StringUtil.nullToEmpty(cifControlVO.getFAX_ARAB());
                String emailArab = StringUtil.nullToEmpty(cifControlVO.getEMAIL_ARAB());

                addressLabel.setBlock(address1Eng);
                addressLabel.setStreet(address2Eng);
                addressLabel.setJada(address3Eng);
                addressLabel.setHouseBuilding(address4Eng);
                addressLabel.setCity(cityEng);

                addressLabel.setBlock_arb(address1Arab);
                addressLabel.setStreet_arb(address2Arab);
                addressLabel.setJada_arb(address3Arab);
                addressLabel.setHouseBuilding_arb(address4Arab);
                addressLabel.setCity_arb(cityArab);

                addressLabel.setArea(regionArab);
                addressLabel.setCountry(countryArab);
                addressLabel.setPoBox(poboxAreaArab);
                addressLabel.setPostalCode(postalCodeArab);
                addressLabel.setHomeTel(telArab);
                addressLabel.setWorkTel(workTelArab);
                addressLabel.setMobile(mobileArab);
                addressLabel.setOtherTel(otherTelArab);
                addressLabel.setFax(faxArab);
                addressLabel.setEmail(emailArab);
                // addressLabel.setCityCode(cityCodeArab);
                // addressLabel.setSector(sectorCodeArab);
            }
        }
        return addressLabel;
       
    }

    public AddressCommonCO addressDisplayManagement(AddressCommonCO addressCommonCOParam) throws BaseException
    {
        
	// AvoidReassigningParameters
	AddressCommonCO addressCommonCO = addressCommonCOParam;
	String language = StringUtil.nullToEmpty(addressCommonCO.getCifVO().getLANGUAGE());
	 
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
        cifControlVO.setCOMP_CODE( addressCommonCO.getCOMP_CODE().abs());
        addressCommonCO.setCifControlVO(commonLibBO.returnCifControlDetails(cifControlVO));
        
        CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
        ctsControlVO.setCOMP_CODE( addressCommonCO.getCOMP_CODE().abs());
        ctsControlVO.setBRANCH_CODE(addressCommonCO.getBRANCH_CODE());
        addressCommonCO.setCtsControl(commonLibBO.returnCtsControlDetails(ctsControlVO));

        CifSC cifSC = new CifSC();
        cifSC.setComp_code(addressCommonCO.getCOMP_CODE());
        cifSC.setCif_no(addressCommonCO.getCIF_NO());
	if(FomConstant.FOM_SCREEN_NAME.equals(addressCommonCOParam.getScreenName())
		&& "1".equals(addressCommonCO.getCifControlVO().getPROCEED_ON_MODIFIED_CIF_YN()))
	{
	    cifSC.setCompCode(addressCommonCO.getCOMP_CODE());
	    // Elias EWBI160091 10/06/2016
	    if(NumberUtil.isEmptyDecimal(addressCommonCO.getCOMP_CODE()) || NumberUtil.isNumberPositive(addressCommonCO.getCOMP_CODE()))
	    {
		cifSC.setSectionKey(addressCommonCOParam.getOpt());
		cifSC.setCurrAppName(addressCommonCOParam.getAppName());
		int cpt = coreCommonServiceBO.checkNegativeComp(cifSC);
		if(cpt == 1)
		{
		    cifSC.setComp_code(addressCommonCO.getCOMP_CODE().negate());
		}
	    }
	}
        cifSC.setPreventException(Boolean.TRUE);
        addressCommonCO.setCifVO(commonLibBO.returnCIF(cifSC));
        
        if(!language.equals(""))
        {
            addressCommonCO.getCifVO().setLANGUAGE(language);
        }
        
        //Added by Mark Ayoub on 02/06/2018 - Needed for cifType mandatory expression
        RequiredFieldsSC requiredFieldsSC = new RequiredFieldsSC();
	requiredFieldsSC.setCifType(addressCommonCO.getCifType());
	
	requiredFieldsSC.setCompCode(addressCommonCO.getCOMP_CODE());
	requiredFieldsSC.setBranchCode(addressCommonCO.getBRANCH_CODE());
	requiredFieldsSC.setPreferredLanguage(addressCommonCO.getLoginPreferrredLanguage());
	requiredFieldsSC.setLoginUserId(addressCommonCO.getLoginUserId());
	requiredFieldsSC.setAppName(addressCommonCO.getAppName());
	requiredFieldsSC.setProgRef(addressCommonCO.getOpt());
	requiredFieldsSC.setCountryId(addressCommonCO.getCOUNTRY());
	Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>();
	entityTypeInfosMap.put(ConstantsCommon.ENTITY_CIF_TYPE_LOV, addressCommonCO.getCifType());
	entityTypeInfosMap.put(ConstantsCommon.ENTITY_VT_TYPE_LOV, addressCommonCO.getGOVERNERATE_ARAB());
	
	   
	 //EWBI160173 -- [falha]
	entityTypeInfosMap.put(ConstantsCommon.ENTITY_COUNTRY_ID_LOV, addressCommonCOParam.getCOUNTRY());
	
	requiredFieldsSC.setEntityTypeInfosMap(entityTypeInfosMap);
	
	 
	if(NumberUtil.nullToZero(addressCommonCO.getCifVO().getCIF_NO()).compareTo(BigDecimal.ZERO) == 1)
	{
	    requiredFieldsSC.setCifNo(addressCommonCO.getCifVO().getCIF_NO());
	}
	addressCommonCO.setBuisnessElement(commonLibBO.returnMapRequiredData(requiredFieldsSC));
        
	//End Mark
        

        addressCommonCO.setBuisnessElement(initialiseAddressVisibility(addressCommonCO));
        addressCommonCO = applyPhoneFormat(addressCommonCO);
        return addressCommonCO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> initialiseAddressVisibility(AddressCommonCO addressCommonCO)
            throws BaseException
    {
        // addressCommonCO.getAddressCommonCO().setCOUNTRY(new BigDecimal(100));

	if (addressCommonCO.getCifControlVO().getADDRESS_DTL_SOURCE() != null) // added by nour for TP#925559
	{
	    if (addressCommonCO.getCifControlVO().getADDRESS_DTL_SOURCE().equals(ConstantsCommon.TWO)
		& !NumberUtil.isEmptyDecimal(addressCommonCO.getCifType()))
	    {
		RIFCTTVO rifCttVO = new RIFCTTVO();
		rifCttVO.setCOMP_CODE(addressCommonCO.getCOMP_CODE());
		rifCttVO.setTYPE_CODE(addressCommonCO.getCifType());
		rifCttVO = (RIFCTTVO) genericDAO.selectByPK(rifCttVO);

		addressCommonCO.getCifControlVO().setPOSTAL_MANDATORY(StringUtil.nullEmptyToValue(rifCttVO.getPOSTAL_CODE_MANDATORY(), ConstantsCommon.ZERO));
		addressCommonCO.getCifControlVO().setMENDATORY_ADDRESS(rifCttVO.getMANDATORY_ADDRESS());
		addressCommonCO.getCifControlVO().setPOBOX_MANDATORY(StringUtil.nullEmptyToValue(rifCttVO.getPOBOX_MANDATORY(), ConstantsCommon.ZERO));
		addressCommonCO.getCifControlVO().setREGION_IS_MANDATORY(StringUtil.nullEmptyToValue(rifCttVO.getREGION_MANDATORY(), ConstantsCommon.ZERO));
		addressCommonCO.getCifControlVO().setTEL_MANDATORY_YN(StringUtil.nullEmptyToValue(rifCttVO.getTEL_MANDATORY_YN(), ConstantsCommon.ZERO));
	    }
	}
	
        HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = addressCommonCO.getBuisnessElement();

        SYS_PARAM_SCREEN_DISPLAYVO addressVO;
        String language = StringUtil.nullEmptyToValue(addressCommonCO.getCifVO().getLANGUAGE(), NCifMaintenanceConstant.LATIN_LANGUAGE);
        if(language.equals(NCifMaintenanceConstant.BOTH_LANGUAGE))
        {
            language = NCifMaintenanceConstant.LATIN_LANGUAGE;
        }

        String address1Eng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getADDRESS1_ENG());
        String address2Eng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getADDRESS2_ENG());
        String address3Eng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getADDRESS3_ENG());
        String address4Eng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getADDRESS4_ENG());
        String regionEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getREGION_ENG());
        String cityEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getCITY_ENG());
        String countryEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getCOUNTRY_ENG());
        String poboxAreaEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getPOBOX_AREA_ENG());
        String postalCodeEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getPOSTAL_CODE_ENG());
        String telEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getTEL_ENG());
        String workTelEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getWORK_TEL_ENG());
        String mobileEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getMOBILE_ENG());
        String otherTelEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getOTHER_TEL_ENG());
        String faxEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getFAX_ENG());
        String emailEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getEMAIL_ENG());
        String cityCodeEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getCITY_CODE_ENG());
        String sectorCodeEng = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getSECTOR_ENG());

        
        /*
         * Arabic Fields - Reda #331474 15/09/2015
         */
        String address1Arab = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getADDRESS1_ARAB());
        String address2Arab = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getADDRESS2_ARAB());
        String address3Arab = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getADDRESS3_ARAB());
        String address4Arab = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getADDRESS4_ARAB());
        String cityArab = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getCITY_ARAB());
        
        String useAddressDesc = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getUSE_ADDRESS_DESC());
        //MAUREENA 529712 DB170051 - BRS Mobile Banking Integration R14
        String wallet = addressCommonCO.geteWalletFlag() ? "1" : "0";
        String cifControlwallet =StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getMOBILE_WALLET_CIF_UPDATE_YN()); 
        

        if("0".equals(useAddressDesc))
        {

            address1Eng = "";
            address2Eng = "";
            address3Eng = "";
            address4Eng = "";
            regionEng = "";
            cityEng = "";
            countryEng = "";
            poboxAreaEng = "";
            postalCodeEng = "";
            telEng = "";
            workTelEng = "";
            mobileEng = "";
            otherTelEng = "";
            faxEng = "";
            emailEng = "";
            cityCodeEng = "";
            sectorCodeEng = "";
            
            /*
             * Arabic Fields - Reda #331474 15/09/2015
             */
            address1Arab = "";
            address2Arab = "";
            address3Arab = "";
            address4Arab = "";
            cityArab = "";

        }
        
        //Added by Mark Ayoub on 02/06/2018 - Needed for cifType mandatory expression - Commenting new instances and replacing them with applyDynScreenDisplay
        
        /*
         * Check common fields
         */
        /*
	addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
	addressVO.setELEMENT_NAME("addressCO.ADDRESS_DESC");
	elementHashmap.put("addressCO.ADDRESS_DESC", addressVO);
	*/
        applyDynScreenDisplay("addressCO_ADDRESS_DESC", "addressCO.ADDRESS_DESC", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);

        /*
	addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
	addressVO.setELEMENT_NAME("addressCO.CONTACT_NAME");
	elementHashmap.put("addressCO.CONTACT_NAME", addressVO);
	*/
        applyDynScreenDisplay("addressCO_CONTACT_NAME", "addressCO.CONTACT_NAME", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
        
        //addressCO.CONTACT_NAME_ARAB
        //applyDynScreenDisplay("addressCO_CONTACT_NAME_ARAB", "addressCO.CONTACT_NAME_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
       //addressCO.CONTACT_NAME_ARAB  
        
        //addressCO.SALUTATION_ARAB
        //applyDynScreenDisplay("addressCO_SALUTATION_ARAB", "addressCO.SALUTATION_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
       //addressCO.SALUTATION_ARAB  
        
        //addressCO.SALUTATION_ENG
	    applyDynScreenDisplay("addressCO_SALUTATION_ENG", "addressCO.SALUTATION_ENG",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
	    //addressCO.SALUTATION_ENG

        //addressCO.SALUTATION_ARAB
        //applyDynScreenDisplay("addressCO_GOVERNERATE_ARAB", "addressCO.GOVERNERATE_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
       //addressCO.SALUTATION_ARAB  


       //addressCO.GOVERNERATE_ENG
	  applyDynScreenDisplay("addressCO_GOVERNERATE_ENG", "addressCO.GOVERNERATE_ENG",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
	//addressCO.GOVERNERATE_ENG

	  
	  
	  
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, regionEng));
        addressVO.setELEMENT_NAME("addressCO.REGION");
        if(regionEng.length() > 0)
        {
            addressVO.setLABEL_KEY(regionEng);
        }
        addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.REGION"));
        elementHashmap.put("addressCO.REGION", addressVO);
        */
	//addressCO.REGION
        if("1".equals(useAddressDesc) && regionEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.REGION", "addressCO.REGION", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(regionEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.REGION", "addressCO.REGION", ConstantsCommon.ACTION_TYPE_LABEL,regionEng, elementHashmap, null);
        }
        
        String regionIsMandatory = StringUtil.nullEmptyToValue(addressCommonCO.getCifControlVO().getREGION_IS_MANDATORY(), "N");
        
        
        if("Y".equals(regionIsMandatory) || "1".equals(regionIsMandatory))
        {
            applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);    
        }
        else
        {
            applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);    
        }
        //addressCO.REGION   
        
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, countryEng));
        addressVO.setELEMENT_NAME("addressCO.COUNTRY");
        if(countryEng.length() > 0)
        {
            addressVO.setLABEL_KEY(countryEng);
        }
        addressVO.setIS_MANDATORY(BigDecimal.ONE);
        elementHashmap.put("addressCO.COUNTRY", addressVO);
	*/
        //addressCO.COUNTRY
        if("1".equals(useAddressDesc) && countryEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.COUNTRY", "addressCO.COUNTRY", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(countryEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.COUNTRY", "addressCO.COUNTRY", ConstantsCommon.ACTION_TYPE_LABEL,countryEng, elementHashmap, null);
        }
        
        applyDynScreenDisplay("addressCO.COUNTRY", "addressCO.COUNTRY", ConstantsCommon.ACTION_TYPE_MANDATORY, "1", elementHashmap, null);    
        //addressCO.COUNTRY    
        
        
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, cityCodeEng));
        addressVO.setELEMENT_NAME("addressCO.CITY_CODE");
        if(cityCodeEng.length() > 0)
        {
            addressVO.setLABEL_KEY(cityCodeEng);
        }
        addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.CITY_CODE"));
        elementHashmap.put("addressCO.CITY_CODE", addressVO);
	*/
        //addressCO.CITY_CODE
        if("1".equals(useAddressDesc) && cityCodeEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.CITY_CODE", "addressCO.CITY_CODE", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(cityCodeEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.CITY_CODE", "addressCO.CITY_CODE", ConstantsCommon.ACTION_TYPE_LABEL,cityCodeEng, elementHashmap, null);
        }
        
        
       //applyDynScreenDisplay("addressCO.CITY_CODE", "addressCO.CITY_CODE", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);    
       //addressCO.CITY_CODE
        
         
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, sectorCodeEng));
        addressVO.setELEMENT_NAME("addressCO.SECTOR_CODE");
        if(sectorCodeEng.length() > 0)
        {
            addressVO.setLABEL_KEY(sectorCodeEng);
        }
        addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.SECTOR_CODE"));
        elementHashmap.put("addressCO.SECTOR_CODE", addressVO);
	*/
        //addressCO.SECTOR_CODE
        if("1".equals(useAddressDesc) && sectorCodeEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.SECTOR_CODE", "addressCO.SECTOR_CODE", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(sectorCodeEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.SECTOR_CODE", "addressCO.SECTOR_CODE", ConstantsCommon.ACTION_TYPE_LABEL,sectorCodeEng, elementHashmap, null);
        }
        
        if(ConstantsCommon.BA_ALGERIA.toString().equals(
		StringUtil.nullEmptyToValue(addressCommonCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ(), "0")))
        {
            
            applyDynScreenDisplay("addressCO.SECTOR_CODE", "addressCO.SECTOR_CODE", ConstantsCommon.ACTION_TYPE_MANDATORY, "1", elementHashmap, null);
        }
        //addressCO.SECTOR_CODE
        
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, poboxAreaEng));
        addressVO.setELEMENT_NAME("addressCO.POBOX_AREA");
        if(poboxAreaEng.length() > 0)
        {
            addressVO.setLABEL_KEY(poboxAreaEng);
        }
        addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.POBOX_AREA"));
        elementHashmap.put("addressCO.POBOX_AREA", addressVO);
	*/
        //addressCO.POBOX_AREA
        if("1".equals(useAddressDesc) && poboxAreaEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.POBOX_AREA", "addressCO.POBOX_AREA", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(poboxAreaEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.POBOX_AREA", "addressCO.POBOX_AREA", ConstantsCommon.ACTION_TYPE_LABEL,poboxAreaEng, elementHashmap, null);
        }
        
        if (NCifMaintenanceConstant.POBOX_MANDATORY_ON.equals(
        	StringUtil.nullEmptyToValue(addressCommonCO.getCifControlVO().getPOBOX_MANDATORY(), "0")))
        {
            
            applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA", ConstantsCommon.ACTION_TYPE_MANDATORY, "1", elementHashmap, null);
        }
        else
        {
            applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA", ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
        }
        //addressCO.POBOX_AREA
        
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, poboxAreaEng));
        addressVO.setELEMENT_NAME("addressCO.PO_BOX");
        elementHashmap.put("addressCO.PO_BOX", addressVO);
        */
        //addressCO.PO_BOX
        if("1".equals(useAddressDesc) && poboxAreaEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.PO_BOX", "addressCO.PO_BOX", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        //addressCO.PO_BOX

        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, poboxAreaEng));
        addressVO.setELEMENT_NAME("addressCO.poBoxAreaDesc");
        elementHashmap.put("addressCO.poBoxAreaDesc", addressVO);
        */
        //addressCO.poBoxAreaDesc
        if("1".equals(useAddressDesc) && poboxAreaEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.poBoxAreaDesc", "addressCO.poBoxAreaDesc", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        //addressCO.poBoxAreaDesc

        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, postalCodeEng));
        addressVO.setELEMENT_NAME("addressCO.POSTAL_CODE");
        if(postalCodeEng.length() > 0)
        {
            addressVO.setLABEL_KEY(postalCodeEng);
        }
        addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.POSTAL_CODE"));
        elementHashmap.put("addressCO.POSTAL_CODE", addressVO);
	*/
        //addressCO.POSTAL_CODE
        if("1".equals(useAddressDesc) && postalCodeEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(postalCodeEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE", ConstantsCommon.ACTION_TYPE_LABEL,postalCodeEng, elementHashmap, null);
        }
        
        if (NCifMaintenanceConstant.POBOX_MANDATORY_ON.equals(
        	StringUtil.nullEmptyToValue(addressCommonCO.getCifControlVO().getPOSTAL_MANDATORY(), "0")))
        {
            
            applyDynScreenDisplay("lookuptxt_addressCO_POSTAL_CODE", "addressCO.POSTAL_CODE", ConstantsCommon.ACTION_TYPE_MANDATORY, "1", elementHashmap, null);
        }
        else
        {
            applyDynScreenDisplay("lookuptxt_addressCO_POSTAL_CODE", "addressCO.POSTAL_CODE", ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
        }
        //addressCO.POSTAL_CODE
        
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, postalCodeEng));
        addressVO.setELEMENT_NAME("addressCO.POSTAL_CODE1");
        if(postalCodeEng.length() > 0)
        {
            addressVO.setLABEL_KEY(postalCodeEng);
        }
        addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.POSTAL_CODE1"));
        elementHashmap.put("addressCO.POSTAL_CODE1", addressVO);
        */
        //addressCO.POSTAL_CODE1
        if("1".equals(useAddressDesc) && postalCodeEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(postalCodeEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1", ConstantsCommon.ACTION_TYPE_LABEL,postalCodeEng, elementHashmap, null);
        }
        
        if (NCifMaintenanceConstant.POBOX_MANDATORY_ON.equals(
        	StringUtil.nullEmptyToValue(addressCommonCO.getCifControlVO().getPOSTAL_MANDATORY(), "0")))
        {
            
            applyDynScreenDisplay("lookuptxt_addressCO_POSTAL_CODE", "addressCO.POSTAL_CODE1", ConstantsCommon.ACTION_TYPE_MANDATORY, "1", elementHashmap, null);
        }
        else
        {
            applyDynScreenDisplay("lookuptxt_addressCO_POSTAL_CODE", "addressCO.POSTAL_CODE1", ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
        }
        //addressCO.POSTAL_CODE1

        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, telEng));
        addressVO.setELEMENT_NAME("addressCO.TEL");
        if(telEng.length() > 0)
        {
            addressVO.setLABEL_KEY(telEng);
        }
        addressVO.setIS_MANDATORY(BigDecimal.ONE);
        elementHashmap.put("addressCO.TEL", addressVO);
        */
        //addressCO.TEL
        if("1".equals(useAddressDesc) && telEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(telEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_LABEL,telEng, elementHashmap, null);
        }
        
	if(ConstantsCommon.ONE
		.equals(StringUtil.nullEmptyToValue(addressCommonCO.getCifControlVO().getTEL_MANDATORY_YN(), "0")))
	{
	    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_MANDATORY, "1",
		    elementHashmap, null);
	}
	else
	{
	    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_MANDATORY, "0",
		    elementHashmap, null);
	}
        //addressCO.TEL

        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, workTelEng));
        addressVO.setELEMENT_NAME("addressCO.WORK_TEL");
        if(workTelEng.length() > 0)
        {
            addressVO.setLABEL_KEY(workTelEng);
        }
        elementHashmap.put("addressCO.WORK_TEL", addressVO);
	*/
        //addressCO.WORK_TEL
        if("1".equals(useAddressDesc) && workTelEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(workTelEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_LABEL,workTelEng, elementHashmap, null);
        }
        //addressCO.WORK_TEL
        
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, otherTelEng));
        addressVO.setELEMENT_NAME("addressCO.OTHER_TEL");
        if(otherTelEng.length() > 0)
        {
            addressVO.setLABEL_KEY(otherTelEng);
        }
        elementHashmap.put("addressCO.OTHER_TEL", addressVO);
	*/
        //addressCO.OTHER_TEL
        if("1".equals(useAddressDesc) && otherTelEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(otherTelEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_LABEL,otherTelEng, elementHashmap, null);
        }
        //addressCO.OTHER_TEL
        
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, emailEng));
        addressVO.setELEMENT_NAME("addressCO.EMAIL");
        if(emailEng.length() > 0)
        {
            addressVO.setLABEL_KEY(emailEng);
        }
        elementHashmap.put("addressCO.EMAIL", addressVO);
	*/
        //addressCO.EMAIL
        if("1".equals(useAddressDesc) && emailEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(emailEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_LABEL,emailEng, elementHashmap, null);
        }
        //addressCO.EMAIL
        
        /*
        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, faxEng));
        addressVO.setELEMENT_NAME("addressCO.FAX");
        if(faxEng.length() > 0)
        {
            addressVO.setLABEL_KEY(faxEng);
        }
        elementHashmap.put("addressCO.FAX", addressVO);

        
        // addressVO =new SYS_PARAM_SCREEN_DISPLAYVO();
        // addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc,emailEng));
        // addressVO.setELEMENT_NAME("addressCO.EMAIL");
        // addressVO.setLABEL_KEY(emailEng);
        // elementHashmap.put("addressCO.EMAIL", addressVO);

        addressVO = elementHashmap.put("addressCO.MOBILE", addressVO);
        if(addressVO==null)
        {
            //in case no record is parametrized in dynamic display, create new one
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        }
        addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, mobileEng));
        addressVO.setELEMENT_NAME("addressCO.MOBILE");
        if(mobileEng.length() > 0)
        {
            addressVO.setLABEL_KEY(mobileEng);
        }
        elementHashmap.put("addressCO.MOBILE", addressVO);
        */
        //addressCO.FAX
        if("1".equals(useAddressDesc) && faxEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(faxEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_LABEL,faxEng, elementHashmap, null);
        }
        //addressCO.FAX

        
        //addressCO.MOBILE
        if("1".equals(useAddressDesc) && mobileEng.length() == 0)
        {
            applyDynScreenDisplay("addressCO.MOBILE", "addressCO.MOBILE", ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
        }
        if(mobileEng.length() > 0)
        {
            applyDynScreenDisplay("addressCO.MOBILE", "addressCO.MOBILE", ConstantsCommon.ACTION_TYPE_LABEL,mobileEng, elementHashmap, null);
        }
        //addressCO.MOBILE
        

        // To hide a field not needed in FOM but present in Account Screen
//        addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
//        addressVO.setIS_VISIBLE(BigDecimal.ZERO);
//        addressVO.setELEMENT_NAME("addressCO.POSTAL_CODE1");
//        elementHashmap.put("addressCO.POSTAL_CODE1", addressVO);
//        
        
        /*
         * Check English / Arabic Fields
         */
        if(NCifMaintenanceConstant.LATIN_LANGUAGE.equals(language))
	{
            String mandatoryAddress = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getMENDATORY_ADDRESS());
            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.SALUTATION_ENG");
         // The property dependencyCallSource is filled true is this case to check if i am calling this method from dependency 
            // dependencyCallSource is set to tru from FOMMaintValidations.js function fomNameAddressLanguageDropDown_onChange()
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_SALUTATION_ENG", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.SALUTATION_ENG", addressVO);
            }
	    */
            //addressCO.SALUTATION_ENG
    	    applyDynScreenDisplay("addressCO_SALUTATION_ENG", "addressCO.SALUTATION_ENG",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
    	    //addressCO.SALUTATION_ENG
            
            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.GOVERNERATE_ENG");
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_GOVERNERATE_ENG", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.GOVERNERATE_ENG", addressVO);
            }
            */
    	    //addressCO.GOVERNERATE_ENG
    	    applyDynScreenDisplay("addressCO_GOVERNERATE_ENG", "addressCO.GOVERNERATE_ENG",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            //addressCO.GOVERNERATE_ENG
    	    
    	    /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.CONTACT_NAME_ARAB");
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_CONTACT_NAME_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.CONTACT_NAME_ARAB", addressVO);
            }
            */
            //addressCO.CONTACT_NAME_ARAB
            applyDynScreenDisplay("addressCO_CONTACT_NAME_ARAB", "addressCO.CONTACT_NAME_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
            //addressCO.CONTACT_NAME_ARAB  

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.SALUTATION_ARAB");
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_SALUTATION_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.SALUTATION_ARAB", addressVO);
            }
	    */
            //addressCO.SALUTATION_ARAB
            applyDynScreenDisplay("addressCO_SALUTATION_ARAB", "addressCO.SALUTATION_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
            //addressCO.SALUTATION_ARAB  
            
            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.GOVERNERATE_ARAB");
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_GOVERNERATE_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.GOVERNERATE_ARAB", addressVO);
            }
            */
            //addressCO.GOVERNERATE_ARAB
  	    applyDynScreenDisplay("addressCO_GOVERNERATE_ARAB", "addressCO.GOVERNERATE_ARAB",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
  	    //addressCO.GOVERNERATE_ARAB

  	    /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, address1Eng));
            addressVO.setELEMENT_NAME("addressCO.ADDRESS1_ENG");
            if(address1Eng.length() > 0)
            {
                addressVO.setLABEL_KEY(address1Eng);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.ADDRESS1_ENG"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_ADDRESS1_ENG", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.ADDRESS1_ENG", addressVO);
            }
            */
            //addressCO.ADDRESS1_ENG
            if("1".equals(useAddressDesc) && address1Eng.length() == 0)
            {
        	applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(address1Eng.length() > 0)
            {
                applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG", ConstantsCommon.ACTION_TYPE_LABEL,address1Eng, elementHashmap, null);
            }
            
            
            if( ("1".equals(mandatoryAddress) || "2".equals(mandatoryAddress) || "3".equals(mandatoryAddress)
                            || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))

            {
        	applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.ADDRESS1_ENG
            

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, address2Eng));
            addressVO.setELEMENT_NAME("addressCO.ADDRESS2_ENG");
            if(address2Eng.length() > 0)
            {
                addressVO.setLABEL_KEY(address2Eng);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.ADDRESS2_ENG"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_ADDRESS2_ENG", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.ADDRESS2_ENG", addressVO);
            }
            */
            //addressCO.ADDRESS2_ENG
            if("1".equals(useAddressDesc) && address2Eng.length() == 0)
            {
        	applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(address2Eng.length() > 0)
            {
                applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG", ConstantsCommon.ACTION_TYPE_LABEL,address2Eng, elementHashmap, null);
            }
            
            
            if("2".equals(mandatoryAddress) || "3".equals(mandatoryAddress)
                            || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress))

            {
        	applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.ADDRESS2_ENG
            
            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, address3Eng));
            addressVO.setELEMENT_NAME("addressCO.ADDRESS3_ENG");
            if(address3Eng.length() > 0)
            {
                addressVO.setLABEL_KEY(address3Eng);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.ADDRESS3_ENG"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_ADDRESS3_ENG", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.ADDRESS3_ENG", addressVO);
            }
            */
            //addressCO.ADDRESS3_ENG
            if("1".equals(useAddressDesc) && address3Eng.length() == 0)
            {
        	applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(address3Eng.length() > 0)
            {
                applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG", ConstantsCommon.ACTION_TYPE_LABEL,address3Eng, elementHashmap, null);
            }
            
            if("3".equals(mandatoryAddress)
                            || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress))

            {
        	applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.ADDRESS3_ENG
            
    	    /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, address4Eng));
            addressVO.setELEMENT_NAME("addressCO.ADDRESS4_ENG");
            if(address4Eng.length() > 0)
            {
                addressVO.setLABEL_KEY(address4Eng);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.ADDRESS4_ENG"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_ADDRESS4_ENG", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.ADDRESS4_ENG", addressVO);
            }
	    */
            //addressCO.ADDRESS4_ENG
            if("1".equals(useAddressDesc) && address4Eng.length() == 0)
            {
        	applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(address4Eng.length() > 0)
            {
                applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG", ConstantsCommon.ACTION_TYPE_LABEL,address4Eng, elementHashmap, null);
            }
            
            if("4".equals(mandatoryAddress) || "5".equals(mandatoryAddress))

            {
        	applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.ADDRESS4_ENG
            
            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, cityEng));
            addressVO.setELEMENT_NAME("addressCO.CITY_ENG");
            if(cityEng.length() > 0)
            {
                addressVO.setLABEL_KEY(cityEng);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.CITY_ENG"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_CITY_ENG", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.CITY_ENG", addressVO);
            }
            */
            //addressCO.CITY_ENG
            if("1".equals(useAddressDesc) && cityEng.length() == 0)
            {
        	applyDynScreenDisplay("addressCO.CITY_ENG", "addressCO.CITY_ENG",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(cityEng.length() > 0)
            {
                applyDynScreenDisplay("addressCO.CITY_ENG", "addressCO.CITY_ENG", ConstantsCommon.ACTION_TYPE_LABEL,cityEng, elementHashmap, null);
            }
            
            if("5".equals(mandatoryAddress) || (ConstantsCommon.BA_ALGERIA.toString().equals(StringUtil.nullEmptyToValue(
        	    addressCommonCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ(),"0"))))

            {
        	applyDynScreenDisplay("addressCO_CITY_ENG", "addressCO.CITY_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_CITY_ENG", "addressCO.CITY_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.CITY_ENG
           
            //Abdo for Both language show arab address
            String bothLang =  StringUtil.nullEmptyToValue(addressCommonCO.getCifVO().getLANGUAGE(),
                    NCifMaintenanceConstant.LATIN_LANGUAGE);
	    if(bothLang.equals(NCifMaintenanceConstant.BOTH_LANGUAGE))
		{
			applyDynScreenDisplay("addressCO_ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
			applyDynScreenDisplay("addressCO_ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
			applyDynScreenDisplay("addressCO_ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
			applyDynScreenDisplay("addressCO_ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
			applyDynScreenDisplay("addressCO_CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
			applyDynScreenDisplay("addressCO_STREET_DETAILS_ARAB", "addressCO.STREET_DETAILS_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
			//Rania - BMO180181
			applyDynScreenDisplay("addressCO_CONTACT_NAME_ARAB", "addressCO.CONTACT_NAME_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
	        applyDynScreenDisplay("addressCO_SALUTATION_ARAB", "addressCO.SALUTATION_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
	        applyDynScreenDisplay("addressCO_GOVERNERATE_ARAB", "addressCO.GOVERNERATE_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
	        //

		}
	    else
		{
			applyDynScreenDisplay("addressCO_ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
			applyDynScreenDisplay("addressCO_ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
			applyDynScreenDisplay("addressCO_ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
			applyDynScreenDisplay("addressCO_ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
			applyDynScreenDisplay("addressCO_CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
			applyDynScreenDisplay("addressCO_STREET_DETAILS_ARAB", "addressCO.STREET_DETAILS_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
			//Rania - BMO180181
			applyDynScreenDisplay("addressCO_CONTACT_NAME_ARAB", "addressCO.CONTACT_NAME_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
	        applyDynScreenDisplay("addressCO_SALUTATION_ARAB", "addressCO.SALUTATION_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
	        applyDynScreenDisplay("addressCO_GOVERNERATE_ARAB", "addressCO.GOVERNERATE_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
	        //
		}
	}
        else
        {

          //Rania - BMO180181
    	applyDynScreenDisplay("addressCO_CONTACT_NAME_ARAB", "addressCO.CONTACT_NAME_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
        applyDynScreenDisplay("addressCO_SALUTATION_ARAB", "addressCO.SALUTATION_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
        applyDynScreenDisplay("addressCO_GOVERNERATE_ARAB", "addressCO.GOVERNERATE_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
        applyDynScreenDisplay("addressCO_ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
        applyDynScreenDisplay("addressCO_ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
        applyDynScreenDisplay("addressCO_ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
        applyDynScreenDisplay("addressCO_STREET_DETAILS_ARAB", "addressCO.STREET_DETAILS_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
        applyDynScreenDisplay("addressCO_CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "1", elementHashmap, null);
        //
            // Doing here also in case default Language is Arabic
            
            String mandatoryAddress = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getMENDATORY_ADDRESS());
            
            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.ADDRESS_DESC");
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_ADDRESS_DESC", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.ADDRESS_DESC", addressVO);
            }
            */
            //addressCO.ADDRESS_DESC 
            applyDynScreenDisplay("addressCO_ADDRESS_DESC", "addressCO.ADDRESS_DESC", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
            //addressCO.ADDRESS_DESC

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.CONTACT_NAME");
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_CONTACT_NAME", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.CONTACT_NAME", addressVO);
            }
            */
            //addressCO.CONTACT_NAME
            applyDynScreenDisplay("addressCO_CONTACT_NAME", "addressCO.CONTACT_NAME", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
            //addressCO.CONTACT_NAME 

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.CONTACT_NAME_ARAB");
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_CONTACT_NAME_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.CONTACT_NAME_ARAB", addressVO);
            }
            */
            //addressCO.CONTACT_NAME_ARAB
            applyDynScreenDisplay("addressCO_CONTACT_NAME_ARAB", "addressCO.CONTACT_NAME_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
            //addressCO.CONTACT_NAME_ARAB 

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.SALUTATION_ARAB");
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_SALUTATION_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.SALUTATION_ARAB", addressVO);
            }
            */
            //addressCO.SALUTATION_ARAB
            applyDynScreenDisplay("addressCO_SALUTATION_ARAB", "addressCO.SALUTATION_ARAB", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", elementHashmap, null);
            //addressCO.SALUTATION_ARAB 

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(BigDecimal.ZERO);// Hide
            addressVO.setELEMENT_NAME("addressCO.GOVERNERATE_ARAB");
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_GOVERNERATE_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.GOVERNERATE_ARAB", addressVO);
            }
            */
            //addressCO.GOVERNERATE_ARAB
  	    applyDynScreenDisplay("addressCO_GOVERNERATE_ARAB", "addressCO.GOVERNERATE_ARAB",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
  	    //addressCO.GOVERNERATE_ARAB
            
      
            /*
             * Arabic Fields - Reda #331474 15/09/2015
             */
  	    /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, address1Arab));
            addressVO.setELEMENT_NAME("addressCO.ADDRESS1_ARAB");
            if(address1Arab.length() > 0)
            {
                addressVO.setLABEL_KEY(address1Arab);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.ADDRESS1_ARAB"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_ADDRESS1_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.ADDRESS1_ARAB", addressVO);
            }
            */
            //addressCO.ADDRESS1_ARAB
            if("1".equals(useAddressDesc) && address1Arab.length() == 0)
            {
        	applyDynScreenDisplay("addressCO.ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(address1Arab.length() > 0)
            {
                applyDynScreenDisplay("addressCO.ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB", ConstantsCommon.ACTION_TYPE_LABEL,address1Arab, elementHashmap, null);
            }
            
            
            if( ("1".equals(mandatoryAddress) || "2".equals(mandatoryAddress) || "3".equals(mandatoryAddress)
                            || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))

            {
        	applyDynScreenDisplay("addressCO_ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.ADDRESS1_ARAB

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, address2Arab));
            addressVO.setELEMENT_NAME("addressCO.ADDRESS2_ARAB");
            if(address2Arab.length() > 0)
            {
                addressVO.setLABEL_KEY(address2Arab);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.ADDRESS2_ARAB"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_ADDRESS2_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.ADDRESS2_ARAB", addressVO);
            }
            */
            //addressCO.ADDRESS2_ARAB
            if("1".equals(useAddressDesc) && address2Arab.length() == 0)
            {
        	applyDynScreenDisplay("addressCO.ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(address2Arab.length() > 0)
            {
                applyDynScreenDisplay("addressCO.ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB", ConstantsCommon.ACTION_TYPE_LABEL,address2Arab, elementHashmap, null);
            }
            
            
            if( ("2".equals(mandatoryAddress) || "3".equals(mandatoryAddress)
                            || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))

            {
        	applyDynScreenDisplay("addressCO_ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.ADDRESS2_ARAB
            

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, address3Arab));
            addressVO.setELEMENT_NAME("addressCO.ADDRESS3_ARAB");
            if(address3Arab.length() > 0)
            {
                addressVO.setLABEL_KEY(address3Arab);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.ADDRESS3_ARAB"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_ADDRESS3_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.ADDRESS3_ARAB", addressVO);
            }
            */
            //addressCO.ADDRESS3_ARAB
            if("1".equals(useAddressDesc) && address3Arab.length() == 0)
            {
        	applyDynScreenDisplay("addressCO.ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(address3Arab.length() > 0)
            {
                applyDynScreenDisplay("addressCO.ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB", ConstantsCommon.ACTION_TYPE_LABEL,address3Arab, elementHashmap, null);
            }
            
            
            if( ("3".equals(mandatoryAddress)
                            || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))

            {
        	applyDynScreenDisplay("addressCO_ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.ADDRESS3_ARAB
            

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, address4Arab));
            addressVO.setELEMENT_NAME("addressCO.ADDRESS4_ARAB");
            if(address4Arab.length() > 0)
            {
                addressVO.setLABEL_KEY(address4Arab);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.ADDRESS4_ARAB"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_ADDRESS4_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.ADDRESS4_ARAB", addressVO);
            }
            */
            //addressCO.ADDRESS4_ARAB
            if("1".equals(useAddressDesc) && address4Arab.length() == 0)
            {
        	applyDynScreenDisplay("addressCO.ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(address4Arab.length() > 0)
            {
                applyDynScreenDisplay("addressCO.ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB", ConstantsCommon.ACTION_TYPE_LABEL,address4Arab, elementHashmap, null);
            }
            
            
            if( ("4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))

            {
        	applyDynScreenDisplay("addressCO_ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.ADDRESS4_ARAB
            

            /*
            addressVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            addressVO.setIS_VISIBLE(checkAddressVisibility(useAddressDesc, cityArab));
            addressVO.setELEMENT_NAME("addressCO.CITY_ARAB");
            if(cityArab.length() > 0)
            {
                addressVO.setLABEL_KEY(cityArab);
            }
            addressVO.setIS_MANDATORY(checkMandatoryAddressDetails(addressCommonCO, "addressCO.CITY_ARAB"));
            if("true".equals(addressCommonCO.getDependencyCallSource()))
            {
                elementHashmap.put("addressCO_CITY_ARAB", addressVO);
            }
            else
            {
                elementHashmap.put("addressCO.CITY_ARAB", addressVO);
            }
            */
            //addressCO.CITY_ARAB
            if("1".equals(useAddressDesc) && cityArab.length() == 0)
            {
        	applyDynScreenDisplay("addressCO.CITY_ARAB", "addressCO.CITY_ARAB",ConstantsCommon.ACTION_TYPE_VISIBLE,"0", elementHashmap, null);
            }
            if(cityArab.length() > 0)
            {
                applyDynScreenDisplay("addressCO.CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_LABEL,cityArab, elementHashmap, null);
            }
            
            if("5".equals(mandatoryAddress) || (ConstantsCommon.BA_ALGERIA.toString().equals(StringUtil.nullEmptyToValue(
        	    addressCommonCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ(),"0"))))

            {
        	applyDynScreenDisplay("addressCO_CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"1", elementHashmap, null);
            }
            else
            {
        	applyDynScreenDisplay("addressCO_CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_MANDATORY,"0", elementHashmap, null);
            }
            //addressCO.CITY_ARAB
            
            
        }
        //id:1041956 Details:DBU190266 - Flag at CSM Admin is unchecked and system is enabling the Wallet falha
        if("1".equals(cifControlwallet))
	    {
		applyDynScreenDisplay("addressCO_E_WALLET","addressCO.eWalletFlag",ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		
	    }
	    else{
		
		applyDynScreenDisplay("addressCO_E_WALLET","addressCO.eWalletFlag",ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);

	    }
//id:1041956 Details:DBU190266 - Flag at CSM Admin is unchecked and system is enabling the Wallet falha
     
        
        //MAUREENA 529712 DB170051 - BRS Mobile Banking Integration R14
       	if("1".equals(wallet))
       	{
       	    
       	    if ("L".equals(language)){
       		
           	    if("1".equals(cifControlwallet))
           	    {
           		applyDynScreenDisplay("addressCO_MOBILE", "addressCO.MOBILE",
           			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
           	    }
           	    else
           	    {
           		applyDynScreenDisplay("addressCO_MOBILE", "addressCO.MOBILE",
           			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
           	    }
       	    applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_STREET_DETAILS_ENG", "addressCO.STREET_DETAILS_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_CITY_ENG", "addressCO.CITY_ENG", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_READONLY,
       		    "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_CITY_CODE", "addressCO.CITY_CODE",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_PO_BOX", "addressCO.PO_BOX", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_ADDRESS_DESCRIPTION", "addressCO.ADDRESS_DESCRIPTION",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_EXPIRY_DATE", "addressCO.EXPIRY_DATE",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_FROM_DATE", "addressCO.FROM_DATE", ConstantsCommon.ACTION_TYPE_READONLY,
       		    "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_TO_DATE", "addressCO.TO_DATE", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_PERM_ADDRESS", "addressCO.permnAddrFlag",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_DEFAULT_ADD", "addressCO.defaultAddrFlag",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_PRINT_STAT", "addressCO.printAddrFlag",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    
       	    applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	    
       	    applyDynScreenDisplay("addressCO_CITY_ENG", "addressCO.CITY_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY, "0",
       		    elementHashmap, null);
       	    
       	    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	    
       	    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	    
       	    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_MANDATORY, "0",
       		    elementHashmap, null);
       	    
       	    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	   
       	    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
       		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       	    
       	}
       	    else { /*language arabic*/
       		
       		

       		
       	    	    if("1".equals(cifControlwallet))
       	    	    {
       	    		applyDynScreenDisplay("addressCO_MOBILE", "addressCO.MOBILE",
       	    			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    	    }
       	    	    else
       	    	    {
       	    		applyDynScreenDisplay("addressCO_MOBILE", "addressCO.MOBILE",
       	    			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       	    	    }
       		    applyDynScreenDisplay("addressCO_ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_STREET_DETAILS_ARAB", "addressCO.STREET_DETAILS_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_READONLY,
       			    "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_CITY_CODE", "addressCO.CITY_CODE",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_PO_BOX", "addressCO.PO_BOX", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_ADDRESS_DESCRIPTION", "addressCO.ADDRESS_DESCRIPTION",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_EXPIRY_DATE", "addressCO.EXPIRY_DATE",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_FROM_DATE", "addressCO.FROM_DATE", ConstantsCommon.ACTION_TYPE_READONLY,
       			    "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_TO_DATE", "addressCO.TO_DATE", ConstantsCommon.ACTION_TYPE_READONLY, "1",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_PERM_ADDRESS", "addressCO.permnAddrFlag",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_DEFAULT_ADD", "addressCO.defaultAddrFlag",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_PRINT_STAT", "addressCO.printAddrFlag",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
       		    
       		    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
       			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
       			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       		    
       		    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
       			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       		    
       		    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_MANDATORY, "0",
       			    elementHashmap, null);
       		    
       		    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
       			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
       			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       		   
       		    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
       			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
       		    
       		
       		
       	    }
       	    
       	}
       	else
       	{ 
       	    if ("L".equals(language)){
       		
       	    
       	    applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_STREET_DETAILS_ENG", "addressCO.STREET_DETAILS_ENG",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_CITY_ENG", "addressCO.CITY_ENG", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       		    elementHashmap, null);
       /*Commented in order to apply customization mandatory
        * 	    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       		    elementHashmap, null);*/
       	    applyDynScreenDisplay("addressCO_WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_READONLY,
       		    "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_CITY_CODE", "addressCO.CITY_CODE",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_PO_BOX", "addressCO.PO_BOX", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("lookuptxt_addressCO_ADDRESS_DESCRIPTION", "addressCO.ADDRESS_DESCRIPTION",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_EXPIRY_DATE", "addressCO.EXPIRY_DATE",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_FROM_DATE", "addressCO.FROM_DATE", ConstantsCommon.ACTION_TYPE_READONLY,
       		    "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_TO_DATE", "addressCO.TO_DATE", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       		    elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_PERM_ADDRESS", "addressCO.permnAddrFlag",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_DEFAULT_ADD", "addressCO.defaultAddrFlag",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	    applyDynScreenDisplay("addressCO_PRINT_STAT", "addressCO.printAddrFlag",
       		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       	
       	    }
       	    
       	    else { 
       		
       		

       		
       		    
       		    applyDynScreenDisplay("addressCO_ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_STREET_DETAILS_ARAB", "addressCO.STREET_DETAILS_ARAB",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_READONLY,
       			    "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_CITY_CODE", "addressCO.CITY_CODE",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_PO_BOX", "addressCO.PO_BOX", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("lookuptxt_addressCO_ADDRESS_DESCRIPTION", "addressCO.ADDRESS_DESCRIPTION",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_EXPIRY_DATE", "addressCO.EXPIRY_DATE",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_FROM_DATE", "addressCO.FROM_DATE", ConstantsCommon.ACTION_TYPE_READONLY,
       			    "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_TO_DATE", "addressCO.TO_DATE", ConstantsCommon.ACTION_TYPE_READONLY, "0",
       			    elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_PERM_ADDRESS", "addressCO.permnAddrFlag",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_DEFAULT_ADD", "addressCO.defaultAddrFlag",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		    applyDynScreenDisplay("addressCO_PRINT_STAT", "addressCO.printAddrFlag",
       			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
       		
       		    
       		
       		
       		
       	    }
       	    
       	    
       	    
       	    }

      //MAUREENA 529712 DB170051 - BRS Mobile Banking Integration R14
	if("1".equals(wallet))
	{
	    
	    if ("L".equals(language)){
		
    	    if("1".equals(cifControlwallet))
    	    {
    		applyDynScreenDisplay("addressCO_MOBILE", "addressCO.MOBILE",
    			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
    	    }
    	    else
    	    {
    		applyDynScreenDisplay("addressCO_MOBILE", "addressCO.MOBILE",
    			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
    	    }
	    applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_STREET_DETAILS_ENG", "addressCO.STREET_DETAILS_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_CITY_ENG", "addressCO.CITY_ENG", ConstantsCommon.ACTION_TYPE_READONLY, "1",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO_WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO_OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_READONLY,
		    "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_READONLY, "1",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO_EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
		    elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_CITY_CODE", "addressCO.CITY_CODE",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_PO_BOX", "addressCO.PO_BOX", ConstantsCommon.ACTION_TYPE_READONLY, "1",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_ADDRESS_DESCRIPTION", "addressCO.ADDRESS_DESCRIPTION",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_EXPIRY_DATE", "addressCO.EXPIRY_DATE",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_FROM_DATE", "addressCO.FROM_DATE", ConstantsCommon.ACTION_TYPE_READONLY,
		    "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_TO_DATE", "addressCO.TO_DATE", ConstantsCommon.ACTION_TYPE_READONLY, "1",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO_PERM_ADDRESS", "addressCO.permnAddrFlag",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_DEFAULT_ADD", "addressCO.defaultAddrFlag",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_PRINT_STAT", "addressCO.printAddrFlag",
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    
	    applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	    
	    applyDynScreenDisplay("addressCO_CITY_ENG", "addressCO.CITY_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY, "0",
		    elementHashmap, null);
	    
	    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	    
	    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	    
	    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_MANDATORY, "0",
		    elementHashmap, null);
	    
	    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	   
	    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
	    
	}
	    else { /*language arabic*/
		
		

		
	    	    if("1".equals(cifControlwallet))
	    	    {
	    		applyDynScreenDisplay("addressCO_MOBILE", "addressCO.MOBILE",
	    			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    	    }
	    	    else
	    	    {
	    		applyDynScreenDisplay("addressCO_MOBILE", "addressCO.MOBILE",
	    			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
	    	    }
		    applyDynScreenDisplay("addressCO_ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_STREET_DETAILS_ARAB", "addressCO.STREET_DETAILS_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_READONLY, "1",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_READONLY,
			    "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_READONLY, "1",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_READONLY, "1",
			    elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_CITY_CODE", "addressCO.CITY_CODE",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_PO_BOX", "addressCO.PO_BOX", ConstantsCommon.ACTION_TYPE_READONLY, "1",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_ADDRESS_DESCRIPTION", "addressCO.ADDRESS_DESCRIPTION",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_EXPIRY_DATE", "addressCO.EXPIRY_DATE",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_FROM_DATE", "addressCO.FROM_DATE", ConstantsCommon.ACTION_TYPE_READONLY,
			    "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_TO_DATE", "addressCO.TO_DATE", ConstantsCommon.ACTION_TYPE_READONLY, "1",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_PERM_ADDRESS", "addressCO.permnAddrFlag",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_DEFAULT_ADD", "addressCO.defaultAddrFlag",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_PRINT_STAT", "addressCO.printAddrFlag",
			    ConstantsCommon.ACTION_TYPE_READONLY, "1", elementHashmap, null);
		    
		    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
		    
		    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
		    
		    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_MANDATORY, "0",
			    elementHashmap, null);
		    
		    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
		   
		    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
			    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", elementHashmap, null);
		    
		
		
	    }
	    
	}
	else
	{ 
	    if ("L".equals(language)){
		
	    
	    applyDynScreenDisplay("addressCO_ADDRESS1_ENG", "addressCO.ADDRESS1_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_ADDRESS2_ENG", "addressCO.ADDRESS2_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_ADDRESS3_ENG", "addressCO.ADDRESS3_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_ADDRESS4_ENG", "addressCO.ADDRESS4_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_STREET_DETAILS_ENG", "addressCO.STREET_DETAILS_ENG",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_CITY_ENG", "addressCO.CITY_ENG", ConstantsCommon.ACTION_TYPE_READONLY, "0",
		    elementHashmap, null);
/*Commented in order to apply customization mandatory
 * 	    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
		    elementHashmap, null);*/
	    applyDynScreenDisplay("addressCO_WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO_OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_READONLY,
		    "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_READONLY, "0",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO_EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
		    elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_CITY_CODE", "addressCO.CITY_CODE",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_PO_BOX", "addressCO.PO_BOX", ConstantsCommon.ACTION_TYPE_READONLY, "0",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("lookuptxt_addressCO_ADDRESS_DESCRIPTION", "addressCO.ADDRESS_DESCRIPTION",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_EXPIRY_DATE", "addressCO.EXPIRY_DATE",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_FROM_DATE", "addressCO.FROM_DATE", ConstantsCommon.ACTION_TYPE_READONLY,
		    "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_TO_DATE", "addressCO.TO_DATE", ConstantsCommon.ACTION_TYPE_READONLY, "0",
		    elementHashmap, null);
	    applyDynScreenDisplay("addressCO_PERM_ADDRESS", "addressCO.permnAddrFlag",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_DEFAULT_ADD", "addressCO.defaultAddrFlag",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	    applyDynScreenDisplay("addressCO_PRINT_STAT", "addressCO.printAddrFlag",
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
	
	    }
	    
	    else { 
		
		

		
		    
		    applyDynScreenDisplay("addressCO_ADDRESS1_ARAB", "addressCO.ADDRESS1_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_ADDRESS2_ARAB", "addressCO.ADDRESS2_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_ADDRESS3_ARAB", "addressCO.ADDRESS3_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_ADDRESS4_ARAB", "addressCO.ADDRESS4_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_STREET_DETAILS_ARAB", "addressCO.STREET_DETAILS_ARAB",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_CITY_ARAB", "addressCO.CITY_ARAB", ConstantsCommon.ACTION_TYPE_READONLY, "0",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_TEL", "addressCO.TEL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_WORK_TEL", "addressCO.WORK_TEL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_OTHER_TEL", "addressCO.OTHER_TEL", ConstantsCommon.ACTION_TYPE_READONLY,
			    "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_FAX", "addressCO.FAX", ConstantsCommon.ACTION_TYPE_READONLY, "0",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_EMAIL", "addressCO.EMAIL", ConstantsCommon.ACTION_TYPE_READONLY, "0",
			    elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_REGION", "addressCO.REGION",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_COUNTRY", "addressCO.COUNTRY",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_CITY_CODE", "addressCO.CITY_CODE",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_SECTOR_CODE", "addressCO.SECTOR_CODE",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_POBOX_AREA", "addressCO.POBOX_AREA",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_PO_BOX", "addressCO.PO_BOX", ConstantsCommon.ACTION_TYPE_READONLY, "0",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO.POSTAL_CODE", "addressCO.POSTAL_CODE",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO.POSTAL_CODE1", "addressCO.POSTAL_CODE1",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("lookuptxt_addressCO_ADDRESS_DESCRIPTION", "addressCO.ADDRESS_DESCRIPTION",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_EXPIRY_DATE", "addressCO.EXPIRY_DATE",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_FROM_DATE", "addressCO.FROM_DATE", ConstantsCommon.ACTION_TYPE_READONLY,
			    "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_TO_DATE", "addressCO.TO_DATE", ConstantsCommon.ACTION_TYPE_READONLY, "0",
			    elementHashmap, null);
		    applyDynScreenDisplay("addressCO_PERM_ADDRESS", "addressCO.permnAddrFlag",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_DEFAULT_ADD", "addressCO.defaultAddrFlag",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		    applyDynScreenDisplay("addressCO_PRINT_STAT", "addressCO.printAddrFlag",
			    ConstantsCommon.ACTION_TYPE_READONLY, "0", elementHashmap, null);
		
		    
		
		
		
	    }
	    
	    
	    
	    }
        /*
         * StringmendatoryAddress=StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().
         * getMENDATORY_ADDRESS());
         * // mendatoryAddress="1";
         * 
         * if (addressCommonCO.getCifVO().getLANGUAGE().equals("L"))
         * {
         * if (mendatoryAddress.equals("1"))
         * 
         * {
         * 
         * // address1EngVO.setIS_VISIBLE(new BigDecimal(1));
         * 
         * }
         * 
         * if (mendatoryAddress.equals("2"))
         * 
         * {
         * 
         * 
         * elementHashmap.put("addressCO.ADDRESS1_ENG",
         * addRequiredElement("addressCO.ADDRESS1_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.ADDRESS2_ENG",
         * addRequiredElement("addressCO.ADDRESS2_ENG",new BigDecimal(1))) ;
         * 
         * 
         * }
         * 
         * if (mendatoryAddress.equals("3"))
         * 
         * {
         * 
         * 
         * elementHashmap.put("addressCO.ADDRESS1_ENG",
         * addRequiredElement("addressCO.ADDRESS1_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.ADDRESS2_ENG",
         * addRequiredElement("addressCO.ADDRESS2_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.ADDRESS3_ENG",
         * addRequiredElement("addressCO.ADDRESS3_ENG",new BigDecimal(1))) ;
         * 
         * 
         * }
         * 
         * if (mendatoryAddress.equals("4"))
         * 
         * {
         * 
         * 
         * elementHashmap.put("addressCO.ADDRESS1_ENG",
         * addRequiredElement("addressCO.ADDRESS1_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.ADDRESS2_ENG",
         * addRequiredElement("addressCO.ADDRESS2_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.ADDRESS3_ENG",
         * addRequiredElement("addressCO.ADDRESS3_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.ADDRESS4_ENG",
         * addRequiredElement("addressCO.ADDRESS4_ENG",new BigDecimal(1))) ;
         * 
         * 
         * }
         * 
         * if (mendatoryAddress.equals("5"))
         * 
         * {
         * 
         * 
         * elementHashmap.put("addressCO.ADDRESS1_ENG",
         * addRequiredElement("addressCO.ADDRESS1_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.ADDRESS2_ENG",
         * addRequiredElement("addressCO.ADDRESS2_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.ADDRESS3_ENG",
         * addRequiredElement("addressCO.ADDRESS3_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.ADDRESS4_ENG",
         * addRequiredElement("addressCO.ADDRESS4_ENG",new BigDecimal(1))) ;
         * elementHashmap.put("addressCO.CITY_ENG", addRequiredElement("addressCO.CITY_ENG",new
         * BigDecimal(1))) ;
         * elementHashmap.put("addressCO.REGION", addRequiredElement("addressCO.REGION",new
         * BigDecimal(1))) ;
         * 
         * }
         * 
         * StringregionIsMandatory=StringUtil.nullEmptyToValue(addressCommonCO.getCifControlVO().
         * getREGION_IS_MANDATORY(), "N");
         * 
         * 
         * if (regionIsMandatory.equals("Y"))
         * {
         * elementHashmap.put("addressCO.REGION", addRequiredElement("addressCO.REGION",new
         * BigDecimal(1))) ;
         * 
         * 
         * }
         * 
         * 
         * if(StringUtil.nullEmptyToValue(addressCommonCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ()
         * , "0").equals(ConstantsCommon.BA_ALGERIA))
         * 
         * {
         * 
         * elementHashmap.put("addressCO.CITY_CODE", addRequiredElement("addressCO.CITY_CODE",new
         * BigDecimal(1))) ;
         * elementHashmap.put("addressCO.SECTOR_CODE",
         * addRequiredElement("addressCO.SECTOR_CODE",new BigDecimal(1))) ;
         * 
         * }
         * 
         * 
         * 
         * 
         * }
         */
	//AKBI200048 - Ranking is not mandatory
	    applyDynScreenDisplay(FomElementsConstant.PRIORITY_CODE_ID,FomElementsConstant.PRIORITY_CODE,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "1", elementHashmap, null);	
	    //AKBI200048 - Ranking is not mandatory
        return elementHashmap;
    }
    
 public AddressCommonCO fillDescriptionInSelectedLang(AddressCommonCO addressCommonCO) throws BaseException
    
    {   
	
	if (!NumberUtil.isEmptyDecimal(addressCommonCO.getREGION())&& !NumberUtil.isEmptyDecimal(addressCommonCO.getCOUNTRY()))
	{
	    CountriesRegionSC countriesRegionSC = new CountriesRegionSC();
		countriesRegionSC.setCompCode(addressCommonCO.getCOMP_CODE());
		String Language = addressCommonCO.getCifVO().getLANGUAGE();
		countriesRegionSC.setPreferredLanguage(Language);
		countriesRegionSC.setCountry_code(addressCommonCO.getCOUNTRY());
		countriesRegionSC.setRegionCode(addressCommonCO.getREGION());

		COUNTRIES_REGIONVO countriesRegionVO = countriesRegionBO.returnCountriesRegionById(countriesRegionSC);
		if (null != countriesRegionVO)
		{
		addressCommonCO.setRegionDesc(countriesRegionVO.getBRIEF_DESC_ENG());
		}

		
	}
	if (!NumberUtil.isEmptyDecimal(addressCommonCO.getCOUNTRY()))
	{
	    CountriesSC countriesSC = new CountriesSC();
	    countriesSC.setCompCode(addressCommonCO.getCOMP_CODE());
	    String Language = addressCommonCO.getCifVO().getLANGUAGE();
	    countriesSC.setPreferredLanguage(Language);
	    countriesSC.setCountryCode(addressCommonCO.getCOUNTRY());
	    countriesSC.setLanguage(addressCommonCO.getLanguage());

	    CountriesCO countriesCO = countriesBO.returnCountryById(countriesSC);
	    if (null != countriesCO)
		{
	          addressCommonCO.setCountryDesc(countriesCO.getCountriesVO().getLONG_DESC_ENG());
		}
	    
	}
	if (!NumberUtil.isEmptyDecimal(addressCommonCO.getCITY_CODE())&& !NumberUtil.isEmptyDecimal(addressCommonCO.getCOUNTRY())&&!NumberUtil.isEmptyDecimal(addressCommonCO.getREGION()))
	{
	    CitiesSC criteria = new CitiesSC();

	    criteria.setCompCode(addressCommonCO.getCOMP_CODE());
	    String Language = addressCommonCO.getCifVO().getLANGUAGE();
	    criteria.setPreferredLanguage(Language);
	    criteria.setCountry_code(addressCommonCO.getCOUNTRY());
	    criteria.setRegion_code(addressCommonCO.getREGION());
	    criteria.setCity_code(addressCommonCO.getCITY_CODE());

	    CITIESVO citiesVO = citiesBO.returnCityById(criteria); 
	    if (null != citiesVO)
		{
	           addressCommonCO.setCityDesc(citiesVO.getBRIEF_DESC_ENG());
		}
	}
	if (!NumberUtil.isEmptyDecimal(addressCommonCO.getSECTOR_CODE())&&!NumberUtil.isEmptyDecimal(addressCommonCO.getCITY_CODE())&& !NumberUtil.isEmptyDecimal(addressCommonCO.getCOUNTRY())&&!NumberUtil.isEmptyDecimal(addressCommonCO.getREGION()))
	{
	    SectorsSC criteria = new SectorsSC();
	    criteria.setCompCode(addressCommonCO.getCOMP_CODE());
	    criteria.setCountry_code(addressCommonCO.getCOUNTRY());
	    criteria.setRegion_code(addressCommonCO.getREGION());
	    criteria.setCity_code(addressCommonCO.getCITY_CODE());
	    criteria.setSector_code(addressCommonCO.getSECTOR_CODE());
	    String Language = addressCommonCO.getCifVO().getLANGUAGE();
	    criteria.setPreferredLanguage(Language);

	    SECTORSVO sectorsVO = sectorsBO.returnSectorById(criteria);
	    if (null != sectorsVO)
		{
	           addressCommonCO.setSectorDesc(sectorsVO.getBRIEF_DESC_ENG());
		}
	}
	if (!NumberUtil.isEmptyDecimal(addressCommonCO.getPOBOX_AREA())&& !NumberUtil.isEmptyDecimal(addressCommonCO.getCOUNTRY()))
	{
	   
		        CountriesRegionSC countriesRegionSC = new CountriesRegionSC();
			countriesRegionSC.setCompCode(addressCommonCO.getCOMP_CODE());
			String Language = addressCommonCO.getCifVO().getLANGUAGE();
			countriesRegionSC.setPreferredLanguage(Language);
			countriesRegionSC.setCountry_code(addressCommonCO.getCOUNTRY());
			countriesRegionSC.setRegionCode(addressCommonCO.getPOBOX_AREA());

			COUNTRIES_REGIONVO countriesRegionVO = countriesRegionBO.returnCountriesRegionById(countriesRegionSC);
			 if (null != countriesRegionVO)
				{
			           addressCommonCO.setPoBoxAreaDesc(countriesRegionVO.getBRIEF_DESC_ENG());
				}
	}
	if (!NumberUtil.isEmptyDecimal(addressCommonCO.getPOSTAL_CODE())&& !NumberUtil.isEmptyDecimal(addressCommonCO.getCOUNTRY())&&!NumberUtil.isEmptyDecimal(addressCommonCO.getREGION()))
	{
	    PostalCodeSC criteria = new PostalCodeSC();
	    criteria.setCompCode(addressCommonCO.getCOMP_CODE());
	    criteria.setCountry_code(addressCommonCO.getCOUNTRY());
	    criteria.setRegion_code(addressCommonCO.getREGION());
	    String Language = addressCommonCO.getCifVO().getLANGUAGE();
	    criteria.setPreferredLanguage(Language);
	    criteria.setPostal_code(addressCommonCO.getPOSTAL_CODE().toString());
	   
	    POSTAL_CODEVO postalCodeVO = postalCodeBO.returnPostalCodeById(criteria);
	    if (null != postalCodeVO)
		{
	          addressCommonCO.setPostalcodeDesc(postalCodeVO.getBRIEF_NAME_ENG());
		}
	}
	if (!NumberUtil.isEmptyDecimal(addressCommonCO.getADDRESS_DESCRIPTION()))
	{
	    ResidenceTypesSC residenceTypesSC = new ResidenceTypesSC();
	    residenceTypesSC.setCompCode(addressCommonCO.getCOMP_CODE());
	    String Language = addressCommonCO.getCifVO().getLANGUAGE();
	    residenceTypesSC.setPreferredLanguage(Language);
	    residenceTypesSC.setCode(addressCommonCO.getADDRESS_DESCRIPTION());
	    
	    
	    RESIDENCE_TYPESVO residenceTypesVO = residenceTypesBO.returnDependencyByCode(residenceTypesSC);
	    if (null != residenceTypesVO)
		{
	          addressCommonCO.setResidenceTypeDesc(residenceTypesVO.getBRIEF_DESC_ENG());
		}
	}
	//added by maria for BMO180181
	if (!NumberUtil.isEmptyDecimal(addressCommonCO.getPROF_ADDRESS_CODE()))
	{

		ProofAddressSC proofAddressSC = new ProofAddressSC();
	    proofAddressSC.setCompCode(addressCommonCO.getCOMP_CODE());
	    proofAddressSC.setCode(addressCommonCO.getPROF_ADDRESS_CODE());
	    CTS_PROOF_ADDRESSVO ctsProofAddressVO = proofAddressBO.returnProofAddressCodeById(proofAddressSC);

	    if (null != ctsProofAddressVO)
		{
	          addressCommonCO.setProofAddressDesc(ctsProofAddressVO.getBRIEF_DESC_ENG());
		}
	}
	
	
	return addressCommonCO;
    }

    /**
     * this function checks the visiblity of the dynamic label defined in cifcontrol screen
     * 
     * @param useAddressDesc: if this flag is checked we have to use the labels defined in
     * cifcontrol/address section
     * @param addressCoulmn :this is the element to be checked: if empty(lenght==0) not visible else
     * visible.
     * @return
     * @throws BaseException
     */
//    public BigDecimal checkAddressVisibility(String useAddressDesc, String addressCoulmn) throws BaseException
//    {
//        BigDecimal retunrvalue = BigDecimal.ONE;
//
//        if("1".equals(useAddressDesc))
//        {
//            retunrvalue = BigDecimal.valueOf((addressCoulmn.length() > 0 ? 1 : 0));
//        }
//        return retunrvalue;
//    }

    /**
     * this function checks wethere the address deais field if ther are required or not
     * 
     * @param addressCommonCO
     * @param addressDetail
     * @return
     * @throws BaseException
     * EWBI160173 -- [John Massaad]
     * The checkAddressVisibility and checkMandatoryAddressDetails are commented due to the modif EWBI160173 because the control management is managed now in initialiseAddressVisibility
     */
//    public BigDecimal checkMandatoryAddressDetails(AddressCommonCO addressCommonCO, String addressDetail)
//            throws BaseException
//    {
//        BigDecimal returnvalue = BigDecimal.ZERO;
//
//        String language = StringUtil.nullEmptyToValue(addressCommonCO.getCifVO().getLANGUAGE(),NCifMaintenanceConstant.LATIN_LANGUAGE);
//
//        String mandatoryAddress = StringUtil.nullToEmpty(addressCommonCO.getCifControlVO().getMENDATORY_ADDRESS());
//
//        if(NCifMaintenanceConstant.LATIN_LANGUAGE.equals(language))
//        {
//            if("addressCO.ADDRESS1_ENG".equals(addressDetail) 
//        	    &&  ("1".equals(mandatoryAddress) || "2".equals(mandatoryAddress) || "3".equals(mandatoryAddress)
//                            || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))
//
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.ADDRESS2_ENG".equals(addressDetail)
//        	    && ("2".equals(mandatoryAddress) || "3".equals(mandatoryAddress) || "4".equals(mandatoryAddress)
//                            || "5".equals(mandatoryAddress)))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.ADDRESS3_ENG".equals(addressDetail)
//        	    && ("3".equals(mandatoryAddress) || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.ADDRESS4_ENG".equals(addressDetail)
//        	    && ("4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.ADDRESS5_ENG".equals(addressDetail) && "5".equals(mandatoryAddress))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.CITY_ENG".equals(addressDetail)
//        	    && ("5".equals(mandatoryAddress)
//                            || (ConstantsCommon.BA_ALGERIA.toString().equals(StringUtil.nullEmptyToValue(
//                        	    addressCommonCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ(),"0")))))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//	}
//        else
//        {
//            /*
//             * Arabic Fields - Reda #331474 15/09/2015
//             */
//            if("addressCO.ADDRESS1_ARAB".equals(addressDetail) 
//        	    &&  ("1".equals(mandatoryAddress) || "2".equals(mandatoryAddress) || "3".equals(mandatoryAddress)
//                            || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.ADDRESS2_ARAB".equals(addressDetail)
//        	    && ("2".equals(mandatoryAddress) || "3".equals(mandatoryAddress) || "4".equals(mandatoryAddress)
//                            || "5".equals(mandatoryAddress)))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.ADDRESS3_ARAB".equals(addressDetail)
//        	    && ("3".equals(mandatoryAddress) || "4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.ADDRESS4_ARAB".equals(addressDetail)
//        	    && ("4".equals(mandatoryAddress) || "5".equals(mandatoryAddress)))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.ADDRESS5_ARAB".equals(addressDetail) && "5".equals(mandatoryAddress))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            if("addressCO.CITY_ARAB".equals(addressDetail)
//        	    && ("5".equals(mandatoryAddress)
//                            || (ConstantsCommon.BA_ALGERIA.toString().equals(StringUtil.nullEmptyToValue(
//                        	    addressCommonCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ(),"0")))))
//            {
//		returnvalue = BigDecimal.ONE;
//            }
//
//            
//        }
//        
//        
//        /*
//         * Common Fields
//         */
//	String regionIsMandatory = StringUtil.nullEmptyToValue(addressCommonCO.getCifControlVO().getREGION_IS_MANDATORY(), "N");
//	/**
//	 * #BUG 336421, comment mandatoryAddress on "addressCO.REGION" because it is not affected
//	 */
//        if("addressCO.REGION".equals(addressDetail) &&
//    	    (/*("2".equals(mandatoryAddress) || "3".equals(mandatoryAddress) || "4".equals(mandatoryAddress) || "5"
//                        .equals(mandatoryAddress))
//                        || */("Y".equals(regionIsMandatory))))
//        {
//	    returnvalue = BigDecimal.ONE;
//        }
//
//        if("addressCO.SECTOR_CODE".equals(addressDetail) &&
//    	    (ConstantsCommon.BA_ALGERIA.toString().equals(
//			StringUtil.nullEmptyToValue(addressCommonCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ(), "0"))))
//        {
//	    returnvalue = BigDecimal.ONE;
//        }
//
//        if("addressCO.POBOX_AREA".equals(addressDetail)
//    	    && (NCifMaintenanceConstant.POBOX_MANDATORY_ON.equals(
//                	StringUtil.nullEmptyToValue(addressCommonCO.getCifControlVO().getPOBOX_MANDATORY(), "0"))))
//        {
//	    returnvalue = BigDecimal.ONE;
//        }
//
//        if("addressCO.POSTAL_CODE".equals(addressDetail)
//    	    && (NCifMaintenanceConstant.POBOX_MANDATORY_ON.equals(
//                	StringUtil.nullEmptyToValue(addressCommonCO.getCifControlVO().getPOSTAL_MANDATORY(), "0"))))
//        {
//	    returnvalue = BigDecimal.ONE;
//        }
//
//        return returnvalue;
//
//    }

 /*   public void addActionToListOfElements(HashMap<String, String> elementNameMap, String actionType,
            Object actionValue, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap) throws BaseException
    {
        SYS_PARAM_SCREEN_DISPLAYVO buisnessElement;
        BigDecimal decimalValue = BigDecimal.ZERO;
        String stringValue = "";

        if(actionValue instanceof BigDecimal)
        {
            decimalValue = (BigDecimal) actionValue;
        }
        if(actionValue instanceof String)
        {
            stringValue = actionValue.toString();
        }

        Iterator it = elementNameMap.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry me = (Map.Entry) it.next();
            String elementName = (String) me.getValue();

            if(elementHashmap.get(elementName) == null)
            {
                buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
                buisnessElement.setELEMENT_NAME(elementName);
            }
	    else
	    {
		buisnessElement = elementHashmap.get(elementName);
	    }
            if("VISIBLE".equals(actionType))
            {
                buisnessElement.setIS_VISIBLE(decimalValue);
            }
            if("REQUIRED".equals(actionType))
            {
                buisnessElement.setIS_MANDATORY(decimalValue);
            }
            if("READ_ONLY".equals(actionType))
            {
                buisnessElement.setIS_READONLY(decimalValue);
            }
            if("LABEL".equals(actionType))
            {
                buisnessElement.setLABEL_KEY(stringValue);
            }
            elementHashmap.put(elementName, buisnessElement);
        }
    }*/

  /*  public void addActionToElement(String elementName, String actionType, Object actionValue,
            HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap) throws BaseException
    {
        HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> LocalElementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
        BigDecimal decimalValue = BigDecimal.ZERO;
        String stringValue = "";
        Date dateValue = null;
        int intValue = 0;
        Long longValue = 0L;
        SYS_PARAM_SCREEN_DISPLAYVO buisnessElement;

        if(actionValue instanceof BigDecimal)
        {
            decimalValue = (BigDecimal) actionValue;
        }
        if(actionValue instanceof String)
        {
            stringValue = actionValue.toString();
        }
        if(actionValue instanceof Date)
        {
            dateValue = (Date) actionValue;
        }
        if(actionValue instanceof Integer)
        {
            intValue = (Integer) actionValue;
        }

        if(actionValue instanceof Long)
        {
            longValue = (Long) actionValue;
        }

        if(elementHashmap.get(elementName) == null)
        {
            buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
            buisnessElement.setELEMENT_NAME(elementName);
        }
	else
	{
	    buisnessElement = elementHashmap.get(elementName);
	}
        if("VISIBLE".equals(actionType))
        {
            buisnessElement.setIS_VISIBLE(decimalValue);
        }
        if("REQUIRED".equals(actionType))
        {
            buisnessElement.setIS_MANDATORY(decimalValue);
        }
        if("READ_ONLY".equals(actionType))
        {
            buisnessElement.setIS_READONLY(decimalValue);
        }
        if("LABEL".equals(actionType))
        {
            buisnessElement.setLABEL_KEY(stringValue);
        }
        if("VALUE".equals(actionType))
        {
            if(actionValue instanceof BigDecimal)
            {
                buisnessElement.setValue(decimalValue);
            }
            if(actionValue instanceof String)
            {
                buisnessElement.setValue(stringValue);
            }
            if(actionValue instanceof Date)
            {
                buisnessElement.setValue(dateValue);
            }
            if(actionValue instanceof Integer)
            {
                buisnessElement.setValue(intValue);
            }
            if(actionValue instanceof Long)
            {
                buisnessElement.setValue(longValue);
            }
        }
        LocalElementHashmap.put(elementName, buisnessElement);
        elementHashmap.putAll(LocalElementHashmap);
    }
*/
    public AddressCommonCO initialiseAddressSreen(AddressCommonCO addressCommonCO) throws BaseException
    {
	ACC_NV_CONTROLVO accountControlVO = new ACC_NV_CONTROLVO();
	accountControlVO.setCOMP_CODE(addressCommonCO.getLoginCompCode());
	accountControlVO.setBRANCH_CODE(addressCommonCO.getLoginBraCode());
	accountControlVO = commonLibBO.returnAccountNvCtrl(accountControlVO);
	
      //  addActionToListOfElements(AccountsElementsConstant.AddressElements(), "VISIBLE", BigDecimal.ZERO,
       //         elementHashmap);
        List<String> values =  new ArrayList<String>(AccountsElementsConstant.AddressElements().values());
	applyDynScreenDisplay(values.toArray(new String[values.size()]), ConstantsCommon.ACTION_TYPE_VISIBLE, "0", addressCommonCO.getBuisnessElement(), null);
        /*addActionToElement(AccountsElementsConstant.ADDRESS1_ENG, "LABEL", "Address_Eng_key", elementHashmap);
        addActionToElement(AccountsElementsConstant.ADDRESS2_ENG, "LABEL", "&nbsp", elementHashmap);
        addActionToElement(AccountsElementsConstant.ADDRESS3_ENG, "LABEL", "&nbsp", elementHashmap);
        addActionToElement(AccountsElementsConstant.ADDRESS4_ENG, "LABEL", "&nbsp", elementHashmap);

        addActionToElement(AccountsElementsConstant.ADDRESS1_ARAB, "LABEL", "Address_Arb_key", elementHashmap);
        addActionToElement(AccountsElementsConstant.ADDRESS2_ARAB, "LABEL", "&nbsp", elementHashmap);
        addActionToElement(AccountsElementsConstant.ADDRESS3_ARAB, "LABEL", "&nbsp", elementHashmap);
        addActionToElement(AccountsElementsConstant.ADDRESS4_ARAB, "LABEL", "&nbsp", elementHashmap);

        addActionToElement(AccountsElementsConstant.POSTAL_CODE, "LABEL", "Postal_Zip_Code_key", elementHashmap);
        */
        applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS1_ENG,  ConstantsCommon.ACTION_TYPE_LABEL, "Address_Eng_key", addressCommonCO.getBuisnessElement(), null);
        applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS2_ENG,  ConstantsCommon.ACTION_TYPE_LABEL, "&nbsp", addressCommonCO.getBuisnessElement(), null);
        applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS3_ENG,  ConstantsCommon.ACTION_TYPE_LABEL, "&nbsp", addressCommonCO.getBuisnessElement(), null);
        applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS4_ENG,  ConstantsCommon.ACTION_TYPE_LABEL, "&nbsp", addressCommonCO.getBuisnessElement(), null);
        applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS1_ARAB, ConstantsCommon.ACTION_TYPE_LABEL, "Address_Arb_key", addressCommonCO.getBuisnessElement(), null);
        applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS2_ARAB, ConstantsCommon.ACTION_TYPE_LABEL, "&nbsp", addressCommonCO.getBuisnessElement(), null);
        applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS3_ARAB, ConstantsCommon.ACTION_TYPE_LABEL, "&nbsp", addressCommonCO.getBuisnessElement(), null);
        applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS4_ARAB, ConstantsCommon.ACTION_TYPE_LABEL, "&nbsp", addressCommonCO.getBuisnessElement(), null);
        applyDynScreenDisplay(null,AccountsElementsConstant.POSTAL_CODE,   ConstantsCommon.ACTION_TYPE_LABEL, "Postal_Zip_Code_key", addressCommonCO.getBuisnessElement(), null);
        applyDynScreenDisplay(null,AccountsElementsConstant.POSTAL_CODE1,   ConstantsCommon.ACTION_TYPE_LABEL, "Postal_Zip_Code_key", addressCommonCO.getBuisnessElement(), null);
        
        if("1".equals(accountControlVO.getACC_ADDRESS_LABEL_FOM()))
        {
          //  addActionToElement(AccountsElementsConstant.ADDRESS1_ENG, "LABEL", "Block_key", elementHashmap);
          //  addActionToElement(AccountsElementsConstant.ADDRESS2_ENG, "LABEL", "Street_key", elementHashmap);
          //  addActionToElement(AccountsElementsConstant.ADDRESS3_ENG, "LABEL", "Jada_key", elementHashmap);
          //  addActionToElement(AccountsElementsConstant.ADDRESS4_ENG, "LABEL", "House_Building_key", elementHashmap);

          //  addActionToElement(AccountsElementsConstant.ADDRESS1_ARAB, "LABEL", "Block_Arb_key", elementHashmap);
          //  addActionToElement(AccountsElementsConstant.ADDRESS2_ARAB, "LABEL", "Street_Arb_key", elementHashmap);
          //  addActionToElement(AccountsElementsConstant.ADDRESS3_ARAB, "LABEL", "Jada_Arb_key", elementHashmap);
          //  addActionToElement(AccountsElementsConstant.ADDRESS4_ARAB, "LABEL", "House_Building_Arb_key",
          //          elementHashmap);
            applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS1_ENG,  ConstantsCommon.ACTION_TYPE_LABEL, "Block_key", addressCommonCO.getBuisnessElement(), null);
            applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS2_ENG,  ConstantsCommon.ACTION_TYPE_LABEL, "Street_key", addressCommonCO.getBuisnessElement(), null);
            applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS3_ENG,  ConstantsCommon.ACTION_TYPE_LABEL, "Jada_key", addressCommonCO.getBuisnessElement(), null);
            applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS4_ENG,  ConstantsCommon.ACTION_TYPE_LABEL, "House_Building_key", addressCommonCO.getBuisnessElement(), null);
            applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS1_ARAB, ConstantsCommon.ACTION_TYPE_LABEL, "Block_Arb_key", addressCommonCO.getBuisnessElement(), null);
            applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS2_ARAB, ConstantsCommon.ACTION_TYPE_LABEL, "Street_Arb_key", addressCommonCO.getBuisnessElement(), null);
            applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS3_ARAB, ConstantsCommon.ACTION_TYPE_LABEL, "Jada_Arb_key", addressCommonCO.getBuisnessElement(), null);
            applyDynScreenDisplay(null,AccountsElementsConstant.ADDRESS4_ARAB, ConstantsCommon.ACTION_TYPE_LABEL, "House_Building_Arb_key", addressCommonCO.getBuisnessElement(), null);
        }
	if(!addressCommonCO.isMoreAddressWindowOpened() && addressCommonCO.isDefaultAddressFromCif())
	{
	    // if the account address is aleardy filled no need to redefault
	    // them from CIF
	    AddressCommonSC criteria = new AddressCommonSC();
	    criteria.setCompCode(addressCommonCO.getLoginCompCode());
	    criteria.setCompCodeCif(NumberUtil.nullEmptyToValue(addressCommonCO.getCompCodeCif(), addressCommonCO.getLoginCompCode()));
	    criteria.setBranchCode(addressCommonCO.getACC_BR());
	    criteria.setCyCode(addressCommonCO.getACC_CY());
	    criteria.setGlCode(addressCommonCO.getACC_GL());
	    criteria.setCifNo(addressCommonCO.getACC_CIF());
	    criteria.setSlNo(addressCommonCO.getACC_SL());
	    criteria.setNbRec(-1);
	    List<AddressCommonCO> addrDetails = addressDAO.returnAddressList(criteria);
	    AMF_ADDRESSVO addressVO;
	    AMF_ADDRESSVO amfAddressVO;
	    for(AddressCommonCO theAddress : addrDetails)
	    {
		addressVO = new AMF_ADDRESSVO();
		PathPropertyUtil.copyProperties(theAddress, addressVO);
		addressVO.setCOMP_CODE(criteria.getCompCode());
		addressVO.setACC_BR(criteria.getBranchCode());
		addressVO.setACC_CY(criteria.getCyCode());
		addressVO.setACC_GL(criteria.getGlCode());
		addressVO.setACC_CIF(criteria.getCifNo());
		addressVO.setACC_SL(criteria.getSlNo());
		addressVO.setLINE_NO(theAddress.getLINE_NO());
		// if records was allready saved at the level of accounts
		// no need to reoveride them from CIF
		amfAddressVO = (AMF_ADDRESSVO) genericDAO.selectByPK(addressVO);
		if(amfAddressVO == null)
		{
		    genericDAO.insert(addressVO);
		}
	    }
	}
        return addressCommonCO;
    }

    public int returnMaxAccountAddressLine(AddressCommonSC criteria) throws BaseException
    {
        return addressDAO.returnMaxAccountAddressLine(criteria);
    }

    public AddressCommonCO returnCifAddress(AddressCommonSC criteria) throws BaseException
    {
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(criteria.getCompCode());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	if(cifControlVO != null)
	{
	    criteria.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	}
        return addressDAO.returnCifAddress(criteria);
    }

    @Override
    public CIF_ADDRESSVO returnCountryTelCIFAddress(AddressCommonSC criteria) throws BaseException
    {
        return addressDAO.returnCountryTelCIFAddress(criteria);
    }

    @Override
    public AddressCommonCO returnAccountFirstAddress(AddressCommonSC criteria) throws BaseException
    {
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(criteria.getCompCode());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	if(cifControlVO != null)
	{
	    criteria.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	}
        return addressDAO.returnAccountFirstAddress(criteria);
    }

    @Override
    public List returnAccountAddressList(AddressCommonSC criteria) throws BaseException
    {
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(criteria.getCompCode());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	if(cifControlVO != null)
	{
	    criteria.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	}
        return addressDAO.returnAccountAddressList(criteria);
    }

    @Override
    public int returnAccountAddressListCount(AddressCommonSC criteria) throws BaseException
    {
        return addressDAO.returnAccountAddressListCount(criteria);
    }

    @Override
    public AddressCommonCO returnAccountAddressDetails(AddressCommonSC criteria) throws BaseException
    {
	AddressCommonCO addressCommonCO = new AddressCommonCO();
	if(!NumberUtil.isEmptyDecimal(criteria.getBranchCode()) && !NumberUtil.isEmptyDecimal(criteria.getCifNo())
		&& !NumberUtil.isEmptyDecimal(criteria.getCyCode()) && !NumberUtil.isEmptyDecimal(criteria.getGlCode())
		&& !NumberUtil.isEmptyDecimal(criteria.getSlNo()) && !NumberUtil.isEmptyDecimal(criteria.getLineNo()))
        {
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(criteria.getCompCode());
	    cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	    if(cifControlVO != null)
	    {
		criteria.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	    }
	    
	    addressCommonCO = addressDAO.returnAccountAddressDetails(criteria);
	    if(addressCommonCO == null)
	    {
		addressCommonCO = new AddressCommonCO();
	    }
        }
	addressCommonCO.setPermnAddrFlag("Y".equalsIgnoreCase(addressCommonCO.getPERM_ADDRESS()) ? true : false);
	addressCommonCO.setDefaultAddrFlag("1".equalsIgnoreCase(addressCommonCO.getDEFAULT_ADD()) ? true : false);
	addressCommonCO.setPrintAddrFlag("1".equalsIgnoreCase(String.valueOf(addressCommonCO.getPRINT_STAT())) ? true : false);
	
	List<String> values = new ArrayList<String>(AccountsElementsConstant.AddressElements().values());
	applyDynScreenDisplay(values.toArray(new String[values.size()]), ConstantsCommon.ACTION_TYPE_VISIBLE, "0",
		addressCommonCO.getBuisnessElement(), null);

	// parameters needed in order to default the address from CIF in the method initialiseAddressSreen
	addressCommonCO.setLoginCompCode(criteria.getCompCode());
	addressCommonCO.setLoginBraCode(criteria.getBranchCode());

	addressCommonCO.setACC_BR(criteria.getBranchCode());
	addressCommonCO.setACC_CY(criteria.getCyCode());
	addressCommonCO.setACC_GL(criteria.getGlCode());
	addressCommonCO.setACC_CIF(criteria.getCifNo());
	addressCommonCO.setACC_SL(criteria.getSlNo());
	addressCommonCO.setACC_CIF(criteria.getCifNo());
	addressCommonCO.setMoreAddressWindowOpened(criteria.isMoreAddressWindowOpened());
	addressCommonCO.setDefaultAddressFromCif(criteria.isDefaultAddressFromCif());
	initialiseAddressSreen(addressCommonCO);
	
        return addressCommonCO;
    }

    /**
     * Return all the CIF Addresses Count
     * 
     * @author: BassamEid
     * @date: Dec 6, 2013
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public int returnAllAddressListCount(AddressCommonSC criteria) throws BaseException
    {
        return addressDAO.returnAllAddressListCount(criteria);
    }

    /**
     * Return all the CIF Addresses
     * 
     * @author: BassamEid
     * @date: Dec 6, 2013
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List returnAllAddressList(AddressCommonSC criteria) throws BaseException
    {
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(criteria.getCompCode());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	if(cifControlVO != null)
	{
	    criteria.setPostalCodeType(cifControlVO.getPOSTAL_CODE_TYPE());
	}
	
        return addressDAO.returnAllAddressList(criteria);
    }

    public void checkAddressDefaultAddrFlag(AddressCommonCO addressCommonCO) throws BaseException
    {
	AddressCommonSC addressCommonSC = new AddressCommonSC();
	addressCommonSC.setScreenSrc(addressCommonCO.getScreenName());
	addressCommonSC.setCompCode(addressCommonCO.getLoginCompCode());
	if("ACCOUNT".equals(addressCommonCO.getScreenName()))
	{
	    addressCommonSC.setBranchCode(addressCommonCO.getACC_BR());
	    addressCommonSC.setCyCode(addressCommonCO.getACC_CY());
	    addressCommonSC.setGlCode(addressCommonCO.getACC_GL());
	    addressCommonSC.setCifNo(addressCommonCO.getACC_CIF());
	    addressCommonSC.setSlNo(addressCommonCO.getACC_SL());
	}
	else if ("FOM".equals(addressCommonCO.getScreenName())||"KYCManagment".equals(addressCommonCO.getScreenName())) // added by nour for 925559
	{
	    addressCommonSC.setCifNo(addressCommonCO.getCIF_NO());
	}
	int result = addressDAO.checkAddressDefaultAddrFlag(addressCommonSC);
	if(result > 1)
	{
	    throw new BOException(MessageCodes.DEFAULT_ADDRESS_IS_ALREADY_SET);
	}
    }
    
    
    public AddressCommonCO returnCifFirstAddress(AddressCommonSC criteria) throws BaseException
    {
	return addressDAO.returnCifFirstAddress(criteria);
    }
    
    public AddressCommonDAO getAddressDAO()
    {
        return addressDAO;
    }

    public void setAddressDAO(AddressCommonDAO addressDAO)
    {
        this.addressDAO = addressDAO;
    }

    public CoreCommonServiceBO getCoreCommonServiceBO()
    {
        return coreCommonServiceBO;
    }

    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }

    @Override
    public int checkNegativeComp(AddressCommonSC addressCommonSC) throws BaseException
    {
	CifSC criteria = new CifSC();
	criteria.setCompCode(addressCommonSC.getCompCode());
	criteria.setCif_no(addressCommonSC.getCifNo());
	criteria.setSectionKey(addressCommonSC.getSectionKey());
	criteria.setCurrAppName(addressCommonSC.getCurrAppName());
	return coreCommonServiceBO.checkNegativeComp(criteria);
    }

    public CountriesRegionBO getCountriesRegionBO()
    {
        return countriesRegionBO;
    }

    public void setCountriesRegionBO(CountriesRegionBO countriesRegionBO)
    {
        this.countriesRegionBO = countriesRegionBO;
    }

    public CountriesBO getCountriesBO()
    {
        return countriesBO;
    }

    public void setCountriesBO(CountriesBO countriesBO)
    {
        this.countriesBO = countriesBO;
    }

    public CitiesBO getCitiesBO()
    {
        return citiesBO;
    }

    public void setCitiesBO(CitiesBO citiesBO)
    {
        this.citiesBO = citiesBO;
    }

    public SectorsBO getSectorsBO()
    {
        return sectorsBO;
    }

    public void setSectorsBO(SectorsBO sectorsBO)
    {
        this.sectorsBO = sectorsBO;
    }

    public PostalCodeBO getPostalCodeBO()
    {
        return postalCodeBO;
    }

    public void setPostalCodeBO(PostalCodeBO postalCodeBO)
    {
        this.postalCodeBO = postalCodeBO;
    }

    public ResidenceTypesBO getResidenceTypesBO()
    {
        return residenceTypesBO;
    }

    public void setResidenceTypesBO(ResidenceTypesBO residenceTypesBO)
    {
        this.residenceTypesBO = residenceTypesBO;
    }

    public List returnWalletAddress(AddressCommonSC criteria) throws BaseException
    {
	return addressDAO.returnWalletAddress(criteria);
    }
	public ProofAddressBO getProofAddressBO() {
		return proofAddressBO;
	}

	public void setProofAddressBO(ProofAddressBO proofAddressBO) {
		this.proofAddressBO = proofAddressBO;
	}


}
