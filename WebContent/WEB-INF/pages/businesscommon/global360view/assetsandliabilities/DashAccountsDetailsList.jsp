<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

 <ps:set name="cifNo_${_pageRef}" value="_cifNo"></ps:set>
 <ps:url id="urlDashAccDetailsGrid_${_pageRef}" action="dashAccDetailsListAction" escapeAmp="false" namespace="/path/globalview">
	 <ps:param name="iv_crud"       value="iv_crud"></ps:param>
	 <ps:param name="_pageRef"      value="_pageRef"></ps:param>
	 <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
	 <ps:param name="assestsOrLiab" value="assestsOrLiab"></ps:param>
	 <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
 </ps:url>
 <psjg:grid
    	id              ="dashAccDetailsGridTbl_Id_${_pageRef}" 
  	    href            ="%{urlDashAccDetailsGrid_${_pageRef}}"
        dataType        ="json"
        caption         ="%{getText('Account_details_key')}"
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
           <psjg:gridColumn id="decimalPoints"    	index="decimalPoints"    	name="decimalPoints"	title=" " 									colType="number" hidden="true" />	 			         
		   <psjg:gridColumn id="branchCode"       	index="branchCode"       	name="branchCode"	   	title=" " 									colType="number" hidden="true" />
		   <psjg:gridColumn id="currencyCode"     	index="currencyCode"     	name="currencyCode"	   	title=" " 									colType="number" hidden="true" />
		   <psjg:gridColumn id="glCode"           	index="glCode"           	name="glCode"	       	title=" " 									colType="number" hidden="true" />
		   <psjg:gridColumn id="slNo"             	index="slNo"             	name="slNo"	          	title=" " 									colType="number" hidden="true" />
		   <psjg:gridColumn id="acc_num"          	index="acc_num"          	name="acc_num"	       	title="%{getText('Account_Number_key')}"   	colType="text"   				editable="false" 	sortable="true"  	search="true" width="200" hidden="true"/>
		   <psjg:gridColumn id="acc_num_format"    	index="acc_num_format"     	name="acc_num_format"	title="%{getText('Account_Number_key')}"   	colType="text"   				editable="false" 	sortable="true"  	search="true" width="200"/>
		   <psjg:gridColumn id="acc_add_ref"      	index="acc_add_ref"      	name="acc_add_ref"      title="%{getText('acc_add_ref_key')}"      	colType="text"   				editable="false" 	sortable="true"  	search="true" />
		   <psjg:gridColumn id="status"           	index="status"           	name="status"           title="%{getText('status_key')}"           	colType="text"   				editable="false" 	sortable="true"  	search="true" />
		   <psjg:gridColumn id="accountName"      	index="accountName"      	name="accountName"      title="%{getText('Account_Name_key')}"     	colType="text"   				editable="false" 	sortable="true"  	search="true" />
	       <psjg:gridColumn id="ytdBalance"	      	index="ytdBalance"       	name="ytdBalance"       title="%{getText('ytd_Balance_key')}"      	colType="number" 				editable="false" 	sortable="true"  	search="true"	formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
	       <psjg:gridColumn id="availableBalance" 	index="availableBalance" 	name="availableBalance" title="%{getText('availableBalance_key')}" 	colType="number" 				editable="false" 	sortable="true"  	search="true" 	formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
	       <psjg:gridColumn id="overdraftAvailLimit" 	index="overdraftAvailLimit" 		name="overdraftAvailLimit" 	title="%{getText('overdraftavaillimit_key')}" 	colType="number" 				editable="false" 	sortable="true"  	search="true" 	formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>	       
	       <psjg:gridColumn id="blockedAmount"	  	index="blockedAmount"    	name="blockedAmount"    title="%{getText('blockedAmount_key')}"    	colType="number" 				editable="false" 	sortable="true"  	search="true" 	formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
	       <psjg:gridColumn id="approvedLine"	  	index="approvedLine"     	name="approvedLine"     title="%{getText('approvedLines_key')}"    	colType="text"   				editable="false" 	sortable="true"  	search="true" />
	       <psjg:gridColumn id="currency"	      	index="currency"         	name="currency"         title="%{getText('currency_key')}"         	colType="text"   				editable="false" 	sortable="true"  	search="true" />
	       <psjg:gridColumn id="rateOfReturn"	  	index="rateOfReturn"     	name="rateOfReturn"     title="%{getText('rate_of_return_key')}"   	colType="text"   				editable="false" 	sortable="true"  	search="true" />
	       <psjg:gridColumn id="showDues"			index="showDues"     	   	name="dueCode"	     	title="%{getText('due_details_key')}"  		colType="number" 				editable="false" 	sortable="false"  	search="false" 	formatter="duesLinkFormatter" />
	       <psjg:gridColumn id="showPostDTDepchqsBl" index="showPostDTDepchqsBl" name="postDatedDepositchequesBalance"	    title="%{getText('PostDatedChqDep_key')}" 		colType="number"  editable="false" 	sortable="false"  	search="false" 	formatter="postDatedBalancesLinkFormatter" formatCol="decimalPoints" />
	       <psjg:gridColumn id="showPostWdDepchqsBl" index="showPostWdDepchqsBl" name="postDatedWithdrawalchequesBalance"	title="%{getText('postDatedChqWDrawal_key')}" 	colType="number"  editable="false" 	sortable="false"  	search="false" 	formatter="postDatedBalancesLinkFormatter" formatCol="decimalPoints"/>
		   <psjg:gridColumn id="showsettlchqsBl"	index="showsettlchqsBl"      name="settlementChequesBalance"			title="%{getText('cheques_settl_FC_Key')}" 		colType="number"  editable="false" 	sortable="false"  	search="false" 	formatter="postDatedBalancesLinkFormatter" formatCol="decimalPoints" />
		   <psjg:gridColumn id="activeWdBalance"	index="activeWdBalance"      name="activeWdBalance"						title="%{getText('active_wd_key')}"  			colType="number"  editable="false" 	sortable="false"  	search="false"  formatter="currencyFmatter" formatCol="decimalPoints" />
		   <psjg:gridColumn id="investmentBalance"	index="investmentBalance"    name="investmentBalance" 					title="%{getText('investment_balance_key')}"  	colType="number"  editable="false" 	sortable="false"  	search="false"  formatter="currencyFmatter" formatCol="decimalPoints" />
 </psjg:grid>
  
 <table style="padding-top: 4px" cellspacing="0" cellpadding="0">
   <tr>
       <td>	  
		    <psj:submit id="trx_Info_id_${_pageRef}"  type="button" button="true" freezeOnSubmit="true" onclick="dashShowAccDtlTrxJv()">
		    	<ps:label key='Trx_jv_Info_key' />
		    </psj:submit>
		    <psj:submit button="true" freezeOnSubmit="true" onclick="dashShowAccDtlTrx()">
		    	<ps:text name="Trx_Info_key"></ps:text>
		    </psj:submit>
		    <psj:submit button="true" freezeOnSubmit="true" onclick="dashShowAccDtlJvs()">
		    	<ps:text name="jvs_list_key"></ps:text>
		    </psj:submit>
		    <psj:submit id="stat_of_account_id_${_pageRef}" type="button"  button="true" freezeOnSubmit="true" onclick="dashShowAccDtlStat()">
		    	<ps:label key='stat_of_account_key' />
		    </psj:submit>
		    <psj:submit id="signature_id_${_pageRef}" type="button" button="true" freezeOnSubmit="true" onclick="dashShowAccDtlSign()">
		    	<ps:label key='Signature_key' />
		    </psj:submit>
       </td>
   </tr>
 </table>

<script type="text/javascript" >
var due_details_key = '<ps:property value="%{getText('due_details_key')}" />';
</script>