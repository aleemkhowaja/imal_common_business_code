function excludeCifs_addId (){
	
	var $table= $("#excludeCifsGridTbl_Id_"+_pageRef);  //excludeCifsGridTbl_Id_
	var rowId = $table.jqGrid('getGridParam', 'selrow');
	//get the last row in the grid, even if it is newly added
	var lastRowIndex = $table.jqGrid('getDataIDs')[$table.jqGrid('getDataIDs').length - 1];
	
	var CIF_NO = $table.jqGrid("getCell", lastRowIndex, "ctsSegmentCifExcludeVO.CIF_NO");
	
	// ADD Rows
	 if ((typeof lastRowIndex == 'undefined')|| (CIF_NO != null && CIF_NO != "")){
		 		$table.jqGrid('addInlineRow', {});
			}
	 else{
		 _showErrorMsg("Fill CIF NO",info_msg_title);
	 }
}

function excludeCifsOnEditLoad(){
	 alert("on edit inline before");
}

// DELETE commodity
function excludeCifs_deleteId(obj) {
	_showConfirmMsg(delete_selected_record_key,grid_delLabel,"confirmexcludeCifsList_delCom","yesNo");
}

function confirmexcludeCifsList_delCom(yesNo) {
	if (yesNo) {
		var $t = $("#excludeCifsGridTbl_Id_"+_pageRef);
		var rowId = $t.jqGrid('getGridParam', 'selrow');
		delData = $t.jqGrid('deleteGridRow', rowId);
	}
}

function onChangingExcludeCif(e)
{
//	var grid = $("#excludeCifsGridTbl_Id_" + _pageRef);
//	var rowdata =  grid.jqGrid('getRowData');
//	var selectedRowId = 	grid.jqGrid("getGridParam", 'selrow');
//	var selectedRowIndex =	grid.jqGrid('getInd',selectedRowId); 
//	
//	var cifToBeExcluded = grid.jqGrid("getCell", selectedRowIndex, "ctsSegmentCifExcludeVO.CIF_NO");
//	
//	$.each(rowdata, function(index, value) 
//	{
//		if(index != selectedRowIndex-1)// index starts with 0 and selectedRowIndex starts with 1
//		{
//			var tempCIF = trxTypeGrid.jqGrid('getCell', selectedRowId,'ctsSegmentCifExcludeVO.CIF_NO');
//			if(tempCIF == cifToBeExcluded)
//			{
//				_showErrorMsg("Fill CIF NO",info_msg_title);
//			}
//		}
//	})
}