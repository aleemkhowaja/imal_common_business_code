function scoringControlRecordMaint_processSubmit()
{
  alert("Coding Needed of scoringControlRecordMaint_onDbClickedEvent()");
}


function scoringControlRecordAddFunc()
{

	var balGrid = $("#ScoringControlRecorddetailsGrid_Id_" + _pageRef);
	var rowIds = balGrid.jqGrid('getDataIDs');
	var addRowFlag = true;
	var empty = 0;
	var rowtoScore =0;

	if (rowIds.length >= 1) {
		for (i = 0; i < rowIds.length; i++) {
			var rowid = rowIds[i];
			var myObject = balGrid.jqGrid('getRowData', rowIds[i]);

			var rowfromScore = myObject["cifControlDefineScoreRangeVO.FROM_SCORE"];
			 rowtoScore = myObject["cifControlDefineScoreRangeVO.TO_SCORE"];
			var rowriskLevel = myObject["cifControlDefineScoreRangeVO.RISK_LEVEL"];


			if (rowfromScore == "" || rowtoScore == "" || rowriskLevel == "") {
				empty = 1;
				
				break;
			}
		}
		if ( empty != 1) 
		{
			var newRowId=balGrid.jqGrid('addInlineRow', {});
			rowtoScore=Number(unformatNumber(rowtoScore));
			var dec= Number(unformatNumber(0.001));
			var toScore=rowtoScore+dec;
			toScore=toScore.toFixed(3);
			balGrid.jqGrid('setCellValue', newRowId,"cifControlDefineScoreRangeVO.FROM_SCORE",toScore ,true);
		}
	}
	else
	{
		balGrid.jqGrid('addInlineRow', {});
		var rowIds = balGrid.jqGrid('getDataIDs');
		var rowId = rowIds[rowIds.length - 1];
		balGrid.jqGrid('setSelection', rowId, false);// setting selection to newly added row
		balGrid.jqGrid('editRow', rowId);
	}
	var theform = document.getElementById("scoringControlRecordMaintFormId_" + _pageRef);
	$.data(theform, 'changeTrack', true);

}

function scoringControlRecordDeleteFunc() 
{

	_showConfirmMsg(Confirm_Delete_Process_key, "",
			"scoringControlRecordDelete", "yesNo");
}

function scoringControlRecordDelete(yesNo)
{
	if (yesNo == true) 
	{
		var rowId = $("#ScoringControlRecorddetailsGrid_Id_" + _pageRef).jqGrid(
				'getGridParam', 'selrow');

		$("#ScoringControlRecorddetailsGrid_Id_" + _pageRef).jqGrid(
				'deleteGridRow', rowId);
		var theform = document.getElementById("scoringControlRecordMaintFormId_" + _pageRef);
		$.data(theform, 'changeTrack', true);
	}
}
function saveUpScoringControlRecord(methodName)
{
	//by bilal for BUG#973477
	var status = $("#status_desc_" + _pageRef).val();
	if(methodName == "save" && status != "" && status != null)
	{
		methodName = "update";
	}
	//end bilal
	$("#saveUpScoringControlRecord_"+_pageRef).val(methodName);	
}

function scoringControlRecordMaint_processSubmit()
{
        var methodName   = $("#saveUpScoringControlRecord_"+_pageRef).val();
        
        scoringControlRecordMaint_submit(true,{methodName:methodName})
   
}

function scoringControlRecordMaint_submit(args)
{

	var confrmMsg;
	var actionName;
	//if(confirm)
  //  {
	 var methodName   = $("#saveUpScoringControlRecord_"+_pageRef).val();
    //}


	if (methodName == 'save' || methodName == 'update'
			|| methodName == 'updateAfterApprove')
	{
		// checkIfGridsChanges();
		var changes = $("#scoringControlRecordMaintFormId_" + _pageRef).hasChanges(true);
		if (changes != true)
		{
			return;
		}
		confrmMsg = Confirm_Save_key;
	}
	else if (methodName == 'approve')
	{
		confrmMsg = Confirm_Approve_Record_key;
		actionName = "approveScoringControlRecord";
	}

	
	if (methodName == 'save')
	{
		actionName = "save";
	}
	else if (methodName == 'update' || methodName == 'updateAfterApprove')
	{
		actionName = "updateScoringControlRecord";
	}
	else if (methodName == 'cancel')
	{
		confrmMsg = Confirm_Cancel_key;
		actionName = "cancel";
	}


	_showConfirmMsg(confrmMsg, "", "scoringControlRecord_afterConfirmation", {
		methodName : methodName,
		actionName : actionName
	});

}

function scoringControlRecord_afterConfirmation(confirm, args)
{
	var methodName = args.methodName;
	var actionName = args.actionName;

	if (confirm)
	{
		continueSaveScoringControlRecord(methodName, actionName);
	}
}

function continueSaveScoringControlRecord(methodName, actionName)
{
	var table1 = $("#ScoringControlRecorddetailsGrid_Id_" + _pageRef);
	var prfCategCashGrid = table1.jqGrid('getAllRows');
	var prfCategCashUpdatedList = table1.jqGrid('getChangedRowData');
	
	//added by bilal for BUG#936058
	if (methodName == 'save' || methodName == 'update'
		|| methodName == 'updateAfterApprove')
	{
		var rows = table1.jqGrid('getDataIDs');
		var rowsLen = rows.length;

		if (rowsLen > 1) {
			for (i = 0; i < rowsLen; i++) {
				var fromScore = table1.jqGrid('getCell', rows[i],
				'cifControlDefineScoreRangeVO.FROM_SCORE');
				var toScore = table1.jqGrid('getCell', rows[i],
				'cifControlDefineScoreRangeVO.TO_SCORE');
				if ( (toScore == null || toScore == "" || toScore == 0) || (fromScore == null || fromScore == "" || fromScore == 0)) 
				{
					_showErrorMsg(to_from_Score_Cannot_Be_Empty_key);
					return;
				}
			}
		}
	}
	//end bilal
	
	$("#allControlRecordDetailsData_" + _pageRef).val(prfCategCashGrid);
	$("#updatedListControlRecord_" + _pageRef).val(prfCategCashUpdatedList);

	var theForm = $("#scoringControlRecordMaintFormId_" + _pageRef).serializeForm();

	var actionSrc = jQuery.contextPath
			+ "/path/scoringControlRecord/ScoringControlRecordMaintAction_"
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
					//by bilal for BUG#973477
					var theFormChange = document.getElementById("scoringControlRecordMaintFormId_" + _pageRef);
					$.data(theFormChange, 'changeTrack', false);

					if (methodName == 'save' || methodName == 'update'|| methodName == 'updateAfterApprove')
					{
						if (methodName == 'save')
						{
							$("#status_" + _pageRef).val(data["scoringControlRecordCO"]["cifControlDefineScoreRangeVO"]["ENTITY_STATUS"]);
							$("#status_desc_" + _pageRef).val(data["scoringControlRecordCO"]["statusDesc"]);
						}
						
						_showErrorMsg(record_saved_successfully_key,
								success_msg_title);
						_showProgressBar(false);
						$("#ScoringControlRecorddetailsGrid_Id_" + _pageRef).trigger("reloadGrid"); //by bilal for BUG#973477
						//by bilal for TP#987360
						if (methodName == 'updateAfterApprove')
						{
							document.getElementById("update_after_approve_btn_" + _pageRef).style.visibility="hidden"; //by bilal for BUG#987360
						}
						reloadScoringSreen(); //by bilal for TP#987360
						return;

					}
					else if (methodName == 'approve')
					{
						

						_showErrorMsg(record_was_approved_Successfully_key,
								success_msg_title);
						_showProgressBar(false);
						$("#ScoringControlRecorddetailsGrid_Id_" + _pageRef).trigger("reloadGrid"); //by bilal for BUG#973477
						document.getElementById("approve_btn_" + _pageRef).style.visibility="hidden"; //by bilal for BUG#973477
						reloadScoringSreen();
						return;
					}
					else if (methodName == 'cancel')
					{
						_showErrorMsg(Record_Was_Cancelled_Successfully,
								success_msg_title);
						_showProgressBar(false);
						$("#ScoringControlRecorddetailsGrid_Id_" + _pageRef).trigger("reloadGrid"); //by bilal for BUG#973477
						document.getElementById("cancel_btn_" + _pageRef).style.visibility="hidden"; //by bilal for BUG#973477
						reloadScoringSreen();
						return;
					}
					

				}
			}
			_showProgressBar(false);
		}
	});
}

function validateFromToScore() {
	var balGrid = $("#ScoringControlRecorddetailsGrid_Id_" + _pageRef);
	var selRow = balGrid.jqGrid("getGridParam", 'selrow');

	var fromScore = balGrid.jqGrid('getCell', selRow,
			'cifControlDefineScoreRangeVO.FROM_SCORE');
	var toScore = balGrid.jqGrid('getCell', selRow,
			'cifControlDefineScoreRangeVO.TO_SCORE');
	fromScore = Number(unformatNumber(fromScore));
	toScore   = Number(unformatNumber(toScore));
    var overlapFlag = 0;
	var rows = balGrid.jqGrid('getDataIDs');
	var rowsLen = rows.length;

	if (rowsLen > 1) {
		for (i = 0; i < rowsLen; i++) {
			if (rows[i] == selRow) {
				//change/added by bilal for BUG#936058
				if(i != rowsLen -1)
				{
					var myObject = balGrid.jqGrid('getRowData', rows[i+1]);
					var rowFromScore = myObject["cifControlDefineScoreRangeVO.FROM_SCORE"];
					var rowToScore = myObject["cifControlDefineScoreRangeVO.TO_SCORE"];
					
					rowFromScore = Number(unformatNumber(rowFromScore));
					rowToScore   = Number(unformatNumber(rowToScore));
				}

				debugger;
				if ( toScore != null && toScore != "" && toScore != 0) 
				{
					//if(i == rowsLen -1)
					//{
					if(toScore <= fromScore && fromScore != "")
					{
						balGrid.jqGrid("setCellValue", selRow,
								'cifControlDefineScoreRangeVO.TO_SCORE', null,false);
						_showErrorMsg(To_Score_Cannot_Be_Less_Than_Or_Equal_From_Score_key);
						return;
					}
					//}
					else
					{
						if(toScore >= rowFromScore && rowFromScore != "")
						{
							overlapFlag = 1;
						}
						else
						{
							overlapFlag = 0;
							var dec = Number(unformatNumber(0.001));
							var nextFromScore = toScore + dec;
							nextFromScore = nextFromScore.toFixed(3);
							balGrid.jqGrid('setCellValue', rows[i+1],"cifControlDefineScoreRangeVO.FROM_SCORE",nextFromScore ,true)
						}
					}
					
					if(overlapFlag == 1)
					{
						balGrid.jqGrid("setCellValue", selRow,
								'cifControlDefineScoreRangeVO.TO_SCORE', null,false);
						
							_showErrorMsg(To_Score_Cannot_Be_Greater_Than_From_Score_key);
							return;
					}
				}
				else
				{
					balGrid.jqGrid("setCellValue", selRow,
							'cifControlDefineScoreRangeVO.TO_SCORE', null,false);
					_showErrorMsg(To_Score_Cannot_Be_Empty_key);
					return;
				}
			}
		}
	}
}

function scoringControlRecord_onStatusClicked()
{
	var status = $("#statusFlags_" + _pageRef).val();
	var statusDesc =  $("#status_desc_" + _pageRef).val();
	var grid = $("#ScoringControlRecorddetailsGrid_Id_" + _pageRef);
	//commented by bilal for TP#987360
//	var scoreCode = grid.jqGrid('getCell', 1,
//	'scoringControlRecord_onStatusClicked.SCORE_CODE');
	
	if (status == "" && statusDesc != "")
	{
		status = "U";
	}
	
	if (status == "")
		return;

	var loadSrc = jQuery.contextPath
			+ "/path/scoringControlRecord/ScoringControlRecordStatusAction_search.action?_pageRef="
			+ _pageRef;

	showStatus("scoringControlRecordMaintFormId_" + _pageRef, _pageRef, loadSrc, {
		"criteria.status" : status
	});
}


function scoringControlRecord_completeFunc(obj)
{
	var table = $("#ScoringControlRecorddetailsGrid_Id_" + _pageRef);
	var recList = table.jqGrid('getDataIDs');
	var rowId;
	
	for (var i = 1; i <= recList.length; i++)

	{
		rowId = recList[i - 1];
		
		if (i >1 )
			{table.jqGrid('setCell', rowId, "cifControlDefineScoreRangeVO.FROM_SCORE", table.jqGrid('getCell', rowId, "cifControlDefineScoreRangeVO.FROM_SCORE"),"not-editable-cell");}
		

	}
}

function reloadScoringSreen()
{
	_showProgressBar(true);
	var iv_crud = $("#iv_crud_" + _pageRef).val();
	var params = {
			"iv_crud" : iv_crud,
			"_pageRef" : _pageRef
		};
	
	//by bilal for TP#$987360
	var src = jQuery.contextPath + "/path/scoringControlRecord/ScoringControlRecordMaintAction_loadControlRecordPage.action";
	
	$.post(src, params, function(param)
	{
		$("#scoringControlMain_" + _pageRef).html(param);
	}, "html");
	
	_showProgressBar(false);
}