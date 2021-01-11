function onOkMemo()
{
		var $table = $("#memoGridTrxTbl_Id");
		var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
		if (selectedRowId == null) {
		_showErrorMsg(msg_noRecordSelectedLabel,info_msg_title);	
		 return;
		}
		var myObject = $table.jqGrid('getRowData', selectedRowId);
		var amount   = myObject["ctsmemoDETVO.AMOUNT"];
		var trxNo	 = myObject["ctsmemoDETVO.TRX_NO"];
		var cifNo	 = myObject["ctsmemoDETVO.CIF_NO"];
		 memoTrxCy =  myObject["ctsmemoDETVO.CURRENCY"]; 
	    callDependency( "lookuptxt_facility_app_ref_"+_pageRef+":trxMgntCO.ctstrsVO.FACILITY_APPLICATION_REF"
	    				+",amount_"+_pageRef+":trxMgntCO.ctstrsVO.AMOUNT"
						,jQuery.contextPath+"/path/trxMgnt/TrxMgntDependencies_dependencyTrxMemoOnOK"
							 	,"trxMgntCO.ctsmemoDETVO.AMOUNT:"+amount
							 	+",trxMgntCO.ctsmemoDETVO.CURRENCY:memoTrxCy"
								 +",trxMgntCO.ctsmemoDETVO.TRX_NO:"+trxNo
								+",trxMgntCO.ctsmemoDETVO.CIF_NO:"+cifNo
								+",trxMgntCO.ctstrsVO.TRS_CY:lookuptxt_trs_cy_"+_pageRef
								+",trxMgntCO.ctstrsVO.TRX_TYPE:lookuptxt_trx_type_"+_pageRef
								+",trxMgntCO.ctstrsVO.TRSFR_METHOD:trsfr_method_"+_pageRef
								+",trxMgntCO.ctstrsVO.TRS_DATE:TRS_DATE_"+_pageRef
								+",trxMgntCO.ctstrxtypeVO.CR_DR_FOREX:cr_dr_forex_"+_pageRef 
								+",trxMgntCO.ctstrsVO.TO_TRS_AC_BR:to_trs_ac_br_"+_pageRef
						        +",trxMgntCO.ctstrsVO.TO_TRS_AC_CY:to_trs_ac_cy_"+_pageRef
						        +",trxMgntCO.to_acc_cy_desc:to_acc_cy_desc_"+_pageRef
						        +",trxMgntCO.ctstrsVO.TO_TRS_AC_GL:to_trs_ac_gl_"+_pageRef							
						        +",trxMgntCO.ctstrsVO.TO_TRS_AC_CIF:to_trs_ac_cif_"+_pageRef
								+",trxMgntCO.ctstrsVO.TRS_AC_BR:trs_ac_br_"+_pageRef
						        +",trxMgntCO.ctstrsVO.TRS_AC_CY:trs_ac_cy_"+_pageRef
						        +",trxMgntCO.ctstrsVO.TRS_AC_GL:trs_ac_gl_"+_pageRef
						        +",trxMgntCO.ctstrsVO.TRS_AC_CIF:trs_ac_cif_"+_pageRef
						        +",trxMgntCO.ctstrsVO.TRS_AC_SL:lookuptxt_trs_ac_sl_"+_pageRef
						        +",trxMgntCO.ctstrsVO.CASH_DEDUCT_IND:cash_deduct_ind_"+_pageRef
						        +",trxMgntCO.ctstrsVO.MULT_DIV_IND:mult_div_ind_"+_pageRef
						        +",trxMgntCO.ctstrsVO.TRS_AC_AMOUNT:trs_ac_amount_"+_pageRef
						        +",trxMgntCO.ctstrsVO.EXCHANGE_RATE:exchange_rate_"+_pageRef
						        +",trxMgntCO.ctstrsVO.REMITTANCE_FR_NUM:remittance_fr_num_"+_pageRef
						        +",trxMgntCO.ctstrsVO.REMITTANCE_TO_NUM:remittance_to_num_"+_pageRef
						        +",trxMgntCO.ctstrsVO.CARD_NO:CARD_NO_"+_pageRef
						        +",trxMgntCO.ctstrsVO.LINKTOOTHER_TRXNO:lookuptxt_linkToAnother_trxNo_"+_pageRef
						        +",trxMgntCO.ctstrsVO.CHARGE:charge_"+_pageRef
						        +",trxMgntCO.ctstrsVO.REMITT_CY:remitt_cy_"+_pageRef
						        +",trxMgntCO.t_instr_avail_qty_ht:t_instr_avail_qty_ht_"+_pageRef
					            +",trxMgntCO.t_instr_avail_qty_vault:t_instr_avail_qty_vault_"+_pageRef
					            +",trxMgntCO.t_total_amount:t_total_amount_"+_pageRef
					             +",trxMgntCO.t_total_ac_amount:t_total_ac_amount_"+_pageRef
					            +",trxMgntCO.compute_2:compute_2_"+_pageRef 
								 
							,"lookuptxt_facility_app_ref_"+_pageRef
							,"");		 
	  
  $("#__overlayClose").trigger("click");
}

function onCancelMemo()
{
   $("#__overlayClose").trigger("click");
}