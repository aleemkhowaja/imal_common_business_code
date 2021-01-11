<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<script  type="text/javascript">

 $.struts2_jquery.require("CustSegmentationList.js,CustSegmentationMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/core/segmentation/");
 
</script>

<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />

<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
<ps:hidden id="iv_crud_${_pageRef}" name="iv_crud" />


<ps:url id="urlcustSegmentationListGrid" escapeAmp="false" action="CustSegmentationListAction_loadCustSegmentationGrid" namespace="/path/segmentation">
   <ps:param name="iv_crud"  value="ivcrud_${_pageRef}"></ps:param>
   <ps:param name="_pageRef" value="_pageRef"></ps:param>
</ps:url>
<psjg:grid
	id               ="custSegmentationListGridTbl_Id_${_pageRef}"
	caption          =" "
    href             ="%{urlcustSegmentationListGrid}"
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
    ondblclick       ="custSegmentationList_onDbClickedEvent()"
    addfunc          ="custSegmentationList_onAddClicked"
    shrinkToFit      ="true" height="125">
    
    <ps:set name="segmentcodeid_key" value="%{getText('segmentcode_key')}" />
     <ps:set name="segmentdescid_key" value="%{getText('segment_desc_key')}" />
     
     <ps:if test='_pageRef.contains("CSC00SC")'>
     	<ps:set name="segmentcodeid_key" value="%{getText('score_code_key')}" />
     </ps:if>
     <ps:if test='_pageRef.contains("CSC00SC")'>
     	<ps:set name="segmentdescid_key" value="%{getText('score_desc_key')}" />
     </ps:if>
     
     <ps:if test='_pageRef.contains("BR00")'>
     	<ps:set name="segmentcodeid_key" value="%{getText('bsn_rule_cod_key')}" />
     </ps:if>
     <ps:if test='_pageRef.contains("BR00")'>
     	<ps:set name="segmentdescid_key" value="%{getText('bsn_rul_desc_key')}" />
     </ps:if>
     
    <psjg:gridColumn id="SEGMENT_CODE"   colType="text" name="ctsSegmentVO.SEGMENT_CODE" index="SEGMENT_CODE" title="${segmentcodeid_key}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="SEGMENT_DESC"  colType="text" name="ctsSegmentVO.SEGMENT_DESC" index="SEGMENT_DESC" title="${segmentdescid_key}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="statusdesc"         colType="text" name="statusdesc" index="statusdesc" title="%{getText('STATUS_key')}" editable="false" sortable="true" search="true" />
	<psjg:gridColumn id="OLD_STATUS"     colType="text"  hidden="true" name="oldstatusdesc" index="OLD_STATUS" title="%{getText('old_status_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="CREATED_BY"     colType="text"  hidden="true" name="ctsSegmentVO.CREATED_BY" index="CREATED_BY" title="%{getText('Created_By_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="DATE_CREATED"   colType="date" hidden="true" name="ctsSegmentVO.DATE_CREATED" index="DATE_CREATED" title="%{getText('date_created_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="DATE_UPDATED"   colType="date" hidden="true" name="ctsSegmentVO.DATE_UPDATED" index="DATE_UPDATED" title="%{getText('date_updated_key')}" editable="false" sortable="true" search="true" />
     	
</psjg:grid>



<div id="custSegmentationListMaintDiv_id_${_pageRef}" style="width:100%;">
	 <ps:if test='iv_crud == "R"'> 
      <%@include file="CustSegmentationMaint.jsp"%>
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
	var Confirm_Suspend_key = "<ps:text name='Confirm_Suspend_key' />";
	var Suspended_Successfully_key = "<ps:text name='suspended_successfully_key' />";
	var Confirm_Reactivate_Process_key = "<ps:text name='Confirm_Reactivate_key' />";
	var Reactivated_Successfully_key = "<ps:text name='reactivated_successfully_key' />";
	var confirm_cancel_process_key = "<ps:text name='Confirm_Cancel_key' />";
	var Canceled_Successfully_key = "<ps:text name='canceled_successfully_key' />";
		
    $("#gview_custSegmentationListGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
</script>