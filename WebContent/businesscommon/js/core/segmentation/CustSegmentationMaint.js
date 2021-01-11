// Button in Detail Grid : Details
function criteria_detailsbtn(cellValue, options, rowObject)
{
	return '<a href = "#" onclick="criteria_detailsDialog(' + options.rowId + ');">' + Details_key + '</a>';
}

function criteria_detailsDialog(rowindex)
{
	var $t = $("#custSegmentationDetailList_Id_" + _pageRef);
	//by bilal for BUG#983146
	var rowIndexId = rowindex.id;
	if(rowIndexId == "undefined" || rowIndexId == "" || rowIndexId == null)
	{
		$t.jqGrid('setSelection', rowindex);
	}
	else
	{
		$t.jqGrid('setSelection', rowIndexId);
	}
	//end bilal
	selRow = $t.jqGrid("getGridParam", 'selrow');
	var myObject = $t.jqGrid('getRowData', selRow);

	var criteria_no = myObject["ctsSegmentDetVO.CRITERIA_CODE"];

	if (criteria_no == "")
	{
		return;
	}
	// var branchCode = myObject["banch_code"];
	var iv_crud = $("#iv_crud_" + _pageRef).val();

	var statusDiv = $("<div id='dialog_div_c" + selRow + "_" + _pageRef + "'/>");
	statusDiv.css("padding", "0");

	var theForm = $("#custSegmentationMaintFormId_" + _pageRef);
	statusDiv.insertAfter(theForm);

	var mySrc = jQuery.contextPath + "/path/criteria/criteriaMaint_loadCriteriaDetails";

	var params = {
			"criteriaCO.ctsCriteriaVO.CRITERIA_CODE" : criteria_no,
			"_pageRef" : _pageRef,
			"iv_crud" : iv_crud,
			"_recReadOnly" : "true",
			"popupMode" : "true"
	};
	_showProgressBar(true); //by bilal for BUG#827425
	$("#dialog_div_c" + selRow + "_" + _pageRef).load(mySrc, params, function()
	{
		$("#dialog_div_c" + selRow + "_" + _pageRef).dialog({
				modal : true,
				title : 'Criteria Details',
				autoOpen : false,
				show : {
					effect : "slide",
					duration : 100,
					complete : function() {
						_showProgressBar(false); //by bilal for BUG#827425
					}
				},
				position : 'center',
				width : '1100',
				height : '500',
				buttons : {
					"ok" : function()
					{
						var theDialog = $(this);
						theDialog.remove();
					}
				},
				close : function()
				{
					var theDialog = $(this);
					theDialog.remove();
				}
		});
		$("#dialog_div_c" + selRow + "_" + _pageRef).dialog("open");
	});
}

function validateDuplicateSegPrioritiesValue()
{
	var segDefinePrioritiesGrid = $("#segDefPrioritiesGridTbl_Id_" + _pageRef);
	var rowsIds = segDefinePrioritiesGrid.jqGrid('getDataIDs');

	// Retrieve the selected row
	var selRow = segDefinePrioritiesGrid.jqGrid("getGridParam", 'selrow');
	var selRowPrioritiesObject = segDefinePrioritiesGrid.jqGrid('getRowData', selRow);
	var selRowPrioritiesValue = selRowPrioritiesObject["ctsSegmentVO.AMENDED_PRIORITY"]; //Rania - Customers Segmentation Enhancement

	for (var i = 0; i < rowsIds.length; i++)
	{
		var rowId = rowsIds[i];
//debugger;
		if (rowId != selRow)
		{
			var myCurrentObject = segDefinePrioritiesGrid.jqGrid('getRowData', rowId);
			var currentValue = myCurrentObject["ctsSegmentVO.PRIORITY"];
			if (currentValue == selRowPrioritiesValue)
			{
				segDefinePrioritiesGrid.jqGrid("setCellValue", selRow, "ctsSegmentVO.AMENDED_PRIORITY", null); //Rania - Customers Segmentation Enhancement
				_showErrorMsg("Duplicate Value", "Warning");
			}
		}
	}
}

function validateSegPrioritiesOnSave()
{
	var segDefinePrioritiesGrid = $("#segDefPrioritiesGridTbl_Id_" + _pageRef);
	var rowsIds = segDefinePrioritiesGrid.jqGrid('getDataIDs');

	for (var i = 0; i < rowsIds.length; i++)
	{
		var rowId = rowsIds[i];
		var myCurrentObject = segDefinePrioritiesGrid.jqGrid('getRowData', rowId);
		if (myCurrentObject["ctsSegmentVO.AMENDED_PRIORITY"] == "")
		{
			_showErrorMsg("Missing Value", "Warning");
			return false;
		}
	}
	return true;
}

// Abdo Segmentation Priorties 09/08/2017
function segDefPriorities_processSubmit(methodName)
{
	if (!validateSegPrioritiesOnSave())
	{
		return;
	}
	// saveSegDefPriorities
	var methodName = $("#methodName_" + _pageRef).val(); // methodName :
	_showProgressBar(true);
	custSegmentation_prepareAllRecordGrid(methodName);

	var theForm = $("#segDefPrioritiesFormId_" + _pageRef).serializeForm();

	var actionPath = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_" + methodName;

	$.ajax({
			url : actionPath,
			type : "post",
			dataType : "json",
			data : theForm,
			success : function(data)
			{
				if (typeof data["_error"] == "undefined" || data["_error"] == null)
				{
					$("#segDefPrioritiesFormId_" + _pageRef).data("changeTrack", false);
					_showErrorMsg(record_saved_Successfully_key, info_msg_title);

					$("#segDefPrioritiesGridTbl_Id_" + _pageRef).trigger("reloadGrid");
				}
				else
				{
					_showErrorMsg(data._error, error_msg_title)

				}
				_showProgressBar(false);

			}
	});

}

// Button in Detail Grid : Parameter Details
function criteriaParameterDetailsbtn(cellValue, options, rowObject)
{
	//By Bilal For TP#750884 fix the rowId //(options.rowId).replace("new_", "")
	//by bilal for BUG#983146
	return '<a href = "#" onclick="criteriaParameterDetailsDialog(' + options.rowId + ')">' + param_details_key + '</a>';
}

function criteriaParameterDetailsDialog(rowindex)
{
	//debugger;
	var theForm = $("#custSegmentationMaintFormId_" + _pageRef);
	var $t = $("#custSegmentationDetailList_Id_" + _pageRef);
	//by bilal for BUG#983146
	var rowIndexIdParam = rowindex.id;
	if(rowIndexIdParam == "undefined" || rowIndexIdParam == "" || rowIndexIdParam == null)
	{
		$t.jqGrid('setSelection', rowindex);
	}
	else
	{
		$t.jqGrid('setSelection', rowIndexIdParam);
	}
	//end bilal
	var selRow = $t.jqGrid("getGridParam", 'selrow');
	var myObject = $t.jqGrid('getRowData', selRow);
	$("#paramIsOpen_" + _pageRef).val(1);

	var criteria_no = myObject["ctsSegmentDetVO.CRITERIA_CODE"];
	if (criteria_no == "")
	{
		return;
	}
	
	$("#_criteriaCode_").val(criteria_no); //By Bilal For TP#750884
	$("#_rowId").val(selRow); //By Bilal For TP#750884
	
	var segCode = $("#code_" + _pageRef).val();
	var segLineNo = myObject["ctsSegmentDetVO.LINE_NO"];

	if (segLineNo == null || segLineNo == "")
	{
		segLineNo = selRow.replace("new_", "");
	}
//Rania - ABSAI180073
	var actionPath = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_returnQueryID.action?";
	var paramObj = {
			"custSegmentationCO.ctsSegmentDetVO.CRITERIA_CODE" : criteria_no
	};
	var queryID, queryDesc;
	_showProgressBar(true); //by bilal for BUG#827425
	$.ajax({
		url : actionPath,
		type : "post",
		dataType : "json",
		data : paramObj,
		success : function(data)
		{
			if (typeof data["_error"] == "undefined" || data["_error"] == null)
			{
				if(data.custSegmentationCO != undefined)
				{
					queryID = data.custSegmentationCO.queryID
					queryDesc = data.custSegmentationCO.queryDesc
				}
				
				
				// var branchCode = myObject["banch_code"];
				var iv_crud = $("#iv_crud_" + _pageRef).val();

				var mySrc = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_loadSegParams.action?";

				var params = {
						"custSegmentationSC.criteria_code" : criteria_no,
						"custSegmentationSC.segment_code" : segCode,
						"custSegmentationSC.lineNo" : segLineNo,
						"_pageRef" : _pageRef,
						"custSegmentationSC.segDetailRowId" : selRow
				};

				if ($("#dialog_div_p" + selRow + "_" + _pageRef).html() == null || $("#dialog_div_p" + selRow + "_" + _pageRef).html() == "")
				{
					var statusDiv = $("<div id='dialog_div_p" + selRow + "_" + _pageRef + "'/>");
					statusDiv.css("padding", "0");

					statusDiv.insertAfter(theForm);

					$("#dialog_div_p" + selRow + "_" + _pageRef).load(mySrc, params, function()
					{
						$("#dialog_div_p" + selRow + "_" + _pageRef).dialog({
								modal : true,
								title : 'Criteria Details',
								autoOpen : false,
								show : {
									effect : "slide",
									duration : 100,
									complete : function() {
										_showProgressBar(false); //by bilal for BUG#827425
									}
								},
								position : 'center',
								width : '1100',
								height : '500',
								buttons : {
									"ok" : function()
									{
										var queryParamGridId = $(this).find("#queryGridId").val(); // $('#queryGridId').val();
										var procParamGridId = $(this).find("#procGridId").val(); // $('#procGridId').val();

										//by bilal for issue the hidden column contain the selected value from livesearch
										var rowsIdsQryParam =  $("#" + queryParamGridId).jqGrid('getDataIDs');
										for (var i = 0; i < rowsIdsQryParam.length; i++)
										{
											var rowIdQryParam = rowsIdsQryParam[i];
											var myObjectQryParam = $("#" + queryParamGridId).jqGrid('getRowData', rowIdQryParam);
											var paramClass = myObjectQryParam["ctsSegmentParamVO.PARAM_CLASS"];
											if(paramClass == 'Q')
											{
												var qrySelectParamGridStr = myObjectQryParam["jsonMultiselectArray_multiSelectlkp_" + criteria_no];
												$("#" + queryParamGridId).jqGrid("setCellValue", rowIdQryParam, "jsonMultiselectArray", qrySelectParamGridStr);
											}
										}
										
										var queryParamGridUpdate = $("#" + queryParamGridId).jqGrid("getAllRows");
										$t.jqGrid("setCellValue", selRow, "queryParamGridStr", queryParamGridUpdate);
										
										var rowsIdsProcParam = $("#" + procParamGridId).jqGrid('getDataIDs');
										for (var i = 0; i < rowsIdsProcParam.length; i++)
										{
											var rowIdProcParam = rowsIdsProcParam[i];
											var myObjectProcParam = $("#" + procParamGridId).jqGrid('getRowData', rowIdProcParam);
											var paramClass = myObjectProcParam["ctsSegmentParamVO.PARAM_CLASS"];
											if(paramClass == 'Q')
											{
												var procSelectParamGridStr = myObjectProcParam["jsonMultiselectArray_multiSelectlkp_" + criteria_no];
												$("#" + procParamGridId).jqGrid("setCellValue", rowIdProcParam, "jsonMultiselectArray", procSelectParamGridStr);
											}
										}
										
										var procParamGridUpdate = $("#" + procParamGridId).jqGrid("getAllRows");
										$t.jqGrid("setCellValue", selRow, "procParamGridStr", procParamGridUpdate);
										//end bilal

										$t.jqGrid("setCellValue", selRow, "segmentationParamOpened", "true");

										if (segLineNo != null && segLineNo != "" && selRow.indexOf("new_") == -1)
										{
											$t.jqGrid("setGridRowStatus", selRow, 2);
										}
										
//										$("#" + queryParamGridId).jqGrid("setSelection", selRow, false);
//										$("#" + procParamGridId).jqGrid("setSelection", selRow, false);
										
										var theDialog = $(this);
										//theDialog.dialog("close");
										theDialog.dialog("destroy").appendTo(theForm);
									}
								},
								close : function()
								{
									$(this).remove();
								}
						});
						$("#dialog_div_p" + selRow + "_" + _pageRef).dialog("open");
						
						//Rania - ABSAI180073
						$("#lookuptxt_queryCode_" + _pageRef).val(queryID)
						$("#queryCodeDesc_" + _pageRef).val(queryDesc)
						//$("#_criteriaCode_").val(criteria_no); //By Bilal For TP#750884
						//
					});
				}
				else
				{
					// here the dialog is already opened
					$("#dialog_div_p" + selRow + "_" + _pageRef).dialog({
						modal : true,
						title : 'Criteria Details',
						autoOpen : false,
						show : {
							effect : "slide",
							duration : 100,
							complete : function() {
								_showProgressBar(false); //by bilal for BUG#827425
							}
						},
						position : 'center',
						width : '1100',
						height : '500',
						buttons : {
							"ok" : function()
							{
								var queryParamGridId = $(this).find("#queryGridId").val(); // $('#queryGridId').val();
								var procParamGridId = $(this).find("#procGridId").val(); // $('#procGridId').val();
								
								//by bilal for issue the hidden column contain the selected value from livesearch
								var rowsIdsQryParam =  $("#" + queryParamGridId).jqGrid('getDataIDs');
								for (var i = 0; i < rowsIdsQryParam.length; i++)
								{
									var rowIdQryParam = rowsIdsQryParam[i];
									var myObjectQryParam = $("#" + queryParamGridId).jqGrid('getRowData', rowIdQryParam);
									var paramClass = myObjectQryParam["ctsSegmentParamVO.PARAM_CLASS"];
									if(paramClass == 'Q')
									{
										var qrySelectParamGridStr = myObjectQryParam["jsonMultiselectArray_multiSelectlkp_" + criteria_no];
										$("#" + queryParamGridId).jqGrid("setCellValue", rowIdQryParam, "jsonMultiselectArray", qrySelectParamGridStr);
									}
								}
								
								var queryParamGridUpdate = $("#" + queryParamGridId).jqGrid("getAllRows");
								$t.jqGrid("setCellValue", selRow, "queryParamGridStr", queryParamGridUpdate);
								
								var rowsIdsProcParam = $("#" + procParamGridId).jqGrid('getDataIDs');
								for (var i = 0; i < rowsIdsProcParam.length; i++)
								{
									var rowIdProcParam = rowsIdsProcParam[i];
									var myObjectProcParam = $("#" + procParamGridId).jqGrid('getRowData', rowIdProcParam);
									var paramClass = myObjectProcParam["ctsSegmentParamVO.PARAM_CLASS"];
									if(paramClass == 'Q')
									{
										var procSelectParamGridStr = myObjectProcParam["jsonMultiselectArray_multiSelectlkp_" + criteria_no];
										$("#" + procParamGridId).jqGrid("setCellValue", rowIdProcParam, "jsonMultiselectArray", procSelectParamGridStr);
									}
								}
								
								var procParamGridUpdate = $("#" + procParamGridId).jqGrid("getAllRows");
								$t.jqGrid("setCellValue", selRow, "procParamGridStr", procParamGridUpdate);
								//end bilal
					
								$t.jqGrid("setCellValue", selRow, "segmentationParamOpened", "true");
					
								if (segLineNo != null && segLineNo != "" && selRow.indexOf("new_") == -1)
								{
									$t.jqGrid("setGridRowStatus", selRow, 2);
								}
								
//								$("#" + queryParamGridId).jqGrid("setSelection", selRow, false);
//								$("#" + procParamGridId).jqGrid("setSelection", selRow, false);
								
								var theDialog = $(this);
								$("#dialog_div_p" + selRow + "_" + _pageRef).dialog("close");
							}
						},
						close : function()
						{
							$("#dialog_div_p" + selRow + "_" + _pageRef).dialog("close");
						}
					});
					
					$("#dialog_div_p" + selRow + "_" + _pageRef).dialog("open");
				}
			}
		}
	});
}

function custSegmentation_onStatusClicked()
{
	var segmentCode = $("#code_" + _pageRef).val();
	if (segmentCode == "")
	{
		return;
	}

	var theParams = {
		segment_code : segmentCode,
		progRef : _pageRef
	};
	// TODO pass correct parameters from the Form
	// var linkCode = $("#lookuptxt_LINK_CODE_"+_pageRef).val();
	// theParams = {linkCode:linkCode, _pageRef:_pageRef}
	var loadSrc = jQuery.contextPath + "/path/segmentation/CustSegmentationStatusAction_search.action";
	var theFormId = "custSegmentationMaintFormId_" + _pageRef;
	showStatus(theFormId, _pageRef, loadSrc, theParams);
}

/**
 * fill the method before before submitting the form, to used in "processAfterValid"
 */
function amendMethodName(methodName)
{
	$("#methodName_" + _pageRef).val(methodName);

}

function saveCustSegmentation()
{
	var methodName = $("#methodName_" + _pageRef).val(); // methodName :
	var confirmMsg;
	var changes = "";

	var grid = $("#custSegmentationDetailList_Id_" + _pageRef);
	var rowsIds = grid.jqGrid('getDataIDs');

	var hasChanges = false;

	for (var i = 0; i < rowsIds.length; i++)
	{
		var rowId = rowsIds[i];
		var myObject = grid.jqGrid('getRowData', rowId);
		var queryParamGridStr = myObject["queryParamGridStr"];
		var procParamGridStr = myObject["procParamGridStr"];
		var criteria_code = myObject["ctsSegmentDetVO.CRITERIA_CODE"]; //By Bilal For TP#750884
		var lineNo = myObject["ctsSegmentDetVO.LINE_NO"]; //By Bilal For TP#750884
		
		if (queryParamGridStr == "" && procParamGridStr == "" && !hasChanges)
		{
			hasChanges = false;
		}
		else
		{
			hasChanges = true;
			break;
		}
		
		//By Bilal For TP#750884
		if(hasChanges == false)
		{
			var querySelectParamGrid = $("#queryParamGridTbl_Id_" + criteria_code + "_" + lineNo + "_" + _pageRef);
			var rowsIdsQueryParam = querySelectParamGrid.jqGrid('getDataIDs');
			for (var j = 0; j < rowsIdsQueryParam.length; j++)
			{
				var rowIdQueryParam = rowsIdsQueryParam[j];
				var myObjectQueryParam = querySelectParamGrid.jqGrid('getRowData', rowIdQueryParam);
				var querySelectParamGridStr = myObjectQueryParam["querySelectParamGridStr"];
				
				if (querySelectParamGridStr == "" && !hasChanges)
				{
					hasChanges = false;
				}
				else
				{
					hasChanges = true;
					break;
				}
			}
		}
		
		if(hasChanges == false)
		{
			var procSelectParamGrid = $("#procParamGridTbl_Id_" + criteria_code + "_" + lineNo + "_" + _pageRef);
			var rowsIdsProcParam = procSelectParamGrid.jqGrid('getDataIDs');
			for (var j = 0; j < rowsIdsProcParam.length; j++)
			{
				var rowIdProcParam = rowsIdsProcParam[j];
				var myObjectProcParam = procSelectParamGrid.jqGrid('getRowData', rowIdProcParam);
				var procSelectParamGridStr = myObjectProcParam["querySelectParamGridStr"];
				
				if (procSelectParamGridStr == "" && !hasChanges)
				{
					hasChanges = false;
				}
				else
				{
					hasChanges = true;
					break;
				}
			}
		}
		//end
		
	}
	
	if(hasChanges == false && methodName == 'saveSegment')
	{
		changes = $("#custSegmentationMaintFormId_" + _pageRef).hasChanges(true);
	}
	
	
	if(changes == true || hasChanges == true)
	{
		changes = true;
	}
	else
	{
		changes = false;
	}
	
	if(changes == true && methodName == 'saveSegment')
	{
		confirmMsg = Confirm_Save_Process_key;
		_showConfirmMsg(confirmMsg, Warning_key, custSegmentationMaint_processSubmit, {});
	}
	
	if (methodName != 'saveSegment')
	{
		if (methodName == 'approveSegment')
		{
			confirmMsg = Confirm_Approve_Process_key;
		}
		else if (methodName == 'rejectSegment')
		{
			confirmMsg = Confirm_Reject_Process_key;
		}
		else if (methodName == 'updateAfterApproveSegment')
		{
			confirmMsg = Confirm_Save_Process_key;
		}
		else if (methodName == 'deleteSegment')
		{
			confirmMsg = Confirm_Delete_key;
		}
		// Rania - 718813 - Dynamic Customer Scoring on latest
		else if (methodName == 'suspendSegment')
		{
			confirmMsg = Confirm_Suspend_Process_key;
		}
		else if (methodName == 'approveSuspendSegment')
		{
			confirmMsg = Confirm_Approve_Process_key;
		}
		else if (methodName == 'reactivateSegment')
		{
			confirmMsg = Confirm_Reactivate_Process_key;
		}
		else if (methodName == 'approveReactivateSegment')
		{
			confirmMsg = Confirm_Approve_Process_key;
		}
		else if (methodName == 'cancelSegment')
		{
			confirmMsg = confirm_cancel_process_key;
		}
		else if (methodName == 'approveCancelSegment')
		{
			confirmMsg = Confirm_Approve_Process_key;
		}
		else if (methodName == 'copySegment')
		{
			confirmMsg = Confirm_Copy_key;
		}
		// End Rania
		
		_showConfirmMsg(confirmMsg, Warning_key, custSegmentationMaint_processSubmit, {});
	}
}

// Abdo define priorities 09/08/2017
function saveSegDefPriorities()
{
	var methodName = $("#methodName_" + _pageRef).val(); // methodName :
	if (methodName == 'saveSegDefPriorities')
	{
		segDefPriorities_processSubmit(methodName);
	}

}

// on save
function custSegmentationMaint_processSubmit(confirm)
{
	if (confirm)
	{
		var methodName = $("#methodName_" + _pageRef).val(); // methodName :
		var segmentType = $("#isSegmentationScore_" + _pageRef).val()
		//Modified By Ali for TP#864398
		if (methodName == 'approveSegment' && ($("#priority_" + _pageRef).val() == null || $("#priority_" + _pageRef).val() == "") && segmentType != "SC" && segmentType != "BR")
		{
			_showErrorMsg("Priority is not defined", error_msg_title);
			return false;
		}

		// saveCommodity
		// (save/Maintenance)
		_showProgressBar(true);
		custSegmentation_prepareAllRecordGrid(methodName);

		var theForm = $("#custSegmentationMaintFormId_" + _pageRef).serializeForm();
		var actionPath = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_" + methodName;

		// paramagteres new_record = false

		$.ajax({
				url : actionPath,
				type : "post",
				dataType : "json",
				data : theForm,
				success : function(data)
				{
					if (typeof data["_error"] == "undefined" || data["_error"] == null)
					{
						// $("#stfCommodityMarketPriceListGridTbl_Id_" +
						// _pageRef)
						// .trigger("reloadGrid");

						if (methodName == 'saveSegment')
						{
							_showErrorMsg(Saved_Successfully_key, info_msg_title);
								//Modified By Ali for TP#864398
							if($("#isSegmentationScore_" + _pageRef).val() != "SC"  &&  $("#isSegmentationScore_" + _pageRef).val() != "BR")
							{
								_showErrorMsg("Please define priority", Warning_key);
							}

							var grid = $("#custSegmentationDetailList_Id_" + _pageRef);
							var rowsIds = grid.jqGrid('getDataIDs');

							for (var i = 0; i < rowsIds.length; i++)
							{
								var rowId = rowsIds[i];
								var myObject = grid.jqGrid('getRowData', rowId);

								$("#dialog_div_c" + rowId + "_" + _pageRef).remove();
								$("#dialog_div_p" + rowId + "_" + _pageRef).remove();
							}

							$("#custSegmentationListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
							openNewCustSegmentation();
						}
						else if (methodName == 'trialProcess')
						{
							cifTrialSegmentationPopup();
						}
						else
						{
							reloadPageAfterSuccessProcess();

						}
					}
					_showProgressBar(false);
				}
		});
	}
}

/*
 * saveSegment rejectSegment approveSegment updateAfterApproveSegment
 */

function reloadPageAfterSuccessProcess()
{
	_showProgressBar(false);
	var methodName = $("#methodName_" + _pageRef).val();
	if (methodName == 'approveSegment')
	{
		_showErrorMsg(approved_successfully_key, info_msg_title);
	}
	if (methodName == 'rejectSegment')
	{
		_showErrorMsg(Confirm_Reject_Process_key, info_msg_title);
	}
	else if (methodName == 'updateAfterApproveSegment')
	{
		_showErrorMsg(Saved_Successfully_key, info_msg_title);
	}
	else if (methodName == 'deleteSegment')
	{
		_showErrorMsg("Delete", info_msg_title);
	}
	// added by nour for #864398
	else if (methodName== 'suspendSegment')

	{
		_showErrorMsg(record_was_Suspended_Successfully_key,info_msg_title)
		
	}
	else if (methodName== 'approveSuspendSegment')
	{
		_showErrorMsg(record_was_approve_suspended_sucessfully_key,info_msg_title)
	}
	else if (methodName=='reactivateSegment')
	{
		_showErrorMsg(Record_was_reactivated_successfully_key,info_msg_title)

	}
	
	else if (methodName=='reactivateSegment')
	{
		_showErrorMsg(Record_was_reactivated_successfully_key,info_msg_title)

	}
	
	else if (methodName=='approveReactivateSegment')
	{
		_showErrorMsg(Record_was_approve_reactivated_successfully_key,info_msg_title)

	}
	
	$("#custSegmentationListGridTbl_Id_" + _pageRef).trigger("reloadGrid"); // custSegmentationListGridTbl_Id_${_pageRef}
	$("#custSegmentationListMaintDiv_id_" + _pageRef).html(""); // custSegmentationListMaintDiv_id_
	showHideSrchGrid('custSegmentationListGridTbl_Id_' + _pageRef);
}

/**
 * Prepare Grid data before saving
 */
function custSegmentation_prepareAllRecordGrid(methodName)
{
	var table = $("#custSegmentationDetailList_Id_" + _pageRef);
	if (methodName == "saveSegDefPriorities")
	{// Abdo define priorties
		var table = $("#segDefPrioritiesGridTbl_Id_" + _pageRef);
	}
	var jsonStringUpdates = "";

	if (methodName == "saveSegment")
	{

		var grid = $("#custSegmentationDetailList_Id_" + _pageRef);
		var rowsIds = grid.jqGrid('getDataIDs');

		var hasEmptyParam = false;
		var hasChanges = false;

		for (var i = 0; i < rowsIds.length; i++)
		{
			var rowId = rowsIds[i];
			grid.jqGrid("setCellValue", rowId, "ctsSegmentDetVO.LINE_NO", (i + 1)); //Rania - Customers Segmentation Enhancement
			var myObject = grid.jqGrid('getRowData', rowId);
			var queryParamGridStr = myObject["queryParamGridStr"];
			var procParamGridStr = myObject["procParamGridStr"];
			
			if (queryParamGridStr == "" && procParamGridStr == "" && !hasChanges)
			{
				hasChanges = false;
			}
			else
			{
				hasChanges = true;
			}

			if (i == (rowsIds.length - 1) && !hasChanges)
			{
				$("#segDefPrioritiesFormId_" + _pageRef).data("changeTrack", false);
				hasEmptyParam = true;
				break;
			}

		}
		/*if (hasEmptyParam)
		{
			jsonStringUpdates = "";
		}
		else
		{*/
			jsonStringUpdates = table.jqGrid('getAllRows');
		//}

	}
	else if (methodName == "updateAfterApproveSegment" || methodName == "saveSegDefPriorities")
	{// Abdo define priorties -Add saveSegDefPriorities
		jsonStringUpdates = table.jqGrid('getChangedRowData');

	}
	else
	{
		var rowSelected = "";
		var selectedRows = table.jqGrid('getGridParam', 'selarrrow');
		for (var i = 0; i < selectedRows.length; i++)
		{
			var gridData = table.jqGrid("getRowData", selectedRows[i]);
			rowSelected += JSON.stringify(gridData) + ",";
		}
		jsonStringUpdates = "{\"root\":[" + rowSelected + "]}";
	}
	var custSegmentationDetailList_Id_gridAllRecords = table.jqGrid('getAllRows');
	// alert ( "get all rows:" + table.jqGrid('getAllRows'));
	$("#custSegmentationDetailList_Id_gridAllRecords_" + _pageRef).val(custSegmentationDetailList_Id_gridAllRecords);
	$("#custSegmentationDetailList_Id_gridUpdate_" + _pageRef).val(jsonStringUpdates);
}

// function custSegmentationDetailList_trialProcess(){
// var segmentCode = $("#code_" + _pageRef).val();
//	
// var param = { "custSegmentationSC.segment_code" : segmentCode};
// var actionPath = jQuery.contextPath+ "/path/custSegmentation/CustSegmentationMaintAction_runTrialSegmentationProcess?";
//	
// _showProgressBar(true);
//	
// $.ajax({
// url : actionPath,
// type : "post",
// dataType : "json",
// data : param,
// success : function(data) {
// if (typeof data["_error"] == "undefined"
// || data["_error"] == null) {
//					
// _showErrorMsg(Process_Executed_Successfully_key, info_msg_title);
// }
//			
// _showProgressBar(false);
// }
// });
// }

function cifTrialSegmentationPopup()
{
	var mySrc = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_loadCifOfTrialSegmentationProcessPopup";

	var params = {};
	params["custSegmentationCO.ctsSegmentVO.SEGMENT_CODE"] = $("#code_" + _pageRef).val();

	if ($("#cifTrialSegmentationPopupDiv_" + _pageRef).html() == null)
	{
		$("#custSegmentationMaintFormId_" + _pageRef).append($("<div id='cifTrialSegmentationPopupDiv_" + _pageRef + "'/>"));
	}

	$("#cifTrialSegmentationPopupDiv_" + _pageRef).load(mySrc, params, function()
	{
		_showProgressBar(false);
	});

	$("#cifTrialSegmentationPopupDiv_" + _pageRef).dialog({
			modal : true,
			title : 'CIF Trial Segment',
			autoOpen : false,
			show : 'slide',
			position : 'center',
			width : '550',
			height : '300',
			buttons : {
				"ok" : function()
				{
					var theDialog = $(this);
					theDialog.remove();
				}
			},
			"close" : function()
			{
				var theDialog = $(this);
				theDialog.remove();
			}
	});

	$("#cifTrialSegmentationPopupDiv_" + _pageRef).dialog("open");
}

// IDs PopUp
function custSegmentationDetailList_excludeCif()
{

	var segmentCode = $("#code_" + _pageRef).val(); // id="code_${_pageRef}" name="custSegmentationCO.ctsSegmentVO.SEGMENT_CODE"
	var segmentDesc = $("#segmentDesc_" + _pageRef).val(); // segmentDesc_${_pageRef}

	// var fomParams = returnFOMPopupParams();
	if (segmentCode == "" && segmentDesc == "")
	{
		_showProgressBar(false);
		_showErrorMsg("Please check and complete " + Mandatory_Field_key, error_msg_title);
		return;
	}
	excludeCif_open(segmentCode, segmentDesc);
}

function excludeCif_open(segmentCode, segmentDesc)
{
	// custSegmentationMaintFormId
	_showProgressBar(true);
	if ($("#excludeCifDiv_" + _pageRef).html() == null || $("#excludeCifDiv_" + _pageRef).html() == "")
	{
		$("#custSegmentationMaintFormId_" + _pageRef).append($("<div id='excludeCifDiv_'" + _pageRef + " />"));
	}
	// fomParams["custSegmentationCO.ctsSegmentVO.SEGMENT_CODE"] = segmentCode;
	// fomParams["segmentDesc.ctsSegmentVO.SEGMENT_DESC"] = segmentDesc;

	var paramObj = {
			"custSegmentationCO.ctsSegmentVO.SEGMENT_CODE" : segmentCode,
			"custSegmentationCO.ctsSegmentVO.SEGMENT_DESC" : segmentDesc,
			"custSegmentationCO.segmentDesc" : segmentDesc,
			"_pageRef" : _pageRef,
			"_recReadOnly" : $("#_recReadOnly_" + _pageRef).val()
	};

	// fomParams["idType"] = $("#lookuptxt_cifVO_ID_TYPE_" + _pageRef).val();
	// var mySrc = ctxPath + "/path/fom/FomIdsList_populateIdsPopup.action";

	var mySrc = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_initializeExcludeCifDialogue";

	// if($("#fomIdsDialog_" + _pageRef).is(":empty")== true)
	// {
	$("#excludeCifDiv_" + _pageRef).empty().html("");
	$("#excludeCifDiv_" + _pageRef).load(mySrc, paramObj, function()
	{
		$("#popExcludeCIFSegCode_" + _pageRef).val($("#code_" + _pageRef).val()); // popExcludeCIFSegCode_${_pageRef}
		$("#popExcludeCIFSegDesc_" + _pageRef).val($("#segmentDesc_" + _pageRef).val()); // popExcludeCIFSegDesc_${_pageRef}
		_showProgressBar(false);
	});

	dialogOptions = excludeCIF_returnBasicDialogOption(300, 500, excludecifs_key, true);
	dialogOptions = $.extend({
		buttons : {
				"OK" : {
						"text" : save_key,
						"id" : "custSegExcludeCIF_save_btn_" + _pageRef,
						"click" : function()
						{
							var excludeCifGrid = $("#excludeCifsGridTbl_Id_" + _pageRef);

							var rowsIds = excludeCifGrid.jqGrid('getDataIDs');
							var execludeCifGridRowId = [];
							for (var i = 0; i < rowsIds.length; i++)
							{
								var myObject = excludeCifGrid.jqGrid('getRowData', rowsIds[i]);
								var cif_no = myObject["ctsSegmentCifExcludeVO.CIF_NO"];

								if (cif_no != "" && cif_no != null && typeof cif_no != "undefined")
								{
									execludeCifGridRowId.push(rowsIds[i])
								}
								else
								{
									excludeCifGrid.jqGrid('setSelection', rowsIds[i], false);
									excludeCifGrid.jqGrid('deleteGridRow', rowsIds[i]);
								}

							}

							$("#excludeCifGridRowId_" + _pageRef).val(execludeCifGridRowId);

							var jsonStringUpdates = excludeCifGrid.jqGrid("getAllRows");
							$("#excludeCifGridUpdates_" + _pageRef).val(jsonStringUpdates);

							var theForm = $("#custSegmentationMaintFormId_" + _pageRef).serializeForm();
							var actionPath = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_saveExcludeCif";

							_showProgressBar(true);
							$.ajax({
									url : actionPath,
									type : "post",
									dataType : "json",
									data : theForm,
									success : function(data)
									{
										if (typeof data["_error"] == "undefined" || data["_error"] == null)
										{
											_showErrorMsg(record_saved_Successfully_key, info_msg_title);
										}
										else
										{
											_showErrorMsg(data._error, error_msg_title);
										}

										_showProgressBar(false);
									}
							});

							// $("#excludeCifDiv_" + _pageRef).dialog("destroy").appendTo("#custSegmentationMaintFormId_"+_pageRef);
							$("#excludeCifDiv_" + _pageRef).dialog("close");
						}
				},
				"Cancel" : {
						"text" : cancel_key,
						"id" : "custSegExcludeCIF_cancel_btn_" + _pageRef,
						"click" : function()
						{

							onCancelCloseExcludeCifPopup();
//							$("#excludeCifDiv_" + _pageRef).dialog("close");
							$("#excludeCifDiv_" + _pageRef).dialog("destroy");
						}
				}
		}
	}, dialogOptions);

	$("#excludeCifDiv_" + _pageRef).dialog(dialogOptions);
	$("#excludeCifDiv_" + _pageRef).dialog("open");
	

	$("#excludeCifDiv_" + _pageRef).load(mySrc, paramObj, function()
	{
		$("#popExcludeCIFSegCode_" + _pageRef).val($("#code_" + _pageRef).val()); // popExcludeCIFSegCode_${_pageRef}
		$("#popExcludeCIFSegDesc_" + _pageRef).val($("#segmentDesc_" + _pageRef).val()); // popExcludeCIFSegDesc_${_pageRef}
		_showProgressBar(false);
	});
	
	_showProgressBar(false);
	// }
	// else
	// {
	// $("#excludeCifDiv_" + _pageRef).dialog("open");
	// _showProgressBar(false);
	// }
}

function excludeCIF_returnBasicDialogOption(dialogH, dialogW, dialogTitle, dontAppendToForm)
{
	return {
			height : returnMaxHeight(dialogH),
			width : returnMaxWidth(dialogW),
			title : dialogTitle,
			modal : true,
			autoOpen : false,
			show : 'slide',
			position : 'center',
			close : function(event, ui)
			{
				onCancelCloseExcludeCifPopup();
				// if (dontAppendToForm != undefined && dontAppendToForm != null && dontAppendToForm == true)
				// {
				// //$(this).dialog("destroy");
				// $(this).dialog("close");
				// } else {
				// $(this).dialog("close");
				// //$(this).dialog("destroy").appendTo("#custSegmentationMaintFormId_" + _pageRef);
				// }
			}
	};
}

function onCancelCloseExcludeCifPopup()
{
	var excludeCifGrid = $("#excludeCifsGridTbl_Id_" + _pageRef);
	var rowsIds = excludeCifGrid.jqGrid('getDataIDs');
	var execludeCifGridRowId = $("#excludeCifGridRowId_" + _pageRef).val();
	for (var i = 0; i < rowsIds.length; i++)
	{

		var myObject = excludeCifGrid.jqGrid('getRowData', rowsIds[i]);
		var cif_no = myObject["ctsSegmentCifExcludeVO.CIF_NO"];

		if (rowsIds[i].indexOf('new') == 0)
		{
			excludeCifGrid.jqGrid('setSelection', rowsIds[i], false);
			excludeCifGrid.jqGrid('deleteGridRow', rowsIds[i]);
		}
	}

	$("#excludeCifGridRowId_" + _pageRef).val(execludeCifGridRowId);

}

function custSegmentationProcess_process()
{
	var fromBranch = $("#lookuptxt_from_branch_" + _pageRef).val();
	var toBranch = $("#lookuptxt_to_branch_" + _pageRef).val();
	var fromCif = $("#lookuptxt_from_cif_" + _pageRef).val();
	var toCif = $("#lookuptxt_to_cif_" + _pageRef).val();
	var processType = $('input:radio[name=custSegmentationSC.processType]:checked').val();
	var iv_crud = $("#iv_crud_" + _pageRef).val();

	if (!(fromBranch != '' && toBranch == '') && !(fromBranch == '' && toBranch != '') && !(fromCif != '' && toCif == '') && !(fromCif == '' && toCif != '')
					&& (fromBranch == '' && toBranch == '' && fromCif == '' && toCif == ''))
	{
		return;
	}

	_showProgressBar(true);

	var mySrc = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_loadCustSegProcessGrid"
	var paramObj = {
			"custSegmentationSC.fromBranch" : fromBranch,
			"custSegmentationSC.toBranch" : toBranch,
			"custSegmentationSC.fromCif" : fromCif,
			"custSegmentationSC.toCif" : toCif,
			"custSegmentationSC.processType" : processType,
			"iv_crud" : iv_crud,
			"_pageRef" : _pageRef
	};

	// $("#customerSegmentationProcessGrid_" + _pageRef).empty().html("");
	// $("#customerSegmentationProcessGrid_" + _pageRef).load(mySrc, paramObj, function() {});
	$("#custSegProcessGridDiv_" + _pageRef).empty().html("");
	$("#custSegProcessGridDiv_" + _pageRef).load(mySrc, paramObj, function()
	{
	});
	$("#custSegProcessGridDiv_" + _pageRef).show();
	$("#custSegmentProcessMaintFormId_" + _pageRef).bindFormChanges("customerSegmentationProcessGrid_" + _pageRef);
	_showProgressBar(false);
}
function custSegProcess_approveButton(cellValue, options, rowObject)
{
	return '<a href ="#" onclick= "javascript:custSegProcess_approveButton_Clicked(' + "'" + options.rowId + "'" + ');">' + approve_key + '</a>';
}
// Function called upon Approve button of Customer Segmentation
function custSegProcess_approveButton_Clicked(rowindex)
{
	var custGrid = $("#custSegmentationProcessList_Id_" + _pageRef);
	var cifNo = custGrid.jqGrid('getCell', rowindex, 'ctsSegmentCifExResVO.CIF_NO');
	var recomendedSeg = custGrid.jqGrid('getCell', rowindex, 'ctsSegmentCifExResVO.RECOMMENED_SEGMENT');
	var status = custGrid.jqGrid('getCell', rowindex, 'ctsSegmentCifExResVO.STATUS');
	if (status != 'A')
	{
		return;
	}

	var paramObj = {
			"custSegmentationSC.cifNo" : cifNo,
			"custSegmentationSC.segment_code" : recomendedSeg,
			"_pageRef" : _pageRef
	};

	_showProgressBar(true);

	var actionPath = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_approveCustSegProcess";

	$.ajax({
			url : actionPath,
			type : "post",
			dataType : "json",
			data : paramObj,
			success : function(data)
			{
				if (typeof data["_error"] == "undefined" || data["_error"] == null)
				{
					custGrid.jqGrid('setCell', rowindex, 'ctsSegmentCifExResVO.STATUS', 'P');

					$("#custSegmentationProcessList_Id_" + _pageRef).trigger("reloadGrid");

					_showProgressBar(false);

				}
			}
	});
}
function custSegProcess_rejectButton(cellValue, options, rowObject)
{
	return '<a href ="#" onclick= "javascript:custSegProcess_rejectButton_Clicked(' + "'" + options.rowId + "'" + ');">' + reject_key + '</a>';
}
// Function called upon Approve button of Customer Segmentation
function custSegProcess_rejectButton_Clicked(rowindex)
{
	var custGrid = $("#custSegmentationProcessList_Id_" + _pageRef);
	var cifNo = custGrid.jqGrid('getCell', rowindex, 'ctsSegmentCifExResVO.CIF_NO');
	var status = custGrid.jqGrid('getCell', rowindex, 'ctsSegmentCifExResVO.STATUS');
	if (status != 'A')
	{
		return;
	}

	var paramObj = {
			"custSegmentationSC.cifNo" : cifNo,
			"_pageRef" : _pageRef
	};

	_showProgressBar(true);

	var actionPath = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_rejectCustSegProcess";

	$.ajax({
			url : actionPath,
			type : "post",
			dataType : "json",
			data : paramObj,
			success : function(data)
			{
				if (typeof data["_error"] == "undefined" || data["_error"] == null)
				{
					custGrid.jqGrid('setCell', rowindex, 'ctsSegmentCifExResVO.STATUS', 'R');
					$("#custSegmentationProcessList_Id_" + _pageRef).trigger("reloadGrid");
					_showProgressBar(false);
				}
			}
	});
}
function custSegProcess_permanentRejectButton(cellValue, options, rowObject)
{
	return '<a href ="#" onclick= "javascript:custSegProcess_permanentRejectButton_Clicked(' + "'" + options.rowId + "'" + ');">' + permanent_reject_key
					+ '</a>';
}
// Function called upon Approve button of Customer Segmentation
function custSegProcess_permanentRejectButton_Clicked(rowindex)
{
	var custGrid = $("#custSegmentationProcessList_Id_" + _pageRef);
	var cifNo = custGrid.jqGrid('getCell', rowindex, 'ctsSegmentCifExResVO.CIF_NO');
	var recomendedSeg = custGrid.jqGrid('getCell', rowindex, 'ctsSegmentCifExResVO.RECOMMENED_SEGMENT');
	var status = custGrid.jqGrid('getCell', rowindex, 'ctsSegmentCifExResVO.STATUS');
	if (status != 'A')
	{
		return;
	}

	var paramObj = {
			"custSegmentationSC.cifNo" : cifNo,
			"custSegmentationSC.segment_code" : recomendedSeg,
			"_pageRef" : _pageRef
	};

	_showProgressBar(true);

	var actionPath = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_permanentRejectCustSegProcess";

	$.ajax({
			url : actionPath,
			type : "post",
			dataType : "json",
			data : paramObj,
			success : function(data)
			{
				if (typeof data["_error"] == "undefined" || data["_error"] == null)
				{
					custGrid.jqGrid('setCell', rowindex, 'ctsSegmentCifExResVO.STATUS', 'V');
					$("#custSegmentationProcessList_Id_" + _pageRef).trigger("reloadGrid");
					_showProgressBar(false);
				}
			}
	});
}

function onChangingPriority(e)
{
	var grid = $("#segDefPrioritiesGridTbl_Id_" + _pageRef);
	var selectedRowId = grid.jqGrid("getGridParam", 'selrow');
	var selectedRowIndex = grid.jqGrid('getInd', selectedRowId);

	var priority = grid.jqGrid("getCell", selectedRowIndex, "ctsSegmentVO.AMENDED_PRIORITY"); //Rania - Customers Segmentation Enhancement

	if (priority != "" && priority - 0 < 1)
	{
		grid.jqGrid('setCellValue', selectedRowIndex, 'ctsSegmentVO.AMENDED_PRIORITY', null); //Rania - Customers Segmentation Enhancement
	}
	validateDuplicateSegPrioritiesValue();
}

//Button in Detail Grid : Parameter Details //By Bilal For TP#750884
function segSelectParamDetailsbtnQuery(cellValue, options, rowObject)
{	
	var entityType = 'Q';
	return '<a href = "#" onclick="segSelectParamDetailsDialog(' + options.rowId + ", 'Q' " + ');">' + param_details_key + '</a>';
}

//Button in Detail Grid : Parameter Details //By Bilal For TP#750884
function segSelectParamDetailsbtnProc(cellValue, options, rowObject)
{	
	var entityType = 'P';
	return '<a href = "#" onclick="segSelectParamDetailsDialog(' + options.rowId + ", 'P' " + ');">' + param_details_key + '</a>';
}

//By Bilal For TP#750884
function segSelectParamDetailsDialog(rowIndexSecDialog, entityType)
{
	debugger;
	var entityName= '';
	var $t;
	//var segDetailRowId = $("#segDetailRowId").val();
	var $f = $("#custSegmentationDetailList_Id_" + _pageRef);
	var segDetailRowId = $f.jqGrid("getGridParam", 'selrow');
		
	if(entityType == 'Q')
	{
		var queryGrid = $("#dialog_div_p" + segDetailRowId + "_" + _pageRef).find("#queryGridId").val();
		$t = $("#" + queryGrid);
	}
	else
	{
		var procGrid = $("#dialog_div_p" + segDetailRowId + "_" + _pageRef).find("#procGridId").val();
		$t = $("#" + procGrid);
		
	}
	
	$t.jqGrid('setSelection', rowIndexSecDialog, true);
	var selRowSecondDialog = $t.jqGrid("getGridParam", 'selrow');
	var myObject = $t.jqGrid('getRowData', selRowSecondDialog);

	var paramClass = myObject["ctsSegmentParamVO.PARAM_CLASS"];
	var queryId = myObject["ctsSegmentParamVO.PARAM_QUERY_ID"];
	var lineNo = myObject["ctsSegmentParamVO.PARAM_ORDER"];
	var criteriaCode = $("#_criteriaCode_").val();
	var segCode = $("#code_" + _pageRef).val();
	//debugger;
	if(paramClass == 'Q') 
	{
		var mySrc = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_loadSegSelectParams.action";

		var params = {"custSegmentationSC.ENTITY_TYPE":"M", 
			             "custSegmentationSC.ENTITY_ID":queryId,
			             "custSegmentationSC.criteria_code":criteriaCode,
			             "custSegmentationSC.segment_code" : segCode,
			             "custSegmentationSC.lineNo" : segDetailRowId,
			              "_entityType":entityType,
			              "_lineNo" : selRowSecondDialog,
			              "_pageRef" : _pageRef};
		
		var divId = $("#dialog_div_spm_" + segDetailRowId + "_" + selRowSecondDialog + "_" + criteriaCode + "_" + entityType + _pageRef);		
		_showProgressBar(true); //by bilal for BUG#827425
		if(divId.html() == null || divId.html() == "")
		{
			var newDivId = $("<div id='dialog_div_spm_" + segDetailRowId + "_" + selRowSecondDialog + "_" + criteriaCode + "_" + entityType + _pageRef + "'></div>");
			newDivId.css("padding", "0");
			var divParam = $("#dialog_div_p" + segDetailRowId + "_" + _pageRef); 
			newDivId.insertAfter(divParam);
			
			divId = $("#dialog_div_spm_" + segDetailRowId + "_" + selRowSecondDialog + "_" + criteriaCode + "_" + entityType + _pageRef);
			
			var dialogOptions = {
					modal : true,
					title : param_details_key,
					autoOpen : false,
					show : {
						effect : "slide",
						duration : 100,
						complete : function() {
							_showProgressBar(false); //by bilal for BUG#827425
						}
					},
					position : 'center',
					width : '700',
					height : '350',
					buttons : {
						"ok" : function() {
							var segSelectParamGridTbl = $("#segSelectParamGridTbl_Id_" + _pageRef+"_" + selRowSecondDialog + "_" + criteriaCode + "_" + entityType);
							var queryParamGridUpdate = segSelectParamGridTbl.jqGrid("getAllRows");
							$t.jqGrid("setCellValue", selRowSecondDialog, "querySelectParamGridStr", queryParamGridUpdate);
							$t.jqGrid("setCellValue", selRowSecondDialog, "isOpened", "1");
							$(this).dialog("destroy").appendTo("#dialog_div_p" + segDetailRowId + "_" + _pageRef);
							divId.dialog("close");
						}
					},
					close : function()
					{
						$(this).remove();
					}
			};
			
			divId.dialog(dialogOptions);
			divId.load(mySrc, params, function() {
				divId.dialog("open");
					});
		}
		else
		{
				divId.dialog({
					modal : true,
					title : param_details_key,
					autoOpen : false,
					show : {
						effect : "slide",
						duration : 100,
						complete : function() {
							_showProgressBar(false); //by bilal for BUG#827425
						}
					},
					position : 'center',
					width : '700',
					height : '350',
					buttons : {
						"ok" : function() {
							var segSelectParamGridTbl = $("#segSelectParamGridTbl_Id_" + _pageRef+"_" + selRowSecondDialog + "_" + criteriaCode + "_" + entityType);
							var queryParamGridUpdate = segSelectParamGridTbl.jqGrid("getAllRows");
							$t.jqGrid("setCellValue", selRowSecondDialog, "querySelectParamGridStr", queryParamGridUpdate);
							$t.jqGrid("setCellValue", selRowSecondDialog, "isOpened", "1");
							$(this).dialog("destroy").appendTo("#dialog_div_p" + segDetailRowId + "_" + _pageRef);
							divId.dialog("close");
						}
					},
					close : function()
					{
						$(this).dialog("destroy").appendTo("#dialog_div_p" + segDetailRowId + "_" + _pageRef);
						divId.dialog("close");
					}
			});
				divId.dialog("open");
		}
	}

}