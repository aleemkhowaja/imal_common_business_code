function dynamicTemplateList_onDbClickedEvent() {

	var $table = $("#dynamicTemplateListGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var ivCrud = $("#iv_crud_" + _pageRef).val();
	var myObject = $table.jqGrid('getRowData', selectedRowId);
	var actionSrc = jQuery.contextPath
			+ '/path/dynamicTemplate/dynamicTemplateMaintAction_retrieveSelectedDynTempId.action';
	params = {};
	params["_pageRef"] = _pageRef;
	params["iv_crud"] = ivCrud;
	params["dtId"] = myObject["dynTemplateVO.DYN_TEMP_ID"];
	params["appName"] = myObject["dynTemplateVO.APP_NAME"];

	$.post(actionSrc, params, function(param) {
		_showProgressBar(false);

		if (param.indexOf("<script type=") != -1) {
			$("#dynamicTemplateListMaintDiv_id_" + _pageRef).show();
			$("#dynamicTemplateListMaintDiv_id_" + _pageRef).html(param);
			showHideSrchGrid('dynamicTemplateListGridTbl_Id_' + _pageRef);
		} else {
			var response = jQuery.parseJSON(param);
			_showErrorMsg(response["_error"], response["_msgTitle"], 300, 100);
		}
	}, "html");
}

function dynamicTemplateList_onDelClicked()
{
	_showConfirmMsg(Confirm_Delete_Process_key, Warning_key,
	dynamicTemplateList_handleDeleteProcess);	
}

function dynamicTemplateList_handleDeleteProcess(confirm) {
	if (confirm) {
		dtId = $("#dynamicTemplateListGridTbl_Id_" + _pageRef).jqGrid('getGridParam', 'selrow');
		myObject = $("#dynamicTemplateListGridTbl_Id_"+_pageRef).jqGrid('getRowData',dtId);
		var dynTempAppName=myObject["dynTemplateVO.APP_NAME"];
		var actionUrl = jQuery.contextPath
				+ "/path/dynamicTemplate/dynamicTemplateMaintAction_deleteDynTempId.action";
		var params = {};
		params["dtId"] = dtId;
		params["dynTempAppName"] = dynTempAppName;
		
		_showProgressBar(true);
		$
				.ajax({
					url : actionUrl,
					type : "post",
					dataType : "json",
					data : params,
					success : function(param) {
						if (typeof param["_error"] == "undefined"
								|| param["_error"] == null) {
							// empty form
							reloadUrl = jQuery.contextPath
									+ "/path/dynamicTemplate/dynamicTemplateMaintAction_clearStpForm.action";
							var ivCrud = returnHtmlEltValue("iv_crud_"
									+ _pageRef);
							var reloadParams = {};
							reloadParams["iv_crud"] = ivCrud;
							reloadParams["_pageRef"] = _pageRef;
							reloadParams["dtId"] = param.dynTemplateCO.dynTemplateVO.DYN_TEMP_ID
							$.post(reloadUrl,
								   reloadParams,
								   function(param) 
								   {
										showHideSrchGrid('dynamicTemplateListGridTbl_Id_'+ _pageRef);		
										$("#dynamicTemplateListMaintDiv_id_"+ _pageRef).html(param);
										// reload grid
										$("#dynamicTemplateListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
										_showProgressBar(false);
										_showErrorMsg(
												record_was_Deleted_Successfully_key,
												info_msg_title, 300,
												100);
									}, "html");

						} else {
							_showProgressBar(false);
						}
					}
				});
	}
}

function dynamicTemplateList_onAddClicked()
{
	// empty form
	if ($("#dynamicTemplateMaintFormId_" + _pageRef).hasChanges())
	{
		_showConfirmMsg(Confirm_Proceed_key, proceed_msg_title, function(
				confirmcChoice, theArgs)
		{
			if (confirmcChoice)
			{
				dynTemplate_clearStpForm();
			}
		}, {}, "yes", "no", 300, 100);
	}
	else
	{
		dynTemplate_clearStpForm();
	}

}

function dynTemplate_clearStpForm()
{
	var url = jQuery.contextPath
			+ "/path/dynamicTemplate/dynamicTemplateMaintAction_clearStpForm.action";
	var params = {};
	params["_pageRef"] = _pageRef;
	var ivCrud = returnHtmlEltValue("iv_crud_" + _pageRef);
	params["iv_crud"] = ivCrud;
	$.post(url, params, function(param)
	{
		$("#dynamicTemplateListMaintDiv_id_" + _pageRef).html(param);
	}, "html");
}