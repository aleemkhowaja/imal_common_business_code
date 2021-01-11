<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<ps:url id="urlUnmaturedInstallmentSummaryGrid_${_pageRef}"
	action="financingDealsListAction_loadUnmaturedInstallmentSummary"
	namespace="/path/globalview" escapeAmp="false">
	<ps:param name="financingDealsSC.planNbr"
		value="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_NBR"></ps:param>
	<ps:param name="financingDealsSC.planSeq"
		value="financingDealRepaymentPlanCO.trsPayPlanVO.PLAN_SEQ"></ps:param>
	<ps:param name="financingDealsSC.branchCode"
		value="financingDealsSC.branchCode"></ps:param>
	<ps:param name="financingDealsSC.dealNo"
		value="financingDealRepaymentPlanCO.trsPayPlanVO.TRX_NBR"></ps:param>

</ps:url>

<psjg:grid id="unmaturedInstallmentSummaryGrid_${_pageRef}"
	href="%{urlUnmaturedInstallmentSummaryGrid_${_pageRef}}"
	dataType="json" hiddengrid="false" pager="false" filter="false"
	caption="Unmatured Installment Summary" gridModel="gridModel" rowNum=""
	rowList="5,10,15,20" viewrecords="true" navigator="true" height="30"
	altRows="true" navigatorRefresh="false" pagerButtons="false"
	navigatorEdit="false" navigatorSearch="false" navigatorAdd="false"
	navigatorDelete="false" editurl="abc" rownumbers="true"
	editinline="true" autowidth="true" shrinkToFit="false">

	<psjg:gridColumn id="installmentAmount${_pageRef}" colType="number"
		name="trsPayPlanDetVO.AMOUNT" index="trsPayPlanDetVO.AMOUNT"
		title="%{getText('Total_Installment_Amount_key')}" editable="false"
		sortable="true" search="true" formatter="currencyFmatter"
		formatCol="currDecimalPoints" />

	<psjg:gridColumn id="profit_${_pageRef}" colType="number"
		name="trsPayPlanDetVO.PROFIT_AMT" index="trsPayPlanDetVO.PROFIT_AMT"
		title="%{getText('profit_key')}" editable="false" sortable="true"
		search="true" formatter="currencyFmatter"
		formatCol="currDecimalPoints" />

	<psjg:gridColumn id="principal_charges_insurance_${_pageRef}"
		colType="number" name="settlementAmount" index="settlementAmount"
		title="%{getText('Principal_Charge_Insurance_Amt_key')}"
		editable="false" sortable="true" search="true"
		formatter="currencyFmatter" formatCol="currDecimalPoints" />

	<psjg:gridColumn id="principal_${_pageRef}" colType="number"
		name="trsPayPlanDetVO.CAPITAL_AMT" index="trsPayPlanDetVO.CAPITAL_AMT"
		title="%{getText('Principal_key')}" editable="false" sortable="true"
		search="true" formatter="currencyFmatter"
		formatCol="currDecimalPoints" />

	<psjg:gridColumn id="charges_${_pageRef}" colType="number"
		name="trsPayPlanDetVO.CHARGE_AMOUNT"
		index="trsPayPlanDetVO.CHARGE_AMOUNT"
		title="%{getText('charges_key')}" editable="false" sortable="true"
		search="true" formatter="currencyFmatter"
		formatCol="currDecimalPoints" />

	<psjg:gridColumn id="insurance_${_pageRef}" colType="number"
		name="trsPayPlanDetVO.INSURANCE_AMOUNT"
		index="trsPayPlanDetVO.INSURANCE_AMOUNT"
		title="%{getText('insurance_key')}" editable="false" sortable="true"
		search="true" formatter="currencyFmatter"
		formatCol="currDecimalPoints" />

	<psjg:gridColumn title="vgg" name="currDecimalPoints" value="3"
		index="currDecimalPoints" id="currDecimalPoints" colType="number"
		hidden="true" />
</psjg:grid>