
(function($) {
	reasonChargesGrid_onDocReady = function() 
	{
		// Adding multipe header to grid column
		$("#reasonChargesGrid_Id_"+_pageRef).jqGrid('setGroupHeaders', {
		  useColSpanStyle: true, 
		  groupHeaders:[
			{startColumnName: 'REASON_CODE', 	 numberOfColumns: 2, titleText: reason_code_label},
			{startColumnName: 'reasonChargeSchemaHyprLink', numberOfColumns: 3, titleText:charges_schema_details_label},
			]
		});
	};
})(jQuery);

function reasonChargesGrid_Id_ChargeSchemaBtnFormatter(cellValue, options, rowObject) {
		return '<a href = "javascript:reasonChargesGrid_Id_ChargeSchemaBtn_Clicked(' + "'" + options.rowId + "'"
				+ ');">' + charges_Schema_key + '</a>';
}

// Function called upon Charges Schema button of Reason Charges Grid is clicked
function reasonChargesGrid_Id_ChargeSchemaBtn_Clicked(rowindex)
{	
	$("#reasonChargesGrid_Id_" + _pageRef).jqGrid('setSelection',rowindex);
	var reasoneGrid = $("#reasonChargesGrid_Id_" + _pageRef);//Reason Charges Grid
	var schemaNo = reasoneGrid.jqGrid('getCell', rowindex,'CHARGE_CODE');
	if(schemaNo=="")
		{
			_showErrorMsg(choose_a_schema_first_msg);
			$("#reasonChargesSchemaDetailDiv_id_" + _pageRef).hide();
			return;
		}
	var schemaUrl = jQuery.contextPath + '/path/fom/ChargesSchemaCommon_loadChargesSchemaDetail?schemaCode='+schemaNo+'&_pageRef='+_pageRef;
	$("#reasonChargesSchemaDetailDiv_id_" + _pageRef).show().load(schemaUrl);// Load Sub Section
}

// Function called upon Add button of Reason Charges Grid is clicked
function reasonChargesGrid_Id_addId()
{
	var reasoneGrid = $("#reasonChargesGrid_Id_" + _pageRef);//Reason Charges Grid
	var rowIds = reasoneGrid.jqGrid('getDataIDs');
	var addRowFlag = true;
	var rowLength = rowIds.length;
	for ( var i = 0; i < rowLength; i++) 
	{
		if (reasoneGrid.jqGrid('getCell', rowIds[i],'REASON_CODE') == "") 
		{
			addRowFlag = false;
			_showErrorMsg(msg_please_fill_Reason_Code_for_already_added_record);
			reasoneGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
			reasoneGrid.jqGrid('editRow',rowIds[i]);// making current row editable
			return;
		}
		else if (reasoneGrid.jqGrid('getCell', rowIds[i],'CHARGE_CODE') == "") 
		{
			addRowFlag = false;
			_showErrorMsg(msg_please_fill_Charge_Code_for_already_added_record);
			reasoneGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
			reasoneGrid.jqGrid('editRow',rowIds[i]);// making current row editable
			return;
		}
	}
	if (addRowFlag) 
	{
		reasoneGrid.jqGrid('addInlineRow', {});
		var rowIds 	= reasoneGrid.jqGrid('getDataIDs');
		var rowId 	= rowIds[rowIds.length-1]; 
		reasoneGrid.jqGrid('setSelection',rowId, false);// setting selection to newly added row
		reasoneGrid.jqGrid('editRow',rowId);// making newly added row editable
		$("#reasonChargesSchemaDetailDiv_id_" + _pageRef).hide();
	}
	
}

// Function called upon Delete button of Reason Charges Grid is clicked
	function reasonChargesGrid_Id_deleteId()
	{
		_showConfirmMsg(Confirm_Delete_Process_key,"","reasonChargesGridRecordDelete","yesNo");
	} 
	
	function reasonChargesGridRecordDelete(yesNo){
	if(yesNo==true)
	{
		var reasoneGrid = $("#reasonChargesGrid_Id_" + _pageRef);//Reason Charges Grid
		var rowId = reasoneGrid.jqGrid('getGridParam','selrow');	
		reasoneGrid.jqGrid('deleteGridRow',rowId);
	}
	}
	
function reasonCharges_onSaveClicked()
{
	var changes = $("#reasonChargesForm_"+_pageRef).hasChanges(true);
	if(changes == 'true' || changes == true)
	{
		var cifCode = $("#fomReasonChargesCO_popupCifNo_"+_pageRef).val();
		var reasoneGrid = $("#reasonChargesGrid_Id_" + _pageRef);//Reason Charges Grid
		
		var iv_crud = $("#iv_crud_"+ _pageRef).val();
		var cifStatus = $("#cifVO_STATUS_"+ _pageRef).val();
		var cif_UpdateDate = $("#cifVO_DATE_UPDATED_"+ _pageRef).val();
		
		var rowIds = reasoneGrid.jqGrid('getDataIDs');
		var rowLength = rowIds.length;
		var arr = [];
		if(rowLength != 0)
		{	
			for ( var i = 0; i < rowLength; i++) // Checking whether all mandatory fields are filled
			{
				reasoneGrid.jqGrid('saveRow',rowIds[i], false, 'clientArray');// save any row which is still in edit mode
				
				arr.push({"REASON_CODE":reasoneGrid.jqGrid('getCell', rowIds[i],'REASON_CODE'),
						  "CHARGE_CODE":reasoneGrid.jqGrid('getCell', rowIds[i],'CHARGE_CODE')});
				
				if (reasoneGrid.jqGrid('getCell', rowIds[i],'REASON_CODE') == "") 
				{
					_showErrorMsg(msg_please_fill_Reason_Code_for_already_added_record);
					reasoneGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
					reasoneGrid.jqGrid('editRow',rowIds[i]);// making current row editable
					return;
				}
				else if (reasoneGrid.jqGrid('getCell', rowIds[i],'CHARGE_CODE') == "") 
				{
					_showErrorMsg(msg_please_fill_Charge_Code_for_already_added_record);
					reasoneGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
					reasoneGrid.jqGrid('editRow',rowIds[i]);// making current row editable
					return;
				}
				
			}
		}	
		var callingScreen = $("#callingScreen_"+_pageRef).val();
		var saveUrl = jQuery.contextPath + "/path/fom/ReasonChargesList_save";	
		
		var reasoneData = {"root":arr};
		var reasonData = {  "reasonStr" : JSON.stringify(reasoneData),
							"cifCode":cifCode,
							"cif_Type":$("#lookuptxt_cifVO_CIF_TYPE_" + _pageRef).val(),
							"cifStatus":cifStatus,
							"iv_crud":iv_crud,
							"cif_UpdateDate":cif_UpdateDate,
							"_auditJsonStr":$("#fomMaintForm_" + _pageRef + "> #auditObj_" + _pageRef).val(),
							"auditTrxNbr":$("#fomMaintForm_" + _pageRef + "> #auditTrxNbr_" + _pageRef).val(),
							"callingScreen":callingScreen,
							"_pageRef":_pageRef 
						}
		
		$.ajax({
			url: saveUrl,
			type:"post",		 
			data: reasonData,
			dataType:"json",
			success: function(data)
			{	
				if(typeof data["_error"] == "undefined" || data["_error"] == null)
				{					
					 changeCIFValues(data.cifStatus,data.latestCifupdateDate);
					if($("#reasonChargesGrid_Id_"+_pageRef).html()!=null && $("#reasonChargesGrid_Id_"+_pageRef).html()!="")
		            {
		            	 $("#reasonChargesGrid_Id_"+_pageRef).trigger("reloadGrid");
		            }
					$("#fomVoidReasonChargesDialog_"+_pageRef).dialog("close");
				}
			 }
		});	
	}
}
