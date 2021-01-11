<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<script type="text/javascript">
	$.struts2_jquery.require("CustSegmentationMaint.js", null, jQuery.contextPath
			+ "/businesscommon/js/core/segmentation/");
</script>


<ps:url id="urlQueryDefPrioritiesGrid"
	action="CustSegmentationMaintAction_loadCustSegmentationGrid" namespace="/path/segmentation" escapeAmp="false">
</ps:url>


<ps:form id="segDefPrioritiesFormId_${_pageRef}" useHiddenProps="true" namespace="/path/segmentation" action="">

<ps:hidden id="methodName_${_pageRef}" />
<ps:hidden id="custSegmentationDetailList_Id_gridAllRecords_${_pageRef}" name ="custSegmentationDetailList_Id_gridAllRecords"/>
<ps:hidden id="custSegmentationDetailList_Id_gridUpdate_${_pageRef}" name ="custSegmentationDetailList_Id_gridUpdate" />

 <div id="segDefPrioritiesDiv_id_${_PageRef}" style="width: 100%;">
				
				<psjg:grid
			   	id="segDefPrioritiesGridTbl_Id_${_pageRef}"  
			   	dataType="json" 
			   	href="%{urlQueryDefPrioritiesGrid}" 
			   	pager="false" 
				filter="false"
			   	gridModel="gridModel" 
			   	rowNum="20" 
			   	rowList="5,10,15,20"
			    viewrecords="true" 
			    navigator="true"
			    editinline	="true" editurl=" "			    
			    navigatorAdd     ="false"
			    navigatorDelete  ="false"
			    navigatorEdit    ="true"			    
			    navigatorRefresh ="true"
				navigatorSearch  ="true"
				navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
				altRows="true"
			    height="350"			  
			    addfunc="segDefPriorities_onAddClicked"  
			    delfunc="segDefPriorities_onDeleteClicked"    
			    rownumbers="true">
				
				<psjg:gridColumn  id="segmentCode_ID" name="ctsSegmentVO.SEGMENT_CODE" title="%{getText('segmentcode_key')}" index="SEGMENT_CODE"
								  colType="number" editoptions="{ maxlength:'4' }" width="50" editable="false" sortable="true" search="true"/>
	
				<psjg:gridColumn id="segmentDesc_ID" colType="text" name="ctsSegmentVO.SEGMENT_DESC" title="%{getText('segmentdesc_key')}"   index="SEGMENT_DESC" 				
								 editable="false" sortable="false" search="false" width="150"/>
	
								
				<psjg:gridColumn  id="amended_priority_id" name="ctsSegmentVO.AMENDED_PRIORITY" title="%{getText('priority_key')}" index="AMENDED_PRIORITY"
								  colType="number" editoptions="{ dataEvents: [{ type: 'change', fn: function(e) { onChangingPriority(e) } }], maxlength: '4' }" width="50" editable="true" sortable="true" search="true"/>
				
				<psjg:gridColumn  id="priority_Id" name="ctsSegmentVO.PRIORITY" title="%{getText('priority_at_segment_level_key')}" index="PRIORITY"
								  colType="number" width="50" sortable="true" search="true" editable="false"/>
								  	  
				<psjg:gridColumn  id="priorityLevel_Id" name="priorityLevel" title="priority_at_segment_level_key" index="PRIORITY_LEVEL" hidden="true"
								  colType="number" width="50" editable="false" sortable="true" search="true"/>
				
			</psjg:grid>
			
			<ptt:toolBar id="segDefPrioritiesToolBar_${_pageRef}" hideInAlert="true">			
				<psj:submit id="segDefPriorituesSave_${_pageRef}" button="true"
					onclick="amendMethodName('saveSegDefPriorities')">
					<ps:label key="btn.save" for="segDefPriorituesSave_${_pageRef}" />
				</psj:submit>			
			
			</ptt:toolBar>
			
		</div>
</ps:form>



<script type="text/javascript">
$(document).ready(function() {
	$("#segDefPrioritiesFormId_"+_pageRef).processAfterValid("saveSegDefPriorities",{});
});	
</script>