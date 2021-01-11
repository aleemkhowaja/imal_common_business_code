<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:url id="gridHrefId" escapeAmp="false" 
	action="DashAccDetailsLoadAction_populatePostDatedChequeTrxList" namespace="/path/globalview">
		<ps:param name="_pageRef" 		value="_pageRef" />
		<ps:param name="accBr" 			value="criteria.accBr"/>
		<ps:param name="currencyCode" 	value="criteria.currencyCode" />
		<ps:param name="glCode" 		value="criteria.glCode" />
		<ps:param name="cif_no" 		value="criteria.cif_no" />
		<ps:param name="slNo" 			value="criteria.slNo" />
		<ps:param name="colname" 		value="criteria.colname" /> 
</ps:url>

<psjg:grid id="postDatedChequeTrxGrid_Id_${_pageRef}" 
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
		navigatorSearch="false"
		pager="true" 
		pagerButtons="true"
		rownumbers="true"
		rowNum="20"
		rowList="5,10,15,20"
		sortable="true"
		shrinkToFit="true"  
		viewrecords="true"
	>
	
	<psjg:gridColumn  id="BRANCH_CODE"    colType="text"	name="ctstrsVO.BRANCH_CODE"		index="BRANCH_CODE"		title="%{getText('Branch_code_key')}"
		editable="false" sortable="true" search="false" />	
	<psjg:gridColumn  id="TRS_NO"    	  colType="text"	name="ctstrsVO.TRS_NO"			index="TRS_NO"			title="%{getText('Trx_No_key')}"
		editable="false" sortable="true" search="false" />
	<psjg:gridColumn  id="TRS_DATE"    	  colType="date"	name="ctstrsVO.TRS_DATE"		index="TRS_DATE"		title="%{getText('trs_date_key')}"
		editable="false" sortable="true" search="false" />
	<psjg:gridColumn  id="VALUE_DATE"     colType="date"	name="ctstrsVO.VALUE_DATE"		index="VALUE_DATE"		title="%{getText('Value_Date_key')}"
		editable="false" sortable="true" search="false" />
	<psjg:gridColumn  id="TRS_AC_AMOUNT"  colType="text"	name="ctstrsVO.TRS_AC_AMOUNT"	index="TRS_AC_AMOUNT"	title="%{getText('amount_key')}"
		editable="false" sortable="true" search="false" />
	<psjg:gridColumn  id="CV_AMOUNT"      colType="text"	name="ctstrsVO.CV_AMOUNT"		index="CV_AMOUNT"		title="%{getText('CV_Amount_key')}"
		editable="false" sortable="true" search="false" />
</psjg:grid>