<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
<ps:hidden name="iv_crud" id="iv_crud_${_pageRef}" />

<ps:url id="urlsegmentGroupingListGrid" escapeAmp="false" action="SegmentGroupingListAction_loadSegmentGroupingGrid" namespace="/path/grouping">
   <ps:param name="iv_crud"  value="ivcrud_${_pageRef}"></ps:param>
   <ps:param name="_pageRef" value="_pageRef"></ps:param>
</ps:url>
<psjg:grid
	id               ="segmentGroupingListGridTbl_Id_${_pageRef}"
	caption          =" "
    href             ="%{urlsegmentGroupingListGrid}"
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
    ondblclick       ="segmentGroupingList_onDbClickedEvent()"
    addfunc          ="segmentGroupingList_onAddClicked"
    shrinkToFit      ="false" height="125">
     
    <psjg:gridColumn id="GROUP_CODE" colType="text" name="ctsSegmentGroupingVO.GROUP_CODE" index="GROUP_CODE" title="%{getText('GROUP_CODE_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="DESCRIPTION" colType="text" name="ctsSegmentGroupingVO.DESCRIPTION" index="DESCRIPTION" title="%{getText('Description_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="PRIORITY" colType="text" name="ctsSegmentGroupingVO.PRIORITY" index="PRIORITY" title="%{getText('priority_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="statusDesc" colType="text" name="statusDesc" index="statusDesc" title="%{getText('STATUS_key')}" editable="false" sortable="true" search="true" />
     	
</psjg:grid>
<div id="segmentGroupingListMaintDiv_id_${_pageRef}" style="width:100%;">
   <ps:if test='iv_crud == "R"'>   
      <%@include file="SegmentGroupingMaint.jsp"%>
   </ps:if>     
</div>
<script  type="text/javascript">
	var Confirm_Save_Process_key = "<ps:text name='Confirm_Save_Process_key' />";
	var Confirm_Delete_key = "<ps:text name='Confirm_Delete_Process_key' />";
	var Confirm_Reject_Process_key = "<ps:text name='Confirm_Reject_Process_key' />";
	var Confirm_Approve_key = "<ps:text name='Confirm_Approve_Process_key' />";
	var deleted_successfully_key = "<ps:text name='deleted_successfully_key' />";
	var approved_successfully_key = "<ps:text name='approved_successfully_key' />";
	var Saved_Successfully_key = "<ps:text name='saved_successfully_key' />";

    $.struts2_jquery.require("SegmentGroupingList.js,SegmentGroupingMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/core/grouping/");
    $("#gview_segmentGroupingListGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
</script>