(function($) {
	moreAddress_onDocReady = function(_addressPageRef) 
	{
		var screen = $("#moreAddress_SCREEN_NAME_" + _addressPageRef).val();
		//if(screen=='FOM')// Libin commented checking as this call is also done from Cards for same req
		if(screen!='ACCOUNT')// If call from any other screen other than account
		{
			if($("#fOMMoreAddress_save_btn_" + _pageRef).length > 0)
			{
				if($("#fOMMoreAddress_save_btn_" + _pageRef).is(":hidden"))
				{
					$("#fOMMoreAddress_save_btn_" + _pageRef).show();
				}
				if($("#moreAddress_screenMode_" + _addressPageRef).val()=='true')
				{
					$("#fOMMoreAddress_save_btn_" + _pageRef).hide();
				}
			}
			
			$("#lbl_addressCO_ADDRESS_DESC_" + _addressPageRef).hide();
			$("#addressCO_ADDRESS_DESC_" + _addressPageRef).hide();
			$("#lbl_addressCO_CONTACT_NAME_" + _addressPageRef).hide();
			$("#addressCO_CONTACT_NAME_" + _addressPageRef).hide();
			$("#lbl_addressCO_CONTACT_NAME_ARAB_" + _addressPageRef).hide();
			$("#addressCO_CONTACT_NAME_ARAB_" + _addressPageRef).hide();
			$("#lbl_addressCO_SALUTATION_ENG_" + _addressPageRef).hide();
			$("#addressCO_SALUTATION_ENG_" + _addressPageRef).hide();
			$("#lbl_addressCO_SALUTATION_ARAB_" + _addressPageRef).hide();
			$("#addressCO_SALUTATION_ARAB_" + _addressPageRef).hide();
			$("#lbl_addressCO_GOVERNERATE_ENG_" + _addressPageRef).hide();
			$("#addressCO_GOVERNERATE_ENG_" + _addressPageRef).hide();
			$("#lbl_addressCO_GOVERNERATE_ARAB_" + _addressPageRef).hide();
			$("#addressCO_GOVERNERATE_ARAB_" + _addressPageRef).hide();
			$("#lbl_addressCO_STREET_DETAILS_ENG_" + _addressPageRef).hide();
			$("#addressCO_STREET_DETAILS_ENG_" + _addressPageRef).hide();
			$("#lbl_addressCO_STREET_DETAILS_ARAB_" + _addressPageRef).hide();
			$("#addressCO_STREET_DETAILS_ARAB_" + _addressPageRef).hide();
			//$("#addressCO_POSTAL_CODE1_" + _addressPageRef).hide();
			//$("#lbl_addressCO_POSTAL_CODE1_" + _addressPageRef).hide();
		}
		else if(screen=='ACCOUNT')// If call from Account screen
		{
			if($("#accountMoreAddress_save_btn_" + _pageRef).length > 0)
			{
				if($("#accountMoreAddress_save_btn_" + _pageRef).is(":hidden"))
				{
					$("#accountMoreAddress_save_btn_" + _pageRef).show();
				}
				if($("#moreAddress_screenMode_" + _addressPageRef).val()=='true')
				{
					$("#accountMoreAddress_save_btn_" + _pageRef).hide();
				}
			}
		}
		var cifLang;
		if($("#cifVO_LANGUAGE_" + _pageRef).length > 0)
			cifLang = $('#cifVO_LANGUAGE_' + _pageRef).val();// data only in FOM screen
		else cifLang='';
		
		var screenLang = $('#screenLang_' + _addressPageRef).val();
		//var screenType = _addressPageRef.substring(_addressPageRef.length - 1, _addressPageRef.length);
		//cifLang = "A";
		
	if(screenLang=="EN")
		if (cifLang == "A") 
		{
			if(screen!='ACCOUNT')// FOM or Safebox or any other screen - Account screen have part to show in both orientation
			{
				$("#addressSectionTbl_Id_ENG_" + _addressPageRef).hide();
				$("#addressSectionTbl_Id_ARAB_" +_addressPageRef).show();
				$('#moreAddressListDetailDiv_id_' + _addressPageRef).attr('dir','rtl'); // For Address section in FOM
				changeLookupOrientationForArbInEngModeAndEngInArbMode_Address(_addressPageRef);// change orientation
				changeAddressSectionLanguage_AddressPopup('ar',_addressPageRef);// Change label to preferred Locale
			}
		} 
		else  // (screenLang=="EN") & (cifLang == "E") 
		{
			if(screen!='ACCOUNT')// FOM or Safebox or any other screen - Account screen have part to show in both orientation
			{
				$("#addressSectionTbl_Id_ENG_" + _addressPageRef).show();
				$("#addressSectionTbl_Id_ARAB_" + _addressPageRef).hide();
				$('#moreAddressListDetailDiv_id_' + _addressPageRef).attr('dir','ltr'); // For Address section in FOM
				changeLookupOrientationForEngInEngModeAndArbInArbMode_Address(_addressPageRef);// change orientation
				changeAddressSectionLanguage_AddressPopup('en_US',_addressPageRef);// Change label to preferred Locale
			}
		}
	else if (screenLang=="AR")
		if (cifLang == "A") 
		{
			if(screen!='ACCOUNT')// FOM or Safebox or any other screen - Account screen have part to show in both orientation
			{
				$("#addressSectionTbl_Id_ENG_" + _addressPageRef).hide();
				$("#addressSectionTbl_Id_ARAB_" + _addressPageRef).show();
				$('#moreAddressListDetailDiv_id_' + _addressPageRef).attr('dir','rtl'); // For Address section in FOM
				changeLookupOrientationForEngInEngModeAndArbInArbMode_Address(_addressPageRef);// change orientation
				changeAddressSectionLanguage_AddressPopup('ar',_addressPageRef);// Change label to preferred Locale
			}
		}
		else // (screenLang=="AR") & (cifLang == "E") 
		{
			if(screen!='ACCOUNT')// FOM or Safebox or any other screen - Account screen have part to show in both orientation
			{
				$("#addressSectionTbl_Id_ENG_" + _addressPageRef).show();
				$("#addressSectionTbl_Id_ARAB_" + _addressPageRef).hide();
				$('#moreAddressListDetailDiv_id_' + _addressPageRef).attr('dir','ltr'); // For Address section in FOM
				changeLookupOrientationForArbInEngModeAndEngInArbMode_Address(_addressPageRef);// Change orientation
				changeAddressSectionLanguage_AddressPopup('en_US',_addressPageRef);// Change label to preferred Locale
			}
		}
	else if (screenLang=="FR")
		if (cifLang == "A") 
		{
			if(screen!='ACCOUNT')// FOM or Safebox or any other screen - Account screen have part to show in both orientation
			{
				$("#addressSectionTbl_Id_ENG_" + _addressPageRef).hide();
				$("#addressSectionTbl_Id_ARAB_" + _addressPageRef).show();
				$('#moreAddressListDetailDiv_id_' + _addressPageRef).attr('dir','rtl'); // For Address section in FOM
				changeLookupOrientationForArbInEngModeAndEngInArbMode_Address(_addressPageRef);// Change orientation
				//changeAddressSectionLanguage_AddressPopup('ar',_addressPageRef);// Change label to preferred Locale
			}
		}
		else // (screenLang=="FR") & (cifLang == "E") 
		{
			if(screen!='ACCOUNT')// FOM or Safebox or any other screen - Account screen have part to show in both orientation
			{
				$("#addressSectionTbl_Id_ENG_" + _addressPageRef).show();
				$("#addressSectionTbl_Id_ARAB_" + _addressPageRef).hide();
				$('#moreAddressListDetailDiv_id_' + _addressPageRef).attr('dir','ltr'); // For Address section in FOM
				changeLookupOrientationForEngInEngModeAndArbInArbMode_Address(_addressPageRef);// change orientation
				//changeAddressSectionLanguage_AddressPopup('en_US',_addressPageRef);// Change label to preferred Locale
			}
		}
		
	};
})(jQuery);

var addressPopupLabelArray_ENG = [];
var addressPopupLabelArray_ARAB = [];
// Change Address Section Lookup Orientation - called from inside of "fomNameAddressLanguageDropDown_onChange" method
// for Arabic layout In English Mode and English layout In Arabic Mode
function changeLookupOrientationForArbInEngModeAndEngInArbMode_Address(_screenRef)
{
	// Country
	$('#spanLookup_addressCO_COUNTRY_' +_screenRef).removeClass('liveSearchSpanCorner').addClass('liveSearchSpanCornerforRTL');
	$('#lookuptxt_addressCO_COUNTRY_' +_screenRef).removeClass('liveSearchInputCorner').addClass('liveSearchInputCornerforRTL');
	
	// Region
	$('#spanLookup_addressCO_REGION_' +_screenRef).removeClass('liveSearchSpanCorner').addClass('liveSearchSpanCornerforRTL');
	$('#lookuptxt_addressCO_REGION_' +_screenRef).removeClass('liveSearchInputCorner').addClass('liveSearchInputCornerforRTL');
	
	// City Code
	$('#spanLookup_addressCO_CITY_CODE_' +_screenRef).removeClass('liveSearchSpanCorner').addClass('liveSearchSpanCornerforRTL');
	$('#lookuptxt_addressCO_CITY_CODE_' +_screenRef).removeClass('liveSearchInputCorner').addClass('liveSearchInputCornerforRTL');
	
	// Sector Code
	$('#spanLookup_addressCO_SECTOR_CODE_' +_screenRef).removeClass('liveSearchSpanCorner').addClass('liveSearchSpanCornerforRTL');
	$('#lookuptxt_addressCO_SECTOR_CODE_' +_screenRef).removeClass('liveSearchInputCorner').addClass('liveSearchInputCornerforRTL');
	
	// PO Box Area
	$('#spanLookup_addressCO_POBOX_AREA_' +_screenRef).removeClass('liveSearchSpanCorner').addClass('liveSearchSpanCornerforRTL');
	$('#lookuptxt_addressCO_POBOX_AREA_' +_screenRef).removeClass('liveSearchInputCorner').addClass('liveSearchInputCornerforRTL');
	
	// Postal Code
	$('#spanLookup_addressCO_POSTAL_CODE_' +_screenRef).removeClass('liveSearchSpanCorner').addClass('liveSearchSpanCornerforRTL');
	$('#lookuptxt_addressCO_POSTAL_CODE_' +_screenRef).removeClass('liveSearchInputCorner').addClass('liveSearchInputCornerforRTL');
	
	// Address Desc
	$('#spanLookup_addressCO_ADDRESS_DESCRIPTION_' +_screenRef).removeClass('liveSearchSpanCorner').addClass('liveSearchSpanCornerforRTL');
	$('#lookuptxt_addressCO_ADDRESS_DESCRIPTION_' +_screenRef).removeClass('liveSearchInputCorner').addClass('liveSearchInputCornerforRTL');
}

// Change Address Section Lookup Orientation - called from inside of "fomNameAddressLanguageDropDown_onChange" method
// for English layout in English mode and Arabic Layout in Arabic Mode
function changeLookupOrientationForEngInEngModeAndArbInArbMode_Address(_screenRef)
{
	// Country
	$('#spanLookup_addressCO_COUNTRY_' +_screenRef).removeClass('liveSearchSpanCornerforRTL').addClass('liveSearchSpanCorner');
	$('#lookuptxt_addressCO_COUNTRY_' +_screenRef).removeClass('liveSearchInputCornerforRTL').addClass('liveSearchInputCorner');
	
	// Region
	$('#spanLookup_addressCO_REGION_' +_screenRef).removeClass('liveSearchSpanCornerforRTL').addClass('liveSearchSpanCorner');
	$('#lookuptxt_addressCO_REGION_' +_screenRef).removeClass('liveSearchInputCornerforRTL').addClass('liveSearchInputCorner');
	
	// City Code
	$('#spanLookup_addressCO_CITY_CODE_' +_screenRef).removeClass('liveSearchSpanCornerforRTL').addClass('liveSearchSpanCorner');
	$('#lookuptxt_addressCO_CITY_CODE_' +_screenRef).removeClass('liveSearchInputCornerforRTL').addClass('liveSearchInputCorner');
	
	// Sector Code
	$('#spanLookup_addressCO_SECTOR_CODE_' +_screenRef).removeClass('liveSearchSpanCornerforRTL').addClass('liveSearchSpanCorner');
	$('#lookuptxt_addressCO_SECTOR_CODE_' +_screenRef).removeClass('liveSearchInputCornerforRTL').addClass('liveSearchInputCorner');
	
	// PO Box Area
	$('#spanLookup_addressCO_POBOX_AREA_' +_screenRef).removeClass('liveSearchSpanCornerforRTL').addClass('liveSearchSpanCorner');
	$('#lookuptxt_addressCO_POBOX_AREA_' +_screenRef).removeClass('liveSearchInputCornerforRTL').addClass('liveSearchInputCorner');
	
	// Postal Code
	$('#spanLookup_addressCO_POSTAL_CODE_' +_screenRef).removeClass('liveSearchSpanCornerforRTL').addClass('liveSearchSpanCorner');
	$('#lookuptxt_addressCO_POSTAL_CODE_' +_screenRef).removeClass('liveSearchInputCornerforRTL').addClass('liveSearchInputCorner');
	
	// Address Desc
	$('#spanLookup_addressCO_ADDRESS_DESCRIPTION_' +_screenRef).removeClass('liveSearchSpanCornerforRTL').addClass('liveSearchSpanCorner');
	$('#lookuptxt_addressCO_ADDRESS_DESCRIPTION_' +_screenRef).removeClass('liveSearchInputCornerforRTL').addClass('liveSearchInputCorner');
}


// Change Address Section Language - called from inside of "moreAddress_onDocReady" method
function changeAddressSectionLanguage_AddressPopup(_prefLocale,_screenRef)
{
	var src = jQuery.contextPath + "/path/moreAddress/moreAddressMaint_fetchAddressLabel.action?neededLocale="+_prefLocale;
	if(_prefLocale=="en_US")
	{
		if(addressPopupLabelArray_ENG[0] == "filled")
		{
			fillAddressSectionLabel_AddressPopup(addressPopupLabelArray_ENG,_screenRef);
			return;
		}
	}
	else
	{
		if(addressPopupLabelArray_ARAB[0] == 'filled')
		{
			fillAddressSectionLabel_AddressPopup(addressPopupLabelArray_ARAB,_screenRef);
			return;
		}
	}
	$.ajax( {
		url : src,
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data["_error"] == null) 
			{
				if(_prefLocale=="en_US")
				{
//					addressPopupLabelArray_ENG[0] = 'filled';
//					addressPopupLabelArray_ENG["lbl_addressCO_REGION_"] = data.addressLabel.area;
//					addressPopupLabelArray_ENG["lbl_addressCO_ADDRESS1_ENG_"] = data.addressLabel.block;
//					addressPopupLabelArray_ENG["lbl_addressCO_ADDRESS2_ENG_"] = data.addressLabel.street;
//					addressPopupLabelArray_ENG["lbl_addressCO_ADDRESS3_ENG_"] = data.addressLabel.jada;
//					addressPopupLabelArray_ENG["lbl_addressCO_ADDRESS4_ENG_"] = data.addressLabel.houseBuilding;
//					addressPopupLabelArray_ENG["lbl_addressCO_CITY_ENG_"] = data.addressLabel.city;
//					
//					addressPopupLabelArray_ENG["lbl_addressCO_ADDRESS1_ARAB_"] = data.addressLabel.block_arb;
//					addressPopupLabelArray_ENG["lbl_addressCO_ADDRESS2_ARAB_"] = data.addressLabel.street_arb;
//					addressPopupLabelArray_ENG["lbl_addressCO_ADDRESS3_ARAB_"] = data.addressLabel.jada_arb;
//					addressPopupLabelArray_ENG["lbl_addressCO_ADDRESS4_ARAB_"] = data.addressLabel.houseBuilding_arb;
//					addressPopupLabelArray_ENG["lbl_addressCO_CITY_ARAB_"] = data.addressLabel.city_arb;
//					
//					addressPopupLabelArray_ENG["lbl_addressCO_COUNTRY_"] = data.addressLabel.country;
//					addressPopupLabelArray_ENG["lbl_addressCO_CITY_CODE_"] = data.addressLabel.cityCode;
//					addressPopupLabelArray_ENG["lbl_addressCO_SECTOR_CODE_"] = data.addressLabel.sector;
//					addressPopupLabelArray_ENG["lbl_addressCO_POBOX_AREA_"] = data.addressLabel.poBox;
//					addressPopupLabelArray_ENG["lbl_addressCO_ADDRESS_DESCRIPTION_"] = data.addressLabel.addressDesc;
//					addressPopupLabelArray_ENG["lbl_addressCO_FROM_DATE_"] = data.addressLabel.fromDate;
//					addressPopupLabelArray_ENG["lbl_addressCO_TO_DATE_"] = data.addressLabel.toDate;
//					addressPopupLabelArray_ENG["lbl_addressCO_EXPIRY_DATE_"] = data.addressLabel.expiryDate;
//					addressPopupLabelArray_ENG["lbl_addressCO_PERM_ADDRESS_"] = data.addressLabel.permanentAddress;
//					addressPopupLabelArray_ENG["lbl_addressCO_DEFAULT_ADD_"] = data.addressLabel.defaultAddress;
//					addressPopupLabelArray_ENG["lbl_addressCO_TEL_"] = data.addressLabel.homeTel;
//					addressPopupLabelArray_ENG["lbl_addressCO_WORK_TEL_"] = data.addressLabel.workTel;
//					addressPopupLabelArray_ENG["lbl_addressCO_MOBILE_"] = data.addressLabel.mobile;
//					addressPopupLabelArray_ENG["lbl_addressCO_OTHER_TEL_"] = data.addressLabel.otherTel;
//					addressPopupLabelArray_ENG["lbl_addressCO_FAX_"] = data.addressLabel.fax;
//					addressPopupLabelArray_ENG["lbl_addressCO_EMAIL_"] = data.addressLabel.email;
//					addressPopupLabelArray_ENG["lbl_addressCO_PRINT_STAT_"] = data.addressLabel.printStatement;
//					addressPopupLabelArray_ENG["lbl_btn_MoreAddress_"] = data.addressLabel.moreAddress;
					
					fillLabelToArray_Address(addressPopupLabelArray_ENG,data);
					
					fillAddressSectionLabel_AddressPopup(addressPopupLabelArray_ENG,_screenRef);// set the list to global Array
				}
				else if(_prefLocale=="ar")
				{
//					addressPopupLabelArray_ARAB[0] = 'filled';
//					addressPopupLabelArray_ARAB["lbl_addressCO_REGION_"] = data.addressLabel.area;
//					addressPopupLabelArray_ARAB["lbl_addressCO_ADDRESS1_ENG_"] = data.addressLabel.block;
//					addressPopupLabelArray_ARAB["lbl_addressCO_ADDRESS2_ENG_"] = data.addressLabel.street;
//					addressPopupLabelArray_ARAB["lbl_addressCO_ADDRESS3_ENG_"] = data.addressLabel.jada;
//					addressPopupLabelArray_ARAB["lbl_addressCO_ADDRESS4_ENG_"] = data.addressLabel.houseBuilding;
//					addressPopupLabelArray_ARAB["lbl_addressCO_CITY_ENG_"] = data.addressLabel.city;
//					
//					addressPopupLabelArray_ARAB["lbl_addressCO_ADDRESS1_ARAB_"] = data.addressLabel.block_arb;
//					addressPopupLabelArray_ARAB["lbl_addressCO_ADDRESS2_ARAB_"] = data.addressLabel.street_arb;
//					addressPopupLabelArray_ARAB["lbl_addressCO_ADDRESS3_ARAB_"] = data.addressLabel.jada_arb;
//					addressPopupLabelArray_ARAB["lbl_addressCO_ADDRESS4_ARAB_"] = data.addressLabel.houseBuilding_arb;
//					addressPopupLabelArray_ARAB["lbl_addressCO_CITY_ARAB_"] = data.addressLabel.city_arb;
//					
//					addressPopupLabelArray_ARAB["lbl_addressCO_COUNTRY_"] = data.addressLabel.country;
//					addressPopupLabelArray_ARAB["lbl_addressCO_CITY_CODE_"] = data.addressLabel.cityCode;
//					addressPopupLabelArray_ARAB["lbl_addressCO_SECTOR_CODE_"] = data.addressLabel.sector;
//					addressPopupLabelArray_ARAB["lbl_addressCO_POBOX_AREA_"] = data.addressLabel.poBox;
//					addressPopupLabelArray_ARAB["lbl_addressCO_ADDRESS_DESCRIPTION_"] = data.addressLabel.addressDesc;
//					addressPopupLabelArray_ARAB["lbl_addressCO_FROM_DATE_"] = data.addressLabel.fromDate;
//					addressPopupLabelArray_ARAB["lbl_addressCO_TO_DATE_"] = data.addressLabel.toDate;
//					addressPopupLabelArray_ARAB["lbl_addressCO_EXPIRY_DATE_"] = data.addressLabel.expiryDate;
//					addressPopupLabelArray_ARAB["lbl_addressCO_PERM_ADDRESS_"] = data.addressLabel.permanentAddress;
//					addressPopupLabelArray_ARAB["lbl_addressCO_DEFAULT_ADD_"] = data.addressLabel.defaultAddress;
//					addressPopupLabelArray_ARAB["lbl_addressCO_TEL_"] = data.addressLabel.homeTel;
//					addressPopupLabelArray_ARAB["lbl_addressCO_WORK_TEL_"] = data.addressLabel.workTel;
//					addressPopupLabelArray_ARAB["lbl_addressCO_MOBILE_"] = data.addressLabel.mobile;
//					addressPopupLabelArray_ARAB["lbl_addressCO_OTHER_TEL_"] = data.addressLabel.otherTel;
//					addressPopupLabelArray_ARAB["lbl_addressCO_FAX_"] = data.addressLabel.fax;
//					addressPopupLabelArray_ARAB["lbl_addressCO_EMAIL_"] = data.addressLabel.email;
//					addressPopupLabelArray_ARAB["lbl_addressCO_PRINT_STAT_"] = data.addressLabel.printStatement;
//					addressPopupLabelArray_ARAB["lbl_btn_MoreAddress_"] = data.addressLabel.moreAddress;
					
					fillLabelToArray_Address(addressPopupLabelArray_ARAB,data);
					
					fillAddressSectionLabel_AddressPopup(addressPopupLabelArray_ARAB,_screenRef);// set the list to global Array
				}
			}
		}
	});
}

function fillLabelToArray_Address(labelArray,data)
{
	labelArray[0] = 'filled';
	labelArray["lbl_addressCO_REGION_"] = data.addressLabel.area;
	labelArray["lbl_addressCO_ADDRESS1_ENG_"] = data.addressLabel.block;
	labelArray["lbl_addressCO_ADDRESS2_ENG_"] = data.addressLabel.street;
	labelArray["lbl_addressCO_ADDRESS3_ENG_"] = data.addressLabel.jada;
	labelArray["lbl_addressCO_ADDRESS4_ENG_"] = data.addressLabel.houseBuilding;
	labelArray["lbl_addressCO_CITY_ENG_"] = data.addressLabel.city;
//	labelArray["lbl_addressCO_STREET_DETAILS_ENG_"] = data.addressLabel.street;
	
	labelArray["lbl_addressCO_ADDRESS1_ARAB_"] = data.addressLabel.block_arb;
	labelArray["lbl_addressCO_ADDRESS2_ARAB_"] = data.addressLabel.street_arb;
	labelArray["lbl_addressCO_ADDRESS3_ARAB_"] = data.addressLabel.jada_arb;
	labelArray["lbl_addressCO_ADDRESS4_ARAB_"] = data.addressLabel.houseBuilding_arb;
	labelArray["lbl_addressCO_CITY_ARAB_"] = data.addressLabel.city_arb;
//	labelArray["lbl_addressCO_STREET_DETAILS_ARAB_"] = data.addressLabel.street_arb;
	
	labelArray["lbl_addressCO_COUNTRY_"] = data.addressLabel.country;
	labelArray["lbl_addressCO_CITY_CODE_"] = data.addressLabel.cityCode;
	labelArray["lbl_addressCO_SECTOR_CODE_"] = data.addressLabel.sector;
	labelArray["lbl_addressCO_POBOX_AREA_"] = data.addressLabel.poBox;
	labelArray["lbl_addressCO_POSTAL_CODE_"] = data.addressLabel.postalCode;
	labelArray["lbl_addressCO_ADDRESS_DESCRIPTION_"] = data.addressLabel.addressDesc;
	labelArray["lbl_addressCO_FROM_DATE_"] = data.addressLabel.fromDate;
	labelArray["lbl_addressCO_TO_DATE_"] = data.addressLabel.toDate;
	labelArray["lbl_addressCO_EXPIRY_DATE_"] = data.addressLabel.expiryDate;
	labelArray["lbl_addressCO_PERM_ADDRESS_"] = data.addressLabel.permanentAddress;
	labelArray["lbl_addressCO_DEFAULT_ADD_"] = data.addressLabel.defaultAddress;
	labelArray["lbl_addressCO_TEL_"] = data.addressLabel.homeTel;
	labelArray["lbl_addressCO_WORK_TEL_"] = data.addressLabel.workTel;
	labelArray["lbl_addressCO_MOBILE_"] = data.addressLabel.mobile;
	labelArray["lbl_addressCO_OTHER_TEL_"] = data.addressLabel.otherTel;
	labelArray["lbl_addressCO_FAX_"] = data.addressLabel.fax;
	labelArray["lbl_addressCO_PO_BOX_"] = data.addressLabel.poBoxStatic;
	labelArray["lbl_addressCO_EMAIL_"] = data.addressLabel.email;
	labelArray["lbl_addressCO_PRINT_STAT_"] = data.addressLabel.printStatement;
	labelArray["lbl_btn_MoreAddress_"] = data.addressLabel.moreAddress;
}

// Method to change Address Section label when an array of label is passed as param
function fillAddressSectionLabel_AddressPopup(labelArray,_screenRef)
{
	moreAddress_labelKey('#lbl_addressCO_REGION_' +_screenRef, labelArray.lbl_addressCO_REGION_);
	moreAddress_labelKey('#lbl_addressCO_ADDRESS1_ENG_' +_screenRef, labelArray.lbl_addressCO_ADDRESS1_ENG_);
	moreAddress_labelKey('#lbl_addressCO_ADDRESS2_ENG_' +_screenRef, labelArray.lbl_addressCO_ADDRESS2_ENG_);
	moreAddress_labelKey('#lbl_addressCO_ADDRESS3_ENG_' +_screenRef, labelArray.lbl_addressCO_ADDRESS3_ENG_);
	moreAddress_labelKey('#lbl_addressCO_ADDRESS4_ENG_' +_screenRef, labelArray.lbl_addressCO_ADDRESS4_ENG_);
	moreAddress_labelKey('#lbl_addressCO_ADDRESS1_ARAB_' +_screenRef, labelArray.lbl_addressCO_ADDRESS1_ARAB_);
	moreAddress_labelKey('#lbl_addressCO_ADDRESS2_ARAB_' +_screenRef, labelArray.lbl_addressCO_ADDRESS2_ARAB_);
	moreAddress_labelKey('#lbl_addressCO_ADDRESS3_ARAB_' +_screenRef, labelArray.lbl_addressCO_ADDRESS3_ARAB_);
	moreAddress_labelKey('#lbl_addressCO_ADDRESS4_ARAB_' +_screenRef, labelArray.lbl_addressCO_ADDRESS4_ARAB_);
	moreAddress_labelKey('#lbl_addressCO_STREET_DETAILS_ENG_' +_screenRef, labelArray.lbl_addressCO_STREET_DETAILS_ENG_);
	moreAddress_labelKey('#lbl_addressCO_STREET_DETAILS_ARAB_' +_screenRef, labelArray.lbl_addressCO_STREET_DETAILS_ARAB_);
	moreAddress_labelKey('#lbl_addressCO_CITY_ENG_' +_screenRef, labelArray.lbl_addressCO_CITY_ENG_);
	moreAddress_labelKey('#lbl_addressCO_CITY_ARAB_' +_screenRef, labelArray.lbl_addressCO_CITY_ARAB_);
	moreAddress_labelKey('#lbl_addressCO_COUNTRY_' +_screenRef, labelArray.lbl_addressCO_COUNTRY_);
	moreAddress_labelKey('#lbl_addressCO_CITY_CODE_' +_screenRef, labelArray.lbl_addressCO_CITY_CODE_);
	moreAddress_labelKey('#lbl_addressCO_SECTOR_CODE_' +_screenRef, labelArray.lbl_addressCO_SECTOR_CODE_);
	moreAddress_labelKey('#lbl_addressCO_POBOX_AREA_' +_screenRef, labelArray.lbl_addressCO_POBOX_AREA_);
	moreAddress_labelKey('#lbl_addressCO_POSTAL_CODE_' +_screenRef, labelArray.lbl_addressCO_POSTAL_CODE_);
	moreAddress_labelKey('#lbl_addressCO_ADDRESS_DESCRIPTION_' +_screenRef, labelArray.lbl_addressCO_ADDRESS_DESCRIPTION_);
	moreAddress_labelKey('#lbl_addressCO_FROM_DATE_' +_screenRef, labelArray.lbl_addressCO_FROM_DATE_);
	moreAddress_labelKey('#lbl_addressCO_TO_DATE_' +_screenRef, labelArray.lbl_addressCO_TO_DATE_);
	moreAddress_labelKey('#lbl_addressCO_EXPIRY_DATE_' +_screenRef, labelArray.lbl_addressCO_EXPIRY_DATE_);
	moreAddress_labelKey('#lbl_addressCO_PERM_ADDRESS_' +_screenRef, labelArray.lbl_addressCO_PERM_ADDRESS_);
	moreAddress_labelKey('#lbl_addressCO_DEFAULT_ADD_' +_screenRef, labelArray.lbl_addressCO_DEFAULT_ADD_);
	moreAddress_labelKey('#lbl_addressCO_TEL_' +_screenRef, labelArray.lbl_addressCO_TEL_);
	moreAddress_labelKey('#lbl_addressCO_WORK_TEL_' +_screenRef, labelArray.lbl_addressCO_WORK_TEL_);
	moreAddress_labelKey('#lbl_addressCO_MOBILE_' +_screenRef, labelArray.lbl_addressCO_MOBILE_);
	moreAddress_labelKey('#lbl_addressCO_OTHER_TEL_' +_screenRef, labelArray.lbl_addressCO_OTHER_TEL_);
	moreAddress_labelKey('#lbl_addressCO_FAX_' +_screenRef, labelArray.lbl_addressCO_FAX_);
	moreAddress_labelKey('#lbl_addressCO_PO_BOX_' +_screenRef, labelArray.lbl_addressCO_PO_BOX_);
	moreAddress_labelKey('#lbl_addressCO_EMAIL_' +_screenRef, labelArray.lbl_addressCO_EMAIL_);
	moreAddress_labelKey('#lbl_addressCO_PRINT_STAT_' +_screenRef, labelArray.lbl_addressCO_PRINT_STAT_);
	moreAddress_labelKey('#lbl_btn_MoreAddress_' +_screenRef, labelArray.lbl_btn_MoreAddress_);
}

function moreAddress_labelKey(element, labelValue)
{
//	if($(element).attr("class") == "required")
//	{
//		labelValue = labelValue + " *";
//	}
	$(element).text(labelValue);
}


//************************************************************************************************************************************

// Function called upon double clicking grid
function moreAddressGridTbl_Id_onDbClicked() {
	var elmId = _pageRef + "P";
	var screen =   $("#moreAddress_SCREEN_NAME_" + elmId).val();
	var $table = $("#moreAddressGridTbl_Id_" + elmId );
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var myObject = $table.jqGrid('getRowData', selectedRowId);
	var linkLoadSrc='';
	var addrParams = {};
	
	addrParams["_pageRef"] 				= 	_pageRef;
	addrParams["callingScreen"]			=   $("#moreAddress_SCREEN_NAME_" + elmId).val();	
	addrParams["tellerCanAccessFlag"] 	=	$("#addressCO_accesByTeller_" + elmId).val();
	
	if(screen=='FOM')
	{
		var cifType = 	$("#lookuptxt_cifVO_CIF_TYPE_" + _pageRef).val();
		
		addrParams["lineNbr"] 			= 	myObject["LINE_NO"];
		addrParams["cifCode"] 			= 	myObject["CIF_NO"];//$("#cifVO_CIF_NO_"+_pageRef).val();
		addrParams["criteria.compCodeCif"]		= 	$("#compCodeCif_" + _pageRef).val();//EWBI160091 (403157)- Modification of CIF
		addrParams["iv_crud"] 			=	$("#iv_crud_" + _pageRef).val();
		addrParams["addressCO.cifType"]	=   cifType;
		
		linkLoadSrc = jQuery.contextPath  + "/path/moreAddress/moreAddressMaint_showFOMAddressDetails.action";
	}
	else if(screen=='PMS' || screen=='TFA')
	{
		addrParams["lineNbr"] 			= 	myObject["LINE_NO"];
		addrParams["cifCode"] 			= 	myObject["CIF_NO"];
		addrParams["iv_crud"] 			=	$("#iv_crud_" + _pageRef).val();
		
		linkLoadSrc = jQuery.contextPath  + "/path/moreAddress/moreAddressMaint_showFOMAddressDetails.action";
	}

	else if(screen=='ACCOUNT')
	{
		var saveType = $("#saveType_" + _pageRef).val();
		if(saveType == "C")
		{
			addrParams["criteria.defaultAddressFromCif"] = true;
		}
		else
		{
			addrParams["criteria.defaultAddressFromCif"] = false;
		}
		addrParams["criteria.moreAddressWindowOpened"] = $("#moreAddressWindowOpened_"+_pageRef).val();
		addrParams["criteria.lineNo"] 			=	myObject["LINE_NO"];
		addrParams["criteria.branchCode"] 		= 	$("#branch_"+_pageRef).val();
		addrParams["criteria.cyCode"] 			= 	$("#lookuptxt_currencyCode_"+_pageRef).val();
		addrParams["criteria.glCode"] 			= 	$("#lookuptxt_glType_"+_pageRef).val();
		addrParams["criteria.cifNo"] 			= 	$("#lookuptxt_cifNo_"+_pageRef).val();
		addrParams["criteria.slNo"] 			= 	$("#srNo_"+_pageRef).val();
		addrParams["iv_crud"] 					=	$("#iv_crud_" + _pageRef).val();
		addrParams["_addressReadOnlyMode"] = $("#accountsManagementCO_moreAddressReadOnly_" + _pageRef).val();
		
		linkLoadSrc = jQuery.contextPath  + "/path/accounts/AccountAddressMaint_showAccountAddressDetails.action";

	}
	_showProgressBar(true);
	// action call to load data on hyperlink click with call back function 
	$("#moreAddressListDetailDiv_id_" + elmId).load(linkLoadSrc,addrParams, function() {
		fomNameAddressLanguageDropDown_onChange(elmId);
		_showProgressBar(false);
	});
}

// Function called upon Save button of Address Popup is clicked
function fOMMoreAddress_onSaveClicked()
{
	var elmId = _pageRef + "P";
	var changes = $("#fomMaint_fomMoreAddress_"+elmId).hasChanges(true);
	if(changes == 'true' || changes == true)
	{
		parseNumbers();
		
		var screen =   $("#moreAddress_SCREEN_NAME_" + elmId).val();
		var saveAction='';
		var reloadPath='';
		var saveParams='';
		var reloadParams = {};
		var saveType;
		var lineNo = $("#addressCO_LINE_NO_"+elmId).val();
			if(lineNo=="" || lineNo == null ||  lineNo == "undefined" )saveType="C"; else saveType="M";
		
		var iv_crud = $("#iv_crud_"+ _pageRef).val();
		if(screen=='FOM')
		{
			var cifStatus = $("#cifVO_STATUS_"+ _pageRef).val();
			var cif_UpdateDate = $("#cifVO_DATE_UPDATED_"+ _pageRef).val();
			var cifCode = $("#cifVO_CIF_NO_"+_pageRef).val();
			var cifType = 	$("#lookuptxt_cifVO_CIF_TYPE_" + _pageRef).val();
			var compCodeCif = $('#compCodeCif_' + _pageRef).val();
		
			reloadParams["_pageRef"] 			= 	_pageRef;
			reloadParams["iv_crud"] 			=	$("#iv_crud_" + _pageRef).val();
			reloadParams["tellerCanAccessFlag"] =	$("#addressCO_accesByTeller_" + elmId).val();
			reloadParams["callingScreen"]		=   $("#moreAddress_SCREEN_NAME_" + elmId).val();	
			reloadParams["cifCode"]				=   cifCode;
			reloadParams["addressCO.cifType"]	=   cifType;

			$("#fomMaint_fomMoreAddress_"+ elmId + "> #auditObj_" + _pageRef).val($("#fomMaintForm_" + _pageRef + "> #auditObj_" + _pageRef).val());
			$("#fomMaint_fomMoreAddress_"+ elmId + "> #auditTrxNbr_" + _pageRef).val($("#fomMaintForm_" + _pageRef + "> #auditTrxNbr_" + _pageRef).val());
			saveAction = jQuery.contextPath+"/path/fom/FOMCommonMaint_saveAddressPopupDetails";
			saveParams = "&saveType=" + saveType +"&cifCode="+cifCode+"&cifStatus="+cifStatus+"&iv_crud="+iv_crud+
			              "&cif_UpdateDate="+cif_UpdateDate + "&addressCO.cifType="+cifType+"&cifAddressCO.compCodeCif="+compCodeCif;
			reloadPath = jQuery.contextPath+"/path/moreAddress/moreAddressMaint_showFOMAddressDetails";
		}
		else if(screen=='ACCOUNT')
		{
			var lineNo 		= $("#addressCO_LINE_NO_"+elmId).val();
			var cifNo 		= $("#lookuptxt_cifNo_"+_pageRef).val();
			var branchCode 	= $("#lookuptxt_branch_"+_pageRef).val();
			var cyCode 		= $("#lookuptxt_currencyCode_"+_pageRef).val();
			var glCode 		= $("#lookuptxt_glType_"+_pageRef).val();
			var slNo 		= $("#srNo_"+_pageRef).val();
			
			
			reloadParams["_pageRef"] 				= 	_pageRef;
			reloadParams["criteria.lineNo"] 		=	lineNo;
			reloadParams["criteria.cifNo"] 			= 	cifNo;
			reloadParams["criteria.branchCode"] 	= 	branchCode;
			reloadParams["criteria.cyCode"] 		= 	cyCode;
			reloadParams["criteria.glCode"] 		= 	glCode;
			reloadParams["criteria.slNo"] 			= 	slNo;
			reloadParams["iv_crud"] 				=	$("#iv_crud_" + _pageRef).val();
			reloadParams["callingScreen"] = 'ACCOUNT';
			reloadPath = jQuery.contextPath+"/path/accounts/AccountAddressMaint_showAccountAddressDetails";
			saveParams = "&saveActionType=" + saveType +"&iv_crud="+iv_crud + "&addressCO.ACC_CIF="+cifNo + "&addressCO.ACC_BR="+branchCode 
						+ "&addressCO.ACC_CY="+cyCode + "&addressCO.ACC_GL="+glCode + "&addressCO.ACC_SL="+slNo;
			saveAction = jQuery.contextPath + '/path/accounts/AccountsMain_saveMoreAddressDetails';
		}
		
	var addressForm  = $("#fomMaint_fomMoreAddress_"+elmId).serializeForm();
	var theForm 	  = addressForm+saveParams;
	
	_showProgressBar(true);
	$.ajax({
		 url: saveAction,
         type:"post",
		 dataType:"json",
		 data: theForm,
		 success: function(data){
		    
			 if(typeof data["_error"] == "undefined" || data["_error"] == null)
		     {
				if (screen == 'FOM') 
				{
					changeCIFValues(data.cifStatus, data.latestCifupdateDate);
				}
				// on reload we should set the changeTrack of the form to false 
				// because the form (tag) is not refreshed and it is declared in MoreAddressPopup.jsp and 
				// we can't put it in MoreAddressDetail.jsp
				var theForm = document.getElementById("fomMaint_fomMoreAddress_"+elmId);
				$.data(theForm,"changeTrack",false);
				
			   $("#moreAddressListDetailDiv_id_"+elmId).load(reloadPath,reloadParams);
               if($("#moreAddressGridTbl_Id_"+elmId).html()!=null && $("#moreAddressGridTbl_Id_"+elmId).html()!="")
               {
            	 $("#moreAddressGridTbl_Id_"+elmId).trigger("reloadGrid");
               }
             } 
			 _showProgressBar(false);
		 }
    });
	}
	
}

// Function called upon Add button of Address Popup is clicked
function fOMMoreAddress_onAddClicked()
{
	var elmId = _pageRef + "P";
	var screen =   $("#moreAddress_SCREEN_NAME_" + elmId).val();
	var mySrc='';
	var params = {};
	if(screen=='FOM')
	{
		params["_pageRef"] 		= 	_pageRef;
		params["cifCode"] 		= 	$("#cifVO_CIF_NO_" + _pageRef).val();
		params["iv_crud"] 		=	$("#iv_crud_" + _pageRef).val();
		params["cifStatus"] 		= 	$("#cifVO_STATUS_" + _pageRef).val();
		params["cifNo"] 			= 	$("#cifVO_CIF_NO_" + _pageRef).val();
		params["cifType"] 		= 	$("#lookuptxt_cifVO_CIF_TYPE_" + _pageRef).val();
		params["addrScreenMode"] = 	$("#fomAddress_screenMode_" + _pageRef).val();
		params["fromAddMethod"]  = 	'add';
		//NABIL FEGHALI - Fix Issue 228295
		params["callingScreen"] = 	screen;
		
		 mySrc = jQuery.contextPath  + "/path/moreAddress/moreAddressList_populateMoreAddressPopupforFOM.action";
	}
	else if(screen=='ACCOUNT')
	{
		params["_pageRef"] 			    = 	_pageRef;
		params["iv_crud"] 		 	    =	$("#iv_crud_" + _pageRef).val();
		params["criteria.branchCode"] 	= 	$("#branch_" + _pageRef).val();
		params["criteria.cyCode"] 		= 	$("#lookuptxt_currencyCode_" + _pageRef).val();
		params["criteria.glCode"] 		= 	$("#lookuptxt_glType_" + _pageRef).val();
		params["criteria.cifNo"] 		= 	$("#lookuptxt_cifNo_" + _pageRef).val();
		params["criteria.slNo"] 		= 	$("#srNo_" + _pageRef).val();
		params["fromAddMethod"]  	= 	'add';
		//NABIL FEGHALI - Fix Issue 228295
		params["callingScreen"] = 	screen;
				
		mySrc = jQuery.contextPath  + "/path/accounts/AccountAddressList_populateMoreAddressPopupforAccounts.action";
	}
	//508805; send the screen as parameter
	 params["callingScreen"] =     screen;
	_showProgressBar(true);
	$("#moreAddressListDetailDiv_id_" + elmId).load(mySrc ,params, function() {
			$("#moreAddressGridTbl_Id_"+elmId).jqGrid('resetSelection');
			_showProgressBar(false);
	});
	//$("#fomMaint_fomMoreAddress_"+_pageRef + "P").clearForm();
}

// Function called upon Delete button of Address Popup is clicked
function fOMMoreAddress_onDeleteClicked()
{
	var elmId = _pageRef + "P";
	var _auditJsonStr = "";
	var auditTrxNbr = "";
	var screen =   $("#moreAddress_SCREEN_NAME_" + elmId).val();
	var delAction='';
	
	var $table = $("#moreAddressGridTbl_Id_" + _pageRef+ "P");
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var selectedRowObject = $table.jqGrid('getRowData', selectedRowId);
	var lineNo = selectedRowObject["LINE_NO"];
	if(screen=='FOM')
	{
		delAction = jQuery.contextPath + "/path/fom/FOMCommonMaint_deleteAddressPopupDetails";
		_auditJsonStr = $("#fomMaintForm_" + _pageRef + "> #auditObj_" + _pageRef).val();
		auditTrxNbr = $("#fomMaintForm_" + _pageRef + "> #auditTrxNbr_" + _pageRef).val()
	}
	else if(screen=='ACCOUNT')
	{
		var iv_crud = $("#iv_crud_"+ _pageRef).val();
	    var cifNo 		= $("#lookuptxt_cifNo_"+_pageRef).val();
		var branchCode 	= $("#lookuptxt_branch_"+_pageRef).val();//lookuptxt_branch_ modified by rany for bugid:680681 was branch_
		var cyCode 		= $("#lookuptxt_currencyCode_"+_pageRef).val();
		var glCode 		= $("#lookuptxt_glType_"+_pageRef).val();
		var slNo 		= $("#srNo_"+_pageRef).val();
		var saveParams = "saveActionType=D&iv_crud="+iv_crud + "&addressCO.ACC_CIF="+cifNo + "&addressCO.ACC_BR="+branchCode 
						+ "&addressCO.ACC_CY="+cyCode + "&addressCO.ACC_GL="+glCode + "&addressCO.ACC_SL="+slNo + "&addressCO.LINE_NO="+lineNo;
		delAction = jQuery.contextPath + '/path/accounts/AccountsMain_saveMoreAddressDetails?'+saveParams;
	}

	if(lineNo=="")
	{
		_showErrorMsg('Choose a record to delete');
		return;
	}

	var confirmMsg = Confirm_Delete_Process_key;
	_showConfirmMsg(confirmMsg, Warning_key,
				callMoreAddress_delete, {
					url : delAction,
					data : {"cifStatus" : $("#cifVO_STATUS_"+ _pageRef).val(),
							"iv_crud" : $("#iv_crud_"+ _pageRef).val(),
							"cif_UpdateDate":$("#cifVO_DATE_UPDATED_"+ _pageRef).val(),
							"lineNo":lineNo,
							"cifCode":$("#cifVO_CIF_NO_"+_pageRef).val(),
							"_auditJsonStr":_auditJsonStr,
							"auditTrxNbr":auditTrxNbr,
							"_pageRef":_pageRef
						   }
				});	
}

function callMoreAddress_delete(confirm, args)
{
	if(confirm) 
	{
		var elmId = _pageRef + "P";
		var screen =   $("#moreAddress_SCREEN_NAME_" + elmId).val();
		var reloadParams = {};
		var reloadPath='';
		if(screen=='FOM')
		{
			var cifType = 	$("#lookuptxt_cifVO_CIF_TYPE_" + _pageRef).val();
			
			reloadParams["_pageRef"] 			= 	_pageRef;
			reloadParams["iv_crud"] 			=	$("#iv_crud_" + _pageRef).val();
			reloadParams["tellerCanAccessFlag"] =	$("#addressCO_accesByTeller_" +elmId).val();
			reloadParams["callingScreen"]		=   $("#moreAddress_SCREEN_NAME_" + elmId).val();	
			reloadParams["cifCode"]				=   args.data["cifCode"];
			reloadParams["addressCO.cifType"]	=   cifType;
			
			reloadPath = jQuery.contextPath+"/path/moreAddress/moreAddressMaint_showFOMAddressDetails";
		}
		else if(screen=='ACCOUNT')
		{
			reloadParams["_pageRef"] 			= 	_pageRef;
			reloadParams["iv_crud"] 			=	$("#iv_crud_" + _pageRef).val();
			reloadParams["criteria.branchCode"] = 	$("#branch_" + _pageRef).val();
		    reloadParams["criteria.cyCode"] 	= 	$("#lookuptxt_currencyCode_" + _pageRef).val();
		    reloadParams["criteria.glCode"] 	= 	$("#lookuptxt_glType_" + _pageRef).val();
		    reloadParams["criteria.cifNo"] 		= 	$("#lookuptxt_cifNo_" + _pageRef).val();
		    reloadParams["criteria.slNo"] 		= 	$("#srNo_" + _pageRef).val();
			
			reloadParams["fromAddMethod"]  	= 	'add';
			reloadParams["callingScreen"] = 	screen;
					
			reloadPath = jQuery.contextPath  + "/path/accounts/AccountAddressList_populateMoreAddressPopupforAccounts.action";
		}
		
		var delAction = args.url;
		_showProgressBar(true);
		$.ajax({
		 url: delAction,
         type:"post",
		 dataType:"json",
		 data: args.data,
		 success: function(data){
			if(typeof data["_error"] == "undefined" || data["_error"] == null)
		     {	 
				if(screen=='FOM')
				{
		        	changeCIFValues(data.cifStatus,data.latestCifupdateDate);
		        }
			   $("#moreAddressListDetailDiv_id_"+elmId).load(reloadPath,reloadParams);
               if($("#moreAddressGridTbl_Id_"+elmId).html()!=null && $("#moreAddressGridTbl_Id_"+elmId).html()!="")
               {
            	 $("#moreAddressGridTbl_Id_"+elmId).trigger("reloadGrid");
               }
            }
			_showProgressBar(false);
		 }
    });
	return false;
	}
}


/**
 * Added by John Massaad
 *This method is used to set the phone format in the grid column "Fax" and Telephone due to the bug [252671]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */

function callMoreAddress_actionTypeFormatter(cellValue, options, rowObject) 
{
	var valOfCell = (cellValue == undefined)?" ":cellValue;
	
	//here we are getting the countryTelFormat from the DB
	if(typeof rowObject["countryTelFormat"]!= "undefined" && rowObject["countryTelFormat"] != null && rowObject["countryTelFormat"] != "")
	{
		//we are creating fake input that have the cellValue as value because the 'mask' (from jquery.maskedinput.js used to format the phone number) function works with <input> elements and here the column is a <td>
		return $($("<input value='"+valOfCell+"'>").mask(rowObject["countryTelFormat"])).val();
	}
	else
	{
		return valOfCell;
	}
}

function validateEmail(progRef) 
{
	if(progRef == null || progRef == '')
	{
		progRef = _pageRef;
	}
	var emails = $("#addressCO_EMAIL_"+ $('#_addressPageRef_'+ progRef).val()).val();
	if(emails != '')
	{
		var emailArray=emails.split(/[ ,]+/);
		
	    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  
	    var allValid=true;
	    for (var i = 0; i < emailArray.length; i++) {
	       if(!re.test(emailArray[i]))
		    {
		    	$("#addressCO_EMAIL_"+$('#_addressPageRef_'+ progRef).val()).val($("#addressCO_EMAIL_"+ $('#_addressPageRef_'+ progRef).val()).attr("prevValue"));
		    	allValid=false;
		    	break;
		    }
	    }
	    
	  
	    if(allValid)
	    {
	    	$("#addressCO_EMAIL_"+$('#_addressPageRef_'+ progRef).val()).attr("prevValue", $("#addressCO_EMAIL_"+$('#_addressPageRef_'+ progRef).val()).val());
	    }
	    else
	    {
	    	_showErrorMsg(Invalid_Entry_key,Cannot_Proceed_Key);

	    }	
	}
}

function validateDescription(e) 
{
	var desc = $("#description_"+_pageRef).val();
	var mode = $("#modeOfStmtDelivery_"+_pageRef).val();
	if(mode == 'E' && desc != '')
	{
	    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	    if(!re.test(desc))
	    {
	    	$("#description_"+_pageRef).val($("#description_"+_pageRef).attr("prevValue"));	    	
	    	_showErrorMsg(Invalid_Entry_key,Cannot_Proceed_Key);
	    }
	    else
	    {
	    	$("#description_"+_pageRef).attr("prevValue",$("#description_"+_pageRef).val())  
	    }
	}
}

function validateTelex()
{
	var src = jQuery.contextPath + "/path/fom/FOMValidate_validateSpecialCharInFields";
	debugger;
	$.ajax( {
		url : src,
		type : "post",
		dataType : "json",
		data: {"fomCO.addressField":$("#addressCO_TELEX_" + _pageRef).val()},
		success : function(data) {
			if (data["_error"] == null) 
			{
				$("#addressCO_TELEX_"+_pageRef).attr("prevValue",$("#addressCO_TELEX_"+_pageRef).val())
				$("#addressCO_TELEX_" + _pageRef).val(data.fomCO.addressField)
			}
			else
			{
				$("#addressCO_TELEX_" + _pageRef).val($("#addressCO_TELEX_" + _pageRef).attr("prevValue"));
			}
		}
	});
}
