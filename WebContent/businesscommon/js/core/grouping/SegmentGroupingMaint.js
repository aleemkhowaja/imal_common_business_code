function segmentGroupingMaint_processSubmit()
{
	alert("Coding Needed of segmentGroupingMaint_onDbClickedEvent()");
}

function segmentGrouping_onStatusClicked()
{
	var groupCode = $("#group_code_" + _pageRef).val();

	if (groupCode == "")
	{
		return;
	}

	var theParams = {
		groupCode : groupCode
	};

	var loadSrc = jQuery.contextPath + "/path/grouping/SegmentGroupingStatusAction_search.action";
	var theFormId = "segmentGroupingFormId_" + _pageRef;
	showStatus(theFormId, _pageRef, loadSrc, theParams);
}

function setMethodName(methodName)
{
	$("#methodName_" + _pageRef).val(methodName);
}

function saveSegmentGroup()
{
	var methodName = $("#methodName_" + _pageRef).val();
	var confirmMsg;
	if (methodName == 'saveGroup')
	{
		confirmMsg = Confirm_Save_Process_key;
	}
	else if (methodName == 'approveGroup')
	{
		confirmMsg = Confirm_Approve_Process_key;
	}
	else if (methodName == 'rejectGroup')
	{
		confirmMsg = Confirm_Reject_Process_key;
	}
	else if (methodName == 'updateAfterApproveGroup')
	{
		confirmMsg = Confirm_Save_Process_key;
	}
	else if (methodName == 'deleteGroup')
	{
		confirmMsg = Confirm_Delete_Process_key;
	}
	
	_showConfirmMsg(confirmMsg, Warning_key, segmentCodeMaint_processSubmit, {});
}

function segmentCodeMaint_processSubmit(confirm)
{
	if (confirm)
	{
		var methodName = $("#methodName_" + _pageRef).val();

		_showProgressBar(true);

		var theForm = $("#segmentGroupingFormId_" + _pageRef).serializeForm();
		var actionPath = jQuery.contextPath + "/path/grouping/SegmentGroupingMaintAction_" + methodName;

		var crud = $("#iv_crud_" + _pageRef).val();
		
		if(crud == "UP")
		{
			actionPath = actionPath + "?_newRecord=false";
		}
		
		$.ajax({
				url : actionPath,
				type : "post",
				dataType : "json",
				data : theForm,
				success : function(data)
				{
					if (typeof data["_error"] == "undefined" || data["_error"] == null)
					{
						if (methodName == 'saveGroup')
						{
							_showErrorMsg(Saved_Successfully_key, info_msg_title);

							openNewSegmentGrouping();
						}
						else
						{
							reloadGroupPageAfterSuccess();

						}
					}
					_showProgressBar(false);
				}
		});
	}
}

function reloadGroupPageAfterSuccess()
{
	_showProgressBar(false);
	var methodName = $("#methodName_" + _pageRef).val();

	if (methodName == 'approveGroup')
	{
		_showErrorMsg(approved_successfully_key, info_msg_title);
	}
	if (methodName == 'rejectGroup')
	{
		_showErrorMsg(Confirm_Reject_Process_key, info_msg_title);
	}
	if (methodName == 'deleteGroup')
	{
		_showErrorMsg("Delete", info_msg_title);
	}
	else if (methodName == 'updateAfterApproveGroup')
	{
		_showErrorMsg(Saved_Successfully_key, info_msg_title);
	}
	$("#segmentGroupingListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
	$("#segmentGroupingListMaintDiv_id_" + _pageRef).html("");
	showHideSrchGrid('segmentGroupingListGridTbl_Id_' + _pageRef);
}
