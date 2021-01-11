<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<html>
	<head>
		<script type="text/javascript"  src="${pageContext.request.contextPath}/businesscommon/js/trxtypecharges/TrxTypeCharges.js"></script>
	</head>
	<body>
		<table border="0" id="trxType_${_pageRef}" align="center" class="ui-widget-content" width="100%">
			<tr>
				<td class="fldLabelView" width="20%">
					<ps:label key="CIF_No_key"/>
				</td>
				<td class="fldDataEdit center" width="10%" colspan="2">
					<ps:textfield id="fomTrxTypeChargesCO_popupCifNo_${_pageRef}" readonly="true"/>
				</td>
				<td class="fldLabelView" width="20%">
					<ps:label key="CIF_Name_key"/>
				</td>
				<td class="fldDataEdit center" width="40%">
					<ps:textfield id="fomTrxTypeChargesCO_popupCifName_${_pageRef}" readonly="true"/>
				</td>
			</tr>
		</table>
		<br/>		
		<ps:hidden id="trxTypeCharges_screenMode_${_pageRef}" value="${_popupReadOnlyMode}"></ps:hidden>
		<ps:form id="trxTypeChargesForm_${_pageRef}" useHiddenProps="true" >	
		<div id="trxTypeChargesGridDiv_Id_${_pageRef}" >
			<ps:url id="trxTypeChargesGrid" action="TrxTypeChargesList_loadTrxTypeChargesGrid" namespace="/path/fom" escapeAmp="false">
				<ps:param name="criteria.cifNo" value="%{cifCode}"/>
			</ps:url>

			<psjg:grid id="trxTypeChargesGrid_Id_${_pageRef}"
				dataType="json"
				href="%{trxTypeChargesGrid}" 
				pager="true"
				filter="false" 
				gridModel="gridModel" 
				rowNum="5" 
				rowList="5,10,15,20"
				viewrecords="true" 
				navigator="true" 
				navigatorAdd     ="${_popupBtnFlag}"
		        navigatorDelete  ="${_popupBtnFlag}"
		        navigatorEdit="false"
				navigatorRefresh="false" 
				navigatorSearch="false" 
				height="110" 
				altRows="true"
				pagerButtons="true"
				editinline="${_popupBtnFlag}"
		        shrinkToFit="true" 	
				addfunc="trxTypeChargesGrid_Id_addId"  
				delfunc="trxTypeChargesGrid_Id_deleteId"
				editurl="asfd"
				rownumbers="true"
				onSelectRowTopics ="trxTypeChargesGrid_Id_SelectLoad"
				onCompleteTopics="trxTypeChargesGrid_Id_CompleteLoad"
				
			>
				<psjg:gridColumn name="TRXTYPE_CODE" title="" index="TRXTYPE_CODE" colType="liveSearch"
					editable="true" sortable="true" search="false" id="TRXTYPE_CODE"
					dataAction="${pageContext.request.contextPath}/pathdesktop/CtsTrxTypeLookup_constructTransactionTypeForTrxTypeLimitCharges"
					paramList="" searchElement="CODE" resultList=""
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/CtsTrxTypeDependencyAction_dependencyByTrxTypeCodeOnly"
					params="trxCode:TRXTYPE_CODE_lookuptxt, showMessage:true"
					dependency="ctsTrxTypeVO.SHORT_DESC_ENG:TRX_TYPE_NAME,ctsTrxTypeVO.STATUS:TRX_TYPE_STATUS,ctsTrxTypeVO.CODE:TRXTYPE_CODE_lookuptxt" 
					afterDepEvent="trxTypeChargesCodeAfterDependency();"
					editoptions="{maxLength:'3'}"
				/>
				
				<psjg:gridColumn name="TRX_TYPE_NAME" title="" index="TRX_TYPE_NAME" colType="text"
					editable="false" sortable="true" search="false" id="TRX_TYPE_NAME" />
				
				<psjg:gridColumn name="trxTypeChargeSchemaHyprLink" index="trxTypeChargeSchemaHyprLink" title="" align="center" id="trxTypeChargeSchemaHyprLink"
					colType="text"  editable="false"  sortable="false" search="false" formatter="trxTypeChargesGrid_Id_ChargeSchemaBtnFormatter" />
			<%--		
				<psjg:gridColumn name="chargeSchemaBtn" index="chargeSchemaBtn" title="" align="center"
					colType="button"  editable="true" edittype="button" sortable="false" search="false" 
					editoptions="{value:'%{getText('Charges_Schema_key')}',onclick:'trxTypeChargesGrid_Id_ChargeSchemaBtn_Clicked()'}" />
			 --%>					
				<psjg:gridColumn name="CHARGE_CODE" title="" index="CHARGE_CODE" colType="liveSearch"
					editable="true" sortable="true" search="false" id="CHARGE_CODE" editoptions="{maxLength:'3'}"
					dataAction="${pageContext.request.contextPath}/pathdesktop/ChargesSchema_constructLookup"
					paramList="" searchElement="CODE" resultList=""
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/ChargesSchemaDependencyAction_dependencyByCode" 
					params="code:CHARGE_CODE_lookuptxt"
					dependency="chargesSchemaVO.BRIEF_NAME_ENG:CHARGE_NAME,chargesSchemaVO.CODE:CHARGE_CODE_lookuptxt" 
				/>
					
				 <psjg:gridColumn name="CHARGE_NAME" title="" index="CHARGE_NAME" colType="text"
					editable="false" sortable="true" search="false" id="CHARGE_NAME" />
				
				<psjg:gridColumn name="CHARGES_CY_POLICY"  title="" index="CHARGES_CY_POLICY" formatter="select"
					id="CHARGES_CY_POLICY" colType="select" editable="true" sortable="true"  edittype="select" loadOnce="true"
					editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/fom/TrxTypeChargesList_loadChargesPolicyList','chargesPolicyList', 'code', 'descValue');}
					,dataEvents: [{ type: 'change', fn: function(e) { trxTypeChargesGrid_onChangeTrxTypeChargesPolicy(e) } }]}" 
				/>
					
				<psjg:gridColumn name="CASH_ACCOUNT"  title="" index="CASH_ACCOUNT"  formatter="select"
					id="CASH_ACCOUNT" colType="select" editable="true" sortable="true"  edittype="select" 
					editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/fom/TrxTypeChargesList_loadCashAccountList','cashAccountList', 'code', 'descValue');}
					,dataEvents: [{ type: 'change', fn: function(e) { trxTypeChargesGrid_onChangeTrxTypeCashAccount(e) } }]}" 
				/>
				
				<psjg:gridColumn name="TRX_TYPE_STATUS"  title="" hidden="true" index="TRX_TYPE_STATUS"  colType="text" editable="false" id="TRX_TYPE_STATUS" />
					
			</psjg:grid>
		</div>
		
		<div id="trxTypeChargesSchemaDetailDiv_id_${_pageRef}" style="width:100%;"></div>
</ps:form>
	</body>
	<script type="text/javascript">
		trxTypeChargesGrid_onDocReady();
	</script>
</html>