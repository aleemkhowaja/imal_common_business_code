<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:set name="ivcrud_${_pageRef}"    value="iv_crud"/>
<ps:hidden id="iv_crud_${_pageRef}"  name="iv_crud"/>
<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
<ps:url id="urldynamicTemplateConventionListGrid" escapeAmp="false" action="DynamicTemplateConvListAction_loadDynamicTemplateConvGrid" namespace="/path/dynamicTemplate">
   <ps:param name="iv_crud"  value="ivcrud_${_pageRef}"></ps:param>
   <ps:param name="_pageRef" value="_pageRef"></ps:param>
</ps:url>
<psjg:grid
	id               ="dynamicTemplateConventionListGridTbl_Id_${_pageRef}"
	caption          =" "
    href             ="%{urldynamicTemplateConventionListGrid}"
    dataType         ="json"
    hiddengrid       ="true"
	pager            ="true"
	sortable         ="true"
	filter           ="true"
	gridModel        ="gridModel"
	rowNum           ="5"
	rowList          ="5,10,15,20"
    viewrecords      ="true"
    navigator        ="true"
    navigatorDelete  ="false"
    navigatorEdit    ="false"
    navigatorRefresh ="false"
    navigatorAdd     ="false"
    navigatorSearch  ="true"
    navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
    altRows          ="true"
    ondblclick       ="dynamicTemplateConventionList_onDbClickedEvent()"
    addfunc          ="dynamicTemplateConventionList_onAddClicked"
    autowidth="true">
	
	<psjg:gridColumn name="dynTempConvVO.CONVENTION_NUMBER" id="CONVENTION_NUMBER"
		searchoptions="{sopt:['eq','ne','lt','gt','le','ge']}"
		index="CONVENTION_NUMBER" colType="number" title="%{getText('convention_number_key')}"
		sortable="true" search="true" key="true" />
	<psjg:gridColumn name="entityDesc" id="ENTITY_DESC"
		searchoptions="{sopt:['eq','ne','bw','bn','ew','en','cn','nc']}"
		index="ENTITY_DESC" colType="text" title="%{getText('entity_key')}"
		sortable="true" />	
	<psjg:gridColumn name="statusDesc" id="STATUS_DESC"
		searchoptions="{sopt:['eq','ne','bw','bn','ew','en','cn','nc']}"
		index="STATUS_DESC" colType="text" title="%{getText('Status_key')}"
		sortable="true" />	
	<psjg:gridColumn id="ENTITY_TYPE" name="dynTempConvVO.ENTITY_TYPE"
		index="ENTITY_TYPE"
		searchoptions="{sopt:['eq','ne','bw','bn','ew','en','cn','nc']}"
		colType="text" title="%{getText('ENTITY_TYPE_key')}" editable="false"
		sortable="true" search="true" hidden="true"/>
	<psjg:gridColumn id="STATUS"
		searchoptions="{sopt:['eq','ne','bw','bn','ew','en','cn','nc']}"
		colType="text" name="dynTempConvVO.STATUS" index="STATUS"
		title="%{getText('STATUS_key')}" hidden="true" />
		
</psjg:grid>
<div id="dynamicTemplateConventionListMaintDiv_id_${_pageRef}" style="width:100%;">
 
      <%@include file="DynamicTemplateConventionMaint.jsp"%>
   
</div>
<script  type="text/javascript">
    $.struts2_jquery.require("DynamicTemplateConventionList.js,DynamicTemplateConventionMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/dynamictemplate/");
    $("#gview_dynamicTemplateConventionListGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
</script>