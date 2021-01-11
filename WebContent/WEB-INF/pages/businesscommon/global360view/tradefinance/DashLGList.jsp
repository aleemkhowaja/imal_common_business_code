<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

    <ps:set name="cifNo_${_pageRef}" value="cif_no"/>
			
    	<ps:url id="urlLGGrid_${_pageRef}"
    			namespace="/path/globalview" escapeAmp="false"
				action="dashLGListAction?_pageRef=${_pageRef}">
				<ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
		<psjg:grid id="lgGridTbl_Id_${_pageRef}" 
					caption="%{getText('LGs_key')}"
			        altRows="true"
			    	dataType="json" 
					filter="true"
			    	gridModel="gridModel" 
			    	href="%{urlLGGrid_${_pageRef}}"
			        navigator="true" 
			        navigatorAdd="false"
			        navigatorDelete="false"
			        navigatorEdit="false"
			        navigatorRefresh="false"
			        navigatorSearch="true" 
			        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
			    	pager="true"
			    	rowNum="5" 
			    	rowList="5,10,15,20"
			        shrinkToFit="false"
			        sortable="true"
			        viewrecords="true">
			    <psjg:gridColumn id="LC_TYPE"    		index="LC_TYPE"    		colType="text"	 	name="tfstrxVO.LC_TYPE"    		title=" "  								hidden="true"/>
		    	<psjg:gridColumn id="TRX_TYPE"   		index="TRX_TYPE"    	colType="number" 	name="tfstrxVO.TRX_TYPE"    	title=" "  								hidden="true"/>
		    	<psjg:gridColumn id="TRX_NBR"   		index="TRX_NBR"    		colType="number" 	name="tfstrxVO.TRX_NBR"    		title=" "  								hidden="true"/>
		    	<psjg:gridColumn id="DECIMAL_POINTS"    index="DECIMAL_POINTS"  colType="number" 	name="decimalPoints"    		title=" "  								hidden="true"/>
				<psjg:gridColumn id="LG_NBR"			index="LG_NBR"			colType="number" 	name="tfslgVO.LG_NBR"			title="%{getText('LGs_key')}"			editable="false" sortable="true" search="true" formatter="dashboard_lgBtn" unformat="dashboard_unformatHyperlink"/>
				<psjg:gridColumn id="VALIDITY_FROM"		index="VALIDITY_FROM"	colType="date"		name="tfslgVO.VALIDITY_FROM"	title="%{getText('ValidityFrom_key')}"	editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="VALIDITY_TO"		index="VALIDITY_TO"		colType="date" 		name="tfslgVO.VALIDITY_TO"		title="%{getText('ValidityTo_key')}"	editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="DOC_DATE"			index="DOC_DATE"		colType="date"		name="tfslgVO.DOC_DATE"			title="%{getText('Doc_date_key')}"		editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="CURRENCY"			index="CURRENCY"		colType="text"		name="currencyDesc"				title="%{getText('Currency_key')}"		editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="AMOUNT"			index="AMOUNT"			colType="number"	name="tfslgVO.AMOUNT"			title="%{getText('Amount_key')}"		editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>				
				<psjg:gridColumn id="CV_AMOUNT"			index="CV_AMOUNT"		colType="number"	name="tfslgVO.CV_AMOUNT"		title="%{getText('CV_Amount_key')}"		editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
				<psjg:gridColumn id="statusDesc"		index="statusDesc"		colType="text" 		name="statusDesc"				title="%{getText('status_key')}"		editable="false" sortable="true" search="true"/>
		</psjg:grid>

<script type="text/javascript">
var lgKey = "<ps:text name='LGs_key' />";
</script>