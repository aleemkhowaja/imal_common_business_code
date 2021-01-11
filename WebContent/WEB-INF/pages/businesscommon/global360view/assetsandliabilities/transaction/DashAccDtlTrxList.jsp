<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
 <ps:url id="urlDashAccDtlTrxGrid_${_pageRef}" action="dashAccDtlTrxListAction" escapeAmp="false" namespace="/path/globalview">
	 <ps:param name="iv_crud"      value="iv_crud"></ps:param>
	 <ps:param name="_pageRef"     value="_pageRef"></ps:param>
	 <ps:param name="cif_no"       value="criteria.cif_no"></ps:param>
	 <ps:param name="accNum"       value="criteria.accNum"></ps:param>
	 <ps:param name="accBr"   	   value="dashAccountDetailsCO.branchCode"></ps:param>
	 <ps:param name="currencyCode" value="dashAccountDetailsCO.currencyCode"></ps:param>
	 <ps:param name="glCode"       value="dashAccountDetailsCO.glCode"></ps:param>
	 <ps:param name="slNo"         value="dashAccountDetailsCO.slNo"></ps:param>
	 <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
 </ps:url>
 <table width="100%">
    <tr>
        <td width="80px">
             <ps:label key="Account_Number_key" 
                       id="lbl_account_number_${_pageRef}"
                       for="account_number_${_pageRef}"/>
        </td>
        <td >
			 <ps:textfield id="account_number_${_pageRef}" 
				           name="dashAccountDetailsCO.acc_num" readonly="true"/>
        </td>
        <td align="right">
             <ps:label key="Account_Name_key" 
                       id="lbl_account_name_${_pageRef}" 
                       for="account_name_${_pageRef}"/>
        </td>
        <td>
			 <ps:textfield id="account_name_${_pageRef}" 
				           name="dashAccountDetailsCO.accountName" readonly="true"/>
        </td>
        <td width="40%"></td>
    </tr>
    <tr>
    <td colspan="5">
          <div>
			 <psjg:grid
			    	id              ="dashAccDtlTrxGridTbl_Id_${_pageRef}" 
			  	    href            ="%{urlDashAccDtlTrxGrid_${_pageRef}}"
			        dataType        ="json"
			        caption         ="%{getText('trxMgntList_key')}"
			        hiddengrid      ="false"
			    	pager           ="true"
			    	filter          ="true"
			    	sortable        ="false"
			    	gridModel       ="gridModel"
			    	rowNum          ="5"
					rowList         ="5,10,15,20"
					viewrecords     ="true" 
					navigator       ="true"
					altRows         ="true"
					navigatorRefresh="false" 
					navigatorAdd    ="false" 
					navigatorDelete ="false"
					navigatorEdit   ="false"
					navigatorSearch ="false"
			        shrinkToFit     ="false">
			           <psjg:gridColumn id="COMP_CODE"		   index="COMP_CODE"		  name="ctstrsVO.COMP_CODE" title="Hidden compCode"	 				   colType="number" editable="false" sortable="true" search="true" hidden = "true"/>
				       <psjg:gridColumn id="TRS_TYPE"		   index="TRS_TYPE"		      name="ctstrsVO.TRS_TYPE"  title="Hidden TRS_TYPE"	 				   colType="text"   editable="false" sortable="true" search="true" hidden = "true"/>
				       <psjg:gridColumn id="CB_IND"		  	   index="CB_IND"		      name="ctstrsVO.CB_IND"	title="Hidden CB_IND"	 				   colType="text"   editable="false" sortable="true" search="true" hidden = "true"/>
				       <psjg:gridColumn id="TRX_TYPE"		   index="TRX_TYPE"		      name="ctstrsVO.TRX_TYPE"  title="Hidden trxType"	 				   colType="number" editable="false" sortable="true" search="true" hidden = "true"/>	 			         
					   <psjg:gridColumn id="decimal_points"    index="decimal_points"     name="decimal_points"     title=" "                                  colType="number" editable="false" sortable="true" search="true" hidden="true"/>
					   <psjg:gridColumn id="cv_decimal_points" index="cv_decimal_points"  name="cv_decimal_points"  title=" "                         		   colType="number" editable="false" sortable="true" search="true" hidden="true"/>
					   <psjg:gridColumn id="trx_branch"        index="trx_branch"         name="trx_branch"  	  	title="%{getText('trx_branch_key')}"       colType="text"   editable="false" sortable="true" search="true"/>
					   <psjg:gridColumn id="trx_no"            index="trx_no"             name="trx_no"      	  	title="%{getText('trsNo_key')}"            colType="number" editable="false" sortable="true" search="true" formatter="dashboard_accDelailsTrxBtn"/>
					   <psjg:gridColumn id="trx_desc"          index="trx_desc"           name="trx_desc"    	  	title="%{getText('Transaction_Type_key')}" colType="text"   editable="false" sortable="true" search="true"/>
					   <psjg:gridColumn id="trx_status"        index="trx_status"         name="trx_status"  	  	title="%{getText('status_key')}"           colType="text"   editable="false" sortable="true" search="true"/>
				       <psjg:gridColumn id="trade_date"        index="trade_date"         name="trade_date"  	  	title="%{getText('trade_date_key')}"       colType="date"   editable="false" sortable="true" search="true"/>
				       <psjg:gridColumn id="value_date"	       index="value_date"         name="value_date"  	  	title="%{getText('valueDate_key')}"        colType="date"   editable="false" sortable="true" search="true"/>
				       <psjg:gridColumn id="amount"	           index="amount"             name="amount"      	  	title="%{getText('account_amount_key')}"   colType="number" editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
				       <psjg:gridColumn id="cvAmount"	       index="cvAmount"           name="cvAmount"    	  	title="%{getText('CV_Amount_key')}"        colType="number" editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="cv_decimal_points"/>
				       <psjg:gridColumn id="voidReason"        index="voidReason"         name="voidReason"  	  	title="%{getText('void_reason_key')}"      colType="text"   editable="false" sortable="true" search="true"/>
			  </psjg:grid>
          </div>
    </td>
    </tr>
 </table>
  <script type="text/javascript">
  var trxDetlsKey = "<ps:text name='Trx_Det_key'/>"; 						
 </script>