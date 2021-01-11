<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
 
<html>
<head>
<script type="text/javascript">
	$.struts2_jquery.require("LimitSchema.js" ,null,jQuery.contextPath+"/businesscommon/js/limitschema/");
</script>
</head>
	<body>
	
	<ps:hidden name="cifSubNo" 						id="limitSchema_cifSubNo_hdn_${_pageRef}" />
	<ps:hidden name="branchCode" 					id="limitSchema_branchCode_hdn_${_pageRef}" />
	<ps:hidden name="groupComboList"				id="groupComboList_${_pageRef}" />
	<ps:hidden name="limitSchemaSC.openedFromSign"	id="limitSchemaParentPage_${_pageRef}" />
	<ps:hidden name="baseCyDecPoint"				id="baseCyDecPoint_${_pageRef}" />
	<ps:hidden name="limitSchemaCO.fromWhere"		id="limitSchema_fromWhere_${_pageRef}" />
	<ps:hidden name="currencyCode" 					id="limitSchema_currencyCode_hdn_${_pageRef}" />
	<ps:hidden name="glCode" 						id="limitSchema_glCode_hdn_${_pageRef}" />
	<ps:hidden name="slNo" 						    id="limitSchema_slNo_hdn_${_pageRef}" />
	
	
	<ps:set name="limitSchema_cifSubNo_${_pageRef}"  value="cifSubNo"/>
    <ps:set name="limitSchema_branchCode_${_pageRef}"  value="branchCode"/>
    <ps:set name="limitSchema_currencyCode_${_pageRef}"  value="currencyCode"/>
    <ps:set name="limitSchema_glCode_${_pageRef}"  value="glCode"/>
    <ps:set name="limitSchema_slNo_${_pageRef}"  value="slNo"/>
    
    <ps:set name="limitSchema_iv_crud_${_pageRef}"  value="iv_crud"/>
    <ps:set name="limitSchema_pageRef_${_pageRef}" value="_pageRef"/>
    	
    <ps:set name="limitSchema_enforceSignLimit_${_pageRef}" value="enforceSignLimit"/>
  
    <ps:if test='${limitSchemaSC.openedFromSign}'>
    	<ps:if test='${iv_crud=="P"}'>    	
    		 <ps:set id="limitSchema_gridEditable" value="false"></ps:set>
    	</ps:if>
    	<ps:else>
		   <ps:set id="limitSchema_gridEditable" value="true"></ps:set>
		</ps:else>
    </ps:if>
    <ps:else>
	    <ps:if test='${_recReadOnly=="true"}'>
		   <ps:set id="limitSchema_gridEditable" value="false"></ps:set>
		</ps:if>
		<ps:else>
		   <ps:set id="limitSchema_gridEditable" value="true"></ps:set>
		</ps:else>
	</ps:else>      
    	
	<ps:url id="limitSchemaGridUrl" escapeAmp="false" action="limitSchema_loadLimitSchemaGrid" namespace="/path/limitSchema">
		<ps:param name="cifSubNo"    value="limitSchema_cifSubNo_${_pageRef}"></ps:param>
		<ps:param name="branchCode" value="limitSchema_branchCode_${_pageRef}"></ps:param>
		<ps:param name="currencyCode"    value="limitSchema_currencyCode_${_pageRef}"></ps:param>
		<ps:param name="glCode"    value="limitSchema_glCode_${_pageRef}"></ps:param>
		<ps:param name="slNo"    value="limitSchema_slNo_${_pageRef}"></ps:param>
		<ps:param name="iv_crud"      value="limitSchema_iv_crud_${_pageRef}"></ps:param>
		<ps:param name="_pageRef"      value="limitSchema_pageRef_${_pageRef}"></ps:param>
		<ps:param name="enforceSignLimit"      value="limitSchema_enforceSignLimit_${_pageRef}"></ps:param>
		<ps:param name="limitSchemaSC.openedFromSign"      value="limitSchemaSC.openedFromSign"></ps:param>
		<ps:param name="compCodeCif"    value="limitSchemaSC.compCodeCif"></ps:param>
	</ps:url>
			
		<table>
		<tr>
		<td>
				<psj:livesearch actionName="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructCifAllAmfLookup" searchElement="CIF_SUB_NO"
				 id="limitSchemaCopyBtn_${_pageRef}" name="" paramList="cif_no:limitSchema_cifSubNo_hdn_${_pageRef}" onOk="limitSchema_onCopyBtnClicked()"></psj:livesearch>
		</td>
		<td>
		</td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		</table>
		<br/>	
 
		<div id="limitSchemaGridDiv_Id_<ps:property value="_pageRef" escapeHtml="true"/>"> 
		    <psjg:grid id="limitSchemaGrid_Id_${_pageRef}"
				dataType="json"
				href="%{limitSchemaGridUrl}" 
				pager="true"
				filter="false" 
				gridModel="gridModel" 
				rowNum="5" 
				rowList="5,10,15,20"
				viewrecords="true" 
				navigator="true" 
				navigatorAdd="%{limitSchema_gridEditable}"
		        navigatorDelete="%{limitSchema_gridEditable}"
		        navigatorEdit="false"
				navigatorRefresh="false" 
				navigatorSearch="false" 
				height="120" 
				altRows="true"
				addfunc="limitSchemaOnAddClicked"  
		        delfunc="limitSchemaOnDeleteClicked"
		        shrinkToFit="false"
		        editurl="1234"
		        editinline="%{limitSchema_gridEditable}"
		        onEditInlineBeforeTopics ="limitSchemaGridOnRowSelect"
		        pagerButtons="false"		
		        multiselect="%{ ( limitSchemaSC.openedFromSign || limitSchemaSC.multiSelection )}"
		        onSelectAllTopics="onLimitSchemCheckBoxSelect" 
		        onSelectRowTopics="onLimitSchemCheckBoxSelect"
				
			>
			
		    	<psjg:gridColumn name="limitSchemaVO.LINE" 			title="%{getText('Line_key')}" 				index="LINE" 			colType="number" 	editable="false" 	sortable="true" 	search="true" 	id="LINE" hidden="true"/>
		    	 
		    	<psjg:gridColumn name="unlimited"		title="%{getText('Unlimited_key')}" 			index="unlimited" 		colType="checkbox" 	editable="true" 	sortable="true" 		id="unlimited"  edittype="checkbox" formatter="checkbox" 
		    		editoptions="{value:'Y:N' ,dataEvents: [{ type: 'change', fn: function(e) { onChangeUnlimitAmount(e) } }]}"	 />
		    		
		    	<psjg:gridColumn name="limitSchemaVO.LIMIT_AMT"		title="%{getText('Limit_Amount_key')}" 			index="LIMIT_AMT" 		colType="number" 	editable="true" 	sortable="true" 	search="true"	id="LIMIT_AMT"  formatter="currencyFmatter" formatCol="limitAmtFormat"  
		    		editoptions="{dataEvents: [{ type: 'change', fn: function(e) { onChangeLimitAmount(e) } },{ type: 'focusout', fn: function(e) { onChangeLimitAmount(e) } }], maxlength: '17'}"	/>
				
	            <psjg:gridColumn  name="limitSchemaVO.TRX_TYPE" title="%{getText('Type_key')}" index="TRX_TYPE" colType="liveSearch" editoptions="{maxlength: '3'}" 
											editable="true" sortable="false" id="limitSchemaVO.TRX_TYPE"  
											dataAction="${pageContext.request.contextPath}/pathdesktop/CtsTrxTypeLookup_constructTransactionTypeForLimitSchema" 
											resultList="" searchElement="CODE"  autoSearch="true"	
											params="code:limitSchemaVO.TRX_TYPE_lookuptxt,criteria.iv_crud:iv_crud_${_pageRef}"
							 				dependencySrc="${pageContext.request.contextPath}/pathdesktop/CtsTrxTypeDependencyAction_dependencyByLimitSchemaTrxTypeCode"
							 				dependency="ctsTrxTypeVO.CODE:limitSchemaVO.TRX_TYPE_lookuptxt, ctsTrxTypeVO.SHORT_DESC_ENG:transactionDesc" />
				
				<psjg:gridColumn name="transactionDesc"		title="%{getText('Description_key')}" 			index="transactionDesc" 		colType="text" 	editable="false" 	sortable="true" 	search="true"	id="transactionDesc"  />
				
				<psjg:gridColumn name="limitSchemaVO.GROUP1" 			title="%{getText('Group1_key')}" 			index="GROUP1" 			colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP1"  edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />
				<psjg:gridColumn name="limitSchemaVO.GROUP2" 			title="%{getText('Group2_key')}" 			index="GROUP2" 			colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP2"  edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />
				<psjg:gridColumn name="limitSchemaVO.GROUP3" 			title="%{getText('Group3_key')}" 			index="GROUP3" 			colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP3"  edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />
				<psjg:gridColumn name="limitSchemaVO.GROUP4" 			title="%{getText('Group4_key')}" 			index="GROUP4" 			colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP4"  edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />
				<psjg:gridColumn name="limitSchemaVO.GROUP5" 			title="%{getText('Group5_key')}" 			index="GROUP5" 			colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP5"  edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />
				<psjg:gridColumn name="limitSchemaVO.GROUP6" 			title="%{getText('Group6_key')}" 			index="GROUP6" 			colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP6"	 edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />
				<psjg:gridColumn name="limitSchemaVO.GROUP7" 			title="%{getText('Group7_key')}" 			index="GROUP7" 			colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP7"	 edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />
				<psjg:gridColumn name="limitSchemaVO.GROUP8" 			title="%{getText('Group8_key')}" 			index="GROUP8" 			colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP8"  edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />
				<psjg:gridColumn name="limitSchemaVO.GROUP9" 			title="%{getText('Group9_key')}" 			index="GROUP9" 			colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP9"  edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />
				<psjg:gridColumn name="limitSchemaVO.GROUP10" 			title="%{getText('Group10_key')}" 			index="GROUP10" 		colType="select" 	editable="true" 	sortable="true" 	search="true"	id="GROUP10" edittype="select" formatter="select" editoptions="{value:function(){return loadLimitSchemaCombo();}}" />

				
				<psjg:gridColumn name="neverExpire"		title="%{getText('Never_Expire_key')}" 			index="neverExpire" 		colType="checkbox" 	editable="true" 	sortable="true" 		id="neverExpire"  edittype="checkbox" formatter="checkbox" 
		    		editoptions="{value:'Y:N' ,dataEvents: [{ type: 'change', fn: function(e) { onChangeNeverExpire(e) } }]}"	 />
		    		
				
				<psjg:gridColumn name="limitSchemaVO.EFFECTIVE_FROM"	title="%{getText('Effective_From_key')}" 	index="EFFECTIVE_FROM" 	colType="date" 		editable="true" 	sortable="true" 	search="true"	id="EFFECTIVE_FROM" 
					params="limitSchemaCO.limitSchemaVO.EFFECTIVE_FROM:limitSchemaVO.EFFECTIVE_FROM,limitSchemaCO.limitSchemaVO.EFFECTIVE_TO:limitSchemaVO.EFFECTIVE_TO"
					dependencySrc="${pageContext.request.contextPath}/path/limitSchema/limitSchema_onChangeEffectiveFromDate"
					dependency="limitSchemaCO.limitSchemaVO.EFFECTIVE_FROM:limitSchemaVO.EFFECTIVE_FROM, limitSchemaCO.limitSchemaVO.EFFECTIVE_TO:limitSchemaVO.EFFECTIVE_TO" />
				<psjg:gridColumn name="limitSchemaVO.EFFECTIVE_TO" 	title="%{getText('Effective_To_key')}" 		index="EFFECTIVE_TO" 	colType="date" 		editable="true" 	sortable="true" 	search="true"	id="EFFECTIVE_TO" 
					params="limitSchemaCO.limitSchemaVO.EFFECTIVE_FROM:limitSchemaVO.EFFECTIVE_FROM,limitSchemaCO.limitSchemaVO.EFFECTIVE_TO:limitSchemaVO.EFFECTIVE_TO"
					dependencySrc="${pageContext.request.contextPath}/path/limitSchema/limitSchema_onChangeEffectiveToDate"
					dependency="limitSchemaCO.limitSchemaVO.EFFECTIVE_FROM:limitSchemaVO.EFFECTIVE_FROM, limitSchemaCO.limitSchemaVO.EFFECTIVE_TO:limitSchemaVO.EFFECTIVE_TO" />
				<psjg:gridColumn title="" name="limitAmtFormat" colType="number" hidden="true" />
				<ps:if test='${accountType != "G" && accountType != "F"}'>
					<psjg:gridColumn name="origin" 			title="%{getText('origin_key')} " 			index="origin" 		colType="text" 	editable="false" 	sortable="false" 	search="false"	id="origin"  />
					<psjg:gridColumn name="limitSchemaVO.STATUS" 			title="%{getText('Status_key')}" 			index="STATUS" 			colType="text" 	editable="false" 	sortable="true" 	search="true"	id="STATUS"  />
				</ps:if>
			</psjg:grid>
				
		</div>
	
</body>

<script type="text/javascript">
		var Copy_key = "<ps:text name='Copy_key' />";
		limitSchemaGrid_onDocReady();
	 
		$("#limitSchemaGrid_Id_"+_pageRef).subscribe("onLimitSchemCheckBoxSelect",function(event,rowObj,b){ 				    
			onLimitSchemCheckBoxSelect(event,rowObj);	 
		});
	</script>
</html>