<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %><html>

<%/* _recReadOnlyAdd(optional) : if we need to force disabling single grid without affect others */ %>
	<ps:set var="theReadOnly" value="#_recReadOnlyAdd==null?_recReadOnly:#_recReadOnlyAdd" />
<%/* charges_gridEditable : logically affected invert theReadOnly */ %>
	<ps:set var="charges_gridEditable" value="%{(#theReadOnly != null && #theReadOnly == 'true')?'false':'true'}" />

<script type="text/javascript" >
$.struts2_jquery.require("EntityCharges.js" ,null,jQuery.contextPath+"/businesscommon/js/entitycharges/");
</script>

 	<ps:hidden id="chargesGridId_hid_${_pageRef}${param.fromId}" value="#chargesGridId_${_pageRef}${param.fromId}"/>
	<ps:hidden id="schemaChargesId_${_pageRef}${param.fromId}" 	 value="${param.schemaCharges}"/>
	<ps:hidden id="chargesGridEntityCode_${_pageRef}${param.fromId}" 			name="entityChargesCO.entityCode"/>
	<ps:hidden id="chargesGridEntityType_${_pageRef}${param.fromId}" 			name="entityChargesCO.entityType"/>
	<ps:hidden id="chargesGridOriginalCode_${_pageRef}${param.fromId}" 			name="entityChargesCO.originalCode"/>
	<ps:hidden id="chargesGridIsEmptied_${_pageRef}${param.fromId}" 			name="entityChargesCO.isEmptied"/>
	<ps:hidden id="chargesGridDeductCharges_${_pageRef}${param.fromId}" 		name="entityChargesCO.deductCharges"/>
	<ps:hidden id="chargesGridCardType_${_pageRef}${param.fromId}" 				name="entityChargesCO.cardType"/>
	<ps:hidden id="chargesGridAccBranch_${_pageRef}${param.fromId}" 			name="entityChargesCO.accBranch"/>
	<ps:hidden id="chargesGridAccCurrency_${_pageRef}${param.fromId}" 			name="entityChargesCO.accCurrency"/>
	<ps:hidden id="chargesGridaccGL_${_pageRef}${param.fromId}" 				name="entityChargesCO.accGL"/>
	<ps:hidden id="chargesGridaccCIF_${_pageRef}${param.fromId}" 				name="entityChargesCO.accCIF"/>
	<ps:hidden id="chargesGridAccSL_${_pageRef}${param.fromId}" 				name="entityChargesCO.accSL"/>
	<ps:hidden id="chargesGridChargeAccBranch_${_pageRef}${param.fromId}" 		name="entityChargesCO.chargeAccBranch"/>
	<ps:hidden id="chargesGridChargeAccCurrency_${_pageRef}${param.fromId}" 	name="entityChargesCO.chargeAccCurrency"/>
	<ps:hidden id="chargesGridChargeAccGL_${_pageRef}${param.fromId}" 			name="entityChargesCO.chargeAccGL"/>
	<ps:hidden id="chargesGridChargeAccCIF_${_pageRef}${param.fromId}" 			name="entityChargesCO.chargeAccCIF"/>
	<ps:hidden id="chargesGridChargeAccSL_${_pageRef}${param.fromId}" 			name="entityChargesCO.chargeAccSL"/>
	<ps:hidden id="chargesGridBriefDescEngBase_${_pageRef}${param.fromId}" 		name="entityChargesCO.briefDescEngBase"/>
	<ps:hidden id="chargesGridEntityCommand_${_pageRef}${param.fromId}" 		name="entityChargesCO.entityCommand"/>
	<ps:hidden id="chargesGridCrud_${_pageRef}${param.fromId}" 					name="entityChargesCO.crud"/>
	<ps:hidden id="chargesGridSchemaDestroy_${_pageRef}${param.fromId}" 		name="entityChargesCO.schemaDestroy"/>
	<ps:hidden id="chargesGridSchemaCancel_${_pageRef}${param.fromId}" 			name="entityChargesCO.schemaCancel"/>
	<ps:hidden id="chargesGridIsRepeat_${_pageRef}${param.fromId}" 				name="entityChargesCO.isRepeat"/>
	<ps:hidden id="chargesGridProceed_${_pageRef}${param.fromId}" 				name="entityChargesCO.proceed"/>
	<ps:hidden id="chargesGridNumOfEntities_${_pageRef}${param.fromId}" 		name="entityChargesCO.numOfEntities"/>
	<ps:hidden id="isWaived_${_pageRef}${param.fromId}" 						name="entityChargesCO.isWaived"/>
	<ps:hidden id="trxType_${_pageRef}${param.fromId}" 							name="entityChargesCO.trxType"/>
	<ps:hidden id="entityTypeCode_${_pageRef}${param.fromId}" 					name="entityChargesCO.entityTypeCode"/>
	<ps:hidden id="leaves_${_pageRef}${param.fromId}" 							name="entityChargesCO.leaves"/>
	<ps:hidden id="type_${_pageRef}${param.fromId}" 							name="entityChargesCO.type"/>
	<ps:hidden id="chqIssueType_${_pageRef}${param.fromId}" 					name="entityChargesCO.chqIssueType"/>
	<ps:hidden id="statusIdentifer_${_pageRef}${param.fromId}"					name="entityChargesCO.statusIdentifer"/>
	<ps:hidden id="maxLosDocAmt_${_pageRef}${param.fromId}"					    name="entityChargesCO.maxLosDocAmt"/>
	<ps:hidden id="appMultiCharges_${_pageRef}${param.fromId}"					name="entityChargesCO.appMultiCharges"/>
	<ps:hidden id="certificateCode_${_pageRef}${param.fromId}"					name="entityChargesCO.certificateCode"/>
 	<ps:hidden id="maxCerticateAmt_${_pageRef}${param.fromId}"					name="entityChargesCO.maxCerticateAmt"/>
 	<ps:hidden id="trsNo_${_pageRef}${param.fromId}"							name="entityChargesCO.trsNo"/>
 	
	<ps:url id="urlChargesGrid_${_pageRef}${param.fromId}" action="EntityCharges_loadChargesEntityGrid?entityChargesCO.printingLocation=${param.printingLocation}&entityChargesCO.typeInd=${param.typeInd}&entityChargesCO.schema=${param.schema}&entityChargesCO.chargeType=${param.chargeType}&entityChargesCO.trxType=${param.trxType}&entityChargesCO.actionType=${param.actionType}&entityChargesCO.cvAmount=${param.cvAmount}&entityChargesCO.maxLosDocAmt=${param.maxLosDocAmt}&entityChargesCO.appMultiCharges=${param.appMultiCharges}&entityChargesCO.loginBraCode=${param.loginBraCode}&entityChargesCO.multiplyByBills=${param.multiplyByBills}&entityChargesCO.maxCerticateAmt=${param.maxCerticateAmt}" namespace="/path/entitycharges"  escapeAmp="false">		
		<ps:param name="iv_crud" 								value="iv_crud"/>
		<ps:param name="_pageRef" 								value="_pageRef"/>
		<ps:param name="entityChargesCO.entityCode" 			value="entityChargesCO.entityCode"/>
		<ps:param name="entityChargesCO.entityType" 			value="entityChargesCO.entityType"/>
		<ps:param name="entityChargesCO.originalCode" 			value="entityChargesCO.originalCode"/>
		<ps:param name="entityChargesCO.ctsChargesEntityCOs" 	value="entityChargesCO.ctsChargesEntityCOs"/>
		<ps:param name="entityChargesCO.isEmptied" 				value="entityChargesCO.isEmptied"/>
		<ps:param name="entityChargesCO.deductCharges" 			value="entityChargesCO.deductCharges"/>
		<ps:param name="entityChargesCO.cardType" 				value="entityChargesCO.cardType"/>
		<ps:param name="entityChargesCO.accBranch" 				value="entityChargesCO.accBranch"/>
		<ps:param name="entityChargesCO.accCurrency" 			value="entityChargesCO.accCurrency"/>
		<ps:param name="entityChargesCO.accGL" 					value="entityChargesCO.accGL"/>
		<ps:param name="entityChargesCO.accCIF" 				value="entityChargesCO.accCIF"/>
		<ps:param name="entityChargesCO.accSL" 					value="entityChargesCO.accSL"/>
		<ps:param name="entityChargesCO.chargeAccBranch" 		value="entityChargesCO.chargeAccBranch"/>
		<ps:param name="entityChargesCO.chargeAccCurrency" 		value="entityChargesCO.chargeAccCurrency"/>
		<ps:param name="entityChargesCO.chargeAccGL" 			value="entityChargesCO.chargeAccGL"/>
		<ps:param name="entityChargesCO.chargeAccCIF" 			value="entityChargesCO.chargeAccCIF"/>
		<ps:param name="entityChargesCO.chargeAccSL" 			value="entityChargesCO.chargeAccSL"/>
		<ps:param name="entityChargesCO.briefDescEngBase" 		value="entityChargesCO.briefDescEngBase"/>
		<ps:param name="entityChargesCO.entityCommand" 			value="entityChargesCO.entityCommand"/>
		<ps:param name="entityChargesCO.crud" 					value="entityChargesCO.crud"/>
		<ps:param name="entityChargesCO.schemaDestroy" 			value="entityChargesCO.schemaDestroy"/>
		<ps:param name="entityChargesCO.schemaCancel" 			value="entityChargesCO.schemaCancel"/>
		<ps:param name="entityChargesCO.isRepeat" 				value="entityChargesCO.isRepeat"/>
		<ps:param name="entityChargesCO.proceed" 				value="entityChargesCO.proceed"/>
		<ps:param name="entityChargesCO.numOfEntities" 			value="entityChargesCO.numOfEntities"/>
		<ps:param name="entityChargesCO.entityTypeCode" 		value="entityChargesCO.entityTypeCode"/>
		<ps:param name="entityChargesCO.leaves" 				value="entityChargesCO.leaves"/>
		<ps:param name="entityChargesCO.type" 					value="entityChargesCO.type"/>
		<ps:param name="entityChargesCO.chqIssueType" 			value="entityChargesCO.chqIssueType"/>
		<ps:param name="entityChargesCO.statusIdentifer" 		value="entityChargesCO.statusIdentifer"/>
		<ps:param name="entityChargesCO.tradeSerialNbr" 		value="entityChargesCO.tradeSerialNbr"/>
		<ps:param name="entityChargesCO.certificateCode" 		value="entityChargesCO.certificateCode"/>
		<ps:param name="entityChargesCO.trsNo" 					value="entityChargesCO.trsNo"/>
	</ps:url>

	<psjg:grid id="chargesGridId_${_pageRef}${param.fromId}"							
		caption=" "														 				 
		href="%{urlChargesGrid_${_pageRef}${param.fromId}}" dataType="json"  
		hiddengrid="false" pager="true" filter="false"
		sortable="true" hidegrid="false"
		gridModel="gridModel" rowNum="5" rowList="5,10,15,20"
		viewrecords="true" navigator="true"   altRows="true"
		navigatorRefresh="false" navigatorSearch="false"  
    	navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
		navigatorAdd="false" navigatorDelete="false" navigatorEdit="false" 
		shrinkToFit="true"  editinline='%{#charges_gridEditable}'  editurl="#"	 footerrow="true"
		userDataOnFooter="true"	   pagerButtons="false"   onGridCompleteTopics="${_pageRef}${param.fromId}_calculateChargesTotal"    onSelectRowTopics ="${_pageRef}${param.fromId}_onSelectRow"
	>

         <psjg:gridColumn index="entityChargeKey" name="entityChargeKey" title="" colType="text" 
                     hidden="true" editable="false" sortable="false" search="false" key="true" />
		<%/* start modif IIAB110476 */ %>
         <psjg:gridColumn index="ctsAmountOrig" name="ctsChargesEntityVO.AMOUNT_ORIGINAL" title="" colType="text" 
                     hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="ctsAmountOrigFC" name="ctsChargesEntityVO.AMOUNT_ORIGINAL_FC" title="" colType="text" 
                     hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="vatAmountOrig" name="vatCtsChargesEntityVO.AMOUNT_ORIGINAL" title="" colType="text" 
                     hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="vatAmountOrigFC" name="vatCtsChargesEntityVO.AMOUNT_ORIGINAL_FC" title="" colType="text" 
                     hidden="true" editable="false" sortable="false" search="false" />
		            
         
         <psjg:gridColumn index="PASS_SEPARATELY" 		name="ctsChargesEntityVO.PASS_SEPARATELY"    	title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DR_CRITERIA" 	  		name="ctsChargesEntityVO.DR_CRITERIA" 	   		title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="ACC_BR" 		  		name="ctsChargesEntityVO.ACC_BR" 				title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="ACC_CY" 		  		name="ctsChargesEntityVO.ACC_CY" 				title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="ACC_GL" 		  		name="ctsChargesEntityVO.ACC_GL" 				title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="ACC_CIF" 		  		name="ctsChargesEntityVO.ACC_CIF" 				title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="ACC_SL" 		  		name="ctsChargesEntityVO.ACC_SL" 				title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="vatACC_BR" 	  		name="vatCtsChargesEntityVO.ACC_BR" 			title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="vatACC_CY" 	  		name="vatCtsChargesEntityVO.ACC_CY" 			title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="vatACC_GL" 	  		name="vatCtsChargesEntityVO.ACC_GL" 			title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="vatACC_CIF" 	  		name="vatCtsChargesEntityVO.ACC_CIF" 			title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="vatACC_SL" 	  		name="vatCtsChargesEntityVO.ACC_SL" 			title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="vatTYPE_IND" 	        name="vatCtsChargesEntityVO.TYPE_IND"           title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DEDUCT_FROM_ACC_BR" 	name="ctsChargesEntityVO.DEDUCT_FROM_ACC_BR" 	title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DEDUCT_FROM_ACC_CY" 	name="ctsChargesEntityVO.DEDUCT_FROM_ACC_CY" 	title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DEDUCT_FROM_ACC_GL" 	name="ctsChargesEntityVO.DEDUCT_FROM_ACC_GL" 	title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DEDUCT_FROM_ACC_CIF" 	name="ctsChargesEntityVO.DEDUCT_FROM_ACC_CIF" 	title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DEDUCT_FROM_ACC_SL" 	name="ctsChargesEntityVO.DEDUCT_FROM_ACC_SL" 	title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DR_ACC_GL" 		  	name="ctsChargesEntityVO.DR_ACC_GL" 			title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DR_ACC_CIF" 		  	name="ctsChargesEntityVO.DR_ACC_CIF" 			title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DR_ACC_SL" 		  	name="ctsChargesEntityVO.DR_ACC_SL" 			title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="SCHEMA_CODE" 		  	name="ctsChargesEntityVO.SCHEMA_CODE" 			title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DUES_COLLECTION_TYPE" 	name="ctsChargesEntityVO.DUES_COLLECTION_TYPE" 	title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="DUES_MODE_PAY" 		name="ctsChargesEntityVO.DUES_MODE_PAY" 		title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
         <psjg:gridColumn index="TYPE_IND" 	            name="ctsChargesEntityVO.TYPE_IND" 	            title="" colType="text" hidden="true" editable="false" sortable="false" search="false" />
                     
		<%/* end modif IIAB110476 */ %>
                     
		<psjg:gridColumn id="chargeCode" colType="number" name="ctsChargesEntityVO.CHARGE_CODE" 
			index="ctsChargesEntityVO.CHARGE_CODE" title="%{getText('Charge_Code_key')}"  	
			editable="false" sortable="false"   			
			/>
		<psjg:gridColumn id="chargeDesc" colType="text" name="chargeDesc"
			index="chargeDesc"
			title="%{getText('Description_key')}"
			editable="false" sortable="true"   />
		<psjg:gridColumn id="cvAmount" colType="number"    
			name="ctsChargesEntityVO.AMOUNT" index="ctsChargesEntityVO.AMOUNT"
			title="%{getText('CV_Amount_key')}"    
			editable="true" sortable="false"
			nbFormat="#,###.00#"
			editoptions="{ dataEvents: [{ type: 'change', fn: function(e) { onChangeAmount('#chargesGridId_${_pageRef}${param.fromId}','B','ctsChargesEntityVO.AMOUNT','${_pageRef}${param.fromId}') } }], maxlength: '14', }"
			formatter="currencyFmatter" formatCol="baseCurrDecPoint"   
			
			/>
		<psjg:gridColumn id="fcAmount"  name="ctsChargesEntityVO.AMOUNT_FC"  
			index="ctsChargesEntityVO.AMOUNT_FC" title="%{getText('FC_Amount_key')}"
			editable="true" sortable="false"  colType="number"
			nbFormat="0#,###.00#"
			editoptions="{  dataEvents: [{ type: 'change', fn: function(e) { onChangeAmount('#chargesGridId_${_pageRef}${param.fromId}','F','ctsChargesEntityVO.AMOUNT_FC','${_pageRef}${param.fromId}') } }], maxlength: '14'}"
			formatter="currencyFmatter" formatCol="chrgsCurrDecPoint"    
			/>	
			
		<psjg:gridColumn id="vatChargeCode" colType="number" name="vatCtsChargesEntityVO.CHARGE_CODE" 
			index="vatCtsChargesEntityVO.CHARGE_CODE" title="%{getText('Charge_Code_key')}"  	
			editable="true" sortable="false"   hidden="true"
						
			/>
 
		<psjg:gridColumn id="vatCVAmount"  
			name="vatCtsChargesEntityVO.AMOUNT" index="vatCtsChargesEntityVO.AMOUNT"
			title="%{getText('VAT_CV_Amount_key')}"  colType="number"
			editable="false" sortable="false"
			nbFormat="0#,###.00#"
			editoptions="{  dataEvents: [{ type: 'change', fn: function(e) { onChangeAmount('#chargesGridId_${_pageRef}${param.fromId}','B','vatCtsChargesEntityVO.AMOUNT','${_pageRef}${param.fromId}') } }], maxlength: '14'}"
			formatter="currencyFmatter" formatCol="baseCurrDecPoint"   
			/>
		<psjg:gridColumn id="vatFCAmount" name="vatCtsChargesEntityVO.AMOUNT_FC"
			index="vatCtsChargesEntityVO.AMOUNT_FC" title="%{getText('VAT_FC_Amount_key')}"
			editable="false" sortable="false"   colType="number"
			nbFormat="0#,###.00#"
			editoptions="{ dataEvents: [{ type: 'change', fn: function(e) { onChangeAmount('#chargesGridId_${_pageRef}${param.fromId}','F','vatCtsChargesEntityVO.AMOUNT_FC','${_pageRef}${param.fromId}') } }], maxlength: '14'}"
			formatter="currencyFmatter" formatCol="chrgsCurrDecPoint"  
			/>	
		<psjg:gridColumn title="" name="baseCurrDecPoint" colType="number" hidden="true" />
		<psjg:gridColumn title="" name="chrgsCurrDecPoint" colType="number" hidden="true" />
		<psjg:gridColumn title="" name="ctsChargesVO.FIX_CHARGES" colType="number" hidden="true" />
	 </psjg:grid>
  
 
 
<script  type="text/javascript">
	$("#gview_chargesGridId_${_pageRef}${param.fromId} div.ui-jqgrid-titlebar").hide() ;	 
	chargesGridOnSelectRow1 =function(ev,data){	 
		chargesGridOnSelectRow("#"+data.id);
		};
	calculateChargesTotal1=function(ev,data){	 
		calculateChargesTotal(data.id,"${_pageRef}${param.fromId}");
		};
	
	/*$.unsubscribe("${_pageRef}_${param.gridId}_onSelectRow",chargesGridOnSelectRow1);
	$.unsubscribe("${_pageRef}_${param.gridId}_calculateChargesTotal",calculateChargesTotal1);*/
	$.subscribe("${_pageRef}${param.fromId}_onSelectRow",chargesGridOnSelectRow1);  
	$.subscribe("${_pageRef}${param.fromId}_calculateChargesTotal",calculateChargesTotal1);

</script>

</html>