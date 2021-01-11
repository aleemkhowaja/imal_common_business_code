<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:set name="cifNo_${_pageRef}" value="cif_no"/>
<body>
		<ps:url id="urlInOutBillsGrid_${_pageRef}" 
		        namespace="/path/globalview" escapeAmp="false"
			    action="dashInOutBillsListAction?_pageRef=${_pageRef}">
		   <ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
	    <psjg:grid id="inOutBillsListGridTbl_Id_${_pageRef}" 
				caption="%{getText('In_Out_Bills_key')}"
		        altRows="true"
		    	dataType="json" 
				filter="true"
		    	gridModel="gridModel" 
		    	href="%{urlInOutBillsGrid_${_pageRef}}"
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
		        shrinkToFit="true"
		        sortable="true"
		        viewrecords="true">
		    <psjg:gridColumn id="LC_TYPE"    		index="LC_TYPE"    			colType="text"	 name="tfstrxVO.LC_TYPE"    		title=" "  								hidden="true"/>
		    <psjg:gridColumn id="TRX_TYPE"   		index="TRX_TYPE"    		colType="number" name="tfstrxVO.TRX_TYPE"    		title=" "  								hidden="true"/>
		    <psjg:gridColumn id="TRX_NBR"   		index="TRX_NBR"    			colType="text"	 name="tfstrxVO.TRX_NBR"    		title=" "  								hidden="true"/>
		    <psjg:gridColumn id="DECIMAL_POINTS"    index="DECIMAL_POINTS"    	colType="number" name="decimalPoints"    			title=" "  								hidden="true"/>
			<psjg:gridColumn id="BILL_NBR"			index="BILL_NBR"			colType="number" name="tfsbillVO.BILL_NBR"			title="%{getText('Bill_No_key')}"		editable="false" sortable="true" search="true" formatter="dashboard_inOutBillsBtn" unformat="dashboard_unformatHyperlink"/>
			<psjg:gridColumn id="BILL_TYPE"			index="BILL_TYPE"			colType="text" 	 name="tfsbillVO.BILL_TYPE"			title="%{getText('inOutBills_key')}"	editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="BILL_DATE"			index="BILL_DATE"			colType="date"	 name="tfsbillVO.BILL_DATE"			title="%{getText('Bill_Date_key')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="DUE_DATE"			index="BILL_DUE_DATE"		colType="date" 	 name="tfsbillVO.BILL_DUE_DATE"		title="%{getText('Due_Date_key')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="CURRENCY"			index="CURRENCY"			colType="text" 	 name="currencyDesc"				title="%{getText('Currency_key')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="FC_AMOUNT"			index="FC_AMENDED_AMOUNT"	colType="number" name="tfsbillVO.FC_AMENDED_AMOUNT"	title="%{getText('FC_Amount_key')}"		editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="CV_AMOUNT"			index="CV_AMENDED_AMOUNT"	colType="number" name="tfsbillVO.CV_AMENDED_AMOUNT"	title="%{getText('CV_Amount_key')}"		editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="statusDesc"		index="statusDesc"			colType="text" 	 name="statusDesc"					title="%{getText('status_key')}"		editable="false" sortable="true" search="true"/>			
		</psjg:grid>
</body>	

<script type="text/javascript">
var importBillKey = "<ps:text name='inbills_key' />";
var exportBillKey = "<ps:text name='outbills_key' />";
</script>