function criteria_ListLoad()
{
	$("div#criteriaListDetailDiv.collapsibleContainer").collapsiblePanel();
	$("#gview_criteriaGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
}



//load data upon double click on main grid records
function criteria_onDbClickedEvent()

{
	var changes = false;
	if($("#criteriaDefFormId_" + _pageRef).length != 0)  //in case of approve the form is not loaded yet upon first search
	{
		changes = $("#criteriaDefFormId_" + _pageRef).hasChanges();
	}
	if (changes == 'true' || changes == true) {
		_showConfirmMsg(changes_made_confirm_msg, "",
				"criteria_onDbClickedAfterConfirm", true);// Confirmation call if changes made
	} else {
		criteria_onDbClickedAfterConfirm(true);
	}
}


function criteria_onDbClickedAfterConfirm(yesNo) 
{
	if(yesNo == true)
	{
		_showProgressBar(true);
		var iv_crud = $("#iv_crud_" + _pageRef).val();
		var table = $("#criteriaGridTbl_Id_" + _pageRef);
		var selectedRowId = table.jqGrid('getGridParam', 'selrow');
		var myObject = table.jqGrid('getRowData', selectedRowId);
		var criteriaCode = myObject["ctsCriteriaVO.CRITERIA_CODE"];
		var linkLoadSrc = jQuery.contextPath
				+ '/path/criteria/criteriaMaint_loadCriteriaDetails.action?criteriaCO.ctsCriteriaVO.CRITERIA_CODE='+criteriaCode+'&_pageRef='+_pageRef+'&iv_crud='+iv_crud;
		
		$.post(linkLoadSrc
		   ,{}
	       ,function( data )
 	        {
	    	   if(typeof data == "object")
		    	 {
		    		 if(data._error != "")
		    		  {
		    			 _showErrorMsg(data._error,data._msgTitle)
		    		  }
		    	 }
		    	 else
		    	 {		    		 
		            $("#criteriaDiv_id_"+_pageRef).html(data);
		            showHideSrchGrid("criteriaGridTbl_Id_" + _pageRef);
		    	 }
		         _showProgressBar(false);
	        } );
	}
}

//reload upon clicking on new button

function criteria_onAddClicked()
{
		var changes = $("#criteriaDefFormId_"+_pageRef).hasChanges();
	if(changes == 'true' || changes == true)
	{
		_showConfirmMsg(changes_made_confirm_msg,"","criteria_initializeAfterConfirm","yesNo");// Confirmation call if changes made
	}
	else
	{
		criteria_initializeAfterConfirm(true);
	}
}


function criteria_initializeAfterConfirm(yesNo)
{
	_showProgressBar(true);
	if(yesNo == true)
	{ 
		var iv_crud = $("#iv_crud_" + _pageRef).val();
		
		var actionSrc = jQuery.contextPath
				+ "/path/criteria/criteriaMaint_loadCriteriaDetails?_pageRef="+_pageRef+"&iv_crud="+iv_crud;
		$.ajax( {
			url : actionSrc,
			type : "post",
			success : function(data) {
				$("#criteriaDiv_id_" + _pageRef).html(data);
				_showProgressBar(false);
			}
		});
	}
}



//function newQueryBtnClicked(cellValue, options, rowObject) 
//{		return '<a href = "#" onclick="onNewQueryShowlink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
//}

function closeRepQueryIframe()
{
	$("#newQueryDiv_id_"+_pageRef ).dialog("destroy");
	$("#newQueryDiv_id_"+_pageRef).remove();
}

function newQueryBtnClicked()
{
  	//var $t = $("#NewQueryListGridTbl_Id_"+_pageRef);
  	
  	//var myObject      = $t.jqGrid('getRowData',selectedRowId); 
	if(_pageRef.indexOf("CSG00CR") == 0 || _pageRef.indexOf("BR001MT") == 0)//Rania - ABSAI180073
	{
		var ivCrud = "R";	
		
		var queryDiv = $("<div id='newQueryDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
		var newQueryDiv = $(queryDiv);
		
		if(queryDiv.html() == null || queryDiv.html() == "")
		{
			var theForm = $("#criteriaFormId_"+_pageRef);
			
			  theForm.append(newQueryDiv);
			
			newQueryDiv.insertAfter(theForm);
		}
		
		//var mySrc = jQuery.contextPath+"/path/designer/queriesList_openTemplateQueries.action?";
		var params = {
				   '_pageRef':'RD00Q',
				  	"iv_crud" :ivCrud,
				   'isLookUp':1,
				   'openSqb':true,
				   'showQryName':'true',
				   'fromQry':'true'
					   //,_pageRef:'MSCL'
				   };
		var currentAppName = 'REP';
		var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
		var iFrameParams = {};
		iFrameParams["destinationProgRef"] = "RD00Q";
		iFrameParams["appName"] = currentAppName;
		iFrameParams["destinationUrl"] = "/path/designer/queryDesign_createStaticQuery";
		iFrameParams["additionalParams"] = JSON.stringify(params);
		
		newQueryDiv.dialog( {
			modal : true,
			title : Query_key,
			autoOpen : false,
			position : 'center',
			height : returnMaxHeight(501),
			width : returnMaxWidth(1023),
			close : function() {
				$("#newQueryDiv_id_"+_pageRef ).dialog("destroy");
				$("#newQueryDiv_id_"+_pageRef ).remove();
			},
			open : function() {
			}
		});

		$(newQueryDiv).load(iFrameUrl,iFrameParams,
				function() 
				{
					$("#newQueryDiv_id_"+_pageRef ).dialog("open");
				});
	}
}


function addRowProcedureGrid() 
{
	var procedureGrid = $("#procedureGridTbl_Id_" + _pageRef);
	procedureGrid.jqGrid('addInlineRow', {});
}

//By Bilal For TP#750884
//var templateQryId;
/*function editSelectedQuery()
{
	var queryDivEdit = $("<div id='queriesDialg_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var theForm = $("#criteriaFormId_"+_pageRef);
	
	 var queriesDialg = $(queryDivEdit);
	  theForm.append(queriesDialg);
	  queriesDialg.insertAfter(theForm);
	
	var queryId = $("#lookuptxt_query_id_"+_pageRef).val();  
	
	if(queryId != null && queryId != "")
	{
		var params = {
				'queryId' : queryId,
			   '_pageRef':'RD00Q',
			   'openSqb' : true,
			   'iv_crud' : 'R',
			   'isLookUp':1,
			   'showQryName':true,
			   'fromQry':true,
			   'templateQryId' : queryId
			   };
		var currentAppName = 'REP';
		var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
		var iFrameParams = {};
		iFrameParams["destinationProgRef"] = "RD00Q";
		iFrameParams["appName"] = currentAppName;
		iFrameParams["destinationUrl"] = "/path/designer/queriesList_openQuery";
		iFrameParams["additionalParams"] = JSON.stringify(params);
		
		queriesDialg.dialog( {
			modal : true,
			title : Query_key,
			autoOpen : false,
			position : 'center',
			height : returnMaxHeight(501),
			width : returnMaxWidth(1023),
			close : function() {
				$("#queriesDialg_"+_pageRef ).dialog("destroy");
				$("#queriesDialg_"+_pageRef ).remove();
			},
			open : function(data){
			}
		});
	
		$(queriesDialg).load(iFrameUrl,iFrameParams,
				function() 
				{
					$("#queriesDialg_"+_pageRef ).dialog("open");
				});
	}
}*/

function editSelectedQuery()
{
	var queryDivEdit = $("<div id='newQueryDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var theForm = $("#criteriaFormId_"+_pageRef);
	
	 var queriesDialg = $(queryDivEdit);
	  theForm.append(queriesDialg);
	  queriesDialg.insertAfter(theForm);
	
	var queryId = $("#lookuptxt_query_id_"+_pageRef).val();  
	
	if(queryId != null && queryId != "")
	{
		var params = {
				'queryId' : queryId,
			   '_pageRef':'RD00Q',
			   'openSqb' : true,
			   'iv_crud' : 'R',
			   'isLookUp':1,
			   'showQryName':true,
			   'fromQry':true,
			   'templateQryId' : queryId
			   };
		var currentAppName = 'REP';
		var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
		var iFrameParams = {};
		iFrameParams["destinationProgRef"] = "RD00Q";
		iFrameParams["appName"] = currentAppName;
		iFrameParams["destinationUrl"] = "/path/designer/queriesList_openQuery";
		iFrameParams["additionalParams"] = JSON.stringify(params);
		
		queriesDialg.dialog( {
			modal : true,
			title : Query_key,
			autoOpen : false,
			position : 'center',
			height : returnMaxHeight(501),
			width : returnMaxWidth(1023),
			close : function() {
				$("#newQueryDiv_id_"+_pageRef ).dialog("destroy");
				$("#newQueryDiv_id_"+_pageRef ).remove();
			},
			open : function(data){
			}
		});
	
		$(queriesDialg).load(iFrameUrl,iFrameParams,
				function() 
				{
					$("#newQueryDiv_id_"+_pageRef ).dialog("open");
				});
	}
}

