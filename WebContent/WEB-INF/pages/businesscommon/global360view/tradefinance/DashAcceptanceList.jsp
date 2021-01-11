<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

    <ps:set name="cifNo_${_pageRef}" value="cif_no"/>
			
   	<ps:url id="urlAcceptanceGrid_${_pageRef}"
   			namespace="/path/globalview" escapeAmp="false"
			action="dashAcceptanceListAction?_pageRef=${_pageRef}">
			<ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
	</ps:url>
	<psjg:grid id="acceptanceListGridTbl_Id_${_pageRef}" 
				caption="%{getText('acceptance_key')}"
		        altRows="true"
		    	dataType="json" 
				filter="true"
		    	gridModel="gridModel" 
		    	href="%{urlAcceptanceGrid_${_pageRef}}"
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
		    <psjg:gridColumn id="LC_YEAR"			index="LC_YEAR"			colType="number" 	name="tfslc1VO.LC_YEAR"			title=" "								hidden="true"/>
		    <psjg:gridColumn id="LC_TYPE"			index="LC_TYPE"			colType="text" 	 	name="tfslc1VO.LC_TYPE"			title=" "								hidden="true"/>
			<psjg:gridColumn id="TRX_TYPE"			index="TRX_TYPE"		colType="number" 	name="tfstrxVO.TRX_TYPE"		title=" "								hidden="true"/>
			<psjg:gridColumn id="LC_NBR"			index="LC_NBR"			colType="number" 	name="tfslc1VO.LC_NBR"			title=" "								hidden="true"/>
		    <psjg:gridColumn id="DECIMAL_POINTS"    index="DECIMAL_POINTS" 	colType="number" 	name="decimalPoints"    		title=" "  								hidden="true"/>
			<psjg:gridColumn id="LC_NUM"			index="LC_NBR"			colType="number"	name="tfstrxVO.LC_NBR"			title="%{getText('LC_Ref_Nbr_key')}"	editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRX_NBR"			index="TRX_NBR"			colType="number" 	name="tfstrxVO.TRX_NBR"			title="%{getText('Trx_No_key')}"		editable="false" sortable="true" search="true" formatter="dashboard_acceptanceBtn" unformat="dashboard_unformatHyperlink"/>
			<psjg:gridColumn id="CURRENCY"			index="CURRENCY"		colType="text"		name="currencyDesc"				title="%{getText('Currency_key')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="AMOUNT"			index="SHIPMENT_AMOUNT"	colType="number"	name="tfstrxVO.SHIPMENT_AMOUNT"	title="%{getText('FC_Amount_key')}"		editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="CV_AMOUNT"			index="CV_AMOUNT"		colType="number"	name="tfstrxVO.CV_AMOUNT"		title="%{getText('CV_Amount_key')}"		editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="T_DATE"			index="TRX_DATE"		colType="date"		name="tfstrxVO.TRX_DATE"		title="%{getText('trsDate_key')}"		editable="false" sortable="true" search="true"/>				
			<psjg:gridColumn id="M_DATE"			index="VALID_TO"		colType="date"		name="tfstrxVO.VALID_TO"		title="%{getText('Expiry_Date_key')}"	editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="LC_TYPE"			index="LC_TYPE"			colType="text"		name="tfstrxVO.LC_TYPE"			title="%{getText('LC_Type_key')}"		editable="false" sortable="true" search="true"/>
	</psjg:grid>
	
<script type="text/javascript">
var importLCKey = "<ps:text name='In_LC_key' />";
var importBillKey = "<ps:text name='inbills_key' />";
var exportLCKey = "<ps:text name='Out_LC_key' />";
var exportBillKey = "<ps:text name='outbills_key' />";
</script>