/**
 * @param fromWhere : whiteListed, 
 * 					   suspicious
 * 		  gridId : matchedCIFListId, 
 * 					whiteListGridId
 * 		  action : BlackListMatchedCIFListAction, 
 * 					BlackListWhiteListAction
 */
function switchCIFListStatus( fromWhere, gridId, action, nextSiblingGrid)
{
	_showProgressBar(true);
	var checkedListObj  = new Array();
	var _gridId = $("#"+gridId);
	var selArrRow = _gridId.jqGrid('getGridParam','selarrrow');
	
	if(selArrRow.length ==0){
		_showProgressBar(false);
		return;
	}
	
//	for(var tmpRowId in selArrRow){
//		var checkedRows = _gridId.jqGrid('getCell', selArrRow[tmpRowId], 'rowId');
//		checkedListObj.push( checkedRows);
//	}
	
	for(var i =0 ; i < selArrRow.length ; i++)
	{
		
		var selRow = selArrRow[i]
		var rowId_data = _gridId.jqGrid('getCell', selRow, 'rowId');
	    checkedListObj.push(rowId_data);
		
	}
	
	
	
	var obj={"checkedList": checkedListObj,
			"fromWhere": fromWhere};
	
	$.ajax({url:  jQuery.contextPath + "/path/blacklistmanagement/" +action+ "_switchCIFListStatus", 
			type:"post", 
			dataType:"json",
			data: obj,
			error:function(){
			},success:function(data){
				
				if(data["_error"] == null )
				{
					$("#"+nextSiblingGrid).trigger("reloadGrid");
					replaceText( eval("_"+fromWhere+"_key"), checkedListObj, _gridId);
				}
				_showProgressBar(false);
			}
		});
}

//******************************************************************************************************************************** //

/**
 * replace the status of the corresponding cif in the list, after saving it
 */
function replaceText( repText, obj, _gridId){
//	_gridId.jqGrid('getRowData',1)["cifVO.CIF_NO"]
	var gridRec = _gridId.jqGrid('getGridParam','rowNum');
//	for(var selectedObj=0 in obj){
	for(var selectedObj=0; selectedObj < obj.length; selectedObj++){  		
		var objId = obj[selectedObj].split(";")[0];
		for(var i=1; i<=gridRec ; i++){
			var checkedRows = _gridId.jqGrid("getCell", i, "cifVO.CIF_NO")
			if(objId == checkedRows)
				_gridId.jqGrid("setCellValue", i, 'statusDesc', repText,false);
		}
	}
}

//******************************************************************************************************************************** //
/**
 * called on uploading a file,
 * proceed is by default false, if we have a confirmation alert it's set true
 */
function uploadBlackListFile( proceed){
	//by bilal for TP#885556
	var structCode = $("#fileStruct_"+_pageRef).val();
	var fileCode = $("#lookuptxt_enqFileCode").val();
	
	if(!proceed && (!validateBlackListForm() || fileCode == "")) //by bilal for tp3885556
		return;
	
	var asSource = $("#asSourceHidd_"+_pageRef).val();
	var params = {"_pageRef": _pageRef
					,"proceed" : proceed
					,"structCode" : structCode //by bilal for TP#885556
					,"fileCode" : fileCode	};
	
	var successMsg = $("#confirmMsg_"+_pageRef).val();

	var options = {
		url : jQuery.contextPath
				+ "/path/blacklistmanagement/BlackListIntSourceUploadMaint_uploadFile?_asSource="
				+ asSource,
		type : 'post',
		data : params,
		beforeSubmit : _showProgressBar(true),
		success : function(response, status, xhr) {
			_showProgressBar(false);

			try {
				var jsonResponse = JSON.parse($(response).html());
				if (jsonResponse["_confirm"] != "" && typeof jsonResponse["_confirm"] != "undefined") {
					_showConfirmMsg(jsonResponse["_confirm"], proceed_msg_title,
							function(confirmcChoice, theArgs) {
								if (confirmcChoice) {
									uploadBlackListFile(true);
									return;
								}
							});
					return;
				} else if (jsonResponse["_error"] != "" && typeof jsonResponse["_error"] != "undefined") {
					_showErrorMsg(jsonResponse["_error"]);
					$("#" + $("#fileHidd_" + _pageRef).val()).val('');
					fillAsSource('', '');
				} else {
					_showErrorMsg(successMsg, info_msg_title)
					$("#" + $("#fileHidd_" + _pageRef).val()).val('');
					fillAsSource('', '');
					//by bilal for TP#885556
					$("#lookuptxt_enqFileCode").val('');
					$("#fileDesc_" + _pageRef).val('');
					document.getElementById('headerBlackList').innerHTML = '';
					document.getElementById('linkBlackList').innerHTML = '';
				}
			} catch (e) {
				$("#" + $("#fileHidd_" + _pageRef).val()).val('');
				fillAsSource('', '');
				_showErrorMsg(successMsg, info_msg_title)
				//by bilal for TP#885556
				$("#lookuptxt_enqFileCode").val('');
				$("#fileDesc_" + _pageRef).val('');
				document.getElementById('headerBlackList').innerHTML = '';
				document.getElementById('linkBlackList').innerHTML = '';
			}
		},
		error : function(response, status, xhr) {
			_showProgressBar(false);
		}
	};
	
	$("#blackListIntSrcFormId_"+_pageRef).ajaxSubmit(options);
}

//******************************************************************************************************************************** //

function validateBlackListForm( ){
//	if($("#asSourceHidd_"+_pageRef).val() == "")
//		return false;
//	else{
		if( $("#uploadScriptDyn").val() == ''){
			return false;
		}
//			else if ($("#asSourceHidd_"+_pageRef).val() == "O"){
//			if( $("#uploadOFACScript").val() == ''){
//				return false;
//			}
//		}
//		
//		else {
//			
//			if( $("#uploadEUScript").val() == ''){
//				return false;
//			}
//		}
//	}
	return true;
}

//******************************************************************************************************************************** //

//fill hidden property as_source 
function fillAsSource( asSource, fileObj){
	$("#asSourceHidd_"+_pageRef).val( asSource);
	$("#fileHidd_"+_pageRef).val( fileObj);
}

/**
 * On select each tab
 * @param {Object} selectedTabId
 */
//function blckListIntSrc_fillAsSource(selectedTabId){
//	if(selectedTabId.indexOf("UNUploadMaintTab") > -1){
//		fillAsSource('U','uploadUNScript');
//	}else if(selectedTabId.indexOf("OFACUploadMaintTab") > -1){
//		fillAsSource('O','uploadOFACScript');
//	}
//	else {
//		fillAsSource('E','uploadEUScript');
//	}
//}

function fillData()
{
	var type = $("#fileType_"+_pageRef).val();
	var typeName;
	if(type != "")
	{
		if(type == 'O')
		{
			typeName = 'OFAC';
		}
		else if(type == 'U')
		{
			typeName = 'UN';
		}
		else if(type == 'E')
		{
			typeName = 'EU';
		}
		else
		{
			typeName = 'UN';
		}
		
		fillAsSource( type, 'uploadScriptDyn');
		var headerBL = $("#fileHeader_"+_pageRef).val();
		var detailsBL = $("#fileDetails_"+_pageRef).val();
		//detailsBL = detailsBL.replace(/\r?\\n/g\~r~n/, '</li><li>');
		detailsBL = detailsBL.replace(/(?:\\[rn]|[\r\n]+)+/g, '</li><li>');
		var linkLabelBL = $("#fileLinkLabel_"+_pageRef).val();
		var linkBL = $("#fileLink_"+_pageRef).val();
		document.getElementById('uploadScriptDyn').setAttribute("name", "fileName"+typeName);
		
		document.getElementById('headerBlackList').innerHTML = '<h2><u><ps:text name="headerBL">' + headerBL + '</ps:text></u></h2>';
		document.getElementById('linkBlackList').innerHTML = '<ul><li>' + before_link_label_key + ' <a href="' + linkBL + '"  target="_new"  ><ps:text name="link">' + linkLabelBL + '</ps:text></a></li>' +
															'<li><ps:text name="detailsBL">' + detailsBL + '</ps:text></li></ul>';
	}
	else
	{
		document.getElementById('headerBlackList').innerHTML = '';
		document.getElementById('linkBlackList').innerHTML = '';
	}
	
}

//by bilal for BUG#974996
function validateExt()
{
	var filename = document.getElementById("uploadScriptDyn").value;
	if(filename != "")
	{
		var ext = filename.substring(filename.lastIndexOf(".")+1,filename.length).toUpperCase();
		if(ext != "" && ext != "CSV" && ext != "XLS" && ext != "XLSX" && ext != "TXT" && ext != "XML") 
		{
			$("#uploadScriptDyn").val('');
			_showErrorMsg(fileNotAllowedKey + "CSV, XLS, XLSX, TXT, XML");
		}
	}
}