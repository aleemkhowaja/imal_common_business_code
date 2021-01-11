function dynamicTemplateConventionMaint_processSubmit()
{
	var formChanged = $("#dynamicTemplateConventionMaintFormId_" + _pageRef).hasChanges();
	if (_pageRef == 'DT00CEMT' || _pageRef == 'DT00CEUP') 
	{
		if (!formChanged)
		{
			dynamicTemplateConventionMaint_handleSaveProcess(0);
			return;
		}
		else
		{
			var code = $("#entity_type_" + _pageRef).val();
			if(code =="A")
			{
				if($("#accBr_" + _pageRef).val() =="" || ($("#accCy_" + _pageRef).val() =="" || $("#accGl_" + _pageRef).val() =="" || $("#accCif_" + _pageRef).val() =="" || $("#lookuptxt_accSl_" + _pageRef).val() ==""))
				{
					_showErrorMsg("Invalid/missing Account",info_msg_title,300,100);
					return;
				}
			}
			else if(code == "C")
			{
				if($("#lookuptxt_cif_no_liveSearch_" + _pageRef).val() =="")
				{
					_showErrorMsg("Missing Cif No",info_msg_title,300,100);
					return;
				}
			}
			else if(code == "S")
			{	
				if($("#lookuptxt_segment_no_liveSearch_" + _pageRef).val() =="")
				{
					_showErrorMsg("Missing Segment No",info_msg_title,300,100);
					return;
				}
			}
			_showConfirmMsg(Confirm_Save_Process_key, Warning_key,
					dynamicTemplateConventionMaint_handleSaveProcess);
		}
	}
}

function dynamicTemplateConventionMaint_handleSaveProcess(confirm) {
	if (confirm) {
		var form = $("#dynamicTemplateConventionMaintFormId_" + _pageRef).serializeForm();
		var actionUrl = jQuery.contextPath	+ "/path/dynamicTemplate/dynamicTemplateConvMaintAction_saveNew.action";
		var params = {};
		_showProgressBar(true);
		
		$.ajax( {
			url : actionUrl,
			type : "post",
			dataType : "json",
			data : form,
			success : function(param) {
				if (typeof param["_error"] == "undefined"
						|| param["_error"] == null) {
					//empty form
					reloadUrl = jQuery.contextPath + "/path/dynamicTemplate/dynamicTemplateConvMaintAction_clearStpForm.action";
					var ivCrud = returnHtmlEltValue("iv_crud_"+ _pageRef);
					var reloadParams = {};
					reloadParams["iv_crud"] = ivCrud;
					reloadParams["_pageRef"] = _pageRef;
					$.post(reloadUrl,
									reloadParams,
									function(param) 
									{
										showHideSrchGrid('dynamicTemplateConventionListGridTbl_Id_'+ _pageRef);
										$("#dynamicTemplateConventionListMaintDiv_id_"+ _pageRef).html(param);
										//reload grid
										$("#dynamicTemplateConventionListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
										_showProgressBar(false);
										_showErrorMsg(record_saved_Successfully_key,info_msg_title,300,100);
									}, "html");
					
				}
				else
				{
					_showProgressBar(false);
				}
			}
		});
	}
	else
	{
		_showProgressBar(false);
	}
}

function dynamicTemplateConvMaint_onDelClicked()
{
	_showConfirmMsg(Confirm_Delete_Process_key, Warning_key,
			dynamicTemplateConvMaint_handleDeleteProcess);
}

function dynamicTemplateConvMaint_handleDeleteProcess(confirm)
{
	if (confirm)
	{
		var form = $("#dynamicTemplateConventionMaintFormId_" + _pageRef).serializeForm();
		var actionUrl = jQuery.contextPath	+ "/path/dynamicTemplate/dynamicTemplateConvMaintAction_deleteCustomerConv.action";
		var params = {};
		_showProgressBar(true);
		$.ajax( {
			url : actionUrl,
			type : "post",
			dataType : "json",
			data : form,
			success : function(param) {
				if (typeof param["_error"] == "undefined"
						|| param["_error"] == null) {
					//empty form
					reloadUrl = jQuery.contextPath + "/path/dynamicTemplate/dynamicTemplateConvMaintAction_clearStpForm.action";
					var ivCrud = returnHtmlEltValue("iv_crud_"+ _pageRef);
					var reloadParams = {};
					reloadParams["iv_crud"] = ivCrud;
					reloadParams["_pageRef"] = _pageRef;
					$.post(reloadUrl,
									reloadParams,
									function(param) 
									{
										showHideSrchGrid('dynamicTemplateConventionListGridTbl_Id_'+ _pageRef);
										$("#dynamicTemplateConventionListMaintDiv_id_"+ _pageRef).html(param);
										//reload grid
										$("#dynamicTemplateConventionListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
										_showProgressBar(false);
										_showErrorMsg(Record_was_Deleted_Successfully_key,info_msg_title,300,100);
									}, "html");
					
				}
				else
				{
					_showProgressBar(false);
				}
			}
		});
	}
	else
	{
		_showProgressBar(false);
	}
}

function dynamicTemplateConvMaint_processApprove()
{
	_showConfirmMsg(Confirm_Approve_Process_key, Warning_key,
			dynamicTemplateConvMaint_handleApproveProcess);
}

function dynamicTemplateConvMaint_handleApproveProcess(confirm)
{
	if (confirm)
	{
		var form = $("#dynamicTemplateConventionMaintFormId_" + _pageRef).serializeForm();
		var actionUrl = jQuery.contextPath	+ "/path/dynamicTemplate/dynamicTemplateConvMaintAction_ApproveCustomerConv.action";
		var params = {};
		_showProgressBar(true);
		$.ajax( {
			url : actionUrl,
			type : "post",
			dataType : "json",
			data : form,
			success : function(param) {
				if (typeof param["_error"] == "undefined"
						|| param["_error"] == null) {
					//empty form
					reloadUrl = jQuery.contextPath + "/path/dynamicTemplate/dynamicTemplateConvMaintAction_clearStpForm.action";
					var ivCrud = returnHtmlEltValue("iv_crud_"+ _pageRef);
					var reloadParams = {};
					reloadParams["iv_crud"] = ivCrud;
					reloadParams["_pageRef"] = _pageRef;
					$.post(reloadUrl,
									reloadParams,
									function(param) 
									{
										showHideSrchGrid('dynamicTemplateConventionListGridTbl_Id_'+ _pageRef);
										$("#dynamicTemplateConventionListMaintDiv_id_"+ _pageRef).html(param);
										//reload grid
										$("#dynamicTemplateConventionListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
										_showProgressBar(false);
										_showErrorMsg(record_was_Approved_Successfully_key,info_msg_title,300,100);
									}, "html");
					
				}
				else
				{
					_showProgressBar(false);
				}
			}
		});
	}
	else
	{
		_showProgressBar(false);
	}
}

function dynamicTemplateConvMaint_processReject()
{
	_showConfirmMsg(Confirm_Reject_Process_key, Warning_key,
			dynamicTemplateConvMaint_handleRejectProcess);
}

function dynamicTemplateConvMaint_handleRejectProcess(confirm)
{
	if (confirm)
	{
		var form = $("#dynamicTemplateConventionMaintFormId_" + _pageRef).serializeForm();
		var actionUrl = jQuery.contextPath	+ "/path/dynamicTemplate/dynamicTemplateConvMaintAction_RejectCustomerConv.action";
		var params = {};
		_showProgressBar(true);
		$.ajax( {
			url : actionUrl,
			type : "post",
			dataType : "json",
			data : form,
			success : function(param) {
				if (typeof param["_error"] == "undefined"
						|| param["_error"] == null) {
					//empty form
					reloadUrl = jQuery.contextPath + "/path/dynamicTemplate/dynamicTemplateConvMaintAction_clearStpForm.action";
					var ivCrud = returnHtmlEltValue("iv_crud_"+ _pageRef);
					var reloadParams = {};
					reloadParams["iv_crud"] = ivCrud;
					reloadParams["_pageRef"] = _pageRef;
					$.post(reloadUrl,
									reloadParams,
									function(param) 
									{
										showHideSrchGrid('dynamicTemplateConventionListGridTbl_Id_'+ _pageRef);
										$("#dynamicTemplateConventionListMaintDiv_id_"+ _pageRef).html(param);
										//reload grid
										$("#dynamicTemplateConventionListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
										_showProgressBar(false);
										_showErrorMsg(record_rejected_Successfully_key,info_msg_title,300,100);
									}, "html");
					
				}
				else
				{
					_showProgressBar(false);
				}
			}
		});
	}
	else
	{
		_showProgressBar(false);
	}
}

function dynamicTemplateConvMaint_processSuspend()
{
	_showConfirmMsg(Confirm_Suspend_Process_key, Warning_key,
			dynamicTemplateConvMaint_handleSuspendProcess);
}

function dynamicTemplateConvMaint_handleSuspendProcess(confirm)
{
	if (confirm)
	{
		var form = $("#dynamicTemplateConventionMaintFormId_" + _pageRef).serializeForm();
		var actionUrl = jQuery.contextPath	+ "/path/dynamicTemplate/dynamicTemplateConvMaintAction_SuspendCustomerConv.action";
		var params = {};
		_showProgressBar(true);
		$.ajax( {
			url : actionUrl,
			type : "post",
			dataType : "json",
			data : form,
			success : function(param) {
				if (typeof param["_error"] == "undefined"
						|| param["_error"] == null) {
					//empty form
					reloadUrl = jQuery.contextPath + "/path/dynamicTemplate/dynamicTemplateConvMaintAction_clearStpForm.action";
					var ivCrud = returnHtmlEltValue("iv_crud_"+ _pageRef);
					var reloadParams = {};
					reloadParams["iv_crud"] = ivCrud;
					reloadParams["_pageRef"] = _pageRef;
					$.post(reloadUrl,
									reloadParams,
									function(param) 
									{
										showHideSrchGrid('dynamicTemplateConventionListGridTbl_Id_'+ _pageRef);
										$("#dynamicTemplateConventionListMaintDiv_id_"+ _pageRef).html(param);
										//reload grid
										$("#dynamicTemplateConventionListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
										_showProgressBar(false);
										_showErrorMsg(Record_was_Suspended_Successfully_key,info_msg_title,300,100);
									}, "html");
					
				}
				else
				{
					_showProgressBar(false);
				}
			}
		});
	}
	else
	{
		_showProgressBar(false);
	}
}

function dynamicTemplateConvMaint_processReactivate()
{
	_showConfirmMsg(Confirm_Reactivate_Process_key, Warning_key,
			dynamicTemplateConvMaint_handleReactivateProcess);
}

function dynamicTemplateConvMaint_handleReactivateProcess(confirm)
{
	if (confirm)
	{
		var form = $("#dynamicTemplateConventionMaintFormId_" + _pageRef).serializeForm();
		var actionUrl = jQuery.contextPath	+ "/path/dynamicTemplate/dynamicTemplateConvMaintAction_ReactivateCustomerConv.action";
		var params = {};
		_showProgressBar(true);
		$.ajax( {
			url : actionUrl,
			type : "post",
			dataType : "json",
			data : form,
			success : function(param) {
				if (typeof param["_error"] == "undefined"
						|| param["_error"] == null) {
					//empty form
					reloadUrl = jQuery.contextPath + "/path/dynamicTemplate/dynamicTemplateConvMaintAction_clearStpForm.action";
					var ivCrud = returnHtmlEltValue("iv_crud_"+ _pageRef);
					var reloadParams = {};
					reloadParams["iv_crud"] = ivCrud;
					reloadParams["_pageRef"] = _pageRef;
					$.post(reloadUrl,
									reloadParams,
									function(param) 
									{
										showHideSrchGrid('dynamicTemplateConventionListGridTbl_Id_'+ _pageRef);
										$("#dynamicTemplateConventionListMaintDiv_id_"+ _pageRef).html(param);
										//reload grid
										$("#dynamicTemplateConventionListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
										_showProgressBar(false);
										_showErrorMsg(record_reactivated_successfully_key,info_msg_title,300,100);
									}, "html");
					
				}
				else
				{
					_showProgressBar(false);
				}
			}
		});
	}
	else
	{
		_showProgressBar(false);
	}
}

function dynamicTemplateConvention_onStatusClicked()
{
	var dtConvNo = $("#Code_"+ _pageRef).val();
	if (dtConvNo == "")
	{
		return;
	}
	
	var theParams = {};
	// TODO pass correct parameters from the Form
	//var linkCode   = $("#lookuptxt_LINK_CODE_"+_pageRef).val();
	//theParams = {linkCode:linkCode, _pageRef:_pageRef}
	var loadSrc  = jQuery.contextPath+"/path/dynamicTemplate/dynamicTemplateConvStatusAction_search.action?dtConvNo="+dtConvNo+"&_pageRef="+_pageRef;
	var theFormId = "dynamicTemplateConventionMaintFormId_"+_pageRef;
	showStatus(theFormId, _pageRef, loadSrc, theParams);
}

function onOkAccountNumber(liveSearchId)
{
   var selectedRowId = $("#gridtab_" + liveSearchId + "_" +_pageRef).jqGrid('getGridParam','selrow');
   var myObject = $("#gridtab_" + liveSearchId + "_" + _pageRef).jqGrid('getRowData',selectedRowId);
   
  $("#accBr_"+_pageRef).val(myObject["amfVO.BRANCH_CODE"]);
  $("#accCy_"+_pageRef).val(myObject["amfVO.CURRENCY_CODE"]);
  $("#accGl_"+_pageRef).val(myObject["amfVO.GL_CODE"]);
  $("#accCif_"+_pageRef).val(myObject["amfVO.CIF_SUB_NO"]);
  $("#lookuptxt_accSl_"+_pageRef).val(myObject["amfVO.SL_NO"]);
  $("#lookuptxt_accAddRef_"+_pageRef).val(myObject["amfVO.ADDITIONAL_REFERENCE"]);
}

function displaySpan(code)
{
	if(code == "A")
	{
		document.getElementById("dynTempConvAcc_" + _pageRef).style.display = "inline"
		document.getElementById("dynTempConvSegment_" + _pageRef).style.display = "none"
		document.getElementById("dynTempConvCif_" + _pageRef).style.display = "none"
			
		$("#lookuptxt_cif_no_liveSearch_" + _pageRef).val('');	
		$("#cif_no_liveSearch_Name_" + _pageRef).val('');	
		$("#lookuptxt_segment_no_liveSearch_" + _pageRef).val('');	
		$("#segment_no_liveSearch_Name_" + _pageRef).val('');	
	}
	else if(code == "C")
	{
		document.getElementById("dynTempConvAcc_" + _pageRef).style.display = "none"
		document.getElementById("dynTempConvSegment_" + _pageRef).style.display = "none"
		document.getElementById("dynTempConvCif_" + _pageRef).style.display = "inline"

		$("#accBr_" + _pageRef).val('');
		$("#accCy_" + _pageRef).val('');
		$("#accGl_" + _pageRef).val('');
		$("#accCif_" + _pageRef).val('');
		$("#lookuptxt_accSl_" + _pageRef).val('');
		$("#accName_" + _pageRef).val('');
		$("#lookuptxt_accAddRef_" + _pageRef).val('');	
		$("#lookuptxt_segment_no_liveSearch_" + _pageRef).val('');	
		$("#segment_no_liveSearch_Name_" + _pageRef).val('');
		//$("#lookuptxt_cif_no_liveSearch_" + _pageRef).val('');	
		//$("#cif_no_liveSearch_Name_" + _pageRef).val('');	
	}
	else if(code == "S")
	{
		document.getElementById("dynTempConvAcc_" + _pageRef).style.display = "none"
		document.getElementById("dynTempConvSegment_" + _pageRef).style.display = "inline"
		document.getElementById("dynTempConvCif_" + _pageRef).style.display = "none"
			
		$("#accBr_" + _pageRef).val('');
		$("#accCy_" + _pageRef).val('');
		$("#accGl_" + _pageRef).val('');
		$("#accCif_" + _pageRef).val('');
		$("#lookuptxt_accSl_" + _pageRef).val('');
		$("#accName_" + _pageRef).val('');
		$("#lookuptxt_accAddRef_" + _pageRef).val('');	
		$("#lookuptxt_cif_no_liveSearch_" + _pageRef).val('');	
		$("#cif_no_liveSearch_Name_" + _pageRef).val('');
		//$("#lookuptxt_segment_no_liveSearch_" + _pageRef).val('');	
		//$("#segment_no_liveSearch_Name_" + _pageRef).val('');
	}
	
	if (code == null || code == "" || code == undefined)
	{
		var convEntityType = $("#entity_type_"+_pageRef).val()
		
		if(convEntityType !=null && convEntityType !="" &&  convEntityType != undefined)
			{
				displaySpan(convEntityType);
			}
		
	}
	
	dynamicTemplateConvListloadDivs();
}

function dynamicTemplateConvListloadDivs()
 {
	var divToLoad;
	
	if(_pageRef.startsWith("DT00T"))
	{
		 divToLoad = "templateDiv_id_";
	}
	else
	{
		divToLoad = "dynamicTemplateConvListMaintDiv_id_";
	}
	var accBr = $("#accBr_" + _pageRef).val();
	var accCy = $("#accCy_" + _pageRef).val();
	var accGl = $("#accGl_" + _pageRef).val();
	var accCif = $("#accCif_" + _pageRef).val();
	var accSl = $("#lookuptxt_accSl_" + _pageRef).val();
	var cifNo = $("#lookuptxt_cif_no_liveSearch_" + _pageRef).val();
	var segmentNo = $("#lookuptxt_segment_no_liveSearch_" + _pageRef).val();
	var entityType = $("#entity_type_"+ _pageRef).val();
	var ivCrud = returnHtmlEltValue("iv_crud_"+ _pageRef);

	
	var url = jQuery.contextPath
			+ "/path/dynamicTemplate/dynamicTemplateMaintAction_loadTemplatePage.action";
	var params = {};
	params["_pageRef"] = _pageRef;
	params["criteria.accBr"] = accBr;
	params["criteria.accCy"] = accCy;
	params["criteria.accGl"] = accGl;
	params["criteria.accCif"] = accCif;
	params["criteria.accSl"] = accSl;
	params["criteria.cifNo"] = cifNo;
	params["criteria.segmentNo"] = segmentNo;
	params["criteria.entityType"] = entityType;//"A":account "C":CIF   "S":Segment....
	params["criteria.crudMode"] = ivCrud;
	params["iv_crud"] = ivCrud;
	
	$.post(url, params, 
			function(param)
			{
				$("#"+divToLoad + _pageRef).html(param);
			}
	, "html");	
}

function populateConventionProductsDates()
{
	var conventionStartDate  = $("#start_date_"+_pageRef).val(); 
	
	if(conventionStartDate != null && conventionStartDate != "" && conventionStartDate != undefined)
	{
		var productsChargesGridObjects =[];//list of all elements of type grid
	       
		productsChargesGridObjects = $("table[id^=accountChargesGrid_Id_"+_pageRef+"]");//get all grid ids having type table and start with accountCharges(product Charges)

		for (var i = 0, len = productsChargesGridObjects.length; i < len; i++) 
		{
				var productGrid = $("#"+productsChargesGridObjects[i].id)

				$.each(	productGrid.jqGrid('getGridParam','selarrrow') , function(index, rowId) 
						{
							productGrid.jqGrid('setCellValue',rowId,"ctsChargesParamTmpVO.SEG_START_DATE",conventionStartDate);
						})				
		}
	}
	
	
}