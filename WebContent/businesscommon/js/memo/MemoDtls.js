function showMemoDtlsStatus() {	 
	if($('#trxNo_'+_pageRef).val()=="")return 
	//if($("#memoDetailsGrid_Id_"+_pageRef).jqGrid('getGridParam', 'selrow')==null)return 
	showStatus("memoDtlsForm_"+_pageRef,
				_pageRef, 
				jQuery.contextPath + "/path/memo/MemoGrid_loadStatusGridDef",
				{"ctsMemoDetVOKey.TRX_NO" : $('#trxNo_'+_pageRef).val()} );
 

}
function newMemo() {
	$("#memoDtlsForm_"+_pageRef).clearForm();
	$("#memoDetailsGrid_Id_"+_pageRef).jqGrid('resetSelection');
}


function setMemoDtlsAccountLookup()
{
	

   var selectedRowId = $("#gridtab_accSl_"+_pageRef).jqGrid('getGridParam','selrow');
   var myObject = $("#gridtab_accSl_"+_pageRef).jqGrid('getRowData',selectedRowId);
  
  $("#accBr_"+_pageRef).val(myObject["amfVO.BRANCH_CODE"]); 	
  $("#accCy_"+_pageRef).val(myObject["amfVO.CURRENCY_CODE"]); 	
  $("#accGl_"+_pageRef).val(myObject["amfVO.GL_CODE"]); 	
  $("#accCif_"+_pageRef).val(myObject["amfVO.CIF_SUB_NO"]); 	
  $("#lookuptxt_cifNo_"+_pageRef).val(myObject["amfVO.CIF_SUB_NO"]);
}

function setMemoDtlsAddRefLookup()
{
	

   var selectedRowId = $("#gridtab_accAddRef_"+_pageRef).jqGrid('getGridParam','selrow');
   var myObject = $("#gridtab_accAddRef_"+_pageRef).jqGrid('getRowData',selectedRowId);   
  $("#accBr_"+_pageRef).val(myObject["amfVO.BRANCH_CODE"]); 	
  $("#accCy_"+_pageRef).val(myObject["amfVO.CURRENCY_CODE"]); 	
  $("#accGl_"+_pageRef).val(myObject["amfVO.GL_CODE"]); 	
  $("#accCif_"+_pageRef).val(myObject["amfVO.CIF_SUB_NO"]); 	
   $("#lookuptxt_accSl_"+_pageRef).val(myObject["amfVO.SL_NO"]);
  $("#lookuptxt_cifNo_"+_pageRef).val(myObject["amfVO.CIF_SUB_NO"]);
}


 



function onMemoDtlsGridDbClick(){
	 if($("#iv_crud_"+_pageRef).val()=="R"){
			var changes = $("#memoDtlsForm_"+_pageRef).hasChanges();
			
			if(changes == 'true' || changes == true)
			{
				_showConfirmMsg(changes_made_confirm_msg,"","onMemoDtlsGridDbClickAfterConfirm","yesNo"); //Confirmation call if changes made		
			}
			else
			{			
				onMemoDtlsGridDbClickAfterConfirm(true); //Direct call if no change		
			}	
		}
	 else{
		 	onMemoDtlsGridDbClickAfterConfirm(true); //Direct call if the screen doesn't have edit form eg:approve reject etc..
	 }
		
		
	 
	
}

function onMemoDtlsGridDbClickAfterConfirm(yesNo){
	
	if(yesNo){
		var theGrid = $("#memoDetailsGrid_Id_"+_pageRef);
 		var sel_id = theGrid.jqGrid('getGridParam', 'selrow'); 
	    var trxNo = theGrid.jqGrid('getCell', sel_id, 'TRX_NO');
		var actionSrc = jQuery.contextPath+"/path/memo/MemoDtlsMaint_populateMemoForm"; 
		_showProgressBar(true);
		$.post(actionSrc,{"memoDtlCO.ctsMemoDetVO.TRX_NO":trxNo,"_pageRef":_pageRef,"iv_crud":$('#iv_crud_'+_pageRef).val()}, function(data) {			 
  			$('#memoDtlsMaint_id_'+_pageRef).html(data);
		}).complete(function() { _showProgressBar(false); });
		showHideSrchGrid('memoDetailsGrid_Id_'+_pageRef);
	}
	
	
}

function memoDtlsValidateDates(date){
		var isDateValid=!(($("#fromDate_"+_pageRef).datepicker("getDate")!=null)&&($("#toDate_"+_pageRef).datepicker("getDate")!=null)&&(compareDate("fromDate_"+_pageRef,"toDate_"+_pageRef)==1));		 
 			$.ajax({
				url: $.contextPath+"/path/memo/MemoDtlsMaint_validateDate",
	         	type:"post",		 
			 	data: {"dateValid":isDateValid,"date":$(date).val()},
			 	dataType:"json",
			 	success: function(data){			 		 
				 	if(data["_error"] != null) {		 	
						$(date).val('');
				} 
			 }
	   	 });
 	} 
function reviewMemo()
{
	var forAccOrCif = $("#forAccOrCif").val();
	var cifNo = $("#cifNo").val();
	var accBR = $("#accBR").val();
	var accCY = $("#accCY").val();
	var accGL = $("#accGL").val();
	var accCIF = $("#accCIF").val();
	var accSL = $("#accSL").val();
	var reviewMemoList =  new Object();
	
	$.each($("#memoGrid").jqGrid('getGridParam','selarrrow'), function(index, value) {		 
		var memo = $("#memoGrid").jqGrid('getRowData',value)
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.TRX_NO"] = memo.TRX_NO;
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.BRANCH_CODE"] = memo.BRANCH_CODE;	
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.MEMO_CODE"] = memo.MEMO_CODE;	
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.COND_AUTOMATION_CODE"] = memo.condAutomationCode;	
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.CIF_NO"] = memo.CIF_NO;	
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.ACC_BR"] = memo.ACC_BR;
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.ACC_CY"] = memo.ACC_CY;
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.ACC_GL"] = memo.ACC_GL;
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.ACC_CIF"] = memo.ACC_CIF;
		reviewMemoList["reviewMemoList["+index+"].ctsmemoDETVO.ACC_SL"] = memo.ACC_SL;
		reviewMemoList["reviewMemoList["+index+"].eventType"] = memo.eventType;
	}); 
	var detailsParmeters = {'forAccOrCif':forAccOrCif,'cifNo':cifNo,'accBR':accBR,'accCY':accCY,'accGL':accGL,'accCIF':accCIF,'accSL':accSL};
	
	$.extend(reviewMemoList, detailsParmeters);
	
	$.ajax({
		 url: $.contextPath+"/path/memo/MemoGrid_reviewMemo",
         type:"post",		 
		 data: reviewMemoList,
		 dataType:"json",
		 success: function(data){			
		 	if(typeof data["_error"] == "undefined" || data["_error"] == null) {		 	
				$("#memoGrid").trigger("reloadGrid"); } 
		 }
    });
}

function memoDtls_submitManagement(confirmDeletion)
{
	var submit = "true";
	var ivCrud          = $("#iv_crud_"+_pageRef).val();
	var localActionType = $("#actionType_"+_pageRef).val();	
	var methodName = "";
	parseNumbers();	 
	switch (ivCrud)
	{
	case "R":	   	
	   methodName = localActionType;
	  break;
	case "P":
	   methodName = "approve";
	  break;
	case "N":
	  methodName = "cancel";
	  break;
	case "S":
	  methodName = "suspend";
	  break;
	case "RA":
	   methodName = "toReactivate";
	  break;
	case "SP":
	   methodName = "toSuspend";
	  break;
	case "CN":
	  methodName = "toCancel";
	  break;
	case "A":
	  methodName = "reactivate";
	  break;
  	case "UP":
	   methodName = "saveNew";
	  break;
	}  		
	var reloadPath = jQuery.contextPath+"/path/memo/MemoDtlsMaint_initialize?iv_crud="+ivCrud+"&_pageRef="+_pageRef;
	var trx_no  = $("#trxNo_"+_pageRef).val();
	if((methodName == "saveNew" || ivCrud == "R") && (methodName != "delete"))
	{
		var changes = $("#memoDtlsForm_"+_pageRef).hasChanges(true);
		if(changes != "true" && changes != true)
		{
			submit = "false";
		}
	}
	if(methodName == "delete" && confirmDeletion != true)
	{
		_showConfirmMsg(Confirm_Delete_Process_key, confirm_msg_title, function(confirmcChoice){
			if(confirmcChoice)
			{
				memoDtls_submitManagement(true);
				return;
			} }, {});
		return;
	}
	if(submit == "true")
	{
		_showProgressBar(true);
		var theForm = $("#memoDtlsForm_"+_pageRef).serializeForm();
		$.ajax({
			 url: jQuery.contextPath+"/path/memo/MemoDtlsSubmit_"+methodName,
			 dataType: "json",
			 type:"post",
			 data: theForm,
			 success : function(res) 
			         {
					     if(typeof res["_error"] == "undefined" || res["_error"] == null)
					     {
							$.post(reloadPath
								   ,{}
							       ,function( param )
						 	        {
								       $("#memoDtlsMaint_id_"+_pageRef).html(param);
								       if($("#memoDetailsGrid_Id_"+_pageRef).html()!=null && $("#memoDetailsGrid_Id_"+_pageRef).html()!="")
						               {
						                 	$("#memoDetailsGrid_Id_"+_pageRef).trigger("reloadGrid");
						               }
								       _showProgressBar(false);
							        }
							       ,"html");
				         }
					     else
					     {
					    	  _showProgressBar(false);
					     }
			 	    }
		
	    });
	}
	return false;
}
 	
 /**
 * on add click, open the maint form in save new mode ...
 * @param {Object} sel_row_index
 */
function memoDtls_onAddClicked(sel_row_index)
{
 
	var changes = $("#memoDtlsForm_"+_pageRef).hasChanges();		 
		if(changes == 'true' || changes == true)
		{
			_showConfirmMsg(changes_made_confirm_msg,"","memoDtls_onAddClickAfterConfirm","yesNo"); //Confirmation call if changes made		
		}
		else
		{			
			memoDtls_onAddClickAfterConfirm(true); //Direct call if no change		
		}	
		
	
	
	
}

function memoDtls_onAddClickAfterConfirm(yesNo){
	if(yesNo){	
		var ivCrud  = $("#iv_crud_"+_pageRef).val();
		if(ivCrud == 'R')
		{
			var actionSrc  = jQuery.contextPath+"/path/memo/MemoDtlsMaint_initialize?iv_crud="+ivCrud+"&_pageRef="+_pageRef;		
			$.post(actionSrc
				   ,{}
			       ,function( param )
		 	        {
			       $("#memoDtlsMaint_id_"+_pageRef).html(param);
			        }
			       ,"html");
		}	
	}
	
	
	
}

//added by maria for bug#677747
function memoDtlsDelete(actionType){
	
	$("#actionType_"+_pageRef).val(actionType);
	
	memoDtls_submitManagement(false);
	
}


function setActionType(actionType){	
	$("#actionType_"+_pageRef).val(actionType);
}

function afterDepEventMemoDtlsCifNo(){
	
	
	if(!$("#accCif_"+_pageRef).attr("readonly")){
			
			$("#accBr_"+_pageRef).val('');
			$("#accCy_"+_pageRef).val('');
			$("#accGl_"+_pageRef).val('');
			$("#accCif_"+_pageRef).val($("#lookuptxt_cifNo_"+_pageRef).val());	
			$("#lookuptxt_accSl_"+_pageRef).val('');
			$("#accDesc_"+_pageRef).val('');			 
			$("#lookuptxt_accAddRef_"+_pageRef).val('');
	}
	
	
}

//************************************************************************************************//
/*
This function is called when clicking on the alert button
*/
function openMemoAlert()
{
	var iv_crud = $("#iv_crud_" + _pageRef).val();
	var formParams = $("#memoDtlsForm_" + _pageRef).serializeForm();
    
	$.ajax( {
			url : jQuery.contextPath
				  + '/path/memo/MemoDtlsMaint_onAlertButtonClicked.action?iv_crud=' + iv_crud,
			type : "post",
			dataType : "json",
			data : formParams
		});
}


function memoDtls_loadMemoAlertDescription(parameters)
{
	if(parameters != undefined && parameters != null)
	{
		var detailsParmeters = {
							'memoDtlCO.isFromAlert':'true',
							'memoDtlCO.alertsParamCO.todoParam':parameters.todoParam,
							'memoDtlCO.alertsParamCO.progRef':parameters.progRef,
							'memoDtlCO.alertsParamCO.todoAlert':parameters.todoAlert,
							'memoDtlCO.alertsParamCO.todoExcepEnglish':parameters.todoExcepEnglish,
							'memoDtlCO.alertsParamCO.todoExcepArabic':parameters.todoExcepArabic,
							'memoDtlCO.alertsParamCO.compCode':parameters.compCode,
							'memoDtlCO.alertsParamCO.branchCode':parameters.branchCode,
							'memoDtlCO.alertsParamCO.todoCode':parameters.todoCode,
							'memoDtlCO.alertsParamCO.todoLine':parameters.todoLine,
							'memoDtlCO.alertsParamCO.todoFrBranch':parameters.todoFrBranch
						};
		$.ajax({
			url: jQuery.contextPath + "/path/memo/MemoDtlsMaint_loadAlertMemoDetails",
			type:"post",
			dataType:"json",
			data: detailsParmeters,
			success: function(data)
					{
						var todoCode = data["memoDtlCO"].alertsParamCO.todoCode;
						var todoLine = data["memoDtlCO"].alertsParamCO.todoLine;
						var detailsColor = data["memoDtlCO"].alertsParamCO.detailsColor;
						var alertDescription = data["memoDtlCO"].alertsParamCO.alertDescription;
						trsAckTOutAlertGrid_openTrxDetails(alertDescription,todoCode,todoLine, detailsColor);
					}
			});
	}	
}

function test()
{
	
}