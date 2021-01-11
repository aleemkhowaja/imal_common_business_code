<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<html>
<script type="text/javascript">
var tiers_key = "<ps:text name='Tiers_key' />";
var foreign_CY_Charge_key = "<ps:text name='Foreign_CY_Charge_key' />";
</script>
	<head></head>
	<body>
		<div id="trxChargesSchemaBackBtnDiv_id_${_pageRef}" style="width:100%;">
			     <psj:submit button="true" type="button" id="trx_charges_Details_back_btn_${_pageRef}" onclick="trxChargesBackButtonClick()">
							<ps:label id="lbl_trx_charges_Details_back_btn_${_pageRef}" key='Back_key' />
						</psj:submit>
			</div>
		<div id="maintenenceChargesSchemaDetailDiv_${_pageRef}">
			<br/><div class="ui-state-active">&nbsp;<ps:label for="" id="charges_schema_${_pageRef}" key="Maintenence_charges_key"/></div>
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
						<ps:label key="Code_key" id="lbl_ctsChargesVO_CODE_${_pageRef}" for="ctsChargesVO_CODE_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center">					
						<ps:textfield id="ctsChargesVO_CODE_${_pageRef}" name="ctsChargesCO.ctsChargesVO.CODE" readonly="${_popupReadOnlyMode}"/>
					</td>
					<td colspan="2"></td>
					<td class="fldLabelView">
						<ps:label key="Charges_key" id="lbl_ctsChargesVO_CHARGE_TYPE_${_pageRef}" for="ctsChargesVO_CHARGE_TYPE_${_pageRef}"/>
					</td>		
					 <td class="fldDataEdit center" >
						<ps:select list="chargeType" name="ctsChargesCO.ctsChargesVO.CHARGE_TYPE" id="ctsChargesVO_CHARGE_TYPE_${_pageRef}" disabled="${_popupReadOnlyMode}" emptyOption="true"/>
					</td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Brief_Description_key" id="lbl_ctsChargesVO_BRIEF_NAME_ENG_${_pageRef}" for="ctsChargesVO_BRIEF_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textfield id="ctsChargesVO_BRIEF_NAME_ENG_${_pageRef}" name="ctsChargesCO.ctsChargesVO.BRIEF_NAME_ENG" readonly="${_popupReadOnlyMode}"/>
					</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Long_Description_key" id="lbl_ctsChargesVO_LONG_NAME_ENG_${_pageRef}" for="ctsChargesVO_LONG_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield id="ctsChargesVO_LONG_NAME_ENG_${_pageRef}" name="ctsChargesCO.ctsChargesVO.LONG_NAME_ENG" readonly="${_popupReadOnlyMode}"/>
					</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="3"></td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textfield id="ctsChargesVO_BRIEF_NAME_ARAB_${_pageRef}" name="ctsChargesCO.ctsChargesVO.BRIEF_NAME_ARAB" readonly="${_popupReadOnlyMode}"
							cssStyle="direction:rtl"
						/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Brief_Name_Arab_key" id="lbl_ctsChargesVO_BRIEF_NAME_ARAB_${_pageRef}" for="ctsChargesVO_BRIEF_NAME_ARAB_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td colspan="2"></td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield id="ctsChargesVO_LONG_NAME_ARAB_${_pageRef}" name="ctsChargesCO.ctsChargesVO.LONG_NAME_ARAB" readonly="${_popupReadOnlyMode}"
							cssStyle="direction:rtl"
						/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Long_Desc_Arab_key" id="lbl_ctsChargesVO_LONG_NAME_ARAB_${_pageRef}" for="ctsChargesVO_LONG_NAME_ARAB_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="amount_key" id="lbl_ctsChargesVO_AMOUNT_${_pageRef}" for="ctsChargesVO_AMOUNT_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textfield id="ctsChargesVO_AMOUNT_${_pageRef}" name="ctsChargesCO.ctsChargesVO.AMOUNT" readonly="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldDataEdit center">
						<ps:textfield id="ctsChargesCO_CY_NAME_${_pageRef}" name="ctsChargesCO.CY_NAME" readonly="${_popupReadOnlyMode}"/>
					</td>
					<td>
						<%/* 
							<psj:a id="b_detail_Tiers_${_pageRef}" button="true" buttonIcon="ui-icon-carat-1-s" cssStyle="width:100px;"
								onclick="fOMTrx_showHideTiersGrid()">
								<ps:label key='Tiers_key' for="b_detail_Tiers_${_pageRef}"/>
							</psj:a>
						*/%>
					</td>
					<td>
						<%/* 
							<psj:a id="cb_charge_cy_${_pageRef}" button="true" buttonIcon="ui-icon-carat-1-s" cssStyle="width:150px;"
								onclick="fOMTrx_showHideForeignCYChargeGrid()">
								<ps:label key='Foreign_CY_Charge_key' for="cb_charge_cy_${_pageRef}"/>
							</psj:a>
						*/%>
					</td>
				</tr>
				
				
				
				
				<tr>
					<td class="fldLabelView">
						<ps:label key="Charge_Branch_key" id="lbl_ctsChargesVO.CHRG_BR_${_pageRef}" for="ctsChargesVO.CHRG_BR_${_pageRef}"/>
					</td>
					
					<td class="fldDataEdit center" colspan="2">
						<ps:select list="chargeBranch" name="ctsChargesCO.ctsChargesVO.CHRG_BR" id="ctsChargesVO.CHRG_BR_${_pageRef}" disabled="${_popupReadOnlyMode}" emptyOption="true"/>
					</td>
					
					<td ></td>			
					<td class="fldLabelView">
						<ps:label key="Account_Branch_key" id="lbl_ctsChargesVO_ACC_BR_${_pageRef}" for="ctsChargesVO_ACC_BR_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center">
						<ps:textfield id="ctsChargesVO_ACC_BR_${_pageRef}" name="ctsChargesCO.ctsChargesVO.ACC_BR" readonly="${_popupReadOnlyMode}"/>
					</td>			
					
				</tr>
				
				<tr>
					<td class="fldLabelView">
						<ps:label key="Credit_Account_key" id="lbl_ctsChargesVO.CHRG_BR_${_pageRef}" />
					</td>	
					<td colspan="2">
						<ps:account 
							accountLabel="" 
							inputIds="accCy_${_pageRef}~accGl_${_pageRef}~accCif_${_pageRef}~accSl_${_pageRef}~accDesc_${_pageRef}" 
							inputNames="ctsChargesCO.ctsChargesVO.ACC_CY~ctsChargesCO.ctsChargesVO.ACC_GL~ctsChargesCO.ctsChargesVO.ACC_CIF~ctsChargesCO.ctsChargesVO.ACC_SL~ctsChargesCO.ACC_NAME"
							inputSizes    ="60~60~60~80~N"
							readOnly      ="true~true~true~true~true"
							mode          ="number~number~number~livesearch~text"
							rowLocation   ="1~1~1~1~2" 
							colSpan       ="1~1~1~1~5" 
							paramList	  ="N~N~N~N~N"
							parameter     ="N~N~N~N~N"
							onblur	      ="N~N~N~N~N"
							dependencySrc ="N~N~N~N~N"
							dependency    ="N~N~N~N~N"
							actionName    ="N~N~N~N~N"
							searchElement ="N~N~N~N~N"							
							>						
						</ps:account>
					</td>					
				</tr>
				 
				<tr>
					<td class="fldLabelView">
						<ps:label key="Debit_Account_key" id="lbl_ctsChargesVO.CHRG_BR_${_pageRef}" for="ctsChargesCO.ctsChargesVO.CHRG_BR_${_pageRef}"/>
					</td>	
					
					<td colspan="2">
						<ps:account 
							accountLabel  ="" 
							inputIds      ="accCy_${_pageRef}~accGl_${_pageRef}~accCif_${_pageRef}~accS1l_${_pageRef}~accDesc_${_pageRef}" 
							inputNames    ="ctsChargesCO.ctsChargesVO.DR_ACC_CY~ctsChargesCO.ctsChargesVO.DR_ACC_GL~ctsChargesCO.ctsChargesVO.DR_ACC_CIF~ctsChargesCO.ctsChargesVO.DR_ACC_SL~ctsChargesCO.DR_ACC_NAME"
							inputSizes    ="60~60~60~80~N"
							readOnly      ="true~true~true~true~true"
							mode          ="number~number~number~livesearch~text"
							rowLocation   ="1~1~1~1~2" 
							colSpan       ="1~1~1~1~5" 
							paramList	  ="N~N~N~N~N"
							parameter     ="N~N~N~N~N"
							onblur	      ="N~N~N~N~N"
							dependencySrc ="N~N~N~N~N"
							dependency    ="N~N~N~N~N"
							actionName    ="N~N~N~N~N"
							searchElement ="N~N~N~N~N"							
							>						
						</ps:account>
					</td>							
				</tr>
				
				<tr>
					<td class="fldLabelView">
						<ps:label key="Criteria_key" id="lbl_ctsChargesVO_DR_CRITERIA_${_pageRef}" for="ctsChargesVO_DR_CRITERIA_${_pageRef}"/>
					</td>	
					 <td class="fldDataEdit center" colspan="2">
						<ps:select list="dr_criteria" name="ctsChargesCO.ctsChargesVO.DR_CRITERIA" id="ctsChargesVO_DR_CRITERIA_${_pageRef}" disabled="${_popupReadOnlyMode}" emptyOption="true"/>
					</td>					
					<td>
					<%--
						<ps:textfield id="ctsChargesVO.ACC_CY_${_pageRef}" name="ctsChargesCO.ctsChargesVO.ACC_CY" readonly="${_popupReadOnlyMode}"/>
					 --%>
					</td>
					<td>
						<%/* 
							<psj:a id="cb_excempted_in_Branches_${_pageRef}" button="true" buttonIcon="ui-icon-carat-1-s" cssStyle="width:150px;"
								onclick="fOMTrx_showHideExcemptedInBranchesGrid()">
								<ps:label key='Exempted_In_Branches_key' for="cb_excempted_in_Branches_${_pageRef}"/>
							</psj:a>
						*/%>
					</td>	
					<td></td>		
				</tr>
						
				<tr>
					<td colspan="6">
						<div class="ui-state-active"></div>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td align="center"> 
						<ps:checkbox name="ctsChargesCO.allowModifyClear" id="ctsChargesVO_ALLOW_CLEARING_${_pageRef}" disabled="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Allow_To_Modify_And_Clear_key" id="lbl_ctsChargesVO_ALLOW_CLEARING_${_pageRef}" for="ctsChargesVO_ALLOW_CLEARING_${_pageRef}"/>
					</td>
					<td align="center"> 
						<ps:checkbox name="ctsChargesCO.basedOnMosarafa" id="ctsChargesVO_BASED_ON_MOSARAFA_${_pageRef}" disabled="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Based_On_Mosarafa_key" id="lbl_ctsChargesVO_BASED_ON_MOSARAFA_${_pageRef}" for="ctsChargesVO_BASED_ON_MOSARAFA_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="center"> 
						<ps:checkbox name="ctsChargesCO.allowModify" id="ctsChargesVO_ALLOW_MODIFY_${_pageRef}" disabled="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Allow_Modify_key" id="lbl_ctsChargesVO_ALLOW_MODIFY_${_pageRef}" for="ctsChargesVO_ALLOW_MODIFY_${_pageRef}"/>
					</td>
					<td align="center"> 
						<ps:checkbox name="ctsChargesCO.passSeperately" id="ctsChargesVO_PASS_SEPARATELY_${_pageRef}" disabled="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Pass_Separately_key" id="lbl_ctsChargesVO_PASS_SEPARATELY_${_pageRef}" for="ctsChargesVO_PASS_SEPARATELY_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="center"> 
						<ps:checkbox name="ctsChargesCO.deductFromTrx" id="ctsChargesVO_DEDUCT_FROM_TRX_${_pageRef}" disabled="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Deduct_amount_from_trx_key" id="lbl_ctsChargesVO_DEDUCT_FROM_TRX_${_pageRef}" for="ctsChargesVO_DEDUCT_FROM_TRX_${_pageRef}"/>
					</td>
					<td align="center"> 
						<ps:checkbox name="ctsChargesCO.applyVat" id="ctsChargesVO_APPLY_TVA_${_pageRef}" disabled="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Apply_vat_key" id="lbl_ctsChargesVO_APPLY_TVA_${_pageRef}" for="ctsChargesVO_APPLY_TVA_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="center"> 
						<ps:checkbox name="ctsChargesCO.fixChkBookCharge" id="ctsChargesVO_FIX_CHARGES_${_pageRef}" disabled="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Fix_chequeBook_charges_key" id="lbl_ctsChargesVO_FIX_CHARGES_${_pageRef}" for="ctsChargesVO_FIX_CHARGES_${_pageRef}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="VAT_Code_key" id="lbl_ctsChargesVO_VAT_CODE_${_pageRef}" for="ctsChargesVO_VAT_CODE_${_pageRef}"/>
					</td>					
					<td class="fldDataEdit center">
						<ps:textfield id="ctsChargesVO_VAT_CODE_${_pageRef}" name="ctsChargesCO.ctsChargesVO.VAT_CODE" readonly="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldDataEdit center">
						<ps:textfield id="VAT_DESC_${_pageRef}" name="ctsChargesCO.VAT_DESC" readonly="${_popupReadOnlyMode}"/>
					</td>					
				</tr>
				<tr>
					<td></td>
					<td align="center"> 
						<ps:checkbox name="ctsChargesCO.considerOnceMultiTran" id="ctsChargesVO.CONSIDER_ONCE_FOR_MULTI_TRX_${_pageRef}" disabled="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Consider_once_for_multi_transactions_key" id="lbl_ctsChargesVO.CONSIDER_ONCE_FOR_MULTI_TRX_${_pageRef}" for="ctsChargesCO.ctsChargesVO.CONSIDER_ONCE_FOR_MULTI_TRX_${_pageRef}"/>
					</td>								
				</tr>
				<tr>
					<td colspan="6">
						<div class="ui-state-active"></div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="center"> 
						<ps:checkbox name="ctsChargesCO.chargeExceedAmt" id="ctsChargesVO.CHRG_ON_EXCEED_${_pageRef}" disabled="${_popupReadOnlyMode}"/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Charges_on_exceeding_amount_key" id="lbl_ctsChargesVO.CHRG_ON_EXCEED_${_pageRef}" for="ctsChargesCO.ctsChargesVO.CHRG_ON_EXCEED_${_pageRef}"/>
					</td>								
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Exceed_Amount_key" id="lbl_ctsChargesVO_EXCEED_AMT_${_pageRef}" for="ctsChargesVO_EXCEED_AMT_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center">
						<ps:textfield id="ctsChargesVO_EXCEED_AMT_${_pageRef}" name="ctsChargesCO.ctsChargesVO.EXCEED_AMT" readonly="${_popupReadOnlyMode}"/>
					</td>
					<td colspan="2"></td>			
					<td class="fldLabelView">
						<ps:label key="Charge_Percentage_key" id="lbl_ctsChargesVO_CHRG_PERCENTAGE_${_pageRef}" for="ctsChargesVO_CHRG_PERCENTAGE_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center">
						<ps:textfield id="ctsChargesVO_CHRG_PERCENTAGE_${_pageRef}" name="ctsChargesCO.ctsChargesVO.CHRG_PERCENTAGE" readonly="${_popupReadOnlyMode}"/>
					</td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Minimum_Amount_key" id="lbl_ctsChargesVO_MIN_AMT_${_pageRef}" for="ctsChargesVO_MIN_AMT_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center">
						<ps:textfield id="ctsChargesVO_MIN_AMT_${_pageRef}" name="ctsChargesCO.ctsChargesVO.MIN_AMT" readonly="${_popupReadOnlyMode}"/>
					</td>
					<td colspan="2"></td>			
					<td class="fldLabelView">
						<ps:label key="Maximum_Amount_key" id="lbl_ctsChargesVO_MAX_${_pageRef}" for="ctsChargesVO_MAX_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center">
						<ps:textfield id="ctsChargesVO_MAX_${_pageRef}" name="ctsChargesCO.ctsChargesVO.MAX" readonly="${_popupReadOnlyMode}"/>
					</td>								
				</tr>
			<ps:if test='%{ctsChargesCO.showTiersGrid}'>		
				<tr id="fom_tiresdetailsGridGridTr_${_pageRef}">
					<td colspan="5">	
						<div id="fom_tiresdetailsGridDiv_${_pageRef}">
							<ps:url id="tiresdetailsGrid" action="MaintenenceChargesGridAction_loadTireDetailsGrid" namespace="/path/fom" escapeAmp="false">
								<ps:param name="criteria.currencyCode" value="%{criteria.currencyCode}"/>
								<ps:param name="criteria.code" value="%{schemaCode}"/>
								<ps:param name="_pageRef" value="_pageRef"></ps:param>
							</ps:url>
				
							<psjg:grid id="tiresdetailsGrid_Id_${_pageRef}"
								caption="%{getText('Tiers_key')}"
								dataType="json"
								href="%{tiresdetailsGrid}" 
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
								addfunc=""  
								delfunc=""
								editurl="asfd"
								rownumbers="true"
							>			
									
								<psjg:gridColumn name="FROM_AMT" title="%{getText('From_amount_key')}" index="FROM_AMT" colType="number"
									editable="false" sortable="true" search="false" id="FROM_AMT" />	
								<psjg:gridColumn name="TO_AMT" title="%{getText('To_amount_key')}" index="TO_AMT" colType="number"
									editable="false" sortable="true" search="false" id="TO_AMT" />		
								<psjg:gridColumn name="PERCENTAGE" title="%{getText('Percentage_key')}" index="PERCENTAGE" colType="number"
									editable="false" sortable="true" search="false" id="PERCENTAGE" />		
								<psjg:gridColumn name="MIN_AMT" title="%{getText('Minimum_Amount_key')}" index="MIN_AMT" colType="number"
									editable="false" sortable="true" search="false" id="MIN_AMT" />				 
								<psjg:gridColumn name="MAX_AMT" title="%{getText('Maximum_Amount_key')}" index="MAX_AMT" colType="number"
									editable="false" sortable="true" search="false" id="MAX_AMT" />				 
								<psjg:gridColumn name="DISC_AMT" title="%{getText('Discount_Amount_key')}"  index="DISC_AMT" colType="number"
									editable="false" sortable="true" search="false" id="DISC_AMT" />	
								<psjg:gridColumn name="CY_CODE" title="" index="CY_CODE" colType="number" hidden="true"
									editable="false" sortable="true" search="false" id="CY_CODE" />	
								<psjg:gridColumn name="DECIMAL_POINTS" title="" index="DECIMAL_POINTS" colType="number" hidden="true"
									editable="false" sortable="true" search="false" id="DECIMAL_POINTS" />	
							</psjg:grid>
						</div>
					</td>
					<td></td>
				</tr>
			</ps:if>
			<ps:if test='%{ctsChargesCO.showFyChargesGrid}'>	
				<tr id="fom_foreignCYChargeGridTr_${_pageRef}">
					<td colspan="5">
						<div id="fom_foreignCYChargeGridDiv_${_pageRef}">
							<ps:url id="foreignCYChargeGrid" action="MaintenenceChargesGridAction_loadForeignCYChargeGrid" namespace="/path/fom" escapeAmp="false">
								<ps:param name="criteria.code" value="%{schemaCode}"/>
								<ps:param name="_pageRef" value="_pageRef"></ps:param>
							</ps:url>
		
							<psjg:grid id="foreignCYChargeGrid_Id_${_pageRef}"
								caption="%{getText('Foreign_CY_Charge_key')}"
								dataType="json"
								href="%{foreignCYChargeGrid}" 
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
								addfunc=""  
								delfunc=""
								editurl=""
								rownumbers="true"
							>			
								<psjg:gridColumn name="ctsChargesCurrencyVO.CY_CODE" title="%{getText('Currency_key')}" index="ctsChargesCurrencyVO.CY_CODE" colType="number"
									editable="false" sortable="true" search="false" id="ctsChargesCurrencyVO.CY_CODE" />	
								<psjg:gridColumn name="ctsChargesCurrencyVO.AMOUNT" title="%{getText('amount_key')}" index="ctsChargesCurrencyVO.AMOUNT" colType="number"
									editable="false" sortable="true" search="false" id="ctsChargesCurrencyVO.AMOUNT" formatter="currencyFmatter" formatCol="amtFormat"/>		
								<psjg:gridColumn name="currencyVO.BRIEF_DESC_ENG" title="%{getText('')}" index="currencyVO.BRIEF_DESC_ENG" colType="text"
									editable="false" sortable="true" search="false" id="currencyVO.BRIEF_DESC_ENG" />	
								<psjg:gridColumn title="" name="amtFormat" colType="number" hidden="true" />	
								<psjg:gridColumn title="" name="ctsChargesCurrencyVO.CHARGE_CODE" colType="number" hidden="true" />	
								<psjg:gridColumn name="tiersHyprLink" index="tiersHyprLink" title="" align="center"
								colType="text"  editable="false"  sortable="false" search="false" formatter="foreignCYChargeGrid_Id_TiersBtnFormatter" />
							</psjg:grid>
						</div>
					</td>
					<td></td>
				</tr>
			</ps:if>
				<%/* 
				<tr style="visibility: collapse;" id="fom_foreignCYChargeTiresdetailsGridGridTr_${_pageRef}" align="center">
					<td colspan="5">	
						<ps:url id="foreignCYChargeTiresdetailsGrid" action="MaintenenceChargesGridAction_loadTireDetailsGrid" namespace="/path/fom" escapeAmp="false">
							<ps:param name="criteria.currencyCode" value="%{criteria.currencyCode}"/>
							<ps:param name="criteria.code" value="%{schemaCode}"/>
							<ps:param name="_pageRef" value="_pageRef"></ps:param>
						</ps:url>
			
						<psjg:grid 
							id="foreignCYChargeTiresdetailsGrid_Id_${_pageRef}"
							caption="%{getText('Foreign_CY_Charge_key')}   -  %{getText('Tiers_key')}"
							dataType="json"
							pager="false"
							pagerButtons="false"
							filter="false" 
							gridModel="gridModel" 
							viewrecords="true" 
							navigator="false" 
							height="110" 
							altRows="true"
							editinline="false"
					        shrinkToFit="true" 	
							rownumbers="true"
							hidegrid="false"
						>			
								
							<psjg:gridColumn name="FROM_AMT" title="%{getText('From_amount_key')}" index="FROM_AMT" colType="text"
								editable="false" sortable="true" search="false" id="FROM_AMT" />	
							<psjg:gridColumn name="TO_AMT" title="%{getText('To_amount_key')}" index="TO_AMT" colType="text"
								editable="false" sortable="true" search="false" id="TO_AMT" />		
							<psjg:gridColumn name="PERCENTAGE" title="" index="PERCENTAGE" colType="text"
								editable="false" sortable="true" search="false" id="PERCENTAGE" />		
							<psjg:gridColumn name="MIN_AMT" title="%{getText('Minimum_Amount_key')}" index="MIN_AMT" colType="text"
								editable="false" sortable="true" search="false" id="MIN_AMT" />				 
							<psjg:gridColumn name="MAX_AMT" title="%{getText('Maximum_Amount_key')}" index="MAX_AMT" colType="text"
								editable="false" sortable="true" search="false" id="MAX_AMT" />				 
							<psjg:gridColumn name="DISC_AMT" title="%{getText('Discount_Amount_key')}"  index="DISC_AMT" colType="text"
								editable="false" sortable="true" search="false" id="DISC_AMT" />	
							<psjg:gridColumn name="CY_CODE" title="" index="CY_CODE" colType="text" hidden="true"
								editable="false" sortable="true" search="false" id="CY_CODE" />	
							<psjg:gridColumn name="DECIMAL_POINTS" title="" index="DECIMAL_POINTS" colType="text" hidden="true"
								editable="false" sortable="true" search="false" id="DECIMAL_POINTS" />	
							
						</psjg:grid>
					</td>
					<td></td>
				</tr>
				*/%>
				<tr id="fom_excemptedInBranchesGridTr_${_pageRef}">
					<td colspan="5">
						<ps:url id="excemptedInBranchesGrid" action="MaintenenceChargesGridAction_loadExcemptedInBranchesGrid" namespace="/path/fom" escapeAmp="false">
							<ps:param name="criteria.code" value="%{schemaCode}"/>
							<ps:param name="_pageRef" value="_pageRef"></ps:param>
						</ps:url>
						<psjg:grid id="excemptedInBranchesGrid_Id_${_pageRef}"
							dataType="json"
							caption="%{getText('Exempted_In_Branches_key')}"
							href="%{excemptedInBranchesGrid}" 
							pager="true"
							filter="false" 
							gridModel="gridModel" 
							rowNum="5" 
							rowList="5,10,15,20"
							viewrecords="true" 				
							height="110" 
							altRows="true"
							pagerButtons="false"
							editinline="false"
					        shrinkToFit="true" 	
							addfunc=""  
							delfunc=""
							editurl="asfd"
							rownumbers="true"
						>			
											
							<psjg:gridColumn name="ctsChargesExemptedBranchVO.BRANCH_CODE" title="%{getText('Branch_key')}" index="BRANCH_CODE" colType="text" 
								editable="true" sortable="true" id="BRANCH_CODE" />	     
				                         	
				            <psjg:gridColumn name="BRANCH_DESC" title="%{getText('desc_eng_key')}" index="BRANCH_DESC" colType="text" 
								editable="true" sortable="true" id="BRANCH_CODE" />	           
							
							<psjg:gridColumn name="ctsChargesExemptedBranchVO.TRX_BR"		title="%{getText('Exempt_Trx_Branch_key')}" 			index="TRX_BR" 		
							colType="checkbox" 	editable="true" 	sortable="true" 		id="TRX_BR"  edittype="checkbox" formatter="checkbox" 
					    		editoptions="{value:'Yes:No' ,align:'middle'}"	 />
								
								<psjg:gridColumn name="ctsChargesExemptedBranchVO.ACC_BR"		title="%{getText('Exempt_A/C_Branch_key')}" 			index="ACC_BR" 		
							colType="checkbox" 	editable="true" 	sortable="true" 		id="ACC_BR"  edittype="checkbox" formatter="checkbox" 
					    		editoptions="{value:'Yes:No' ,align:'middle'}"	 />
						</psjg:grid>
					</td>
					<td></td>
				</tr>
		</table>
							
		<div id="trxChargesSchemaDetailsGridDiv_id_${_pageRef}" style="width:100%;">
		     	<%@include file="TrxChargesSchemaDetailsGrid.jsp" %>
		</div>		
			
		</div>
	</body>
</html>