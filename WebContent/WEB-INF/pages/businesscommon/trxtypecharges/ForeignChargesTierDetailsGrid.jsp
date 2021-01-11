<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

	<ps:url id="foreignCYChargeTiresdetailsGrid" action="MaintenenceChargesGridAction_loadTireDetailsGrid" namespace="/path/fom" escapeAmp="false">
		<ps:param name="criteria.currencyCode" value="%{criteria.currencyCode}"/>
		<ps:param name="criteria.code" value="%{criteria.code}"/>
		<ps:param name="_pageRef" value="_pageRef"></ps:param>
	</ps:url>
	
	<psjg:grid 
		id="foreignCYChargeTiresdetailsGrid_Id_${_pageRef}"
		caption=""
		href="%{foreignCYChargeTiresdetailsGrid}" 
		dataType="json"
		pager="true"
		pagerButtons="true"
		filter="false" 
		gridModel="gridModel" 
		rowNum="5" 
		rowList="5,10,15,20"
		viewrecords="true" 
		navigator="false" 
		height="110" 
		altRows="true"
		editinline="false"
	    shrinkToFit="true" 	
		rownumbers="true"
	>			
			
		<psjg:gridColumn name="FROM_AMT" title="%{getText('From_amount_key')}" index="FROM_AMT" colType="number"
			editable="false" sortable="true" search="false" id="FROM_AMT" />	
		<psjg:gridColumn name="TO_AMT" title="%{getText('To_amount_key')}" index="TO_AMT" colType="number"
			editable="false" sortable="true" search="false" id="TO_AMT" />		
		<psjg:gridColumn name="PERCENTAGE" title="%{getText('Percentage_key')}" index="PERCENTAGE" colType="number"
			editable="false" sortable="true" search="false" id="PERCENTAGE" />		
		<psjg:gridColumn name="MIN_AMT" title="%{getText('Minimum_Amount_key')}" index="MIN_AMT" colType="number"
			editable="false" sortable="true" search="false" id="MIN_AMT" />				 
		<psjg:gridColumn name="MAX_AMT" title="%{getText('Maximum_Amount_key')}" index="MAX_AMT" colType="number"
			editable="false" sortable="true" search="false" id="MAX_AMT" />				 
		<psjg:gridColumn name="DISC_AMT" title="%{getText('Discount_Amount_key')}"  index="DISC_AMT" colType="number"
			editable="false" sortable="true" search="false" id="DISC_AMT" />	
		<psjg:gridColumn name="CY_CODE" title="" index="CY_CODE" colType="number" hidden="true"
			editable="false" sortable="true" search="false" id="CY_CODE" />	
		<psjg:gridColumn name="DECIMAL_POINTS" title="" index="DECIMAL_POINTS" colType="number" hidden="true"
			editable="false" sortable="true" search="false" id="DECIMAL_POINTS" />	
		
	</psjg:grid>