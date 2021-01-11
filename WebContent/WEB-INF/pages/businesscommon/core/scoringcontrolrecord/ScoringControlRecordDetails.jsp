<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>


<%@taglib prefix="pt" uri="/path-toolbar-tags"%>

<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />

<ps:url id="ScoringControlRecorddetailsGrid" escapeAmp="false"
	action="ScoringControlRecordListAction_loadScoringControlRecordGrid"
	namespace="/path/scoringControlRecord">
	<ps:param name="status" value="scoringControlRecordSC.status"></ps:param>
	<ps:param name="iv_crud" value="ivcrud_${_pageRef}"></ps:param>
	<ps:param name="_pageRef" value="_pageRef"></ps:param>
	
</ps:url>

	<psjg:grid id="ScoringControlRecorddetailsGrid_Id_${_pageRef}"
	caption="" dataType="json"
	href="%{ScoringControlRecorddetailsGrid}"
	pager="${_popupBtnAddFlag}"
	filter="false" gridModel="gridModel" rowNum="5" rowList="5,10,15,20"
	viewrecords="true" navigator="true"
	navigatorAdd="${_popupBtnAddFlag}"
	navigatorDelete="${_popupBtnDelFlag}"
	navigatorEdit="false"
	navigatorRefresh="false" navigatorSearch="false" height="100" width="890"
	altRows="true" pagerButtons="false" editinline="true" editurl="abc"
	shrinkToFit="true" addfunc="scoringControlRecordAddFunc"
	delfunc="scoringControlRecordDeleteFunc" rownumbers="true"
	onCompleteTopics="scoringControlRecord_complete"
	>
	
	<ps:if test="_pageRef =='ACR00AP' ||  _pageRef =='ACR00M' || _pageRef =='ACR00A' || _pageRef =='ACR00DJ' ">

		<psjg:gridColumn id="compCode_${_pageRef}" colType="number"
			width="110" name="cifControlDefineScoreRangeVO.COMP_CODE"
			index="SCORE_CODE" title="%{getText('company_key')}" editable="false"
			sortable="false" search="false" hidden="true" />

		<psjg:gridColumn id="score_no_${_pageRef}" colType="number"
			width="110" name="cifControlDefineScoreRangeVO.SCORE_CODE"
			index="SCORE_CODE" title="%{getText('line_no_key')}"
			editable="false" sortable="false" search="false" />
	</ps:if>
	<ps:else>
		<psjg:gridColumn id="score_no_${_pageRef}" colType="number"
			width="110" name="cifControlDefineScoreRangeVO.SCORE_CODE"
			index="SCORE_CODE" title="%{getText('RISK_LEVEL_key')}"
			editable="false" sortable="false" search="true" hidden="true"/>
	</ps:else>



	<psjg:gridColumn id="from_score_${_pageRef}" colType="number"
		name="cifControlDefineScoreRangeVO.FROM_SCORE" index="FROM_SCORE"
		title="%{getText('from_score_key')}" editable="${_popupBtnAddFlag}"
		sortable="false" search="${_popupBtnAddFlag}" nbFormat="#,#0.000" maxValue="9999999.999" minValue="1.000"
		dependencySrc="${pageContext.request.contextPath}/path/scoringControlRecord/ScoringControlRecordMaintAction_dependencyByFromScore"
		params="scoringControlRecordCO.cifControlDefineScoreRangeVO.FROM_SCORE:cifControlDefineScoreRangeVO.FROM_SCORE"
		dependency="scoringControlRecordCO.cifControlDefineScoreRangeVO.FROM_SCORE:cifControlDefineScoreRangeVO.FROM_SCORE,
		scoringControlRecordCO.cifControlDefineScoreRangeVO.TO_SCORE:cifControlDefineScoreRangeVO.TO_SCORE"
			
		/>
		
	<psjg:gridColumn id="to_score_${_pageRef}" colType="number"
		name="cifControlDefineScoreRangeVO.TO_SCORE" index="TO_SCORE"
		title="%{getText('to_score_key')}" editable="${_popupBtnAddFlag}"
		sortable="false" search="${_popupBtnAddFlag}" nbFormat="#,#0.000" maxValue="9999999.999" minValue="1.000"
		dependencySrc="${pageContext.request.contextPath}/path/scoringControlRecord/ScoringControlRecordMaintAction_dependencyByToScore"
		params="scoringControlRecordCO.cifControlDefineScoreRangeVO.FROM_SCORE:cifControlDefineScoreRangeVO.FROM_SCORE,
		scoringControlRecordCO.cifControlDefineScoreRangeVO.TO_SCORE:cifControlDefineScoreRangeVO.TO_SCORE"
		dependency="scoringControlRecordCO.cifControlDefineScoreRangeVO.FROM_SCORE:cifControlDefineScoreRangeVO.FROM_SCORE,
		scoringControlRecordCO.cifControlDefineScoreRangeVO.TO_SCORE:cifControlDefineScoreRangeVO.TO_SCORE"
		afterDepEvent="validateFromToScore()" 
			/>


	<psjg:gridColumn id="risk_level_${_pageRef}" colType="text" width="110"
		name="cifControlDefineScoreRangeVO.RISK_LEVEL" index="RISK_LEVEL"
		title="%{getText('risk_level_key')}" editable="${_popupBtnAddFlag}"
		editoptions="{ maxlength:'20'}" sortable="false"
		search="${_popupBtnAddFlag}" />
		
	<psjg:gridColumn id="created_by" colType="text" width="110"
		name="cifControlDefineScoreRangeVO.CREATED_BY" index="cifControlDefineScoreRangeVO.CREATED_BY"  	
		title="" editable="false" 
		sortable="false" search="true" hidden="true" />
		
	<psjg:gridColumn id="created_date" colType="date" width="110"
		name="cifControlDefineScoreRangeVO.CREATED_DATE" index="cifControlDefineScoreRangeVO.CREATED_DATE"  	
		title="" editable="false" 
		sortable="false" search="true" hidden="true" />	
		
		<psjg:gridColumn id="modified_by" colType="text" width="110"
		name="cifControlDefineScoreRangeVO.MODIFIED_BY" index="cifControlDefineScoreRangeVO.MODIFIED_BY"  	
		title="" editable="false" 
		sortable="false" search="true" hidden="true" />
		
	<psjg:gridColumn id="modified_date" colType="date" width="110"
		name="cifControlDefineScoreRangeVO.MODIFIED_DATE" index="cifControlDefineScoreRangeVO.MODIFIED_DATE"  	
		title="" editable="false" 
		sortable="false" search="true" hidden="true" />	
		
		<psjg:gridColumn id="entity_status" colType="text" width="110"
		name="cifControlDefineScoreRangeVO.ENTITY_STATUS" index="cifControlDefineScoreRangeVO.ENTITY_STATUS"  	
		title="" editable="false" 
		sortable="false" search="true" hidden="true" />

	<ps:if test="_pageRef =='ACR00AP' ||  _pageRef =='ACR00M' || _pageRef =='ACR00A' || _pageRef =='ACR00DJ' ">
		<psjg:gridColumn id="risk_${_pageRef}" colType="select"
			name="cifControlDefineScoreRangeVO.RISK" index="risk"
			title="%{getText('priority_key')}" editable="true" sortable="false"
			search="false" formatter="select" edittype="select"
			editoptions="{value:function() {  return loadCombo('${pageContext.request.contextPath}/path/scoringControlRecord/ScoringControlRecordMaintAction_loadriskList','riskActionList', 'code', 'descValue');}
						,style:'width:100%'
						,dataEvents: [{ type: 'change', fn: function(e) { onChangeScoringRisk(e); } }]}"
						/>
	</ps:if>
	<ps:else>
	<psjg:gridColumn id="risk_${_pageRef}" colType="select"
			name="cifControlDefineScoreRangeVO.RISK" index="risk"
			title="%{getText('priority_key')}" editable="false" sortable="false"
			search="false" formatter="select" edittype="select"
			editoptions="{value:function() {  return loadCombo('${pageContext.request.contextPath}/path/scoringControlRecord/ScoringControlRecordMaintAction_loadriskList','riskActionList', 'code', 'descValue');}
						,style:'width:100%'}" hidden="true"/>
	</ps:else>
</psjg:grid>
</td>

<script type="text/javascript">
	console.log("out")
	
	$("#ScoringControlRecorddetailsGrid_Id_" + _pageRef).subscribe(
			"scoringControlRecord_complete", function(obj)
			{
				if(_pageRef != "ACR00AP" && _pageRef != "ACR00M" && _pageRef != "ACR00A" && _pageRef != "ACR00DJ")
				{
					scoringControlRecord_completeFunc(obj);		
				}
				
			});

	
	
</script>