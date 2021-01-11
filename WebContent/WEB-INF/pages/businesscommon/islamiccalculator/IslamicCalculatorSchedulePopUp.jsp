<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<div class="" style="width: 100%;" id="scheduleDiv_${_pageRef}">
	<psjg:grid
				id="scheduleGridTbl_Id_${_pageRef}"
				dataType="json" 
															pager="true" 								filter="false" 				
					gridModel="gridModel"  					rowNum="5" 									rowList="5,10,15,20"
					viewrecords="true" 						navigator="true" 							height="370"
					navigatorRefresh="false" 				navigatorSearch="false"						hiddengrid="false"
					addfunc="addDealCharges" 				editfunc="editDealCharges"					delfunc="deleteDealCharges"
					rownumbers="false"						multiselect="false" 						multiboxonly="false"
					editinline="false"						altRows="true" 								navigatorAdd="false"		
					navigatorEdit="false" 					shrinkToFit="false" 						pagerButtons="false"
					footerrow="true"						navigatorDelete="false"						
					editurl="abc"  							userDataOnFooter="true">		 
					
		<psjg:gridColumn name="LINE_NBR" 
			title="%{getText('L/N_key')}" index="LINE_NBR" 
			colType="number" editable="false" sortable="true"  width="30"
			id ="lnNo_${_pageRef}" />					
			<%-- 
		<psjg:gridColumn name="BALLOON"
			title="%{getText('Balln_key')}" index="BALLOON"
			colType="number" editable="false" sortable="true" 
			id ="baloon_${_pageRef}" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>--%>
			
		<psjg:gridColumn name="BALLOON_PAYMENT" title="%{getText('Balln_key')}" index="BALLOON_PAYMENT" colType="checkbox" 
			editoptions="{value:'1:0'}" editable="true" sortable="true" edittype="currencyFmatter" formatter="checkbox" formatoptions="{disabled : true}"
			formatCol="scheduleAmtFormat"  width="30"
	        id="baloon_${_pageRef}" />
			
		<psjg:gridColumn name="VALUE_DATE"
			title="%{getText('Due_Date_key')}" index="VALUE_DATE"
			 editable="false" sortable="true" colType="date" formatter="date" formatoptions= "{newformat:'m/d/Y'}"
			id ="dueDate_${_pageRef}" />
			
		<psjg:gridColumn name="VALUE_DATE_HIJRI"
			title="%{getText('Due_Date_hijiri_key')}" index="VALUE_DATE_HIJRI"
			colType="date" editable="false" sortable="false"
			id="VALUE_DATE_HIJRI" align="center" width="80" />	
			
		<psjg:gridColumn name="AMOUNT"
			title="%{getText('Installment_Amount_key')}" index="AMOUNT"
			colType="number" editable="false" sortable="true" 
			id ="installmentAmount_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="PRINCIPLE_AMT"
			title="%{getText('Principal_Amount_key')}" index="PRINCIPLE_AMT"
			colType="number" editable="false" sortable="true" 												
			id ="code_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="CAPITAL_AMT" 
			title="%{getText('Principal+_Charges_key')}" index="CAPITAL_AMT" 
			colType="number" editable="false" sortable="true"
			search="true" 						
			id ="principalCharges_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="CHARGE_AMOUNT"
			title="%{getText('Charge_Amount__key')}" index="CHARGE_AMOUNT"
			colType="number" editable="false" sortable="true" 
			id ="chargeAmount_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
			
		<%-- EWBI160081; Saheer.Naduthodi; 07/3/2017 [Begin] --%>	
		<psjg:gridColumn name="settlChargesInstalment"
			title="%{getText('settlement_charges_in_inst_key')}" index="settlChargesInstalment"
			colType="number" editable="false" sortable="false" id="settlChargesInstalment_${_pageRef}" 
			formatCol="scheduleAmtFormat" />
			
		<psjg:gridColumn name="settlChargesNotInstalment"
			title="%{getText('settlement_charges_not_in_inst_key')}" index="settlChargesNotInstalment"
			colType="number" editable="false" sortable="false" 
			id="settlChargesNotInstalment_${_pageRef}" 
			formatCol="scheduleAmtFormat" />
	
          <%-- EWBI160081; Saheer.Naduthodi; 07/3/2017 [End]--%>

		<psjg:gridColumn name="INSURANCE_AMOUNT"
			title="%{getText('Insurance_Amount_key')}" index="INSURANCE_AMOUNT"
			colType="number" editable="false" sortable="true" 
			id ="insuranceAmount_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat" />
		<psjg:gridColumn name="PROFIT_AMT"
			title="%{getText('Profit_Amount_key')}" index="PROFIT_AMT"
			colType="number" editable="false" sortable="true" id ="profitAmount_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="VAT_AMOUNT"
			title="%{getText('VAT_Amount_key')}" index="VAT_AMOUNT"
			colType="number" editable="false" sortable="true" id ="vatAmount_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="TOTAL_EARNED_PROFIT"
			title="%{getText('Total_Earned_Profit__key')}"
			index="TOTAL_EARNED_PROFIT" colType="number" editable="false"
			sortable="true" id ="totalEarnedProfit_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="XNPV"
			title="%{getText('XNPV_key')}" index="XNPV"
			colType="number" editable="false" sortable="true" id ="xnpv_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="NET_INVEST_OUTSTANDING"
			title="%{getText('Net_Investment_Outstanding_key')}" index="NET_INVEST_OUTSTANDING"
			colType="number" editable="false" sortable="true" id ="netInvestmentOutstanding_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="TOTAL_DEFERRED_PROFIT"
			title="%{getText('Total_Deferred_Profit__key')}"
			index="TOTAL_DEFERRED_PROFIT" colType="number" editable="false"
			sortable="true" id ="totalDeferredProfit_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="TOTAL_PRINCIPAL_OUTSTANDIG"
			title="%{getText('Total_Principal_Outstanding__key')}" index="TOTAL_PRINCIPAL_OUTSTANDIG"
			colType="number" editable="false" sortable="true" id ="totalPrincipalOutstanding_${_pageRef}"  formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn name="NO_OF_DAYS"
			title="%{getText('No_of_Days_key')}" index="NO_OF_DAYS"
			colType="number" editable="false" sortable="true" id ="noOfDays_${_pageRef}" />
		<psjg:gridColumn name="ROR"
			title="%{getText('Constant_ROR__key')}" index="ROR"
			colType="number" editable="false" sortable="true" id ="constantROR_${_pageRef}"  formatter="currencyFmatter" formatCol="constantRorFormat"/>	
		<psjg:gridColumn title="" name="scheduleAmtFormat" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="constantRorFormat" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="STATUS" colType="select" hidden="true"/>
		<psjg:gridColumn title="" name="SETTLEMENT_AMOUNT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="ORG_PROFIT_AMT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="PAYMENT_TYPE" colType="select" hidden="true"/>
		<psjg:gridColumn title="" name="DEAL_AMOUNT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="RESERVE_AMOUNT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="DEAL_VALUE_DATE" colType="date" hidden="true"/>
		<psjg:gridColumn title="" name="ACC_BR" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="ACC_CY" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="ACC_GL" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="ACC_CIF" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="ACC_SL" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="COVERING_ACC_BR" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="COVERING_ACC_CY" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="COVERING_ACC_GL" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="COVERING_ACC_CIF" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="COVERING_ACC_SL" colType="number" hidden="true"/>
		<psjg:gridColumn title="" name="BALLOON_AMOUNT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="CAPITAL_AMT_BEFORE_XIRR" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="PROFIT_AMT_BEFORE_XIRR" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="PENALTY_AMOUNT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="VAT_PERCENTAGE" colType="number" hidden="true" formatter="currencyFmatter" formatCol="6"/>
		<psjg:gridColumn title="" name="SETTLED_VAT_AMT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="REIMBURSED_PROFIT_FOR_ACCRUAL" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="ACTUAL_PROFIT_AMT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="VAT_CHARGE_INSUR_PERCENT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="6"/>
		<psjg:gridColumn title="" name="VAT_CHARGE_INSUR_AMT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="SETTLE_VAT_CHARGE_INSUR_AMT" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
		<psjg:gridColumn title="" name="ACTUAL_PROFIT_AMT_BEFORE_XIRR" colType="number" hidden="true" formatter="currencyFmatter" formatCol="scheduleAmtFormat"/>
	</psjg:grid>
</div>

<table>
			<tr>
				<td>		
					<psj:a button="true" href="#" onclick="islamicCalculator_printScheduleFromTempTable()"
							cssStyle="width:120px" buttonIcon="ui-icon ui-icon-print" >
							<ps:text name="Print_Schedule_key"></ps:text>
					</psj:a>
				</td>		
			</tr>
		</table>


