 <%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>


<ps:url id="gridHrefId" escapeAmp="false" 
	action="DashAccDtlDuesListAction_populateDuesForAccList" namespace="/path/globalview">
		<ps:param name="_pageRef" value="_pageRef" />
		<ps:param name="accBr" value="criteria.accBr"/>
		<ps:param name="currencyCode" value="criteria.currencyCode" />
		<ps:param name="glCode" value="criteria.glCode" />
		<ps:param name="cif_no" value="criteria.cif_no" />
		<ps:param name="slNo" value="criteria.slNo" />
</ps:url>

<psjg:grid id="dashAccountsDuesGrid_Id_${_pageRef}" 
		altRows="false" 
		caption=" "
		dataType="json" 
		editinline="false"
		filter="false" 
		gridModel="gridModel" 
		href="%{gridHrefId}" 
		height="125" 
		multiselect="false"
		navigator="true" 
		navigatorAdd="false"
		navigatorDelete="false"
		navigatorEdit="false" 
		navigatorRefresh="true" 
		navigatorSearch="true"
		navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
		pager="true" 
		pagerButtons="false"
		rownumbers="true"
		rowNum="20"
		rowList="5,10,15,20"
		sortable="false"
		shrinkToFit="true"  
		viewrecords="true"
		ondblclick="openTrxScreenFromDuesDash();"
	>
	
	<psjg:gridColumn id="COMP_CODE_${_pageRef}" name="ctsDuesVO.COMP_CODE"	colType="number" title=""	hidden="true" />
	<psjg:gridColumn id="decimalPoints_${_pageRef}" name="decimalPoints"	colType="number" title=""	hidden="true" />
	<psjg:gridColumn id="PAYMENT_MODE_${_pageRef}" name="ctsDuesVO.PAYMENT_MODE"	colType="text" title=""	hidden="true" />
	<psjg:gridColumn id="STATUS_${_pageRef}" name="ctsDuesVO.STATUS"	colType="text" title=""	hidden="true" />
				

	<psjg:gridColumn  id="APP_NAME_${_pageRef}"    	colType="text"	name="ctsDuesVO.APP_NAME"		index="APP_NAME"		title="%{getText('appName')}"
		editable="false" sortable="false" search="false" />

	<psjg:gridColumn  id="dueTypeDesc_${_pageRef}"    	colType="text"	name="dueTypeDesc"		index="dueTypeDesc"		title="%{getText('due_type_key')}"
		editable="false" sortable="false" search="false" />

	<psjg:gridColumn  id="BRANCH_CODE_${_pageRef}"    	colType="number"	name="ctsDuesVO.BRANCH_CODE"		index="BRANCH_CODE"		title="%{getText('Branch_code_key')}"
		editable="false" sortable="false" search="false" />

	<psjg:gridColumn  id="accountNumber_${_pageRef}"    	colType="text"	name="accountNumber"		index="accountNumber"		title="%{getText('Account_Number_key')}"
		editable="false" sortable="false" search="false" />

	<psjg:gridColumn  id="TRS_NO_${_pageRef}"    	colType="number"	name="ctsDuesVO.TRS_NO"		index="TRS_NO"		title="%{getText('Trx_No_key')}"
		editable="false" sortable="false" search="false" />

	<psjg:gridColumn  id="paymentModeDesc_${_pageRef}"    	colType="text"	name="paymentModeDesc"		index="paymentModeDesc"		title="%{getText('payment_mode_key ')}"
		editable="false" sortable="false" search="false" />

	<psjg:gridColumn  id="ORIGINAL_AMT_${_pageRef}"    	colType="number"	name="ctsDuesVO.ORIGINAL_AMT"		index="ORIGINAL_AMT"		title="%{getText('Original_Amount_key')}"
		editable="false" sortable="false" search="false" formatter="currencyFmatter" formatCol="decimalPoints" />

	<psjg:gridColumn  id="REMAINING_AMOUNT_${_pageRef}"    	colType="number"	name="ctsDuesVO.REMAINING_AMOUNT"		index="REMAINING_AMOUNT"		title="%{getText('Remaining_Amount_key')}"
		editable="false" sortable="false" search="false" formatter="currencyFmatter" formatCol="decimalPoints"/>

	<psjg:gridColumn  id="statusDesc_${_pageRef}"    	colType="text"	name="statusDesc"		index="statusDesc"		title="%{getText('Status_key ')}"
		editable="false" sortable="false" search="false" />

</psjg:grid>

<script type="text/javascript" >
<%/* #254261 */ %>
	$("#gview_dashAccountsDuesGrid_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
</script>