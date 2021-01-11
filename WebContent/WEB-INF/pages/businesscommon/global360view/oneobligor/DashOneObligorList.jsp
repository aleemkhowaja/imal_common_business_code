<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
<ps:url id="urloneObligorListGrid" escapeAmp="false" action="OneObligorListAction_loadOneObligorGrid" namespace="/path/oneObligor">
   <ps:param name="iv_crud"  value="ivcrud_${_pageRef}"></ps:param>
   <ps:param name="_pageRef" value="_pageRef"></ps:param>
</ps:url>
<psjg:grid
	id               ="oneObligorListGridTbl_Id_${_pageRef}"
	caption          =" "
    href             ="%{urloneObligorListGrid}"
    dataType         ="json"
    hiddengrid       ='%{iv_crud== "R"}'
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
    ondblclick       ="oneObligorList_onDbClickedEvent()"
    addfunc          ="oneObligorList_onAddClicked"
    shrinkToFit      ="false" height="125">
     
    <psjg:gridColumn id="myCIfNOAlias" colType="number" name="myCIfNOAlias" index="myCIfNOAlias" title="" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="SHORT_NAME_ENG" colType="text" name="SHORT_NAME_ENG" index="SHORT_NAME_ENG" title="" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="BANK_EXP_DTE" colType="date" name="BANK_EXP_DTE" index="BANK_EXP_DTE" title="" editable="false" sortable="true" search="true" />
     	
</psjg:grid>
<div id="oneObligorListMaintDiv_id_<ps:property value="_pageRef" escapeHtml="true"/>" style="width:100%;">
   <ps:if test='iv_crud == "R"'>   
      <%@include file="DashOneObligorMaint.jsp"%>
   </ps:if>     
</div>
<script  type="text/javascript">
    $.struts2_jquery.require("DashOneObligorList.js,DashOneObligorMaint.js" ,null,jQuery.contextPath+"+/businesscommon/js/global360view/oneobligor/");
    $("#gview_oneObligorListGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
</script>