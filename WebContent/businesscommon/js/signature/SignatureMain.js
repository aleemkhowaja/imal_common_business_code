	
	/****
	 * Method for building the tabs for signature,document,photos,schemas etc.....
	 * @param {Object} $
	 */
	var _signCallBackObj  = null;
	var ctxPath = jQuery.contextPath;
/*	(function($) {
		signatureMain_onDocReady = function() {
			$("#signatureMainTabs_" + _pageRef).tabs({cache: true});  
			$("#signatureMainTabs_" + _pageRef).tabs().find(".ui-tabs-nav").sortable( {
				axis : "x"
			}); 
			// binding the tab select(click)event to tab header
			$("#signatureMainTabs_" + _pageRef)
					.bind("tabsselect", function(event, ui) {	
					 
			});
			
			// binding the tab show event 
			$("#signatureMainTabs_" + _pageRef)
				.bind("tabsshow", function(event, ui) {		
						tabId = ui.tab.id; // getting clicked tab ID
						tabContent = $('#' + ui.tab.id).attr('href'); // getting the href attribute from tab iD
						tabPanelId = tabContent.substr(1, tabContent.length); // getting the tab Panel ID currosponding to tab ID
			});
		};
	})(jQuery);*/
	
	(function($) {
		signatureGrid_onDocReady = function(){
			// Adding multipe header to grid column
			$("#signatureGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
			  useColSpanStyle: true, 
			  groupHeaders:[
				{startColumnName: 'actionEdit',numberOfColumns: 3, titleText: signature_action_title}
			  ]
			});
		};
	})(jQuery);
	
	function setSignAsViewed(elem,objectCode){ 		
		/*console.log(objectCode+"contains" +containsInArray(objectCode,_signObjCodeArr));
		if($(elem).is(":checked")&&!containsInArray(objectCode,_signObjCodeArr)){			
				_signObjCodeArr[_signObjCodeArr.length] =objectCode.toString();
		}
		else{
			var index = _signObjCodeArr.indexOf(objectCode.toString());
			 
			_signObjCodeArr.splice(index, 1);
		}*/
	 
		
	}
 
	/**
	 * To open a signature with param conditions only
	 * @param {Object} formId
	 * @param {Object} signatureParams
	 * @param {Object} callBack
	 */
	
	function populateSignaturePopup(formId,signatureParams,callBack) {			
		//_signCallBackObj  =  new Signature();
		signatureParams["signatureCO.viewMode"] 		= 	"A"; //open the signature page in add mode
 		//var popupButtons				=	{};
		//var popupDiv = $("<div id='signatureDialog_"+_pageRef+"'/>");
		//popupDiv.css("padding","0");		
		//popupDiv.insertAfter($("#"+formId)); 
		 var mySrc = ctxPath + "/path/signature/Signature_loadSignatureTabs";
		_showProgressBar(true);		
		 $.ajax( {
			url : mySrc,
			type : "post",			
			data : signatureParams,
			success : function(response) {			 
    			_showProgressBar(false);
				if (response["_error"] == undefined || response["_error"] == null) 
				{			 
					showSignaturePopup(formId,response,callBack);//Calling method for opening the signature popup from alert open item popu
				}	
				else{				
					_showErrorMsg(response["_error"], Warning_key);				
				 	if(callBack!=undefined)//if error occured pass an empty signature object the callback method.
	        		{	var signature = new Signature();
				 		signature.signatureError = true;
				 		callBack(signature);
				 	}
				}
			}
		});	
	
	}
	/**
	 * To be called after executing the server side onload functionalities and the returned signature html to be populated in a dialog
	 * @param {Object} formId
	 * @param {Object} html
	 * @param {Object} callBack
	 * @memberOf {TypeName} 
	 */
	function showSignaturePopup(formId,html,callBack, closeAfterCallBack){		 
		_signCallBackObj  =  new Signature();
 		var popupButtons				=	{};
		var popupDiv = $("<div id='signatureDialog_"+_pageRef+"'/>");
		popupDiv.css("padding","0");		
		popupDiv.insertAfter($("#"+formId));	
		$("#signatureDialog_" + _pageRef).html(html);
		maxHeight = 650;
		maxWidth = 925;
		var sigCap = html.indexOf("id=\"sigCapMainDiv_");
		if(sigCap>0)
		{
			maxHeight = 250;
			maxWidth = 400;
		}
		$("#"+formId).bindFormChanges("signatureDialog_"+_pageRef);
		$("#signatureDialog_"+_pageRef).dialog
		
			(
				{
					modal	:true, 
	                title	:signature_popup_title,	              
		            position:'center', 
	             	autoOpen:false,
	          		height	:returnMaxHeight(maxHeight),
				    width	:returnMaxWidth(maxWidth),
				    beforeclose: function ()
				    		{ 
								//NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
	        					if(closeAfterCallBack != undefined && closeAfterCallBack != null && closeAfterCallBack == true)
	        					{
	        						$("#signatureCancelBtn_"+ _pageRef).click();

	        						document.getElementById("STPadCapt").DeviceClose(0);
									return false;
								}	
							},
	               	close	:function ()
			                 {
								 //NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry 
			                     //var theDialog = $(this);
			                     //theDialog.remove();
			                  	 $("#signatureCancelBtn_"+ _pageRef).click(); 
			         			document.getElementById("STPadCapt").DeviceClose(0);
			                 }
				}
			);
	        popupButtons["Cancel"] 	= {text:signature_close_btn,	id:"signatureCancelBtn_"+ _pageRef,	
	        	click: function()
	        	{ 	        	
	        		//NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
	        		if(closeAfterCallBack == undefined || closeAfterCallBack == null || closeAfterCallBack == false)
	        		{
	        			$( this ).remove();	
//	        			$(this).dialog("destroy").appendTo("#"+formId);
	        		}	        
	        		if(callBack!=undefined)
	        		{
	        			callBack(_signCallBackObj);
	        		}
	        	}
	        }
			$("#signatureDialog_"+_pageRef).dialog('option', 'buttons', popupButtons);
	        
	        //Fix Issue #242606 #242600
	        if(($("#showAcceptCancelBtns_"+_pageRef).val()=="true" 
	        	&& $("#hideAcceptCancelInAlert_"+_pageRef).val()!="true"
	        		&& $("#isSignReadOnly_"+_pageRef).val()!="false") || sigCap>0)
			{
			     $("#signatureDialog_"+_pageRef).dialog( "option", "dialogClass", "no-close" );
			     $("#signatureDialog_"+_pageRef).dialog( "option", "closeOnEscape", false);
			     $("#signatureCancelBtn_"+ _pageRef).hide();
			}
	        
			$("#signatureDialog_"+_pageRef).dialog("open");
			$("#signatureDialog_"+_pageRef).parents('div.ui-dialog').show();
			if($('div.jMsgbox-mainWrap.ui-widget-content').length > 0)
			{
				var _zIndexVal = parseInt($("#signatureDialog_"+_pageRef).parents('div.ui-dialog').css("z-index")) +1;
				$('div.jMsgbox-mainWrap.ui-widget-content').css("z-index",_zIndexVal);
				$('div.jMsgbox-background').css("z-index",_zIndexVal);
			}
	 
	}
	
	
	
	/*****
	 * Method for formatting the action types (Hyperlink)
	 * @param {Object} cellValue
	 * @param {Object} options
	 * @param {Object} rowObject
	 * @return {TypeName} 
	 */
	function actionFormatter(cellValue, options, rowObject) {
 
		var hyperLinks="";
		if($('#hdDetails_' + _pageRef).val()!=""){			
			hyperLinks = '<a id=btnDetails_'+options.rowId+' class="fg-button ui-state-default  ui-corner-all fg-button-icon-left" onclick="javascript:openSignatureForm(' +"'V'"+','+options.rowId+ ');"  href="#"><span class="ui-icon ui-icon-image"/>'+$('#hdDetails_' + _pageRef).val()+'</a>'
		}
		if($("#isSignReadOnly_"+_pageRef).val()=="false"){
			if($('#hdEdit_' + _pageRef).val()!=""){
				hyperLinks = hyperLinks+'<a id=btnEdit_'+options.rowId+' class="fg-button ui-state-default  ui-corner-all fg-button-icon-left"   onclick="javascript:openSignatureForm(' +"'E'"+','+options.rowId+ ');" href="#"><span class="ui-icon ui-icon-gear"/>'+$('#hdEdit_' + _pageRef).val()+'</a>'
			}
			
		if($('#hdChangeAmount_' + _pageRef).val()!=""){
				hyperLinks = hyperLinks+'<a id=btnChangeAmt_'+options.rowId+' class="fg-button ui-state-default  ui-corner-all fg-button-icon-left"   onclick="javascript:openSignatureForm(' +"'EC'"+','+options.rowId+ ');" href="#"><span class="ui-icon ui-icon-key"/>'+ $('#hdChangeAmount_' + _pageRef).val()+'</a>'
			}
		}
		return hyperLinks;
		
		
		
	}
	
	
	function copySignActionFormatter(cellValue, options, rowObject){
		
		var hyperLink = "";
	    var accNo  = "'"+rowObject.index+"'";	   
		if(rowObject.isLeaf=="false"&&$("#hdCopyBtnVisible_"+_pageRef).val()=="true"){			
			hyperLink = '<a class="fg-button ui-state-default  ui-corner-all fg-button-icon-left" href="#"  onclick="javascript:copySignatures('+ accNo +');"><span class="ui-icon ui-icon-image"/>Copy Signatures</a>'
		}
		
		return hyperLink;
	}
	
	
	function docGridActionFormatter(cellValue, options, rowObject,secondaryId){
		var argId  = "'"+secondaryId+"'";
		var hyperLinks='';
		if($('#showDocViewLink_' + secondaryId).val()!="")
			hyperLinks='<a class="fg-button ui-state-default  ui-corner-all fg-button-icon-left"  href="#"  onclick="javascript:openDocumentForm(' +"'V'"+','+argId+','+options.rowId+ ');"><span class="ui-icon ui-icon-image"/>'+$('#showDocViewLink_' + secondaryId).val()+'</a>';
		if($('#showDocEditLink_' + secondaryId).val()!=""&&$("#isSignReadOnly_"+_pageRef).val()=="false")
			hyperLinks = hyperLinks + '<a class="fg-button ui-state-default  ui-corner-all fg-button-icon-left"  href="#" onclick="javascript:openDocumentForm(' +"'E'"+','+argId+','+options.rowId+ ');"><span class="ui-icon ui-icon-gear"/>'+$('#showDocEditLink_' + secondaryId).val()+'</a>';
		
		return hyperLinks;
	}
	
	function onChangeUsed(e){
		$t = $("#signatureGridTbl_Id_"+_pageRef);
		var selRowId = $($t).jqGrid("getGridParam","selrow");
		//$("#"+e.target.id).is(':checked') is changed to $(this).is(':checked') for IE8 compatibility
		if( $(this).is(':checked') == true)
		{
			$t.jqGrid('setCellValue', selRowId, 'used',"","true");
		}
		else
		{
			$t.jqGrid('setCellValue', selRowId, 'used',"","false");
		}
	}
	
	/**
 * Unlimited Checkbox onchange event
 */

	function expiryUnlimitedCheckBoxOnChange() {
		if($("#expiryUnlimited_" + _pageRef).is(":checked"))
		{			
			disableDatepicker("expirySignDate_" + _pageRef, true);
			$($("#expirySignDate_" + _pageRef)).datepicker('setDate', null);		
		}
		else
		{
			disableDatepicker("expirySignDate_" + _pageRef, false);
			$("#expirySignDate_" + _pageRef).removeAttr('readonly');
			$("#expirySignDate_" + _pageRef).removeAttr('disabled');
		}
	//	openSignatureForm("EC");
	
	}

	/**
	 * Open the signature form in a mode specified as param
	 */
	function openSignatureForm(viewMode,rowId) {
		var action 												= 	jQuery.contextPath+ "/path/signature/Signature_loadSignatureForm";
		var signatureParams										= 	{};
		signatureParams["_pageRef"] 							= 	_pageRef;
		signatureParams["signatureCO.viewMode"] 				= 	viewMode;			
		signatureParams["signatureSC.signatureTp"] 				= 	$("#signatureTp_"+_pageRef).val();
		signatureParams["signatureSC.branchCode"] 				= 	$("#signatureBranchCode_"+_pageRef).val();
		signatureParams["signatureSC.readOnly"] 				= 	$("#isSignReadOnly_"+_pageRef).val();	
		signatureParams["signatureSC.isAsaanAcc"]   			=  $("#is_Asaan_Acc_" + _pageRef).val();
		//NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
		signatureParams["signatureSC.expiryDateRequired"] 		= 	$("#expiryDateRequired_"+_pageRef).val();	
		//signatureParams["signatureSC.showApproveBtn"]			= 	$("#showApproveBtn_"+_pageRef).val();
		//signatureParams["signatureSC.showRejectBtn"]			= 	$("#showRejectBtn_"+_pageRef).val();		
		signatureParams["signatureSC.currencyCode"] 			= 	$("#_signCYCode_"+_pageRef).val();
		signatureParams["signatureSC.cifType"] 					= 	$("#_signCifType_"+_pageRef).val();
		if(rowId){//rowid undefined
			var $grid 												= 	$("#signatureGridTbl_Id_" + _pageRef);
			var selectedSignatureObj 								= 	$grid.jqGrid('getRowData', rowId);		
			signatureParams["signatureCO.cifObjectVO.ACC_CY"] 		= 	selectedSignatureObj["cifObjectVO.ACC_CY"];
			signatureParams["signatureCO.cifObjectVO.ACC_GL"] 		= 	selectedSignatureObj["cifObjectVO.ACC_GL"];
			signatureParams["signatureCO.cifObjectVO.ACC_SL"] 		= 	selectedSignatureObj["cifObjectVO.ACC_SL"];
			signatureParams["signatureCO.cifObjectVO.ACC_CIF"] 		= 	selectedSignatureObj["cifObjectVO.ACC_CIF"];			
			signatureParams["signatureCO.signatureTp"] 				= 	$("#signatureTp_"+_pageRef).val();						
			signatureParams["signatureCO.cifObjectVO.OBJECT_CODE"] 	= 	selectedSignatureObj["cifObjectVO.OBJECT_CODE"];
			signatureParams["signatureCO.cifObjectVO.OBJECT_SEQ"] 	= 	selectedSignatureObj["cifObjectVO.OBJECT_SEQ"];
			signatureParams["signatureCO.origin"] 					= 	selectedSignatureObj["origin"];
			signatureParams["signatureCO.originObjectCode"] 		= 	selectedSignatureObj["originObjectCode"];
			//signatureParams["signatureSC.signatureTp"] 				= 	$("#signatureTp_"+_pageRef).val();
			signatureParams["signatureSC.cifNo"] 					= 	selectedSignatureObj["cifObjectVO.ACC_CIF"];
		   // signatureParams["signatureSC.branchCode"] 				= 	$("#signatureBranchCode_"+_pageRef).val();
			//Added by Jose Afonso tp#272281 2015/02/17 
			signatureParams["signatureSC.branchCode"] 				= 	selectedSignatureObj["cifObjectVO.BRANCH_CODE"];
			signatureParams["signatureSC.trxType"] 					= 	$("#signTrxType_"+_pageRef).val();
		}
		else//The case when the user click on Add button (new Event)
		{
			signatureParams["signatureSC.cifNo"]  = $("#_signCIFCode_"+_pageRef).val();
			signatureParams["signatureSC.signCIFDesc"]  = $("#_signCIFDesc_"+_pageRef).val();
			signatureParams["signatureSC.screenName"]  = $("#_signScreenName_"+_pageRef).val();
		}
		
	/*	if(viewMode=='V'&&!containsInArray(selectedSignatureObj["cifObjectVO.OBJECT_CODE"],_signObjCodeArr)){	
				_signObjCodeArr[_signObjCodeArr.length] =(selectedSignatureObj["originObjectCode"]!="")?selectedSignatureObj["originObjectCode"]:selectedSignatureObj["cifObjectVO.OBJECT_CODE"];check whether sign modif data is displayed if so get the original code of cifobject. 			}*/
		$("#signatureFormDiv_" + _pageRef).load(action,signatureParams,	function() {			
				if(viewMode=="V"){
					_signCallBackObj.signatureViewed=true;
					 $grid.jqGrid('setCellValue', rowId, 'signViewed',   true);
					}
				
			}
		);
	}
	
	
	function containsInArray(value, arr){
		    var ret=false;
		    $.each(arr, function(index, elem) {		    	
		        if (elem== value) ret=true;
		    }); 
		    
		    return ret;
	};
	
	function openDocumentForm(viewMode,secondaryId,rowId){
	
		
		var action 												= 	jQuery.contextPath+ "/path/signature/Signature_loadDocumentForm";
		var signatureParams										= 	{};
		signatureParams["_pageRef"] 							= 	_pageRef;
		signatureParams["signatureCO.viewMode"] 				= 	viewMode;
		signatureParams["signatureCO.scanVO.DOC_TYPE"] 			= 	$("#docType_"+secondaryId).val();
		
		
		if(rowId){//rowid undefined
			var $grid 												= 	$("#documentGridTbl_Id_" + secondaryId);
			var selectedSignatureObj 								= 	$grid.jqGrid('getRowData', rowId);
			signatureParams["signatureCO.cifObjectVO.ACC_CY"] 		= 	selectedSignatureObj["cifObjectVO.ACC_CY"];
			signatureParams["signatureCO.cifObjectVO.ACC_GL"] 		= 	selectedSignatureObj["cifObjectVO.ACC_GL"];
			signatureParams["signatureCO.cifObjectVO.ACC_SL"] 		= 	selectedSignatureObj["cifObjectVO.ACC_SL"];
			signatureParams["signatureCO.cifObjectVO.ACC_CIF"] 		= 	selectedSignatureObj["cifObjectVO.ACC_CIF"];			
			signatureParams["signatureCO.signatureTp"] 				= 	$("#signatureTp_"+_pageRef).val();						
			signatureParams["signatureCO.cifObjectVO.OBJECT_CODE"] 	= 	selectedSignatureObj["cifObjectVO.OBJECT_CODE"];
			signatureParams["signatureCO.cifObjectVO.OBJECT_SEQ"] 	= 	selectedSignatureObj["cifObjectVO.OBJECT_SEQ"];
			signatureParams["signatureSC.branchCode"] 				= 	$("#signatureBranchCode_"+_pageRef).val();
			
			
	 
			
		 
		}
		
		$("#documentFormDiv_" + secondaryId).load(
			action,
			signatureParams, 
			function() {
			}
		);
		
		 
		
	}
	
	function getSelectedSignatureList(status){
		var signList =  {};
		var selectedSignature = null;
		var selectedRows = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow');
		if(selectedRows.length > 0)
		{
			signList = {"_pageRef":_pageRef};
			if($("#cifVO_STATUS_"+ _pageRef).length != 0)
			{
				signList["signatureCO.screenName"] 			=	"FOM";
				signList["signatureCO.updateDate"] 			=	$("#cifVO_DATE_UPDATED_"+ _pageRef).val();
				signList["signatureCO.cifStatus"]  			=	$("#cifVO_STATUS_"+ _pageRef).val();
				signList["signatureCO.cifObjectVO.CIF_NO"] 	= 	$("#cifVO_CIF_NO_"+ _pageRef).val();
			}
			
		    $.each(	selectedRows, function(index, rowId) {		    	
				selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)		
					signList["signatureCOList["+index+"].cifObjectVO.ACC_CY"] 		= 	selectedSignature["cifObjectVO.ACC_CY"];
					signList["signatureCOList["+index+"].cifObjectVO.ACC_GL"] 		= 	selectedSignature["cifObjectVO.ACC_GL"];
					signList["signatureCOList["+index+"].cifObjectVO.ACC_SL"] 		= 	selectedSignature["cifObjectVO.ACC_SL"];
					signList["signatureCOList["+index+"].cifObjectVO.ACC_CIF"] 		= 	selectedSignature["cifObjectVO.ACC_CIF"];
					signList["signatureCOList["+index+"].cifObjectVO.CIF_NO"] 		= 	selectedSignature["cifObjectVO.ACC_CIF"];
					signList["signatureCOList["+index+"].cifObjectVO.OBJECT_CODE"] 	= 	selectedSignature["cifObjectVO.OBJECT_CODE"];
					signList["signatureCOList["+index+"].cifObjectVO.OBJECT_SEQ"] 	= 	selectedSignature["cifObjectVO.OBJECT_SEQ"];
					signList["signatureCOList["+index+"].cifObjectVO.STATUS"] 		= 	selectedSignature["cifObjectVO.STATUS"];
					signList["signatureCOList["+index+"].cifObjectVO.TO_BE_STATUS"]	= 	selectedSignature["cifObjectVO.TO_BE_STATUS"];
					signList["signatureCOList["+index+"].cifObjectVO.BRANCH_CODE"]	= 	selectedSignature["cifObjectVO.BRANCH_CODE"];
					signList["signatureCOList["+index+"].cifObjectVO.COMP_CODE"]	= 	selectedSignature["cifObjectVO.COMP_CODE"];
					signList["signatureCOList["+index+"].origin"] 					= 	selectedSignature["origin"];
					signList["signatureCOList["+index+"].signatureTp"] 				= 	$("#signatureTp_"+_pageRef).val();
					signList["signatureCOList["+index+"].autoApprove"] 				= 	$("#signatureAutoApprove_"+_pageRef).val();
		 
			}); 
		}

	    return signList;
	}
	
	function onDeleteSignatures(){
		//TONY NOUH 21/11/2014 Bug 243343 invalid error when deleting signature - GA miantenance screen
//		var flag =  false;
//		$.each(	$("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow'), function(index, rowId) {		    	
//			selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)		
//			if(selectedSignature["cifObjectVO.STATUS"]=="P"){
//				_showErrorMsg("Approved signatures cannot be deleted");
//				flag =  true;
//				return;				
//				}
//		}); 
//		if(flag)
//			return;
	    var signDelList =  getSelectedSignatureList();
	    if($.isEmptyObject(signDelList)){
	    	_showErrorMsg(msg_noRecordSelectedLabel, cannot_proceed_title);
	    	return;
	    }
	    
		   //EWBI160037 -- [John Massaad]
		   var flag=false;
			$.each(	$("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow'), function(index, rowId) {		    	
				selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)		
				if(selectedSignature["cifObjectVO.STATUS"]=="D"){
					_showErrorMsg(already_deleted_records_are_selected_key, cannot_proceed_title);
					flag =  true;	
					return;
					}
			}); 
			if(flag)
				return;
			//EWBI160037 -- [John Massaad]
			
	    _showConfirmMsg(Confirm_Delete_Process_key, Warning_key,onConfirmDeleteSignatures, {data : signDelList});
	
			
		
		
		 
		
	}
	
	function onConfirmDeleteSignatures(confirm, args){
		if(confirm){
			 $.ajax({
			 url: $.contextPath+"/path/signature/Signature_deleteSignatures",
	         type:"post",		 
			 data: args.data,
			 dataType:"json",
			 success: function(data){			
			 	if(typeof data["_error"] == "undefined" || data["_error"] == null) {
			 		_signCallBackObj.signatureDeleted =  true;
			 		$( args.data ).each(function( index ) {
			 			_signCallBackObj.actionsPerformed.put(args.data["signatureCOList["+index+"].cifObjectVO.OBJECT_CODE"],"D");
 						
					});			 	 
					$("#signatureGridTbl_Id_" + _pageRef).trigger("reloadGrid");
					openSignatureForm("A");	
					if(typeof changeCIFValues != "undefined" && changeCIFValues != null )
					{
				    	changeCIFValues(data["signatureCO"].cifVO.STATUS,data["signatureCO"].latestupdateDate)
					}
					
					if ($("#fomMaintForm_" + _pageRef).html().length > 0) {
						//in case we are saving only from FOM
						setCompCodeCif(data["signatureCO"]["compCodeCif"]);
					}
					
					_showErrorMsg(record_was_Deleted_Successfully_key,success_msg_title);
			 	
			 	} 
			 }
	    }); 
	 }
	}
	
	
function onApproveSignatures()
{
	var flag=false;
	$.each(	$("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow'), function(index, rowId) {		    	
		selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)		
		if(selectedSignature["cifObjectVO.STATUS"]=="P"){
			_showErrorMsg(already_approved_records_are_selected_key, cannot_proceed_title);
			flag =  true;	
			return;
			}
		//EWBI160037 -- [John Massaad]
		if(selectedSignature["cifObjectVO.STATUS"]=="D" ){
			_showErrorMsg(already_deleted_records_are_selected_key, cannot_proceed_title);
			flag =  true;	
			return;
			}
	   //EWBI160037 -- [John Massaad]
	}); 
	if(flag)
		return;
		 
	var signApproveList  = getSelectedSignatureList();		 
	 if($.isEmptyObject(signApproveList)){
    	_showErrorMsg(msg_noRecordSelectedLabel, cannot_proceed_title);
    	return;
    }
	 
	$.ajax({
		 url: $.contextPath+"/path/signature/Signature_approveSignatures",
         type:"post",		 
		 data: signApproveList,
		 dataType:"json",
		 success: function(data){			
		 	if(typeof data["_error"] == "undefined" || data["_error"] == null) {
		 		_signCallBackObj.signatureApproved =  true;
		 		$(signApproveList).each(function( index ) {			 			
		 			_signCallBackObj.actionsPerformed.put(signApproveList["signatureCOList["+index+"].cifObjectVO.OBJECT_CODE"],"A");
 						
					});	
					$("#signatureGridTbl_Id_" + _pageRef).trigger("reloadGrid");
				openSignatureForm("A");	
				if(typeof changeCIFValues != "undefined" && changeCIFValues != null )
				{
			    	changeCIFValues(data["signatureCO"].cifVO.STATUS,data["signatureCO"].latestupdateDate)
				}
		 		_showErrorMsg(record_was_Approved_Successfully_key,success_msg_title);
		 	} 
		 }
    }); 
}
	
	
	
	
	
	function onRejectSignatures(){
		var signMode   = $("#signMode_"+_pageRef).val();
		var flag  = false;
		if(signMode==0){
			$.each(	$("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow'), function(index, rowId) {		    	
			selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)		
			if(selectedSignature["cifObjectVO.TO_BE_STATUS"]!="D"){
				_showErrorMsg(deleted_record_can_be_rejected_key, cannot_proceed_title); //Hala - ARIBI180055 
				flag =  true;	
				return;
				}
			});			
		}
		else{
			$.each(	$("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow'), function(index, rowId) {		    	
			selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)		
			if(selectedSignature["cifObjectVO.STATUS"]=="P"){
				_showErrorMsg(approved_record_cannot_be_rejected_key, cannot_proceed_title); //Hala - ARIBI180055 
				flag =  true;	
				return;
				}
			});		
		}
		if(flag)
			return;
		 var signRejectList =  getSelectedSignatureList();
		   if($.isEmptyObject(signRejectList)){
	    	_showErrorMsg(msg_noRecordSelectedLabel, cannot_proceed_title);
	    	return;
	    }
		 $.ajax({
			 url: $.contextPath+"/path/signature/Signature_rejectSignatures",
	         type:"post",		 
			 data: signRejectList,
			 dataType:"json",
			 success: function(data){			
			 	if(typeof data["_error"] == "undefined" || data["_error"] == null) {
			 		_signCallBackObj.signatureRejected =  true;
			 		$(signRejectList).each(function( index ) {
			 			_signCallBackObj.actionsPerformed.put(signRejectList["signatureCOList["+index+"].cifObjectVO.OBJECT_CODE"],"R");
 						
					});	
					$("#signatureGridTbl_Id_" + _pageRef).trigger("reloadGrid");
					openSignatureForm("A");	
					if(typeof changeCIFValues != "undefined" && changeCIFValues != null )
					{
				    	changeCIFValues(data["signatureCO"].cifVO.STATUS,data["signatureCO"].latestupdateDate)
					}
			 		_showErrorMsg(record_rejected_Successfully_key,success_msg_title);
			 	} 
			 }
	    }); 
			
		
	}
	
	
	function onAcceptSignatures(){
		var selectedRows = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow');
		
		if(selectedRows.length==0){
			_showErrorMsg(msg_noRecordSelectedLabel, cannot_proceed_title);
			return ;
		}
		
		var closeDialogue = false;
		
		var signNotView = false;
		
		//sign note mandatory
		//EWBI160037 -- [John Massaad] adding || _signCallBackObj.allSignatureViewed == true condition (in case viewAllSignatures)  
		if($("#signNoteMandatory_"+_pageRef).val()=="1" || ( $("#signViewMandatory_"+_pageRef).val()=="1" && (_signCallBackObj.allSignatureViewed == false || _signCallBackObj.allSignatureViewed == true))){
			//EWBI160037 -- [John Massaad]
			var arr = new Array();
			var objectCode;
			var str="";
			var changed = "1";
			$.each(selectedRows, function(index, rowId) {	
				
				selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)		
				
				//EWBI160037 -- [John Massaad] -- _signCallBackObj.allSignatureViewed == false  condition
				if(_signCallBackObj.allSignatureViewed == false &&(selectedSignature["signViewed"] == false || selectedSignature["signViewed"] == 'false') ){//sign not viewed
					//_showErrorMsg("Selected signature at row " + rowId + " has not been viewed");
					_showErrorMsg($("#viewSelectedSignMessage_"+_pageRef).val(), cannot_proceed_title);
					signNotView = true;
					return false;
				}

				var signatureStatus = selectedSignature["cifObjectVO.STATUS"];
				if("D" == signatureStatus)
				{
					_showErrorMsg(deleted_singatures_cannot_be_accepted_key, cannot_proceed_title);
					closeDialogue = true;
					return false;
				}
				
				//EWBI160037 -- [John Massaad] -- filling the selected signatures OBJECT_CODE in actionsPerformed
				var signExpiryDate = selectedSignature["scanVO.EXP_DATE"];
				var lineNo = selectedSignature["lineNo"];
				var defaultUnlimitedExpDate = selectedSignature["scanVO.DEFAULT_UNLIMITED"];
				var objectCode = selectedSignature["cifObjectVO.OBJECT_CODE"];
				
				arr.push("{\"cifObjectVO.OBJECT_CODE\": \""	 + objectCode +"\""+","+
					"\"scanVO.EXP_DATE\": \""	 + signExpiryDate +"\""+","+
					"\"lineNo\": \"" + lineNo +"\""+","+
					"\"scanVO.DEFAULT_UNLIMITED\": \"" + defaultUnlimitedExpDate +"\""+","+
					"\"CHANGED\": \""+ changed +"\"}" );
							
				str = "{\"root\":[" + arr.join(",") + "]}";
				
				if($("#selectedSignaturesGridUpdates_"+_pageRef) != undefined && $("#selectedSignaturesGridUpdates_"+_pageRef) != "undefined")
				{
					$("#selectedSignaturesGridUpdates_"+_pageRef).val(str);
				}
//				_signCallBackObj.actionsPerformed.put(selectedSignature["cifObjectVO.OBJECT_CODE"],"C");
				
				//EWBI160037 -- [John Massaad]
			}); 
			
			
			//In case no exception was raised (signature not viewed or singature status deleted)
			if(str !="")
			{
				var checkedSignaturesGridUpdates = str;
				var screenName = $("#_signScreenName_"+_pageRef).val();
				var validationDate = $("#validationDate_"+_pageRef).val();
				var params = {"signatureCO.checkedSignaturesGridUpdates":checkedSignaturesGridUpdates,
					          "signatureCO.screenName":screenName,
					          "signatureCO.validationDate":validationDate};
									
				$.ajax( {
						url : jQuery.contextPath + "/path/signature/Signature_validateCheckedSignatures",
						type : "post",
						dataType : "json",
						data : params,
						success : function(data)
						         {
									_showProgressBar(false);
									if (data["_error"] == null) 
									{
										if( ($("#signViewMandatory_"+_pageRef).val()=="1"  && _signCallBackObj.allSignatureViewed == false && signNotView == true) || closeDialogue == true)
										{
											return;
										}
			
										calculateSignAmt(selectedRows);
										_signCallBackObj.signatureAccepted = true;  
										//Rakan Makarem - BTII170148 
										_signCallBackObj.signatureCancelled = false;
										 $("#signatureCancelBtn_"+ _pageRef). trigger('click');
										//  $("#signatureDialog_"+_pageRef).remove();
										
							    	}
								}
						});
				
			}
	
			
		}
		

	}	
		
	function getCheckedSignSum(){
	        var sum =  0;
	        var gridSelectedArray = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow');
	        if(gridSelectedArray != undefined && gridSelectedArray != null)
	        {
	        	$.each(gridSelectedArray, function(index, rowId) {		    	
						selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)
						sum  =  sum+parseFloat(selectedSignature["cifObjectVO.AMOUNT"])				 
					 
				});
			}
			return sum;
		
	}	
	
	
	function calculateSignAmt(selectedRows){
		
		//schema checking done in action based on cif or acc
		var isLimitSchemaAvailable =$("#enforceSign_"+_pageRef).val()=="1";		
		if(isLimitSchemaAvailable){//schema available								
			var groupIdCombination = "";			
			$.each(selectedRows, function(index, rowId) {		    	
					selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)
					groupIdCombination = groupIdCombination+selectedSignature["cifObjectVO.GROUP_ID"];		
				 
			});				
			
			if(selectedRows.length>10){
					_signCallBackObj.signAmount = getCheckedSignSum();//$("#signatureGridTbl_Id_" + _pageRef).jqGrid('getCol', 'cifObjectVO.AMOUNT', false, 'sum');			
			}
			else{
				 
				var limitSchemaVO = null;
				var signParam = getLimitSchemaSignParam();
				signParam["signatureSC.groupIds"] = groupIdCombination;
				//if limitAmt is null then no combination for the groupId was found
			   $.ajax({
				url: $.contextPath+"/path/signature/Signature_returnLimitAmtForGroupCombination",
	         	type:"post",		 
			 	data: signParam,
			 	dataType:"json",
			 	success: function(data){			 		 
				   if(data["_error"] == null){
 						 limitSchemaVO = data.limitSchemaVO;					 
 						 if(limitSchemaVO==undefined)//no limit found 	
							_signCallBackObj.signAmount = getCheckedSignSum();//$("#signatureGridTbl_Id_" + _pageRef).jqGrid('getCol', 'cifObjectVO.AMOUNT', false, 'sum');
						else if(limitSchemaVO.LIMIT_AMT==0)
							_signCallBackObj.signAmount = 99999999999.99
						else
							_signCallBackObj.signAmount = limitSchemaVO.LIMIT_AMT	
							
							//_signCallBackObj.signatureAccepted = true;								 
							//_signCallBackObj.signatureGrpId = groupId; 						   
 					 }
 					 else{
 						 return;//error occured 				
 						}
				  $("#signatureGridTbl_Id_" + _pageRef).jqGrid('footerData','set', {'': '', 'cifObjectVO.AMOUNT': $.formatNumberNumeric(_signCallBackObj.signAmount, {format: returnNbFormat(3),applyRounding:true})},false);
	    		 
				   
				   
			 }
	   	 });	 			 
	 	}										
	}
			else{//no schema		
				_signCallBackObj.signAmount =getCheckedSignSum(); //$("#signatureGridTbl_Id_" + _pageRef).jqGrid('getCol', 'cifObjectVO.AMOUNT', false, 'sum');
				$("#signatureGridTbl_Id_" + _pageRef).jqGrid('footerData', 'set', {"cifObjectVO.AMOUNT" :	$.formatNumberNumeric(_signCallBackObj.signAmount, {format: returnNbFormat(3),applyRounding:true}) }, false);
				//_signCallBackObj.signatureAccepted = true;
				//_signCallBackObj.signatureGrpId = groupId;
				
			}	
		
		
		
	}
 
	
	function onCancelSignatures(){
		var selectedRows = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow');		
		var closeDialogue = false;
		//EWBI160037 -- [John Massaad]
		$.each(selectedRows, function(index, rowId) {
			selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId);
				var signatureStatus = selectedSignature["cifObjectVO.STATUS"];
				
				if("D" == signatureStatus)
				{
					_showErrorMsg(deleted_singatures_cannot_be_rejected_key, cannot_proceed_title);
					closeDialogue = true;
					return false;
				}
		});
		//EWBI160037 -- [John Massaad]
		
		if(closeDialogue == true)
		{
			return;
				
		}
		
		if(selectedRows.length==0){
			_signCallBackObj.signAmount = 0;
		}
		else{
			_signCallBackObj.signAmount = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getCol', 'cifObjectVO.AMOUNT', false, 'sum');
		}
		_signCallBackObj.signatureCancelled = true;
		//Rakan Makarem - BTII170148 
		_signCallBackObj.signatureAccepted = false; 
		 $("#signatureCancelBtn_"+ _pageRef). trigger('click');
		//$("#signatureDialog_"+_pageRef).remove();
	}
	
	function openSignatureImageBox(progRef) {
		$(document).ready(
			function() {
	    		$.__overlaybox( {
					height : 600,
					href : jQuery.contextPath
							+ "/path/signature/Signature_loadSignatureImageScreen"
				});
		});
		
	
	}
	
	
	function openViewAllSignPopup(){
	 
		var popupButtons				=	{};
		var popupDiv = $("<div id='signViewAllDialog_"+_pageRef+"'/>");
		popupDiv.css("padding","0");
		var form = $("#signatureFormDiv_"+ _pageRef);	 
		 
		var signatureParams	=		getSignatureParams();
		signatureParams["_pageRef"] 	= 	_pageRef;
		
	    var mySrc = "";
		if($("#signatureTp_"+_pageRef).val()=="C")
			mySrc = ctxPath + "/path/signature/Signature_viewAllSignaturesForCIF";
		else
			mySrc = ctxPath + "/path/signature/Signature_viewAllSignaturesForAcc";
		
		 $.ajax({
			 url: mySrc,
	         type:"post",		 
			 data: signatureParams,		 
			 success: function(response){			
			 	if(typeof response["_error"] == "undefined" || response["_error"] == null) {		 	
					 if($(response).find("input#isViewAllSignListEmpty_"+_pageRef).val()!="true"){						 
						 popupDiv.insertAfter(form);
						 popupDiv.html(response);
						$("#signViewAllDialog_"+_pageRef).dialog
						(
							{
								modal	:true, 
				                title	:signature_popup_title,	               
					            position:'center', 
				             	autoOpen:false,
				          		height	:returnMaxHeight(550),
							    width	:returnMaxWidth(900),
				               	close	:function ()
						                 {
						                     var theDialog = $(this);
						                     theDialog.remove();
						                 }
							}
						);
				        popupButtons["Cancel"] 	= {text:signature_close_btn,	id:"signatureCancelBtn_"+ _pageRef,	click: function(){$( this ).remove();}}
				        popupButtons["Ok"] 	= {text:"OK",	id:"signatureOkBtn_"+ _pageRef,	click: function(){onOkViewAllSignatures();}}
						$("#signViewAllDialog_"+_pageRef).dialog('option', 'buttons', popupButtons);
						$("#signViewAllDialog_"+_pageRef).dialog("open");
						_signCallBackObj.signatureViewed=true;
						_signCallBackObj.allSignatureViewed=true;
					 }
					 else{
						 _showErrorMsg(no_appr_sign_msg)
					 }	
			 		
			 	
			 	} 
			 	
			 }
	    }); 
		
		

		
		
		}
	
	function onOkViewAllSignatures()
	{
		$('#signViewAllDialog_'+_pageRef).remove();
		var _gridId = $("#signatureGridTbl_Id_" + _pageRef);
		var rows = _gridId.jqGrid('getDataIDs');
		for ( var i = 1; i <= rows.length; i++) {
			_gridId.jqGrid('setSelection',i);
		}
		$("#cb_signatureGridTbl_Id_" + _pageRef).attr("checked",true);
		onSignatureCheckBoxSelect();
	}
	
	function initializeSignScrollable(){
		
		$("#sign_scrollable_"+_pageRef).scrollable();	 
		$("#sign_items_"+_pageRef+" img").click(function() {			
			if ($(this).hasClass("active")) { return; }	 
			var url = $(this).attr("alt");		  	 
			var img = new Image(); 
			img.onload = function() {			
				$("#sign_viewer_"+_pageRef).find("img").attr("src", url);		 
			};	
			img.src = url; 
			$("#sign_items_"+_pageRef+" img").removeClass("active");	 
			 
			$(this).addClass("active");	
		    $("#sign_viewer_"+_pageRef).iviewer({src:url}); 		 
		
		}).filter(":first").click(); 
		
	 
		
		
		
		
		
	}
	
	function returnCaptSign(){
		try{
		if($("#signOption_"+_pageRef).val()=='C')
		{
			//document.getElementById("SigPlus1").TabletState = 0; //Turns tablet off
			//document.getElementById("SigPlus1").SigCompressionMode = 2;//Compresses the signature at a 2.5 to 1 ratio, making it smaller...to display the signature again later, you WILL HAVE TO set the SigCompressionMode of the new SigPlus object = 1
			if(!document.getElementById("STPadCapt").SignatureConfirm()< 0)
				{
				return false; 
				}
			$("#signCaptStr_"+_pageRef).val(document.getElementById("STPadCapt").SignatureSaveAsStreamEx(300, 0, 0, 203, 0, 0, 0));//The signature is now taken, and you may access it using the SigString property of SigPlus. This SigString is the actual signature, in ASCII format. You may pass this string value like you would any other String. To display the signature again, you simply pass this String back to the SigString property of SigPlus (BE SURE TO SET SigCompressionMode=1 PRIOR TO REASSIGNING THE SigString)
		/*	if((document.getElementById("SigPlus1").SigString.toString()).length < 100)
				{
				_showErrorMsg(sign_signature_msg);
				return false;
				}*/
		}
		else
		{
			return false;
		}
		}
		catch(e)
		{
			_showErrorMsg(AX_ERROR_KEY,error_msg_title);
		}
			return true;
		}
	
function  saveSignature()
{
	if($("#signFormId_"+_pageRef).hasChanges(true))
	{
		if(!validateSignature())
		{
		return;
		}
		else
		{
		parseNumbers();
		
		var data = $("#signFormId_"+_pageRef).serializeForm()+"&"+$.param(getSignatureParams());	//appending CIF/ACC info to data 
 		$.ajax({
			url : jQuery.contextPath + "/path/signature/Signature_saveSignature",
			type : "post",
			dataType : "json",
			data:data,
			beforeSend:_showProgressBar(true),	
			success : function(data) {
	 			_showProgressBar(false);	
				if (typeof data["_error"] == "undefined"|| data["_error"] == null)
				{		
					 if(data.signatureCO.viewMode=="A"){
						 _signCallBackObj.signatureAdded=true;
						 _signCallBackObj.actionsPerformed.put((data.signatureCO.cifObjectVO.OBJECT_CODE).toString(),"A")
					 }
				     else if(data.signatureCO.viewMode=="EC"){//change amount
				     	_signCallBackObj.actionsPerformed.put((data.signatureCO.cifObjectVO.OBJECT_CODE).toString(),"M")
				     }
					 else if(data.signatureCO.viewMode=="E"){
						_signCallBackObj.actionsPerformed.put((data.signatureCO.cifObjectVO.OBJECT_CODE).toString(),"U") 
					 }
				     openSignatureForm("A");			 
				    $("#signatureGridTbl_Id_"+_pageRef).trigger("reloadGrid");
				    if(typeof changeCIFValues != "undefined" && changeCIFValues != null )
					{
				    	changeCIFValues(data["signatureCO"].cifVO.STATUS,data["signatureCO"].latestupdateDate)
					}
				    
//					if ($("#fomMaintForm_" + _pageRef).val() != "") {
					if ($("#fomMaintForm_" + _pageRef).html().length > 0) {
						//in case we are saving only from FOM
						setCompCodeCif(data["signatureCO"]["compCodeCif"]);
					}
				    _showErrorMsg(record_saved_Successfully_key,success_msg_title)
			 
					}
				}
			});	 
		}
		
	}
}
	
	
	function captureSignature(){
		$("#signOption_"+_pageRef).val('C');
		$("#edit_sign_viewer_"+_pageRef).hide();	
		$("#signPadViewer_"+_pageRef).show();		
		try
		{
		//	document.getElementById("SigPlus1").TabletState = 1;//Turns tablet on
			
			// try to open first pad
			var nReturn = document.getElementById("STPadCapt").DeviceOpen(0);
			if((nReturn < 0) && (nReturn != -6))
			{
			_showErrorMsg("Could not open device because of error " + nReturn);
			return;
			}
						
			// start capturing
			nReturn =document.getElementById("STPadCapt").SignatureStart(); 
			if (nReturn < 0)
			{   // error
			_showErrorMsg("Could not start capture process because of error " + nReturn);
			document.getElementById("STPadCapt").DeviceClose(0);
			return;
			}

		}
		catch(e)
		{
			_showErrorMsg(AX_ERROR_KEY,error_msg_title);
		}
		clearSignImgAttr();	
	}
	
	function clearSignImgAttr(){
		$("#signFileType_"+_pageRef).val("");
	    $("#signImportFile_temp_"+_pageRef).val("");
	    var img  = $("#edit_sign_viewer_"+_pageRef+" img");
	    $(img).attr('src',"");
	    $(img).attr('style',"left: 0px; top: 0px; position: absolute; -ms-transform: rotate(0deg);");   
	    $("#importFileContainer_"+_pageRef).html("<input  type=\"file\"  name=\"fileUpload\" id=\"signImportFile_"+_pageRef+"\"   />"); 
	    
		
	}
	
	function scanSignature(){
		$("#signOption_"+_pageRef).val('S');
		$("#edit_sign_viewer_"+_pageRef).show();
		$("#signPadViewer_"+_pageRef).hide();
		clearSignImgAttr();		
		$("#edit_sign_viewer_"+_pageRef).attr("imgName", scanToServer('scan__1', 'EN'));
	}
	
		
	/**
	 * Bug # 340581 -- John Massaad -- Adding "View Signature" button in order to view the after scanning.
	 */
	function viewSignature()
	{
		var imageName = $("#edit_sign_viewer_"+_pageRef).attr("imgName");
		if(imageName != null && imageName != "" && imageName != undefined && imageName != "undefined")
		{
			$("#edit_sign_viewer_"+_pageRef).show();
			$("#signPadViewer_"+_pageRef).hide();
			$("#edit_sign_viewer_"+_pageRef).iviewer('loadImage', jQuery.contextPath+"/path/scan/loadPreviewImage?imgName="+decodeURIComponent(imageName));
		}
		
	}
	
	
 
	  function displaySignImg(selFile){
		  
				$("#signOption_"+_pageRef).val('I');
   				$("#edit_sign_viewer_"+_pageRef).show();
				$("#signPadViewer_"+_pageRef).hide();
				var options = { 
				url:    jQuery.contextPath+ "/path/signature/Signature_uploadSignatureImg",				 	
				type:   'post',									
				beforeSubmit:_showProgressBar(true),				
				
				success: function(response, status, xhr) {				 
				 	var jsonObj = $.parseJSON($(response).html());				 						  		 	    			    
					_showProgressBar(false);					
						if(jsonObj._error!=undefined){
							_showErrorMsg(jsonObj._error,error_msg_title);
						}
						else{
							
							$("#signFileType_"+_pageRef).val(jsonObj.fileUploadContentType);
						 	$("#signImportFile_temp_"+_pageRef).val(decodeURIComponent(jsonObj.fileImgPath));				 
						 	//#BUG 678996 image preview not available in IE
						 	//#727857 ARIBI180069 - signature on ie
						 	var params = "fileImgPath="+   (jsonObj.fileImgPath)+"&fileUploadContentType="+jsonObj.fileUploadContentType ;
							params = returnEncryptedData(params); 

							$("#edit_sign_viewer_"+_pageRef).iviewer('loadImage', jQuery.contextPath+"/path/signature/Signature_loadImage?"+params);
						}							
					    expiryUnlimitedCheckBoxOnChange();
					}
				};			
				 
			 $("#signFormId_"+_pageRef).ajaxSubmit(options); 
			 
   
   
   
   		 
   
   }
	  
   function displayDocImg(selFile,secondaryId){	     
	  
				var options = { 
				url:    jQuery.contextPath+ "/path/signature/Signature_uploadSignatureImg",				 	
				type:   'post',									
				beforeSubmit:_showProgressBar(true),				
				success: function(response, status, xhr) {				 
				 	var jsonObj = $.parseJSON($(response).html());				 						  		 	    			    
					_showProgressBar(false);					
						if(jsonObj._error!=undefined){
							_showErrorMsg(jsonObj._error,error_msg_title);
						}
						else{
							$("#docFileType_"+secondaryId).val(jsonObj.fileUploadContentType);
						 	$("#docImportFile_temp_"+secondaryId).val(decodeURIComponent(jsonObj.fileImgPath));				 
						 	var params = "fileImgPath="+decodeURIComponent(jsonObj.fileImgPath);
							params = returnEncryptedData(params); 

							$("#edit_doc_viewer_"+secondaryId).iviewer('loadImage', jQuery.contextPath+"/path/signature/Signature_loadImage?"+params);
						}							
					}
				};			
				 
			 $("#documentFormId_"+secondaryId).ajaxSubmit(options); 
			 
   
   
	   
	   
   } 
	  
	  
	  
	 function  saveDocument(secondaryId){
		if($("#documentFormId_"+secondaryId).hasChanges(true)){		 
			if(!validateDocument(secondaryId))
				return;	
			parseNumbers();
			var data = $("#documentFormId_"+secondaryId).serialize()+"&"+$.param(getSignatureParams());	//appending CIF/ACC info to data 
	 		$.ajax( {
			url : jQuery.contextPath + "/path/signature/Signature_saveDocument",
			type : "post",
			dataType : "json",
			data:data,
			beforeSend:_showProgressBar(true),	
			success : function(data) {
	 		_showProgressBar(false);	
			if (typeof data["_error"] == "undefined"|| data["_error"] == null){
				    openDocumentForm("A",secondaryId);			 
				    $("#documentGridTbl_Id_"+secondaryId).trigger("reloadGrid");
				    _showErrorMsg(record_saved_Successfully_key,success_msg_title)
		 
				 }
			 
				}
			});	
		}
	}
	 
	function onDeleteDocuments(secondaryId){
	    var docDelList =  getSelectedDocumentList(secondaryId);
	    if($.isEmptyObject(docDelList)){
	    	_showErrorMsg(msg_noRecordSelectedLabel, cannot_proceed_title);	    	
	    	return;
	    }
	     _showConfirmMsg(Confirm_Delete_Process_key, Warning_key,onConfirmDeleteDocuments, {data : docDelList,secId:secondaryId});
		

		
	}
	
	function onConfirmDeleteDocuments(confirm,args){
		if(confirm){
		 $.ajax({
			 url: $.contextPath+"/path/signature/Signature_deleteDocuments",
	         type:"post",		 
			 data: args.data,
			 dataType:"json",
			 success: function(data){			
			 	if(typeof data["_error"] == "undefined" || data["_error"] == null) {		 	
					$("#documentGridTbl_Id_" + args.secId).trigger("reloadGrid");
					openDocumentForm("A",args.secId);	
					_showErrorMsg(record_was_Deleted_Successfully_key,success_msg_title)
			 	
			 	} 
			 }
	    }); 
	 }
		
	}
	
	function onApproveDocuments(secondaryId){
		var docApproveList  = getSelectedDocumentList(secondaryId);	
		 if($.isEmptyObject(docApproveList)){
	    	_showErrorMsg(msg_noRecordSelectedLabel, cannot_proceed_title);
	    	return;
	    }
		 $.ajax({
			 url: $.contextPath+"/path/signature/Signature_approveDocuments",
	         type:"post",		 
			 data: docApproveList,
			 dataType:"json",
			 success: function(data){			
			 	if(typeof data["_error"] == "undefined" || data["_error"] == null) {		 	
					$("#documentGridTbl_Id_" + secondaryId).trigger("reloadGrid");
					openDocumentForm("A",secondaryId);	
			 		_showErrorMsg(record_was_Approved_Successfully_key,success_msg_title)
			 	} 
			 }
	    }); 
		
	}
	
	function onRejectDocuments(secondaryId){
		 var docRejectList =  getSelectedDocumentList(secondaryId);
		   if($.isEmptyObject(docRejectList)){
	    	_showErrorMsg(msg_noRecordSelectedLabel, cannot_proceed_title);
	    	return;
	    }
		 $.ajax({
			 url: $.contextPath+"/path/signature/Signature_rejectDocuments",
	         type:"post",		 
			 data: docRejectList,
			 dataType:"json",
			 success: function(data){			
			 	if(typeof data["_error"] == "undefined" || data["_error"] == null) {		 	
					$("#documentGridTbl_Id_" + secondaryId).trigger("reloadGrid");
					openDocumentForm("A",secondaryId);	
					_showErrorMsg(record_rejected_Successfully_key,success_msg_title)
			 	
			 	} 
			 }
	    }); 
			
		
	}
	
	
	
	function getSelectedDocumentList(secondaryId){
		var docList =  new Object();
		var selectedDocuments = null;
	    $.each(	$("#documentGridTbl_Id_" + secondaryId).jqGrid('getGridParam','selarrrow'), function(index, rowId) {		    	
		selectedDocuments = $("#documentGridTbl_Id_" + secondaryId).jqGrid('getRowData',rowId)		 
		docList["signatureCOList["+index+"].cifObjectVO.ACC_CY"] 		= 	selectedDocuments["cifObjectVO.ACC_CY"];
		docList["signatureCOList["+index+"].cifObjectVO.ACC_GL"] 		= 	selectedDocuments["cifObjectVO.ACC_GL"];
		docList["signatureCOList["+index+"].cifObjectVO.ACC_SL"] 		= 	selectedDocuments["cifObjectVO.ACC_SL"];
		docList["signatureCOList["+index+"].cifObjectVO.ACC_CIF"] 		= 	selectedDocuments["cifObjectVO.ACC_CIF"];
		docList["signatureCOList["+index+"].cifObjectVO.CIF_NO"] 		= 	selectedDocuments["cifObjectVO.ACC_CIF"];
		docList["signatureCOList["+index+"].cifObjectVO.OBJECT_CODE"] 	= 	selectedDocuments["cifObjectVO.OBJECT_CODE"];
		docList["signatureCOList["+index+"].cifObjectVO.OBJECT_SEQ"] 	= 	selectedDocuments["cifObjectVO.OBJECT_SEQ"];
		docList["signatureCOList["+index+"].cifObjectVO.STATUS"] 		= 	selectedDocuments["cifObjectVO.STATUS"];
		docList["signatureCOList["+index+"].cifObjectVO.TO_BE_STATUS"]	= 	selectedDocuments["cifObjectVO.TO_BE_STATUS"];
		docList["signatureCOList["+index+"].cifObjectVO.BRANCH_CODE"]	= 	selectedDocuments["cifObjectVO.BRANCH_CODE"];
		docList["signatureCOList["+index+"].origin"] 					= 	selectedDocuments["origin"];
	 
		}); 
	    return docList;
	}
	
	  
	  
	  
	/**
	 * Returns the Accounts/CIF info
	 * @return {signature parameter as object} 
	 */
	function getSignatureParams(){
		var signatureParams		= {};
		/*
		 * to attaribute pageRef is added in the functions which call getSignatureParams() because when we have from.sirialize
		 * the page ref is already included in the from
		 */
		//signatureParams["_pageRef"] 							= 	_pageRef;
		signatureParams["signatureCO.cifObjectVO.ACC_CY"] 		= 	$("#_signCYCode_"+_pageRef).val();
		signatureParams["signatureCO.cifObjectVO.ACC_GL"] 		= 	$("#_signGLCode_"+_pageRef).val();
		signatureParams["signatureCO.cifObjectVO.ACC_SL"] 		= 	$("#_signSLCode_"+_pageRef).val();
		signatureParams["signatureCO.cifObjectVO.CIF_NO"] 		= 	$("#_signCIFCode_"+_pageRef).val();
		signatureParams["signatureCO.cifObjectVO.ACC_CIF"] 		= 	$("#_signCIFCode_"+_pageRef).val();
		signatureParams["signatureCO.cifObjectVO.BRANCH_CODE"] 	= 	$("#signatureBranchCode_"+_pageRef).val();	
		signatureParams["signatureCO.autoApprove"] 				= 	$("#signatureAutoApprove_"+_pageRef).val();
		signatureParams["signatureSC.readOnly"] 				= 	$("#isSignReadOnly_"+_pageRef).val();
		signatureParams["signatureSC.signatureTp"] 				= 	$("#signatureTp_"+_pageRef).val();
		signatureParams["signatureSC.showAcceptCancelBtns"] 	= 	$("#showAcceptCancelBtns_"+_pageRef).val();
		signatureParams["signatureSC.cifType"] 					= 	$("#_signCifType_"+_pageRef).val();
		//NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
		signatureParams["signatureSC.expiryDateRequired"] 		= 	$("#expiryDateRequired_"+_pageRef).val();	
		signatureParams["signatureCO.imageName"]   				=   $("#signImportFile_"+_pageRef).val()!=""?$("#signImportFile_"+_pageRef).val():$("#edit_sign_viewer_"+_pageRef).attr("imgName");
		if($("#cifVO_STATUS_"+ _pageRef).length != 0)
		{
			signatureParams["signatureCO.screenName"] =	"FOM";
			signatureParams["signatureCO.updateDate"] =	$("#cifVO_DATE_UPDATED_"+ _pageRef).val();
			signatureParams["signatureCO.cifStatus"]  =	$("#cifVO_STATUS_"+ _pageRef).val();
		}
		return signatureParams;
	}
	
	function getLimitSchemaSignParam(){
		var signatureParams		= {};
		signatureParams["_pageRef"] 				= 	_pageRef;			 
		signatureParams["signatureSC.currencyCode"] 		= 	$("#_signCYCode_"+_pageRef).val();
		signatureParams["signatureSC.glCode"] 		= 	$("#_signGLCode_"+_pageRef).val();
		signatureParams["signatureSC.slNo"] 		= 	$("#_signSLCode_"+_pageRef).val();
		signatureParams["signatureSC.cifNo"] 		= 	$("#_signCIFCode_"+_pageRef).val();
		signatureParams["signatureSC.branchCode"] 	= 	$("#signatureBranchCode_"+_pageRef).val();
		signatureParams["signatureSC.signatureTp"] 	= 	$("#signatureTp_"+_pageRef).val();
		//signatureParams["signatureSC.filterSign"] 	= 	$("#signApplyFilter_"+_pageRef).val();
		signatureParams["signatureSC.amount"] 		= 	$("#signParamAmount_"+_pageRef).val();
		signatureParams["signatureSC.trxType"] 		= 	$("#signTrxType_"+_pageRef).val();
		//signatureParams["signatureSC.validationDate"]	= 	$("#signValidateDate_"+_pageRef).val();
		//NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
		signatureParams["signatureSC.expiryDateRequired"] 		= 	$("#expiryDateRequired_"+_pageRef).val();	
		return signatureParams;
	}
	
	
	function getGenAnnotationParams(){
		var genAnnotationParams		= {};
		genAnnotationParams["_pageRef"] 								= 	_pageRef;			 
		genAnnotationParams["genAnnotation.CURRENCY_CODE"] 	= 	$("#_signCYCode_"+_pageRef).val();
		genAnnotationParams["genAnnotation.GL_CODE"] 		= 	$("#_signGLCode_"+_pageRef).val();
		genAnnotationParams["genAnnotation.SL_NO"] 			= 	$("#_signSLCode_"+_pageRef).val();
		genAnnotationParams["genAnnotation.CIF_SUB_NO"] 	= 	$("#_signCIFCode_"+_pageRef).val();		 
		genAnnotationParams["genAnnotation.BRANCH_CODE"] 	= 	$("#signatureBranchCode_"+_pageRef).val();
		genAnnotationParams["genAnnotation.ANNOTATION"] 	= 	$("#signGenAnnotation_"+_pageRef).val();
		genAnnotationParams["signatureSC.readOnly"] 		= 	$("#isSignReadOnly_"+_pageRef).val();
		genAnnotationParams["signatureSC.signatureTp"] 		= 	$("#signatureTp_"+_pageRef).val();
		return genAnnotationParams;
		
		
	}
 
	
	function resetSignMaintForm(){
		$("#pageMode_"+_pageRef).val("A")//set the page mode to add
		//document.getElementById("SigPlus1").ClearTablet();//Clears the signature, in case of error or mistake
		resetSignMaintFields();
		var nReturn = document.getElementById("STPadCapt").SignatureRetry();
         if (nReturn < 0)
             _showErrorMsg("Could not erase signature because of error " + nReturn);
		
	}
	
	function resetSignMaintFields(){	
		$(':input', $("#signFormId_"+_pageRef)).each(function() {
			if(this.id=="expirySignDate_"+_pageRef){//expiry date
				$(this).val("");				
				$(this).datepicker("disable");				
			}
			else if(this.id=="expiryUnlimited_"+_pageRef){//unlimited checkbox
				$(this).attr('checked','checked');
				$(this).removeAttr("disabled");				
			}
			else if(this.id=="signGroup_"+_pageRef){
				$(this)[0].selectedIndex=0;
				$(this).removeAttr("disabled");		
			}
			//Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
			else if(this.id=="signatureInstructions_"+_pageRef){
				$(this).valChange("O");
				
			}
			//EWBI160037 -- Do not empty the Signature CIF field
			else if(this.id!="limitAmtCurrencyDesc_"+_pageRef && this.id!="lookuptxt_authCIFNo_"+_pageRef  && this.id!="authCifDesc_"+_pageRef ){
				$(this).val("");
			}
		});	 
		//$("#signatureGridTbl_Id_"+_pageRef).jqGrid('resetSelection');
	 }
	
	function onSignatureCompleteGridload(signatureSC){
		var signGrid   = $("#signatureGridTbl_Id_"+_pageRef);
		var rows = signGrid.jqGrid('getDataIDs');
		if( rows.length == 0){
			_showErrorMsg(no_signatures_found, info_msg_title);	
		}
			
	}
	
	
	
	function onSignatureListLoad(signatureSC){		
		$("#_signGLCode_"+_pageRef).val(signatureSC.glCode);
		$("#_signSLCode_"+_pageRef).val(signatureSC.slNo);
		$("#_signCYCode_"+_pageRef).val(signatureSC.currencyCode);
		$("#signatureTp_"+_pageRef).val(signatureSC.signatureTp);
		var signGrid   = $("#signatureGridTbl_Id_"+_pageRef);
		signGrid.jqGrid('footerData', 'set', {"cifObjectVO.AMOUNT" :	$.formatNumberNumeric(signGrid.jqGrid('getCol', 'cifObjectVO.AMOUNT', false, 'sum'), {format: returnNbFormat(3),applyRounding:true}) }, false);
		//var showApproveReject =  true;
		//var showAddDelete =  true;
	
		//if(signatureSC.program=="TRS"){
			//showAddDelete=false;
		//}
		//if(signatureSC.flag=="M"){
			//showApproveReject=false;
		//}
		//else if(signatureSC.program=="TRS"&&signatureSC.status!="A"){		 
			// showApproveReject=false;
		//}
		
		//EWBI160037 -- [John Massaad]
		var trsStatus = $("#trsStatus_"+_pageRef).val();
	    var trsIvcrud = $("#parentIvCrud_"+_pageRef).val();
	    //EWBI160037 -- [John Massaad]
	    var screenName = $("#_signScreenName_"+_pageRef).val();
			
		$("#gview_signatureGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide(); 
		
		if($("#toolbarLoaded_"+_pageRef).val()=="false"){
		 $("#toolbarLoaded_"+_pageRef).val("true");		
 		 if($("#isSignReadOnly_"+_pageRef).val()=="false"){
 			 
	 		 if($("#hdAddBtnVisible_"+_pageRef).val()=="true"){
				signGrid.jqGrid ('navButtonAdd', '#signatureGridTbl_Id_'+_pageRef+'_pager',
										      { id:"signAddBtn_"+_pageRef, 
					 						  caption:grid_addLabel,
											  buttonicon: "ui-icon-plus",
											  title: grid_addLabel,
										      onClickButton: function() {
										    	  if (typeof document.getElementById("STPadCapt").DeviceClose !== "undefined")
										    		  {
										    		  document.getElementById("STPadCapt").DeviceClose(0);
										    		  }
										       openSignatureForm("A");											      
										      }});		
									    }
			 if($("#hdDelBtnVisible_"+_pageRef).val()=="true"){											
				signGrid.jqGrid ('navButtonAdd', '#signatureGridTbl_Id_'+_pageRef+'_pager',
										      { caption:grid_delLabel,
											  buttonicon: "ui-icon-trash",
											  title: grid_delLabel,
										      onClickButton: function() {
										       onDeleteSignatures();								      
				 			      }});
			 			      }
			 
			 if($("#hdApproveBtnVisible_"+_pageRef).val()=="true"){				
					signGrid.jqGrid ('navButtonAdd', '#signatureGridTbl_Id_'+_pageRef+'_pager',
											      {id:"signApproveBtn_"+_pageRef, 
												  caption:grid_approveLabel,
												  buttonicon: "ui-icon-check",
												  title: grid_approveLabel,
											      onClickButton: function() {onApproveSignatures();}});
										     }
			 if($("#hdRejectBtnVisible_"+_pageRef).val()=="true"){
				 	var signRejectLabel  =$("#signMode_"+_pageRef).val()=="0"?Reject_Deleted_key:Reject_Active_Deleted_key;				 	
					signGrid.jqGrid ('navButtonAdd', '#signatureGridTbl_Id_'+_pageRef+'_pager',
											      {id:"signRejectBtn_"+_pageRef,
												   caption:signRejectLabel,
												  buttonicon: "ui-icon-cancel",
												  title:signRejectLabel,
											      onClickButton: function() {onRejectSignatures();}})   ;
					}
			 
			 } 
 		  else{
 			  
 			 //EWBI160037 -- [John Massaad]
  			 //The trsNo is only filled when oppening the account signature from transaction screen.
  			  var trsNo = $("#trsNo_"+_pageRef).val();
  			  if(trsNo!=null && trsNo!=undefined && trsNo!='undefined' && trsNo!='' )
  			  {	   
  				  //if transaction status is Active and ivCrud = 'R' the close button must be hidden and Accept, Reject buttons must appear.

 				     if(($("#showAcceptCancelBtns_"+_pageRef).val()=="true" && $("#hideAcceptCancelInAlert_"+_pageRef).val()!="true")&&(((trsStatus==null || trsStatus=='A')&& trsIvcrud=='R') || (trsStatus=='T' && trsIvcrud=='AS')||  screenName == 'batchProcessing' ))  // In batch processing we need the signature to be always enabled and get the checked rows 
 			  {
  					    signGrid.jqGrid ('navButtonAdd', '#signatureGridTbl_Id_'+_pageRef+'_pager',
 											      {
  					  							  caption:Accept_key,
 												  buttonicon: "ui-icon-check",
												  title: Accept_key,
											      onClickButton: function() {onAcceptSignatures();}});
 				  		signGrid.jqGrid ('navButtonAdd', '#signatureGridTbl_Id_'+_pageRef+'_pager',
											      { 
     					  							  caption:grid_rejectLabel,
												  buttonicon: "ui-icon-cancel",
												  title:grid_rejectLabel,
											      onClickButton: function() {onCancelSignatures();}})   ;
 					  
 				  	$("#signatureCancelBtn_"+ _pageRef).hide();
 				  	if (screenName == 'batchProcessing')
 				  		{
 				  		$("#signatureCancelBtn_"+ _pageRef).show();
 				  		}
 				  }
 				  else 
 				  {
 					 $("#signatureCancelBtn_"+ _pageRef).show(); 	
				   	//to disable the checkbox select (to disable the selection on the rows when the trsStatus not Active and iv_crud !='R')
				    $("[id^=jqg_signatureGridTbl_Id_"+_pageRef+"]").attr("disabled","disabled");
				    $("[id^=cb_signatureGridTbl_Id_"+_pageRef+"]").attr("disabled","disabled");
				    
				    //VIIVP
				    $("#jqg_signatureGridTbl_Id_F00I1MT_3").attr("checked",true);
 				  }
 				  
 				  	//The below is to select the signatures that are saved in CTSTRS_SIGNATURE
					var rowIds=signGrid.jqGrid('getDataIDs');
					for(var i = 0;i<rowIds.length;i++)
					{
						var rowId = rowIds[i];
						var checked = signGrid.jqGrid("getCell", rowId, "checked");
						
						if("1"==checked)
						{
							signGrid.jqGrid('setSelection', rowId);
						}
					}
				//EWBI160037 -- [John Massaad]
 			  }
 			  else
 			  {
 				  	  //Fix issue #242600	
		 			  if($("#showAcceptCancelBtns_"+_pageRef).val()=="true" && $("#hideAcceptCancelInAlert_"+_pageRef).val()!="true")
		 			  {
		 				 
		 				  signGrid.jqGrid ('navButtonAdd', '#signatureGridTbl_Id_'+_pageRef+'_pager',
													      {
		     					  							  caption:Accept_key,
														  buttonicon: "ui-icon-check",
														  title: Accept_key,
													      onClickButton: function() {onAcceptSignatures();}});
		 				  signGrid.jqGrid ('navButtonAdd', '#signatureGridTbl_Id_'+_pageRef+'_pager',
													      { 
		     					  							  caption:grid_rejectLabel,
														  buttonicon: "ui-icon-cancel",
														  title:grid_rejectLabel,
													      onClickButton: function() {onCancelSignatures();}})   ;
		 			  }
 				  
 				  
 				}
 			  
 		 
 		  }
 		 	 		 
		
			 }
 		 	//}
		
			//EWBI160037 -- [John Massaad] -- protect authorized signatures
			 var signGrid   = $("#signatureGridTbl_Id_"+_pageRef);
		 	  	//The below is to select the signatures that are saved in CTSTRS_SIGNATURE
				var rowIds=signGrid.jqGrid('getDataIDs');
				for(var i = 0;i<rowIds.length;i++)
				{
					var rowId = rowIds[i];
					var signProtected = signGrid.jqGrid("getCell", rowId, "cifObjectVO.SIGN_PROTECTED_YN");
					var signatureStatus = signGrid.jqGrid("getCell", rowId, "cifObjectVO.STATUS");
					
					if("1"==signProtected || "D"==signatureStatus)
					{
						$("#btnEdit_"+rowId).hide();
						$("#btnChangeAmt_"+rowId).hide();
					}
				}
			//EWBI160037
	}
	
	
	function onDocumentListLoad(id){		
	 
		$("#gview_documentGridTbl_Id_"+id+" div.ui-jqgrid-titlebar").hide();         
 		 if($("#isSignReadOnly_"+_pageRef).val()=="false"&&$("#documentAddBtn_"+id).html()==null){		 
	 		 if($("#showDocAddBtn_"+id).val()=="true"){
				 $("#documentGridTbl_Id_"+id).jqGrid ('navButtonAdd', '#documentGridTbl_Id_'+id+'_pager',
										      { 
					 						  id:"documentAddBtn_"+id,
					    					  caption:grid_addLabel,
											  buttonicon: "ui-icon-plus",
											  title: grid_addLabel,
										      onClickButton: function() {
										       openDocumentForm("A",id);											      
										      }});		
									    }
			 if($("#showDocDelBtn_"+id).val()=="true"){											
				$("#documentGridTbl_Id_"+id).jqGrid ('navButtonAdd', '#documentGridTbl_Id_'+id+'_pager',
										      { caption:grid_delLabel,
											  buttonicon: "ui-icon-trash",
											  title: grid_delLabel,
										      onClickButton: function() {
										       onDeleteDocuments(id);								      
				 			      }});
			 			      }
			if($("#showDocApproveBtn_"+id).val()=="true"){			
				$("#documentGridTbl_Id_"+id).jqGrid ('navButtonAdd', '#documentGridTbl_Id_'+id+'_pager',
										      { caption:grid_approveLabel,
											  buttonicon: "ui-icon-check",
											  title: grid_approveLabel,
										      onClickButton: function() {onApproveDocuments(id);}});
									     }
			// if($("#showDocRejectBtn_"+id).val()=="true"){
			//	$("#documentGridTbl_Id_"+id).jqGrid ('navButtonAdd', '#documentGridTbl_Id_'+id+'_pager',
			//							      { caption:grid_rejectLabel,
			//								  buttonicon: "ui-icon-cancel",
			//								  title:grid_rejectLabel,
			//							      onClickButton: function() {onRejectDocuments(id);}})   ;
			//	}	
			
			 }
 		 
 		 
 		  
 
   
	}
	
	
  function  saveGenAnnotation(){  
	  	if($("#genAnnotationFormId_"+_pageRef).hasChanges(true)){
	 		$.ajax( {
			url : jQuery.contextPath + "/path/signature/Signature_saveGeneralAnnotation",
			type : "post",
			dataType : "json",
			data:$.param(getGenAnnotationParams()),
			beforeSend:_showProgressBar(true),	
			success : function(data) {
	 		_showProgressBar(false);	
			if (typeof data["_error"] == "undefined"|| data["_error"] == null){
		 			_showErrorMsg(gen_ann_saved_msg,success_msg_title);
		 			loadSignAnnotation();
				 }
			else{
				   _showErrorMsg(data["_error"], data["_msgTitle"]);
			}
				}
			});	
 		}
	}
  
  function loadSignAnnotation()
  {
	  var signParams = getSignatureParams();
	  signParams["_pageRef"] 	= 	_pageRef;
	  var mySrc = jQuery.contextPath + "/path/signature/Signature_loadSignAnnotation";
	  $("#generalInformation-3_content_" + _pageRef).load(mySrc ,signParams, function() {});
  }
	
	
	function validateSignature(){
		var pageMode  = $("#pageMode_"+_pageRef).val();
		if(pageMode=="A"){ //add mode
			// Commented by Rakan Makarem #498977 -SBI170057 - Signature Discription LOV
			/*if($("#signDesc_"+_pageRef).val()==""){
				_showErrorMsg(desc_mandatory_msg, cannot_proceed_title);
				return false;
			}
			else*/ if(returnCaptSign())
			{
				document.getElementById("STPadCapt").DeviceClose(0);
				return true;
			}
			//Bug # 338150
			else if($("#signImportFile_temp_"+_pageRef).val()=="" && typeof $("#edit_sign_viewer_"+_pageRef).attr("imgName") == "undefined"){
				_showErrorMsg(please_select_a_signature_key, cannot_proceed_title);
				return false;
			}					
		}	 
		return true;
		
	}
	
	
	
	function validateDocument(secondaryId){
		var pageMode  = $("#docPageMode_"+secondaryId).val();
		if(pageMode=="A"){ //add mode
			if($("#docDesc_"+secondaryId).val()==""){
				_showErrorMsg(desc_mandatory_msg, cannot_proceed_title);
				return false;
			}	
			else if($("#docImportFile_temp_"+secondaryId).val()==""){
				_showErrorMsg(choose_doc_msg, cannot_proceed_title);
				return false;
			}			
		}	
		else if(pageMode=="E"){
			if($("#docDesc_"+secondaryId).val()==""){
				_showErrorMsg(desc_mandatory_msg, cannot_proceed_title);
				return false;
			}	
		}
		return true;
		
	}
	
	function clearGenAnnotationForm(){
		//modified by rany for bugid:679011
		//$("#signGenAnnotation_"+_pageRef).val('');
		$("#signGenAnnotation_"+_pageRef).valChange('');
		//end rany
	}
	
	function copySignatures(index,isSignAvailConfirmed){			
		var signParams = getSignatureParams();
		signParams["_pageRef"] 	= 	_pageRef;
		signParams["signatureCO.index"] = index;
		if(isSignAvailConfirmed){
			signParams["signAvailConfirmed"] = true;
		}
		$.ajax( {
		url : jQuery.contextPath + "/path/signature/Signature_copySignatures",
		type : "post",
		dataType : "json",
		data:signParams,
		beforeSend:_showProgressBar(true),	
		success : function(data) {			
 		_showProgressBar(false);	
		if (typeof data["_error"] == "undefined"|| data["_error"] == null){			 
			    if(data["copySignAvailable"]){	
			    	_showConfirmMsg(data["_confirm"],"",function(confirm){			    		
			    		if(confirm){
			    			copySignatures(index,true);	
			    		}
			    	},"yesNo");			    			    	
			    }
			    else{
					_showErrorMsg(sign_copied, info_msg_title)			    	
			    }
			

			 }
		else{
			   _showErrorMsg(data["_error"], data["_msgTitle"]);
		}
			}
		});	 
		
		
		
		
	}
	
	function resetDocumentForm(secondaryId){
		$("#docDesc_"+secondaryId).val('');
	}
	
	 function Signature(){
		 this.selectedSignatures =  new Array(); 
		 this.actionsPerformed 	=  new Map();
		this.schemaApproved 	=  false;	
		this.schemaRejected 	=  false;
		this.schemaModified 	=  false;
		this.signatureAdded 	=  false;
		this.signatureDelete    =  false;
		this.signatureModified  =  false;
		this.signatureApproved 	=  false;
		this.signatureRejected 	=  false;
		this.signatureViewed    =  false;
		this.signatureError     =  false;
		this.signAmount 		=  "Unlimited";
		this.signatureAccepted  =  false;
		this.signatureCancelled = false;
		this.signatureGrpId 	= null;
		this.allSignatureViewed =  false;
		
	}
	
	 
	 
	 //========================================================================================================//
	 
	 
	 // linking the key-value-pairs is optional
// if no argument is provided, linkItems === undefined, i.e. !== false
// --> linking will be enabled
function Map(linkItems) {
    this.current = undefined;
    this.size = 0;

    if(linkItems === false)
        this.disableLinking();
}

Map.noop = function() {
    return this;
};

Map.illegal = function() {
    throw new Error("illegal operation for maps without linking");
};

// map initialisation from existing object
// doesn't add inherited properties if not explicitly instructed to:
// omitting foreignKeys means foreignKeys === undefined, i.e. == false
// --> inherited properties won't be added
Map.from = function(obj, foreignKeys) {
    var map = new Map;

    for(var prop in obj) {
        if(foreignKeys || obj.hasOwnProperty(prop))
            map.put(prop, obj[prop]);
    }

    return map;
};

Map.prototype.disableLinking = function() {
    this.link = Map.noop;
    this.unlink = Map.noop;
    this.disableLinking = Map.noop;
    this.next = Map.illegal;
    this.key = Map.illegal;
    this.value = Map.illegal;
    this.removeAll = Map.illegal;

    return this;
};

// overwrite in Map instance if necessary
Map.prototype.hash = function(value) {
    return (typeof value) + ' ' + (value instanceof Object ?
        (value.__hash || (value.__hash = ++arguments.callee.current)) :
        value.toString());
};

Map.prototype.hash.current = 0;

// --- mapping functions

Map.prototype.get = function(key) {
    var item = this[this.hash(key)];
    return item === undefined ? undefined : item.value;
};

Map.prototype.put = function(key, value) {
    var hash = this.hash(key);

    if(this[hash] === undefined) {
        var item = { key : key, value : value };
        this[hash] = item;

        this.link(item);
        ++this.size;
    }
    else this[hash].value = value;

    return this;
};

Map.prototype.remove = function(key) {
    var hash = this.hash(key);
    var item = this[hash];

    if(item !== undefined) {
        --this.size;
        this.unlink(item);

        delete this[hash];
    }

    return this;
};

// only works if linked
Map.prototype.removeAll = function() {
    while(this.size)
        this.remove(this.key());

    return this;
};

// --- linked list helper functions

Map.prototype.link = function(item) {
    if(this.size == 0) {
        item.prev = item;
        item.next = item;
        this.current = item;
    }
    else {
        item.prev = this.current.prev;
        item.prev.next = item;
        item.next = this.current;
        this.current.prev = item;
    }
};

Map.prototype.unlink = function(item) {
    if(this.size == 0)
        this.current = undefined;
    else {
        item.prev.next = item.next;
        item.next.prev = item.prev;
        if(item === this.current)
            this.current = item.next;
    }
};

// --- iterator functions - only work if map is linked

Map.prototype.next = function() {
    this.current = this.current.next;
};

Map.prototype.key = function() {
    return this.current.key;
};

Map.prototype.value = function() {
    return this.current.value;
};
	 
	 
	 
	 
	 //==========================================================================================================//
	
	
function onSignatureCheckBoxSelect(){		
	    calculateSignAmt($("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow'));
	  
	
}


function approveReject(){
	var disableRejectBtn = false;
	var disableApproveBtn =  false;	
	$.each($("#signatureGridTbl_Id_" + _pageRef).jqGrid('getGridParam','selarrrow'), function(index, rowId) {		    	
					selectedSignature = $("#signatureGridTbl_Id_" + _pageRef).jqGrid('getRowData',rowId)					 
					if(selectedSignature["cifObjectVO.STATUS"]=="P")
					   disableApproveBtn =  true;
					if(selectedSignature["cifObjectVO.TO_BE_STATUS"]!="D")
					  disableRejectBtn =  true;
				 
			});	
 
	if(disableApproveBtn)		 
		$("#signApproveBtn_"+_pageRef).hide();		
	 else		 
		$("#signApproveBtn_"+_pageRef).show();
	if(disableRejectBtn)		 
		$("#signRejectBtn_"+_pageRef).hide();		
	 else		 
		$("#signRejectBtn_"+_pageRef).show();
		 
}

function clearSignPadViewer()
{
	try
	{
		document.getElementById("STPadCapt").SignatureRetry();
	//	document.getElementById("SigPlus1").ClearTablet();//Clears the signature, in case of error or mistake
	}
	catch(e)
	{
		_showErrorMsg(AX_ERROR_KEY,error_msg_title);
	}
}
	 
	

function signature_showAuditReport(progRef) {
	$(document).ready(
			function() {
				var preCallRes = true;
        		// check if PreCall Func Exists and not Empty in order to call it, so that if false return do not proceed to Autdit Report
        		// usefull in multi select Row, where audit can be viewed fro single row Selection
        		var auditPreCallFunc = $("#auditPreCall_"+progRef).val();
        		if(auditPreCallFunc != null && auditPreCallFunc !== "" && auditPreCallFunc!="undefined")
        		{
        		  preCallRes = eval(auditPreCallFunc);
        		}
        		// check if not false returned from Precall Function if available
        		if(typeof preCallRes == "undefined" || preCallRes == "undefined" || preCallRes)
        		{
					var sigauditTrxNbr_val = $("#setSignAuditTrxNbr_"+progRef).val();
				//	alert(sigauditTrxNbr_val)
				//	alert(progRef)
	            	if(sigauditTrxNbr_val!=null &&sigauditTrxNbr_val!="" && sigauditTrxNbr_val!="undefined")
	            	{
		            		$.__overlaybox( {
								height : returnMaxHeight(750),
								href : jQuery.contextPath
										+ "/path/audit/audit_showAuditReport",
	                            data:{progRef:progRef,trxNbr:sigauditTrxNbr_val}   
							});
	            		
	            	}else{
	            		_showErrorMsg(msg_noRecordSelectedLabel,info_msg_title);					
					}
	            }
			});
}

//added by maria 
function onchangeIdNo(){
//	handleIdNoPrevValue();
	
	var params = {};
	params["signatureCO.scanVO.ID_NO"]    		= $("#scanVO_ID_NO_"+_pageRef).val();
	params["signatureCO.scanVO.ID_TYPE"] = $("#lookuptxt_scanVO_ID_TYPE_"+_pageRef).val();
	
	_showProgressBar(true);
	var action 	  =	jQuery.contextPath+ "/path/signature/Signature_dependencyByIdNo";

	$.ajax({
		url : action,
		type : "post",
		data : params,
		dataType : "json",
		success : function(data) {
			if (data["_error"] == null) {

				$("#scanVO_ID_TYPE_" + _pageRef).val(data.signatureCO.scanVO.ID_NO);
				_showProgressBar(false);
			}else {
				resetIdPrevValue();
				_showProgressBar(false);
			}
		}
	});
	
}

function handleIdNoPrevValue()
{
	$("#idNoPrevValue_"+_pageRef).val($("#scanVO_ID_NO_"+_pageRef).attr("prevValue"));
}

function resetIdPrevValue()
{
	var prevValue = $("#idNoPrevValue_"+_pageRef).val();
	$("#scanVO_ID_NO_"+_pageRef).val(prevValue);
	$("#scanVO_ID_NO_"+_pageRef).attr("prevValue",prevValue);
}