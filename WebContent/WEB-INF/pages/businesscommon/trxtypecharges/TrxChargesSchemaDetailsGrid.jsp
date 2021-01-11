<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<html>
	<head>
		<script type="text/javascript"  src="${pageContext.request.contextPath}/businesscommon/js/chargeschema/TrxChargeSchema.js"></script>
	</head>
	<body>			
			<div id="trxChargesSchemaDetailsGrid_main_${_pageRef}">
			<ps:url id="trxChargesSchemaDetailsGrid" action="ChargesSchemaGridAction_chargesSchemaGrid" namespace="/path/fom" escapeAmp="false">
				<ps:param name="schemaCode" value="%{schemaCode}"/>
				<ps:param name="_pageRef" value="_pageRef"></ps:param>
			</ps:url>

			<psjg:grid id="trxChargesSchemaGrid_Id_${_pageRef}"
				caption="%{getText('Charge_Schema_Details_key')}"
				dataType="json"
				href="%{trxChargesSchemaDetailsGrid}" 
				pager="true"
				filter="false" 
				gridModel="gridModel" 
				rowNum="5" 
				rowList="5,10,15,20"
				viewrecords="true" 				
				height="110" 
				altRows="true"
				pagerButtons="true"
				editinline="false"
		        shrinkToFit="true" 	
				addfunc="trxChargesSchemaGrid_Id_addId"  
				delfunc="trxChargesSchemaGrid_Id_deleteId"
				editurl="asfd"
				rownumbers="true"
			>
					<psjg:gridColumn name="chargeSchemaHyprLink" index="chargeSchemaHyprLink" title="" align="center"
					colType="text"  editable="false"  sortable="false" search="false" formatter="trxTypeChargesGrid_Id_ChargeBtnFormatter" />
					
			<%-- 	<psjg:gridColumn name="CHARGE_CODE" title="%{getText('Charge_Code_key')}" index="CHARGE_CODE" colType="liveSearch"
					editable="true" sortable="true" search="false" id="CHARGE_CODE" 
					dataAction="${pageContext.request.contextPath}/pathdesktop/ChargesSchema_constructLookup"
					paramList="" searchElement="CODE" resultList=""
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/ChargesSchemaDependencyAction_dependencyByCode" 
					params="code:CHARGE_CODE_lookuptxt"
					dependency="chargesSchemaVO.BRIEF_NAME_ENG:CHARGE_NAME,chargesSchemaVO.CODE:CHARGE_CODE_lookuptxt" 
					/>
			--%>
					<psjg:gridColumn name="ctsChargesSchemaVO.CHARGE_CODE" title="%{getText('Charge_Code_key')}" index="CHARGE_CODE" colType="text" 
					editable="true" sortable="true" id="CHARGE_CODE" />	    
					
					<psjg:gridColumn name="CHARGES_DESC" title="%{getText('desc_eng_key')}" index="CHARGES_DESC" colType="text" 
					editable="true" sortable="true" id="CHARGES_DESC" />	               	 

					<psjg:gridColumn name="ctsChargesSchemaVO.CHARGE_TYPE"  title="%{getText('Charge_Type_For_Delivery_Channels_key')}" index="CHARGE_TYPE" 
					id="CHARGE_TYPE" colType="select" editable="true" sortable="true"  edittype="select"  
					editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/fom/ChargesSchemaGridAction_loadChargeType','chargeTypeList', 'code', 'descValue');}
					,dataEvents: [{ type: 'change', fn: function(e) { trxChargesSchemaGrid_onChangeTrxChargeType(e) } }]}" 
					/>

				
			</psjg:grid>
		</div>


<div id="maintenenceChargesSchemaDetailMainDiv_${_pageRef}" >
			</div>
	</body>
</html>