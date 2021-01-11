function dynamicTemplateConventionList_onDbClickedEvent()
{
	var $table = $("#dynamicTemplateConventionListGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var ivCrud = $("#iv_crud_" + _pageRef).val();
	var myObject = $table.jqGrid('getRowData', selectedRowId);
	var actionSrc = jQuery.contextPath+'/path/dynamicTemplate/dynamicTemplateConvMaintAction_retrieveSelectedConvNo.action';
	params = {};
	params["_pageRef"]=_pageRef;
	params["iv_crud"] = ivCrud;
	params["convNo"] = myObject["dynTempConvVO.CONVENTION_NUMBER"];
	params["convStatus"] = myObject["dynTempConvVO.STATUS"];
	params["convEntType"] = myObject["dynTempConvVO.ENTITY_TYPE"];
	
	$.post(actionSrc, params, function(param) {
		_showProgressBar(false);
		
		if (param.indexOf("<script type=") != -1)
		{
			$("#dynamicTemplateConventionListMaintDiv_id_" + _pageRef).show();
			$("#dynamicTemplateConventionListMaintDiv_id_" + _pageRef).html(param);
			displaySpan(params.convEntType);
			showHideSrchGrid('dynamicTemplateConventionListGridTbl_Id_' + _pageRef);
		}
		else
		{
			var response = jQuery.parseJSON(param);
			_showErrorMsg(response["_error"], response["_msgTitle"], 300, 100);
		}
	}, "html");
}


function dynamicTemplateConventionList_onAddClicked() 
{
	// empty form
	if ($("#dynamicTemplateConventionMaintFormId_" + _pageRef).hasChanges()) {
		_showConfirmMsg(Confirm_Proceed_key, proceed_msg_title, function(
				confirmcChoice, theArgs) {
			if (confirmcChoice) {
				dynamicTemplateConvention_clearStpForm();
			}
		}, {}, "yes", "no", 300, 100);
	} else {
		dynamicTemplateConvention_clearStpForm();
	}

}

function dynamicTemplateConvention_clearStpForm() 
{
	var url = jQuery.contextPath
			+ "/path/dynamicTemplate/dynamicTemplateConvMaintAction_clearStpForm.action";
	var params = {};
	params["_pageRef"] = _pageRef;
	var ivCrud = returnHtmlEltValue("iv_crud_" + _pageRef);
	params["iv_crud"] = ivCrud;
	$.post(url, params, function(param) {
		$("#dynamicTemplateConventionListMaintDiv_id_" + _pageRef).html(param);
	}, "html");
}