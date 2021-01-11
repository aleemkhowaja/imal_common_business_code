
function blackListType_onStatusClicked()
{
	var theParams = {};
	var loadSrc = jQuery.contextPath + "/path/blackListType/BlackListTypeStatusAction_search.action";
	var theFormId = "blackListTypeMaintFormId_" + _pageRef;
	showStatus(theFormId, _pageRef, loadSrc, theParams);
}
/**
 * * called when row clicked in search grid
 */

function blackListTypeList_onDbClickedEvent()
{
	var isNotLoaded = typeof $('#blackListTypeMaintFormId_' + _pageRef).css('display') == "undefined";

	if (isNotLoaded)
	{
		blackListTypeList_onDbClickedConfirm(true);
	}
	else
	{
		var changes = $("#blackListTypeMaintFormId_" + _pageRef).hasChanges();
		if (changes == 'true' || changes == true)
		{
			_showConfirmMsg(changes_made_confirm_msg, "", "blackListTypeList_onDbClickedConfirm", "yesNo");
		}
		else
		{
			blackListTypeList_onDbClickedConfirm(true);
		}
	}

}
function blackListTypeList_onDbClickedConfirm(yesNo)
{
	if (yesNo == true)
	{
		blackListTypeList_onDbClickedConfirm(true);
	}
}
/**
 * called when proceed to load
 * 
 * @param {Object}
 *            yesNo
 */

function blackListTypeList_onDbClickedConfirm(yesNo)
{
	if (yesNo)
	{
		var $table = $("#blackListTypeListGridTbl_Id_" + _pageRef);
		var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
		var myObject = $table.jqGrid('getRowData', selectedRowId);
		/**
		 * get the selected rowId
		 */
		var Params = {};
		Params["blackListTypeSC.code"] = myObject["mosBlackListTypeVO.CODE"];

		Params["iv_crud"] = $("#iv_crud_" + _pageRef).val();
		Params["_pageRef"] = _pageRef;
		var actionSrc = jQuery.contextPath + "/path/blackListType/BlackListTypeMaintAction_loadRecords";
		_showProgressBar(true);
		$.post(actionSrc, Params, function(Params)
		{
			$("#blackListTypeListMaintDiv_id_" + _pageRef).html(Params);
			showHideSrchGrid('blackListTypeListGridTbl_Id_' + _pageRef);
			_showProgressBar(false);
		}, "html");

	}

}
/**
 * new btn
 * 
 * @returns
 */
function blackListTypeList_onAddClicked()
{
	var changes = $("#blackListTypeMaintFormId_" + _pageRef).hasChanges();
	if (changes == 'true' || changes == true)
	{
		_showConfirmMsg(changes_made_confirm_msg, "", "confirm_openNewBlackListTypeRequest", "yesNo");// Confirmation
	}
	else
	{
		confirm_openNewBlackListTypeRequest(true);
	}
}

function confirm_openNewBlackListTypeRequest(yesNo)
{
	if (yesNo == true)
	{
		blackListType_openNewRequest();
	}
}

function blackListType_openNewRequest()
{
	var iv_crud = $("#iv_crud_" + _pageRef).val();
	var params = {
			"iv_crud" : iv_crud,
			"_pageRef" : _pageRef
	};
	var actionSrc = jQuery.contextPath + "/path/blackListType/BlackListTypeMaintAction_reload.action";

	_showProgressBar(true);
	$.post(actionSrc, params, function(params)
	{
		$("#blackListTypeListMaintDiv_id_" + _pageRef).html(params);
		$("#blackListTypeListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
		var isDisplayed = $("#gview_" + "blackListTypeListGridTbl_Id_" + _pageRef).find('.ui-jqgrid-bdiv').css('display');
		if (isDisplayed == "block")
		{
			showHideSrchGrid("blackListTypeListGridTbl_Id_" + _pageRef);
		}
		_showProgressBar(false);
	}, "html");

}

function saveUpdBlackListType(methodName)
{
	$("#saveUpdBlackListType_" + _pageRef).val(methodName);
}

function blackListTypeMaint_processSubmit()
{
	var methodName = $("#saveUpdBlackListType_" + _pageRef).val();

	blackListTypeMaint_submit(true, {
		methodName : methodName
	});

}

function blackListTypeMaint_submit()
{

	var confrmMsg;
	var actionName;

	var methodName = $("#saveUpdBlackListType_" + _pageRef).val();

	if (methodName == 'save' || methodName == 'update' || methodName == 'updateAfterApprove')
	{
		var changes = $("#blackListTypeMaintFormId_" + _pageRef).hasChanges(true);
		if (changes != true)
		{
			return;
		}
		confrmMsg = Confirm_Save_key;
	}

	else if (methodName == 'delete')
	{
		confrmMsg = Confirm_Delete_Process_key;
		actionName = "deleteRecord";
	}
	if (methodName == 'save')
	{
		actionName = "saveBlackListType";
	}
	else if (methodName == 'update' || methodName == 'updateAfterApprove')
	{
		actionName = "updateBlackListType";
	}

	else if (methodName == 'cancel')
	{
		confrmMsg = Confirm_Cancel_key;
		actionName = "cancel";
	}

	else if (methodName == 'approve')
	{
		confrmMsg = Confirm_Approve_Record_key;
		actionName = "approveBlackListType";
	}

	_showConfirmMsg(confrmMsg, "", "blackListType_afterConfirmation", {
			methodName : methodName,
			actionName : actionName
	});

}

function blackListType_afterConfirmation(confirm, args)
{
	var methodName = args.methodName;
	var actionName = args.actionName;

	if (confirm)
	{
		continueSaveUtil(methodName, actionName);
	}
}
function continueSaveUtil(methodName, actionName)
{

	var theForm = $("#blackListTypeMaintFormId_" + _pageRef).serializeForm();

	var actionSrc = jQuery.contextPath + "/path/blackListType/BlackListTypeMaintAction_" + actionName;
	_showProgressBar(true);
	$.ajax({
			url : actionSrc,
			type : "post",
			dataType : "json",
			data : theForm,
			success : function(data)
			{
				if (data["_error"] == null)
				{
					if (methodName.indexOf("save") != -1 || methodName.indexOf("update") != -1 || methodName.indexOf("delete") != -1
									|| methodName.indexOf("updateAfterApprove") != -1 || methodName.indexOf("approve") != -1
									|| methodName.indexOf("cancel") != -1)
					{

						if (methodName == 'save' || methodName == 'update' || methodName == 'updateAfterApprove')
						{
							_showProgressBar(false);
							_showErrorMsg(record_saved_successfully_key, success_msg_title);
							blackListType_openNewRequest();

						}

						else if (methodName == 'delete')
						{
							blackListType_openNewRequest();
							_showErrorMsg(Record_was_Deleted_Successfully_key, success_msg_title);
							_showProgressBar(false);

							return;
						}
						else if (methodName == 'cancel')
						{
							blackListType_openNewRequest();
							_showErrorMsg(Record_Was_Cancelled_Successfully, success_msg_title);
							_showProgressBar(false);
							return;
						}

						else if (methodName == 'approve')
						{

							blackListType_openNewRequest();

							_showErrorMsg(record_was_approved_Successfully_key, success_msg_title);
							_showProgressBar(false);
							return;
						}

					}
				}
				_showProgressBar(false);
			}
	});
}

function blackListType_onStatusClicked()
{
	var status = $("#status_" + _pageRef).val();
	var code = $("#CODE_" + _pageRef).val();

	if (status == "" || code == "")
		return;

	var loadSrc = jQuery.contextPath + "/path/blackListType/BlackListTypeStatusAction_search.action?_pageRef=" + _pageRef;

	showStatus("blackListTypeMaintFormId_" + _pageRef, _pageRef, loadSrc, {
			"criteria.status" : status,
			"criteria.code" : code

	});
}
