(function($) {
	blackListMaint_onDocReady = function() 
	{

	};
})(jQuery);

var ctxPath = jQuery.contextPath;

// BlackList Status Button 
function onBlackListStatusClicked() {
	var code = $("#blackListVO_CODE_" + _pageRef).val();
	var loadSrc = jQuery.contextPath
			+ "/path/blackList/BlackListStatus_loadStatusGridDef.action?blackListSC.code=" + code
			+ "&_pageRef=" + _pageRef;

	showStatus("blackListMaintForm_" + _pageRef, _pageRef, loadSrc, {});
}

// Function called upon double clicking grid
function blackListGridTbl_Id_onDbClicked() {
	var changes = $("#blackListMaintForm_" + _pageRef).length == 0? false: $("#blackListMaintForm_" + _pageRef).hasChanges();
	if (changes == 'true' || changes == true) {
		_showConfirmMsg(changes_made_confirm_msg, confirm_msg_title,
				"blackListGridTbl_Id_onDbClickedConfirm", "yesNo");
	} else {
		blackListGridTbl_Id_onDbClickedConfirm(true);
	}
}

function blackListGridTbl_Id_onDbClickedConfirm(yesNo)
{
	if(yesNo==true)
	{
		var $table = $("#blackListGridTbl_Id_" + _pageRef);
		var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
		var myObject = $table.jqGrid('getRowData', selectedRowId);
		
		var blackListParams = {};
		blackListParams["_pageRef"] 			= 	_pageRef;
		blackListParams["iv_crud"] 				= 	$("#iv_crud_" + _pageRef).val();
		blackListParams["blackListSC.code"] 	=	 myObject["blackListVO.CODE"];
		
		var loadSrc = ctxPath + '/path/blackList/BlackListMaint_showBlackListDetails.action';
		_showProgressBar(true);
		$("#blackListDetailDiv_id_" + _pageRef).load(loadSrc,blackListParams, function() 
			{
				showHideSrchGrid('blackListGridTbl_Id_'+_pageRef);
				_showProgressBar(false);
			});
	}
}

// Function called upon Add button clicked
function blackListGridTbl_Id_onAddClicked() 
{
	var changes = $("#blackListMaintForm_" + _pageRef).length == 0? false: $("#blackListMaintForm_" + _pageRef).hasChanges();
	if (changes == 'true' || changes == true) {
		_showConfirmMsg(changes_made_confirm_msg, confirm_msg_title,
				"blackListGridTbl_afterConfirmNewPage", "yesNo");
	} else {
		blackListGridTbl_afterConfirmNewPage(true);
	}
	
}

function blackListGridTbl_afterConfirmNewPage(yesNo) {
	if (yesNo) {
		var blackListParams = {};
		blackListParams["_pageRef"] = _pageRef;
		blackListParams["iv_crud"] = $("#iv_crud_" + _pageRef).val();
		var loadSrc = ctxPath + '/path/blackList/BlackListMaint_loadBlackListDetailPage.action';
		_showProgressBar(true);
		$("#blackListDetailDiv_id_" + _pageRef).load(loadSrc, blackListParams,
				function() {
					showHideSrchGrid('blackListGridTbl_Id_' + _pageRef);
					_showProgressBar(false);
				});
	}
}

// Function called upon clicking SAVE
function blackListMgnt_saveBlackList() 
{
	var changes = $("#blackListMaintForm_"+_pageRef).hasChanges(true);
	if(changes == 'true' || changes == true)
	{
		parseNumbers();
		var blackListForm = $("#blackListMaintForm_" + _pageRef).serializeForm();
		
		var blackListIdsData = '';
		var blackListIdsGrid = $("#blackListIdsGridTbl_Id_" + _pageRef);//Trx Type Grid
		var rowIds = blackListIdsGrid.jqGrid('getDataIDs');
		var rowLength = rowIds.length;
		if(rowLength > 0)
		{
			for ( var i = 0; i < rowLength; i++) // Checking whether all mandatory fields are filled
			{
				blackListIdsGrid.jqGrid('saveRow',rowIds[i], false, 'clientArray');// save any row which is still in edit mode
				
				if (blackListIdsGrid.jqGrid('getCell', rowIds[i],'blackListIdVO.ID_TYPE') == "") 
				{
					_showErrorMsg(Please_id_type_key, error_msg_title);
					//_showErrorMsg('Please fill the ID Type for already added record(s)');
					blackListIdsGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
					blackListIdsGrid.jqGrid('editRow',rowIds[i]);// making current row editable
					return;
				}
				else if (blackListIdsGrid.jqGrid('getCell', rowIds[i],'blackListIdVO.ID_NO') == "") 
				{
					_showErrorMsg(Please_id_no_key, error_msg_title);
					//_showErrorMsg('Please fill ID No for already added record(s)');
					blackListIdsGrid.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
					blackListIdsGrid.jqGrid('editRow',rowIds[i]);// making current row editable
					return;
				}
			}
			blackListIdsData = blackListIdsGrid.jqGrid('getAllRows'); // Grid Data
		}
		
		blackListIdsData="blackListIdsStr="+blackListIdsData;
		var ivCrud = $("#iv_crud_" + _pageRef).val();
		var	action = jQuery.contextPath + "/path/blackList/BlackListMaint_saveBlackList.action?iv_crud="+ ivCrud;
		blackListForm = blackListForm+'&'+blackListIdsData;

		_showProgressBar(true);
		$.ajax( 
			{
				url : action,
				type : "post",
				dataType : "json",
				data : blackListForm,
				success : function(data) 
				{
					_showProgressBar(false);
					if (typeof data["_error"] == "undefined" || data["_error"] == null)
					{
						$("#blackListDetailDiv_id_" + _pageRef).load(reloadPath);
						if ($("#blackListGridTbl_Id_" + _pageRef).html() != null && $("#blackListGridTbl_Id_" + _pageRef).html() != "") 
						{
							$("#blackListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
						}
					}
				}
			});
	}
}


/**
 * 
 * @param {Object} methodName
 */
function blacklistMaint_amendMethodName(methodName){
	$("#methodName_"+_pageRef).val(methodName);
}


// Function called upon clicking DELETE/APPROVE/REVERSE/UPDATE AFTER APPROVE/TO BE REVERSED
function blackListMgnt_submitBlackList()
{
	var action = $("#methodName_"+_pageRef).val();
	var confirmMsg,successMsg,reload;
	if (action.indexOf("save")!=-1) {
		reload=true;
		confirmMsg = Confirm_Save_Process_key; //modified by Marie-Joe for tp#677743 was "Confirm_Success_key"
		successMsg = "record_created_Successfully_key";
	}else
		if (action.indexOf("update")!=-1) 
		{
			reload=true;
			confirmMsg = "Confirm_update_Process_key";
			successMsg = "record_was_updated_Successfully_key";
		}
	else if (action.indexOf("delete")!=-1) 
		{
			reload=true;
			confirmMsg = Confirm_Delete_Process_key;  //modified by Marie-Joe for tp#677743 was "Confirm_delete_Process_key"
			successMsg = "record_was_deleted_Successfully_key";
		}
	else if (action.indexOf("approve")!=-1)
		{
			reload=true;
			confirmMsg = "Confirm_Success_key";
			successMsg = "record_approved_Successfully_key";
		}
	else if (action.indexOf("reverse")!=-1) 
		{
			reload=true;
			confirmMsg = "Confirm_delete_Process_key";
			successMsg = "record_was_deleted_Successfully_key";
		}
	else if (action.indexOf("toBeReversed")!=-1)
		{
			reload=true;
			confirmMsg = Confirm_Reverse_Process_key;//modified by Marie-Joe for tp#681235 was "Confirm_Success_key"
			successMsg = "record_approved_Successfully_key";
		}
	//added for tp#677743
	if ((action.indexOf("delete")!=-1) || (action.indexOf("save")!=-1) || (action.indexOf("toBeReversed")!=-1))
	{
		_showConfirmMsg(confirmMsg, Warning_key,
			 callSubmit_blackList, { url : action , msg : successMsg, reload : reload});
	}
	//end tp#677743
	else
	{
		//true added for tp#677743
		callSubmit_blackList(true, { url : action , msg : successMsg, reload : reload}) ;
	}
	//return false;
}

//added by abbas for Bug#681229
function blackListMgnt_deleteBlackList(methodName)
{
	var confirmMsg,successMsg,reload;
	reload=true;
	confirmMsg = Confirm_Delete_Process_key; 
	successMsg = "record_was_deleted_Successfully_key";
	_showConfirmMsg(confirmMsg, Warning_key,
			 callSubmit_blackList, { url : methodName , msg : successMsg, reload : reload});
}
//end abbas


/**
 * Show/Hide Black List ID No grid upon clicking on the button IDs
 */
function blackListIds_showHideBlackListIdGrid() {
	var blackCode = $("#blackListVO_CODE_" + _pageRef).val();
	if (blackCode == '') {
		_showErrorMsg(Please_define_blacklist_code_key, error_msg_title);
		return;
	} else {
		//check if the grid is already opened or not
		if ($("#blackList_idTr_" + _pageRef).attr("style").indexOf(
				"visibility: collapse") != -1) {
			$("#blackList_idTr_" + _pageRef).attr("style",
					"visibility: visible;");
		} else {
			$("#blackList_idTr_" + _pageRef).attr("style",
					"visibility: collapse;");
		}
	}
	//IE9 grid resize issue
	resizeSingleGrid("blackListIdsGridTbl_Id_" + _pageRef);
}


	// Show Hide mechanism for Reference Prefix Popup
	function blackListCodeDependency_showHideBlackListIdGrid()
	{
		var blackCode = $("#blackListVO_CODE_" + _pageRef).val();
		if(blackCode=='')
		{
			if($("#blackList_idTr_"+_pageRef).attr("style") == "visibility: visible;"
				|| $("#blackList_idTr_"+_pageRef).attr("style") == "visibility: visible")
			{
				$("#blackList_idTr_"+_pageRef).attr("style","visibility: collapse;");
			}
		}
	}
//************************************************************* Sub Grid *************************************************************//	

	// Function called upon Add button of Grid is clicked
	function blackListIdsGridTbl_Id_addId(){
		var idGrid = $("#blackListIdsGridTbl_Id_" + _pageRef);
		var rowIds = idGrid.jqGrid('getDataIDs');
		var addRowFlag = true;
		for ( var i = 0; i < rowIds.length; i++) 
		{
			var rowId = rowIds[i];
			if (idGrid.jqGrid('getCell', rowId,'blackListIdVO.ID_TYPE') == "") 
			{
				addRowFlag = false;
				alert('Please fill the ID Type for already added record(s)');
				break;
			}
			else if (idGrid.jqGrid('getCell', rowId,'blackListIdVO.ID_NO') == "") 
			{
				addRowFlag = false;
				alert('Please fill ID No for already added record(s)');
				break;
			}
		}
		if (addRowFlag) {
			idGrid.jqGrid('addInlineRow', {});
		}
	} 

// Function called upon Delete button of Grid is clicked
	function blackListIdsGridTbl_Id_deleteId(){
		var rowId = $("#blackListIdsGridTbl_Id_"+_pageRef).jqGrid('getGridParam','selrow');	
		$("#blackListIdsGridTbl_Id_"+_pageRef).jqGrid('deleteGridRow',rowId);
	} 
	
	/**
 * Common Function called upon clicking DELETE / SAVE / Update 
 * @param {Object} args
 * @return false
 */
/*confirm added for tp#677743 to handle case of confirmation msg on save/delete/to be reversed*/	
function callSubmit_blackList(confirm, args)
{
	if (confirm) //confirm instead of true for tp#677743
	{
		//added by bilal For BUG#971381
		if (blackListId_prepareGridUpdate() == false)
		{
			return;
		};
		var action = args.url;
		var ivCrud = $("#iv_crud_" + _pageRef).val();
		parseNumbers(); 
	   	var theForm = $("#blackListMaintForm_"+_pageRef).serializeForm();
	   	_showProgressBar(true);
	   	$.ajax({
		 url: action+"?iv_crud="+ ivCrud,
         type:"post",
		 dataType:"json",
		 data: theForm,
		 success : function(data) {
				_showProgressBar(false);
				if (typeof data["_error"] == "undefined" || data["_error"] == null) {
					if (typeof data["_confirm"] != "undefined" && data["_confirm"] != null && data["_confirm"] != "") {
						_showConfirmMsg(data["_confirm"], "", "continueProcessAfterConfirm", action);
						return;
					} else {
						newBlackList();
					}
				}
			}
    	});
		return false;
	}
}


function blackListId_prepareGridUpdate() {
	//added/Commented by bilal For BUG#971381
//	var $t = $("#blackListIdsGridTbl_Id_" + _pageRef);
//	var jsonStringUpdates = $t.jqGrid("getAllRows");
//	$('#blackListIdsStr_' + _pageRef).val(jsonStringUpdates);
	var $t = $("#blackListIdsGridTbl_Id_" + _pageRef);
	var rowIds = $t.jqGrid('getDataIDs');
	var rowLength = rowIds.length;
	if(rowLength > 0)
	{
		for ( var i = 0; i < rowLength; i++) // Checking whether all mandatory fields are filled
		{
			$t.jqGrid('saveRow',rowIds[i], false, 'clientArray');// save any row which is still in edit mode
			
			if ($t.jqGrid('getCell', rowIds[i],'blackListIdVO.ID_TYPE') == "") 
			{
				_showErrorMsg(Please_id_type_key, error_msg_title);
				//_showErrorMsg('Please fill the ID Type for already added record(s)');
				$t.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
				$t.jqGrid('editRow',rowIds[i]);// making current row editable
				return false;
			}
			else if ($t.jqGrid('getCell', rowIds[i],'blackListIdVO.ID_NO') == "") 
			{    
				_showErrorMsg(Please_id_no_key, error_msg_title);
			//'Please fill ID No for already added record(s)');
				$t.jqGrid('setSelection',rowIds[i], false);// setting selection to current row
				$t.jqGrid('editRow',rowIds[i]);// making current row editable
				return false;
			}
		}
		var jsonStringUpdates = $t.jqGrid("getAllRows");
		$('#blackListIdsStr_' + _pageRef).val(jsonStringUpdates);
	}
}

  function continueProcessAfterConfirm(yesNo, action) {
	  if (yesNo == true) { 
		var theForm = "";
		var ivCrud = $("#iv_crud_" + _pageRef).val();
		var action = action + "?iv_crud="+ ivCrud + "&messageConfirmed=" + true;
		//var formAndGridsResult = preparingFormAndGridsForSaving();
		var theForm = $("#blackListMaintForm_"+_pageRef).serialize();
		_showProgressBar(true);
		$.ajax( {
			url : action,
			type : "post",
			dataType : "json",
			data : theForm,
			success : function(data) {
				_showProgressBar(false);
				if (typeof data["_error"] == "undefined" || data["_error"] == null) {
					
					//new checking
					if(ivCrud=='P' ||ivCrud =='V'){
						
						confirmMsg = printAffectedCifKey;
						_showConfirmMsg(confirmMsg, Warning_key, function(confirmChoice)
						{
							if (confirmChoice)
							{
								var op='';
								if(ivCrud=='P')
									{
									op='approve';
									}
								if(ivCrud='V')
									{
									op='reverse';
									}
									
								var code = data["blackListCO"]["blackListVO"]["CODE"];
								var compCode = data["blackListCO"]["loginCompCode"];
								var userId= data["blackListCO"]["loginUserId"];
								var params =compCode  + "~#~" + userId + "~#~" + op + "~#~" + code;
								openPreviewAdvice("RETBLUPD", params, 1, null);
							}
						});
						
						
						
					}
					newBlackList();
				}
			}
		});
		return false;
	}
}
  
function newBlackList()
{
	var ivCrud = $("#iv_crud_" + _pageRef).val();
		$.ajax({
		 url: jQuery.contextPath + "/path/blackList/BlackListMaint_loadBlackListDetPage?iv_crud="+ ivCrud 
																						+ "&_pageRef=" + _pageRef,
         type:"post",
		 success : function(data) {
						if ( typeof data["_error"] == "undefined" || data["_error"] == null) {
							$("#blackListDetailDiv_id_" + _pageRef).html(data);
							$("#blackListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
							
							}
					}
    });
}


function blackList_openAlertsClicked() 
{
	var ivCrud = $("#iv_crud_" + _pageRef).val();
	var formParams = $("#blackListMaintForm_" + _pageRef).serializeForm();
	$.ajax( {
			url : jQuery.contextPath
				  + '/path/blackList/BlackListMaint_onAlertButtonClicked.action?iv_crud='+ ivCrud ,
			type : "post",
			dataType : "json",
			data : formParams
		});
}
//******************************************************************************************************************************** //

function setColTypeNumber(event) {
	var key = event.charCode || event.keyCode;
	/* all number, 'tab' and 'backspace' keys only allowed */
	if ((key != 8 && key != 9) && (key < 46 || key > 57)) {
		event.preventDefault();
	}
}
function fillIDGridData()
{

	var blackListIdsGrid = $("#blackListIdsGridTbl_Id_" + _pageRef);
	blackListIdsStr = blackListIdsGrid.jqGrid('getAllRows'); 
	$("#blackListIdsStr_" + _pageRef).val(blackListIdsStr);
}

function blackList_alertCallBackFunc(data)
{
	if (typeof data["_error"] == "undefined" || data["_error"] == null)
	{
		if(openItem_OldPageRef != undefined && openItem_OldPageRef != null && openItem_OldPageRef != '')
		{	
			if(data.blackListCO && data.blackListCO.alertsParamCO && data.blackListCO.alertsParamCO.isLocalApprove == 'true')
			{ 
				 var ivCrud = $("#iv_crud_" + openItem_OldPageRef).val();
				 $.ajax({
						 url: jQuery.contextPath + "/path/blackList/BlackListMaint_loadBlackListDetPage?iv_crud="+ ivCrud 
																										+ "&_pageRef=" + openItem_OldPageRef,
				         type:"post",
						 success : function(data) {
										if ( typeof data["_error"] == "undefined" || data["_error"] == null) {
											$("#blackListDetailDiv_id_" + openItem_OldPageRef).html(data);
											$("#blackListGridTbl_Id_" + openItem_OldPageRef).trigger("reloadGrid");
											}
									}
				     });
			}
		}
	}
}


function blackList_loadBlackListAlertDescription(parameters)
{
	if(parameters != undefined && parameters != null)
	{
		var detailsParmeters = {
							'blackListCO.isFromAlert':'true',
							'blackListCO.alertsParamCO.todoParam':parameters.todoParam,
							'blackListCO.alertsParamCO.progRef':parameters.progRef,
							'blackListCO.alertsParamCO.todoAlert':parameters.todoAlert,
							'blackListCO.alertsParamCO.todoExcepEnglish':parameters.todoExcepEnglish,
							'blackListCO.alertsParamCO.compCode':parameters.compCode,
							'blackListCO.alertsParamCO.branchCode':parameters.branchCode,
							'blackListCO.alertsParamCO.todoCode':parameters.todoCode,
							'blackListCO.alertsParamCO.todoLine':parameters.todoLine,
							'blackListCO.alertsParamCO.todoFrBranch':parameters.todoFrBranch,
							'blackListCO.alertsParamCO.alertDescription':parameters.alertDescription
						};
		$.ajax({
			url: jQuery.contextPath + "/path/blackList/BlackListMaint_loadAlertBlackListDetails",
			type:"post",
			dataType:"json",
			data: detailsParmeters,
			success: function(data)
					{
						var todoCode = data["blackListCO"].alertsParamCO.todoCode;
						var todoLine = data["blackListCO"].alertsParamCO.todoLine;
						var alertDescription = data["blackListCO"].alertsParamCO.alertDescription;
						trsAckTOutAlertGrid_openTrxDetails(alertDescription,todoCode,todoLine);
					}
			});
	}	
}

//#82748 - Manage the alert for suspicious report generated on EOD
function blackList_blackListEODCallBack(data)
{
	if(data != undefined && data != null)
	{
		if(data.reportRef != undefined && data.reportRef != null && data.reportRef != ''
				&& data.parameter != undefined && data.parameter != null
				 	&& data.language != undefined && data.language != null)
		{
			_showProgressBar(true);
			
			var param = {'blackListCO.alertsParamCO.todoCode':data["blackListCO.alertsParamCO.todoCode"],
			   'blackListCO.alertsParamCO.todoLine':data["blackListCO.alertsParamCO.todoLine"]};
			
			$.ajax({
			url: jQuery.contextPath + "/path/blackList/BlackListMaint_blackListEODCallBack",
			type:"post",
			dataType:"json",
			data: param,
			success: function(currentData)
					{
						$.struts2_jquery.require("AlertsOpenItem.js" ,null,jQuery.contextPath+"/common/js/alerts/");
						//ALERTS_OPEN_ITEM_closeOpenItem();
						//Reload the trsAckTOut grid
						ALERTS_OPEN_ITEM_reloadTrsAckTOutGrid('RCVALERT');
						openPreviewAdvice(data.reportRef, data.parameter,null, null,null,data.language);
						
						_showProgressBar(false);
					}
			});
			
		}
	}
}

