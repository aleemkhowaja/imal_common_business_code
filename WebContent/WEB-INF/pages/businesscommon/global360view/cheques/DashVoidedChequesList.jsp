<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

    <!-- <ps:hidden id="cifNo_${_pageRef}"  name="cif_no"/> -->
    <ps:set name="cifNo_${_pageRef}" value="cif_no"/>
			<ps:url id="urlVoidedChequesGrid_${_pageRef}" 
			        namespace="/path/globalview" escapeAmp="false"
				    action="dashVoidedChequesListAction?_pageRef=${_pageRef}">
			   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
			   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
			</ps:url>

		    <psjg:grid id="voidedChequesListGridTbl_Id_${_pageRef}" 
					caption="%{getText('voided_cheques_key')}"
			        altRows="true"
			    	dataType="json" 
					filter="true"
			    	gridModel="gridModel" 
			    	href="%{urlVoidedChequesGrid_${_pageRef}}"
			        navigator="true" 
			        navigatorAdd="false"
			        navigatorDelete="false"
			        navigatorEdit="false"
			        navigatorRefresh="false"
			        navigatorSearch="true" 
			        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
			    	pager="true"
			    	rowNum="10" 
			    	rowList="5,10,15,20"
			        shrinkToFit="false"
			        sortable="true"
			        viewrecords="true">
			    <psjg:gridColumn id="decimal_points"  		index="decimal_points"  	 colType="number" name="decimal_points"     title=""		     hidden="true" />
			    <psjg:gridColumn id="COMP_CODE"		  		index="COMP_CODE"		  	 colType="number" name="ctstrsVO.COMP_CODE"  			 title="Hidden compCode"						hidden="true" editable="false" sortable="true" search="true" />
		    	<psjg:gridColumn id="TRS_TYPE"		 	    index="TRS_TYPE"		     colType="text"   name="ctstrsVO.TRS_TYPE"	 			 title="Hidden TRS_TYPE"			            editable="false" sortable="true" search="true" hidden="true"/>
		    	<psjg:gridColumn id="CB_IND"		  		index="CB_IND"		  	     colType="text"   name="ctstrsVO.CB_IND"	 			 title="Hidden CB_IND"							editable="false" sortable="true" search="true" hidden="true"/>
		    	<psjg:gridColumn id="trxType"		  		index="trxType"		  	     colType="number" name="ctstrsVO.TRX_TYPE"	 			 title="Hidden trxType"							editable="false" sortable="true" search="true" hidden="true"/>
				<psjg:gridColumn id="branch_code"     		index="branch_code"     	 colType="number" name="branch_code"      	 		     title="%{getText('Branch_code_key')}"      	editable="false" sortable="true" search="true" />
				<psjg:gridColumn id="trx_no"          		index="trx_no"          	 colType="number" name="trx_no" 	       	 			 title="%{getText('Trx_No_key')}"	          	editable="false" sortable="true" search="true" formatter="dashboard_voidedChequesTrxBtn"/>
				<psjg:gridColumn id="trx_type"       	 	index="trx_type"        	 colType="text"   name="trx_type"        	 			 title="%{getText('Transaction_Type_key')}" 	editable="false" sortable="true" search="true"/>
                <psjg:gridColumn id="trx_date"	      		index="trx_date"        	 colType="date"   name="trx_date"		 	 			 title="%{getText('trs_date_key')}" 	      	editable="false" sortable="true" search="true"/>
                <psjg:gridColumn id="value_date"	  		index="value_date"           colType="date"   name="value_date"	  	     			 title="%{getText('Value_Date_key')}" 	  		editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="cheque_date"	  		index="cheque_date"     	 colType="date"   name="cheque_date"	     			 title="%{getText('Cheque_Date_key')}" 	  		editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="trs_acc_br"      		index="trs_acc_br"      	 colType="number" name="trs_acc_br"	         			 title="%{getText('Acc_Br_key')}"           	editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="trs_acc_cy"      		index="trs_acc_cy"           colType="number" name="trs_acc_cy"           		     title="%{getText('Acc_Cy_key')}"           	editable="false" sortable="true" search="true"/>				
				<psjg:gridColumn id="trs_acc_gl"	  		index="trs_acc_gl"      	 colType="number" name="trs_acc_gl"	         			 title="%{getText('Acc_GL_key')}" 		 	    editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="trs_acc_cif"	  		index="trs_acc_cif"     	 colType="number" name="trs_acc_cif"	      			 title="%{getText('Acc_CIF_key')}" 	      		editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="trs_acc_sl"	  		index="trs_acc_sl"      	 colType="number" name="trs_acc_sl"	         			 title="%{getText('Acc_SL_key')}" 	      		editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="ADDITIONAL_REFERENCE"  index="ADDITIONAL_REFERENCE" colType="text"   name="amfVO.ADDITIONAL_REFERENCE" 	 title="%{getText('Additional_Reference_key')}" editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="LONG_NAME_ENG"         index="LONG_NAME_ENG"        colType="text"   name="amfVO.LONG_NAME_ENG"     		 title="%{getText('Account_Name_key')}"        	editable="false" sortable="true" search="true"/>
			    <psjg:gridColumn id="trs_currency"	  		index="trs_currency"    	 colType="text"   name="trs_currency"	    			 title="%{getText('trs_currency_key')}" 	  	editable="false" sortable="true" search="true"/>
			    <psjg:gridColumn id="amount"	      		index="amount"               colType="number" name="amount"		    				 title="%{getText('amount_key')}" 	      		editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
			    <psjg:gridColumn id="cv_amount"	      		index="cv_amount"       	 colType="number" name="cv_amount"		    			 title="%{getText('CV_Amount_key')}" 	      	editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
			    <psjg:gridColumn id="void_reason"	  		index="void_reason"     	 colType="text"   name="void_reason"	   	 			 title="%{getText('void_reason_key')}" 	  		editable="false" sortable="true" search="true"/>
			</psjg:grid>
			<div id="DashVoidedCheques_Div_Id_${_pageRef}"></div>


<script type="text/javascript">
 var trs_acc_Key = "<ps:text name='Account_key'/>";
 var voidedChequesKey = "<ps:text name='voided_cheques_key'/>";
 $("#voidedChequesListGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
 useColSpanStyle: true,
 groupHeaders:[{startColumnName: 'trs_acc_br', numberOfColumns: 6, titleText: trs_acc_Key}]
 });								
</script>