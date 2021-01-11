function custSegmentationList_onAddClicked()
{
	on_openNewCustSegmentation();
}

function on_openNewCustSegmentation() {
	var changes = $("#custSegmentationMaintFormId_"+_pageRef).hasChanges();  //custSegmentationMaintFormId_
	if(changes == 'true' || changes == true)
	{
		_showConfirmMsg(changes_made_confirm_msg,"","confirm_openNewCustSegmentation","yesNo");// Confirmation call if changes made
	}
	else
	{
		confirm_openNewCustSegmentation(true);
	}
}

function confirm_openNewCustSegmentation(yesNo)
{
	if(yesNo == true)
	{
		openNewCustSegmentation();   
	}
}

/**
 * reload page for new record
 */
function openNewCustSegmentation(paramArr) {
	_showProgressBar(true);
	//if paramArr is not filled (in case of new record) we create a new one
	paramArr = typeof paramArr == 'undefined' ? {} : paramArr;

	var iv_crud = $("#iv_crud_" + _pageRef).val();

	paramArr["_pageRef"] = _pageRef;
	paramArr["iv_crud"] = iv_crud;

	var actionSrc = jQuery.contextPath+ "/path/segmentation/CustSegmentationMaintAction_initialize";

	$.post(actionSrc, paramArr, function(returnHtmlPage) {
		$("#custSegmentationListMaintDiv_id_" + _pageRef).html(returnHtmlPage);
	    }, "html").complete(function() {
		
			_showProgressBar(false);
//			showHideSrchGrid('stfCommodityMarketPriceListGridTbl_Id_' + _pageRef);
	});
}

/**
 * on double click
 * @returns
 */

function custSegmentationList_onDbClickedEvent()
{
  	var $table = $("#custSegmentationListGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var myObject = $table.jqGrid('getRowData', selectedRowId);
	var segment_code = myObject["ctsSegmentVO.SEGMENT_CODE"];
	custSegmentation_loadDataInTheForm(segment_code);   
	showHideSrchGrid('custSegmentationListGridTbl_Id_' + _pageRef);
}

/**
 * load detail form
 * @param market_index_date
 * @param market_index_time
 * @returns
 */
function custSegmentation_loadDataInTheForm(segment_code) {
	
	debugger;
	var segDefinePrioritiesGrid = $("#custSegmentationDetailList_Id_" + _pageRef);
	var rowsIds = segDefinePrioritiesGrid.jqGrid('getDataIDs');

	for (var i = 1; i <= rowsIds.length; i++)
	{
		$("#dialog_div_p" + i + "_" + _pageRef).dialog("destroy").remove();
	}
	
	var ivCrud = $("#iv_crud_" + _pageRef).val();
	var actionSrc = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_retrieveCustSegment";
	var paramObj = {
		"custSegmentationCO.ctsSegmentVO.SEGMENT_CODE" : segment_code,  //new Date(market_index_time)
		"iv_crud" : ivCrud,		
		"_pageRef" : _pageRef,
		"_newRecord" : false,
	};

	_showProgressBar(true);
	$.post(actionSrc, paramObj, function(param) {
		_showProgressBar(false);
		$("#custSegmentationListMaintDiv_id_" + _pageRef).html(param);  //custSegmentationListMaintDiv_id_
		$("#excludeCifsGridTbl_Id_" + _pageRef).trigger("reloadGrid");
	}, "html");
}

// DELETE criteria in grid View
function custSegmentationDetailList_delCom(obj) {
	_showConfirmMsg(Confirm_Delete_Process_key,grid_delLabel,"confirmcustSegmentationDetailList_delCom","yesNo");
}

function confirmcustSegmentationDetailList_delCom(yesNo) {
	if (yesNo) {
		var $t = $("#custSegmentationDetailList_Id_"+_pageRef);   //custSegmentationDetailList_Id_${_pageRef}
		var rowId = $t.jqGrid('getGridParam', 'selrow');
		delData = $t.jqGrid('deleteGridRow', rowId);
		
		$("#dialog_div_c"+rowId+"_"+_pageRef).remove();
		$("#dialog_div_p"+rowId+"_"+_pageRef).remove();
	}
}

function custSegmentationDetailList_onAddClicked (){
	var _gridId= $("#custSegmentationDetailList_Id_"+_pageRef);
	var rowId = _gridId.jqGrid('getGridParam', 'selrow');
	//get the last row in the grid, even if it is newly added
	var lastRowIndex = _gridId.jqGrid('getDataIDs')[_gridId.jqGrid('getDataIDs').length - 1];
	var CRITERION = _gridId.jqGrid("getCell", lastRowIndex, "ctsSegmentDetVO.CRITERIA_CODE");	
	/// joyceeeeeee
	var lineNo = _gridId.jqGrid("getCell", rowId, "ctsSegmentDetVO.LINE_NO");
	
	// ADD Rows
	 if ((typeof lastRowIndex == 'undefined')|| (CRITERION != null && CRITERION != "")){
		 		_gridId.jqGrid('addInlineRow', {});
			}
	 else{
		 _showErrorMsg("Please check mandatory fields",info_msg_title);
	 }
}

function custSegmentationDetailList_trialProcess(){
	$("#methodName_" + _pageRef).val("trialProcess");
	custSegmentationMaint_processSubmit(true); 
}

function custSegmentation_editInlineBeforeTopicsAP(obj){
		var _gridId= $("#custSegmentationDetailList_Id_"+_pageRef);
		var rowId = obj.originalEvent.id;
		var _restTypeCell = $("#"+obj.target.id );	
		var gridViewId= _gridId.jqGrid('getDataIDs');
		var isSegmentationScore = $("#isSegmentationScore_"+_pageRef).val();//moved up by maureen for tp 955568
		
		_gridId.jqGrid('setCellReadOnly', rowId, "ctsSegmentDetVO.LOGICAL_OPERATOR", false);	
		for (i=0; i < gridViewId.length ; i++){
			//i = 0 means First Row
			if (gridViewId[i]  == rowId && i == 0)
			{
				//create an empty option just for first row
				$('#'+rowId+'_ctsSegmentDetVO\\.LOGICAL_OPERATOR').append($('<option>', {
				  value: 'X',
				  text: ''
				}));
				
				
				_gridId.jqGrid('setCell', rowId, "ctsSegmentDetVO.LEFT_OPERATOR", '(');
				//added by maureen for tp 955568
				if (isSegmentationScore == 'SC' || isSegmentationScore == 'BR')
				{										
					_gridId.jqGrid('setCell', rowId, "ctsSegmentDetVO.RIGHT_OPERATOR", ')');	
				}
				//added by maureen for tp 955568
				//selected by default, to avoid any other operator
				$('#'+rowId+'_ctsSegmentDetVO\\.LOGICAL_OPERATOR option[value=X]').prop("selected",true);
				_gridId.jqGrid('setCellReadOnly', rowId, "ctsSegmentDetVO.LOGICAL_OPERATOR", true);	
			}
			//added by maureen for tp 955568
			else
			{
				if (isSegmentationScore == 'SC' || isSegmentationScore == 'BR')
					{
						_gridId.jqGrid('setCell', rowId, "ctsSegmentDetVO.LOGICAL_OPERATOR", 'OR');
						_gridId.jqGrid('setCell', rowId, "ctsSegmentDetVO.LEFT_OPERATOR", '(');
						_gridId.jqGrid('setCell', rowId, "ctsSegmentDetVO.RIGHT_OPERATOR", ')');
					}
				
			}
			//added by maureen for tp 955568
		}
		_gridId.jqGrid("setCellRequired" ,rowId,"ctsSegmentDetVO.CRITERIA_CODE",true);
		
		 //Rania - 718813 - Dynamic Customer Scoring on latest
		debugger;
		 var isSegmentationScore = $("#isSegmentationScore_"+_pageRef).val();
		 var scoringCalcCriteria = $("#scoringCalcCriteria_"+_pageRef).val(); //Rania - BMO180147 - Risk Assessment of customers on the basis of products, services and geographic locations
		 
		 if(isSegmentationScore == "SC" && scoringCalcCriteria == "C") //Rania - BMO180147 - Risk Assessment of customers on the basis of products, services and geographic locations
		 {
			 _gridId.jqGrid('setCellReadOnly', rowId, "ctsSegmentDetVO.LABEL_CODE", false);
			 _gridId.jqGrid('setCellReadOnly', rowId, "ctsSegmentDetVO.LABEL_PERC", false);
		 }
		 else
		 {
			 _gridId.jqGrid('setCellReadOnly', rowId, "ctsSegmentDetVO.LABEL_CODE", true);
			 _gridId.jqGrid('setCellReadOnly', rowId, "ctsSegmentDetVO.LABEL_PERC", true);
		 }
}


function criteriaCodeAfterDep()
{					
	var $grid = $("#custSegmentationDetailList_Id_" + _pageRef);
	var selectedRowId = $grid.jqGrid('getGridParam', 'selrow');
	
	var crieriaPrevValue 	 = $("#"+selectedRowId+"_ctsSegmentDetVO\\.CRITERIA_CODE_lookuptxt_custSegmentationDetailList_Id_"+_pageRef).attr("prevValue");
	var criteriaCurrentValue = $("#"+selectedRowId+"_ctsSegmentDetVO\\.CRITERIA_CODE_lookuptxt_custSegmentationDetailList_Id_"+_pageRef).val();
	
	if(crieriaPrevValue != criteriaCurrentValue)
	{
		$("#dialog_div_c"+selectedRowId+"_"+_pageRef).remove();
		$("#dialog_div_p"+selectedRowId+"_"+_pageRef).remove();
	}
}

//Rania - 718813 - Dynamic Customer Scoring on latest
function onChangeLabelPercentage()
{
	var _gridId= $("#custSegmentationDetailList_Id_"+_pageRef);
	var rowId = _gridId.jqGrid('getGridParam', 'selrow');
	var rowCount = _gridId.jqGrid('getDataIDs').length
	var gridViewId= _gridId.jqGrid('getDataIDs');
	var totalLabelPerc = 0;
	
	var custSegmentationDetailList_Id_gridAllRecords = _gridId.jqGrid('getAllRows');
	$("#custSegmentationDetailList_Id_gridAllRecords_" + _pageRef).val(custSegmentationDetailList_Id_gridAllRecords);

	var actionPath = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_totalPercentageValidation";
	var paramObj = {
					"custSegmentationDetailList_Id_gridAllRecords":$("#custSegmentationDetailList_Id_gridAllRecords_" + _pageRef).val(),
					"custSegmentationCO.ctsSegmentVO.IS_SEGMENT_SCORE":$("#isSegmentationScore_" + _pageRef).val(),
					"custSegmentationCO.fromDepFunc":"dep",
				};
	
	$.ajax({
			url : actionPath,
			type : "post",
			dataType : "json",
			data : paramObj,
			success : function(data)
			{
				if (typeof data["_error"] != "undefined" && data["_error"] != null)
				{
					_gridId.jqGrid('setCellValue', rowId, "ctsSegmentDetVO.LABEL_PERC", null);
				}
			}
	});
}

//Rania - 718813 - Dynamic Customer Scoring on latest
function onCheckIgnoreOtherCalcFields()
{
	
	var $table = $("#custSegmentationDetailList_Id_"+_pageRef);
    var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var myObject  = $table.jqGrid('getRowData', selectedRowId);
	var isChecked = myObject["ctsSegmentDetVO.IGNORE_OTHER_CALC_FIELDS_YN"];

	if(isChecked == 1)
	{		
	    var rowIds = $table.jqGrid('getDataIDs');
		$.each(rowIds, function(index,rowId) {
			if(rowId != selectedRowId) {
					$table.jqGrid("setCellEltValue",rowId,"ctsSegmentDetVO.IGNORE_OTHER_CALC_FIELDS_YN",0);
			}
		});
	}
}

//Rania - BMO180147 - Risk Assessment of customers on the basis of products, services and geographic locations
function criteriaCodeAfterDependency()
{
	debugger;
	var custSegmentationDetailGrid = $("#custSegmentationDetailList_Id_" + _pageRef);
	var rowsIds = custSegmentationDetailGrid.jqGrid('getDataIDs');

	var selRow = custSegmentationDetailGrid.jqGrid("getGridParam", 'selrow');
	var selRowCustSegmentationObject = custSegmentationDetailGrid.jqGrid('getRowData', selRow);
	var selRowCustSegmentationValue = selRowCustSegmentationObject["ctsSegmentDetVO.CRITERIA_CODE"]; //Rania - Customers Segmentation Enhancement

	for (var i = 0; i < rowsIds.length; i++)
	{
		var rowId = rowsIds[i];

		if (rowId != selRow)
		{
			var myCurrentObject = custSegmentationDetailGrid.jqGrid('getRowData', rowId);
			var currentValue = myCurrentObject["ctsSegmentDetVO.CRITERIA_CODE"];
			if (currentValue == selRowCustSegmentationValue)
			{
				custSegmentationDetailGrid.jqGrid("setCellValue", selRow, "ctsSegmentDetVO.CRITERIA_CODE", null); //Rania - Customers Segmentation Enhancement
				_showErrorMsg("Duplicate Value", "Warning");
			}
		}
	}

}