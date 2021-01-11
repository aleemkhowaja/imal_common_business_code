<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<script type="text/javascript">
$.struts2_jquery.require("SegmentationParamsList.js", null, jQuery.contextPath+ "/businesscommon/js/core/segmentation/");
</script>

<ps:url id="urlParamGrid" action="CustSegmentationListAction_loadSegParamGrid" namespace="/path/segmentation" escapeAmp="false">
		<ps:param name="criteria.criteria_code" value="%{custSegmentationSC.criteria_code}"></ps:param>
		<ps:param name="criteria.segment_code" value="%{custSegmentationSC.segment_code}"></ps:param>
		<ps:param name="criteria.ENTITY_TYPE" value="%{custSegmentationSC.ENTITY_TYPE}"></ps:param>
		<ps:param name="criteria.ENTITY_ID" value="%{custSegmentationSC.ENTITY_ID}"></ps:param>
		<ps:param name="criteria.lineNo" value="%{custSegmentationSC.lineNo}"></ps:param>
		<ps:param name="criteria.progRef" value="%{custSegmentationSC.progRef}"></ps:param>
	</ps:url>


			<psjg:grid id="segSelectParamGridTbl_Id_${_pageRef}_${_lineNo}_${custSegmentationSC.criteria_code}_${_entityType}" altRows="true"
				caption=" " dataType="json" editurl="TTT" editinline="true"
				filter="false" gridModel="gridModel" href="%{urlParamGrid}"
				height="200" multiselect="false" navigator="false"
				navigatorEdit="false" navigatorRefresh="true"
				navigatorSearch="false"
				onEditInlineBeforeTopics=""
				navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
				pager="true" pagerButtons="false" rownumbers="true" rowNum="5"
				rowList="5,10,15,20" sortable="false" shrinkToFit="false"
				viewrecords="true">
				
				<psjg:gridColumn name="ctsSegmentParamVO.PARAM_NAME"
					title="%{getText('param_name_key')}" index="PARAM_NAME"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_NAME" />

				<psjg:gridColumn id="PARAM_VALUE" colType="text" width="200"
					name="ctsSegmentParamVO.PARAM_VALUE" index="PARAM_VALUE" 
					title="%{getText('param_value_key')}" editable="true"
					sortable="false" search="false" 
					editoptions="{ maxlength:'15',dataEvents: [{ type: 'change', fn: function(e) { onChangeSelectParamValue('${_entityType}'); } }]
					              }" />
					
				<psjg:gridColumn name="ctsSegmentParamVO.PARAM_ORDER"
					title="%{getText('param_order_key')}" index="PARAM_ORDER"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_ORDER" />
				<psjg:gridColumn name="ctsSegmentParamVO.PARAM_TYPE"
					title="%{getText('param_type_key')}" index="PARAM_TYPE"
					colType="text" editable="false" sortable="true" search="true"
					id="PARAM_TYPE" />
					
					


			</psjg:grid>


<script type="text/javascript">
$("#gview_segSelectParamGridTbl_Id_" + _pageRef+ "_${_lineNo}"+"_${custSegmentationSC.criteria_code}"+"_${_entityType}" + " div.ui-jqgrid-titlebar").hide();

// $("#segSelectParamGridTbl_Id_" + _pageRef+ "_${_lineNo}"+"_${custSegmentationSC.criteria_code}"+"_${_entityType}").subscribe("segmentationProcParam_onEditInlineBeforeTopics", 
// 		 function(obj) { 
// 	                 segmentationProcParam_onEditInlineBeforeTopics("${_entityType}");
// 		 });

		

		
</script>