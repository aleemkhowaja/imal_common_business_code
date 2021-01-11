/*******************************************************************************
 * Method for adding calculation,schedule tab
 *
 * @param {Object} $
 */

function loadRepaymentplanPaymentTypeCombo()
{
	return $("#paymentType_" + _pageRef).val();

}

(function($)
{
	islmcCalcMaint_onDocReady = function()
	{
		var rowId = "";
		$("#islmcCalcMainTabs_" + _pageRef).tabs(); // For showing the Jquery
		// Tabs
		$("#islmcCalcMainTabs_" + _pageRef).tabs().find(".ui-tabs-nav")
				.sortable({
					axis : "x"
				}); // For making the tabs sortable

		// $("#islmcCalcTabs2").css("display", "none");
		$("#islmcCalcTabs2_" + _pageRef).css("display", "none");
		if (_pageRef == "M01681")
		{
			$("#islmcCalcTabs3_" + _pageRef).css("display", "none");
		}

		$("#islmcCalcMainTabs_" + _pageRef).tabs({
			collapsible : false
		});

		// binding the tab show event
		$("#islmcCalcMainTabs_" + _pageRef).bind(
				"tabsshow",
				function(event, ui)
				{
					tabId = ui.tab.id; // getting clicked tab ID
					tabContent = $('#' + ui.tab.id).attr('href'); // getting
					// the
					// href
					// attribute
					// from
					// tab
					// iD
					tabPanelId = tabContent.substr(1, tabContent.length); // getting
					// the
					// tab
					// Panel
					// ID
					// currosponding
					// to
					// tab
					// ID
					if (tabPanelId == "islmcCalcTabs2_" + _pageRef)
					{
						var gridParentWidth = $(
								'#gbox_scheduleGridTbl_Id_' + _pageRef)
								.parent().parent().width();
						$('#scheduleGridTbl_Id_' + _pageRef).jqGrid(
								"setGridWidth", gridParentWidth);
					}

					if (tabPanelId == "islmcCalcTabs3_" + _pageRef)
					{
						var gridParentWidth = $(
								'#gbox_urlRepaymentPlanTentativeScheduleGrid_Id_'
										+ _pageRef).parent().parent().width();
						$(
								'#urlRepaymentPlanTentativeScheduleGrid_Id_'
										+ _pageRef).jqGrid("setGridWidth",
								gridParentWidth);
					}
				});
		onChangeVatApplicable();

		// By default - hiding- for straight line
		$("#compoundingDuringTheEntireDealPeriod_" + _pageRef).hide();
		$("#lbl_compoundingDuringTheEntireDealPeriod_" + _pageRef).hide();

		// Setting the default values as previous value.
		$("#annualYieldRate_" + _pageRef).attr("prevValue",
				$("#annualYieldRate_" + _pageRef).val());
		$("#margin_" + _pageRef).attr("prevValue",
				$("#margin_" + _pageRef).val());
		$("#floatingRate_" + _pageRef).attr("prevValue",
				$("#floatingRate_" + _pageRef).val());
		$("#financingAmount_" + _pageRef).attr("prevValue",
				$("#financingAmount_" + _pageRef).val());

		$("#lookuptxt_cifNo_" + _pageRef).focus();

	};
})(jQuery);

function onChangeChargesCalculation()
{

	var $table = $("#dealChargesGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var chargescal = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('getCell',
			selectedRowId, 'CHARGES_CALCULATION_METHOD')
	if (chargescal == "P")
	{
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'PERIODICAL_BASIS', "false");

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'PERIODICAL_NUMBER', "false");
	}
	else if (chargescal == "N")
	{

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'PERIODICAL_BASIS', "true");

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'PERIODICAL_NUMBER', "true");

	}

}

function onChangeAmoutClaculationBasis()
{

	var $table = $("#dealChargesGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var amtcal = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('getCell',
			selectedRowId, 'AMOUNT_CALCULATION_BASIS')

	if (amtcal == "P")
	{

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'CHARGES_CALCULATION_METHOD', "true");

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'PERIODICAL_NUMBER', "true");

		// $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
		// selectedRowId, 'PERIODICAL_PERIODICITY', "true");

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'PERIODICAL_BASIS', "true");

	}
	else if (amtcal == "B")
	{
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'CHARGES_CALCULATION_METHOD', "false");

	}

}
function setRepaymentFormat()
{

	var colModel = $("#repaymentgridTbl_Id_" + _pageRef).jqGrid('getGridParam',
			'colModel');
	var decimalPoints = $("#hidden_islamicCalcDecimalFormat_" + _pageRef).val();
	var nbFormat = returnNbFormat(decimalPoints);
	for (var i = 0; i < colModel.length; i++)
	{
		if (colModel[i].name == 'CAPITAL_AMT')
		{
			colModel[i].nbFormat = nbFormat;
			break;
		}
	}
	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setGridParam', 'colModel',
			colModel);
}

$(function()
{
	$('#play').click(function()
	{
		$(this).val() == "play" ? play_int() : play_pause();
	});
});

(function($)
{
	balloonPaymentGrid_onDocReady = function()
	{
		// 665864 VISHNU V
		// $("#balloonPaymentGridTbl_Id_" + _pageRef)
		// // Modifying Pager
		// .jqGrid('navGrid', '#balloonPaymentGridTbl_Id_' + _pageRef +
		// '_pager',
		// {
		//
		// })
		// // custom Add Button
		//
		// .jqGrid('navButtonAdd',
		// '#balloonPaymentGridTbl_Id_' + _pageRef + '_pager', {
		// caption : equalPayments,
		// onClickButton : function()
		// {
		// getEqualUnEqualBalloonPaymentsList("equal");
		// }
		// }).jqGrid('navButtonAdd',
		// '#balloonPaymentGridTbl_Id_' + _pageRef + '_pager', {
		// caption : unequalPayments,
		// onClickButton : function()
		// {
		// getEqualUnEqualBalloonPaymentsList("unEqual");
		// }
		// })
	};
})(jQuery);

/*******************************************************************************
 * Method for adding a multi header for amount in deal charges grid
 *
 * @param {Object}
 *            event
 * @param {Object}
 *            data
 */

$.subscribe('dealChargesAmountHeader', function(event, data)
{
	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setGroupHeaders', {
		useColSpanStyle : true,
		groupHeaders : [ {
			startColumnName : 'trsPayplanCriteriaVO.FROM_DATE',
			numberOfColumns : 2,
			titleText : dealChargesAmountHeader
		} ]
	});
});

/*******************************************************************************
 * Method for adding a multi header for installment date for repayment criteria
 *
 * @param {Object}
 *            event
 * @param {Object}
 *            data
 */
// $.subscribe('repaymentMultiHeaders', function(event, data) {
// $("#repaymentgridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
// useColSpanStyle: true,
// groupHeaders:[
// {startColumnName: 'trsPayplanCriteriaVO.FROM_DATE', numberOfColumns: 2,
// titleText: repaymentInstallmentDate}
// ]
// });
// $("#repaymentgridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
// useColSpanStyle: true,
// groupHeaders:[
// {startColumnName: 'trsPayplanCriteriaVO.PAYM_PERIOD_NBR', numberOfColumns: 4,
// titleText: repaymentPeriodicity}
// ]
// });
// // setRepaymentFormat();
// });
/*******************************************************************************
 * Method for hiding the balloon payments sections in onload
 */
function showBallonDetails(show)
{
	if (show)
	{
		$('#lbl_baloonPercentage_' + _pageRef).show();
		$('#baloonPercentage_' + _pageRef).show();
		$('#lbl_baloonAmount_' + _pageRef).show();
		$('#baloonAmount_' + _pageRef).show();
		$('#baloonPercentage_' + _pageRef).focus();
	}
	else
	{
		$('#baloonPercentage_' + _pageRef).val("");
		$('#baloonAmount_' + _pageRef).val("");
		$('#lbl_baloonPercentage_' + _pageRef).hide();
		$('#baloonPercentage_' + _pageRef).hide();
		$('#lbl_baloonAmount_' + _pageRef).hide();
		$('#baloonAmount_' + _pageRef).hide();
	}
}

/*******************************************************************************
 * Method for validating the cif and civil id
 *
 * @param {Object}
 *            componentId
 */
function validateOnChangeCifCivilId(componentId)
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var params = {};
		if (componentId.toString().indexOf("cifNo_") >= 0)
		{
			params["iisCommonCO.cifNo"] = $(
					"#lookuptxt_" + componentId + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.cifNo"] = $(
					"#lookuptxt_" + componentId + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#lookuptxt_currencyCode_" + _pageRef).val();
			params["iisCommonCO.idNo"] = $("#lookuptxt_civilId_" + _pageRef)
					.val();
		}
		else
		{
			params["iisCommonCO.idNo"] = $(
					"#lookuptxt_" + componentId + _pageRef).val();
		}

		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOnChangeCifCivilId",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (typeof data["_error"] != "undefined"
								|| data["_error"] == null)
						{
							if (data.iisCommonCO.cifNo != null)
							{
								params["iisCommonCO.cifNo"] = data.iisCommonCO.cifNo;
								params["islamicCalculatorEventMgmtCO.cifNo"] = data.iisCommonCO.cifNo;
								params["islamicCalculatorEventMgmtCO.startDate"] = $(
										"#startDate_" + _pageRef).val();
								isCifBlackListed(params, componentId);// call
								// the
								// check
								// for
								// blacklisted
							}
						}
					}
				});
	}
	else
		$("#lookuptxt_" + componentId).val("");
}

/*******************************************************************************
 * Method for checking whether the cif is blacklisted or not based on the
 * confirm the flow will continue.
 *
 * @param {Object}
 *            params TODO Confirm mechanism
 */
function isCifBlackListed(params, componentId)
{
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_isCifBlackListed",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (typeof data["_error"] != "undefined"
							|| data["_error"] == null) // Later use confirm box
						// and on clicking yes
						// button load the
						// details_showConfirmMsg(data["_error"]);
						params["iisCommonCO.productClass"] = $(
								"#lookuptxt_productClass_" + _pageRef).val();
					if (componentId.toString().indexOf("cifNo_") >= 0)
						populateCifDetails(params);// Populating the CIF
					// Details
				}
			});
}
/*******************************************************************************
 * Method for getting CIF details from server
 *
 * @param {Object}
 *            params
 */
function populateCifDetails(params)
{
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeCifCivilId",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						setCifDetails(data);
						applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
						// THE
						// DECIMAL
						// FORMAT
						// IN
						// ALL
						// AMOUNT
						// FIELDS
					}
				}
			});
}

/*******************************************************************************
 * Method for setting the cif details to the page
 *
 * @param {Object}
 *            data
 */
function setCifDetails(data)
{

	$("#cifName_" + _pageRef).val(data.islamicCalculatorEventMgmtCO.cifName);
	$("#lookuptxt_civilId_" + _pageRef).val(
			data.islamicCalculatorEventMgmtCO.idNo);
	$("#lookuptxt_cifNo_" + _pageRef).val(
			data.islamicCalculatorEventMgmtCO.cifNo);
	$("#approvedSalary_" + _pageRef).val(
			data.islamicCalculatorEventMgmtCO.approvedSalary);
	$("#income_" + _pageRef).val(data.islamicCalculatorEventMgmtCO.income);
	$("#debtBurdanRatio_" + _pageRef).val(
			data.islamicCalculatorEventMgmtCO.debtBurdanRatio);
	if (data.islamicCalculatorEventMgmtCO.maintainSalaryAccount != null)
	{
		if (data.islamicCalculatorEventMgmtCO.maintainSalaryAccount == "1"
				|| data.islamicCalculatorEventMgmtCO.maintainSalaryAccount == "Y")
		{
			$("#maintainSalaryAccount_" + _pageRef).attr('checked', 'checked');
		}
		else
		{
			if ($("#maintainSalaryAccount_" + _pageRef).is(':checked') == true)
				$("#maintainSalaryAccount_" + _pageRef).removeAttr('checked');
		}
	}
	if (_pageRef == "M01681")
	{
		if (data.islamicCalculatorEventMgmtCO.salaryWithBank != null)
		{
			if (data.islamicCalculatorEventMgmtCO.salaryWithBank == "1"
					|| data.islamicCalculatorEventMgmtCO.salaryWithBank == "Y")
			{
				$("#salary_with_bank_" + _pageRef).attr('checked', 'checked');
			}
			else
			{
				if ($("#salary_with_bank_" + _pageRef).is(':checked') == true)
					$("#salary_with_bank_" + _pageRef).removeAttr('checked');
			}
		}

	}
}

/*******************************************************************************
 * Method for onchange event of vat applicable checkbox TODO Make Readonly when
 * u select product class only if vat details exists TODO On unchecking
 * installment amount checkbox the readonly attribute should remove TODO On
 * checking installment amount checkbox the make this checkbox readonly
 *
 */
function onChangeVatApplicable()
{
	// TP#259997; Ramesh; Date 08/01/2015
	var classCode = $("#lookuptxt_productClass_" + _pageRef).val();
	if (classCode != null && classCode != undefined && classCode != "")
	{
		// TP#242355; Ramesh; Date 07/01/2015 [START]
		var vatInstallmentCheckBox = 'vatInstallment_' + _pageRef
				+ ',label[for="vatInstallment_' + _pageRef + '"]';
		var vatCodeLiveSearch = 'lookupdiv_vatCode_' + _pageRef;
		if ($("#vatApplicable_" + _pageRef).is(':checked') == false)
		{
			$('#lookuptxt_vatCode_' + _pageRef).val("");
			$('#vatDesc_' + _pageRef).val("");
			$('#vatPercentage_' + _pageRef).val("");
			$("#" + vatInstallmentCheckBox).removeAttr('checked');
			$('#lbl_VAT_Code_' + _pageRef).hide();
			$('#vatCode_' + _pageRef).hide();
			$('#vatDesc_' + _pageRef).hide();
			$('#lbl_VAT_Percentage_' + _pageRef).hide();
			$('#vatPercentage_' + _pageRef).hide();
			$('#' + vatInstallmentCheckBox).hide();
			$('#' + vatCodeLiveSearch).hide();
		}
		else
		{
			$('#lbl_VAT_Code_' + _pageRef).show();
			$('#vatCode_' + _pageRef).show();
			$('#vatDesc_' + _pageRef).show();
			$('#lbl_VAT_Percentage_' + _pageRef).show();
			$('#vatPercentage_' + _pageRef).show();
			$('#' + vatInstallmentCheckBox).show();
			$('#' + vatCodeLiveSearch).show();
		}
		// TP#242355; Ramesh; Date 07/01/2015 [END]
	}
	// TP#259997; Ramesh; Date 08/01/2015
	else
	{
		$('#vatApplicable_' + _pageRef).prop('checked', false);
	}

}
/*******************************************************************************
 * Method calls while checking the vat installment check box TODO check service
 * team whether we need to set the vat code,desc, ad percentage.If so then the
 * vat desc is coming null but the Vat code is coming as 1
 */
function onChangeVatInstallment()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var vatCode = $.parseNumber($('#lookuptxt_vatCode_' + _pageRef).val(),
				{
					format : $('#lookuptxt_vatCode_' + _pageRef).attr(
							"nbFormat"),
					locale : "us"
				});
		if ($("#vatInstallment_" + _pageRef).is(':checked') == true
				&& vatCode > 0)
		{
			var params = {};
			params["islamicCalculatorEventMgmtCO.includeVatinInstallment"] = "Y";
			params["islamicCalculatorEventMgmtCO.vatCode"] = $(
					'#lookuptxt_vatCode_' + _pageRef).val();
			// #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015
			params["islamicCalculatorEventMgmtCO.productClass"] = $(
					"#lookuptxt_productClass_" + _pageRef).val();
			$
					.ajax({
						url : $.contextPath
								+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeVatInstallment",
						type : "post",
						data : params,
						dataType : "json",
						success : function(data)
						{
							if (data["_error"] == null)
							{
								// $('#lookuptxt_vatCode_'+_pageRef).val(data.islamicCalculatorEventMgmtCO.vatCode);
								// $('#vatDesc_'+_pageRef).val(data.islamicCalculatorEventMgmtCO.vatDesc);
								// $('#vatPercentage_'+_pageRef).val(data.islamicCalculatorEventMgmtCO.vatPercentage);
							}
							else
							{
								var vatInstallmentCheckBox = 'vatInstallment_'
										+ _pageRef
										+ ',label[for="vatInstallment_'
										+ _pageRef + '"]';
								$("#" + vatInstallmentCheckBox).removeAttr(
										'checked');
							}
						}
					});
		}
	}
}
/*******************************************************************************
 * Method for calling the onchange evnt of vat code
 */
function onChangeVatCode()
{

	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{

		var params = {};
		if ($("#vatApplicable_" + _pageRef).is(':checked') == true)
			params["islamicCalculatorEventMgmtCO.vatApplicable"] = "Y";
		else
			params["islamicCalculatorEventMgmtCO.vatApplicable"] = "N";

		var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
		if (rescheduleYn == "Y")
		{
			var financingAmount = $.parseNumber($(
					"#outstanding_amount_" + _pageRef).val(), {
				format : $("#outstanding_amount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
		}
		else
		{
			var financingAmount = $.parseNumber($(
					"#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
		}

		params["islamicCalculatorEventMgmtCO.vatCode"] = $(
				"#lookuptxt_vatCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeVatCode",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							// $('#vatDesc_'+_pageRef).val(data.islamicCalculatorEventMgmtCO.vatDesc);
							// $('#vatPercentage_'+_pageRef).val(data.islamicCalculatorEventMgmtCO.vatPercentage);
							setInputValue(
									"vatPercentage_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.vatPercentage);
							if (data.islamicCalculatorEventMgmtCO.includeVatinInstallment == "N")
								$('#vatInstallment_' + _pageRef).removeAttr(
										'checked');
							// TP#245267; Libin; Date 28/12/2014 [Start] Added
							// confirmation checking and data reset
							var confirmChoice = false;
							if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
									&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
							{
								_showConfirmMsg(
										data.islamicCalculatorEventMgmtCO.confirmationMessageId,
										confirm_msg_title,
										function(confirmChoice, theArgs)
										{
											vatPercentConfirmation(confirmChoice);
										});
							}
						}
						else
						{
							$("#lookuptxt_vatCode_" + _pageRef).val('');
							$("#vatDesc_" + _pageRef).val('');
							$("#vatPercentage_" + _pageRef).val('');
						}
					}
				});
	}
	else
	{
		if ($.trim($("#lookuptxt_productClass_" + _pageRef).val()) == "")
		{
			$("#lookuptxt_vatCode_" + _pageRef).val('');
			$("#vatDesc_" + _pageRef).val('');
			$("#vatPercentage_" + _pageRef).val('');

		}
	}
}
// TP#245267; Libin; Date 28/12/2014 [End]

// TP#245267; Libin; Date 28/12/2014 [Start] Added confirmation checking
function vatPercentConfirmation(confirmChoice)
{
	if (!confirmChoice)
	{
		$("#vatPercentage_" + _pageRef).val('0');
	}
}
// TP#245267; Libin; Date 28/12/2014 [End]

/*******************************************************************************
 * Method for caling thr on change event of no of balloon paymnets TODO Add the
 * data to balloon payment grid once we get that it from service team
 */
function onChangeNoOfBalloons()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
		var params = {};

		params["islamicCalculatorEventMgmtCO.tempCode"] = $(
				"#lookuptxt_tempCode_" + _pageRef).val();
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		var balloonAmount = $.parseNumber($('#baloonAmount_' + _pageRef).val(),
				{
					format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		var balloonPercentage = $.parseNumber(
				$('#baloonPercentage_' + _pageRef).val(), {
					format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		var noOfBalloonPayments = $.parseNumber($(
				'#baloonPaymentNo_' + _pageRef).val(), {
			format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
			locale : "us"
		});

		params["islamicCalculatorEventMgmtCO.baloonAmount"] = balloonAmount;
		params["islamicCalculatorEventMgmtCO.baloonPercentage"] = balloonPercentage;
		params["islamicCalculatorEventMgmtCO.noOfBaloonPayments"] = noOfBalloonPayments;
		// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
		params["islamicCalculatorEventMgmtCO.flexiPaymentYn"] = returnHtmlEltValue('flexiPaymentYN_CheckBox_'
				+ _pageRef);
		// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
		// TP#194122; Ramesh; Date 10/08/2014
		if ((_pageRef == "M0169") || (_pageRef == "M0165"))
		{
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#hidden_deal_cy_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#lookuptxt_currencyCode_" + _pageRef).val();
		}

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeNoOfBalloons",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							if ($("#baloonPaymentNo_" + _pageRef).val() != null
									&& parseInt($(
											"#baloonPaymentNo_" + _pageRef)
											.val(), 10) > 0)
							{
								showBallonDetails(true);
								addBalloonDetailsList(data.islamicCalculatorEventMgmtCO.balloonDetailsList);

								// //TODO summary row
							}
							else
							{
								showBallonDetails(false);
								$("#balloonPaymentGridTbl_Id_" + _pageRef)
										.jqGrid("clearGridData", true).trigger(
												"reloadGrid");
							}
						}
						else
						{
							showBallonDetails(false);
							$("#baloonPaymentNo_" + _pageRef).val("");
							$("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
									"clearGridData", true)
									.trigger("reloadGrid");
						}
					}
				});
	}
}
/*******************************************************************************
 * Method for calling onchange event of balloon percentage TODO The parameter
 * list provided by IIS team is not correct cross check it
 */
function onChangeBalloonPercentage()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var prevBalloonPercentage = $('#baloonPercentage_' + _pageRef).attr(
				"prevValue");

		var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
		var params = {};
		var financingAmount;
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (rescheduleYn == "Y")
		{
			params["islamicCalculatorEventMgmtCO.startDate"] = $(
					"#hidden_reschedule_value_date_" + _pageRef).val();
			financingAmount = $.parseNumber(
					$("#outstanding_amount_" + _pageRef).val(), {
						format : $("#outstanding_amount_" + _pageRef).attr(
								"nbFormat"),
						locale : "us"
					});
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#hidden_deal_cy_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.tempCode"] = $(
					"#lookuptxt_tempCode_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.startDate"] = $(
					"#startDate_" + _pageRef).val();
			financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
					.val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#lookuptxt_currencyCode_" + _pageRef).val();
		}

		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();

		var balloonAmount = $.parseNumber($('#baloonAmount_' + _pageRef).val(),
				{
					format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		var balloonPercentage = $.parseNumber(
				$('#baloonPercentage_' + _pageRef).val(), {
					format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		var noOfBalloonPayments = $.parseNumber($(
				'#baloonPaymentNo_' + _pageRef).val(), {
			format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
			locale : "us"
		});

		params["islamicCalculatorEventMgmtCO.baloonAmount"] = balloonAmount;
		params["islamicCalculatorEventMgmtCO.baloonPercentage"] = balloonPercentage;
		params["islamicCalculatorEventMgmtCO.noOfBaloonPayments"] = noOfBalloonPayments;

		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeBalloonPercentage",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							$('#baloonAmount_' + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.baloonAmount);
							addBalloonDetailsList(data.islamicCalculatorEventMgmtCO.balloonDetailsList);
							setPreviousValue("baloonPercentage_" + _pageRef);
						}
						else
						{
							// resetToPreviousValue("baloonPercentage_"+_pageRef);
							// $("#baloonPercentage_" +
							// _pageRef).val(prevBalloonPercentage);
							setInputValue("baloonPercentage_" + _pageRef,
									prevBalloonPercentage);
						}
						applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
						// THE
						// DECIMAL
						// FORMAT
						// IN
						// ALL
						// AMOUNT
						// FIELDS
					}
				});
	}
}
/*******************************************************************************
 * Method for calling onchange event of balloon payment amount
 */
function onChangeBalloonAmount()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var prevBalloonAmount = $('#baloonAmount_' + _pageRef)
				.attr("prevValue");
		var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
		var params = {};

		params["islamicCalculatorEventMgmtCO.tempCode"] = $(
				"#lookuptxt_tempCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		var balloonAmount = $.parseNumber($('#baloonAmount_' + _pageRef).val(),
				{
					format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		var financingAmount = 0;
		var currencyCode = null;
		if (rescheduleYn == "Y")
		{

			// TP#193130; Ramesh; Date 24/06/2014
			if (_pageRef == "M0165")
			{
				financingAmount = $.parseNumber($(
						"#outstanding_amount_" + _pageRef).val(), {
					format : $("#outstanding_amount_" + _pageRef).attr(
							"nbFormat"),
					locale : "us"
				});
			}
			else
			{
				financingAmount = $.parseNumber($(
						"#principalAmount_" + _pageRef).val(),
						{
							format : $("#principalAmount_" + _pageRef).attr(
									"nbFormat"),
							locale : "us"
						});
			}
			currencyCode = $("#hidden_deal_cy_" + _pageRef).val();
		}
		else
		{
			financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
					.val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
			currencyCode = $("#lookuptxt_currencyCode_" + _pageRef).val();
		}
		var balloonPercentage = $.parseNumber(
				$('#baloonPercentage_' + _pageRef).val(), {
					format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		var noOfBalloonPayments = $.parseNumber($(
				'#baloonPaymentNo_' + _pageRef).val(), {
			format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.baloonAmount"] = balloonAmount;
		params["islamicCalculatorEventMgmtCO.baloonPercentage"] = balloonPercentage;
		params["islamicCalculatorEventMgmtCO.noOfBaloonPayments"] = noOfBalloonPayments;
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
		params["islamicCalculatorEventMgmtCO.currencyCode"] = currencyCode;

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeBalloonPaymentAmount",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{

							$('#baloonPercentage_' + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.baloonPercentage);
							addBalloonDetailsList(data.islamicCalculatorEventMgmtCO.balloonDetailsList);
							setPreviousValue("baloonAmount_" + _pageRef);
						}
						else
						{
							// resetToPreviousValue("baloonAmount_"+_pageRef);
							// $("#baloonAmount_" +
							// _pageRef).val(prevBalloonAmount);
							setInputValue("baloonAmount_" + _pageRef,
									prevBalloonAmount);
						}
					}
				});
	}
}
// Method for onchange evnt of date field in ballon payment grid
function validateDateForBalloonDetails(t)
{
	// var row = $(t.target).closest('tr.jqgrow');
	// var rowId = row.attr('id');
	// IE-8 Fix
	var balloonGrid = $("#balloonPaymentGridTbl_Id_" + _pageRef);
	var rowId = balloonGrid.jqGrid("getGridParam", 'selrow');

	if ($("#" + rowId + "_balloonDate").val() != undefined
			&& $("#" + rowId + "_balloonDate").val() != null)
	{
		var params = {};
		var noOfBalloonPayments = $.parseNumber($(
				'#baloonPaymentNo_' + _pageRef).val(), {
			format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
			locale : "us"
		});

		var balloonAmount = $.parseNumber($('#baloonAmount_' + _pageRef).val(),
				{
					format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		params["islamicCalculatorEventMgmtCO.noOfBaloonPayments"] = noOfBalloonPayments;
		params["islamicCalculatorEventMgmtCO.baloonAmount"] = balloonAmount;
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();

		var balloonDatePrev = $("#" + rowId + "_balloonDate").attr("prevvalue");

		var balAmount = $
				.parseNumber($("#" + rowId + "_balloonAmount").val(),
						{
							format : $("#" + rowId + "_balloonAmount").attr(
									"nbFormat"),
							locale : "us"
						});
		var balloonDetails = $("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
				'getAllRows');
		// TP#221204;Arun.R.Variyath;23/09/2014 [Start]
		var rowsBalloon = $("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
				'getDataIDs');

		if (rowsBalloon.length <= 0)
		{
			params["strBalloonDetails"] = "";
		}
		else
		{
			params["strBalloonDetails"] = balloonDetails;
		}
		// TP#221204;Arun.R.Variyath;23/09/2014 [End]

		params["islamicCalculatorEventMgmtCO.ballonPaymentCO.balloonNo"] = $(
				'#balloonPaymentGridTbl_Id_' + _pageRef).jqGrid('getCell',
				rowId, 'balloonNo');
		params["islamicCalculatorEventMgmtCO.ballonPaymentCO.balloonDate"] = $(
				"#" + rowId + "_balloonDate").val();// $("#"+rowId+"_balloonDate").val()
		params["islamicCalculatorEventMgmtCO.ballonPaymentCO.balloonAmount"] = $(
				"#" + rowId + "_balloonAmount").val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();

		var financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
				.val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateDateForBalloonDetails",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							$("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
									'saveRow', rowId, false, 'clientArray');
							addBalloonDetailsList(data.islamicCalculatorEventMgmtCO.balloonDetailsList);
						}
						else
						{
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId, 'balloonDate', "",
									"false");

							$("#" + rowId + "_balloonDate")
									.val(balloonDatePrev);

							// $elt =
							// $("#dealChargesGridTbl_Id_"+_pageRef).jqGrid("getCellInputElt",rowId,
							// "balloonDate");
							// $elt.focus();
						}

					}
				});
	}

}
/*******************************************************************************
 * Method for onchange evnt of amount field in ballon payment grid
 */
function validateAmtForBalloonDetails(t)
{
	var params = {};

	var noOfBalloonPayments = $.parseNumber($('#baloonPaymentNo_' + _pageRef)
			.val(), {
		format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	var balloonAmount = $.parseNumber($('#baloonAmount_' + _pageRef).val(), {
		format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
		locale : "us"
	});

	params["islamicCalculatorEventMgmtCO.noOfBaloonPayments"] = noOfBalloonPayments;
	params["islamicCalculatorEventMgmtCO.baloonAmount"] = balloonAmount;
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	// var row = $(t.target).closest('tr.jqgrow');
	// var rowId = row.attr('id');
	// IE-8 Fix
	var balloonGrid = $("#balloonPaymentGridTbl_Id_" + _pageRef);
	var rowId = balloonGrid.jqGrid("getGridParam", 'selrow');

	var balAmount = $.parseNumber($("#" + rowId + "_balloonAmount").val(), {
		format : $("#" + rowId + "_balloonAmount").attr("nbFormat"),
		locale : "us"
	});

	var balloonAmountPrev = $("#" + rowId + "_balloonAmount").attr("prevvalue");
	var balloonDetails = $("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');

	// TP#221204;Arun.R.Variyath;23/09/2014 [Start]
	var rowsBalloon = $("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
			'getDataIDs');

	if (rowsBalloon.length <= 0)
	{
		params["strBalloonDetails"] = "";
	}
	else
	{
		params["strBalloonDetails"] = balloonDetails;
	}
	// TP#221204;Arun.R.Variyath;23/09/2014 [End]
	params["islamicCalculatorEventMgmtCO.ballonPaymentCO.balloonNo"] = $(
			'#balloonPaymentGridTbl_Id_' + _pageRef).jqGrid('getCell', rowId,
			'balloonNo');
	params["islamicCalculatorEventMgmtCO.ballonPaymentCO.balloonDate"] = $(
			"#" + rowId + "_balloonDate").val();// $("#"+rowId+"_balloonDate").val()
	params["islamicCalculatorEventMgmtCO.ballonPaymentCO.balloonAmount"] = $(
			"#" + rowId + "_balloonAmount").val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();

	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateAmtForBalloonDetails",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						$("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
								'saveRow', rowId, false, 'clientArray');
						addBalloonDetailsList(data.islamicCalculatorEventMgmtCO.balloonDetailsList);
					}
					else
					{
						var decimalPoints = $(
								"#hidden_islamicCalcDecimalFormat_" + _pageRef)
								.val();
						// $("#" + rowId + "_balloonAmount").val(
						// formatToCurrencyDecimal(0, decimalPoints));
						$("#" + rowId + "_balloonAmount")
								.val(balloonAmountPrev);

					}
				}
			});
}

/*******************************************************************************
 * Button click of equal unequal payments of balloon payment grid
 *
 * @param {Object}
 *            equalUnEqual
 */
function getEqualUnEqualBalloonPaymentsList(equalUnEqual)
{
	/*
	 * #665864 VISHNU V
	 */
	var name = $('#unequalEqualPayments_' + _pageRef).val();
	if (name == "unequal")
	{
		equalUnEqual = "unEqual"
		$('#unequalEqualPayments_' + _pageRef).html(equal_Payments_key);
		$('#unequalEqualPayments_' + _pageRef).val("equal");
	}
	else
	{
		equalUnEqual = "equal"
		$('#unequalEqualPayments_' + _pageRef).html(unequal_Payments_key);
		$('#unequalEqualPayments_' + _pageRef).val("unequal");
	}

	var rescheduleyn = $("#hidden_reschedule_" + _pageRef).val();
	var params = {};

	var balloonAmount = $.parseNumber($('#baloonAmount_' + _pageRef).val(), {
		format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	var noOfBalloonPayments = $.parseNumber($('#baloonPaymentNo_' + _pageRef)
			.val(), {
		format : $('#baloonAmount_' + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	var ballonPercentage = $.parseNumber($('#baloonPercentage_' + _pageRef)
			.val(), {
		format : $('#baloonPercentage_' + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (noOfBalloonPayments > 0 && ballonPercentage > 0)
	{
		params["islamicCalculatorEventMgmtCO.baloonAmount"] = balloonAmount;
		params["islamicCalculatorEventMgmtCO.noOfBaloonPayments"] = noOfBalloonPayments;
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		if (rescheduleyn == "Y")
		{
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#hidden_deal_cy_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#lookuptxt_currencyCode_" + _pageRef).val();
		}

		if ("equal" == equalUnEqual)
			actionUrl = ""
					+ $.contextPath
					+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateEqualBalloonPaymentDetails";
		else
			actionUrl = ""
					+ $.contextPath
					+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateUnEqualBalloonPaymentDetails";
		$
				.ajax({
					url : actionUrl,
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							addBalloonDetailsListWithAmountOnly(data.islamicCalculatorEventMgmtCO.balloonDetailsList);//TP-667704
						}
					}
				});
	}
}
/*******************************************************************************
 * Method for reloading the balloon payment grid from server
 *
 * @param {Object}
 *            balloonDetailsList
 */
function addBalloonDetailsList(balloonDetailsList)
{
	$("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid("clearGridData", true);
	if (balloonDetailsList != null)
	{
		var balloonLength = balloonDetailsList.length;
		for (var i = 0; i < balloonLength; i++)
		{
			if (balloonDetailsList[i].balloonDate != null)
			{
				balloonDetailsList[i].balloonDate = convertToDate(
						"balloonPaymentGridTbl_Id_" + _pageRef,
						balloonDetailsList[i].balloonDate)
			}
			$("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid('addRowData',
					i + 1, balloonDetailsList[i]);
		}
		setBaloonPaymentSummary();
	}

}

//TP 667704 START
function addBalloonDetailsListWithAmountOnly(balloonDetailsList)
{

	var $table = $("#balloonPaymentGridTbl_Id_" + _pageRef);
	var rowIds = $("#balloonPaymentGridTbl_Id_" + _pageRef)
	.jqGrid('getDataIDs');
	for (var i = 0; i <= rowIds.length; i++)
	{
		if (balloonDetailsList != null)
		{
		$table.jqGrid('setCellValue', i+1, 'balloonAmount', balloonDetailsList[i].balloonAmount);
		}

	}
	setBaloonPaymentSummary();

}

//TP 667704 END
function convertToDate(gridId, dataValue)
{

	if (dataValue == null)
		return null;
	return $.datepicker.formatDate('dd/mm/yy', parseISODateStr(dataValue
			.substr(0, 10)));

	// var formatOpts =
	// $("#"+gridId).jqGrid("getColProp","balloonDate")["formatoptions"]
	// var srcFormat = 'Y-m-d'; //format of date coming from server according to
	// jqgrid.
	// var newFormat = "d/m/y"; //output format according to jqgrid format
	// options.
	// if( typeof formatOpts != "undefined" && typeof formatOpts["newformat"] !=
	// "undefined" && formatOpts["newformat"] != "")
	// {
	// newFormat = formatOpts["newformat"];
	// }
	// //$.fmatter.util.DateFormat(srcFormat,dataValue,newFormat,$.jgrid.formatter.date);
	// formattedDate = $.datepicker.formatDate('dd/mm/yy', new Date(dataValue));
	// return formattedDate;
}

/*******************************************************************************
 * Method for calling onchange event of Amount Per Payment
 */
function onChangeAmountPerPayment()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{

		var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
		var amountPerPaymentPrevValue = $('#amountPerPayment_' + _pageRef).attr("prevValue");//TP-504271
		var params = {};

		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		var financingAmount;
		if (rescheduleYn == "Y")
		{
			params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
					"#no_of_payments_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.startDate"] = $(
					"#hidden_reschedule_value_date_" + _pageRef).val();
			if (_pageRef == "M0169")
			{
				financingAmount = $.parseNumber($(
						"#outstanding_principle_" + _pageRef).val(), {
					format : $("#outstanding_principle_" + _pageRef).attr(
							"nbFormat"),
					locale : "us"
				});
			}
			else
			{
				financingAmount = $.parseNumber($(
						"#outstanding_amount_" + _pageRef).val(), {
					format : $("#outstanding_amount_" + _pageRef).attr(
							"nbFormat"),
					locale : "us"
				});
			}
			params["islamicCalculatorEventMgmtCO.amountPerPayment"] = $(
					"#amountPerPayment_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#hidden_deal_cy_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.financingCurrency"] = $(
					"#hidden_deal_cy_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
					"#noOfPayments_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.startDate"] = $(
					"#startDate_" + _pageRef).val();
			financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
					.val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
			params["islamicCalculatorEventMgmtCO.amountPerPayment"] = $(
					"#amountPerPayment_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#lookuptxt_currencyCode_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.financingCurrency"] = $(
					"#lookuptxt_currencyCode_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.yield"] = returnHtmlEltValue('annualYieldRate_'+ _pageRef);

			var totalInsuranceAmount = $.parseNumber($(
					"#totalInsuranceAmount_" + _pageRef).val(), {
				format : $("#totalInsuranceAmount_" + _pageRef)
						.attr("nbFormat"),
				locale : "us"
			});
			params["islamicCalculatorEventMgmtCO.totalInsuranceAmt"] = totalInsuranceAmount;
		}
		var amountPerPaymentPrevValue = $('#amountPerPayment_' + _pageRef)
				.attr("prevValue");// TP-504271
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeAmountPerPayment",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							setPreviousValue("amountPerPayment_" + _pageRef);
						}
						else
						{
							// resetToPreviousValue("amountPerPayment_" +
							// _pageRef);
							setInputValue("amountPerPayment_" + _pageRef,
									amountPerPaymentPrevValue);// TP-504271
						}
					}
				});
	}
}

/*******************************************************************************
 * Method for calling onchange event of Total Flat Rate
 */
function onChangeTotalFlatRate()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var params = {};
		params["islamicCalculatorEventMgmtCO.totalFlatRate"] = $(
				"#totalFlatRate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeTotalFlatRate",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{

						}
					}
				});
	}
}

/*******************************************************************************
 * Method for calling onchange event of PurchaseAmount *
 */
function onChangePurchaseAmount()
{
	// TP#253241; Ramesh; Date 28/12/2014
	var prevPurchsAmt = $("#purchaseAmount_" + _pageRef).attr("prevValue");

	var resetElements = {};

	resetElements[0] = "financingAmount_" + _pageRef;
	resetElements[1] = "downPaymentAmount_" + _pageRef;
	resetElements[2] = "annualYieldRate_" + _pageRef;
	resetElements[3] = "downPaymentPercentage_" + _pageRef;
	resetElements[4] = "insuranceChargesAmount_" + _pageRef;
	resetElements[5] = "chargeAmount_" + _pageRef;
	resetElements[6] = "totalInsuranceAmount_" + _pageRef;
	resetElements[7] = "purchaseAmount_" + _pageRef;

	var params = {};
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
			"#noOfPayments_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
			"#maintainSalaryAccount_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
			"#downPaymentPercentage_" + _pageRef).val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	var purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef).val(),
			{
				format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	var downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
			.val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
	params["islamicCalculatorEventMgmtCO.yield"] = $(
			"#annualYieldRate_" + _pageRef).val();
	// var dealCharges = $("#dealChargesGridTbl_Id_" +
	// _pageRef).jqGrid('getRowData');
	// var dealcharges = JSON.stringify( dealCharges)
	// params["strDealCharges"] = dealcharges;

	// Added deal charges as param - based on issue 0092514
	params["strDealCharges"] = returnGridDataForCalc("dealChargesGridTbl_Id");

	// BB150217 - Rescheduling and Loan Buyout CR105585
	var dealType = returnHtmlEltValue('dealType_' + _pageRef);
	params["islamicCalculatorEventMgmtCO.dealType"] = dealType;
	if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
	{
		if (dealType == 'T')
		{
			var topUpGridData = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef)
					.jqGrid('getAllRows');
			params["islamicCalculatorEventMgmtCO.topUpGridData"] = topUpGridData;
			params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('net_credit_to_customer_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.trsTopUpDealVO.TOP_UP_DEAL_AMOUNT"] = returnHtmlEltValue('topup_deal_amount_'
					+ _pageRef);
		}
		if (dealType == 'B')
		{
			params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_CY"] = returnHtmlEltValue('buy_out_deal_cy_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BANK_CIF_NO"] = returnHtmlEltValue('buy_out_bank_no_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_AMOUNT"] = returnHtmlEltValue('buy_out_deal_amount_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('buyOut_net_credit_to_customer_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.NEW_DEAL_AMOUNT"] = returnHtmlEltValue('new_deal_amount_'
					+ _pageRef);
		}
	}

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangePurchaseAmount",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						$("#financingAmount_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.financingAmount);
						setInputValue(
								"purchaseAmount_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.purchaseAmount);
						// TP#211073; Ramesh; Date 20/08/2014
						if (_pageRef == "M0168")
						{
							// TP#233385; Ramesh; Date 22/10/2014
							$("#capital_amt_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);
							$("#Plan_Principal_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);
						}
						// TP#197054; Ramesh; Date 01/07/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_DEAL_AMOUNT_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);
							// TP# 236345;deepu.mohandas 30/10/2014
							$("#Plan_Principal_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);
						}
						$("#downPaymentAmount_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.downPaymentAmount);
						// $("#annualYieldRate_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.yield);
						setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
						// TP#282715;Arun.R.Variyath;24/03/2015
						setMarginRateFromServer(data.islamicCalculatorEventMgmtCO.margin);
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						setSumofInsuranceCharges();
						resetRepaymentAndBalloonDetails();
						setElementsPreviousValue(resetElements);
						// BB150217 - Rescheduling and Loan Buyout CR105585 TP #
						// 412619
						if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
						{
							$("#dealType_Div_" + _pageRef).dialog("destroy");
							$("#dealType_Div_" + _pageRef).remove();
						}
					}
					else
					{
						resetElementsToPreviousValue(resetElements);

						setInputValue("purchaseAmount_" + _pageRef,
								prevPurchsAmt);

						// // TP#164431; Ramesh; Date 25/08/2014
						// if (_pageRef == "M0162") {
						// setInputValue("purchaseAmount_" + _pageRef, purAmt);
						// }
						//
						// // TP#253241; Ramesh; Date 28/12/2014
						// if (_pageRef == "M01681") {
						// setInputValue("purchaseAmount_" + _pageRef,
						// prevPurchsAmt);
						// }
					}
					applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
					// THE
					// DECIMAL
					// FORMAT
					// IN
					// ALL
					// AMOUNT
					// FIELDS
				}
			});
}
/*******************************************************************************
 * Method for calling onchange event of PurchaseAmount *
 */

//var prevPurchsAmt ;

//667257 Confirmaiton message is added for  onChangePurchaseAmount fo rhandling the deal ranges
function onChangePurchaseAmountCorporate(confirm, args)
{


	var resetElements = {};

	resetElements[0] = "financingAmount_" + _pageRef;
	resetElements[1] = "downPaymentAmount_" + _pageRef;
	resetElements[2] = "annualYieldRate_" + _pageRef;
	resetElements[3] = "downPaymentPercentage_" + _pageRef;
	resetElements[4] = "insuranceChargesAmount_" + _pageRef;
	resetElements[5] = "chargeAmount_" + _pageRef;
	resetElements[6] = "totalInsuranceAmount_" + _pageRef;
	resetElements[7] = "purchaseAmount_" + _pageRef;

	if (confirm)
	{
		// TP#253241; Ramesh; Date 28/12/2014
		//prevPurchsAmt = $("#purchaseAmount_" + _pageRef).attr("prevValue");
		//alert("inside"+prevPurchsAmt);
//		var actionSrc;
//		if (arg != "undefined" && arg != null)
//		{
//			if (arg.addUrlParam != "undefined" && arg.addUrlParam != null)
//			{
//				actionSrc = arg.actionURL + arg.addUrlParam;
//				alert(actionSrc);
//			}
//		}
//		else
//		{
//			actionSrc = $.contextPath
//					+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangePurchaseAmount";
//		}

		var actionSrc = $.contextPath
		+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangePurchaseAmount";

		if (args != undefined && args != null
				&& args.addUrlParam != "undefined" && args.addUrlParam != null)
		{
			actionSrc = actionSrc + args.addUrlParam;
		}

		var prevValue = $("#purchaseAmount_" + _pageRef).attr("prevValue");
		$('#purchaseAmountPreValue_' + _pageRef).val(prevValue);
		if (typeof prevValue == "undefined" || prevValue == null)
		{
			prevValue = "";
		}



	var params = {};
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
			"#noOfPayments_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
			"#maintainSalaryAccount_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
			"#downPaymentPercentage_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.limitSerialNo"] = returnHtmlEltValue('lookuptxt_limitSerialNo_'
			+ _pageRef);//TP 67257
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	var purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef).val(),
			{
				format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	var downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
			.val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
	params["islamicCalculatorEventMgmtCO.yield"] = $(
			"#annualYieldRate_" + _pageRef).val();
	// var dealCharges = $("#dealChargesGridTbl_Id_" +
	// _pageRef).jqGrid('getRowData');
	// var dealcharges = JSON.stringify( dealCharges)
	// params["strDealCharges"] = dealcharges;

	// Added deal charges as param - based on issue 0092514
	params["strDealCharges"] = returnGridDataForCalc("dealChargesGridTbl_Id");

	// BB150217 - Rescheduling and Loan Buyout CR105585
	var dealType = returnHtmlEltValue('dealType_' + _pageRef);
	params["islamicCalculatorEventMgmtCO.dealType"] = dealType;
	if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
	{
		if (dealType == 'T')
		{
			var topUpGridData = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef)
					.jqGrid('getAllRows');
			params["islamicCalculatorEventMgmtCO.topUpGridData"] = topUpGridData;
			params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('net_credit_to_customer_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.trsTopUpDealVO.TOP_UP_DEAL_AMOUNT"] = returnHtmlEltValue('topup_deal_amount_'
					+ _pageRef);
		}
		if (dealType == 'B')
		{
			params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_CY"] = returnHtmlEltValue('buy_out_deal_cy_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BANK_CIF_NO"] = returnHtmlEltValue('buy_out_bank_no_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_AMOUNT"] = returnHtmlEltValue('buy_out_deal_amount_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('buyOut_net_credit_to_customer_'
					+ _pageRef);
			params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.NEW_DEAL_AMOUNT"] = returnHtmlEltValue('new_deal_amount_'
					+ _pageRef);
		}
	}

	$
			.ajax({
				url :actionSrc,
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						if (typeof data["_confirm"] != "undefined"
							|| data["_confirm"] != null)
						{

							$('#purchaseAmount_' + _pageRef)
							.attr(
									"prevValue",
									$(
											'#purchaseAmountPreValue_'
													+ _pageRef)
											.val());
							if (data.confirmType == "DEAL_AMOUNT_LESS_THAN_AMOUNT_RANGE_DEFINED_AT_LIMIT")
							{
								_showConfirmMsg(
										data["_confirm"],
										"",
										"onChangePurchaseAmountCorporate",
										{
											addUrlParam : "?islamicCalculatorEventMgmtCO.globalConfirmationFrom=DEAL_AMOUNT_GREATER_THAN_AMOUNT_RANGE_DEFINED_AT_LIMIT"
										}, "Continue", "Cancel");
								_showProgressBar(false);
								return;
							}
							if (data.confirmType == "DEAL_AMOUNT_GREATER_THAN_AMOUNT_RANGE_DEFINED_AT_LIMIT")
							{
								_showConfirmMsg(
										data["_confirm"],
										"",
										"onChangePurchaseAmountCorporate",
										{
											addUrlParam : "?islamicCalculatorEventMgmtCO.globalConfirmationFrom=XXX"
										}, "Continue", "Cancel");
								_showProgressBar(false);
								return;
							}
						}


						$("#financingAmount_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.financingAmount);
						setInputValue(
								"purchaseAmount_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.purchaseAmount);
						// TP#211073; Ramesh; Date 20/08/2014
						if (_pageRef == "M0168")
						{
							// TP#233385; Ramesh; Date 22/10/2014
							$("#capital_amt_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);
							$("#Plan_Principal_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);
						}
						// TP#197054; Ramesh; Date 01/07/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_DEAL_AMOUNT_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);
							// TP# 236345;deepu.mohandas 30/10/2014
							$("#Plan_Principal_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);
						}
						$("#downPaymentAmount_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.downPaymentAmount);
						// $("#annualYieldRate_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.yield);
						setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
						// TP#282715;Arun.R.Variyath;24/03/2015
						setMarginRateFromServer(data.islamicCalculatorEventMgmtCO.margin);
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						setSumofInsuranceCharges();
						resetRepaymentAndBalloonDetails();
						setElementsPreviousValue(resetElements);
//							$('#purchaseAmount_' + _pageRef)
//							.attr(
//									"prevValue",
//									$(
//											'#purchaseAmount_'
//													+ _pageRef)
//											.val());



						// BB150217 - Rescheduling and Loan Buyout CR105585 TP #
						// 412619
						if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
						{
							$("#dealType_Div_" + _pageRef).dialog("destroy");
							$("#dealType_Div_" + _pageRef).remove();
						}
						
						var floatRateCode=		returnHtmlEltValue('lookuptxt_floatingRateCode_' + _pageRef);
						 if(floatRateCode !=null && floatRateCode !=undefined && parseInt(floatRateCode)>0){
							  $("#lookuptxt_floatingRateCode_" + _pageRef).trigger("change");
						 }
						
					}
					else
					{
						resetElementsToPreviousValue(resetElements);
						$('#purchaseAmount' + _pageRef).attr(
								"prevValue", prevValue);
						setInputValue("purchaseAmount_" + _pageRef,
								prevValue);

						// // TP#164431; Ramesh; Date 25/08/2014
						// if (_pageRef == "M0162") {
						// setInputValue("purchaseAmount_" + _pageRef, purAmt);
						// }
						//
						// // TP#253241; Ramesh; Date 28/12/2014
						// if (_pageRef == "M01681") {
						// setInputValue("purchaseAmount_" + _pageRef,
						// prevPurchsAmt);
						// }
					}
					applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
					// THE
					// DECIMAL
					// FORMAT
					// IN
					// ALL
					// AMOUNT
					// FIELDS
				}
			});

	}
	else
	{
		//setInputValue("purchaseAmount_" + _pageRef,prevPurchsAmt);
		setInputValue("purchaseAmount_" + _pageRef, $(
				'#purchaseAmountPreValue_' + _pageRef).val());
	}
}

/*******************************************************************************
 * Method for calling onchange event of DownPaymentPercentage *
 */
function onChangeDownPaymentPercentage()
{
	var resetElements = {};

	resetElements[0] = "financingAmount_" + _pageRef;
	resetElements[1] = "downPaymentAmount_" + _pageRef;
	resetElements[2] = "annualYieldRate_" + _pageRef;
	resetElements[3] = "downPaymentPercentage_" + _pageRef;
	resetElements[4] = "insuranceChargesAmount_" + _pageRef;
	resetElements[5] = "chargeAmount_" + _pageRef;
	resetElements[6] = "totalInsuranceAmount_" + _pageRef;

	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		if ($("#downPaymentPercentage_" + _pageRef).val() == null
				|| $("#downPaymentPercentage_" + _pageRef).val() == undefined
				|| $("#downPaymentPercentage_" + _pageRef).val() == "")
		{
			$("#downPaymentPercentage_" + _pageRef).val("");
			$("#downPaymentAmount_" + _pageRef).val("");
			$("#financingAmount_" + _pageRef).val(
					$("#purchaseAmount_" + _pageRef).val());
			return;
		}
		var params = {};
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.cifNo"] = $(
				"#lookuptxt_cifNo_" + _pageRef).val();
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
				"#paymPeriodNbr_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
				"#paymPeriodicity_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
				"#paymPeriodPos_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
				"#gracePeriod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
				"#gracePeriodicity_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
				"#maintainSalaryAccount_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
				"#downPaymentPercentage_" + _pageRef).val();
		var financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
				.val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		var purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef)
				.val(), {
			format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		var downPaymentAmount = $.parseNumber($(
				"#downPaymentAmount_" + _pageRef).val(), {
			format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
		params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
		params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
		var annualYieldRate = $.parseNumber($("#annualYieldRate_" + _pageRef)
				.val(), {
			format : $("#annualYieldRate_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.annualYieldRate"] = annualYieldRate;
		params["islamicCalculatorEventMgmtCO.yield"] = $(
				"#annualYieldRate_" + _pageRef).val();

		var previous = $('#downPaymentPercentage_' + _pageRef)
				.attr("prevValue")

		// var dealCharges = $("#dealChargesGridTbl_Id_" +
		// _pageRef).jqGrid('getRowData');
		// var dealcharges = JSON.stringify( dealCharges)
		// params["strDealCharges"] = dealcharges;

		// Added deal charges as param - based on issue 0092514
		params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef)
				.jqGrid('getAllRows');

		// BB150217 - Rescheduling and Loan Buyout CR105585
		var dealType = returnHtmlEltValue('dealType_' + _pageRef);
		params["islamicCalculatorEventMgmtCO.dealType"] = dealType;
		if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
		{
			if (dealType == 'T')
			{
				var topUpGridData = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef)
						.jqGrid('getAllRows');
				params["islamicCalculatorEventMgmtCO.topUpGridData"] = topUpGridData;
				params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('net_credit_to_customer_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsTopUpDealVO.TOP_UP_DEAL_AMOUNT"] = returnHtmlEltValue('topup_deal_amount_'
						+ _pageRef);
			}
			if (dealType == 'B')
			{
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_CY"] = returnHtmlEltValue('buy_out_deal_cy_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BANK_CIF_NO"] = returnHtmlEltValue('buy_out_bank_no_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_AMOUNT"] = returnHtmlEltValue('buy_out_deal_amount_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('buyOut_net_credit_to_customer_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.NEW_DEAL_AMOUNT"] = returnHtmlEltValue('new_deal_amount_'
						+ _pageRef);
			}
		}

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeDownPaymentPercentage",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							$("#financingAmount_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);

							// TP#211073; Ramesh; Date 20/08/2014
							if (_pageRef == "M0168")
							{
								// TP#233385; Ramesh; Date 22/10/2014
								$("#capital_amt_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.financingAmount);
								$("#Plan_Principal_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.financingAmount);
							}
							// TP#197054; Ramesh; Date 01/07/2014
							if (_pageRef == "M01681")
							{
								$("#trsdealVO_DEAL_AMOUNT_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.financingAmount);
							}
							$("#downPaymentAmount_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.downPaymentAmount);
//TP#682482; Srikumar; 
							setInputValue('downPaymentPercentage_' + _pageRef, 
									data.islamicCalculatorEventMgmtCO.downPaymentPercentage);							
							setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
							// TP#282715;Arun.R.Variyath;24/03/2015
							setMarginRateFromServer(data.islamicCalculatorEventMgmtCO.margin);
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									"clearGridData", true);
							if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
									&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
							{
								for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
									// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid(
													'addRowData',
													i + 1,
													data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
							}
							setSumofInsuranceCharges();
							resetRepaymentAndBalloonDetails();
							setElementsPreviousValue(resetElements);
						}
						else
						{
							resetElementsToPreviousValue(resetElements);
							setInputValue("downPaymentPercentage_" + _pageRef,
									previous);
						}
						applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
						// THE
						// DECIMAL
						// FORMAT
						// IN
						// ALL
						// AMOUNT
						// FIELDS
					}
				});
	}
	else
	{
		resetElementsToPreviousValue(resetElements);
	}
}

/*******************************************************************************
 * Method for calling onchange event of DownPaymentAmount *
 */
function populateOnChangeSalaryWithBank()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var params = {};

		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
				"#paymPeriodNbr_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
				"#paymPeriodicity_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
				"#paymPeriodPos_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
				"#gracePeriod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
				"#gracePeriodicity_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.cifNo"] = $(
				"#lookuptxt_cifNo_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
				"#maintainSalaryAccount_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeSalaryWithBank",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							// $("#annualYieldRate_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.annualYieldRate);
							setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.annualYieldRate);
							// TP#282715;Arun.R.Variyath;24/03/2015
							setMarginRateFromServer(data.islamicCalculatorEventMgmtCO.margin);
						}
					}
				});
	}
}

/*******************************************************************************
 * Method for calling onchange event of DownPaymentAmount *
 */
function onChangeDownPayment()
{
	var resetElements = {};

	resetElements[0] = "financingAmount_" + _pageRef;
	resetElements[1] = "downPaymentPercentage_" + _pageRef;
	resetElements[2] = "annualYieldRate_" + _pageRef;
	resetElements[3] = "insuranceChargesAmount_" + _pageRef;
	resetElements[4] = "chargeAmount_" + _pageRef;
	resetElements[5] = "totalInsuranceAmount_" + _pageRef;
	// resetElements [3] = "downPaymentAmount_"+_pageRef;//Libin commented as
	// need custom logic

	var prevValue = $("#downPaymentAmount_" + _pageRef).attr("prevValue");
	if (typeof prevValue == "undefined" || prevValue == null)
	{
		prevValue = "";
	}
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var params = {};
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.cifNo"] = $(
				"#lookuptxt_cifNo_" + _pageRef).val();

		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
				"#paymPeriodNbr_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
				"#paymPeriodicity_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
				"#paymPeriodPos_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
				"#gracePeriod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
				"#gracePeriodicity_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
				"#maintainSalaryAccount_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
				"#downPaymentPercentage_" + _pageRef).val();
		var financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
				.val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		var purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef)
				.val(), {
			format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		var downPaymentAmount = $.parseNumber($(
				"#downPaymentAmount_" + _pageRef).val(), {
			format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
		params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
		params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
		params["islamicCalculatorEventMgmtCO.yield"] = $(
				"#annualYieldRate_" + _pageRef).val();
		// TP#164723;Libin;06/11/2014 Libin adding decPoints to server call
		params["islamicCalculatorEventMgmtCO.currencyDecimalPointsForCalc"] = $(
				"#hidden_islamicCalcDecimalFormat_" + _pageRef).val();

		// var dealCharges = $("#dealChargesGridTbl_Id_" +
		// _pageRef).jqGrid('getRowData');
		// var dealcharges = JSON.stringify( dealCharges)
		// params["strDealCharges"] = dealcharges;

		// Added deal charges as param - based on issue 0092514
		params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef)
				.jqGrid('getAllRows');

		// BB150217 - Rescheduling and Loan Buyout CR105585
		var dealType = returnHtmlEltValue('dealType_' + _pageRef);
		params["islamicCalculatorEventMgmtCO.dealType"] = dealType;
		if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
		{
			if (dealType == 'T')
			{
				var topUpGridData = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef)
						.jqGrid('getAllRows');
				params["islamicCalculatorEventMgmtCO.topUpGridData"] = topUpGridData;
				params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('net_credit_to_customer_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsTopUpDealVO.TOP_UP_DEAL_AMOUNT"] = returnHtmlEltValue('topup_deal_amount_'
						+ _pageRef);
			}
			if (dealType == 'B')
			{
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_CY"] = returnHtmlEltValue('buy_out_deal_cy_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BANK_CIF_NO"] = returnHtmlEltValue('buy_out_bank_no_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_AMOUNT"] = returnHtmlEltValue('buy_out_deal_amount_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('buyOut_net_credit_to_customer_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.NEW_DEAL_AMOUNT"] = returnHtmlEltValue('new_deal_amount_'
						+ _pageRef);
			}
		}

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeDownPayment",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							$("#financingAmount_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.financingAmount);

							// TP#211073; Ramesh; Date 20/08/2014
							if (_pageRef == "M0168")
							{
								// TP#233385; Ramesh; Date 22/10/2014
								$("#capital_amt_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.financingAmount);
								$("#Plan_Principal_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.financingAmount);
							}

							// TP#197054; Ramesh; Date 01/07/2014
							if (_pageRef == "M01681")
							{
								$("#trsdealVO_DEAL_AMOUNT_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.financingAmount);
							}
							// setInputValue("financingAmount_"+
							// _pageRef,data.islamicCalculatorEventMgmtCO.financingAmount);
//TP#682482; Srikumar; Restricting to 2 decimal places 
							setInputValue('downPaymentPercentage_' + _pageRef, 
									data.islamicCalculatorEventMgmtCO.downPaymentPercentage);							
							setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
							// TP#282715;Arun.R.Variyath;24/03/2015
							setMarginRateFromServer(data.islamicCalculatorEventMgmtCO.margin);
							// $("#annualYieldRate_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.yield);
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									"clearGridData", true);
							if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
									&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
							{
								for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
									// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid(
													'addRowData',
													i + 1,
													data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
							}
							setSumofInsuranceCharges();
							resetRepaymentAndBalloonDetails();
							setElementsPreviousValue(resetElements);
							// TP#164723;Libin;06/11/2014 Added to manage
							// prevValue issue
							$('#downPaymentAmount_' + _pageRef).attr(
									"prevValue",
									$('#downPaymentAmount_' + _pageRef).val());
						}
						else
						{
							resetElementsToPreviousValue(resetElements);
							// TP#164723;Libin;06/11/2014 Added to manage
							// prevValue issue
							$('#downPaymentAmount_' + _pageRef).attr(
									"prevValue", prevValue);
							$('#downPaymentAmount_' + _pageRef).val(prevValue);
						}
						applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
						// THE
						// DECIMAL
						// FORMAT
						// IN
						// ALL
						// AMOUNT
						// FIELDS
					}
				});
	}
	else
	{
		resetElementsToPreviousValue(resetElements);
		$('#downPaymentAmount_' + _pageRef).attr("prevValue", prevValue);
		$('#downPaymentAmount_' + _pageRef).val(prevValue);
	}
}

/*******************************************************************************
 * Method for calling onchange event of onChangeFinancingAmount *
 */
function onChangeFinancingAmount(confirm, arg)
{

	var resetElements = {};

	resetElements[0] = "downPaymentAmount_" + _pageRef;
	resetElements[1] = "annualYieldRate_" + _pageRef;
	resetElements[2] = "downPaymentPercentage_" + _pageRef;
	resetElements[3] = "insuranceChargesAmount_" + _pageRef;
	resetElements[4] = "chargeAmount_" + _pageRef;
	resetElements[5] = "totalInsuranceAmount_" + _pageRef;
	// resetElements [0] = "financingAmount_"+_pageRef;Libin commented as need
	// custom logic

	if (confirm)
	{
		var actionSrc;
		if (arg != "undefined" && arg != null)
		{
			if (arg.addUrlParam != "undefined" && arg.addUrlParam != null)
			{
				actionSrc = arg.actionURL + arg.addUrlParam;
			}
		}
		else
		{
			actionSrc = $.contextPath
					+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeFinancingAmount";
		}

		var prevValue = $("#financingAmount_" + _pageRef).attr("prevValue");
		$('#financingAmountPreValue_' + _pageRef).val(prevValue);
		if (typeof prevValue == "undefined" || prevValue == null)
		{
			prevValue = "";
		}
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
		{
			var params = {};
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#lookuptxt_currencyCode_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.productClass"] = $(
					"#lookuptxt_productClass_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.cifNo"] = $(
					"#lookuptxt_cifNo_" + _pageRef).val();
			if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
					|| calculator_type == "BILLS_CALCULATOR")
			{
				params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
						"#plan_maturity_date_" + _pageRef).val();
			}
			else
			{
				params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
						"#maturityDate_" + _pageRef).val();
			}

			params["islamicCalculatorEventMgmtCO.startDate"] = $(
					"#startDate_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
					"#noOfPayments_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
					"#paymPeriodNbr_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
					"#paymPeriodicity_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
					"#paymPeriodPos_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
					"#gracePeriod_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
					"#gracePeriodicity_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
					"#maintainSalaryAccount_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
					"#downPaymentPercentage_" + _pageRef).val();
			var financingAmount = $.parseNumber($(
					"#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
			var purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef)
					.val(), {
				format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
			var downPaymentAmount = $.parseNumber($(
					"#downPaymentAmount_" + _pageRef).val(), {
				format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
			params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
			params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
			params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;

			var profitAmount = $.parseNumber($("#profit_" + _pageRef).val(), {
				format : $("#profit_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
			params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = $(
					"#profitCalcMethod_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.profit"] = profitAmount;
			params["islamicCalculatorEventMgmtCO.yield"] = $(
					"#annualYieldRate_" + _pageRef).val();
			// TP#164514;Libin;07/11/2014 Libin adding decPoints to server call
			params["islamicCalculatorEventMgmtCO.currencyDecimalPointsForCalc"] = $(
					"#hidden_islamicCalcDecimalFormat_" + _pageRef).val();

			// BB150217 - Rescheduling and Loan Buyout CR105585
			var dealType = returnHtmlEltValue('dealType_' + _pageRef);
			params["islamicCalculatorEventMgmtCO.dealType"] = dealType;
			if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
			{
				if (dealType == 'T')
				{
					var topUpGridData = $(
							"#tradeTopUpDetailGridTbl_Id_" + _pageRef).jqGrid(
							'getAllRows');
					params["islamicCalculatorEventMgmtCO.topUpGridData"] = topUpGridData;
					params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('net_credit_to_customer_'
							+ _pageRef);
					params["islamicCalculatorEventMgmtCO.trsTopUpDealVO.TOP_UP_DEAL_AMOUNT"] = returnHtmlEltValue('topup_deal_amount_'
							+ _pageRef);
				}
				if (dealType == 'B')
				{
					params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_CY"] = returnHtmlEltValue('buy_out_deal_cy_'
							+ _pageRef);
					params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BANK_CIF_NO"] = returnHtmlEltValue('buy_out_bank_no_'
							+ _pageRef);
					params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_AMOUNT"] = returnHtmlEltValue('buy_out_deal_amount_'
							+ _pageRef);
					params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('buyOut_net_credit_to_customer_'
							+ _pageRef);
					params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.NEW_DEAL_AMOUNT"] = returnHtmlEltValue('new_deal_amount_'
							+ _pageRef);
				}
			}
			// var dealCharges = $("#dealChargesGridTbl_Id_" +
			// _pageRef).jqGrid('getRowData');
			// var dealcharges = JSON.stringify( dealCharges)
			// params["strDealCharges"] = dealcharges;

			// Added deal charges as param - based on issue 0092514
			params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef)
					.jqGrid('getAllRows');

			$
					.ajax({
						url : actionSrc,
						type : "post",
						data : params,
						dataType : "json",
						success : function(data)
						{
							if (data["_error"] == null)
							{

								if (typeof data["_confirm"] != "undefined"
										|| data["_confirm"] != null)
								{

									if (data.confirmType == "DEAL_AMOUNT_EXCEED_GENERAL_CUSTOMER_LIMIT")
									{
										_showConfirmMsg(
												data["_confirm"],
												"",
												"onChangeFinancingAmount",
												{
													actionURL : actionSrc,
													addUrlParam : "?islamicCalculatorEventMgmtCO.globalConfirmationFrom=DEAL_AMOUNT_EXCEED_GENERAL_CUSTOMER_LIMIT"
												}, "Continue", "Cancel");
										_showProgressBar(false);
										return;
									}
								}

								// setInputValue("purchaseAmount_"+
								// _pageRef,data.islamicCalculatorEventMgmtCO.purchaseAmount);
								// setInputValue("downPaymentAmount_"+
								// _pageRef,data.islamicCalculatorEventMgmtCO.downPaymentAmount);
								$("#purchaseAmount_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.purchaseAmount);
								$("#downPaymentAmount_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.downPaymentAmount);
								setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
								// TP#282715;Arun.R.Variyath;24/03/2015
								setMarginRateFromServer(data.islamicCalculatorEventMgmtCO.margin);
								// $("#annualYieldRate_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.yield);
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										"clearGridData", true);
								if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
										&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
								{
									for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
										// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
										$("#dealChargesGridTbl_Id_" + _pageRef)
												.jqGrid(
														'addRowData',
														i + 1,
														data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
								}
								setSumofInsuranceCharges();
								resetRepaymentAndBalloonDetails();
								setElementsPreviousValue(resetElements);
								// TP#164514;Libin;06/11/2014 Added to manage
								// prevValue issue
								$('#financingAmount_' + _pageRef)
										.attr(
												"prevValue",
												$(
														'#financingAmount_'
																+ _pageRef)
														.val());
								if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
										&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
									_showErrorMsg(
											data.islamicCalculatorEventMgmtCO.confirmationMessageId,
											warning_msg_title);
								$("#Plan_Principal_" + _pageRef).val(
										financingAmount);

							}
							else
							{
								resetElementsToPreviousValue(resetElements);
								// TP#164514;Libin;06/11/2014 Added to manage
								// prevValue issue
								$('#financingAmount_' + _pageRef).attr(
										"prevValue", prevValue);
								$('#financingAmount_' + _pageRef)
										.val(prevValue);
							}
							applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
							// THE
							// DECIMAL
							// FORMAT
							// IN
							// ALL
							// AMOUNT
							// FIELDS
						}
					});
		}
		else
		{
			resetElementsToPreviousValue(resetElements);
			$('#financingAmount_' + _pageRef).attr("prevValue", prevValue);
			$('#financingAmount_' + _pageRef).val(prevValue);
		}
	}
	else
	{
		setInputValue("financingAmount_" + _pageRef, $(
				'#financingAmountPreValue_' + _pageRef).val());
	}
}

/*******************************************************************************
 * Method for calling onchange event of FirstPaymentAfterPeriodicity
 */
function onChangeFirstPaymentAfterPeriodicity()
{

	var prevVal = $('#gracePeriodicity_' + _pageRef).attr("prevvalue");

	var params = {};

	var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
	var purchaseAmount, financingAmount;
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["_pageRef"] = _pageRef;

	if (rescheduleYn == "Y")
	{
		params["islamicCalculatorEventMgmtCO.rescheduleCalcYN"] = rescheduleYn;
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#hiddenNewOriginalFirstPaymentDate_" + _pageRef).val();
		downPaymentAmount = 0;
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#no_of_payments_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#hidden_deal_cy_" + _pageRef).val();
		financingAmount = $.parseNumber($("#outstanding_amount_" + _pageRef)
				.val(), {
			format : $("#outstanding_amount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		purchaseAmount = $.parseNumber($("#outstanding_amount_" + _pageRef)
				.val(), {
			format : $("#outstanding_amount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
				.val(), {
			format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		financingAmount = $
				.parseNumber($("#financingAmount_" + _pageRef).val(),
						{
							format : $("#financingAmount_" + _pageRef).attr(
									"nbFormat"),
							locale : "us"
						});
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef).val(),
				{
					format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
					locale : "us"
				});
	}
	if (rescheduleYn != "Y")
	{
		params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
				"#maintainSalaryAccount_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.tempCode"] = $(
				"#lookuptxt_tempCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.yield"] = $.parseNumber($(
				"#annualYieldRate_" + _pageRef).val(), {
			format : $("#annualYieldRate_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
	}
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
	params["islamicCalculatorEventMgmtCO.baloonPercentage"] = $(
			"#baloonPercentage_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeFirstPaymentAfterPeriodicity",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{

					if (data["_error"] == null)
					{
						//TP #678015 - Fawas
						$("#firstPaymentDate_" + _pageRef)
					      .datepicker(
					        "setDate",
					        data.islamicCalculatorEventMgmtCO.firstPaymentDate);

						var confirmChoice = false;
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
						{
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title, function(confirmChoice,
											theArgs)
									{
										setMaturityBasedonHoliday(
												confirmChoice, data);
									});
						}
						else
						{
							setMaturityBasedonHoliday(confirmChoice, data);
						}
						applyAdditionalDynamicDisplay(data["additionalScreenParams"]);
					}
					else
					{
						// Added for #627342
						setInputValue("gracePeriodicity_" + _pageRef, prevVal);
					}
				}
			});

}

/*******************************************************************************
 * Method for calling onchange event for FirstPaymentAfterPeriodicity (checking
 * of setMaturityBasedonHoliday())
 */
function setMaturityBasedonHoliday(confirmChoice, data)
{
	if (!confirmChoice)
	{
		return;
	}
	var params = {};
	var purchaseAmount, financingAmount;
	var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
	params["_pageRef"] = _pageRef;
	if (rescheduleYn == "Y")
	{
		params["islamicCalculatorEventMgmtCO.rescheduleCalcYN"] = rescheduleYn;
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#hidden_deal_cy_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#hiddenNewOriginalFirstPaymentDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#no_of_payments_" + _pageRef).val();
		purchaseAmount = $.parseNumber($("#outstanding_amount_" + _pageRef)
				.val(), {
			format : $("#outstanding_amount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		financingAmount = $.parseNumber($("#outstanding_amount_" + _pageRef)
				.val(), {
			format : $("#outstanding_amount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
		purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef).val(),
				{
					format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		financingAmount = $
				.parseNumber($("#financingAmount_" + _pageRef).val(),
						{
							format : $("#financingAmount_" + _pageRef).attr(
									"nbFormat"),
							locale : "us"
						});
		params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef)
				.jqGrid('getAllRows');
	}
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.tempCode"] = $(
			"#lookuptxt_tempCode_" + _pageRef).val();
	// params["islamicCalculatorEventMgmtCO.maturityDate"] =
	// $("#maturityDate_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
			"#maintainSalaryAccount_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.baloonPercentage"] = $(
			"#baloonPercentage_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = confirmChoice;

	// Added deal charges as param - based on issue 0092514

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_setMaturityBasedonHoliday",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						// IE-8 fix
						$("#firstPaymentDate_" + _pageRef)
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.firstPaymentDate);
						if (_pageRef == "M0168")
						{
							$("#plan_maturity_date_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						else
						{
							$("#maturityDate_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						setInputValue(
								"gracePeriodicity_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriodicity);
						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_MATURITY_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}

						setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						setSumofInsuranceCharges();
						applyAdditionalDynamicDisplay(data["additionalScreenParams"]);
					}
				}
			});
	if (data.islamicCalculatorEventMgmtCO.firstPaymentDate == undefined
			|| data.islamicCalculatorEventMgmtCO.firstPaymentDate == null)
		hideShowRepaymentNavigator(false);
	else
		hideShowRepaymentNavigator(true);
}

/*******************************************************************************
 * Method for calling onchange event of OnChangeFirstPaymentAfter *
 */
// TP#231558;Arun.R.Variyath;15/10/2014 renamed OnChangeFirstPaymentAfter
function onChangeFirstPaymentAfter()
{
	var prevVal = $('#gracePeriod_' + _pageRef).attr("prevvalue");
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();

	var params = {};
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();

	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val()
	}

	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["_pageRef"] = _pageRef;

	var purchaseAmount, financingAmount, downPaymentAmount;
	if (rescheduleYn == "Y")
	{
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#hiddenNewOriginalFirstPaymentDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.rescheduleCalcYN"] = rescheduleYn;
		downPaymentAmount = 0;

		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#no_of_payments_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#hidden_deal_cy_" + _pageRef).val();
		financingAmount = $.parseNumber($("#outstanding_amount_" + _pageRef)
				.val(), {
			format : $("#outstanding_amount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		purchaseAmount = $.parseNumber($("#outstanding_amount_" + _pageRef)
				.val(), {
			format : $("#outstanding_amount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
				.val(), {
			format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		financingAmount = $
				.parseNumber($("#financingAmount_" + _pageRef).val(),
						{
							format : $("#financingAmount_" + _pageRef).attr(
									"nbFormat"),
							locale : "us"
						});
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef).val(),
				{
					format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		params["islamicCalculatorEventMgmtCO.tempCode"] = $(
				"#lookuptxt_tempCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
				"#downPaymentPercentage_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
				"#maintainSalaryAccount_" + _pageRef).val();
		if (_pageRef != "M0162" && _pageRef != "M0166")
		{
			params["islamicCalculatorEventMgmtCO.yield"] = $.parseNumber($(
					"#annualYieldRate_" + _pageRef).val(), {
				format : $("#annualYieldRate_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
		}
	}

	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
	params["islamicCalculatorEventMgmtCO.baloonPercentage"] = $(
			"#baloonPercentage_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeFirstPaymentAfter",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						// IE-8 fix

						$("#firstPaymentDate_" + _pageRef)
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.firstPaymentDate);
						// TP#231558;Arun.R.Variyath;15/10/2014

						if (_pageRef == "M0168")
						{
							setInputValue(
									"actual_grace_period_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.gracePeriodActual);
						}

						if (rescheduleYn == "Y")
						{

							$("#no_of_payments_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.noOfPayments);
							// TP#200206; Ramesh; Date 21/08/2014
							if (_pageRef == "M0165")
							{
								$("#plan_maturity_date_" + _pageRef)
										.datepicker(
												"setDate",
												data.islamicCalculatorEventMgmtCO.maturityDate);
							}

						}
						else
						{
							if (_pageRef == "M0168")
							{
								$("#plan_maturity_date_" + _pageRef)
										.datepicker(
												"setDate",
												data.islamicCalculatorEventMgmtCO.maturityDate);
							}
							else
							{
								$("#maturityDate_" + _pageRef)
										.datepicker(
												"setDate",
												data.islamicCalculatorEventMgmtCO.maturityDate);
							}

							// TP#193281; Ramesh; Date 25/06/2014
							if (_pageRef == "M01681")
							{
								$("#trsdealVO_MATURITY_DATE_" + _pageRef)
										.datepicker(
												"setDate",
												data.islamicCalculatorEventMgmtCO.maturityDate);
							}
						}

						setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
						if (data.islamicCalculatorEventMgmtCO.firstPaymentDate == undefined
								|| data.islamicCalculatorEventMgmtCO.firstPaymentDate == null)
							hideShowRepaymentNavigator(false);
						else
							hideShowRepaymentNavigator(true);
						applyAdditionalDynamicDisplay(data["additionalScreenParams"]);
					}
					else
					{
						setInputValue("gracePeriod_" + _pageRef, prevVal);

					}
				}
			});

}

function islamicCalculator_checkYieldGreaterThanTieRate( args)
{
	
	var column =  args.column;
	var COValues = args.islamicCalculatorEventMgmtCO;
	var prevMargin = args.prevMargin ;
	var prevFloatingRate = args.prevFloatingRate ; 
	var yieldval = args.yieldval
	
	var params = {};
	params["islamicCalculatorEventMgmtCO.currencyCode"]		= 	$("#lookuptxt_currencyCode_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"]		= 	$("#lookuptxt_productClass_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"]			=	$("#lookuptxt_cifNo_"+_pageRef).val();		
	params["islamicCalculatorEventMgmtCO.startDate"]		=	$("#startDate_"+_pageRef).val();
			
			
	params["islamicCalculatorEventMgmtCO.financingAmount"]	=	 COValues.financingAmount;		
	params["islamicCalculatorEventMgmtCO.noOfPayments"]		=	$("#noOfPayments_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"]	=	$("#paymPeriodicity_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"]	=	$("#paymPeriodPos_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"]		=	$("#gracePeriod_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"]	=	$("#gracePeriodicity_"+_pageRef).val();
	if(column == "ANNUAL_YIELD"){
		params["islamicCalculatorEventMgmtCO.annualYieldRate"]	= COValues.annualYieldRate;
	}else{
		params["islamicCalculatorEventMgmtCO.annualYieldRate"]	= COValues.yield;
	}
	
	
	params["islamicCalculatorEventMgmtCO.margin"]			= COValues.margin;			
	params["islamicCalculatorEventMgmtCO.floatingRate"]		= COValues.floatingRate;
	params["islamicCalculatorEventMgmtCO.yieldFlag"]		= "A";

			
	params["islamicCalculatorEventMgmtCO.maturityDate"]			= COValues.maturityDate;
			
	params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = 	$("#profitCalcMethod_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.profit"] 			= 	COValues.profit;	
	params["islamicCalculatorEventMgmtCO.yield"] 			= 	COValues.yield;
	params["islamicCalculatorEventMgmtCO.totalYield"]			= COValues.totalYield;
	
			
	
	var src = $.contextPath+"/path/islamicCalculator/islamicCalculatorEventMgmt_checkYieldGreaterThanTieRate";
		
		_showProgressBar(true);
		$.ajax( {
					url : src,
					type : "post",
					dataType : "json",
					data : params,
					success : function(data) {
						if (data["_error"] == null) {
							
							if (typeof data["_confirm"] != "undefined"	|| data["_confirm"] != null) 
							{
							_showConfirmMsg(
											data["_confirm"]+ '  ' + Do_you_want_to_proceed_key,
											data["_msgTitle"],
											"islamicCalulator_afterCheckYieldGreaterThanTieRate",
											{islamicCalculatorEventMgmtCO :data.confirmReturn,
											yieldval:yieldval,	
											column :column,
											prevMargin:prevMargin, 
											prevFloatingRate:prevFloatingRate}, "Yes", "No"
									);
									_showProgressBar(false);
									return;
							}else{
								
							islamicCalulator_afterCheckYieldGreaterThanTieRate(true,{islamicCalculatorEventMgmtCO :data.islamicCalculatorEventMgmtCO,
											yieldval:yieldval,
											column :column,
											prevMargin:prevMargin, 
											prevFloatingRate:prevFloatingRate });					
							}
						}
						else
						{
							if(column == "ANNUAL_YIELD"){
								setInputValue("annualYieldRate_" + _pageRef, yieldval);	
							}else{
								setInputValue("margin_" + _pageRef, prevMargin);	
								setInputValue("floatingRate_" + _pageRef, prevFloatingRate);	
								
							}
							_showProgressBar(false);
								
						}
					}
				});
		
	
}

/*******************************************************************************
 * Method for calling onchange event of onChangeYield *
 */
function onChangeYield()
{

	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{

		var params = {};
		if (calculator_type == "BILLS_CALCULATOR")
		{

			params["strNIDCDetail"] = $("#NIDCDetail_Id_" + _pageRef).jqGrid(
					'getAllRows');
			params["NIDCCouponPayment"] = $(
					"#NIDCCouponPaymentDet_Id_" + _pageRef)
					.jqGrid('getAllRows');

			params["islamicCalculatorEventMgmtCO.trsdealNIDCVO.ISSUE_AT_TYPE"] = $(
					"#ISSUE_AT_TYPE_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.accrualBasis"] = $(
					"#accrualBasis_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.price"] = $(
					"#Price_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.valueDate"] = $(
					"#Value_Date_" + _pageRef).val();

			var yieldrate = $("#annualYieldRate_" + _pageRef).val();

			$("#annualFlatRate_" + _pageRef).val(yieldrate);

		}
		// TP#164974; Ramesh; Date 14/07/2014 [START]
		var yieldval = $('#annualYieldRate_' + _pageRef).attr("prevValue");
		// TP#164974; Ramesh; Date 14/07/2014 [START]
		// var criteriaLength =
		// data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVO.length;

		params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.cifNo"] = $(
				"#lookuptxt_cifNo_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();

		var financingAmount = returnHtmlEltValue('financingAmount_'+ _pageRef);
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
				"#paymPeriodicity_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
				"#paymPeriodPos_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
				"#gracePeriod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
				"#gracePeriodicity_" + _pageRef).val();
		var annualYieldRate = returnHtmlEltValue('annualYieldRate_'+ _pageRef);
		var margin = returnHtmlEltValue('margin_'+ _pageRef);
		var floatingRate = returnHtmlEltValue('floatingRate_'+ _pageRef);

		params["islamicCalculatorEventMgmtCO.annualYieldRate"] = annualYieldRate;
		params["islamicCalculatorEventMgmtCO.margin"] = margin;
		params["islamicCalculatorEventMgmtCO.floatingRate"] = floatingRate;
		params["islamicCalculatorEventMgmtCO.yieldFlag"] = "A";
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		var profitAmount = $.parseNumber($("#profit_" + _pageRef).val(), {
			format : $("#profit_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = $(
				"#profitCalcMethod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.profit"] = profitAmount;
		params["islamicCalculatorEventMgmtCO.yield"] = $(
				"#annualYieldRate_" + _pageRef).val();
		// TP# 222800 BM140006 - Limit for Yield Roster in IIS Sreejith
		params["iisCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
				"#maintainSalaryAccount_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.tempCode"] = $(
				"#lookuptxt_tempCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.baloonPercentage"] = $(
				"#baloonPercentage_" + _pageRef).val();
		// TP# 222800 BM140006 - Limit for Yield Roster in IIS end Sreejith
		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeYield",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							islamicCalculator_checkYieldGreaterThanTieRate({ islamicCalculatorEventMgmtCO :data.islamicCalculatorEventMgmtCO,
											column :'ANNUAL_YIELD', yieldval:yieldval })
											
							if (calculator_type == "BILLS_CALCULATOR")
							{
									// $("#Price_" + /*_pageRef)
									// .val(
									// data*/.islamicCalculatorEventMgmtCO.price);

									setInputValue(
											"Price_" + _pageRef,
											data.islamicCalculatorEventMgmtCO.price);

							}
							// TP# 222800 BM140006 - Limit for Yield Roster in
							// IIS Sreejith
							islamicCalculator_showInformationMessage(data.islamicCalculatorEventMgmtCO.informationMessageList);
						}
						else
						{

							// TP#164974; Ramesh; Date 14/07/2014 [START]
							// TP#204571; Ramesh; Date 22/07/2014 [Added M0166
							// condition]
							if ((_pageRef == "M0162") || (_pageRef == "M0166"))
							{
								setInputValue("annualYieldRate_" + _pageRef,
										yieldval);

							}
							// TP#164974; Ramesh; Date 14/07/2014 [END]
							else
							{
								// resetToPreviousValue("annualYieldRate_"+_pageRef);
								// TP# 245195;Ravikant.Singh ;02/12/2014
								setInputValue("annualYieldRate_" + _pageRef,
										yieldval);
							}
						}
						applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
						// THE
						// DECIMAL
						// FORMAT
						// IN
						// ALL
						// AMOUNT
						// FIELDS
					}
				});
	}
	else
	{
		resetToPreviousValue("annualYieldRate_" + _pageRef);
	}
}

function islamicCalulator_afterCheckYieldGreaterThanTieRate(confirm, args)
	{
	
	var islamicCalculatorEventMgmtCO = args.islamicCalculatorEventMgmtCO;
	var column = args.column;
	var yieldval = args.yieldval;
	var prevMargin = args.prevMargin
	var prevFloatingRate = args.prevFloatingRate
	
	if(!confirm){
		var prevValueTrfAmt = $("#hidden_YieldToReset_" + _pageRef).val();
		if(column == "ANNUAL_YIELD"){
			setInputValue("annualYieldRate_" + _pageRef, yieldval);	
		}else{
			
			
			setInputValue("margin_" + _pageRef, prevMargin);	
			setInputValue("floatingRate_" + _pageRef, prevFloatingRate);	
		}
		
		return;
	}
	if(column == "ANNUAL_YIELD"){
		
		if(islamicCalculatorEventMgmtCO!=undefined && islamicCalculatorEventMgmtCO!= null ){
			
			// TP#212782; Ramesh; Date 27/09/2014
			if((islamicCalculatorEventMgmtCO.confirmationMessageId != null) && (islamicCalculatorEventMgmtCO.confirmationMessageId != "") && (islamicCalculatorEventMgmtCO.confirmationMessageId != undefined))
			{
				
				var margin = (islamicCalculatorEventMgmtCO.margin);
				var annualFlatRate = (islamicCalculatorEventMgmtCO.totalYield);
				var msg = islamicCalculatorEventMgmtCO.confirmationMessageId;
				_showConfirmMsg(msg, "Title",
					setYielValuesAfterConfirmation, {
										yieldval : yieldval,
										margin : margin,
										annualFlatRate : annualFlatRate
										});
									
								 
			 }
			
			//$("#margin_"+_pageRef).val(islamicCalculatorEventMgmtCO.margin);
			//$("#annualFlatRate_"+_pageRef).val(islamicCalculatorEventMgmtCO.totalYield);
			setInputValue("margin_" + _pageRef, islamicCalculatorEventMgmtCO.margin);	
			setInputValue("annualFlatRate_" + _pageRef, islamicCalculatorEventMgmtCO.totalYield);	
			}
		//alert(yieldval);
		//setInputValue("annualYieldRate_" + _pageRef, yieldval);	
						//setPreviousValue("annualYieldRate_"+_pageRef);
	}else{
		
		if(islamicCalculatorEventMgmtCO!=null && islamicCalculatorEventMgmtCO!=undefined){
		//$("#annualYieldRate_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.yield);
			setAnnualYieldRateFromServer(islamicCalculatorEventMgmtCO.annualYieldRate);
			$("#annualFlatRate_"+_pageRef).val(islamicCalculatorEventMgmtCO.totalYield);
			setInputValue("margin_" + _pageRef, islamicCalculatorEventMgmtCO.margin);	
			setInputValue("floatingRate_" + _pageRef, islamicCalculatorEventMgmtCO.floatingRate);	
			//setElementsPreviousValue(resetElements);//Setting the new value as prev value for margin floatingrate,annualyield
		}
	}
	
	_showProgressBar(false);
}
	
// TP# 222800 BM140006 - Limit for Yield Roster in IIS Sreejith
function islamicCalculator_showInformationMessage(confirmMessagesList)
{

	if (confirmMessagesList != null)
	{
		for (var i = 0; i < confirmMessagesList.length; i++)
		{
			_showErrorMsg(confirmMessagesList[i], info_msg_title);
		}
		return;
	}
}

// TP#212782; Ramesh; Date 27/09/2014
function setYielValuesAfterConfirmation(confirm, args)
{
	if (confirm)
	{
		$("#margin_" + _pageRef).val(args.margin);
		$("#annualFlatRate_" + _pageRef).val(args.annualFlatRate);
	}
	else
	{
		$("#margin_" + _pageRef).val(args.yieldval);
		$("#annualFlatRate_" + _pageRef).val(args.yieldval);
	}
}

/*******************************************************************************
 * Method for calling onchange event of onChangeCurrencyCode *
 */
function onChangeCurrencyCode()
{
	// TP#462168; Saheer.Naduthodi; 03/01/2017
	// if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid()) {

	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	// if($("#lookuptxt_currencyCode_"+_pageRef).val()=="")
	// {
	// $("#purchaseAmount_"+_pageRef).attr("readonly", "true");
	// }
	// else
	// {
	// $("#purchaseAmount_"+_pageRef).attr("readonly", "false");
	// }
	var params = {};

	// var criteriaLength =
	// data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVO.length;

	params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;
	if (calculator_type == "BILLS_CALCULATOR")
	{

		params["islamicCalculatorEventMgmtCO.trsdealNIDCVO.ISSUE_AT_TYPE"] = $(
				"#ISSUE_AT_TYPE_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.trsdealNIDCVO.COUPON_PAYMENT_TYPE"] = $(
				"#COUPON_PAYMENT_TYPE_" + _pageRef).val();
		params["strNIDCDetail"] = $("#NIDCDetail_Id_" + _pageRef).jqGrid(
				'getAllRows');
		params["strNIDCCouponPayment"] = $(
				"#NIDCCouponPaymentDet_Id_" + _pageRef).jqGrid('getAllRows');

		params["islamicCalculatorEventMgmtCO.valueDate"] = $(
				"#Value_Date_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.yield"] = $(
				"#Annual_Discount_Rate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.accrualBasis"] = $(
				"#accrualBasis_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.tradingCurrency"] = $(
				"#lookuptxt_tradingCurrency_" + _pageRef).val();

	}
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
			"#noOfPayments_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
			"#maintainSalaryAccount_" + _pageRef).val();

	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	var purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef).val(),
			{
				format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
	// Added deal charges as param - based on issue 0092514
	params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeCurrencyCode",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
						// TP#282715;Arun.R.Variyath;24/03/2015
						setMarginRateFromServer(data.islamicCalculatorEventMgmtCO.margin);
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title, "calculateDealCharges",
									"yesNo");
						setSumofInsuranceCharges();
						setRepaymentFormat();
						// TP #412619; BB150217 - Rescheduling and Loan Buyout CR105585
						if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
						{
							$("#dealType_Div_" + _pageRef).dialog("destroy");
							$("#dealType_Div_" + _pageRef).remove();
						}
					}else{
						setInputValue("lookuptxt_currencyCode_"	+ _pageRef,
								returnHtmlEltValue('preValue_'	+ _pageRef));
						setInputValue("currencyDesc_"	+ _pageRef,
								returnHtmlEltValue('preValueDesc_'	+ _pageRef));
					}
					applyAdditionalDynamicDisplay(data["additionalScreenParams"]);


				}
			});
	// }
}

/*******************************************************************************
 * Method for calling onChangeTempCode
 */
function onChangeTemplateCode()
{
	// TP#462171; Saheer.Naduthodi; 27/12/2016
	if (1 == 1)// if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var templateCode = $("#lookuptxt_tempCode_" + _pageRef).val();

		var grid = $("#dealChargesGridTbl_Id_" + _pageRef);
		var rowIds = grid.jqGrid('getDataIDs');
		for (var i = 0; i < rowIds.length; i++)
		{
			var myObject = grid.jqGrid('getRowData', rowIds[i]);
			var chargeCode = myObject["CHARGES_CODE"];
			if (chargeCode == "")
			{
				$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('delRowData',
						rowIds[i]);

			}
		}
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);

		if (templateCode != undefined && templateCode != null
				&& templateCode != '')
		{
			var params = {};
			params["islamicCalculatorEventMgmtCO.tempCode"] = $(
					"#lookuptxt_tempCode_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
					"#lookuptxt_currencyCode_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.startDate"] = $(
					"#startDate_" + _pageRef).val();
			if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
					|| calculator_type == "BILLS_CALCULATOR")
			{
				params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
						"#plan_maturity_date_" + _pageRef).val();
			}
			else
			{
				params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
						"#maturityDate_" + _pageRef).val();
			}

			params["islamicCalculatorEventMgmtCO.productClass"] = $(
					"#lookuptxt_productClass_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.cifNo"] = $(
					"#lookuptxt_cifNo_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
					"#paymPeriodNbr_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
					"#paymPeriodicity_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
					"#paymPeriodPos_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
					"#gracePeriod_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
					"#gracePeriodicity_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.baloonPercentage"] = $(
					"#baloonPercentage_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
					"#noOfPayments_" + _pageRef).val();
			var financingAmount = $.parseNumber($(
					"#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
			params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
			params["islamicCalculatorEventMgmtCO.dealAmount"] = financingAmount;
			var downPaymentAmount = $.parseNumber($(
					"#downPaymentAmount_" + _pageRef).val(), {
				format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});

			params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
			params["islamicCalculatorEventMgmtCO.yield"] = $(
					"#annualYieldRate_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
					"#firstPaymentDate_" + _pageRef).val();

			// var dealCharges = $("#dealChargesGridTbl_Id_" +
			// _pageRef).jqGrid('getRowData');
			// var dealcharges = JSON.stringify( dealCharges)
			// params["strDealCharges"] = dealcharges;

			// Added deal charges as param - based on issue 0092514
			params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef)
					.jqGrid('getAllRows');
			// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
			params["islamicCalculatorEventMgmtCO.flexiPaymentYn"] = returnHtmlEltValue('flexiPaymentYN_CheckBox_'
					+ _pageRef);
			// BB160136; Saheer.Naduthodi; 20/04/2017 [End]

			$
					.ajax({
						url : $.contextPath
								+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeTemplateCode",
						type : "post",
						data : params,
						dataType : "json",
						success : function(data)
						{
							if (data["_error"] == null)
							{
								$("#profitCalcMethod_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.profitCalcMethod);
								$("#profitRecognitionMethod_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.profitDistMethod);
								setPeriodicityDetails(data.islamicCalculatorEventMgmtCO.paymPeriodicity);
								$("#paymPeriodNbr_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.paymPeriodNbr);
								$("#paymPeriodPos_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.paymPeriodPos);
								setInputValue(
										"gracePeriod_" + _pageRef,
										data.islamicCalculatorEventMgmtCO.gracePeriod);
								setInputValue(
										"gracePeriodicity_" + _pageRef,
										data.islamicCalculatorEventMgmtCO.gracePeriodicity);

								$("#baloonAmount_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.baloonAmount);
								// setInputValue("baloonAmount_"+
								// _pageRef,data.islamicCalculatorEventMgmtCO.baloonAmount);
								$("#baloonPaymentNo_" + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.noOfBaloonPayments);
								$('#baloonPercentage_' + _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.baloonPercentage);

								setInputValue(
										'noOfPayments_' + _pageRef,
										data.islamicCalculatorEventMgmtCO.noOfPayments);

								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										"clearGridData", true);
								if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
										&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
								{
									for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
										// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
										$("#dealChargesGridTbl_Id_" + _pageRef)
												.jqGrid(
														'addRowData',
														i + 1,
														data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
								}
								// $("#maturityDate_"+_pageRef).datepicker("setDate",
								// new
								// Date(data.islamicCalculatorEventMgmtCO.maturityDate));
								// IE-8 fix
								if (_pageRef == "M0168"
										|| calculator_type == "AR_RAHANU"
										|| calculator_type == "BILLS_CALCULATOR")
								{

									$("#plan_maturity_date_" + _pageRef)
											.datepicker(
													"setDate",
													data.islamicCalculatorEventMgmtCO.maturityDate);
								}
								else
								{
									$("#maturityDate_" + _pageRef)
											.datepicker(
													"setDate",
													data.islamicCalculatorEventMgmtCO.maturityDate);
								}

								// TP#193281; Ramesh; Date 25/06/2014
								if (_pageRef == "M01681")
								{
									$("#trsdealVO_MATURITY_DATE_" + _pageRef)
											.datepicker(
													"setDate",
													data.islamicCalculatorEventMgmtCO.maturityDate);
								}
								$("#firstPaymentDate_" + _pageRef)
										.datepicker(
												"setDate",
												data.islamicCalculatorEventMgmtCO.firstPaymentDate);
								showBallonDetails(true);
								addBalloonDetailsList(data.islamicCalculatorEventMgmtCO.balloonDetailsList);
								setSumofInsuranceCharges();
								// paymPeriodPosprofit

							}
						}
					});
		}
	}
	else
	{
		$("#templateDesc_" + _pageRef).val("");
		$("#lookuptxt_tempCode_" + _pageRef).val("");
	}
}

/**
 * Method for handling the change event for the start date
 */
function validateOnChangeStartDate()
{

	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	//if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).length > 0)
	{
		var params = {};
		params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;

		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.defaultMaturityDate"] = $(
				"#hidden_defaultMaturityDate_" + _pageRef).val();

		if (calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.tradingCurrency"] = $(
					"#lookuptxt_tradingCurrency_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.trsdealNIDCVO.ISSUE_AT_TYPE"] = $(
					"#ISSUE_AT_TYPE_" + _pageRef).val();
			params["islamicCalculatorEventMgmtCO.accrualBasis"] = returnHtmlEltValue('accrualBasis_'
					+ _pageRef);
		}

		// TP#208366; Ramesh; Date 07/08/2014
		var startDate = $('#startDate_' + _pageRef).attr("prevValue");

		// BB150217 - Rescheduling and Loan Buyout CR105585
		var dealType = returnHtmlEltValue('dealType_' + _pageRef);
		params["islamicCalculatorEventMgmtCO.dealType"] = dealType;
		if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
		{
			if (dealType == 'T')
			{
				var topUpGridData = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef)
						.jqGrid('getAllRows');
				params["islamicCalculatorEventMgmtCO.topUpGridData"] = topUpGridData;
			}
			if (dealType == 'B')
			{
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_CY"] = returnHtmlEltValue('buy_out_deal_cy_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BANK_CIF_NO"] = returnHtmlEltValue('buy_out_bank_no_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.BUY_OUT_DEAL_AMOUNT"] = returnHtmlEltValue('buy_out_deal_amount_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.netCreditToCustomer"] = returnHtmlEltValue('buyOut_net_credit_to_customer_'
						+ _pageRef);
				params["islamicCalculatorEventMgmtCO.trsBuyOutDealVO.NEW_DEAL_AMOUNT"] = returnHtmlEltValue('new_deal_amount_'
						+ _pageRef);
			}
		}

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOnChangeStartDate",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							$("#reschedule_value_date_" + _pageRef).val(
									$("#startDate_" + _pageRef).val());
							var confirmChoice = false;
							if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
									&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
							{
								_showConfirmMsg(
										data.islamicCalculatorEventMgmtCO.confirmationMessageId,
										confirm_msg_title,
										function(confirmChoice, theArgs)
										{
											// confirmcChoice = TRUE : Start
											// date is holiday wanna to continue
											// with new revised date
											// (data.islamicCalculatorEventMgmtCO.startDateAfterHoliday)
											validateOnChangeStartDateOnMaturityDate(confirmChoice);
											// confirmcChoice = FALSE :Start
											// date is
											// holiday but wanna continue with
											// the
											// holiday itself
										});
							}
							else
								// Start date is not holiday
								validateOnChangeStartDateOnMaturityDate(confirmChoice);

						}
						else
						{
							// TP#208366; Ramesh; Date 07/08/2014
							setInputValue("startDate_" + _pageRef, startDate);
							setInputValue("reschedule_value_date_" + _pageRef,
									startDate);
							// TODO for resetting the previous value
							// resetToPreviousValue("startDate_"+_pageRef);
						}
					}
				});
	}
}

function validateOnChangeStartDateOnMaturityDate(confirmChoice)
{

	var params = {};
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.startDateAfterHoliday"] = $(
			'#hidden_startDateAfterHoliday_' + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = $(
			'#hidden_confirmationResult_' + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
			"#noOfPayments_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = confirmChoice;
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.financingAmount"] = $.parseNumber($(
			"#financingAmount_" + _pageRef).val(), {
		format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.checkDefaultMaturityDate"] = $(
			'#hidden_checkDefaultMaturityDate_' + _pageRef).val();
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}
	params["islamicCalculatorEventMgmtCO.defaultMaturityDate"] = $(
			"#hidden_defaultMaturityDate_" + _pageRef).val();
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOnChangeStartDateOnMaturityDate",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						var confirmChoice = false;
						$("#hidden_checkDefaultMaturityDate_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.checkDefaultMaturityDate);
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
						{
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title,
									function(confirmChoice, theArgs)
									{
										// confirmcChoice: TRUE :: Difffernce in
										// the new maturity date for the
										// selected start date with the deafult
										// maturity date
										// which is being sets during onchange
										// of
										// product class and wanna continue with
										// the
										// new maturity date
										onChangeStartDateCalculateMaturityDate(confirmChoice ? "Y"
												: "N");
										// confirmcChoice: FALSE :: Difffernce
										// in
										// the new maturity date for the
										// selected
										// start date with the deafult maturity
										// date
										// which is being sets during onchange
										// of
										// product class and wanna continue with
										// the
										// default maturity date
									});
						}
						else
							// No difference in the new maturity date for the
							// selected start date with the deafult maturity
							// date
							// which is being sets during onchange of product
							// class
							onChangeStartDateCalculateMaturityDate("");

					}

				}
			});
}
function onChangeStartDateCalculateMaturityDate(confirmChoice)
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.maturityDateAfterHoliday"] = $(
			"#hidden_maturityDateAfterHoliday_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	// params["islamicCalculatorEventMgmtCO.downPaymentAmount"] =
	// $("#downPaymentAmount_"+_pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	var downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
			.val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;

	// params["islamicCalculatorEventMgmtCO.confirmationResult"] =
	// confirmChoice;
	params["strConfirm"] = confirmChoice;
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_checkMaturityDateIsHoliday",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						var confirmChoice = false;
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
						{
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title, function(confirmChoice,
											theArgs)
									{
										// The chosen maturity date is a holiday
										// wanna continue with new maturity date
										setOnChangeStartDate(confirmChoice);
										// The chosen maturity date is a holiday
										// wanna continue with old /default
										// maturity
										// date
									});
						}
						else
							setOnChangeStartDate(confirmChoice);
					}
				}
			});
}

function setOnChangeStartDate(confirmChoice)
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = $(
			'#hidden_confirmationResult_' + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.maturityDateAfterHoliday"] = $(
			"#hidden_maturityDateAfterHoliday_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.vatPercentage"] = $(
			"#vatPercentage_" + _pageRef).val();
	// params["islamicCalculatorEventMgmtCO.downPaymentAmount"] =
	// $("#downPaymentAmount_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.vatCode"] = $(
			'#lookuptxt_vatCode_' + _pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{

		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.dealAmount"] = financingAmount;
	var downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
			.val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;

	params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
			"#noOfPayments_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = confirmChoice;

	var profitAmount = $.parseNumber($("#profit_" + _pageRef).val(), {
		format : $("#profit_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = $(
			"#profitCalcMethod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.profit"] = profitAmount;
	params["islamicCalculatorEventMgmtCO.yield"] = $(
			"#annualYieldRate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;

	// Added deal charges as param - based on issue 0092514
	params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_setOnChangeStartDate",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{

						// $("#maturityDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.maturityDate)
						// );
						// $("#startDate_"+_pageRef).datepicker("setDate", new
						// Date(data.islamicCalculatorEventMgmtCO.startDate) );
						// $("#firstPaymentDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.firstPaymentDate)
						// );
						// IE-8 fix
						var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
								+ _pageRef);
						if (_pageRef == "M0168"
								|| calculator_type == "AR_RAHANU"
								|| calculator_type == "BILLS_CALCULATOR")
						{

							$("#plan_maturity_date_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						else
						{
							$("#maturityDate_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}

						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_MATURITY_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						$("#startDate_" + _pageRef).datepicker("setDate",
								data.islamicCalculatorEventMgmtCO.startDate);
						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_DEAL_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.startDate);
						}
						$("#firstPaymentDate_" + _pageRef)
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.firstPaymentDate);

						setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
						// $("#annualYieldRate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.yield) );
						$("#vatPercentage_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.vatPercentage);
						$("#debtBurdanRatio_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.debtBurdanRatio);
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						if (data.islamicCalculatorEventMgmtCO.firstPaymentDate == undefined
								|| data.islamicCalculatorEventMgmtCO.firstPaymentDate == null)
							hideShowRepaymentNavigator(false);
						else
							hideShowRepaymentNavigator(true);
						setSumofInsuranceCharges();
					}
				}
			});
}

/**
 * Method for handling the change event for the Maturity Date
 */
function validateOnChangeMaturityDate()
{
	validateOnChangeMaturityDateConfirm(true);
}
function validateOnChangeMaturityDateConfirm(confirm, args)
{

	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	var prevMaturityDate =  returnHtmlEltValue('preValue_'
			+ _pageRef);   
	var params = {};
	params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = returnHtmlEltValue('purchaseAmount_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.annualYieldRate"] = returnHtmlEltValue('annualYieldRate_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.limitSerialNo"] = returnHtmlEltValue('lookuptxt_limitSerialNo_'
			+ _pageRef);
	// tp #467365

	$('#hiddenNoOfPayments_' + _pageRef).val(
			$("#noOfPayments_" + _pageRef).val());

//	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
//			|| calculator_type == "BILLS_CALCULATOR")
//	{
//		prevMaturityDate = $("#plan_maturity_date_" + _pageRef).attr(
//				"prevvalue");
//	}
//	else
//	{
//		prevMaturityDate = $("#maturityDate_" + _pageRef).attr("prevvalue"); // TP#258960;roshin
//		// ;08/01/2014
//	}
	if (confirm)
	{

		var url = $.contextPath
				+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOnChangeMaturityDate";

		if (args != undefined && args != null
				&& args.addUrlParam != "undefined" && args.addUrlParam != null)
		{
			url = url + args.addUrlParam;
		}

		params["islamicCalculatorEventMgmtCO.cifNo"] = returnHtmlEltValue("lookuptxt_cifNo_"
				+ _pageRef);

		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();

		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}
		params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
				"#firstPaymentDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.checkDefaultMaturityDate"] = $(
				"#hidden_checkDefaultMaturityDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.financingAmount"] = $(
				"#financingAmount_" + _pageRef).val();

		$
				.ajax({
					url : url,
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
									+ _pageRef);
							if (_pageRef == "M0168"
									|| calculator_type == "AR_RAHANU"
									|| calculator_type == "BILLS_CALCULATOR")
							{
								setInputValue("maturity_date_" + _pageRef, $(
										"#plan_maturity_date_" + _pageRef)
										.val());

								// $("#maturity_date_"+_pageRef).val($("#plan_maturity_date_"+_pageRef).val());
							}
							else
							{
								$("#maturity_date_" + _pageRef).val(
										$("#maturityDate_" + _pageRef).val());
							}
							setInputValue(
									"annualYieldRate_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.annualYieldRate);
							// TP# 236345;deepu.mohandas 30/10/2014
							if (_pageRef == "M01681"
									|| calculator_type == "AR_RAHANU"
									|| calculator_type == "BILLS_CALCULATOR")
							{
								// $("#plan_maturity_date_" + _pageRef)
								// .val(
								// data.islamicCalculatorEventMgmtCO.maturityDate);
								setInputValue(
										"plan_maturity_date_" + _pageRef,
										data.islamicCalculatorEventMgmtCO.maturityDate);
							}

							var confirmChoice = false;

							if (typeof data["_confirm"] != "undefined"
									|| data["_confirm"] != null)
							{

								if (data.confirmType == "TOTAL_PERIODS_EXCEEDS_COUNTER_PARTY_TENURE_PERIOD")
								{

									_showConfirmMsg(
											data["_confirm"],
											data["_msgTitle"],
											"validateOnChangeMaturityDateConfirm",
											{
												addUrlParam : "?islamicCalculatorEventMgmtCO.globalConfirmationFrom=JS"
											}, "Yes", "No");
									_showProgressBar(false);
									return;
								}

							}
//							if ((data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
//									&& (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined))
//							{
//								// set the check default maturity date to the
//								// hidden variable
//								$(
//										"#hidden_checkDefaultMaturityDate_"
//												+ _pageRef)
//										.val(
//												data.islamicCalculatorEventMgmtCO.checkDefaultMaturityDate);
//								_showConfirmMsg(
//										data.islamicCalculatorEventMgmtCO.confirmationMessageId,
//										confirm_msg_title,
//										function(confirmChoice, theArgs)
//										{
//											// Confirm yes: Pass maturity date
//											// Confirm No: Pass default maturity
//											// date
//
//											if (_pageRef == "M0168"
//													|| calculator_type == "AR_RAHANU"
//													|| calculator_type == "BILLS_CALCULATOR")
//											{
//												onChangeMaturityDate((confirmChoice == true) ? $(
//														"#plan_maturity_date_"
//																+ _pageRef)
//														.val()
//														: $(
//																"#hidden_defaultMaturityDate_"
//																		+ _pageRef)
//																.val());
//											}
//											else
//											{
//												onChangeMaturityDate((confirmChoice == true) ? $(
//														"#maturityDate_"
//																+ _pageRef)
//														.val()
//														: $(
//																"#hidden_defaultMaturityDate_"
//																		+ _pageRef)
//																.val());
//											}
//
//										});
//							}
//							else
							// No confirm messages - then pass maturity
							// date
//							{

//								var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
//										+ _pageRef);
//								if (_pageRef == "M0168"
//										|| calculator_type == "AR_RAHANU"
//										|| calculator_type == "BILLS_CALCULATOR")
//								{
//									onChangeMaturityDate($(
//											"#plan_maturity_date_" + _pageRef)
//											.val());
//								}
//								else
//								{
//									onChangeMaturityDate($(
//											"#maturityDate_" + _pageRef).val());
//								}
//							}

						}
						else
						{

							if (_pageRef == "M0168"
									|| calculator_type == "AR_RAHANU"
									|| calculator_type == "BILLS_CALCULATOR")
							{

								setInputValue("plan_maturity_date_" + _pageRef,

								prevMaturityDate);
							}
							else
							{
								$("#maturityDate_" + _pageRef).datepicker(
										"setDate", prevMaturityDate);
							}

						}

					}
				});
	}
	else
	{
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{

			setInputValue("plan_maturity_date_" + _pageRef, prevMaturityDate);
		}
		else
		{
			$("#maturityDate_" + _pageRef).datepicker("setDate",
					prevMaturityDate);
		}
	}

}

function onChangeMaturityDate()
{
	
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168"
			|| calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		maturityDate =$("#plan_maturity_date_" + _pageRef).val();
		;
	}
	else
	{
		maturityDate =$("#maturityDate_" + _pageRef).val();
		
	}
	
	
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
		|| calculator_type == "BILLS_CALCULATOR")
		{
					
			setInputValue("preValue_" + _pageRef,  $("#plan_maturity_date_" + _pageRef).attr(
			"prevvalue"));
		}
		else
		{
			
			setInputValue("preValue_" + _pageRef, $("#maturityDate_" + _pageRef).attr("prevvalue"));
		}
	
	
	$("#hidden_checkDefaultMaturityDate_"	+ _pageRef).val(maturityDate);
	
	var params = {};

	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	var prevMaturityDate = "";
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		prevMaturityDate = $("#plan_maturity_date_" + _pageRef).attr(
				"prevvalue");
	}
	else
	{
		prevMaturityDate = $("#maturityDate_" + _pageRef).attr("prevvalue");
	}
	if (calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.trsdealNIDCVO.ISSUE_AT_TYPE"] = $(
				"#ISSUE_AT_TYPE_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.accrualBasis"] = $(
				"#accrualBasis_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.valueDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.yield"] = $(
				"#annualYieldRate_" + _pageRef).val();

	}
	params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;
	params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
			"#noOfPayments_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	$('#financingAmount_' + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = returnHtmlEltValue('purchaseAmount_'
			+ _pageRef);

	// params["islamicCalculatorEventMgmtCO.financingAmount"] =
	// $.parseNumber($("#financingAmount_"+_pageRef).val(),{format
	// :$("#financingAmount_"+_pageRef).attr("nbFormat"), locale:"us"});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = returnHtmlEltValue('financingAmount_'
			+ _pageRef);
	;
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.maturityDate"] = maturityDate;
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeMaturityDate",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						var confirmChoice = false;
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
						{
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title, function(confirmChoice,
											theArgs)
									{
										setOnChangeMaturityDate(confirmChoice);
									});
						}
						else
						{
							setOnChangeMaturityDate(confirmChoice);
						}

					}
					else
					{
						setInputValue("maturityDate_" + _pageRef,
								prevMaturityDate);
					}
				}
			});
}

function setOnChangeMaturityDate(confirmChoice)
{
	var params = {};
	// params["islamicCalculatorEventMgmtCO.downPaymentAmount"] =
	// $("#downPaymentAmount_"+_pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	if (calculator_type == "BILLS_CALCULATOR")
	{

		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();

	}
	params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = returnHtmlEltValue('purchaseAmount_'
			+ _pageRef);
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.dealAmount"] = financingAmount;
	var downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
			.val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;

	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = confirmChoice;

	var profitAmount = $.parseNumber($("#profit_" + _pageRef).val(), {
		format : $("#profit_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = $(
			"#profitCalcMethod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.profit"] = profitAmount;
	params["islamicCalculatorEventMgmtCO.yield"] = $(
			"#annualYieldRate_" + _pageRef).val();
	// params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
	// "#maintainSalaryAccount_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.maintainSalaryAccount"] = $(
			"#maintainSalaryAccount_" + _pageRef).val();
	// var dealCharges = $("#dealChargesGridTbl_Id_" +
	// _pageRef).jqGrid('getAllRows');
	// params["strDealCharges"] = dealCharges;

	// Added deal charges as param - based on issue 0092514
	params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_setOnChangeMaturityDate",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						if (_pageRef != "M01681")
						{
							setInputValue(
									'noOfPayments_' + _pageRef,
									data.islamicCalculatorEventMgmtCO.noOfPayments);
						}

						// IE-8 fix

						if (calculator_type == "BILLS_CALCULATOR")
						{
							setInputValue(
									"periodicity_nbr_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.periodicityNbr);

							setInputValue(
									"periodicity_type_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.periodicityType);
							setInputValue(
									"gracePeriod_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.gracePeriod);
							setInputValue(
									"gracePeriodicity_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.gracePeriodicity);

						}

						if (_pageRef == "M0168"
								|| calculator_type == "AR_RAHANU"
								|| calculator_type == "BILLS_CALCULATOR")
						{

							// $("#plan_maturity_date_" + _pageRef)
							// .datepicker(
							// "setDate",
							// data.islamicCalculatorEventMgmtCO.maturityDate);
							setInputValue(
									"plan_maturity_date_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						else
						{
							$("#maturityDate_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}

						// TP#212256; Ramesh; Date 25/08/2014
						if (_pageRef == "M0162" || _pageRef == "M0166")
						{
							setInputValue("annualYieldRate_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.yield);
							setInputValue("margin_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.yield);
							setInputValue("floatingRate_" + _pageRef, '0');
						}
						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_MATURITY_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						setSumofInsuranceCharges();
						// afterDependencyForOnChangeMaturityDate(true);
						
						validateOnChangeMaturityDate();
						
					}
				}
			});
}

// TP# BB130052;deepu.mohandas 08/09/2015

function afterDependencyForOnChangeMaturityDate(confirm, arg)
{
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	var params = {};
	if (confirm == true)
	{
		params["_pageRef"] = _pageRef;
		params["islamicCalculatorEventMgmtCO.cifNo"] = returnHtmlEltValue("lookuptxt_cifNo_"
				+ _pageRef);
		params["islamicCalculatorEventMgmtCO.startDate"] = returnHtmlEltValue("startDate_"
				+ _pageRef);
		params["islamicCalculatorEventMgmtCO.productClass"] = returnHtmlEltValue("lookuptxt_productClass_"
				+ _pageRef);
		if (_pageRef == "M0168")
		{
			params["islamicCalculatorEventMgmtCO.limitSerialNo"] = $(
					"#lookuptxt_limitSerialNo_" + _pageRef).val();
		}

		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		_showProgressBar(true);
		var actionURL = jQuery.contextPath
				+ "/path/islamicCalculator/islamicCalculatorEventMgmt_afterDependencyForOnChangeMaturityDate";

		if (arg != "undefined" && arg != null)
		{
			if (arg.addUrlParam != "undefined" && arg.addUrlParam != null)
				actionURL = actionURL + arg.addUrlParam;

		}

		$
				.ajax({

					url : actionURL,
					type : "post",
					dataType : "json",
					data : params,
					success : function(data)
					{
						if (data["_error"] == null)
						{
							_showProgressBar(false);
							if (typeof data["_confirm"] != "undefined"
									|| data["_confirm"] != null)
							{

								if (data.confirmType == "TOTAL_PERIODS_EXCEEDS_COUNTER_PARTY_TENURE_PERIOD")
								{

									_showConfirmMsg(
											data["_confirm"],
											data["_msgTitle"],
											"afterDependencyForOnChangeMaturityDate",
											{
												actionURL : actionURL,
												addUrlParam : "?islamicCalculatorEventMgmtCO.globalConfirmationFrom=JS"
											}, "Yes", "No");
									_showProgressBar(false);
									return;
								}

							}

						}
						else
						{
							if (_pageRef == "M0168"
									|| calculator_type == "AR_RAHANU"
									|| calculator_type == "BILLS_CALCULATOR")
							{

								setInputValue("plan_maturity_date_" + _pageRef,
										$("#plan_maturity_date_" + _pageRef)
												.attr("prevvalue"));
							}
							else
							{
								setInputValue("maturityDate_" + _pageRef, $(
										"#maturityDate_" + _pageRef).attr(
										"prevvalue"));
								setInputValue("noOfPayments_" + _pageRef, $(
										"#noOfPayments_" + _pageRef).attr(
										"prevvalue"));
							}
							_showProgressBar(false);
						}
					}
				});
	}
	else
	{
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{

			setInputValue("plan_maturity_date_" + _pageRef, $(
					"#plan_maturity_date_" + _pageRef).attr("prevvalue"));

		}
		else
		{

			setInputValue("maturityDate_" + _pageRef, $(
					"#maturityDate_" + _pageRef).attr("prevvalue"));

		}
	}

}

/**
 * Method for handling the change event for the FirstPayDate
 */
function validateOnChangeFirstPayDate()
{
	var preValue = $("#firstPaymentDate_" + _pageRef).attr("prevValue");

	var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
	var params = {};
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.checkDefaultMaturityDate"] = $(
			"#hidden_checkDefaultMaturityDate_" + _pageRef).val();
	if (rescheduleYn == "Y")
	{
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#hidden_deal_cy_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
	}

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOnChangeFirstPayDate",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						var confirmChoice = false;
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
						{
							// set the check default maturity date to the
							// hidden variable
							$("#hidden_checkDefaultMaturityDate_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.checkDefaultMaturityDate);
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title, function(confirmChoice,
											theArgs)
									{
										// Confirm yes: Pass maturity date
										// Confirm No: Pass default maturity
										// date
										onChangeFirstPayDate(confirmChoice);

									});
						}
						else
							// No confirm messages - then pass maturity date
							onChangeFirstPayDate(confirmChoice);

					}
					else
					{
						setInputValue("firstPaymentDate_" + _pageRef, preValue);
					}

				}
			});
}

/**
 * Method for handling the change event for the FirstPayDate
 */
function onChangeFirstPayDate(confirmChoice)
{
	var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
	var params = {};

	if (rescheduleYn == "Y")
	{
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#no_of_payments_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	var financingAmount;
	if (rescheduleYn == "Y")
	{
		financingAmount = $.parseNumber($("#outstanding_amount_" + _pageRef)
				.val(), {
			format : $("#outstanding_amount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
	}
	else
	{
		financingAmount = $
				.parseNumber($("#financingAmount_" + _pageRef).val(),
						{
							format : $("#financingAmount_" + _pageRef).attr(
									"nbFormat"),
							locale : "us"
						});
	}
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	var dealAmount;
	if (rescheduleYn == "Y")
	{
		dealAmount = $.parseNumber($("#outstanding_amount_" + _pageRef).val(),
				{
					format : $("#outstanding_amount_" + _pageRef).attr(
							"nbFormat"),
					locale : "us"
				});
	}
	else
	{
		dealAmount = $.parseNumber($("#financingAmount_" + _pageRef).val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
	}
	params["islamicCalculatorEventMgmtCO.dealAmount"] = dealAmount
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	var downPaymentAmount;
	if (rescheduleYn == "Y")
	{
		downPaymentAmount = 0;
	}
	else
	{
		downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
				.val(), {
			format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
	}
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount
	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();
	if (rescheduleYn == "Y")
	{
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#hidden_deal_cy_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
	}
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeFirstPayDate",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						var confirmChoice = false;
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
						{
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title,
									function(confirmChoice, theArgs)
									{
										setInputValue("firstPaymentDate_" + _pageRef,
                                                data.islamicCalculatorEventMgmtCO.firstPaymentDate);

										calculateDealChargesOnChangeFirstPaymentDate(confirmChoice);
									});
						}
						else
						{
							calculateDealChargesOnChangeFirstPaymentDate(confirmChoice);
						}

					}
				}
			});
}

function onChangeprofitCalcMethod()
{
	var profitCalc = ($("#profitCalcMethod_" + _pageRef).val());
	// #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [START]
	if (profitCalc == "S")
	{
		var params = {};
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = profitCalc;
		params["islamicCalculatorEventMgmtCO.profitDistMethod"] = $(
				"#profitRecognitionMethod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.principalLast"] = "N";
		// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
		params["islamicCalculatorEventMgmtCO.flexiPaymentYn"] = returnHtmlEltValue('flexiPaymentYN_CheckBox_'
				+ _pageRef);
		// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
		if ($("#compoundingDuringTheEntireDealPeriod_" + _pageRef).is(
				':checked') == true)
			params["islamicCalculatorEventMgmtCO.dealPeriodCompounding"] = "Y";
		else
			params["islamicCalculatorEventMgmtCO.dealPeriodCompounding"] = "N";

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeProfitCalculationMethod",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] != null)
						{
							$("#profitCalcMethod_" + _pageRef).val("R");
						}
					}
				});
	}
	// #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [END]
	if (profitCalc == "R")
	{
		var resetElements = {};
		resetElements[0] = "profitCalcMethod_" + _pageRef;

		var params = {};
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		var financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
				.val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		var profitAmount = $.parseNumber($("#profit_" + _pageRef).val(), {
			format : $("#profit_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
		params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = profitCalc;
		params["islamicCalculatorEventMgmtCO.profit"] = profitAmount;
		params["islamicCalculatorEventMgmtCO.yield"] = $(
				"#annualYieldRate_" + _pageRef).val();
		// #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [START]
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.profitDistMethod"] = $(
				"#profitRecognitionMethod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.principalLast"] = "N";
		if ($("#compoundingDuringTheEntireDealPeriod_" + _pageRef).is(
				':checked') == true)
			params["islamicCalculatorEventMgmtCO.dealPeriodCompounding"] = "Y";
		else
			params["islamicCalculatorEventMgmtCO.dealPeriodCompounding"] = "N";
		// #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [END]
		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeProfitCalculationMethod",// modified
					// as
					// per
					// manoj's
					// comment
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							$("#annualFlatRate_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.totalYield);
							// setElementsPreviousValue(resetElements);//Setting
							// the new value as prev value for margin
							// floatingrate,annualyield
						}
						// else
						// resetElementsToPreviousValue(resetElements)//Resetting
						// the values of margin floatingrate,annualyield to the
						// prev values
					}
				});
		$("#compoundingDuringTheEntireDealPeriod_" + _pageRef).show();
		$("#lbl_compoundingDuringTheEntireDealPeriod_" + _pageRef).show();
		$("#totalFlatRate_" + _pageRef).val("");
		$("#totalFlatRate_" + _pageRef).attr("readonly", true);
	}
	else if (profitCalc == "S")
	{
		$("#compoundingDuringTheEntireDealPeriod_" + _pageRef).hide();
		$("#lbl_compoundingDuringTheEntireDealPeriod_" + _pageRef).hide();
		$("#totalFlatRate_" + _pageRef).attr("readonly", false);
		$("#annualFlatRate_" + _pageRef).val(
				$("#annualYieldRate_" + _pageRef).val());

		hideShowRepaymentNavigator(true);
		$("#profitCalcMethod_" + _pageRef).removeAttr("readOnly");
		$("#profitRecognitionMethod_" + _pageRef).removeAttr("readOnly");
		$("#amountPerPayment_" + _pageRef).removeAttr("readOnly");
		$("#lookuptxt_tempCode_" + _pageRef).removeAttr("readOnly");
		if ($("#compoundingDuringTheEntireDealPeriod_" + _pageRef).is(
				':checked') == true)
			$("#compoundingDuringTheEntireDealPeriod_" + _pageRef).removeAttr(
					'checked');
	}
}

function calculateDealChargesOnChangeFirstPaymentDate(confirmChoice)
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	var downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
			.val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = confirmChoice;

	// Added deal charges as param - based on issue 0092514
	params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_calculateDealChargesOnChangeFirstPaymentDate",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						// $("#maturityDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.maturityDate));
						// IE-8 fix

						if (_pageRef == "M0168"
								|| calculator_type == "AR_RAHANU"
								|| calculator_type == "BILLS_CALCULATOR")
						{
							$("#plan_maturity_date_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						else
						{
							$("#maturityDate_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}

						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_MATURITY_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						setInputValue("gracePeriod_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriod);
						setInputValue(
								"gracePeriodicity_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriodicity);

						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						setSumofInsuranceCharges();
					}
				}
			});
}

/**
 * Method for handling the change event for the NoOfPayments
 */
function validateOnChangeNoOfPayments()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{

		var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
		var preValue = $("#noOfPayments_" + _pageRef).attr("prevValue");
		var params = {};
		var noOfPayments;
		if (rescheduleYn == "Y")
		{
			noOfPayments = $("#no_of_payments_" + _pageRef).val();
		}
		else
		{
			noOfPayments = $("#noOfPayments_" + _pageRef).val();
		}
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		params["islamicCalculatorEventMgmtCO.noOfPayments"] = noOfPayments;
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.checkDefaultMaturityDate"] = $(
				"#hidden_checkDefaultMaturityDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
		params["islamicCalculatorEventMgmtCO.flexiPaymentYn"] = returnHtmlEltValue('flexiPaymentYN_CheckBox_'
				+ _pageRef);
		// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOnChangeNoOfPayments",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							var confirmChoice = false;
							if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
									&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
							{
								$(
										"#hidden_checkDefaultMaturityDate_"
												+ _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.checkDefaultMaturityDate);
								_showConfirmMsg(
										data.islamicCalculatorEventMgmtCO.confirmationMessageId,
										confirm_msg_title,
										function(confirmChoice, theArgs)
										{
											// confirmcChoice = TRUE : continue
											// with new maturity date :
											// difference in default, maturity
											// date from client result
											if (_pageRef == "M0168")
											{
												onChangeNoOfPayments(
														confirmChoice,
														(confirmChoice == true) ? $(
																"#plan_maturity_date_"
																		+ _pageRef)
																.val()
																: $(
																		"#hidden_defaultMaturityDate_"
																				+ _pageRef)
																		.val());
											}
											else
											{
												onChangeNoOfPayments(
														confirmChoice,
														(confirmChoice == true) ? $(
																"#maturityDate_"
																		+ _pageRef)
																.val()
																: $(
																		"#hidden_defaultMaturityDate_"
																				+ _pageRef)
																		.val());
											}

											// confirmcChoice = FALSE :continue
											// with
											// default maturity date : No
											// difference
											// in default, maturity date from
											// client
											// result
										});
							}
							else // no difference in maturity date and
							// default maturity date
							if (_pageRef == "M0168")
							{
								onChangeNoOfPayments(confirmChoice, $(
										"#plan_maturity_date_" + _pageRef)
										.val());
							}
							else
							{
								onChangeNoOfPayments(confirmChoice, $(
										"#maturityDate_" + _pageRef).val());
							}

						}
						else
						{

							setInputValue('noOfPayments_' + _pageRef, preValue);
							setInputValue('no_of_payments_' + _pageRef,
									preValue);

						}

					}
				});
	}
}

/**
 * Method for handling the change event for the NoOfPayments
 */
function onChangeNoOfPayments(confirmChoice, maturityDate)
{
	var params = {};
	var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.maturityDate"] = maturityDate;
	var financingAmount, dealAmount, downPaymentAmount;

	if (rescheduleYn == "Y")
	{
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#no_of_payments_" + _pageRef).val();
		financingAmount = $
				.parseNumber($("#principalAmount_" + _pageRef).val(),
						{
							format : $("#principalAmount_" + _pageRef).attr(
									"nbFormat"),
							locale : "us"
						});
		dealAmount = $.parseNumber($("#principalAmount_" + _pageRef).val(), {
			format : $("#principalAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		downPaymentAmount = $.parseNumber($("#principalAmount_" + _pageRef)
				.val(), {
			format : $("#principalAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.financingAmount"] = $
				.parseNumber($("#principalAmount_" + _pageRef).val(),
						{
							format : $("#financingAmount_" + _pageRef).attr(
									"nbFormat"),
							locale : "us"
						});
		params["islamicCalculatorEventMgmtCO.dealAmount"] = $.parseNumber($(
				"#principalAmount_" + _pageRef).val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount

	}
	else
	{

		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
		financingAmount = $
				.parseNumber($("#financingAmount_" + _pageRef).val(),
						{
							format : $("#financingAmount_" + _pageRef).attr(
									"nbFormat"),
							locale : "us"
						});
		dealAmount = $.parseNumber($("#financingAmount_" + _pageRef).val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
				.val(), {
			format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.financingAmount"] = $
				.parseNumber($("#financingAmount_" + _pageRef).val(),
						{
							format : $("#financingAmount_" + _pageRef).attr(
									"nbFormat"),
							locale : "us"
						});
		params["islamicCalculatorEventMgmtCO.dealAmount"] = $.parseNumber($(
				"#financingAmount_" + _pageRef).val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount

	}

	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeNoOfPayments",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						var confirmChoice = false;
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
						{
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title,
									function(confirmChoice, theArgs)
									{
										// confirmcChoice = TRUE :continue with
										// revised maturity date based on
										// holiday checking for the maturity
										// date selected from last step
										calculateDealChargesOnChangeNoOfPayments(confirmChoice);
										// confirmcChoice = FALSE :continue with
										// maturity date (even a holiday not
										// revised) maturity date based on
										// holiday
										// checking for the maturity date
										// selected
										// from last step
									});
						}
						else
						{ // no difference in maturity date and
							// default maturity date
							confirmChoice = null;
							calculateDealChargesOnChangeNoOfPayments(confirmChoice);
						}
						// MaturityDate set the values to the session in prev
						// method
						// MaturityDateAfterHoliday set the values to the
						// session in prev method
					}
				}
			});
}
/**
 * Method for handling the change event for the NoOfPayments -
 * calculateDealCharges
 */
function calculateDealChargesOnChangeNoOfPayments(confirmChoice)
{
	var params = {};
	var rescheduleYn = $("#hidden_reschedule_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
			"#maturityDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();

	var financingAmount, downPaymentAmount;
	if (rescheduleYn == "Y")
	{
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#hidden_deal_cy_" + _pageRef).val();
		var financingAmount = $.parseNumber($("#principalAmount_" + _pageRef)
				.val(), {
			format : $("#principalAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		var downPaymentAmount = $.parseNumber($("#principalAmount_" + _pageRef)
				.val(), {
			format : $("#principalAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		// Added deal charges as param - based on issue 0092514
		// params["strDealCharges"] = "";
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		var financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
				.val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		var downPaymentAmount = $.parseNumber($(
				"#downPaymentAmount_" + _pageRef).val(), {
			format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		// Added deal charges as param - based on issue 0092514
		params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef)
				.jqGrid('getAllRows');
	}
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = confirmChoice;
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_calculateDealChargesOnChangeNoOfPayments",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						// $("#maturityDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.maturityDate));
						// IE-8 fix
						if (rescheduleYn == "Y")
						{
							$("#plan_maturity_date_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
							$("#plan_maturity_date_" + _pageRef).trigger(
									"change");
							if (_pageRef == "M0169")
							{
								$("#maturity_date_" + _pageRef)
										.datepicker(
												"setDate",
												data.islamicCalculatorEventMgmtCO.maturityDate);

							}
						}
						else
						{
							if (_pageRef == "M0168")
							{
								$("#plan_maturity_date_" + _pageRef)
										.datepicker(
												"setDate",
												data.islamicCalculatorEventMgmtCO.maturityDate);
							}
							else
							{
								// TP #467365
								setInputValue(
										'maturityDate_' + _pageRef,
										data.islamicCalculatorEventMgmtCO.maturityDate);
							}

							// TP#193281; Ramesh; Date 25/06/2014
							if (_pageRef == "M01681")
							{
								$("#trsdealVO_MATURITY_DATE_" + _pageRef)
										.datepicker(
												"setDate",
												data.islamicCalculatorEventMgmtCO.maturityDate);
							}
						}
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						setSumofInsuranceCharges();
					}
				}
			});
}

/**
 * Method for handling the change event for the NoOfPayments -
 * calculateDealCharges
 */
function calculateDealCharges(confirmChoice)
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	var downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
			.val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = confirmChoice;

	// Added deal charges as param - based on issue 0092514
	params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_calculateDealCharges",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						// $("#maturityDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.maturityDate));
						// IE-8 fix
						if (_pageRef == "M0168"
								|| calculator_type == "AR_RAHANU"
								|| calculator_type == "BILLS_CALCULATOR")
						{
							$("#plan_maturity_date_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						else
						{
							$("#maturityDate_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}

						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_MATURITY_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						setSumofInsuranceCharges();
					}
				}
			});
}

/**
 * Method for handling the change event for the PayEvery
 */
function validateOnChangePayEvery()
{

	var preVal = $("#paymPeriodNbr_" + _pageRef).attr("prevValue");
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{

		var params = {};
		params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
				"#paymPeriodNbr_" + _pageRef).val();

		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.checkDefaultMaturityDate"] = $(
				'#hidden_checkDefaultMaturityDate_' + _pageRef).val();

		params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;

		if (calculator_type == "BILLS_CALCULATOR")
		{

			params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
					'#gracePeriod_' + _pageRef).val();
		}
		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOnChangePayEvery",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							var confirmChoice = false;
							if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
									&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
							{
								$(
										"#hidden_checkDefaultMaturityDate_"
												+ _pageRef)
										.val(
												data.islamicCalculatorEventMgmtCO.checkDefaultMaturityDate);
								_showConfirmMsg(
										data.islamicCalculatorEventMgmtCO.confirmationMessageId,
										confirm_msg_title,
										function(confirmChoice, theArgs)
										{
											if (_pageRef == "M0168"
													|| calculator_type == "AR_RAHANU"
													|| calculator_type == "BILLS_CALCULATOR")
											{
												onChangeNoOfPayments(
														confirmChoice,
														(confirmChoice == true) ? $(
																"#plan_maturity_date_"
																		+ _pageRef)
																.val()
																: $(
																		"#hidden_defaultMaturityDate_"
																				+ _pageRef)
																		.val());
											}
											else
											{
												onChangeNoOfPayments(
														confirmChoice,
														(confirmChoice == true) ? $(
																"#maturityDate_"
																		+ _pageRef)
																.val()
																: $(
																		"#hidden_defaultMaturityDate_"
																				+ _pageRef)
																		.val());
											}

										});
							}
							else
							{

								if (_pageRef == "M0168"
										|| calculator_type == "AR_RAHANU"
										|| calculator_type == "BILLS_CALCULATOR")
								{

									onChangeNoOfPayments(confirmChoice, $(
											"#plan_maturity_date_" + _pageRef)
											.val());
								}
								else
								{
									onChangeNoOfPayments(confirmChoice, $(
											"#maturityDate_" + _pageRef).val());
								}

							}
						}
						else
						{

							setInputValue("paymPeriodNbr_" + _pageRef, preVal);

						}
					}
				});
	}
}

/**
 * Method for handling the change event for the PayEveryPeriodicity
 */
function validateOnChangePayEveryPeriodicity()
{
	_showProgressBar(true);
	var preValue = $('#paymPeriodicity_' + _pageRef).attr("prevValue");

	var params = {};
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.checkDefaultMaturityDate"] = $(
			'#hidden_checkDefaultMaturityDate_' + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	params["islamicCalculatorEventMgmtCO.flexiPaymentYn"] = returnHtmlEltValue('flexiPaymentYN_CheckBox_'
			+ _pageRef);
	// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
	var paymPeriod = ($("#paymPeriodicity_" + _pageRef).val());
	var paymPeriodPos = ($("#paymPeriodPos_" + _pageRef));
	var paymPeriodAt = ($("#lbl_At_" + _pageRef));
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (paymPeriod == "M")
	{
		$(paymPeriodPos).show();
		$(paymPeriodAt).show();
	}
	else
	{
		$(paymPeriodPos).hide();
		$(paymPeriodAt).hide();
	}
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOnChangePayEveryPeriodicity",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					_showProgressBar(false);
					if (data["_error"] == null)
					{
						var confirmChoice = false;
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
						{
							$("#hidden_checkDefaultMaturityDate_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.checkDefaultMaturityDate);
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title,
									function(confirmChoice, theArgs)
									{
										if (_pageRef == "M0168"
												|| calculator_type == "AR_RAHANU"
												|| calculator_type == "BILLS_CALCULATOR")
										{

											onChangeNoOfPayments(
													confirmChoice,
													(confirmChoice == true) ? $(
															"#plan_maturity_date_"
																	+ _pageRef)
															.val()
															: $(
																	"#hidden_defaultMaturityDate_"
																			+ _pageRef)
																	.val());
										}
										else
										{
											onChangeNoOfPayments(
													confirmChoice,
													(confirmChoice == true) ? $(
															"#maturityDate_"
																	+ _pageRef)
															.val()
															: $(
																	"#hidden_defaultMaturityDate_"
																			+ _pageRef)
																	.val());
										}

									});
						}
						else
						{

							if (_pageRef == "M0168"
									|| calculator_type == "AR_RAHANU"
									|| calculator_type == "BILLS_CALCULATOR")
							{

								onChangeNoOfPayments(confirmChoice, $(
										"#plan_maturity_date_" + _pageRef)
										.val());
							}
							else
							{
								onChangeNoOfPayments(confirmChoice, $(
										"#maturityDate_" + _pageRef).val());
							}
						}
					}
					else
					{
						setInputValue("paymPeriodicity_" + _pageRef, preValue);
					}
				}
			});

}
/**
 * Method for handling the change event for the PayEveryPeriodicity
 */
function validateOnChangePayEveryPosition()
{
	var params = {};
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.checkDefaultMaturityDate"] = $(
			'#hidden_checkDefaultMaturityDate_' + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOnChangePayEveryPosition",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						var confirmChoice = false;
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
						{
							$("#hidden_checkDefaultMaturityDate_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.checkDefaultMaturityDate);
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title,
									function(confirmChoice, theArgs)
									{
										if (_pageRef == "M0168"
												|| calculator_type == "AR_RAHANU"
												|| calculator_type == "BILLS_CALCULATOR")
										{
											onChangeNoOfPayments(
													confirmChoice,
													(confirmChoice == true) ? $(
															"#plan_maturity_date_"
																	+ _pageRef)
															.val()
															: $(
																	"#hidden_defaultMaturityDate_"
																			+ _pageRef)
																	.val());
										}
										else
										{
											onChangeNoOfPayments(
													confirmChoice,
													(confirmChoice == true) ? $(
															"#maturityDate_"
																	+ _pageRef)
															.val()
															: $(
																	"#hidden_defaultMaturityDate_"
																			+ _pageRef)
																	.val());
										}

									});
						}
						else
						{
							if (_pageRef == "M0168"
									|| calculator_type == "AR_RAHANU"
									|| calculator_type == "BILLS_CALCULATOR")
							{
								onChangeNoOfPayments(confirmChoice, $(
										"#plan_maturity_date_" + _pageRef)
										.val());
							}
							else
							{
								onChangeNoOfPayments(confirmChoice, $(
										"#maturityDate_" + _pageRef).val());
							}

						}
					}
				}
			});
}

/*******************************************************************************
 * FOR AR-Rahan Calculator Grid Sum
 */

function setSumofTotalAmtCharges()
{

	var grid = $("#arRahnuCalcItemGrid_" + _pageRef);
	var totalAmount = grid.jqGrid('getCol', 'amount', false, 'sum');
	var totalFinancingAmount = grid.jqGrid('getCol', 'financing_amount', false,
			'sum');
	var params = {};
	var finacingper = "";
	params["islamicCalculatorEventMgmtCO.totalAmount"] = totalAmount;
	params["islamicCalculatorEventMgmtCO.financingAmount"] = totalFinancingAmount;

	$("#purchaseAmount_" + _pageRef).val(totalAmount);
	$("#financingAmount_" + _pageRef).val(totalFinancingAmount);

	$
			.ajax({
				type : "POST",
				data : params,
				url : $.contextPath
						+ "/path/iis/arrhanCalcMgmt/ArrahnCalcMgmt_financingPercentCalc",
				success : function(data)
				{

					finacingper = data.islamicCalculatorEventMgmtCO.financing_perc;
					$("#financing_perc_" + _pageRef).val(finacingper);
				},
				error : function(data)
				{
					_showErrorMsg("Something went wrong, Please try again",
							error_msg_title);
				}
			});

}
function islamicCalculator_setPurchasepartyArRanuCalcu()
{
	var selrowId = $("#arRahnuCalcItemGrid_" + _pageRef).jqGrid('getGridParam',
			'selrow');

	var grid = $("#arRahnuCalcItemGrid_" + _pageRef);
	var rows = $("#arRahnuCalcItemGrid_" + _pageRef).jqGrid('getDataIDs');
	var i;

	var newPurchaseParty = grid.jqGrid('getCell', selrowId, 'Purchase_Party');

	for (i = 0; i < rows.length; i++)
	{

		var lineParchaseParty = grid.jqGrid('getCell', rows[i],
				'Purchase_Party');
		// var cellData = grid.jqGrid('getCell', rows[i], 'Purchase_Party');
		if (lineParchaseParty == null || lineParchaseParty == "")
		{
			grid.jqGrid('setCellValue', rows[i], 'Purchase_Party',
					newPurchaseParty);
		}
	}
}

/**
 * Method for editing deal charges
 *
 * @param {Object}
 *            rowId
 */

/*******************************************************************************
 * Method for adding deal charges
 */

function setSumofInsuranceCharges()
{
	var grid = $("#dealChargesGridTbl_Id_" + _pageRef);
	var decimalPoints = $("#hidden_islamicCalcDecimalFormat_" + _pageRef).val();
	var rowIds = grid.jqGrid('getDataIDs');
	var rowIdlength = rowIds.length;
	var totalInsuranceAmount = 0;
	var totalChargeAmtToInclInPrinciple = 0;
	var sum = 0;

	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (calculator_type == "AR_RAHANU")
	{
		var totalSafeBoxAmt = grid.jqGrid('getCol', 'CHARGES_AMOUNT', false,
				'sum');

		setInputValue("safeBoxesChargeAmt_" + _pageRef, totalSafeBoxAmt);

	}

	for (var i = 0; i < rowIdlength; i++)
	{
		var includeInPrincipleFlag = grid.jqGrid('getCell', rowIds[i],
				'CHARGE_TYPE');
		if (includeInPrincipleFlag == 'Y' || includeInPrincipleFlag == true)
		{
			totalInsuranceAmount = totalInsuranceAmount
					+ $.parseNumber(grid.jqGrid('getCell', rowIds[i],
							'insuranceAmount'), {
						format : $("#purchaseAmount_" + _pageRef).attr(
								"nbFormat"),
						locale : "us"
					});
			totalChargeAmtToInclInPrinciple = totalChargeAmtToInclInPrinciple
					+ $.parseNumber(grid.jqGrid('getCell', rowIds[i],
							'chargeAmtToInclInPrinciple'), {
						format : $("#purchaseAmount_" + _pageRef).attr(
								"nbFormat"),
						locale : "us"
					});
		}
	}
	sum = totalInsuranceAmount + totalChargeAmtToInclInPrinciple;
	$("#insuranceChargesAmount_" + _pageRef).val(
			$.formatNumberNumeric(totalInsuranceAmount, {
				format : returnNbFormat($(
						"#hidden_islamicCalcDecimalFormat_" + _pageRef).val()),
				applyRounding : true
			}));
	$("#chargeAmount_" + _pageRef).val(
			$.formatNumberNumeric(totalChargeAmtToInclInPrinciple, {
				format : returnNbFormat($(
						"#hidden_islamicCalcDecimalFormat_" + _pageRef).val()),
				applyRounding : true
			}));
	$("#totalInsuranceAmount_" + _pageRef).val(
			$.formatNumberNumeric(sum, {
				format : returnNbFormat($(
						"#hidden_islamicCalcDecimalFormat_" + _pageRef).val()),
				applyRounding : true
			}));

	if (calculator_type == "AR_RAHANU")
	{
		$("#safeboxchargetype_" + _pageRef).trigger("change");
	}
}

function arRahnuCalculator_itemsPurchaseParty()
{

	var arRahnuCalcGrid = $("#arRahnuCalcItemGrid_" + _pageRef);
	var rowIds = arRahnuCalcGrid.jqGrid('getDataIDs');
	if (rowIds.length != 0)
	{
		var lastRowId = rowIds[rowIds.length - 2];
		var cellData = arRahnuCalcGrid.jqGrid('getCell', lastRowId,
				'Purchase_Party');
		var cRowId = rowIds[rowIds.length - 1];
		arRahnuCalcGrid.jqGrid('setCellValue', cRowId, 'Purchase_Party',
				cellData);

	}
}

function addDealCharges()
{

	// TP#255365;Ramesh;04/01/2015 [START]
	if ($('#dealChargesGridTbl_Id_' + _pageRef).jqGrid('getDataIDs').length > 0)
	{

		var $records = $("#dealChargesGridTbl_Id_" + _pageRef);
		var rows = $records.jqGrid('getDataIDs');
		var i;

		for (i = 0; i < rows.length; i++)
		{
			var myObject = $records.jqGrid('getRowData', rows[i]);
			if (myObject["CHARGES_CODE"] == undefined
					|| myObject["CHARGES_CODE"] == ""
					|| myObject["CHARGES_CODE"] == null)
			{
				return;
			}
		}
	}
	// TP#255365;Ramesh;04/01/2015[END]

	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('addInlineRow', {});
	var rowIds = $('#dealChargesGridTbl_Id_' + _pageRef).jqGrid('getDataIDs');
	var rowId = rowIds[rowIds.length - 1];
	$("#dealChargesGridTbl_Id_" + _pageRef)
			.jqGrid('setCellValue', rowId, 'CR_ACC_BRANCH',
					$("#hidden_branchCode_" + _pageRef).val(), "false");
	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'CR_ACC_CURRENCY', $("#lookuptxt_currencyCode_" + _pageRef).val(),
			"false");
	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'CHARGE_TYPE', "Y", "false");

	// $("#dealChargesGridTbl_Id_"+_pageRef).jqGrid('editRow',rowId);
	// $("#"+rowId+"_CR_ACC_BRANCH").val($("#hidden_branchCode_"+_pageRef).val());
	// $("#"+rowId+"_CR_ACC_CURRENCY").val($("#lookuptxt_currencyCode_"+_pageRef).val());
	// var includeInPrincipleElem = document.getElementById( rowId +
	// "_CHARGE_TYPE");
	// $(includeInPrincipleElem).attr('checked','checked');
	// $("#dealChargesGridTbl_Id_"+_pageRef).jqGrid('saveRow',rowId,false,
	// 'clientArray');

}

$.subscribe('editDealCharges', function(event, data)
{

	var rowId = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('getGridParam',
			'selrow');
	var payNetIncentPrincStlmtYn = $("#dealChargesGridTbl_Id_" + _pageRef)
			.jqGrid('getCell', rowId,
					'TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN');

	if (payNetIncentPrincStlmtYn == "Y")
	{
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'CHARGE_TYPE', "true");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'PROFIT_ON_CHARGES', "true");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'CREDIT_TO_SD_ACCOUNT_YN', "true");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'CHARGE_AMT_PER_INST_YN', "true");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'COLLECT_CHARGE_AT_DEAL_YN', "true");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'COLLECT_CHARGES_ACCOUNT_TYPE', "true");
	}
	else
	{
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'CHARGE_TYPE', "false");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'PROFIT_ON_CHARGES', "false");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'CREDIT_TO_SD_ACCOUNT_YN', "false");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'CHARGE_AMT_PER_INST_YN', "false");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'COLLECT_CHARGE_AT_DEAL_YN', "false");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'COLLECT_CHARGES_ACCOUNT_TYPE', "false");

		var includeInPrincipleElem = document.getElementById(rowId
				+ "_CHARGE_TYPE");
		var profitOnChargesElem = document.getElementById(rowId
				+ "_PROFIT_ON_CHARGES");
		if ($("#" + rowId + "_CHARGE_TYPE").is(':checked') == false)
		{
			if ($(profitOnChargesElem).is(':checked'))
				$(profitOnChargesElem).removeAttr('checked');
			$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue",
					rowId, 'PROFIT_ON_CHARGES', "0", "true");
		}
		else
		{
			// TP#251096;Arun.R.Variyath;19/12/2014
			$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue",
					rowId, 'CHARGE_AMT_PER_INST_YN', "0", "false");
			$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue",
					rowId, 'COLLECT_CHARGE_AT_DEAL_YN', "0", "true");

		}
	}

	var allowToEditVatCode = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getCell', rowId, 'allowToEditVatCode');

	// var allowToEditVatCode= document.getElementById( rowId +
	// "_allowToEditVatCode");
	if (allowToEditVatCode == "N")
	{
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'VAT_CODE', "true");
	}
	else
	{
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'VAT_CODE', "false");
	}

});
/*******************************************************************************
 * On change functionality of Include in principle- If it unchecks then Uncheck
 * profit on charge check box and disable it If it checked then profit on charge
 * check box should get enable
 */

function onChangeIncludeInPrinciple()
{
	var rowId = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('getGridParam',
			'selrow');
	var includeInPrincipleElem = document
			.getElementById(rowId + "_CHARGE_TYPE");
	var profitOnChargesElem = document.getElementById(rowId
			+ "_PROFIT_ON_CHARGES");
	if ($("#" + rowId + "_CHARGE_TYPE").is(':checked') == false)
	{
		$(profitOnChargesElem).removeAttr('checked');
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'PROFIT_ON_CHARGES', "0", "true");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'COLLECT_CHARGE_AT_DEAL_YN', "0", "false");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'CHARGE_AMT_PER_INST_YN', "0", "false");

	}
	else
	{
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'PROFIT_ON_CHARGES', "0", "false");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'COLLECT_CHARGE_AT_DEAL_YN', "0", "true");
		// $("#dealChargesGridTbl_Id_"+_pageRef).jqGrid("setCellValue", rowId,
		// 'CHARGE_AMT_PER_INST_YN', "0", "true");
		// TP#251096;Arun.R.Variyath;19/12/2014
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'CHARGE_AMT_PER_INST_YN', "0", "false");
	}
	setSumofInsuranceCharges();
}

function onChangeCollectChgsOnDealApprove()
{
	var rowId = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('getGridParam',
			'selrow');
	if ($("#" + rowId + "_COLLECT_CHARGE_AT_DEAL_YN").is(':checked') == false)
	{

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'CHARGE_AMT_PER_INST_YN', "N", "false");
		// TP#251100;Arun.R.Variyath;17/12/2014
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'COLLECT_CHARGES_ACCOUNT_TYPE', "true");
		// TP#251131;Arun.R.Variyath;19/12/2014
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'COLLECT_CHARGES_ACCOUNT_TYPE', "R", "false");
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'CHARGE_TYPE', "0", "false");

	}
	else
	{

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'CHARGE_AMT_PER_INST_YN', "N", "false");
		// TP#251100;Arun.R.Variyath;17/12/2014
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				rowId, 'COLLECT_CHARGES_ACCOUNT_TYPE', "false");
		// TP#251131;Arun.R.Variyath;19/12/2014
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'CHARGE_TYPE', "N", "true");
		// TP#251131;Arun.R.Variyath;30/12/2014
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'COLLECT_CHARGES_ACCOUNT_TYPE', "C", "false");
	}
	setSumofInsuranceCharges();
}

function onChangeCollectChgsperInstallmentOnPI()
{
	var rowId = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('getGridParam',
			'selrow');

	if ($("#" + rowId + "_CHARGE_AMT_PER_INST_YN").is(':checked') == false)
	{

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'COLLECT_CHARGE_AT_DEAL_YN', "0", "false");
	}
	else
	{

		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'COLLECT_CHARGE_AT_DEAL_YN', "0", "true");
		// TP#251096;Arun.R.Variyath;19/12/2014
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("setCellValue", rowId,
				'CHARGE_TYPE', "N", "false");
	}
	setSumofInsuranceCharges();
}

function editDealCharges()
{
	var rowId = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('getGridParam',
			'selrow');
	var selectedrecord = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getRowData', rowId);
}
/*******************************************************************************
 * Method for deleting deal charges
 */
function deleteDealCharges()
{
	_showConfirmMsg(Confirm_Delete_Process_key, confirm_msg_title,
			"deleteDealChargesRecord", "yesNo");
	// _showConfirmMsg(Do_you_want_to_remove_the_record_key,confirm_msg_title,"deleteDealChargesRecord","yesNo");
}

function deleteDealChargesRecord(yesNo)
{
	if (yesNo)
	{
		var rowId = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
				'getGridParam', 'selrow');
		// TP#231436; Saheer.Naduthodi; 19/10/2014 [START]
		var allowToEdit = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
				'getCell', rowId, 'ALLOW_EDIT');
		if (allowToEdit == "N")
		{
			_showErrorMsg("Charge Cannot Delete/Edit", warning_msg_title);
			return;
		}
		// TP#231436; Saheer.Naduthodi; 19/10/2014 [END]
		$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('delRowData', rowId);
		setSumofInsuranceCharges();
	}
}

/*******************************************************************************
 * Method for adding repayment criteria
 */
function addRepaymentCriteria()
{
	// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	var flexiPaymentYN = returnHtmlEltValue('flexiPaymentYN_CheckBox_'
			+ _pageRef);
	if (flexiPaymentYN == "Y")
	{
		_showErrorMsg(
				"Flexi Payments is not applicable with Repayment Plan Criteria",
				Cannot_Proceed);
		return;
	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('addInlineRow', {});
	var rowIds = $('#repaymentgridTbl_Id_' + _pageRef).jqGrid('getDataIDs');
	var rowId = rowIds[rowIds.length - 1];
	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'FROM_DATE', $("#firstPaymentDate_" + _pageRef).val(), "false");
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
				'TO_DATE', $("#plan_maturity_date_" + _pageRef).val(), "false");
	}
	else
	{
		$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
				'TO_DATE', $("#maturityDate_" + _pageRef).val(), "false");
	}

	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'PAYM_PERIOD_NBR', $("#paymPeriodNbr_" + _pageRef).val(), "false");// periodicity
	// number
	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'PAYM_PERIODICITY', $("#paymPeriodicity_" + _pageRef).val(),
			"false");// periodicity
	if ($("#paymPeriodicity_" + _pageRef).val() == 'M')
		$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
				'PAYM_PERIOD_POS', $("#paymPeriodPos_" + _pageRef).val(),
				"false");// at

	if ($("#paymPeriodicity_" + _pageRef).val() == 'M'
			&& $("#paymPeriodPos_" + _pageRef).val() == 'D')
		$("#repaymentgridTbl_Id_" + _pageRef).jqGrid(
				'setCellValue',
				rowId,
				'PAYM_DAY',
				$("#firstPaymentDate_" + _pageRef).datepicker('getDate')
						.getDate(), "false");// on
	else
		$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
				'PAYM_DAY', "", "false");// on
	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'NO_OF_PAYMENTS', $("#noOfPayments_" + _pageRef).val(), "false");// no
	// of
	// payments
	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'PAYMENT_TYPE', "B", "false");
	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'CAPITAL_AMT', "0", "false");// capital

	// $("#repaymentgridTbl_Id_"+_pageRef).jqGrid('setCellValue', rowId,
	// 'PAYM_PERIODICITY', "D","false");
	// $("#repaymentgridTbl_Id_"+_pageRef).jqGrid('editRow',rowId);
	// $("#repaymentgridTbl_Id_"+_pageRef).jqGrid('setCell', rowId,
	// 'FROM_DATE',$("#firstPaymentDate_"+_pageRef).val());
	// $("#repaymentgridTbl_Id_"+_pageRef).jqGrid('setCell', rowId,
	// 'TO_DATE',$("#maturityDate_"+_pageRef).val());
	// $("#"+rowId+"_PAYM_PERIODICITY").val("D");
	// $("#"+rowId+"_PAYMENT_TYPE").val("B");
	// $("#"+rowId+"_CAPITAL_AMT").val("0");
	// $("#repaymentgridTbl_Id_"+_pageRef).jqGrid('saveRow',rowId,false,
	// 'clientArray');

}

function hideShowRepaymentNavigator(hideShow)
{
	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('navGrid',
			'' + "#repaymentgridTbl_Id_" + _pageRef + "_pager", {
				del : hideShow,
				add : hideShow,
				edit : false,
				refresh : false,
				search : false,
				addfunc : "addRepaymentCriteria",
				delfunc : "deleteRepaymentCriteria"
			}, // options
			{}, {}, {}, {}, {});
	if (hideShow)
		$("#repaymentgridTbl_Id_" + _pageRef + "_pager_left").css("display",
				"block");
	else
		$("#repaymentgridTbl_Id_" + _pageRef + "_pager_left").css("display",
				"none");
}

function hideShowDealChargesNavigator(hideShow)
{
	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('navGrid',
			'' + "#dealChargesGridTbl_Id_" + _pageRef + "_pager", {
				del : hideShow,
				add : hideShow,
				edit : false,
				refresh : false,
				search : false,
				addfunc : "addDealCharges",
				delfunc : "deleteDealCharges"
			}, // options
			{}, {}, {}, {}, {});

}
/*******************************************************************************
 * Method for set sum of repayment amount to the hidden variable
 */

/*******************************************************************************
 * Method for editing repayment criteria
 */

function editRepaymentCriteria(rowId)
{
	// if($("#"+rowId+"_PAYM_PERIODICITY").val() == "M"){
	// if($("#"+rowId+"_PAYM_PERIOD_POS").val() == "-1"){
	// $("#"+rowId+"_PAYM_PERIOD_POS").val("D");
	// }
	// }
	// else{
	// $("#"+rowId+"_PAYM_PERIOD_POS").val("-1");
	// $("#"+rowId+"_PAYM_PERIOD_POS").hide();
	// $("#"+rowId+"_PAYM_DAY").hide();
	//
	// }
	if ($("#" + rowId + "_PAYM_PERIODICITY").val() != "M")
	{
		$("#" + rowId + "_PAYM_PERIOD_POS").val("-1");
		$("#" + rowId + "_PAYM_PERIOD_POS").hide();
		$("#" + rowId + "_PAYM_DAY").hide();
	}
	if ($("#" + rowId + "_PAYM_PERIOD_POS").val() != "D")
	{
		$("#" + rowId + "_PAYM_DAY").hide();
	}

	if ($("#" + rowId + "_PAYMENT_TYPE").val() == "S"
			|| $("#" + rowId + "_PAYMENT_TYPE").val() == "C"
			|| $("#" + rowId + "_PAYMENT_TYPE").val() == "B"
			|| $("#" + rowId + "_PAYMENT_TYPE").val() == "A"
			|| $("#" + rowId + "_PAYMENT_TYPE").val() == "A")

	{
		// $("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
		// rowId, 'CAPITAL_AMT', false);
		$("#" + rowId + "_CAPITAL_AMT").show();
	}
	else
	{
		// $("#repaymentgridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
		// rowId, 'CAPITAL_AMT', true);
		$("#" + rowId + "_CAPITAL_AMT").hide();
	}

	// if ($(pymttype).val() == "B") {
	// $(cptlamt).show();
	// } else if ($(pymttype).val() == "C") {
	// $(cptlamt).show();
	// } else if ($(pymttype).val() == "S") {
	// $(cptlamt).show();
	// } else if ($(pymttype).val() == "A") {
	// $(cptlamt).show();
	// } else if ($(pymttype).val() == "O") {
	// $(cptlamt).show();
	// } else {
	//
	// $(cptlamt).hide();
	// }

	// setRepaymentFormat();

	// TP#235332;Arun.R.Variyath;30/10/2014
	onChangeAutoCreateSettlementYN();
}
/*******************************************************************************
 * Method for deleting repayment criteria
 */
function deleteRepaymentCriteria()
{
	_showConfirmMsg(Confirm_Delete_Process_key, confirm_msg_title,
			"deleteRepaymentCriteriaRecord", "yesNo");
}
function deleteRepaymentCriteriaRecord(yesNo)
{
	if (yesNo)
	{
		var rowId = $("#repaymentgridTbl_Id_" + _pageRef).jqGrid(
				'getGridParam', 'selrow');
		$("#repaymentgridTbl_Id_" + _pageRef).jqGrid('delRowData', rowId);
		resetRepaymentSum();
	}
}

function resetRepaymentSum()
{
	$("#repaymentAmountSum_" + _pageRef).val(calculateTotal());// Resetting the
	// sum amount in
	// repayment
	// criteria
}

$.subscribe('editRepaymentCriteria', function(event, data)
{
	editRepaymentCriteria(event.originalEvent.id);
});

function getColumnIndexByName(repaymentGrid, columnName)
{
	var cm = repaymentGrid.jqGrid('getGridParam', 'colModel');
	for (var i = 0, l = cm.length; i < l; i++)
	{
		if (cm[i].name === columnName)
		{
			return i; // return the index
		}
	}
	return -1;
}

function getTextFromCell(cellNode)
{
	return cellNode.childNodes[0].nodeName === "INPUT" ? cellNode.childNodes[0].value
			: cellNode.textContent || cellNode.innerText;
}

function calculateTotal()
{
	var totalAmount = 0;
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	// var totalAmount = Number(repaymentGrid.jqGrid('getCol', 'CAPITAL_AMT',
	// false, 'sum'));
	var rowIds = repaymentGrid.jqGrid('getDataIDs');
	var totalAmount = Number(0);
	for (var i = 0; i < rowIds.length; i++)
	{
		if (repaymentGrid.jqGrid('getCell', rowIds[i], 'CAPITAL_AMT') == 'B'
				|| repaymentGrid.jqGrid('getCell', rowIds[i], 'CAPITAL_AMT') == 'O'
				|| repaymentGrid.jqGrid('getCell', rowIds[i], 'CAPITAL_AMT') == 'C')
		{
			var noOfPayments = repaymentGrid.jqGrid('getCell', rowIds[i],
					'NO_OF_PAYMENTS');
			var capitalAmount = repaymentGrid.jqGrid('getCell', rowIds[i],
					'CAPITAL_AMT');
			if (capitalAmount == "")
				capitalAmount = Number(0);
			if (noOfPayments == "")
				noOfPayments = Number(0);
			totalAmount = Number(totalAmount)
					+ (Number(capitalAmount) * Number(noOfPayments));
		}
	}
	return totalAmount;
}

/**
 *
 * Methode for handling the change event for the First Payment Date
 *
 */

function onChangeFirstPaymentDate()
{
	var params = {};
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	$
			.ajax({

				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeFirstPaymentDate",

				type : "post",

				data : params,

				dataType : "json"
			/*
			 * ,
			 *
			 * success: function(data){
			 *
			 * if(data["_error"] == null){
			 *
			 * //TODO handle error }
			 *
			 * else if(typeof data["_confirm"] != "undefined" ||
			 * data["_confirm"] != null){
			 *
			 * //TODO handle confirm } }
			 */

			});

}

function enableVatApplicable()
{
	if ($("#vatApplicable_" + _pageRef).is(':checked') == true)
	{
		// if(!($("#vatAmount_"+_pageRef).is(':checked')))
		{
			$("#vatAmount_" + _pageRef).hide();
			$("#Installment_Amount_" + _pageRef).attr("disabled", true)
			$("#Installment_Amount_" + _pageRef).hide();
			$("#lookupdiv_vatCode_" + _pageRef).hide();
			$("#vatDesc_" + _pageRef).attr("readonly", "true");
			$("#vatPercentage_" + _pageRef).attr("readonly", "true");

		}
		// else
		// {
		// $('#lookupdiv_vatCode_'+_pageRef).show();
		// $('#vatAmount_'+_pageRef).show();
		// }
	}
	else
	{
		// $('#lookupdiv_vatCode_'+_pageRef).show();
		// $('#vatAmount_'+_pageRef).show();
		// $('#Installment_Amount_+_VAT_Amount_'+_pageRef).show();
		// $("#vatPercentage_"+_pageRef).attr("readonly", "false");
		// $("#vatDesc_"+_pageRef).attr("readonly", "false");
		// $("#lookupdiv_vatCode_"+_pageRef).attr("readonly", "false");
	}
}

// Debit Burdun Ratio Popup

function onDebitBurdunRatioButtonClicked()
{
	var cifNo = $("#lookuptxt_cifNo_" + _pageRef).val();
	var productClass = $("#lookuptxt_productClass_" + _pageRef).val();
	var currencyCode = $("#lookuptxt_currencyCode_" + _pageRef).val();
	var mySrc = jQuery.contextPath
			+ "/path/islamicCalculator/islamicCalculatorDBRatio_populateIslamicCalculatorDebitBurdunRatioPopup.action?_pageRef="
			+ _pageRef + "&cifNo=" + cifNo + "&productClass=" + productClass
			+ "&currencyCode=" + currencyCode;
	_showProgressBar(true);
	$("#islamicCalculatorDebitBurdunRatiosDialog_" + _pageRef).load(mySrc);
	dialogOptions = {
		'height' : returnMaxHeight(360),
		'width' : returnMaxWidth(530)
	};
	$("#islamicCalculatorDebitBurdunRatiosDialog_" + _pageRef).dialog(
			dialogOptions);
	$("#islamicCalculatorDebitBurdunRatiosDialog_" + _pageRef).dialog("open");
	_showProgressBar(false);
}

/*******************************************************************************
 * Method for setting the total DBR ratio
 */
function setDBRTotal()
{
	var dbrGrid = $("#DBRGridTbl_Id_" + _pageRef);
	var rowIds = dbrGrid.jqGrid('getDataIDs');
	var dbrValueSum = dbrGrid.jqGrid('getCol', 'dbrAmount', false, 'sum');
	if (rowIds.length > 7)
		dbrGrid.jqGrid('setCellValue', rowIds[7], 'dbrAmount', dbrValueSum);
	var decimalPoints = $("#hidden_islamicCalcDecimalFormat_" + _pageRef).val();
	dbrGrid.jqGrid('footerData', 'set', {
		dbrAmount : formatToCurrencyDecimal(dbrValueSum, decimalPoints)
	}, false);

	dbrGrid.jqGrid("setRowData", rowIds[3], "", {
		background : "#FD97FB",
		opacity : "1"
	});
	dbrGrid.jqGrid("setRowData", rowIds[7], "", {
		background : "#FD97FB",
		opacity : "1"
	});

	var gviewNode = jQuery("#DBRGridTbl_Id_" + _pageRef)[0].parentNode.parentNode.parentNode;
	var sdiv = jQuery(".ui-jqgrid-sdiv", gviewNode);
	sdiv.find(".footrow td").css({
		"white-space" : "normal",
		"height" : "auto",
		"vertical-align" : "text-top",
		"padding-top" : "2px"
	});
}
/*******************************************************************************
 * Method for handling the on change event of periodicity
 *
 * @param {Object}
 *            t
 */
function onChangePeriodicityPaymentType(t)
{
	// var row = $(t.target).closest('tr.jqgrow');
	// var rowId = row.attr('id');
	// IE-8 Fix
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	var rowId = repaymentGrid.jqGrid("getGridParam", 'selrow');

	var pymttype = document.getElementById(rowId + "_PAYMENT_TYPE");
	var cptlamt = document.getElementById(rowId + "_CAPITAL_AMT");
	if ($(pymttype).val() == "B")
	{
		$(cptlamt).show();
	}
	else if ($(pymttype).val() == "C")
	{
		$(cptlamt).show();
	}
	else if ($(pymttype).val() == "S")
	{
		$(cptlamt).show();
	}
	else if ($(pymttype).val() == "A")
	{
		$(cptlamt).show();
	}
	else if ($(pymttype).val() == "O")
	{
		$(cptlamt).show();
	}
	else
	{

		$(cptlamt).hide();
	}
	populateOnChangeRepaymentCriteriaPaymentType(rowId);
}

/*******************************************************************************
 * Method for handling the on change event of periodicity
 *
 * @param {Object}
 *            t
 */
function onChangePeriodicity(t)
{
	// var row = $(t.target).closest('tr.jqgrow');
	// var rowId = row.attr('id');
	// IE-8 fix
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	var rowId = repaymentGrid.jqGrid("getGridParam", 'selrow');
	var periodicity = document.getElementById(rowId + "_PAYM_PERIODICITY");
	var at = document.getElementById(rowId + "_PAYM_PERIOD_POS");
	var prdPosition = document.getElementById(rowId + "_PAYM_DAY");
	if ($(periodicity).val() != "M")
	{
		$(at).val("-1");
		$(at).hide();
		$(prdPosition).val("");
		$(prdPosition).hide();
	}
	else
	{
		if ($(at).val() == "-1")
			$(at).val("D");
		else
			$(at).val($(at).val());

		$(at).show();
		$(prdPosition).show();
	}
	populateOnChangeRepaymentCriteriaPeriodicityPeriod(rowId);
}

/*******************************************************************************
 * Method for handling the on change event of periodicity
 *
 * @param {Object}
 *            t
 */
function onChangePeriodicityPosition(t)
{
	// var row = $(t.target).closest('tr.jqgrow');
	// var rowId = row.attr('id');
	// IE-8 fix
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	var rowId = repaymentGrid.jqGrid("getGridParam", 'selrow');
	var at = document.getElementById(rowId + "_PAYM_PERIOD_POS");
	var prdPosition = document.getElementById(rowId + "_PAYM_DAY");
	if ($("#" + rowId + "_PAYM_PERIODICITY").val() == "M"
			&& $("#" + rowId + "_PAYM_PERIOD_POS").val() == "-1")
	{
		$("#" + rowId + "_PAYM_PERIOD_POS").val("D");
	}
	if ($(at).val() != "D")
	{
		// $("#repaymentgridTbl_Id_"+_pageRef).jqGrid("setCellReadOnly",rowId,"PAYM_DAY",true);
		$(prdPosition).hide();
	}
	else
	{
		// $("#repaymentgridTbl_Id_"+_pageRef).jqGrid("setCellReadOnly",rowId,"PAYM_DAY",false);
		$(prdPosition).show();
	}
	populateOnChangeRepaymentCriteriaPeriodicityPosition(rowId);
}

/*******************************************************************************
 * Method for handling the on change event of periodicity
 *
 * @param {Object}
 *            row
 */
function hideShowAt(rowId)
{
	var at = document.getElementById(rowId
			+ "_trsPayplanCriteriaVO.PAYM_PERIOD_POS");
	var periodicity = document.getElementById(rowId
			+ "_trsPayplanCriteriaVO.PAYM_PERIODICITY");
	if ($(periodicity).val() != "M")
	{
		$(at).hide();
	}
	else
		$(at).show();
}

function setBaloonPaymentGrid(data)
{
	var balloonAmount = 0;
	$("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid("clearGridData", true)
			.trigger("reloadGrid");
	for (var i = 0; i < data.islamicCalculatorEventMgmtCO.balloonDetailsList.length; i++)
	{// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
		balloonAmount = balloonAmount
				+ data.islamicCalculatorEventMgmtCO.balloonDetailsList[i].balloonAmount;
		$("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid('addRowData', i + 1,
				data.islamicCalculatorEventMgmtCO.balloonDetailsList[i]);
	}
}

// TP#209466; Ramesh; Date 13/08/2014
function islamicCalculator_productClassBeforeDependencyValue()
{
	setInputValue("hidden_prevValue_" + _pageRef, $(
			'#lookuptxt_productClass_' + _pageRef).val());
}

function onChangeFacilityNumber()
{

	var params = {};

	params["islamicCalculatorEventMgmtCO.facilityBranch"] = $(
			"#lookuptxt_trsdealVO_FACILITY_BRANCH_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.facilityNbr"] = $(
			"#lookuptxt_trsdealVO_FACILITY_NUMBER_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.facilitySubNo"] = $(
			"#facilitySubNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();

	$
			.ajax({
				url : $.contextPath
						+ "/path/iis/billcalculator/BillsCalculatorEvntMgmt_onChangeFacilityNbr",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{

						$("#facilitySubNo_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.facilitySubNo);

						$("#lookuptxt_currencyCode_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.currencyCode);

						$("#lookuptxt_cifNo_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.cifNo);

						$("#lookuptxt_productClass_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.productClass);

						$("#tfaTrxType_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.tfaTrxType);

						$("#tfaLinkYn_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.tfaLinkYn);

						$("#tfa_discounting_margin_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.tfaDiscountingMargin);

						$("#tfa_trs_amount_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.tfaTrsAmount);

						$("#tfa_bill_amount_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.tfaBillAmount);

						$("#unutilized_facility_amt_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.unutilizedFacilityAmt);

						$("#noOfBills_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.noOfBills);

						setInputValue("noOfPayments_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.noOfPayments);

						$("#billAmount_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.billAmount);

						$("#Total_Bill_Amount_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.totalBillAmount);

						$("#amountPerPayment_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.amountPerPayment);

						$("#tfa_bill_amount_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.tfaBillAmount);

						setInputValue("plan_maturity_date_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.maturityDate);

						setInputValue("gracePeriod_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriod);
						setInputValue(
								"gracePeriodicity_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriodicity);

						setInputValue(
								"firstPaymentDate_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.firstPaymentDate);

						$("#annualYieldRate_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.yield);

						$("#cifName_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.cifName);

					}
				}
			});

}

function islamic_onChangeProductClass()
{

	var params = {};
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	// TP 253158 -Renaming by product category - Sreejith
	params["islamicCalculatorEventMgmtCO.pageRef"] = _pageRef;

	// sankar
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;

	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
		// TP#280422;Arun.R.Variyath;16/03/2015
		params["islamicCalculatorEventMgmtCO.limitSerialNo"] = $(
				"#lookuptxt_limitSerialNo_" + _pageRef).val();
	}
	else
	{

		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.tempCode"] = $(
			"#lookuptxt_tempCode_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.noOfMonths"] = $(
			"#noOfMonths_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
			"#noOfPayments_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.roundingFactor"] = $(
			"#roundingFactor_" + _pageRef).val();
	
	params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
			"#downPaymentPercentage_" + _pageRef).val();

	var purchaseAmount = returnHtmlEltValue('purchaseAmount_' + _pageRef);
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;

	if (calculator_type != "AR_RAHANU" || calculator_type != "BILLS_CALCULATOR")
	{
		var downPaymentAmount = returnHtmlEltValue('downPaymentAmount_'
				+ _pageRef);
		params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
	}
	if (calculator_type == "BILLS_CALCULATOR")
	{
		params["strNIDCDetail"] = $("#NIDCDetail_Id_" + _pageRef).jqGrid(
				'getAllRows');
	}

	var financingAmount = returnHtmlEltValue('financingAmount_' + _pageRef);

	if (calculator_type !== "AR_RAHANU")
	{

		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;

		params["islamicCalculatorEventMgmtCO.yield"] = returnHtmlEltValue('annualYieldRate_'
				+ _pageRef);
	}

	// TP#197054; Ramesh; Date 01/07/2014
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;

	// Added deal charges as param - based on issue 0092514
	if (calculator_type == "BILLS_CALCULATOR")
	{
		params["strBillsDealCharges"] = returnGridDataForCalc("dealChargesGridTbl_Id");
	}

	_showProgressBar(true);

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeProductClass",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						// TP#681370 Mathew 03Jun18
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null) {
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title,
									function(confirmChoice, theArgs) {
										if (confirmChoice) {
											setInputValue(
													"maturityDate_" + _pageRef,
													data.islamicCalculatorEventMgmtCO.maturityDateAfterHoliday);
										}
									});
						}
						//713888 - Start
						setInputValue("repaymentPlan_holidayAction_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.holidayAction);
						setInputValue("holidayActionOriginalVal_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.holidayAction);						
						//713888 - End
						setInputValue("annualYieldRate_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.yield);

						setInputValue("noOfPayments_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.noOfPayments);
						$("#noOfPayments_" + _pageRef).attr("prevvalue",
								data.islamicCalculatorEventMgmtCO.noOfPayments);

						$("#roundingFactor_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.roundingFactor);
						setPeriodicityDetails(data.islamicCalculatorEventMgmtCO.paymPeriodicity);
						$("#paymPeriodNbr_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.paymPeriodNbr);
						$("#paymPeriodPos_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.paymPeriodPos);
						setInputValue("gracePeriod_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriod);
						setInputValue(
								"gracePeriodicity_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriodicity);

						$("#profitCalcMethod_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.profitCalcMethod);
						// $("#profitRecognitionMethod_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.profitRecognitionMethod);

						$("#profitRecognitionMethod_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.profitDistMethod);

						$("#lookuptxt_tempCode_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.tempCode);

						$("#islamicCalculatorEventMgmtCO_category_" + _pageRef)
								.val(data.islamicCalculatorEventMgmtCO.category);
						
					  	//DN# EWBI160013; deepu.mohandas  9/05/2016
					  	$("#applytegyn_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.APPLY_TEG_YN);
					  	if(data.islamicCalculatorEventMgmtCO.APPLY_TEG_YN=="Y"){
					  		$('#applytegyn_' + _pageRef).prop('checked',true);
					  	}
					  	else
					  	{
					  		$('#applytegyn_' + _pageRef).prop('checked',false);
					  	}
						
						// TP#245197;Ravikant.Singh ;01/12/2014
						if (_pageRef == "M0168")
						{
							$("#hidden_PROFIT_UPFRONT_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.profitUpfront);
							$(
									"#hidden_islamicCalculator_FLOATING_RATE_"
											+ _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.FLOATING_RATE);
							$("#lookuptxt_floatingRateCode_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.floatingRateCode);
							$("#floatingRateCode_desc_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.floatingRateCodeDesc);
						}

						$("#startDate_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.startDate);
						$("#reschedule_value_date_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.startDate);
						// TP#193281; Ramesh; Date 25/06/2014

						if (_pageRef == "M01681")
						{
							$("#trsdealVO_DEAL_DATE_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.startDate);
							$("#lookuptxt_investmentDeals_CLASS_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.productClass);

							// TP# 234177;deepu.mohandas 24/10/2014
							if (data.islamicCalculatorEventMgmtCO.showPaySchedule == 'N')
							{
								$("#projectdisbursementdiv_" + _pageRef).hide();
								$(
										"#repaymentTentativeCriteriaDiv_Id_"
												+ _pageRef).hide();
							}
							else
							{
								$("#projectdisbursementdiv_" + _pageRef).show();
								$(
										"#repaymentTentativeCriteriaDiv_Id_"
												+ _pageRef).show();

							}

							// TP# 236345;deepu.mohandas 30/10/2014
							$("#plan_maturity_date_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.maturityDate);
							$("#reschedule_value_date_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.startDate);

							$("#lookuptxt_floatingRateCode1_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.floatingRateCode);
							$("#floatingRateCode_desc12_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.floatingRateCodeDesc);

							// TP#255360; Ramesh; Date 12/01/2015 [START]
							if ((data.islamicCalculatorEventMgmtCO.category == 1)
									|| (data.islamicCalculatorEventMgmtCO.category == 2)
									|| (data.islamicCalculatorEventMgmtCO.category == 13)
									|| (data.islamicCalculatorEventMgmtCO.profitUpfront == 'Y')
									|| (data.islamicCalculatorEventMgmtCO.FLOATING_RATE == 'N'))
							{
								$("#lookupid_floatingRateCode1_" + _pageRef)
										.hide();
								$("#lbl_Floating_rate_type_" + _pageRef).hide();
								$("#floatingRateCode_desc12_" + _pageRef)
										.hide();
								$("#lbl_Floating_Rate_" + _pageRef).hide();
								$("#floatingRate_" + _pageRef).hide();
								$("#margin_" + _pageRef).hide();
								$("#lbl_Margin_" + _pageRef).hide();

							}
							else
							{

								$("#lookupid_floatingRateCode1_" + _pageRef)
										.show();
								$("#lbl_Floating_rate_type_" + _pageRef).show();
								$("#floatingRateCode_desc12_" + _pageRef)
										.show();
								$("#lbl_Floating_Rate_" + _pageRef).show();
								$("#floatingRate_" + _pageRef).show();
								$("#margin_" + _pageRef).show();
								$("#lbl_Margin_" + _pageRef).show();

							}
							// TP#255360; Ramesh; Date 12/01/2015 [END]

						}
						// For Bills calulatior
						if (calculator_type == "BILLS_CALCULATOR")
						{
							$("#linkType_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.linkTypeList);
							var len = data.islamicCalculatorEventMgmtCO.linkTypeList.length;
							$t = document
									.getElementById('linkType_' + _pageRef);
							$t.options.length = 0;
							for (var i = 0; i < len; i++)
							{
								$t.options[$t.options.length] = new Option(
										data.islamicCalculatorEventMgmtCO.linkTypeList[i].descValue,
										data.islamicCalculatorEventMgmtCO.linkTypeList[i].code);
							}
						}

						$("#accrualBasis_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.accrualBasis);										
//TP#682482; Srikumar; Restricting to 2 decimal places
						setInputValue('downPaymentPercentage_' + _pageRef, 
								data.islamicCalculatorEventMgmtCO.downPaymentPercentage);
						
						$("#debtBurdanRatio_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.debtBurdanRatio);

						// $("#startDate_"+_pageRef).datepicker("setDate", new
						// Date(data.islamicCalculatorEventMgmtCO.startDate));
						// $("#maturityDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.maturityDate));
						// $("#firstPaymentDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.firstPaymentDate)
						// );
						// $("#hidden_defaultMaturityDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.maturityDate)
						// );

						// The below setting is for IE 9

						$("#startDate_" + _pageRef).datepicker("setDate",
								data.islamicCalculatorEventMgmtCO.startDate);
						// TP#197054; Ramesh; Date 01/07/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_VALUE_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.startDate);
						}
						if (_pageRef == "M0168"
								|| calculator_type == "AR_RAHANU"
								|| calculator_type == "BILLS_CALCULATOR")
						{
							// TP-638365
							setInputValue(
									"plan_maturity_date_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.maturityDate);
							setInputValue(
									"hidden_PROFIT_UPFRONT_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.profitUpfront);
						}
						else
						{

							$("#maturityDate_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
							$("#maturityDate_" + _pageRef)
									.attr(
											"prevvalue",
											data.islamicCalculatorEventMgmtCO.maturityDate);// TP#258960;roshin
							// ;08/01/2014
						}

						// TP#193281; Ramesh; Date 25/06/2014
						if (calculator_type == "BILLS_CALCULATOR")

						{
							if (data.islamicCalculatorEventMgmtCO.nidc == "Y")
							{
								$("#nidc_id_" + _pageRef).show();
							}
							else if (data.islamicCalculatorEventMgmtCO.nidc == "N")
							{
								$("#nidc_id_" + _pageRef).hide();
							}
							setInputValue("hiddenNidc_id_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.nidc);

							setInputValue(
									"plan_maturity_date_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.maturityDate);

							$("#noOfBills_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.noOfPayments);

							$("#periodicity_nbr_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.periodicityNbr);

							// $("#periodicity_nbr_" +
							// _pageRef).val(data.islamicCalculatorEventMgmtCO.periodicityNbr);

						}

						if (_pageRef == "M01681")
						{
							$("#trsdealVO_DEAL_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.startDate);
							$("#trsdealVO_MATURITY_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						// TP#214058; Ramesh; Date 03/09/2014 [START]
						// if(_pageRef == "M0162")
						// {
						if (data.islamicCalculatorEventMgmtCO.vatApplicable == 'Y')
						{
							$('#vatApplicable_' + _pageRef).attr('checked',
									true);
						}
						else
						{
							$('#vatApplicable_' + _pageRef).attr('checked',
									false);
						}

						if (data.islamicCalculatorEventMgmtCO.includeVatinInstallment == 'Y')
						{
							$('#vatInstallment_' + _pageRef).attr('checked',
									true);
						}
						else
						{
							$('#vatInstallment_' + _pageRef).attr('checked',
									false);
						}

						$("#lookuptxt_vatCode_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.vatCode);
						$("#vatDesc_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.vatDesc);
						$("#vatPercentage_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.vatPercentage);
						// }
						// TP#214058; Ramesh; Date 03/09/2014 [END]

						$("#firstPaymentDate_" + _pageRef)
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.firstPaymentDate);

						$("#hidden_defaultMaturityDate_" + _pageRef)
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.maturityDate);

						$("#lookuptxt_currencyCode_" + _pageRef).val(
								data.islamicCalculatorEventMgmtCO.currencyCode);// added
						// as
						// by
						// navas
						// as
						// per
						// manoj
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						if (data.islamicCalculatorEventMgmtCO.profitCalcMethod != null
								&& data.islamicCalculatorEventMgmtCO.profitCalcMethod == 'R')
						{
							$("#totalFlatRate_" + _pageRef).attr("readonly",
									true);
							$(
									"#compoundingDuringTheEntireDealPeriod_"
											+ _pageRef).show();
							$(
									"#lbl_compoundingDuringTheEntireDealPeriod_"
											+ _pageRef).show();
							if ($(
									"#compoundingDuringTheEntireDealPeriod_"
											+ _pageRef).is(':checked') == true)
								$(
										"#compoundingDuringTheEntireDealPeriod_"
												+ _pageRef).removeAttr(
										'checked');

						}
						else
							$("#totalFlatRate_" + _pageRef).removeAttr(
									"readOnly");
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{

							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
							{// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
							}
						}
						if (data.islamicCalculatorEventMgmtCO.payResAmt != null
								&& data.islamicCalculatorEventMgmtCO.payResAmt != undefined)
						{

							if (data.islamicCalculatorEventMgmtCO.payResAmt == "D")
								$(
										'input:radio[name=islamicCalculatorEventMgmtCO.payResAmt]:nth(0)')
										.attr('checked', true);
							else if (data.islamicCalculatorEventMgmtCO.payResAmt == "F")
								$(
										'input:radio[name=islamicCalculatorEventMgmtCO.payResAmt]:nth(1)')
										.attr('checked', true);
							else
								$(
										'input:radio[name=islamicCalculatorEventMgmtCO.payResAmt]:nth(2)')
										.attr('checked', true);
						}

						if (data.islamicCalculatorEventMgmtCO.firstPaymentDate == undefined
								|| data.islamicCalculatorEventMgmtCO.firstPaymentDate == null)
						{
							hideShowRepaymentNavigator(false);
							hideShowDealChargesNavigator(false);
						}
						else
						{
							hideShowRepaymentNavigator(true);
							hideShowDealChargesNavigator(true);

						}
						setSumofInsuranceCharges();
						// hideShowVatSection(data);

						// TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement
						// and reschedule Charges START
						$("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true).trigger("reloadGrid");
						if (data.islamicCalculatorEventMgmtCO.trsDealSettlementChargesCO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealSettlementChargesCO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealSettlementChargesCO.length; i++)
							{
								$("#settlementChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealSettlementChargesCO[i]);
							}
						}
						// TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement
						// and reschedule Charges END
						_showProgressBar(false);

						// BB150217 - Rescheduling and Loan Buyout CR105585 TP #
						// 412619
						if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
						{
							$("#dealType_Div_" + _pageRef).dialog("destroy");
							$("#dealType_Div_" + _pageRef).remove();
						}
						setInputValue("flexiPaymentYN_CheckBox_" + _pageRef,
								"N");
						setInputValue("flexi_month_" + _pageRef, "");
	
						//if(data.islamicCalculatorEventMgmtCO.calcDisableStartDate == "Y")
						//{
							validateOnChangeStartDate();
						//}
					}

					// TP#209466; Ramesh; Date 13/08/2014
					else
					{
						setInputValue("lookuptxt_productClass_" + _pageRef,
								$('#hidden_prevValue_' + _pageRef));
						setInputValue("productClassName_" + _pageRef, "");
						_showProgressBar(false);
					}

					applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
					// THE
					// DECIMAL
					// FORMAT
					// IN
					// ALL
					// AMOUNT
					// FIELDS

					if (_pageRef == "M0168"
							&& data.islamicCalculatorEventMgmtCO.floatingRateCode > 0
							&& data.islamicCalculatorEventMgmtCO.APPLY_FIX_RATE == "N")
					{
						if (data.islamicCalculatorEventMgmtCO.limitSerialNo != undefined
								&& data.islamicCalculatorEventMgmtCO.limitSerialNo > 0)
						{
							setInputValue(
									"floatingRate_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.floatingRate);
							setInputValue("margin_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.margin);
							setInputValue(
									"annualYieldRate_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.annualYieldRate);
							setInputValue(
									"iborRatePeriodicity_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.iborRatePeriodicity);
							setInputValue(
									"iborRatePeriodicityType_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.iborRatePeriodicityType);
							setInputValue(
									"floatingRateCode_desc_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.floatingRateCodeDesc);
							setInputValue(
									"iborPeriodicityTypeOld_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.IBOR_PERIODICITY_TYPE_OLD);
							setInputValue(
									"iborPeriodicityNumberOld_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.IBOR_PERIODICITY_NUMBER_OLD);
						}
						// TP 678917 - Rakesh
						var floatRateCode=		returnHtmlEltValue('lookuptxt_floatingRateCode_' + _pageRef);
						 if(floatRateCode !=null && floatRateCode !=undefined && floatRateCode>0){
						      $("#lookuptxt_floatingRateCode_" + _pageRef).trigger("change");
						 }
					}
					else
					{
						setInputValue("floatingRate_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.floatingRate);
						setInputValue("margin_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.margin);
						setInputValue(
								"annualYieldRate_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.annualYieldRate);
					}

				}

			});

}
/*******************************************************************************
 * Method to hide/show the vat section
 *
 * @param {Object}
 *            hideShowVat
 */
function hideShowVatSection(data)
{

	if (data.islamicCalculatorEventMgmtCO.showVat != undefined
			&& data.islamicCalculatorEventMgmtCO.showVat != null)
	{
		var vatInstallmentCheckBox = 'vatInstallment_' + _pageRef
				+ ',label[for="vatInstallment_' + _pageRef + '"]';
		var vatApplicableCheckBox = 'vatApplicable_' + _pageRef
				+ ',label[for="vatApplicable_' + _pageRef + '"]';
		var vatCodeLiveSearch = 'lookupdiv_vatCode_' + _pageRef;
		if (data.islamicCalculatorEventMgmtCO.showVat == 'N')
		{
			$('#lookuptxt_vatCode_' + _pageRef).val("");
			$('#vatDesc_' + _pageRef).val("");
			$('#vatPercentage_' + _pageRef).val("");
			$('#lbl_VAT_Code_' + _pageRef).hide();
			$('#vatCode_' + _pageRef).hide();
			$('#vatDesc_' + _pageRef).hide();
			$('#lbl_VAT_Percentage_' + _pageRef).hide();
			$('#vatPercentage_' + _pageRef).hide();
			$('#' + vatInstallmentCheckBox).hide();
			$('#' + vatCodeLiveSearch).hide();
			$('#' + vatApplicableCheckBox).hide();
			$('#vatSection_' + _pageRef).hide();
			if ($("#" + vatApplicableCheckBox).is(':checked') == true)
				$("#" + vatApplicableCheckBox).removeAttr('checked');
		}
		else
		{
			$('#lbl_VAT_Code_' + _pageRef).show();
			$('#vatCode_' + _pageRef).show();
			$('#vatDesc_' + _pageRef).show();
			$('#lbl_VAT_Percentage_' + _pageRef).show();
			$('#vatPercentage_' + _pageRef).show();
			$('#' + vatInstallmentCheckBox).show();
			$('#' + vatCodeLiveSearch).show();
			$('#vatSection_' + _pageRef).show();
			$('#' + vatApplicableCheckBox).show();
			if (data.islamicCalculatorEventMgmtCO.vatApplicable != undefined
					&& data.islamicCalculatorEventMgmtCO.vatApplicable != null
					&& data.islamicCalculatorEventMgmtCO.vatApplicable == 'Y')
			{
				$('#' + vatApplicableCheckBox).attr('checked', 'checked');

				if (data.islamicCalculatorEventMgmtCO.vatIcludedInInstallement != undefined
						&& data.islamicCalculatorEventMgmtCO.vatIcludedInInstallement != null
						&& data.islamicCalculatorEventMgmtCO.vatIcludedInInstallement == 'Y')
				{
					$('#' + vatInstallmentCheckBox).attr('checked', 'checked');
				}
				$('#lookuptxt_vatCode_' + _pageRef).val(
						data.islamicCalculatorEventMgmtCO.vatCode);
				$('#vatDesc_' + _pageRef).val(
						data.islamicCalculatorEventMgmtCO.vatDesc);
				$('#vatPercentage_' + _pageRef).val(
						data.islamicCalculatorEventMgmtCO.vatPercentage);
				var resetElements = {};
				resetElements[0] = "lookuptxt_vatCode_" + _pageRef;
				setElementsPreviousValue(resetElements);
			}
		}
	}
}

/*******************************************************************************
 * Method for handling the periodicity on clicking edit
 *
 * @param {Object}
 *            event
 * @param {Object}
 *            data
 */
$.subscribe('hideShowAt', function(event, data)
{
	hideShowAt(event.originalEvent.id);
});

function onChangeCivilId()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var params = {};
		params["islamicCalculatorEventMgmtCO.idNo"] = $(
				"#lookuptxt_civilId_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.cifNo"] = $(
				"#lookuptxt_cifNo_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeCivilId",
					type : "get",
					data : params,
					dataType : "json"
				/*
				 * , success: function(data){ if(data["_error"] == null){ } }
				 */
				});
	}
	else
		$("#lookuptxt_cifNo_" + _pageRef).val("")
}

/*******************************************************************************
 * Method for caling thr on change event of RepaymentCriteriaPeriodicityPeriod
 */

function populateOnChangeRepaymentCriteriaPeriodicityPeriod(rowId)
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.sumOfCapitalAmtRepayment"] = getNumber(
			$("#repaymentAmountSum_" + _pageRef), true);// $("#repaymentAmountSum_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYMENT_TYPE"] = $(
			"#" + rowId + "_PAYMENT_TYPE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_POS"] = $(
			"#" + rowId + "_PAYM_PERIOD_POS").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIODICITY"] = $(
			"#" + rowId + "_PAYM_PERIODICITY").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE"] = $(
			"#" + rowId + "_FROM_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE"] = $(
			"#" + rowId + "_TO_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT"] = $
			.parseNumber($("#" + rowId + "_CAPITAL_AMT").val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR"] = $(
			"#" + rowId + "_PAYM_PERIOD_NBR").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS"] = $(
			"#" + rowId + "_NO_OF_PAYMENTS").val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeRepaymentCriteriaPeriodicityPeriod",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						// $("#"+rowId+"_FROM_DATE").datepicker("setDate", new
						// Date(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE)
						// );
						// $("#"+rowId+"_TO_DATE").datepicker("setDate", new
						// Date(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE)
						// );
						// IE-8 fix
						$("#" + rowId + "_FROM_DATE")
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE);
						$("#" + rowId + "_TO_DATE")
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE);

						// $("#"+rowId+"_CAPITAL_AMT").val(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT);
						$("#" + rowId + "_CAPITAL_AMT")
								.val(
										$
												.formatNumberNumeric(
														data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT,
														{
															format : returnNbFormat($(
																	"#hidden_islamicCalcDecimalFormat_"
																			+ _pageRef)
																	.val()),
															applyRounding : true
														}));
						$("#" + rowId + "_NO_OF_PAYMENTS")
								.val(
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS);
						resetRepaymentSum();
					}
				}
			});

}

function populateOnChangeRepaymentCriteriaPeriodicityPosition(rowId)
{

	var params = {};
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.sumOfCapitalAmtRepayment"] = getNumber(
			$("#repaymentAmountSum_" + _pageRef), true);// $("#repaymentAmountSum_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYMENT_TYPE"] = $(
			"#" + rowId + "_PAYMENT_TYPE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_POS"] = $(
			"#" + rowId + "_PAYM_PERIOD_POS").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIODICITY"] = $(
			"#" + rowId + "_PAYM_PERIODICITY").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE"] = $(
			"#" + rowId + "_FROM_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE"] = $(
			"#" + rowId + "_TO_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT"] = $
			.parseNumber($("#" + rowId + "_CAPITAL_AMT").val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR"] = $(
			"#" + rowId + "_PAYM_PERIOD_NBR").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS"] = $(
			"#" + rowId + "_NO_OF_PAYMENTS").val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeRepaymentCriteriaPeriodicityPosition",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						// $("#"+rowId+"_FROM_DATE").datepicker("setDate", new
						// Date(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE)
						// );
						// $("#"+rowId+"_TO_DATE").datepicker("setDate", new
						// Date(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE)
						// );
						// IE-8 fix
						$("#" + rowId + "_FROM_DATE")
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE);
						$("#" + rowId + "_TO_DATE")
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE);

						// $("#"+rowId+"_CAPITAL_AMT").val(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT);
						$("#" + rowId + "_CAPITAL_AMT")
								.val(
										$
												.formatNumberNumeric(
														data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT,
														{
															format : returnNbFormat($(
																	"#hidden_islamicCalcDecimalFormat_"
																			+ _pageRef)
																	.val()),
															applyRounding : true
														}));
						$("#" + rowId + "_NO_OF_PAYMENTS")
								.val(
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS);
						resetRepaymentSum();
					}
				}
			});

}

function populateOnChangeRepaymentCriteriaPaymentType(rowId)
{

	var params = {};
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.sumOfCapitalAmtRepayment"] = getNumber(
			$("#repaymentAmountSum_" + _pageRef), true);// $("#repaymentAmountSum_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYMENT_TYPE"] = $(
			"#" + rowId + "_PAYMENT_TYPE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_POS"] = $(
			"#" + rowId + "_PAYM_PERIOD_POS").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIODICITY"] = $(
			"#" + rowId + "_PAYM_PERIODICITY").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE"] = $(
			"#" + rowId + "_FROM_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE"] = $(
			"#" + rowId + "_TO_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT"] = $
			.parseNumber($("#" + rowId + "_CAPITAL_AMT").val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR"] = $(
			"#" + rowId + "_PAYM_PERIOD_NBR").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS"] = $(
			"#" + rowId + "_NO_OF_PAYMENTS").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_DAY"] = $(
			"#" + rowId + "_PAYM_DAY").val();

	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	if (_pageRef == "M0168")
	{
		var strRepaymentCharges = $("#repaymentCriteriaGridTbl_Id_" + _pageRef)
				.jqGrid('getAllRows');
	}
	else
	{
		var strRepaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef).jqGrid(
				'getAllRows');
	}
	// TP#221204;Arun.R.Variyath;23/09/2014 [Start]
	var rowsRepaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef).jqGrid(
			'getDataIDs');

	if (rowsRepaymentCharges.length <= 0)
	{
		params["strRepaymentCharges"] = "";
	}
	else
	{
		params["strRepaymentCharges"] = strRepaymentCharges;
	}
	// TP#221204;Arun.R.Variyath;23/09/2014 [End]

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeRepaymentCriteriaPaymentType",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						// $("#"+rowId+"_CAPITAL_AMT").val(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT);
						$("#" + rowId + "_CAPITAL_AMT")
								.val(
										$
												.formatNumberNumeric(
														data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT,
														{
															format : returnNbFormat($(
																	"#hidden_islamicCalcDecimalFormat_"
																			+ _pageRef)
																	.val()),
															applyRounding : true
														}));
						$("#" + rowId + "_NO_OF_PAYMENTS")
								.val(
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS);

						resetRepaymentSum();
					}
				}
			});

}

function populateOnChangeRepaymentCriteriaNoOfPayments(t)
{
	// var row = $(t.target).closest('tr.jqgrow');
	// var rowId = row.attr('id');
	// IE-8 Fix
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	var rowId = repaymentGrid.jqGrid("getGridParam", 'selrow');
	var prevValue = repaymentGrid.jqGrid("getCellInputElt",
			repaymentGrid.jqGrid('getGridParam', 'selrow'), 'NO_OF_PAYMENTS')
			.attr("prevValue");
	var params = {};
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.sumOfCapitalAmtRepayment"] = getNumber(
			$("#repaymentAmountSum_" + _pageRef), true);// $("#repaymentAmountSum_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYMENT_TYPE"] = $(
			"#" + rowId + "_PAYMENT_TYPE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_POS"] = $(
			"#" + rowId + "_PAYM_PERIOD_POS").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIODICITY"] = $(
			"#" + rowId + "_PAYM_PERIODICITY").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE"] = $(
			"#" + rowId + "_FROM_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE"] = $(
			"#" + rowId + "_TO_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT"] = $
			.parseNumber($("#" + rowId + "_CAPITAL_AMT").val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR"] = $(
			"#" + rowId + "_PAYM_PERIOD_NBR").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS"] = $(
			"#" + rowId + "_NO_OF_PAYMENTS").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_DAY"] = $(
			"#" + rowId + "_PAYM_DAY").val();

	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeRepaymentCriteriaNoOfPayments",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						// $("#"+rowId+"_CAPITAL_AMT").val(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT);
						$("#" + rowId + "_CAPITAL_AMT")
								.val(
										$
												.formatNumberNumeric(
														data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT,
														{
															format : returnNbFormat($(
																	"#hidden_islamicCalcDecimalFormat_"
																			+ _pageRef)
																	.val()),
															applyRounding : true
														}));
						// $("#"+rowId+"_TO_DATE").datepicker("setDate", new
						// Date(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE)
						// );
						// IE-8 fix
						$("#" + rowId + "_TO_DATE")
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE);

						// convertToDate(gridId,dataValue)
						resetRepaymentSum();
					}
					else
					{
						$("#" + rowId + "_NO_OF_PAYMENTS").val(prevValue);
					}

				}
			});

}

/*******************************************************************************
 * Method before validating the submit
 */
function validateCalculate()
{
	var grids = [ $("#dealChargesGridTbl_Id_" + _pageRef),
			$("#repaymentgridTbl_Id_" + _pageRef),
			$("#balloonPaymentGridTbl_Id_" + _pageRef) ];
	verifyAndSaveGrid(grids);
	showWarningForCifSalaryMultiple();
	// 636487 Hari.K.S 21/03/2018
	$("#saveYN_" + _pageRef).val("Y");

	// 658575 Hari.K.S 28/04/2018
	$("#islamicCalculatorFormMaindiv_" + _pageRef).data("changeTrack", false);
}

/**
 * Method for handling the change event for the showWarningForCifSalaryMultiple
 * (before calling calculate)
 */
function showWarningForCifSalaryMultiple()
{
	// manojmv848123
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (calculator_type == "BILLS_CALCULATOR")
	{
		return validateFieldsForDealCharges();

	}

	_showProgressBar(true);
	var params = {};
	params["islamicCalculatorEventMgmtCO.productClass"] = returnHtmlEltValue('lookuptxt_productClass_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.cifNo"] = returnHtmlEltValue('lookuptxt_cifNo_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.currencyCode"] = returnHtmlEltValue('lookuptxt_currencyCode_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.calculatorType"] = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_showWarningForCifSalaryMultiple",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					_showProgressBar(false);
					if (data["_error"] == null)
					{
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId !== null)
						{
							_showErrorMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									warning_msg_title);
						}
						validateForCifSalaryMultiple();
					}
				}
			});
}

/**
 * Method for handling the change event for the validateForCifSalaryMultiple
 * (before calling calculate)
 */
function validateForCifSalaryMultiple()
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	/** BB Production Issue; Saheer.Naduthodi; 12/11/2018 <Begin> */
	params["islamicCalculatorEventMgmtCO.dealNo"] = returnHtmlEltValue('hidden_dealNo_'	+ _pageRef);
	/** BB Production Issue; Saheer.Naduthodi; 12/11/2018 <End> */
	_showProgressBar(true);
	// BB130272 Modification;Ravikant.Singh;19/05/2015
	var custOrGuarLibalityDetails = "";
	if (_pageRef.indexOf('M0162') == 0 || _pageRef.indexOf('M0166') == 0)
	{

		custOrGuarLibalityDetails = returnGridData("iisCalculatorCustGuarLiabilityGridTbl_Id_"
				+ _pageRef);

		setInputValue("custGuarLiabilityListDet_" + _pageRef,
				custOrGuarLibalityDetails);
		// TP#641609; Saheer.Naduthodi; 19/03/2018
		params["custGuarLiabilityListDet"] = returnHtmlEltValue('custGuarLiabilityListDet_'
				+ _pageRef);

	}

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateForCifSalaryMultiple",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					_showProgressBar(false);
					if (data["_error"] == null)
					{
						validateGeneralCustmerLimit(true);
					}
				}
			});
}

/**
 * Method for handling the change event for the validateGeneralCustmerLimit
 * (before calling calculate)
 */
function validateGeneralCustmerLimit(confirm, arg)
{
	if ($("#lookuptxt_cifNo_" + _pageRef).val() == undefined
			|| $("#lookuptxt_cifNo_" + _pageRef).val() == null
			|| $("#lookuptxt_cifNo_" + _pageRef).val() == "")
	{
		validateFieldsForDealCharges();
		return;
	}
	if (confirm)
	{
		var actionSrc;
		if (arg != "undefined" && arg != null)
		{
			if (arg.addUrlParam != "undefined" && arg.addUrlParam != null)
			{
				actionSrc = arg.actionURL + arg.addUrlParam;
			}
		}
		else
		{
			actionSrc = $.contextPath
					+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateGeneralCustmerLimit";
		}
		var params = {};
		var financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
				.val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.financingAmount"] 	= 	financingAmount;
		params["islamicCalculatorEventMgmtCO.cifNo"] 			= 	$("#lookuptxt_cifNo_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] 	= 	$("#lookuptxt_currencyCode_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.dealNo"] 			=	returnHtmlEltValue('hidden_dealNo_'	+ _pageRef);

		// BB130272 Modification;Ravikant.Singh;19/05/2015
		var custOrGuarLibalityDetails = "";
		if (_pageRef.indexOf('M0162') == 0 || _pageRef.indexOf('M0166') == 0)
		{

			custOrGuarLibalityDetails = returnGridData("iisCalculatorCustGuarLiabilityGridTbl_Id_"
					+ _pageRef);
			setInputValue("custGuarLiabilityListDet_" + _pageRef,
					custOrGuarLibalityDetails);
			params["custGuarLiabilityListDet"] = returnHtmlEltValue('custGuarLiabilityListDet_'
					+ _pageRef);

		}
		_showProgressBar(true);
		$
				.ajax({
					url : actionSrc,
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						_showProgressBar(false);
						if (data["_error"] == null)
						{
							
							if (typeof data["_confirm"] != "undefined"
									|| data["_confirm"] != null)
							{

								if (data.confirmType == "DEAL_AMOUNT_EXCEED_GENERAL_CUSTOMER_LIMIT")
								{
									_showConfirmMsg(
											data["_confirm"],
											"",
											"validateGeneralCustmerLimit",
											{
												actionURL : actionSrc,
												addUrlParam : "?islamicCalculatorEventMgmtCO.globalConfirmationFrom=DEAL_AMOUNT_EXCEED_GENERAL_CUSTOMER_LIMIT"
											}, "Continue", "Cancel");
									_showProgressBar(false);
									return;
								}
							}
							validateFieldsForDealCharges();
						}
					}
				});
	}
}
/**
 * Method for handling the change event for the validateFieldsForDealCharges for
 * submit
 */
function validateFieldsForDealCharges()
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.vatCode"] = $(
			'#lookuptxt_vatCode_' + _pageRef).val();
	if ($("#vatApplicable_" + _pageRef).is(':checked') == true)
		params["islamicCalculatorEventMgmtCO.vatApplicable"] = "Y";
	else
		params["islamicCalculatorEventMgmtCO.vatApplicable"] = "N";
	if ($("#vatInstallment_" + _pageRef).is(':checked') == true)
		params["islamicCalculatorEventMgmtCO.includeVatinInstallment"] = "true";
	else
		params["islamicCalculatorEventMgmtCO.includeVatinInstallment"] = "false";
	var vatPercentage = $.parseNumber($("#vatPercentage_" + _pageRef).val(), {
		format : $("#vatPercentage_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.vatPercentage"] = vatPercentage;
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});

	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;

	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	params["islamicCalculatorEventMgmtCO.calculatorType"] = calculator_type;
	if (calculator_type != "AR_RAHANU")
	{
		params["islamicCalculatorEventMgmtCO.yield"] = $(
				"#annualYieldRate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = $(
				"#profitCalcMethod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.totalFlatRate"] = $(
				"#totalFlatRate_" + _pageRef).val();
	}
	if (_pageRef == "M0162")
	{
		var contractPrice = $.parseNumber(
				$("#contractPrice_" + _pageRef).val(), {
					format : $("#contractPrice_" + _pageRef).attr("nbFormat"),
					locale : "us"
				});
		params["islamicCalculatorEventMgmtCO.contractPrice"] = contractPrice;
	}
	_showProgressBar(true);
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateFieldsForDealCharges",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					_showProgressBar(false);
					if (data["_error"] == null)
					{
						
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
						{
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title,
									"validateMaxFinancingAmountForDealCharges",
									"yesNo");
						}
						else
						{
							validateMaxFinancingAmountForDealCharges(true);
						}

					}

				}
			});
}
/**
 * Method for handling the change event for the
 * validateMaxFinancingAmountForDealCharges for submit
 */
function validateMaxFinancingAmountForDealCharges(yesNo)
{
	if (yesNo)
	{
		var params = {};
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		var financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
				.val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		if ($("#vatApplicable_" + _pageRef).is(':checked') == true)
			params["islamicCalculatorEventMgmtCO.vatApplicable"] = "Y";
		else
			params["islamicCalculatorEventMgmtCO.vatApplicable"] = "N";
		
		_showProgressBar(true);

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateMaxFinancingAmountForDealCharges",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						_showProgressBar(false);
						if (data["_error"] == null)
						{
							if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
									&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
							{
								_showConfirmMsg(
										data.islamicCalculatorEventMgmtCO.confirmationMessageId,
										confirm_msg_title,
										"validateNoOfPaymentsForDealCharges",
										"yesNo");
							}
							else
							{
								validateNoOfPaymentsForDealCharges(true);
							}
						}
					}
				});
	}
}
/**
 * Method for handling the change event for the
 * validateNoOfPaymentsForDealCharges for submit
 */
function validateNoOfPaymentsForDealCharges(yesNo)
{
	if (yesNo)
	{
		var params = {};
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);

		params["islamicCalculatorEventMgmtCO.pageRef"] = _pageRef;
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
				"#noOfPayments_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.startDate"] = $(
				"#startDate_" + _pageRef).val();
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);

		if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
				|| calculator_type == "BILLS_CALCULATOR")
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#plan_maturity_date_" + _pageRef).val();
		}
		else
		{
			params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
					"#maturityDate_" + _pageRef).val();
		}

		params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
				"#gracePeriodicity_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.dealPeriodCompounding"] = "N";
		// TODO yieldrequired
		params["islamicCalculatorEventMgmtCO.yield"] = $(
				"#annualYieldRate_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.noOfBaloonPayments"] = $(
				"#baloonPaymentNo_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.baloonAmount"] = $.parseNumber($(
				"#baloonAmount_" + _pageRef).val(), {
			format : $("#baloonAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
				"#firstPaymentDate_" + _pageRef).val();

		// TP#221204;Arun.R.Variyath;23/09/2014 [Start]
		var rowsBalloon = $("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
				'getDataIDs');

		if (rowsBalloon.length <= 0)
		{
			params["strBalloonDetails"] = "";
		}
		else
		{
			params["strBalloonDetails"] = $(
					"#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
					'getAllRows');
		}
		// TP#221204;Arun.R.Variyath;23/09/2014 [End]

		if (_pageRef == "M0168")
		{
			var strRepaymentCharges = $(
					"#repaymentCriteriaGridTbl_Id_" + _pageRef).jqGrid(
					'getAllRows');
		}
		else
		{
			var strRepaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef)
					.jqGrid('getAllRows');
		}

		// TP#221204;Arun.R.Variyath;23/09/2014 [Start]
		var rowsRepaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef)
				.jqGrid('getDataIDs');

		if (rowsRepaymentCharges.length <= 0)
		{
			params["strRepaymentCharges"] = "";
		}
		else
		{
			params["strRepaymentCharges"] = strRepaymentCharges;
		}
		// TP#221204;Arun.R.Variyath;23/09/2014 [End]

		params["islamicCalculatorEventMgmtCO.tempCode"] = $(
				"#lookuptxt_tempCode_" + _pageRef).val();

		var financingAmount = $.parseNumber($("#financingAmount_" + _pageRef)
				.val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();
		if ($("#vatApplicable_" + _pageRef).is(':checked') == true)
			params["islamicCalculatorEventMgmtCO.vatApplicable"] = "Y";
		else
			params["islamicCalculatorEventMgmtCO.vatApplicable"] = "N";
		
		_showProgressBar(true);

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateNoOfPaymentsForDealCharges",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						_showProgressBar(false);
						if (data["_error"] == null)
						{
							if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
									&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
							{
								_showConfirmMsg(
										data.islamicCalculatorEventMgmtCO.confirmationMessageId,
										confirm_msg_title,
										"validateRepayamentCriteriaList", "");
							}
							else
							{
								validateRepayamentCriteriaList();// submitCalculate();
							}
						}
					}
				});
	}
}
/*******************************************************************************
 * Method for validating repayment criteria list
 */
function validateRepayamentCriteriaList()
{
	var params = {};
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		var strRepaymentCharges = $("#repaymentCriteriaGridTbl_Id_" + _pageRef)
				.jqGrid('getAllRows');
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		var strRepaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef).jqGrid(
				'getAllRows');
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	// var strRepaymentCharges = $("#repaymentgridTbl_Id_" +
	// _pageRef).jqGrid('getAllRows');

	// TP#221204;Arun.R.Variyath;23/09/2014 [Start]
	// TP#212543; Ramesh ; 09/10/2014 [Added below if condition]
	if (_pageRef == "M0168")
	{
		var rowsRepaymentCharges = $("#repaymentCriteriaGridTbl_Id_" + _pageRef)
				.jqGrid('getDataIDs');
	}
	else
	{
		var rowsRepaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef)
				.jqGrid('getDataIDs');
	}

	if (rowsRepaymentCharges.length <= 0)
	{
		params["strRepaymentCharges"] = "";
	}
	else
	{
		params["strRepaymentCharges"] = strRepaymentCharges;
	}
	// TP#221204;Arun.R.Variyath;23/09/2014 [End]
	_showProgressBar(true);
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateRepayamentCriteriaList",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					_showProgressBar(false);
					if (data["_error"] == null)
					{
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
						{
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title, "submitCalculate", data);
						}
						else
						{
							// submitCalculate(true, data);
							validateOneObligorGlobalLimit();
						}
					}
				}
			});
}

/*******************************************************************************
 * Method for validating One Obligor Global Limit NIZI120160
 */
function validateOneObligorGlobalLimit()
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = $.parseNumber($(
			"#purchaseAmount_" + _pageRef).val(), {
		format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	})
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.floatingRate"] = $(
			"#annualFlatRate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.annualYieldRate"] = $(
			"#annualYieldRate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
			"#maturityDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.facilityTypeCode"] = $(
			"#lookuptxt_facilityTypeCode_" + _pageRef).val();
	if ($("#lookuptxt_drawDownBranch_" + _pageRef).val() != null
			&& $("#lookuptxt_drawDownBranch_" + _pageRef).val() != "")
	{
		params["islamicCalculatorEventMgmtCO.drawDownBranch"] = $(
				"#lookuptxt_drawDownBranch_" + _pageRef).val();
	}

	if ($("#lookuptxt_drawDownCode_" + _pageRef).val() != null
			&& $("#lookuptxt_drawDownCode_" + _pageRef).val() != "")
	{
		params["islamicCalculatorEventMgmtCO.drawDownCode"] = $(
				"#lookuptxt_drawDownCode_" + _pageRef).val();
	}

	if ($("#lookuptxt_trsdealVO_FACILITY_BRANCH_" + _pageRef).val() != null
			&& $("#lookuptxt_trsdealVO_FACILITY_BRANCH_" + _pageRef).val() != "")
	{
		params["islamicCalculatorEventMgmtCO.facilityBranch"] = $(
				"#lookuptxt_trsdealVO_FACILITY_BRANCH_" + _pageRef).val();
	}

	if ($("#lookuptxt_trsdealVO_FACILITY_NUMBER_" + _pageRef).val() != null
			&& $("#lookuptxt_trsdealVO_FACILITY_NUMBER_" + _pageRef).val() != "")
	{
		params["islamicCalculatorEventMgmtCO.facilityNbr"] = $(
				"#lookuptxt_trsdealVO_FACILITY_NUMBER_" + _pageRef).val();
	}

	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		var strRepaymentCharges = $("#repaymentCriteriaGridTbl_Id_" + _pageRef)
				.jqGrid('getAllRows');

	}
	else
	{
		var strRepaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef).jqGrid(
				'getAllRows');
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	if (_pageRef == "M0168")
	{
		var rowsRepaymentCharges = $("#repaymentCriteriaGridTbl_Id_" + _pageRef)
				.jqGrid('getDataIDs');
	}
	else
	{
		var rowsRepaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef)
				.jqGrid('getDataIDs');
	}

	if (rowsRepaymentCharges.length <= 0)
	{
		params["strRepaymentCharges"] = "";
	}
	else
	{
		params["strRepaymentCharges"] = strRepaymentCharges;
	}

	_showProgressBar(true);
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateOneObligorGlobalLimit",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					_showProgressBar(false);
					if (data["_error"] == null)
					{
						if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
								&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
						{
							_showConfirmMsg(
									data.islamicCalculatorEventMgmtCO.confirmationMessageId,
									confirm_msg_title, "submitCalculate", data);
						}
						else
						{
							submitCalculate(true, data, "N");
							
						}
					}
				}
			});
}


/*******************************************************************************
 * Method for form submitting for calculations
 */

function submitCalculate(confirm, data, tendative)
{
	var holidayAction = $("#repaymentPlan_holidayAction_" + _pageRef).val();

	if (data != null) 
	{
		var returnValue = data.returnValue;
		if (returnValue != undefined && returnValue != null && returnValue == "HOLIDAY_CHECKING") 
		{
			tendative=data.tendative;
			if (!confirm) 
			{
				holidayAction = -1;
				setInputValue("repaymentPlan_holidayAction_" + _pageRef,	-1);
			}
			confirm = true;
		}
	}
	if (data == null || (data != null && data.returnValue == null)) 
	{
		if (holidayAction != null && holidayAction != "") 
		{
			if (holidayAction == "1" || holidayAction == "2"
					|| holidayAction == "3" || holidayAction == "4"
					|| holidayAction == "5") {
				
					data["returnValue"]     = "HOLIDAY_CHECKING";
					data["tendative"]     	= tendative;
					_showConfirmMsg(
							Do_you_want_change_Repayment_plan_dates_as_per_Holiday_settings,
							Warning_key, submitCalculate, data, "Yes", "No");
					return 0;
				
			}
		}
	}
	if (confirm != true) {
		return;
	}
	
	//end
		
	if (tendative != undefined && tendative == "Y")
	{
		if ($("#scheduleGridTbl_Id_" + _pageRef).jqGrid('getDataIDs').length <= 0)
		{
			if ($("#paymentScheduleGridTbl_Id_1" + _pageRef).jqGrid(
					'getDataIDs').length <= 0)
			{
				return;
			}
			_showErrorMsg("Please Create Schedule", error_msg_title);
			return;
		}
		tendative = "Y";
	}
	else
	{
		tendative = "N";
	}
	if (confirm)
	{
		setRepaymentDetailsInForm(data);
		// parseNumbers();
		var settlementChargeGridData = $(
				"#settlementChargesGridTbl_Id_" + _pageRef)
				.jqGrid('getAllRows');
		setInputValue("settlementChargeGridData_" + _pageRef,
				settlementChargeGridData);
		// var theForm = $("#islamicCalculatorFormMaindiv_" +
		// _pageRef).serialize();
		//var theForm = $("#islamicCalculatorFormMaindiv_" + _pageRef)
			//	.serializeForm();

		var dealCharges = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
				'getAllRows');
		// var repaymentCharges = $("#repaymentgridTbl_Id_" +
		// _pageRef).jqGrid('getAllRows');
		var multipleYieldGrid = "";

		if (_pageRef == "M0168")
		{
			var repaymentCharges = $("#repaymentCriteriaGridTbl_Id_" + _pageRef)
					.jqGrid('getAllRows');
			multipleYieldGrid = $(
					"#InvestDealMultipleYieldGridTbl_Id_" + _pageRef).jqGrid(
					'getAllRows');
		}
		else
		{
			var repaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef)
					.jqGrid('getAllRows');
		}

		var strBalloonDetails = $("#balloonPaymentGridTbl_Id_" + _pageRef)
				.jqGrid('getAllRows');
		// TP#221204;Arun.R.Variyath;23/09/2014 [Start]

		if (_pageRef == "M0168")
		{
			var rowsRepaymentCharges = $(
					"#repaymentCriteriaGridTbl_Id_" + _pageRef).jqGrid(
					'getDataIDs');
		}
		else
		{
			var rowsRepaymentCharges = $("#repaymentgridTbl_Id_" + _pageRef)
					.jqGrid('getDataIDs');
		}

		if (rowsRepaymentCharges.length <= 0)
		{
			repaymentCharges = "";
		}
		var rowsBalloon = $("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid(
				'getDataIDs');

		if (rowsBalloon.length <= 0)
		{
			strBalloonDetails = "";
		}
		// TP#221204;Arun.R.Variyath;23/09/2014 [End]

		// TP#246877;Arun.R.Variyath;08/12/2014 [Start]
		var rowsMultipleYieldGrid = $(
				"#InvestDealMultipleYieldGridTbl_Id_" + _pageRef).jqGrid(
				'getDataIDs');
		if (rowsMultipleYieldGrid.length <= 0)
		{
			multipleYieldGrid = "";
		}
		// TP#246877;Arun.R.Variyath;08/12/2014 [End]

		var projectFinanceDetails = "";

		if (tendative == "Y")
		{
			if ($("#paymentScheduleGridTbl_Id_1" + _pageRef).jqGrid(
					'getDataIDs').length <= 0)
			{
				return;
			}
			var projectFinanceDetails = $(
					"#paymentScheduleGridTbl_Id_1" + _pageRef).jqGrid(
					'getAllRows');
			// TP#440366; Saheer.Naduthodi; 05/11/2016
			setInputValue("projectFinanceDetails_" + _pageRef,
					projectFinanceDetails);
			if ($("#repaymentTentativeCriteriaGridTbl_Id_" + _pageRef).jqGrid(
					'getDataIDs').length > 0)
			{
				var repaymentCharges = $(
						"#repaymentTentativeCriteriaGridTbl_Id_" + _pageRef)
						.jqGrid('getAllRows');
			}

		}
		// for Bills Caclulator
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		var strNIDCList = "";
		var strNIDCCouponPayment = "";

		if (calculator_type == "BILLS_CALCULATOR")
		{

			strNIDCList = $("#NIDCDetail_Id_" + _pageRef).jqGrid('getAllRows');
			strNIDCCouponPayment = $("#NIDCCouponPaymentDet_Id_" + _pageRef)
					.jqGrid('getAllRows');
			setInputValue("strNIDCCouponPayment_" + _pageRef,
					strNIDCCouponPayment);
		}

		//
		// TP#244113; Ramesh; Date 09/12/2014 [START]
		var balloonAmt = $("#baloonAmount_" + _pageRef).val();
		var totalAllocatedAmount = 0;
		
		//785196
		setInputValue("strRepaymentCharges_" + _pageRef,	repaymentCharges);
		var theForm = $("#islamicCalculatorFormMaindiv_" + _pageRef).serializeForm();
		
		var params = {};
		if (balloonAmt > 0)
		{
			var $table = $('#balloonPaymentGridTbl_Id_' + _pageRef);
			totalAllocatedAmount = $table.jqGrid('getCol', 'balloonAmount',
					false, 'sum');
			// if(totalAllocatedAmount != balloonAmt)
			// {
			// _showErrorMsg("Ballon Amount and Allocated Balloon Amount are
			// Miss Matched");
			// return;
			// }
			//785196
			theForm = theForm + "&strDealCharges=" + dealCharges
					+ "&strBalloonDetails=" + strBalloonDetails
					+ "&strMultipleYieldList=" + multipleYieldGrid
					+ "&tentativeSchedule=" + tendative + "&totalAllcBlnAmt="
					+ totalAllocatedAmount;
		}
		else
		{
			//785196
			theForm = theForm + "&strDealCharges=" + dealCharges
					+ "&strBalloonDetails=" + strBalloonDetails
					+ "&strMultipleYieldList=" + multipleYieldGrid
					+ "&tentativeSchedule=" + tendative + "&strNIDCList="
					+ strNIDCList;
		}
		
		
		
		
		// TP#244113; Ramesh; Date 09/12/2014[END]
		_showProgressBar(true);
		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_calculate",
					type : "post",
					data : theForm,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
						if(data.calculatorCO != "undefined" 
							&& data.calculatorCO != null 
							&& data.calculatorCO.showTegMessages == "Y")
						{
							setInputValue("hidden_showTegMessagesYN_"+_pageRef,"Y");	
						
							if(data.calculatorCO.minYeildReached == true )
							{	
								_showErrorMsg(teg_is_greater_than_the_tie_after_adjusting_yield_charges );
								
								_showErrorMsg(tie_rate_exeeded_key + ": " + current_yield_is_key + " " +
								data.calculatorCO.actualAnnualRate +
								"% " + and_related_teg_is_key + " " + data.calculatorCO.actualTegRate + "%", info_msg_title);
							
							
							}else{
						
								_showErrorMsg(the_optimum_teg_rate_should_be_key + " " +
								data.calculatorCO.tieRate +
								"% " + and_the_max_yield_should_be_key + " " + data.calculatorCO.tieAdjustedAnnualRate + "%", info_msg_title);
						
								_showErrorMsg(tie_rate_exeeded_key + ": " + current_yield_is_key + " " +
								data.calculatorCO.actualAnnualRate +
								"% "+and_related_teg_is_key + " " + data.calculatorCO.actualTegRate + "%", info_msg_title);
							}
						
						
						}
						else{
							setInputValue("hidden_showTegMessagesYN_"+_pageRef,"N");
						}
							
							var holidayActionOriginalValue = $("#holidayActionOriginalVal_" + _pageRef).val();
							setInputValue("repaymentPlan_holidayAction_" + _pageRef,holidayActionOriginalValue);
							
							if (data.islamicCalculatorEventMgmtCO.secondConfirmId != undefined
									&& data.islamicCalculatorEventMgmtCO.secondConfirmId != null)
							{
								if (data.islamicCalculatorEventMgmtCO.confirmMessageDetailId != undefined
										&& data.islamicCalculatorEventMgmtCO.confirmMessageDetailId != null
										&& data.islamicCalculatorEventMgmtCO.confirmMessageDetailId == '1')
								{
									_showConfirmMsg(
											data.islamicCalculatorEventMgmtCO.secondConfirmId,
											confirm_msg_title,
											"setCalculationDetails", data);
								}
								_showProgressBar(false);
							}
							else{
								setCalculationDetails(true, data);
							}
							$("#createDealBtn_"+ _pageRef).attr('aria-disabled', false).removeAttr("disabled").removeClass('ui-button-disabled ui-state-disabled');
							
						}
						else
						{
							_showProgressBar(false);
						}
						if (tendative != "Y")
						{
							applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
							// THE
							// DECIMAL
							// FORMAT
							// IN
							// ALL
							// AMOUNT
							// FIELDS
						}
					}
				});
	}
}
/*******************************************************************************
 * Sets the result section and schedule.
 */
function setCalculationDetails(yesNo, data)
{

	if (yesNo)
	{
		if (data.calculatorCO.tentativeSchedule == "Y")
		{
			setScheduleData(true, data);

			_showProgressBar(false);
			// TP#239096; Libin; Date 23/11/2014 ;Commented code and added new
			// message <Start>
			// _showErrorMsg(calculation_done_msg,info_msg_title);
			_showErrorMsg(tentative_Schedule_Created_msg_key, info_msg_title);
			// TP#239096; Libin; Date 23/11/2014 ;Commented code and added new
			// message <End>
			$("#islmcCalcTabs3_" + _pageRef).css("display", "list-item");
			return;
		}
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (calculator_type == "AR_RAHANU")
		{
			setInputValue("totalamt_" + _pageRef,
					data.calculatorCO.outRemainingAmount);
		}

		if (calculator_type == "BILLS_CALCULATOR")
		{
			setInputValue("financingAmount_" + _pageRef,
					data.calculatorCO.totalNetPrecentValue);
			setInputValue("purchaseAmount_" + _pageRef,
					data.calculatorCO.totalNetPrecentValue);
		}

		setInputValue("remainingAmount_" + _pageRef,
				data.calculatorCO.outRemainingAmount);
		setInputValue("saleAmount_" + _pageRef, data.calculatorCO.outSaleAmount);
		setInputValue("profit_" + _pageRef, data.calculatorCO.outProfitAmount);
		setInputValue("amountPerPaymentResult_" + _pageRef,
				data.calculatorCO.outAmountPerPayment);
		setInputValue("xirr_" + _pageRef, data.calculatorCO.xirrOut);
		setInputValue("apr_rate_" + _pageRef, data.calculatorCO.aprRate);
		if (data.calculatorCO.xirrWithChargesOut == null
				|| data.calculatorCO.xirrWithChargesOut == 0
				|| data.calculatorCO.xirrWithChargesOut == ""
				|| data.calculatorCO.xirrWithChargesOut == undefined)
		{
			hideObject($("#XIRR_With_Charges_" + _pageRef));
			hideObject($("#lbl_XIRR_With_Charges_" + _pageRef));
		}
		else
		{
			showObject($("#XIRR_With_Charges_" + _pageRef));
			showObject($("#lbl_XIRR_With_Charges_" + _pageRef));
			setInputValue("XIRR_With_Charges_" + _pageRef,
					data.calculatorCO.xirrWithChargesOut);
		}

		setInputValue("annualFlatRate_" + _pageRef,
				data.calculatorCO.outAnnualFlatRate);
		setInputValue("totalFlatRate_" + _pageRef,
				data.calculatorCO.outTotalFlatRate);
		setInputValue("noOfMonths_" + _pageRef, data.calculatorCO.noOfMonths);

		setInputValue("noOfPayments_" + _pageRef,
				data.calculatorCO.noOfPayments);
		// TP#212543; Ramesh; Date 31/08/2014
		setInputValue("paymPeriodNbr_" + _pageRef,
				data.calculatorCO.paymentPeriodicityNo);
		setInputValue("paymPeriodicity_" + _pageRef,
				data.calculatorCO.paymentPeriodicity);
		if (data.calculatorCO.applyAprRateYn == "N")
		{
		setInputValue("annualYieldRate_" + _pageRef,
				data.calculatorCO.annualYield);
		}

		if (data.islamicCalculatorEventMgmtCO.confirmationMessageId != undefined
				&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
			_showConfirmMsg(
					data.islamicCalculatorEventMgmtCO.confirmationMessageId,
					confirm_msg_title, "setScheduleData", data);
		else
			setScheduleData(true, data);
		_showProgressBar(false);
		_showErrorMsg(calculation_done_msg, info_msg_title);
		//TP:683294;Libin;08/06/2018;
		if(recalulate_key!="")
		{
			$('#calculator_Calculate_btn_label_'+ _pageRef).text(recalulate_key);
		}
		//688242
		$("#islmcCalcTabs2_" + _pageRef).css("display", "list-item");
	    $("#islmcCalcMainTabs_" + _pageRef).tabs("select", 1);
		if ($("#hidden_disableBtnAfterCalc_" + _pageRef).val() == "Y")
		{
			$("#calculateBtn_" + _pageRef).attr('disabled', 'disabled');
		}
		// TP#239091;Arun.R.Variyath;10/11/2014 M0168
		$("#islamicCalculatorFormMaindiv_" + _pageRef).data("changeTrack",
				false);
	}
}

/*******************************************************************************
 * Method for setting schedule data
 *
 * @param {Object}
 *            yesNo
 * @param {Object}
 *            data
 */
function setScheduleData(yesNo, data)
{

	if (yesNo)
	{
		if (data.calculatorCO.tentativeSchedule == "Y")
		{
			$("#islmcCalcTabs3_" + _pageRef).css("display", "list-item");
			fillTendativeScheduleList(data.calculatorCO.trspayplandetVOList);
			return;
		}
		fillScheduleList(data.calculatorCO.trspayplandetVOList);
		setScheduleSummary();
		//initializePrintIcon();
		var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
				+ _pageRef);
		if (calculator_type == "BILLS_CALCULATOR")
		{
			islamicCalculator_fillChargesGrid(data.calculatorCO.trsdealchargesVO)
		}
		islamicCalculator_fillGracePeriodPorifutScheduleList(data.calculatorCO.trspayplan_BREAKUP_PROFITVs);

	}
}

//Added By Manoj on 18/04/2018 for DB170110 - Multiple Yield R14_0_14 <Start>
/***
 * Method for filling data into Grace period 
 * @param {Object} scheduleList
 */
function islamicCalculator_fillGracePeriodPorifutScheduleList(scheduleList)
{
	if(scheduleList == undefined || scheduleList == null || scheduleList == "" ){
		return;
	}
	if($.trim( $("#gracePeriodProfitScheduleDiv_"+ _pageRef).html()).length > 0)
	{
		$("#gracePeriodProfitScheduleGridTbl_Id_"+_pageRef).jqGrid("clearGridData", true).trigger("reloadGrid");
		var scheduleLength = scheduleList.length;
		for(var i=0;i<scheduleLength;i++){
			$("#gracePeriodProfitScheduleGridTbl_Id_"+_pageRef).jqGrid('addRowData',i+1,scheduleList[i]);
		}
	}
}

// function islamicCalculator_fillChargesGrid(chargeList){
// $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("clearGridData", true);
// if (chargeList != undefined && chargeList != null) {
// for ( var i = 0; i < chargeList.length; i++)
// {//data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
// $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('addRowData',i +
// 1,chargeList[i]);
// }
// setSumofInsuranceCharges();
// var calculator_type = returnHtmlEltValue('hidden_calculatorType_' +
// _pageRef);
// if (calculator_type == "BILLS_CALCULATOR"){
// islamicCalculator_fillChargesGrid(data.calculatorCO.trsdealchargesVO)
// }

// }

// }

function islamicCalculator_fillChargesGrid(chargeList)
{
	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("clearGridData", true);
	if (chargeList != undefined && chargeList != null)
	{
		for (var i = 0; i < chargeList.length; i++)
		{// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
			$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('addRowData', i + 1,
					chargeList[i]);
		}
		setSumofInsuranceCharges();
	}

}
function fillTendativeScheduleList(scheduleList)
{
	$("#urlRepaymentPlanTentativeScheduleGrid_Id_" + _pageRef).jqGrid(
			"clearGridData", true).trigger("reloadGrid");
	var scheduleLength = scheduleList.length;
	for (var i = 0; i < scheduleLength; i++)
	{
		if (scheduleList[i].VALUE_DATE != null)
		{
			scheduleList[i].VALUE_DATE = convertToDate(
					"urlRepaymentPlanTentativeScheduleGrid_Id_" + _pageRef,
					scheduleList[i].VALUE_DATE);
		}
		$("#urlRepaymentPlanTentativeScheduleGrid_Id_" + _pageRef).jqGrid(
				'addRowData', i + 1, scheduleList[i]);
	}
	var decimalPoints = $("#hidden_islamicCalcDecimalFormat_" + _pageRef).val();
	var grid = $("#urlRepaymentPlanTentativeScheduleGrid_Id_" + _pageRef);
	var amount = grid.jqGrid('getCol', 'AMOUNT', false, 'sum');
	var principalAmount = grid.jqGrid('getCol', 'PRINCIPLE_AMT', false, 'sum');
	var capitalAmount = grid.jqGrid('getCol', 'CAPITAL_AMT', false, 'sum');
	var chargeAmount = grid.jqGrid('getCol', 'CHARGE_AMOUNT', false, 'sum');
	var insuranceAmount = grid.jqGrid('getCol', 'INSURANCE_AMOUNT', false,
			'sum');
	var profitAmount = grid.jqGrid('getCol', 'PROFIT_AMT', false, 'sum');
	var vatAmount = grid.jqGrid('getCol', 'VAT_AMOUNT', false, 'sum');
	// TP#210228; Ramesh; Date 18/08/2014
	var principalChargesBeforeXirr = grid.jqGrid('getCol',
			'CAPITAL_AMT_BEFORE_XIRR', false, 'sum');
	var principalAmtBeforeXirr = grid.jqGrid('getCol',
			'PROFIT_AMT_BEFORE_XIRR', false, 'sum');
	grid.jqGrid('footerData', 'set', {
		AMOUNT : formatToCurrencyDecimal(amount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		PRINCIPLE_AMT : formatToCurrencyDecimal(principalAmount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		CAPITAL_AMT : formatToCurrencyDecimal(capitalAmount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		CHARGE_AMOUNT : formatToCurrencyDecimal(chargeAmount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		INSURANCE_AMOUNT : formatToCurrencyDecimal(insuranceAmount,
				decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		PROFIT_AMT : formatToCurrencyDecimal(profitAmount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		VAT_AMOUNT : formatToCurrencyDecimal(vatAmount, decimalPoints)
	}, false);
	// TP#210228; Ramesh; Date 18/08/2014
	grid.jqGrid('footerData', 'set', {
		CAPITAL_AMT_BEFORE_XIRR : formatToCurrencyDecimal(
				principalChargesBeforeXirr, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		PROFIT_AMT_BEFORE_XIRR : formatToCurrencyDecimal(
				principalAmtBeforeXirr, decimalPoints)
	}, false);
}

/*******************************************************************************
 * Method to put a print icon in the screen
 */
function initializePrintIcon()
{
	if ($("#scheduleGridTbl_Id_print_" + _pageRef).length <= 0)
	{
		$("#scheduleGridTbl_Id_" + _pageRef).jqGrid(
				'navButtonAdd',
				'#scheduleGridTbl_Id_' + _pageRef + '_pager',
				{
					caption : printStatement,
					buttonicon : "ui-icon-print",
					title : printStatement,
					id : "scheduleGridTbl_Id_print_" + _pageRef,
					onClickButton : function()
					{
						printGrid("scheduleGridTbl_Id_" + _pageRef, schedule,
								[ "NO_OF_DAYS" ]);
					}
				});
	}
}
/*******************************************************************************
 * Setting the repayment detailts to form if there is only one record while
 * submitting
 */
function setRepaymentDetailsInForm(data)
{
	if (data != null && data.islamicCalculatorEventMgmtCO != null
			&& data.islamicCalculatorEventMgmtCO.confirmationMessageId != null)
	{
		if (data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVO != null)
		{
			var criteriaLength = data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVO.length;
			var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
					+ _pageRef);
			if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
					|| calculator_type == "BILLS_CALCULATOR")
			{

				$("#plan_maturity_date_" + _pageRef).datepicker("setDate",
						data.islamicCalculatorEventMgmtCO.maturityDate);
			}
			else
			{
				$("#maturityDate_" + _pageRef).datepicker("setDate",
						data.islamicCalculatorEventMgmtCO.maturityDate);
			}

			// TP#193281; Ramesh; Date 25/06/2014
			if (_pageRef == "M01681")
			{
				$("#trsdealVO_MATURITY_DATE_" + _pageRef).datepicker("setDate",
						data.islamicCalculatorEventMgmtCO.maturityDate);
			}
			if (criteriaLength == 1)
			{
				$("#paymPeriodNbr_" + _pageRef)
						.val(
								data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVO[0].PAYM_PERIOD_NBR);
				$("#paymPeriodicity_" + _pageRef)
						.val(
								data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVO[0].PAYM_PERIODICITY);
				$("#paymPeriodPos_" + _pageRef)
						.val(
								data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVO[0].PAYM_PERIOD_POS);
				$("#firstPaymentDate_" + _pageRef).datepicker("setDate",
						data.islamicCalculatorEventMgmtCO.firstPaymentDate);

				setInputValue(
						"noOfPayments_" + _pageRef,
						data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVO[0].NO_OF_PAYMENTS);
			}
		}
	}
}

/*******************************************************************************
 * Method for filling data into schedule list
 *
 * @param {Object}
 *            scheduleList
 */
function fillScheduleList(scheduleList)
{
	$("#scheduleGridTbl_Id_" + _pageRef).jqGrid("clearGridData", true).trigger(
			"reloadGrid");
	var scheduleLength = scheduleList.length;
	for (var i = 0; i < scheduleLength; i++)
	{
		if (scheduleList[i].VALUE_DATE != null)
			scheduleList[i].VALUE_DATE = convertToDate("scheduleGridTbl_Id_"
					+ _pageRef, scheduleList[i].VALUE_DATE);
		$("#scheduleGridTbl_Id_" + _pageRef).jqGrid('addRowData', i + 1,
				scheduleList[i]);
	}
	iisCalculatorn_hideCompoundingDealPeriodRows();
}

function iisCalculatorn_hideCompoundingDealPeriodRows()
{
	if (($("#compoundingDuringTheEntireDealPeriod_" + _pageRef).is(':checked') == false))
	{
		$("#scheduleGridTbl_Id_" + _pageRef).jqGrid('hideCol', 'rn');
		$("#scheduleGridTbl_Id_" + _pageRef).jqGrid('showCol', 'LINE_NBR');
		return;
	}
	var $table = $("#scheduleGridTbl_Id_" + _pageRef);
	var rows = $table.jqGrid('getDataIDs');
	var rowNum = rows.length;
	var lineNo = 0;

	for (i = 0; i < rowNum; i++)
	{
		var myObject = $table.jqGrid('getRowData', rows[i]);
		var amount = myObject["AMOUNT"];
		if (amount <= 0)
		{
			$("#" + rows[i], "#scheduleGridTbl_Id_" + _pageRef).css({
				display : "none"
			});
		}
		else
		{

			lineNo = lineNo + 1;
			// $("#repaumentPlanScheduleGridTbl_Id_" +
			// _pageRef).jqGrid('setCellValue', i, 'rn', "10");

			// $table.jqGrid("setCellValue", i, 'rn',"10" , false);
			// $("#repaumentPlanScheduleGridTbl_Id_" +
			// _pageRef).jqGrid('setCellValue', i, 'TEMP_LINE_NBR', lineNo);
		}

		// $table.jqGrid(rows[i]).hide();

		// $table.jqGrid.

		// $("#"+rows[i]).hide();
	}
	$("#repaumentPlanScheduleGridTbl_Id_" + _pageRef).jqGrid('showCol',
			'LINE_NBR');
	$("#scheduleGridTbl_Id_" + _pageRef).jqGrid('hideCol', 'rn');

}

/**
 * Method for Repayment Criteria
 */
function repaymentCriteria()
{

	var params = {};

	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{

		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_repaymentCriteria",
				type : "post",
				data : params,
				dataType : "json"
			/*
			 * , success: function(data){ if(data["_error"] == null){ } }
			 */
			});
}

/*******************************************************************************
 * Method for caling thr on change event of RepaymentCriteriaPeriodicityPeriod
 */

function populateOnChangeDealChargesGridAmounts(callType)
{

	var rowId = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid("getGridParam",
			'selrow');

	var params = {};

	var $table = $("#dealChargesGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
			selectedRowId, 'PERIODICAL_BASIS', "true");

	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
			selectedRowId, 'PERIODICAL_NUMBER', "true");

	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
			selectedRowId, 'CHARGES_CALCULATION_METHOD', "true");

	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
			selectedRowId, 'PERIODICAL_PERIODICITY', "true");

	$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'PERIODICAL_NUMBER', "1");

	// var criteriaLength =
	// data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVO.length;

	params["iisDealChargesCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();

	params["iisDealChargesCO.cifNo"] = $("#lookuptxt_cifNo_" + _pageRef).val();

	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{

		params["iisDealChargesCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["iisDealChargesCO.maturityDate"] = $("#maturityDate_" + _pageRef)
				.val();
	}

	params["iisDealChargesCO.currency"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["iisDealChargesCO.DownPaymentAmount"] = $.parseNumber($(
			"#downPaymentAmount_" + _pageRef).val(), {
		format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["iisDealChargesCO.trsDealChargesCO.CHARGES_CODE"] = $(
			"#" + rowId + "_CHARGES_CODE_lookuptxt_dealChargesGridTbl_Id_"
					+ _pageRef).val();
	params["iisDealChargesCO.trsDealChargesCO.CR_ACC_CURRENCY"] = $(
			"#" + rowId + "_CR_ACC_CURRENCY").val();
	// TP#259655;Arun.R.Variyath;09/01/2015
	// params["iisDealChargesCO.trsDealChargesCO.CHARGES_AMT_FC"] =
	// $.parseNumber($("#"+rowId+"_CHARGES_AMT_FC").val(),{format
	// :$("#"+rowId+"_CHARGES_AMT_FC").attr("nbFormat"), locale:"us"});
	params["iisDealChargesCO.trsDealChargesCO.CHARGES_AMOUNT"] = $.parseNumber(
			$("#" + rowId + "_CHARGES_AMOUNT").val(), {
				format : $("#" + rowId + "_CHARGES_AMOUNT").attr("nbFormat"),
				locale : "us"
			});
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});

	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["iisDealChargesCO.dealAmount"] = financingAmount;
	params["iisDealChargesCO.valueDate"] = $("#startDate_" + _pageRef).val();
	params["iisDealChargesCO.callType"] = "CC";
	if (callType != undefined && callType != null && callType != '')
		params["iisDealChargesCO.callType"] = callType;
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();

	var includeInPrincipleFlag = $("#dealChargesGridTbl_Id_" + _pageRef)
			.jqGrid('getCell', rowId, 'CHARGE_TYPE')
	if (includeInPrincipleFlag != null
			&& (includeInPrincipleFlag == 'Y' || includeInPrincipleFlag == true))
		params["iisDealChargesCO.trsDealChargesCO.CHARGE_TYPE"] = "Y"
	else
		params["iisDealChargesCO.trsDealChargesCO.CHARGE_TYPE"] = "N"

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeDealChargesGridAmounts",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						if (data.trsDealChargesCO != null
								&& data.trsDealChargesCO != undefined)
						{
							// $("#"+rowId+"_CHARGES_AMOUNT").val($.formatNumberNumeric(data.trsDealChargesCO.CHARGES_AMOUNT,{format:
							// returnNbFormat($("#hidden_islamicCalcDecimalFormat_"+_pageRef).val()),applyRounding:true}));
							// $("#"+rowId+"_CHARGES_AMT_FC").val($.formatNumberNumeric(data.trsDealChargesCO.CHARGES_AMT_FC,{format:
							// returnNbFormat($("#hidden_islamicCalcDecimalFormat_"+_pageRef).val()),applyRounding:true}));
							// $("#"+rowId+"_CHARGES_AMT_CV").val($.formatNumberNumeric(data.trsDealChargesCO.CHARGES_AMT_CV,{format:
							// returnNbFormat($("#hidden_islamicCalcDecimalFormat_"+_pageRef).val()),applyRounding:true}));

							// $("#"+rowId+"_CR_ACC_BRANCH").val(data.trsDealChargesCO.CR_ACC_BRANCH);
							// $("#"+rowId+"_CR_ACC_CURRENCY").val(data.trsDealChargesCO.CR_ACC_CURRENCY);
							// $("#"+rowId+"_CR_ACC_GL").val(data.trsDealChargesCO.CR_ACC_GL);
							// $("#"+rowId+"_CR_ACC_CIF_SUB_NO").val(data.trsDealChargesCO.CR_ACC_CIF_SUB_NO);
							// $("#"+rowId+"_CR_ACC_SL_NO_lookuptxt_dealChargesGridTbl_Id_"+_pageRef).val(data.trsDealChargesCO.CR_ACC_SL_NO);
							$("#dealChargesGridTbl_Id_" + _pageRef)
									.jqGrid(
											'setCellValue',
											rowId,
											'CHARGES_AMOUNT',
											$
													.formatNumberNumeric(
															data.trsDealChargesCO.CHARGES_AMOUNT,
															{
																format : returnNbFormat($(
																		"#hidden_islamicCalcDecimalFormat_"
																				+ _pageRef)
																		.val()),
																applyRounding : true
															}));
							$("#dealChargesGridTbl_Id_" + _pageRef)
									.jqGrid(
											'setCellValue',
											rowId,
											'CHARGES_AMT_FC',
											$
													.formatNumberNumeric(
															data.trsDealChargesCO.CHARGES_AMT_FC,
															{
																format : returnNbFormat($(
																		"#hidden_islamicCalcDecimalFormat_"
																				+ _pageRef)
																		.val()),
																applyRounding : true
															}));
							$("#dealChargesGridTbl_Id_" + _pageRef)
									.jqGrid(
											'setCellValue',
											rowId,
											'CHARGES_AMT_CV',
											$
													.formatNumberNumeric(
															data.trsDealChargesCO.CHARGES_AMT_CV,
															{
																format : returnNbFormat($(
																		"#hidden_islamicCalcDecimalFormat_"
																				+ _pageRef)
																		.val()),
																applyRounding : true
															}));
							if (callType == 'CC')
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellValue', rowId, 'CR_ACC_BRANCH',
										data.trsDealChargesCO.CR_ACC_BRANCH);

							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId, 'CR_ACC_CURRENCY',
									data.trsDealChargesCO.CR_ACC_CURRENCY);
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId, 'CR_ACC_GL',
									data.trsDealChargesCO.CR_ACC_GL);
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId, 'CR_ACC_CIF_SUB_NO',
									data.trsDealChargesCO.CR_ACC_CIF_SUB_NO);
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId, 'CR_ACC_SL_NO',
									data.trsDealChargesCO.CR_ACC_SL_NO);

							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId, 'insuranceAmount',
									data.trsDealChargesCO.insuranceAmount);
							$("#dealChargesGridTbl_Id_" + _pageRef)
									.jqGrid(
											'setCellValue',
											rowId,
											'chargeAmtToInclInPrinciple',
											data.trsDealChargesCO.chargeAmtToInclInPrinciple);
							// TP#234960;roshin ;28/10/2014 start
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId, 'VAT_CODE',
									data.trsDealChargesCO.VAT_CODE);
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId,
									'VAT_BRIEF_NAME_ENG',
									data.trsDealChargesCO.VAT_BRIEF_NAME_ENG);
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId,
									'allowToEditVatCode',
									data.trsDealChargesCO.allowToEditVatCode);

							// TP#250387 ; Hari ; 11/12/2014
							$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
									'setCellValue', rowId, 'CHARGE_TYPE',
									data.trsDealChargesCO.CHARGE_TYPE);

							$("#dealChargesGridTbl_Id_" + _pageRef)
									.jqGrid(
											'setCellValue',
											rowId,
											'TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN',
											data.trsDealChargesCO.TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN);

							// TP#250441 ; Hari ; 11/12/2014
							if (data.trsDealChargesCO.profitOnCharge == "TRUE")
							{
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellValue', rowId,
										'PROFIT_ON_CHARGES', 1);
							}
							else
							{
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellValue', rowId,
										'PROFIT_ON_CHARGES', 0);
							}

							var allowToEditVatCode = data.trsDealChargesCO.allowToEditVatCode;
							if (allowToEditVatCode == "N")
							{
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId, 'VAT_CODE',
										"true");
							}
							else
							{
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId, 'VAT_CODE',
										"false");
							}
							// TP#234960;roshin ;28/10/2014 end

							if (data.trsDealChargesCO.CHARGE_TYPE == "N")
							{
								if (data.trsDealChargesCO.COLLECT_CHARGE_AT_DEAL_YN == "Y")
								{
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid(
													"setCellValue",
													rowId,
													'COLLECT_CHARGE_AT_DEAL_YN',
													"Y", "false");
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid("setCellValue", rowId,
													'CHARGE_AMT_PER_INST_YN',
													"N", "true");
								}
								else if (data.trsDealChargesCO.CHARGE_AMT_PER_INST_YN == "Y")
								{
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid(
													"setCellValue",
													rowId,
													'COLLECT_CHARGE_AT_DEAL_YN',
													"N", "true");
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid("setCellValue", rowId,
													'CHARGE_AMT_PER_INST_YN',
													"Y", "false");
								}
								else
								{
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid(
													"setCellValue",
													rowId,
													'COLLECT_CHARGE_AT_DEAL_YN',
													"N", "false");
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid("setCellValue", rowId,
													'CHARGE_AMT_PER_INST_YN',
													"N", "false");
								}
							}

							var payNetIncentPrincStlmtYn = data.trsDealChargesCO.TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN;
							if (payNetIncentPrincStlmtYn == "Y")
							{
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'CHARGE_TYPE', "true");
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'PROFIT_ON_CHARGES', "true");
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'CREDIT_TO_SD_ACCOUNT_YN', "true");
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'CHARGE_AMT_PER_INST_YN', "true");
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'COLLECT_CHARGE_AT_DEAL_YN', "true");
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'COLLECT_CHARGES_ACCOUNT_TYPE', "true");
							}
							else
							{
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'CHARGE_TYPE', "false");
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'PROFIT_ON_CHARGES', "false");
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'CREDIT_TO_SD_ACCOUNT_YN', "false");
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'CHARGE_AMT_PER_INST_YN', "false");
								$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
										'setCellReadOnly', rowId,
										'COLLECT_CHARGE_AT_DEAL_YN', "false");
								if (data.trsDealChargesCO.COLLECT_CHARGE_AT_DEAL_YN != "Y"
										|| data.trsDealChargesCO.CHARGE_AMT_PER_INST_YN != "Y")
								{
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid(
													'setCellReadOnly',
													rowId,
													'COLLECT_CHARGES_ACCOUNT_TYPE',
													"true");
								}
								else
								{
									$("#dealChargesGridTbl_Id_" + _pageRef)
											.jqGrid(
													'setCellReadOnly',
													rowId,
													'COLLECT_CHARGES_ACCOUNT_TYPE',
													"false");
								}
							}
							
							//976207 CDMI190005 - Takaful Insurance Product
							if(data.trsDealChargesCO.calcOnYerlyOutstndPrincYN=='Y')
							{
								
								$("#dealChargesGridTbl_Id_"+_pageRef).jqGrid("setCellValue", rowId, 'calcOnYerlyOutstndPrincYN', data.trsDealChargesCO.calcOnYerlyOutstndPrincYN, "true");
								$("#dealChargesGridTbl_Id_"+_pageRef).jqGrid("setCellValue", rowId, 'CHARGES_AMOUNT', data.trsDealChargesCO.CHARGES_AMOUNT, "true");	
								
							}
									
							// if($("#chargeAmtToInclInPrinciple_"+_pageRef).is(':checked')
							// == true)
							setSumofInsuranceCharges();
						}
					}
				}
			});

}
/*******************************************************************************
 * Method for onchnage events for floating rate code,annual yield rate , margin
 */
function calculateAnnualFloatingMarginRates()
{

	var resetElements = {};
	resetElements[0] = "margin_" + _pageRef;
	resetElements[1] = "floatingRate_" + _pageRef;
	resetElements[2] = "annualYieldRate_" + _pageRef;
	var prevMargin = $('#margin_' + _pageRef).attr("prevValue");
	var prevFloatingRate = $('#floatingRate_' + _pageRef).attr("prevValue");// TP#258962;roshin;08/01/2014

	var params = {};
	var annualYieldRate = $.parseNumber(
			$("#annualYieldRate_" + _pageRef).val(), {
				format : $("#annualYieldRate_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	var margin = $.parseNumber($("#margin_" + _pageRef).val(), {
		format : $("#margin_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	var floatingRate = $.parseNumber($("#floatingRate_" + _pageRef).val(), {
		format : $("#floatingRate_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.annualYieldRate"] = annualYieldRate;
	params["islamicCalculatorEventMgmtCO.margin"] = margin;
	params["islamicCalculatorEventMgmtCO.floatingRate"] = floatingRate;
	params["islamicCalculatorEventMgmtCO.yieldFlag"] = "FM";
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{

		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	var profitAmount = $.parseNumber($("#profit_" + _pageRef).val(), {
		format : $("#profit_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = $(
			"#profitCalcMethod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.profit"] = profitAmount;
	params["islamicCalculatorEventMgmtCO.yield"] = $(
			"#annualYieldRate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_calculateAnnualFloatingMarginRates",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						if (data.islamicCalculatorEventMgmtCO != null
								&& data.islamicCalculatorEventMgmtCO != undefined)
						{
							// $("#annualYieldRate_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.yield);
							setAnnualYieldRateFromServer(data.islamicCalculatorEventMgmtCO.yield);
							$("#annualFlatRate_" + _pageRef)
									.val(
											data.islamicCalculatorEventMgmtCO.totalYield);
							setElementsPreviousValue(resetElements);// Setting
							// the new
							// value as
							// prev
							// value for
							// margin
							// floatingrate,annualyield
						}
					}
					else
					{
						// TP#251263; Ramesh; Date 21/12/2014
						$("#margin_" + _pageRef).val(
								$.parseNumber(prevMargin, {
									format : $("#margin_" + _pageRef).attr(
											"nbFormat"),
									locale : "us"
								}));
						// Commented below line it is not working
						// resetElementsToPreviousValue(resetElements)//Resetting
						// the values of margin floatingrate,annualyield to the
						// prev values
						$("#floatingRate_" + _pageRef).val(prevFloatingRate);// TP#258962;roshin
						// ;08/01/2014
					}
					applyAdditionalDynamicDisplay(data["additionalScreenParams"]);// APPLYING
					// THE
					// DECIMAL
					// FORMAT
					// IN
					// ALL
					// AMOUNT
					// FIELDS
				}
			});
	setSumofInsuranceCharges();
	// }
	// else{
	//
	// resetElementsToPreviousValue(resetElements)//Resetting the values of
	// margin floatingrate,annualyield to the prev values
	// }
}
/*******************************************************************************
 * Method for the on chnage event of compounding during deal period
 *
 * @param {Object}
 *            yesNo
 */
function onChangeDealPeriodCompounding()
{
	if ($("#compoundingDuringTheEntireDealPeriod_" + _pageRef).is(':checked') == true)
	{
		var params = {};
		if ($("#compoundingDuringTheEntireDealPeriod_" + _pageRef).is(
				':checked') == true)
			params["islamicCalculatorEventMgmtCO.dealPeriodCompounding"] = "Y";
		else
			params["islamicCalculatorEventMgmtCO.dealPeriodCompounding"] = "N";
		params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = $(
				"#profitCalcMethod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.profitDistMethod"] = $(
				"#profitRecognitionMethod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.principalLast"] = "N";
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
		params["islamicCalculatorEventMgmtCO.flexiPaymentYn"] = returnHtmlEltValue('flexiPaymentYN_CheckBox_'
				+ _pageRef);
		// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeDealPeriodCompounding",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{
							hideShowRepaymentNavigator(false);
							$("#lookuptxt_tempCode_" + _pageRef).val("");
							$("#templateDesc_" + _pageRef).val("");
							// TP#244995;Arun.R.Variyath;03/12/2014
							$("#profitCalcMethod_" + _pageRef).attr("disabled",
									true);
							$("#profitRecognitionMethod_" + _pageRef).attr(
									"disabled", true);
							$("#amountPerPayment_" + _pageRef).attr("readonly",
									true);
							$("#lookuptxt_tempCode_" + _pageRef).attr(
									"readonly", true);
							// TP#238822;Arun.R.Variyath;10/11/2014
							$('#repaymentCriteriaDiv_Id_' + _pageRef).hide();

							resetRepaymentAndBalloonDetails();
						}
						else
						{
							if ($(
									"#compoundingDuringTheEntireDealPeriod_"
											+ _pageRef).is(':checked') == true)
							{
								$(
										"#compoundingDuringTheEntireDealPeriod_"
												+ _pageRef).removeAttr(
										'checked');
								// TP#238822;Arun.R.Variyath;10/11/2014
								$('#repaymentCriteriaDiv_Id_' + _pageRef)
										.show();
							}

						}

					}
				});
	}
	else
	{
		hideShowRepaymentNavigator(true);
		// TP#244995;Arun.R.Variyath;03/12/2014

		$("#profitCalcMethod_" + _pageRef).removeAttr("disabled");
		$("#profitRecognitionMethod_" + _pageRef).removeAttr("disabled");
		$("#amountPerPayment_" + _pageRef).removeAttr("readOnly");
		$("#lookuptxt_tempCode_" + _pageRef).removeAttr("readOnly");
		// TP#238822;Arun.R.Variyath;10/11/2014
		$('#repaymentCriteriaDiv_Id_' + _pageRef).show();
	}
}

function setBaloonPaymentSummary()
{
	var grid = $("#balloonPaymentGridTbl_Id_" + _pageRef);
	var totalAmount = grid.jqGrid('getCol', 'balloonAmount', false, 'sum');
	var decimalPoints = $("#hidden_islamicCalcDecimalFormat_" + _pageRef).val();
	var balloonAmount = grid.jqGrid('getCol', 'balloonAmount', false, 'sum');
	grid.jqGrid('footerData', 'set', {
		balloonDate : Total_Amount_key
	}, false);
	// grid.jqGrid('footerData', 'set', {"balloonAmount" :
	// $.formatNumberNumeric(grid.jqGrid('getCol', 'balloonAmount', false,
	// 'sum'), {format: returnNbFormat(decimalPoints)})}, false);
	grid.jqGrid('footerData', 'set', {
		"balloonAmount" : formatToCurrencyDecimal(balloonAmount, decimalPoints)
	}, false);
}

function setScheduleSummary()
{

	var decimalPoints = $("#hidden_islamicCalcDecimalFormat_" + _pageRef).val();
	var grid = $("#scheduleGridTbl_Id_" + _pageRef);
	var amount = grid.jqGrid('getCol', 'AMOUNT', false, 'sum');
	var principalAmount = grid.jqGrid('getCol', 'PRINCIPLE_AMT', false, 'sum');
	var principalAmountbeforexirr = grid.jqGrid('getCol', 'PRINCIPLE_AMT_BEFORE_XIRR', false, 'sum');//714070-BBRUP180640
	var capitalAmount = grid.jqGrid('getCol', 'CAPITAL_AMT', false, 'sum');
	var chargeAmount = grid.jqGrid('getCol', 'CHARGE_AMOUNT', false, 'sum');
	var insuranceAmount = grid.jqGrid('getCol', 'INSURANCE_AMOUNT', false,
			'sum');
	var profitAmount = grid.jqGrid('getCol', 'PROFIT_AMT', false, 'sum');
	var vatAmount = grid.jqGrid('getCol', 'VAT_AMOUNT', false, 'sum');
	// TP#210228; Ramesh; Date 18/08/2014
	var principalChargesBeforeXirr = grid.jqGrid('getCol',
			'CAPITAL_AMT_BEFORE_XIRR', false, 'sum');
	var principalAmtBeforeXirr = grid.jqGrid('getCol',
			'PROFIT_AMT_BEFORE_XIRR', false, 'sum');
	grid.jqGrid('footerData', 'set', {
		AMOUNT : formatToCurrencyDecimal(amount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		PRINCIPLE_AMT : formatToCurrencyDecimal(principalAmount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		PRINCIPLE_AMT_BEFORE_XIRR : formatToCurrencyDecimal(principalAmountbeforexirr, decimalPoints)
	}, false); //714070-BBRUP180640
	grid.jqGrid('footerData', 'set', {
		CAPITAL_AMT : formatToCurrencyDecimal(capitalAmount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		CHARGE_AMOUNT : formatToCurrencyDecimal(chargeAmount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		INSURANCE_AMOUNT : formatToCurrencyDecimal(insuranceAmount,
				decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		PROFIT_AMT : formatToCurrencyDecimal(profitAmount, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		VAT_AMOUNT : formatToCurrencyDecimal(vatAmount, decimalPoints)
	}, false);
	// TP#210228; Ramesh; Date 18/08/2014
	grid.jqGrid('footerData', 'set', {
		CAPITAL_AMT_BEFORE_XIRR : formatToCurrencyDecimal(
				principalChargesBeforeXirr, decimalPoints)
	}, false);
	grid.jqGrid('footerData', 'set', {
		PROFIT_AMT_BEFORE_XIRR : formatToCurrencyDecimal(
				principalAmtBeforeXirr, decimalPoints)
	}, false);
}

function formatToCurrencyDecimal(num, decimal)
{
	// var nbFormat =
	// returnNbFormat($("#hidden_islamicCalcDecimalFormat_"+_pageRef).val());
	var nbFormat = returnNbFormat(decimal);

	return $.formatNumberNumeric(num, {
		format : nbFormat,
		applyRounding : true
	});

	// var p = num.toFixed(decimal).split(".");
	// return p[0].split("").reverse().reduce(function(acc, num, i, orig) {
	// return num + (i && !(i % 3) ? "," : "") + acc;
	// }, "") + "." + p[1];
}

/*******************************************************************************
 * Method for reloading the calculator screen
 */
function resetCalculatorPage()
{
	var params = {};
	params["_pageRef"] = _pageRef;
	params["iv_crud"] = "R";

	// TP#164724; Ramesh; Date 14/07/2014 [Start]
	// TP#204549; Ramesh; Date 21/07/2014 [Added below M0166 condition]
	if ((_pageRef == "M0162") || (_pageRef == "M0166"))
	{

		// $("#islmcCalcMainTabs_" + _pageRef)
		// .parent()
		// .load(
		// $.contextPath
		// +
		// "/path/iis/createdealbutton/CreateDealButtonMain_loadIslamicFinanceCalculator1",
		// params, function() {
		// });
		var url = $.contextPath
				+ "/path/iis/createdealbutton/CreateDealButtonMain_initializeIslamicCalculator";
		_showProgressBar(true);
		$.post(url, params, function(response)
		{
			_showProgressBar(false);
			$("#calculatorContentDiv_id_" + _pageRef).html(response);
		}, "html");

	}
	// TP#164724; Ramesh; Date 14/07/2014 [END]
	else
	{

		$("#islmcCalcMainTabs_" + _pageRef)
				.parent()
				.load(
						$.contextPath
								+ "/path/islamicCalculator/islamicCalculator_loadIslamicCalculator",
						params, function()
						{
						});
	}
}

function resetRepaymentAndBalloonDetails()
{
	$("#repaymentgridTbl_Id_" + _pageRef).jqGrid("clearGridData", true)
			.trigger("reloadGrid");
	$("#balloonPaymentGridTbl_Id_" + _pageRef).jqGrid("clearGridData", true)
			.trigger("reloadGrid");
	$("#baloonPaymentNo_" + _pageRef).val("");
	$('#baloonPercentage_' + _pageRef).val("");
	$('#baloonAmount_' + _pageRef).val("");
	$('#lbl_baloonPercentage_' + _pageRef).hide();
	$('#baloonPercentage_' + _pageRef).hide();
	$('#lbl_baloonAmount_' + _pageRef).hide();
	$('#baloonAmount_' + _pageRef).hide();
}

/*******************************************************************************
 *
 */
function setPeriodicityDetails(paymPeriodicity)
{
	if (paymPeriodicity != undefined && paymPeriodicity != null)
	{
		$("#paymPeriodicity_" + _pageRef).val(paymPeriodicity);
		var paymPeriod = ($("#paymPeriodicity_" + _pageRef).val());
		var paymPeriodPos = ($("#paymPeriodPos_" + _pageRef));
		var paymPeriodAt = ($("#lbl_At_" + _pageRef));
		if (paymPeriod == "M")
		{
			$(paymPeriodPos).show();
			$(paymPeriodAt).show();
		}
		else
		{
			$(paymPeriodPos).hide();
			$(paymPeriodAt).hide();
		}
	}
}
/*******************************************************************************
 * Method for setting annual yield rate from server
 */
function setAnnualYieldRateFromServer(annualYieldRate)
{
	if (annualYieldRate != undefined && annualYieldRate > 0)
		$("#annualYieldRate_" + _pageRef).val(annualYieldRate);
}

/*******************************************************************************
 * Method for setting margin rate from server
 */
function setMarginRateFromServer(margin)
{
	if (margin != undefined && margin > 0)
	{
		$("#margin_" + _pageRef).val(margin);
	}
}

function populateOnChangeRepaymentCriteriaFromDate(t)
{

	var prevValue = getGridFieldPreviousValue(
			"repaymentgridTbl_Id_" + _pageRef, "FROM_DATE");
	var params = {};
	// var row = $(t.target).closest('tr.jqgrow');
	// var rowId = row.attr('id');
	// IE-8 Fix
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	var rowId = repaymentGrid.jqGrid("getGridParam", 'selrow');

	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYMENT_TYPE"] = $(
			"#" + rowId + "_PAYMENT_TYPE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_POS"] = $(
			"#" + rowId + "_PAYM_PERIOD_POS").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIODICITY"] = $(
			"#" + rowId + "_PAYM_PERIODICITY").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE"] = $(
			"#" + rowId + "_FROM_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE"] = $(
			"#" + rowId + "_TO_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT"] = $
			.parseNumber($("#" + rowId + "_CAPITAL_AMT").val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR"] = $(
			"#" + rowId + "_PAYM_PERIOD_NBR").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS"] = $(
			"#" + rowId + "_NO_OF_PAYMENTS").val();
	params["islamicCalculatorEventMgmtCO.sumOfCapitalAmtRepayment"] = getNumber(
			$("#repaymentAmountSum_" + _pageRef), true);// $("#repaymentAmountSum_"+_pageRef).val();
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{

		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();

	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.checkDefaultMaturityDate"] = $(
			"#hidden_checkDefaultMaturityDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
			"#noOfPayments_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	var dealAmount = $.parseNumber($("#financingAmount_" + _pageRef).val(), {
		format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.dealAmount"] = dealAmount
	var downPaymentAmount = $.parseNumber($("#downPaymentAmount_" + _pageRef)
			.val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount
	params["islamicCalculatorEventMgmtCO.confirmationResult"] = "Y";

	var rowIds = $('#repaymentgridTbl_Id_' + _pageRef).jqGrid('getDataIDs');
	var firstRowId = rowIds[0];
	params["islamicCalculatorEventMgmtCO.repaymentCriteriaFirstRowDate"] = $(
			'#repaymentgridTbl_Id_' + _pageRef).jqGrid('getCell', firstRowId,
			'FROM_DATE')

	// Added deal charges as param - based on issue 0092514
	params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeRepaymentCriteriaFromDate",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						// $("#"+rowId+"_CAPITAL_AMT").val(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT);
						$("#" + rowId + "_CAPITAL_AMT")
								.val(
										$
												.formatNumberNumeric(
														data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT,
														{
															format : returnNbFormat($(
																	"#hidden_islamicCalcDecimalFormat_"
																			+ _pageRef)
																	.val()),
															applyRounding : true
														}));
						$("#" + rowId + "_NO_OF_PAYMENTS")
								.val(
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS);
						$("#hidden_checkDefaultMaturityDate_" + _pageRef)
								.val(
										data.islamicCalculatorEventMgmtCO.checkDefaultMaturityDate);
						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						// $("#maturityDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.maturityDate));
						// IE-8 Fix
						if (_pageRef == "M0168"
								|| calculator_type == "AR_RAHANU"
								|| calculator_type == "BILLS_CALCULATOR")
						{

							$("#plan_maturity_date_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						else
						{
							$("#maturityDate_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}

						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_MATURITY_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						setInputValue("gracePeriod_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriod);
						setInputValue(
								"gracePeriodicity_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriodicity);

						// $("#noOfPayments_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS);
						// $("#firstPaymentDate_"+_pageRef).datepicker("setDate",
						// new
						// Date(data.islamicCalculatorEventMgmtCO.firstPaymentDate)
						// );
						// IE-8 Fix
						$("#firstPaymentDate_" + _pageRef)
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.firstPaymentDate);
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
								// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
						}
						setSumofInsuranceCharges();
						resetRepaymentSum();

					}
					else
					{
						$("#" + rowId + "_FROM_DATE").val(prevValue);
					}
				}
			});
}

/*******************************************************************************
 *
 * @param {Object}
 *            gridName
 */
function callSlCodeDependency(gridName)
{
	var gridId;
	var colNames = {};
	var selectedRowId;
	var lookupGridTblId;
	if (gridName == 'repayment')
	{
		gridId = $("#repaymentgridTbl_Id_" + _pageRef);
		selectedRowId = gridId.jqGrid("getGridParam", 'selrow');
		colNames = [ "ACC_BR", "ACC_CY", "ACC_GL", "ACC_CIF", "ACC_SL",
				"ACC_NAME" ];
		lookupGridTblId = "gridtab_" + selectedRowId
				+ "_ACC_SL_repaymentgridTbl_Id_" + _pageRef;
	}
	else if (gridName == 'repaymentCoveringSl')
	{
		gridId = $("#repaymentgridTbl_Id_" + _pageRef);
		selectedRowId = gridId.jqGrid("getGridParam", 'selrow');
		colNames = [ "COVERING_ACC_BR", "COVERING_ACC_CY", "COVERING_ACC_GL",
				"COVERING_ACC_CIF", "COVERING_ACC_SL", "COVERING_ACC_NAME" ];
		lookupGridTblId = "gridtab_" + selectedRowId
				+ "_COVERING_ACC_SL_repaymentgridTbl_Id_" + _pageRef;
	}
	else
	{
		gridId = $("#dealChargesGridTbl_Id_" + _pageRef);
		selectedRowId = gridId.jqGrid("getGridParam", 'selrow');
		colNames = [ "CR_ACC_BRANCH", "CR_ACC_CURRENCY", "CR_ACC_GL",
				"CR_ACC_CIF_SUB_NO", "CR_ACC_SL_NO" ];
		lookupGridTblId = "gridtab_" + selectedRowId
				+ "_CR_ACC_SL_NO_dealChargesGridTbl_Id_" + _pageRef;
	}
	onChangeRepaymentSLCode(gridId, gridName, colNames, selectedRowId,
			lookupGridTblId);
}

function onChangeRepaymentSLCode(dealChargesGrid, gridName, colNames,
		selectedRowId, lookupGridTblId)
{
	var lookupObject = {};
	// Call to take the current row data from popup grid
	var lookupGridRowId = $("#" + lookupGridTblId).jqGrid('getGridParam',
			'selrow');
	lookupObject = $("#" + lookupGridTblId).jqGrid('getRowData',
			lookupGridRowId);

	// TP#235336;Arun.R.Variyath;02/01/2015 [Start]
	var sl = dealChargesGrid.jqGrid('getCell', selectedRowId, colNames[4]);
	var sl2 = lookupObject["amfVO.SL_NO"];
	if (sl != sl2)
	{
		lookupGridRowId = undefined;
	}
	// TP#235336;Arun.R.Variyath;02/01/2015 [End]

	// set the values to fields by taking from the lookupGrid
	if (lookupGridRowId != undefined)
	{
		dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[0],
				lookupObject["amfVO.BRANCH_CODE"]);
		dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[1],
				lookupObject["amfVO.CURRENCY_CODE"]);
		dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[2],
				lookupObject["amfVO.GL_CODE"]);
		dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[3],
				lookupObject["amfVO.CIF_SUB_NO"]);
		dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[4],
				lookupObject["amfVO.SL_NO"]);
	}
	var accData = dealChargesGrid.jqGrid('getAllRows'); // Grid Data
	var br = dealChargesGrid.jqGrid('getCell', selectedRowId, colNames[0]);
	var cy = dealChargesGrid.jqGrid('getCell', selectedRowId, colNames[1]);
	var gl = dealChargesGrid.jqGrid('getCell', selectedRowId, colNames[2]);
	var cif = dealChargesGrid.jqGrid('getCell', selectedRowId, colNames[3]);
	// var sl = dealChargesGrid.jqGrid('getCell', selectedRowId,colNames[4]);
	var accParams = {};
	accParams["account.BRANCH_CODE"] = br;
	accParams["account.CURRENCY_CODE"] = cy;
	accParams["account.GL_CODE"] = gl;
	accParams["account.CIF_SUB_NO"] = cif;
	accParams["account.SL_NO"] = sl;

	// var mySrc = jQuery.contextPath +
	// "/pathdesktop/AccountDependencyAction_dependencyBySLId";
	// TP#235336;Arun.R.Variyath;02/01/2015
	var mySrc = jQuery.contextPath
			+ "/pathdesktop/AccountDependencyAction_dependencyBySLIdWithMessage";
	$.ajax({
		url : mySrc,
		type : "post",
		data : accParams,
		dataType : "json",
		success : function(data)
		{
			manageSlDependencyResults(gridName, dealChargesGrid, selectedRowId,
					data, colNames);
		}
	});
	setSumofInsuranceCharges();
}

function manageSlDependencyResults(gridName, dealChargesGrid, selectedRowId,
		data, colNames)
{
	if (gridName == 'repayment' || gridName == 'repaymentCoveringSl')
	{
		if (typeof data["_error"] != "undefined" && data["_error"] != null)
		{
			// dealChargesGrid.jqGrid('setCellValue', selectedRowId,
			// colNames[0],"");
			// dealChargesGrid.jqGrid('setCellValue', selectedRowId,
			// colNames[1],"");
			// dealChargesGrid.jqGrid('setCellValue', selectedRowId,
			// colNames[2],"");
			// dealChargesGrid.jqGrid('setCellValue', selectedRowId,
			// colNames[3],"");
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[4],
					"");
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[5],
					"");
		}
		else
		{
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[0],
					data.account.BRANCH_CODE);
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[1],
					data.account.CURRENCY_CODE);
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[2],
					data.account.GL_CODE);
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[3],
					data.account.CIF_SUB_NO);
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[4],
					data.account.SL_NO);
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[5],
					data.account.BRIEF_NAME_ENG);
		}
	}
	else
	{
		if (typeof data["_error"] != "undefined" && data["_error"] != null)
		{
			// dealChargesGrid.jqGrid('setCellValue', selectedRowId,
			// colNames[0],"");
			// dealChargesGrid.jqGrid('setCellValue', selectedRowId,
			// colNames[1],"");
			// dealChargesGrid.jqGrid('setCellValue', selectedRowId,
			// colNames[2],"");
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[4],
					"");
		}
		else
		{
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[0],
					data.account.BRANCH_CODE);
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[1],
					data.account.CURRENCY_CODE);
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[2],
					data.account.GL_CODE);
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[3],
					data.account.CIF_SUB_NO);
			dealChargesGrid.jqGrid('setCellValue', selectedRowId, colNames[4],
					data.account.SL_NO);
		}
	}
}
function populateOnChangeRepaymentCriteriaToDate()
{
	var prevValue = getGridFieldPreviousValue(
			"repaymentgridTbl_Id_" + _pageRef, "TO_DATE");
	var params = {};
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	var rowId = repaymentGrid.jqGrid("getGridParam", 'selrow');

	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYMENT_TYPE"] = $(
			"#" + rowId + "_PAYMENT_TYPE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_POS"] = $(
			"#" + rowId + "_PAYM_PERIOD_POS").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIODICITY"] = $(
			"#" + rowId + "_PAYM_PERIODICITY").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.FROM_DATE"] = $(
			"#" + rowId + "_FROM_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.TO_DATE"] = $(
			"#" + rowId + "_TO_DATE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT"] = $
			.parseNumber($("#" + rowId + "_CAPITAL_AMT").val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYM_PERIOD_NBR"] = $(
			"#" + rowId + "_PAYM_PERIOD_NBR").val();
	params["islamicCalculatorEventMgmtCO.sumOfCapitalAmtRepayment"] = getNumber(
			$("#repaymentAmountSum_" + _pageRef), true);// $("#repaymentAmountSum_"+_pageRef).val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS"] = $(
			"#" + rowId + "_NO_OF_PAYMENTS").val();

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_populateOnChangeRepaymentCriteriaToDate",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{

						var decimalPoints = $(
								"#hidden_islamicCalcDecimalFormat_" + _pageRef)
								.val();
						$("#" + rowId + "_CAPITAL_AMT")
								.val(
										$
												.formatNumberNumeric(
														data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT,
														{
															format : returnNbFormat(decimalPoints),
															applyRounding : true
														}));
						$("#" + rowId + "_NO_OF_PAYMENTS")
								.val(
										data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS);
						// $("#noOfPayments_"+_pageRef).val(data.islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS);

						resetRepaymentSum();

					}
					else
					{
						$("#" + rowId + "_TO_DATE").val(prevValue);

					}
				}
			});
}
/*******************************************************************************
 *
 */
function onChangeCapitalAmount()
{
	var params = {};
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	var rowId = repaymentGrid.jqGrid("getGridParam", 'selrow');
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	var capitalAmount = $.parseNumber($("#" + rowId + "_CAPITAL_AMT").val(), {
		format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.CAPITAL_AMT"] = capitalAmount;
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.PAYMENT_TYPE"] = $(
			"#" + rowId + "_PAYMENT_TYPE").val();
	params["islamicCalculatorEventMgmtCO.trsPayplanCriteriaVOObject.NO_OF_PAYMENTS"] = $(
			"#" + rowId + "_NO_OF_PAYMENTS").val();

	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeCapitalAmount",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{
						resetRepaymentSum();
						$("#" + rowId + "_CAPITAL_AMT").val(
								$.formatNumberNumeric($(
										"#" + rowId + "_CAPITAL_AMT").val(), {
									format : returnNbFormat($(
											"#hidden_islamicCalcDecimalFormat_"
													+ _pageRef).val()),
									applyRounding : true
								}));
					}
					else
					{
						$("#" + rowId + "_CAPITAL_AMT").val("");
					}
				}
			});

}
/*******************************************************************************
 * Method for checking less than zero for ON field in repayment criteria
 */
function onChangeOnPayDay()
{
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	var rowId = repaymentGrid.jqGrid("getGridParam", 'selrow');
	var payDay = repaymentGrid.jqGrid('getCell', rowId, 'PAYM_DAY');
	if (payDay != undefined && payDay != "")
	{
		payDay = Number(payDay);
		if (payDay < 0)
		{
			_showErrorMsg(cannotBeLessThanZero, warning_msg_title);
			repaymentGrid
					.jqGrid('setCellValue', rowId, 'PAYM_DAY', "", "false");
		}
	}
}
/*******************************************************************************
 *
 * @param {Object}
 *            gridId
 */
function verifyAndSaveGrid(gridId)
{
	var gridIdLength = gridId.length;
	for (var j = 0; j < gridIdLength; j++)
	{
		var rowIds = gridId[j].jqGrid('getDataIDs');
		var rowIdlength = rowIds.length;
		for (var i = 0; i < rowIdlength; i++)
		{
			if ($("tr#" + rowIds[i]).attr("editable") === "1")
			{
				$(gridId[j]).jqGrid('saveRow', rowIds[i], false, 'clientArray');
				break;
			}
		}
	}
	;
}

function getNumber(componentId, initNullToZero)
{
	if (initNullToZero)
	{
		var value = componentId.val();
		if (value == undefined || value == "")
			value = Number(0);
		else
			value = $.parseNumber(componentId.val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
		return value;
	}
	else
	{
		return $.parseNumber(componentId.val(), {
			format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
	}
}

function printCalculateScreen()
{
   _showProgressBar(false);
   
	// TP#237823; Snitha; 20/11/2014
	var purchaseAmt = $('#purchaseAmount_' + _pageRef).val();
	if (purchaseAmt <= 0.000)
	{
		_showErrorMsg(InvalidTotalAmount, Cannot_Proceed);
		return;
	}

	// printing calculation page
	var printCalcDetailScheduleYN = $(
			"#hidden_printCalcDetailScheduleYN_" + _pageRef).val();
	var printCalcDetailYN = $("#hidden_printCalcDetailYN_" + _pageRef).val();

	if (printCalcDetailYN == 'Y')
	{

		printScreen("islamicCalculatorMaindiv_" + _pageRef);

		if (printCalcDetailScheduleYN == 'Y')
		{
			printGrid("scheduleGridTbl_Id_" + _pageRef);
		}
	}
	else
	{
		
		// printing summary
		var action = $.contextPath
				+ "/path/islamicCalculator/islamicCalculatorEventMgmt_printCalculateScreen";

		var rowIds = $("#scheduleGridTbl_Id_" + _pageRef).jqGrid('getDataIDs');
		var sDate = $("#startDate_" + _pageRef).val();

		var startDate = dateToObjDate(sDate);

		var nextYrDate = new Date(startDate
				.setFullYear(startDate.getFullYear() + 1));

		var firstYrAmount = 0;
		var template_code = $("#lookuptxt_tempCode_" + _pageRef).val();
		var paym_periodicity = $("#paymPeriodicity_" + _pageRef).val();
		var paym_period_nbr = $("#paymPeriodNbr_" + _pageRef).val();
		var calc_first_year_profit_based_pay_every = 0;

		if ($("#islamicCalculatorEventMgmtCO_category_" + _pageRef).val() == 11
				&& (template_code == null || template_code == undefined || template_code == ""))
		{
			if (paym_periodicity = 'M'
					&& (12 % parseFloat(paym_period_nbr)) == 0)
			{
				calc_first_year_profit_based_pay_every = 1;
				paym_period_nbr = 12 / parseFloat(paym_period_nbr);
			}
		}

		for (var i = 0; i < rowIds.length; i++)
		{

			var date = $("#scheduleGridTbl_Id_" + _pageRef).jqGrid('getCell',
					rowIds[i], 'VALUE_DATE');
			var amount = $("#scheduleGridTbl_Id_" + _pageRef).jqGrid('getCell',
					rowIds[i], 'PROFIT_AMT');

			if (calc_first_year_profit_based_pay_every == 1)
			{

				if (i < paym_period_nbr)
				{

					firstYrAmount = parseFloat(firstYrAmount)
							+ parseFloat(amount);
				}
			}
			else
			{

				if ((nextYrDate.getTime() > dateToObjDate(date).getTime()))
				{
					firstYrAmount = parseFloat(firstYrAmount)
							+ parseFloat(amount);
				}
				else
				{
					var prevdate = $("#scheduleGridTbl_Id_" + _pageRef).jqGrid(
							'getCell', rowIds[i - 1], 'VALUE_DATE');

					var diff = nextYrDate - dateToObjDate(prevdate);

					var prediff = dateToObjDate(date) - dateToObjDate(prevdate);

					firstYrAmount = parseFloat(firstYrAmount)
							+ (parseFloat(amount) / parseFloat(diff) * parseFloat(prediff));
					i = rowIds.length;
				}

			}

		}

		var islamicCalcDecimalFormatPrint = $(
				"#hidden_islamicCalcDecimalFormat_" + _pageRef).val();

		var formatt = "##0.0";
		for (var i = 1; i < islamicCalcDecimalFormatPrint; i++)
		{
			formatt = formatt + "0";
		}

		$("#hidden_islamicCalcDecimalFormatPrint_" + _pageRef).val(formatt);

		var lastPayment = $("#scheduleGridTbl_Id_" + _pageRef).jqGrid(
				'getCell', rowIds[rowIds.length - 1], 'AMOUNT');
		$("#islamicCalculatorEventMgmtCO_lastPayment_" + _pageRef).val(
				lastPayment);

		$("#islamicCalculatorEventMgmtCO_firstYrProfit_" + _pageRef).val(
				firstYrAmount);

		var FormData = $("#islamicCalculatorFormMaindiv_" + _pageRef)
				.serializeForm();

		var action = $.contextPath
				+ "/path/islamicCalculator/islamicCalculatorEventMgmt_printCalculateScreen";

		_showProgressBar(true);
		$.ajax({
			url : action,
			type : "post",
			data : FormData,
			success : function(data)
			{

				_showProgressBar(false);
				if (data==undefined || data=="undefined" || data==null || data=='')
				{
					return;
				}
				else
				{
					printBatchAdvice(data.islamicCalculatorEventMgmtCO.reportResponseCOList);					
				}
			}
		});
	}

}

function printScreen(divName)
{
	showhidePrintElements('Y');
	var printContents = document.getElementById(divName).innerHTML;
	var WindowObject = window
			.open("", "",
					"width=950,height=750,top=50,left=50,scrollbars=yes,menubar=yes,resizable=yes");
	WindowObject.document.writeln(printContents);

	WindowObject.document.close();
	WindowObject.print();
	WindowObject.close();
	showhidePrintElements('N');

}

function printCalc()
{
	_showProgressBar(true);
	 
	$("#PrintCalculateScreen_Div_" + _pageRef).printElement({
		printBodyOptions : {
			styleToAdd : ''
		},
		leaveOpen : false,
		printMode : 'popup'
	});
	$("#PrintCalculateScreen_Div_" + _pageRef).dialog("destroy");
	$("#PrintCalculateScreen_Div_" + _pageRef).remove();
	_showProgressBar(false);

}

function investmentDeals_showMultipleYield()
{

	var pageTitle = "Multiple Yield";
	var iv_crud = $("#iv_crud_" + _pageRef).val();
	var prodClass = $('#lookuptxt_productClass_' + _pageRef).val();

	var params = {};
	params["criteria.serialNo"] = 0;
	params["criteria.prodClass"] = prodClass;
	params["iv_crud"] = iv_crud;
	params["_pageRef"] = _pageRef;

	var actionSrc = jQuery.contextPath
			+ "/path/iis/investmentDeals/InvestmentDealsMaint_loadInvestDealMultipleYieldPage";

	dialogOptions = {
		'height' : returnMaxHeight(350),
		'width' : returnMaxWidth(850)
	};
	var invDealMultipleYieldDiv = $('<div id="InvestDealMultipleYield_Div_'
			+ _pageRef + '"></div>');

	invDealMultipleYieldDiv.dialog({
		autoOpen : false,
		modal : true,
		title : pageTitle,
		hide : 'clip',
		beforeClose : function(event, ui)
		{
		},
		close : function(ev, ui)
		{
			investmentdeal_closeMultipleYield(true);
		}
	});
	_showProgressBar(true);
	$("#InvestDealMultipleYield_Div_" + _pageRef).load(
			actionSrc,
			params,
			function()
			{
				_showProgressBar(false);
				$("#InvestDealMultipleYield_Div_" + _pageRef).dialog(
						dialogOptions);
				$("#InvestDealMultipleYield_Div_" + _pageRef).dialog("open");
				$('#InvestDealMultipleYieldGridTbl_Id_' + _pageRef)
						.jqGrid(
								"setGridWidth",
								$("#InvestDealMultipleYield_Div_" + _pageRef)
										.width() - 25);

			});
}
function investmentdeal_closeMultipleYield(confirm)
{
	if (confirm == true)
	{
		$("#InvestDealMultipleYield_Div_" + _pageRef).dialog("destroy");
		$("#InvestDealMultipleYield_Div_" + _pageRef).remove();
	}
}
function corporateCalc_imitSerialNoBeforeDep()
{
	var preValue = $('#lookuptxt_limitSerialNo_' + _pageRef).attr("prevValue");
	setInputValue("preValue_" + _pageRef, preValue);
}

function corporateCalc_onChangeLimitSerialNo()
{
	var params = {};
	var calculator_type = returnHtmlEltValue('hidden_calculatorType_'
			+ _pageRef);

	params["islamicCalculatorEventMgmtCO.limitSerialNo"] = $(
			"#lookuptxt_limitSerialNo_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.startDate"] = $(
			"#startDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
			"#lookuptxt_currencyCode_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	if (_pageRef == "M0168" || calculator_type == "AR_RAHANU"
			|| calculator_type == "BILLS_CALCULATOR")
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#plan_maturity_date_" + _pageRef).val();
	}
	else
	{
		params["islamicCalculatorEventMgmtCO.maturityDate"] = $(
				"#maturityDate_" + _pageRef).val();
	}

	params["islamicCalculatorEventMgmtCO.tempCode"] = $(
			"#lookuptxt_tempCode_" + _pageRef).val();
	// TP#246251; Ramesh; Date 03/12/2014
	params["islamicCalculatorEventMgmtCO.margin"] = $("#margin_" + _pageRef)
			.val();
	params["islamicCalculatorEventMgmtCO.noOfMonths"] = $(
			"#noOfMonths_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.noOfPayments"] = $(
			"#noOfPayments_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriod"] = $(
			"#gracePeriod_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.gracePeriodicity"] = $(
			"#gracePeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.firstPaymentDate"] = $(
			"#firstPaymentDate_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodNbr"] = $(
			"#paymPeriodNbr_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = $(
			"#paymPeriodicity_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.paymPeriodPos"] = $(
			"#paymPeriodPos_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.roundingFactor"] = $(
			"#roundingFactor_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.cifNo"] = $(
			"#lookuptxt_cifNo_" + _pageRef).val();

	params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
			"#downPaymentPercentage_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = $.parseNumber($(
			"#purchaseAmount_" + _pageRef).val(), {
		format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = $.parseNumber($(
			"#downPaymentAmount_" + _pageRef).val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	var financingAmount = $.parseNumber(
			$("#financingAmount_" + _pageRef).val(), {
				format : $("#financingAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.financingAmount"] = financingAmount;
	params["islamicCalculatorEventMgmtCO.yield"] = $.parseNumber($(
			"#annualYieldRate_" + _pageRef).val(), {
		format : $("#annualYieldRate_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});

	// Added deal charges as param - based on issue 0092514
	params["strDealCharges"] = $("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');
	var cifBefore = returnHtmlEltValue('lookuptxt_cifNo_' + _pageRef);

	$
			.ajax({
				url : $.contextPath
						+ "/path/iis/repaymentPlanOthersEventMgmt/RepaymentPlanOthersEventMgmtAction_corporateCalc_onchangeLimitSerialNo",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					if (data["_error"] == null)
					{

						setInputValue("noOfPayments_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.noOfPayments);
						setInputValue(
								"roundingFactor_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.roundingFactor);
						setInputValue("lookuptxt_cifNo_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.cifNo);
						setInputValue("lookuptxt_civilId_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.idNo);
						setInputValue("lookuptxt_productClass_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.productClass);
						setInputValue(
								"productClassName_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.productClassName);
						setInputValue("lookuptxt_currencyCode_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ACC_CURRENCY);
						setInputValue("currencyDesc_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.currencyDesc);
						setInputValue("accBrMI_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ACC_BRANCH);
						setInputValue("accCyMI_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ACC_CURRENCY);
						setInputValue("accGlMI_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ACC_GL_CODE);
						setInputValue("accCifMI_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ACC_CIF_NO);
						setInputValue("accSlMI_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ACC_SL_NO);
						setInputValue(
								"accAddRefMI_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ADDITIONAL_REFERENCE);
						setInputValue("accDescMI_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ACCOUNT_NAME);
						setInputValue(
								"lookuptxt_accAddRefMI_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ADDITIONAL_REFERENCE);
						setInputValue("accDescMI_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.ACCOUNT_NAME);
						setPeriodicityDetails(data.islamicCalculatorEventMgmtCO.paymPeriodicity);
						setInputValue("paymPeriodNbr_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.paymPeriodNbr);
						setInputValue("paymPeriodPos_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.paymPeriodPos);
						setInputValue("gracePeriod_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriod);
						setInputValue(
								"gracePeriodicity_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.gracePeriodicity);
						setInputValue(
								"profitCalcMethod_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.profitCalcMethod);
						setInputValue(
								"profitRecognitionMethod_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.profitDistMethod);
						setInputValue("lookuptxt_tempCode_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.tempCode);
						setInputValue("startDate_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.startDate);
						setInputValue("margin_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.margin);
						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							setInputValue("trsdealVO_DEAL_DATE_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.startDate);
						}
						setInputValue("accrualBasis_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.accrualBasis);
						setInputValue(
								"downPaymentPercentage_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.downPaymentPercentage);
						setInputValue(
								"debtBurdanRatio_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.debtBurdanRatio);
						setInputValue(
								"purchaseAmount_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.purchaseAmount);
						setInputValue(
								"downPaymentPercentage_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.downPaymentPercentage);
						setInputValue(
								"downPaymentAmount_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.downPaymentAmount);
						setInputValue(
								"financingAmount_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.financingAmount);
						// TP#211073; Ramesh; Date 20/08/2014
						if (_pageRef == "M0168"
								|| calculator_type == "AR_RAHANU"
								|| calculator_type == "BILLS_CALCULATOR")
						{

							setInputValue(
									"Plan_Principal_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.financingAmount);
						}
						setInputValue(
								"profitAmount_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.advancePayment);
						setInputValue(
								"annualYieldRate_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.annualYieldRate);
						// TP#246251; Ramesh; Date 03/12/2014
						setInputValue("floatingRate_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.floatingRate);
						// TP#247626;Arun.R.Variyath;12/12/2014
						setInputValue("annualFlatRate_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.totalYield)
						setInputValue("income_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.income);
						setInputValue(
								"hiddenctsmessages_" + _pageRef,
								data.islamicCalculatorEventMgmtCO.confirmMessagesArryList);
						corporatecalc_showctsMessages(data.islamicCalculatorEventMgmtCO.confirmMessagesArryList);
						// The below setting is for IE 9

						$("#startDate_" + _pageRef).datepicker("setDate",
								data.islamicCalculatorEventMgmtCO.startDate);
						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_DEAL_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.startDate);
						}
						if (_pageRef == "M0168"
								|| calculator_type == "AR_RAHANU"
								|| calculator_type == "BILLS_CALCULATOR")
						{

							$("#plan_maturity_date_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						else
						{
							$("#maturityDate_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}

						// TP#193281; Ramesh; Date 25/06/2014
						if (_pageRef == "M01681")
						{
							$("#trsdealVO_MATURITY_DATE_" + _pageRef)
									.datepicker(
											"setDate",
											data.islamicCalculatorEventMgmtCO.maturityDate);
						}
						$("#firstPaymentDate_" + _pageRef)
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.firstPaymentDate);
						$("#hidden_defaultMaturityDate_" + _pageRef)
								.datepicker(
										"setDate",
										data.islamicCalculatorEventMgmtCO.maturityDate);

						$("#dealChargesGridTbl_Id_" + _pageRef).jqGrid(
								"clearGridData", true);
						if (data.islamicCalculatorEventMgmtCO.profitCalcMethod != null
								&& data.islamicCalculatorEventMgmtCO.profitCalcMethod == 'R')
						{
							$("#totalFlatRate_" + _pageRef).attr("readonly",
									true);
							$(
									"#compoundingDuringTheEntireDealPeriod_"
											+ _pageRef).show();
							$(
									"#lbl_compoundingDuringTheEntireDealPeriod_"
											+ _pageRef).show();
							if ($(
									"#compoundingDuringTheEntireDealPeriod_"
											+ _pageRef).is(':checked') == true)
								$(
										"#compoundingDuringTheEntireDealPeriod_"
												+ _pageRef).removeAttr(
										'checked');
						}
						else
							$("#totalFlatRate_" + _pageRef).removeAttr(
									"readOnly");
						if (data.islamicCalculatorEventMgmtCO.trsDealChargesVO != undefined
								&& data.islamicCalculatorEventMgmtCO.trsDealChargesVO != null)
						{
							for (var i = 0; i < data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length; i++)
							{// data.islamicCalculatorEventMgmtCO.trsDealChargesVO.length
								$("#dealChargesGridTbl_Id_" + _pageRef)
										.jqGrid(
												'addRowData',
												i + 1,
												data.islamicCalculatorEventMgmtCO.trsDealChargesVO[i]);
							}
						}
						if (data.islamicCalculatorEventMgmtCO.payResAmt != null
								&& data.islamicCalculatorEventMgmtCO.payResAmt != undefined)
						{
							if (data.islamicCalculatorEventMgmtCO.payResAmt == "D")
								$(
										'input:radio[name=islamicCalculatorEventMgmtCO.payResAmt]:nth(0)')
										.attr('checked', true);
							else if (data.islamicCalculatorEventMgmtCO.payResAmt == "F")
								$(
										'input:radio[name=islamicCalculatorEventMgmtCO.payResAmt]:nth(1)')
										.attr('checked', true);
							else
								$(
										'input:radio[name=islamicCalculatorEventMgmtCO.payResAmt]:nth(2)')
										.attr('checked', true);
						}
						if (data.islamicCalculatorEventMgmtCO.firstPaymentDate == undefined
								|| data.islamicCalculatorEventMgmtCO.firstPaymentDate == null)
						{
							hideShowRepaymentNavigator(false);
							hideShowDealChargesNavigator(false);
						}
						else
						{
							hideShowRepaymentNavigator(true);
							hideShowDealChargesNavigator(true);
						}
						setInputValue("calledByJSTriggerYN_" + _pageRef, "Y");
						// 629296
						var cif =data.islamicCalculatorEventMgmtCO.cifNo;
						/**
						 * Trigger CIF item change only if cif not defined/ defined cif is not limit cif
						 */
						if(cifBefore== undefined || cifBefore ==null || cifBefore =="" ||  cifBefore != cif )
						{
							$("#lookuptxt_cifNo_" + _pageRef).trigger("change");
						}
						setSumofInsuranceCharges();

						// hideShowVatSection(data);
						islamic_onChangeProductClass();
					}
					else
					{

						var preValue = returnHtmlEltValue("preValue_"
								+ _pageRef);
						setInputValue("lookuptxt_limitSerialNo_" + _pageRef,
								preValue);

					}
					// Applying the decimal format in all amount fields
					applyAdditionalDynamicDisplay(data["additionalScreenParams"]);
				}
			});
}
function corporatecalc_showctsMessages(confirmMessagesArryList)
{
	if (confirmMessagesArryList != null)
	{
		for (var i = 0; i < confirmMessagesArryList.length; i++)
		{
			_showErrorMsg(confirmMessagesArryList[i], info_msg_title);
			// _showConfirmMsg(okBtnTrans, title, height, args, closeFn, width,
			// cancelBtnTrans, i)
		}

	}
}

// TP#201244;BejoyKodiyan;14/07/2014
function corporatecalc_resetCorporateCalculatorPage()
{
	var params = {};
	params["_pageRef"] = _pageRef;
	params["iv_crud"] = "R";
	// 624185
	var url = $.contextPath
			+ "/path/iis/iiscalculator/IISCalculatorAction_initializeCorporateCalculator";
	_showProgressBar(true);
	$.post(url, params, function(response)
	{
		_showProgressBar(false);
		$("#calculatorContentDiv_id_" + _pageRef).html(response);
	}, "html");

}

// TP#201244;BejoyKodiyan;14/07/2014
function arRehnuCalculator_clearbtn()
{
	var params = {};
	params["_pageRef"] = _pageRef;
	params["iv_crud"] = "R";
	$("#islmcCalcMainTabs_" + _pageRef)
			.parent()
			.load(
					$.contextPath
							+ "/path/iis/iiscalculator/IISCalculatorAction_loadArRahnAction",
					params, function()
					{
					});

}

function islmCalc_showQuery()
{

	var pageTitle = "Counter Party Limit";
	var cif = $("#lookuptxt_cifNo_" + _pageRef).val();
	if (!cif || cif == "")
		return;

	var params = {};
	params["_pageRef"] = _pageRef;
	params["dashboardCO.cifVO.CIF_NO"] = cif;
	var popupDiv = $("<div id='islmCalcCounterPartyDetails_" + _pageRef + "'/>");
	popupDiv.css("padding", "0");
	var theForm = $("#islamicCalculatorFormMaindiv_" + _pageRef);
	popupDiv.insertAfter(theForm);
	var mySrc = jQuery.contextPath
			+ "/path/globalview/dashboardMain_loadDashboardPage"
	_showProgressBar(true);
	$("#islmCalcCounterPartyDetails_" + _pageRef).load(mySrc, params,
			function()
			{
				_showProgressBar(false);
				$("#islmCalcCounterPartyDetails_" + _pageRef).dialog({
					modal : true,
					title : "Counter Party Details",
					show : 'slide',
					position : 'center',
					autoOpen : false,
					height : returnMaxHeight(600),
					width : returnMaxWidth(1200),
					close : function()
					{
						var theDialog = $(this);
						theDialog.remove();
					}
				});
				$("#islmCalcCounterPartyDetails_" + _pageRef).dialog("open");
			});

}

function onChangeAutoCreateSettlementYN(call)
{
	var repaymentGrid = $("#repaymentgridTbl_Id_" + _pageRef);
	var rowId = repaymentGrid.jqGrid("getGridParam", 'selrow');
	var autoCreateSettlementYN = document.getElementById(rowId
			+ "_AUTO_CREATE_SETTLEMENT_YN");
	var branch = document.getElementById(rowId + "_COVERING_ACC_BR");
	var currency = document.getElementById(rowId + "_COVERING_ACC_CY");
	var accGl = document.getElementById(rowId + "_COVERING_ACC_GL");
	var accCif = document.getElementById(rowId + "_COVERING_ACC_CIF");
	var accSl = document.getElementById(rowId
			+ "_COVERING_ACC_SL_lookuptxt_repaymentgridTbl_Id_" + _pageRef);
	var accName = document.getElementById(rowId + "_COVERING_ACC_NAME");

	if ($(autoCreateSettlementYN).val() != "Y")
	{
		$(branch).val("");
		$(currency).val("");
		$(accGl).val("");
		$(accCif).val("");
		$(accName).val("");
		$(accSl).val("");
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_BR',
				true);
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_CY',
				true);
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_GL',
				true);
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_CIF',
				true);
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_NAME',
				true);
		makeGridLiveSearchReadOnly(rowId, true, "repaymentgridTbl_Id",
				"COVERING_ACC_SL");
	}
	else
	{
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_BR',
				false);
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_CY',
				false);
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_GL',
				false);
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_CIF',
				false);
		$(repaymentGrid).jqGrid('setCellReadOnly', rowId, 'COVERING_ACC_NAME',
				true);
		makeGridLiveSearchReadOnly(rowId, false, "repaymentgridTbl_Id",
				"COVERING_ACC_SL");

	}
}

function makeGridLiveSearchReadOnly(rowId, readOnlyFlag, gridId, columnName)
{
	var lookupText = $(document.getElementById(rowId + "_" + columnName
			+ "_lookuptxt_" + gridId + "_" + _pageRef));
	var componentId = rowId + "_" + columnName + "_lookuptxt_" + gridId + "_"
			+ _pageRef;
	var spanCompId = (componentId.indexOf("lookuptxt_") < 0) ? "spanLookup_"
			+ componentId : componentId.replace("lookuptxt_", "spanLookup_");
	var spanLookup = $(document.getElementById(spanCompId))
	if (readOnlyFlag == "true" || readOnlyFlag == true)
	{
		spanLookup.addClass("disableLiveSearch");
		spanLookup.addClass("disableLiveSearchText");
		spanLookup.find('.ui-icon-search').addClass('ui-state-disabled');
		spanLookup.attr('tabindex', '-1');
		lookupText.attr('readonly', 'readonly');
		lookupText.attr('tabindex', '-1');
	}
	else
	{
		spanLookup.removeClass("disableLiveSearch");
		spanLookup.removeClass("disableLiveSearchText");
		spanLookup.find('.ui-icon-search').removeClass('ui-state-disabled');
		lookupText.removeAttr('readonly');
		lookupText.removeAttr('tabindex');
		spanLookup.attr('tabindex', "0");
	}
}

function projectFinance_calculateTendativeSchedulde()
{
	submitCalculate(true, null, "Y");
}

// TP# 241462 ;Ravikant.Singh;26/11/2014[start]
function beforeDependencyForCifValidationInCalculator()
{
	setInputValue("cifNo_preValue_" + _pageRef,
			returnHtmlEltValue('lookuptxt_cifNo_' + _pageRef));
	setInputValue("cifName_preValue_" + _pageRef, returnHtmlEltValue('cifName_'
			+ _pageRef));

	$('#previousValues_' + _pageRef).val(
			$('#lookuptxt_cifNo_' + _pageRef).attr("prevValue"));
	$('#previousValuesDesc_' + _pageRef).val(
			$('#cifName_' + _pageRef).attr("prevValue"));
	var params = {};
	params["_pageRef"] = _pageRef;
	params["islamicCalculatorEventMgmtCO.cifNo"] = returnHtmlEltValue("lookuptxt_cifNo_"
			+ _pageRef);
	_showProgressBar(true);
	var actionURL = jQuery.contextPath
			+ "/path/islamicCalculator/islamicCalculatorEventMgmt_validateCifBlackListedOrNot";
	$.ajax({
		url : actionURL,
		type : "post",
		dataType : "json",
		data : params,
		success : function(data)
		{
			if (typeof data["_error"] != "undefined" || data["_error"] != null)
			{
				$("#lookuptxt_cifNo_" + _pageRef).trigger("_event.dependency");
				_showProgressBar(false);
			}
			else
			{
				if (data.confirmType == "CHECK_BLACK_LISTED_CIF")
				{
					{
						// var
						// cifNo
						// =
						// data.islamicCalculatorEventMgmtCO.cifNo;
						// setInputValue("lookuptxt_cifNo_"+
						// _pageRef,
						// cifNo);
						_showProgressBar(false);
						return _showConfirmMsg(data["_confirm"], Warning_key,// TP#246324;

						// Libin;
						// 29/12/2014
						// data["_msgTitle"],
						callConfirmationForCIFValidation, {

						}, "Yes", "No");
						_showProgressBar(false);
						return;
					}
				}
				_showProgressBar(false);

			}
		}
	});
	return true;

}

function callConfirmationForCIFValidation(confirm)
{
	if (confirm == true)
	{
		$("#lookuptxt_cifNo_" + _pageRef).trigger("_event.dependency");
		_showProgressBar(false);
		return true;
	}
	else
	{
		$("#lookuptxt_cifNo_" + _pageRef).val(null);
		$("#cifName_" + _pageRef).val(null);
		$("#lookuptxt_civilId_" + _pageRef).val(null);
		_showProgressBar(false);
		return;
	}
}

function islamicCalculator_onChangeContractPrice()
{
	if ($("#islamicCalculatorFormMaindiv_" + _pageRef).valid())
	{
		var params = {};

		params["islamicCalculatorEventMgmtCO.contractPrice"] = $.parseNumber($(
				"#contractPrice_" + _pageRef).val(), {
			format : $("#contractPrice_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		// $("#contractPrice_"+_pageRef).val();
		params["islamicCalculatorEventMgmtCO.discountCalMethod"] = $(
				"#discountCalMethod_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.discountPerc"] = $.parseNumber($(
				"#discountPerc_" + _pageRef).val(), {
			format : $("#discountPerc_" + _pageRef).attr("nbFormat"),
			locale : "us"
		});
		// $("#discountPerc_"+_pageRef).val();

		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.cifNo"] = $(
				"#lookuptxt_cifNo_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.currencyCode"] = $(
				"#lookuptxt_currencyCode_" + _pageRef).val();

		params["islamicCalculatorEventMgmtCO.annualYieldRate"] = $(
				"#annualYieldRate_" + _pageRef).val();

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeContractPrice",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] == null)
						{

							setInputValue(
									"financingAmount_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.purchaseAmount)
							setInputValue(
									"purchaseAmount_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.purchaseAmount)
							setInputValue(
									"downPaymentPercentage_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.downPaymentPercentage)
							setInputValue(
									"downPaymentAmount" + _pageRef,
									data.islamicCalculatorEventMgmtCO.downPaymentAmount)
							setInputValue(
									"profitCollected_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.advancePayment)
							setInputValue(
									"annualYieldRate_" + _pageRef,
									data.islamicCalculatorEventMgmtCO.annualYieldRate)
							setInputValue("totalFlatRate" + _pageRef, 0)

							applyAdditionalDynamicDisplay(data["additionalScreenParams"]);
						}
					}
				});
	}
}

// TP# 241462 ;Ravikant.Singh;26/11/2014[end]

function afterDependencyForCifValidationInCalculator()
{
	var params = {};

	params["_pageRef"] = _pageRef;
	params["islamicCalculatorEventMgmtCO.cifNo"] = returnHtmlEltValue("lookuptxt_cifNo_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.startDate"] = returnHtmlEltValue("startDate_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.productClass"] = returnHtmlEltValue("lookuptxt_productClass_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.currencyCode"] = returnHtmlEltValue("lookuptxt_currencyCode_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.globalConfirmationFrom"] = "JS";

	params["islamicCalculatorEventMgmtCO.limitSerialNo"] = returnHtmlEltValue("lookuptxt_limitSerialNo_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.calledByJSTriggerYN"] = returnHtmlEltValue("calledByJSTriggerYN_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.ACC_BRANCH"] = returnHtmlEltValue("accBrMI_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.ACC_CURRENCY"] = returnHtmlEltValue("accCyMI_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.ACC_GL_CODE"] = returnHtmlEltValue("accGlMI_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.ACC_CIF_NO"] = returnHtmlEltValue("accCifMI_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.ACC_SL_NO"] = returnHtmlEltValue("accSlMI_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.ADDITIONAL_REFERENCE"] = returnHtmlEltValue("lookuptxt_accAddRefMI_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.ACCOUNT_NAME"] = returnHtmlEltValue("accDescMI_"
			+ _pageRef);
	_showProgressBar(true);
	var actionURL = jQuery.contextPath
			+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeCifCivilId";
	$.ajax({

		url : actionURL,
		type : "post",
		dataType : "json",
		data : params,
		success : function(data)
		{
			if (data["_error"] == null)
			{
				_showProgressBar(false);
				if (typeof data["_confirm"] != "undefined"
						|| data["_confirm"] != null)
				{

					if (data.confirmType == "CHECK_CIF_EXISTING_DEALS")
					{

						_showConfirmMsg(data["_confirm"], data["_msgTitle"],
								"islamicCalculator_showQueryForExistingDeals",
								{
									activeDealCount : data.activeDealCount
								}, "Yes", "No");

						_showProgressBar(false);

						return;
					}

				}
				calculator_applyCIFDepValues(data);

			}
			else
			{
				setInputValue("lookuptxt_cifNo_" + _pageRef, $(
						"#previousValues_" + _pageRef).val());
				setInputValue("cifName_" + _pageRef, $(
						"#previousValuesDesc_" + _pageRef).val());
				_showProgressBar(false);
			}
		}
	});

}

function calculator_applyCIFDepValues(data)
{

	setInputValue("calledByJSTriggerYN_" + _pageRef, "N");
	setInputValue("lookuptxt_civilId_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.idNo);
	setInputValue("lookuptxt_cifNo_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.cifNo);
	setInputValue("cifName_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.cifName);
	setInputValue("approvedSalary_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.approvedSalary);
	setInputValue("income_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.income);
	setInputValue("debtBurdanRatio_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.debtBurdanRatio);
	setInputValue("lookuptxt_limitSerialNo_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.limitSerialNo);
	/** Resetting fields */
	setInputValue("accBrMI_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.ACC_BRANCH);
	setInputValue("accCyMI_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.ACC_CURRENCY);
	setInputValue("accGlMI_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.ACC_GL_CODE);
	setInputValue("accCifMI_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.ACC_CIF_NO);
	setInputValue("accSlMI_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.ACC_SL_NO);
	setInputValue("lookuptxt_accAddRefMI_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.ADDITIONAL_REFERENCE);
	setInputValue("accDescMI_" + _pageRef,
			data.islamicCalculatorEventMgmtCO.ACCOUNT_NAME);
	// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
	if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
	{
		$("#dealType_Div_" + _pageRef).dialog("destroy");
		$("#dealType_Div_" + _pageRef).remove();
	}
}
function islamicCalculator_showQueryForExistingDeals(confirm, arg)
{
	setInputValue("calledByJSTriggerYN_" + _pageRef, "N");
	if (confirm)
	{
		// islamicCalculator_showQuery(arg.activeDealCount);
		var cif = $("#lookuptxt_cifNo_" + _pageRef).val();

		if (!cif || cif == "")
		{
			return;
		}

		islamicCalculator_openQueryPopup(cif);
	}
	var activeDealCount = arg.activeDealCount;
	if (activeDealCount > 0)
	{
		setInputValue("lookuptxt_cifNo_" + _pageRef, $(
				"#previousValues_" + _pageRef).val());
		setInputValue("cifName_" + _pageRef, $(
				"#previousValuesDesc_" + _pageRef).val());
	}
}

function islamicCalculator_openQueryPopup(cif)
{

	var params = {};
	params["_pageRef"] = _pageRef;
	params["dashboardCO.cifVO.CIF_NO"] = cif;
	var popupDiv = $("<div id='islamicCalculatorCounterPartyDetails_"
			+ _pageRef + "'/>");
	popupDiv.css("padding", "0");
	var theForm = $("#islamicCalculatorFormMaindiv_" + _pageRef);
	popupDiv.insertAfter(theForm);
	var mySrc = jQuery.contextPath
			+ "/path/globalview/dashboardMain_loadDashboardPage";

	dialogOptions = {
		autoOpen : false,
		height : returnMaxHeight(600),
		width : returnMaxWidth(1200),
		show : 'slide',
		position : 'center',
		modal : true,
		title :  "Counter Party Details",
		close : function()
		{
			var theDialog = $(this);
			theDialog.remove();
		}
	};
	_showProgressBar(true);
	$.ajax({

		url : mySrc,
		type : "post",
		data : params,
		success : function(data)
		{

			$("#islamicCalculatorCounterPartyDetails_" + _pageRef).html(data);
			$("#islamicCalculatorCounterPartyDetails_" + _pageRef).dialog(
					dialogOptions);
			$("#islamicCalculatorCounterPartyDetails_" + _pageRef).dialog(
					"open");
			_showProgressBar(false);
		}
	});

}

function returnGridDataForCalc(gridId)
{
	var gridAllRecords = ""
	var reccount = $("#" + gridId + "_" + _pageRef).jqGrid("getGridParam",
			"reccount")
	if (reccount != undefined && reccount != "undefined" && reccount != 0)
	{
		gridAllRecords = $("#" + gridId + "_" + _pageRef).jqGrid('getAllRows');

	}
	return gridAllRecords;
}

// #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [START]
function onChangeProfitRecognitionMethod()
{
	var profitRecMethod = $("#profitRecognitionMethod_" + _pageRef).val();
	if (profitRecMethod == "I" || profitRecMethod == "L")
	{
		var params = {};
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.profitRecognitionMethod"] = profitRecMethod;

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeProfitRecognitionMethod",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] != null)
						{
							$("#profitRecognitionMethod_" + _pageRef).val("R");
						}
					}
				});
	}
}
function onChangeAccrualBasis()
{
	var accrualBasis = $("#accrualBasis_" + _pageRef).val();
	if (accrualBasis == "2" || accrualBasis == "3")
	{
		var params = {};
		params["islamicCalculatorEventMgmtCO.productClass"] = $(
				"#lookuptxt_productClass_" + _pageRef).val();
		params["islamicCalculatorEventMgmtCO.accrualBasis"] = accrualBasis;

		$
				.ajax({
					url : $.contextPath
							+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeAccrualBasis",
					type : "post",
					data : params,
					dataType : "json",
					success : function(data)
					{
						if (data["_error"] != null)
						{
							$("#accrualBasis_" + _pageRef).val("1");
						}
					}
				});
	}
}
// #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [End]

function billsCalculator_clearbtn()
{
	var params = {};
	params["_pageRef"] = _pageRef;
	params["iv_crud"] = "R";
	// $("#islmcCalcMainTabs_" + _pageRef).parent().load
	// TP#512395 Mathew on 21Apr2017
	$("#calculatorContentDiv_id_" + _pageRef)
			.parent()
			.load(
					$.contextPath
							+ "/path/iis/iiscalculator/IISCalculatorAction_loadBillCalculatorAction",
					params, function()
					{
					});

}

// TAR TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule
// Charges START
var Settlement_Charges_key = "Settlement Charges"
var settlementChargesURL = "/path/iis/settlementcharges";
var Remove_record_key = "Do you want to remove the record?";
var cannot_delete_this_charges = "You cannot Delete this charge";
var Cannot_Proceed_key = "Cannot Proceed";

function onSettlementChargesGridLoadComplete()
{
	var settlementChargesGrid = $("#settlementChargesGridTbl_Id_" + _pageRef);
	settlementChargesGrid.jqGrid('navButtonAdd',
			'#settlementChargesGridTbl_Id_' + _pageRef + '_pager', {
				id : "settlementcharges_addCharges_" + _pageRef,
				caption : " ",
				buttonicon : "ui-icon-plus",
				title : grid_addLabel,
				onClickButton : function()
				{
					settlementcharges_addCharges()
				}
			});
	settlementChargesGrid.jqGrid('navButtonAdd',
			'#settlementChargesGridTbl_Id_' + _pageRef + '_pager', {
				id : "settlementcharges_deleteCharges_" + _pageRef,
				caption : " ",
				buttonicon : "ui-icon-trash",
				title : grid_delLabel,
				onClickButton : function()
				{

					settlementcharges_deleteCharges();
				}
			});
}

function settlementcharges_setReadonly()
{
	var gridId = $("#settlementChargesGridTbl_Id_" + _pageRef);
	var selectedRowId = gridId.jqGrid('getGridParam', 'selrow');
	var myObject = gridId.jqGrid('getRowData', selectedRowId);
	var alloEdit = myObject["ALLOW_EDIT"];
	var defaultFromProductClass = myObject["DEFAULT_FROM_PRODUCT_CLASS_YN"];
	if (defaultFromProductClass == "Y" && alloEdit == "N")
	{
		$("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'CHARGE_CODE', "true");

		$("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'CHARGE_AMOUNT', "true");
		$("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid('setCellReadOnly',
				selectedRowId, 'INCLUDE_IN_INSTALLMENT_YN', "true");
	}

}

function settlementcharges_addCharges()
{

	var settlementChargesGrid = $("#settlementChargesGridTbl_Id_" + _pageRef);

	if (settlementChargesGrid.jqGrid("getGridParam", "reccount") != 0)
	{
		var index = settlementChargesGrid.jqGrid("getGridParam", "reccount")
		var rowId = jQuery(
				"#settlementChargesGridTbl_Id_" + _pageRef + " tr:eq(" + index
						+ ")").attr("id");
		var code = jQuery("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid(
				'getCell', rowId, 'CHARGE_CODE')
		if (code == null || code == "" || code == "undefined")
		{
			return;
		}
	}
	$("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid('addInlineRow', {});
	var rowIds = $('#settlementChargesGridTbl_Id_' + _pageRef).jqGrid(
			'getDataIDs');
	var rowId = rowIds[rowIds.length - 1];
	$("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid('setCellValue', rowId,
			'DEFAULT_FROM_PRODUCT_CLASS_YN', "N", "false");

	$("#investmentDealsFormId_" + _pageRef).data("changeTrack", true);
}

function settlementcharges_deleteCharges()
{
	var gridId = $("#settlementChargesGridTbl_Id_" + _pageRef);
	var rowId = $("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid(
			'getGridParam', 'selrow');
	if (rowId == null || rowId == undefined)
	{
		return;
	}
	var myObject = gridId.jqGrid('getRowData', rowId);
	var alloEdit = myObject["ALLOW_EDIT"];
	var defaultFromProductClass = myObject["DEFAULT_FROM_PRODUCT_CLASS_YN"];
	if (defaultFromProductClass == "Y" && alloEdit == "N")
	{
		_showErrorMsg("You cannot Delete this charge", Cannot_Proceed_key);
		return;
	}
	_showConfirmMsg(
			(typeof Confirm_Delete_Process_key != undefined) ? Remove_record_key
					: "Do you want to remove the record?",
			confirm_msg_title,
			function(yesNo)
			{
				if (yesNo)
				{

					var myObject = $("#settlementChargesGridTbl_Id_" + _pageRef)
							.jqGrid('getRowData', rowId);
					var decimalPoints = $
							.parseNumber(myObject["settlementChargesFormat"]);
					if (decimalPoints == 0)
					{
						decimalPoints = 2;
					}
					$("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid(
							'deleteGridRow', rowId);
					$("#investmentDealsFormId_" + _pageRef).data("changeTrack",
							true);
					// var scoreSum = $("#settlementChargesGridTbl_Id_" +
					// _pageRef).jqGrid('getCol', 'CHARGE_AMOUNT', false,
					// 'sum');
					// $('#total_charges_' +
					// _pageRef).val(format_currencyDecimal(scoreSum,
					// decimalPoints));

				}
			}, "yesNo");

}

// TAR TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule
// Charges END
/*******************************************************************************
 * Method for validating flexi payment BB160136; Saheer.Naduthodi; 20/04/2017
 */
function validateFlexiPayment(confirm, data)
{
	_showProgressBar(true);
	var params = {};
	params["islamicCalculatorEventMgmtCO.flexiPaymentYn"] = returnHtmlEltValue('flexiPaymentYN_CheckBox_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.productClass"] = returnHtmlEltValue('lookuptxt_productClass_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = returnHtmlEltValue('profitCalcMethod_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = returnHtmlEltValue('paymPeriodicity_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.noOfPayments"] = returnHtmlEltValue('noOfPayments_'
			+ _pageRef);
	var gridId = "repaymentgridTbl_Id_" + _pageRef;
	var rowCount = getGridRowCount(gridId);
	params["islamicCalculatorEventMgmtCO.repaymentCriteriaRowCount"] = rowCount;
	params["islamicCalculatorEventMgmtCO.noOfBaloonPayments"] = returnHtmlEltValue('baloonPaymentNo_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.tempCode"] = returnHtmlEltValue('lookuptxt_tempCode_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.dealPeriodCompounding"] = returnHtmlEltValue('compoundingDuringTheEntireDealPeriod_'
			+ _pageRef);
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeFlexiPaymentCheckBox",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					_showProgressBar(false);
					if (data["_error"] != "undefined" && data["_error"] != null)
					{
						setInputValue("flexiPaymentYN_CheckBox_" + _pageRef,
								"N");
					}
					else
					{
						submitCalculate(true, data,"N");
					}
				}
			});
}
/**
 * @modification BB160136
 * @author Saheer.Naduthodi
 * @date 20/04/2017
 */
function islamicCalc_onChangeFlexiPaymentCheckBox(confirmChoice, maturityDate)
{
	_showProgressBar(true);
	var params = {};
	params["islamicCalculatorEventMgmtCO.flexiPaymentYn"] = returnHtmlEltValue('flexiPaymentYN_CheckBox_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.productClass"] = returnHtmlEltValue('lookuptxt_productClass_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.profitCalcMethod"] = returnHtmlEltValue('profitCalcMethod_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.paymPeriodicity"] = returnHtmlEltValue('paymPeriodicity_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.noOfPayments"] = returnHtmlEltValue('noOfPayments_'
			+ _pageRef);
	var gridId = "repaymentgridTbl_Id_" + _pageRef;
	var rowCount = getGridRowCount(gridId);
	params["islamicCalculatorEventMgmtCO.repaymentCriteriaRowCount"] = rowCount;
	params["islamicCalculatorEventMgmtCO.noOfBaloonPayments"] = returnHtmlEltValue('baloonPaymentNo_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.tempCode"] = returnHtmlEltValue('lookuptxt_tempCode_'
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.dealPeriodCompounding"] = returnHtmlEltValue('compoundingDuringTheEntireDealPeriod_'
			+ _pageRef);
	$
			.ajax({
				url : $.contextPath
						+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeFlexiPaymentCheckBox",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data)
				{
					applyAdditionalDynamicDisplay(data.additionalScreenParams);
					setInputValue("flexi_month_" + _pageRef, "");
					_showProgressBar(false);
					if (data["_error"] != "undefined" && data["_error"] != null)
					{
						setInputValue("flexiPaymentYN_CheckBox_" + _pageRef,
								"N");
					}
				}
			});
}

// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function validateDealType()
{
	var iv_crud = $("#iv_crud_" + _pageRef).val();
	var type = returnHtmlEltValue("dealType_" + _pageRef);
	var params = {};
	params["iv_crud"] = iv_crud;
	params["_pageRef"] = _pageRef;
	params["islamicCalculatorEventMgmtCO.dealType"] = type;
	params["islamicCalculatorEventMgmtCO.cifNo"] = returnHtmlEltValue("lookuptxt_cifNo_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.productClass"] = returnHtmlEltValue("lookuptxt_productClass_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.currencyCode"] = returnHtmlEltValue("lookuptxt_currencyCode_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.financingAmount"] = returnHtmlEltValue("financingAmount_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.startDate"] = returnHtmlEltValue("startDate_"
			+ _pageRef);
	if (type == 'P')
	{
		return;
	}
	var actionSrc = jQuery.contextPath
			+ "/path/iis/iiscalculator/IISCalculatorAction_validateDealType";
	$.ajax({
		url : actionSrc,
		type : "post",
		dataType : "json",
		data : params,
		success : function(data)
		{
			if (data["_error"] == null)
			{
				showDealTypeWindow();
			}
			else
			{
				return;
			}
		}
	});
}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function showDealTypeWindow()
{
	var iv_crud = $("#iv_crud_" + _pageRef).val();
	var type = returnHtmlEltValue("dealType_" + _pageRef);
	var params = {};
	params["iv_crud"] = iv_crud;
	params["_pageRef"] = _pageRef;
	params["islamicCalculatorEventMgmtCO.dealType"] = type;
	params["islamicCalculatorEventMgmtCO.cifNo"] = returnHtmlEltValue("lookuptxt_cifNo_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.productClass"] = returnHtmlEltValue("lookuptxt_productClass_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.currencyCode"] = returnHtmlEltValue("lookuptxt_currencyCode_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.newDealCYDesc"] = returnHtmlEltValue("currencyDesc_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.financingAmount"] = returnHtmlEltValue("financingAmount_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.startDate"] = returnHtmlEltValue("startDate_"
			+ _pageRef);
	params["calculatorSC.cifNo"] = returnHtmlEltValue("lookuptxt_cifNo_"
			+ _pageRef);
	params["calculatorSC.currencyCode"] = returnHtmlEltValue("lookuptxt_currencyCode_"
			+ _pageRef);
	var title;
	var actionSrc = jQuery.contextPath
			+ "/path/iis/iiscalculator/IISCalculatorAction_loadDealTypeWindow";
	var dealTypeDiv = $('<div id="dealType_Div_' + _pageRef + '"></div>');
	var maxHeight;
	var maxWidth;
	if (type == 'T')
	{
		title = "Top-Up(BTU)"
		maxHeight = returnMaxHeight(520)
		maxWidth = returnMaxWidth(850)
	}
	else
	{
		title = "BuyOut(B2B)"
		maxHeight = returnMaxHeight(620)
		maxWidth = returnMaxWidth(1000)
	}
	var dialogOptions = {
		'height' : maxHeight,
		'width' : maxWidth,
		autoOpen : false,
		modal : true,
		title : title,
		hide : 'clip',
		dialogClass : "noclose",
		beforeClose : function(event, ui)
		{
		}
	};
	_showProgressBar(true);
	if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
	{
		$("#dealType_Div_" + _pageRef).dialog(dialogOptions);
		$("#dealType_Div_" + _pageRef).dialog("open");
		_showProgressBar(false);
	}
	else
	{
		_showProgressBar(false);
		$.ajax({
			url : actionSrc,
			type : "post",
			data : params,
			success : function(data)
			{
				_showProgressBar(false);
				if (typeof data["_error"] != "undefined"
						&& data["_error"] != null)
				{
					_showProgressBar(false);
					_showErrorMsg(data._error);
					return;
				}
				else
				{
					dealTypeDiv.dialog(dialogOptions);
					dealTypeDiv.html(data);
					dealTypeDiv.dialog("open");
				}
			}
		});
	}

}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function closeTopUpDealTypePopUp()
{

	var topUpGridData = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');
	setInputValue("topUpGridData_" + _pageRef, topUpGridData);
	setInputValue("topup_cy_hidden_" + _pageRef, returnHtmlEltValue("topup_cy_"
			+ _pageRef));
	setInputValue("topup_deal_amount_hidden_" + _pageRef,
			returnHtmlEltValue("topup_deal_amount_" + _pageRef));
	setInputValue("advance_payment_value_date_hidden_" + _pageRef,
			returnHtmlEltValue("advance_payment_value_date_" + _pageRef));

	var formId = $('#auditTrxNbr_' + _pageRef).parent().attr("id");
	$("#dealType_Div_" + _pageRef).dialog("destroy").appendTo("#" + formId);

}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function closeBuyOutDealTypePopUp()
{
	var formId = $('#auditTrxNbr_' + _pageRef).parent().attr("id");
	$("#dealType_Div_" + _pageRef).dialog("destroy").appendTo("#" + formId);

}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function tradeTopUpPenaltyBtn(cellValue, options, rowObject)
{
	return "<a class='fg-button ui-state-default  ui-corner-all fg-button-icon-left'  "
			+ " href='javascript:topUp_onPenaltyClicked("
			+ "\""
			+ options.rowId
			+ "\""
			+ ");'>"
			+ "<span class='ui-icon ui-icon-newwin'/>"
			+ "<span>Penalty</span>"
			+ "</a>"

}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function onChangeTopUpDealSelYN(e)
{
	var topUpGridData = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef).jqGrid(
			'getAllRows');
	var gridId = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef);
	var selectedRowId = gridId.jqGrid('getGridParam', 'selrow');
	var myObject = gridId.jqGrid('getRowData', selectedRowId);

	if (myObject['topUpDealSelYN'] == 'Y'
			&& (_pageRef == 'M0162' || _pageRef == 'M0166'))
	{
		gridId.jqGrid('setCellReadOnly', selectedRowId,
				'trsTopUpDealDetVO.REIMBURSE_PROFIT_PERC', "false");
		gridId.jqGrid('setCellReadOnly', selectedRowId,
				'trsTopUpDealDetVO.REIMBURSE_PROFIT_AMOUNT', "false");
	}

	var params = {};
	params["islamicCalculatorEventMgmtCO.trsTopUpDealVO.TOP_UP_DEAL_AMOUNT"] = returnHtmlEltValue("topup_deal_amount_"
			+ _pageRef);
	params["islamicCalculatorEventMgmtCO.topUpGridData"] = topUpGridData;
	params["islamicCalculatorEventMgmtCO.trsTopUpDealDetVO.CROSS_CY_OS_AMOUNT"] = myObject["trsTopUpDealDetVO.CROSS_CY_OS_AMOUNT"];
	params["islamicCalculatorEventMgmtCO.trsTopUpDealDetVO.DEAL_BRANCH"] = myObject["trsTopUpDealDetVO.DEAL_BRANCH"];
	params["islamicCalculatorEventMgmtCO.trsTopUpDealDetVO.DEAL_NO"] = myObject["trsTopUpDealDetVO.DEAL_NO"];
	params["islamicCalculatorEventMgmtCO.trsTopUpDealDetVO.CROSS_CY_OS_AMOUNT"] = myObject["trsTopUpDealDetVO.CROSS_CY_OS_AMOUNT"];
	params["islamicCalculatorEventMgmtCO.topUpDealSelYN"] = myObject["topUpDealSelYN"];

	var actionSrc = jQuery.contextPath
			+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeTopUpDealSelYN";
	$.ajax({
		url : actionSrc,
		type : "post",
		dataType : "json",
		data : params,
		success : function(data)
		{
			if (data["_error"] == null)
			{
				$("#tradeTopUpDetailGridTbl_Id_" + _pageRef).jqGrid(
						'setCellValue', selectedRowId, 'outStandingTopUpCy',
						data.islamicCalculatorEventMgmtCO.outStandingTopUpCy,
						"false");
				setInputValue("net_credit_to_customer_" + _pageRef,
						data.islamicCalculatorEventMgmtCO.netCreditToCustomer);

			}
			else
			{
				$("#tradeTopUpDetailGridTbl_Id_" + _pageRef).jqGrid(
						'setCellValue', selectedRowId, 'topUpDealSelYN', 'N');
			}
		}
	});
}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function onChangeDealType()
{
	if ($.trim($("#dealType_Div_" + _pageRef).html()).length > 0)
	{
		$("#dealType_Div_" + _pageRef).dialog("destroy");
		$("#dealType_Div_" + _pageRef).remove();
	}
}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function setBuyOutAccountLookup(fieldName)
{
	var selectedRowId = $("#gridtab_" + fieldName + "_sl_" + _pageRef).jqGrid(
			'getGridParam', 'selrow');
	var myObject = $("#gridtab_" + fieldName + "_sl_" + _pageRef).jqGrid(
			'getRowData', selectedRowId);
	setInputValue(fieldName + "_br_" + _pageRef, myObject["amfVO.BRANCH_CODE"]);
	setInputValue(fieldName + "_cy_" + _pageRef,
			myObject["amfVO.CURRENCY_CODE"]);
	setInputValue(fieldName + "_gl_" + _pageRef, myObject["amfVO.GL_CODE"]);
	setInputValue(fieldName + "_cif_" + _pageRef, myObject["amfVO.CIF_SUB_NO"]);
	setInputValue("lookuptxt_" + fieldName + "_sl_" + _pageRef,
			myObject["amfVO.SL_NO"]);
	setInputValue(fieldName + "_name_desc_" + _pageRef,
			myObject["amfVO.BRIEF_NAME_ENG"]);
	setInputValue(fieldName + "_addRef_" + _pageRef,
			myObject["amfVO.ADDITIONAL_REFERENCE"]);
}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function onEditTradeTopUpDetailGridTblRow()
{
	var gridId = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef);
	var selectedRowId = gridId.jqGrid('getGridParam', 'selrow');
	var myObject = gridId.jqGrid('getRowData', selectedRowId);
	if (_pageRef == 'T021MT')
	{
		gridId.jqGrid('setCellReadOnly', selectedRowId,
				'trsTopUpDealDetVO.REIMBURSE_PROFIT_PERC', "true");
		gridId.jqGrid('setCellReadOnly', selectedRowId,
				'trsTopUpDealDetVO.REIMBURSE_PROFIT_AMOUNT', "true");
		gridId.jqGrid('setCellReadOnly', selectedRowId, 'topUpDealSelYN',
				"true");
	}
	if (myObject['topUpDealSelYN'] == 'N'
			&& (_pageRef == 'M0162' || _pageRef == 'M0166'))
	{
		gridId.jqGrid('setCellReadOnly', selectedRowId,
				'trsTopUpDealDetVO.REIMBURSE_PROFIT_PERC', "true");
		gridId.jqGrid('setCellReadOnly', selectedRowId,
				'trsTopUpDealDetVO.REIMBURSE_PROFIT_AMOUNT', "true");
	}

}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function applyTopUpDetailGridFooterValues()
{
	// $("#tradeTopUpDetailGridTbl_Id_" +
	// _pageRef).jqGrid('resetSelection').jqGrid('setSelection', 1);
	$("#tradeTopUpDetailGridTbl_Id_" + _pageRef).jqGrid('footerData', 'set', {
		"trsTopUpDealDetVO.CROSS_CY_EXCH_RATE" : (Total_key)
	}, false);
	var total = getVendorPaymentAllocationDetailsTotalAmount();
	$("#tradeTopUpDetailGridTbl_Id_" + _pageRef).jqGrid('footerData', 'set', {
		"trsTopUpDealDetVO.CROSS_CY_OS_AMOUNT" : (total)
	}, true);
	var topUpDealAmount = returnHtmlEltValue("topup_deal_amount_" + _pageRef)
	var netAmount = topUpDealAmount - total;
	setInputValue("net_credit_to_customer_" + _pageRef, netAmount);
}
// BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
function getVendorPaymentAllocationDetailsTotalAmount()
{

	var tableData = $("#tradeTopUpDetailGridTbl_Id_" + _pageRef).jqGrid(
			'getRowData');
	var amount = 0;
	if (tableData.length > 0)
	{
		$
				.each(
						tableData,
						function(index, allocationRowData)
						{
							var chkSelect = allocationRowData["topUpDealSelYN"];
							if (chkSelect == "Y")
							{
								amount = amount
										+ eval(allocationRowData["trsTopUpDealDetVO.CROSS_CY_OS_AMOUNT"]);
							}
						});
	}
	return amount;
}
function showBuyOutSwiftTypeWindow()
{
	var swiftType = returnHtmlEltValue("SWIFT_TYPE_" + _pageRef);
	if (swiftType == null || swiftType == '')
	{
		_showErrorMsg("Please select Swift Type..", warning_msg_title);
		return; 
	}
	var pageTitle = Swift_Details_key;
	var iv_crud = $("#iv_crud_" + _pageRef).val();
	var params = {};
	params["iv_crud"] = iv_crud;
	params["_pageRef"] = _pageRef;
	params["islamicCalculatorEventMgmtCO.tradeDealNo"]=returnHtmlEltValue('tradeDealNo_' + _pageRef); 
	var actionSrc = jQuery.contextPath
			+ "/path/iis/iiscalculator/IISCalculatorAction_showBuyOutSwiftTypeWindow";

	dialogOptions = {
		'height' : returnMaxHeight(450),
		'width' : returnMaxWidth(900),
		autoOpen : false,
		modal : true,
		title : pageTitle,
		hide : 'clip',
		dialogClass : "noclose",
		close : function(ev, ui)
		{
			//$("#swiftDetailsDiv_" + _pageRef).dialog("destroy");
			//$("#swiftDetailsDiv_" + _pageRef).remove();
			var formId = $('#auditTrxNbr_' + _pageRef).parent().attr("id");
			$("#swiftDetailsDiv_" + _pageRef).dialog("destroy").appendTo("#" + formId);			
		}
	};




	var popupButtons = {};
	
	popupButtons["Ok"] = {
			text : "OK",
			id : "swiftDetailsOkBtn_" + _pageRef,
			click : function()
			{
				var formId = $('#auditTrxNbr_' + _pageRef).parent().attr("id");
				$("#swiftDetailsDiv_" + _pageRef).dialog("destroy").appendTo("#" + formId);	
			}
		}
	
	if($.trim($("#swiftDetailsDiv_" + _pageRef)
			.html()).length > 0)
	{
		//var swiftDetailsDiv = $('<div id="swiftDetailsDiv_' + _pageRef + '"></div>');
		$("#swiftDetailsDiv_" + _pageRef).dialog(dialogOptions);
		$("#swiftDetailsDiv_" + _pageRef).dialog('option', 'buttons', popupButtons);
		$("#swiftDetailsDiv_" + _pageRef).dialog("open");
	}
	else
	{

		_showProgressBar(true);
		var swiftDetailsDiv = $('<div id="swiftDetailsDiv_' + _pageRef + '"></div>');
		swiftDetailsDiv.dialog(dialogOptions);
		swiftDetailsDiv.load(actionSrc, params, function()
				{
					// applyDisplayProperties(swiftType);

					_showProgressBar(false);
					
					swiftDetailsDiv.dialog('option', 'buttons', popupButtons);
					swiftDetailsDiv.dialog("open");
				});
	}
}

function showhidePrintElements(show)
{
	if (show == 'Y')
	{
		var eltId = 'paymPeriodicity_' + _pageRef;
		var $sel = document.getElementById(eltId);
		var eltValue = $sel.options[$sel.selectedIndex].label;
		setInputValue("paymPeriodicityForPrint_" + _pageRef, eltValue);
		$("#paymPeriodicityForPrint_" + _pageRef).attr("value", eltValue);
		$("#paymPeriodicity_" + _pageRef).css("display", "none");
		$("#paymPeriodicityForPrint_" + _pageRef).css("display", "block");

		eltId = 'paymPeriodPos_' + _pageRef;
		$sel = document.getElementById(eltId);
		eltValue = $sel.options[$sel.selectedIndex].label;
		setInputValue("paymPeriodPosForPrint_" + _pageRef, eltValue);
		$("#paymPeriodPosForPrint_" + _pageRef).attr("value", eltValue);
		$("#paymPeriodPos_" + _pageRef).css("display", "none");
		$("#paymPeriodPosForPrint_" + _pageRef).css("display", "block");

		eltId = 'gracePeriodicity_' + _pageRef;
		$sel = document.getElementById(eltId);
		eltValue = $sel.options[$sel.selectedIndex].label;
		setInputValue("gracePeriodicityForPrint_" + _pageRef, eltValue);
		$("#gracePeriodicityForPrint_" + _pageRef).attr("value", eltValue);
		$("#gracePeriodicity_" + _pageRef).css("display", "none");
		$("#gracePeriodicityForPrint_" + _pageRef).css("display", "block");

		eltId = 'flexi_month_' + _pageRef;
		$sel = document.getElementById(eltId);
		eltValue = $sel.options[$sel.selectedIndex].label;
		setInputValue("flexi_monthForPrint_" + _pageRef, eltValue);
		$("#flexi_monthForPrint_" + _pageRef).attr("value", eltValue);
		$("#flexi_month_" + _pageRef).css("display", "none");
		$("#flexi_monthForPrint_" + _pageRef).css("display", "block");

		eltId = 'roundingFactor_' + _pageRef;
		$sel = document.getElementById(eltId);
		eltValue = $sel.options[$sel.selectedIndex].label;
		setInputValue("roundingFactorForPrint_" + _pageRef, eltValue);
		$("#roundingFactorForPrint_" + _pageRef).attr("value", eltValue);
		$("#roundingFactor_" + _pageRef).css("display", "none");
		$("#roundingFactorForPrint_" + _pageRef).css("display", "block");

	}
	else
	{
		$("#paymPeriodPos_" + _pageRef).css("display", "block");
		$("#paymPeriodPosForPrint_" + _pageRef).css("display", "none");
		$("#gracePeriodicity_" + _pageRef).css("display", "block");
		$("#gracePeriodicityForPrint_" + _pageRef).css("display", "none");
		$("#paymPeriodicity_" + _pageRef).css("display", "block");
		$("#paymPeriodicityForPrint_" + _pageRef).css("display", "none");
		$("#flexi_month_" + _pageRef).css("display", "block");
		$("#flexi_monthForPrint_" + _pageRef).css("display", "none");
		$("#roundingFactor_" + _pageRef).css("display", "block");
		$("#roundingFactorForPrint_" + _pageRef).css("display", "none");
	}

}

function calculator_beforeDepCurrencyCode()
{
	setInputValue("preValue_" + _pageRef, $(
			'#lookuptxt_currencyCode_' + _pageRef).attr("prevValue"));
	setInputValue("preValueDesc_" + _pageRef, $(
			'#currencyDesc_' + _pageRef).attr("prevValue"));
}

function onChangeIborRatePeriodicity()
{	
	var floatRateCode=		returnHtmlEltValue('lookuptxt_floatingRateCode_' + _pageRef);
	 if(floatRateCode !=null && floatRateCode !=undefined && parseInt(floatRateCode)>0){
	      $("#lookuptxt_floatingRateCode_" + _pageRef).trigger("change");
	 }
}

function onChangeCorporateIborRatePeriodicityType()
{	
	var floatRateCode=		returnHtmlEltValue('lookuptxt_floatingRateCode_' + _pageRef);
	 if(floatRateCode !=null && floatRateCode !=undefined && parseInt(floatRateCode)>0){
	      $("#lookuptxt_floatingRateCode_" + _pageRef).trigger("change");
	 }
}


function islamicCalculator_printScheduleFromTempTable()
{	
	var repaymentPlanScheduleAllRows = returnGridData("scheduleGridTbl_Id_"	+ _pageRef);
	var params = {};

	params["repaymentPlanScheduleAllRows"] 				= repaymentPlanScheduleAllRows;
		
	params["repaymentPlanGridCO.cifNo"] 				= returnHtmlEltValue("lookuptxt_cifNo_" + _pageRef);
	params["repaymentPlanGridCO.trspayplanVO.CURRENCY"] = returnHtmlEltValue("lookuptxt_currencyCode_" + _pageRef);
	params["repaymentPlanGridCO.trspayplanVO.PROFIT_DIST_METHOD"] = returnHtmlEltValue("profitRecognitionMethod_" + _pageRef);
			
	var url =  jQuery.contextPath + "/path/iis/repaymentplan/repaymentplan_printScheduleFromTempTable"; 
	
	_showProgressBar(true);
	$
			.ajax({
				url : url,
				type : "post",
				dataType : "json",
				data : params,
				success : function(data) {

					if (typeof data["_error"] == "undefined"
							|| data["_error"] == null) {
						printBatchAdvice(data.repaymentPlanGridCO.reportResponseCOList);
					}
					_showProgressBar(false);
				}
			});
}

//EWBI160081; Saheer.Naduthodi; 29/06/2016 [START] 
function calc_settlChargesInstalmentLink(cellValue, options, rowObject){
 return '<a href ="#" onclick= "javascript:calc_settleChargeInstPopup();">' + currencyFmatter(cellValue, options, rowObject) + '</a>';
}
function calc_settleChargeInstPopup(){
	calc_loadPopupGridData("Y");
}

function calc_settlChargesNotInstalmentLink(cellValue, options, rowObject){
 return '<a href ="#" onclick= "javascript:calc_settleChargeNotInstPopup();">' + currencyFmatter(cellValue, options, rowObject) + '</a>';
}
function calc_settleChargeNotInstPopup(){
	calc_loadPopupGridData("N");
}

function calc_loadPopupGridData(type){

	var actionSrc = jQuery.contextPath + "/path/iis/repaymentplan/repaymentplan_loadSettleChargeDetPopup";
	var params = {};
	var dealNo = $('#trx_nbr_hd_' + _pageRef).val()
	if(dealNo==null ||dealNo==undefined() || dealNo==""){
		var settlementChargeGridData = $("#settlementChargesGridTbl_Id_" + _pageRef).jqGrid('getAllRows');
		params["dealSettlementChargesAllRows"] =  settlementChargeGridData;
		params["repaymentPlanSC.calculatorYN"] = "Y";
	}
	params["repaymentPlanSC.dealNo"] =  dealNo;
	params["repaymentPlanSC.includeInInstallment"] =  type;
	_showProgressBar(true);
	$
		.ajax( {
			url : actionSrc,
			type : "post",
			dataType : "json",
			data : params,
			success : function(data) {
				if (typeof data["_error"] == "undefined"
						|| data["_error"] == null) {
					
							var settlementChargesPopupDiv = $("#settlementChargesPopup_Div_" + _pageRef);
							var dialogOptions = {
								'width' : returnMaxWidth(375),
								hide : 'clip'
							};
							settlementChargesPopupDiv.dialog( {
									autoOpen : false,
									modal : true,
									title : 'settlement_charge_key',	
									close : function(ev, ui) {				
										$(this).dialog("destroy").appendTo($("#islamicCalculatorFormMaindiv_"+_pageRef))								
									},
									 
								});
							var grid = $("#repaymentSettleChargePopupGrid_" + _pageRef);
							grid.jqGrid("clearGridData", true);
							if(data.settledChargePopupList==undefined || data.settledChargePopupList== null || data.settledChargePopupList ==""){
								_showProgressBar(false);	
							}
							else{							
						
								for(var i = 0; i < data.settledChargePopupList.length; i++)
								{
										grid.jqGrid('addRowData', i + 1, data.settledChargePopupList[i]);
								}				
							
	 							var chargeAmountTotal = grid.jqGrid('getCol', 'chargeAmount', false, 'sum');
								var vatAmountTotal = grid.jqGrid('getCol', 'vatAmount', false, 'sum');
								var cyDecimal =3;
								$(grid).jqGrid('footerData', 'set', {
										"chargeAmount" : calc_formatToCurrencyDecimal(chargeAmountTotal, parseInt(cyDecimal)),
										"vatAmount": calc_formatToCurrencyDecimal(vatAmountTotal, parseInt(cyDecimal))
										}, false);
								
							}
							settlementChargesPopupDiv.dialog(dialogOptions);
							settlementChargesPopupDiv.dialog("open");
							_showProgressBar(false);			
					
						}else{
								_showProgressBar(false);
						}
				}
		}); 	
}
// EWBI160081; Saheer.Naduthodi; 29/06/2016 [END]

function calc_formatToCurrencyDecimal(num, decimal) {

	if(num<=0){
		return num;
	}
	var nbFormat = returnNbFormat(decimal);
	return $.formatNumberNumeric(num, {
		format : nbFormat,
		applyRounding : true
	});
}// EWBI160081; Saheer.Naduthodi; 01/07/2016 [END]

//TP#1022246 BAJI200012 Fawas.kuruvakkottil 10/07/2020 <Start>
function onChangeDownPaymentToVendorPercentage()
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
			"#downPaymentPercentage_" + _pageRef).val();
	var downPaymentAmount = $.parseNumber($(
			"#downPaymentAmount_" + _pageRef).val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
	var purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef).val(),
			{
				format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
	params["islamicCalculatorEventMgmtCO.downPaymentToVendorPerc"] = returnHtmlEltValue("downPaymentToVendorPercentage_" + _pageRef);
	
	$
	.ajax({
		url : $.contextPath
				+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeDownPaymentToVendorPercentage",
		type : "post",
		data : params,
		dataType : "json",
		success : function(data)
		{
			if (data["_error"] == null)
			{
				setInputValue("downPaymentToVendor_"	+ _pageRef, data.islamicCalculatorEventMgmtCO.downPaymentToVendor);
				setInputValue("totalDownPayment_"	+ _pageRef, data.islamicCalculatorEventMgmtCO.totalDownPayment);
				setInputValue("totalDownPaymentPercentage_"	+ _pageRef, data.islamicCalculatorEventMgmtCO.totalDownPaymentPerc);
				setInputValue("financingAmount_"	+ _pageRef, data.islamicCalculatorEventMgmtCO.financingAmount);
			}
		}
		});
}

function onChangeDownPaymentToVendor()
{
	var params = {};
	params["islamicCalculatorEventMgmtCO.productClass"] = $(
			"#lookuptxt_productClass_" + _pageRef).val();
	params["islamicCalculatorEventMgmtCO.downPaymentPercentage"] = $(
			"#downPaymentPercentage_" + _pageRef).val();
	var downPaymentAmount = $.parseNumber($(
			"#downPaymentAmount_" + _pageRef).val(), {
		format : $("#downPaymentAmount_" + _pageRef).attr("nbFormat"),
		locale : "us"
	});
	params["islamicCalculatorEventMgmtCO.downPaymentAmount"] = downPaymentAmount;
	var purchaseAmount = $.parseNumber($("#purchaseAmount_" + _pageRef).val(),
			{
				format : $("#purchaseAmount_" + _pageRef).attr("nbFormat"),
				locale : "us"
			});
	params["islamicCalculatorEventMgmtCO.purchaseAmount"] = purchaseAmount;
	params["islamicCalculatorEventMgmtCO.downPaymentToVendor"] = returnHtmlEltValue("downPaymentToVendor_" + _pageRef);
	
	$
	.ajax({
		url : $.contextPath
				+ "/path/islamicCalculator/islamicCalculatorEventMgmt_onChangeDownPaymentToVendor",
		type : "post",
		data : params,
		dataType : "json",
		success : function(data)
		{
			if (data["_error"] == null)
			{
				setInputValue("downPaymentToVendorPercentage_"	+ _pageRef, data.islamicCalculatorEventMgmtCO.downPaymentToVendorPerc);
				setInputValue("totalDownPayment_"	+ _pageRef, data.islamicCalculatorEventMgmtCO.totalDownPayment);
				setInputValue("totalDownPaymentPercentage_"	+ _pageRef, data.islamicCalculatorEventMgmtCO.totalDownPaymentPerc);
				setInputValue("financingAmount_"	+ _pageRef, data.islamicCalculatorEventMgmtCO.financingAmount);
			}
		}
		});
}
//TP#1022246 BAJI200012 Fawas.kuruvakkottil 10/07/2020 <END>