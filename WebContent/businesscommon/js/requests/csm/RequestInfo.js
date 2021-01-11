function requestDetRrequest_onStatusClicked() {
	var Code = $("#requestDetRequestNo_" + _pageRef).val();
	var requestDetRequestBranch = $("#lookuptxt_requestDetRrequestProcessBranch_" + _pageRef).val();//bug 823923

	if (Code == "")
		return; //in case of new record

	//we should send the request branch code and NOT the session branch code
	var loadSrc = jQuery.contextPath
			+ "/path/requests/CtsRequestStatus_searchRequestStatus.action?criteria.code="
			+ Code + "&criteria.branchCode=" + requestDetRequestBranch
	var theFormId = "requestInfoTbl_" + _pageRef;
	showStatus(theFormId, _pageRef, loadSrc, {});
}

function requestDetRrequest_onChargeDetClicked(formId) {


	var params = fillReportsParam(formId);
	var requestCy = params["requestCy"];
	var existCyField = params["existCyField"];
	if (existCyField && (requestCy == '' || requestCy == null)) {
		_showErrorMsg(msg_please_fill_Currency_for_already_added_record,
				error_msg_title)
		//we shoud not open the charges if currency is not defined
		return;
	}
	if ($("#chargesDetailDiv_id_" + _pageRef).is(':empty') === true) 
	{
		_showProgressBar(true);
		var mySrc = jQuery.contextPath
				+ "/path/requests/CtsRequestMaintAction_loadChargesMaint";

		$("#chargesDetailDiv_id_" + _pageRef).load(mySrc,
				params,
				function() {
					//var formId  = "tradeDefFormId";
				$("#srcformId_" + _pageRef).val("#" + formId + "_" + _pageRef);
				$("#" + formId + _pageRef).bindFormChanges(
						"chargesDetailDiv_id_" + _pageRef);
				_showProgressBar(false);
			});
	}

	var theFormId = $('#auditTrxNbr_' + _pageRef).parent().attr("id");
	dialogOptions = {
		height : returnMaxHeight(600),
		width : returnMaxWidth(800),
		title : charges_key,
		modal : true,
		autoOpen : false,
		show : 'slide',
		position : 'center',
		buttons : {
			"OK" : {
				"text" : ok_label_trans,
				"id" : "cancel_btn_" + _pageRef,
				"click" : function() {
					$(this).dialog("close");
				}
			}
		}
	}
	$("#chargesDetailDiv_id_" + _pageRef).dialog(dialogOptions);
	$("#chargesDetailDiv_id_" + _pageRef).dialog("open");
	$("#" + formId + _pageRef).bindFormChanges(
			"chargesDetailDiv_id_" + _pageRef);

}

/**
 * fill the parameters needed in request charges screen, based on formId argument which should be passed dynamically from each screen
 * @param {Object} formId
 */
function fillReportsParam(formId) {
	

	var reqNo, readOnly, requestCy, requestCif, status, iv_crud;
	var existCyField = false;//used to check whether the currency field exist on the screen or not, if it exists then it should not b empty 
	if (formId != '') {
		if (formId.indexOf("lgMgntMaintFormId_") > -1) {
			reqNo = $("#requestDetRequestNo_" + _pageRef).val();
			readOnly = $("#_recReadOnly_" + _pageRef).val();
			requestCy = $("#lookuptxt_currency_" + _pageRef).val();
			existCyField = $("#lookuptxt_currency_" + _pageRef).length > 0;
			requestCif = $("#lookuptxt_cif_" + _pageRef).val();
			status = $("#requestDetRequestStatus_" + _pageRef).val();
			iv_crud = $("#iv_crud_" + _pageRef).val();
		
		} else if (formId.indexOf("lcFormId_") > -1) {
			
			reqNo = $("#requestDetRequestNo_" + _pageRef).val();
			readOnly = $("#_recReadOnly_" + _pageRef).val();
			requestCy = $("#lookuptxt_lc_currency_" + _pageRef).val();
			existCyField = $("#lookuptxt_lc_currency_" + _pageRef).length > 0;
			requestCif = $("#lookuptxt_app_cif_" + _pageRef).val();
			status = $("#requestDetRequestStatus_" + _pageRef).val();
			iv_crud = $("#iv_crud_" + _pageRef).val();

		} else if (formId.indexOf("bcMgntMaintFormId_") > -1) 
		  
		  {
			  
			reqNo = $("#requestDetRequestNo_" + _pageRef).val();
			readOnly = $("#_recReadOnly_" + _pageRef).val();
			requestCy = $("#lookuptxt_currency_" + _pageRef).val();
			existCyField = $("#lookuptxt_currency_" + _pageRef).length > 0;
			requestCif = $("#lookuptxt_drawee_cif" + _pageRef).val();
			status = $("#requestDetRequestStatus_" + _pageRef).val();
			iv_crud = $("#iv_crud_" + _pageRef).val();
		 
			
			
		} else if (formId.indexOf("ALLBRANCH") > -1) {
			reqNo = $("#requestDetRequestNo_" + _pageRef).val();
			
		}
		//Added By Rani for Bug Fixing Done By Elias Aoun
		else if (formId.indexOf("tradeDefFormId_") > -1) {
			reqNo = $("#requestDetRequestNo_" + _pageRef).val();
			readOnly = $("#_recReadOnly_" + _pageRef).val();
			requestCy = $("#tradeCy_securityLookup_" + _pageRef).val();
			existCyField = $("#tradeCy_securityLookup_" + _pageRef).length > 0;
			//requestCif = $("#lookuptxt_counter_guarantee_cif_"+_pageRef).val();
		} else if (formId.indexOf("subscriptionMaintFormId_") > -1) {
			reqNo = $("#requestDetRequestNo_" + _pageRef).val();
			readOnly = $("#_recReadOnly_" + _pageRef).val();
			requestCy = $("#tradeCy_fund_" + _pageRef).val();
			existCyField = $("#tradeCy_fund_" + _pageRef).length > 0;
			//    requestCif = $("#lookuptxt_counter_guarantee_cif_"+_pageRef).val();
		}
		//End Rani
	}
	return {
		"_pageRef" : _pageRef,
		"ctsRequestVO.REQ_NO" : reqNo,
		"requestCy" : requestCy,
		"existCyField" : existCyField,
		"requestCif" : requestCif,
		"iv_crud" : iv_crud,
		"ctsRequestVO.STATUS" : status,
		"_recReadOnly" : $("#_recReadOnly_" + _pageRef).val()
	};
}