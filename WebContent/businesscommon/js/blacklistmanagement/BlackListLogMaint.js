function blacklistLog_reasonBtn(cellValue, options, rowObject) 
{	
		return '<a href = "#" onclick="blacklistLog_reasonBtnDialog(' + options.rowId
				+ ');">' +  blackListReason_trans_key + '</a>';		
}

function blacklistLog_reasonBtnDialog(rowindex)
{
	var blckListLogGrid = $("#blackListLogGridTbl_Id_" + _pageRef);
	blckListLogGrid.jqGrid('setSelection',	rowindex);
		
	selRow = blckListLogGrid.jqGrid("getGridParam", 'selrow');
	var lineNo = blckListLogGrid.jqGrid('getCell', selRow,'ctsBlackListLogVO.LINE_NO');
	if(lineNo != "" && lineNo != null)
	{
		_showProgressBar(true);

		var srcURL  = jQuery.contextPath+"/path/blackList/BlackListLogMaintAction_loadBlackListReasonGrid.action?_pageRef="+_pageRef;
		var	statusDiv = $("<div id='dialog_div_"+_pageRef+"'/>");
		statusDiv.css("padding","0");
		var theForm = $("#blackListLogMaintForm_"+_pageRef);
	    statusDiv.insertAfter(theForm); 
	    var curParams = {"blackListLogSC.blckListLogLineNo":lineNo};
		$("#dialog_div_"+_pageRef).load(srcURL, curParams, function() {
	    $("#dialog_div_"+_pageRef).dialog({modal:true, 
		                                  title: blackListReason_trans_key,
		                               autoOpen:false,
		                                   show:'slide',
		                               position:'center', 
		                                 width:'300',
		                                 height:'250',
		                                 close: function (){
							 								 var theDialog = $(this);
							 								 theDialog.remove();
														    }});
		$("#dialog_div_"+_pageRef).dialog("open");
		_showProgressBar(false);
	    });
	}
}




function blacklistLog_matchPercBtn(cellValue, options, rowObject) 
{	
		return '<a href = "#" onclick="blacklistLog_matchPercBtnDialog(' + options.rowId
				+ ');">' +  blackListMatchPerc_trans_key + '</a>';		
}

function blacklistLog_matchPercBtnDialog(rowindex)
{
	var blckListLogGrid = $("#blackListLogGridTbl_Id_" + _pageRef);
	blckListLogGrid.jqGrid('setSelection',	rowindex);
		
	selRow = blckListLogGrid.jqGrid("getGridParam", 'selrow');
	var lineNo = blckListLogGrid.jqGrid('getCell', selRow,'ctsBlackListLogVO.LINE_NO');
	if(lineNo != "" && lineNo != null)
	{
		_showProgressBar(true);

		var srcURL  = jQuery.contextPath+"/path/blackList/BlackListLogMaintAction_loadBlackListNameMatchGrid.action?_pageRef="+_pageRef;
		var	statusDiv = $("<div id='dialog_div_"+_pageRef+"'/>");
		statusDiv.css("padding","0");
		var theForm = $("#blackListLogMaintForm_"+_pageRef);
	    statusDiv.insertAfter(theForm); 
	    var curParams = {"blackListLogSC.blckListLogLineNo":lineNo};
		$("#dialog_div_"+_pageRef).load(srcURL, curParams, function() {
	    $("#dialog_div_"+_pageRef).dialog({modal:true, 
		                                  title: blackListReason_trans_key,
		                               autoOpen:false,
		                                   show:'slide',
		                               position:'center', 
		                                 width:'500',
		                                 height:'250',
		                                 close: function (){
							 								 var theDialog = $(this);
							 								 theDialog.remove();
														    }});
		$("#dialog_div_"+_pageRef).dialog("open");
		_showProgressBar(false);
	    });
	}
}


function processBlackListLog(){
	
	var blackListLogGrid = $("#blackListLogMaintForm_" + _pageRef);
	var changes = $("#blackListLogMaintForm_" + _pageRef).hasChanges(true);
	if (changes == 'true' || changes == true) {

		var jsonStringUpdates = $("#blackListLogGridTbl_Id_" + _pageRef).jqGrid(
				"getAllRows");
		$.ajax( {
			url : jQuery.contextPath
					+ "/path/blackList/BlackListLogMaintAction_process",
			type : "post",
			data : {
				"blackListLogCO.blackListLogCOsStr" : jsonStringUpdates
			},
			dataType : "json",
			success : function(data) {
				if (typeof data["_error"] == "undefined"
						|| data["_error"] == null) {
					
					$("#blackListLogGridTbl_Id_"+_pageRef).trigger("reloadGrid");
						
				}
			}
		});
	}
	
}

function onChangeACTION_TYPE(col, rowObj, cellValue, obj)
{
	var bllGrid = $("#blackListLogGridTbl_Id_" + _pageRef);
	var selRowId = bllGrid.jqGrid("getGridParam","selrow");
	var row = bllGrid.jqGrid('getRowData', selRowId);
	var actionType = bllGrid.jqGrid('getCell', selRowId,'ctsBlackListLogVO.ACTION_TYPE');
	if(actionType =='1' || actionType =='' || actionType == null)
	{
	bllGrid.jqGrid('setCellReadOnly', selRowId,"ctsBlackListLogVO.REMARK_VALUE", "true");
	}
	else if(actionType =='2' && actionType != "" && actionType != null)
	{
	bllGrid.jqGrid('setCellReadOnly', selRowId,"ctsBlackListLogVO.REMARK_VALUE", "false");
	}
}


//added by bilal for TP#885556

function blacklistLog_detailsBtn(cellValue, options, rowObject) 
{	 var bl_code = rowObject["blackListCode"];
		if (bl_code !='' && bl_code !=null)
			{
		return '<a href = "#" onclick="blacklistLog_detailsBtnDialog(' + options.rowId
				+ ');">' +  details_key + '</a>';	
			}
		return '';	
}
//added by bilal for TP#885556
function blacklistLog_detailsBtnDialog(rowindex)
{
	var iv_crud = "BLL";
	var blckListLogGrid = $("#blackListLogGridTbl_Id_" + _pageRef);
	blckListLogGrid.jqGrid('setSelection',	rowindex);
		
	selRow = blckListLogGrid.jqGrid("getGridParam", 'selrow');
	var lineNo = blckListLogGrid.jqGrid('getCell', selRow,'ctsBlackListLogVO.LINE_NO');
	if(lineNo != "" && lineNo != null)
	{
		_showProgressBar(true);

		var loadSrc  = jQuery.contextPath+"/path/blackList/BlackListMaint_showBlackListDetails.action";
		var	statusDiv = $("<div id='dialog_bl_div_"+_pageRef+"'/>");
		statusDiv.css("padding","0");
		var theForm = $("#blackListLogMaintForm_"+_pageRef);
		var blackListCode = blckListLogGrid.jqGrid('getCell', selRow,'blackListCode');
	    statusDiv.insertAfter(theForm); 
	    var blackListParams = {};
		blackListParams["_pageRef"] 			= 	_pageRef;
		blackListParams["iv_crud"] 				= 	iv_crud;
		blackListParams["blackListSC.code"] 	=	 blackListCode;
		$("#dialog_bl_div_"+_pageRef).load(loadSrc, blackListParams, function() {
				$("#dialog_bl_div_"+_pageRef).dialog({
										  modal:true, 
		                                  title: Black_List_Management_key,
		                                  autoOpen:false,
		                                  show : {
		              						effect : "slide",
		              						duration : 100,
		              						complete : function() {
		              							_showProgressBar(false); 
			              						}
			              					},
		                                   position:'center', 
		                                   width : returnMaxWidth(1200),
		                   					height : returnMaxHeight(730),
		                   					close: function (){
				 								 var theDialog = $(this);
				 								 theDialog.remove();
		                   						}
			              					});
		$("#dialog_bl_div_"+_pageRef).dialog("open");
		_showProgressBar(false);
	    });
	}
}