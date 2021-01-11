function dynamicTemplate_nodeAddClicked(params)
{debugger;
	var appName = $("#lookuptxt_newLblApp_Labeling").val()
	
	if(appName != null && appName != 'undefiend' && appName != "")
	{
		var dtId = $("#dynTempId_" + _pageRef).val();
			
		var params1 = {};
		params1["dynTemplateCO.dynTemplateNodesVO.NODE_ID"] = params.attr("nodeCode");
		params1["dynTemplateCO.dynTemplateNodesVO.PARENT_NODE_ID"] = params.attr("parentNodeCode");
			
		url = jQuery.contextPath
				+ "/path/dynamicTemplate/dynamicTemplateMaintAction_retrieveSelectNodesDesc.action?dtId="
				+ dtId;
		$.post(url,params1, function(param)
		{
			mySrc = jQuery.contextPath
			+ "/path/dynamicTemplate/dynamicTemplateMaintAction_openNodeDetails.action";
			$('#openNodeDetailsPopup_'+_pageRef).load(mySrc, {"dynTemplateCO.dynTemplateNodesVO.PARENT_NODE_ID":param.dynTemplateCO.dynTemplateNodesVO.NODE_ID}, function()
		                {
		               });
				$('#openNodeDetailsPopup_'+_pageRef).dialog('open');
			});
	
		}
	}
	
function dynamicTemplate_nodeDblClicked(params)
{debugger;
	var dtId = $("#dynTempId_" + _pageRef).val();
	
	url = jQuery.contextPath
			+ "/path/dynamicTemplate/dynamicTemplateMaintAction_retrieveSelectNodesDesc.action?dtId="
			+ dtId;
	$.post(url,params, function(param)
	{debugger;
		mySrc = jQuery.contextPath
		+ "/path/dynamicTemplate/dynamicTemplateMaintAction_openNodeDetails.action";
		if(typeof param.dynTemplateCO.dynTemplateNodesVO.NODE_DESC == "undefined")
		{
			param.dynTemplateCO.dynTemplateNodesVO.NODE_DESC = "";
		}
		if(typeof param.dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_ID == "undefined")
		{
			param.dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_ID = "";
		}
		if(typeof param.dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_DESC == "undefined")
		{
			param.dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_DESC = "";
		}
		$('#openNodeDetailsPopup_'+_pageRef).load(mySrc, {"dynTemplateCO.dynTemplateNodesVO.NODE_ID":param.dynTemplateCO.dynTemplateNodesVO.NODE_ID,"dynTemplateCO.dynTemplateNodesVO.PARENT_NODE_ID":param.dynTemplateCO.dynTemplateNodesVO.PARENT_NODE_ID,"dynTemplateCO.dynTemplateNodesVO.NODE_DESC":param.dynTemplateCO.dynTemplateNodesVO.NODE_DESC,"dynTemplateCO.dynTemplateNodesVO.NODE_TYPE":param.dynTemplateCO.dynTemplateNodesVO.NODE_TYPE,"dynTemplateCO.dynTemplateNodesVO.SCREEN_ID":param.dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_ID,"dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_DESC":param.dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_DESC}, function()
                {debugger;
               });
		$('#openNodeDetailsPopup_'+_pageRef).dialog('open');
	});
}

function reloadDynamicTemplateTree()
{
	var dtId = $("#dynTempId_" + _pageRef).val();
	var dynTempAppName = $("#lookuptxt_newLblApp_Labeling").val();
	var reloadParams = {};
	reloadParams["dtId"] = dtId;
	reloadParams["dynTempAppName"] = dynTempAppName;
	
	$("#DynTempTree").jstree("path_change_setting",
			{url: jQuery.contextPath+"/path/dynamicTemplate/dynamicTemplateMaintAction_loadTree"
			,data: reloadParams});
			// calling the refresh of the tree (the tree will be collapsed if  openAllOnRefresh is not true)
			$("#DynTempTree").jstree("refresh");

}

function dynTempPopup_okProcess()
{
	var parentNodeId = $("#parentNodeId_").val();
	$('#openNodeDetailsPopup_'+_pageRef).dialog("destroy").appendTo("#dynamicTemplateMaintFormId_" +_pageRef);
	var form = $("#dynamicTemplateMaintFormId_" + _pageRef).serializeForm();
	var actionUrl = jQuery.contextPath	+ "/path/dynamicTemplate/dynamicTemplateMaintAction_saveNew.action";
	var params = {};
	_showProgressBar(true);
	
	$.ajax( {
		url : actionUrl,
		type : "post",
		dataType : "json",
		data : form,
		success : function(param) {
		
				//empty form
				reloadUrl = jQuery.contextPath + "/path/dynamicTemplate/dynamicTemplateMaintAction_retrieveSelectedDynTempId.action";
				var ivCrud = returnHtmlEltValue("iv_crud_"+ _pageRef);
				var reloadParams = {};
				reloadParams["iv_crud"] = ivCrud;
				reloadParams["_pageRef"] = _pageRef;
				reloadParams["dtId"] = param.dynTemplateCO.dynTemplateVO.DYN_TEMP_ID
				$.post(reloadUrl,
								reloadParams,
								function(param) 
								{
									$("#dynamicTemplateListMaintDiv_id_"+ _pageRef).html(param);
									//reload grid
									$("#dynamicTemplateListGridTbl_Id_" + _pageRef).trigger("reloadGrid");

								}, "html");
			
				if (typeof param["_error"] == "undefined"
					|| param["_error"] == null) 
				{
					_showProgressBar(false);
					_showErrorMsg(record_saved_Successfully_key,info_msg_title,300,100);
				}
				else
				{	debugger;
					$("#dynamicTemplateListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
					_showProgressBar(false);
				}
		}
	});
	
}

function dynamicTemplate_nodeDelClicked(params) 
{
	var appName = $("#lookuptxt_newLblApp_Labeling").val()
	
	if(appName != null && appName != 'undefiend' && appName != "")
	{
		var actionUrl = jQuery.contextPath
				+ "/path/dynamicTemplate/dynamicTemplateMaintAction_deleteNode.action";
		var reloadparams = {};
		reloadparams["dynTemplateCO.dynTemplateNodesVO.NODE_ID"] = params.attr("nodeCode");
		reloadparams["dynTemplateCO.dynTemplateNodesVO.PARENT_NODE_ID"] = params.attr("parentNodeCode");
		reloadparams["dynTemplateCO.dynTemplateNodesVO.DYN_TEMP_ID"] = $("#dynTempId_" + _pageRef).val();
		_showProgressBar(true);
		$
				.ajax({
					url : actionUrl,
					type : "post",
					dataType : "json",
					data : reloadparams,
					success : function(param) {
						if (typeof param["_error"] == "undefined"
								|| param["_error"] == null) {
							//empty form
							reloadUrl = jQuery.contextPath
									+ "/path/dynamicTemplate/dynamicTemplateMaintAction_retrieveSelectedDynTempId.action";
							var ivCrud = returnHtmlEltValue("iv_crud_" + _pageRef);
							var reloadParams = {};
							reloadParams["iv_crud"] = ivCrud;
							reloadParams["_pageRef"] = _pageRef;
							reloadParams["dtId"] = param.dynTemplateCO.dynTemplateNodesVO.DYN_TEMP_ID
							$.post(reloadUrl, reloadParams, function(param) {
								$("#dynamicTemplateListMaintDiv_id_" + _pageRef).html(param);
								//reload grid
								$("#dynamicTemplateListGridTbl_Id_" + _pageRef).trigger("reloadGrid");
								_showProgressBar(false);
								_showErrorMsg(record_was_Deleted_Successfully_key,
										info_msg_title, 300, 100);
							}, "html");
	
						} else {
							_showProgressBar(false);
						}
					}
				});
		}
}


function dynTempMaint_Preview()
{
		var	openPrieviewDiv = $("<div id='openPreviewPopup_"+_pageRef+"' class='path-common-sceen'></div>");
		openPrieviewDiv.css("padding","0");
		openPrieviewDiv.insertAfter($('body'));
		
		mySrc = jQuery.contextPath
		+ "/path/dynamicTemplate/dynamicTemplateMaintAction_loadTemplatePage.action";
		var appName = $("#lookuptxt_newLblApp_Labeling").val();
		var param = {'_pageRef':_pageRef,
					 'dynTempAppName':appName,
					 'criteria.dynAlertSource':'true'
					};

		var _dialogOptions = {modal:true, 
				                  title: (typeof prv_sel_rep_key === "undefined")?"Preview" :prv_sel_rep_key ,
				                  autoOpen:false,
				                  show:'slide',
				                  width:returnMaxWidth(850),
				                  height:returnMaxHeight(850),
				                  position:'center', 
				                  close: function (){
									     var theDialog = $(this);
									     theDialog.dialog("destroy");
									     theDialog.remove();
									    }
			    		         };
		
		$('#openPreviewPopup_'+_pageRef).load(mySrc,param, function()
                {
               });
		$('#openPreviewPopup_'+_pageRef).dialog(_dialogOptions);
		$('#openPreviewPopup_'+_pageRef).dialog('open');
}

function destroyf()
{
	$('#openPreviewPopup_'+_pageRef).dialog('destroy');
}

function drawListElement(jsonElement,params)
{
	debugger;
	for(var j = 0;j<jsonElement.length;j++)
	{
		drawElement(jsonElement[j],j,params);
	}
	
	debugger;
	 $('.TreenodeClass'+_pageRef).each(function( i ) {
		 debugger;
	    console.log(this.id);
	    var jId = this.id;
	    
	    
	    	    
//		    if(!jId.startsWith("subDiv") && !jId.startsWith("destinationDivContainer"))
		if(!jId.startsWith("subDiv"))
	    {
	    	console.info("111111", jId);
	    	$('#'+jId).collapsiblePanel();
	    }
	    if(jId.startsWith("destinationDivContainer"))
	    {
	    	console.info("222222", jId);
	    	$('#'+jId+" .collapsibleContainerContent").attr("style","display: none;");
	    
	    }	

	    //$('#'+jId).collapsiblePanel();
	    //$('#'+jId).addClass("collapsed");
	  });
}

function drawElement(jsonElement,j,params)
{	
	debugger;
	var $appDiv = null;
	var $destinationDiv = null;
	if(jsonElement.attr.parentNodeCode == 'ROOT' )
	{
		$appDiv = $('#appContainer_'+j+_pageRef);
		$appDiv.attr('title', jsonElement.icon);
		$destinationDiv = $('#baseContainer_'+j+_pageRef);
		$destinationDiv.attr('title', "&nbsp;&nbsp" + jsonElement.data.title);
	}
	else
	{
		$destinationDiv = $('div [for="' + jsonElement.attr.nodeCode+j + '"]');
		if(jsonElement.attr.childrendisabeled == 'H')
		{
			$destinationDiv.attr('title', jsonElement.data.title);
		}
		else
		{
			$destinationDiv.attr('title', '&nbsp;' + jsonElement.data.title);
		}
	}
	
	for(var i = 0; i < jsonElement.children.length; i++)
	{
		var TreenodeClass = "TreenodeClass"+_pageRef;
		//var TreenodeClass = "collapsibleContainer"

		params["_pageRef"] = _pageRef ;
		params["fromId"] = i ;
		
		if(!(typeof jsonElement.children[i].checked == "undefined"))
		{
			$destinationDiv.append("<div for='" + jsonElement.children[i].attr.nodeCode+j + "' title='&nbsp;&nbsp;&nbsp;&nbsp;" + jsonElement.children[i].data.title + "' id='destinationDivContainer_" + jsonElement.children[i].attr.nodeCode+j+_pageRef +"' class=" + TreenodeClass + ">");
			$('#destinationDivContainer_'+ jsonElement.children[i].attr.nodeCode+j+_pageRef).append("<div id='subDiv_" + _pageRef+"_"+jsonElement.children[i].attr.nodeCode+"_"+j+ "' class='"+TreenodeClass+"'> </div>");
			$destinationDiv.append("</div>");
			
			var $subDestinationDiv = $('#subDiv_'+_pageRef+'_'+jsonElement.children[i].attr.nodeCode+"_"+j);
			var urlToCall = jQuery.contextPath+ jsonElement.children[i].checked;

			console.info(">>>", '#destinationDivContainer_'+ jsonElement.children[i].attr.nodeCode+j+_pageRef);
//				$('#destinationDivContainer_'+ jsonElement.children[i].attr.nodeCode+j+_pageRef).collapsiblePanel();
			//$('#destinationDivContainer_'+ jsonElement.children[i].attr.nodeCode+j+_pageRef+ " .collapsibleContainerTitle").click(loadInternalDivs($subDestinationDiv, urlToCall, params) );
			$('#destinationDivContainer_'+ jsonElement.children[i].attr.nodeCode+j+_pageRef).click({param1: urlToCall , param2:i}, 
					function (e) {
						debugger;
						console.log("XX<<<<<<<<<<: " + e.data.param1);
						console.log("yyyy<<<<<<<<<<: " + e.data.param2);
						var url = e.data.param1;
						var index = e.data.param2;
						var subDivID = $(this).children().children().get(2).id;//getting the id of each subdiv(grid container)
						if($("#"+subDivID).html().length <= 1) {
							params["fromId"] = index;//index of each grid
							$("#"+subDivID).empty().html("<table class='showLoading' width='100%'><tr><td>&nbsp;</td></tr></table>");//loading bar
							$("#"+subDivID).load(url ,params);//filling divs with Grid
						}
					});
			
							
			
			
			/*$('#destinationDivContainer_'+ jsonElement.children[i].attr.nodeCode+j+_pageRef+ " .collapsibleContainerTitle").click(
			function () {
				
				debugger;
				var productsChargesGridObjects = $("table[id^=accountChargesGrid_Id_"+_pageRef+"]");
				
				for (var i = 0, len = productsChargesGridObjects.length; i < len; i++) {//looping thru objects and extract ids and push to list
					
					var productsChargesGridId = (productsChargesGridObjects[i].id);
					
					$("#"+productsChargesGridId).jqGrid("setGridWidth",$("#"+productsChargesGridId).parent().parent().parent().parent().parent().parent().width());
					
				}
			} );*/
					
		
			//$subDestinationDiv.load(urlToCall,params);
		}
		else
		{
			$destinationDiv.append("<div for='" + jsonElement.children[i].attr.nodeCode+j + "' title=" + jsonElement.children[i].data.title + " id=" + jsonElement.children[i].attr.nodeCode+j+_pageRef +" class=" + TreenodeClass + "> </div>");
		}
		//drawElement(jsonElement.children[i],j,params);
		}
	}
	
function loadInternalDivs(divId, urlToCall, params)
{
	debugger;
	divId.load(urlToCall,params);
}

