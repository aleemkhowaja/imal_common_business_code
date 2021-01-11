<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
<%@taglib prefix="ptt" uri="/path-toolbar-tags"%>

<script  type="text/javascript"> 
	$.struts2_jquery.require("IslamicCalculatorMain.js" ,null,jQuery.contextPath+"/businesscommon/js/islamiccalculator/");
		var dealChargesAmountHeader 	= "<ps:text name='Amount_key' />";
		var repaymentInstallmentDate 	= "<ps:text name='Installment_Date_key'/>";
		var repaymentPeriodicity		= "<ps:text name='Repayment_Periodicity_key'/>";
		var coveringAccount				= "<ps:text name='Covering_Account_key'/>";
		var account						= "<ps:text name='Account_key'/>";
		var cannotBeLessThanZero		= "<ps:text name='Cannot_be_less_than_zero_key'/>";
		var printStatement				= "<ps:text name='Print_Statement__key'/>";
		var schedule					= "<ps:text name='Schedule_key'/>";
		var equalPayments				= "<ps:text name='Equal_Payments_key'/>";
		var unequalPayments				= "<ps:text name='Unequal_Payments_key'/>";	
		var InvalidTotalAmount   		="<ps:text name='Invalid_total_amount_key'/>"; 
  		var Cannot_Proceed            	="<ps:text name='Cannot_Proceed'/>";
		$(document).ready(function() {
		   islmcCalcMaint_onDocReady();	
		   $("div#islamicCalculatorMaindiv_"+_pageRef+" .collapsibleContainer").collapsiblePanel();
		   $("#islamicCalculatorMaindiv_"+_pageRef).sortable({ handle : '.collapsibleContainerTitle'});
		});
	</script>
	
<html>

	
	<head>
   		<title> <ps:text name="" /> </title>
	</head>
	<body> 
		
		
		
		
		<ps:hidden id="hidden_branchCode_${_pageRef}" name="islamicCalculatorEventMgmtCO.branchCode"></ps:hidden>
		<ps:hidden id="hidden_civilidFlag_${_pageRef}" value="Y"></ps:hidden>
		<ps:hidden id="hidden_checkDefaultMaturityDate_${_pageRef}" name="islamicCalculatorEventMgmtCO.checkDefaultMaturityDate"></ps:hidden>
		<ps:hidden id="hidden_confirmationResult_${_pageRef}" name="islamicCalculatorEventMgmtCO.confirmationResult"></ps:hidden>
		<ps:hidden id="hidden_islamicCalcDecimalFormat_${_pageRef}" name="islamicCalculatorEventMgmtCO.currencyDecimalPointsForCalc"></ps:hidden>
		<ps:hidden id="hidden_disableBtnAfterCalc_${_pageRef}" name="islamicCalculatorEventMgmtCO.disableBtnAfterCalc"></ps:hidden>
		<psj:datepicker cssStyle="display:none" name="islamicCalculatorEventMgmtCO.defaultMaturityDate" id="hidden_defaultMaturityDate_${_pageRef}"/>
		<psj:datepicker cssStyle="display:none" name="islamicCalculatorEventMgmtCO.maturityDateAfterHoliday" id="hidden_maturityDateAfterHoliday_${_pageRef}"/>
		<psj:datepicker cssStyle="display:none" name="islamicCalculatorEventMgmtCO.startDateAfterHoliday" id="hidden_startDateAfterHoliday_${_pageRef}"/>
		<ps:hidden id="hidden_reschedule_${_pageRef}" name="rescheduleYn"></ps:hidden>
		<ps:hidden id="hidden_prevValue_${_pageRef}" ></ps:hidden>
		<ps:hidden id="hidden_printCalcDetailScheduleYN_${_pageRef}" name="islamicCalculatorEventMgmtCO.printCalcDetailScheduleYN"/>
		<ps:hidden id="hidden_printCalcDetailYN_${_pageRef}" name="islamicCalculatorEventMgmtCO.printCalcDetailYN"/>
		<ps:hidden id="cifNo_preValue_${_pageRef}" />
		<ps:hidden id="cifName_preValue_${_pageRef}" />
		

		
		<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
		<div id="islmcCalcMainTabs_${_pageRef}" style="width: 100%">
			<ul>
	      		<li><a href="#islmcCalcTabs-1_${_pageRef}" id="islmcCalcTabs1_${_pageRef}"><ps:text name="Calculator_key"/></a></li>
	      		<li><a href="#islmcCalcTabs-2_${_pageRef}" id="islmcCalcTabs2_${_pageRef}"><ps:text name="Schedule_key"/></a></li>
	       	</ul>
	       	<div id="islmcCalcTabs-1_${_pageRef}" >
	       		<ps:form id="islamicCalculatorFormMaindiv_${_pageRef}" useHiddenProps="true">
	       			<!-----SANKAR---->
					<ps:hidden id="hidden_calculatorType_${_pageRef}" name="islamicCalculatorEventMgmtCO.calculatorType"></ps:hidden>
					<%--  		 TP# 271723;deepu.mohandas 18/02/2015 --%>
					<ps:hidden id="islamicCalculatorEventMgmtCO_category_${_pageRef}" name="islamicCalculatorEventMgmtCO.category" />
					<ps:hidden id="islamicCalculatorEventMgmtCO_firstYrProfit_${_pageRef}" name="islamicCalculatorEventMgmtCO.firstYrProfit" />
					<ps:hidden id="islamicCalculatorEventMgmtCO_lastPayment_${_pageRef}" name="islamicCalculatorEventMgmtCO.lastPaymentAmount" />
					<ps:hidden id="hidden_dealNo_${_pageRef}" name="islamicCalculatorEventMgmtCO.dealNo"/>
					<ps:hidden id="hidden_planNbr_${_pageRef}" name="islamicCalculatorEventMgmtCO.planNbr"/>
					<ps:hidden id="hidden_islamicCalcDecimalFormatPrint_${_pageRef}" name="islamicCalculatorEventMgmtCO.islamicCalcDecimalFormatPrint"/>
		
					<div id="islamicCalculatorMaindiv_${_pageRef}" class="connectedSortable ui-helper-reset">
						<div id="financingdetailsdiv_${_pageRef}" class="collapsibleContainer" title="<ps:text name="FINANCING_DETAILS_key"/>"><!-- Financing Details Section Starts -->
							<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<td class="fldLabelView">
										<ps:label key="CIF_No_key" id="lblCIF_No_${_pageRef}" for="lookuptxt_cifNo_${_pageRef}"/>
									</td>
									<td>
										<psj:livesearch name="islamicCalculatorEventMgmtCO.cifNo" 				                      
						                      id="cifNo_${_pageRef}" mode="number" leadZeros="8" maxlength="8" searchElement="CIF_NO"
						                      paramList="lookupCivilId:hidden_civilidFlag_${_pageRef}"
						                      resultList="CIF_NO:lookuptxt_cifNo_${_pageRef},SHORT_NAME_ENG:cifName_${_pageRef},ID_NO:civilId_${_pageRef}"
						                      actionName="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructCifQueryLookup" 
						                      beforeDepEvent="beforeDependencyForCifValidationInCalculator()"
						                      parameter="islamicCalculatorEventMgmtCO.cifNo:lookuptxt_cifNo_${_pageRef},islamicCalculatorEventMgmtCO.startDate:startDate_${_pageRef},islamicCalculatorEventMgmtCO.productClass:lookuptxt_productClass_${_pageRef},islamicCalculatorEventMgmtCO.currencyCode:lookuptxt_currencyCode_${_pageRef}"
			                    			  dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeCifCivilId"
			                   				  dependency="lookuptxt_civilId_${_pageRef}:islamicCalculatorEventMgmtCO.idNo,lookuptxt_cifNo_${_pageRef}:islamicCalculatorEventMgmtCO.cifNo,cifName_${_pageRef}:islamicCalculatorEventMgmtCO.cifName,approvedSalary_${_pageRef}:islamicCalculatorEventMgmtCO.approvedSalary,income_${_pageRef}:islamicCalculatorEventMgmtCO.income,debtBurdanRatio_${_pageRef}:islamicCalculatorEventMgmtCO.debtBurdanRatio"
			                   				  afterDepEvent="afterDependencyForCifValidationInCalculator()"
			                   				  >
									 	</psj:livesearch>								
									</td>
									<td colspan="2">
										<ps:textfield id="cifName_${_pageRef}"  readonly="true" name="islamicCalculatorEventMgmtCO.cifName"></ps:textfield>
									</td>
									<td>
									<psj:submit id="queryBtn_${_pageRef}" button="true"
													type="button"   buttonIcon="ui-icon-flag"
													onclick="islmCalc_showQuery()" >
													<ps:label key="Query_key"></ps:label>
									</psj:submit>
									</td>
									<td class="fldLabelView">
										<ps:label key="Civil_ID_key" id="lblCivil_ID_${_pageRef}"/>
									</td>
									<td colspan="2">
										<psj:livesearch name="islamicCalculatorEventMgmtCO.idNo" id ="civilId_${_pageRef}" mode="text" maxlength="19"
						                      actionName="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructLookup" 
						                      paramList="lookupCivilId:hidden_civilidFlag_${_pageRef}"
						                      resultList="ID_NO:lookuptxt_civilId_${_pageRef}" searchElement="ID_NO"
						                      							                      
						                      parameter="islamicCalculatorEventMgmtCO.cifNo:lookuptxt_cifNo_${_pageRef},islamicCalculatorEventMgmtCO.startDate:startDate_${_pageRef},islamicCalculatorEventMgmtCO.productClass:lookuptxt_productClass_${_pageRef},islamicCalculatorEventMgmtCO.idNo:lookuptxt_civilId_${_pageRef},islamicCalculatorEventMgmtCO.currencyCode:lookuptxt_currencyCode_${_pageRef}"
			                    			  dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeCivilId"
			                   				  dependency="lookuptxt_civilId_${_pageRef}:islamicCalculatorEventMgmtCO.idNo,lookuptxt_cifNo_${_pageRef}:islamicCalculatorEventMgmtCO.cifNo,cifName_${_pageRef}:islamicCalculatorEventMgmtCO.cifName,approvedSalary_${_pageRef}:islamicCalculatorEventMgmtCO.approvedSalary,income_${_pageRef}:islamicCalculatorEventMgmtCO.income,debtBurdanRatio_${_pageRef}:islamicCalculatorEventMgmtCO.debtBurdanRatio"
						                     >
								  	    </psj:livesearch>			
									</td>
									
									<td class="fldLabelView">
										<ps:label key="Income_key" id="lbl_Income_${_pageRef}" for="income_${_pageRef}"/>
									</td>
									<td colspan="2">
										<ps:textfield id="income_${_pageRef}" name="islamicCalculatorEventMgmtCO.income"
										mode="number" readonly="true"  nbFormat="#,###.##" maxlength="14" />
									</td>
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Approved_Salary_key" id="lbl_Approved_Salary_${_pageRef}" for="approvedSalary_${_pageRef}"/>
									</td>			
									<td colspan="2">
										<ps:textfield mode="number" nbFormat="#,###.##" maxlength="14" name="islamicCalculatorEventMgmtCO.approvedSalary" id="approvedSalary_${_pageRef}"
											 parameter="islamicCalculatorEventMgmtCO.approvedSalary:approvedSalary_${_pageRef},islamicCalculatorEventMgmtCO.cifNo:lookuptxt_cifNo_${_pageRef},islamicCalculatorEventMgmtCO.startDate:startDate_${_pageRef},islamicCalculatorEventMgmtCO.productClass:lookuptxt_productClass_${_pageRef},islamicCalculatorEventMgmtCO.currencyCode:lookuptxt_currencyCode_${_pageRef}"
						                     dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeApprovedSalary"
											 dependency="approvedSalary_${_pageRef}:islamicCalculatorEventMgmtCO.approvedSalary,debtBurdanRatio_${_pageRef}:islamicCalculatorEventMgmtCO.debtBurdanRatio"
										/>
									</td>									
									<td colspan="2"></td>
									
									<ps:set var="show" value="%{'display:none'}"/>
									<ps:if test='%{islamicCalculatorEventMgmtCO.calcDbrCalculationReqdYn!=null && islamicCalculatorEventMgmtCO.calcDbrCalculationReqdYn.equals("Y")}' >
										<td class="fldLabelView" >
											<ps:label key="Debt_Burden_Ratio_key" id="lbl_Debt_Burden_Ratio_${_pageRef}" for="debtBurdanRatio_${_pageRef}"/>
										</td>		
										<td colspan="2">
											<ps:textfield id="debtBurdanRatio_${_pageRef}" name="islamicCalculatorEventMgmtCO.debtBurdanRatio" 
											mode="number" nbFormat="#,###.##" maxlength="14" cssStyle="%{hide}"/>
										</td>											
										<td colspan="3">
											<psj:submit id="debitburdan_${_pageRef}" button="true"  type="button" onclick="onDebitBurdunRatioButtonClicked();" cssStyle="%{hide}" name="debitburdan">
				                                <ps:label key="Debt_Burden_Ratio_key"/>
				                            </psj:submit>  
										</td>	
									</ps:if>
								</tr>
							</table>
							<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<td width="10%"></td>
								</tr>
								
								<tr>
									<td class="fldLabelView">
										<ps:label key="Product_Class_key" id="lbl_Product_Class_${_pageRef}" for="lookuptxt_productClass_${_pageRef}"/>
									</td>		
									<td>
										<psj:livesearch
												actionName="${pageContext.request.contextPath}/pathdesktop/productClassLookup_constructLookup"
												id="productClass_${_pageRef}" name="islamicCalculatorEventMgmtCO.productClass"
												searchElement="CODE" autoSearch="true" mode="number"
												resultList="CODE:lookuptxt_productClass_${_pageRef},BRIEF_NAME_ENG:productClassName_${_pageRef}"
												parameter="CODE:lookuptxt_productClass_${_pageRef}" maxlength="4"
							                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/ProductClassDependencyAction_dependencyByProductClassCode"
							                    dependency="lookuptxt_productClass_${_pageRef}:productClassCO.CODE,productClassName_${_pageRef}:productClassCO.BRIEF_NAME_ENG,profitRecognitionMethod_:islamicCalculatorEventMgmtCO.profitRecognitionMethod"
							                    beforeDepEvent="islamicCalculator_productClassBeforeDependencyValue()"
												afterDepEvent="islamic_onChangeProductClass()">
										</psj:livesearch><!-- TODO add this in dependency  the radio doc Pay_Residual_Amount_${_pageRef}:islamicCalculatorEventMgmtCO.payResAmt,-->									
									</td>	
									<td colspan="2">
										<ps:textfield id= "productClassName_${_pageRef}"  readonly="true" name="islamicCalculatorEventMgmtCO.productClassName" />
									</td>	
									<td class="fldLabelView">
										<ps:label key="Financing_Currency_key" id="lbl_Financing_Currency_${_pageRef}" for="lookuptxt_currencyCode_${_pageRef}"/>
									</td>		
									<td>
						                <psj:livesearch
											actionName="${pageContext.request.contextPath}/pathdesktop/currencyLookup_constructLookup"
											id="currencyCode_${_pageRef}" name="islamicCalculatorEventMgmtCO.currencyCode"
											searchElement="CURRENCY_CODE" autoSearch="true" maxlength="3"
											resultList="CURRENCY_CODE:lookuptxt_currencyCode_${_pageRef},BRIEF_DESC_ENG:currencyDesc_${_pageRef}"
											mode="number" afterDepEvent="onChangeCurrencyCode();"
											parameter="islamicCalculatorEventMgmtCO.currencyCode:lookuptxt_currencyCode_${_pageRef}"
						                    dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_dependencyByCurrencyCode"
						                    dependency="lookuptxt_currencyCode_${_pageRef}:islamicCalculatorEventMgmtCO.currencyCode,currencyDesc_${_pageRef}:islamicCalculatorEventMgmtCO.currencyDesc,hidden_islamicCalcDecimalFormat_${_pageRef}:islamicCalculatorEventMgmtCO.currencyDecimalPointsForCalc"
						                    >
										</psj:livesearch>									
									</td>		
									<td >
										<ps:textfield id="currencyDesc_${_pageRef}" name="islamicCalculatorEventMgmtCO.currencyDesc" 
										 readonly="true">
						                </ps:textfield>										
									</td>	
									<td class="fldLabelView">
										<ps:label key="Profit_Collected_key" id="lbl_Profit_Collected_${_pageRef}" for="profitCollected_${_pageRef}"/>
									</td>	
									<td colspan="2">
										<ps:textfield id="profitCollected_${_pageRef}" name="islamicCalculatorEventMgmtCO.advancePayment" 
										 mode="number" nbFormat="#,###.##" maxlength="14" readonly="false"/>
									</td>	
								</tr>		
							</table>
							<%--       TP#247336;Arun.R.Variyath;10/12/2014 Start--%>
					       <div id="musawamahDiv_${_pageRef}" style="display: none">
					       <table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
			              <td class="fldLabelView">
			               <ps:label key="Contract_Price_key" id="lbl_Contract_Price_${_pageRef}" for="contractPrice_${_pageRef}"/>
			              </td>
			              <td class="fldDataEdit">
			               <ps:textfield id="contractPrice_${_pageRef}" name="islamicCalculatorEventMgmtCO.contractPrice" 
			                  mode="number" nbFormat="#,###.###"  maxLenBeforeDec="12" minValue="0"
			                  onchange="islamicCalculator_onChangeContractPrice()"/>            
			              </td>
			              <td></td>
			              <td class="fldDataEdit">
			               <ps:label key="Discount_Calc_Method_key" id="lbl_Discount_Cal_Method_${_pageRef}" for="discountCalMethod_${_pageRef}"/>
			              </td>
			              <td class="fldDataEdit" colspan="2">
			               <ps:select  id="discountCalMethod_${_pageRef}" list="discountCalMethodList" listKey="code" 
			                  listValue="descValue" name="islamicCalculatorEventMgmtCO.discountCalMethod"
			                  onchange="islamicCalculator_onChangeContractPrice()"></ps:select>
			              </td>
			              <td class="fldLabelView">
			               <ps:label key="Discount_Ptg_key" id="lbl_Discount_Perc_${_pageRef}" for="discountPerc_${_pageRef}"/>
			              </td>
			              <td class="fldDataEdit" >
			               <ps:textfield id="discountPerc_${_pageRef}" name="islamicCalculatorEventMgmtCO.discountPerc" 
			                  mode="number"  nbFormat="#,###.########" maxLenBeforeDec="3"  minValue="0"
			                  onchange="islamicCalculator_onChangeContractPrice()" />            
			              </td>
			             </tr>
					       </table>
					       </div>
					       <%--       TP#247336;Arun.R.Variyath;10/12/2014 End--%>
							<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<td class="fldLabelView">
										<ps:label key="Purchase_Amount_key" id="lbl_Purchase_Amount_${_pageRef}" for="purchaseAmount_${_pageRef}"/>
									</td>	
									<td colspan="2">
										<table width="100%">
											<tr>
												<td width="80%" class="fldDataEdit right">
													<ps:textfield id="purchaseAmount_${_pageRef}" name="islamicCalculatorEventMgmtCO.purchaseAmount" 
													mode="number" nbFormat="#,###.##"  onchange="onChangePurchaseAmount()"/>												
												</td>
												<td width="20%"></td>
											</tr>
										</table>  
									</td>
									<td class="fldLabelView">
										<ps:label key="Down_Pay_Ptg_key" id="lbl_Down_Payment_${_pageRef}" for="downPaymentPercentage_${_pageRef}"/>
									</td>	
									<td colspan="3">
									<table width="100%">
									<tr>
									<td width="80%" class="fldDataEdit right">
									<ps:textfield id = "downPaymentPercentage_${_pageRef}" name="islamicCalculatorEventMgmtCO.downPaymentPercentage" 
									onchange="onChangeDownPaymentPercentage()" mode="number" nbFormat="#,###.##" />
									</td>
									
									</tr>
									</table>
									</td>
									<td class="fldLabelView"  width="20%">
									<ps:label key="Down_Payment_key" id="lbl_downPaymentAmount_${_pageRef}" for="downPaymentAmount_${_pageRef}"/>
									</td>
									<td colspan="1">
										<table width="100%">
											<tr>
											<%-- TP#164723;Libin;06/11/2014 Removed the wrong maxValue validation from jsp and moved it to Server Side --%>
												<td width="80%" class="fldDataEdit right">
													<ps:textfield id="downPaymentAmount_${_pageRef}" 
													 mode="number" nbFormat="#,###.##"
													 name="islamicCalculatorEventMgmtCO.downPaymentAmount" 
													 onchange="onChangeDownPayment()"
													/>
												</td>
												
												<td width="20%"></td>
											</tr>
										</table>
									</td>
									<td class="fldLabelView">
										<ps:label key="Financing_Amount_key" id="lbl_Financing_Amount_${_pageRef}" for="financingAmount_${_pageRef}"/>
									</td>	
									<td colspan="2">
										<table width="100%">
											<tr>
												<td width="80%" class="fldDataEdit right">
													<ps:textfield id="financingAmount_${_pageRef}" name="islamicCalculatorEventMgmtCO.financingAmount" 
													mode="number" nbFormat="#,###.##" 
													onchange="onChangeFinancingAmount(true)"/>
													<ps:hidden id="financingAmountPreValue_${_pageRef}"/>
												</td>
												
											</tr>
										</table>									
									</td>
								</tr>	
								<tr>
									<td class="fldLabelView">
										<ps:label key="Start_date_key" id="lbl_Start_date_${_pageRef}" for="startDate_${_pageRef}"/>
									</td>	
									<td>
										<psj:datepicker id="startDate_${_pageRef}" name="islamicCalculatorEventMgmtCO.startDate" 
										buttonImageOnly="true" onchange="validateOnChangeStartDate()" 
										/>
									</td>
									<td></td>
									<td class="fldLabelView">
										<ps:label key="Tenure_key" id="lbl_Tenure_${_pageRef}" for="tenure_${_pageRef}"/>
									</td>	
									<td colspan="2">
										<table width="100%">
											<tr>
												<td width="23%">
													<ps:textfield  readonly="true" id="tenure_${_pageRef}" name="islamicCalculatorEventMgmtCO.tenureCode" size="5" mode="number" maxlength="5" />
												</td>
												<td width="2%"></td>
												<td width="75%" >
													<ps:select disabled="true" id="tenure_${_pageRef}" list="paymPeriodicity" listKey="code" 
													listValue="descValue" name="islamicCalculatorEventMgmtCO.tenureDesc"></ps:select>
												</td>
											</tr>
										</table>										
									</td>
								
									<td class="fldLabelView">
										<ps:label key="Calendar_Type_key"
											id="lbl_Calendar_Type_${_pageRef}"
											for="Calendar_Type_${_pageRef}" />

									</td>
									<td width="75%">
										<ps:select id="Calendar_Type_${_pageRef}"
											name="islamicCalculatorEventMgmtCO.calendarType"
											list="calendarType" listKey="code" listValue="descValue" />
									</td>
									
									<td class="fldLabelView">
										<ps:label key="Maturity_Date_key" id="lbl_Maturity_Date_${_pageRef}" for="maturityDate_${_pageRef}"/>
									</td>	
									<td>
										<psj:datepicker id="maturityDate_${_pageRef}" name="islamicCalculatorEventMgmtCO.maturityDate" 
										buttonImageOnly="true" onchange="validateOnChangeMaturityDate()" required="true"/>
									</td>
									<td colspan="2">
										<table width= "100%">
											<tr>
												<td width = "25%">
												
												</td>
												<td width = "75%">
													<ps:checkbox  id= "maintainSalaryAccount_${_pageRef}" name="islamicCalculatorEventMgmtCO.maintainSalaryAccount"
								 					cssClass="ui-widget-content checkboxheight" key="Salary_With_Bank_key" 
								 					onchange="populateOnChangeSalaryWithBank()"/>										
												</td>
											</tr>
										</table>
									</td>
								</tr>							
							</table>
						</div><!-- 	Financing Details Section 	End -->
						<%-- Profit.Calculation Details --%>
						
							<div id="profitcalculationdetailsdiv_${_pageRef}" class="collapsibleContainer" title="<ps:text name="PROFIT_CALC_DETAILS_key"/>"><!-- Profit Calculation Section Starts -->
								<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
										<ps:if test='%{islamicCalculatorEventMgmtCO.showYieldInCalc!=null || islamicCalculatorEventMgmtCO.showYieldInCalc.equals("Y")}' >
											<td class="fldLabelView">
												<ps:label key="Annual_Yield_Rate_key"  id="lbl_Annual_Yield_Rate_${_pageRef}" for="annualYieldRate_${_pageRef}"/>
											</td>
											<td><%--TP#164973; Libin; 06/11/2014 --%>
												<ps:textfield id="annualYieldRate_${_pageRef}" name="islamicCalculatorEventMgmtCO.annualYieldRate"
												  mode="number"  nbFormat ="#,0.000000" 
												  onchange="onChangeYield()" />
											</td>	
										</ps:if>
										<ps:else>
											<td></td><td></td>
										</ps:else>	
										<ps:if test='%{islamicCalculatorEventMgmtCO.allowProfitRecoInCalc==null || !islamicCalculatorEventMgmtCO.allowProfitRecoInCalc.equals("N")}'>
										<td class="fldLabelView">
											<ps:label key="Margin_key"  id="lbl_Margin_${_pageRef}" for="margin_${_pageRef}"/>
										</td>
										<td>
											<ps:textfield id="margin_${_pageRef}" name="islamicCalculatorEventMgmtCO.margin"
											  mode="number" 
											  nbFormat="#,0.00000000" 
											  onchange="calculateAnnualFloatingMarginRates()"/>
										</td>
										<td class="fldLabelView">
											<ps:label key="Floating_Rate_Code_key"  id="lbl_Floating_Rate_Code_${_pageRef}" 
											for="lookuptxt_floatingRateCode_${_pageRef}"/>
										</td>	
										<td>
											<psj:livesearch
												actionName="${pageContext.request.contextPath}/pathdesktop/floatingRateCodeLookup_constructLookup"
												id ="floatingRateCode_${_pageRef}"  name="islamicCalculatorEventMgmtCO.floatingRateCode"
												mode="number" maxlength="12"								
												searchElement="IBOR_CODE" autoSearch="false"
												resultList="BRIEF_DESC_ENG:floatingRateCode_desc_${_pageRef}"
							                    parameter="IBOR_CODE:lookuptxt_floatingRateCode_${_pageRef}"
							                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/FloatingRateCodeDependencyAction_dependencyByIBOR_CODE"
							                   	dependency="lookuptxt_floatingRateCode_${_pageRef}:iborhdrVO.IBOR_CODE,floatingRateCode_desc_${_pageRef}:iborhdrVO.BRIEF_DESC_ENG">
											</psj:livesearch>										
						                    
										</td>	
										<td colspan="3">
											<ps:textfield id="floatingRateCode_desc_${_pageRef}"  readonly="true" 
											name="islamicCalculatorEventMgmtCO.floatingRateCodeDesc" >
					               			</ps:textfield>
										</td>
										<td class="fldLabelView">
											<ps:label key="Floating_Rate_key"  id="lbl_Floating_Rate_${_pageRef}" for="floatingRate_${_pageRef}"/>
										</td>	
										<td colspan="3">
											<ps:textfield id="floatingRate_${_pageRef}" name="islamicCalculatorEventMgmtCO.floatingRate" 
											mode="number" nbFormat ="#,0.00000000" onchange="calculateAnnualFloatingMarginRates()" 
											/>
										</td>
										</ps:if>
									</tr>
									<tr>
									<%-- <ps:if test='%{islamicCalculatorEventMgmtCO.allowProfitRecoInCalc==null || !islamicCalculatorEventMgmtCO.allowProfitRecoInCalc.equals("N")}'> --%>
										
										<td class="fldLabelView">
											<ps:label key="Annual_Flat_Rate_key"  id="lbl_Annual_Flat_Rate_${_pageRef}" for="annualFlatRate_${_pageRef}"/>
										</td>	
										<td>
											<ps:textfield id="annualFlatRate_${_pageRef}" name="calculatorCO.outAnnualFlatRate" readonly="true" 
											mode="number"   maxValue="99999.999999" nbFormat="#,0.000000"/>
										</td>			
										<td class="fldLabelView">
											<ps:label key="Total_Flat_Rate_key"  id="lbl_Total_Flat_Rate_${_pageRef}" for="totalFlatRate_${_pageRef}"/>
										</td>	
										<td>
											<ps:textfield id="totalFlatRate_${_pageRef}"  name="calculatorCO.outTotalFlatRate" 
											mode="number"  maxValue="99999.999999" onchange="onChangeTotalFlatRate()" nbFormat="#,0.000000"
											 />			
										</td>	
										<td class="fldLabelView">
											<ps:label key="Profit_Calc_Method_key"  id="lbl_Profit_Calc_Method_${_pageRef}" for="profitCalcMethod_${_pageRef}"/>
										</td>	
										<td colspan="2">
											<ps:select  value="profCalc"  id="profitCalcMethod_${_pageRef}" list="profitCalculationMethod" listKey="code" 
											listValue="descValue" name="islamicCalculatorEventMgmtCO.profitCalcMethod"  onchange="onChangeprofitCalcMethod()"
											>
											</ps:select>													
										</td>	
										<td colspan="2"></td>
										<td class="fldLabelView">
											<ps:label key="Profit_Recognition_Method_key"  id="lbl_Profit_Recognition_Method_${_pageRef}" for="profitRecognitionMethod_${_pageRef}"/>
										</td>	
										<td colspan="3">
											<ps:select id="profitRecognitionMethod_${_pageRef}"  list="profitDistMethod" listKey="code" 
											listValue="descValue" name="islamicCalculatorEventMgmtCO.profitRecognitionMethod" onchange="onChangeProfitRecognitionMethod()"
											disabled="false">
											</ps:select>	
										</td>	
										<%-- </ps:if> --%>																																																																																																						
									</tr>
								</table>
								<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
									<tr>
										<td width="10%"></td>
										<td width="15%"></td>
										<td width="15%"></td>
										<td width="10%"></td>	
										<td width="10%"></td>	
										<td width="10%"></td>										
										<td width="10%"></td>	
										<td width="5%"></td>	
										<td width="5%"></td>
										<td width="5%"></td>
										<td width="5%"></td>
									</tr>
<%--									<ps:if test='%{islamicCalculatorEventMgmtCO.allowProfitRecoInCalc==null || !islamicCalculatorEventMgmtCO.allowProfitRecoInCalc.equals("N")}'>--%>
									<tr>
										<td class="fldLabelView">
											<ps:label key="Accrual_Basis_key"  id="lbl_Accrual_Basis_${_pageRef}" for="accrualBasis_${_pageRef}"/>
										</td>	
										<td>
											<ps:select value="accrual" id="accrualBasis_${_pageRef}" list="acccrualBasis" listKey="code" listValue="descValue" 
											name="islamicCalculatorEventMgmtCO.accrualBasis"  onchange="onChangeAccrualBasis()">
											</ps:select>
										</td>
										<td></td>
										<td class="fldLabelView">
											<ps:label key="Facility_Type_key"  id="lbl_Facility_Type_${_pageRef}" for="lookuptxt_facilityTypeCode_${_pageRef}"/>
										</td>	
										<td colspan="2">
											<psj:livesearch
											    actionName="${pageContext.request.contextPath}/pathdesktop/FacilityTypeLookup_constructLookup"
											    paramList="CODE:lookuptxt_facilityTypeCode_${_pageRef}"
												id ="facilityTypeCode_${_pageRef}"  name="islamicCalculatorEventMgmtCO.facilityTypeCode"	
												mode="number"	maxlength="12"								
												searchElement="CODE" autoSearch="false"
												parameter="CODE:lookuptxt_facilityTypeCode_${_pageRef}" 
												dependencySrc="${pageContext.request.contextPath}/pathdesktop/FacilityTypeDependencyAction_dependencyByFacilityTypeCode"
												dependency="lookuptxt_facilityTypeCode_${_pageRef}:facilityTypeVO.CODE,facilityTypeCodeDesc_${_pageRef}:facilityTypeVO.BRIEF_NAME_ENG"
												>
											</psj:livesearch>
										</td>
										<td colspan="3">
											<ps:textfield id="facilityTypeCodeDesc_${_pageRef}"  readonly="true" name="islamicCalculatorEventMgmtCO.facilityTypeDesc">
					                		</ps:textfield>
										</td>
									</tr>
									<tr>
										<td class="fldLabelView" valign="top" colspan="3">	
											<ps:checkbox name="islamicCalculatorEventMgmtCO.dealPeriodCompounding" 
											id = "compoundingDuringTheEntireDealPeriod_${_pageRef}" key="Compounding_during_the_Entire_Deal_period_key" 
											fieldValue="true" onchange="onChangeDealPeriodCompounding()" cssClass="ui-widget-content checkboxheight"/>
										</td>
									</tr>									
<%--									</ps:if>								--%>
								</table>
							</div><!-- 	Profit Calculation Section 	End -->
						
						<div id="repaymentdetailsdiv_${_pageRef}" class="collapsibleContainer"title="<ps:text name='REPAYMENT_DETAILS_key'/>"><%-- Repayment Details Section Starts--%>
							<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<td class="fldLabelView">
										<ps:label key="Temp.Code_key"  id="lbl_Temp_Code_${_pageRef}" for="lookuptxt_tempCode_${_pageRef}"/>
									</td>	
									<td>
										<psj:livesearch
											actionName="${pageContext.request.contextPath}/pathdesktop/TempCodeLookup_constructLookup"
											id="tempCode_${_pageRef}" name="islamicCalculatorEventMgmtCO.tempCode"
											searchElement="TEMPLATE_CODE" autoSearch="false" mode="number" maxlength="8"
											resultList="TEMPLATE_CODE:lookuptxt_tempCode_${_pageRef},BRIEF_NAME_ENG:templateDesc_${_pageRef}"											 
											parameter="TEMPLATE_CODE:lookuptxt_tempCode_${_pageRef}"
											dependencySrc="${pageContext.request.contextPath}/pathdesktop/TemplateCodeDependencyAction_dependancyByTemplateCode"	
											dependency="templateDesc_${_pageRef}:tempCodeVO.BRIEF_NAME_ENG,lookuptxt_tempCode_${_pageRef}:tempCodeVO.TEMPLATE_CODE" 
											afterDepEvent="onChangeTemplateCode()">
										</psj:livesearch>
									</td>	
									<td colspan="2">
										<table width="100%">
											<tr>
												<td width = "80%">
													<ps:textfield name="islamicCalculatorEventMgmtCO.tempCodeDesc"  readonly="true" id = "templateDesc_${_pageRef}"/>
												</td>
												<td width = "20%">
												</td>
											</tr>
										</table>
									</td>	
									<td class="fldLabelView">
										<ps:label key="First_Payment_After_key"  id="lbl_First_Payment_After_${_pageRef}" for="gracePeriod_${_pageRef}"/>
									</td>		
									<td colspan="2">
										<table width="100%">
											<tr>
												<td width="25%" class="fldDataEdit right">
													<ps:textfield name="islamicCalculatorEventMgmtCO.gracePeriod" id="gracePeriod_${_pageRef}"
														onchange="onChangeFirstPaymentAfter()" mode ="number"/>
												</td>
												<td width="75%" class="fldDataEdit center">
													<table width="100%">
														<tr>
															<td width="60%">
																<ps:select value="graceprdcty" id="gracePeriodicity_${_pageRef}" list="gracePeriodicity" listKey="code" listValue="descValue" name="islamicCalculatorEventMgmtCO.gracePeriodicity" 
																	onchange="onChangeFirstPaymentAfterPeriodicity()">	
																</ps:select>																			
															</td>
															<td width="40%">
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>		
									<td class="fldLabelView">
										<ps:label key="First_Payment_Date_key"  id="lbl_First_Payment_Date_${_pageRef}" 
										for="firstPaymentDate_${_pageRef}"/>
									</td>	
									<td>
										<psj:datepicker id="firstPaymentDate_${_pageRef}" name="islamicCalculatorEventMgmtCO.firstPaymentDate" 
										buttonImageOnly="true" onchange="validateOnChangeFirstPayDate()" />
									</td>		
								</tr>
							</table>	
							<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<td colspan="2" class="fldLabelView">
										<ps:label key="No_Of_Payments_key"  id="lbl_No_Of_Payments_${_pageRef}" 
										for="noOfPayments_${_pageRef}"/>
									</td>
									<td>
										<ps:textfield id="noOfPayments_${_pageRef}" name="islamicCalculatorEventMgmtCO.noOfPayments"
										mode="number" maxlength="6" onchange="validateOnChangeNoOfPayments()"
										/>		
									</td>
									<td colspan="2" class="fldLabelView">
										<ps:label key="No_of_Months_key"  id="lbl_No_of_Months_${_pageRef}" 
										for="noOfMonths_${_pageRef}"/>
									</td>
									<td>
										<ps:textfield id="noOfMonths_${_pageRef}" name="islamicCalculatorEventMgmtCO.noOfMonths" 
										 readonly="true" mode="number" maxlength="6"/>
									</td>		
									<td colspan="2" class="fldLabelView">
										<ps:label key="Pay_Every_key"  id="lbl_Pay_Every_${_pageRef}" for="paymPeriodNbr_${_pageRef}"/>
									</td>
									<td>
										<ps:textfield    name="islamicCalculatorEventMgmtCO.paymPeriodNbr" id="paymPeriodNbr_${_pageRef}"
										 onchange="validateOnChangePayEvery()" mode="number"/>
									</td>	
									<td colspan="2">
										<ps:select value="payevery" id="paymPeriodicity_${_pageRef}" list="paymPeriodicity" listKey="code" 
										listValue="descValue" name="islamicCalculatorEventMgmtCO.paymPeriodicity" onchange="validateOnChangePayEveryPeriodicity()"></ps:select>
									</td>
									<td class="fldLabelView">
										<ps:label key="At_key"  id="lbl_At_${_pageRef}" for="paymPeriodPos_${_pageRef}"/>
									</td>
									<td colspan="2">
										<ps:select value="payeverypos" id="paymPeriodPos_${_pageRef}" list="paymPeriodPos" listKey="code" listValue="descValue"
										 name="islamicCalculatorEventMgmtCO.paymPeriodPos"  onchange="validateOnChangePayEveryPeriodicity()">
										 </ps:select>
									</td>
									<td colspan="2" class="fldLabelView">
										<ps:label key="Amount_Per_Payment_key"  id="lbl_Amount_Per_Payment_${_pageRef}" for="amountPerPayment_${_pageRef}"/>
									</td>
									<td colspan="3">
										<ps:textfield id="amountPerPayment_${_pageRef}"  name="islamicCalculatorEventMgmtCO.amountPerPayment" 
											mode="number" nbFormat="#,###.##" maxlength="20" onchange="onChangeAmountPerPayment()"		
										/>
									</td>																															
								</tr>
							</table>		
							<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<td class="fldLabelView" colspan="2">
										<ps:label key="Rounding_Factor_key"  id="lbl_Rounding_Factor_${_pageRef}" for="roundingFactor_${_pageRef}"/>
									</td>
									<td colspan="3">
										<ps:select value="roundingf" id="roundingFactor_${_pageRef}" list="roundingFactor" listKey="code" listValue="descValue" 
											name="islamicCalculatorEventMgmtCO.roundingFactor">
										</ps:select>
									</td>
									<td></td>
									<td class="fldLabelView" colspan="2">
									<ps:label key="Pay_Residual_Amount_key"  id="lbl_Pay_Residual_Amount_${_pageRef}"/>	
									</td>
									<td></td>
									<td colspan="6">
										<ps:radio id="radPayResidualAmount_${_pageRef}" list="payResidualAmount"  
										cssClass="radioDown_%{_pageRef}" name="islamicCalculatorEventMgmtCO.payResAmt" 
										value="defaultPayResidualAmount" />
									</td>
									<td colspan="5"></td>
								</tr>								
							</table>
							<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<td class="fldLabelView" colspan="2">
										<ps:label key="Insurance_Charges_key"  id="lbl_Insurance_Charges_${_pageRef}" for="insuranceChargesAmount_${_pageRef}"/>
									</td>
									<td colspan="3">
										<ps:textfield id="insuranceChargesAmount_${_pageRef}"   mode="number" readonly="true" nbFormat="#,###.##"  />
									</td>				
									<td colspan="3">
										<ps:textfield id="chargeAmount_${_pageRef}"  name="islamicCalculatorEventMgmtCO.chargeAmount"   mode="number" readonly="true" nbFormat="#,###.##"  />
									</td>									
									<td colspan="3">
										<ps:textfield id="totalInsuranceAmount_${_pageRef}"    mode="number" readonly="true" nbFormat="#,###.##" />
									</td>	
									<td colspan="9"></td>																					
								</tr>								
							</table>
							<div id="dealChargesGridDiv_Id_${_pageRef}" class="collapsibleContainer collapsed"
									title="<ps:text name='Deal_Charges_key'/>">
							<ps:hidden id="DEALCHARGE_VAT_PERCENTAGE_IND_${_pageRef}" name="" value="P"></ps:hidden>
										<ps:url id="urlDealCharges" action="LoadIslamicCalcDealChargesGrid" namespace="/path/islamicCalculator" />
										<psjg:grid 
											id="dealChargesGridTbl_Id_${_pageRef}" 		caption="%{getText('Deal_Charges_key')}" 		dataType="json"
											pager="true" 								filter="false" 									editurl="#" 
											gridModel="gridModel"  						rowNum="5" 										rowList="5,10,15,20"
											viewrecords="true" 							navigator="true" 								height="110"
											navigatorRefresh="false" 					navigatorSearch="false"							hiddengrid="false"
											addfunc="addDealCharges" 					delfunc="deleteDealCharges"						autowidth="true"
											multiselect="false" 						multiboxonly="false"							pagerButtons="false"
											editinline="true"							altRows="true" 									shrinkToFit="false" 		
											navigatorEdit="false" 						onCompleteTopics="dealChargesAmountHeader"		navigatorAdd="true"
											navigatorDelete="true"						rownumbers="true" 								onEditInlineBeforeTopics = "editDealCharges"
										 >								
													
										<psjg:gridColumn name="CHARGES_CODE" title="%{getText('Code_key')}" index="CHARGES_CODE" colType="liveSearch" 
											editable="true" sortable="true" id="CHARGES_CODE"   mode="number"
											dataAction="${pageContext.request.contextPath}/pathdesktop/Charges_constructLookup" 
											resultList="" searchElement="CODE" paramList="" autoSearch="true"	
											params="iisDealChargesParamCO.chargeCode:CHARGES_CODE_lookuptxt 
											, iisDealChargesParamCO.classCode:lookuptxt_productClass_${_pageRef}
											, iisDealChargesParamCO.cifNo:lookuptxt_cifNo_${_pageRef}
											, iisDealChargesParamCO.dealCurrecny:lookuptxt_currencyCode_${_pageRef}
											, iisDealChargesParamCO.valueDate:startDate_${_pageRef}
											, iisDealChargesParamCO.maturityDate:maturityDate_${_pageRef}
											, iisDealChargesParamCO.dealAmount:financingAmount_${_pageRef}"											
											dependencySrc="${pageContext.request.contextPath}/path/iis/dealcharges/dealChargesMaint_dependancyByCharges"							 				
							 				dependency="iisDealChargesParamCO.chargeName:lsBriefNameeng,iisDealChargesParamCO.chargeCode:CHARGES_CODE_lookuptxt, iisDealChargesParamCO.accountCurrency:CR_ACC_CURRENCY,iisDealChargesParamCO.chargeType:CHARGE_TYPE"
							 				afterDepEvent="populateOnChangeDealChargesGridAmounts('CC')"/>
														
										<psjg:gridColumn name="lsBriefNameeng" title="%{getText('Name_key')}" index="lsBriefNameeng" colType="text" 
											editable="false" sortable="true" id="lsBriefNameeng" />
											
										<psjg:gridColumn name="CR_ACC_BRANCH" title="%{getText('branchKey')}" index="CR_ACC_BRANCH" colType="number" editable="true"
								            sortable="true" id="CR_ACC_BRANCH" 
								            dependencySrc="${pageContext.request.contextPath}/pathdesktop/BranchesDependencyAction_dependencyByBrIdWithExceptionMessage"
								            params="account.BRANCH_CODE:CR_ACC_BRANCH" 
								            dependency="account.BRANCH_CODE:CR_ACC_BRANCH,account.CURRENCY_CODE:CR_ACC_CURRENCY,account.GL_CODE:CR_ACC_GL,account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO,account.SL_NO:CR_ACC_SL_NO_lookuptxt" 
								            afterDepEvent="setSumofInsuranceCharges()"/>
								          
								          <psjg:gridColumn name="CR_ACC_CURRENCY" title="%{getText('Currency_key')}" index="CR_ACC_CURRENCY" colType="number" 
								                                            editable="true" sortable="true" id="CR_ACC_CURRENCY" 
								                                          params="account.BRANCH_CODE:CR_ACC_BRANCH,CURRENCY_CODE:CR_ACC_CURRENCY"
								                                            dependencySrc="${pageContext.request.contextPath}/pathdesktop/CurrencyDependencyAction_dependencyByCurrencyCode"
								                                            dependency="currency.CURRENCY_CODE:CR_ACC_CURRENCY,account.GL_CODE:CR_ACC_GL,account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO,account.SL_NO:CR_ACC_SL_NO_lookuptxt"
								                                         afterDepEvent="populateOnChangeDealChargesGridAmounts('CR')"/>
								           
								          <psjg:gridColumn name="CR_ACC_GL" title="%{getText('G/L_key')}" index="CR_ACC_GL" colType="number" editable="true" 
								           sortable="true" id="CR_ACC_GL" 
								           dependencySrc="${pageContext.request.contextPath}/pathdesktop/GLDependencyAction_returnGlByCode"
								           params="account.BRANCH_CODE:CR_ACC_BRANCH,account.CURRENCY_CODE:CR_ACC_CURRENCY,account.GL_CODE:CR_ACC_GL" 
								           dependency="account.GL_CODE:CR_ACC_GL,account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO,account.SL_NO:CR_ACC_SL_NO_lookuptxt" 
								           afterDepEvent="setSumofInsuranceCharges()"/>
								      
								                
								          <psjg:gridColumn name="CR_ACC_CIF_SUB_NO" title="%{getText('CIF_key')}" index="CR_ACC_CIF_SUB_NO" colType="number" 
								           editable="true" sortable="true" id="CR_ACC_CIF_SUB_NO"      
								           dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByCifIdWithExceptionMessage"
								           params="account.BRANCH_CODE:CR_ACC_BRANCH,account.CURRENCY_CODE:CR_ACC_CURRENCY,account.GL_CODE:CR_ACC_GL,account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO" 
								           dependency="account.CIF_SUB_NO:CR_ACC_CIF_SUB_NO,account.SL_NO:CR_ACC_SL_NO_lookuptxt" 
								           afterDepEvent="setSumofInsuranceCharges()"/>
							
														
										<psjg:gridColumn name="CR_ACC_SL_NO" title="%{getText('S/L_key')}" index="CR_ACC_SL_NO" colType="liveSearch" 
											editable="true" sortable="true" id="CR_ACC_SL_NO"  
											dataAction="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup"  
											searchElement="amfVO.SL_NO" paramList="" autoSearch="true"					
											editoptions="{dataEvents: [{ type: 'change', fn: function(e) { callSlCodeDependency('dealCharges'); } }],maxlength: '3'}"
											
											/>
										<%--TP#231436; Saheer.Naduthodi; 19/10/2014 --%>
										<psjg:gridColumn name="CHARGES_AMOUNT" title="%{getText('Deal_CY_key')}" index="CHARGES_AMOUNT" colType="number" editable="true"
											sortable="true" id="CHARGES_AMOUNT" 
											params="iisDealChargesCO.productClass:lookuptxt_productClass_${_pageRef},iisDealChargesCO.cifNo:lookuptxt_cifNo_${_pageRef},iisDealChargesCO.maturityDate:maturityDate_${_pageRef},iisDealChargesCO.valueDate:startDate_${_pageRef},iisDealChargesCO.currency:lookuptxt_currencyCode_${_pageRef},iisDealChargesCO.DownPaymentAmount:downPaymentAmount_${_pageRef},iisDealChargesCO.dealAmount:financingAmount_${_pageRef},iisDealChargesCO.trsDealChargesCO.CHARGES_CODE:CHARGES_CODE_lookuptxt,iisDealChargesCO.trsDealChargesCO.CR_ACC_CURRENCY:CR_ACC_CURRENCY,iisDealChargesCO.trsDealChargesCO.CHARGES_AMOUNT:CHARGES_AMOUNT,iisDealChargesCO.allowEdit:ALLOW_EDIT"
							 				dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeDealChargesGridAmounts?iisDealChargesCO.callType=CA"
							 				dependency="trsDealChargesCO.CHARGES_AMOUNT:CHARGES_AMOUNT,trsDealChargesCO.CHARGES_AMT_FC:CHARGES_AMT_FC,trsDealChargesCO.CHARGES_AMT_CV:CHARGES_AMT_CV,trsDealChargesCO.insuranceAmount:insuranceAmount,trsDealChargesCO.chargeAmtToInclInPrinciple:chargeAmtToInclInPrinciple"
							 				afterDepEvent="setSumofInsuranceCharges()" formatter="currencyFmatter" formatCol="dealChargesFormat"
							 				nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}"/>
										 	
										<psjg:gridColumn name="CHARGES_AMT_FC" title="%{getText('Charge_CY_key')}" index="CHARGES_AMT_FC" colType="number" 
											editable="true" sortable="true" id="CHARGES_AMT_FC" 
											params="iisDealChargesCO.productClass:lookuptxt_productClass_${_pageRef},iisDealChargesCO.cifNo:lookuptxt_cifNo_${_pageRef},iisDealChargesCO.maturityDate:maturityDate_${_pageRef},iisDealChargesCO.valueDate:startDate_${_pageRef},iisDealChargesCO.currency:lookuptxt_currencyCode_${_pageRef},iisDealChargesCO.DownPaymentAmount:downPaymentAmount_${_pageRef},iisDealChargesCO.dealAmount:financingAmount_${_pageRef},iisDealChargesCO.trsDealChargesCO.CHARGES_CODE:CHARGES_CODE_lookuptxt,iisDealChargesCO.trsDealChargesCO.CR_ACC_CURRENCY:CR_ACC_CURRENCY,iisDealChargesCO.trsDealChargesCO.CHARGES_AMT_FC:CHARGES_AMT_FC,iisDealChargesCO.trsDealChargesCO.CHARGES_AMOUNT:CHARGES_AMOUNT"
							 				dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeDealChargesGridAmounts?iisDealChargesCO.callType=CS"
							 				dependency="trsDealChargesCO.CHARGES_AMOUNT:CHARGES_AMOUNT,trsDealChargesCO.CHARGES_AMT_FC:CHARGES_AMT_FC,trsDealChargesCO.CHARGES_AMT_CV:CHARGES_AMT_CV,trsDealChargesCO.insuranceAmount:insuranceAmount,trsDealChargesCO.chargeAmtToInclInPrinciple:chargeAmtToInclInPrinciple"
											afterDepEvent="setSumofInsuranceCharges()" formatter="currencyFmatter" formatCol="dealChargesFormat"
											nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}"/>
											
										<psjg:gridColumn name="CHARGES_AMT_CV" title="%{getText('Base_CY_key')}" index="baseCy" colType="number" editable="true" 
											sortable="true" id="CHARGES_AMOUNT" formatter="currencyFmatter" formatCol="dealChargesFormat"
											nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}"/>
																		
										<psjg:gridColumn name="PROFIT_ON_CHARGES" title="%{getText('Profit_On_Charges_key')}" index="PROFIT_ON_CHARGES" colType="checkbox" 
											editoptions="{value:'1:0'}" editable="true" sortable="true" edittype="checkbox" formatter="checkbox" formatoptions="{disabled : true}" 
										  id="profitOnCharge" />
										  
										<psjg:gridColumn name="CHARGE_TYPE" title="%{getText('Include_In_Principal_key')}" index="includeInPrincipal" colType="checkbox" 
											editoptions="{value:'Y:N',dataEvents: [{ type: 'click', fn: function(e) { onChangeIncludeInPrinciple(e) } }]}" editable="true" sortable="true" edittype="checkbox" formatter="checkbox" formatoptions="{disabled : true}" 
										  id="includeInPrincipal" />
										
										<psjg:gridColumn name="CREDIT_TO_SD_ACCOUNT_YN" title="%{getText('credit_to_sd_account_yn_key')}" index="CREDIT_TO_SD_ACCOUNT_YN" colType="checkbox" editoptions="{value:'Y:N'}" editable="false" sortable="true" edittype="checkbox" formatter="checkbox"
            								formatoptions="{disabled : true}" id="CREDIT_TO_SD_ACCOUNT_YN" />
            
										<psjg:gridColumn name="COLLECT_CHARGE_AT_DEAL_YN" title="%{getText('Collect_Chgs_On_Deal_Approve_key')}" index="COLLECT_CHARGE_AT_DEAL_YN" colType="checkbox" 
											editoptions="{value:'Y:N',dataEvents: [{ type: 'click', fn: function(e) {onChangeCollectChgsOnDealApprove(e) } }]}" editable="true" sortable="true" edittype="checkbox" formatter="checkbox" formatoptions="{disabled : true}" 
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
										index="VAT_CODE" colType="liveSearch" editable="true" sortable="true"
										id="VAT_CODE" mode="number"
										dataAction="${pageContext.request.contextPath}/pathdesktop/VatCodeLookup_constructLookup"
										paramList="vatCodeSC.PERCENTAGE_IND:DEALCHARGE_VAT_PERCENTAGE_IND_${_pageRef}" 
										resultList="" searchElement="VAT_CODE" params="vatCodeSC.vatCode:VAT_CODE_lookuptxt,vatCodeSC.PERCENTAGE_IND:DEALCHARGE_VAT_PERCENTAGE_IND_${_pageRef}" 
										autoSearch="true"
										dependencySrc="${pageContext.request.contextPath}/pathdesktop/VatCodeDependencyAction_dependancyByVatCode"							 				
										dependency="vatCodeVO.VAT_CODE:VAT_CODE_lookuptxt,vatCodeVO.BRIEF_NAME_ENG:VAT_BRIEF_NAME_ENG"
										afterDepEvent=""	
										/>
										
										    <psjg:gridColumn name="VAT_BRIEF_NAME_ENG"
										     title="%{getText('vat_desc_key')}" index="VAT_BRIEF_NAME_ENG"
										     colType="text" editable="false" sortable="false"
										     id="VAT_BRIEF_NAME_ENG" />
     
										<psjg:gridColumn name="CHARGE_AMT_PER_INST_YN" title="%{getText('Collect_Chgs_Per_Inst._OnP.I_Approve_key')}" index="CHARGE_AMT_PER_INST_YN" colType="checkbox" 
											editoptions="{value:'Y:N',dataEvents: [{ type: 'click', fn: function(e) { onChangeCollectChgsperInstallmentOnPI(e) } }]}" editable="true" sortable="true" edittype="checkbox" formatter="checkbox" formatoptions="{disabled : true}" 
										  id="CHARGE_AMT_PER_INST_YN" />
									
																				  
										<psjg:gridColumn name="insuranceAmount" title="%{getText('Insurance_Amount_key')}" index="insuranceAmount" colType="number" editable="false" hidden="true" formatter="currencyFmatter" formatCol="dealChargesFormat"
											sortable="true" id="insuranceAmount" nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}"/>
											
										<psjg:gridColumn name="chargeAmtToInclInPrinciple" title="%{getText('ChargeAmtToInclInPrinciple_key')}" index="chargeAmtToInclInPrinciple" colType="number" editable="false" hidden="true" formatter="currencyFmatter" formatCol="dealChargesFormat"
											sortable="true" id="chargeAmtToInclInPrinciple" nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}"/>	
										
										<psjg:gridColumn name="ALLOW_EDIT" title="%{getText('Allow_Edit_key')}" index="ALLOW_EDIT" colType="text"  hidden="true" 
										sortable="true" id="ALLOW_EDIT" />
										
										<psjg:gridColumn title="" name="allowToEditVatCode" index="allowToEditVatCode" id="allowToEditVatCode"
										colType="text" hidden="true" />	
											
										<psjg:gridColumn title="" name="dealChargesFormat" colType="number" hidden="true"/>	  
									</psjg:grid>										
							</div>
							<div id="repaymentgridDiv_Id_${_pageRef}" align="center">
										<ps:hidden id = "repaymentAmountSum_${_pageRef}" ></ps:hidden>
										<psjg:grid 
											id="repaymentgridTbl_Id_${_pageRef}" 		caption="%{getText('Repayment_Criteria_key')}" 	dataType="json"
											pager="true" 								filter="false" 									editurl="#"
											gridModel="gridModel"  						rowNum="5" 										rowList="5,10,15,20"
											viewrecords="true" 							navigator="true" 								height="110"
											navigatorRefresh="false" 					navigatorSearch="false"							hiddengrid="true"
											addfunc="addRepaymentCriteria" 				delfunc="deleteRepaymentCriteria"
											multiselect="false" 						multiboxonly="false"							pagerButtons="false"
											editinline="true"							altRows="true" 									shrinkToFit="false" 		
											navigatorEdit="false" 						onCompleteTopics=""		onEditInlineBeforeTopics = "editRepaymentCriteria"
											navigatorAdd="true"						navigatorDelete="true"
										 >								
											                              							
											
														
										<psjg:gridColumn name="FROM_DATE" 	title="%{getText('From_Date_key')}" index="FROM_DATE" colType="date" 
							 					editable="true" sortable="true" id="FROM_DATE_${_pageRef}" 
							 					editoptions="{dataEvents: [{ type: 'change', fn: function(e) { populateOnChangeRepaymentCriteriaFromDate(e); } }]}"
							 					/>
														
										<psjg:gridColumn name="TO_DATE" 	title="%{getText('To_Date_key')}" 	index="TO_DATE" colType="date" 
												editable="true" sortable="true" id="TO_DATE_${_pageRef}"
												editoptions="{dataEvents: [{ type: 'change', fn: function(e) { populateOnChangeRepaymentCriteriaToDate(); } }]}"
												 />
		
										<psjg:gridColumn name="PAYM_PERIOD_NBR" title="%{getText('Periodicity_Number_key')}" index="PAYM_PERIOD_NBR" 
												colType="number" editable="true" sortable="true" id="PAYM_PERIOD_NBR_${_pageRef}" 
												dependency="islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR:PAYM_PERIOD_NBR,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT:CAPITAL_AMT,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS:NO_OF_PAYMENTS"
							 					dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeRepaymentCriteriaPeriodicityNumber"
							 					params="islamicCalculatorEventMgmtCO.startDate:startDate_${_pageRef},islamicCalculatorEventMgmtCO.financingAmount:financingAmount_${_pageRef},islamicCalculatorEventMgmtCO.gracePeriod:gracePeriod_${_pageRef},islamicCalculatorEventMgmtCO.gracePeriodicity:gracePeriodicity_${_pageRef},islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYMENT_TYPE:PAYMENT_TYPE,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_POS:PAYM_PERIOD_POS,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIODICITY:PAYM_PERIODICITY,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE:FROM_DATE,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE:TO_DATE,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT:CAPITAL_AMT,islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR:PAYM_PERIOD_NBR,islamicCalculatorEventMgmtCO.sumOfCapitalAmtRepayment:repaymentAmountSum_${_pageRef},islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS:NO_OF_PAYMENTS" 
												afterDepEvent="resetRepaymentSum()"
												/>
											
										<psjg:gridColumn name="PAYM_PERIODICITY"  title="%{getText('Periodicity_key')}" index="PAYM_PERIODICITY"  formatter="select"
												id="PAYM_PERIODICITY_${_pageRef}" colType="select" editable="true" sortable="true"  edittype="select" 
												editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculator_loadPaymPeriodicity','paymPeriodicity', 'code', 'descValue');}
												,dataEvents: [{ type: 'change', fn: function(e) { onChangePeriodicity(e) } }]}" 
												
												/>
						
											
										<psjg:gridColumn name="PAYM_PERIOD_POS" title="%{getText('At_key')}" index="PAYM_PERIOD_POS" 
												colType="select"   formatter="select" editable="true" sortable="true" id="PAYM_PERIOD_POS_${_pageRef}"  edittype="select" 
												editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculator_loadPaymPeriodPosition','paymPeriodPos', 'code', 'descValue');}
												,dataEvents: [{ type: 'change', fn: function(e) { onChangePeriodicityPosition(e) } }]}" 
											
												/>
												
										<psjg:gridColumn name="PAYM_DAY" title="%{getText('on_key')}" index="PAYM_DAY" colType="number" editable="true" 
												sortable="true" id="PAYM_DAY" editoptions="{dataEvents: [{ type: 'change', fn: function(e) { onChangeOnPayDay(); } }]}" 	 
										/>
											
										<psjg:gridColumn name="NO_OF_PAYMENTS" title="%{getText('No_Of_Payments_key')}" index="NO_OF_PAYMENTS" colType="number" 
												editable="true" sortable="true" id="NO_OF_PAYMENTS_${_pageRef}" 
												editoptions="{dataEvents: [{ type: 'change', fn: function(e) { populateOnChangeRepaymentCriteriaNoOfPayments(e); } }]}"
													
												/>
											
										<psjg:gridColumn name="PAYMENT_TYPE" title="%{getText('Payment_Type_key')}" index="PAYMENT_TYPE" 
												id="PAYMENT_TYPE_${_pageRef}" colType="select"  formatter="select" editable="true" sortable="true" edittype="select" 
												editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculator_loadPaymentType','paymentType', 'code', 'descValue');}
												,dataEvents: [{ type: 'change', fn: function(e) { onChangePeriodicityPaymentType(e) } }]}"  
												 />
																	
										<psjg:gridColumn name="CAPITAL_AMT" title="%{getText('Amount_key')}" index="CAPITAL_AMT" colType="number" 
												nbFormat="${islamicCalculatorEventMgmtCO.cyFormat}" editable="true" sortable="true" 
												id="CAPITAL_AMT_${_pageRef}" 
												editoptions="{dataEvents: [{ type: 'change', fn: function(e) { onChangeCapitalAmount(); } }]}" 	 />
												
										<psjg:gridColumn name="ACC_BR" title="%{getText('branchKey')}" index="ACC_BR" colType="number" editable="true"
										 	sortable="true" id="ACC_BR" 
										 	dependencySrc="${pageContext.request.contextPath}/pathdesktop/BranchesDependencyAction_dependencyByBrId"
										 	params="account.BRANCH_CODE:ACC_BR" 
										 	dependency="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:ACC_CY,account.GL_CODE:ACC_GL,account.CIF_SUB_NO:ACC_CIF,account.SL_NO:ACC_SL_lookuptxt" 
										 />
										
										<psjg:gridColumn name="ACC_CY" title="%{getText('Currency_key')}" index="ACC_CY" colType="number" 
                                            editable="true" sortable="true" id="ACC_CY" 
                                          	params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:ACC_CY"
                                            dependencySrc="${pageContext.request.contextPath}/pathdesktop/CurrencyDependencyAction_dependencyByCYId"
                                            dependency="account.CURRENCY_CODE:ACC_CY,account.GL_CODE:ACC_GL,account.CIF_SUB_NO:ACC_CIF,account.SL_NO:ACC_SL_lookuptxt"
                                         />
										
										<psjg:gridColumn name="ACC_GL" title="%{getText('G/L_key')}" index="ACC_GL" colType="number" editable="true" 
											sortable="true" id="ACC_GL" 
											dependencySrc="${pageContext.request.contextPath}/pathdesktop/GLDependencyAction_dependencyByGLId"
											params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:ACC_CY,account.GL_CODE:ACC_GL" 
											dependency="account.GL_CODE:ACC_GL,account.CIF_SUB_NO:ACC_CIF,account.SL_NO:ACC_SL_lookuptxt" 
										/>
										<psjg:gridColumn name="ACC_CIF" title="%{getText('CIF_key')}" index="ACC_CIF" colType="number" 
											editable="true" sortable="true" id="ACC_CIF" 					
											dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByCifId"
											params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:ACC_CY,account.GL_CODE:ACC_GL,account.CIF_SUB_NO:ACC_CIF" 
											dependency="account.CIF_SUB_NO:ACC_CIF,account.SL_NO:ACC_SL_lookuptxt" 
										/>
										<psjg:gridColumn name="ACC_SL" title="%{getText('S/L_key')}" index="ACC_SL" colType="liveSearch" 
											editable="true" sortable="true" id="ACC_SL"  
											dataAction="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup"  
											searchElement="amfVO.SL_NO" paramList="" autoSearch="true"					
											editoptions="{dataEvents: [{ type: 'change', fn: function(e) { callSlCodeDependency('repayment'); } }],maxlength: '3'}"
										/>	
										<psjg:gridColumn name="ACC_NAME" title="%{getText('Account_Name_key')}" index="ACC_NAME" colType="text" 
											editable="false" sortable="true" id="ACC_NAME" 
										/>
										<psjg:gridColumn name="AUTO_CREATE_SETTLEMENT_YN"  title="%{getText('Automatic_Settlement_key')}" index="AUTO_CREATE_SETTLEMENT_YN"  
										formatter="select"	id="AUTO_CREATE_SETTLEMENT_YN_${_pageRef}" colType="select" editable="true" sortable="true"  edittype="select" 
										editoptions="{value:function(){return loadCombo('${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculator_loadAutoCreateSettlement','autoCreateSettlement', 'code', 'descValue');}
										,dataEvents: [{ type: 'change', fn: function(e) { onChangeAutoCreateSettlementYN(e) } }]}" 
										/>
										
										<psjg:gridColumn name="COVERING_ACC_BR" title="%{getText('branchKey')}" index="COVERING_ACC_BR" colType="number" editable="true"
							            sortable="true" id="COVERING_ACC_BR" 
							            dependencySrc="${pageContext.request.contextPath}/pathdesktop/BranchesDependencyAction_dependencyByBrIdWithExceptionMessage"
							            params="account.BRANCH_CODE:COVERING_ACC_BR" 
							            dependency="account.BRANCH_CODE:COVERING_ACC_BR,account.CURRENCY_CODE:COVERING_ACC_CY,account.GL_CODE:COVERING_ACC_GL,account.CIF_SUB_NO:COVERING_ACC_CIF,account.SL_NO:COVERING_ACC_SL_lookuptxt" 
							           />
							          
							          <psjg:gridColumn name="COVERING_ACC_CY" title="%{getText('Currency_key')}" index="COVERING_ACC_CY" colType="number" 
							                                            editable="true" sortable="true" id="COVERING_ACC_CY" 
							                                           params="account.BRANCH_CODE:ACC_BR,CURRENCY_CODE:COVERING_ACC_CY"
							                                            dependencySrc="${pageContext.request.contextPath}/pathdesktop/CurrencyDependencyAction_dependencyByCurrencyCode"
							                                            dependency="currency.CURRENCY_CODE:COVERING_ACC_CY,account.GL_CODE:COVERING_ACC_GL,account.CIF_SUB_NO:COVERING_ACC_CIF,account.SL_NO:COVERING_ACC_SL_lookuptxt"
							                                         />
							          
							          <psjg:gridColumn name="COVERING_ACC_GL" title="%{getText('G/L_key')}" index="COVERING_ACC_GL" colType="number" editable="true" 
							           sortable="true" id="COVERING_ACC_GL" 
							           dependencySrc="${pageContext.request.contextPath}/pathdesktop/GLDependencyAction_returnGlByCode"
							           params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:COVERING_ACC_CY,account.GL_CODE:COVERING_ACC_GL" 
							           dependency="account.GL_CODE:COVERING_ACC_GL,account.CIF_SUB_NO:COVERING_ACC_CIF,account.SL_NO:COVERING_ACC_SL_lookuptxt" 
							          />
							          <psjg:gridColumn name="COVERING_ACC_CIF" title="%{getText('CIF_key')}" index="COVERING_ACC_CIF" colType="number" 
							           editable="true" sortable="true" id="COVERING_ACC_CIF"      
							           dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByCifIdWithExceptionMessage"
							           params="account.BRANCH_CODE:ACC_BR,account.CURRENCY_CODE:COVERING_ACC_CY,account.GL_CODE:COVERING_ACC_GL,account.CIF_SUB_NO:COVERING_ACC_CIF" 
							           dependency="account.SL_NO:COVERING_ACC_SL_lookuptxt" 
							          />
										<psjg:gridColumn name="COVERING_ACC_SL" title="%{getText('S/L_key')}" index="COVERING_ACC_SL" colType="liveSearch" 
											editable="true" sortable="true" id="COVERING_ACC_SL"  
											dataAction="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup"  
											searchElement="amfVO.SL_NO" paramList="" autoSearch="true"					
											editoptions="{dataEvents: [{ type: 'change', fn: function(e) { callSlCodeDependency('repaymentCoveringSl'); } }],maxlength: '3'}"
										/>	
										<psjg:gridColumn name="COVERING_ACC_NAME" title="%{getText('Account_Name_key')}" index="COVERING_ACC_NAME" colType="text" 
											editable="true" sortable="true" id="COVERING_ACC_NAME" 
										/>										
									</psjg:grid>
							</div>										
									
						</div><%-- Repayment Details Section End--%>
						<%-- BB130272 Modification;Ravikant.Singh;19/05/2015 --%>
                   <ps:if test='%{islamicCalculatorEventMgmtCO.showCustGuarLiability}'>
                   <div id="iisCalculatorCustGuarLiabilityDiv_Id_${_pageRef}" class="collapsibleContainer collapsed"
                                     title="<ps:text name='CustOrGuar_Liability_key'/>">
                                           <ps:url id="urlIisCalculatorCustGuarLiabilityGrid_Id_${_pageRef}" escapeAmp="false" action="InvestmentDealCustGuarLiabilityGrid_loadCustGuarLiability" 
                                           namespace="/path/iis/investmentDeals"/>
                                           <psjg:grid 
                                                 id="iisCalculatorCustGuarLiabilityGridTbl_Id_${_pageRef}" dataType="json"
                                                 pager="true"                                                filter="false"                                                    editurl="#" 
                                                 href="%{urlIisCalculatorCustGuarLiabilityGrid_Id_${_pageRef}}" 
                                                 gridModel="gridModel"                                 rowNum="5"                                                       rowList="5,10,15,20"
                                                 viewrecords="true"                                          navigator="true"                                            height="110"
                                                 navigatorRefresh="false"                              navigatorSearch="false"                                     hiddengrid="false"
                                                 addfunc="addDealCharges"                              delfunc="deleteDealCharges"                                 autowidth="false"
                                                 multiselect="false"                                   multiboxonly="false"                                        pagerButtons="false"
                                                 editinline="true"                                     altRows="true"                                                       shrinkToFit="false"             
                                                 navigatorEdit="false"                                 onCompleteTopics=""           navigatorAdd="true"
                                                 navigatorDelete="true"                                rownumbers="true"                                                 onEditInlineBeforeTopics = ""
                                           >                                              
                                           <psjg:gridColumn 
                                                 id="COMP_CODE"
                                                 index="COMP_CODE"
                                                 name="trsdealCustGuarLiabilitiesVO.COMP_CODE"
                                                 title=""
                                                 colType="number"
                                                 width="1"      
                                                 editable="false"  sortable="false"  search="false"    
                                                 hidden="true" 
                                           />
                                           <psjg:gridColumn 
                                                 id="BRANCH_CODE"
                                                 index="BRANCH_CODE"
                                                 name="trsdealCustGuarLiabilitiesVO.BRANCH_CODE"
                                                 title=""
                                                 colType="number"
                                                 width="1"      
                                                 editable="false"  sortable="false"  search="false"    
                                                 hidden="true" 
                                           />
                                           <psjg:gridColumn 
                                                 id="SERIAL_NO"
                                                 index="SERIAL_NO"
                                                 name="trsdealCustGuarLiabilitiesVO.SERIAL_NO"
                                                 title=""
                                                 colType="number"
                                                 width="1"      
                                                 editable="false"  sortable="false"  search="false"    
                                                 hidden="true" 
                                           />
                                           <psjg:gridColumn 
                                                 id="LINE_NO"
                                                 index="LINE_NO"
                                                 name="trsdealCustGuarLiabilitiesVO.LINE_NO"
                                                 title=""
                                                 colType="number"
                                                 width="1"      
                                                 editable="false"  sortable="false"  search="false"    
                                                 hidden="true" 
                                           />
                                           <psjg:gridColumn 
                                                 id="LINE_DESCRIPTION_ENG"
                                                 index="LINE_DESCRIPTION_ENG"
                                                 name="trsdealCustGuarLiabilitiesVO.LINE_DESCRIPTION_ENG"
                                                 title="%{getText('Previous_Deals_key')}"
                                                 colType="text"
                                                 width="150" 
                                                 editable="false"  sortable="false"  search="false"    
                                                 hidden="false" 
                                           />
                                           <psjg:gridColumn 
                                                 id="LINE_DESCRIPTION_ARAB"
                                                 index="LINE_DESCRIPTION_ARAB"
                                                 name="trsdealCustGuarLiabilitiesVO.LINE_DESCRIPTION_ARAB"
                                                 title="%{getText('Previous_Deals_Arb_key')}"
                                                 colType="text"
                                                 width="150" 
                                                 editable="false"  sortable="false"  search="false"    
                                                 hidden="false" 
                                           />
                                           <psjg:gridColumn 
                                                 id="TOTAL_FINANCED_AMT"
                                                 index="TOTAL_FINANCED_AMT"
                                                 name="trsdealCustGuarLiabilitiesVO.TOTAL_FINANCED_AMT"
                                                 title="%{getText('Remaining_Amt_key')}"
                                                 colType="number"
                                                 width="125" nbFormat="#,###.000" minValue="0.00"
                                                 editoptions="{maxlength:'17'}" 
                                                 onchange=""
                                                 onblur=""
                                                 editable="true"   sortable="false"  search="false"
                                                 hidden="false" 
                                           />
                                           <psjg:gridColumn 
                                                 id="INSTALLMENT_AMOUNT"
                                                 index="INSTALLMENT_AMOUNT"
                                                 name="trsdealCustGuarLiabilitiesVO.INSTALLMENT_AMOUNT"
                                                 title="%{getText('Total_installment_key')}"
                                                 colType="number"  nbFormat="#,###.000"
                                                 width="125" 
                                                 editoptions="{maxlength:'17'}" minValue="0.00"
                                                 editable="true"   sortable="false"  search="false"    
                                                 hidden="false" 
                                           />
                                           </psjg:grid>                                                            
                         </div>
                         </ps:if>       
						<div class="collapsibleContainer"title="<ps:text name="VAT_key"/>" id="vatSection_${_pageRef}"><%-- Vat Details Section Starts--%>
							<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<td colspan="4">
										<ps:checkbox name="islamicCalculatorEventMgmtCO.vatApplicable" id = "vatApplicable_${_pageRef}" key="VAT_Applicable_key" 
										onchange="onChangeVatApplicable();" valOpt="Y:N" cssClass="ui-widget-content checkboxheight" />
									</td>			
									<td colspan="5">
										<ps:checkbox name="islamicCalculatorEventMgmtCO.includeVatinInstallment" id = "vatInstallment_${_pageRef}" fieldValue="true"
										 onchange="onChangeVatInstallment()" cssClass="ui-widget-content checkboxheight"  valOpt="Y:N"
										 key="Installment_Amount_+_VAT_Amount_key" />
									</td>								
									<%--TP#226010;Arun.R.Variyath;26/09/2014			--%>
									<td class="fldLabelView" colspan="2">
										<ps:label key="VAT_Code_key"  id="lbl_VAT_Code_${_pageRef}" for="lookuptxt_vatCode_${_pageRef}"/>
									</td>
									<td colspan="2">
										<psj:livesearch actionName="${pageContext.request.contextPath}/pathdesktop/VatCodeLookup_constructLookup"	
											id="vatCode_${_pageRef}" name="islamicCalculatorEventMgmtCO.vatCode"
											searchElement="VAT_CODE" autoSearch="false" mode="number"
											resultList=""	maxlength="6"	
							 				dependencySrc="${pageContext.request.contextPath}/pathdesktop/VatCodeDependencyAction_dependancyByVatCode"
							 				parameter="vatCodeSC.vatCode:lookuptxt_vatCode_${_pageRef}"
						                    dependency="lookuptxt_vatCode_${_pageRef}:vatCodeVO.VAT_CODE,vatDesc_${_pageRef}:vatCodeVO.BRIEF_NAME_ENG"
							 				afterDepEvent="onChangeVatCode();">
										</psj:livesearch>											
															
									</td>		
									<td colspan="2">
										<ps:textfield id = "vatDesc_${_pageRef}" name="islamicCalculatorEventMgmtCO.vatDesc" readonly="true"/>
									</td>			
									<td class="fldLabelView" colspan="2">
										<ps:label key="VAT_PERCENTAGE_SYM_key"  id="lbl_VAT_Percentage_${_pageRef}" for="vatPercentage_${_pageRef}"/>
									</td>
									<td>
										<ps:textfield id="vatPercentage_${_pageRef}" name="islamicCalculatorEventMgmtCO.vatPercentage" 
										mode="number" nbFormat="#,###.##" maxlength="20"/>
									</td>
								</tr>
							</table>							
						</div><%-- Vat Details Section End--%>
						
						<div  id="baloonpaymentdetailsdiv_${_pageRef}" class="collapsibleContainer" title="<ps:text name="BALLOON_PAYMENT_DETAILS_key"/>"><%-- Balloon Details Section Starts--%>
							<table width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<ps:set var="hideBalloons" value="%{'display:none'}"/>
									<td class="fldLabelView" colspan="2">
										<ps:label key="Number_of_Balloon_Payments_key"  id="lbl_baloonPaymentNo_${_pageRef}" for="baloonPaymentNo_${_pageRef}"/>
									</td>
									
									<td colspan="1">
										<ps:textfield id="baloonPaymentNo_${_pageRef}" name="islamicCalculatorEventMgmtCO.noOfBaloonPayments"
											mode="number"  onchange="onChangeNoOfBalloons();"	maxValue="999"	maxlength="3"									
										/>
									</td>
									<td></td>
									<td class="fldLabelView" colspan="2">
										<ps:label key="Balloon_percentage_key"  id="lbl_baloonPercentage_${_pageRef}" for="baloonPercentage_${_pageRef}" cssStyle="%{hideBalloons}"/>
									</td>
									<td colspan="1">
										<ps:textfield id="baloonPercentage_${_pageRef}" name="islamicCalculatorEventMgmtCO.baloonPercentage"										
											mode="number" nbFormat="#,###.###" maxlength="6" onchange="onChangeBalloonPercentage();" cssStyle="%{hideBalloons}"
										/>
									</td>
									<td></td>
									<td class="fldLabelView" colspan="2">
										<ps:label key="Balln_Amt_key"  id="lbl_baloonAmount_${_pageRef}" for="baloonAmount_${_pageRef}" cssStyle="%{hideBalloons}"/>
									</td>
									<td colspan="3">
										<ps:textfield id="baloonAmount_${_pageRef}" name="islamicCalculatorEventMgmtCO.baloonAmount" mode="number" nbFormat="#,###.##" maxlength="20"
										 onchange="onChangeBalloonAmount();" cssStyle="%{hideBalloons}"/>
									</td>								
								</tr>
							</table>
							<table width="100%" border="0" style="" class="headerPortionContent ui-widget-content">
								<tr>
									<td>
										<psjg:grid 
											id="balloonPaymentGridTbl_Id_${_pageRef}" 	caption="%{getText('Balloon_Details_key')}" 	dataType="json"
											pager="true"								filter="false" 									editurl="#"                                   								
											viewrecords="true" 							navigator="true" 								height="110"
											navigatorRefresh="false" 					navigatorSearch="false"							hiddengrid="true"
											addfunc="" 									editfunc=""										delfunc=""
											multiselect="false" 						multiboxonly="false"							pagerButtons="false"
											editinline="true"							altRows="true" 									shrinkToFit="true" 		
											navigatorEdit="false" 						footerrow="true"								userDataOnFooter="true" 
											gridModel="" 								navigatorAdd="false"							navigatorDelete="false">						 		
											
											<psjg:gridColumn name="balloonNo"
												title="%{getText('Balloon_No_key')}" index="balloonNo" 
												colType="number" editable="false" sortable="true" id="balloonNo" />	
																								
											<psjg:gridColumn name="balloonDate"
												title="%{getText('Payment_Date_key')}" index="balloonDate" colType="date" 
												 editable="true" sortable="true" id="balloonDate"
												 editoptions="{dataEvents: [{ type: 'change', fn: function(e) { validateDateForBalloonDetails(e); } }]}"
												/>
											<psjg:gridColumn name="balloonAmount" 
												title="%{getText('Balloon_Amount_key')}" index="balloonAmount"  formatter="currencyFmatter" 
												colType="number" editable="true" sortable="true" id="balloonAmount"  formatCol="baloonAmtFormat"
												editoptions="{dataEvents: [{ type: 'change', fn: function(e) { validateAmtForBalloonDetails(e); } }]}" 				
												
											/>	
											<psjg:gridColumn title="" name="baloonAmtFormat" colType="number" hidden="true"/>				
										</psjg:grid>	
										
									</td>							
								</tr>
							</table>
						</div><%-- Balloon Details Section End--%>
						<div id="resultsetdiv_${_pageRef}" class="collapsibleContainer" title="<ps:text name="RESULT_SET_key"/>"><%-- Result Section Starts--%>
							<table id="resultSetTable_${_pageRef}" width="100%" border="0" style="padding:0 10px;" class="headerPortionContent ui-widget-content">
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
									<td class="fldLabelView" colspan="2">
										<ps:label key="Remaining_Amount_key"  id="lbl_Remaining_Amount_${_pageRef}" for="remainingAmount_${_pageRef}"/>
									</td>
									<td colspan="3">
										<ps:textfield id="remainingAmount_${_pageRef}" name="calculatorCO.outRemainingAmount"
										 mode="number" readonly="true" nbFormat="#,###.##" maxValue="99999999999999999999"/>
									</td>	
									<td class="fldLabelView" colspan="2">
										<ps:label key="Sale_Amount_key"  id="lbl_Sale_Amount_${_pageRef}" for="saleAmount_${_pageRef}"/>
									</td>
									<td colspan="3">
										<ps:textfield id="saleAmount_${_pageRef}" name="calculatorCO.outSaleAmount" 
										mode="number" readonly="true" nbFormat="#,###.##" maxValue="99999999999999999999"/>
									</td>																	
									<td class="fldLabelView" colspan="2">
										<ps:label key="Profit_key"  id="lbl_Profit_${_pageRef}" for="profit_${_pageRef}"/>
									</td>
									<td colspan="3">
										<ps:textfield id="profit_${_pageRef}" name="calculatorCO.outProfitAmount" 
										mode="number" readonly="true" nbFormat="#,###.##" maxValue="99999999999999999999"/>
									</td>																																										
								</tr>
								<tr>
									<td class="fldLabelView" colspan="2">
										<ps:label key="Amount_Per_Payment_key"  id="lbl_Amount_Per_Payment_${_pageRef}" for="amountPerPaymentResult_${_pageRef}"/>
									</td>
									<td colspan="3">
										<ps:textfield id="amountPerPaymentResult_${_pageRef}" name="calculatorCO.outAmountPerPayment" 
										mode="number"  readonly="true" nbFormat="#,###.##" maxValue="99999999999999999999"/>
									</td>																																										
									<td class="fldLabelView" colspan="2">
										<ps:label key="XIRR_key"  id="lbl_XIRR_${_pageRef}" for="xirr_${_pageRef}"/>
									</td>
									<td colspan="3">
										<ps:textfield id="xirr_${_pageRef}" name="calculatorCO.xirrOut" 
										mode="number" readonly="true"  nbFormat="#,###.##" maxValue="99999.999999"/>
									</td>																																																		
								</tr>
							</table>							
						</div><%-- Result Section End--%>
					</div>
					<pt:toolBar  id="fomToolbar_${_pageRef}"  > 
  							<psj:submit id="calculateBtn_${_pageRef}" button="true"  buttonIcon="ui-icon-calculator" >
                                <ps:label key="Calculate_key"/>
                            </psj:submit>        
    						<psj:submit id="resetBtn_${_pageRef}" button="true" type="button" buttonIcon="ui-icon-refresh" onclick="resetCalculatorPage();">
                                <ps:label key="Reset_key"/>
                            </psj:submit>  
                            <psj:submit id="printBtn_${_pageRef}" button="true"  type="button" buttonIcon="ui-icon-print" onclick="printCalculateScreen();">
                                <ps:label key="btn.print"/>
                            </psj:submit>  
                           
                            
                           
  				</pt:toolBar>	
					       				
	       		</ps:form>	
	       	</div>
			<div id = "islmcCalcTabs-2_${_pageRef}">
				<jsp:include page="IslamicCalculatorSchedulePopUp.jsp"></jsp:include>
			</div>
			<psj:dialog id="islamicCalculatorDebitBurdunRatiosDialog_${_pageRef}"
				autoOpen="false" title="%{getText('Debt_Burden_Ratio_key')}"  modal="true"
				buttons="{
				\"Cancel\":{text:\"%{getText(\"Cancel_key\")}\",id:\"dbr_cancel_btn_%{_pageRef}\",click: function(){$( this ).dialog( 'close' );}}
			}">
	</psj:dialog>
			
		</div>		
		
	<script  type="text/javascript">
		balloonPaymentGrid_onDocReady();	
		setBaloonPaymentSummary();
		$("#islamicCalculatorFormMaindiv_"+_pageRef).processAfterValid("validateCalculate",[]);	
		$(document).ready(function() {
		   $("#lookuptxt_productClass_"+_pageRef).focus();
		   jQuery("#repaymentgridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
			  useColSpanStyle: true, 
			  groupHeaders:[ {startColumnName: 'ACC_BR', numberOfColumns: 6, titleText:account},
			  {startColumnName: 'COVERING_ACC_BR', numberOfColumns: 6, titleText:coveringAccount},
			  {startColumnName: 'FROM_DATE', numberOfColumns: 2, titleText: repaymentInstallmentDate},
			  {startColumnName: 'PAYM_PERIOD_NBR', numberOfColumns: 4, titleText: repaymentPeriodicity}]
			});
			//TP#236387; Ramesh; Date 04/11/2014
		$('#scheduleGridTbl_Id_' + _pageRef).jqGrid("setGridWidth", 1024);
		// TP#237341; Ramesh; Date 25/12/2014
		$('#dealChargesGridTbl_Id_' + _pageRef).jqGrid(
						"setGridWidth",
						$("#islamicCalculatorFormMaindiv_" + _pageRef).width());
		$(
					"#gview_dealChargesGridTbl_Id_" + _pageRef
							+ " div.ui-jqgrid-titlebar").hide();
		});		    
	</script>
	</body>
</html>