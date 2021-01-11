<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

	<div class="" style=""  >
				<ps:url id="urlDBRRatio"
					action="islamicCalculatorDBRatio_getDBRRatio"
					namespace="/path/islamicCalculator" escapeAmp="false">
					<ps:param name="cifNo" value="%{cifNo}"></ps:param>
					<ps:param name="productClass" value="%{productClass}"></ps:param>
					<ps:param name="currencyCode" value="%{currencyCode}"></ps:param>
				</ps:url>
			
				<psjg:grid
					id="DBRGridTbl_Id_${_pageRef}"			dataType="json" 
					href="%{urlDBRRatio}"					pager="true" 								filter="false" 				
					gridModel="gridModel"  					rowNum="5" 									rowList="5,10,15,20"
					viewrecords="true" 						navigator="true" 							
					navigatorRefresh="false" 				navigatorSearch="false"						hiddengrid="true"					
					rownumbers="true"						multiselect="false" 						multiboxonly="false"
					altRows="true" 							navigatorEdit="false" 						shrinkToFit="true" 	
					navigatorAdd="false"					navigatorDelete="false"						
					pagerButtons="false"					userDataOnFooter="true"						footerrow="true"
					onCompleteTopics="prepareDbrSummary"
					
				>
				<psjg:gridColumn name="dbrDetails" 
					title="%{getText('Name_key')}" index="dbrDetails"
					colType="text" editable="false" sortable="true" 
					id ="dbrDetails" />					
				<psjg:gridColumn name="dbrAmount" 
					title="%{getText('Type_key')}" index="dbrAmount"
					colType="number" editable="false" sortable="true" 
					id ="dbrAmount" formatter="currencyFmatter" formatCol="dbrAmountFormat"/>			
				<psjg:gridColumn title="" name="dbrAmountFormat" colType="number" hidden="true"/>	
				</psjg:grid>
	</div>	
	<script type="text/javascript">
	
		$("#DBRGridTbl_Id_"+_pageRef).unsubscribe("prepareDbrSummary");
		$("#DBRGridTbl_Id_"+_pageRef).subscribe("prepareDbrSummary",function(){ 	
			setDBRTotal();
		});
	</script>	
