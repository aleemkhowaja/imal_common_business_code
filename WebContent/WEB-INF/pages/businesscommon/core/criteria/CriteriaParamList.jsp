<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

	<script type="text/javascript">
$.struts2_jquery.require("CriteriaParamList.js", null, jQuery.contextPath+ "/businesscommon/js/core/criteria/");
</script>



	<ps:url id="urlCriteriaParamGrid" action="criteriaList_loadParamGrid" namespace="/path/criteria" escapeAmp="false">
		<ps:param name="criteriaSC.BRANCH_CODE" value="criteriaCO.ctsCriteriaVO.BRANCH_CODE"></ps:param>
		<ps:param name="criteriaSC.CRITERIA_CODE" value="criteriaCO.ctsCriteriaVO.CRITERIA_CODE"></ps:param>
		<ps:param name="criteriaSC.ENTITY_TYPE" value="criteriaCO.ctsCriteriaParamVO.ENTITY_TYPE"></ps:param>
		<ps:param name="criteriaSC.ENTITY_ID" value="criteriaCO.ctsCriteriaParamVO.ENTITY_ID"></ps:param>
		<ps:param name="criteriaSC.entityName" value="criteriaSC.entityName"></ps:param>
		<ps:param name="criteriaCO.editMode" value="criteriaCO.editMode"></ps:param>
		
	</ps:url>


			<psjg:grid id="criteriaParamGridTbl_Id_${_pageRef}_${_entityType}" altRows="true"
				caption=" " dataType="json" editurl="TTT" editinline="true"
				filter="false" gridModel="gridModel" href="%{urlCriteriaParamGrid}"
				height="200" multiselect="false" navigator="false"
				navigatorEdit="false" navigatorRefresh="true"
				navigatorSearch="false"
				onEditInlineBeforeTopics="criteriaParam_onEditInlineBeforeTopics"
				navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
				pager="true" pagerButtons="false" rownumbers="true" rowNum="5"
				rowList="5,10,15,20" sortable="false" shrinkToFit="false"
				viewrecords="true">
				
				<psjg:gridColumn name="ctsCriteriaParamVO.PARAM_NAME"
					title="%{getText('param_name_key')}" index="PARAM_NAME"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_NAME" />
					
				<psjg:gridColumn id="PARAM_CLASS" colType="select" edittype="select"
					width="200" formatter="select"
					name="ctsCriteriaParamVO.PARAM_CLASS" index="PARAM_CLASS"
					title="%{getText('param_class_key')}" editable="true"
					sortable="false" search="false" 
					editoptions="{ 
  value:function() {  return loadCombo('${pageContext.request.contextPath}/path/criteria/criteriaMaint_loadAvaBenefStatusSelect','criteriaUsageList', 'code', 'descValue');}  
 ,dataEvents: [{ type: 'change', fn: function(e) { onEditInlineBeforeTopcics_addParamClass('${_entityType}'); } }]
					              
					              }" />
				
				<psjg:gridColumn id="QUERY_ID" 	colType="liveSearch"
					name="ctsCriteriaParamVO.PARAM_QUERY_ID" 	index="QUERY_ID" 	
					resultList="queryId:ctsCriteriaParamVO.PARAM_QUERY_ID_lookuptxt" 
					editable="true" sortable="false" search="false" width="200" 
					dataAction="${pageContext.request.contextPath}/pathdesktop/QueryIdLookup_constructLookup"
					paramList=""
					title="%{getText('queryid_key')}"
					params="queryIdSC.queryId:ctsCriteriaParamVO.PARAM_QUERY_ID_lookuptxt"
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/QueryIdDependencyAction_dependencyByQueryId"
					dependency="queryIdCO.queryId:ctsCriteriaParamVO.PARAM_QUERY_ID"
					editoptions="{ dataEvents: [{ type: 'change', fn: function(e) { onChangeParamQuery('${_entityType}'); } }]
					              }"
				/>
				
				<psjg:gridColumn id="criteriaSelectParameterDetails" colType="text"
					name="criteriaSelectParameterDetails" index="criteriaSelectParameterDetails" title="%{getText('parameter_details_key')}"
					editable="false" sortable="false" search="false"
					formatter="criteriaSelectParamDetailsbtn"  />
		
				<psjg:gridColumn id="querySelectParamGridStr" colType="text"
					name="querySelectParamGridStr" index="querySelectParamGridStr" title=""
					editable="false" sortable="false" search="false" hidden="true" />
				
				<psjg:gridColumn id="jsonMultiselectArray" colType="text" index="jsonMultiselectArray" 
					name="jsonMultiselectArray" title="%{getText('multi_selected_key')}" editable="true"
					sortable="true" search="true" width="150" hidden="true" />
				
				<psjg:gridColumn id="multiSelectlkp" 	colType="liveSearch"   
					name="multiSelectlkp" 	index="multiSelectlkp" 
					multiSelect 	= "true" 	multiResultInput ="jsonMultiselectArray"
					selectColumn ="PARAM_VALUE" 
					editable="true" sortable="true" search="true" width="200"
					dataAction="${pageContext.request.contextPath}/path/criteria/criteriaList_constructQryMultiSelect"
					paramList="queryId:ctsCriteriaParamVO.PARAM_QUERY_ID,CRITERIA_CODE:ctsCriteriaParamVO.CRITERIA_CODE,criteriaEntityId:ctsCriteriaParamVO.ENTITY_ID,querySelectParamGridStr:querySelectParamGridStr" 
					title="%{getText('multi_value_key')}"
				/>
				
				<psjg:gridColumn id="SESSION_ATTR_NAME" colType="select"
					edittype="select" width="200" formatter="select"
					name="ctsCriteriaParamVO.SESSION_ATTR_NAME"
					index="SESSION_ATTR_NAME"
					title="%{getText('session_attr_name_key')}" editable="true"
					sortable="false" search="false"
					editoptions="{ 
  value:function() {  return loadCombo('${pageContext.request.contextPath}/path/criteria/criteriaMaint_loadSessionAttrNameSelect','sessionAttrList', 'code', 'descValue');}  
 }" />
 


				<psjg:gridColumn id="PARAM_VALUE" colType="text" width="200"
					name="ctsCriteriaParamVO.PARAM_VALUE" index="PARAM_VALUE" 
					title="%{getText('param_value_key')}" editable="true"
					sortable="false" search="false" editoptions="{ maxlength:'15'}"  />
					
				<psjg:gridColumn name="ctsCriteriaParamVO.PARAM_ORDER"
					title="%{getText('param_order_key')}" index="PARAM_ORDER"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_ORDER" />
				<psjg:gridColumn name="ctsCriteriaParamVO.PARAM_TYPE"
					title="%{getText('param_type_key')}" index="PARAM_TYPE"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_TYPE" />
					
					
				<psjg:gridColumn id="CRITERIA_CODE" colType="number"
					name="ctsCriteriaParamVO.CRITERIA_CODE" index="CRITERIA_CODE" title=""
					editable="true" sortable="false" search="false" hidden="true" />
					
				<psjg:gridColumn id="ENTITY_ID" colType="number"
					name="ctsCriteriaParamVO.ENTITY_ID" index="ENTITY_ID" title=""
					editable="true" sortable="false" search="false" hidden="true" />
					
				<psjg:gridColumn id="QUERY_ID_OLD" colType="number"
				name="oldQueryIdParam" index="QUERY_ID_OLD" title=""
				editable="false" sortable="false" search="false" hidden="true" />	
				
				<psjg:gridColumn id="isOpened" colType="text"
				name="isOpened" index="isOpened" title=""
				editable="false" sortable="false" search="false" hidden="true" />

			</psjg:grid>


<script type="text/javascript">

$("#gview_criteriaParamGridTbl_Id_" + _pageRef+"_${_entityType}" + " div.ui-jqgrid-titlebar").hide();

$("#criteriaParamGridTbl_Id_" + _pageRef+"_${_entityType}").subscribe("criteriaParam_onEditInlineBeforeTopics", 
		 function(obj) { 
	                 criteriaParam_onEditInlineBeforeTopics("${_entityType}");
		 });
		

		
</script>