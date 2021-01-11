<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>
<ps:form id="islamicCalculatorFormMaindiv_${_pageRef}" >
	<ps:hidden id="hidden_calculatorType_${_pageRef}"
		name="islamicCalculatorEventMgmtCO.calculatorType"></ps:hidden>
	<%--  		 TP# 271723;deepu.mohandas 18/02/2015 --%>
	<ps:hidden id="islamicCalculatorEventMgmtCO_category_${_pageRef}"
		name="islamicCalculatorEventMgmtCO.category" />
	<ps:hidden id="islamicCalculatorEventMgmtCO_firstYrProfit_${_pageRef}"
		name="islamicCalculatorEventMgmtCO.firstYrProfit" />
	<ps:hidden id="islamicCalculatorEventMgmtCO_lastPayment_${_pageRef}"
		name="islamicCalculatorEventMgmtCO.lastPaymentAmount" />
	<ps:hidden id="hidden_dealNo_${_pageRef}"
		name="islamicCalculatorEventMgmtCO.dealNo" />
	<ps:hidden id="hidden_tradeDealNo_${_pageRef}"
		name="islamicCalculatorEventMgmtCO.tradeDealNo" />
	<ps:hidden id="hidden_planNbr_${_pageRef}"
		name="islamicCalculatorEventMgmtCO.planNbr" />
	<ps:hidden id="hidden_islamicCalcDecimalFormatPrint_${_pageRef}"
		name="islamicCalculatorEventMgmtCO.islamicCalcDecimalFormatPrint" />
	<ps:hidden id="previousValues_${_pageRef}" />
	<ps:hidden id="previousValuesDesc_${_pageRef}" />
	<ps:hidden id="hiddenNoOfPayments_${_pageRef}" />
	<ps:hidden id="settlementChargeGridData_${_pageRef}"
		name="settlementChargeGridData" />
	<ps:hidden id="financingAmountPreValue_${_pageRef}" />
	<ps:hidden id="repaymentAmountSum_${_pageRef}"></ps:hidden>
	<ps:hidden id="DEALCHARGE_VAT_PERCENTAGE_IND_${_pageRef}" value="P"></ps:hidden>
	<%--BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 --%>
	<ps:hidden id="topUpGridData_${_pageRef}" name="islamicCalculatorEventMgmtCO.topUpGridData" ></ps:hidden>
	<ps:hidden id="topUpJasonData_hidden_${_pageRef}" name="islamicCalculatorEventMgmtCO.topUpJasonData" ></ps:hidden>
	<ps:hidden id="topup_cy_hidden_${_pageRef}" name="islamicCalculatorEventMgmtCO.trsTopUpDealVO.TOP_UP_DEAL_CY" ></ps:hidden>
	<ps:hidden id="topup_deal_amount_hidden_${_pageRef}" name="islamicCalculatorEventMgmtCO.trsTopUpDealVO.TOP_UP_DEAL_AMOUNT" ></ps:hidden>
	<ps:hidden id="advance_payment_value_date_hidden_${_pageRef}" name="islamicCalculatorEventMgmtCO.trsTopUpDealVO.VALUE_DATE" ></ps:hidden>
	 
	<ps:hidden id="strRepaymentCharges_${_pageRef}" name="strRepaymentCharges" ></ps:hidden>
		
	<%--BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619  end --%>
	<div id="islamicCalculatorMaindiv_${_pageRef}"
		class="connectedSortable ui-helper-reset">
		<div id="financingdetailsdiv_${_pageRef}" class="collapsibleContainer"
			title="<ps:text name="FINANCING_DETAILS_key"/>">
			<!-- Financing Details Section Starts -->
			<table style="width: 100%"
				class="headerPortionContent ui-widget-content">
				<tr>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
				</tr>
				<tr>
					<td class="fldLabelView"><ps:label key="CIF_No_key"
							id="lblCIF_No_${_pageRef}" for="lookuptxt_cifNo_${_pageRef}" /></td>
					<td><psj:livesearch name="islamicCalculatorEventMgmtCO.cifNo"
							id="cifNo_${_pageRef}" mode="number" leadZeros="8" maxlength="8"
							searchElement="CIF_NO"
							paramList="lookupCivilId:hidden_civilidFlag_${_pageRef}"
							actionName="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructCifQueryLookup"
							beforeDepEvent="beforeDependencyForCifValidationInCalculator()"
							parameter="islamicCalculatorEventMgmtCO.cifNo:lookuptxt_cifNo_${_pageRef},
							                      islamicCalculatorEventMgmtCO.startDate:startDate_${_pageRef},
							                      islamicCalculatorEventMgmtCO.productClass:lookuptxt_productClass_${_pageRef},
							                      islamicCalculatorEventMgmtCO.currencyCode:lookuptxt_currencyCode_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeCifCivilId"
							dependency="lookuptxt_civilId_${_pageRef}:islamicCalculatorEventMgmtCO.idNo,
			                   				  			lookuptxt_cifNo_${_pageRef}:islamicCalculatorEventMgmtCO.cifNo,
			                   				  			cifName_${_pageRef}:islamicCalculatorEventMgmtCO.cifName,
			                   				  			approvedSalary_${_pageRef}:islamicCalculatorEventMgmtCO.approvedSalary,
			                   				  			income_${_pageRef}:islamicCalculatorEventMgmtCO.income,
			                   				  			debtBurdanRatio_${_pageRef}:islamicCalculatorEventMgmtCO.debtBurdanRatio,
			                   				  			maintainSalaryAccount_${_pageRef}:islamicCalculatorEventMgmtCO.salaryWithBank"
							afterDepEvent="afterDependencyForCifValidationInCalculator()">
						</psj:livesearch></td>
					<td colspan="2"><ps:textfield id="cifName_${_pageRef}"
							readonly="true" name="islamicCalculatorEventMgmtCO.cifName"></ps:textfield>
					</td>
					<td><psj:submit id="queryBtn_${_pageRef}" button="true"
							type="button" buttonIcon="ui-icon-flag"
							onclick="islmCalc_showQuery()">
							<ps:label key="Query_key"></ps:label>
						</psj:submit></td>
					<td class="fldLabelView"><ps:label key="Civil_ID_key"
							id="lblCivil_ID_${_pageRef}" /></td>
					<td colspan="2"><psj:livesearch
							name="islamicCalculatorEventMgmtCO.idNo" id="civilId_${_pageRef}"
							mode="text" maxlength="19"
							actionName="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructLookup"
							paramList="lookupCivilId:hidden_civilidFlag_${_pageRef}"
							resultList="ID_NO:lookuptxt_civilId_${_pageRef}"
							searchElement="ID_NO"
							parameter="islamicCalculatorEventMgmtCO.cifNo:lookuptxt_cifNo_${_pageRef},islamicCalculatorEventMgmtCO.startDate:startDate_${_pageRef},islamicCalculatorEventMgmtCO.productClass:lookuptxt_productClass_${_pageRef},islamicCalculatorEventMgmtCO.idNo:lookuptxt_civilId_${_pageRef},islamicCalculatorEventMgmtCO.currencyCode:lookuptxt_currencyCode_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeCivilId"
							dependency="lookuptxt_civilId_${_pageRef}:islamicCalculatorEventMgmtCO.idNo,lookuptxt_cifNo_${_pageRef}:islamicCalculatorEventMgmtCO.cifNo,cifName_${_pageRef}:islamicCalculatorEventMgmtCO.cifName,approvedSalary_${_pageRef}:islamicCalculatorEventMgmtCO.approvedSalary,income_${_pageRef}:islamicCalculatorEventMgmtCO.income,debtBurdanRatio_${_pageRef}:islamicCalculatorEventMgmtCO.debtBurdanRatio,
			                   				  			maintainSalaryAccount_${_pageRef}:islamicCalculatorEventMgmtCO.salaryWithBank">
						</psj:livesearch></td>

					<td class="fldLabelView"><ps:label key="Income_key"
							id="lbl_Income_${_pageRef}" for="income_${_pageRef}" /></td>
					<td colspan="2"><ps:textfield id="income_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.income" mode="number"
							nbFormat="#,###.##" maxlength="14" /></td>
				</tr>
				

				<tr>
					<td class="fldLabelView"><ps:label key="Product_Class_key"
							id="lbl_Product_Class_${_pageRef}"
							for="lookuptxt_productClass_${_pageRef}" /></td>
					<td><psj:livesearch
							actionName="${pageContext.request.contextPath}/pathdesktop/productClassLookup_constructLookup"
							id="productClass_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.productClass"
							searchElement="CODE" autoSearch="true" mode="number"
							resultList="CODE:lookuptxt_productClass_${_pageRef},BRIEF_NAME_ENG:productClassName_${_pageRef}"
							parameter="CODE:lookuptxt_productClass_${_pageRef}" maxlength="4"
							dependencySrc="${pageContext.request.contextPath}/pathdesktop/ProductClassDependencyAction_dependencyByProductClassCode"
							dependency="lookuptxt_productClass_${_pageRef}:productClassCO.CODE,productClassName_${_pageRef}:productClassCO.BRIEF_NAME_ENG,profitRecognitionMethod_:islamicCalculatorEventMgmtCO.profitRecognitionMethod"
							beforeDepEvent="islamicCalculator_productClassBeforeDependencyValue()"
							afterDepEvent="islamic_onChangeProductClass()">
						</psj:livesearch> <!-- TODO add this in dependency  the radio doc Pay_Residual_Amount_${_pageRef}:islamicCalculatorEventMgmtCO.payResAmt,-->
					</td>
					<td colspan="2"><ps:textfield
							id="productClassName_${_pageRef}" readonly="true"
							name="islamicCalculatorEventMgmtCO.productClassName" /></td>
					<td></td>
					<td class="fldLabelView"><ps:label
							key="Financing_Currency_key"
							id="lbl_Financing_Currency_${_pageRef}"
							for="lookuptxt_currencyCode_${_pageRef}" /></td>
					<td><psj:livesearch
							actionName="${pageContext.request.contextPath}/pathdesktop/currencyLookup_constructLookup"
							id="currencyCode_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.currencyCode"
							searchElement="CURRENCY_CODE" autoSearch="true" maxlength="3"
							resultList="CURRENCY_CODE:lookuptxt_currencyCode_${_pageRef},BRIEF_DESC_ENG:currencyDesc_${_pageRef}"
							mode="number" afterDepEvent="onChangeCurrencyCode();" beforeDepEvent="calculator_beforeDepCurrencyCode()"
							parameter="islamicCalculatorEventMgmtCO.currencyCode:lookuptxt_currencyCode_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_dependencyByCurrencyCode"
							dependency="lookuptxt_currencyCode_${_pageRef}:islamicCalculatorEventMgmtCO.currencyCode,currencyDesc_${_pageRef}:islamicCalculatorEventMgmtCO.currencyDesc,hidden_islamicCalcDecimalFormat_${_pageRef}:islamicCalculatorEventMgmtCO.currencyDecimalPointsForCalc">
						</psj:livesearch></td>
					<td><ps:textfield id="currencyDesc_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.currencyDesc" readonly="true">
						</ps:textfield></td>
					<td class="fldLabelView"><ps:label key="Profit_Collected_key"
							id="lbl_Profit_Collected_${_pageRef}"
							for="profitCollected_${_pageRef}" /></td>
					<td colspan="2"><ps:textfield id="profitCollected_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.advancePayment" mode="number"
							nbFormat="#,###.##" maxlength="14" minValue="0" readonly="false" /></td>
				</tr>
				<tr>
					<td class="fldLabelView"><ps:label key="Purchase_Amount_key"
							id="lbl_Purchase_Amount_${_pageRef}"
							for="purchaseAmount_${_pageRef}" /></td>
					<td><ps:textfield id="purchaseAmount_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.purchaseAmount" mode="number"
							nbFormat="#,###.##" onchange="onChangePurchaseAmount()" /></td>
					<td class="fldLabelView"><ps:label key="Down_Pay_Ptg_key"
							id="lbl_Down_Payment_${_pageRef}"
							for="downPaymentPercentage_${_pageRef}" /></td>
					<td colspan="1"><ps:textfield
							id="downPaymentPercentage_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.downPaymentPercentage"
							onchange="onChangeDownPaymentPercentage()" mode="number"
							nbFormat="##0.00" /></td><%--TP#682482 --%>
					<td></td>
					<td class="fldLabelView"><ps:label key="Down_Payment_key"
							id="lbl_downPaymentAmount_${_pageRef}"
							for="downPaymentAmount_${_pageRef}" /></td>
					<td colspan="2"><ps:textfield
							id="downPaymentAmount_${_pageRef}" mode="number"
							nbFormat="#,###.##"
							name="islamicCalculatorEventMgmtCO.downPaymentAmount"
							onchange="onChangeDownPayment()" /></td>

					<td class="fldLabelView"><ps:label key="Financing_Amount_key"
							id="lbl_Financing_Amount_${_pageRef}"
							for="financingAmount_${_pageRef}" /></td>
					<td colspan="2"><ps:textfield id="financingAmount_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.financingAmount" mode="number"
							nbFormat="#,###.##" onchange="onChangeFinancingAmount(true)" />
					</td>
				</tr>
				<tr>
					<td class="fldLabelView"><ps:label key="Start_date_key"
							id="lbl_Start_date_${_pageRef}" for="startDate_${_pageRef}" /></td>
					<td><psj:datepicker id="startDate_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.startDate"
							buttonImageOnly="true" onchange="validateOnChangeStartDate()" />
					</td>
					<td class="fldLabelView"><ps:label key="Maturity_Date_key"
							id="lbl_Maturity_Date_${_pageRef}" for="maturityDate_${_pageRef}" />
					</td>
					<td colspan="2"><psj:datepicker id="maturityDate_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.maturityDate"
							buttonImageOnly="true" onchange="onChangeMaturityDate()"
							required="true" /></td>
					<td class="fldLabelView"><ps:label key="Tenure_key"
							id="lbl_Tenure_${_pageRef}" for="tenure_${_pageRef}" /></td>

					<td><ps:textfield readonly="true" id="tenure_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.tenureCode" mode="number"
							maxlength="5" /></td>

					<td><ps:select disabled="true" id="tenure_${_pageRef}"
							list="paymPeriodicity" listKey="code" listValue="descValue"
							name="islamicCalculatorEventMgmtCO.tenureDesc"></ps:select></td>


					<td class="fldLabelView"><ps:label key="Calendar_Type_key"
							id="lbl_Calendar_Type_${_pageRef}"
							for="Calendar_Type_${_pageRef}" /></td>
					<td colspan="2"><ps:select id="Calendar_Type_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.calendarType"
							list="calendarType" listKey="code" listValue="descValue" /></td>


				</tr>
				<tr>
					<td class="fldLabelView"><ps:label key="Approved_Salary_key"
							id="lbl_Approved_Salary_${_pageRef}"
							for="approvedSalary_${_pageRef}" /></td>
					<td colspan="2"><ps:textfield mode="number"
							nbFormat="#,###.##" maxlength="14" minValue="0"
							name="islamicCalculatorEventMgmtCO.approvedSalary"
							id="approvedSalary_${_pageRef}"
							parameter="islamicCalculatorEventMgmtCO.approvedSalary:approvedSalary_${_pageRef},islamicCalculatorEventMgmtCO.cifNo:lookuptxt_cifNo_${_pageRef},islamicCalculatorEventMgmtCO.startDate:startDate_${_pageRef},islamicCalculatorEventMgmtCO.productClass:lookuptxt_productClass_${_pageRef},islamicCalculatorEventMgmtCO.currencyCode:lookuptxt_currencyCode_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeApprovedSalary"
							dependency="approvedSalary_${_pageRef}:islamicCalculatorEventMgmtCO.approvedSalary,debtBurdanRatio_${_pageRef}:islamicCalculatorEventMgmtCO.debtBurdanRatio" />
					</td>
					<td colspan="2"><ps:checkbox
							id="maintainSalaryAccount_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.maintainSalaryAccount"
							cssClass="ui-widget-content checkboxheight"
							key="Salary_With_Bank_key" valOpt="Y:N"
							onchange="populateOnChangeSalaryWithBank()" /></td>

					<ps:set var="show" value="%{'display:none'}" />
					<ps:if
						test='%{islamicCalculatorEventMgmtCO.calcDbrCalculationReqdYn!=null && islamicCalculatorEventMgmtCO.calcDbrCalculationReqdYn.equals("Y")}'>
						<td class="fldLabelView"><ps:label
								key="Debt_Burden_Ratio_key"
								id="lbl_Debt_Burden_Ratio_${_pageRef}"
								for="debtBurdanRatio_${_pageRef}" /></td>
						<td colspan="2"><ps:textfield
								id="debtBurdanRatio_${_pageRef}"
								name="islamicCalculatorEventMgmtCO.debtBurdanRatio"
								mode="number" nbFormat="#,###.##" maxlength="14"
								cssStyle="%{hide}" /></td>
						<td colspan="3"><psj:submit id="debitburdan_${_pageRef}"
								button="true" type="button"
								onclick="onDebitBurdunRatioButtonClicked();" cssStyle="%{hide}"
								name="debitburdan">
								<ps:label key="Debt_Burden_Ratio_key" />
							</psj:submit></td>
					</ps:if>
				</tr>
				<tr><%--BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 --%>
					<td class="fldLabelView"><ps:label key="Type_key"
							id="lbl_dealType_${_pageRef}" for="dealType_${_pageRef}" /></td>
	
					<td><ps:select disabled="false" id="dealType_${_pageRef}" 
 								list="dealTypeDropDownList" listKey="code" listValue="descValue" 
 								name="islamicCalculatorEventMgmtCO.dealType" 
 								onchange="onChangeDealType()" 
 								></ps:select>
					</td> 
					<td height="5%">
						<psj:submit id="dealTypeBtn_${_pageRef}" button="true" type="button"
							 onclick="validateDealType();">
							<ps:label key="." />
						</psj:submit>
					</td>
				</tr>
			</table>
			<%--       TP#247336;Arun.R.Variyath;10/12/2014 Start--%>
			<div id="musawamahDiv_${_pageRef}" style="display: none">
				<table style="width: 100%"
					class="headerPortionContent ui-widget-content">
					<tr>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
					</tr>
					<tr>
						<%--       TP#258278,  258270;Roshin;06/01/2015 End--%>
						<td class="fldLabelView"><ps:label key="Contract_Price_key"
								id="lbl_Contract_Price_${_pageRef}"
								for="contractPrice_${_pageRef}" /></td>
						<td class="fldDataEdit"><ps:textfield
								id="contractPrice_${_pageRef}"
								name="islamicCalculatorEventMgmtCO.contractPrice" mode="number"
								nbFormat="#,###.###" maxLenBeforeDec="12" minValue="0"
								onchange="islamicCalculator_onChangeContractPrice()" /></td>
						<td></td>
						<td class="fldDataEdit"><ps:label
								key="Discount_Calc_Method_key"
								id="lbl_Discount_Cal_Method_${_pageRef}"
								for="discountCalMethod_${_pageRef}" /></td>
						<td class="fldDataEdit" colspan="2"><ps:select
								id="discountCalMethod_${_pageRef}" list="discountCalMethodList"
								listKey="code" listValue="descValue"
								name="islamicCalculatorEventMgmtCO.discountCalMethod"
								onchange="islamicCalculator_onChangeContractPrice()"></ps:select>
						</td>
						<td class="fldLabelView"><ps:label key="Discount_Ptg_key"
								id="lbl_Discount_Perc_${_pageRef}"
								for="discountPerc_${_pageRef}" /></td>
						<td class="fldDataEdit"><ps:textfield
								id="discountPerc_${_pageRef}"
								name="islamicCalculatorEventMgmtCO.discountPerc" mode="number"
								nbFormat="#,###.########" maxLenBeforeDec="3" minValue="0"
								onchange="islamicCalculator_onChangeContractPrice()" /></td>
					</tr>
				</table>
			</div>
			<%--       TP#247336;Arun.R.Variyath;10/12/2014 End--%>

		</div>
		<!-- 	Financing Details Section 	End -->
		<%-- Profit.Calculation Details --%>

		<div id="profitcalculationdetailsdiv_${_pageRef}"
			class="collapsibleContainer"
			title="<ps:text name="PROFIT_CALC_DETAILS_key"/>">
			<!-- Profit Calculation Section Starts -->
			<table style="width: 100%"
				class="headerPortionContent ui-widget-content">
				<tr>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
				</tr>
				<tr>
						 <%-- Removed if clause TP 642518 --%>
						<td class="fldLabelView"><ps:label
								key="Annual_Yield_Rate_key"
								id="lbl_Annual_Yield_Rate_${_pageRef}"
								for="annualYieldRate_${_pageRef}" /></td>
						<td>
							<%--TP#164973; Libin; 06/11/2014 --%> <ps:textfield
								id="annualYieldRate_${_pageRef}"
								name="islamicCalculatorEventMgmtCO.annualYieldRate"
								mode="number" nbFormat="#,0.000000" onchange="onChangeYield()" />
						</td>
					<ps:if
						test='%{islamicCalculatorEventMgmtCO.allowProfitRecoInCalc==null || !islamicCalculatorEventMgmtCO.allowProfitRecoInCalc.equals("N")}'>
						<td class="fldLabelView"><ps:label key="Margin_key"
								id="lbl_Margin_${_pageRef}" for="margin_${_pageRef}" /></td>
						<td><ps:textfield id="margin_${_pageRef}"
								name="islamicCalculatorEventMgmtCO.margin" mode="number"
								nbFormat="#,0.00000000"
								onchange="calculateAnnualFloatingMarginRates()" /></td>
						<td class="fldLabelView"><ps:label
								key="Floating_Rate_Code_key"
								id="lbl_Floating_Rate_Code_${_pageRef}"
								for="lookuptxt_floatingRateCode_${_pageRef}" /></td>
						<td><psj:livesearch
								actionName="${pageContext.request.contextPath}/pathdesktop/floatingRateCodeLookup_constructLookup"
								id="floatingRateCode_${_pageRef}"
								name="islamicCalculatorEventMgmtCO.floatingRateCode"
								mode="number" maxlength="12" searchElement="IBOR_CODE"
								autoSearch="false"
								resultList="BRIEF_DESC_ENG:floatingRateCode_desc_${_pageRef}"
								parameter="IBOR_CODE:lookuptxt_floatingRateCode_${_pageRef}"
								dependencySrc="${pageContext.request.contextPath}/pathdesktop/FloatingRateCodeDependencyAction_dependencyByIBOR_CODE"
								dependency="lookuptxt_floatingRateCode_${_pageRef}:iborhdrVO.IBOR_CODE,floatingRateCode_desc_${_pageRef}:iborhdrVO.BRIEF_DESC_ENG">
							</psj:livesearch></td>
						<td colspan="3"><ps:textfield
								id="floatingRateCode_desc_${_pageRef}" readonly="true"
								name="islamicCalculatorEventMgmtCO.floatingRateCodeDesc">
							</ps:textfield></td>
						<td class="fldLabelView"><ps:label key="Floating_Rate_key"
								id="lbl_Floating_Rate_${_pageRef}"
								for="floatingRate_${_pageRef}" /></td>
						<td colspan="3"><ps:textfield id="floatingRate_${_pageRef}"
								name="islamicCalculatorEventMgmtCO.floatingRate" mode="number"
								nbFormat="#,0.00000000"
								onchange="calculateAnnualFloatingMarginRates()" /></td>
					</ps:if>
				</tr>
				<tr>
					<%-- <ps:if test='%{islamicCalculatorEventMgmtCO.allowProfitRecoInCalc==null || !islamicCalculatorEventMgmtCO.allowProfitRecoInCalc.equals("N")}'> --%>

					<td class="fldLabelView"><ps:label key="Annual_Flat_Rate_key"
							id="lbl_Annual_Flat_Rate_${_pageRef}"
							for="annualFlatRate_${_pageRef}" /></td>
					<td><ps:textfield id="annualFlatRate_${_pageRef}"
							name="calculatorCO.outAnnualFlatRate" readonly="true"
							mode="number" maxValue="99999.999999" nbFormat="#,0.000000" /></td>
					<td class="fldLabelView"><ps:label key="Total_Flat_Rate_key"
							id="lbl_Total_Flat_Rate_${_pageRef}"
							for="totalFlatRate_${_pageRef}" /></td>
					<td><ps:textfield id="totalFlatRate_${_pageRef}"
							name="calculatorCO.outTotalFlatRate" mode="number"
							maxValue="99999.999999" minValue="0"
							onchange="onChangeTotalFlatRate()" nbFormat="#,0.000000" /></td>
					<td class="fldLabelView"><ps:label
							key="Profit_Calc_Method_key"
							id="lbl_Profit_Calc_Method_${_pageRef}"
							for="profitCalcMethod_${_pageRef}" /></td>
					<td colspan="2"><ps:select id="profitCalcMethod_${_pageRef}"
							list="profitCalculationMethod" listKey="code"
							listValue="descValue"
							name="islamicCalculatorEventMgmtCO.profitCalcMethod"
							onchange="onChangeprofitCalcMethod()">
						</ps:select></td>
					<td colspan="2"></td>
					<td class="fldLabelView"><ps:label
							key="Profit_Recognition_Method_key"
							id="lbl_Profit_Recognition_Method_${_pageRef}"
							for="profitRecognitionMethod_${_pageRef}" /></td>
					<td colspan="3"><ps:select
							id="profitRecognitionMethod_${_pageRef}" list="profitDistMethod"
							listKey="code" listValue="descValue"
							name="islamicCalculatorEventMgmtCO.profitRecognitionMethod"
							onchange="onChangeProfitRecognitionMethod()" disabled="false">
						</ps:select></td>
					<%-- </ps:if> --%>
				</tr>
				<tr>
					<td class="fldLabelView"><ps:label key="Accrual_Basis_key"
							id="lbl_Accrual_Basis_${_pageRef}" for="accrualBasis_${_pageRef}" />
					</td>
					<td colspan="2"><ps:select id="accrualBasis_${_pageRef}"
							list="acccrualBasis" listKey="code" listValue="descValue"
							name="islamicCalculatorEventMgmtCO.accrualBasis"
							onchange="onChangeAccrualBasis()">
						</ps:select></td>
					<td></td>
					<td class="fldLabelView"><ps:label key="Facility_Type_key"
							id="lbl_Facility_Type_${_pageRef}"
							for="lookuptxt_facilityTypeCode_${_pageRef}" /></td>
					<td colspan="2"><psj:livesearch
							actionName="${pageContext.request.contextPath}/pathdesktop/FacilityTypeLookup_constructLookup"
							paramList="CODE:lookuptxt_facilityTypeCode_${_pageRef}"
							id="facilityTypeCode_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.facilityTypeCode"
							mode="number" maxlength="12" searchElement="CODE"
							autoSearch="false"
							parameter="CODE:lookuptxt_facilityTypeCode_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/pathdesktop/FacilityTypeDependencyAction_dependencyByFacilityTypeCode"
							dependency="lookuptxt_facilityTypeCode_${_pageRef}:facilityTypeVO.CODE,facilityTypeCodeDesc_${_pageRef}:facilityTypeVO.BRIEF_NAME_ENG">
						</psj:livesearch></td>
					<td colspan="3"><ps:textfield
							id="facilityTypeCodeDesc_${_pageRef}" readonly="true"
							name="islamicCalculatorEventMgmtCO.facilityTypeDesc">
						</ps:textfield></td>
				</tr>
				<tr>
					<td class="fldLabelView" valign="top" colspan="3"><ps:checkbox
							name="islamicCalculatorEventMgmtCO.dealPeriodCompounding"
							id="compoundingDuringTheEntireDealPeriod_${_pageRef}"
							key="Compounding_during_the_Entire_Deal_period_key"
							fieldValue="true" onchange="onChangeDealPeriodCompounding()"
							cssClass="ui-widget-content checkboxheight" /></td>
				</tr>
				<%--									</ps:if>								--%>
			</table>
		</div>
		<!-- 	Profit Calculation Section 	End -->

		<div id="repaymentdetailsdiv_${_pageRef}"
			class="collapsibleContainer collapsed"
			title="<ps:text name='REPAYMENT_DETAILS_key'/>">
			<%-- Repayment Details Section Starts--%>
			<table style="width: 100%"
				class="headerPortionContent ui-widget-content">
				<tr>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="15%"></td>
					<td width="10%"></td>
					<td width="15%"></td>
				</tr>
				<tr>
					<td class="fldLabelView"><ps:label key="Temp.Code_key"
							id="lbl_Temp_Code_${_pageRef}"
							for="lookuptxt_tempCode_${_pageRef}" /></td>
					<td><psj:livesearch
							actionName="${pageContext.request.contextPath}/pathdesktop/TempCodeLookup_constructLookup"
							id="tempCode_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.tempCode"
							searchElement="TEMPLATE_CODE" autoSearch="false" mode="number"
							maxlength="8"
							resultList="TEMPLATE_CODE:lookuptxt_tempCode_${_pageRef},BRIEF_NAME_ENG:templateDesc_${_pageRef}"
							parameter="TEMPLATE_CODE:lookuptxt_tempCode_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/pathdesktop/TemplateCodeDependencyAction_dependancyByTemplateCode"
							dependency="templateDesc_${_pageRef}:tempCodeVO.BRIEF_NAME_ENG,lookuptxt_tempCode_${_pageRef}:tempCodeVO.TEMPLATE_CODE"
							afterDepEvent="onChangeTemplateCode()">
						</psj:livesearch></td>
					<td><ps:textfield
							name="islamicCalculatorEventMgmtCO.tempCodeDesc" readonly="true"
							id="templateDesc_${_pageRef}" /></td>
					<td class="fldLabelView"><ps:label
							key="First_Payment_After_key"
							id="lbl_First_Payment_After_${_pageRef}"
							for="gracePeriod_${_pageRef}" /></td>

					<td><ps:textfield
							name="islamicCalculatorEventMgmtCO.gracePeriod"
							id="gracePeriod_${_pageRef}" 
							onchange="onChangeFirstPaymentAfter()" mode="number" /></td>
					<td><ps:select 
							id="gracePeriodicity_${_pageRef}" list="gracePeriodicity"
							listKey="code" listValue="descValue" 
							name="islamicCalculatorEventMgmtCO.gracePeriodicity"
							onchange="onChangeFirstPaymentAfterPeriodicity()">
						</ps:select>
						
						<ps:textfield id="gracePeriodicityForPrint_${_pageRef}" cssStyle="display:none"></ps:textfield>
						</td>

					<td class="fldLabelView"><ps:label
							key="First_Payment_Date_key"
							id="lbl_First_Payment_Date_${_pageRef}"
							for="firstPaymentDate_${_pageRef}" /></td>
					<td><psj:datepicker id="firstPaymentDate_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.firstPaymentDate"
							buttonImageOnly="true" onchange="validateOnChangeFirstPayDate()" />
					</td>
				</tr>


				<tr>
					<td class="fldLabelView"><ps:label key="No_Of_Payments_key"
							id="lbl_No_Of_Payments_${_pageRef}"
							for="noOfPayments_${_pageRef}" /></td>
					<td><ps:textfield id="noOfPayments_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.noOfPayments" mode="number"
							maxlength="6" onchange="validateOnChangeNoOfPayments()" /></td>
					<td></td>
					<td class="fldLabelView"><ps:label key="No_of_Months_key"
							id="lbl_No_of_Months_${_pageRef}" for="noOfMonths_${_pageRef}" />
					</td>
					<td><ps:textfield id="noOfMonths_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.noOfMonths" readonly="true"
							mode="number" maxlength="6" /></td>
					<td></td>
					<td class="fldLabelView"><ps:label
							key="Amount_Per_Payment_key"
							id="lbl_Amount_Per_Payment_${_pageRef}"
							for="amountPerPayment_${_pageRef}" /></td>
					<td><ps:textfield id="amountPerPayment_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.amountPerPayment"
							mode="number" nbFormat="#,###.##" maxlength="20"
							onchange="onChangeAmountPerPayment()" /></td>
				</tr>
				<tr>
					<td class="fldLabelView"><ps:label key="Pay_Every_key"
							id="lbl_Pay_Every_${_pageRef}" for="paymPeriodNbr_${_pageRef}" />
					</td>
					<td><ps:textfield
							name="islamicCalculatorEventMgmtCO.paymPeriodNbr"
							id="paymPeriodNbr_${_pageRef}"
							onchange="validateOnChangePayEvery()" mode="number" /></td>
					<td><ps:select 
							id="paymPeriodicity_${_pageRef}" list="paymPeriodicity"
							listKey="code" listValue="descValue"
							name="islamicCalculatorEventMgmtCO.paymPeriodicity"
							onchange="validateOnChangePayEveryPeriodicity()">
							</ps:select>
							<ps:textfield id="paymPeriodicityForPrint_${_pageRef}" cssStyle="display:none"></ps:textfield>
							
							</td>
					<td class="fldLabelView"><ps:label key="At_key"
							id="lbl_At_${_pageRef}" for="paymPeriodPos_${_pageRef}" /></td>
					<td><ps:select 
							id="paymPeriodPos_${_pageRef}" list="paymPeriodPos"
							listKey="code" listValue="descValue"
							name="islamicCalculatorEventMgmtCO.paymPeriodPos"
							onchange="validateOnChangePayEveryPeriodicity()">
						</ps:select>
						<ps:textfield id="paymPeriodPosForPrint_${_pageRef}" cssStyle="display:none"></ps:textfield>
						</td>
					<td class="fldLabelView"><ps:label
							key="Pay_Residual_Amount_key"
							id="lbl_Pay_Residual_Amount_${_pageRef}" /></td>
					<td colspan="2"><ps:radio
							id="radPayResidualAmount_${_pageRef}" list="payResidualAmount"
							cssClass="radioDown_%{_pageRef}"
							name="islamicCalculatorEventMgmtCO.payResAmt"
							value="defaultPayResidualAmount" /></td>
					
				</tr>

				<tr>
					<td class="fldLabelView"><ps:label key="Rounding_Factor_key"
							id="lbl_Rounding_Factor_${_pageRef}"
							for="roundingFactor_${_pageRef}" /></td>
					<td colspan="2"><ps:select value="roundingf"
							id="roundingFactor_${_pageRef}" list="roundingFactor"
							listKey="code" listValue="descValue" 
							name="islamicCalculatorEventMgmtCO.roundingFactor">
						</ps:select>
						
						<ps:textfield id="roundingFactorForPrint_${_pageRef}" cssStyle="display:none"></ps:textfield>
						</td>


					<td class="fldLabelView"><ps:label key="Insurance_Charges_key"
							id="lbl_Insurance_Charges_${_pageRef}"
							for="insuranceChargesAmount_${_pageRef}" /></td>
					<td><ps:textfield id="insuranceChargesAmount_${_pageRef}"
							mode="number" readonly="true" nbFormat="#,###.##" /></td>
					<td><ps:textfield id="chargeAmount_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.chargeAmount" mode="number"
							readonly="true" nbFormat="#,###.##" /></td>
					<td><ps:textfield id="totalInsuranceAmount_${_pageRef}"
							mode="number" readonly="true" nbFormat="#,###.##" /></td>
				</tr>
				<tr>
					<td><ps:checkbox
							name="islamicCalculatorEventMgmtCO.flexiPaymentYn"
							id="flexiPaymentYN_CheckBox_${_pageRef}" key="flexi_payments_key"
							valOpt="Y:N"
							onchange="islamicCalc_onChangeFlexiPaymentCheckBox()"
							cssClass="ui-widget-content checkboxheight" /></td>
					<td class="fldLabelView"><ps:label key="flexi_month_key"
							id="lbl_flexi_month_${_pageRef}" for="flexi_month_${_pageRef}" />
					</td>
					<td><ps:select id="flexi_month_${_pageRef}"
							list="flexiMonthList" listKey="code" listValue="descValue" emptyOption="true" 
							name="islamicCalculatorEventMgmtCO.flexiPaymentsMonth">
						</ps:select>
						
						<ps:textfield id="flexi_monthForPrint_${_pageRef}" cssStyle="display:none"></ps:textfield>
						</td>
				</tr>
			</table>

			<div id="repaymentgridDiv_Id_${_pageRef}" class="collapsibleContainer"
			title="<ps:text name='Repayment_Criteria_key'/>">	
					<ps:url id="payplanCriteriaCalcUrl_${_pageRef}"
								namespace="/path/iis/createdealbutton"
								action="CreateDealButtonList_loadpayPlanCriteriaCalcGridData?_pageRef=${_pageRef}&refNo=${islamicCalculatorEventMgmtCO.trsPayPlanCalculatorVO.REF_NBR}&currencyCode=${islamicCalculatorEventMgmtCO.currencyCode}" />

							<psjg:grid id="repaymentgridTbl_Id_${_pageRef}"
								 dataType="json"
								pager="true" filter="false" editurl="#" gridModel="gridModel"
								rowNum="5" viewrecords="true" navigator="true" height="110"
								navigatorRefresh="false" navigatorSearch="false"
								hiddengrid="false" addfunc="addRepaymentCriteria"
								delfunc="deleteRepaymentCriteria"
								href="%{payplanCriteriaCalcUrl_${_pageRef}}"
								pagerButtons="false" editinline="true" altRows="true"
								shrinkToFit="false" navigatorEdit="false"
								onEditInlineBeforeTopics="editRepaymentCriteria"
								navigatorAdd="true" navigatorDelete="true" autowidth="true">

								<psjg:gridColumn name="FROM_DATE"
									title="%{getText('From_Date_key')}" index="FROM_DATE"
									colType="date" editable="true" sortable="false"
									id="FROM_DATE_${_pageRef}"
									editoptions="{dataEvents: [{ type: 'change', fn: function(e) { populateOnChangeRepaymentCriteriaFromDate(e); } }]}" />

								<psjg:gridColumn name="TO_DATE"
									title="%{getText('To_Date_key')}" index="TO_DATE"
									colType="date" editable="true" sortable="false"
									id="TO_DATE_${_pageRef}"
									editoptions="{dataEvents: [{ type: 'change', fn: function(e) { populateOnChangeRepaymentCriteriaToDate(); } }]}" />

								<psjg:gridColumn name="PAYM_PERIOD_NBR"
									title="%{getText('Periodicity_Number_key')}"
									index="PAYM_PERIOD_NBR" colType="number" editable="true"
									sortable="false" id="PAYM_PERIOD_NBR_${_pageRef}"
									dependency="islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR:PAYM_PERIOD_NBR,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT:CAPITAL_AMT,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS:NO_OF_PAYMENTS"
									dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeRepaymentCriteriaPeriodicityNumber"
									params="islamicCalculatorEventMgmtCO.startDate:startDate_${_pageRef},islamicCalculatorEventMgmtCO.financingAmount:financingAmount_${_pageRef},islamicCalculatorEventMgmtCO.gracePeriod:gracePeriod_${_pageRef},islamicCalculatorEventMgmtCO.gracePeriodicity:gracePeriodicity_${_pageRef},islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYMENT_TYPE:PAYMENT_TYPE,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_POS:PAYM_PERIOD_POS,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIODICITY:PAYM_PERIODICITY,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE:FROM_DATE,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE:TO_DATE,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT:CAPITAL_AMT,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR:PAYM_PERIOD_NBR,islamicCalculatorEventMgmtCO.sumOfCapitalAmtRepayment:repaymentAmountSum_${_pageRef},islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS:NO_OF_PAYMENTS"
									afterDepEvent="resetRepaymentSum()" />

								<psjg:gridColumn name="PAYM_PERIODICITY"
									title="%{getText('Periodicity_key')}" index="PAYM_PERIODICITY"
									formatter="select" id="PAYM_PERIODICITY_${_pageRef}"
									colType="select" editable="true" sortable="false"
									edittype="select"
									editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculator_loadPaymPeriodicity','paymPeriodicity', 'code', 'descValue');}
												,dataEvents: [{ type: 'change', fn: function(e) { onChangePeriodicity(e) } }]}" />


								<psjg:gridColumn name="PAYM_PERIOD_POS"
									title="%{getText('At_key')}" index="PAYM_PERIOD_POS"
									colType="select" formatter="select" editable="true"
									sortable="false" id="PAYM_PERIOD_POS_${_pageRef}"
									edittype="select"
									editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculator_loadPaymPeriodPosition','paymPeriodPos', 'code', 'descValue');}
												,dataEvents: [{ type: 'change', fn: function(e) { onChangePeriodicityPosition(e) } }]}" />

								<psjg:gridColumn name="PAYM_DAY" title="%{getText('on_key')}"
									index="PAYM_DAY" colType="number" editable="true"
									sortable="false" id="PAYM_DAY"
									editoptions="{dataEvents: [{ type: 'change', fn: function(e) { onChangeOnPayDay(); } }]}" />

								<psjg:gridColumn name="NO_OF_PAYMENTS"
									title="%{getText('No_Of_Payments_key')}" index="NO_OF_PAYMENTS"
									colType="number" editable="true" sortable="false"
									id="NO_OF_PAYMENTS_${_pageRef}"
									editoptions="{dataEvents: [{ type: 'change', fn: function(e) { populateOnChangeRepaymentCriteriaNoOfPayments(e); } }]}" />

								<psjg:gridColumn name="PAYMENT_TYPE"
									title="%{getText('Payment_Type_key')}" index="PAYMENT_TYPE"
									id="PAYMENT_TYPE_${_pageRef}" colType="select"
									formatter="select" editable="true" sortable="false"
									edittype="select"
									editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculator_loadPaymentType','paymentType', 'code', 'descValue');}
												,dataEvents: [{ type: 'change', fn: function(e) { onChangePeriodicityPaymentType(e) } }]}" />

								<psjg:gridColumn name="CAPITAL_AMT"
									title="%{getText('Amount_key')}" index="CAPITAL_AMT"
									colType="number"
									nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}"
									editable="true" sortable="false" id="CAPITAL_AMT_${_pageRef}"
									editoptions="{dataEvents: [{ type: 'change', fn: function(e) { onChangeCapitalAmount(); } }]}" />

								<psjg:gridColumn name="ACC_BR" title="%{getText('branchKey')}"
									index="ACC_BR" colType="number" editable="true" sortable="false"
									id="ACC_BR"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/BranchesDependencyAction_dependencyByBrId"
									params="account.BRANCH_CODE:ACC_BR"
									dependency="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:ACC_CY,account.GL_CODE:ACC_GL,account.CIF_SUB_NO:ACC_CIF,account.SL_NO:ACC_SL_lookuptxt" />

								<psjg:gridColumn name="ACC_CY"
									title="%{getText('Currency_key')}" index="ACC_CY"
									colType="number" editable="true" sortable="false" id="ACC_CY"
									params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:ACC_CY"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/CurrencyDependencyAction_dependencyByCYId"
									dependency="account.CURRENCY_CODE:ACC_CY,account.GL_CODE:ACC_GL,account.CIF_SUB_NO:ACC_CIF,account.SL_NO:ACC_SL_lookuptxt" />

								<psjg:gridColumn name="ACC_GL" title="%{getText('G/L_key')}"
									index="ACC_GL" colType="number" editable="true" sortable="false"
									id="ACC_GL"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/GLDependencyAction_dependencyByGLId"
									params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:ACC_CY,account.GL_CODE:ACC_GL"
									dependency="account.GL_CODE:ACC_GL,account.CIF_SUB_NO:ACC_CIF,account.SL_NO:ACC_SL_lookuptxt" />
								<psjg:gridColumn name="ACC_CIF" title="%{getText('CIF_key')}"
									index="ACC_CIF" colType="number" editable="true"
									sortable="false" id="ACC_CIF"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByCifId"
									params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:ACC_CY,account.GL_CODE:ACC_GL,account.CIF_SUB_NO:ACC_CIF"
									dependency="account.CIF_SUB_NO:ACC_CIF,account.SL_NO:ACC_SL_lookuptxt" />
								<psjg:gridColumn name="ACC_SL" title="%{getText('S/L_key')}"
									index="ACC_SL" colType="liveSearch" editable="true"
									sortable="false" id="ACC_SL"
									dataAction="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup"
									searchElement="amfVO.SL_NO" paramList="" autoSearch="true"
									editoptions="{dataEvents: [{ type: 'change', fn: function(e) { callSlCodeDependency('repayment'); } }],maxlength: '3'}" />
								<psjg:gridColumn name="ACC_NAME"
									title="%{getText('Account_Name_key')}" index="ACC_NAME"
									colType="text" editable="false" sortable="false" id="ACC_NAME" />
								<psjg:gridColumn name="AUTO_CREATE_SETTLEMENT_YN"
									title="%{getText('Automatic_Settlement_key')}"
									index="AUTO_CREATE_SETTLEMENT_YN" formatter="select"
									id="AUTO_CREATE_SETTLEMENT_YN_${_pageRef}" colType="select"
									editable="true" sortable="false" edittype="select"
									editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculator_loadAutoCreateSettlement','autoCreateSettlement', 'code', 'descValue');}
										,dataEvents: [{ type: 'change', fn: function(e) { onChangeAutoCreateSettlementYN(e) } }]}" />

								<psjg:gridColumn name="COVERING_ACC_BR"
									title="%{getText('branchKey')}" index="COVERING_ACC_BR"
									colType="number" editable="true" sortable="false"
									id="COVERING_ACC_BR"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/BranchesDependencyAction_dependencyByBrIdWithExceptionMessage"
									params="account.BRANCH_CODE:COVERING_ACC_BR"
									dependency="account.BRANCH_CODE:COVERING_ACC_BR,account.CURRENCY_CODE:COVERING_ACC_CY,account.GL_CODE:COVERING_ACC_GL,account.CIF_SUB_NO:COVERING_ACC_CIF,account.SL_NO:COVERING_ACC_SL_lookuptxt" />

								<psjg:gridColumn name="COVERING_ACC_CY"
									title="%{getText('Currency_key')}" index="COVERING_ACC_CY"
									colType="number" editable="true" sortable="false"
									id="COVERING_ACC_CY"
									params="account.BRANCH_CODE:ACC_BR,CURRENCY_CODE:COVERING_ACC_CY"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/CurrencyDependencyAction_dependencyByCurrencyCode"
									dependency="currency.CURRENCY_CODE:COVERING_ACC_CY,account.GL_CODE:COVERING_ACC_GL,account.CIF_SUB_NO:COVERING_ACC_CIF,account.SL_NO:COVERING_ACC_SL_lookuptxt" />

								<psjg:gridColumn name="COVERING_ACC_GL"
									title="%{getText('G/L_key')}" index="COVERING_ACC_GL"
									colType="number" editable="true" sortable="false"
									id="COVERING_ACC_GL"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/GLDependencyAction_returnGlByCode"
									params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:COVERING_ACC_CY,account.GL_CODE:COVERING_ACC_GL"
									dependency="account.GL_CODE:COVERING_ACC_GL,account.CIF_SUB_NO:COVERING_ACC_CIF,account.SL_NO:COVERING_ACC_SL_lookuptxt" />
								<psjg:gridColumn name="COVERING_ACC_CIF"
									title="%{getText('CIF_key')}" index="COVERING_ACC_CIF"
									colType="number" editable="true" sortable="false"
									id="COVERING_ACC_CIF"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByCifIdWithExceptionMessage"
									params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:COVERING_ACC_CY,account.GL_CODE:COVERING_ACC_GL,account.CIF_SUB_NO:COVERING_ACC_CIF"
									dependency="account.SL_NO:COVERING_ACC_SL_lookuptxt" />
								<psjg:gridColumn name="COVERING_ACC_SL"
									title="%{getText('S/L_key')}" index="COVERING_ACC_SL"
									colType="liveSearch" editable="true" sortable="false"
									id="COVERING_ACC_SL"
									dataAction="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup"
									searchElement="amfVO.SL_NO" paramList="" autoSearch="true"
									editoptions="{dataEvents: [{ type: 'change', fn: function(e) { callSlCodeDependency('repaymentCoveringSl'); } }],maxlength: '3'}" />
								<psjg:gridColumn name="COVERING_ACC_NAME"
									title="%{getText('Account_Name_key')}"
									index="COVERING_ACC_NAME" colType="text" editable="true"
									sortable="false" id="COVERING_ACC_NAME" />
							</psjg:grid>
			</div>
		</div>
		<%-- Repayment Details Section End--%>
		<div id="dealChargesGridDiv_Id_${_pageRef}"
			class="collapsibleContainer collapsed"
			title="<ps:text name='Deal_Charges_key'/>">

			<ps:url id="dealChargesCalcUrl_${_pageRef}"
				action="dealChargesList_loadDealChargesDet?dealNo=${islamicCalculatorEventMgmtCO.trsPayPlanCalculatorVO.REF_NBR}&trsDealChargesSC.calculatorYN=Y"
				namespace="/path/iis/dealcharges" />
			<psjg:grid id="dealChargesGridTbl_Id_${_pageRef}"
				caption="%{getText('Deal_Charges_key')}" dataType="json"
				href="%{dealChargesCalcUrl_${_pageRef}}" pager="true" filter="false"
				editurl="#" gridModel="gridModel" rowNum="5" rowList="5,10,15,20"
				viewrecords="true" navigator="true" height="110"
				navigatorRefresh="false" navigatorSearch="false" hiddengrid="false"
				addfunc="addDealCharges" delfunc="deleteDealCharges"
				autowidth="true" multiselect="false" multiboxonly="false"
				pagerButtons="false" editinline="true" altRows="true"
				shrinkToFit="false" navigatorEdit="false"
				onCompleteTopics="dealChargesAmountHeader" navigatorAdd="true"
				navigatorDelete="true" rownumbers="true"
				onEditInlineBeforeTopics="editDealCharges">

				<psjg:gridColumn name="CHARGES_CODE" title="%{getText('Code_key')}"
					index="CHARGES_CODE" colType="liveSearch" editable="true"
					sortable="false" id="CHARGES_CODE" mode="number"
					dataAction="${pageContext.request.contextPath}/pathdesktop/Charges_constructLookup"
					resultList="" searchElement="CODE" paramList="" autoSearch="true"
					params="iisDealChargesParamCO.chargeCode:CHARGES_CODE_lookuptxt 
											, iisDealChargesParamCO.classCode:lookuptxt_productClass_${_pageRef}
											, iisDealChargesParamCO.cifNo:lookuptxt_cifNo_${_pageRef}
											, iisDealChargesParamCO.dealCurrecny:lookuptxt_currencyCode_${_pageRef}
											, iisDealChargesParamCO.valueDate:startDate_${_pageRef}
											, iisDealChargesParamCO.maturityDate:maturityDate_${_pageRef}
											, iisDealChargesParamCO.dealAmount:financingAmount_${_pageRef}
											, iisDealChargesParamCO.companyContributorAmount:financingAmount_${_pageRef}"
					dependencySrc="${pageContext.request.contextPath}/path/iis/dealcharges/dealChargesMaint_dependancyByCharges"
					dependency="iisDealChargesParamCO.chargeName:lsBriefNameeng
							 				,iisDealChargesParamCO.chargeCode:CHARGES_CODE_lookuptxt
							 				,iisDealChargesParamCO.accountCurrency:CR_ACC_CURRENCY
							 				,iisDealChargesParamCO.chargeType:CHARGE_TYPE
							 				,iisDealChargesParamCO.profitOnCharge:PROFIT_ON_CHARGES
							 				,iisDealChargesParamCO.collectChargesAccountType:COLLECT_CHARGES_ACCOUNT_TYPE
							 				,iisDealChargesParamCO.collectChargeAtDealLevelYN:COLLECT_CHARGE_AT_DEAL_YN
							 				,iisDealChargesParamCO.creditSDToAccount:CREDIT_TO_SD_ACCOUNT_YN
							 				,iisDealChargesParamCO.amountPerInstallamnet:CHARGE_AMT_PER_INST_YN
							 				,iisDealChargesParamCO.chargePercentage:CHARGES_PERCENTAGE"
					afterDepEvent="populateOnChangeDealChargesGridAmounts('CC')" />

				<psjg:gridColumn name="lsBriefNameeng"
					title="%{getText('Name_key')}" index="lsBriefNameeng"
					colType="text" editable="false" sortable="false" id="lsBriefNameeng" />

				<psjg:gridColumn name="CR_ACC_BRANCH"
					title="%{getText('branchKey')}" index="CR_ACC_BRANCH"
					colType="number" editable="true" sortable="false" id="CR_ACC_BRANCH"
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/BranchesDependencyAction_dependencyByBrIdWithExceptionMessage"
					params="account.BRANCH_CODE:CR_ACC_BRANCH"
					dependency="account.BRANCH_CODE:CR_ACC_BRANCH,account.CURRENCY_CODE:CR_ACC_CURRENCY,account.GL_CODE:CR_ACC_GL,account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO,account.SL_NO:CR_ACC_SL_NO_lookuptxt"
					afterDepEvent="setSumofInsuranceCharges()" />

				<psjg:gridColumn name="CR_ACC_CURRENCY"
					title="%{getText('Currency_key')}" index="CR_ACC_CURRENCY"
					colType="number" editable="true" sortable="false"
					id="CR_ACC_CURRENCY"
					params="account.BRANCH_CODE:CR_ACC_BRANCH,CURRENCY_CODE:CR_ACC_CURRENCY"
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/CurrencyDependencyAction_dependencyByCurrencyCode"
					dependency="currency.CURRENCY_CODE:CR_ACC_CURRENCY,account.GL_CODE:CR_ACC_GL,account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO,account.SL_NO:CR_ACC_SL_NO_lookuptxt"
					afterDepEvent="populateOnChangeDealChargesGridAmounts('CR')" />

				<psjg:gridColumn name="CR_ACC_GL" title="%{getText('G/L_key')}"
					index="CR_ACC_GL" colType="number" editable="true" sortable="false"
					id="CR_ACC_GL"
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/GLDependencyAction_returnGlByCode"
					params="account.BRANCH_CODE:CR_ACC_BRANCH,account.CURRENCY_CODE:CR_ACC_CURRENCY,account.GL_CODE:CR_ACC_GL"
					dependency="account.GL_CODE:CR_ACC_GL,account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO,account.SL_NO:CR_ACC_SL_NO_lookuptxt"
					afterDepEvent="setSumofInsuranceCharges()" />


				<psjg:gridColumn name="CR_ACC_CIF_SUB_NO"
					title="%{getText('CIF_key')}" index="CR_ACC_CIF_SUB_NO"
					colType="number" editable="true" sortable="false"
					id="CR_ACC_CIF_SUB_NO"
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByCifIdWithExceptionMessage"
					params="account.BRANCH_CODE:CR_ACC_BRANCH,account.CURRENCY_CODE:CR_ACC_CURRENCY,account.GL_CODE:CR_ACC_GL,account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO"
					dependency="account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO,account.SL_NO:CR_ACC_SL_NO_lookuptxt"
					afterDepEvent="setSumofInsuranceCharges()" />


				<psjg:gridColumn name="CR_ACC_SL_NO" title="%{getText('S/L_key')}"
					index="CR_ACC_SL_NO" colType="liveSearch" editable="true"
					sortable="false" id="CR_ACC_SL_NO"
					dataAction="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup"
					searchElement="amfVO.SL_NO" paramList="" autoSearch="true"
					editoptions="{dataEvents: [{ type: 'change', fn: function(e) { callSlCodeDependency('dealCharges'); } }],maxlength: '3'}" />
				<%--TP#231436; Saheer.Naduthodi; 19/10/2014 --%>
				<psjg:gridColumn name="CHARGES_AMOUNT"
					title="%{getText('Deal_CY_key')}" index="CHARGES_AMOUNT"
					colType="number" editable="true" sortable="false"
					id="CHARGES_AMOUNT"
					params="iisDealChargesCO.productClass:lookuptxt_productClass_${_pageRef},iisDealChargesCO.cifNo:lookuptxt_cifNo_${_pageRef},iisDealChargesCO.maturityDate:maturityDate_${_pageRef},iisDealChargesCO.valueDate:startDate_${_pageRef},iisDealChargesCO.currency:lookuptxt_currencyCode_${_pageRef},iisDealChargesCO.DownPaymentAmount:downPaymentAmount_${_pageRef},iisDealChargesCO.dealAmount:financingAmount_${_pageRef},iisDealChargesCO.trsDealChargesCO.CHARGES_CODE:CHARGES_CODE_lookuptxt,iisDealChargesCO.trsDealChargesCO.CR_ACC_CURRENCY:CR_ACC_CURRENCY,iisDealChargesCO.trsDealChargesCO.CHARGES_AMOUNT:CHARGES_AMOUNT,iisDealChargesCO.allowEdit:ALLOW_EDIT"
					dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeDealChargesGridAmounts?iisDealChargesCO.callType=CA"
					dependency="trsDealChargesCO.CHARGES_AMOUNT:CHARGES_AMOUNT,trsDealChargesCO.CHARGES_AMT_FC:CHARGES_AMT_FC,trsDealChargesCO.CHARGES_AMT_CV:CHARGES_AMT_CV,trsDealChargesCO.insuranceAmount:insuranceAmount,trsDealChargesCO.chargeAmtToInclInPrinciple:chargeAmtToInclInPrinciple"
					afterDepEvent="setSumofInsuranceCharges()"
					formatter="currencyFmatter" formatCol="dealChargesFormat"
					nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}" />

				<psjg:gridColumn name="CHARGES_AMT_FC"
					title="%{getText('Charge_CY_key')}" index="CHARGES_AMT_FC"
					colType="number" editable="true" sortable="false"
					id="CHARGES_AMT_FC"
					params="iisDealChargesCO.productClass:lookuptxt_productClass_${_pageRef},iisDealChargesCO.cifNo:lookuptxt_cifNo_${_pageRef},iisDealChargesCO.maturityDate:maturityDate_${_pageRef},iisDealChargesCO.valueDate:startDate_${_pageRef},iisDealChargesCO.currency:lookuptxt_currencyCode_${_pageRef},iisDealChargesCO.DownPaymentAmount:downPaymentAmount_${_pageRef},iisDealChargesCO.dealAmount:financingAmount_${_pageRef},iisDealChargesCO.trsDealChargesCO.CHARGES_CODE:CHARGES_CODE_lookuptxt,iisDealChargesCO.trsDealChargesCO.CR_ACC_CURRENCY:CR_ACC_CURRENCY,iisDealChargesCO.trsDealChargesCO.CHARGES_AMT_FC:CHARGES_AMT_FC,iisDealChargesCO.trsDealChargesCO.CHARGES_AMOUNT:CHARGES_AMOUNT"
					dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeDealChargesGridAmounts?iisDealChargesCO.callType=CS"
					dependency="trsDealChargesCO.CHARGES_AMOUNT:CHARGES_AMOUNT,trsDealChargesCO.CHARGES_AMT_FC:CHARGES_AMT_FC,trsDealChargesCO.CHARGES_AMT_CV:CHARGES_AMT_CV,trsDealChargesCO.insuranceAmount:insuranceAmount,trsDealChargesCO.chargeAmtToInclInPrinciple:chargeAmtToInclInPrinciple"
					afterDepEvent="setSumofInsuranceCharges()"
					formatter="currencyFmatter" formatCol="dealChargesFormat"
					nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}" />

				<psjg:gridColumn name="CHARGES_AMT_CV"
					title="%{getText('Base_CY_key')}" index="baseCy" colType="number"
					editable="true" sortable="false" id="CHARGES_AMOUNT"
					formatter="currencyFmatter" formatCol="dealChargesFormat"
					nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}" />

				<psjg:gridColumn name="PROFIT_ON_CHARGES"
					title="%{getText('Profit_On_Charges_key')}"
					index="PROFIT_ON_CHARGES" colType="checkbox"
					editoptions="{value:'1:0'}" editable="true" sortable="false"
					edittype="checkbox" formatter="checkbox"
					formatoptions="{disabled : true}" id="profitOnCharge" />

				<psjg:gridColumn name="CHARGE_TYPE"
					title="%{getText('Include_In_Principal_key')}"
					index="includeInPrincipal" colType="checkbox"
					editoptions="{value:'Y:N',dataEvents: [{ type: 'click', fn: function(e) { onChangeIncludeInPrinciple(e) } }]}"
					editable="true" sortable="false" edittype="checkbox"
					formatter="checkbox" formatoptions="{disabled : true}"
					id="includeInPrincipal" />

				<psjg:gridColumn name="CREDIT_TO_SD_ACCOUNT_YN"
					title="%{getText('credit_to_sd_account_yn_key')}"
					index="CREDIT_TO_SD_ACCOUNT_YN" colType="checkbox"
					editoptions="{value:'Y:N'}" editable="false" sortable="false"
					edittype="checkbox" formatter="checkbox"
					formatoptions="{disabled : true}" id="CREDIT_TO_SD_ACCOUNT_YN" />

				<psjg:gridColumn name="COLLECT_CHARGE_AT_DEAL_YN"
					title="%{getText('Collect_Chgs_On_Deal_Approve_key')}"
					index="COLLECT_CHARGE_AT_DEAL_YN" colType="checkbox"
					editoptions="{value:'Y:N',dataEvents: [{ type: 'click', fn: function(e) {onChangeCollectChgsOnDealApprove(e) } }]}"
					editable="true" sortable="false" edittype="checkbox"
					formatter="checkbox" formatoptions="{disabled : true}"
					id="COLLECT_CHARGE_AT_DEAL_YN" />

				<psjg:gridColumn name="COLLECT_CHARGES_ACCOUNT_TYPE"
					title="%{getText('collect_charges_account_type_key')}"
					index="COLLECT_CHARGES_ACCOUNT_TYPE" colType="select"
					editable="true" sortable="false"
					id="collect_charges_account_type_${_pageRef}" edittype="select"
					formatter="select"
					editoptions="{value:function()
									    {
									     return loadCombo('${pageContext.request.contextPath}/path/iis/dealcharges/dealChargesList_loadAllDropdowns',
									          'debitAccTypeDropDown', 
									          'code', 
									          'descValue'
									         );
									    },dataEvents: [{ type: 'change', fn: function(e) {} }]
									   }" />

				<psjg:gridColumn name="VAT_CODE" title="%{getText('Vat_code_key')}"
					index="VAT_CODE" colType="liveSearch" editable="true"
					sortable="false" id="VAT_CODE" mode="number"
					dataAction="${pageContext.request.contextPath}/pathdesktop/VatCodeLookup_constructLookup"
					paramList="vatCodeSC.PERCENTAGE_IND:DEALCHARGE_VAT_PERCENTAGE_IND_${_pageRef}"
					resultList="" searchElement="VAT_CODE"
					params="vatCodeSC.vatCode:VAT_CODE_lookuptxt,vatCodeSC.PERCENTAGE_IND:DEALCHARGE_VAT_PERCENTAGE_IND_${_pageRef}"
					autoSearch="true"
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/VatCodeDependencyAction_dependancyByVatCode"
					dependency="vatCodeVO.VAT_CODE:VAT_CODE_lookuptxt,vatCodeVO.BRIEF_NAME_ENG:VAT_BRIEF_NAME_ENG"
					afterDepEvent="" />

				<psjg:gridColumn name="VAT_BRIEF_NAME_ENG"
					title="%{getText('vat_desc_key')}" index="VAT_BRIEF_NAME_ENG"
					colType="text" editable="false" sortable="false"
					id="VAT_BRIEF_NAME_ENG" />

				<psjg:gridColumn name="CHARGE_AMT_PER_INST_YN"
					title="%{getText('Collect_Chgs_Per_Inst._OnP.I_Approve_key')}"
					index="CHARGE_AMT_PER_INST_YN" colType="checkbox"
					editoptions="{value:'Y:N',dataEvents: [{ type: 'click', fn: function(e) { onChangeCollectChgsperInstallmentOnPI(e) } }]}"
					editable="true" sortable="false" edittype="checkbox"
					formatter="checkbox" formatoptions="{disabled : true}"
					id="CHARGE_AMT_PER_INST_YN" />


				<psjg:gridColumn name="insuranceAmount"
					title="%{getText('Insurance_Amount_key')}" index="insuranceAmount"
					colType="number" editable="false" hidden="true"
					formatter="currencyFmatter" formatCol="dealChargesFormat"
					sortable="false" id="insuranceAmount"
					nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}" />

				<psjg:gridColumn name="chargeAmtToInclInPrinciple"
					title="%{getText('ChargeAmtToInclInPrinciple_key')}"
					index="chargeAmtToInclInPrinciple" colType="number"
					editable="false" hidden="true" formatter="currencyFmatter"
					formatCol="dealChargesFormat" sortable="false"
					id="chargeAmtToInclInPrinciple"
					nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}" />

				<psjg:gridColumn name="ALLOW_EDIT"
					title="%{getText('Allow_Edit_key')}" index="ALLOW_EDIT"
					colType="text" hidden="true" sortable="false" id="ALLOW_EDIT" />

				<psjg:gridColumn title="" name="allowToEditVatCode"
					index="allowToEditVatCode" id="allowToEditVatCode" colType="text"
					hidden="true" />

				<psjg:gridColumn title="" name="dealChargesFormat" colType="number"
					hidden="true" />
				
				<psjg:gridColumn title="" name="allowToEditChargeCracYN" colType="text" hidden="true" />	
										
				<psjg:gridColumn name="CHARGES_PERCENTAGE"
					title="%{getText('charge_percentage_key')}"
					index="CHARGES_PERCENTAGE" colType="number" editable="true"
					sortable="true" id="CHARGES_PERCENTAGE" nbFormat="###.00" editoptions="{maxlength: '5'}" minValue="0.00"
					hidden="true" 
					/>
				
				<psjg:gridColumn title="" name="calcOnYerlyOutstndPrincYN" colType="text" hidden="true" />	
										
				<psjg:gridColumn title=""
					name="TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN"
					index="TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN"
					id="TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN" colType="text"
					hidden="true" />
			</psjg:grid>
		</div>
		<%--TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule Charges START	--%>
		<div id="settlementChargesGridDiv_Id_${_pageRef}"
			class="collapsibleContainer collapsed"
			title="<ps:text name='settlement_charges_key'/>">
			<psjg:grid id="settlementChargesGridTbl_Id_${_pageRef}" href="#"
				dataType="json" pager="true" filter="false" gridModel="gridModel"
				viewrecords="true" navigator="true"
				height="150" navigatorRefresh="false" navigatorSearch="false"
				hiddengrid="true" editfunc="" rownumbers="true" multiselect="false"
				multiboxonly="false" editinline="true" altRows="true"
				navigatorAdd="false" navigatorEdit="false" shrinkToFit="false"
				pagerButtons="false" disableEditableFocus="true" onCompleteTopics=""
				onEditInlineBeforeTopics="settlementcharges_setReadonly"
				onGridCompleteTopics="onSettlementChargesGridLoadComplete"
				footerrow="true" navigatorDelete="false" editurl="#">

				<psjg:gridColumn name="CHARGE_CODE" title="%{getText('Code_key')}"
					index="CHARGE_CODE" colType="liveSearch" editable="true"
					sortable="false" id="CHARGE_CODE" mode="number"
					dataAction="${pageContext.request.contextPath}/pathdesktop/Charges_constructSettlementChargesLookup"
					resultList="" searchElement="CODE" paramList="" autoSearch="true"
					params="trsDealSettlementChargesSC.chargeCode:CHARGE_CODE_lookuptxt,trsDealSettlementChargesSC.dealCY:lookuptxt_currencyCode_${_pageRef}"
					dependencySrc="${pageContext.request.contextPath}/path/iis/settlementcharges/settlementChargesMaint_dependancyByCharges"
					dependency="trsDealSettlementChargesSC.chargeCode:CHARGE_CODE_lookuptxt,trschargesvo.BRIEF_NAME_ENG:lsBriefNameeng,trschargesvo.INCLUDE_IN_INSTALLMENT_AMT_YN:INCLUDE_IN_INSTALLMENT_YN"
					width="80" afterDepEvent="settlementcharges_afterDepChargeCode()" />

				<psjg:gridColumn name="lsBriefNameeng"
					title="%{getText('Name_key')}" index="lsBriefNameeng"
					colType="text" editable="false" sortable="false" id="lsBriefNameeng" />

				<psjg:gridColumn name="CHARGE_AMOUNT"
					title="%{getText('amount_in_deal_cy_key')}" index="CHARGE_AMOUNT"
					colType="number" editable="true" sortable="false" id="CHARGE_AMOUNT"
					minValue="0"
					params="trsDealStlmntChargesCO.CHARGE_CODE:CHARGE_CODE_lookuptxt,trsDealStlmntChargesCO.CHARGE_AMOUNT:CHARGE_AMOUNT,trsDealStlmntChargesCO.valueDate:startDate_${_pageRef}"
					dependencySrc="${pageContext.request.contextPath}/path/iis/settlementcharges/settlementChargesMaint_onChangeChargeAmount"
					dependency="trsDealStlmntChargesCO.CHARGE_AMOUNT:CHARGE_AMOUNT,trsDealStlmntChargesCO.CHARGE_CODE:CHARGE_CODE_lookuptxt,trsDealStlmntChargesCO.VAT_AMOUNT:VAT_AMOUNT"
					formatter="currencyFmatter"
					formatCol="settlementChargesFormat"
					nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}" />

				<psjg:gridColumn name="INCLUDE_IN_INSTALLMENT_YN"
					title="%{getText('include_in_installment_key')}"
					index="INCLUDE_IN_INSTALLMENT_YN" colType="checkbox"
					editoptions="{value:'Y:N'}" editable="false" sortable="false"
					edittype="checkbox" formatter="checkbox"
					formatoptions="{disabled : true}" id="INCLUDE_IN_INSTALLMENT_YN" />
				<psjg:gridColumn title="" name="dealChargesFormat"
					colType="number" hidden="true" />
				<psjg:gridColumn title="" name="ALLOW_EDIT" colType="text"
					hidden="true" />
				<psjg:gridColumn title="" name="DEFAULT_FROM_PRODUCT_CLASS_YN"
					colType="text" hidden="true" />
				<psjg:gridColumn title="" name="VAT_AMOUNT" colType="text"
					hidden="true" />


			</psjg:grid>
		</div>
		<%--TP#416613;Roshin;02/02/2017  - EWBI160081 - Settlement and reschedule Charges	END	--%>


		<%-- BB130272 Modification;Ravikant.Singh;19/05/2015 --%>
		<ps:if test='%{islamicCalculatorEventMgmtCO.showCustGuarLiability}'>
			<div id="iisCalculatorCustGuarLiabilityDiv_Id_${_pageRef}"
				class="collapsibleContainer collapsed"
				title="<ps:text name='CustOrGuar_Liability_key'/>">
				<ps:url id="urlIisCalculatorCustGuarLiabilityGrid_Id_${_pageRef}"
					escapeAmp="false"
					action="InvestmentDealsList_loadCustGuarLiability?refNbr=${islamicCalculatorEventMgmtCO.trsPayPlanCalculatorVO.REF_NBR}"
					namespace="/path/iis/investmentDeals" />
				<psjg:grid id="iisCalculatorCustGuarLiabilityGridTbl_Id_${_pageRef}"
					dataType="json" pager="true" filter="false" editurl="#"
					href="%{urlIisCalculatorCustGuarLiabilityGrid_Id_${_pageRef}}"
					gridModel="gridModel" rowNum="5" rowList="5,10,15,20"
					viewrecords="true" navigator="true" height="110"
					navigatorRefresh="false" navigatorSearch="false" hiddengrid="false"
					addfunc="addDealCharges" delfunc="deleteDealCharges"
					autowidth="false" multiselect="false" multiboxonly="false"
					pagerButtons="false" editinline="true" altRows="true"
					shrinkToFit="false" navigatorEdit="false" onCompleteTopics=""
					navigatorAdd="false" navigatorDelete="false" rownumbers="true"
					onEditInlineBeforeTopics="">
					<psjg:gridColumn id="COMP_CODE" index="COMP_CODE"
						name="trsdealCustGuarLiabilitiesVO.COMP_CODE" title=""
						colType="number" width="1" editable="false" sortable="false"
						search="false" hidden="true" />
					<psjg:gridColumn id="BRANCH_CODE" index="BRANCH_CODE"
						name="trsdealCustGuarLiabilitiesVO.BRANCH_CODE" title=""
						colType="number" width="1" editable="false" sortable="false"
						search="false" hidden="true" />
					<psjg:gridColumn id="SERIAL_NO" index="SERIAL_NO"
						name="trsdealCustGuarLiabilitiesVO.SERIAL_NO" title=""
						colType="number" width="1" editable="false" sortable="false"
						search="false" hidden="true" />
					<psjg:gridColumn id="LINE_NO" index="LINE_NO"
						name="trsdealCustGuarLiabilitiesVO.LINE_NO" title=""
						colType="number" width="1" editable="false" sortable="false"
						search="false" hidden="true" />
					<psjg:gridColumn id="LINE_DESCRIPTION_ENG"
						index="LINE_DESCRIPTION_ENG"
						name="trsdealCustGuarLiabilitiesVO.LINE_DESCRIPTION_ENG"
						title="%{getText('Previous_Deals_key')}" colType="text"
						width="150" editable="false" sortable="false" search="false"
						hidden="false" />
					<psjg:gridColumn id="LINE_DESCRIPTION_ARAB"
						index="LINE_DESCRIPTION_ARAB"
						name="trsdealCustGuarLiabilitiesVO.LINE_DESCRIPTION_ARAB"
						title="%{getText('Previous_Deals_key')}" colType="text"
						width="150" editable="false" sortable="false" search="false"
						hidden="true" />
					<psjg:gridColumn id="TOTAL_FINANCED_AMT" index="TOTAL_FINANCED_AMT"
						name="trsdealCustGuarLiabilitiesVO.TOTAL_FINANCED_AMT"
						title="%{getText('Remaining_Amt_key')}" colType="number"
						width="125" nbFormat="#,###.000" minValue="0.00"
						editoptions="{maxlength:'17'}" onchange="" onblur=""
						editable="true" sortable="false" search="false" hidden="false" />
					<psjg:gridColumn id="INSTALLMENT_AMOUNT" index="INSTALLMENT_AMOUNT"
						name="trsdealCustGuarLiabilitiesVO.INSTALLMENT_AMOUNT"
						title="%{getText('Total_installment_key')}" colType="number"
						nbFormat="#,###.000" width="125" editoptions="{maxlength:'17'}"
						minValue="0.00" editable="true" sortable="false" search="false"
						hidden="false" />
				</psjg:grid>
			</div>
		</ps:if>
		<%-- Vat Details Section Starts--%>
		<psj:div cssClass="collapsibleContainer collapsed"
			title="%{getText('VAT_key')}" id="vatSection_${_pageRef}">
			<table style="width: 100%"
				class="headerPortionContent ui-widget-content">
				<tr>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
				</tr>
				<tr>
					<td colspan="4"><ps:checkbox
							name="islamicCalculatorEventMgmtCO.vatApplicable"
							id="vatApplicable_${_pageRef}" key="VAT_Applicable_key"
							onchange="onChangeVatApplicable();" valOpt="Y:N"
							cssClass="ui-widget-content checkboxheight" /></td>
					<td colspan="5"><ps:checkbox
							name="islamicCalculatorEventMgmtCO.includeVatinInstallment"
							id="vatInstallment_${_pageRef}" fieldValue="true"
							onchange="onChangeVatInstallment()"
							cssClass="ui-widget-content checkboxheight" valOpt="Y:N"
							key="Installment_Amount_+_VAT_Amount_key" /></td>
					<%--TP#226010;Arun.R.Variyath;26/09/2014			--%>
					<td class="fldLabelView" colspan="2"><ps:label
							key="VAT_Code_key" id="lbl_VAT_Code_${_pageRef}"
							for="lookuptxt_vatCode_${_pageRef}" /></td>
					<td colspan="2"><psj:livesearch
							actionName="${pageContext.request.contextPath}/pathdesktop/VatCodeLookup_constructLookup"
							id="vatCode_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.vatCode"
							searchElement="VAT_CODE" autoSearch="false" mode="number"
							resultList="" maxlength="6"
							dependencySrc="${pageContext.request.contextPath}/pathdesktop/VatCodeDependencyAction_dependancyByVatCode"
							parameter="vatCodeSC.vatCode:lookuptxt_vatCode_${_pageRef}"
							dependency="lookuptxt_vatCode_${_pageRef}:vatCodeVO.VAT_CODE,vatDesc_${_pageRef}:vatCodeVO.BRIEF_NAME_ENG"
							afterDepEvent="onChangeVatCode();">
						</psj:livesearch></td>
					<td colspan="2"><ps:textfield id="vatDesc_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.vatDesc" readonly="true" /></td>
					<td class="fldLabelView" colspan="2"><ps:label
							key="VAT_PERCENTAGE_SYM_key" id="lbl_VAT_Percentage_${_pageRef}"
							for="vatPercentage_${_pageRef}" /></td>
					<td><ps:textfield id="vatPercentage_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.vatPercentage" mode="number"
							nbFormat="#,###.##" maxlength="20" /></td>
				</tr>
				<%--TP#226010;Arun.R.Variyath;26/09/2014			--%>
				<%--TP#396091;Roshin;27/04/2016	START	--%>
					<jsp:include page="/WEB-INF/pages/businesscommon/islamiccalculator/VatExemptionDetails.jsp" />
			    <%--TP#396091;Roshin;27/04/2016	END	--%>
								
			</table>
		</psj:div>
		<%-- Vat Details Section End--%>

		<div id="baloonpaymentdetailsdiv_${_pageRef}"
			class="collapsibleContainer collapsed"
			title="<ps:text name="BALLOON_PAYMENT_DETAILS_key"/>">
			<%-- Balloon Details Section Starts--%>
			<table style="width: 100%"
				class="headerPortionContent ui-widget-content">
				<tr>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
				</tr>
				<tr>
					<ps:set var="hideBalloons" value="%{'display:none'}" />
					<td class="fldLabelView" colspan="2"><ps:label
							key="Number_of_Balloon_Payments_key"
							id="lbl_baloonPaymentNo_${_pageRef}"
							for="baloonPaymentNo_${_pageRef}" /></td>

					<td colspan="1"><ps:textfield id="baloonPaymentNo_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.noOfBaloonPayments"
							mode="number" onchange="onChangeNoOfBalloons();" maxValue="999"
							maxlength="3" /></td>
					<td></td>
					<td class="fldLabelView" colspan="2"><ps:label
							key="Balloon_percentage_key"
							id="lbl_baloonPercentage_${_pageRef}"
							for="baloonPercentage_${_pageRef}" /></td>
					<td colspan="1"><ps:textfield
							id="baloonPercentage_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.baloonPercentage"
							mode="number" nbFormat="0#,###.###" maxlength="6"
							onchange="onChangeBalloonPercentage();" /></td>
					<td></td>
					<td class="fldLabelView" colspan="2"><ps:label
							key="Balln_Amt_key" id="lbl_baloonAmount_${_pageRef}"
							for="baloonAmount_${_pageRef}" /></td>
					<td colspan="3"><ps:textfield id="baloonAmount_${_pageRef}"
							name="islamicCalculatorEventMgmtCO.baloonAmount" mode="number"
							nbFormat="#,###.##" maxlength="20"
							onchange="onChangeBalloonAmount();" /></td>
				</tr>
			</table>
			<table style="width: 100%"
				class="headerPortionContent ui-widget-content">
				<tr>
					<td colspan="3">
						<table style="width: 100%">
							<tr> 
								<td>
									<psjg:grid id="balloonPaymentGridTbl_Id_${_pageRef}"
										caption="%{getText('Balloon_Details_key')}" dataType="json"
										pager="true" filter="false" editurl="#" viewrecords="true"
										navigator="true" height="110" navigatorRefresh="false"
										navigatorSearch="false" hiddengrid="false" addfunc="" editfunc=""
										multiselect="false" multiboxonly="false" pagerButtons="false"
										editinline="true" altRows="true" shrinkToFit="true"
										navigatorEdit="false" footerrow="true" userDataOnFooter="true"
										gridModel="gridModel" navigatorAdd="false"
										navigatorDelete="false">
			
										<psjg:gridColumn name="balloonNo"
											title="%{getText('Balloon_No_key')}" index="balloonNo"
											colType="number" editable="false" sortable="false" id="balloonNo" />
			
										<psjg:gridColumn name="balloonDate"
											title="%{getText('Payment_Date_key')}" index="balloonDate"
											colType="date" editable="true" sortable="false" id="balloonDate"
											editoptions="{dataEvents: [{ type: 'change', fn: function(e) { validateDateForBalloonDetails(e); } }]}" />
										<psjg:gridColumn name="balloonAmount"
											title="%{getText('Balloon_Amount_key')}" index="balloonAmount"
											formatter="currencyFmatter" colType="number" editable="true"
											sortable="false" id="balloonAmount" formatCol="baloonAmtFormat"
											editoptions="{dataEvents: [{ type: 'change', fn: function(e) { validateAmtForBalloonDetails(e); } }]}" />
										<psjg:gridColumn title="" name="baloonAmtFormat" colType="number"
											hidden="true" />
									</psjg:grid>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				 <tr>
				    
				    <td>
				    <psj:a button="true" href="#" id="unequalEqualPayments_${_pageRef}"
						onclick="getEqualUnEqualBalloonPaymentsList('equal')">
						<ps:label key="equal_Payments_key"></ps:label>
					</psj:a>
				    </td>
				    <td width="80%">
				    </td>
			    </tr>
			</table>
		</div>
		<%-- Balloon Details Section End--%>
		
		<%@include file="/WEB-INF/pages/businesscommon/islamiccalculator/CifBlackListRestrictionCode.jsp" %>
		<ps:hidden id="hidden_validateBlackListRestriction_${_pageRef}" name="islamicCalculatorEventMgmtCO.validateBlackListRestriction"></ps:hidden>
		
		<div id="resultsetdiv_${_pageRef}" class="collapsibleContainer"
			title="<ps:text name="RESULT_SET_key"/>">
			<%-- Result Section Starts--%>
			<table id="resultSetTable_${_pageRef}" style="width: 100%"
				class="headerPortionContent ui-widget-content">
				<tr>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="15%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="15%"></td>

				</tr>
				<tr>
					<td class="fldLabelView" colspan="2"><ps:label
							key="Remaining_Amount_key" id="lbl_Remaining_Amount_${_pageRef}"
							for="remainingAmount_${_pageRef}" /></td>
					<td><ps:textfield id="remainingAmount_${_pageRef}"
							name="calculatorCO.outRemainingAmount" mode="number"
							readonly="true" nbFormat="#,###.##"
							maxValue="99999999999999999999" /></td>
					<td class="fldLabelView"><ps:label key="Sale_Amount_key"
							id="lbl_Sale_Amount_${_pageRef}" for="saleAmount_${_pageRef}" /></td>
					<td colspan="3"><ps:textfield id="saleAmount_${_pageRef}"
							name="calculatorCO.outSaleAmount" mode="number" readonly="true"
							nbFormat="#,###.##" maxValue="99999999999999999999" /></td>
					<td class="fldLabelView"><ps:label key="Profit_key"
							id="lbl_Profit_${_pageRef}" for="profit_${_pageRef}" /></td>
					<td><ps:textfield id="profit_${_pageRef}"
							name="calculatorCO.outProfitAmount" mode="number" readonly="true"
							nbFormat="#,###.##" maxValue="99999999999999999999" /></td>
				</tr>
				<tr>
					<td class="fldLabelView" colspan="2"><ps:label
							key="Amount_Per_Payment_key"
							id="lbl_Amount_Per_Payment_${_pageRef}"
							for="amountPerPaymentResult_${_pageRef}" /></td>
					<td><ps:textfield id="amountPerPaymentResult_${_pageRef}"
							name="calculatorCO.outAmountPerPayment" mode="number"
							readonly="true" nbFormat="#,###.##"
							maxValue="99999999999999999999" /></td>
					<td class="fldLabelView"><ps:label key="XIRR_key"
							id="lbl_XIRR_${_pageRef}" for="xirr_${_pageRef}" /></td>
					<td colspan="3"><ps:textfield id="xirr_${_pageRef}"
							name="calculatorCO.xirrOut" mode="number" readonly="true"
							nbFormat="#,###.##" maxValue="99999.999999" /></td>
					<td class="fldLabelView"><ps:label key="xirr_with_charges_key"
							id="lbl_XIRR_With_Charges_${_pageRef}"
							for="XIRR_With_Charges_${_pageRef}" /></td>
					<td><ps:textfield id="XIRR_With_Charges_${_pageRef}"
							name="calculatorCO.xirrWithChargesOut" mode="number"
							readonly="true" nbFormat="0,###.000000000000" /></td>
					<td class="fldLabelView" colspan="2">
						<ps:label key="TEG"  id="lbl_teg_${_pageRef}" for="teg_${_pageRef}"/>
					</td>
				
					<td colspan="3">
						<ps:textfield id="teg_${_pageRef}" name="islamicCalculatorEventMgmtCO.teg" 
							mode="number" readonly="true"  nbFormat="#,###.##" />
					</td>																																																		
					
				</tr>
				<tr>
					<td class="fldLabelView" colspan="2">
						<ps:label key="apr_key" id="lbl_apr_rate_${_pageRef}"
							for="apr_rate_${_pageRef}" />
					</td> 
					<td >
					<ps:textfield  id="apr_rate_${_pageRef}" 
							name="calculatorCO.aprRate" readonly="true"
							 />
					</td>
				</tr>
			</table>
		</div>
		<%-- Result Section End--%>
	</div>

	<ptt:toolBar id="fomToolbar_${_pageRef}">
		<psj:submit id="calculateBtn_${_pageRef}" button="true"
			buttonIcon="ui-icon-calculator">
			<ps:label key="Calculate_key" />
		</psj:submit>
		<psj:submit id="resetBtn_${_pageRef}" button="true" type="button"
			buttonIcon="ui-icon-refresh" onclick="resetCalculatorPage();">
			<ps:label key="Reset_key" />
		</psj:submit>
		<psj:submit id="printBtn_${_pageRef}" button="true" type="button"
			buttonIcon="ui-icon-print" onclick="printCalculateScreen();">
			<ps:label key="btn.print" />
		</psj:submit>
	</ptt:toolBar>
</ps:form>

<script type="text/javascript">
	$(document).ready(
			function() {
				var gridParentWidth = $('#repaymentdetailsdiv_' + _pageRef)
						.width();
				$('#repaymentgridTbl_Id_' + _pageRef).jqGrid("setGridWidth",
						gridParentWidth - 5);
				$('#balloonPaymentGridTbl_Id_' + _pageRef).jqGrid(
						"setGridWidth", gridParentWidth - 5);
			});
</script>