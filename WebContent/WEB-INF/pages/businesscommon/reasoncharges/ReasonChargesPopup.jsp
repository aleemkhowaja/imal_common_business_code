<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<html>
	<head>
		<script type="text/javascript"  src="${pageContext.request.contextPath}/businesscommon/js/reasoncharges/ReasonCharges.js"></script>
	</head>
	<body>
		<table border="0" align="center" class="ui-widget-content" width="100%">
			<tr>
				<td class="fldLabelView" width="20%">
					<ps:label key="CIF_No_key"/>
				</td>
				<td class="fldDataEdit center" width="10%" colspan="2">
					<ps:textfield id="fomReasonChargesCO_popupCifNo_${_pageRef}" readonly="true"/>
				</td>
				<td class="fldLabelView" width="20%">
					<ps:label key="CIF_Name_key"/>
				</td>
				<td class="fldDataEdit center" width="40%">
					<ps:textfield id="fomReasonChargesCO_popupCifName_${_pageRef}" readonly="true"/>
				</td>
			</tr>
		</table>
		<br/>
		<ps:hidden id="reasonCharges_screenMode_${_pageRef}" value="${_popupReadOnlyMode}"></ps:hidden>
		<ps:hidden id="reasonChargesGrid_REASON_CODE_showCode_${_pageRef}" value="true"/>
		<ps:hidden id="callingScreen_${_pageRef}" value="%{callingScreen}"/>
		<ps:hidden id="checkApprovedByAccess_${_pageRef}" value="%{reasonChargesCO.checkApprovedByAccess}"/>
		<ps:form id="reasonChargesForm_${_pageRef}" useHiddenProps="true" >
		<table border="0" align="center" class="ui-widget-content" width="100%">
		<div id="reasonChargesGridDiv_Id_<ps:property value="_pageRef" escapeHtml="true"/>" >
			<ps:url id="reasonChargesGrid" action="ReasonChargesList_loadReasonChargesGrid" namespace="/path/fom" escapeAmp="false">
				<ps:param name="criteria.cifNo" value="%{cifCode}"/>
				<ps:param name="criteria.ciftype" value="%{cif_Type}"/>
				<ps:param name="criteria.screenName" value="%{callingScreen}"/>
				<ps:param name="compCodeCif" value="criteria.compCodeCif"/>
				<ps:param name="criteria.sectionKey" value="%{_pageRef}"/>
			</ps:url>

			<psjg:grid id="reasonChargesGrid_Id_${_pageRef}"
				dataType="json"
				href="%{reasonChargesGrid}" 
				pager="true"
				filter="false" 
				gridModel="gridModel" 
				rowNum="5" 
				rowList="5,10,15,20"
				viewrecords="true" 
				navigator="true" 
				navigatorAdd     ="${_popupBtnAddFlag}"
		        navigatorDelete  ="${_popupBtnDelFlag}"
		        navigatorEdit="false"
				navigatorRefresh="false" 
				navigatorSearch="false" 
				height="110"
				width="500" 
				altRows="true"
				pagerButtons="true"
				editinline="${_popupBtnDelFlag}"
		        shrinkToFit="true" 	
				addfunc="reasonChargesGrid_Id_addId"  
				delfunc="reasonChargesGrid_Id_deleteId"
				editurl="asfd"
				rownumbers="true"
			>
				<psjg:gridColumn name="REASON_CODE" title="" index="REASON_CODE" colType="liveSearch" editoptions="{maxLength:'3'}"
					editable="${_popupBtnAddFlag}" sortable="true" search="false" id="REASON_CODE"
					dataAction="${pageContext.request.contextPath}/pathdesktop/ReasonLookup_drawingReasonGrid"
					paramList="reasonCode:reasonChargesGrid_REASON_CODE_showCode_${_pageRef}" searchElement="CODE" resultList=""
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/ReasonDependencyAction_dependencyByCode"
					params="reasonCode:REASON_CODE_lookuptxt"
					dependency="reasonVO.BRIEF_NAME_ENG:REASON_NAME,reasonVO.CODE:REASON_CODE_lookuptxt" 
				/>
				
				<psjg:gridColumn name="REASON_NAME" title="" index="REASON_NAME" colType="text"
					editable="false" sortable="true" search="false" id="REASON_NAME" />
				
				<psjg:gridColumn name="reasonChargeSchemaHyprLink" index="reasonChargeSchemaHyprLink" title="" align="center" id="reasonChargeSchemaHyprLink"
					colType="text"  editable="false"  sortable="false" search="false" formatter="reasonChargesGrid_Id_ChargeSchemaBtnFormatter" />
			<%--		
				<psjg:gridColumn name="chargeSchemaBtn" index="chargeSchemaBtn" title="" align="center"
					colType="button"  editable="true" edittype="button" sortable="false" search="false" 
					editoptions="{value:'%{getText('Charges_Schema_key')}',onclick:'reasonChargesGrid_Id_ChargeSchemaBtn_Clicked()'}" />
			--%>					
				<psjg:gridColumn name="CHARGE_CODE" title="" index="CHARGE_CODE" colType="liveSearch" editoptions="{maxLength:'3'}"
					editable="true" sortable="true" search="false" id="CHARGE_CODE" 
					dataAction="${pageContext.request.contextPath}/pathdesktop/ChargesSchema_constructLookup"
					paramList="" searchElement="CODE" resultList=""
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/ChargesSchemaDependencyAction_dependencyByCode" 
					params="code:CHARGE_CODE_lookuptxt"
					dependency="chargesSchemaVO.BRIEF_NAME_ENG:CHARGE_NAME,chargesSchemaVO.CODE:CHARGE_CODE_lookuptxt" 
				/>
					
				 <psjg:gridColumn name="CHARGE_NAME" title="" index="CHARGE_NAME" colType="text"
					editable="false" sortable="true" search="false" id="CHARGE_NAME" />
					
				<psjg:gridColumn name="ENTITY_TYPE" title="" index="ENTITY_TYPE" colType="text"
					editable="false" sortable="true" search="false" id="ENTITY_TYPE" hidden="true"/>
				
			</psjg:grid>
		</div>
		</table>
		<div id="reasonChargesSchemaDetailDiv_id_<ps:property value="_pageRef" escapeHtml="true"/>" style="width:100%;"></div>
</ps:form>
	</body>
	<script type="text/javascript">
		reasonChargesGrid_onDocReady();
	</script>
</html>