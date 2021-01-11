/**
 * StatementOfAccountMaint.js
 * @memberOf StatementOfAccountMaint.jsp
 */


/**
 * @Description Bind the below functions on the needed elements in the html , while loading the screen
 * @Traget to be hidden from user view
 */
function initLoadFunctions() {
	$("#statementOfAccountMaintForm_" + _pageRef).find(
			":[id^=msgIncludeInReport_" + _pageRef + "]").on("click", function() {
		msgIncludeInReport(this);
	});
	$("#statementOfAccountMaintForm_" + _pageRef).find(
			":[id^=languageOpt_"+_pageRef+"]").on("click", function() {
		chooseLanguage(this);
	});
	$("#statementOfAccountMaintForm_" + _pageRef).find(
			":[id^=rangeByCriteria_"+_pageRef+"]").on("click", function() {
		showHideRangeByCriteria(this);
	});
	$("#statementOfAccountMaintForm_" + _pageRef).find(
			":[id^=gregoHijriDateList_"+_pageRef+"]").on("click", function() {
		showHideRangeGregoHijri(this);
	});
	
}



function disEnableBranch() {
	if ($("#lookuptxt_companyLkp_" + _pageRef).val() != '') {
		liveSearch_makeReadOnly(false, "lookuptxt_branchLkp_" + _pageRef)
	} else {
		liveSearch_makeReadOnly(true, "lookuptxt_branchLkp_" + _pageRef)
	}
}


function msgIncludeInReport(radioObject) {
	var selectedCriteriaVal = radioObject.value;
	var selectedCriteriaId = radioObject.id;

	parameter = "reportsCO.ctsSoaCtrlVO.MSG_IN_REPORT_ON:'" + selectedCriteriaVal
			+"',reportsCO.ctsSoaCtrlVO.ONLINE_LANGUAGE:'" + $("input:radio[id^=languageOpt_"+_pageRef+"]:checked").val()
			+ "',_pageRef:'" + _pageRef + "'";
	dependencySrc = jQuery.contextPath
			+ "/path/reports/ReportsDependencyAction_msgIncludeInReportDependency";

	dependency = "lookuptxt_rifMessageCode_" + _pageRef + ":reportsCO.rifMessageVO.MSG_CODE"
			+ ",rifMessageDesc_"+_pageRef+":reportsCO.rifMsgDesc";

	callDependency(dependency, dependencySrc, parameter, selectedCriteriaId,
			null);
}

/**
 * triggered when choose if the message is included in the report ot not
 * it disables the langauge and the message
 */
function chooseLanguage(radioObject) {
	var selectedCriteriaVal = radioObject.value;
	var selectedCriteriaId = radioObject.id;

	parameter = "reportsCO.ctsSoaCtrlVO.ONLINE_LANGUAGE:'" + selectedCriteriaVal
			+"',reportsCO.rifMessageVO.MSG_CODE:'" + $("lookuptxt_rifMessageCode_"+_pageRef).val()
			+ "',_pageRef:'" + _pageRef + "'";

	dependencySrc = jQuery.contextPath
			+ "/path/reports/ReportsDependencyAction_chooseLanguageDependency";

	dependency = "lookuptxt_rifMessageCode_" + _pageRef + ":reportsCO.rifMessageVO.MSG_CODE"
			+ ",rifMessageDesc_"+_pageRef+":reportsCO.rifMsgDesc";

	callDependency(dependency, dependencySrc, parameter, selectedCriteriaId,
			null);
}


function disableLanguage(checked) {
	$("[name='reportsCO.ctsSoaCtrlVO.ONLINE_LANGUAGE']").attr("disabled", !checked);
	liveSearch_makeReadOnly(!checked, "lookuptxt_rifMessageCode_" + _pageRef)
}

function showHideMsgData(languageField) {
	$("#lookuptxt_rifMessageCode_" + _pageRef).val( $("#msg_code_" + _pageRef).val());
	$("#rifMessageDesc_" + _pageRef).val(languageField.val());
}

function setAccountStatementValFrom() {
	var selectedRowId = $("#gridtab_accSlFrom_" + _pageRef).jqGrid(
			'getGridParam', 'selrow');
	var myObject = $("#gridtab_accSlFrom_" + _pageRef).jqGrid('getRowData',
			selectedRowId);
	$("#accBrFrom_" + _pageRef).val(myObject["amfVO.BRANCH_CODE"]);
	$("#accCyFrom_" + _pageRef).val(myObject["amfVO.CURRENCY_CODE"]);
	$("#accGlFrom_" + _pageRef).val(myObject["amfVO.GL_CODE"]);
	$("#accCifFrom_" + _pageRef).val(myObject["amfVO.CIF_SUB_NO"]);
	$("#lookuptxt_accSlFrom_" + _pageRef).val(myObject["amfVO.SL_NO"]);
	$("#accBrTo_" + _pageRef).val(myObject["amfVO.BRANCH_CODE"]);
	$("#accCyTo_" + _pageRef).val(myObject["amfVO.CURRENCY_CODE"]);
	$("#accGlTo_" + _pageRef).val(myObject["amfVO.GL_CODE"]);
	$("#accCifTo_" + _pageRef).val(myObject["amfVO.CIF_SUB_NO"]);
	$("#lookuptxt_accSlTo_" + _pageRef).val(myObject["amfVO.SL_NO"]);
}

function setAccountStatementValTo() {
	var selectedRowId = $("#gridtab_accSlTo_" + _pageRef).jqGrid(
			'getGridParam', 'selrow');
	var myObject = $("#gridtab_accSlTo_" + _pageRef).jqGrid('getRowData',
			selectedRowId);
	$("#accBrTo_" + _pageRef).val(myObject["amfVO.BRANCH_CODE"]);
	$("#accCyTo_" + _pageRef).val(myObject["amfVO.CURRENCY_CODE"]);
	$("#accGlTo_" + _pageRef).val(myObject["amfVO.GL_CODE"]);
	$("#accCifTo_" + _pageRef).val(myObject["amfVO.CIF_SUB_NO"]);
	$("#lookuptxt_accSlTo_" + _pageRef).val(myObject["amfVO.SL_NO"]);
}

function statementOfAcc_openPreview(currentPageRef, fromCancel) {
	_showProgressBar(true);
	//if the date is Hijri, i fill the equivalent gregorian date into the original one
	if ($("input:radio[id^=gregoHijriDateList_" + _pageRef + "]:checked").val() == "H") {
		$("from_date_" + _pageRef).val($("from_date_hijri_" + _pageRef).val());
		$("to_date_" + _pageRef).val($("to_date_hijri_" + _pageRef).val());
	}
	var theForm = $("#statementOfAccountMaintForm_" + currentPageRef).serializeForm();
	var action = jQuery.contextPath+"/path/reports/StatementOfAccountMaint_checkBeforeGenerate";

	//NABIL FEGHALI - IIAB110237 - SOA Charges
	var _type = $("#_type_" + currentPageRef).val();
	
	if(_type != undefined && _type != null && _type == 'TRX_CHARGES')
	{
		action = jQuery.contextPath + "/path/reports/StatementOfAccountMaintActionExt_checkBeforeGenerate";
		var theTrxForm = $("#trxMgntDefFormId_" + currentPageRef).serializeForm();
		theForm = theForm + "&" + theTrxForm;
	}
	else if(_type != undefined && _type != null && _type == 'TRX_CHARGES_APPROVE')
	{
		var param = {};
		param["trxMgntCO.ctstrsVO.OBJ_CODE"] = $("#trxChargesObjCode_" + currentPageRef).val();
		param["trxMgntCO.ctstrsVO.COMP_CODE"] = $("#trxChargesCompCode_" + currentPageRef).val();
		param["trxMgntCO.ctstrsVO.BRANCH_CODE"] = $("#trxChargesBranchCode_" + currentPageRef).val();
		openReport_stmtAccountTrxCharges(currentPageRef,param,_type, fromCancel);
		return;
	}
	//NABIL FEGHALI - end - IIAB110237 - SOA Charges 

	$.ajax( {
		url : action,
		type : "post",
		dataType : "json",
		data : theForm,
		success : function(data) {
			if (data["_error"] == null) {
				openReport_stmtAccount(currentPageRef,data, fromCancel);
				$("#auditTrxNbr_"+ _pageRef).val(data["reportsCO"]["opt"]);
			}else{
				_showProgressBar(false);
			}
		}
	});

}

//NABIL FEGHALI - IIAB110237 - SOA Charges
function openReport_stmtAccountTrxCharges(currentPageRef,data, _type, fromCancel) {
	
	//Add custom customReportAction in case of trx soa charges
	if(_type != undefined && _type != null && (_type == 'TRX_CHARGES' || _type == 'TRX_CHARGES_APPROVE'))
	{
		var customReportAction = jQuery.contextPath + '/path/reports/StatementOfAccountMaint_returnStatementChargesReport?trxMgntCO.openSOAReport=' + _type;
		
		if(_type == 'TRX_CHARGES')
		{	
			//Default the amount of the transaction
			$("#amount_" + currentPageRef).val(data.trxMgntCO.ctstrsVO.AMOUNT);
			$("#soaDateFrom_" + currentPageRef).val($.datepicker.formatDate('dd/mm/yy',  parseISODateStr(data.trxMgntCO.ctstrsStatementVO.SOA_DATE_FROM)));
			$("#soaDateTO_" + currentPageRef).val($.datepicker.formatDate('dd/mm/yy',  parseISODateStr(data.trxMgntCO.ctstrsStatementVO.SOA_DATE_TO)));
			$("#soaNbPages_" + currentPageRef).val(data.trxMgntCO.ctstrsStatementVO.SOA_NB_PAGES);
			
			//Dependency by amount
			$("#trs_ac_amount_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.TRS_AC_AMOUNT);
		    $("#exchange_rate_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.EXCHANGE_RATE);
		    $("#cv_amount_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.CV_AMOUNT);
			$("#remittance_fr_num_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.REMITTANCE_FR_NUM);
		    $("#remittance_to_num_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.REMITTANCE_TO_NUM);
		    $("#remitt_cy_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.REMITT_CY);
		    $("#t_instr_avail_qty_ht_"+currentPageRef).val(data.trxMgntCO.t_instr_avail_qty_ht);
		    $("#t_instr_avail_qty_vault_"+currentPageRef).val(data.trxMgntCO.t_instr_avail_qty_vault);
		    $("#t_total_amount_"+currentPageRef).val(data.trxMgntCO.t_total_amount);
		    $("#t_total_ac_amount_"+currentPageRef).val(data.trxMgntCO.t_total_ac_amount);
		    $("#trxMgntCyDenomGridUpdate_"+currentPageRef).val(data.trxMgntCO.trxMgntCyDenomGridUpdate);
		    $("#reloadCyDenomGrid_"+currentPageRef).val(data.trxMgntCO.reloadCyDenomGrid);
		    
		    //Account det settings
		    if(data.trxMgntCO.ctstrsACCDETVOs != undefined
		    		&& data.trxMgntCO.ctstrsACCDETVOs != null
		    		&& data.trxMgntCO.ctstrsACCDETVOs.length > 0)
		    {
		    	$("#trxMgntAccountDtlGridSOA_"+currentPageRef).val(JSON.stringify(data.trxMgntCO.ctstrsACCDETVOs));
		    
		    	trxMgnt_openAccountDtlLkp();	
		    }
		   else
		    {
		    	$("#to_trs_ac_br_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.TO_TRS_AC_BR);
		    	$("#to_trs_ac_cy_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.TO_TRS_AC_CY);
		    	$("#to_trs_ac_gl_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.TO_TRS_AC_GL);
		    	$("#to_trs_ac_cif_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.TO_TRS_AC_CIF);
		    	$("#lookuptxt_to_trs_ac_sl_"+currentPageRef).val(data.trxMgntCO.ctstrsVO.TO_TRS_AC_SL);
		    }
		}
		else if(_type == 'TRX_CHARGES_APPROVE')
		{
			
			customReportAction += '&trxMgntCO.ctstrsVO.OBJ_CODE=' + data["trxMgntCO.ctstrsVO.OBJ_CODE"] +
								  '&trxMgntCO.ctstrsVO.COMP_CODE=' + data["trxMgntCO.ctstrsVO.COMP_CODE"] +
								  '&trxMgntCO.ctstrsVO.BRANCH_CODE=' + data["trxMgntCO.ctstrsVO.BRANCH_CODE"];
			
		}	
		if(fromCancel == undefined || fromCancel == null || fromCancel == false)
		{
			//Close statement of account dialog
			
			//$("#trxMgntSOADiv_"+currentPageRef).dialog('close');
			$("#trxMgntSOADiv_"+currentPageRef).dialog("destroy");
			$("#trxMgntSOADiv_"+currentPageRef).remove();
			
			
			//var dateTimeId = new Date();
			//window.open dont display PDF in IE. it works only in FireFox, an upgrade of AdobeReader to a version greater than 10.0 may resolve 
			//the problem. a workaround is done by using IFRAME
			//window.open(customReportAction,
			//dateTimeId.getTime(), "width=950,height=750,top=50,left=50,scrollbars=yes,menubar=yes,resizable=yes");
			displayPDF_stmtAccountTrxCharges(currentPageRef,customReportAction);
		}
		_showProgressBar(false);
		
	}
	
	
}


//NABIL FEGHALI - IIAB110237 - SOA Charges
function displayPDF_stmtAccountTrxCharges(currentPageRef,reportUrl)
{
	////////////////////////////////////
	//object works IE8, does not work in FireFox
	//var chooseLanguageDivContent = '<div id="openPDFDivId"><object data="' + certificateReportUrl + '" type="application/pdf" width="100%" height="100%"> <p>cannot open PDF</a></p> </object></div>';

	//IFrame works on FireFox , does not work on IE8
	//var chooseLanguageDivContent = '<div id="openPDFDivId"><iframe src="' + certificateReportUrl + '" width="100%" height="100%"> </iframe></div>';

	//Embed works IE8, does not work on FireFox
	//var chooseLanguageDivContent = '<div id="openPDFDivId"><embed  src="' + certificateReportUrl + '" width="100%" height="100%"></div>';

	var openPDFDiv = null;

	if ($.browser.msie) 
	{
		openPDFDiv = '<div id="openPDFDivId_'+ currentPageRef +'"><embed  src="' + reportUrl + '" width="100%" height="100%"></div>';
	} else 
	{
		openPDFDiv = '<div id="openPDFDivId_'+ currentPageRef +'"><iframe src="' + reportUrl + '" width="100%" height="100%"> </iframe></div>';
	}

	var openPDFDivElement = $(openPDFDiv);

	$('body').append(openPDFDivElement);

	openPDFDivElement.dialog( {
		modal : true,
		title : stat_of_account_key,
		autoOpen : false,
		//show : 'slide',
		position : 'center',
		width : returnMaxWidth(950),
		height : returnMaxHeight(750),
		close : function() 
		{
			if ($("#openPDFDivId")) 
			{
				$("#openPDFDivId_"+ currentPageRef).dialog("destroy");
				$("#openPDFDivId_"+ currentPageRef).remove();
			}
		}
	});

	$(openPDFDivElement).dialog("open");
		
} 


function openReport_stmtAccount(currentPageRef,data, fromCancel) {
	_showProgressBar(true);
	var RA_LANGUAGE = data.reportsCO.ctsSoaCtrlVO.ONLINE_LANGUAGE;
	var opt = data.reportsCO.opt;
	var reportParams = data.reportsCO.reportParams;
	//NABIL FEGHALI - IIAB110237 - SOA Charges 
	var _type = data.reportsCO._type;
	if(_type != undefined && _type != null && (_type == 'TRX_CHARGES'))
	{
		openReport_stmtAccountTrxCharges(currentPageRef,data,_type, fromCancel);
		return;
	}
	//NABIL FEGHALI - end - IIAB110237 - SOA Charges
	_showProgressBar(true);
	if (RA_LANGUAGE =='L' || RA_LANGUAGE =='EN' )
		{
		RA_LANGUAGE ='EN';
		}else {
			RA_LANGUAGE='AR';
		}
	
	var exportType = $("#exportType_" + _pageRef).val();
	var dataParams = {};
	dataParams["var_format"] = exportType;
	if (exportType == "HTML" || exportType == "PDF") 
	{
		openPreviewAdvice(opt, reportParams,null, "_showProgressBar(false)", null, RA_LANGUAGE);
	}
	else if (exportType == "MT940") 
	{
		var param = {};
		var reportByDate = $("input:radio[id^=reportByDate_" + _pageRef+"]:checked").val(); 
		param["reportsCO.companiesVO.COMP_CODE"] = $("#lookuptxt_companyLkp_" + currentPageRef).val();
		param["reportsCO.branchesVO.BRANCH_CODE"] = $("#lookuptxt_branchLkp_" + currentPageRef).val();
		param["reportsCO.amfVOFrom.BRANCH_CODE"] = $("#accBrFrom_" + currentPageRef).val();
		param["reportsCO.amfVOFrom.CURRENCY_CODE"] = $("#accCyFrom_" + currentPageRef).val();
		param["reportsCO.amfVOFrom.GL_CODE"] = $("#accGlFrom_" + currentPageRef).val();
		param["reportsCO.amfVOFrom.CIF_SUB_NO"] = $("#accCifFrom_" + currentPageRef).val();
		param["reportsCO.amfVOFrom.SL_NO"] = $("#lookuptxt_accSlFrom_" + currentPageRef).val();
		param["reportsCO.amfVOTo.BRANCH_CODE"] = $("#accBrTo_" + currentPageRef).val();
		param["reportsCO.amfVOTo.CURRENCY_CODE"] = $("#accCyTo_" + currentPageRef).val();
		param["reportsCO.amfVOTo.GL_CODE"] = $("#accGlTo_" + currentPageRef).val();
		param["reportsCO.amfVOTo.CIF_SUB_NO"] = $("#accCifTo_" + currentPageRef).val();
		param["reportsCO.amfVOTo.SL_NO"] = $("#lookuptxt_accSlTo_" + currentPageRef).val();
		param["reportsCO.ctsSoaCtrlVO.ONLINE_DATE_TYPE"]= reportByDate;
		param["reportsCO.from_date"]= $("#from_date_" + currentPageRef).val();
		param["reportsCO.to_date"]= $("#to_date_" + currentPageRef).val();

		$.ajax({
			url: jQuery.contextPath+"/path/reports/ReportsDependencyAction_viewStatementMT940",
	        type:"post",
			dataType:"json",
			data: param,
			success: function(data){ 
				var logdivMsg = "<div id='logDivMsgTrx'><textarea readonly='readonly' id ='txtAreaLogMsg' style='width:100%;height:100%;' spellcheck='false' autocorrect='off' autocapitalize='off' autocomplete='off'>" + data.reportsCO.swiftMessage + "</textarea></div>";
				var logdivMsg = $(logdivMsg);								
		      	var buttonsArr = {};
		      	buttonsArr[print_label_trans] = function()
           			{
		      		    printpage('txtAreaLogMsg',data.reportsCO.swiftMessage);
           			};
			   	buttonsArr[cancel_label_trans] =function()
	   				{
	      				$(this).dialog("close");
	   				};
    	   				
				logdivMsg.dialog({
					modal : true,
					title : data.reportsCO.savePathJava,
					autoOpen : false,
					show : 'slide',
					position : 'center',
					width : '750',
					height : '500',
					buttons: buttonsArr,
					close : function() {
					},
					open : function() 
					{
					},
				});
				$(logdivMsg).dialog("open");				
				_showProgressBar(false);
			}
		});
	}
	else 
	{
		openAdviceReportWithRef(opt,reportParams, null, dataParams);
	}
	 
}

/** 
  @Modif : w_report_statement_boubyan (TP id:83155)
*/
function showHideRangeByCriteria(radioObject) {
	var selectedCriteriaVal = radioObject.value;
	var selectedCriteriaId = radioObject.id;

	parameter = "reportsCO.rangeByCriteria:~CONST_" + selectedCriteriaVal
	+ ",_pageRef:'" + _pageRef + "'";
	
	dependencySrc = jQuery.contextPath + "/path/reports/ReportsDependencyAction_showHideRangeByCriteria";
	
	dependency = "rangeByCriteria_" + _pageRef + ":reportsCO.rangeByCriteria";
	callDependency(dependency, dependencySrc, parameter, selectedCriteriaId,
			null);
}


function simulateOpenLookup_fromCardNo(){
	var referenceVal = $("#lookuptxt_fromCardNo_"+_pageRef).val();
	if( referenceVal != ""){
		$("#spanLookup_fromCardNo_"+_pageRef).trigger("click");
	}else{
		simulateCardNoDependency();
	}
	return false;
}



/** 
  @Modif : w_report_statement_boubyan (TP id:83155)
*/
function simulateCardNoDependency(fromWhere) {
	if (fromWhere == "onOk") {
		var selectedRowId = $("#gridtab_fromCardNo_" + _pageRef).jqGrid(
				'getGridParam', 'selrow');
		var myObject = $("#gridtab_fromCardNo_" + _pageRef).jqGrid(
				'getRowData', selectedRowId);
	} else {
		var myObject = new Object();
	}
	
	$("#lookuptxt_fromCardNo_" + _pageRef).val(myObject["cardsMgtVO.CARD_NO"]);
	
	//TODO added for bug 327783
	$("#lookuptxt_branchLkp_" + _pageRef).val(myObject["cardAccountVO.ACC_BR"]);
	$("#accBrFrom_" + _pageRef).val(myObject["cardAccountVO.ACC_BR"]);
	$("#accCyFrom_" + _pageRef).val(myObject["cardAccountVO.ACC_CY"]);
	$("#accGlFrom_" + _pageRef).val(myObject["cardAccountVO.ACC_GL"]);
	$("#accCifFrom_" + _pageRef).val(myObject["cardAccountVO.ACC_CIF"]);
	$("#lookuptxt_accSlFrom_" + _pageRef).val(myObject["cardAccountVO.ACC_SL"]);
	//END

	parameter = "fromCardNo:lookuptxt_fromCardNo_" + _pageRef
			+ ",companiesVO.COMP_CODE:lookuptxt_companyLkp_" + _pageRef 
			+ ",amfVOFrom.BRANCH_CODE:accBrFrom_" + _pageRef
			+ ",amfVOFrom.CURRENCY_CODE:accCyFrom_" + _pageRef
			+ ",amfVOFrom.GL_CODE:accGlFrom_" + _pageRef
			+ ",amfVOFrom.CIF_SUB_NO:accCifFrom_" + _pageRef
			+ ",amfVOFrom.SL_NO:lookuptxt_accSlFrom_" + _pageRef + "";
	
	dependencySrc = jQuery.contextPath
			+ "/path/reports/ReportsDependencyAction_fromCardNoDependency";
	
	dependency = "lookuptxt_fromCardNo_" + _pageRef + ":reportsCO.fromCardNo," +
				"lookuptxt_branchLkp_" + _pageRef + ":reportsCO.branchesVO.BRANCH_CODE," +
				"branchDesc_" + _pageRef + ":reportsCO.branchesVO.BRIEF_DESC_ENG," +
				"accBrFrom_" + _pageRef + ":reportsCO.branchesVO.BRANCH_CODE," +
				"accBrTo_" + _pageRef + ":reportsCO.branchesVO.BRANCH_CODE," +
				"accCyFrom_" + _pageRef + ":reportsCO.amfVOFrom.CURRENCY_CODE," +
				"accCyTo_" + _pageRef + ":reportsCO.amfVOFrom.CURRENCY_CODE," +
				"accGlFrom_" + _pageRef + ":reportsCO.amfVOFrom.GL_CODE," +
				"accGlTo_" + _pageRef + ":reportsCO.amfVOFrom.GL_CODE," +
				"accCifFrom_" + _pageRef + ":reportsCO.amfVOFrom.CIF_SUB_NO," +
				"accCifTo_" + _pageRef + ":reportsCO.amfVOFrom.CIF_SUB_NO," +
				"lookuptxt_accSlFrom_" + _pageRef + ":reportsCO.amfVOFrom.SL_NO," +
				"lookuptxt_accSlTo_" + _pageRef + ":reportsCO.amfVOFrom.SL_NO," +
				"lookuptxt_fromReference_" + _pageRef + ":reportsCO.amfVOFrom.ADDITIONAL_REFERENCE," +
				"lookuptxt_toReference_" + _pageRef + ":reportsCO.amfVOTo.ADDITIONAL_REFERENCE";

	callDependency(dependency, dependencySrc, parameter,
			"lookuptxt_fromCardNo_" + _pageRef, null);
	return false;
}




function onOkFromIban() {
	var selectedRowId = $("#gridtab_fromIban_" + _pageRef).jqGrid(
			'getGridParam', 'selrow');
	var myObject = $("#gridtab_fromIban_" + _pageRef).jqGrid('getRowData',
			selectedRowId);
	
	$("#lookuptxt_branchLkp_" + _pageRef).val(myObject["amfVO.BRANCH_CODE"]);
	$("#accCyFrom_" + _pageRef).val(myObject["amfVO.CURRENCY_CODE"]);
	$("#accGlFrom_" + _pageRef).val(myObject["amfVO.GL_CODE"]);
	$("#accCifFrom_" + _pageRef).val(myObject["amfVO.CIF_SUB_NO"]);
	$("#lookuptxt_accSlFrom_" + _pageRef).val(myObject["amfVO.SL_NO"]);
	$("#lookuptxt_fromReference_" + _pageRef).val(myObject["amfVO.ADDITIONAL_REFERENCE"]);

	if ( myObject["amfVO.IBAN_ACC_NO"] != null && myObject["amfVO.IBAN_ACC_NO"].trim() != "") {
		parameter = "companiesVO.COMP_CODE:lookuptxt_companyLkp_" + _pageRef
				+ ",amfVOFrom.IBAN_ACC_NO:lookuptxt_fromIban_" + _pageRef ;

		dependencySrc = jQuery.contextPath
				+ "/path/reports/ReportsDependencyAction_fromIbanDependency";

		
		dependency = "lookuptxt_fromIban_" + _pageRef
				+ ":reportsCO.amfVOFrom.IBAN_ACC_NO," + "lookuptxt_branchLkp_" + _pageRef
				+ ":reportsCO.branchesVO.BRANCH_CODE," + "accBrFrom_"
				+ _pageRef + ":reportsCO.branchesVO.BRANCH_CODE,"
				+ "accCyFrom_" + _pageRef
				+ ":reportsCO.amfVOFrom.CURRENCY_CODE," + "accGlFrom_" + _pageRef
				+ ":reportsCO.amfVOFrom.GL_CODE," + "accCifFrom_"
				+ _pageRef + ":reportsCO.amfVOFrom.CIF_SUB_NO," + "lookuptxt_accSlFrom_"
				+ _pageRef + ":reportsCO.amfVOFrom.SL_NO";

		callDependency(dependency, dependencySrc, parameter,
				"lookuptxt_fromIban_" + _pageRef, null);
	}
}


function onOkToIban() {
	var selectedRowId = $("#gridtab_toIban_" + _pageRef).jqGrid(
			'getGridParam', 'selrow');
	var myObject = $("#gridtab_toIban_" + _pageRef).jqGrid('getRowData',
			selectedRowId);
	
	$("#lookuptxt_branchLkp_" + _pageRef).val(myObject["amfVO.BRANCH_CODE"]);
	$("#accCyTo_" + _pageRef).val(myObject["amfVO.CURRENCY_CODE"]);
	$("#accGlTo_" + _pageRef).val(myObject["amfVO.GL_CODE"]);
	$("#accCifTo_" + _pageRef).val(myObject["amfVO.CIF_SUB_NO"]);
	$("#lookuptxt_accSlTo_" + _pageRef).val(myObject["amfVO.SL_NO"]);
	$("#lookuptxt_toReference_" + _pageRef).val(myObject["amfVO.ADDITIONAL_REFERENCE"]);

	if ( myObject["amfVO.IBAN_ACC_NO"] != null && myObject["amfVO.IBAN_ACC_NO"].trim() != "") {
		parameter = "companiesVO.COMP_CODE:lookuptxt_companyLkp_" + _pageRef
				+ ",amfVOTo.IBAN_ACC_NO:lookuptxt_toIban_" + _pageRef 
				+ ",amfVOFrom.IBAN_ACC_NO:lookuptxt_fromIban_" + _pageRef;

		dependencySrc = jQuery.contextPath
				+ "/path/reports/ReportsDependencyAction_toIbanDependency";

		
		dependency = "lookuptxt_toIban_" + _pageRef
				+ ":reportsCO.amfVOTo.IBAN_ACC_NO," + "lookuptxt_branchLkp_" + _pageRef
				+ ":reportsCO.branchesVO.BRANCH_CODE," + "accBrTo_"
				+ _pageRef + ":reportsCO.branchesVO.BRANCH_CODE,"
				+ "accCyTo_" + _pageRef
				+ ":reportsCO.amfVOTo.CURRENCY_CODE," + "accGlTo_" + _pageRef
				+ ":reportsCO.amfVOTo.GL_CODE," + "accCifTo_"
				+ _pageRef + ":reportsCO.amfVOTo.CIF_SUB_NO," + "lookuptxt_accSlTo_"
				+ _pageRef + ":reportsCO.amfVOTo.SL_NO";

		callDependency(dependency, dependencySrc, parameter,
				"lookuptxt_toIban_" + _pageRef, null);
	}
	
}

function showHideRangeGregoHijri(radioObject) {
	var selectedCriteriaVal = radioObject.value;
	var selectedCriteriaId = radioObject.id;

	parameter = "reportsCO.ctsSoaCtrlVO.SHOW_HIJRI_DATE:'" + selectedCriteriaVal
			+ "',_pageRef:'" + _pageRef + "'";
	
	dependencySrc = jQuery.contextPath
			+ "/path/reports/ReportsDependencyAction_showHideRangeGregoHijri";

	dependency = "lookuptxt_fromCardNo_" + _pageRef + ":reportsCO.fromCardNo";;

	callDependency(dependency, dependencySrc, parameter, selectedCriteriaId,
			null);
}