<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/jquery/js/charting/jquery.jqplot.css" />-->

<script type="text/javascript">
$.struts2_jquery.require("highcharts.js", null, jQuery.contextPath + "/common/jquery/js/highchart/");
//$.struts2_jquery.require("jquery.jqplot.js,jqplot.pieRenderer.js,jqplot.dateAxisRenderer.js,jqplot.highlighter.js,jqplot.cursor.js", null, jQuery.contextPath + "/common/jquery/js/charting/");
//if($.browser.msie && $.browser.version <= 8)
//$.struts2_jquery.require("excanvas.js", null, jQuery.contextPath + "/common/jquery/js/charting/");
</script>
<ps:set name="asOfDate_${_pageRef}" value="criteria.asOfDateStr"/>
<ps:set name="loginTypBr_${_pageRef}" value="criteria.loginTypeByBr"/>
<ps:set name="callSource_${_pageRef}" value="criteria.callSource"/>

<ps:set name="consolCy_${_pageRef}" value="criteria.consolCy"/>

<ps:hidden id="bookValueList_${_pageRef}"	name="bookValueList"/>
<ps:hidden id="marketValueList_${_pageRef}"	name="marketValueList"/>


<ps:set name="cifNo_${_pageRef}" value="cif_no"/>
<body>
		<ps:url id="urlInvestmentsGrid_${_pageRef}" 
		        namespace="/path/globalview" escapeAmp="false"
			    action="dashInvestmentsListAction_investmentsListGrid?_pageRef=${_pageRef}">
		   <ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		   <ps:param name="criteria.branchCode"    value="criteria.branchCode"></ps:param>
           <ps:param name="criteria.runningDate"   value="asOfDate_${_pageRef}"></ps:param>
           <ps:param name="criteria.loginTypeByBr" value="loginTypBr_${_pageRef}"></ps:param>
		   <ps:param name="criteria.callSource"    value="callSource_${_pageRef}"></ps:param>
		   <ps:param name="criteria.consolCy"      value="consolCy_${_pageRef}"></ps:param>
		</ps:url>
	    <psjg:grid id="investmentsListGridTbl_Id_${_pageRef}" 
				caption="%{getText('investments_key')}"
		        altRows="true"
		    	dataType="json" 
				filter="true"
		    	gridModel="gridModel" 
		    	href="%{urlInvestmentsGrid_${_pageRef}}"
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
		        ondblclick="${ondblclick}"
		        viewrecords="true">
		    <psjg:gridColumn id="DECIMAL_POINTS"    		index="DECIMAL_POINTS" 				colType="number" name="decimalPoints"    							title=" "  										hidden="true"/>
			<psjg:gridColumn id="BRANCH"					index="BRANCH"						colType="number" name="pmsPortfolioTmpVO.BRANCH"					title="%{getText('branchKey')}"					editable="false" sortable="true" search="true" />
			<psjg:gridColumn id="CIF"						index="CIF"							colType="number" name="pmsPortfolioTmpVO.PORTFOLIO_CIF"				title="%{getText('CIF_key')}"					editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="SEQ"						index="SEQ"							colType="number" name="pmsPortfolioTmpVO.PORTFOLIO_SEQ"				title="%{getText('Sequence_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="PF_NAME"					index="PF_NAME"						colType="text" 	 name="pmsPortfolioTmpVO.PORTFOLIO_NAME"			title="%{getText('Brief_Name_key')}"			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="LONG_NAME"					index="LONG_NAME"					colType="text" 	 name="pmspacVO.LONG_NAME_ENG"						title="%{getText('Long_Name__key')}"			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="BASE_CY"					index="BASE_CY"						colType="text" 	 name="pmsPortfolioTmpVO.BASE_CY_NAME"				title="%{getText('Base_CY_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="PORTFOLIO_TYPE"			index="PORTFOLIO_TYPE"				colType="text" 	 name="pmspacVO.PORTFOLIO_TYPE"						title="%{getText('type_key')}"					editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="INITIAL_INVESTMENT"		index="INITIAL_INVESTMENT"			colType="number" name="pmspacVO.INITIAL_INVESTMENT"					title="%{getText('initial_investment')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="PORTFOLIO_VALUE_BASE_CY"	index="PORTFOLIO_VALUE_BASE_CY"		colType="number" name="pmsPortfolioTmpVO.AMOUNT_PORTFOLIO"			title="%{getText('Portfolio_Value_in_Base_CY_key')}"				editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="PORTFOLIO_VALUE_CONS_CY"	index="PORTFOLIO_VALUE_CONS_CY"		colType="number" name="pmsPortfolioTmpVO.AMOUNT_CV"					title="%{getText('Portfolio_Value_in_Consolidation_CY_key')}"				editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="consolDecimalPoints"/>
			<psjg:gridColumn id="DATE_OPENED"				index="DATE_OPENED"					colType="date" 	 name="pmsPortfolioTmpVO.DATE_OPENED"				title="%{getText('Date_Opened_key')}"			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="STATUS"					index="STATUS"						colType="text" 	 name="pmspacVO.STATUS"								title="%{getText('STATUS_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="PORTFOLIO_MARKET_BASE_CY"	index="PORTFOLIO_MARKET_BASE_CY"	colType="number" name="pmsPortfolioTmpVO.VDATE_AMOUNT_PORTFOLIO"	title="%{getText('Portfolio_Market_in_Base_CY_key')}"		editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimalPoints"/>
			<psjg:gridColumn id="PORTFOLIO_MARKET_CONS_CY"	index="PORTFOLIO_MARKET_CONS_CY"	colType="number" name="pmsPortfolioTmpVO.VDATE_AMOUNT_CV"			title="%{getText('Portfolio_Market_Value_in_Consolidation_CY_key')}"	editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="consolDecimalPoints"/>
			<psjg:gridColumn id="CONSOL_DEC_POINTS"    		index="CONSOL_DEC_POINTS" 			colType="number" name="consolDecimalPoints"    				title=" "  										hidden="true"/>
		</psjg:grid>
		
		<br/>
		
		<table width="100%">
			<tr>
				<td width="50%">
					<div id="bookValueChart" chartName='<ps:text name="Book_Value_key" />'></div>
				</td>
				<td width="50%">
					<div id="marketValueChart" chartName='<ps:text name="Market_Value_key" />'></div>
				</td>
			</tr>
		</table>
</body>
<script type="text/javascript"> 
 $(document).ready(function(){
     onLoadInvestmentCharts()
});
</script>
