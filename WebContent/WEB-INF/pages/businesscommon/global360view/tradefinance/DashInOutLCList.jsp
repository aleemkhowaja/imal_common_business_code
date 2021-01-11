<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:set name="cifNo_${_pageRef}" value="cif_no"/>
<body>
	<div>
		<ps:url id="urlInLCGrid_${_pageRef}" 
		        namespace="/path/globalview" escapeAmp="false"
			    action="dashInOutLCListAction_inLCListGrid?_pageRef=${_pageRef}">
			<ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
	    <psjg:grid id="inLCListGridTbl_Id_${_pageRef}" 
				caption="%{getText('Out_LC_key')}"
		        altRows="true"
		    	dataType="json" 
				filter="true"
		    	gridModel="gridModel" 
		    	href="%{urlInLCGrid_${_pageRef}}"
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
		    <psjg:gridColumn id="LC_YEAR"			index="LC_YEAR"						colType="number" 	name="tfslc1VO.LC_YEAR"						title=" "											hidden="true"/>
		    <psjg:gridColumn id="LC_TYPE"			index="LC_TYPE"						colType="text" 		name="tfslc1VO.LC_TYPE"						title=" "											hidden="true"/>
			<psjg:gridColumn id="TRX_TYPE"			index="TRX_TYPE"					colType="number" 	name="tfstrxVO.TRX_TYPE"					title=" "											hidden="true"/>
			<psjg:gridColumn id="TRX_NBR"			index="TRX_NBR"						colType="number" 	name="tfstrxVO.TRX_NBR"						title=" "											hidden="true"/>
			<psjg:gridColumn id="DECIMAL_POINTS"    index="DECIMAL_POINTS"    			colType="number" 	name="decimalPoints"    					title=" "  											hidden="true"/>
			<psjg:gridColumn id="LC_NBR"			index="LC_NBR"						colType="number"	name="tfslc1VO.LC_NBR"						title="%{getText('LC_Ref_Nbr_key')}"				editable="false" sortable="true" search="true" formatter="dashboard_inwardLCBtn" unformat="dashboard_unformatHyperlink"/>
			<psjg:gridColumn id="VALIDITY_FROM"		index="VALIDITY_FROM"				colType="date"		name="tfslc1VO.VALIDITY_FROM"				title="%{getText('ValidityFrom_key')}"				editable="false" sortable="true" search="true" />
			<psjg:gridColumn id="VALIDITY_TO"		index="VALIDITY_TO"					colType="date"		name="tfslc1VO.VALIDITY_TO"					title="%{getText('ValidityTo_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="LC_AMOUNT"			index="LC_AMOUNT"					colType="number" 	name="tfslc1VO.LC_AMOUNT"					title="%{getText('FC_Amount_key')}"					editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="CV_AMOUNT"			index="CV_AMOUNT"					colType="number" 	name="tfslc1VO.CV_AMOUNT"					title="%{getText('CV_Amount_key')}"					editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="LC_CURRENCY"		index="LC_CURRENCY"					colType="text" 		name="currencyDesc"							title="%{getText('Currency_key')}"					editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="CREDIT_AVAIL"		index="CREDIT_AVAILABILITY"			colType="text" 		name="tfslc1VO.CREDIT_AVAILABILITY"			title="%{getText('Credit_Availability_key')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="CREDIT_AVAIL_DAYS"	index="CREDIT_AVAILABILITY_DAYS"	colType="text" 		name="tfslc1VO.CREDIT_AVAILABILITY_DAYS"	title="%{getText('Credit_Availability_Days_key')}"	editable="false" sortable="true" search="true"/>
		</psjg:grid>
		<br/>
	</div>
	<div>
		<ps:url id="urlOutLCGrid_${_pageRef}" 
		        namespace="/path/globalview" escapeAmp="false"
			    action="dashInOutLCListAction_outLCListGrid?_pageRef=${_pageRef}">
			<ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
	    <psjg:grid id="outLCListGridTbl_Id_${_pageRef}" 
				caption="%{getText('In_LC_key')}"
		        altRows="true"
		    	dataType="json" 
				filter="true"
		    	gridModel="gridModel" 
		    	href="%{urlOutLCGrid_${_pageRef}}"
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
		    <psjg:gridColumn id="LC_YEAR"			index="LC_YEAR"						colType="number" name="tfslc1VO.LC_YEAR"					title=" "											hidden="true"/>
		    <psjg:gridColumn id="LC_TYPE"			index="LC_TYPE"						colType="text" 	 name="tfslc1VO.LC_TYPE"					title=" "											hidden="true"/>
			<psjg:gridColumn id="TRX_TYPE"			index="TRX_TYPE"					colType="number" name="tfstrxVO.TRX_TYPE"					title=" "											hidden="true"/>
			<psjg:gridColumn id="TRX_NBR"			index="TRX_NBR"						colType="number" name="tfstrxVO.TRX_NBR"					title=" "											hidden="true"/>
			<psjg:gridColumn id="DECIMAL_POINTS"    index="DECIMAL_POINTS"    			colType="number" name="decimalPoints"    					title=" "  											hidden="true"/>
			<psjg:gridColumn id="LC_NBR"			index="LC_NBR"						colType="number" name="tfslc1VO.LC_NBR"						title="%{getText('LC_Ref_Nbr_key')}"				editable="false" sortable="true" search="true" formatter="dashboard_outwardLCBtn" unformat="dashboard_unformatHyperlink"/>
			<psjg:gridColumn id="VALIDITY_FROM"		index="VALIDITY_FROM"				colType="date"	 name="tfslc1VO.VALIDITY_FROM"				title="%{getText('ValidityFrom_key')}"				editable="false" sortable="true" search="true" />
			<psjg:gridColumn id="VALIDITY_TO"		index="VALIDITY_TO"					colType="date"	 name="tfslc1VO.VALIDITY_TO"				title="%{getText('ValidityTo_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="LC_AMOUNT"			index="LC_AMOUNT"					colType="number" name="tfslc1VO.LC_AMOUNT"					title="%{getText('FC_Amount_key')}"					editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="CV_AMOUNT"			index="CV_AMOUNT"					colType="number" name="tfslc1VO.CV_AMOUNT"					title="%{getText('CV_Amount_key')}"					editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="LC_CURRENCY"		index="LC_CURRENCY"					colType="text" 	 name="currencyDesc"						title="%{getText('Currency_key')}"					editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="CREDIT_AVAIL"		index="CREDIT_AVAILABILITY"			colType="text" 	 name="tfslc1VO.CREDIT_AVAILABILITY"		title="%{getText('Credit_Availability_key')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="CREDIT_AVAIL_DAYS"	index="CREDIT_AVAILABILITY_DAYS"	colType="text" 	 name="tfslc1VO.CREDIT_AVAILABILITY_DAYS"	title="%{getText('Credit_Availability_Days_key')}"	editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="statusDesc"		index="statusDesc"					colType="text" 		name="statusDesc"							title="%{getText('status_key')}"					editable="false" sortable="true" search="true"/>
		</psjg:grid>
		<br/>
	</div>
</body>

<script type="text/javascript">
var importLCKey = "<ps:text name='In_LC_key' />";
var exportLCKey = "<ps:text name='Out_LC_key' />";
 </script>