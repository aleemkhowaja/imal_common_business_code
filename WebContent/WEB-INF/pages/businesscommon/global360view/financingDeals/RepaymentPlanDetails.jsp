<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<script>
$(document).ready(function() {	
 	
	$("#repaymentDealDtlsSection_"+_pageRef+".collapsibleContainer").collapsiblePanel();
	$.struts2_jquery.require("Dashboard.js" ,null,jQuery.contextPath+"/businesscommon/js/global360view/");
				});

function financingDealRepaymentDtlsGridStatusColor(cellValue, options, rowObject){	
	var statusColor = "";
	if (rowObject.status == "P")
		statusColor = '<span class="" style=" background: blue;">&nbsp;&nbsp;&nbsp;&nbsp;</span>'
	else if (rowObject.status == "A")
		statusColor = '<span class="" style=" background: green;">&nbsp;&nbsp;&nbsp;&nbsp;</span>'
	else if (rowObject.status == "N")
		statusColor = '<span class="" style=" background: red;">&nbsp;&nbsp;&nbsp;&nbsp;</span>'
	else if (rowObject.status == "D")
		statusColor = '<span class="" style=" background: #00BFFF;">&nbsp;&nbsp;&nbsp;&nbsp;</span>'
	else
		statusColor = '<span class=""  >&nbsp;&nbsp;&nbsp;&nbsp;</span>'
	return statusColor;

}
</script>
<ps:hidden id="dealBranchHidden_${_pageRef}"
	value="%{financingDealsSC.branchCode}"></ps:hidden>
	
<jsp:include page="UnmaturedInstallmentSummary.jsp"></jsp:include>
<br/>
<div id="repaymentDealDtlsSection_${_pageRef}"
	class="collapsibleContainer"
	title="<ps:text name='Repayment_Plan_Details_key'/>">
	<table width="100%">
		<tr>
			<td class="fldLabelView"><ps:label key="Plan_Nbr_key" /></td>
			<td><ps:textfield id="planNbr_${_pageRef}"
					name="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_NBR"></ps:textfield>
			</td>
			<td class="fldLabelView"><ps:label key="Seq_No_key" /></td>
			<td><ps:textfield id="planSeq_${_pageRef}"
					name="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_SEQ"></ps:textfield>
			</td>
			<td class="fldLabelView"><ps:label key="Deal_No_key" /></td>
			<td><ps:textfield id="dealNo_${_pageRef}"
					name="financingDealRepaymentPlanCO.trsPayPlanVO.TRX_NBR"></ps:textfield>
			</td>
		</tr>
		<tr>
			<td class="fldLabelView"><ps:label key="total_amount_key" /></td>
			<td><ps:textfield id="totalAmt_${_pageRef}"
					name="financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT"
					mode="number"></ps:textfield></td>
			<td class="fldLabelView"><ps:label key="Total_Amount_Paid_key" />
			</td>
			<td><ps:textfield id="totalAmtPaid_${_pageRef}"
					name="financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT_PAID"
					mode="number"></ps:textfield></td>
			<td class="fldLabelView"><ps:label key="Active_Amount_key" /></td>
			<td><ps:textfield id="activeAmt_${_pageRef}"
					name="financingDealRepaymentPlanCO.activeSettlementAmt"
					mode="number"></ps:textfield></td>
		</tr>
		<tr>
			<td class="fldLabelView"><ps:label key="Remaining_Amount_key" />
			</td>
			<td><ps:textfield id="remainingAmt_${_pageRef}"
					name="financingDealRepaymentPlanCO.remainingAmt" mode="number">
				</ps:textfield></td>
			<td class="fldLabelView"><ps:label key="Currency_key" /></td>
			<td><ps:textfield id="currBriefDescEng_${_pageRef}"
					name="financingDealRepaymentPlanCO.currBriefDescEng"></ps:textfield>
			</td>
			<td class="fldLabelView"><ps:label key="No_of_Payments_key" />
			</td>
			<td><ps:textfield id="noOfPay_${_pageRef}"
					name="financingDealRepaymentPlanCO.trsPayPlanVO.NO_OF_PAYMENTS"></ps:textfield>
			</td>
		</tr>
		<tr>
			<td class="fldLabelView"><ps:label key="Amount_Per_Payment_key" />
			</td>
			<td><ps:textfield id="amtPerPayment_${_pageRef}"
					name="financingDealRepaymentPlanCO.trsPayPlanVO.AMT_PER_PAYMENT"
					mode="number"></ps:textfield></td>
			<td class="fldLabelView"><ps:label
					key="Cur_Period_Unstld_Amt_key" /></td>
			<td><ps:textfield id="CurPeriodUnsettledAmt_${_pageRef}"
					name="financingDealRepaymentPlanCO.curPeriodUnsettledAmt"
					mode="number"></ps:textfield></td>
			<td class="fldLabelView"><ps:label key="Act_No_of_payments_key" />
			</td>
			<td><ps:textfield id="ActNoOfpayments_${_pageRef}"
					name="financingDealRepaymentPlanCO.actNoOfpayments" mode="number"></ps:textfield>
			</td>
		</tr>
	</table>
</div>



<div id="hidden_repaymentplanDealDiv_${_pageRef}" style="display: none">


	<table>
		<tr>
			<td height="10"><ps:label key="CIF_No_key" /> <ps:textfield
					id="hidden_cif_${_pageRef}" name="financingDealsSC.cifNo"></ps:textfield>
				<ps:label key="Name_key" /> <ps:textfield
					id="hidden_name_${_pageRef}"
					name="financingDealRepaymentPlanCO.cifName"></ps:textfield> <psjg:grid
					id="hidden_repaymentplanDeal_${_pageRef}" href="#" dataType="json"
					pager="false" sortable="false" filter="false" gridModel="gridModel"
					viewrecords="false" navigator="false" altRows="false"
					navigatorRefresh="false" navigatorAdd="false"
					navigatorDelete="false" navigatorEdit="false" pagerButtons="false"
					navigatorSearch="false" shrinkToFit="false" autowidth="false"
					width="10" height="10" hiddengrid="true" hidegrid="true"
					userDataOnFooter="false" footerrow="true">
					<psjg:gridColumn id="planNBR" align="center"
						index="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_NBR"
						name="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_NBR"
						title="%{getText('Plan_Nbr_key')}" colType="text" sortable="true"
						search="true" width="50" />
					<psjg:gridColumn id="planSEQ" align="center"
						index="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_SEQ"
						name="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_SEQ"
						title="%{getText('Seq_No_key')}" colType="date" sortable="true"
						search="true" />
					<psjg:gridColumn id="trxNBR" align="center"
						index="financingDealRepaymentPlanCO.trsPayPlanVO.TRX_NBR"
						name="financingDealRepaymentPlanCO.trsPayPlanVO.TRX_NBR"
						title="%{getText('Deal_No_key')}" colType="text" sortable="true"
						search="true" />
					<psjg:gridColumn id="totalAmt" align="center"
						index="financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT"
						name="financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT"
						title="%{getText('total_amount_key')}" colType="number"
						sortable="true" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />

					<psjg:gridColumn id="totalAmtPaid" align="center"
						index="financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT_PAID"
						name="financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT_PAID"
						title="%{getText('Total_Amount_Paid_key')}" colType="number"
						sortable="true" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="activeSettlementAmt" align="center"
						index="financingDealRepaymentPlanCO.activeSettlementAmt"
						name="financingDealRepaymentPlanCO.activeSettlementAmt"
						title="%{getText('Active_Amount_key')}" colType="number"
						sortable="true" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="remaningAmt" align="center"
						index="financingDealRepaymentPlanCO.remainingAmt"
						name="financingDealRepaymentPlanCO.remainingAmt"
						title="%{getText('Remaining_Amount_key')}" colType="number"
						sortable="true" search="true" formatCol="currDecimalPoints"
						formatter="currencyFmatter" />
					<psjg:gridColumn id="currBriefDescEng" align="center"
						index="financingDealRepaymentPlanCO.currBriefDescEng"
						name="financingDealRepaymentPlanCO.currBriefDescEng"
						title="%{getText('Currency_key')}" colType="text" sortable="true"
						search="true" />
					<psjg:gridColumn id="NoOfPayments"
						index="financingDealRepaymentPlanCO.trsPayPlanVO.NO_OF_PAYMENTS"
						name="financingDealRepaymentPlanCO.trsPayPlanVO.NO_OF_PAYMENTS"
						title="%{getText('No_of_Payments_key')}" colType="number"
						sortable="false" search="false" align="center" />
					<psjg:gridColumn id="amtPerPayment" align="center"
						index="financingDealRepaymentPlanCO.trsPayPlanVO.AMT_PER_PAYMENT"
						name="financingDealRepaymentPlanCO.trsPayPlanVO.AMT_PER_PAYMENT"
						title="%{getText('Amount_Per_Payment_key')}" colType="date"
						sortable="true" search="true" />
					<psjg:gridColumn id="CurPeriodUnsettledAmt"
						index="financingDealRepaymentPlanCO.curPeriodUnsettledAmt"
						name="financingDealRepaymentPlanCO.curPeriodUnsettledAmt"
						title="%{getText('Cur_Period_Unsttld_Amount_key')}"
						colType="number" sortable="false" search="false" />
					<psjg:gridColumn id="ActNoOfpayments" align="center"
						index="financingDealRepaymentPlanCO.actNoOfpayments"
						name="financingDealRepaymentPlanCO.actNoOfpayments"
						title="%{getText('Act_No_of_payments_key')}" colType="date"
						sortable="true" search="true" />



				</psjg:grid></td>
		</tr>
		<tr>
			<td height="10">
				<div>

					<psjg:grid
						id="hidden_financingDealsRepaymentDtlsGridTbl_Id_${_pageRef}"
						href="#" dataType="json" pager="false" sortable="false"
						filter="false" gridModel="gridModel" viewrecords="false"
						navigator="false" altRows="false" navigatorRefresh="false"
						navigatorAdd="false" navigatorDelete="false" navigatorEdit="false"
						pagerButtons="false" navigatorSearch="false" shrinkToFit="false"
						autowidth="false" width="900" height="400" hiddengrid="false"
						hidegrid="true" userDataOnFooter="false" footerrow="true"
						caption="%{getText('Payment_Details_key')}">
						<psjg:gridColumn name="statusColor" title=" " index="action"
							colType="custom" editable="false" sortable="false" search="false"
							id="statusColor"
							formatter="financingDealRepaymentDtlsGridStatusColor" width="20" />
						<psjg:gridColumn id="lineNo" align="center"
							index="trsPayPlanDetVO.LINE_NBR" name="trsPayPlanDetVO.LINE_NBR"
							title="%{getText('Line_No._key')}" colType="text" sortable="true"
							search="true" width="50" />
						<psjg:gridColumn id="dueDate" align="center"
							index="trsPayPlanDetVO.VALUE_DATE"
							name="trsPayPlanDetVO.VALUE_DATE"
							title="%{getText('Due_Date_key')}" colType="date" sortable="true"
							search="true" />
						<psjg:gridColumn id="paymentType" align="center"
							index="paymentType" name="paymentType"
							title="%{getText('Payment_Type_key')}" colType="text"
							sortable="true" search="true" />
						<psjg:gridColumn id="installmentAmt" align="center" index="amount"
							name="amount" title="%{getText('Installment_Amount_key')}"
							colType="number" sortable="true" search="true"
							formatter="currencyFmatter" formatCol="currDecimalPoints" />
						<psjg:gridColumn id="principalAmt" align="center"
							index="trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR"
							name="trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR"
							title="%{getText('Principal_Amount_key')}" colType="number"
							sortable="true" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="principalAmtXIRR" align="center"
							index="trsPayPlanDetVO.CAPITAL_AMT"
							name="trsPayPlanDetVO.CAPITAL_AMT"
							title="%{getText('Principal_Amount_XIRR_key')}" colType="number"
							sortable="true" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="profitAmt" align="center"
							index="trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR"
							name="trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR"
							title="%{getText('Profit_Amount_key')}" colType="number"
							sortable="true" search="true" formatCol="currDecimalPoints"
							formatter="currencyFmatter" />
						<psjg:gridColumn id="profitAmtXIRR" align="center"
							index="profitAmt" name="profitAmt"
							title="%{getText('Profit_Amount_XIRR_key')}" colType="number"
							sortable="true" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="balloon"
							index="trsPayPlanDetVO.BALLOON_PAYMENT"
							name="trsPayPlanDetVO.BALLOON_PAYMENT"
							title="%{getText('Balloon_Payment_key')}" colType="checkbox"
							sortable="false" search="false" formatter="checkbox"
							align="center" editoptions="{value:'1:0'}" />
						<psjg:gridColumn id="settlementDate" align="center"
							index="dateSettled" name="dateSettled"
							title="%{getText('Settlement_Date_key')}" colType="date"
							sortable="true" search="true" />
						<psjg:gridColumn id="settledAmt" align="center"
							index="settlementAmount" name="settlementAmount"
							title="%{getText('Settlement_Amount_key')}" colType="number"
							sortable="true" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="activeSettlement" align="center"
							index="computedActiveSettlementAmt"
							name="computedActiveSettlementAmt"
							title="%{getText('Active_Settlement_key')}" colType="number"
							sortable="false" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="remainingAmt" align="center"
							index="computedRemainingAmt" name="computedRemainingAmt"
							title="%{getText('Remaining_Amount_key')}" colType="number"
							sortable="false" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="reimbursedProfit" align="center"
							index="trsPayPlanDetVO.REIMBURSED_PROFIT"
							name="trsPayPlanDetVO.REIMBURSED_PROFIT"
							title="%{getText('Reimbursed_Profit_key')}" colType="number"
							sortable="true" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="reserveAmt" align="center"
							index="trsPayPlanDetVO.RESERVE_AMOUNT"
							name="trsPayPlanDetVO.RESERVE_AMOUNT"
							title="%{getText('Reserve_Amount_key')}" colType="number"
							sortable="true" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="amountReceived" align="center"
							index="computedAmtReceived" name="computedAmtReceived"
							title="%{getText('Amt_Received_key')}" colType="number"
							sortable="false" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="incidentalCost" align="center"
							index="computedIncidentalCost" name="computedIncidentalCost"
							title="%{getText('Incidental_Cost_key')}" colType="number"
							sortable="false" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="advInsurance" align="center"
							index="computedAdvInsurance" name="computedAdvInsurance"
							title="%{getText('Advance_Insurance_key')}" colType="number"
							sortable="false" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />
						<psjg:gridColumn id="totalInstallmentAmt" align="center"
							index="computedTotalInstallment" name="computedTotalInstallment"
							title="%{getText('Total_Installment_key')}" colType="number"
							sortable="false" search="true" formatter="currencyFmatter"
							formatCol="currDecimalPoints" />



					</psjg:grid>

				</div>
			</td>
		</tr>

	</table>
</div>
<div>
	<table>
		<tr>
			<td><ps:url id="urlFinancingDealsRepaymentDtlsGrid"
					action="financingDealsListAction_loadFinancingDealsRepaymentPlanGridDetails"
					namespace="/path/globalview" escapeAmp="false">
					<ps:param name="iv_crud" value="iv_crud"></ps:param>
					<ps:param name="_pageRef" value="_pageRef"></ps:param>
					<ps:param name="financingDealsSC.cifNo"
						value="financingDealsSC.cifNo"></ps:param>
					<ps:param name="financingDealsSC.planNbr"
						value="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_NBR"></ps:param>
					<ps:param name="financingDealsSC.planSeq"
						value="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_SEQ"></ps:param>
					<ps:param name="financingDealsSC.prodClassCode"
						value="financingDealsSC.prodClassCode"></ps:param>
					<ps:param name="financingDealsSC.branchFilter"
						value="financingDealsSC.branchFilter"></ps:param>
					<ps:param name="financingDealsSC.branchCode"
						value="financingDealsSC.branchCode"></ps:param>

				</ps:url> <%-- TP#214325; Saheer.Naduthodi; 02/09/2014--%> <psjg:grid
					id="financingDealsRepaymentDtlsGridTbl_Id_${_pageRef}"
					href="%{urlFinancingDealsRepaymentDtlsGrid}" dataType="json"
					pager="true" sortable="true" filter="false" gridModel="gridModel"
					viewrecords="false" navigator="true" altRows="true"
					navigatorRefresh="false" navigatorAdd="false"
					navigatorDelete="false" navigatorEdit="false" pagerButtons="false"
					navigatorSearch="false" shrinkToFit="false" autowidth="false"
					width="900" height="400"
					caption="%{getText('Payment_Details_key')}" userDataOnFooter="true"
					footerrow="true" sortname="trsPayPlanDetVO.LINE_NBR"
					sortorder="asc"
					onCompleteTopics="calcFinancingDealsRepaymentPlanTotal">
					<psjg:gridColumn name="statusColor" title=" " index="action"
						colType="custom" editable="false" sortable="false" search="false"
						id="statusColor"
						formatter="financingDealRepaymentDtlsGridStatusColor" width="20" />
					<psjg:gridColumn id="lineNo" align="center"
						index="trsPayPlanDetVO.LINE_NBR" name="trsPayPlanDetVO.LINE_NBR"
						title="%{getText('Line_No._key')}" colType="text" sortable="false"
						search="true" width="50" />
					<psjg:gridColumn id="dueDate" align="center"
						index="trsPayPlanDetVO.VALUE_DATE"
						name="trsPayPlanDetVO.VALUE_DATE"
						title="%{getText('Due_Date_key')}" colType="date" sortable="false"
						search="true" />
					<psjg:gridColumn id="paymentType" align="center"
						index="paymentType" name="paymentType"
						title="%{getText('Payment_Type_key')}" colType="text"
						sortable="false" search="true" />
					<psjg:gridColumn id="installmentAmt" align="center" index="amount"
						name="amount" title="%{getText('Installment_Amount_key')}"
						colType="number" sortable="false" search="true"
						formatter="currencyFmatter" formatCol="currDecimalPoints" />
					<psjg:gridColumn id="principalAmt" align="center"
						index="trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR"
						name="trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR"
						title="%{getText('Principal_Amount_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="principalAmtXIRR" align="center"
						index="trsPayPlanDetVO.CAPITAL_AMT"
						name="trsPayPlanDetVO.CAPITAL_AMT"
						title="%{getText('Principal_Amount_XIRR_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="profitAmt" align="center"
						index="trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR"
						name="trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR"
						title="%{getText('Profit_Amount_key')}" colType="number"
						sortable="false" search="true" formatCol="currDecimalPoints"
						formatter="currencyFmatter" />
					<psjg:gridColumn id="profitAmtXIRR" align="center"
						index="profitAmt" name="profitAmt"
						title="%{getText('Profit_Amount_XIRR_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="balloon"
						index="trsPayPlanDetVO.BALLOON_PAYMENT"
						name="trsPayPlanDetVO.BALLOON_PAYMENT"
						title="%{getText('Balloon_Payment_key')}" colType="checkbox"
						sortable="false" search="false" formatter="checkbox"
						align="center" editoptions="{value:'1:0'}" />
					<psjg:gridColumn id="settlementDate" align="center"
						index="dateSettled" name="dateSettled"
						title="%{getText('Settlement_Date_key')}" colType="date"
						sortable="false" search="true" />
					<psjg:gridColumn id="settledAmt" align="center"
						index="settlementAmount" name="settlementAmount"
						title="%{getText('Settlement_Amount_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="activeSettlement" align="center"
						index="computedActiveSettlementAmt"
						name="computedActiveSettlementAmt"
						title="%{getText('Active_Settlement_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="remainingAmt" align="center"
						index="computedRemainingAmt" name="computedRemainingAmt"
						title="%{getText('Remaining_Amount_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="reimbursedProfit" align="center"
						index="trsPayPlanDetVO.REIMBURSED_PROFIT"
						name="trsPayPlanDetVO.REIMBURSED_PROFIT"
						title="%{getText('Reimbursed_Profit_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="reserveAmt" align="center"
						index="trsPayPlanDetVO.RESERVE_AMOUNT"
						name="trsPayPlanDetVO.RESERVE_AMOUNT"
						title="%{getText('Reserve_Amount_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="amountReceived" align="center"
						index="computedAmtReceived" name="computedAmtReceived"
						title="%{getText('Amt_Received_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="incidentalCost" align="center"
						index="computedIncidentalCost" name="computedIncidentalCost"
						title="%{getText('Incidental_Cost_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="advInsurance" align="center"
						index="computedAdvInsurance" name="computedAdvInsurance"
						title="%{getText('Advance_Insurance_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />
					<psjg:gridColumn id="totalInstallmentAmt" align="center"
						index="computedTotalInstallment" name="computedTotalInstallment"
						title="%{getText('Total_Installment_key')}" colType="number"
						sortable="false" search="true" formatter="currencyFmatter"
						formatCol="currDecimalPoints" />

	<psjg:gridColumn name="trsPayPlanDetVO.ACC_BR"
		title="%{getText('acc_br_key')}" index="trsPayPlanDetVO.ACC_BR"
		colType="number" leadZeros="4" editable="false" sortable="false"
		id="trsPayPlanDetVO.ACC_BR" width="80" />

	<psjg:gridColumn name="trsPayPlanDetVO.ACC_CY"
		title="%{getText('acc_cy_key')}" index="trsPayPlanDetVO.ACC_CY"
		colType="number" leadZeros="3" editable="false" sortable="false"
		id="trsPayPlanDetVO.ACC_CY" width="80" />

	<psjg:gridColumn name="trsPayPlanDetVO.ACC_GL"
		title="%{getText('acc_gl_key')}" index="trsPayPlanDetVO.ACC_GL"
		colType="number" leadZeros="6" editable="false" sortable="false"
		id="trsPayPlanDetVO.ACC_GL" width="80" />

	<psjg:gridColumn name="trsPayPlanDetVO.ACC_CIF"
		title="%{getText('acc_cif_key')}" index="trsPayPlanDetVO.ACC_CIF"
		colType="number" leadZeros="8" editable="false" sortable="false"
		id="trsPayPlanDetVO.ACC_CIF" width="80" />
	<psjg:gridColumn name="trsPayPlanDetVO.ACC_SL"
		title="%{getText('acc_sl_key')}" index="trsPayPlanDetVO.ACC_SL"
		leadZeros="4" mode="number" align="center" sortable="false"
		id="trsPayPlanDetVO.ACC_SL_${_pageRef}" width="80" editable="false"
		colType="liveSearch" />
	<psjg:gridColumn name="accountName" title="%{getText('acc_name_key')}"
		index="accountName" colType="text" editable="false" sortable="false"
		id="accountName" />


	<psjg:gridColumn name="trsPayPlanDetVO.COVERING_ACC_BR"
		title="%{getText('covering_acc_br_key')}"
		index="trsPayPlanDetVO.COVERING_ACC_BR" colType="number"
		editable="false" sortable="false" leadZeros="4"
		id="trsPayPlanDetVO.COVERING_ACC_BR" width="80" />

	<psjg:gridColumn name="trsPayPlanDetVO.COVERING_ACC_CY"
		title="%{getText('covering_acc_cy_key')}"
		index="trsPayPlanDetVO.COVERING_ACC_CY" colType="number"
		editable="false" sortable="false" id="trsPayPlanDetVO.COVERING_ACC_CY"
		width="80" />

	<psjg:gridColumn name="trsPayPlanDetVO.COVERING_ACC_GL"
		title="%{getText('covering_acc_gl_key')}"
		index="trsPayPlanDetVO.COVERING_ACC_GL" colType="number"
		editable="false" sortable="false" id="trsPayPlanDetVO.COVERING_ACC_GL"
		width="80" />

	<psjg:gridColumn name="trsPayPlanDetVO.COVERING_ACC_CIF"
		title="%{getText('covering_acc_cif_key')}"
		index="trsPayPlanDetVO.COVERING_ACC_CIF" colType="number"
		editable="false" sortable="false"
		id="trsPayPlanDetVO.COVERING_ACC_CIF" width="80" />

	<psjg:gridColumn name="trsPayPlanDetVO.COVERING_ACC_SL"
		title="%{getText('covering_acc_sl_key')}"
		index="trsPayPlanDetVO.COVERING_ACC_SL" editable="false"
		sortable="false" id="trsPayPlanDetVO.COVERING_ACC_SL" width="80"
		colType="liveSearch" leadZeros="4" />

	<psjg:gridColumn name="coveringAccountName"
		title="%{getText('covering_acc_name_key')}"
		index="coveringAccountName" colType="text" editable="false"
		sortable="false" id="coveringAccountName" />



				</psjg:grid>
	</table>
</div>





<table width="100%" class="ui-state-focus">
	<tr>
		<%-- TP##402878; Fawas.Kuruvakkottil; 26/05/2016--%>
		<td><psj:a button="true" href="#"
				onclick="financingDeals_printScheduleReport()"
				cssStyle="width:120px" buttonIcon="ui-icon ui-icon-print">
				<ps:text name="Print_Statement__key"></ps:text>
			</psj:a></td>
	</tr>
	<tr class="ui-state-focus">

		<td><span class="" style="background: #00BFFF">&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span style="color: #00BFFF;"><ps:text
					name="Partially_Paid_key" /> </span></td>
		<td><span class="" style="background: blue">&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span style="color: blue;"><ps:text name="Paid_key" /> </span></td>
		<td><span class="" style="background: red">&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span style="color: red;"><ps:text name="Past_Due_key" /> </span></td>
		<td><span class="" style="background: green">&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span style="color: green;"><ps:text name="Early_Paid_key" />
		</span></td>

	</tr>


</table>


<style>
.circle {
	border-radius: 50%/50%;
}
</style>
<ps:set name="Account_key" value="%{getEscText('Account_key')}" />
<ps:set name="Covering_Account_key"
	value="%{getEscText('Covering_Account_key')}" />

<script type="text/javascript">
 var account= "${Account_key}";
 var coveringAccount= "${Covering_Account_key}";

$(document).ready(
		function() {
			calTotalAmtOfColumns = function(response, html) {

				calcFinancingDealsRepaymentPlanTotal(response, html);

			};

			$("#financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef)
					.unsubscribe("calcFinancingDealsRepaymentPlanTotal");
			$("#financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).subscribe(
					"calcFinancingDealsRepaymentPlanTotal",
					calTotalAmtOfColumns);
$("#financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid ('navButtonAdd', '#financingDealsRepaymentDtlsGridTbl_Id_'+_pageRef+'_pager', 
										      {   
					 						  caption:"<ps:text name='Print_Statement__key' />", 
											  buttonicon: "ui-icon-print", 
											  title: "<ps:text name='Print_Statement__key' />", 
										      onClickButton: function() {										       
		  										printGrid("financingDealsRepaymentDtlsGridTbl_Id_"+_pageRef); 
   				 							}    
    									});
jQuery("#financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef) 
.jqGrid('setGroupHeaders', { 
	useColSpanStyle : true, 
	color : '12', 
	groupHeaders : [ { 
		startColumnName : 'trsPayPlanDetVO.ACC_BR', 
		numberOfColumns : 6, 
		titleText : account 
	}, { 
		startColumnName : 'trsPayPlanDetVO.COVERING_ACC_BR', 
		numberOfColumns : 6, 
		titleText : coveringAccount 
	} ] 
});
    									
					

		});

function printStatementPlan() {

	$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
			"clearGridData");

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid("clearGridData", true);
	var selRow = $("#hidden_repaymentplanDeal_" + _pageRef).jqGrid(
			'addInlineRow', {});

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_NBR',
			$("#planNbr_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_SEQ',
			$("#planSeq_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.trsPayPlanVO.TRX_NBR',
			$("#dealNo_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT',
			$("#totalAmt_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT_PAID',
			$("#totalAmtPaid_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.activeSettlementAmt',
			$("#activeAmt_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.remainingAmt',
			$("#remainingAmt_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.currBriefDescEng',
			$("#currBriefDescEng_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.trsPayPlanVO.NO_OF_PAYMENTS',
			$("#noOfPay_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.curPeriodUnsettledAmt',
			$("#CurPeriodUnsettledAmt_" + _pageRef).val());

	$("#hidden_repaymentplanDeal_" + _pageRef).jqGrid('setCellValue', selRow,
			'financingDealRepaymentPlanCO.actNoOfpayments',
			$("#ActNoOfpayments_" + _pageRef).val());

	//printGrid("financingDealsRepaymentDtlsGridTbl_Id_"+_pageRef);

<%-- TP##402878; Fawas.Kuruvakkottil; 26/05/2016--%>
		  										      var grid = $("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef);
		  										      
	 					var financingDealsRepaymentDtlsGrid 	= $("#financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef);		  										     
						var rowIds 				= financingDealsRepaymentDtlsGrid.jqGrid('getDataIDs');	  									     		  										      
						 for ( var i = 0; i < rowIds.length; i++)        {         
         					var myObject = financingDealsRepaymentDtlsGrid.jqGrid('getRowData', rowIds[i]);      
         
         						$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef)
          						.jqGrid(
            					'addRowData',
           						 i + 1,
           							 myObject);

        								}
		  										   
	  										      var rowId=$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid('addInlineRow', {});
	  										      
	  										      $("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'paymentType',Total_Amount_key );
	  										      $("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'amount', ($.formatNumberNumeric(grid.jqGrid('getCol', 'amount', false, 'sum'),{format: nbFormat,applyRounding:true})));
	  										       										      
	  										      
	  										      $("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR', ($.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'trsPayPlanDetVO.CAPITAL_AMT', ($.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.CAPITAL_AMT', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'trsPayPlanDetVO.TRSPAYPLANDET_PROFIT_AMT_BEFORE_XIRR', ($.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.TRSPAYPLANDET_PROFIT_AMT_BEFORE_XIRR', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR', ($.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'settlementAmount', ($.formatNumberNumeric(grid.jqGrid('getCol', 'settlementAmount', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'computedActiveSettlementAmt', ($.formatNumberNumeric(grid.jqGrid('getCol', 'computedActiveSettlementAmt', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'computedRemainingAmt', ($.formatNumberNumeric(grid.jqGrid('getCol', 'computedRemainingAmt', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'trsPayPlanDetVO.REIMBURSED_PROFIT', ($.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.REIMBURSED_PROFIT', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'trsPayPlanDetVO.RESERVE_AMOUNT', ($.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.RESERVE_AMOUNT', false, 'sum'))));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'computedAmtReceived', ($.formatNumberNumeric(grid.jqGrid('getCol', 'computedAmtReceived', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'computedIncidentalCost', ($.formatNumberNumeric(grid.jqGrid('getCol', 'computedIncidentalCost', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								
							$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'computedAdvInsurance', ($.formatNumberNumeric(grid.jqGrid('getCol', 'computedIncidentalCost', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'computedTotalInstallment', ($.formatNumberNumeric(grid.jqGrid('getCol', 'computedTotalInstallment', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								
								$("#hidden_financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef).jqGrid(
								'setCellValue', rowId, 'profitAmt', ($.formatNumberNumeric(grid.jqGrid('getCol', 'profitAmt', false, 'sum'),{format: nbFormat,applyRounding:true})));
								
								
								
								
								
								
	  										      
		  						 													
													$('#hidden_repaymentplanDealDiv_'+_pageRef).show();	 
		  										     var printContents = document.getElementById("hidden_repaymentplanDealDiv_"+_pageRef).innerHTML;
		  										     
		  										      $('#hidden_repaymentplanDealDiv_'+_pageRef).hide(); 
		  										      
		  										       										      
		  										      
      var WindowObject = window.open("","", "width=950,height=750,top=50,left=50,scrollbars=yes,menubar=yes,resizable=yes");
     
      WindowObject.document.writeln(printContents);
     
   WindowObject.document.close();
   WindowObject.print();
   WindowObject.close();
   
   		}


function financingDeals_printScheduleReport() {
	_showProgressBar(true);
	var params = {};
	params["financingDealsSC.planNbr"] = $("#planNbr_" + _pageRef).val();
	params["financingDealsSC.dealNo"] = $("#dealNo_" + _pageRef).val();
	params["financingDealsSC.planSeq"] = $("#planSeq_" + _pageRef).val();
	params["financingDealsSC.cifNo"] = $("#lookuptxt_cif_no_" + _pageRef).val();
	params["financingDealsSC.branchCode"] = $("#dealBranchHidden_"+ _pageRef).val();


	var actionSrc = jQuery.contextPath + "/path/globalview/financingDealsMaintAction_printScheduleReport";
	$.ajax({
		  url: actionSrc,
		  type:"post",
		  data : params,
		  success: function(data){
	
					if (typeof data["_error"] == "undefined"
							|| data["_error"] == null) {
						printGlobalBatchAdvice(data.financingDealsSC.reportResponseCOList);
					}
					_showProgressBar(false);
				}
			});
}

function printGlobalBatchAdvice(adviceList) {
 if(adviceList == null || typeof adviceList == "undefined" || adviceList == undefined || adviceList == ""){
  return;
 }
 var currentParam = null;
 var lastParam = null; 
 var listSize = adviceList.length;
 for ( var i = listSize - 1; i >= 0; i--) {  
	
  currentParam = batchGlobal_prepareAdditionalAdviceParam(adviceList[i]);
  if (i < listSize - 1) {
   currentParam.nextFunc = openMultipleAdvice;
   currentParam.nextFuncArgs = lastParam;
   lastParam = currentParam;
  } else {
   currentParam.nextFunc = null;
   currentParam.nextFuncArgs = null;
   lastParam = currentParam;
  }
 }
 if (currentParam != null) {
  openMultipleAdvice(currentParam);
 }
}

function batchGlobal_prepareAdditionalAdviceParam(reportResponse) {
	var paramObj = {};
	if (reportResponse) {
		paramObj.shouldSelectLanguage = reportResponse.selectReportLanguage;
		paramObj.selectLangBeforeConf = false;
		paramObj.confirmMessageShown = false;
		paramObj.askLangByReport = false;
		paramObj.reportsObjArray = new Array(reportResponse);
		if(reportResponse.callBackFunc != undefined && reportResponse.callBackFunc != "undefined" && reportResponse.callBackFunc != null && reportResponse.callBackFunc != ""){
		paramObj.callBackFunc=function (response){ 
							var url = jQuery.contextPath+ "/path/iis/commonUtilities/IISUtilityAction_"+reportResponse.callBackFunc;
						_showProgressBar(true);
							$
							.ajax( {
								url : url,
								type : "post",
								success : function(data) {
									_showProgressBar(false);
								}
							});
		};
		 	
	    		 
$("#financingDealsRepaymentDtlsGridTbl_Id_"+_pageRef).unsubscribe("calcFinancingDealsRepaymentPlanTotal");		
$("#financingDealsRepaymentDtlsGridTbl_Id_"+_pageRef).subscribe("calcFinancingDealsRepaymentPlanTotal",calTotalAmtOfColumns);
$('#financingDealsRepaymentDtlsGridTbl_Id_' + _pageRef).jqGrid(
		"setGridWidth",
		$("#repaymentDealDtlsSection_" + _pageRef).width());
});
 </script>
    

 
 <div id="repaymentDealDtlsSection_<ps:property value="_pageRef" escapeHtml="true"/>" class="collapsibleContainer" title="<ps:text name='Repayment_Plan_Details_key'/>" >

<ps:hidden id="dealBranchCode_${_pageRef}"
	name="financingDealRepaymentPlanCO.dealBranchCode" />
	
<table width="100%">
	<tr>
       <td class="fldLabelView"   ><ps:label key="Plan_Nbr_key" /></td>
       <td>
         <ps:textfield id="planNbr_${_pageRef}" name="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_NBR"></ps:textfield>
       </td>
        <td class="fldLabelView"   ><ps:label key="Seq_No_key" /></td>
       <td>
         <ps:textfield id="planSeq_${_pageRef}" name="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_SEQ"></ps:textfield>
       </td>
        <td class="fldLabelView"   ><ps:label key="Deal_No_key" /></td>
       <td>
         <ps:textfield id="dealNo_${_pageRef}" name="financingDealRepaymentPlanCO.trsPayPlanVO.TRX_NBR" ></ps:textfield>
       </td>
     </tr>
     <tr>
       <td class="fldLabelView"   ><ps:label key="total_amount_key" /></td>
       <td>
         <ps:textfield id="totalAmt_${_pageRef}" name="financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT" mode="number" ></ps:textfield>
       </td>
        <td class="fldLabelView"   ><ps:label key="Total_Amount_Paid_key" /></td>
       <td>
         <ps:textfield id="totalAmtPaid_${_pageRef}" name="financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT_PAID" mode="number"></ps:textfield>
       </td>
        <td class="fldLabelView"   ><ps:label key="Active_Amount_key" /></td>
       <td>
         <ps:textfield id="activeAmt_${_pageRef}" name="financingDealRepaymentPlanCO.activeSettlementAmt" mode="number"></ps:textfield>
       </td>
     </tr>
     <tr>
       <td class="fldLabelView"   ><ps:label key="Remaining_Amount_key" /></td>
       <td>
         <ps:textfield id="remainingAmt_${_pageRef}"  name= "financingDealRepaymentPlanCO.remainingAmt" mode="number"> </ps:textfield>
       </td>
        <td class="fldLabelView"   ><ps:label key="Currency_key" /></td>
       <td>
         <ps:textfield id="currBriefDescEng_${_pageRef}" name="financingDealRepaymentPlanCO.currBriefDescEng"></ps:textfield>
       </td>
        <td class="fldLabelView"   ><ps:label key="No_of_Payments_key" /></td>
       <td>
         <ps:textfield id="noOfPay_${_pageRef}" name="financingDealRepaymentPlanCO.trsPayPlanVO.NO_OF_PAYMENTS"></ps:textfield>
       </td>
     </tr>
      <tr>
       <td class="fldLabelView"   ><ps:label key="Amount_Per_Payment_key" /></td>
       <td>
         <ps:textfield id="amtPerPayment_${_pageRef}" name="financingDealRepaymentPlanCO.trsPayPlanVO.AMT_PER_PAYMENT" mode="number"></ps:textfield>
       </td>
      </tr>
      </table>
     </div>
 <table width="100%">	
 <tr><td>	
           <ps:url id="urlFinancingDealsRepaymentDtlsGrid" action="financingDealsListAction_loadFinancingDealsRepaymentPlanGridDetails" namespace="/path/globalview" escapeAmp="false">
				 <ps:param name="iv_crud"      			  		value="iv_crud"></ps:param>
				 <ps:param name="_pageRef"      		 		value="_pageRef"></ps:param>
				 <ps:param name="financingDealsSC.cifNo" 		value="financingDealsSC.cifNo"></ps:param>
				 <ps:param name="financingDealsSC.planNbr" 		value="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_NBR"></ps:param>
				 <ps:param name="financingDealsSC.planSeq" 		value="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_SEQ"></ps:param>
				 <ps:param name="financingDealsSC.prodClassCode" value="financingDealsSC.prodClassCode"></ps:param>
				 <ps:param name="financingDealsSC.branchFilter" value="financingDealsSC.branchFilter"></ps:param>
				 <ps:param name="financingDealsSC.branchCode" value="financingDealsSC.branchCode"></ps:param>
				
			 </ps:url>
			 <%-- TP#214325; Saheer.Naduthodi; 02/09/2014--%>
			 <psjg:grid
			    	id				="financingDealsRepaymentDtlsGridTbl_Id_${_pageRef}" 
			  	    href            ="%{urlFinancingDealsRepaymentDtlsGrid}"  	    
			        dataType        ="json"       
			    	pager           ="true"
			    	sortable        ="true"
					filter          ="false"
			    	gridModel       ="gridModel"    	 
					viewrecords     ="true" 
					navigator       ="true"
					altRows         ="true"
					navigatorRefresh="false" 
					navigatorAdd    ="false"			
					navigatorDelete ="false"
					navigatorEdit   ="false"			
					pagerButtons    ="false" 
					navigatorSearch ="false"
			        shrinkToFit     ="false"	
			        autowidth		="false"
			        width			="900"			         
					height			="400"
					caption="%{getText('Payment_Details_key')}"	 
					userDataOnFooter="true"	 
					footerrow="true"
					sortorder="asc"
					sortname="trsPayPlanDetVO.LINE_NBR"
					onCompleteTopics = "calcFinancingDealsRepaymentPlanTotal"
					
			        >	
			       <psjg:gridColumn  name="statusColor"	title=" " index="action"  colType="custom" 	editable="false" 	sortable="false" 	search="false"	id="statusColor" 	 formatter="financingDealRepaymentDtlsGridStatusColor"  width="20" />		        			         
			       <psjg:gridColumn id="lineNo"	      index="trsPayPlanDetVO.LINE_NBR"          name="trsPayPlanDetVO.LINE_NBR"         title="%{getText('Line_No._key')}"         colType="text"   sortable="true" search="true" width="50"/>
			       <psjg:gridColumn id="dueDate"      index="trsPayPlanDetVO.VALUE_DATE"      	name="trsPayPlanDetVO.VALUE_DATE"      	title="%{getText('Due_Date_key')}"    colType="date"     sortable="true" search="true" />
			       <psjg:gridColumn id="paymentType"          index="paymentType"        name="paymentType"       title="%{getText('Payment_Type_key')}"          colType="text" sortable="true" search="true"  />
			       <psjg:gridColumn id="installmentAmt"      index="amount"    name="amount"   title="%{getText('Installment_Amount_key')}"      colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints" />
			       <psjg:gridColumn id="principalAmt"	  index="trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR"      name="trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR"     title="%{getText('Principal_Amount_key')}"     colType="number"   sortable="true" search="true"  formatter="currencyFmatter" formatCol="currDecimalPoints"   />
			       <psjg:gridColumn id="principalAmtXIRR"	      index="trsPayPlanDetVO.CAPITAL_AMT"        name="trsPayPlanDetVO.CAPITAL_AMT"       title="%{getText('Principal_Amount_XIRR_key')}"          colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints" />
			       
			       <psjg:gridColumn id="profitAmt" hidden="${financingDealRepaymentPlanCO.profitShow}"	      index="trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR"        name="trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR"       title="%{getText('Profit_Amount_key')}"       colType="number" sortable="true" search="true" formatCol="currDecimalPoints"  formatter="currencyFmatter" />
			    
			       <psjg:gridColumn id="profitAmtXIRR"	  index="profitAmt"    name="profitAmt"      title="${financingDealRepaymentPlanCO.titleName}"      colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints" />
			      
			       <psjg:gridColumn id="balloon"  index="trsPayPlanDetVO.BALLOON_PAYMENT"   name="trsPayPlanDetVO.BALLOON_PAYMENT"  title="%{getText('Balloon_Payment_key')}" colType="checkbox" sortable="false" search="false"  formatter="checkbox" align="center"  editoptions="{value:'1:0'}"  />			       		       
			       <psjg:gridColumn id="settlementDate"  index="dateSettled"   name="dateSettled"  title="%{getText('Settlement_Date_key')}" colType="date" sortable="true" search="true"/>
			       <psjg:gridColumn id="settledAmt"  index="settlementAmount"   name="settlementAmount"  title="%{getText('Settlement_Amount_key')}" colType="number" sortable="true" search="true" formatter="dashboard_settlementAmountLink" formatCol="currDecimalPoints"   />
			        <psjg:gridColumn id="hiddenSettlementAmount"  index="hiddenSettlementAmount"   formatter="currencyFmatter" formatCol="currDecimalPoints" 
					name="hiddenSettlementAmount"  title="hiddenSettlementAmount" colType="number" sortable="false" search="true" hidden="true" />
			       		   
			       
			       <psjg:gridColumn id="activeSettlement"  index="computedActiveSettlementAmt"   name="computedActiveSettlementAmt"  title="%{getText('Active_Settlement_key')}" colType="number" sortable="false" search="true"  formatter="currencyFmatter" formatCol="currDecimalPoints" />
			       <psjg:gridColumn id="remainingAmt"  index="computedRemainingAmt"   name="computedRemainingAmt"  title="%{getText('Remaining_Amount_key')}" colType="number" sortable="false" search="true"  formatter="currencyFmatter" formatCol="currDecimalPoints" />
			       <psjg:gridColumn id="reimbursedProfit"  index="trsPayPlanDetVO.REIMBURSED_PROFIT"   name="trsPayPlanDetVO.REIMBURSED_PROFIT"  title="%{getText('Reimbursed_Profit_key')}" colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"  />
			       <psjg:gridColumn id="reserveAmt"  index="trsPayPlanDetVO.RESERVE_AMOUNT"   name="trsPayPlanDetVO.RESERVE_AMOUNT"  title="%{getText('Reserve_Amount_key')}" colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"  />
			       <psjg:gridColumn id="amountReceived"  index="computedAmtReceived"   name="computedAmtReceived"  title="%{getText('Amt_Received_key')}" colType="number" sortable="false" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints" />
			       <psjg:gridColumn id="incidentalCost"  index="computedIncidentalCost"   name="computedIncidentalCost"  title="%{getText('Incidental_Cost_key')}" colType="number" sortable="false" search="true"  formatter="currencyFmatter" formatCol="currDecimalPoints" />
			       <psjg:gridColumn id="advInsurance"  index="computedAdvInsurance"   name="computedAdvInsurance"  title="%{getText('Advance_Insurance_key')}" colType="number" sortable="false" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"  />
			       <psjg:gridColumn id="totalInstallmentAmt"  index="computedTotalInstallment"   name="computedTotalInstallment"  title="%{getText('Total_Installment_key')}" colType="number" sortable="false" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints" />
			       <psjg:gridColumn id="currDecimalPoints"  index="currDecimalPoints"   name="currDecimalPoints"  title="currDecimalPoints" colType="number" sortable="false" search="true" hidden="true" />
			       <psjg:gridColumn id="status"          index="status"        name="status"       title="status"   hidden="true"    colType="text" sortable="false" search="false"  />
			       
			       
			       
			 </psjg:grid>
</td></tr>
</table>
       <table     width="100%" class="ui-state-focus">
     <tr class="ui-state-focus">
     
      <td>
         <span class="" style=" background: #00BFFF">&nbsp;&nbsp;&nbsp;&nbsp;</span>
      	 <span style="color: #00BFFF;"><ps:text name="Partially_Paid_key" /></span>
      </td>
      <td>
         <span class="" style=" background: blue">&nbsp;&nbsp;&nbsp;&nbsp;</span>
      	 <span style="color: blue;"><ps:text name="Paid_key" /></span>
      </td>
      <td>
         <span class="" style=" background: red">&nbsp;&nbsp;&nbsp;&nbsp;</span>
      	 <span style="color: red;"><ps:text name="Past_Due_key" /></span>
      </td>
      <td>
       	 <span class="" style=" background: green">&nbsp;&nbsp;&nbsp;&nbsp;</span>
      	 <span style="color: green;"><ps:text name="Early_Paid_key" /></span>
      </td>
         
       <td width="50%">      
      </td>   
     </tr>
    
    </table>
    
 
  <style>
 .circle {
    border-radius: 50%/50%; 
   
}
 </style>
 

