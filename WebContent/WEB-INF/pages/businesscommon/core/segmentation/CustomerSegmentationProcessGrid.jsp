<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>


<ps:set name="approve_key" value="%{getEscText('approve_key')}"/>
<ps:set name="reject_key" value="%{getEscText('reject_key')}"/>
<ps:set name="permanent_reject_key" value="%{getEscText('permanent_reject_key')}"/>

<ps:url id="urlcustSegmentationProcessGrid" escapeAmp="false" 
	action="CustSegmentationListAction_loadCustSegmentationProcessGrid" namespace="/path/segmentation">
   <ps:param name="criteria.ivCrud"  value="iv_crud"></ps:param> 
   <ps:param name="_pageRef" value="_pageRef"></ps:param>
   <ps:param name="criteria.fromBranch" value="custSegmentationSC.fromBranch" ></ps:param>
   <ps:param name="criteria.toBranch" value="custSegmentationSC.toBranch" ></ps:param>
   <ps:param name="criteria.fromCif" value="custSegmentationSC.fromCif" ></ps:param>
   <ps:param name="criteria.toCif" value="custSegmentationSC.toCif" ></ps:param>
   <ps:param name="criteria.processType" value="custSegmentationSC.processType" ></ps:param>
</ps:url>


<%-- <psjg:grid id="custSegmentationProcessList_Id_${_pageRef}" caption=" " rownumbers="true"
				href="%{urlcustSegmentationProcessGrid}"
				dataType="json"
				pager="true" 
				filter="true"
				gridModel="gridModel"
				rowNum="5" 
				rowList="5,10,15,20" 
				viewrecords="true"
				navigator="true"
				height="145" 
				altRows="true"
				navigatorRefresh="false"
				pagerButtons="false" 
				navigatorEdit="false"
				navigatorSearch="true"
				navigatorAdd="false"
				navigatorDelete="false"
				editurl="abc" editinline="true" shrinkToFit="true"
				onCompleteTopics="turnOffProgressbar"> --%>
			
		<psjg:grid 
		id="custSegmentationProcessList_Id_${_pageRef}"
		caption=" "
		href="%{urlcustSegmentationProcessGrid}"
		dataType="json"
		pager="true"
		sortable="false"
		filter="true"
		gridModel="gridModel"
		rowNum="10"
		rowList="5,10,15,20"
		viewrecords="true"
		navigator="true"
		navigatorAdd="false"
		navigatorDelete="false"
		editinline="false"
		editurl="abc"
		navigatorEdit="false"
		navigatorRefresh="true"
		navigatorSearch="false"
		navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
		altRows="true"
		height="200"
		shrinkToFit="true"
		onGridCompleteTopics="turnOffProgressbar" 
		>		
			
			
	<psjg:gridColumn id="branchCode_${_pageRef}"  	colType="number" 	name="branchCode"  
			index="branchCode" 	title="%{getText('branch_key')}" 
			editable="false" sortable="true" search="true"/>
			
	<psjg:gridColumn id="CIF_NO_${_pageRef}"  	colType="number" 	name="ctsSegmentCifExResVO.CIF_NO"  
			index="CIF_NO" 	title="%{getText('cif_no_key')}" 
			editable="false" sortable="true" search="true"/>
			
 	<psjg:gridColumn id="RECOMMENED_SEGMENT_${_pageRef}"  	colType="number" 	name="ctsSegmentCifExResVO.RECOMMENED_SEGMENT"
 			index="RECOMMENED_SEGMENT" 	title="%{getText('recommened_segment_key')}"
 			editable="false" sortable="true" search="true"/>
	
 	<psjg:gridColumn id="recomendedPriority_${_pageRef}"  	colType="number" 	name="recomendedPriority" 
 			index="recomendedPriority" 	title="%{getText('recommened_segment_priority_key')}" 
 			editable="false" sortable="true" search="true"/>
 			
	<psjg:gridColumn id="RECOMMENED_GROUP_${_pageRef}"  	colType="number" 	name="recommendedGroupCode"
 			index="recommendedGroupCode" 	title="%{getText('recommened_group_key')}"
 			editable="false" sortable="true" search="true"/> 	
 	
 	<psjg:gridColumn id="CRITERIA_${_pageRef}"  	colType="number" 	name="CRITERIA"
 			index="CRITERIA" 	title="%{getText('matched_criteria_key')}"
 			editable="false" sortable="true" search="true"/> 
 								
 	<psjg:gridColumn id="currentSegment_${_pageRef}"  	colType="number" 	name="currentSegment" 
 			index="currentSegment" 	title="%{getText('current_segment_key')}"
 			editable="false" sortable="true" search="true"/>
			
	<psjg:gridColumn id="currentPriority_${_pageRef}"  	colType="number" 	name="currentPriority" 
 			index="currentPriority" 	title="%{getText('current_segment_priority_key')}"
 			editable="false" sortable="true" search="true"/>
	
	<psjg:gridColumn id="currentGroupCode_${_pageRef}"  	colType="number" 	name="currentGroupCode"
 			index="currentGroupCode" 	title="%{getText('current_group_key')}"
 			editable="false" sortable="true" search="true"/> 	
 				
 	<psjg:gridColumn id="CREATED_DATE_${_pageRef}" colType="date" name="ctsSegmentCifExResVO.CREATED_DATE"  
 			index="CREATED_DATE" title="%{getText('date_of_classification_key')}" 
 			editable="false" sortable="true" search="true" searchoptions="{dataInit:function(elem){initDatePicker(elem,'dd/mm/yy','false')}}"/>
 			
 	 	<psjg:gridColumn id="RECOMMENDED_DATE_${_pageRef}" colType="date" name="recommendedDate"  
 			index="recommendedDate" title="%{getText('date_of_recommendation_key')}" 
 			editable="false" sortable="true" search="true" searchoptions="{dataInit:function(elem){initDatePicker(elem,'dd/mm/yy','false')}}"/>		
 			
 	<psjg:gridColumn id="STATUS_${_pageRef}" colType="text" name="ctsSegmentCifExResVO.STATUS"
 			index="STATUS" title="%{getText('status_key')}" 
 			editable="false" sortable="true" search="true" hidden="true"/>
		
<ps:if test='%{_pageRef == "CSG00SEGSPP"}'>
 	<psjg:gridColumn name="approveButton" index="approveButton" title="" align="center"
 					colType="text"  editable="false"  sortable="false" search="false"
 					formatter="custSegProcess_approveButton" />
					
	<psjg:gridColumn name="rejectButton" index="rejectButton" title="" align="center"
					colType="text"  editable="false"  sortable="false" search="false"
					formatter="custSegProcess_rejectButton" />
					
	<psjg:gridColumn name="permanentRejectButton" index="permanentRejectButton" title="" align="center"
					colType="text"  editable="false"  sortable="false" search="false"
					formatter="custSegProcess_permanentRejectButton" />
</ps:if>			
			
</psjg:grid>

<script type="text/javascript">
var approve_key	= "${approve_key}";
var reject_key	= "${reject_key}";
var permanent_reject_key = "${permanent_reject_key}";
$(document).ready(function() {					
							$.struts2_jquery.require("CustSegmentationMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/core/segmentation/");
						});
$.subscribe("turnOffProgressbar",function(){_showProgressBar(false);});
						
</script>`