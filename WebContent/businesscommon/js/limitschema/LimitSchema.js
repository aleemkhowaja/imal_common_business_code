
(function($) {
	limitSchemaGrid_onDocReady = function() 
	{
		$("#lookuptxt_limitSchemaCopyBtn_"+_pageRef).hide();
		$("#spanLookup_limitSchemaCopyBtn_"+_pageRef).removeClass('ui-search ui-state-default ui-state-focus liveSearchSpanCorner liveSearchSpanSize liveSearchSpanDisplay').addClass('ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only');
		$("#spanLookup_limitSchemaCopyBtn_"+_pageRef).children("span").removeClass('ui-icon ui-icon-search live-search-ui').addClass('ui-button-text').text(Copy_key);
		// Adding multipe header to grid column
		$("#limitSchemaGrid_Id_"+_pageRef).jqGrid('setGroupHeaders', {
		  useColSpanStyle: true, 
		  groupHeaders:[
			{startColumnName: 'unlimited', 	 numberOfColumns: 2, titleText: limit_key},
			{startColumnName: 'limitSchemaVO.TRX_TYPE', 	 numberOfColumns: 2, titleText: transaction_key}
			]
		});
		
		$("#limitSchemaGrid_Id_"+_pageRef).subscribe("limitSchemaGridOnRowSelect",function(event,rowObj){
			 
			limitSchemaOnRowSelect(event,rowObj);
		});
		
	};
})(jQuery);

function limitSchemaOnRowSelect(event,rowObj)
{
	//Raed Saad Bug - 679025
	var gridId = event.currentTarget.id
	var grid = $("#"+gridId);
	var rowid = event.originalEvent.id;
	var chkBoxValue = grid.jqGrid ('getCell', rowid, 'neverExpire');
	var unlimittedChkBoxValue = grid.jqGrid ('getCell', rowid, 'unlimited');
	var inputs = $("#"+rowid+" >td").find('input[type=text].editable');
	var neverExpire = [];
	var unLimit = [];
	$.each(inputs,function(i,v){
		var id = v.id;
		if(id.indexOf("EFFECTIVE_FROM")>-1 || id.indexOf("EFFECTIVE_TO")>-1)
		{
			neverExpire.push(v)
		}
		else if(id.indexOf("LIMIT_AMT")>-1)
		{
			unLimit.push(v);
		}
	});	
	if(true == chkBoxValue || 'Y' == chkBoxValue)
	{
		$(neverExpire).attr('readonly','readonly');
	}
	if(true == unlimittedChkBoxValue || 'Y' == unlimittedChkBoxValue) 
	{
		$(unLimit).attr('readonly','readonly');
	}
	//Raed Saad END - Bug - 679025
	/*
	$t = $("#limitSchemaGrid_Id_"+_pageRef);
	var selRowId = $($t).jqGrid("getGridParam","selrow");
	var limitAmount = $t.jqGrid('getCell', selRowId,'limitSchemaVO.LIMIT_AMT');
	if( typeof limitAmount == "undefined" || limitAmount == null || limitAmount == "" || limitAmount == "0")
	{
		$t.jqGrid('setCellReadOnly', selRowId,'limitSchemaVO.LIMIT_AMT', "true");

		$t.jqGrid('setCellValue', selRowId,'unlimited', "Y"); 

	}*/
	
	//Rania - Bug #679025
	var neverExpire = grid.jqGrid("getCell",rowid, 'neverExpire');
	if(neverExpire != undefined && neverExpire != null && neverExpire == 'Y')
	{
		grid.jqGrid('setCellReadOnly', rowid, 'limitSchemaVO.EFFECTIVE_FROM',"true");
		grid.jqGrid('setCellReadOnly', rowid, 'limitSchemaVO.EFFECTIVE_TO',"true");
	}
	
}

function onChangeUnlimitAmount(e)
{
	$t = $("#limitSchemaGrid_Id_"+_pageRef);
	var selRowId = $(e.target).closest('tr.jqgrow').attr("id");
//	var selRowId = $($t).jqGrid("getGridParam","selrow");
	if(selRowId != undefined && selRowId != null)
	{	
		var unlimited = $t.jqGrid('getCell',selRowId, 'unlimited');
		if( unlimited == 'Y')
		{
			$t.jqGrid('setCellValue', selRowId, 'limitSchemaVO.LIMIT_AMT',"","true");
		}
		else
		{
//			var cellElt = document.getElementById( selRowId + "_limitSchemaVO.LIMIT_AMT");
//			$cellProp = $(cellElt);
//			$cellProp.val("");
//			$cellProp.removeAttr("readonly")
//			$cellProp.focus();
			$t.jqGrid('setCellValue', selRowId, 'limitSchemaVO.LIMIT_AMT',"","false");
		}
	}
}

function onChangeNeverExpire(e)
{
	$t = $("#limitSchemaGrid_Id_"+_pageRef);
	var selRowId = $(e.target).closest('tr.jqgrow').attr("id");
//	var selRowId = $($t).jqGrid("getGridParam","selrow");
	var neverExpire = $t.jqGrid('getCell',selRowId, 'neverExpire')
	if(selRowId != undefined && selRowId != null)
	{
		if( neverExpire == 'Y')
		{
			$t.jqGrid('setCellValue', selRowId, 'limitSchemaVO.EFFECTIVE_FROM',"","true");
			$t.jqGrid('setCellValue', selRowId, 'limitSchemaVO.EFFECTIVE_TO',"","true");
		}
		else
		{
			$t.jqGrid('setCellValue', selRowId, 'limitSchemaVO.EFFECTIVE_FROM',"","false");
			$t.jqGrid('setCellValue', selRowId, 'limitSchemaVO.EFFECTIVE_TO',"","false");
		}
	}
}

function onChangeLimitAmount(e)
{
	$t = $("#limitSchemaGrid_Id_"+_pageRef);
	if(e == undefined)
	{
		return;
	}
	var selRowId = $(e.target).closest('tr.jqgrow').attr("id");
//	var selRowId = $($t).jqGrid("getGridParam","selrow");
	if(selRowId != undefined && selRowId != null)
	{
		 var limitAmount = $t.jqGrid('getCell',selRowId, 'limitSchemaVO.LIMIT_AMT');
//		var limitAmtElem = document.getElementById( selRowId + "_limitSchemaVO.LIMIT_AMT");
//		var limitAmount = $(limitAmtElem).val();
		if ( (limitAmount == null)||(limitAmount == "") ||(limitAmount == "0") )
		{
			$t.jqGrid('setCellValue', selRowId, 'limitSchemaVO.LIMIT_AMT',"","true");
//			var unLimitAmtElem = document.getElementById( selRowId + "_unlimited");
//			$(unLimitAmtElem).attr('checked','checked');
			$t.jqGrid('setCellValue', selRowId, 'unlimited',"Y");
		}
		else
		{
			var cellvalue = $t.jqGrid('getCell',selRowId, 'limitSchemaVO.LIMIT_AMT')
			var formtNum = $.formatNumberNumeric(cellvalue, {format: returnNbFormat($("#baseCyDecPoint_" + _pageRef).val(), null,null)});
			$t.jqGrid('setCellValue', selRowId, 'limitSchemaVO.LIMIT_AMT',formtNum,"false");
		}
	}
}

function limitSchemaOnAddClicked()
{
//	TODO confirm this with service team
//	If dw_limit_schema.object.datawindow.ReadOnly	=	'yes' Then Return
	var limitSchemaGrid = $("#limitSchemaGrid_Id_"+_pageRef);
	var rowIds = limitSchemaGrid.jqGrid('getDataIDs');
	var trxType ="", group1 = "", unlimited="", limitAmount="";
	var rowsLength = rowIds.length;
	var rowId;
	var missingData=false;
	for(var i=0; i<rowsLength; i++)
	{
		rowId = rowIds[i];
		unlimited = limitSchemaGrid.jqGrid('getCell', rowId,'unlimited');
		limitAmount = limitSchemaGrid.jqGrid('getCell', rowId,'limitSchemaVO.LIMIT_AMT');
		trxType = limitSchemaGrid.jqGrid('getCell', rowId,'limitSchemaVO.TRX_TYPE');
		group1 = limitSchemaGrid.jqGrid('getCell', rowId,'limitSchemaVO.GROUP1');
		if((unlimited == "N" && limitAmount == "") || trxType == "" || group1 == "")
		{
			missingData = true;
			break;
		}
	}
	if(missingData)
	{
		return;
	}
	
	
	var params = {};
	var  limitSchemaGridData			=  	limitSchemaGrid.jqGrid('getAllRows');
	params["limitSchemaGridJson"]		= 	limitSchemaGridData;
	params["cifSubNo"]					= 	$("#limitSchema_cifSubNo_hdn_" + _pageRef).val();
	params["branchCode"]				= 	$("#limitSchema_branchCode_hdn_" + _pageRef).val();
	var action = jQuery.contextPath + "/path/limitSchema/limitSchema_addNewRow.action";
	_showProgressBar(true);
	$.ajax({
		 url: action,
		 type:"post",		 
		 data: params,
		 dataType:"json",
		 success: function(data)
		 {	
			_showProgressBar(false);
			if (typeof data["_error"] == "undefined" || data["_error"] == null) 
			{
				var rowId = $(limitSchemaGrid).jqGrid('addInlineRow', {});
				$(limitSchemaGrid).jqGrid('setCell',rowId,"limitSchemaVO.LINE",data.limitSchemaCO.limitSchemaVO.LINE);
				$(limitSchemaGrid).jqGrid('setCell',rowId,"unlimited",data.limitSchemaCO.unlimited);
				$(limitSchemaGrid).jqGrid('setCell',rowId,"neverExpire",data.limitSchemaCO.neverExpire);
				$(limitSchemaGrid).jqGrid('setCell',rowId,"limitSchemaVO.TRX_TYPE",data.limitSchemaCO.limitSchemaVO.TRX_TYPE);
				$(limitSchemaGrid).jqGrid('setCell',rowId,"transactionDesc",data.limitSchemaCO.transactionDesc);
				$(limitSchemaGrid).jqGrid('setSelection',rowId, false);// setting selection to newly added row
				$(limitSchemaGrid).jqGrid('editRow',rowId);// making newly added row editable
				
				$(limitSchemaGrid).jqGrid('setCellValue', rowId, 'limitSchemaVO.LIMIT_AMT',"","true");
				$(limitSchemaGrid).jqGrid('setCellValue', rowId, 'limitAmtFormat',$("#baseCyDecPoint_" + _pageRef).val(),"true");
				$(limitSchemaGrid).jqGrid('setCellValue', rowId, 'limitSchemaVO.EFFECTIVE_FROM',"","true");
				$(limitSchemaGrid).jqGrid('setCellValue', rowId, 'limitSchemaVO.EFFECTIVE_TO',"","true");
			}
		}
	});	
}

function limitSchemaOnDeleteClicked()
{
	//	TODO confirm this with service team
//	If dw_limit_schema.object.datawindow.ReadOnly	=	'yes' Then Return
	var rowId = $("#limitSchemaGrid_Id_"+_pageRef).jqGrid('getGridParam','selrow');	
	//$("#limitSchemaGrid_Id_"+_pageRef).jqGrid('delRowData',rowId);
	$("#limitSchemaGrid_Id_"+_pageRef).jqGrid('deleteGridRow',rowId);
}

function fomLimitSchema_onSaveClicked()
{
	//detect change
	var changes = $("#limitSchemaListForm_"+_pageRef).hasChanges(true);
	
	if(changes == 'true' || changes == true)
	{
		var limitSchemaGrid = $("#limitSchemaGrid_Id_"+_pageRef);
		var params = {};		
		var  limitSchemaGridData = '{"root":[]}';
		if (limitSchemaGrid.length != 0) 
		{
			limitSchemaGridData = limitSchemaGrid.jqGrid('getAllRows'); // Grid Data
		}

		var fromWhere = $("#limitSchema_fromWhere_"+ _pageRef).val();
		params["limitSchemaGridJson"]			= 	limitSchemaGridData;
		params["cifSubNo"]						= 	$("#limitSchema_cifSubNo_hdn_" + _pageRef).val();
		params["branchCode"]					= 	$("#limitSchema_branchCode_hdn_" + _pageRef).val();
		params["currencyCode"]					= 	$("#limitSchema_currencyCode_hdn_" + _pageRef).val();
		params["glCode"]						= 	$("#limitSchema_glCode_hdn_" + _pageRef).val();
		params["slNo"]							= 	$("#limitSchema_slNo_hdn_" + _pageRef).val();
		params["limitSchemaSC.parentPage"]		= 	$("#limitSchemaParentPage_" + _pageRef).val();
		params["limitSchemaSC.openedFromSign"]	= 	$("#limitSchemaParentPage_" + _pageRef).val();
		params["_auditJsonStr"]					= 	$("#fomMaintForm_" + _pageRef + "> #auditObj_" + _pageRef).val();
		params["auditTrxNbr"]					= 	$("#fomMaintForm_" + _pageRef + "> #auditTrxNbr_" + _pageRef).val();
		params["_pageRef"]						= 	_pageRef;
		params["limitSchemaCO.cifStatus"]		= 	 $("#cifVO_STATUS_"+ _pageRef).val();
		params["limitSchemaCO.cif_UpdateDate"]	= 	$("#cifVO_DATE_UPDATED_"+ _pageRef).val();
		params["compCodeCif"]					= 	$("#compCodeCif_"+ _pageRef).val();
		params["limitSchemaCO.fromWhere"]		= 	fromWhere;
	
		var action = jQuery.contextPath + "/path/limitSchema/limitSchema_saveLimitSchema.action"; 
		_showProgressBar(true);
		$.ajax({
			url: action,
		 	type:"post",		 
		 	data: params,
		 	dataType:"json",
		 	success: function(data)
		 	{
						$.data(document.getElementById("limitSchemaListForm_"
								+ _pageRef), 'changeTrack', false);
						
			   			if(typeof data["_error"] == "undefined" || data["_error"] == null)
		    			 {	 
			   				if (fromWhere == "FOM") {
			   					//EWBI160091 (403157)
								setCompCodeCif(data["limitSchemaCO"]["cifVo"].COMP_CODE);
							}
			   				if(null != document.getElementById("fomMaintForm_"+ _pageRef) && undefined != document.getElementById("fomMaintForm_"+ _pageRef)
			   						&& "undefined" != document.getElementById("fomMaintForm_"+ _pageRef))
	 						{
								var cifStatus = data["limitSchemaCO"]["cifVo"]["STATUS"];
								var latestCifupdateDate = data["limitSchemaCO"]["latestDateUpdated"];
								changeCIFValues(cifStatus, latestCifupdateDate);
							}
							limitSchemaGrid.trigger("reloadGrid");
							$("#limitSchemaDivPopupElementId").dialog("close");
						}
						_showProgressBar(false);

					}
		});
	}
}

function limitSchema_onCopyBtnClicked()
{
	var selectedRowId = $("#gridtab_limitSchemaCopyBtn_"+_pageRef).jqGrid('getGridParam','selrow');
   	var myObject = $("#gridtab_limitSchemaCopyBtn_"+_pageRef).jqGrid('getRowData',selectedRowId);
   	var params = {};
   	params["branchCode"]	= myObject["BRANCH_CODE"];
   	params["currencyCode"]	= myObject["CURRENCY_CODE"];
   	params["glCode"]	= myObject["GL_CODE"];
   	params["cifSubNo"]	= myObject["CIF_SUB_NO"];
   	params["slNo"]	= myObject["SL_NO"];
   	params["compCodeCif"]	= $("#compCodeCif_" + _pageRef).val();
   	var action = jQuery.contextPath + "/path/limitSchema/limitSchema_onCopyButtonClicked.action"
   	
   	_showProgressBar(true);
	$.ajax({
		 url: action,
		 type:"post",		 
		 data: params,
		 dataType:"json",
		 success: function(data)
		 {	
			if(data["_error"] == null){
				jQuery("#limitSchemaGrid_Id_"+_pageRef).jqGrid('setGridParam', {
						url : jQuery.contextPath	+ '/path/limitSchema/limitSchema_loadLimitSchemaGridData',
						datatype : 'json',
						postData: params
					}).trigger("reloadGrid");
			}
			_showProgressBar(false);
		}
	});	
   	
}

function loadLimitSchemaCombo(){
	return $("#groupComboList_" + _pageRef).val();
}

function limitSchema_ApproveClicked(){
var limitSchemaApproveList  = limitSchema_getSelectedLimitSchemaList();
 if($.isEmptyObject(limitSchemaApproveList)){
	    	_showErrorMsg(msg_noRecordSelectedLabel);
	    	return;
	    }
		 $.ajax({
			 url: $.contextPath+"/path/limitSchema/limitSchema_approveLimitSchemaList",
	         type:"post",		 
			 data: limitSchemaApproveList,
			 dataType:"json",
			 success: function(data){			
			 	if(typeof data["_error"] == "undefined" || data["_error"] == null) {			 	 
			 		$("#limitSchemaGrid_Id_" + _pageRef).trigger("reloadGrid");
			 		_signCallBackObj.schemaApproved = true;
			 	
			 	} 
			 }
	    }); 
}

function limitSchema_RejectClicked(){
	var limitSchemaApproveList  = limitSchema_getSelectedLimitSchemaList();
 if($.isEmptyObject(limitSchemaApproveList)){
	    	_showErrorMsg(msg_noRecordSelectedLabel);
	    	return;
	    }
		 $.ajax({
			 url: $.contextPath+"/path/limitSchema/limitSchema_rejectLimitSchemaList",
	         type:"post",		 
			 data: limitSchemaApproveList,
			 dataType:"json",
			 success: function(data){			
			 	if(typeof data["_error"] == "undefined" || data["_error"] == null) {
				 	 $("#limitSchemaGrid_Id_" + _pageRef).trigger("reloadGrid");		
				 	 _signCallBackObj.schemaRejected = true;
			 	} 
			 }
	    }); 

}

function limitSchema_getSelectedLimitSchemaList(){
	    var limitSchemaList =  new Object();
		var selectedLimitSchema = null;
	    $.each(	$("#limitSchemaGrid_Id_" + _pageRef).jqGrid('getGridParam','selarrrow'), function(index, rowId) {		    	
		selectedLimitSchema = $("#limitSchemaGrid_Id_" + _pageRef).jqGrid('getRowData',rowId)		 
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.LINE"] 			= 	selectedLimitSchema["limitSchemaVO.LINE"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.LIMIT_AMT"] 	= 	selectedLimitSchema["limitSchemaVO.LIMIT_AMT"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.TRX_TYPE"] 		= 	selectedLimitSchema["limitSchemaVO.TRX_TYPE"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP1"] 		= 	selectedLimitSchema["limitSchemaVO.GROUP1"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP2"] 		= 	selectedLimitSchema["limitSchemaVO.GROUP2"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP3"] 		= 	selectedLimitSchema["limitSchemaVO.GROUP3"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP4"] 		= 	selectedLimitSchema["limitSchemaVO.GROUP4"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP5"] 		= 	selectedLimitSchema["limitSchemaVO.GROUP5"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP6"]		= 	selectedLimitSchema["limitSchemaVO.GROUP6"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP7"]		= 	selectedLimitSchema["limitSchemaVO.GROUP7"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP8"] 		= 	selectedLimitSchema["limitSchemaVO.GROUP8"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP9"] 		= 	selectedLimitSchema["limitSchemaVO.GROUP9"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.GROUP10"] 		= 	selectedLimitSchema["limitSchemaVO.GROUP10"];
		limitSchemaList["limitSchemaCOList["+index+"].neverExpire"]					= 	selectedLimitSchema["neverExpire"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.EFFECTIVE_FROM"]= 	selectedLimitSchema["limitSchemaVO.EFFECTIVE_FROM"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.EFFECTIVE_TO"] 	= 	selectedLimitSchema["limitSchemaVO.EFFECTIVE_TO"];
		limitSchemaList["limitSchemaCOList["+index+"].origin"] 						= 	selectedLimitSchema["origin"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.STATUS"] 		= 	selectedLimitSchema["limitSchemaVO.STATUS"];
		limitSchemaList["limitSchemaCOList["+index+"].unlimited"] 					= 	selectedLimitSchema["unlimited"];
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.ACC_CIF"] 		= 	$("#limitSchema_cifSubNo_hdn_" + _pageRef).val();
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.ACC_BR"] 		= 	$("#limitSchema_branchCode_hdn_" + _pageRef).val();
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.ACC_GL"] 		= 	0;
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.ACC_SL"] 		= 	0;
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.ACC_CY"] 		= 	0;
		limitSchemaList["limitSchemaCOList["+index+"].limitSchemaVO.COMP_CODE"] 	= 	$("#compCodeCif_"+ _pageRef).val();
		
		
		

		}); 
	    return limitSchemaList;
	
	
	
}

function onLimitSchemCheckBoxSelect(event,rowObj){
	 
	var grid   = $("#limitSchemaGrid_Id_" + _pageRef);	 
	var hideBtns = false;
	$.each(grid.jqGrid('getGridParam','selarrrow'), function(index, rowId) {	    	
	  		if(grid.jqGrid('getRowData',rowId)['origin']=="1"){
	   			 hideBtns  =  true;
	    	}
	    			
	   });
	   if(hideBtns){
			$("#limitSchema_ApproveBtn_Id_"+_pageRef).hide();
	    	$("#limitSchema_RejectBtn_Id_"+_pageRef).hide();	    			 
	   }
	   else{
	    	$("#limitSchema_ApproveBtn_Id_"+_pageRef).show();
	    	$("#limitSchema_RejectBtn_Id_"+_pageRef).show();
	   }

	    
	
}


