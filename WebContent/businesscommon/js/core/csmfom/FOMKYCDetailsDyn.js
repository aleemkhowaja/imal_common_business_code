function openPassportInfoPopupDyn()
{
	var prevValueNumber1;
	var prevValueDteIssuance1;
	var prevValueDteIssuanceHijri1;
	var prevValuePlaceIssuance1;
	var prevValueCntryIssuance1;
	var prevValueExpiryDate1;
	var prevValueExpiryDateHijri1;
	var prevValueNumber2;
	var prevValueDteIssuance2;
	var prevValueDteIssuanceHijri2;
	var prevValuePlaceIssuance2;
	var prevValueCntryIssuance2;
	var prevValueExpiryDate2;
	var prevValueExpiryDateHijri2;
	var prevValueNumber3;
	var prevValueDteIssuance3;
	var prevValueDteIssuanceHijri3;
	var prevValuePlaceIssuance3;
	var prevValueCntryIssuance3;
	var prevValueExpiryDate3;
	var prevValueExpiryDateHijri3;
	var prevValueCountryIssuance1Desc;
	if($("#isPassportLoaded_"+_pageRef).val()==1)
	{	
		prevValueNumber1 = $("#cifVO1_PASPORT_NO_"+_pageRef).val();
		prevValueDteIssuance1 =  $("#cifVO1_PASSPORT_ISSUE_DATE_"+_pageRef).val();
		prevValueDteIssuanceHijri1 =  $("#cifVO1_PASSPORT_ISSUE_DATE_"+_pageRef+"_hijriDate").val();
		prevValuePlaceIssuance1 = $("#cifVO1_PASSPORT_ISSUE_PLACE_"+_pageRef).val();
		prevValueCntryIssuance1 = $("#lookuptxt_cif1VOCountryOfIssuance_"+_pageRef).val();
		prevValueExpiryDate1 = $("#cifVO1_PASSPORT_EXPIRY_DATE_"+_pageRef).val();
		prevValueExpiryDateHijri1 = $("#cifVO1_PASSPORT_EXPIRY_DATE_"+_pageRef+"_hijriDate").val();
		prevValueCountryIssuance1Desc =$("#cif1VOCountryOfIssuanceDesc_"+_pageRef).val();	 
		  
		prevValueNumber2 = $("#cifVO1_PASSPORT_NO2_"+_pageRef).val();
		prevValueDteIssuance2 =  $("#cifVO1_PASSPORT_ISSUE_DATE2_"+_pageRef).val();
		prevValueDteIssuanceHijri2 =  $("#cifVO1_PASSPORT_ISSUE_DATE2_"+_pageRef+"_hijriDate").val();
		prevValuePlaceIssuance2 = $("#cifVO1_PASSPORT_ISSUE_PLACE2_"+_pageRef).val();
		prevValueCntryIssuance2 = $("#lookuptxt_cifVO1CountryOfIssuance2_"+_pageRef).val();
		prevValueExpiryDate2 = $("#cifVO1_PASSPORT_EXPIRY_DATE2_"+_pageRef).val();
		prevValueExpiryDateHijri2 = $("#cifVO1_PASSPORT_EXPIRY_DATE2_"+_pageRef+"_hijriDate").val();
		prevValueCountryIssuance2Desc =$("#cif1VOCountryOfIssuance2Desc_"+_pageRef).val();	 
		
		prevValueNumber3 = $("#cifVO1_PASSPORT_NO3_"+_pageRef).val();
		prevValueDteIssuance3 =  $("#cifVO1_PASSPORT_ISSUE_DATE3_"+_pageRef).val();
		prevValueDteIssuanceHijri3 =  $("#cifVO1_PASSPORT_ISSUE_DATE3_"+_pageRef+"_hijriDate").val();
		prevValuePlaceIssuance3 = $("#cifVO1_PASSPORT_ISSUE_PLACE3_"+_pageRef).val();
		prevValueCntryIssuance3 = $("#lookuptxt_cifVO1CountryOfIssuance3_"+_pageRef).val();
		prevValueExpiryDate3 = $("#cifVO1_PASSPORT_EXPIRY_DATE3_"+_pageRef).val();
		prevValueExpiryDateHijri3 = $("#cifVO1_PASSPORT_EXPIRY_DATE3_"+_pageRef+"_hijriDate").val();
		prevValueCountryIssuance3Desc =$("#cif1VOCountryOfIssuance3Desc_"+_pageRef).val();	 
	}
	
	
    var okButtonTitle = ok_label_trans;	
	var moreInfoDivId = "moreInfoDivId";
	var okButton = '<a id="moreInfoDivId_okButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="$(\'#moreInfoDivId\').dialog(\'close\')">' + okButtonTitle +'</span>' +
						'</a>';	
	
	var reasonDivContent = "<div id='"+ moreInfoDivId +"'><table style='width:100%;height:100%'>"
							+"</div>";	
	var reasonDivElement = $(reasonDivContent);
	
	if($("#" + moreInfoDivId) && $("#" + moreInfoDivId).attr('id') != undefined)
	{
		$("#" + moreInfoDivId).dialog("destroy");
		$("#" + moreInfoDivId).remove();
	}
	
	$('body').append(reasonDivElement);
	reasonDivElement.dialog({
									modal : true,
									title : Passport_Info_key,
									autoOpen : false,
									position : 'center',
									width : returnMaxWidth(850),
									height : returnMaxHeight(400),
									close : function() {
										if($("#moreInfoDivId"))
										{
											//stopped the below because now have to save in a textfield in fom screen
											//$("#"+hiddenPasspInfo+"_"+_pageRef).val($('#moreInfoDivId').find('input').serialize());
											//$("#additionnalKycProps_"+_pageRef).val($("#additionnalKycProps_"+_pageRef).val()+""+$('#moreInfoDivId').find('input').serialize());
											//appending the passport dialog to the dynamic screen's form
											_showProgressBar(true);
											$(this).dialog("destroy");//.appendTo("#dynScreen_"+$("#screenid_"+_pageRef).val()+"_FormId_"+_pageRef+"_DivId");
											$("#isPassportLoaded_"+_pageRef).val("1");
											afterClosePassportPopup();
										}
										
									}
								});
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_populatePassportInfoPopup.action?_pageRef="+ _pageRef+"_KYC";
	$(reasonDivElement).load(mySrc, {"cifNo":$("#cifVO_CIF_NO_" + _pageRef).val(),
		"auditTrxNbr":$("#auditTrxNbr_"+_pageRef).val(), 
		"_recReadOnly":$("#fom_recReadOnly_"+ _pageRef).val(),
		 "isLookUp":$("#isLookUp_" + _pageRef).val()}, function()
			 {
			 	$(reasonDivElement).append("<table style='width:100%'><tr><td align='right'>"+okButton+"</td></tr></table>")
			 	if($("#isPassportLoaded_"+_pageRef).val()==1)
			 	{
			 		 $("#cifVO1_PASPORT_NO_"+_pageRef+"_KYC").val(prevValueNumber1);
			 		 $("#cifVO1_PASSPORT_ISSUE_DATE_"+_pageRef+"_KYC").val(prevValueDteIssuance1);
			 		 $("#cifVO1_PASSPORT_ISSUE_DATE_"+_pageRef+"_KYC_hijriDate").val(prevValueDteIssuanceHijri1);
			 	//	 $("#cifVO1_PASSPORT_ISSUE_DATE_"+_pageRef+"_KYC").trigger("change");
			 		 $("#cifVO1_PASSPORT_ISSUE_PLACE_"+_pageRef+"_KYC").val(prevValuePlaceIssuance1);
			 		 $("#lookuptxt_cif1VOCountryOfIssuance_"+_pageRef+"_KYC").val(prevValueCntryIssuance1);
			 		 $("#cif1VOCountryOfIssuanceDesc_"+_pageRef+"_KYC").val(prevValueCountryIssuance1Desc);
			 		 $("#cifVO1_PASSPORT_EXPIRY_DATE_"+_pageRef+"_KYC").val(prevValueExpiryDate1);
			 		 $("#cifVO1_PASSPORT_EXPIRY_DATE_"+_pageRef+"_KYC_hijriDate").val(prevValueExpiryDateHijri1);
			 		// $("#cifVO1_PASSPORT_EXPIRY_DATE_"+_pageRef+"_KYC").trigger("change");
			 		
			 		 $("#cifVO1_PASSPORT_NO2_"+_pageRef+"_KYC").val(prevValueNumber2);
			 		 $("#cifVO1_PASSPORT_ISSUE_DATE2_"+_pageRef+"_KYC").val(prevValueDteIssuance2);
			 		 $("#cifVO1_PASSPORT_ISSUE_DATE2_"+_pageRef+"_KYC_hijriDate").val(prevValueDteIssuanceHijri2);
			 		 //$("#cifVO1_PASSPORT_ISSUE_DATE2_"+_pageRef+"_KYC").trigger("change");
			 		 $("#cifVO1_PASSPORT_ISSUE_PLACE2_"+_pageRef+"_KYC").val(prevValuePlaceIssuance2);
			 		 $("#lookuptxt_cifVO1CountryOfIssuance2_"+_pageRef+"_KYC").val(prevValueCntryIssuance2);
			 		 //$("#lookuptxt_cifVO1CountryOfIssuance2_"+_pageRef+"_KYC").trigger("change");
			 		 $("#cifVO1_PASSPORT_EXPIRY_DATE2_"+_pageRef+"_KYC").val(prevValueExpiryDate2);
			 		 $("#cifVO1_PASSPORT_EXPIRY_DATE2_"+_pageRef+"_KYC_hijriDate").val(prevValueExpiryDateHijri2);
			 		 //$("#cifVO1_PASSPORT_EXPIRY_DATE2_"+_pageRef+"_KYC").trigger("change");
			 		 $("#cif1VOCountryOfIssuance2Desc_"+_pageRef+"_KYC").val(prevValueCountryIssuance2Desc);
			 		
			 		 $("#cifVO1_PASSPORT_NO3_"+_pageRef+"_KYC").val(prevValueNumber3);
			 		 $("#cifVO1_PASSPORT_ISSUE_DATE3_"+_pageRef+"_KYC").val(prevValueDteIssuance3);
			 		 $("#cifVO1_PASSPORT_ISSUE_DATE3_"+_pageRef+"_KYC_hijriDate").val(prevValueDteIssuanceHijri3);
			 		 //$("#cifVO1_PASSPORT_ISSUE_DATE3_"+_pageRef+"_KYC").trigger("change");
			 		 $("#cifVO1_PASSPORT_ISSUE_PLACE3_"+_pageRef+"_KYC").val(prevValuePlaceIssuance3);
			 		 $("#lookuptxt_cifVO1CountryOfIssuance3_"+_pageRef+"_KYC").val(prevValueCntryIssuance3);
			 		 //$("#lookuptxt_cifVO1CountryOfIssuance3_"+_pageRef+"_KYC").trigger("change");
			 		 $("#cifVO1_PASSPORT_EXPIRY_DATE3_"+_pageRef+"_KYC").val(prevValueExpiryDate3);
			 		 $("#cifVO1_PASSPORT_EXPIRY_DATE3_"+_pageRef+"_KYC_hijriDate").val(prevValueExpiryDateHijri3);
			 		 //$("#cifVO1_PASSPORT_EXPIRY_DATE3_"+_pageRef+"_KYC").trigger("change");
			 		 $("#cif1VOCountryOfIssuance3Desc_"+_pageRef+"_KYC").val(prevValueCountryIssuance3Desc);
			 	}
			 	_showProgressBar(false);
			});
	
	$(reasonDivElement).dialog("open");
}

function afterClosePassportPopup()
{
	var mySrc = jQuery.contextPath+"/path/fom/FrontOfficeMgntMaint_populatePassportInfoPopup.action?_pageRef="+_pageRef;
	$("#fomPassportInfoDialog_"+_pageRef).load(mySrc, {"cifNo":$("#cifVO_CIF_NO_"+_pageRef).val(),"_recReadOnly" : $("#fom_recReadOnly_" + _pageRef).val(),
		"isLookUp" : $("#isLookUp_" + _pageRef).val(), "auditTrxNbr":$("#auditTrxNbr_"+_pageRef).val()}
	,function(){
					$("#fomPassportInfoDialog_"+_pageRef).find("input").each(function (){
							var id = $(this).attr("id");
							if(id.indexOf("_hijriDate") != -1)
							{
								$("#"+id).val($("#"+id.replace("_hijriDate", "")+"_KYC_hijriDate").val());
							}
							else
							{
								$("#"+id).val($("#"+id+'_KYC').val());
							}
					})
			   _showProgressBar(false)});
}

function checkRecalcCall(obj,toReset)
{
	if($("#kycCompCall_"+_pageRef+"Y").is(":checked") && $("#clientRecall_"+_pageRef+"Y").is(":checked"))
	{		
		$(toReset).attr("checked",true);	
	}	
}

function loadTheValues(screenId)
{	
	//reading values from fom screen and not database
	updateKycSessionLang();
	if($("#additionnalKycProps_"+_pageRef).val()!="")
	{
		value = $("#additionnalKycProps_"+_pageRef).val();
		var elementNames = [];
		var elementValues = [];
		var i=0;
		while(value.indexOf("&")!=-1)
		{
			value = value.substring(value.indexOf("&")+1,value.length);
			currentString = value.substring(0,value.indexOf("&"));
			elementName = currentString.substring(0,currentString.indexOf("="));
			elementValue = currentString.substring(currentString.indexOf("=")+1,currentString.length);
			if($("[name='"+elementName+"']").attr('type')=='radio')
	       	{
				$("input:radio[name='"+elementName+"'][value='"+elementValue+"']").attr("checked","checked");
				elementNames[i] = elementName;
				elementValues[i] = elementValue;
				i++;
	        }
			else if($("[name='"+elementName+"']").attr('type')=='checkbox' && elementValue==1)
			{
				$("[name='"+elementName+"']").attr("checked","checked");
			}
	        else
	        {
	        	elementValue = elementValue.replace(/\+/g," ");
	        	elementValue = elementValue.replace(/%2C/g,"/");
	        	elementValue = elementValue.replace(/%2F/g,"/");
	        	elementValue = decodeURIComponent(elementValue);
	            if(elementName!='')
	        	{
	            	$("[name='"+elementName+"']").val(elementValue);
	        	}
	        }	 
		}	
		//handling the last element in the value string
		currentString = value;
		elementName = currentString.substring(0,currentString.indexOf("="));
		elementValue = currentString.substring(currentString.indexOf("=")+1,currentString.length);
		if($("[name='"+elementName+"']").attr('type')=='radio')
       	{
			$("input:radio[name='"+elementName+"'][value='"+elementValue+"']").attr("checked","checked");
			elementNames[i] = elementName;
			elementValues[i] = elementValue;
			i++;
        }
        else
        {
        	elementValue = elementValue.replace(/\+/g," ");
        	elementValue = elementValue.replace(/%2C/g,"/");
        	elementValue = elementValue.replace(/%2F/g,"/");
        	$("[name='"+elementName+"']").val(elementValue);
        }	 
		//end for last element
		
		//triggering the clicks after the fill of data
		for(j=0;j<elementNames.length;j++)
		{
			$("input:radio[name='"+elementNames[j]+"'][value='"+elementValues[j]+"']").trigger("click"); 		
		}
		$("#kycCompCall_"+_pageRef+"Y").click(function(){checkRecalcCall(this,"#clientRecall_"+_pageRef+"N");});
		$("#clientRecall_"+_pageRef+"Y").click(function(){checkRecalcCall(this,"#kycCompCall_"+_pageRef+"N");});		
		$("#cifTypeDyn_"+_pageRef).val($("#lookuptxt_cifVO_CIF_TYPE_"+_pageRef).val());
		$("#cifTypeDyn_"+_pageRef).trigger("change");
		$("#fomNationality_"+_pageRef).val($("#lookuptxt_cifVO_NATION_CODE_"+_pageRef).val());
		$("#fomNationality_"+_pageRef).trigger("change");
		$("#fatcaCountry_"+_pageRef).trigger("change");
		$("#disableKycRecalCompByCall_"+_pageRef).trigger("change");
		$("#kycSironVisibility_"+_pageRef).trigger("change");
		var kycAddressPostalCode=$("#lookuptxt_postalCodeLS_"+_pageRef).val();
		var kycRegion=$("#lookuptxt_areaAddress_"+_pageRef).val();
		
		if($("#applyCorporateKycId_"+_pageRef).val()=="1")
		{
			 if($("#relativeAnyAbove_"+_pageRef).is(':checked')==true)
			   {   
			     $("#relativeAnyAbove_"+_pageRef).trigger("click");
			     $("[name='fomCO.cifKYCVO.RELATIVE_WITH_PEP_YN']").attr("checked","checked");	 
			   }
			 
			 if($("#connAnyAbove_"+_pageRef).is(':checked')==true)
			   {	 
				 $("#connAnyAbove_"+_pageRef).trigger("click");
				 $("[name='fomCO.cifKYCVO.CONNECTION_WITH_PEP_YN']").attr("checked","checked");	 
			   }
			 var kycRegionDesc=$("#ymcAreaDesc_"+_pageRef).val();
			 var kycAddressPostalCodeDesc=$("#ymcAddressPostCodeDesc_"+_pageRef).val();  
			 var telNo=$("#telNo_"+_pageRef).val();
			 var fax=$("#fax_"+_pageRef).val();
			 $("#lookuptxt_countryForLbl_"+_pageRef).trigger("change");
			//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
	    	 $("#sironHiddenStatus_"+_pageRef).trigger("change");
	    	//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
	
		}
		else
		{
			
			var kycRegionDesc=$("#areaDesc_"+_pageRef).val();
			var kycAddressPostalCodeDesc=$("#specifyPostalCodeDesc_"+_pageRef).val();
			var telNo=$("#telNoDesc_"+_pageRef).val();
			var fax=$("#faxDesc_"+_pageRef).val();
			$("#lookuptxt_specifyCountryLS_"+_pageRef).trigger("change");
			$("#lookuptxt_relationshipLkp_"+_pageRef).trigger("change");
			$("#lookuptxt_politicalPositionDynLkp_"+_pageRef).trigger("change");
		}
		
		//set time out till we find a solution with java team
		setTimeout(function(){
		$("[name='fomCO.kycRegion']").val(kycRegion);
   	  	$("[name='fomCO.kycRegionDesc']").val(kycRegionDesc);
   	  	$("[name='fomCO.kycAddressPostalCode']").val(kycAddressPostalCode);
   	  	$("[name='fomCO.kycTel']").val(telNo);
   	  	$("[name='fomCO.kycFax']").val(fax);
   	  	$("#lookuptxt_bankName_"+_pageRef).trigger("change");
   	  	$("[name='fomCO.kycAddressPostalCodeDesc']").val(kycAddressPostalCodeDesc);}, 2000);
		return;
		 
	}	

	$("#kycCompCall_"+_pageRef+"Y").click(function(){checkRecalcCall(this,"#clientRecall_"+_pageRef+"N");});
	$("#clientRecall_"+_pageRef+"Y").click(function(){checkRecalcCall(this,"#kycCompCall_"+_pageRef+"N");});
	$("#kycSironVisibility_"+_pageRef).val($("#sironVisibility_"+_pageRef).val());
	$("#kycSironCompliance_"+_pageRef).val($("#sironCompliance_"+_pageRef).val());
//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
	$("#sironResetKycScoreDS_"+_pageRef).val($("#sironResetKycScore_"+_pageRef).val());
	$("#sironResetKycScoreDS_"+_pageRef).trigger("change");
//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
	$("#kycSironVisibility_"+_pageRef).trigger("change");
	$("#cifTypeDyn_"+_pageRef).val($("#lookuptxt_cifVO_CIF_TYPE_"+_pageRef).val());
	$("#cifTypeDyn_"+_pageRef).trigger("change");
	//added parameters neede on normal load of old kyc screen
	var screenLang = $('#screenLang_' + _pageRef).val();
	var cifLang = $('#cifVO_LANGUAGE_' + _pageRef).val();
	var cif_no = $('#cifVO_CIF_NO_'+ _pageRef).val();
	var neededLocale = "en_US";
	var cifKYCCompleted = $("#cifVO_KYC_COMPLETED_"+_pageRef).val();	
	var isLookUp = $("#isLookUp_"+_pageRef).val();
	var params   ="_pageRef="+_pageRef 
				 +"&_recReadOnly=" + $('#fomMaint_recReadOnly_' + _pageRef).val()
				 +"&neededLocale=" + neededLocale
				 +"&iv_crud=" + $("#iv_crud_"+_pageRef).val()
				 +"&fomCO.cifVO.CIF_NO="+cif_no
				 +"&fomCO.cifVO.CIF_TYPE="+$("#lookuptxt_cifVO_CIF_TYPE_"+_pageRef).val()
				 +"&fomCO.cifVO.KYC_COMPLETED="+cifKYCCompleted
				 +"&fomCO.cifVO.STATUS="+$("#cifVO_STATUS_" + _pageRef).val()
				 +"&isLookUp="+isLookUp
				 +"&fomCO.CifKYCVO.FATCA_COMPLIANT_TYPE="+ $("input:radio[id^=fatcaCompliant]:checked").val()
				 +"&fomCO.isEmptyScreen=1";
	if(cif_no!="")
	{
$.ajax(
		{
		    url:jQuery.contextPath+"/path/fom/FrontOfficeMgntMaint_loadTheValues.action?updates="+screenId,
		 	type:"post",
		 	data:params,
			dataType:"json",
			success: function(data)
			{
		      if(typeof data["_error"] == "undefined" || data["_error"] == null)
		      {         
		    	  //if KYC
		    	  if($("#applyCorporateKycId_"+_pageRef).val()=="0")
		    	  {
		          $("#fatcaCountry_"+_pageRef).val(data["fatcaCountry"]);
		          $("#fomNationality_"+_pageRef).val($("#lookuptxt_cifVO_NATION_CODE_"+_pageRef).val());
		          $("#fatcaCountry_"+_pageRef).trigger("change");
		    	  //filling already existing fields in kyc
		    	  $("[name='fomCO.cifKYCVO.OPENING_ACC_PURPOSE']").val(data["fomCO"]["cifKYCVO"]["OPENING_ACC_PURPOSE"]);  
		    	  $("[name='fomCO.kycOpeningAccPurposeDesc']").val(data["fomCO"]["kycOpeningAccPurposeDesc"]);  
	    	 
		    	  $("[name='fomCO.cifKYCVO.NON_RESIDENT_COUNTRY_NAME']").val(data["fomCO"]["cifKYCVO"]["NON_RESIDENT_COUNTRY_NAME"]); 		
		    	  $("[name='fomCO.cifKYCVO.RESIDENT_BANK_CIF_CODE']").val(data["fomCO"]["cifKYCVO"]["RESIDENT_BANK_CIF_CODE"]);
		    	  $("[name='fomCO.kycResidentBankName']").val(data["fomCO"]["kycResidentBankName"]);

		    	  $("#otherExistingAccRes_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_BANK_ACC"]).attr("checked","checked");
		    	  $("#otherExistingAccRes_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_BANK_ACC"]).trigger("click");
		    	  
		    	  if(data["fomCO"]["cifKYCVO"]["KYC_UPDATE_DATE"]!=null)
		    	  {
			    	  $("[name='fomCO.cifKYCVO.KYC_UPDATE_DATE']").val($.datepicker.formatDate('dd/mm/yy',parseISODateStr(data["fomCO"]["cifKYCVO"]["KYC_UPDATE_DATE"])));
		    	  }
		    	  
		    	 		    	  
		    	  $("[name='fomCO.cifKYCVO.POLITICAL_MEMBER_SPEC']").val(data["fomCO"]["cifKYCVO"]["POLITICAL_MEMBER_SPEC"]); 
		    	  $("#politicalMember_"+_pageRef+data["fomCO"]["cifKYCVO"]["POLITICAL_MEMBER_YN"]).attr("checked","checked");
		    	  $("#politicalMember_"+_pageRef+data["fomCO"]["cifKYCVO"]["POLITICAL_MEMBER_YN"]).trigger("click"); 
//		    	  if(data["fomCO"]["cifKYCVO"]["DATE_ESTABLISHED"]!=null)
//		    	  {	   
//		    		  $("[name='fomCO.cifKYCVO.DATE_ESTABLISHED']").val($.datepicker.formatDate('dd/mm/yy',parseISODateStr(data["fomCO"]["cifKYCVO"]["DATE_ESTABLISHED"])));
//		    	  }
		    	  $("[name='fomCO.cifKYCVO.BUSINESS_ECO_SECTOR_CODE']").val(data["fomCO"]["cifKYCVO"]["BUSINESS_ECO_SECTOR_CODE"]); 
		    	  $("[name='fomCO.kycBusinessEcoSectorDesc']").val(data["fomCO"]["kycBusinessEcoSectorDesc"]); 
		    	  $("#incomeBusiness_"+_pageRef+data["fomCO"]["cifKYCVO"]["INCOME_BUSINESS_YN"]).attr("checked","checked");
		    	  $("#incomeBusiness_"+_pageRef+data["fomCO"]["cifKYCVO"]["INCOME_BUSINESS_YN"]).trigger("click");
		    	  
		    	  $("[name='fomCO.cifKYCVO.ESTIMATED_INCOME_AMOUNT']").val(data["fomCO"]["cifKYCVO"]["ESTIMATED_INCOME_AMOUNT"]); 

		    	  //For PB DATA
		    	  var incomePeriodicity;
		    	  if(data["fomCO"]["cifKYCVO"]["INCOME_PERIODICITY"]=="O")
		    		  {
		    		  	incomePeriodicity="3";
		    		  }
		    	  else  if(data["fomCO"]["cifKYCVO"]["INCOME_PERIODICITY"]=="Y")
		    		  {
		    		  	incomePeriodicity="2";
		    		  }
		    	  else
		    		  {
		    		  	incomePeriodicity=data["fomCO"]["cifKYCVO"]["INCOME_PERIODICITY"];
		    		  }
		    	  
		    	  $("[name='fomCO.cifKYCVO.OTHER_INCOME_SPEC']").val(data["fomCO"]["cifKYCVO"]["OTHER_INCOME_SPEC"]);
		    	  $("#durationRadio_"+_pageRef+incomePeriodicity).attr("checked","checked");
		    	  $("#durationRadio_"+_pageRef+incomePeriodicity).trigger("click");    	  
		    	  
		    	 
		    	  $("[name='fomCO.cifKYCVO.SOURCE_SPEC']").val(data["fomCO"]["cifKYCVO"]["SOURCE_SPEC"]);
		    	  $("#sourceOfWealth_"+_pageRef+data["fomCO"]["cifKYCVO"]["SOURCE_ADDITIONAL_INCOME"]).attr("checked","checked");
		    	  $("#sourceOfWealth_"+_pageRef+data["fomCO"]["cifKYCVO"]["SOURCE_ADDITIONAL_INCOME"]).trigger("click");
		    	  

		    	  
		    	  $("#OTHERPASSYN_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_PASSPORT_YN"]).attr("checked","checked");
		    	  $("[name='fomCO.cifKYCVO.OTHER_PASSPORT_COUNTRY']").val(data["fomCO"]["cifKYCVO"]["OTHER_PASSPORT_COUNTRY"]);
		    	  $("[name='fomCO.countryKYCDesc']").val(data["fomCO"]["countryKYCDesc"]);
		    	  $("#OTHERPASSYN_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_PASSPORT_YN"]).trigger("click");
		    	  
		    	  
		    	  $("#greenCardHolder_"+_pageRef+data["fomCO"]["cifKYCVO"]["PERM_RESID_OR_GREENCARD_YN"]).attr("checked","checked");
		    	  $("[name='fomCO.cifKYCVO.PERM_RESID_COUNTRY_CODE']").val(data["fomCO"]["cifKYCVO"]["PERM_RESID_COUNTRY_CODE"]);
		    	  $("[name='fomCO.kycGreenCardCountryDesc']").val(data["fomCO"]["kycGreenCardCountryDesc"]);
		    	  $("[name='fomCO.cifKYCVO.PERM_RESID_ID_NO']").val(data["fomCO"]["cifKYCVO"]["PERM_RESID_ID_NO"]);		    	  
		    	  $("#greenCardHolder_"+_pageRef+data["fomCO"]["cifKYCVO"]["PERM_RESID_OR_GREENCARD_YN"]).trigger("click");
		    	  

		    	  $("#countryOtherNationality_"+_pageRef+data["fomCO"]["cifKYCVO"]["LONG_STAY_IN_COUNTRY_YN"]).attr("checked","checked");
		    	  $("[name='fomCO.cifKYCVO.LONG_STAY_COUNTRY_CODE']").val(data["fomCO"]["cifKYCVO"]["LONG_STAY_COUNTRY_CODE"]);
		    	  $("[name='fomCO.kycLongStayCountryDesc']").val(data["fomCO"]["kycLongStayCountryDesc"]);
		    	  $("[name='fomCO.cifKYCVO.LONG_STAY_LAST_YEAR_DAY_NO']").val(data["fomCO"]["cifKYCVO"]["LONG_STAY_LAST_YEAR_DAY_NO"]);
		    	  $("[name='fomCO.cifKYCVO.LONG_STAY_THIS_YEAR_DAY_NO']").val(data["fomCO"]["cifKYCVO"]["LONG_STAY_THIS_YEAR_DAY_NO"]);
		    	  $("[name='fomCO.cifKYCVO.OLDER_DAYS']").val(data["fomCO"]["cifKYCVO"]["OLDER_DAYS"]);
		    	  $("#countryOtherNationality_"+_pageRef+data["fomCO"]["cifKYCVO"]["LONG_STAY_IN_COUNTRY_YN"]).trigger("click");		    	  
		    	 
		    	  
		    	  $("#areYouTaxPayer_"+_pageRef+data["fomCO"]["cifKYCVO"]["TAX_PAYER_ANY_COUNTRY_YN"]).attr("checked","checked");
		    	  $("[name='fomCO.cifKYCVO.TAX_PAYER_COUNTRY_CODE']").val(data["fomCO"]["cifKYCVO"]["TAX_PAYER_COUNTRY_CODE"]);
		    	  $("[name='fomCO.kycTaxPayerCountryDesc']").val(data["fomCO"]["kycTaxPayerCountryDesc"]);
		    	  $("#areYouTaxPayer_"+_pageRef+data["fomCO"]["cifKYCVO"]["TAX_PAYER_ANY_COUNTRY_YN"]).trigger("click");
		    
		    	  
		    	    
		    	  $("#instrOutsideCntr_"+_pageRef+data["fomCO"]["cifKYCVO"]["STAND_INSTR_OUT_COUNTRY_YN"]).attr("checked","checked");
		    	  $("[name='fomCO.cifKYCVO.STAND_INSTR_COUNTRY_CODE']").val(data["fomCO"]["cifKYCVO"]["STAND_INSTR_COUNTRY_CODE"]);
		    	  $("[name='fomCO.kycStandInstrCountryDesc']").val(data["fomCO"]["kycStandInstrCountryDesc"]);	
		    	  $("[name='fomCO.cifKYCVO.REMITTER_BENEF_NAME']").val(data["fomCO"]["cifKYCVO"]["REMITTER_BENEF_NAME"]);				    	  
		    	  $("[name='fomCO.cifKYCVO.REMITTER_BENEF_NATIONALITY']").val(data["fomCO"]["cifKYCVO"]["REMITTER_BENEF_NATIONALITY"]);
		    	  $("[name='fomCO.kycRemitterBenefNationalityDesc']").val(data["fomCO"]["kycRemitterBenefNationalityDesc"]);	 	  
		    	  $("#instrOutsideCntr_"+_pageRef+data["fomCO"]["cifKYCVO"]["STAND_INSTR_OUT_COUNTRY_YN"]).trigger("click");
		    	  
		    	  
		    	  $("#attorneyRadio_"+_pageRef+data["fomCO"]["cifKYCVO"]["ATTORNEY_OUTSIDE_COUNTRY_YN"]).attr("checked","checked");
		    	  $("[name='fomCO.cifKYCVO.ATTORNEY_OUTSIDE_COUNTRY_CODE']").val(data["fomCO"]["cifKYCVO"]["ATTORNEY_OUTSIDE_COUNTRY_CODE"]);
		    	  $("[name='fomCO.kycAttorneyCountryDesc']").val(data["fomCO"]["kycAttorneyCountryDesc"]);		    	  
		    	  $("#attorneyRadio_"+_pageRef+data["fomCO"]["cifKYCVO"]["ATTORNEY_OUTSIDE_COUNTRY_YN"]).trigger("click");
		    	  
		    	  
		    	  $("#kycCompCall_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMPLETED_BY_CALL_YN"]).attr("checked","checked");
		    	  $("#clientRecall_"+_pageRef+data["fomCO"]["cifKYCVO"]["RELUCTANT_YN"]).attr("checked","checked");

		    	  if($("#sourceOfWealth_"+_pageRef+"fomCO_cifKYCVO_SOURCE_OTHER_YN").val()=='fomCO_cifKYCVO_SOURCE_OTHER_YN')
		    	  {
		    		  $("#sourceWealthOther_"+_pageRef).val("");
		    	  }
		    	  //SELECT APPLY_CORPORATE_KYC_YN FROM RIFCTT WHERE COMP_CODE = 1 AND TYPE_CODE =1  IF(1 YMC).IF 0 KYC
		    	  //end filling existing fields in kyc
		    	  
		    	  
		    	  $("[name='fomCO.kycAddressCountryCode']").val(data["fomCO"]["kycAddressCountryCode"]);
		    	  $("#lookuptxt_specifyCountryLS_"+_pageRef).trigger("change");
		    	  $("[name='fomCO.kycAddressCountryDesc']").val(data["fomCO"]["kycAddressCountryDesc"]);
		    	  $("[name='fomCO.kycAddressPoboxCode']").val(data["fomCO"]["kycAddressPoboxCode"]);
		    	  $("[name='fomCO.kycAddressState']").val(data["fomCO"]["kycAddressState"]);
		    	  $("[name='fomCO.kycAddressGovernate']").val(data["fomCO"]["kycAddressGovernate"]);
		    	  $("[name='fomCO.kycAddressEmail']").val(data["fomCO"]["kycAddressEmail"]);	    	  
		    	  $("[name='fomCO.kycAddressGovernate']").val(data["fomCO"]["kycAddressGovernate"]);	   		    	  
		    	  $("[name='fomCO.kycStreet']").val(data["fomCO"]["kycStreet"]);
		    	  $("[name='fomCO.kycAvenue']").val(data["fomCO"]["kycAvenue"]);
		    	  $("[name='fomCO.kycBlock']").val(data["fomCO"]["kycBlock"]);
		    	  $("[name='fomCO.kycHouseBuildling']").val(data["fomCO"]["kycHouseBuildling"]);
		    	  $("[name='fomCO.kycPoBox']").val(data["fomCO"]["kycPoBox"]);
		    	  $("#addressTelOtherCountry_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_COUNTRY_TEL_ADDRESS_YN"]).attr("checked","checked");
		    	  $("#addressTelOtherCountry_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_COUNTRY_TEL_ADDRESS_YN"]).trigger("click");
		    	  $("#fatcaCompRadio_"+_pageRef+data["fomCO"]["cifKYCVO"]["FATCA_COMPLIANT_TYPE"]).attr("checked","checked");
		    	  $("[name='fomCO.cifKYCVO.INCOME_BUSINESS_COUNTRY']").val(data["fomCO"]["cifKYCVO"]["INCOME_BUSINESS_COUNTRY"]);
		    	  $("[name='fomCO.incomeBusinessCntryDesc']").val(data["fomCO"]["incomeBusinessCntryDesc"]);
		    	  
		    	  $("[name='fomCO.cifKYCVO.SIRON_KYC_STATUS']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_STATUS"]);
		    	  $("[name='fomCO.cifKYCVO.SIRON_KYC_SCORE']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_SCORE"]);
		    	  $("[name='fomCO.cifKYCVO.SIRON_KYC_INSTRUCTION']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_INSTRUCTION"]);
		    	  $("[name='fomCO.cifKYCVO.SIRON_KYC_REASON']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_REASON"]);   	  

		    	  $("#fatcaCompRadio_"+_pageRef+data["fomCO"]["cifKYCVO"]["FATCA_COMPLIANT_TYPE"]).attr("checked","checked");
		    	  
		    	//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
		    		$("#sironHiddenStatus_"+_pageRef).val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_STATUS"])
		    	    $("#sironHiddenStatus_"+_pageRef).trigger("change");
		    	//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
		    	  //filling political and relationship info
		    	  if($("input:radio[id^=politicalMember]:checked").val()=="Y")
		    	  {
		    		  $("[name='fomCO.cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_RELATIONSHIP']").val(data["fomCO"]["cifKycFinancialInfoCO"]["cifKycFinancialInfoVO"]["KYC_FINANCIAL_RELATIONSHIP"]);
		    		  $("[name='fomCO.cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_POLITICAL_POS']").val(data["fomCO"]["cifKycFinancialInfoCO"]["cifKycFinancialInfoVO"]["KYC_FINANCIAL_POLITICAL_POS"]);   
		    		  $("[name='fomCO.cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_RELATIONSHIP']").trigger("change");
		    		  $("[name='fomCO.cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_POLITICAL_POS']").trigger("change");
		    	  }
		    	  }
			      //filling YMC data
			      else
			      {
			    	  
			    	  fillYmcData(data);
			    	//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
			    		$("#sironHiddenStatus_"+_pageRef).val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_STATUS"])
			    	    $("#sironHiddenStatus_"+_pageRef).trigger("change");
			    	//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
			
			    	  $("#lookuptxt_countryForLbl_"+_pageRef).trigger("change");
			      }
		    	  
		    	  setTimeout(function(){   $("[name='fomCO.kycRegion']").val(data["fomCO"]["kycRegion"]);
		    	  $("[name='fomCO.kycRegionDesc']").val(data["fomCO"]["kycRegionDesc"]);
		    	  $("[name='fomCO.kycAddressPostalCode']").val(data["fomCO"]["kycAddressPostalCode"]);
		    	  $("[name='fomCO.kycAddressPostalCodeDesc']").val(data["fomCO"]["kycAddressPostalCodeDesc"]);
		    	  $("[name='fomCO.kycTel']").val(data["fomCO"]["kycTel"]);
		    	  $("[name='fomCO.kycFax']").val(data["fomCO"]["kycFax"]);
		    	  $("[name='fomCO.cifKYCVO.TIN']").val(data["fomCO"]["cifKYCVO"]["TIN"]);
		    	  if(data["fomCO"]["cifKYCVO"]["DATE_ESTABLISHED"]!=null)
		    	  {	   
		    		  $("[name='fomCO.cifKYCVO.DATE_ESTABLISHED']").val($.datepicker.formatDate('dd/mm/yy',parseISODateStr(data["fomCO"]["cifKYCVO"]["DATE_ESTABLISHED"])));
		    	  }
		    	  }, 2000);
		    	  
		    	  var len = data.listKycVOs.length;
		    	  var elementIds = [];
		  		  var elementValues = [];
		  		  var radioBtnCnt=0;
		  		  var livesearchesCnt=0;
		  		  var livesearchesToTrigger = [];
		  		  var checkBoxToTrigger = [];
		  		  var checkBoxToTriggerVal = [];
		  		  var checkBoxCnt=0;
		  		  var chkChecked;
			      for (var i=0; i<len; i++)
			      { 
				       	if($("[name='"+data.listKycVOs[i].ELEMENT_ID+"']").attr('type')=='radio')
				       	{
				       		elementIds[radioBtnCnt] = data.listKycVOs[i].ELEMENT_ID;
				       		elementValues[radioBtnCnt] = data.listKycVOs[i].ELEMENT_VALUE;
				       		radioBtnCnt++;
				        }
				       	else if($("[name='"+data.listKycVOs[i].ELEMENT_ID+"']").attr('type')=='checkbox')
				       	{
				       		checkBoxToTrigger[checkBoxCnt] = data.listKycVOs[i].ELEMENT_ID;
				       		checkBoxToTriggerVal[checkBoxCnt] = data.listKycVOs[i].ELEMENT_VALUE;				       		
				       		checkBoxCnt++;
				        }
				        else
				        {
				        	try
				        	{
					        	if($("[name='"+data.listKycVOs[i].ELEMENT_ID+"']").attr('id')!=null && 
					        			$("[name='"+data.listKycVOs[i].ELEMENT_ID+"']").attr('id').substring(0,9)=='lookuptxt')
					        	{
					        		livesearchesToTrigger[livesearchesCnt] = data.listKycVOs[i].ELEMENT_ID;
					        		livesearchesCnt++;
					        	}
					        	$("[name='"+data.listKycVOs[i].ELEMENT_ID+"']").val(data.listKycVOs[i].ELEMENT_VALUE);
				        	}
				        	catch(e)
				        	{
				        		console.log("dynamic lookups")
				        	}
				        }	
	              }
			      for(var j=0;j<radioBtnCnt;j++)
			      {
			    	  $("input:radio[name='"+elementIds[j]+"'][value='"+elementValues[j]+"']").attr("checked","checked");
			    	  $("input:radio[name='"+elementIds[j]+"'][value='"+elementValues[j]+"']").trigger("click"); 		
			      }	
			      for(var k=0;k<checkBoxCnt;k++)
			      {
			    	  if(checkBoxToTriggerVal[k]==1)
			    	  {
				    	 $("[name='"+checkBoxToTrigger[k]+"']").attr("checked","checked");
				    	 $("[name='"+checkBoxToTrigger[k]+"']").trigger("click");
				    	 $("[name='"+checkBoxToTrigger[k]+"']").removeAttr("checked","checked");
				    	 $("[name='"+checkBoxToTrigger[k]+"']").attr("checked","checked");
			    	  }  
			      }
			      for (var l=0;l<livesearchesCnt;l++)
			      {
			    	  $("[name='"+livesearchesToTrigger[l]+"']").trigger("change");
			      }
			    //#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
		    		$("#sironHiddenStatus_"+_pageRef).val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_STATUS"])
		    	    $("#sironHiddenStatus_"+_pageRef).trigger("change");
		    	//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
		    		
		    		if($('#fomMaint_recReadOnly_' + _pageRef).val() == 'true')
		    		{
		    			var kycDivElements = $("#dyn_preview_screen_div_" + screenId + "_" + _pageRef + " :button");
		    			var len = kycDivElements.length;
		    			for(var i=0; i<=len; i++)
		    			{
		    				$(kycDivElements[i]).removeAttr("disabled");
		    				$(kycDivElements[i]).removeClass("ui-state-disabled");
		    			}
		    		}
		
			   }
		    		 $("[name='fomCO.screenId']").val(data["fomCO"]["screenId"]);   	  
		    		 $("#fatcaCountry_"+_pageRef).val(data["fatcaCountry"]);
		    		 $("#fatcaNationality_"+_pageRef).val(data["fatcaNationality"]);
		    		 $("#fomNationality_"+_pageRef).val( $("#lookuptxt_cifVO_NATION_CODE_"+_pageRef).val());
		    		 $("#disableKycRecalCompByCall_"+_pageRef).val(data["disableKycRecalCompByCall"]);
		    		 $("#disableKycRecalCompByCall_"+_pageRef).trigger("change");
		    		 
		    		 if(data["fatcaNationality"]==$("#lookuptxt_cifVO_NATION_CODE_"+_pageRef).val())
		    			 {
		    			 	var radioId='companyForeignOrRegistered_'+_pageRef+'Y';
		    			 	$("input:radio[ID='"+radioId+"']").attr("checked","checked");
		    			 	$("input:radio[ID='"+radioId+"']").trigger("click"); 	
		    			 	
		    			 	radioId='areYouTaxPayer_'+_pageRef+'Y';
		    			 	$("input:radio[ID='"+radioId+"']").attr("checked","checked");
		    			 	$("input:radio[ID='"+radioId+"']").trigger("click"); 	
		    			 }

			 }
	})
	}
}

//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
function resetSironStatus()
{
	_showProgressBar(true);
	var cif_no = $('#cifVO_CIF_NO_'+ _pageRef).val();
	var comp_code = $('#cifVO_COMP_CODE_'+ _pageRef).val();

	var params   ="_pageRef="+_pageRef 	
	 +"&fomCO.cifKYCVO.CIF_NO="+cif_no
	 +"&fomCO.CifKYCVO.COMP_CODE="+ comp_code;

	$.ajax(
			{
			    url:jQuery.contextPath+"/path/fom/FrontOfficeMgntMaint_resetSironStatus.action?_pageRef="+ _pageRef+"_KYC",
			 	type:"post",
				dataType:"json",
				data:params,
				success: function(data)
				{
    				 if(typeof data["_error"] == "undefined" || data["_error"] == null)
    				 { 
    			     $("[name='fomCO.cifKYCVO.SIRON_KYC_SCORE']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_SCORE"]);
    			     $("[name='fomCO.cifKYCVO.SIRON_KYC_INSTRUCTION']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_INSTRUCTION"]);
    			     $("[name='fomCO.cifKYCVO.SIRON_KYC_REASON']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_REASON"]);
    			     $("[name='fomCO.cifKYCVO.SIRON_KYC_STATUS']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_STATUS"]);


    				 }
    				 _showProgressBar(false);    				 
 					$("#fomMaintForm_" + _pageRef).data("changeTrack", true);//to enable saving after reset
				}
		    });	
	
}
//#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]



function fillYmcData(data)
{
	$("#fatcaCountry_"+_pageRef).val(data["fatcaCountry"]);
	if(data["fomCO"]["cifKYCVO"]["KYC_UPDATE_DATE"]!=null)
	 {
		$("[name='fomCO.cifKYCVO.KYC_UPDATE_DATE']").val($.datepicker.formatDate('dd/mm/yy',parseISODateStr(data["fomCO"]["cifKYCVO"]["KYC_UPDATE_DATE"])));
		
		
	 }
	 //filling siron fields
	 $("[name='fomCO.cifKYCVO.SIRON_KYC_STATUS']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_STATUS"]);
	 $("[name='fomCO.cifKYCVO.SIRON_KYC_SCORE']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_SCORE"]);
	 $("[name='fomCO.cifKYCVO.SIRON_KYC_INSTRUCTION']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_INSTRUCTION"]);
	 $("[name='fomCO.cifKYCVO.SIRON_KYC_REASON']").val(data["fomCO"]["cifKYCVO"]["SIRON_KYC_REASON"]);   	  
	 //filling other fields
	 $("[name='fomCO.cifKYCVO.OPENING_ACC_PURPOSE']").val(data["fomCO"]["cifKYCVO"]["OPENING_ACC_PURPOSE"]);
	 $("[name='fomCO.kycOpeningAccPurposeDesc']").val(data["fomCO"]["kycOpeningAccPurposeDesc"]);
	 $("[name='fomCO.cifKYCVO.RESIDENT_BANK_CIF_CODE']").val(data["fomCO"]["cifKYCVO"]["RESIDENT_BANK_CIF_CODE"]);	
	 $("#lookuptxt_bankName_"+_pageRef).trigger("change");
	 $("[name='fomCO.cifKYCVO.NON_RESIDENT_COUNTRY_NAME']").val(data["fomCO"]["cifKYCVO"]["NON_RESIDENT_COUNTRY_NAME"]);
	 $("[name='fomCO.kycResidentBankName']").val(data["fomCO"]["kycResidentBankName"]);
	 $("#otherExistingAccRes_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_BANK_ACC"]).attr("checked","checked");

	 $("#otherExistingAccRes_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_BANK_ACC"]).trigger("click");
	 
	 $("[name='fomCO.cifKYCVO.STAFF_MEMBER_NAME']").val(data["fomCO"]["cifKYCVO"]["STAFF_MEMBER_NAME"]);
	 $("[name='fomCO.cifKYCVO.STAFF_RELATION_DEGREE']").val(data["fomCO"]["cifKYCVO"]["STAFF_RELATION_DEGREE"]);
	 $("[name='fomCO.cifKYCVO.RECEIVE_INCOME_COUNTRY_CODE']").val(data["fomCO"]["cifKYCVO"]["RECEIVE_INCOME_COUNTRY_CODE"]);
	 $("[name='fomCO.recvIncomeCntryDesc']").val(data["fomCO"]["recvIncomeCntryDesc"]);
	 $("#isAnyOwnersOpt_"+_pageRef+data["fomCO"]["cifKYCVO"]["SIGNATORY_STAFF_RELATIVE_YN"]).attr("checked","checked");
	 $("#isAnyOwnersOpt_"+_pageRef+data["fomCO"]["cifKYCVO"]["SIGNATORY_STAFF_RELATIVE_YN"]).trigger("click");
	 $("[name='fomCO.cifKYCVO.COMP_COUNTRY_CODE']").val(data["fomCO"]["cifKYCVO"]["COMP_COUNTRY_CODE"]);
	 $("[name='fomCO.compCountryDesc']").val(data["fomCO"]["compCountryDesc"]);
	 $("[name='fomCO.cifKYCVO.COMP_LICENSE_NO']").val(data["fomCO"]["cifKYCVO"]["COMP_LICENSE_NO"]);
	 $("[name='fomCO.cifKYCVO.COMP_MEMORANDUM_NO']").val(data["fomCO"]["cifKYCVO"]["COMP_MEMORANDUM_NO"]);
	 $("[name='fomCO.cifKYCVO.COMP_EIN']").val(data["fomCO"]["cifKYCVO"]["COMP_EIN"]);	 
	 $("#companyForeignOrRegistered_"+_pageRef+data["fomCO"]["cifKYCVO"]["FOREIGN_COMPANY_YN"]).attr("checked","checked");
	 $("#companyForeignOrRegistered_"+_pageRef+data["fomCO"]["cifKYCVO"]["FOREIGN_COMPANY_YN"]).trigger("click");
	 $("#compInstJointly_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_OWN_EXCEEDING_PERC_YN"]).attr("checked","checked");
	 $("#compInstJointly_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_OWN_EXCEEDING_PERC_YN"]).trigger("click");
	 $("#foreignPartnerOwnsJointly_"+_pageRef+data["fomCO"]["cifKYCVO"]["PARTNER_EXCEEDING_PERC_YN"]).attr("checked","checked");
	 $("#foreignPartnerOwnsJointly_"+_pageRef+data["fomCO"]["cifKYCVO"]["PARTNER_EXCEEDING_PERC_YN"]).trigger("click");	 
	 $("#compAddForeignCountry_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_FOREIGN_ADDRESS_YN"]).attr("checked","checked");
	 $("#compAddForeignCountry_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_FOREIGN_ADDRESS_YN"]).trigger("click");
	 $("[name='fomCO.kycAddressCountryCode']").val(data["fomCO"]["kycAddressCountryCode"]);
	 $("[name='fomCO.kycAddressCountryDesc']").val(data["fomCO"]["kycAddressCountryDesc"]);	 
	 $("[name='fomCO.kycAddressGovernate']").val(data["fomCO"]["kycAddressGovernate"]);
	 $("[name='fomCO.kycStreet']").val(data["fomCO"]["kycStreet"]);
	 $("[name='fomCO.kycAvenue']").val(data["fomCO"]["kycAvenue"]);	 
	 $("[name='fomCO.kycPoBox']").val(data["fomCO"]["kycPoBox"]);
	 $("[name='fomCO.kycFax']").val(data["fomCO"]["kycFax"]);
	 $("[name='fomCO.kycAddressState']").val(data["fomCO"]["kycAddressState"]);
	 $("[name='fomCO.kycAddressEmail']").val(data["fomCO"]["kycAddressEmail"]);
	 $("[name='fomCO.kycBlock']").val(data["fomCO"]["kycBlock"]);
	 $("[name='fomCO.kycAddressPostalCode']").val(data["fomCO"]["kycAddressPostalCode"]);
	 $("[name='fomCO.kycAddressPostalCodeDesc']").val(data["fomCO"]["kycAddressPostalCodeDesc"]);
	 $("[name='fomCO.kycRegion']").val(data["fomCO"]["kycRegion"]);
	 $("[name='fomCO.kycRegionDesc']").val(data["fomCO"]["kycRegionDesc"]);
	 $("[name='fomCO.kycHouseBuildling']").val(data["fomCO"]["kycHouseBuildling"]);
	 $("[name='fomCO.kycTel']").val(data["fomCO"]["kycTel"]);
	 $("#compStandOrdersAmt_key_"+_pageRef+data["fomCO"]["cifKYCVO"]["SO_FOREIGN_TRANSFER_YN"]).attr("checked","checked");
	 $("#compStandOrdersAmt_key_"+_pageRef+data["fomCO"]["cifKYCVO"]["SO_FOREIGN_TRANSFER_YN"]).trigger("click");
	 $("#personAttorneyOut_"+_pageRef+data["fomCO"]["cifKYCVO"]["ATTORNEY_FOREIGN_ADDRESS_YN"]).attr("checked","checked");
	 $("#personAttorneyOut_"+_pageRef+data["fomCO"]["cifKYCVO"]["ATTORNEY_FOREIGN_ADDRESS_YN"]).trigger("click");
	 $("[name='fomCO.cifKYCVO.COMP_LEGAL_ENTITY']").val(data["fomCO"]["cifKYCVO"]["COMP_LEGAL_ENTITY"]);	 
	 $("#compStockExch_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_STOCK_EXCHANGE_YN"]).attr("checked","checked");
	 $("#compStockExch_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_STOCK_EXCHANGE_YN"]).trigger("click");
	 $("#entitySubsidiary_"+_pageRef+data["fomCO"]["cifKYCVO"]["ENTITY_SUDSIDIARY_YN"]).attr("checked","checked");
	 $("#entitySubsidiary_"+_pageRef+data["fomCO"]["cifKYCVO"]["ENTITY_SUDSIDIARY_YN"]).trigger("click");
	 $("#entityHoldingComp_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_HOLDING_ENTITY_YN"]).attr("checked","checked");
	 $("#entityHoldingComp_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_HOLDING_ENTITY_YN"]).trigger("click");
	 $("[name='fomCO.cifKYCVO.FINANCIAL_INS_CODE']").val(data["fomCO"]["cifKYCVO"]["FINANCIAL_INS_CODE"]);	 
	 setTimeout(function(){
		 $("[name='fomCO.cifKYCVO.PARENT_ENTITY']").val(data["fomCO"]["cifKYCVO"]["PARENT_ENTITY"]);}, 2000);
	 $("[name='fomCO.cifKYCVO.DETAILS_SUBSIDIARY_ENTITIES']").val(data["fomCO"]["cifKYCVO"]["DETAILS_SUBSIDIARY_ENTITIES"]);		 
	 $("[name='fomCO.cifKYCVO.REF_REG_STOCK_EXCHANGE']").val(data["fomCO"]["cifKYCVO"]["REF_REG_STOCK_EXCHANGE"]);	 
	 $("[name='fomCO.cifKYCVO.REGULATOR_ENTITY']").val(data["fomCO"]["cifKYCVO"]["REGULATOR_ENTITY"]);	
	 $("[name='fomCO.cifKYCVO.FINANCIAL_INS_CODE']").val(data["fomCO"]["cifKYCVO"]["FINANCIAL_INS_CODE"]);	
	 $("[name='fomCO.ymcStatusDesc']").val(data["fomCO"]["ymcStatusDesc"]);	
	 $("[name='fomCO.cifKYCVO.EXPECTED_INCOME']").val(data["fomCO"]["cifKYCVO"]["EXPECTED_INCOME"]);	
	 $("[name='fomCO.cifKYCVO.INCOME_FREQUENCY_TYPE']").val(data["fomCO"]["cifKYCVO"]["INCOME_FREQUENCY_TYPE"]);	
	 $("[name='fomCO.cifKYCVO.INCOME_THROUGH']").val(data["fomCO"]["cifKYCVO"]["INCOME_THROUGH"]);	
	 $("[name='fomCO.cifKYCVO.DEPOSIT_THROUGH']").val(data["fomCO"]["cifKYCVO"]["DEPOSIT_THROUGH"]);	
	 $("[name='fomCO.cifKYCVO.SOURCE_WEALTH']").val(data["fomCO"]["cifKYCVO"]["SOURCE_WEALTH"]);	
	 $("[name='fomCO.cifKYCVO.PAID_CAPITAL']").val(data["fomCO"]["cifKYCVO"]["PAID_CAPITAL"]);	
	 $("[name='fomCO.cifKYCVO.INITIAL_DEPOSIT']").val(data["fomCO"]["cifKYCVO"]["INITIAL_DEPOSIT"]);
	 $("[name='fomCO.kycSourceOfWealth']").val(data["fomCO"]["kycSourceOfWealth"]);
	 $("[name='fomCO.depositThroughDesc']").val(data["fomCO"]["depositThroughDesc"]);
	 $("[name='fomCO.incomeThroughDesc']").val(data["fomCO"]["incomeThroughDesc"]);
	 $("[name='fomCO.cifKYCVO.COMP_PHONE_NO']").val(data["fomCO"]["cifKYCVO"]["COMP_PHONE_NO"]);
	 $("[name='fomCO.cifKYCVO.COMP_PHONE_COUNTRY']").val(data["fomCO"]["cifKYCVO"]["COMP_PHONE_COUNTRY"]);
	 $("[name='fomCO.ymcOtherCntryDesc']").val(data["fomCO"]["ymcOtherCntryDesc"]);
	 $("#otherExstingAcc_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_EXIST_BANK_YN"]).attr("checked","checked");
	 $("#otherExstingAcc_"+_pageRef+data["fomCO"]["cifKYCVO"]["OTHER_EXIST_BANK_YN"]).trigger("click");
	 $("#compPhoneOutside_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_PHONE_YN"]).attr("checked","checked");
	 $("#compPhoneOutside_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMP_PHONE_YN"]).trigger("click");
	 $("#fatcaCompRadio_"+_pageRef+data["fomCO"]["cifKYCVO"]["FATCA_COMPLIANT_TYPE"]).attr("checked","checked");
	 $("#kycCompCall_"+_pageRef+data["fomCO"]["cifKYCVO"]["COMPLETED_BY_CALL_YN"]).attr("checked","checked");
	 $("#clientRecall_"+_pageRef+data["fomCO"]["cifKYCVO"]["RELUCTANT_YN"]).attr("checked","checked");
	 $("[name='fomCO.cifKYCVO.TYPE_OF_ACCOUNT']").val(data["fomCO"]["cifKYCVO"]["TYPE_OF_ACCOUNT"]);
	 $("[name='fomCO.ymcTypeOfAccountDesc']").val(data["fomCO"]["ymcTypeOfAccountDesc"]);
	 

	 $("[name='fomCO.cifKYCVO.OTHER_INCOME']").val(data["fomCO"]["cifKYCVO"]["OTHER_INCOME"]);
	 if(data["fomCO"]["cifKYCVO"]["INCOME_INTREST_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.INCOME_INTREST_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["INCOME_RENTS_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.INCOME_RENTS_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["INCOME_CAPITAL_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.INCOME_CAPITAL_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["OTHER_INCOME_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.OTHER_INCOME_YN']").attr("checked","checked");	 
	 }
	 $("#compRecFrgInc_"+_pageRef+data["fomCO"]["cifKYCVO"]["RECEIVE_FOREIGN_INCOME_YN"]).attr("checked","checked");
	 $("#compRecFrgInc_"+_pageRef+data["fomCO"]["cifKYCVO"]["RECEIVE_FOREIGN_INCOME_YN"]).trigger("click");	 

	 //checkboxes
	 if(data["fomCO"]["cifKYCVO"]["PRESIDENT_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.PRESIDENT_PEP_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["HEAD_MILITARY_AUTH_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.HEAD_MILITARY_AUTH_PEP_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["CHIEF_JUDGE_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.CHIEF_JUDGE_PEP_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["HEAD_PUBLIC_AUTH_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.HEAD_PUBLIC_AUTH_PEP_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["PRIME_MINISTER_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.PRIME_MINISTER_PEP_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["DIPLOMAT_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.DIPLOMAT_PEP_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["RELATIVE_WITH_PEP_YN"]==1)
	 {	 
		 $("#relativeAnyAbove_"+_pageRef).trigger("click");
		 setTimeout(function(){ 
		 $("[name='fomCO.cifKYCVO.RELATIVE_WITH_PEP_YN']").attr("checked","checked");	 
		 $("[name='fomCO.cifKYCVO.RELATIVE_NAME']").val(data["fomCO"]["cifKYCVO"]["RELATIVE_NAME"]);   	  
		 $("[name='fomCO.cifKYCVO.RELATIVE_RELATION_NATURE']").val(data["fomCO"]["cifKYCVO"]["RELATIVE_RELATION_NATURE"]);   }, 2000);
	 }
	 if(data["fomCO"]["cifKYCVO"]["PARLIAMENT_SPEAKER_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.PARLIAMENT_SPEAKER_PEP_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["CHAIRMAN_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.CHAIRMAN_PEP_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["CONNECTION_WITH_PEP_YN"]==1)
	 {	 
		 $("#connAnyAbove_"+_pageRef).trigger("click");
		setTimeout(function(){
			 $("[name='fomCO.cifKYCVO.CONNECTION_WITH_PEP_YN']").attr("checked","checked");	 
			 $("[name='fomCO.cifKYCVO.NAME_PEP']").val(data["fomCO"]["cifKYCVO"]["NAME_PEP"]);   	  
			 $("[name='fomCO.cifKYCVO.RELATION_NATURE_PEP']").val(data["fomCO"]["cifKYCVO"]["RELATION_NATURE_PEP"]);   	 
		}, 2000);
	 }
	 if(data["fomCO"]["cifKYCVO"]["HEAD_DEPARTMENT_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.HEAD_DEPARTMENT_PEP_YN']").attr("checked","checked");	 
	 }	 
	 $("[name='fomCO.cifKYCVO.ADDITIONAL_NOTE_PEP']").val(data["fomCO"]["cifKYCVO"]["ADDITIONAL_NOTE_PEP"]);	 
	 $("#signPEP_"+_pageRef+data["fomCO"]["cifKYCVO"]["OWNER_SIGNATORY_PEP_YN"]).attr("checked","checked");
	 $("#signPEP_"+_pageRef+data["fomCO"]["cifKYCVO"]["OWNER_SIGNATORY_PEP_YN"]).trigger("click"); 
	 
	 
	 if(data["fomCO"]["cifKYCVO"]["CONNECTION_WITH_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.CONNECTION_WITH_PEP_YN']").attr("checked","checked");	 
	 }
	 if(data["fomCO"]["cifKYCVO"]["RELATIVE_WITH_PEP_YN"]==1)
	 {	 
		 $("[name='fomCO.cifKYCVO.RELATIVE_WITH_PEP_YN']").attr("checked","checked");	 
	 }
}


function moreSignatory(containingForm)
{
		var mySrc = ctxPath + "/path/fom/FomMoreSignatoryList_populateMoreSignatoryPopup.action";
		dialogOptions = fOM_returnBasicDialogOption(440, 900, More_Signatory_key, true);
		var recReadOnly = !$("#AppFrameLoader_"+_pageRef).contents().find("#fom_recReadOnly_"+_pageRef).val()?$("#fom_recReadOnly_"+_pageRef).val():$("#AppFrameLoader_"+_pageRef).contents().find("#fom_recReadOnly_"+_pageRef).val();
		
	 if($("#iv_crud_"+_pageRef).val() == "R" && $("#originOpt_"+_pageRef).val()=="F00I1MT" && recReadOnly!='true' )
		{
			dialogOptions = $.extend({buttons :{"OK":{"text":Save_key,
			                              		"id" : "fOMMoreSignatory_save_btn_"+_pageRef,			                              		
			                              				  "click": function(){
									                            var _requiredLabels = fOM_requiredLabels("fomMaint_fomSignatory_"+_pageRef);
									                            if(_requiredLabels != "")
									                            {
									                              _showErrorMsg(_requiredLabels,missing_elt_msg_key);
									                              return;
									                            }
									                            // $("#"+containingForm+"_"+_pageRef).val($('#FOMdialogDiv_'+_pageRef).find('input').serialize());
									                            fOMMoreSignatory_onSaveClicked(); 
									                        }},
							                              "Cancel":{"text":Cancel_key,
		                              		"id" : "fOMMoreSignatory_cancel_btn_"+_pageRef,
		                              		"click": function(){
			                              							$(this).dialog("destroy");
			                              						}
			                              		}
	                                          }} , dialogOptions);
		}
		
		fOM_openDialog({"srcURL":mySrc, 
						"params":returnFOMPopupParams(), 
						"options":dialogOptions,
						"callBackParam" : null, 
						"callBackFunc": function (response){ 
							$("#signatoryCO_popupCifNo_" + _pageRef).val($("#cifVO_CIF_NO_" + _pageRef).val());
							$("#signatoryCO_popupCifName_" + _pageRef).val($("#cifVO_SHORT_NAME_ENG_" + _pageRef).val());
						 }
					  });
}


function shareHolderPopup(financialType)
{
	_showProgressBar(true)
    var okButtonTitle = "Save";	
	var moreInfoDivId = "shareholerDivId";
	var dynDialogTitle;
	
	if(financialType==1)
	{
		dynDialogTitle = "Authorized Signatories";
	}
	else if(financialType==5)
	{
		dynDialogTitle = "Shareholders";
	}
	else if(financialType==3)
	{
		dynDialogTitle = "Actual Beneficiaries";
	}
	else if(financialType==2)
	{
		dynDialogTitle = "Custodians";
	}
	else if(financialType==4)
	{
		dynDialogTitle = "Board Members / Managers";
	}
	else if(financialType==8)
	{
		$("#ymc_in_number_div").remove();
		dynDialogTitle = "Foreign Standing Orders";
	}
	else if(financialType==9)
	{
		$("#ymc_in_number_div").remove();
		dynDialogTitle = "Foreign Authorized Signatories";
	}
	else if(financialType==6)
	{
		dynDialogTitle = "Partner Details";
	}
	else if(financialType==7)
	{
		dynDialogTitle = "Foreign Investors - Companies";
	}
	else if(financialType=="A" || financialType=="C")
	{
		dynDialogTitle = "Country";
	}
	else if(financialType=="B")
	{
		dynDialogTitle = "Beneficiary";
	}
	else if(financialType=="T")
	{
		dynDialogTitle = "Power Of Attorney";
	}
	else if(financialType=="H")
	{
		dynDialogTitle = telephone_info_key;
	}
	else if(financialType=="D" || financialType=="E")
	{
		dynDialogTitle = tax_payer_information_key;
	}

	var dialogTitle = dynDialogTitle;	

	
	var reasonDivContent = "<div style='overflow-x:hidden' id='"+ moreInfoDivId +"'><table style='width:100%;height:100%'>"
							+"</div>";	
	var reasonDivElement = $(reasonDivContent);
	
	if($("#" + moreInfoDivId) && $("#" + moreInfoDivId).attr('id') != undefined)
	{
		$("#" + moreInfoDivId).dialog("destroy");
		$("#" + moreInfoDivId).remove();
	}
	
	$('body').append(reasonDivElement);
	reasonDivElement.dialog({
									modal : true,
									title : dialogTitle,
									autoOpen : false,
									position : 'center',
									width : returnMaxWidth(900),
									height : returnMaxHeight(770),
									close : function() {
										if($("#shareholerDivId"))
										{
											$(this).dialog("destroy");
										}										
									}
								});
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_openShareHolderPopup.action?_pageRef="+ _pageRef;
	$(reasonDivElement).load(mySrc, {"update":$("#cifVO_CIF_NO_" + _pageRef).val(),"updates":financialType,
		 "_recReadOnly":$("#fom_recReadOnly_"+ _pageRef).val(),
		 "fomCO.cifVO.CIF_TYPE":$('#lookuptxt_cifVO_CIF_TYPE_'+_pageRef).val(),
		 "fomCO.cifVO.CIF_NO":$('#cifVO_CIF_NO_'+_pageRef).val(),
		 "isLookUp":$("#isLookUp_" + _pageRef).val()}, function()
			 {
			 if(financialType==2)
			 {
				 $("#politicalReq_"+_pageRef).attr("required","required");
				 $("#politicalReq_"+_pageRef).attr("class","required");
			 }	
			 else if(financialType==5 || financialType==4 || financialType==1 || financialType=='H')
			 {
				 $("#outerAddDetailsDiv_"+_pageRef).hide();
			 }
			 else if ( financialType == 'E' ||financialType == 'D'||financialType == 7) {
					$("#outerPepDiv_" + _pageRef).hide();
					
				}
			 $("#financialTypeId_"+_pageRef).val(financialType);
			 //$('#politicallyExposedPerson_'+_pageRef+'0').attr('checked','checked');	
			 ymc_showHideDetails();
			 },_showProgressBar(false));
	
	$(reasonDivElement).dialog("open");
}


function ymc_showHideDetails()
{
	var financialType = $("#financialTypeId_" + _pageRef).val();
	if ($("input[name='cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PEP']:checked").val() == 1)
	{
		$("#relationPolitical_"+_pageRef).attr("style", "display:inline"); 
		$("#lookuptxt_relationship_"+_pageRef).attr("required","required");
		$("#lookuptxt_politicalPositionLkp_"+_pageRef).attr("required","required");
	}
	else
	{
		$("#relationPolitical_"+_pageRef).attr("style", "display:none");
		$("#lookuptxt_relationship_"+_pageRef).removeAttr("required")
		$("#lookuptxt_politicalPositionLkp_"+_pageRef).removeAttr("required")
		$("#lookuptxt_relationship_"+_pageRef).val('');
		$("#lookuptxt_politicalPositionLkp_"+_pageRef).val('');
		$("#politicalPositionDesc_"+_pageRef).val('');		
		if($("#politicallyExposedPerson_"+_pageRef+"1").is(":visible")==false)
		$("#politicalReq_"+_pageRef).attr("style","display:none");
	}
	
	if ($(
	"input[name='cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PEP_CLIENT']:checked")
	.val() == 'Y') {
		$("#clientPolitical_" + _pageRef).attr("style", "display:inline");

		} else {
		$("#clientPolitical_" + _pageRef).attr("style", "display:none");
		$("#lookuptxt_politicalPositionClientLkp_" + _pageRef).val('');
		$("#politicalPositionClientDesc_" + _pageRef).val('');
		}
	

/*	if(financialType=='2')
		{
		$("#outerKycDetailsDiv_" + _pageRef).attr("style", "display:inline");
	*/
	// BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement FALHA

	if ($("input[name='cifKycFinancialInfoCO.cifKycFinancialInfoVO.OTHER_BANK_ACC']:checked")
			.val() == 'R') {
		$("#residentBank_" + _pageRef).attr("style", "display:inline");

		/*$("#lookuptxt_residentBankLkp_" + _pageRef).show();
		$("#residentBankLbl_" + _pageRef).show();
		$("#residentBankDesc_" + _pageRef).show();*/

		$("#countryName_" + _pageRef).hide();
		$("#countryPNameLbl_" + _pageRef).hide();
		$("#countryName_" + _pageRef).val('');
	} else if ($("input[name='cifKycFinancialInfoCO.cifKycFinancialInfoVO.OTHER_BANK_ACC']:checked")
			.val() == 'N') {
		$("#countryPNameLbl_" + _pageRef).show();
		$("#countryName_" + _pageRef).show();

		/*$("#lookuptxt_residentBankLkp_" + _pageRef).hide();
		$("#residentBankLkp_" + _pageRef).hide();
		$("#residentBankLbl_" + _pageRef).hide();
		$("#residentBankDesc_" + _pageRef).hide();*/
		$("#residentBank_" + _pageRef).attr("style", "display:none");

		$("#lookuptxt_residentBankLkp_" + _pageRef).val('');
		$("#residentBankDesc_" + _pageRef).val('');
	} else {
		$("#residentBank_" + _pageRef).attr("style", "display:none");

	/*	$("#lookuptxt_residentBankLkp_" + _pageRef).hide();
		$("#residentBankLkp_" + _pageRef).hide();
		$("#residentBankLbl_" + _pageRef).hide();
		$("#residentBankDesc_" + _pageRef).hide();*/
		
		$("#countryName_" + _pageRef).hide();	
		$("#countryPNameLbl_" + _pageRef).hide();
		
		$("#lookuptxt_residentBankLkp_" + _pageRef).val('');
		$("#residentBankDesc_" + _pageRef).val('');
		$("#countryName_" + _pageRef).val('');

	}

	if ($("input[name='cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_VALTRX']:checked")
			.val() == 1 && financialType=='2') {
		$("#expectedValTrxMon_" + _pageRef).show();
		$("#expectedValTrxYr_" + _pageRef).hide();
		$("#expectedValTrxYr_" + _pageRef).val('');

	} else if ($("input[name='cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_VALTRX']:checked")
			.val() == 2 && financialType=='2') {
		$("#expectedValTrxYr_" + _pageRef).show();

		$("#expectedValTrxMon_" + _pageRef).hide();
		$("#expectedValTrxMon_" + _pageRef).val('');

	}
	else
	{
		$("#expectedValTrxYr_" + _pageRef).hide();
		$("#expectedValTrxYr_" + _pageRef).val('');
		$("#expectedValTrxMon_" + _pageRef).hide();
		$("#expectedValTrxMon_" + _pageRef).val('');
	}	
	
	if ($(
			"input[name='cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_NUMTRX']:checked")
			.val() == 1 && financialType=='2') {
		$("#expectedNumTrxMon_" + _pageRef).show();
		$("#expectedNumTrxYr_" + _pageRef).hide();
		$("#expectedNumTrxYr_" + _pageRef).val('');

	} else if ($(
			"input[name='cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_NUMTRX']:checked")
	.val() == 2 && financialType=='2'){
		$("#expectedNumTrxYr_" + _pageRef).show();

		$("#expectedNumTrxMon_" + _pageRef).hide();
		$("#expectedNumTrxMon_" + _pageRef).val('');

	}
	else
		{
		$("#expectedNumTrxYr_" + _pageRef).attr("style", "display:none");
		$("#expectedNumTrxYr_" + _pageRef).val('');
		$("#expectedNumTrxMon_" + _pageRef).attr("style", "display:none");
		$("#expectedNumTrxMon_" + _pageRef).val('');
		}
	

	if ($(
			"input[name='cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_OTHERS_YN']:checked")
			.val() == 'true') {
		$("#natureTrxOther_" + _pageRef).attr("style", "display:inline");

	} else {
		$("#natureTrxOther_" + _pageRef).attr("style", "display:none");
		$("#natureTrxOther_" + _pageRef).val('');

	}
	 if (financialType == 'E' ||financialType == 'D'||financialType == 7) {
		$("#outerPepDiv_" + _pageRef).hide();
		
	}
	
		/*}
	else
		{
		$("#outerKycDetailsDiv_" + _pageRef).attr("style", "display:none");
		}*/
	// BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement FALHA

	
	// BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement FALHA

	if(_pageRef=='GLBVIEW001')//806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen[FALHA]
	{
		$("#saveRecord_"+_pageRef).hide();
	}
}


function saveYmcFinancialInfo()
{
	_showProgressBar(true);
	$('#fullname_' + _pageRef).val($('#fullname_' + _pageRef).val().replace(/\n/g," "));
	$('#kycFinancAddress_' + _pageRef).val($('#kycFinancAddress_' + _pageRef).val().replace(/\n/g," "));
	$('#financial_street_' + _pageRef).val($('#financial_street_' + _pageRef).val().replace(/\n/g," "));
	var myObject = $("#kycFinancialInfoForm_"+_pageRef).serializeForm(); 
	var financialType=$("#financialTypeId_"+_pageRef).val();
	$.ajax(
			{
			    url:jQuery.contextPath+"/path/fom/fomYmcLookupsAction_saveYmcFinancialInfo.action",
			 	type:"post",
				dataType:"json",
				data:myObject,
				success: function(data)
				{
    				 if(typeof data["_error"] == "undefined" || data["_error"] == null)
    				 { 
    					 if(financialType==5 ||financialType==1 ||financialType==4)
    						 {
    						   $("#financialLineNoId_" + _pageRef).val(data.cifKycFinancialInfoCO.cifKycFinancialInfoVO.LINE_NO);
    						 }
    					 else
    						 {
    						   emptyYmcForm();
    						 }
    					 $("#ymcSharholdersTable_"+_pageRef).trigger("reloadGrid");
    					 //if already contains w9 do not change it
    					 if( $("#fatcaControlCntry_"+_pageRef).val()!="C")
    					 {	
    						 $("#fatcaControlCntry_"+_pageRef).val(data["cifKycFinancialInfoCO"]["KYC_FINANCIAL_BIRTH_COUNTRY_DESC"]);
    					 }
					 openYmcCountryTaxPayerDtlsGrid();	 
    				 }
    				 _showProgressBar(false);
				}
		    });	

}

function ymc_deleteRecord(rowid)
{
 _showConfirmMsg(deleteConfirm, deleteTitle, function(confirmcChoice,
			theArgs)
	{
		if (confirmcChoice)
		{
			ymc_deleteFunc(theArgs.rowid)
		}
	}, {
		rowid : rowid
	}, yes_confirm, no_confirm, 300, 100);	
}

function ymc_deleteFunc(rowid)
{
	_showProgressBar(true);
	 	var rowidModifs = $("#ymcSharholdersTable_"+_pageRef).jqGrid('getGridParam','selrow');
		var myObject 	= $("#ymcSharholdersTable_"+_pageRef).jqGrid('getRowData',rowidModifs);
		params={};
		params["cifKycFinancialInfoCO.cifKycFinancialInfoVO.COMP_CODE"]=myObject["cifKycFinancialInfoVO.COMP_CODE"];
		params["cifKycFinancialInfoCO.cifKycFinancialInfoVO.CIF_NO"]=myObject["cifKycFinancialInfoVO.CIF_NO"];
		params["cifKycFinancialInfoCO.cifKycFinancialInfoVO.LINE_NO"]=myObject["cifKycFinancialInfoVO.LINE_NO"];
		params["cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_TYPE"]=myObject["cifKycFinancialInfoVO.KYC_FINANCIAL_TYPE"];
		var url = jQuery.contextPath+"/path/fom/fomYmcLookupsAction_deleteFinancialInfoRec?_pageRef="+_pageRef
			$.ajax({
			 url: url,
	         type:"post",
			 dataType:"json",
			 data: params,
			 success: function(param)
			 {
			 	$("#ymcSharholdersTable_"+_pageRef).jqGrid('deleteGridRow');
			 	emptyYmcForm();
				 _showProgressBar(false);
			 }
			});
}

function ymc_loadDetails()
{
 	var rowidModifs = $("#ymcSharholdersTable_"+_pageRef).jqGrid('getGridParam','selrow');
	var myObject 	= $("#ymcSharholdersTable_"+_pageRef).jqGrid('getRowData',rowidModifs);
	var financialType = $("#financialTypeId_"+_pageRef).val();
	params={};
	params["cifKycFinancialInfoCO.cifKycFinancialInfoVO.COMP_CODE"]=myObject["cifKycFinancialInfoVO.COMP_CODE"];
	params["cifKycFinancialInfoCO.cifKycFinancialInfoVO.CIF_NO"]=myObject["cifKycFinancialInfoVO.CIF_NO"];
	params["cifKycFinancialInfoCO.cifKycFinancialInfoVO.LINE_NO"]=myObject["cifKycFinancialInfoVO.LINE_NO"];
	params["cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_TYPE"]=myObject["cifKycFinancialInfoVO.KYC_FINANCIAL_TYPE"];
	params["cifKycFinancialInfoCO.openExistingRecord"] = "1";	// BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement FALHA

	params["_recReadOnly"] = $("#fom_recReadOnly_"+ _pageRef).val();
	if(_pageRef=="GLBVIEW001")
	{
		params["_recReadOnly"] = true;
	}
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_openShareHolderMaintPopup.action?_pageRef="+ _pageRef;
	$("#ymc_maintForm_"+_pageRef).load(mySrc,params, function() {
		_showProgressBar(false);
		$("#actionType_"+_pageRef).val("U");
		$("#fcDiv_"+_pageRef).collapsiblePanel();
		
		if(financialType!=5 && financialType!=1 && financialType!=4)
		{
			$("#addDetailsDiv_"+_pageRef).collapsiblePanel();	
		}
		if(myObject["cifKycFinancialInfoVO.KYC_FINANCIAL_TYPE"]==2)
		{
			$("#politicalReq_"+_pageRef).attr("required","required");
			$("#politicalReq_"+_pageRef).attr("class","required");
		}	 		
		ymc_showHideDetails();
		checkTinMandatory();
	});
}

function emptyYmcForm()
{
	var financialType = $("#financialTypeId_"+_pageRef).val();
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_openShareHolderMaintPopup.action?_pageRef="+ _pageRef;
	params={};	
	$("#ymc_maintForm_"+_pageRef).load(mySrc,{"update":$("#cifVO_CIF_NO_" + _pageRef).val(),"updates":$("#updateYmc_"+_pageRef).val()}, function() {
		_showProgressBar(false);
		$("#actionType_"+_pageRef).val("");
		$("#fcDiv_"+_pageRef).collapsiblePanel();
		
		if(financialType!=5 && financialType!=1 && financialType!=4)
			{
				$("#addDetailsDiv_"+_pageRef).collapsiblePanel();
			}
		
		$("#financialTypeId_"+_pageRef).val(financialType);
		if(financialType==2)
		{
			$("#politicalReq_"+_pageRef).attr("required","required");
			$("#politicalReq_"+_pageRef).attr("class","required");
		}	 	
	//	$('#politicallyExposedPerson_'+_pageRef+'0').attr('checked','checked');	
		ymc_showHideDetails();
	});
}

function kycDetails_okKycClicked(screenId)
{
	var _requiredLabels = fOM_requiredLabels("dynScreen_"+screenId+"_FormId_"+_pageRef);
	if(_requiredLabels!="" &&  $("input:radio[id^=politicalMember]:checked").val()=="N")
	{
		var labelObjRelationship = $("label[for='"+$("[name='fomCO.cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_RELATIONSHIP']").attr("id")+"'].required");
		var curElemLabelRelationship = $.trim((labelObjRelationship.text()).replace("*",""));
		var labelObjPoliticalPos = $("label[for='"+$("[name='fomCO.cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_POLITICAL_POS']").attr("id")+"'].required");
		var curElemLabelPoliticalPos = $.trim((labelObjPoliticalPos.text()).replace("*",""));
		_requiredLabels = _requiredLabels.replace(curElemLabelRelationship,"");
		_requiredLabels = _requiredLabels.replace(curElemLabelPoliticalPos,"");
		_requiredLabels = $.trim(_requiredLabels);
	}
	if(_requiredLabels!="")
	{
	  _showErrorMsg(_requiredLabels,missing_elt_msg_key);
      return;
	}
	var kyc_CompletedVal = $("#cifVO_KYC_COMPLETED_"+_pageRef).val();	
	var cif_type =  $("#lookuptxt_cifVO_CIF_TYPE_"+_pageRef).val();
	//var screenId = $("#screenid_"+_pageRef).val();
	$("#screenId_"+_pageRef).val(screenId);
	$.data(document.getElementById($("#fomMaintForm_"+_pageRef).attr("id")),"changeTrack",true); 
	var checkMandatoryAction = jQuery.contextPath+"/path/fom/FrontOfficeMgntMaint_checkFomKYCMandatoryFields?";
	
	 
	
	var jsonParam = {"_pageRef" : _pageRef 
		,"iv_crud" : $("#iv_crud_"+_pageRef).val()
		,"fomCO.cifVO.CIF_TYPE" : cif_type
		,"fomCO.cifKYCVO.TIN": $("#tineinDesc_"+_pageRef).val()//ok			
		,"fomCO.cifVO.KYC_COMPLETED" : kyc_CompletedVal
		,"fomCO.cifVO.CIF_NO":$("#cifVO_CIF_NO_" + _pageRef).val()		
		,"fomCO.cifKYCVO.TAX_PAYER_ANY_COUNTRY_YN": $("input:radio[id^=areYouTaxPayer]:checked").val()//ok
		,"fomCO.cifKYCVO.TAX_PAYER_COUNTRY_CODE":  $("#lookuptxt_countryTaxPayer_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.TIN": $("#taxPayerIdentification_"+_pageRef).val()//ok		
		,"fomCO.cifKYCVO.OTHER_COUNTRY_TEL_ADDRESS_YN": $("input:radio[id^=addressTelOtherCountry]:checked").val()//ok
		,"fomCO.fatcaControlCntry":$("#fatcaControlCntry_"+_pageRef).val()
		,"fomCO.cifVO.LANGUAGE":$("#cifVO_LANGUAGE_" + _pageRef).val()	
		//,"fomCO.additionnalKycProps": $("#dynScreen_"+screenId+"_FormId_"+_pageRef).serialize()
		,"fomCO.screenId":screenId
		
		
		
		,"fomCO.cifKYCVO.OPENING_ACC_PURPOSE": $("#lookuptxt_purposeOfOpeningAcc_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.OTHER_BANK_ACC":$("input:radio[id^=otherExistingAccRes]:checked").val()//ok
		,"fomCO.cifKYCVO.RESIDENT_BANK_CIF_CODE": $("#lookuptxt_bankName_"+_pageRef).val()//ok
		
	
		
		,"fomCO.cifKYCVO.NON_RESIDENT_COUNTRY_NAME": $("#countryNameTxt_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.POLITICAL_MEMBER_YN": $("input:radio[id^=politicalMember]:checked").val()//ok
		,"fomCO.cifKYCVO.POLITICAL_MEMBER_SPEC": $("#politicalMemberSpec_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.INCOME_BUSINESS_YN": $("input:radio[id^=incomeBusiness]:checked").val()//ok
		,"fomCO.cifKYCVO.BUSINESS_ECO_SECTOR_CODE": $("#lookuptxt_economicSec_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.DATE_ESTABLISHED":$("#dateEstablished_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.ESTIMATED_INCOME_AMOUNT": unformatNumber($("#estimatedAmtInc_"+_pageRef).val())//ok
		,"fomCO.cifKYCVO.INCOME_BUSINESS_COUNTRY": $("#lookuptxt_incomeBusinessCntryLS_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.INCOME_PERIODICITY": $("input:radio[id^=durationRadio]:checked").val()//ok
		,"fomCO.cifKYCVO.OTHER_INCOME_SPEC": $("#specifyDuration_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.SOURCE_ADDITIONAL_INCOME":  $("input:radio[id^=sourceOfWealth_]:checked").val()//ok
		,"fomCO.cifKYCVO.SOURCE_SPEC": $("#sourceWealthOther_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.OTHER_PASSPORT_COUNTRY":$("#lookuptxt_OTHERCOUNTRY_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.PERM_RESID_OR_GREENCARD_YN": $("input:radio[id^=greenCardHolder]:checked").val()//ok
		,"fomCO.cifKYCVO.PERM_RESID_COUNTRY_CODE": $("#lookuptxt_gcCountry_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.PERM_RESID_ID_NO": $("#idNoDesc_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.LONG_STAY_IN_COUNTRY_YN": $("input:radio[id^=countryOtherNationality]:checked").val()//ok
		,"fomCO.cifKYCVO.LONG_STAY_COUNTRY_CODE": $("#lookuptxt_otherNationality_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.LONG_STAY_LAST_YEAR_DAY_NO": $("#numberDayLastYearVal_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.LONG_STAY_THIS_YEAR_DAY_NO": $("#nbDaysThisYearLbl_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.OLDER_DAYS" : $("#olderDesc_"+_pageRef).val()//ok 
		,"fomCO.cifKYCVO.TAX_PAYER_ANY_COUNTRY_YN": $("input:radio[id^=areYouTaxPayer]:checked").val()//ok
		,"fomCO.cifKYCVO.TAX_PAYER_COUNTRY_CODE":  $("#lookuptxt_countryTaxPayer_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.TIN": $("#taxPayerIdentification_"+_pageRef).val()//ok		
		,"fomCO.cifKYCVO.OTHER_COUNTRY_TEL_ADDRESS_YN": $("input:radio[id^=addressTelOtherCountry]:checked").val()//ok
		,"fomCO.kycAddressPoboxCode": $("#poBox_"+_pageRef).val()//ok
		,"fomCO.kycAddressCountryCode": $("#lookuptxt_specifyCountryLS_"+_pageRef).val()//ok
		,"fomCO.kycAddressState": $("#stateKey_"+_pageRef).val()//ok
		,"fomCO.kycAddressPostalCode": $("#lookuptxt_postalCodeLS_"+_pageRef).val()//ok
		,"fomCO.kycAddressGovernate": $("#governateVal_"+_pageRef).val()//ok
		,"fomCO.kycAddressEmail": $("#emailArea_"+_pageRef).val()//ok
		,"fomCO.kycRegion": $("#lookuptxt_areaAddress_"+_pageRef).val()//ok
		,"fomCO.kycStreet": $("#streetDesc_"+_pageRef).val()//ok
		,"fomCO.kycAvenue": $("#avenueDesc_"+_pageRef).val()//ok 
		,"fomCO.kycBlock": $("#houseBuildingLbl_"+_pageRef).val()//ok
		,"fomCO.kycPoBox": $("#poBox"+_pageRef).val()//ok
		,"fomCO.kycHouseBuildling":$("#houseBuilding_"+_pageRef).val()//ok
		,"fomCO.kycTel":$("#telNoDesc_"+_pageRef).val()//ok
		,"fomCO.kycFax":$("#faxDesc_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.STAND_INSTR_OUT_COUNTRY_YN": $("input:radio[id^=instrOutsideCntr]:checked").val()//ok
		,"fomCO.cifKYCVO.STAND_INSTR_COUNTRY_CODE": $("#lookuptxt_cntryRemiitterLS_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.COMPLETED_BY_CALL_YN":$("input:radio[id^=kycCompCall]:checked").val()//ok
		,"fomCO.cifKYCVO.RELUCTANT_YN":$("input:radio[id^=clientRecall]:checked").val()//ok
		,"fomCO.cifKYCVO.SIRON_KYC_STATUS":$("#sironKycStatusDrpDwn_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.SIRON_KYC_SCORE":$("#sironKycScore_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.SIRON_KYC_INSTRUCTION":$("#sironKycInstruction_"+_pageRef).val()//ok
		,"fomCO.cifKYCVO.SIRON_KYC_REASON":$("#sironKycReason_"+_pageRef).val()//ok		
		,"fomCO.cifKYCVO.FATCA_COMPLIANT_TYPE":$("input:radio[id^=fatcaCompRadio]:checked").val()
		,"fomCO.cifKYCVO.ATTORNEY_OUTSIDE_COUNTRY_YN": $("input:radio[id^=attorneyRadio]:checked").val()		
		,"fomCO.cifKYCVO.OTHER_PASSPORT_YN" : $("input:radio[id^=OTHERPASSYN]:checked").val()
		
		,"fomCO.cifVO.COUNTRY" 	: $("#lookuptxt_cifVO_COUNTRY_" + _pageRef).val()
		,"fomCO.cifVO.COUNTRY_OF_BIRTH" : $("#lookuptxt_cifVO_COUNTRY_OF_BIRTH_" + _pageRef).val()//#423994	
		,"fomCO.cifVO.NATION_CODE": $("#lookuptxt_cifVO_NATION_CODE_"+_pageRef).val()//recheck
		,"fomCO.crsSignYN": $("input:radio[id^=crsSignYN]:checked").val()	
		
		
		,"fomCO.cif1VO.PASPORT_NO" 				: $("#cifVO1_PASPORT_NO_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_ISSUE_DATE" 	: $("#cifVO1_PASSPORT_ISSUE_DATE_" + _pageRef).val()
		,"fomCO.cif1VO.PASS_ISSUE_DATE_HIJIRI" 	: $("#cifVO1_PASS_ISSUE_DATE_HIJIRI_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_ISSUE_PLACE" 	: $("#cifVO1_PASSPORT_ISSUE_PLACE_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_EXPIRY_DATE" 	: $("#cifVO1_PASSPORT_EXPIRY_DATE_" + _pageRef).val()
		,"fomCO.cif1VO.PASS_EXP_DATE_HIJIRI" 	: $("#cifVO1_PASS_EXP_DATE_HIJIRI_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_NO2" 			: $("#cifVO1_PASSPORT_NO2_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_ISSUE_DATE2" 	: $("#cifVO1_PASSPORT_ISSUE_DATE2_" + _pageRef).val()
		,"fomCO.cif1VO.PASS_ISSUE_DATE2_HIJIRI" : $("#cifVO1_PASS_ISSUE_DATE2_HIJIRI_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_ISSUE_PLACE2" 	: $("#cifVO1_PASSPORT_ISSUE_PLACE2_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_EXPIRY_DATE2" 	: $("#cifVO1_PASSPORT_EXPIRY_DATE2_" + _pageRef).val()
		,"fomCO.cif1VO.PASS_EXP_DATE2_HIJIRI" 	: $("#cifVO1_PASS_EXP_DATE2_HIJIRI_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_NO3" 			: $("#cifVO1_PASSPORT_NO3_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_ISSUE_DATE3" 	: $("#cifVO1_PASSPORT_ISSUE_DATE3_" + _pageRef).val()
		,"fomCO.cif1VO.PASS_ISSUE_DATE3_HIJIRI" : $("#cifVO1_PASS_ISSUE_DATE3_HIJIRI_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_ISSUE_PLACE3" 	: $("#cifVO1_PASSPORT_ISSUE_PLACE3_" + _pageRef).val()
		,"fomCO.cif1VO.PASSPORT_EXPIRY_DATE3" 	: $("#cifVO1_PASSPORT_EXPIRY_DATE3_" + _pageRef).val()
		,"fomCO.cif1VO.PASS_EXP_DATE3_HIJIRI" 	: $("#cifVO1_PASS_EXP_DATE3_HIJIRI_" + _pageRef).val()		
		,"fomCO.fatcaControlCntry":$("#fatcaControlCntry_"+_pageRef).val()
		,"fomCO.cifAddressCO.cifAddressVO.COUNTRY" 	: $("#lookuptxt_addressCO_COUNTRY_" + _pageRef).val()
		};
	
	
	
	//alert(JSON.stringify(jsonParam))
	
	_showProgressBar(true);
	
	$.ajax({
		 url: checkMandatoryAction,
         type:"post",
		 dataType:"json",
		 data: jsonParam,
		 success: function(data){	
			 var complType = data["fomCO"]["cifKYCVO"]["FATCA_COMPLIANT_TYPE"];			 
			 var kycCompleted = data["fomCO"]["cifVO"]["KYC_COMPLETED"];//Abdo Dynamic KYC TP#382751
		
					
		  	 if(typeof data["_error"] == "undefined" || data["_error"] == null)
		     {
		  		 
		  		 //Abdo Dynamic KYC TP#382751 		  		
		  		 $('#cifVO_KYC_COMPLETED_'+_pageRef).val(kycCompleted)
				//NABIL FEGHALI BB140155 KYC new changes
				if(complType == 'B')
				{
					$('#fatcaCompliantW8_'+_pageRef+complType).attr('checked','checked');	
				}
				else if(complType == 'C')
				{
					$('#fatcaCompliantW9_'+_pageRef+complType).attr('checked','checked');
//					onFOMFatcaDetailsButtonClicked(data["fomCO"]["cifFatcaDetailsVO"]);
				}	
				else if(complType == '0')	
				{
					$('#fatcaCompliantNA_'+_pageRef+complType).attr('checked','checked');	
				}
				
				if($("#addressY_"+_pageRef+"Y").is(":checked"))
				{
					if($("#screenLang_"+_pageRef).val()=="EN")
					{
						$("#addressCO_ADDRESS1_ENG_"+_pageRef).val($("#addressState_"+_pageRef).val())  
						$("#addressCO_ADDRESS2_ENG_"+_pageRef).val($("#addressGovernate_"+_pageRef).val())  
					}
				  	else
				  		 {$("#addressCO_ADDRESS1_ARAB_"+_pageRef).val($("#addressGovernate_"+_pageRef).val())  
						$("#addressCO_ADDRESS2_ARAB_"+_pageRef).val($("#addressState_"+_pageRef).val())
					}
					
					$("#lookuptxt_addressCO_COUNTRY_"+_pageRef).val($("#lookuptxt_kycAddressCountry_"+_pageRef).val());
					$("#addressCO_countryDesc_"+_pageRef).val($("#kycAddressCountryDesc_"+_pageRef).val());
					$("#addressCO_PO_BOX_"+_pageRef).val($("#kycAddressPoBox_"+_pageRef).val())
					$("#lookuptxt_addressCO_POSTAL_CODE_"+_pageRef).val($("#lookuptxt_kycAddressPostalCode_"+_pageRef).val())
					$("#addressCO_postalcodeDesc_"+_pageRef).val($("#kycAddressPostalCodeDesc_"+_pageRef).val())
					$("#addressCO_EMAIL_"+_pageRef).val($("#emailArea_"+_pageRef).val());
				}
				//politically exposed
				if($("input:radio[id^=politicalMember]:checked").val()=='Y')
				{
					$("#cifVO_PEPS_"+_pageRef).val("Y");
				}
				else
				{
					$("#cifVO_PEPS_"+_pageRef).val("N");
				}
				//end
				//changing the fatca compliant in case it has been changed on validation
				if($("#additionnalKycProps_"+_pageRef).val()!="")
				{
					additionnalKycPropsValue = $("#additionnalKycProps_"+_pageRef).val();
					var indexStr = additionnalKycPropsValue.indexOf("fomCO.cifKYCVO.FATCA_COMPLIANT_TYPE");
					firstValue = additionnalKycPropsValue.substring(0,indexStr);
					if(indexStr==-1)
					{
						secondValue = additionnalKycPropsValue.substring(indexStr,additionnalKycPropsValue.length);
					}
					else
					{
						secondValue = additionnalKycPropsValue.substring(indexStr+38,additionnalKycPropsValue.length);
					}
					additionnalKycPropsValue = firstValue+secondValue+"&fomCO.cifKYCVO.FATCA_COMPLIANT_TYPE="+data["fomCO"]["cifKYCVO"]["FATCA_COMPLIANT_TYPE"];
					$("#additionnalKycProps_"+_pageRef).val(additionnalKycPropsValue);
				}
				var kycDynScreen = $("#dynScreen_"+screenId+"_FormId_"+_pageRef+"_DivId").pathObjectClone();
				cachePathData("kycData",kycDynScreen);				
				//Commented for BUG 686113 - Hala
				//$("#dyn_preview_screen_div_"+screenId+"_"+_pageRef).dialog("close");
				//$("#dyn_preview_screen_div_"+screenId+"_"+_pageRef).remove();
				$("#FomKYCIsloaded_"+_pageRef).val(1);
				addressPageRef = $("#_addressPageRef_"+_pageRef).val();
				//if($("#addressCO_ADDRESS1_ENG_"+addressPageRef).val()=="" || $("#addressCO_ADDRESS1_ARAB_"+addressPageRef).val()=="")
				//{
					//$("#addressCO_ADDRESS1_ENG_"+addressPageRef).val($("#houseBuildingLbl_"+_pageRef).val());
					//$("#addressCO_ADDRESS2_ENG_"+addressPageRef).val($("#streetDesc_"+_pageRef).val());
					//$("#addressCO_ADDRESS1_ARAB_"+addressPageRef).val($("#houseBuildingLbl_"+_pageRef).val());
					//$("#addressCO_ADDRESS2_ARAB_"+addressPageRef).val($("#streetDesc_"+_pageRef).val());
					//$("#addressCO_TEL_"+addressPageRef).val($("#telNoDesc_"+_pageRef).val());
						      
					//	$("#lookuptxt_addressCO_REGION_"+addressPageRef).val($("#lookuptxt_areaAddress_"+_pageRef).val());
					//$("#lookuptxt_addressCO_COUNTRY_"+addressPageRef).val($("#lookuptxt_specifyCountryLS_"+_pageRef).val());
					//$("#addressCO_FAX_"+addressPageRef).val($("#faxDesc_"+_pageRef).val());
					//$("#addressCO_ADDRESS4_ENG_"+addressPageRef).val($("#houseBuilding_"+_pageRef).val());
					//$("#addressCO_ADDRESS4_ARAB_"+addressPageRef).val($("#houseBuilding_"+_pageRef).val());
					//$("#addressCO_EMAIL_"+addressPageRef).val($("#emailArea_"+_pageRef).val());
					//$("#addressCO_regionDesc_"+addressPageRef).val($("#areaDesc_"+_pageRef).val());
					//$("#addressCO_countryDesc_"+addressPageRef).val($("#specifyCountryDesc_"+_pageRef).val());
					//$("#addressCO_STREET_DETAILS_ENG_"+addressPageRef).val($("#streetDesc_"+_pageRef).val());
					//$("#addressCO_STREET_DETAILS_ARAB_"+addressPageRef).val($("#streetDesc_"+_pageRef).val());
				//}
				//BUG 686113 - Hala
				$("#dyn_preview_screen_div_"+screenId+"_"+_pageRef).dialog("close");
				$("#dyn_preview_screen_div_"+screenId+"_"+_pageRef).remove();
             }
		  	 else
		  	 {
		  		 //In case of Missing TIN exception
		  		 if(complType == 'C')
				 {
					$('#fatcaCompliantW9_'+_pageRef+complType).attr('checked','checked');
				 }	
		  	 }	 
		 	 _showProgressBar(false);
		 }
    });
}





function ymcDetails_okYmcClicked(screenId)
{
	var _requiredLabels = fOM_requiredLabels("dynScreen_"+screenId+"_FormId_"+_pageRef);
	if(_requiredLabels != "")
	{
	  _showErrorMsg(_requiredLabels,missing_elt_msg_key);
		return;
	}
	
	var kyc_CompletedVal = $("#cifVO_KYC_COMPLETED_"+_pageRef).val();
	var cif_type =  $("#lookuptxt_cifVO_CIF_TYPE_"+_pageRef).val();
	
	$.data(document.getElementById($("#fomMaintForm_"+_pageRef).attr("id")),"changeTrack",true); 
	var checkMandatoryAction = jQuery.contextPath+"/path/fom/FrontOfficeMgntMaint_checkFomKYCMandatoryFields?";
	
	var jsonParam = {"_pageRef" : _pageRef , "iv_crud" : $("#iv_crud_"+_pageRef).val()
			,"fomCO.cifVO.CIF_TYPE" : cif_type
			,"fomCO.cifVO.KYC_COMPLETED" : kyc_CompletedVal
			,"fomCO.cifVO.CIF_NO":$("#cifVO_CIF_NO_" + _pageRef).val()	
			,"fomCO.cifVO.LANGUAGE":$("#cifVO_LANGUAGE_" + _pageRef).val()	
			,"fomCO.additionnalKycProps": $("#dynScreen_"+screenId+"_FormId_"+_pageRef).serialize()
			,"fomCO.screenId":screenId
			
			,"fomCO.cifKYCVO.OPENING_ACC_PURPOSE": $("#lookuptxt_purposeOfOpeningAcc_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.OTHER_BANK_ACC":$("input:radio[id^=otherExistingAccRes]:checked").val()//$("#lookuptxt_otherExistingAccRes_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.RESIDENT_BANK_CIF_CODE": $("#lookuptxt_bankName_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.NON_RESIDENT_COUNTRY_NAME": $("#countryNameTxt_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.POLITICAL_MEMBER_YN": $("input:radio[id^=politicalMember]:checked").val()//ok
			,"fomCO.cifKYCVO.POLITICAL_MEMBER_SPEC": $("#politicalMemberSpec_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.INCOME_BUSINESS_YN": $("input:radio[id^=incomeBusiness]:checked").val()//ok
			,"fomCO.cifKYCVO.BUSINESS_ECO_SECTOR_CODE": $("#lookuptxt_economicSec_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.DATE_ESTABLISHED":$("#dateEstablished_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.ESTIMATED_INCOME_AMOUNT": unformatNumber($("#estimatedAmtInc_"+_pageRef).val())//ok
			,"fomCO.cifKYCVO.INCOME_PERIODICITY": $("input:radio[id^=durationRadio]:checked").val()//ok
			,"fomCO.cifKYCVO.OTHER_INCOME_SPEC": $("#specifyDuration_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.SOURCE_ADDITIONAL_INCOME":  $("input:radio[id^=sourceOfWealth_]:checked").val()//ok
			,"fomCO.cifKYCVO.SOURCE_SPEC": $("#sourceWealthOther_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.OTHER_PASSPORT_YN":$("input:radio[id^=OTHER_PASSPORT_YN_]:checked").val()//ok
			,"fomCO.cifKYCVO.OTHER_PASSPORT_COUNTRY":$("#lookuptxt_OTHER_COUNTRY_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.PERM_RESID_OR_GREENCARD_YN": $("input:radio[id^=greenCardHolder]:checked").val()//ok
			,"fomCO.cifKYCVO.PERM_RESID_COUNTRY_CODE": $("#lookuptxt_gcCountry_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.PERM_RESID_ID_NO": $("#idNoDesc_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.LONG_STAY_IN_COUNTRY_YN": $("input:radio[id^=countryOtherNationality]:checked").val()//ok
			,"fomCO.cifKYCVO.LONG_STAY_COUNTRY_CODE": $("#lookuptxt_otherNationality_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.LONG_STAY_LAST_YEAR_DAY_NO": $("#numberDayLastYearVal_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.LONG_STAY_THIS_YEAR_DAY_NO": $("#nbDaysThisYearLbl_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.OLDER_DAYS" : $("#olderDesc_"+_pageRef).val()//ok 
			,"fomCO.cifKYCVO.TAX_PAYER_ANY_COUNTRY_YN": $("input:radio[id^=areYouTaxPayer]:checked").val()//ok
			,"fomCO.cifKYCVO.TAX_PAYER_COUNTRY_CODE":  $("#lookuptxt_countryTaxPayer_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.TIN": $("#taxPayerIdentification_"+_pageRef).val()//ok		
			,"fomCO.cifKYCVO.OTHER_COUNTRY_TEL_ADDRESS_YN": $("input:radio[id^=addressTelOtherCountry]:checked").val()//ok
			,"fomCO.kycAddressPoboxCode": $("#poBox_"+_pageRef).val()//ok
			,"fomCO.kycAddressCountryCode": $("#lookuptxt_specifyCountryLS_"+_pageRef).val()//ok
			,"fomCO.kycAddressState": $("#stateDesc_"+_pageRef).val()//ok
			,"fomCO.kycAddressPostalCode": $("#lookuptxt_postalCodeLS_"+_pageRef).val()//ok
			,"fomCO.kycAddressGovernate": $("#governateDesc_"+_pageRef).val()//ok
			,"fomCO.kycAddressEmail": $("#email_"+_pageRef).val()//ok
			,"fomCO.kycRegion": $("#lookuptxt_areaAddress_"+_pageRef).val()//ok
			,"fomCO.kycStreet": $("#streetDesc_"+_pageRef).val()//ok
			,"fomCO.kycAvenue": $("#avenueDesc_"+_pageRef).val()//ok
			,"fomCO.kycBlock": $("#blockDesc_"+_pageRef).val()//ok
			,"fomCO.kycHouseBuildling":$("#houseDesc_"+_pageRef).val()//ok
			,"fomCO.kycPoBox":$("#poBox_"+_pageRef).val()//ok
			,"fomCO.kycTel":$("#telNo_"+_pageRef).val()//ok
			,"fomCO.kycFax":$("#fax_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.STAND_INSTR_OUT_COUNTRY_YN": $("input:radio[id^=instrOutsideCntr]:checked").val()//ok
			,"fomCO.cifKYCVO.STAND_INSTR_COUNTRY_CODE": $("#lookuptxt_cntryRemiitterLS_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.COMPLETED_BY_CALL_YN":$("input:radio[id^=kycCompCall]:checked").val()//ok
			,"fomCO.cifKYCVO.RELUCTANT_YN":$("input:radio[id^=clientRecall]:checked").val()//ok
			,"fomCO.cifKYCVO.SIRON_KYC_STATUS":$("#sironKycStatusDrpDwn_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.SIRON_KYC_SCORE":$("#sironKycScore_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.SIRON_KYC_INSTRUCTION":$("#sironKycInstruction_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.SIRON_KYC_REASON":$("#sironKycReason_"+_pageRef).val()//ok		
			
			,"fomCO.cifKYCVO.ATTORNEY_OUTSIDE_COUNTRY_YN": $("input:radio[id^=attorneyRadio]:checked").val()		
			,"fomCO.cifKYCVO.OTHER_PASSPORT_YN" : $("input:radio[id^=OTHER_PASSPORT_YN]:checked").val()
			,"fomCO.crsSignYN": $("input:radio[id^=crsSignYN]:checked").val()	
			,"fomCO.cifVO.COUNTRY" 	: $("#lookuptxt_cifVO_COUNTRY_" + _pageRef).val()
			,"fomCO.cifVO.COUNTRY_OF_BIRTH" : $("#lookuptxt_cifVO_COUNTRY_OF_BIRTH_" + _pageRef).val()//#423994	
			,"fomCO.cifVO.NATION_CODE": $("#lookuptxt_cifVO_NATION_CODE_"+_pageRef).val()//recheck	
			,"fomCO.cifKYCVO.OWNER_SIGNATORY_PEP_YN": $("input:radio[id^=signPEP]:checked").val()//ok
			,"fomCO.cifKYCVO.PRESIDENT_PEP_YN":$("#presidentChk_"+_pageRef).is(':checked')=='true'?1:0//checkbox
			,"fomCO.cifKYCVO.HEAD_MILITARY_AUTH_PEP_YN":$("#headMilAutChk_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.CHIEF_JUDGE_PEP_YN":$("#chiefJudgeAttorney_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.HEAD_PUBLIC_AUTH_PEP_YN":$("#headIndAutChk_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.PRIME_MINISTER_PEP_YN":$("#primeMinisterChk_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.DIPLOMAT_PEP_YN":$("#diplomat_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.RELATIVE_WITH_PEP_YN":$("#relativeAnyAbove_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.HEAD_DEPARTMENT_PEP_YN":$("#headExeCompChk_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.PARLIAMENT_SPEAKER_PEP_YN":$("#parliamentSpMbChk_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.CHAIRMAN_PEP_YN":$("#charimanInterOrg_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.CONNECTION_WITH_PEP_YN":$("#connAnyAbove_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.SIGNATORY_STAFF_RELATIVE_YN":$("input:radio[id^=isAnyOwnersOpt]:checked").val()
			,"fomCO.cifKYCVO.STAFF_MEMBER_NAME":$("#pleaseSpecStaffDesc_"+_pageRef).val()
			,"fomCO.cifKYCVO.STAFF_RELATION_DEGREE":$("#degreeRelDesc_"+_pageRef).val()
			,"fomCO.cifKYCVO.RECEIVE_FOREIGN_INCOME_YN":$("input:radio[id^=compRecFrgInc]:checked").val()
			,"fomCO.cifKYCVO.RECEIVE_INCOME_COUNTRY_CODE":$("#lookuptxt_recvIncCountryCode_"+_pageRef).val()
			,"fomCO.cifKYCVO.INCOME_INTREST_YN":$("#incomeTypeChk_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.INCOME_RENTS_YN":$("#receivedInterestChk_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.INCOME_CAPITAL_YN":$("#receivedRentsChk_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.OTHER_INCOME_YN":$("#capitalIncChk_"+_pageRef).is(':checked')==true?1:0//checkbox
			,"fomCO.cifKYCVO.OTHER_INCOME":$("#specifyOtherDesc_"+_pageRef).val()
			,"fomCO.cifKYCVO.FOREIGN_COMPANY_YN":$("input:radio[id^=companyForeignOrRegistered]:checked").val()
			,"fomCO.cifKYCVO.COMP_COUNTRY_CODE":$("#lookuptxt_compForeignRegLS_"+_pageRef).val()
			,"fomCO.cifKYCVO.COMP_LICENSE_NO":$("#licenseNoDesc_"+_pageRef).val()
			,"fomCO.cifKYCVO.COMP_MEMORANDUM_NO":$("#memorandumDesc_"+_pageRef).val()
			,"fomCO.cifKYCVO.COMP_EIN":$("#tineinDesc_"+_pageRef).val()		
			,"fomCO.cifKYCVO.COMP_OWN_EXCEEDING_PERC_YN":$("input:radio[id^=compInstJointly]:checked").val()
			,"fomCO.cifKYCVO.PARTNER_EXCEEDING_PERC_YN":$("input:radio[id^=foreignPartnerOwnsJointly]:checked").val()		
			,"fomCO.cifKYCVO.COMP_FOREIGN_ADDRESS_YN":$("input:radio[id^=compAddForeignCountry]:checked").val()		
			,"fomCO.kycAddressCountryCode":$("#lookuptxt_countryForLbl_"+_pageRef).val()		
			,"fomCO.cifKYCVO.SO_FOREIGN_TRANSFER_YN":$("input:radio[id^=compStandOrdersAmt_key]:checked").val()
			,"fomCO.cifKYCVO.ATTORNEY_FOREIGN_ADDRESS_YN":$("input:radio[id^=personAttorneyOut]:checked").val()
			,"fomCO.cifKYCVO.COMP_LEGAL_ENTITY":$("#legalEntityReg_"+_pageRef).val()
			,"fomCO.cifKYCVO.COMP_STOCK_EXCHANGE_YN": $("input:radio[id^=compStockExch]:checked").val()		
			,"fomCO.cifKYCVO.REF_REG_STOCK_EXCHANGE":$("#specRefRegNo_"+_pageRef).val()
			,"fomCO.cifKYCVO.REGULATOR_ENTITY":$("#regAutoEntSubject_"+_pageRef).val()
			,"fomCO.cifKYCVO.ENTITY_SUDSIDIARY_YN":$("input:radio[id^=entitySubsidiary]:checked").val()
			,"fomCO.cifKYCVO.PARENT_ENTITY":$("#detailsParentEntitity_"+_pageRef).val()
			,"fomCO.cifKYCVO.COMP_HOLDING_ENTITY_YN":$("input:radio[id^=entityHoldingComp]:checked").val()		
			,"fomCO.cifKYCVO.DETAILS_SUBSIDIARY_ENTITIES":$("#detailsSubsidiary_"+_pageRef).val()
			,"fomCO.cifKYCVO.FINANCIAL_INS_CODE":$("#lookuptxt_financialInsCodeLS_"+_pageRef).val()
			,"fomCO.cifKYCVO.EXPECTED_INCOME":$("#expectedIncome_"+_pageRef).val()
			,"fomCO.cifKYCVO.INCOME_FREQUENCY_TYPE":$("#frequency_"+_pageRef).val()
			,"fomCO.cifKYCVO.INCOME_THROUGH":$("#lookuptxt_throughLS_"+_pageRef).val()
			,"fomCO.cifKYCVO.SOURCE_WEALTH":$("#lookuptxt_sourceOfWealthLS_"+_pageRef).val()
			,"fomCO.cifKYCVO.PAID_CAPITAL":$("#paidUpCapital_"+_pageRef).val()
			,"fomCO.cifKYCVO.INITIAL_DEPOSIT":$("#initDeposit_"+_pageRef).val()
			,"fomCO.cifKYCVO.DEPOSIT_THROUGH":$("#lookuptxt_throughSecondLS_"+_pageRef).val()
			,"fomCO.cifKYCVO.OTHER_EXIST_BANK_YN":$("input:radio[id^=otherExstingAcc]:checked").val()
			,"fomCO.cifKYCVO.COMP_PHONE_YN":$("input:radio[id^=compPhoneOutside]:checked").val()
			,"fomCO.cifKYCVO.COMP_PHONE_NO":$("#phoneNumber_"+_pageRef).val()
			,"fomCO.cifKYCVO.COMP_PHONE_COUNTRY":$("#lookuptxt_compPhoneCntryLS_"+_pageRef).val()
			,"fomCO.fatcaControlCntry":$("#fatcaControlCntry_"+_pageRef).val()
			,"fomCO.cifKYCVO.TYPE_OF_ACCOUNT":$("#lookuptxt_typeOfAccountLS_"+_pageRef).val()
			,"fomCO.cifVO.GIIN": $("#cifVO_GIIN_"+_pageRef).val()
			,"fomCO.cifKYCVO.NAME_PEP":$("#name_pep_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.RELATION_NATURE_PEP":$("#relation_nature_pep_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.RELATIVE_NAME":$("#relative_name_"+_pageRef).val()//ok
			,"fomCO.cifKYCVO.RELATIVE_RELATION_NATURE":$("#relative_relation_nature_"+_pageRef).val()//ok
		};
	
	
	
	_showProgressBar(true);
	$.ajax({
		 url: checkMandatoryAction,
         type:"post",
		 dataType:"json",
		 data: jsonParam,
		 success: function(data){
			 var complType = data["fomCO"]["cifKYCVO"]["FATCA_COMPLIANT_TYPE"];
			 var kycCompleted = data["fomCO"]["cifVO"]["KYC_COMPLETED"];
		  	 if(typeof data["_error"] == "undefined" || data["_error"] == null)
		     {

				var ymcDynScreen = $("#dynScreen_"+screenId+"_FormId_"+_pageRef+"_DivId").pathObjectClone();
				cachePathData("ymcData",ymcDynScreen);
				$("#dyn_preview_screen_div_"+screenId+"_"+_pageRef).dialog("close");
				$("#dyn_preview_screen_div_"+screenId+"_"+_pageRef).remove();
				$("#FomKYCIsloaded_"+_pageRef).val(1);
				addressPageRef = $("#_addressPageRef_"+_pageRef).val();
				$('#cifVO_KYC_COMPLETED_'+_pageRef).val(kycCompleted);
				
				if($("#additionnalKycProps_"+_pageRef).val()!="")
				{
					var additionnalKycPropsValue = $("#additionnalKycProps_"+_pageRef).val();
					var indexStr = additionnalKycPropsValue.indexOf("fomCO.cifKYCVO.FATCA_COMPLIANT_TYPE");
					var firstValue = additionnalKycPropsValue.substring(0,indexStr);
					var secondValue;
					if(indexStr==-1)
					{
						secondValue = additionnalKycPropsValue.substring(indexStr,additionnalKycPropsValue.length);
					}
					else
					{
						secondValue = additionnalKycPropsValue.substring(indexStr+38,additionnalKycPropsValue.length);
					}
					additionnalKycPropsValue = firstValue+secondValue+"&fomCO.cifKYCVO.FATCA_COMPLIANT_TYPE="+data["fomCO"]["cifKYCVO"]["FATCA_COMPLIANT_TYPE"];
					$("#additionnalKycProps_"+_pageRef).val(additionnalKycPropsValue);
				}
             }
		 	 _showProgressBar(false);
		 }
    });
}

function ymc_productsToBeIssued()
{
	_showProgressBar(true)
    var okButtonTitle = "Save";	
	var moreInfoDivId = "productsToBeIssuedDivId";
	var dialogTitle = "Products to be issued";	
	var okButton = '<a id="moreInfoDivId_okButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="ymc_saveProductsIssued()">' + okButtonTitle +'</span>' +
						'</a>';
	var cancelButton = '<a id="moreInfoDivId_cancelButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="$(\'#productsToBeIssuedDivId\').dialog(\'close\')">' + cancel_label_trans +'</span>' +
						'</a>';
	
	var reasonDivContent = "<div style='overflow-x:hidden' id='"+ moreInfoDivId +"'><table style='width:100%;height:100%'>"
							+"</div>";	
	var reasonDivElement = $(reasonDivContent);
	
	if($("#" + moreInfoDivId) && $("#" + moreInfoDivId).attr('id') != undefined)
	{
		$("#" + moreInfoDivId).dialog("destroy");
		$("#" + moreInfoDivId).remove();
	}
	
	$('body').append(reasonDivElement);
	reasonDivElement.dialog({
									modal : true,
									title : dialogTitle,
									autoOpen : false,
									position : 'center',
									width : returnMaxWidth(500),
									height : returnMaxHeight(300),
									close : function() {
										if($("#productsToBeIssuedDivId"))
										{
											$(this).dialog("destroy");
										}										
									}
								});
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_openProductsToBeIssuedPopup.action?_pageRef="+ _pageRef;
	$(reasonDivElement).load(mySrc, {"update":$("#cifVO_CIF_NO_" + _pageRef).val()}, function()
			 {
			 $(reasonDivElement).append("<table style='width:100%'><tr><td width='88%'></td><td align='right'>"+okButton+"</td><td align='right'>"+cancelButton+"</td></tr></table>")
			},_showProgressBar(false));
	
	$(reasonDivElement).dialog("open");
}

function ymc_saveProductsIssued()
{
	var action = jQuery.contextPath+"/path/fom/fomYmcLookupsAction_saveYmcProductsIssued.action";
	var myObject={};
	myObject["update"]  = $("#ymcProductsToBeIssuedGrid_"+_pageRef).jqGrid("getAllRows");
	$.ajax({
		url : action,
		type : "post",
		dataType : "json",
		data : myObject,
		success : function(data) {
			if (typeof data["_error"] == "undefined" || data["_error"] == null) 
			{
				$("#productsToBeIssuedDivId").dialog("close");
				$("#productsToBeIssuedDivId").remove();				
			}
		}
	});
}

function ymc_accountDetails()
{
	_showProgressBar(true)
    var okButtonTitle = "Save";	
	var moreInfoDivId = "accountDetailsDivId";
	var dialogTitle = "Account Details";	
	var okButton = '<a id="moreInfoDivId_okButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="ymc_saveAccountDetails()">' + okButtonTitle +'</span>' +
						'</a>';
	var cancelButton = '<a id="moreInfoDivId_cancelButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="$(\'#accountDetailsDivId\').dialog(\'close\')">' + cancel_label_trans +'</span>' +
						'</a>';
	
	var reasonDivContent = "<div style='overflow-x:hidden' id='"+ moreInfoDivId +"'><table style='width:100%;height:100%'>"
							+"</div>";	
	var reasonDivElement = $(reasonDivContent);
	
	if($("#" + moreInfoDivId) && $("#" + moreInfoDivId).attr('id') != undefined)
	{
		$("#" + moreInfoDivId).dialog("destroy");
		$("#" + moreInfoDivId).remove();
	}
	
	$('body').append(reasonDivElement);
	reasonDivElement.dialog({
									modal : true,
									title : dialogTitle,
									autoOpen : false,
									position : 'center',
									width : returnMaxWidth(750),
									height : returnMaxHeight(550),
									close : function() {
										if($("#accountDetailsDivId"))
										{
											$(this).dialog("destroy");
										}										
									}
								});
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_openAccountDetailsPopup.action?_pageRef="+ _pageRef;
	$(reasonDivElement).load(mySrc, {"update":$("#cifVO_CIF_NO_" + _pageRef).val()}, function()
			 {
			 $(reasonDivElement).append("<table style='width:100%'><tr><td width='88%'></td><td align='right'>"+okButton+"</td><td align='right'>"+cancelButton+"</td></tr></table>")
			},_showProgressBar(false));
	
	$(reasonDivElement).dialog("open");
}


function ymcAccDet_onAddClicked()
{
	$("#ymcAccountDetailsGrid_"+_pageRef).jqGrid('addInlineRow',{});
}

function ymcAccDet_onDelClicked(rowId)
{
	$("#ymcAccountDetailsGrid_"+_pageRef).jqGrid('deleteGridRow',rowId);	
}


function ymc_saveAccountDetails() 
{
	var result = $("#ymcAccountDetailsGrid_"+_pageRef).jqGrid('checkRequiredCells');
	if(!result)
	{
		return;
	}
	var action = jQuery.contextPath+"/path/fom/fomYmcLookupsAction_saveYmcAccountDetails.action";
	var myObject={};
	myObject["update"]  = $("#ymcAccountDetailsGrid_"+_pageRef).jqGrid("getAllRows");
	myObject["financialType"] = 'O';
	myObject["updates"] = $("#cifVO_CIF_NO_" + _pageRef).val();
	
	$.ajax({
		url : action,
		type : "post",
		dataType : "json",
		data : myObject,
		success : function(data) {
			if (typeof data["_error"] == "undefined" || data["_error"] == null) 
			{
				$("#accountDetailsDivId").dialog("close");
				$("#accountDetailsDivId").remove();				
			}
		}
	});
}

function ymc_openCompanyFinancial()
{
	_showProgressBar(true)
    var okButtonTitle = "Save";	
	var moreInfoDivId = "companyFinancialDivId";
	var dialogTitle = 	compfinancialfigures_key;	
	var okButton = '<a id="moreInfoDivId_okButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="ymc_saveCompanyFinancialFigures()">' + okButtonTitle +'</span>' +
						'</a>';
	var cancelButton = '<a id="moreInfoDivId_cancelButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="$(\'#companyFinancialDivId\').dialog(\'close\')">' + cancel_label_trans +'</span>' +
						'</a>';
	
	var reasonDivContent = "<div style='overflow-x:hidden' id='"+ moreInfoDivId +"'><table style='width:100%;height:100%'>"
							+"</div>";	
	var reasonDivElement = $(reasonDivContent);
	
	if($("#" + moreInfoDivId) && $("#" + moreInfoDivId).attr('id') != undefined)
	{
		$("#" + moreInfoDivId).dialog("destroy");
		$("#" + moreInfoDivId).remove();
	}
	
	$('body').append(reasonDivElement);
	reasonDivElement.dialog({
									modal : true,
									title : dialogTitle,
									autoOpen : false,
									position : 'center',
									width : returnMaxWidth(730),
									height : returnMaxHeight(250),
									close : function() {
										if($("#companyFinancialDivId"))
										{
											$(this).dialog("destroy");
										}										
									}
								});
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_openCompanyFinancialFiguresPopup.action?_pageRef="+ _pageRef;
	$(reasonDivElement).load(mySrc, {"update":$("#cifVO_CIF_NO_" + _pageRef).val()}, function()
			 {
			 $(reasonDivElement).append("<table style='width:100%'><tr><td width='88%'></td><td align='right'>"+okButton+"</td><td align='right'>"+cancelButton+"</td></tr></table>")
			},_showProgressBar(false));
	
	$(reasonDivElement).dialog("open");
}

function ymc_saveCompanyFinancialFigures()
{
	var action = jQuery.contextPath+"/path/fom/fomYmcLookupsAction_saveCompanyFinancialFigures.action?updates="+$("#cifVO_CIF_NO_"+_pageRef).val();
	var myObject= $("#financialFiguresForm_"+_pageRef).serializeForm();	
	$.ajax({
		url : action,
		type : "post",
		dataType : "json",
		data : myObject,
		success : function(data) {
			if (typeof data["_error"] == "undefined" || data["_error"] == null) 
			{
				$("#companyFinancialDivId").dialog("close");
				$("#companyFinancialDivId").remove();				
			}
		}
	});
}

function ymc_commonPopup(financialType,dialogTitle)
{
	_showProgressBar(true)
    var okButtonTitle = "Save";	
	var moreInfoDivId = "commonInfoDivId";
	var okButton = '<a id="'+moreInfoDivId+'_okButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="ymc_saveCommonPopup(\''+financialType+'\')">' + okButtonTitle +'</span>' +
						'</a>';
	var cancelButton = '<a id="'+moreInfoDivId+'_cancelButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="$(\'#'+moreInfoDivId+'\').dialog(\'close\')">' + cancel_label_trans +'</span>' +
						'</a>';
	
	var reasonDivContent = "<div style='overflow-x:hidden' id='"+ moreInfoDivId +"'><table style='width:100%;height:100%'>"
							+"</div>";	
	var reasonDivElement = $(reasonDivContent);
	
	if($("#" + moreInfoDivId) && $("#" + moreInfoDivId).attr('id') != undefined)
	{
		$("#" + moreInfoDivId).dialog("destroy");
		$("#" + moreInfoDivId).remove();
	}
	
	$('body').append(reasonDivElement);
	reasonDivElement.dialog({
									modal : true,
									title : dialogTitle,
									autoOpen : false,
									position : 'center',
									width : returnMaxWidth(750),
									height : returnMaxHeight(550),
									close : function() {
										if($("#"+moreInfoDivId))
										{
											$(this).dialog("destroy");
										}										
									}
								});
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_openCommonGridPopup.action?_pageRef="+ _pageRef;
	$(reasonDivElement).load(mySrc, {"update":$("#cifVO_CIF_NO_" + _pageRef).val(),"updates":financialType,
		 "_recReadOnly":$("#fom_recReadOnly_"+ _pageRef).val(),
		 "isLookUp":$("#isLookUp_" + _pageRef).val()}, function()
			 {
			 $(reasonDivElement).append("<table style='width:100%'><tr><td width='88%'></td><td align='right'>"+okButton+"</td><td align='right'>"+cancelButton+"</td></tr></table>")
			},_showProgressBar(false));
	
	$(reasonDivElement).dialog("open");
}


function ymc_saveCommonPopup(financialType){
	var result = $("#ymcCommonGrid_"+_pageRef).jqGrid('checkRequiredCells');
	if(!result)
	{
		return;
	}
	var action = jQuery.contextPath+"/path/fom/fomYmcLookupsAction_saveFinancialInfoDetail.action";
	var myObject={};
	myObject["update"]  = $("#ymcCommonGrid_"+_pageRef).jqGrid("getAllRows");
	myObject["updates"] = $("#cifVO_CIF_NO_" + _pageRef).val();
	myObject["financialType"] = financialType;

	$.ajax({
		url : action,
		type : "post",
		dataType : "json",
		data : myObject,
		success : function(data) {
			if (typeof data["_error"] == "undefined" || data["_error"] == null) 
			{
				$("#commonInfoDivId").dialog("close");
				$("#commonInfoDivId").remove();				
			}
		}
	});
}
function ymc_common_onAddClicked()
{
	$("#ymcCommonGrid_"+_pageRef).jqGrid('addInlineRow',{});
}

function ymc_common_onDelClicked(rowId)
{
	$("#ymcCommonGrid_"+_pageRef).jqGrid('deleteGridRow',rowId);	
}


function ymc_inPopup(param) 
{
	var	in_number_div ="",okButton ="",okButtonTitle = "",financialType= "",cifNo="";
    
	if(param=='kycIn')
		{
		  okButtonTitle = "Save";
		  in_number_div = $("<div id='kyc_in_number_div'/>");
		  financialType 	= 'I';
		  okButton = '<a id="kyc_in_number_div_okButton" ' +
			'href="#" ' +
			'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
			'role="button">' +
			'<span class="ui-button-text" onClick="ymc_saveCifCountryInfoPopup(\'kycIn\')">' + okButtonTitle +'</span>' +
			'</a>';
		}
	else
		{
		  okButtonTitle = "Ok";
		  in_number_div = $("<div id='ymc_in_number_div'/>");
		  var fromScr="'"+param+"'";
		  okButton = '<a id="ymc_in_number_div_okButton" ' +
			'href="#" ' +
			'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
			'role="button">' +
			'<span class="ui-button-text" onClick="onYmcBtnOk('+fromScr+')">' + okButtonTitle +'</span>' +
			'</a>';
		}
  
	
	if(param=='ownerShipIn')
		{
			cifNo = $("#lookuptxt_fomOwnershipDetails_AUTH_CIF_NO_" + _pageRef).val();
			$.data(document.getElementById($("#fomMaint_fomOwnership_"+_pageRef).attr("id")),"changeTrack",true); 
		}
	else if(param=='ymcIn') 
		{
			cifNo = $("#lookuptxt_cif_no_" + _pageRef).val();
		}
	else
		{
			cifNo = $("#cifVO_CIF_NO_" + _pageRef).val();
		}
	var recReadOnly 	= $("#fom_recReadOnly_"+ _pageRef).val();
	var lineNo 			= $("#financialLineNoId_"+ _pageRef).val();
	var theBody = $('body');
	in_number_div.insertAfter(theBody);
	
	var mySrc=jQuery.contextPath+"/path/fom/fomYmcLookupsAction_openInGrid.action?_pageRef="+_pageRef;  
  	var curParams={'update': cifNo, 'updates':financialType,'_recReadOnly':recReadOnly,'lineNo':lineNo};
 
	var dialogOptions = {modal:true, title:tax_payer_information_key,
	                    height:returnMaxHeight(350),width:returnMaxWidth(800),
	                    autoOpen:false,
	                    show:'slide',
	                    position:'center',
	                    close   :function(event, ui)
	                    		  {
	                    			$(this).dialog("destroy");
	                              }};  
	if(param=='kycIn')
		{
			$("#ymc_in_number_div").remove();
			$("#kyc_in_number_div").empty().html("");
			$("#kyc_in_number_div").load(mySrc ,curParams, function() {
			$("#kyc_in_number_div").append("<table style='width:100%'><tr><td width='88%'></td><td align='right'>"+okButton+"</td></tr></table>")});
			$("#kyc_in_number_div").dialog( dialogOptions );
			$("#kyc_in_number_div").dialog("open");
		}
	else 
		{
			$("#kyc_in_number_div").remove();
			if($("#ymc_in_number_div").is(':empty') === true) 
			{
				$("#ymc_in_number_div").empty().html("");
				$("#ymc_in_number_div").load(mySrc ,curParams, function() {
				$("#ymc_in_number_div").append("<table style='width:100%'><tr><td width='88%'></td><td align='right'>"+okButton+"</td></tr></table>")});
			}
			$("#ymc_in_number_div").dialog( dialogOptions );
			$("#ymc_in_number_div").dialog("open");
		}
}


function onYmcBtnOk(param)
{
	var result = $("#ymcInGrid_"+_pageRef).jqGrid('checkRequiredCells');
	if(!result)
	{
		return;
	}
	if(param=='ownerShipIn')
	{
		$("#ownerInGridStr_"+_pageRef).val($("#ymcInGrid_"+_pageRef).jqGrid("getAllRows"));
	}
	else
	{
		$("#inGridStr_"+_pageRef).val($("#ymcInGrid_"+_pageRef).jqGrid("getAllRows"));	
	}
	
	$("#ymc_in_number_div").dialog("close");
}

function ymc_InGrid_onAddClicked()
{
	var gridId	= $("#ymcInGrid_" + _pageRef);
	var rowCount = gridId.jqGrid('getDataIDs').length;
	var lastRowId = gridId.jqGrid('getDataIDs')[rowCount - 1];
	
	if (rowCount != 0 && gridId.jqGrid('getCell', lastRowId, 'cifKycFinancialInfoCountryVO.COUNTRY_CODE') == "")
		{
			return;
		}
	
	var rowId =gridId.jqGrid('addInlineRow',{});
	gridId.jqGrid('setSelection',rowId, true);
}

function ymc_InGrid_onDelClicked(rowId)
{
	$("#ymcInGrid_"+_pageRef).jqGrid('deleteGridRow',rowId);	
}





function ymc_openCifCountryInfoPopup()
{
	_showProgressBar(true)
    var okButtonTitle = "Save";	
	var moreInfoDivId = "ymcCifCountryInfoGrid_";
	var okButton = '<a id="'+moreInfoDivId+'_okButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="ymc_saveCifCountryInfoPopup()">' + okButtonTitle +'</span>' +
						'</a>';
	var cancelButton = '<a id="'+moreInfoDivId+'_cancelButton" ' +
						'href="#" ' +
						'class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" ' +
						'role="button">' +
						'<span class="ui-button-text" onClick="$(\'#'+moreInfoDivId+'\').dialog(\'close\')">' + cancel_label_trans +'</span>' +
						'</a>';
	
	var reasonDivContent = "<div style='overflow-x:hidden' id='"+ moreInfoDivId +"'><table style='width:100%;height:100%'>"
							+"</div>";	
	var reasonDivElement = $(reasonDivContent);
	
	if($("#" + moreInfoDivId) && $("#" + moreInfoDivId).attr('id') != undefined)
	{
		$("#" + moreInfoDivId).dialog("destroy");
		$("#" + moreInfoDivId).remove();
	}
	
	$('body').append(reasonDivElement);
	reasonDivElement.dialog({
									modal : true,
									title : residency_information_key,
									autoOpen : false,
									position : 'center',
									width : returnMaxWidth(750),
									height : returnMaxHeight(550),
									close : function() {
										if($("#"+moreInfoDivId))
										{
											$(this).dialog("destroy");
										}										
									}
								});
	var mySrc = ctxPath+"/path/fom/fomYmcLookupsAction_openCifCountryInfoGrid.action?_pageRef="+ _pageRef;
	$(reasonDivElement).load(mySrc, {
			"update":$("#cifVO_CIF_NO_" + _pageRef).val(),
			"_recReadOnly":$("#fom_recReadOnly_"+ _pageRef).val(),
		 	"isLookUp":$("#isLookUp_" + _pageRef).val()}, function()
			 {
			 $(reasonDivElement).append("<table style='width:100%'><tr><td width='88%'></td><td align='right'>"+okButton+"</td><td align='right'>"+cancelButton+"</td></tr></table>")
			},_showProgressBar(false));
	
	$(reasonDivElement).dialog("open");
}


function ymc_saveCifCountryInfoPopup(param)
{
	var result ="",gridData ="",action="";
 
	if(param=='kycIn')
		{
			result= $("#ymcInGrid_"+_pageRef).jqGrid('checkRequiredCells');
			gridData= $("#ymcInGrid_"+_pageRef).jqGrid("getAllRows");
			action = jQuery.contextPath+"/path/fom/fomYmcLookupsAction_savekycInGrid.action"; 
		}
	else
		{
		    result= $("#ymcCifCountryInfoGrid_"+_pageRef).jqGrid('checkRequiredCells');
		    gridData= $("#ymcCifCountryInfoGrid_"+_pageRef).jqGrid("getAllRows");
		    action = jQuery.contextPath+"/path/fom/fomYmcLookupsAction_saveCifCountryInfoGrid.action"; 
		}
	
	if(!result)
	{
		return;
	}
	
	var myObject={};
	myObject["updates"]  = gridData;
	myObject["update"] = $("#cifVO_CIF_NO_" + _pageRef).val();

	$.ajax({
		url : action,
		type : "post",
		dataType : "json",
		data : myObject,
		success : function(data) {
			if (typeof data["_error"] == "undefined" || data["_error"] == null) 
			{
				if(param=='kycIn')
					{
						$("#kyc_in_number_div").dialog("close");
						$("#kyc_in_number_div").remove();		
					}
				else
					{
						$("#ymcCifCountryInfoGrid_").dialog("close");
						$("#ymcCifCountryInfoGrid_").remove();		
					}
			}
		}
	});
}

function ymc_cifCountryInfo_onAddClicked()
{
	var gridId	= $("#ymcCifCountryInfoGrid_" + _pageRef);
	var rowCount = gridId.jqGrid('getDataIDs').length;
	var lastRowId = gridId.jqGrid('getDataIDs')[rowCount - 1];
	
	if (rowCount != 0 && gridId.jqGrid('getCell', lastRowId, 'cifCountryInfoVO.COUNTRY_CODE') == "")
		{
			return;
		}
	
	var rowId =gridId.jqGrid('addInlineRow',{});
	gridId.jqGrid('setSelection',rowId, true);
}

function ymc_cifCountryInfo_onDelClicked(rowId)
{
	$("#ymcCifCountryInfoGrid_"+_pageRef).jqGrid('deleteGridRow',rowId);	
}

function ymcCommonGrid_SelectRowFunc()
{
	onChangeOtherIncome();
}

function  onChangeOtherIncome() 
{
	if($("#updates_" + _pageRef).val()=='F')
		{
			var table = $("#ymcCommonGrid_"+_pageRef);
			var rowId = table.jqGrid("getGridParam", 'selrow');
			var otherIncomeYN = table.jqGrid("getCell",rowId, "cifKycFinancialInfoVO.OTHER_INCOME_YN");
			if(otherIncomeYN==1)
				{
					table.jqGrid('setCellReadOnly', rowId, 'cifKycFinancialInfoVO.OTHER_INCOME', false);
				  	table.jqGrid('setCellRequired', rowId, 'cifKycFinancialInfoVO.OTHER_INCOME', true);
				}
			else
				{
					table.jqGrid('setCellReadOnly', rowId, 'cifKycFinancialInfoVO.OTHER_INCOME', true);
					table.jqGrid('setCellRequired', rowId, 'cifKycFinancialInfoVO.OTHER_INCOME', false);
					table.jqGrid('setCellValue',rowId,"cifKycFinancialInfoVO.OTHER_INCOME",'');	
				}
		}
}

function checkDuplicateId()
{
	var grid = $("#ymcCommonGrid_"+_pageRef);
	var rowdata = grid.jqGrid('getRowData');
	var selectedRowId = grid.jqGrid("getGridParam", 'selrow');
	var selectedRowIndex =	grid.jqGrid('getInd',selectedRowId);
	
	$.each(rowdata, function(index, value) 
	{
		if(index != selectedRowIndex-1) 
		{
			var selected_ID_NO = grid.jqGrid('getCell', selectedRowId,'cifKycFinancialInfoVO.ID_NO');
			var selected_ID_TYPE = grid.jqGrid('getCell', selectedRowId,'cifKycFinancialInfoVO.ID_TYPE');
			
			if(selected_ID_NO == value["cifKycFinancialInfoVO.ID_NO"] && selected_ID_TYPE == value["cifKycFinancialInfoVO.ID_TYPE"]) // Checking CHARGE_CODE
			{
				_showErrorMsg(msg_duplicate_entry_Of_record_key);
				
				grid.jqGrid('setCellValue',selectedRowId,"cifKycFinancialInfoVO.ID_NO","");
				grid.jqGrid('setCellValue',selectedRowId,"cifKycFinancialInfoVO.ID_TYPE","");
				grid.jqGrid('setCellValue',selectedRowId,"idTypeDesc","");
				return;
			}
		}
	});

}

function checkDuplicateCountry()
{
	var grid = $("#ymcCifCountryInfoGrid_"+_pageRef);
	var rowdata = grid.jqGrid('getRowData');
	var selectedRowId = grid.jqGrid("getGridParam", 'selrow');
	var selectedRowIndex =	grid.jqGrid('getInd',selectedRowId);
	
	$.each(rowdata, function(index, value) 
			{
		if(index != selectedRowIndex-1) 
		{
			var selected_COUNTRY_CODE = grid.jqGrid('getCell', selectedRowId,'cifCountryInfoVO.COUNTRY_CODE');
			
			if(selected_COUNTRY_CODE == value["cifCountryInfoVO.COUNTRY_CODE"]) // Checking CHARGE_CODE
			{
				_showErrorMsg(msg_duplicate_entry_Of_record_key);
				
				grid.jqGrid('setCellValue',selectedRowId,"cifCountryInfoVO.COUNTRY_CODE","");
				grid.jqGrid('setCellValue',selectedRowId,"KYC_FINANCIAL_COUNTRY_DESC","");
				grid.jqGrid('setCellValue',selectedRowId,"cifCountryInfoVO.ID_NO","");
				return;
			}
		}
			});
	
}

function checkDuplicateCountryIn()
{
	var grid = $("#ymcInGrid_"+_pageRef);
	var rowdata = grid.jqGrid('getRowData');
	var selectedRowId = grid.jqGrid("getGridParam", 'selrow');
	var selectedRowIndex =	grid.jqGrid('getInd',selectedRowId);
	
	$.each(rowdata, function(index, value) 
			{
		if(index != selectedRowIndex-1) 
		{
			var selected_COUNTRY_CODE = grid.jqGrid('getCell', selectedRowId,'cifKycFinancialInfoCountryVO.COUNTRY_CODE');
			
			if(selected_COUNTRY_CODE == value["cifKycFinancialInfoCountryVO.COUNTRY_CODE"]) // Checking CHARGE_CODE
			{
				_showErrorMsg(msg_duplicate_entry_Of_record_key);
				
				grid.jqGrid('setCellValue',selectedRowId,"cifKycFinancialInfoCountryVO.COUNTRY_CODE","");
				grid.jqGrid('setCellValue',selectedRowId,"KYC_FINANCIAL_COUNTRY_DESC","");
				grid.jqGrid('setCellValue',selectedRowId,"cifKycFinancialInfoCountryVO.ID_NO","");
				return;
			}
		}
			});
	
}

function checkTinMandatory()
{
	if($("#fatcaNationality_"+_pageRef).val()==$("#lookuptxt_financialNationality_"+_pageRef).val()
			|| $("#fatcaCountry_"+_pageRef).val()==$("#lookuptxt_birthCountryLkp_"+_pageRef).val())
		{
		  $("#taxPyerInt_"+_pageRef).attr("required","required");
		  $("#taxPyerIntLabel").attr("class","required");
		}
	else
		{
		  $("#taxPyerInt_"+_pageRef).attr("required",false);
		  $("#taxPyerIntLabel").removeAttr("class")
		}

}

function openKycFOMMoreAddress() 
{
	var fomParams = returnFOMPopupParams();
	fomParams["callingScreen"] = 'FOM';
	fomParams["fromFomKyc"] = true;
	var addrScreenMode = $("#fomAddress_screenMode_" + _pageRef).val();
	fomParams["addrScreenMode"] = addrScreenMode;
	fomParams["addressCO.cifVO.LANGUAGE"] = $("#cifVO_LANGUAGE_" + _pageRef).val();
	
	var mySrc = ctxPath + "/path/moreAddress/moreAddressList_populateMoreAddressPopupforFOM.action";
	
	dialogOptions = fOM_returnBasicDialogOption(600, 950, More_Addresses_key,true);
	
	//Bug --[289609]--This param is added to apply readonly to all popups in FOM ( buttons)
	//If we are opening the popup form an Iframe we retrieve the recoReadonly from the Iframe else we retrieve the value from the FOMMaint.jsp
	var recReadOnly = !$("#AppFrameLoader_"+_pageRef).contents().find("#fom_recReadOnly_"+_pageRef).val()?$("#fom_recReadOnly_"+_pageRef).val():$("#AppFrameLoader_"+_pageRef).contents().find("#fom_recReadOnly_"+_pageRef).val();
	
 if($("#iv_crud_"+_pageRef).val() == "R" && $("#originOpt_"+_pageRef).val()=="F00I1MT" && recReadOnly!='true' )
	{
	dialogOptions = $.extend({buttons :{"OK":{"text":Save_key,
			                              		"id" : "fOMMoreAddress_save_btn_"+_pageRef,
			                              		"click": function(){ 
														var _requiredLabels = fOM_requiredLabels("fomMaint_fomMoreAddressKyc_"+_pageRef+"P");
														if(_requiredLabels != "")
														{
															_showErrorMsg(_requiredLabels,missing_elt_msg_key);
															return;
														}
														fOMMoreAddressKyc_onSaveClicked(); 
												}},
		                                 "Cancel":{"text":Cancel_key,
		                              		"id" : "fOMMoreAddress_cancel_btn_"+_pageRef,
		                              		"click": function(){
			                              							//NABIL FEGHALI - FIX ISSUE 78721
			                              							$(this).dialog("destroy");
			                              						}
			                              		}
	                                          },} , dialogOptions);
	}
	
 _showProgressBar(true);
 $("#FOMdialogDiv_"+_pageRef).remove();
 $("<div>", {id: "FOMdialogDiv_"+_pageRef, padding:"0"}).insertAfter($("#fomMaintForm_" + _pageRef));

 $("#FOMdialogDiv_"+_pageRef).load(mySrc, fomParams, function() {
 $("#FOMdialogDiv_"+_pageRef).dialog(dialogOptions);
 $("#FOMdialogDiv_"+_pageRef).dialog("open");
  
 $("#addressCO_GOVERNERATE_ENG_"+_pageRef+'P').attr("style", "display:inline");
 $("#lbl_addressCO_GOVERNERATE_ENG_"+_pageRef+'P').attr("style", "display:inline");
 $("#addressCO_GOVERNERATE_ARAB_"+_pageRef+'P').attr("style", "display:inline");
 $("#lbl_addressCO_GOVERNERATE_ARAB_"+_pageRef+'P').attr("style", "display:inline");

 _showProgressBar(false);});
 
}

function moreAddressGridTbl_KYC_onDbClicked() {
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
	addrParams["lineNbr"] 			= 	myObject["LINE_NO"];
	addrParams["cifCode"] 			= 	myObject["CIF_NO"];//$("#cifVO_CIF_NO_"+_pageRef).val();
	addrParams["iv_crud"] 			=	$("#iv_crud_" + _pageRef).val();
	addrParams["fromFomKyc"] 		=   true;
	
	linkLoadSrc = jQuery.contextPath  + "/path/moreAddress/moreAddressMaint_showFOMAddressDetails.action";
 
	_showProgressBar(true);
	// action call to load data on hyperlink click with call back function 
	$("#moreAddressKycListDetailDiv_id_" + elmId).load(linkLoadSrc,addrParams, function() {
		 $("#addressCO_GOVERNERATE_ENG_"+elmId).attr("style", "display:inline");
		 $("#lbl_addressCO_GOVERNERATE_ENG_"+elmId).attr("style", "display:inline");
		 $("#addressCO_GOVERNERATE_ARAB_"+elmId).attr("style", "display:inline");
		 $("#lbl_addressCO_GOVERNERATE_ARAB_"+elmId).attr("style", "display:inline");
		_showProgressBar(false);
	});
}

function fOMMoreAddressKyc_onSaveClicked()
{
	var elmId = _pageRef + "P";
	var changes = $("#fomMaint_fomMoreAddressKyc_"+elmId).hasChanges(true);
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
	 
		var cifStatus = $("#cifVO_STATUS_"+ _pageRef).val();
		var cif_UpdateDate = $("#cifVO_DATE_UPDATED_"+ _pageRef).val();
		var cifCode = $("#cifVO_CIF_NO_"+_pageRef).val();
		
		reloadParams["_pageRef"] 			= 	_pageRef;
		reloadParams["iv_crud"] 			=	$("#iv_crud_" + _pageRef).val();
		reloadParams["tellerCanAccessFlag"] =	$("#addressCO_accesByTeller_" + elmId).val();
		reloadParams["callingScreen"]		=   $("#moreAddress_SCREEN_NAME_" + elmId).val();	
		reloadParams["cifCode"]				=   cifCode;
		reloadParams["fromFomKyc"]			=   true;
		
		$("#fomMaint_fomMoreAddressKyc_"+ elmId + "> #auditObj_" + _pageRef).val($("#fomMaintForm_" + _pageRef + "> #auditObj_" + _pageRef).val());
		$("#fomMaint_fomMoreAddressKyc_"+ elmId + "> #auditTrxNbr_" + _pageRef).val($("#fomMaintForm_" + _pageRef + "> #auditTrxNbr_" + _pageRef).val());
		saveAction = jQuery.contextPath+"/path/fom/FOMCommonMaint_saveAddressPopupDetails";
		saveParams = "&saveType=" + saveType +"&cifCode="+cifCode+"&cifStatus="+cifStatus+"&iv_crud="+iv_crud+"&cif_UpdateDate="+cif_UpdateDate+"&addressCO.IS_KYC_YN=1";
		reloadPath = jQuery.contextPath+"/path/moreAddress/moreAddressMaint_showFOMAddressDetails";
	 
		
	var addressForm  = $("#fomMaint_fomMoreAddressKyc_"+elmId).serializeForm();
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
				var theForm = document.getElementById("fomMaint_fomMoreAddressKyc_"+elmId);
				$.data(theForm,"changeTrack",false);
				
				fOMMoreAddressKyc_onAddClicked();
             } 
			 _showProgressBar(false);
		 }
    });
	}
	
}

function fOMMoreAddressKyc_onAddClicked()
{
	var fomParams = returnFOMPopupParams();
	fomParams["callingScreen"] = 'FOM';
	fomParams["fromFomKyc"] = true;
	var addrScreenMode = $("#fomAddress_screenMode_" + _pageRef).val();
	fomParams["addrScreenMode"] = addrScreenMode;
	fomParams["addressCO.cifVO.LANGUAGE"] = $("#cifVO_LANGUAGE_" + _pageRef).val();
	
	var mySrc = ctxPath + "/path/moreAddress/moreAddressList_populateMoreAddressPopupforFOM.action";
	$("#FOMdialogDiv_"+_pageRef).load(mySrc, fomParams, function() {
		  
		 $("#addressCO_GOVERNERATE_ENG_"+_pageRef+'P').attr("style", "display:inline");
		 $("#lbl_addressCO_GOVERNERATE_ENG_"+_pageRef+'P').attr("style", "display:inline");
		 $("#addressCO_GOVERNERATE_ARAB_"+_pageRef+'P').attr("style", "display:inline");
		 $("#lbl_addressCO_GOVERNERATE_ARAB_"+_pageRef+'P').attr("style", "display:inline");
		 });
}
 


function openYmcCountryTaxPayerDtlsGrid(param) 
{
	if($("#financialLineNoId_" + _pageRef).val()=="")
	{
		return;
	}
	
	_showProgressBar(true)
	var ymcCountryTaxPayerDtlsDivId = "ymcCountryTaxPayerDtlsDivId_";
	var divContent = "<div style='overflow-x:hidden' id='"+ ymcCountryTaxPayerDtlsDivId +"'><table style='width:100%;height:100%'>"
							+"</div>";	
	var divElement = $(divContent);
	
	if($("#" + ymcCountryTaxPayerDtlsDivId) && $("#" + ymcCountryTaxPayerDtlsDivId).attr('id') != undefined)
	{
		$("#" + ymcCountryTaxPayerDtlsDivId).dialog("destroy");
		$("#" + ymcCountryTaxPayerDtlsDivId).remove();
	}
	
	$('body').append(divElement);
	divElement.dialog({
									modal : true,
									title : details_key,
									autoOpen : false,
									position : 'center',
									width : returnMaxWidth(900),
									height : returnMaxHeight(600),
									close : function() {
										if($("#"+ymcCountryTaxPayerDtlsDivId) && $("#ymcCountryTaxPayerTable_"+_pageRef).jqGrid('getDataIDs').length > 0)
										{
											$(this).dialog("destroy");
										}
										if($("#ymcCountryTaxPayerTable_"+_pageRef).jqGrid('getDataIDs').length == 0)
										{
											openYmcCountryTaxPayerDtlsGrid();
											_showErrorMsg("Fill mandatory fields");
										}										
									}
								});
	var cifNo=$("#cifVO_CIF_NO_" + _pageRef).val();
	var recReadOnly=$("#fom_recReadOnly_"+ _pageRef).val();
	if(_pageRef=='GLBVIEW001')
	{
		cifNo=$("#lookuptxt_cif_no_"+_pageRef).val();
		var recReadOnly="true";	
	}	
	var mySrc = ctxPath+"/path/fom/fomYmcLookupsAction_openYmcCountryTaxPayerDtlsGrid.action?_pageRef="+ _pageRef;
	$(divElement).load(mySrc, {
			"cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.CIF_NO":cifNo,
			"cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.LINE_NO":$("#financialLineNoId_" + _pageRef).val(),
			"cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.KYC_FINANCIAL_TYPE":$("#financialTypeId_" + _pageRef).val(),
			"_recReadOnly":recReadOnly,
		 	"isLookUp":$("#isLookUp_" + _pageRef).val()}, function()
			 {
				//$('#politicallyExposedPersonDtls_'+_pageRef+'0').attr('checked','checked');	
				$("#politicalReqDtls_"+_pageRef).attr("required","required");
				$("#politicalReqDtls_"+_pageRef).attr("class","required");
				ymc_countryTaxPayerShowHideDetails();
			},_showProgressBar(false));
	
	$(divElement).dialog("open");
}

function ymc_loadCountryTaxPayerDetails()
{
 	var rowidModifs = $("#ymcCountryTaxPayerTable_"+_pageRef).jqGrid('getGridParam','selrow');
	var myObject 	= $("#ymcCountryTaxPayerTable_"+_pageRef).jqGrid('getRowData',rowidModifs);
	params={};
	params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.COMP_CODE"]=myObject["cifKycFinancialInfoDtlsVO.COMP_CODE"];
	params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.CIF_NO"]=myObject["cifKycFinancialInfoDtlsVO.CIF_NO"];
	params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.LINE_NO"]=myObject["cifKycFinancialInfoDtlsVO.LINE_NO"];
	params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.KYC_FINANCIAL_TYPE"]=myObject["cifKycFinancialInfoDtlsVO.KYC_FINANCIAL_TYPE"];
	params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.ID"]=myObject["cifKycFinancialInfoDtlsVO.ID"];
	if(_pageRef=="GLBVIEW001")
	{
		params["_recReadOnly"] = true;
	}
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_loadCountryTaxPayerDetails.action?_pageRef="+ _pageRef;
	$("#ymcCountryTaxPayerFormDiv_"+_pageRef).load(mySrc,params, function() {
		_showProgressBar(false);
		$("#ymcCountryTaxPayerActionType_"+_pageRef).val("U");
		$("#politicalReqDtls_"+_pageRef).attr("required","required");
		$("#politicalReqDtls_"+_pageRef).attr("class","required");
		$("#countryTaxPayerDiv_"+_pageRef).collapsiblePanel();	
		$("#addDtlsDiv_"+_pageRef).collapsiblePanel();	
		ymc_countryTaxPayerShowHideDetails();
		checkCountryTaxPayerTinMandatory();
	});
}


function ymc_countryTaxPayerShowHideDetails()
{
	if ($("input[name='cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.KYC_FINANCIAL_PEP']:checked").val() == 1)
	{
		$("#relationPoliticalDtls_"+_pageRef).attr("style", "display:inline"); 
		$("#lookuptxt_relationshipDtls_"+_pageRef).attr("required","required");
		$("#lookuptxt_politicalPositionDtlsLkp_"+_pageRef).attr("required","required");
		$("#lbl_relationshipDtls_"+_pageRef).attr("class","required");
		$("#lbl_politicalPosition_"+_pageRef).attr("class","required");
	}
	else
	{
		$("#relationPoliticalDtls_"+_pageRef).attr("style", "display:none");
		$("#lookuptxt_relationshipDtls_"+_pageRef).removeAttr("required")
		$("#lookuptxt_politicalPositionDtlsLkp_"+_pageRef).removeAttr("required")
		$("#lookuptxt_relationshipDtls_"+_pageRef).val('');
		$("#lookuptxt_politicalPositionDtlsLkp_"+_pageRef).val('');
		$("#politicalPositionDtlsDesc_"+_pageRef).val('');
	}
	
	var financialType = $("#financialTypeId_"+_pageRef).val();
	
	if(financialType==1 || financialType==4)
	{
		$("#sharesDtls_"+_pageRef).hide();
		$("#sharesPercDtls_"+_pageRef).hide();
		$("#lbl_sharesDtls_"+_pageRef).hide();
		$("#lbl_sharesPercDtls_"+_pageRef).hide();
		if(financialType==4)
		{
			$("#kyc_financial_employer_Dtls_"+_pageRef).hide();
			$("#lbl_kyc_financial_employer_Dtls_"+_pageRef).hide();
		}
	} 
	else if(financialType==5)
	{
		$("#kyc_financial_employer_Dtls_"+_pageRef).hide();
		$("#lbl_kyc_financial_employer_Dtls_"+_pageRef).hide();
		$("#kyc_financial_position_Dtls_"+_pageRef).hide();
		$("#lbl_kyc_financial_position_Dtls_"+_pageRef).hide();
	} 
	if(_pageRef=='GLBVIEW001')//806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen[FALHA]
	{
		$("#saveDtlsRecord_"+_pageRef).hide();
	}
	
}


function checkCountryTaxPayerTinMandatory()
{
	if($("#fatcaNationality_"+_pageRef).val()==$("#lookuptxt_financialNationality_"+_pageRef).val()
			|| $("#fatcaCountry_"+_pageRef).val()==$("#lookuptxt_birthCountryLkp_"+_pageRef).val())
		{
		  $("#taxPyerIntDtls_"+_pageRef).attr("required","required");
		  $("#taxPyerIntDtlsLabel").attr("class","required");
		}
	else
		{
		  $("#taxPyerIntDtls_"+_pageRef).attr("required",false);
		}

}

function saveYmcCountryTaxPayerDtls()
{
	var myObject = $("#ymcCountryTaxPayerForm_"+_pageRef).serializeForm()+
	'&cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.CIF_NO='+$("#cifVO_CIF_NO_" + _pageRef).val()+
	'&cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.KYC_FINANCIAL_TYPE='+$("#financialTypeId_"+_pageRef).val()+
	'&cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.LINE_NO='+$("#financialLineNoId_"+_pageRef).val()+ 
	'&cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.ID='+$("#countryTaxPayerId_"+_pageRef).val()+ 
	'&cifKycFinancialInfoCO.ymcCountryTaxPayerActionType='+$("#ymcCountryTaxPayerActionType_"+_pageRef).val(); 
	$.ajax(
			{
			    url:jQuery.contextPath+"/path/fom/fomYmcLookupsAction_saveYmcCountryTaxPayerDtls.action",
			 	type:"post",
				dataType:"json",
				data:myObject,
				success: function(data)
				{
    				 if(typeof data["_error"] == "undefined" || data["_error"] == null)
    				 { 
    					 emptyCountryTaxPayerDtls();
    					 $("#ymcCountryTaxPayerTable_"+_pageRef).trigger("reloadGrid");
    				 }
				}
		    });	

}

function emptyCountryTaxPayerDtls()
{
	financialType = $("#financialTypeId_"+_pageRef).val();
	var mySrc = ctxPath+"/path/fom/FrontOfficeMgntMaint_loadCountryTaxPayerDetails.action?_pageRef="+ _pageRef;
	params={};	
	$("#ymcCountryTaxPayerFormDiv_"+_pageRef).load(mySrc,{}, function() {
		_showProgressBar(false);
		$("#ymcCountryTaxPayerActionType_"+_pageRef).val("");
		$("#countryTaxPayerDiv_"+_pageRef).collapsiblePanel();	
		$("#addDtlsDiv_"+_pageRef).collapsiblePanel();	
		$("#financialTypeId_"+_pageRef).val(financialType);
		ymc_countryTaxPayerShowHideDetails();
		//$('#politicallyExposedPersonDtls_'+_pageRef+'0').attr('checked','checked');	
		ymc_showHideDetails();
	});
}

function ymc_cntryTaxPayerDtlsDelRecord(rowid)
{
 _showConfirmMsg(deleteConfirm, deleteTitle, function(confirmcChoice,
			theArgs)
	{
		if (confirmcChoice)
		{
			ymc_cntryTaxPayerDtlsDeleteFunc(theArgs.rowid)
		}
	}, {
		rowid : rowid
	}, yes_confirm, no_confirm, 300, 100);	
}

function ymc_cntryTaxPayerDtlsDeleteFunc(rowid)
{
	_showProgressBar(true);
	 	var rowidModifs = $("#ymcCountryTaxPayerTable_"+_pageRef).jqGrid('getGridParam','selrow');
		var myObject 	= $("#ymcCountryTaxPayerTable_"+_pageRef).jqGrid('getRowData',rowidModifs);
		params={};
		params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.COMP_CODE"]=myObject["cifKycFinancialInfoDtlsVO.COMP_CODE"];
		params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.CIF_NO"]=myObject["cifKycFinancialInfoDtlsVO.CIF_NO"];
		params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.LINE_NO"]=myObject["cifKycFinancialInfoDtlsVO.LINE_NO"];
		params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.KYC_FINANCIAL_TYPE"]=myObject["cifKycFinancialInfoDtlsVO.KYC_FINANCIAL_TYPE"];
		params["cifKycFinancialInfoCO.cifKycFinancialInfoDtlsVO.ID"]=myObject["cifKycFinancialInfoDtlsVO.ID"];
		var url = jQuery.contextPath+"/path/fom/fomYmcLookupsAction_deleteCntryTaxPayerDtlsRec?_pageRef="+_pageRef
			$.ajax({
			 url: url,
	         type:"post",
			 dataType:"json",
			 data: params,
			 success: function(param)
			 {
			 	$("#ymcCountryTaxPayerTable_"+_pageRef).jqGrid('deleteGridRow');
			 	emptyCountryTaxPayerDtls();
				 _showProgressBar(false);
			 }
			});
}


function checkDupTaxPayerCountry()
{ 
	var financialType=$("#financialTypeId_"+_pageRef).val();
	if(financialType=='E' || financialType=='D')
		{
			var grid = $("#ymcSharholdersTable_"+_pageRef);
			var rowdata = grid.jqGrid('getRowData');
			var selectedRowId = grid.jqGrid("getGridParam", 'selrow');
			var selectedRowIndex =	grid.jqGrid('getInd',selectedRowId);
			
			$.each(rowdata, function(index, value) 
					{
				if(index != selectedRowIndex-1) 
				{
					var selected_COUNTRY_CODE =$("#lookuptxt_countryOfResidenceLkp_"+_pageRef).val();
					
					if(selected_COUNTRY_CODE == value["cifKycFinancialInfoVO.KYC_FINANCIAL_COUNTRY"]) // Checking CHARGE_CODE
					{
						_showErrorMsg(msg_duplicate_entry_Of_record_key);
						
						$("#lookuptxt_countryOfResidenceLkp_"+_pageRef).val("");
						$("#countryOfResidenceDesc_"+_pageRef).val("");
						$("#taxPyerInt_"+_pageRef).val("");
						if( financialType=='D')
							{
								$("#licenceNo_"+_pageRef).val("");
								$("#memorandomNo_"+_pageRef).val("");
							}
						return;
					}
				}
					});
		}
	
}



function updateKycSessionLang()
{
 
	var action = jQuery.contextPath + "/path/fom/FrontOfficeMgntMaint_updateKycSessionLang.action?fomCO.preferredLanguage="+$("#screenLang_"+_pageRef).val()+"&fomCO.cifVO.LANGUAGE="+$("#cifVO_LANGUAGE_"+_pageRef).val();
	_showProgressBar(true);
	$
		.ajax( {
			url : action,
			type : "post",
			dataType : "json",
			data : "",
			success : function(data) { 
			}
		});
}


//BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement FALHA

function checkOpenCifCustodianGrid() {
	debugger;
	var gridMode = $("#gridMode_" + _pageRef).val();
	if (gridMode == '0') {
		ymc_showHideDetails();
		return;
	}
	if (gridMode == '1') {
		_showErrorMsg(
				'The inserted CID does not have existing CIF or another custodian ',
				info_msg_title);
	}
	if (gridMode == '2' || gridMode == '3') {
		var idNO = $("#civilIdNumber_" + _pageRef).val();
		var idType = $("#lookuptxt_CIF_ID_TYPE_" + _pageRef).val();
		var params = {
			"idNo" : idNO,
			"gridMode" : gridMode,
			"idType" : idType,
			"_pageRef" : _pageRef
		};

		if ($("#cifCustodianGrid_div_" + _pageRef)
				&& $("#cifCustodianGrid_div_" + _pageRef).attr('id') != undefined) {
			$("#cifCustodianGrid_div_" + _pageRef).dialog("destroy");
			$("#cifCustodianGrid_div_" + _pageRef).remove();
		}
		var dialogDivId = "cifCustodianGrid_div_" + _pageRef;
		var statusDiv = $("<div id='" + dialogDivId + "'/>");
		statusDiv.css("padding", "0");

		$('body').append(statusDiv);

		var reloadUrl = jQuery.contextPath
				+ "/path/fom/CifCustodianListAction_openGridPage"

		var dialogOption = {
			modal : true,
			title : 'Warning',
			autoOpen : false,
			show : 'slide',
			position : 'center',
			width : '1200',
			height : '300',
			close : function() {
				var theDialog = $(this);
				theDialog.remove();
			}
		};

		dialogOption = $.extend({
			buttons : {
				"OK" : {
					"text" : ok_label_trans,
					"id" : "ok_btn_" + _pageRef,
					"click" : function() {
						cifCustodianPopupOkPressed();

					}
				}
			}
		}, dialogOption);

		$("#" + dialogDivId).load(reloadUrl, params, function() {
			$(this).dialog(dialogOption);
			$(this).dialog("open");
		});

	}
	if (gridMode == '0') {
		_showErrorMsg(
				'The inserted CID does not have existing CIF or another custodian',
				info_msg_title);
	}
	

}

function cifCustodianPopupOkPressed() {
	debugger;
	var finType =	 $("#financialTypeId_" + _pageRef).val();
	var grid = $("#cifCustodianGrid_" + _pageRef);
	var rowdata = grid.jqGrid('getRowData');
	var selectedRowId = grid.jqGrid("getGridParam", 'selrow');
	if (selectedRowId != null) {
		var selectedCif = grid.jqGrid('getCell', selectedRowId,
				'cifKycFinancialInfoVO.CIF_NO');
		var selectedCustomerRef = grid.jqGrid('getCell', selectedRowId,
				'cifKycFinancialInfoVO.KYC_FINANCIAL_CUSTOMER_REF');

		parameter = "cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CIVIL_ID:civilIdNumber_"
				+ _pageRef
				+ ",cifKycFinancialInfoCO.civilIdType:civilIdType_"
				+ _pageRef
				+ ",cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CIF_TYPE:lookuptxt_kycCifTypeLkp_"
				+ _pageRef
				+ ",cifKycFinancialInfoCO.cifKycFinancialInfoVO.CIF_ID_TYPE:lookuptxt_CIF_ID_TYPE_"
				+ _pageRef
				+ ",cifKycFinancialInfoCO.SelectedCif:"
				+ selectedCif
				+ ",cifKycFinancialInfoCO.finType:financialTypeId_"+_pageRef
				+ ",cifKycFinancialInfoCO.SelectedCustomerRef:"
				+ selectedCustomerRef;
		
		dependencySrc = jQuery.contextPath
				+ "/path/fom/fomYmcLookupsAction_ymcCivilIdNoDependency"

		dependency = "civilIdNumber_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CIVIL_ID,"
				+ "firstName_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_FIRST_NAME,"
				+ "lastName_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_LAST_NAME,"
				+ "fullname_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_NAME,"
				+ "genderSelect_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_GENDER,"

				+ "lookuptxt_financialNationality_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_NATIONALITY,"
				+ "nationalityDesc_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.KYC_NATIONALITY_DESC,"

				+ "lookuptxt_birthCountryLkp_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_BIRTH_COUNTRY,"
				+ "birthCountryDesc_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.KYC_FINANCIAL_BIRTH_COUNTRY_DESC,"

				+ "lookuptxt_regionLkp_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANC_BIRTH_REGION,"
				+ "regionDesc_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.KYC_REGION_DESC,"

				+ "lookuptxt_cityLkp_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_BIRTH_PLACE,"
				+ "ymcCityDesc_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.KYC_CITY_DESC,"

				+ "cifVO1_PASSPORT_ISSUE_DATEdyn_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_BIRTH_DATE,"
				+ "cifCateg_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CIF_CATEGORY,"

				+ "lookuptxt_countryOfResidenceLkp_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_COUNTRY,"
				+ "countryOfResidenceDesc_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.KYC_FINANCIAL_COUNTRY_DESC,"

				+ "lookuptxt_addressRegionLkp_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANC_RESID_OP_REGION,"
				+ "addressRegionDesc_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.KYC_ADDRESS_REGION_DESC,"

				+ "lookuptxt_addressCityLkp_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_CITY,"
				+ "addressCityDesc_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.KYC_ADDRESS_CITY_DESC,"

				+ "kycFinancAddress_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_ADDRESS,"

				+ "phoneNo_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PHONE,"
				+ "email_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_EMAIL,"
				+ "postalZipCode_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_ZIP_CODE,"
				+ "financial_street_"
				+ _pageRef
				+ ":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_STREET,"
				  +"politicallyExposedPersonClient_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PEP_CLIENT,"
               +"lookuptxt_politicalPositionClientLkp_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.POLITICAL_POS_CLIENT,"
               
               +"politicalPositionClientDesc_"+_pageRef+":cifKycFinancialInfoCO.POLITICAL_POS_CLIENT_DESC,"
               +"politicallyExposedPerson_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_PEP,"
               +"relationShipSpecify_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.RELATIONSHIP_SPECIFY,"
               +"lookuptxt_relationship_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_RELATIONSHIP,"
               +"relationShipDesc_"+_pageRef+":cifKycFinancialInfoCO.KYC_FINANCIAL_RELATION_DESC,"
               +"lookuptxt_politicalPositionLkp_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_POLITICAL_POS,"
               +"politicalPositionDesc_"+_pageRef+":cifKycFinancialInfoCO.KYC_FINANCIAL_POLITICAL_POS_DESC,"
               +"otherBankAcc_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.OTHER_BANK_ACC,"
               +"countryName_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.COUNTRY_NAME,"
               +"lookuptxt_residentBankLkp_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.RESIDENT_BANK_CIF_CODE,"
               +"residentBankDesc_"+_pageRef+":cifKycFinancialInfoCO.RESIDENT_BANK_DESC,"
               
               +"expectedValTrx_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_VALTRX,"
               +"expectedValTrxMon_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_VALTRX_MON,"
               +"expectedValTrxYr_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_VALTRX_YR,"
               +"expectedNumTrx_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_NUMTRX,"
               +"expectedNumTrxMon_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_NUMTRX_MON,"
               +"expectedNumTrxYr_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.EXPECTED_NUMTRX_YRS,"
               +"natureTrxCashDepYn_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_CASHDEP_YN,"
               +"natureTrxChqYn_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_CHQ_YN,"
               +"natureTrxLFYn_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_LOCAL_FOR_TRANT_YN,"
               +"natureTrxIntTrnsYn_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_INTERNAL_TRANS_YN,"
               +"natureTrxSoYn_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_STANDING_ORDER_YN,"
               +"natureTrxOtherYn_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_OTHERS_YN,"
               +"natureTrxOther_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.NATURETRX_OTHERS,"
               +"averageAnnualIncome_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.AVERAGE_ANNUAL_INCOME,"
               +"crsSignYn_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.CRSSIGN_YN," 
               +"idCifNo_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.ID_CIF_NO,"
               +"idCustomerRef_"+_pageRef+":cifKycFinancialInfoCO.cifKycFinancialInfoVO.ID_CUSTOMER_REF,"
              

               

				
				
				+ "gridMode_" + _pageRef + ":cifKycFinancialInfoCO.gridMode";

		callDependency(dependency, dependencySrc, parameter, "civilIdNumber_"
				+ _pageRef, "ymc_showHideDetails");

	}
	ymc_showHideDetails();
	$("#cifCustodianGrid_div_" + _pageRef).dialog("close");
}
//BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement FALHA

