function segmentGroupingList_onDbClickedEvent()
{
	var $table = $("#segmentGroupingListGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var myObject = $table.jqGrid('getRowData', selectedRowId);
	var segment_code = myObject["ctsSegmentGroupingVO.GROUP_CODE"];
	segmentGrouping_loadDataInTheForm(segment_code);   
	showHideSrchGrid('segmentGroupingListGridTbl_Id_' + _pageRef);
}

function segmentGrouping_loadDataInTheForm(segment_code) {
	var ivCrud = $("#iv_crud_" + _pageRef).val();
	var actionSrc = jQuery.contextPath + "/path/grouping/SegmentGroupingMaintAction_retrieveSegmentGroup";
	var paramObj = {
		"segmentGroupingCO.ctsSegmentGroupingVO.GROUP_CODE" : segment_code,
		"iv_crud" : ivCrud,		
		"_pageRef" : _pageRef,
		"_newRecord" : false,
	};

	_showProgressBar(true);
	$.post(actionSrc, paramObj, function(param) {
		_showProgressBar(false);
		$("#segmentGroupingListMaintDiv_id_" + _pageRef).html(param);
	}, "html");
}

function segmentGroupingList_onAddClicked()
{
	var changes = $("#segmentGroupingFormId_" + _pageRef).hasChanges();

	if (changes == 'true' || changes == true)
	{
		_showConfirmMsg(changes_made_confirm_msg, "", "confirm_openNewSegmentGrouping", "yesNo");// Confirmation call if changes made
	}
	else
	{
		confirm_openNewSegmentGrouping(true);
	}
}

function confirm_openNewSegmentGrouping(yesNo)
{
	if (yesNo == true)
	{
		openNewSegmentGrouping();
	}
}

function openNewSegmentGrouping(paramArr)
{
	_showProgressBar(true);
	paramArr = typeof paramArr == 'undefined' ? {} : paramArr;

	var iv_crud = $("#iv_crud_" + _pageRef).val();

	paramArr["_pageRef"] = _pageRef;
	paramArr["iv_crud"] = iv_crud;

	var actionSrc = jQuery.contextPath + "/path/grouping/SegmentGroupingMaintAction_initialize";

	$.post(actionSrc, paramArr, function(returnHtmlPage)
	{
		$("#segmentGroupingListMaintDiv_id_" + _pageRef).html(returnHtmlPage);
	}, "html").complete(function()
	{

		_showProgressBar(false);
	});
}
