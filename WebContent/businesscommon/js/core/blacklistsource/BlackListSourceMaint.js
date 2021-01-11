



/**
**
* called when row clicked in search grid
*/

function blackListSourceList_onDbClickedEvent()
{
	var isNotLoaded = typeof $('#blackListSourceMaintFormId_' + _pageRef).css(
			'display') == "undefined";

	if (isNotLoaded)
	{
		blackListSourceList_onDbClickedConfirm(true);
	}
	else
	{
		var changes = $("#blackListSourceMaintFormId_" + _pageRef).hasChanges();
		if (changes == 'true' || changes == true)
		{
			_showConfirmMsg(changes_made_confirm_msg, "",
					"blackListSourceList_onDbClickedConfirm", "yesNo");
		}
		else
		{
			blackListSourceList_onDbClickedConfirm(true);
		}
	}

}
function blackListSourceList_onDbClickedConfirm(yesNo)
{
	if (yesNo == true)
	{
		blackListSourceList_onDbClickedConfirm(true);
	}
}
/**
* called when proceed to load
* 
* @param {Object}
*            yesNo
*/

function blackListSourceList_onDbClickedConfirm(yesNo)
{
	if (yesNo)
	{
		var $table = $("#blackListSourceListGridTbl_Id_" + _pageRef);
		var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
		var myObject = $table.jqGrid('getRowData', selectedRowId);
		/**
		 * get the selected rowId
		 */
	var Params = {};
		Params["blackListSourceSC.code"] = myObject["blackSourceVO.CODE"];

		Params["iv_crud"] = $("#iv_crud_" + _pageRef).val();
		Params["_pageRef"] = _pageRef;
		var actionSrc = jQuery.contextPath
				+ "/path/blackListSource/BlackListSourceMaintAction_loadRecords";
		_showProgressBar(true);
		$.post(actionSrc, Params, function(Params)
		{
			$("#blackListSourceListMaintDiv_id_" + _pageRef).html(Params);
			showHideSrchGrid('blackListSourceListGridTbl_Id_' + _pageRef);
			_showProgressBar(false);
		}, "html");

	}
	
}
	/**
	 *  new btn
	* 
	* @returns
	*/
	function blackListSourceList_onAddClicked()
	{
		var changes = $("#blackListSourceMaintFormId_" + _pageRef).hasChanges();
		if (changes == 'true' || changes == true)
		{
			_showConfirmMsg(changes_made_confirm_msg, "",
					"confirm_openNewBlackListSourceRequest", "yesNo");// Confirmation
																	// call
			// if changes made
		}
		else
		{
			confirm_openNewBlackListSourceRequest(true);
		}
	}

	function confirm_openNewBlackListSourceRequest(yesNo)
	{
		if (yesNo == true)
		{
			blackListSource_openNewRequest();
		}
	}

	function blackListSource_openNewRequest()
	{
		var iv_crud = $("#iv_crud_" + _pageRef).val();
		var params = {
			"iv_crud" : iv_crud,
			"_pageRef" : _pageRef
		};
		var actionSrc = jQuery.contextPath
				+ "/path/blackListSource/BlackListSourceMaintAction_reload.action";

		
			_showProgressBar(true);
			$.post(actionSrc, params, function(params)
			{
				$("#blackListSourceListMaintDiv_id_" + _pageRef).html(params);
				$("#blackListSourceListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
				var isDisplayed = $(
						"#gview_" + "blackListSourceListGridTbl_Id_" + _pageRef).find(
						'.ui-jqgrid-bdiv').css('display');
				if (isDisplayed == "block")
				{
					showHideSrchGrid("blackListSourceListGridTbl_Id_" + _pageRef);
				}
				_showProgressBar(false);
			}, "html");
		
	}
	
	
	
	function saveUpdBlackListSource(methodName)
	{
	  $("#saveUpdBlackListSource_"+_pageRef).val(methodName);	
	}

	function blackListSourceMaint_processSubmit()
	{
	        var methodName   = $("#saveUpdBlackListSource_"+_pageRef).val();
	        
	      blackListSourceMaint_submit(true,{methodName:methodName});
	   
	}

	function blackListSourceMaint_submit()
	{

		var confrmMsg;
		var actionName;

		 var methodName   = $("#saveUpdBlackListSource_"+_pageRef).val();
	    


		if (methodName == 'save' || methodName == 'update'|| methodName == 'updateAfterApprove')
		{
			var changes = $("#blackListSourceMaintFormId_" + _pageRef).hasChanges(true);
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
			actionName = "saveBlackListSource";
		}
		else if (methodName == 'update' || methodName == 'updateAfterApprove')
		{
			actionName = "updateBlackListSource";
		}
		else if (methodName == 'cancel')
		{
			confrmMsg = Confirm_Cancel_key;
			actionName = "cancel";
		}
		
		else if (methodName == 'approve')
		{
			confrmMsg = Confirm_Approve_Record_key;
			actionName = "approveBlackListSource";
		}

		

		_showConfirmMsg(confrmMsg, "", "blackListSource_afterConfirmation", {
			methodName : methodName,
			actionName : actionName
		});

	}

	function blackListSource_afterConfirmation(confirm, args)
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
		

		var theForm = $("#blackListSourceMaintFormId_" + _pageRef).serializeForm();

		var actionSrc = jQuery.contextPath
				+ "/path/blackListSource/BlackListSourceMaintAction_"
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
							|| methodName.indexOf("delete") != -1
							|| methodName.indexOf("updateAfterApprove") != -1
							|| methodName.indexOf("approve") != -1
							|| methodName.indexOf("cancel") != -1)
					{

						if (methodName == 'save' || methodName == 'update' ||
										methodName =='updateAfterApprove'
								)
						{
							_showProgressBar(false);
							_showErrorMsg(record_saved_successfully_key,
									success_msg_title);
							blackListSource_openNewRequest();

						}
						
						else if (methodName == 'delete')
						{
							blackListSource_openNewRequest();
							_showErrorMsg(Record_was_Deleted_Successfully_key,
									success_msg_title);
							_showProgressBar(false);

							return;
						}
						else if (methodName == 'cancel')
						{
							blackListSource_openNewRequest();
							_showErrorMsg(Record_Was_Cancelled_Successfully,
									success_msg_title);
							_showProgressBar(false);
							return;
						}
						else if (methodName == 'approve')
						{
							
							blackListSource_openNewRequest();

							_showErrorMsg(record_was_approved_Successfully_key,
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
	
	function blackListSource_onStatusClicked()
	{
		var status = $("#status_" + _pageRef).val();
		var code = $("#CODE_" + _pageRef).val();

		if (status == "" || code== "")
			return;

		var loadSrc = jQuery.contextPath
				+ "/path/blackListSource/BlackListSourceStatusAction_search.action?_pageRef="
				+ _pageRef;

		showStatus("blackListSourceMaintFormId_" + _pageRef, _pageRef, loadSrc, {
			"criteria.status" : status,
			"criteria.code" : code

			
		});
	}


	