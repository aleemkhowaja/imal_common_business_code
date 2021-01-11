<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
<ps:url id="urldynamicTemplateListGrid" escapeAmp="false" action="DynamicTemplateListAction_loadDynamicTemplateGrid" namespace="/path/dynamicTemplate">
   <ps:param name="iv_crud"  value="ivcrud_${_pageRef}"></ps:param>
   <ps:param name="_pageRef" value="_pageRef"></ps:param>
</ps:url>
<psjg:grid
	id               ="dynamicTemplateListGridTbl_Id_${_pageRef}"
	caption          =" "
    href             ="%{urldynamicTemplateListGrid}"
    dataType         ="json"
    hiddengrid       ='true'
	pager            ="true"
	sortable         ="true"
	filter           ="true"
	gridModel        ="gridModel"
	rowNum           ="5"
	rowList          ="5,10,15,20"
    viewrecords      ="true"
    navigator        ="true"
    navigatorDelete  ="true"
    navigatorEdit    ="false"
    navigatorRefresh ="false"
    navigatorAdd     ="true"
    navigatorSearch  ="true"
    navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
    altRows          ="true"
    ondblclick       ="dynamicTemplateList_onDbClickedEvent()"
    addfunc          ="dynamicTemplateList_onAddClicked"
    delfunc			 ="dynamicTemplateList_onDelClicked"
    autowidth	     ="true">

	<psjg:gridColumn id="DYN_TEMP_ID" colType="number"
		name="dynTemplateVO.DYN_TEMP_ID" index="DYN_TEMP_ID"
		title="%{getText('ID_key')}" editable="false" sortable="true"
		search="true" key="true"/>
	<psjg:gridColumn id="APP_NAME" colType="text"
		name="dynTemplateVO.APP_NAME" index="APP_NAME"
		title="%{getText('application')}" editable="false" sortable="true"
		search="true" />
	<psjg:gridColumn id="APP_DESC" colType="text" name="APP_DESC"
		index="APP_DESC" title="%{getText('app_name_key')}" editable="false"
		sortable="true" search="true" />

</psjg:grid>
<div id="dynamicTemplateListMaintDiv_id_${_pageRef}" style="width:100%;">
   <ps:if test='iv_crud == "R"'>   
      <%@include file="DynamicTemplateMaint.jsp"%>
   </ps:if>     
</div>
<script  type="text/javascript">
    $.struts2_jquery.require("DynamicTemplateList.js,DynamicTemplateMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/dynamictemplate/");
    $("#gview_dynamicTemplateListGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
</script>