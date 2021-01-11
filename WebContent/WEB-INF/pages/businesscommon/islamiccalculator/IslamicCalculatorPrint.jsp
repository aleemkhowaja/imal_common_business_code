<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<style>
  .iiShighlight{
   background-color:#999999;
   -webkit-print-color-adjust: exact; 
   height: 16px;
   }
   
   .iiSRowhigh{
   height: 20px;
   }
   
   .iiSfontbold{
   font-weight:bold;
   }
   .iiSpadding{
   padding-top:5px !important;
   paddi
   }
 </style>
<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
<table style="width: 100%;" >
	<tr>
		<td width="22%"></td>
		<td width="3%"></td>
		<td width="50%"></td>
		<td width="3%"></td>
		<td width="20%"></td>
		<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Date_key" cssStyle="font-weight: bold !important;"
				id="lbl_date_${_pageRef}" /></td>
		<td align="center">:</td>
		<td style="border-bottom: thin solid;background-color: lightgrey;pad" align="right"><ps:date
				name="islamicCalculatorEventMgmtCO.startDate" format="dd/MM/yyyy" />
		</td>
		<td align="center">:</td>
		<td class="iisfldLabelViewArab" align="right"><ps:label key="Date_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_date_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Product_Class_key" cssStyle="font-weight: bold !important;"
				id="Product_Class_${_pageRef}" /></td>
		<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.productClassName" /></td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Product_Class_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Product_Class_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Total_Amount_key" cssStyle="font-weight: bold !important;"
				id="lbl_totalAmount_${_pageRef}" /></td>
		<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.currencyDesc" /> <ps:property
				value="getText('{0,number,#,%{islamicCalculatorEventMgmtCO.islamicCalcDecimalFormatPrint}}',{islamicCalculatorEventMgmtCO.purchaseAmount})" />
		</td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Total_Amount_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Total_Amount_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Total_Deal_Amount_key" cssStyle="font-weight: bold !important;"
				id="lbl_totalDealAmount_${_pageRef}" /></td>
		<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.currencyDesc" /> <ps:property
				value="getText('{0,number,#,%{islamicCalculatorEventMgmtCO.islamicCalcDecimalFormatPrint}}',{calculatorCO.outSaleAmount})" />
		</td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Total_Deal_Amount_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Total_Deal_Amount_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Deal_Period_month_key" cssStyle="font-weight: bold !important;"
				id="lbl_Deal_Period_month_${_pageRef}" /></td>
		<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.noOfMonths" /></td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Deal_Period_month_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Deal_Period_month_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Down_Payment_key" cssStyle="font-weight: bold !important;"
				id="lbl_Down_Payment_${_pageRef}" /></td>
		<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.currencyDesc" /> <ps:property
				value="getText('{0,number,#,%{islamicCalculatorEventMgmtCO.islamicCalcDecimalFormatPrint}}',{islamicCalculatorEventMgmtCO.DownPaymentAmount})" />
		</td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Down_Payment_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Down_Payment_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="No_Of_Payments" cssStyle="font-weight: bold !important;"
				id="lbl_No_Of_Payments_${_pageRef}" /></td>
		<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.noOfPayments" /></td>
		<td align="center">:</td>
		<td align="right"><ps:label key="No_Of_Payments_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_no_of_payment_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Amount_Per_Payment_key" cssStyle="font-weight: bold !important;"
				id="lbl_Amount_Per_Payment_${_pageRef}" /></td>
				<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.currencyDesc" /> <ps:property
				value="getText('{0,number,#,%{islamicCalculatorEventMgmtCO.islamicCalcDecimalFormatPrint}}',{calculatorCO.outAmountPerPayment})" />
		</td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Amount_Per_Payment_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Amount_Per_Payment_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Last_Payment_key" cssStyle="font-weight: bold !important;"
				id="lbl_date_${_pageRef}" /></td>
				<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.currencyDesc" /> <ps:property
				value="getText('{0,number,#,%{islamicCalculatorEventMgmtCO.islamicCalcDecimalFormatPrint}}',{islamicCalculatorEventMgmtCO.lastPaymentAmount})" />

		</td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Last_Payment_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Last_Payment_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Remaining_Amount_key" cssStyle="font-weight: bold !important;"
				id="lbl_Remaining_Amount_${_pageRef}" /></td>
				<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.currencyDesc" /> <ps:property
				value="getText('{0,number,#,%{islamicCalculatorEventMgmtCO.islamicCalcDecimalFormatPrint}}',{calculatorCO.outRemainingAmount})" />
		</td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Remaining_Amount_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Remaining_Amount_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr >
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="First_Payment_Date_key" cssStyle="font-weight: bold !important;"
				id="lbl_First_Payment_Date_${_pageRef}" /></td>
				<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:date
				name="islamicCalculatorEventMgmtCO.firstPaymentDate"
				format="dd/MM/yyyy" /></td>
				<td align="center">:</td>
		<td align="right"><ps:label key="First_Payment_Date_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_First_Payment_Date_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Total_Profit_key" cssStyle="font-weight: bold !important;"
				id="lbl_Total_Profit_${_pageRef}" /></td>
				<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right"><ps:property
				value="islamicCalculatorEventMgmtCO.currencyDesc" /> <ps:property
				value="getText('{0,number,#,%{islamicCalculatorEventMgmtCO.islamicCalcDecimalFormatPrint}}',{calculatorCO.outProfitAmount})" />
		</td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Total_Profit_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Total_Profit_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr class="iiSRowhigh">
		<td class="fldLabelView"><ps:label key="Notes_key" cssStyle="font-weight: bold !important;"
				id="lbl_Notes_${_pageRef}" /></td>
				<td align="center">:</td>
		<td style="border-bottom: thin solid" align="right">&nbsp;&nbsp;</td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Notes_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Notes_Arb_${_pageRef}" /></td>
				<td width="2%"></td>
	</tr>
	<tr>
		<td colspan="6">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="6">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="5" style="text-decoration: underline; font-weight: bold;"
			align="right"><ps:label key="documents_requested_customer_guarantor_arb_key"  cssStyle="font-weight: bold !important; font-size: 12px !important; font-style: italic !important; "
				 id="lbl_Notes_Arb_${_pageRef}" /></td>
		<td width="2%"></td>
	</tr>
	<tr>
		<td colspan="6" style="text-decoration: underline;"
			align="left"><ps:label
				key="Documents requested from the customer & guarantor (if needed) :"
				cssStyle="font-weight: bold !important; font-style: italic !important; font-size: 12px !important;" id="lbl_Notes_Eng_${_pageRef}" /></td>
	</tr>
	<tr>
		<td colspan="6">&nbsp;</td>
	</tr>
</table>
<table style="width: 100%;">
	<tr>
		<td width="5%"></td>
		<td width="45%"></td>
		<td width="43%" align="right"></td>
		<td width="5%" align="right"></td>
		<td width="2%"></td>
	</tr>
	<tr>
		<td class="fldLabelView" align="left"><input type="checkbox" /></td>
		<td class="fldLabelView"><ps:label key="Orginal_civil_ID_key" cssStyle="font-weight: bold !important;"
				id="lbl_Orginal_civil_ID_${_pageRef}" /></td>
		<td align="right"><ps:label key="Orginal_civil_ID_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Orginal_civil_ID_Arb_${_pageRef}" /></td>
		<td class="fldLabelView"><input type="checkbox" /></td>
		<td width="2%"></td>
	</tr>

	<tr>
		<td class="fldLabelView" align="left"><input type="checkbox" /></td>
		<td class="fldLabelView"><ps:label cssStyle="font-weight: bold !important;"
				key="New_salary_certificate_key"
				id="lbl_New_salary_certificate_${_pageRef}" /></td>
		<td align="right"><ps:label key="New_salary_certificate_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_New_salary_certificate_Arb${_pageRef}" /></td>
		<td class="fldLabelView"><input type="checkbox" /></td>
		<td width="2%"></td>
	</tr>
	<tr>
		<td class="fldLabelView" align="left"><input type="checkbox" /></td>
		<td class="fldLabelView"><ps:label cssStyle="font-weight: bold !important;"
				key="Bank Statement for the last 3 Month (Non cust.)"
				id="lbl_Bank_Statement_for_the_${_pageRef}" /></td>
		<td align="right"><ps:label key="bank_statement_for_the_non_cust_arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Bank_Statement_for_the_Arb${_pageRef}" /></td>
		<td class="fldLabelView"><input type="checkbox" /></td>
		<td width="2%"></td>
	</tr>
	<tr>
		<td class="fldLabelView" align="left"><input type="checkbox" /></td>
		<td class="fldLabelView"><ps:label key="ATM_card_key" cssStyle="font-weight: bold !important;"
				id="lbl_ATM_card_${_pageRef}" /></td>
		<td align="right"><ps:label key="ATM_card_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_BATM_card_Arb_${_pageRef}" /></td>
		<td class="fldLabelView"><input type="checkbox" /></td>
		<td width="2%"></td>
	</tr>
	<tr>
		<td class="fldLabelView" align="left"><input type="checkbox" /></td>
		<td class="fldLabelView"><ps:label key="Purchaser_Offer_key" cssStyle="font-weight: bold !important;"
				id="lbl_Purchaser_Offer_${_pageRef}" /></td>
		<td align="right"><ps:label key="purchaseroffer_arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Purchaser_Offer_Arb_${_pageRef}" /></td>
		<td class="fldLabelView"><input type="checkbox" /></td>
		<td width="2%"></td>
	</tr>
	<tr>
		<td class="fldLabelView" align="left"><input type="checkbox" /></td>
		<td class="fldLabelView"><ps:label
				key="Car_Registeration_in_case_of_used_cars_key" cssStyle="font-weight: bold !important;"
				id="lbl_Car_Registeration_in_case_of_used_cars_${_pageRef}" /></td>
		<td align="right"><ps:label
				key="Car_Registeration_in_case_of_used_cars_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Car_Registeration_in_case_of_used_cars_Arb_${_pageRef}" />
		</td>
		<td class="fldLabelView"><input type="checkbox" /></td>
		<td width="2%"></td>
	</tr>
	<tr>
		<td class="fldLabelView" align="left"><input type="checkbox" /></td>
		<td class="fldLabelView"><ps:label key="Others_key" cssStyle="font-weight: bold !important;"
				id="lbl_Others_${_pageRef}" /></td>
		<td align="right"><ps:label key="Others_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Others_Arb_${_pageRef}" /></td>
		<td class="fldLabelView"><input type="checkbox" /></td>
		<td width="2%"></td>
	</tr>
<tr>
		<td colspan="5">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="5">&nbsp;</td>
	</tr>
</table>

<div Style="font-weight: bold !important;">
<table style="width: 100%;" >
	<tr class="iiShighlight">
		<td align="center" >
					<ps:label key="calculatorUsrArb_key"  cssStyle="font-weight: bold !important;" />
					<ps:label key="" value="%{#session.sesVO.userName}" cssStyle="font-weight: bold !important;" />
					<ps:label key="" value="%{#session.sesVO.companyName}" cssStyle="font-weight: bold !important;" />
					 
		</td>
	</tr>
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr>
		<td >&nbsp;</td>
	</tr>
</table>
</div>

<table style="width: 100%;">
	<tr>
		<td width="22%"></td>
		<td width="3%"></td>
		<td width="50%"></td>
		<td width="3%"></td>
		<td width="20%"></td>
		<td width="2%"></td>
	</tr>
	<tr>
		<td class="fldLabelView"><ps:label key="Employee_Name_key" cssStyle="font-weight: bold !important;"
				id="lbl_Employee_Name_${_pageRef}" /></td>
		<td align="center">:</td>
		<td style="border-bottom: thin solid" align="left"><ps:property
				value="%{#session.sesVO.userFirstName}" /> <ps:property
				value="%{#session.sesVO.userLastName}" /></td>
		<td align="center">:</td>
		<td align="right"><ps:label key="Employee_Name_Arb_key" cssStyle="font-weight: bold !important;"
				id="lbl_Employee_Name_Arb_${_pageRef}" /></td>
			<td width="2%"></td>
	</tr>
</table>


<table style="width: 100%;" >
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr>
		<td >&nbsp;</td>
	</tr>
	<tr>
		<td align="center" >
					<ps:label key="telephoneservicearb_key"  /> <ps:property value="%{companyTelNo}"   />
		</td>
	</tr>
	<tr>
		<td align="center" >
					<ps:property value="%{companyDomain}" />
		</td>
	</tr>
	
	
</table>


