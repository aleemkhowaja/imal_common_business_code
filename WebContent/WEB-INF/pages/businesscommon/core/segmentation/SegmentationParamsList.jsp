<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>


<ps:set var="queryParamGridPK" value='%{custSegmentationSC.queryParamGridPK + "_" +_pageRef}' />
<ps:set  var="procParamGridPK" value='%{custSegmentationSC.procParamGridPK + "_" +_pageRef}' />
<ps:set  var="segDetailRow" value='%{custSegmentationSC.segDetailRowId}' />
<ps:set  var="multiSelectlkpId" value='%{custSegmentationSC.multiSelectlkp}' />

<ps:hidden id="queryGridId" value="%{queryParamGridPK}"/>
<ps:hidden id="procGridId" value="%{procParamGridPK}"/>
<ps:hidden id="segDetailRowId" value="%{segDetailRow}"/>

<ps:hidden id="_criteriaCode_" name ="custSegmentationSC.criteria_code"/>

<script type="text/javascript">
$.struts2_jquery.require("SegmentationParamsList.js", null, jQuery.contextPath+ "/businesscommon/js/core/segmentation/");
</script>

   <!-- <ps:textfield id="_criteriaCode_" name="custSegmentationSC.criteria_code" /> -->

	<ps:url id="urlQueryParamGrid" action="CustSegmentationListAction_loadSegParamGrid?criteria.ENTITY_TYPE=Q" namespace="/path/segmentation" escapeAmp="false">
		<ps:param name="criteria.criteria_code" value="%{custSegmentationSC.criteria_code}"></ps:param>
		<ps:param name="criteria.segment_code" value="%{custSegmentationSC.segment_code}"></ps:param>
		<ps:param name="criteria.lineNo" value="%{custSegmentationSC.lineNo}"></ps:param>
		<ps:param name="criteria.progRef" value="%{custSegmentationSC.progRef}"></ps:param>
	</ps:url>

          <table>
			<tr>
			   <td class="fldLabelView" >
					<ps:label key="query_code_key" id="queryCode_${_pageRef}" for="lookuptxt_queryCode_${_pageRef}" />
				</td>
				<td>
					<psj:livesearch id="queryCode_${_pageRef}"
						name="queryID" mode="number"
						actionName="${pageContext.request.contextPath}/pathdesktop/AuthSignatoriesLookup_constructLookup"
						resultList="cifAuthSignatoryVO.AUTH_CIF_NO:lookuptxt_authCIFNo_${_pageRef}${secondaryId},cifAuthSignatoryVO.AUTH_NAME:authCifDesc_${_pageRef}"
						searchElement="CIF_NO" readOnlyMode="true"
						maxlength="12" autoSearch="false"
						paramList="cifNo:_signCIFCode_${_pageRef}"
						parameter="signatureCO.cifObjectVO.AUTH_CIF_NO:lookuptxt_authCIFNo_${_pageRef}${secondaryId},signatureCO.cifVO.CIF_NO:_signCIFCode_${_pageRef}"
						dependencySrc="${pageContext.request.contextPath}/path/signature/Signature_dependencyByAuthCifNo"
						dependency="lookuptxt_authCIFNo_${_pageRef}${secondaryId}:signatureCO.cifObjectVO.AUTH_CIF_NO,
									authCifDesc_${_pageRef}:signatureCO.authCifDesc"
						leadZeros="8"
						>
					</psj:livesearch>
				</td>
				<td colspan="3">
					<ps:textfield id="queryCodeDesc_${_pageRef}${secondaryId}"
						name="signatureCO.authCifDesc" readonly="true" />
				</td>
			</tr>
			
			</table>

			<psjg:grid id="%{#queryParamGridPK}" altRows="true"
				caption=" " dataType="json" editurl="TTT" editinline="true"
				filter="false" gridModel="gridModel" href="%{urlQueryParamGrid}"
				height="200" multiselect="false" navigator="false"
				navigatorEdit="false" navigatorRefresh="true"
				navigatorSearch="false"
				onEditInlineBeforeTopics="segmentationQueryParam_onEditInlineBeforeTopics"
				navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
				pager="true" pagerButtons="false" rownumbers="true" rowNum="5"
				rowList="5,10,15,20" sortable="false" shrinkToFit="false"
				viewrecords="true"
				onGridCompleteTopics="fillQryMultiSelectJsonArray"
				>
				<psjg:gridColumn name="ctsSegmentParamVO.PARAM_NAME"
					title="%{getText('param_name_key')}" index="PARAM_NAME"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_NAME" />
				<psjg:gridColumn id="PARAM_CLASS" colType="select" edittype="select"
					width="200" formatter="select"
					name="ctsSegmentParamVO.PARAM_CLASS" index="PARAM_CLASS"
					title="%{getText('param_class_key')}" editable="true"
					sortable="false" search="false" 
					editoptions="{ 
  value:function() {  return loadCombo('${pageContext.request.contextPath}/path/criteria/criteriaMaint_loadAvaBenefStatusSelect','criteriaUsageList', 'code', 'descValue');}  
 ,dataEvents: [{ type: 'change', fn: function(e) { onEditInlineBeforeTopcics_addParamQuery('${_entityType}'); } }]
					              
					              }" />
					              
				<psjg:gridColumn id="QUERY_ID" 	colType="liveSearch"
					name="ctsSegmentParamVO.PARAM_QUERY_ID" 	index="QUERY_ID" 	
					resultList="queryId:ctsSegmentParamVO.PARAM_QUERY_ID_lookuptxt" 
					editable="true" sortable="false" search="false" width="200" 
					dataAction="${pageContext.request.contextPath}/pathdesktop/QueryIdLookup_constructLookup"
					paramList=""
					title="%{getText('queryid_key')}"
					params="queryIdSC.queryId:ctsSegmentParamVO.PARAM_QUERY_ID_lookuptxt"
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/QueryIdDependencyAction_dependencyByQueryId"
					dependency="queryIdCO.queryId:ctsSegmentParamVO.PARAM_QUERY_ID"
					editoptions="{ dataEvents: [{ type: 'change', fn: function(e) { onChangeParamQuery('Q'); } }]
					              }"
				/>
				
				<psjg:gridColumn id="segSelectParameterDetails" colType="text"
					name="segSelectParameterDetails" index="segSelectParameterDetails" title="%{getText('parameter_details_key')}"
					editable="false" sortable="false" search="false"
					formatter="segSelectParamDetailsbtnQuery"  />
		
				<psjg:gridColumn id="querySelectParamGridStr" colType="text"
					name="querySelectParamGridStr" index="querySelectParamGridStr" title=""
					editable="false" sortable="false" search="false" hidden="true" />
				
				<psjg:gridColumn id="jsonMultiselectArrayTest" colType="text" index="jsonMultiselectArrayTest" 
					name="jsonMultiselectArray_%{multiSelectlkpId}" title="%{getText('multi_selected_key')}" editable="true"
					sortable="true" search="true" width="150" hidden="true" />
				
				<psjg:gridColumn id="jsonMultiselectArray" colType="text" index="jsonMultiselectArray" 
					name="jsonMultiselectArray" title="%{getText('multi_selected_key')}" editable="true"
					sortable="true" search="true" width="150" hidden="true" />
				
				<psjg:gridColumn id="multiSelectlkp" 	colType="liveSearch"   
					name="%{multiSelectlkpId}" 	index="multiSelectlkp" 
					multiSelect 	= "true" 	multiResultInput ="jsonMultiselectArray_%{multiSelectlkpId}"
					selectColumn ="PARAM_VALUE" 
					editable="true" sortable="true" search="true" width="200"
					dataAction="${pageContext.request.contextPath}/path/segmentation/CustSegmentationListAction_constructQryMultiSelect"
					paramList="queryId:ctsSegmentParamVO.PARAM_QUERY_ID,segment_code:ctsSegmentParamVO.SEGMENT_CODE,criteriaCode:criteriaCode,criteriaEntityId:ctsSegmentParamVO.ENTITY_ID,querySelectParamGridStr:querySelectParamGridStr,isSegmentationScore:isSegmentationScore"
					title="%{getText('multi_value_key')}"
				/>	              

				<psjg:gridColumn id="SESSION_ATTR_NAME" colType="select"
					edittype="select" width="200" formatter="select"
					name="ctsSegmentParamVO.SESSION_ATTR_NAME"
					index="SESSION_ATTR_NAME"
					title="%{getText('session_attr_name_key')}" editable="true"
					sortable="false" search="false"
					editoptions="{ 
  value:function() {  return loadCombo('${pageContext.request.contextPath}/path/criteria/criteriaMaint_loadSessionAttrNameSelect','sessionAttrList', 'code', 'descValue');}  }" />
 

				<psjg:gridColumn id="PARAM_VALUE" colType="text" width="200"
					name="ctsSegmentParamVO.PARAM_VALUE" index="PARAM_VALUE" 
					title="%{getText('param_value_key')}" editable="true"
					sortable="false" search="false" editoptions="{ maxlength:'15'}"  />
					
				<psjg:gridColumn name="ctsSegmentParamVO.PARAM_ORDER"
					title="%{getText('param_order_key')}" index="PARAM_ORDER"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_ORDER" />
				<psjg:gridColumn name="ctsSegmentParamVO.PARAM_TYPE"
					title="%{getText('param_type_key')}" index="PARAM_TYPE"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_TYPE" />
				
				<psjg:gridColumn id="SEGMENT_CODE" colType="number"
					name="ctsSegmentParamVO.SEGMENT_CODE" index="SEGMENT_CODE" title=""
					editable="true" sortable="false" search="false" hidden="true" />	
					
				<psjg:gridColumn id="CRITERIA_CODE" colType="number"
					name="criteriaCode" index="CRITERIA_CODE" title=""
					editable="true" sortable="false" search="false" hidden="true" />
					
				<psjg:gridColumn id="ENTITY_ID" colType="number"
					name="ctsSegmentParamVO.ENTITY_ID" index="ENTITY_ID" title=""
					editable="true" sortable="false" search="false" hidden="true" />
					
				<psjg:gridColumn id="QUERY_ID_OLD" colType="number"
				name="oldQueryIdParam" index="QUERY_ID_OLD" title=""
				editable="false" sortable="false" search="false" hidden="true" />	
				
				<psjg:gridColumn name="isSegmentationScore"
					title="" index="isSegmentationScore"
					colType="text" editable="false" sortable="false" search="false" hidden="true"
					id="isSegmentationScore" />
					
				<psjg:gridColumn id="isOpened" name="isOpened"
					title="" index="isOpened"
					colType="text" editable="false" sortable="false" search="false" hidden="true"
					 />	

			</psjg:grid>
			
		
		
			<ps:url id="urlProcParamGrid" action="CustSegmentationListAction_loadSegParamGrid?criteria.ENTITY_TYPE=P" namespace="/path/segmentation" escapeAmp="false">
				<ps:param name="criteria.criteria_code" value="%{custSegmentationSC.criteria_code}"></ps:param>
				<ps:param name="criteria.segment_code" value="%{custSegmentationSC.segment_code}"></ps:param>
				<ps:param name="criteria.lineNo" value="%{custSegmentationSC.lineNo}"></ps:param>
				<ps:param name="criteria.progRef" value="%{custSegmentationSC.progRef}"></ps:param>
			</ps:url>
			
			<psjg:grid id="%{#procParamGridPK}" altRows="true"
				caption=" " dataType="json" editurl="TTT" editinline="true"
				filter="false" gridModel="gridModel" href="%{urlProcParamGrid}"
				height="200" multiselect="false" navigator="false"
				navigatorEdit="false" navigatorRefresh="true"
				navigatorSearch="false"
				onEditInlineBeforeTopics="segmentationProcParam_onEditInlineBeforeTopics"
				navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
				pager="true" pagerButtons="false" rownumbers="true" rowNum="5"
				rowList="5,10,15,20" sortable="false" shrinkToFit="false"
				viewrecords="true" 
				onGridCompleteTopics="fillProcMultiSelectJsonArray">
				<psjg:gridColumn name="ctsSegmentParamVO.PARAM_NAME"
					title="%{getText('param_name_key')}" index="PARAM_NAME"
					colType="text" editable="false" sortable="false" search="true"
					id="PARAM_NAME" />
				<psjg:gridColumn id="PARAM_CLASS" colType="select" edittype="select"
					width="200" formatter="select"
					name="ctsSegmentParamVO.PARAM_CLASS" index="PARAM_CLASS"
					title="%{getText('param_class_key')}" editable="true"
					sortable="false" search="false" 
					editoptions="{ 
  value:function() {  return loadCombo('${pageContext.request.contextPath}/path/criteria/criteriaMaint_loadAvaBenefStatusSelect','criteriaUsageList', 'code', 'descValue');}  
 ,dataEvents: [{ type: 'change', fn: function(e) { onEditInlineBeforeTopcics_addParamProc('${_entityType}'); } }]
					              
					              }" />
				
				
				<psjg:gridColumn id="QUERY_ID" 	colType="liveSearch"
					name="ctsSegmentParamVO.PARAM_QUERY_ID" 	index="QUERY_ID" 	
					resultList="queryId:ctsSegmentParamVO.PARAM_QUERY_ID_lookuptxt" 
					editable="true" sortable="false" search="false" width="200" 
					dataAction="${pageContext.request.contextPath}/pathdesktop/QueryIdLookup_constructLookup"
					paramList=""
					title="%{getText('queryid_key')}"
					params="queryIdSC.queryId:ctsSegmentParamVO.PARAM_QUERY_ID_lookuptxt"
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/QueryIdDependencyAction_dependencyByQueryId"
					dependency="queryIdCO.queryId:ctsSegmentParamVO.PARAM_QUERY_ID"
					editoptions="{ dataEvents: [{ type: 'change', fn: function(e) { onChangeParamQuery('P'); } }]
					              }"
				/>
				
				<psjg:gridColumn id="segSelectParameterDetails" colType="text"
					name="segSelectParameterDetails" index="segSelectParameterDetails" title="%{getText('parameter_details_key')}"
					editable="false" sortable="false" search="false"
					formatter="segSelectParamDetailsbtnProc"  />
		
				<psjg:gridColumn id="querySelectParamGridStr" colType="text"
					name="querySelectParamGridStr" index="querySelectParamGridStr" title=""
					editable="false" sortable="false" search="false" hidden="true" />
				
				<psjg:gridColumn id="jsonMultiselectArrayTest" colType="text" index="jsonMultiselectArrayTest" 
					name="jsonMultiselectArray_%{multiSelectlkpId}" title="%{getText('multi_selected_key')}" editable="true"
					sortable="true" search="true" width="150" hidden="true" />
				
				<psjg:gridColumn id="jsonMultiselectArray" colType="text" index="jsonMultiselectArray" 
					name="jsonMultiselectArray" title="%{getText('multi_selected_key')}" editable="true"
					sortable="false" search="true" width="150" hidden="true" />
				
				<psjg:gridColumn id="multiSelectlkp" 	colType="liveSearch"   
					name="%{multiSelectlkpId}" 	index="multiSelectlkp" 
					multiSelect 	= "true" 	multiResultInput ="jsonMultiselectArray_%{multiSelectlkpId}"
					selectColumn ="PARAM_VALUE" 
					editable="true" sortable="false" search="true" width="200" 
					dataAction="${pageContext.request.contextPath}/path/segmentation/CustSegmentationListAction_constructQryMultiSelect"
					paramList="queryId:ctsSegmentParamVO.PARAM_QUERY_ID,criteriaCode:criteriaCode,criteriaEntityId:ctsSegmentParamVO.ENTITY_ID,querySelectParamGridStr:querySelectParamGridStr,isSegmentationScore:isSegmentationScore"
					title="%{getText('multi_value_key')}"
				/>	 
				
				<psjg:gridColumn id="SESSION_ATTR_NAME" colType="select"
					edittype="select" width="200" formatter="select"
					name="ctsSegmentParamVO.SESSION_ATTR_NAME"
					index="SESSION_ATTR_NAME"
					title="%{getText('session_attr_name_key')}" editable="true"
					sortable="false" search="false"
					editoptions="{ 
  value:function() {  return loadCombo('${pageContext.request.contextPath}/path/criteria/criteriaMaint_loadSessionAttrNameSelect','sessionAttrList', 'code', 'descValue');}  
 }" />
 


				<psjg:gridColumn id="PARAM_VALUE" colType="text" width="200"
					name="ctsSegmentParamVO.PARAM_VALUE" index="PARAM_VALUE" 
					title="%{getText('param_value_key')}" editable="true"
					sortable="false" search="false" editoptions="{ maxlength:'15'}"  />
					
				<psjg:gridColumn name="ctsSegmentParamVO.PARAM_ORDER"
					title="%{getText('param_order_key')}" index="PARAM_ORDER"
					colType="text" editable="false" sortable="false" search="true"
					id="PARAM_ORDER" />
									<psjg:gridColumn name="ctsSegmentParamVO.PARAM_TYPE"
					title="%{getText('param_type_key')}" index="PARAM_TYPE"
					colType="text" editable="false" sortable="false" search="true"
					id="PARAM_TYPE" />
					
					<psjg:gridColumn id="SEGMENT_CODE" colType="number"
					name="ctsSegmentParamVO.SEGMENT_CODE" index="SEGMENT_CODE" title=""
					editable="true" sortable="false" search="false" hidden="true" />	
					
				<psjg:gridColumn id="CRITERIA_CODE" colType="number"
					name="criteriaCode" index="CRITERIA_CODE" title=""
					editable="true" sortable="false" search="false" hidden="true" />
					
				<psjg:gridColumn id="ENTITY_ID" colType="number"
					name="ctsSegmentParamVO.ENTITY_ID" index="ENTITY_ID" title=""
					editable="true" sortable="false" search="false" hidden="true" />
					
				<psjg:gridColumn id="QUERY_ID_OLD" colType="number"
				name="oldQueryIdParam" index="QUERY_ID_OLD" title=""
				editable="false" sortable="false" search="false" hidden="true" />
				
				<psjg:gridColumn name="isSegmentationScore"
					title="" index="isSegmentationScore"
					colType="text" editable="false" sortable="false" search="false" hidden="true"
					id="isSegmentationScore" />
				
				<psjg:gridColumn id="isOpened" name="isOpened"
					title="" index="isOpened"
					colType="text" editable="false" sortable="false" search="false" hidden="true"
					 />	
					 
			</psjg:grid>

<script type="text/javascript">

//$("#gview_criteriaParamGridTbl_Id_" + _pageRef+"_${_entityType}" + " div.ui-jqgrid-titlebar").hide();

var rowId = $("#_rowId").val();
var queryParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#queryGridId").val();

$("#"+ queryParamGridId).subscribe("fillQryMultiSelectJsonArray", 
		 function(obj) {fillQryMultiSelectJsonArray();
		 });
		 
$("#" + queryParamGridId).subscribe("segmentationQueryParam_onEditInlineBeforeTopics", 
		 function(obj) {segmentationQueryParam_onEditInlineBeforeTopics("Q");
		 });


var procParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#procGridId").val();

$("#"+ procParamGridId).subscribe("fillProcMultiSelectJsonArray", 
		 function(obj) {fillProcMultiSelectJsonArray();
		 });
		 
$("#"+ procParamGridId).subscribe("segmentationProcParam_onEditInlineBeforeTopics", 
		 function(obj) {segmentationProcParam_onEditInlineBeforeTopics("P");
		 });



				

</script>