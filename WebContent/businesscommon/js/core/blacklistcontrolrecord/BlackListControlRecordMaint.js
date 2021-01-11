

function saveBlackListControlRecord(methodName)
{
  $("#saveBlackListControlRecord_"+_pageRef).val(methodName);	
}

function blackListControlRecordMaint_processSubmit()
{
        var methodName   = $("#saveBlackListControlRecord_"+_pageRef).val();
        
        blackListControlRecordMaint_submit(true,{methodName:methodName})
   
}

function blackListControlRecordMaint_submit()
{

	var confrmMsg;
	var actionName;

	 var methodName   = $("#saveBlackListControlRecord_"+_pageRef).val();
    


	if (methodName == 'update' || methodName == 'save'|| methodName == 'updateAfterApprove')
	{
		var changes = $("#controlRecordMaintFormId_" + _pageRef).hasChanges(true);
		if (changes != true)
		{
			return;
		}
		confrmMsg = Confirm_Save_key;
	}
	
	if (methodName == 'save')
	{
		actionName = "saveBlackListControlRecord";
	}
	else if (methodName == 'approve')
	{
		confrmMsg = Confirm_Approve_Record_key;
		actionName = "approveControlRecord";
	}
	else if (methodName == 'update' || methodName == 'updateAfterApprove')
	{
		actionName = "saveBlackListControlRecord";
	}
	else if (methodName == 'cancel')
	{
		confrmMsg = Confirm_Cancel_key;
		actionName = "cancel";
	}
	
	_showConfirmMsg(confrmMsg, "", "blackListControlRecord_afterConfirmation", {
		methodName : methodName,
		actionName : actionName
	});

}

function blackListControlRecord_afterConfirmation(confirm, args)
{
	var methodName = args.methodName;
	var actionName = args.actionName;

	if (confirm)
	{
		continueSaveBlackListControlRecord (methodName, actionName);
	}
}

function continueSaveBlackListControlRecord (methodName, actionName)
{
	

	var theForm = $("#controlRecordMaintFormId_" + _pageRef).serializeForm();

	var actionSrc = jQuery.contextPath
			+ "/path/controlRecord/BlackListControlRecordMaintAction_"
			+ actionName;
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
				if (methodName.indexOf("save") != -1
						|| methodName.indexOf("update") != -1
						|| methodName.indexOf("updateAfterApprove") != -1
						|| methodName.indexOf("approve") != -1
						|| methodName.indexOf("cancel") != -1


						)
				{

					if (methodName == 'save' || methodName == 'update' || methodName == 'updateAfterApprove'
							)
					{
						blackListControlRecord_openNewRequest();

						_showProgressBar(false);
						_showErrorMsg(record_saved_successfully_key,
								success_msg_title);

					}
					else if (methodName == 'approve')
					{
						
						blackListControlRecord_openNewRequest();

						_showErrorMsg(record_was_approved_Successfully_key,
								success_msg_title);
						_showProgressBar(false);
						return;
					}
					else if (methodName == 'cancel')
					{
						blackListControlRecord_openNewRequest();
						_showErrorMsg(Record_Was_Cancelled_Successfully,
								success_msg_title);
						_showProgressBar(false);
						return;
					}
					

				}
			}
			_showProgressBar(false);
		}
	});
}

function blackListControlRecord_onStatusClicked()
{
	var status = $("#status_" + _pageRef).val();
	
	if (status == "")
		return;

	var loadSrc = jQuery.contextPath
			+ "/path/controlRecord/BlackListControlRecordStatusAction_search.action?_pageRef="
			+ _pageRef;

	showStatus("controlRecordMaintFormId_" + _pageRef, _pageRef, loadSrc, {
		"criteria.status" : status

		
	});
}

function blackListControlRecord_openNewRequest()

{
	_showProgressBar(true);
	var iv_crud = $("#iv_crud_" + _pageRef).val();
	var params = {
			"iv_crud" : iv_crud,
			"_pageRef" : _pageRef
	};
	var actionSrc = jQuery.contextPath + "/path/controlRecord/BlackListControlRecordMaintAction_reload.action";


	
	$.post(actionSrc, params, function(param)
					{
						$("#controlRecordMaintDivId_" + _pageRef).html(param);
					}, "html");

	
	_showProgressBar(true);

}