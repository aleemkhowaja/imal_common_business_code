
function onNewProcClicked() {

	var mySrc = jQuery.contextPath
			+ "/path/criteria/criteriaMaint_loadProcedure.action?_pageRef="
			+ _pageRef;

	var curParams = {};

	var dialogOptions = {
		modal : true,
		height : returnMaxHeight(350),
		width : returnMaxWidth(1100),
		autoOpen : false,
		show : {
			effect : "slide",
			duration : 100,
			complete : function() {
				resizeSingleGrid("procedureGridTbl_Id_" + _pageRef);
			}
		},
		position : 'center',
		title : procedure_key_trans,
		close : function(event, ui) {
			$("#procedureDivId_" + _pageRef).dialog("destroy").appendTo(
					"#criteriaDefFormId_" + _pageRef);
			emptyProcedureGridOnPopupClose();
			
		},
		buttons : {
			"save" : function() {
				applyProcedureFunct();
			},
			"Cancel" : function() {
				$("#procedureDivId_" + _pageRef).dialog("destroy").appendTo(
						"#criteriaDefFormId_" + _pageRef);
				emptyProcedureGridOnPopupClose();
			}
		}
	};

	if ($("#procedureDivId_" + _pageRef).is(':empty') === true) {
		$("#procedureDivId_" + _pageRef).empty().html("");
		$("#procedureDivId_" + _pageRef).load(mySrc, curParams, function() {
			$("#procedureDivId_" + _pageRef).dialog(dialogOptions);
			$("#procedureDivId_" + _pageRef).dialog("open");
		});
	} else {
		$("#procedureDivId_" + _pageRef).dialog(dialogOptions);
		$("#procedureDivId_" + _pageRef).dialog("open");
	}
	$("#criteriaDefFormId_" + _pageRef).bindFormChanges(
			"procedureDivId_" + _pageRef);
}

function emptyProcedureGridOnPopupClose(){
	var procedureGrid = $("#procedureGridTbl_Id_" + _pageRef);
	var rows = procedureGrid.jqGrid('getDataIDs');
	var rowsLen = rows.length;
	
	for(i=rowsLen-1; i>=0; i--)
	{
		procedureGrid.jqGrid('delRowData',rows[i])
	}
}


function deleteRowProcedureGrid(rowId) {
	_showProgressBar(true);

	var procedureGrid = $("#procedureGridTbl_Id_" + _pageRef);
	var selRow = procedureGrid.jqGrid("getGridParam", 'selrow');

	var lineNo = procedureGrid.jqGrid("getCell", selRow,
			"ctsCriteriaVO.LINE_NO");
	if (lineNo != null && lineNo != "") 
	{
//		var params = { "criteriaCO.procedireIdCO.ctsCriteriaVO.LINE_NO" : lineNo };
//		$.ajax( {
//			url : jQuery.contextPath
//					+ "/path/avaFile/criteriaMaint_checkIfProcedureCanDeleted",
//			type : "post",
//			dataType : "json",
//			data : params,
//			success : function(data) {
//				if (data["_error"] == null) {
//					procedureGrid.jqGrid('delRowData', selRow);
//					var theForm = document.getElementById("criteriaDefFormId_"
//							+ _pageRef);
//					$.data(theForm, "changeTrack", true);
//
//				}
//				_showProgressBar(false);
//			}
//		});
	}
	else
	{
		procedureGrid.jqGrid('delRowData', selRow);

		var theForm = document.getElementById("criteriaDefFormId_" + _pageRef);
		$.data(theForm, "changeTrack", true);
		_showProgressBar(false);
	}
}

function applyProcedureFunct() {
	var procGrid = $("#proceduresForm_" + _pageRef);
	var changes = $("#proceduresForm_" + _pageRef).hasChanges(true);
	if (changes == 'true' || changes == true) {
		//	var procNames = $("#PROC_NAME_"+_pageRef).val();
		//var procDesc = $("#PROC_DESC_" + _pageRef);
		//		var iv_crud = $("#iv_crud_"+ _pageRef).val();
		//		var rowIds = procGrid.jqGrid('getDataIDs');
		//		var rowLength = rowIds.length;

		var jsonStringUpdates = $("#procedureGridTbl_Id_" + _pageRef).jqGrid(
				"getAllRows");

		$.ajax( {
			url : jQuery.contextPath
					+ "/path/criteria/criteriaMaint_saveProcedures",
			type : "post",
			data : {
				"proceduresIdCOsStr" : jsonStringUpdates
			},
			dataType : "json",
			success : function(data) {
				if (typeof data["_error"] == "undefined"
						|| data["_error"] == null) {
					
						$("#procedureDivId_" + _pageRef).dialog("destroy").appendTo("#criteriaDefFormId_"+_pageRef);
						emptyProcedureGridOnPopupClose();
				}
			}
		});
	}
}




function criteria_save()
{
	debugger;
	var iv_crud = $("#iv_crud_" + _pageRef).val();
	var changes = "";
	var methodName = "saveNew";
    if (methodName == 'saveNew')
	{
		 changes = $("#criteriaDefFormId_" + _pageRef).hasChanges(true);
	}
	if((changes == 'true' || changes == true)  || ( methodName != 'saveNew') )
 		{
			var actionSrc = jQuery.contextPath				
   				+ "/path/criteria/criteriaMaint_"+methodName+"?iv_crud="+iv_crud  ;
			
		    parseNumbers();
		    var theForm = $("#criteriaDefFormId_"+_pageRef).serializeForm();  //take all the data to the java
		   
		    _showProgressBar(true);
		   
		    $.ajax( {
						url : actionSrc,
						type : "post",
						dataType : "json",
						data : theForm,
						success : function(data) 
				        {

			    			if(data["_error"] == null && iv_crud == 'R')
							{
		    					
		    					$("#criteriaDefFormId_" + _pageRef).trigger("reloadGrid");
					    	    criteria_initializeAfterConfirm(true);
		    					
		    				}
			    		
			    			_showProgressBar(false);
		    				
		    				
			    		}
		    		})
		}		          
}

function criteriaMaint_onParamBtnClicked(entityType)
{
	
	var entityId="";
	var entityName="";
	var divId = "";
	if(entityType == 'Q')
	{
		entityId = $("#lookuptxt_query_id_"+_pageRef).val();
		divId = $("#queryParamsDivId_"+_pageRef);
		
	}
	else if(entityType == 'P')
	{
		entityId = $("#lookuptxt_proc_id_"+_pageRef).val();
		entityName = $("#proc_name_"+_pageRef).val();
		divId = $("#procedureParamsDivId_"+_pageRef);
	}

	
	var criteriaCode = $("#criteriaId_"+_pageRef).val();
	var branchCode= $("#branchCode_"+_pageRef).val();
	
	var mySrc = jQuery.contextPath
			+ "/path/criteria/criteriaMaint_loadParam" +
					".action?_pageRef="
			+ _pageRef;

	var curParams = {"criteriaCO.ctsCriteriaParamVO.ENTITY_TYPE":entityType, 
		             "criteriaCO.ctsCriteriaParamVO.ENTITY_ID":entityId,
		             "criteriaCO.ctsCriteriaVO.CRITERIA_CODE":criteriaCode,
		              "_entityType":entityType,
		             "criteriaSC.entityName":entityName,
		             "criteriaCO.ctsCriteriaVO.BRANCH_CODE": branchCode};

	
	var dialogOptions = {
		modal : true,
		height : returnMaxHeight(350),
		width : returnMaxWidth(1100),
		autoOpen : false,
		show : {
			effect : "slide",
			duration : 100,
			complete : 
						
				function() {
				resizeSingleGrid("criteriaParamGridTbl_Id_" + _pageRef+"_"+entityType);
//				//criteriaParamAddRefGrid_completeTopicFct(entityType);
			}
		},
		position : 'center',
		title :  parameters_key_trans,
		close : function(event, ui) {
			$(this).dialog("destroy").appendTo("#criteriaDefFormId_" + _pageRef);
		},
		
		buttons : {
			"ok" : function() {
				var criteriaParamGridTbl = $("#criteriaParamGridTbl_Id_" + _pageRef+"_"+entityType);
				var jsonStringUpdates = criteriaParamGridTbl.jqGrid("getAllRows");
				if(entityType == 'Q')
				{
					$("#queriesParamCOsStr_"+_pageRef).val(jsonStringUpdates);
				}
				else if(entityType == 'P')
				{
					$("#proceduresParamCOsStr_"+_pageRef).val(jsonStringUpdates);
				}
				$(this).dialog("destroy").appendTo("#criteriaDefFormId_"+_pageRef);

				
			}
		}
	};



	if(divId.is(':empty') === true 
			/*|| $("#newValue_" + _pageRef).val() != $("#oldValue_" + _pageRef).val()*/)
	{
		divId.empty().html("");
		divId.load(mySrc, curParams, function() {
					divId.dialog(dialogOptions);
					divId.dialog("open");
					$("#criteriaParamEntityType_"+_pageRef).val(entityType);
				});
	}
	else
	{
		divId.dialog(dialogOptions);
		divId.dialog("open");
		$("#criteriaParamEntityType_"+_pageRef).val(entityType);
	}

	if(entityType == 'Q')
	{
		$("#criteriaDefFormId_" + _pageRef).bindFormChanges("queryParamsDivId_"+_pageRef);
	}
	else if(entityType == 'P')
	{
		$("#criteriaDefFormId_" + _pageRef).bindFormChanges("procedureParamsDivId_"+_pageRef);
	}

//	$("#criteriaDefFormId_" + _pageRef).bindFormChanges("paramDivId_" + _pageRef);
}


/**
 * when then dialog is fully loaded
 * i load the grid in case it has been already loaded (to prevent data change loss)
 */
function criteriaParamAddRefGrid_completeTopicFct(entityType)
{
	
	
	if(entityType == 'Q')
	{
	
		var referencesJsonStr = $("#queriesParamCOsStr_"+_pageRef).val();
	}

	else if(entityType == 'P')
	{
		var referencesJsonStr = $("#proceduresParamCOsStr_"+_pageRef).val();
	}
	
	
	if(typeof referencesJsonStr != undefined && referencesJsonStr != null && referencesJsonStr != '' && referencesJsonStr!='referencesJsonStr')
	{
		var referencesJsonArray = $.parseJSON(referencesJsonStr);
		if(typeof referencesJsonArray != undefined && referencesJsonArray != null )
		{
			var i=1;
			$.each(referencesJsonArray, function( index, value ) {
					$("#criteriaParamGridTbl_Id_"+_pageRef).jqGrid('addRowData',i,value);
					i++;
			});
		}
	}
}


function clearParamsHtmlsEvent(entityType)
{
	if(entityType == "P")
	{
		$("#procedureParamsDivId_"+_pageRef).empty().html("");
	}
	else if(entityType == "Q")
	{
		$("#queryParamsDivId_"+_pageRef).empty().html("");
	}
}

function criteriaUsage_afterDepEvent()
{
	var theForm = $("#criteriaDefFormId_" + _pageRef).serializeForm();
	
	$.ajax({
			url : jQuery.contextPath + "/path/criteria/criteriaMaint_onChangeCriteriaEntity",
			type : "post",
			data : theForm,
			dataType : "json",
			success : function(data)
			{
				if (typeof data["_error"] == "undefined" || data["_error"] == null)
				{
					var criteriaUsage = $("#criteriaUsage_" + _pageRef).val()

					$("#scoreValue_" + _pageRef).val("")

					if (criteriaUsage == "O")
					{
						$("#scoreValue_" + _pageRef).show()
						$("#lbl_scoreValue_" + _pageRef).show()
					}
					else
					{
						$("#scoreValue_" + _pageRef).hide()
						$("#lbl_scoreValue_" + _pageRef).hide()
					}
				}
				else
				{
					var prevVal = $('#criteriaUsage_' + _pageRef).attr("prevvalue");
					
					$("#criteriaUsage_" + _pageRef).val(prevVal)
				}
			}
	});

}