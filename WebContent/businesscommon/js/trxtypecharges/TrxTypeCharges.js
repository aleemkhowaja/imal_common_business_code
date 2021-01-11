
(function($) {
	trxTypeChargesGrid_onDocReady = function() 
	{
		// Adding multipe header to grid column
		$("#trxTypeChargesGrid_Id_"+_pageRef).jqGrid('setGroupHeaders', {
		  useColSpanStyle: true, 
		  groupHeaders:[
			{startColumnName: 'TRXTYPE_CODE', 	 numberOfColumns: 2, titleText: trx_type_label},
			{startColumnName: 'trxTypeChargeSchemaHyprLink', numberOfColumns: 3, titleText:charges_schema_details_label},
			{startColumnName: 'CHARGES_CY_POLICY', numberOfColumns: 2, titleText:cash_account_label}
		  ]
		});
		$("#trxTypeChargesGrid_Id_"+_pageRef).subscribe("trxTypeChargesGrid_Id_SelectLoad",function(){
			trxTypeChargesGridLoad();
		});
//		$("#trxTypeChargesGrid_Id_"+_pageRef).subscribe("trxTypeChargesGrid_Id_CompleteLoad",function(){
//			trxTypeChargesGridLoad();
//		});
	};
})(jQuery);
		
function trxTypeChargesGridLoad()
	{
		var trxTypeGrid = $("#trxTypeChargesGrid_Id_" + _pageRef);//Trx Type Grid
		var selRowId = trxTypeGrid.jqGrid("getGridParam","selrow");
		if(selRowId.indexOf("new_") < 0) //not newly added row
		{
			var myObject = trxTypeGrid.jqGrid('getRowData',selRowId);
			var isEditable = myObject["TRX_TYPE_STATUS"];
			if( typeof isEditable != "undefined" && isEditable != "" && isEditable == "D")
			{
				trxTypeGrid.jqGrid('setCellReadOnly', selRowId, 'CASH_ACCOUNT',"true");
			}
			else // if null or any other value
			{
				trxTypeGrid.jqGrid('setCellReadOnly', selRowId, 'CASH_ACCOUNT',"false");
			}
		}
		//var selRowId = trxTypeGrid.jqGrid("getGridParam","selrow");
		//var rowdata =  trxTypeGrid.jqGrid('getRowData');
//		var rowIds = trxTypeGrid.jqGrid('getDataIDs');
//		var rowLength = rowIds.length;
//		for ( var i = 0; i < rowLength; i++) 
//		{
			//trxTypeGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to newly added row
			//trxTypeGrid.jqGrid('editRow',rowIds[i]);
		//	trxTypeGrid.jqGrid('saveRow',rowIds[i], false, 'clientArray');
		//	trxTypeGrid.jqGrid('resetSelection');
			
		//}
	}

// Function called for formatting the link in grid
function trxTypeChargesGrid_Id_ChargeSchemaBtnFormatter(cellValue, options, rowObject) {
		return '<a href="#" onclick = "javascript:trxTypeChargesGrid_Id_ChargeSchemaBtn_Clicked(' + "'" + options.rowId + "'"
				+ ');">' + charges_Schema_key + '</a>';
}

// Function called upon Charges Schema button of Trx Type Grid is clicked
function trxTypeChargesGrid_Id_ChargeSchemaBtn_Clicked(rowindex)
{
	var trxTypeGrid = $("#trxTypeChargesGrid_Id_" + _pageRef);//Trx Type Grid
	trxTypeGrid.jqGrid('setSelection',rowindex);	
	var balSelectRowId = trxTypeGrid.jqGrid("getGridParam", 'selrow');
	
	var schemaNo = trxTypeGrid.jqGrid('getCell', rowindex,'CHARGE_CODE');	
	if(schemaNo=="" || schemaNo == false)
		{
			_showErrorMsg(choose_a_schema_first_msg);
			$("#trxTypeChargesSchemaDetailDiv_id_" + _pageRef).hide();
			return;
		}
	var schemaUrl = jQuery.contextPath + '/path/fom/ChargesSchemaCommon_loadChargesSchemaDetail?schemaCode='+schemaNo+'&_pageRef='+_pageRef;
	$("#trxTypeChargesSchemaDetailDiv_id_" + _pageRef).show().load(schemaUrl);// Load Sub Section
}


// Function called upon Add button of Trx Type Grid is clicked
function trxTypeChargesGrid_Id_addId()
{
	var trxTypeGrid = $("#trxTypeChargesGrid_Id_" + _pageRef);//Trx Type Grid
	var rowIds = trxTypeGrid.jqGrid('getDataIDs');
	var addRowFlag = true;
	var rowLength = rowIds.length;
	for ( var i = 0; i < rowLength; i++) 
	{
		if (trxTypeGrid.jqGrid('getCell', rowIds[i],'TRXTYPE_CODE') == "") 
		{
			addRowFlag = false;
			_showErrorMsg(msg_please_fill_Trx_Type_Code_for_already_added_record);
			trxTypeGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
			trxTypeGrid.jqGrid('editRow',rowIds[i]);// making current row editable
			return;
		}
		else if (trxTypeGrid.jqGrid('getCell', rowIds[i],'CHARGE_CODE') == "") 
		{
			addRowFlag = false;
			_showErrorMsg(msg_please_fill_Charge_Code_for_already_added_record);
			trxTypeGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
			trxTypeGrid.jqGrid('editRow',rowIds[i]);// making current row editable
			return;
		}
	}
	
	var rowdata =  trxTypeGrid.jqGrid('getRowData');
	var selectedRowId = 	trxTypeGrid.jqGrid("getGridParam", 'selrow');
	var selectedRowIndex =	trxTypeGrid.jqGrid('getInd',selectedRowId); 
	$.each(rowdata, function(index, value) 
	{
		if(index != selectedRowIndex-1)// index starts with 0 and selectedRowIndex starts with 1
		{
			var selected_TRXTYPE_CODE = trxTypeGrid.jqGrid('getCell', selectedRowId,'TRXTYPE_CODE');	
			var selected_CHARGES_CY_POLICY = trxTypeGrid.jqGrid('getCell', selectedRowId,'CHARGES_CY_POLICY');
			var selected_CASH_ACCOUNT = trxTypeGrid.jqGrid('getCell', selectedRowId,'CASH_ACCOUNT');
			
			if(selected_TRXTYPE_CODE == value.TRXTYPE_CODE)// Checking TRXTYPE_CODE
			{
				if(selected_CHARGES_CY_POLICY == value.CHARGES_CY_POLICY)// Checking CHARGES_CY_POLICY
				{
					if(selected_CASH_ACCOUNT == value.CASH_ACCOUNT)// Checking CASH_ACCOUNT
					{
						_showErrorMsg(msg_duplicate_entry_Of_record_key);// will be moved to properties file
						addRowFlag = false;
						return;
					}
				}
			}
		}
	});
	
	if (addRowFlag) 
	{
		trxTypeGrid.jqGrid('addInlineRow', {});
		var rowIds 	= trxTypeGrid.jqGrid('getDataIDs');
		var rowId 	= rowIds[rowIds.length-1]; 
		trxTypeGrid.jqGrid('setSelection',rowId, false);// setting selection to newly added row
		trxTypeGrid.jqGrid('editRow',rowId);// making newly added row editable
		$("#trxTypeChargesSchemaDetailDiv_id_" + _pageRef).hide();
	}
}

// Function called upon Delete button of Trx Type Grid is clicked
	function trxTypeChargesGrid_Id_deleteId()
	{
		_showConfirmMsg(Confirm_Delete_Process_key,"","trxTypeChargesGridRecordDelete","yesNo");
	} 
	
	function trxTypeChargesGridRecordDelete(yesNo){
		if(yesNo==true)
		{
			var trxTypeGrid = $("#trxTypeChargesGrid_Id_" + _pageRef);//Trx Type Grid
			var rowId = trxTypeGrid.jqGrid('getGridParam','selrow');	
			trxTypeGrid.jqGrid('deleteGridRow',rowId);
		}
	}

// Function called after Dependency call of TRXTYPE_CODE
	function trxTypeChargesCodeAfterDependency()
	{
		var trxTypeGrid = $("#trxTypeChargesGrid_Id_" + _pageRef);//Trx Type Grid
		var selectedRowId = trxTypeGrid.jqGrid("getGridParam", 'selrow');
		if(selectedRowId.indexOf("new_") < 0) //not newly added row
		{
			var myObject = trxTypeGrid.jqGrid('getRowData',selectedRowId);
			var isEditable = myObject["TRX_TYPE_STATUS"];
			if( typeof isEditable != "undefined" && isEditable != "" && isEditable == "D")
			{
				trxTypeGrid.jqGrid('setCellReadOnly', selectedRowId, 'CASH_ACCOUNT',"true");
			}
			else // if null or any other value
			{
				trxTypeGrid.jqGrid('setCellReadOnly', selectedRowId, 'CASH_ACCOUNT',"false");
			}
		}
		
		var rowdata =  trxTypeGrid.jqGrid('getRowData');
		var selectedRowIndex =	trxTypeGrid.jqGrid('getInd',selectedRowId); 
		$.each(rowdata, function(index, value) 
		{
			//alert('selectedRowIndex:   '+(selectedRowIndex-1)+'         index:   '+index);
			if(index != selectedRowIndex-1)// index starts with 0 and selectedRowIndex starts with 1
			{
				var selected_TRXTYPE_CODE = trxTypeGrid.jqGrid('getCell', selectedRowId,'TRXTYPE_CODE');	
				var selected_CHARGES_CY_POLICY = trxTypeGrid.jqGrid('getCell', selectedRowId,'CHARGES_CY_POLICY');
				var selected_CASH_ACCOUNT = trxTypeGrid.jqGrid('getCell', selectedRowId,'CASH_ACCOUNT');
				
				if(selected_TRXTYPE_CODE == value.TRXTYPE_CODE)// Checking TRXTYPE_CODE
				{
					if(selected_CHARGES_CY_POLICY == value.CHARGES_CY_POLICY)// Checking CHARGES_CY_POLICY
					{
						if(selected_CASH_ACCOUNT == value.CASH_ACCOUNT)// Checking CASH_ACCOUNT
						{
							_showErrorMsg(msg_duplicate_entry_Of_record_key);// will be moved to properties file
						}
					}
				}
			}
		});
	}
	
// Function called on change of CHARGES_CY_POLICY
	function trxTypeChargesGrid_onChangeTrxTypeChargesPolicy(t)
	{
		var trxTypeGrid = $("#trxTypeChargesGrid_Id_" + _pageRef);//Trx Type Grid
		var rowdata =  trxTypeGrid.jqGrid('getRowData');
		var selectedRowId = 	trxTypeGrid.jqGrid("getGridParam", 'selrow');
		var selectedRowIndex =	trxTypeGrid.jqGrid('getInd',selectedRowId); 
		$.each(rowdata, function(index, value) 
		{
			//alert('selectedRowIndex:   '+(selectedRowIndex-1)+'         index:   '+index);
			if(index != selectedRowIndex-1)// index starts with 0 and selectedRowIndex starts with 1
			{
				var selected_TRXTYPE_CODE = trxTypeGrid.jqGrid('getCell', selectedRowId,'TRXTYPE_CODE');	
				var selected_CHARGES_CY_POLICY = trxTypeGrid.jqGrid('getCell', selectedRowId,'CHARGES_CY_POLICY');
				var selected_CASH_ACCOUNT = trxTypeGrid.jqGrid('getCell', selectedRowId,'CASH_ACCOUNT');
				
				if(selected_TRXTYPE_CODE == value.TRXTYPE_CODE)// Checking TRXTYPE_CODE
				{
					if(selected_CHARGES_CY_POLICY == value.CHARGES_CY_POLICY)// Checking CHARGES_CY_POLICY
					{
						if(selected_CASH_ACCOUNT == value.CASH_ACCOUNT)// Checking CASH_ACCOUNT
						{
							_showErrorMsg(msg_duplicate_entry_Of_record_key);// will be moved to properties file
						}
					}
				}
			}
		});
	}
	
// Function called on change of CASH_ACCOUNT	
	function trxTypeChargesGrid_onChangeTrxTypeCashAccount(t)
	{
		var trxTypeGrid = $("#trxTypeChargesGrid_Id_" + _pageRef);//Trx Type Grid
		var rowdata =  trxTypeGrid.jqGrid('getRowData');
		var selectedRowId = 	trxTypeGrid.jqGrid("getGridParam", 'selrow');
		var selectedRowIndex =	trxTypeGrid.jqGrid('getInd',selectedRowId); 
		$.each(rowdata, function(index, value) 
		{
			//alert('selectedRowIndex:   '+(selectedRowIndex-1)+'         index:   '+index);
			if(index != selectedRowIndex-1)// index starts with 0 and selectedRowIndex starts with 1
			{
				var selected_TRXTYPE_CODE = trxTypeGrid.jqGrid('getCell', selectedRowId,'TRXTYPE_CODE');	
				var selected_CHARGES_CY_POLICY = trxTypeGrid.jqGrid('getCell', selectedRowId,'CHARGES_CY_POLICY');
				var selected_CASH_ACCOUNT = trxTypeGrid.jqGrid('getCell', selectedRowId,'CASH_ACCOUNT');
				
				if(selected_TRXTYPE_CODE == value.TRXTYPE_CODE)// Checking TRXTYPE_CODE
				{
					if(selected_CHARGES_CY_POLICY == value.CHARGES_CY_POLICY)// Checking CHARGES_CY_POLICY
					{
						if(selected_CASH_ACCOUNT == value.CASH_ACCOUNT)// Checking CASH_ACCOUNT
						{
							_showErrorMsg(msg_duplicate_entry_Of_record_key);// will be moved to properties file
						}
					}
				}
			}
		});
	}

// Function called for Save of Trx Type Charges
function trxTypeCharges_onSaveClicked()
{
	var changes = $("#trxTypeChargesForm_"+_pageRef).hasChanges(true);
	if(changes == 'true' || changes == true)
	{
		var cifCode = $("#fomTrxTypeChargesCO_popupCifNo_"+_pageRef).val();
		var trxTypeGrid = $("#trxTypeChargesGrid_Id_" + _pageRef);//Trx Type Grid
		
		var iv_crud = $("#iv_crud_"+ _pageRef).val();
		var cifStatus = $("#cifVO_STATUS_"+ _pageRef).val();
		var cif_UpdateDate = $("#cifVO_DATE_UPDATED_"+ _pageRef).val();
			    
		var rowIds = trxTypeGrid.jqGrid('getDataIDs');
		var rowLength = rowIds.length;
			
//		if(rowLength == 0)
//		{
//			alert('Please add record(s) to save');
//			return;
//		}
	
		if(rowLength != 0)
		{
			
			for ( var i = 0; i < rowLength; i++) // Checking whether all mandatory fields are filled
			{
				trxTypeGrid.jqGrid('saveRow',rowIds[i], false, 'clientArray');// save any row which is still in edit mode
				
				if (trxTypeGrid.jqGrid('getCell', rowIds[i],'TRXTYPE_CODE') == "") 
				{
					_showErrorMsg(msg_please_fill_Trx_Type_Code_for_already_added_record);
					trxTypeGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
					trxTypeGrid.jqGrid('editRow',rowIds[i]);// making current row editable
					return;
				}
				else if (trxTypeGrid.jqGrid('getCell', rowIds[i],'CHARGE_CODE') == "") 
				{
					_showErrorMsg(msg_please_fill_Charge_Code_for_already_added_record);
					trxTypeGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
					trxTypeGrid.jqGrid('editRow',rowIds[i]);// making current row editable
					return;
				}
			}
			
			var rowdata =  trxTypeGrid.jqGrid('getRowData');
			var selectedRowId = 	trxTypeGrid.jqGrid("getGridParam", 'selrow');
			var selectedRowIndex =	trxTypeGrid.jqGrid('getInd',selectedRowId); 
			
			$.each(rowdata, function(index, value) // checking whether any duplicate records are there
			{
				if(index != selectedRowIndex-1)// index starts with 0 and selectedRowIndex starts with 1
				{
					var selected_TRXTYPE_CODE = trxTypeGrid.jqGrid('getCell', selectedRowId,'TRXTYPE_CODE');	
					var selected_CHARGES_CY_POLICY = trxTypeGrid.jqGrid('getCell', selectedRowId,'CHARGES_CY_POLICY');
					var selected_CASH_ACCOUNT = trxTypeGrid.jqGrid('getCell', selectedRowId,'CASH_ACCOUNT');
					
					if(selected_TRXTYPE_CODE == value.TRXTYPE_CODE)// Checking TRXTYPE_CODE
					{
						if(selected_CHARGES_CY_POLICY == value.CHARGES_CY_POLICY)// Checking CHARGES_CY_POLICY
						{
							if(selected_CASH_ACCOUNT == value.CASH_ACCOUNT)// Checking CASH_ACCOUNT
							{
								_showErrorMsg(msg_duplicate_entry_Of_record_key);// will be moved to properties file
								return;
							}
						}
					}
				}
			});
		}
		
		var saveUrl = jQuery.contextPath + "/path/fom/TrxTypeChargesList_save";	
		var chargeData = {"chargesStr" : trxTypeGrid.jqGrid('getAllRows'),
						"cifCode":cifCode,
						"cifStatus":cifStatus,
						"iv_crud":iv_crud,
						"cif_UpdateDate":cif_UpdateDate,
						"_auditJsonStr":$("#fomMaintForm_" + _pageRef + "> #auditObj_" + _pageRef).val(),
						"auditTrxNbr":$("#fomMaintForm_" + _pageRef + "> #auditTrxNbr_" + _pageRef).val(),
						"_pageRef":_pageRef };

		$.ajax({
			 url: saveUrl,
	         type:"post",		 
			 data: chargeData,
			 dataType:"json",
			 success: function(data)		 
			 {
				if(typeof data["_error"] == "undefined" || data["_error"] == null)
				{			
					changeCIFValues(data.cifStatus,data.latestCifupdateDate);
					if($("#trxTypeChargesGrid_Id_"+_pageRef).html()!=null && $("#trxTypeChargesGrid_Id_"+_pageRef).html()!="")
		            {
		            	 $("#trxTypeChargesGrid_Id_"+_pageRef).trigger("reloadGrid");
		            }
					$("#fomTrxTypeChargesDialog_"+_pageRef).dialog("close");
					
				}
			 }
		});	
	}
}