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

	<ps:set name="Counterparty_details_key" value="%{getEscText('Counterparty_details_key')}"/>
	<head>
   		<title> <ps:text name="" /> </title>
	</head>
	<body> 
		
	<ps:form id="islamicCalculatorFormMaindiv_${_pageRef}" useHiddenProps="true">
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
		<ps:hidden id="hidden_showTegMessagesYN_${_pageRef}" name="calculatorCO.setShowTegMessages"/>
		
		<ps:hidden id="repaymentPlanBalloon_${_pageRef}" name="repaymentPlanBalloon"></ps:hidden>
		<ps:hidden id="multipeYieldList_${_pageRef}" name="multipeYieldList"></ps:hidden>
      	<ps:hidden id="repaymentPlanCriteria" name="repaymentPlanCriteria"></ps:hidden>
      	<ps:hidden id="itemsList_${_pageRef}" name="itemsList"></ps:hidden>
		<ps:hidden id="custGuarLiabilityListDet_${_pageRef}" name="custGuarLiabilityListDet"></ps:hidden>
		<ps:hidden id="strNIDCDetail_${_pageRef}" name="strNIDCDetail"></ps:hidden>
		<ps:hidden id="strNIDCCouponPayment_${_pageRef}" name="strNIDCCouponPayment"></ps:hidden>
		<ps:hidden id="multipleYieldGriddetails_${_pageRef}" name="multipleYieldGriddetails"></ps:hidden>
		<ps:hidden id="tendativeScheduleList_${_pageRef}" name="tendativeScheduleList"></ps:hidden>
		<ps:hidden id="projectFinanceDetails_${_pageRef}" name="projectFinanceDetails"></ps:hidden>
		<ps:hidden id="repaymentTentativeCritieria_${_pageRef}" name="repaymentTentativeCritieria"></ps:hidden>
		<ps:hidden id="dealChargesGriddetails_${_pageRef}" name="dealChargesGriddetails"></ps:hidden>
		<ps:hidden id="scheduleGriddetails_${_pageRef}" name="scheduleGriddetails"></ps:hidden>
		<ps:hidden id="repaymentGridDetails_${_pageRef}" name="repaymentGridDetails"></ps:hidden>
		<ps:hidden name="islamicCalculatorEventMgmtCO.vatApplicable" id="vatApplicableYN_${_pageRef}" />
		<%--TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule Charges 	--%>
		<ps:hidden id="dealSettlementChargesAllRows_${_pageRef}" name="dealSettlementChargesAllRows"></ps:hidden>
		<%--636487 Hari.K.S  21/03/2018 --%>
		<ps:hidden id="preValue_${_pageRef}" />
		<ps:hidden id="preValueDesc_${_pageRef}" />
		<ps:hidden id="saveYN_${_pageRef}" />
      				
		<ps:if test='%{iisScreenYN=="Y"}'>
		<table width="100%" class="ui-state-default ui-widget-content">
		<tr>
			<td class="fldLabelView" width="20%">
				<ps:label key="Ref_No_key" cssStyle="font-weight:bold!important" />
			</td>
			<td width="30%">
				<ps:textfield id="calculatorRefNO_${_pageRef}"
					name="islamicCalculatorEventMgmtCO.trsPayPlanCalculatorVO.REF_NBR"
					readonly="true"
					cssStyle="background: white !important;text-align:center!important;font-weight:bold!important;color:#2779aa !important" />
			</td>
			<td width="50%">
				<ps:textfield id="calculatorRefDescription_${_pageRef}" maxlength="30"
					name="islamicCalculatorEventMgmtCO.trsPayPlanCalculatorVO.REF_DESCRIPTION" />
			</td>
		</tr>
		</table>
		</ps:if>
		<ps:if test='%{iisScreenYN!="Y"}'>
			<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
		</ps:if>
		<psj:tabbedpanel id="islmcCalcMainTabs_${_pageRef}" >
	
		<psj:tab id="islmcCalcDetailsTab_${_pageRef}"  target="islmcCalcTabs1_${_pageRef}" key="Calculator_key" />
  		<psj:tab id="islmcCalcScheduleTab_${_pageRef}" target="islmcCalcTabs2_${_pageRef}" key="Schedule_key" />

		<div id="islmcCalcTabs1_${_pageRef}">
			<jsp:include page="IslamicCalculatorCalculate.jsp" />
		</div>
		<div id="islmcCalcTabs2_${_pageRef}">
			<jsp:include page="IslamicCalculatorSchedulePopUp.jsp" />
		</div>
	</psj:tabbedpanel>
		
	<ps:set name="Confirm_Delete_Process_key"
	value="%{getEscText('Confirm_Delete_Process_key')}" />	
	</ps:form>
	<script  type="text/javascript">
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
		//TP#416613;Roshin;02/02/2017   - EWBI160081 - Settlement and reschedule Charges START 				  
		$('#settlementChargesGridTbl_Id_' + _pageRef).jqGrid(
						"setGridWidth",
						$("#islamicCalculatorFormMaindiv_" + _pageRef).width());
		$(
					"#gview_settlementChargesGridTbl_Id" + _pageRef
							+ " div.ui-jqgrid-titlebar").hide();
		
			$.subscribe('settlementcharges_setReadonly', function(event, data) {
			settlementcharges_setReadonly();
				});
	
			 var settlementChargesGrid = $("#settlementChargesGridTbl_Id_"+_pageRef);
	
	  		  settlementChargesGrid.unsubscribe("onSettlementChargesGridLoadComplete")
			  settlementChargesGrid.subscribe("onSettlementChargesGridLoadComplete",function(response,html){ 		    
				 onSettlementChargesGridLoadComplete();	
			});
	  	//TP#416613;Roshin;02/02/2017  - EWBI160081 - Settlement and reschedule Charges END
	  		var Confirm_Delete_Process_key = "${Confirm_Delete_Process_key}";
		
		});		
		var Counterparty_details_key = "${Counterparty_details_key}";	    
	</script>
	</body>
</html>