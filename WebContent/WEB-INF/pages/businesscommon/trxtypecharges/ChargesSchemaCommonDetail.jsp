<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<html>
	<head></head>
	<body>
	<div id="chargesSchemaDetailDiv_content_id_main_${_pageRef}">
		<div id="chargesSchemaDetailDiv_content_id_${_pageRef}">
			<br/><div class="ui-state-active">&nbsp;<ps:label for="" id="charges_schema_${_pageRef}" key="Charges_Schema_key"/></div>
			<table border="0" align="center" class="ui-widget-content" width="100%">
				<tr>
					<td width="20%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="20%"></td>
					<td width="20%"></td>
					<td width="20%"></td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Schema_Code_key" id="lbl_chargesSchemaVO_CODE_${_pageRef}" for="chargesSchemaVO_CODE_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center">
						<ps:textfield id="chargesSchemaVO_CODE_${_pageRef}" name="chargesSchemaVO.CODE" readonly="true"/>
					</td>
					<td colspan="4"></td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Brief_Name_key" id="lbl_chargesSchemaVO_BRIEF_NAME_ENG_${_pageRef}" for="chargesSchemaVO_BRIEF_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textfield id="chargesSchemaVO_BRIEF_NAME_ENG_${_pageRef}" name="chargesSchemaVO.BRIEF_NAME_ENG" readonly="true"/>
					</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Long_Desc_Eng_key" id="lbl_chargesSchemaVO_LONG_NAME_ENG_${_pageRef}" for="chargesSchemaVO_LONG_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield id="chargesSchemaVO_LONG_NAME_ENG_${_pageRef}" name="chargesSchemaVO.LONG_NAME_ENG" readonly="true"/>
					</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="4"></td>
					<td class="fldDataEdit center">
						<ps:textfield id="chargesSchemaVO_BRIEF_NAME_ARAB_${_pageRef}" name="chargesSchemaVO.BRIEF_NAME_ARAB" readonly="true"
							cssStyle="direction:rtl"
						/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Brief_Name_Arab_key" id="lbl_chargesSchemaVO_BRIEF_NAME_ARAB_${_pageRef}" for="chargesSchemaVO_BRIEF_NAME_ARAB_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td colspan="2"></td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield id="chargesSchemaVO_LONG_NAME_ARAB_${_pageRef}" name="chargesSchemaVO.LONG_NAME_ARAB" readonly="true"
							cssStyle="direction:rtl"
						/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Long_Desc_Arab_key" id="lbl_chargesSchemaVO_LONG_NAME_ARAB_${_pageRef}" for="chargesSchemaVO_LONG_NAME_ARAB_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="center"> 
						<ps:checkbox name="profitCharge" id="PROFIT_CHARGE_${_pageRef}" disabled="true"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Profit_Charge_key" id="lbl_PROFIT_CHARGE_${_pageRef}" for="PROFIT_CHARGE_${_pageRef}"/>
					</td>
					<td align="center"> 
						<ps:checkbox name="passChargesSeperately" id="PASS_CHRG_SEP_FRM_TVA_${_pageRef}" disabled="true"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Pass_Charges_Separately_from_TVA_on_Delivery_Channels_key" id="lbl_PASS_CHRG_SEP_FRM_TVA_${_pageRef}" for="PASS_CHRG_SEP_FRM_TVA_${_pageRef}"/>
					</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="6"></td>
				</tr>
			</table>
		</div>		
		
			
			<div id="trxChargesSchemaDetailsGridDiv_id_${_pageRef}" style="width:100%;">
			     	<%@include file="TrxChargesSchemaDetailsGrid.jsp" %>
			</div>
			
		
		</div>
	</body>
</html>