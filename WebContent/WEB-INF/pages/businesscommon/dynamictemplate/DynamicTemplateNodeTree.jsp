<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@taglib uri="/path-struts-tags" prefix="ps"%>
<%@taglib uri="/path-struts-jquery-tree-tags" prefix="psjt" %>

<ps:url id="getDataThruJson" action="dynamicTemplateMaintAction_loadTree" namespace="/path/dynamicTemplate" escapeAmp="false" >
	<ps:param name="_pageRef" value="_pageRef" />
	<ps:param name="dtId" value="dynTemplateCO.dynTemplateVO.DYN_TEMP_ID" />
	<ps:param name="dynTempAppName" value="dynTemplateCO.dynTemplateVO.APP_NAME" />
</ps:url>

<psjt:tree id="DynTempTree"
			openAllOnLoad="false"
			openAllOnRefresh="false"
			checkbox="false" 
			showThemeDots="true"
			showThemeIcons="true" 
			jstreetheme="default"
			href="%{getDataThruJson}"
			onClickTopics="treeClicked"
			disabled="false"
			enableAddNode="false"
			enableRemoveNode="false"
			enableRenameNode="false"
			ccp="false"
			addNodeKey="Insert_key"
			removeNodeKey="btn.remove"
			onDBlClickTopics="dynamicTemplate_nodeDblClicked"
			additionalContextMenuItems="'customFunc' : { 'label': 'Add Node', 'action': function (obj) { dynamicTemplate_nodeAddClicked(obj); }},
			 'custom_func' : { 'label': 'Delete Node', 'action':  function (obj) { dynamicTemplate_nodeDelClicked(obj); } }"
			/>
			
<script>
$("#DynTempTree").subscribe('treeClicked',function(event){ 
	console.log("id: " + event.originalEvent.data.rslt.obj.attr('id'));
	console.log("nodeCode: " + event.originalEvent.data.rslt.obj.attr('nodeCode'));
});
$("#DynTempTree").subscribe('dynamicTemplate_nodeDblClicked',function(event){ 
	var params = {};
	params["dynTemplateCO.dynTemplateNodesVO.NODE_ID"] = event.originalEvent.data.rslt.obj.attr('nodeCode');
	params["dynTemplateCO.dynTemplateNodesVO.PARENT_NODE_ID"] = event.originalEvent.data.rslt.obj.attr('parentNodeCode');
	dynamicTemplate_nodeDblClicked(params);
});
</script>
