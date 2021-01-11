<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<ps:url id="urlcustSegmentationDetailListGrid" escapeAmp="false" 
	action="CustSegmentationListAction_loadCustSegmentationDetailSubGrid" namespace="/path/segmentation">
   <ps:param name="iv_crud"  value="ivcrud_${_pageRef}"></ps:param>
   <ps:param name="_pageRef" value="_pageRef"></ps:param>
   <ps:param name="segmentCode" value="custSegmentationCO.ctsSegmentVO.SEGMENT_CODE" ></ps:param>
</ps:url>

<psjg:grid id="custSegmentationDetailList_Id_${_pageRef}" caption=" " rownumbers="true"
				href="%{urlcustSegmentationDetailListGrid}"
				dataType="json"
				pager="true" 
				filter="false"
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
				navigatorSearch="false"
				addfunc="custSegmentationDetailList_onAddClicked"
				delfunc="custSegmentationDetailList_delCom"
				navigatorAdd="#attr['showAddDeleteBtn']"
				navigatorDelete="#attr['showAddDeleteBtn']"
				editurl="abc" editinline="true" shrinkToFit="true" 
				onEditInlineBeforeTopics="custSegmentationDetailList"
				>

		<psjg:gridColumn id="LINE_NO" name="ctsSegmentDetVO.LINE_NO" colType="number"  title=""	hidden="true" />
	
		<psjg:gridColumn id="LOGICAL_OPERATOR"  	colType="select" 	name="ctsSegmentDetVO.LOGICAL_OPERATOR"  
				index="ctsSegmentDetVO.LOGICAL_OPERATOR" 	title="%{getText('operator_key')}"  hidden="${ishidden}"
				editable="true" sortable="false" search="false"	formatter="select"  edittype="select"
				editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/segmentation/CustSegmentationMaintAction_loadLogicalOperatorDropDown','logicalOperatorDropDown', 'code', 'descValue');}}"
			/>
	
		<psjg:gridColumn id="LEFT_OPERATOR"  	colType="select" 	name="ctsSegmentDetVO.LEFT_OPERATOR"  
				index="ctsSegmentDetVO.LEFT_OPERATOR" 	title="%{getText('left_operator_key')}" 
				editable="true" sortable="false" search="false"	formatter="select"  edittype="select" hidden="${ishidden}"
				editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/segmentation/CustSegmentationMaintAction_loadLeftOperatorDropDown','leftOperatorDropDown', 'code', 'descValue');}}"
			/>
	
		<psjg:gridColumn id="CRITERIA_CODE" 	colType="liveSearch"   
			name="ctsSegmentDetVO.CRITERIA_CODE" 	index="CRITERIA_CODE" 	
			resultList="CRITERIA_CODE:ctsSegmentDetVO.CRITERIA_CODE_lookuptxt" 
			editable="true" sortable="false" search="true"  mode="number" width="70" 
			dataAction="${pageContext.request.contextPath}/pathdesktop/criteriaCodeLookup_constructCriteriaCodeLookup"
			paramList="_pageRef:_pageRef,fromWhere:~CONST_%{fromWhere}"
			title="%{getText('criterion_key')}" required="true"
			searchElement="ctsSegmentDetVO.CRITERIA_CODE" leadZeros="3" minValue="1"
			editoptions="{maxlength:'10' }"
			beforeDepEvent="criteriaCodeAfterDep()"
			params="custSegmentationCO.CtsSegmentDetVO.CRITERIA_CODE:ctsSegmentDetVO.CRITERIA_CODE,_pageRef:_pageRef"
			dependencySrc="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyByCriteriaCode" 
			dependency="custSegmentationCO.ctsSegmentDetVO.CRITERIA_CODE:ctsSegmentDetVO.CRITERIA_CODE,custSegmentationCO.criteriaDesc:criteriaDesc"
			afterDepEvent = "criteriaCodeAfterDependency()"
		/>
	
		<psjg:gridColumn id="criteriaDesc" colType="text"
			name="criteriaDesc" title="%{getText('Description_key')}"
			index="criteriaDesc" editable="false" sortable="false"
			search="false" required="true" />
		
		
		<psjg:gridColumn id="RIGHT_OPERATOR"  	colType="select" 	name="ctsSegmentDetVO.RIGHT_OPERATOR"  
			index="ctsSegmentDetVO.RIGHT_OPERATOR" 	title="%{getText('right_operator_key')}" hidden="${ishidden}"
			editable="true" sortable="false" search="false"	formatter="select"  edittype="select"
			editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/segmentation/CustSegmentationMaintAction_loadRightOperatorDropDown','rightOperatorDropDown', 'code', 'descValue');}}"
		/>
	
	<ps:if test='custSegmentationCO.isSegmentationScore !="BR"'>
		<psjg:gridColumn  id="LABEL_CODE" name="ctsSegmentDetVO.LABEL_CODE" title="%{getText('label_code_key')}" index="LABEL_CODE" 
								  colType="number" editoptions="{ dataEvents: [{ type: 'change', fn: function(e) { onChangingPriority(e) } }], maxlength: '6'}" width="100" editable="true" sortable="true" search="true"/>
		<psjg:gridColumn  id="LABEL_DESC" name="ctsSegmentDetVO.LABEL_DESCRIPTION" title="%{getText('label_desc_key')}" index="LABEL_DESCRIPTION" 
								  colType="text" width="100" editable="true" sortable="true" search="true"/>
								  
		<psjg:gridColumn  id="LABEL_PERC" name="ctsSegmentDetVO.LABEL_PERC" title="%{getText('label_perc_key')}" index="LABEL_CODE"
								  colType="number" editoptions="{ dataEvents: [{ type: 'change', fn: function() { onChangeLabelPercentage() } }], maxlength: '7'}" width="100" editable="true" sortable="true" search="true" minValue="0"/>								 
		
		<psjg:gridColumn id="IGNORE_OTHER_CALC_FIELDS_YN" index="IGNORE_OTHER_CALC_FIELDS_YN" colType="checkbox" name="ctsSegmentDetVO.IGNORE_OTHER_CALC_FIELDS_YN"			
						  title="%{getText('ignore_other_calc_fields_key')}" editable="true" sortable="true" align="center" edittype="checkbox" formatter="checkbox" 
						  editoptions="{value:'1:0',dataEvents: [{ type: 'change', fn: function(e) {  onCheckIgnoreOtherCalcFields() } }]}"   width="150"/>
		</ps:if>
		
		<psjg:gridColumn id="criteriaDetails" colType="text"
					name="criteriaDetails" index="criteriaDetails" title="%{getText('details1_key')}"
					editable="false" sortable="false" search="false"
					formatter="criteria_detailsbtn"  />
			
		<psjg:gridColumn id="criteriaParameterDetails" colType="text"
					name="criteriaParameterDetails" index="criteriaParameterDetails" title="%{getText('parameter_details_key')}"
					editable="false" sortable="false" search="false"
					formatter="criteriaParameterDetailsbtn"  />
					
		
		<psjg:gridColumn id="queryParamGridStr" colType="text"
					name="queryParamGridStr" index="queryParamGridStr" title=""
					editable="false" sortable="false" search="false" hidden="true" />	
		
		<psjg:gridColumn id="procParamGridStr" colType="text"
				name="procParamGridStr" index="procParamGridStr" title=""
				editable="false" sortable="false" search="false" hidden="true" />	
		
		<psjg:gridColumn id="segmentationParamOpened" colType="text"
				name="segmentationParamOpened" index="segmentationParamOpened" title=""
				editable="false" sortable="false" search="false" hidden="true" />
				
		<psjg:gridColumn id="divFormParam" colType="text"
				name="divFormParam" index="divFormParam" title=""
				editable="false" sortable="false" search="false" hidden="true" />	
							
</psjg:grid>

<script type="text/javascript" >
	$("#custSegmentationDetailList_Id_"+_pageRef).subscribe("custSegmentationDetailList",function(obj){
			custSegmentation_editInlineBeforeTopicsAP(obj);
	});
</script>