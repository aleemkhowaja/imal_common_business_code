<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

	<script type="text/javascript">
$.struts2_jquery.require("CriteriaParamList.js", null, jQuery.contextPath+ "/businesscommon/js/core/criteria/");
</script>



	<ps:url id="urlCriteriaSelectParamGrid" action="criteriaList_loadParamGrid" namespace="/path/criteria" escapeAmp="false">
		<ps:param name="criteriaSC.BRANCH_CODE" value="criteriaCO.ctsCriteriaVO.BRANCH_CODE"></ps:param>
		<ps:param name="criteriaSC.CRITERIA_CODE" value="criteriaCO.ctsCriteriaVO.CRITERIA_CODE"></ps:param>
		<ps:param name="criteriaSC.ENTITY_TYPE" value="criteriaCO.ctsCriteriaParamVO.ENTITY_TYPE"></ps:param>
		<ps:param name="criteriaSC.ENTITY_ID" value="criteriaCO.ctsCriteriaParamVO.ENTITY_ID"></ps:param>
		<ps:param name="criteriaSC.entityName" value="criteriaSC.entityName"></ps:param>
		<ps:param name="criteriaCO.editMode" value="criteriaCO.editMode"></ps:param>
		
	</ps:url>


			<psjg:grid id="criteriaSelectParamGridTbl_Id_${_pageRef}_${_entityType}_${_lineNo}" altRows="true"
				caption=" " dataType="json" editurl="TTT" editinline="true"
				filter="false" gridModel="gridModel" href="%{urlCriteriaSelectParamGrid}"
				height="200" multiselect="false" navigator="false"
				navigatorEdit="false" navigatorRefresh="true"
				navigatorSearch="false"
				onEditInlineBeforeTopics="criteriaSelectParam_onEditInlineBeforeTopics"
				navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
				pager="true" pagerButtons="false" rownumbers="true" rowNum="5"
				rowList="5,10,15,20" sortable="false" shrinkToFit="false"
				viewrecords="true">
				
				<psjg:gridColumn name="ctsCriteriaParamVO.PARAM_NAME"
					title="%{getText('param_name_key')}" index="PARAM_NAME"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_NAME" />

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
					
					


			</psjg:grid>


<script type="text/javascript">

$("#gview_criteriaSelectParamGridTbl_Id_" + _pageRef+"_${_entityType}" + " div.ui-jqgrid-titlebar").hide();

$("#criteriaSelectParamGridTbl_Id_" + _pageRef+"_${_entityType}").subscribe("criteriaSelectParam_onEditInlineBeforeTopics", 
		 function(obj) { 
	                 criteriaSelectParam_onEditInlineBeforeTopics("${_entityType}");
		 });
		

		
</script>