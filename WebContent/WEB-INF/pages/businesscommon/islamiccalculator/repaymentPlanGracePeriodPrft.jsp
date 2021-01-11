<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<div class="" style="width: 100%;" id="gracePeriodProfitScheduleDiv_${_pageRef}"  hidden="true">
	<psjg:grid
				id="gracePeriodProfitScheduleGridTbl_Id_${_pageRef}"
				dataType="json" 
															pager="false" 								filter="false" 				
					gridModel="gridModel"  					rowNum="5" 									rowList="5,10,15,20"
					viewrecords="false" 					navigator="false" 							height="370"
					navigatorRefresh="false" 				navigatorSearch="false"						hiddengrid="false"
					addfunc="addDealCharges" 				editfunc="editDealCharges"					delfunc="deleteDealCharges"
					rownumbers="false"						multiselect="false" 						multiboxonly="false"
					editinline="false"						altRows="true" 								navigatorAdd="false"		
					navigatorEdit="false" 					shrinkToFit="false" 						pagerButtons="false"
					footerrow="true"						navigatorDelete="false"						
					editurl="abc"  							userDataOnFooter="true">		 
					
		<psjg:gridColumn name="LINE_NO" 
			title="%{getText('L/N_key')}" index="LINE_NO"
			colType="number" editable="false" sortable="false" 
			id ="lnNo_${_pageRef}" />					
			
		<psjg:gridColumn name="PROFIT_AMOUNT"
			title="%{getText('Installment_Amount_key')}" index="PROFIT_AMOUNT"
			colType="number" editable="false" sortable="false" 
			id ="PROFIT_AMOUNT_${_pageRef}"  nbFormat="0,###.000"/>
		
		<psjg:gridColumn name="DEAL_AMOUNT"
			title="%{getText('Installment_Amount_key')}" index="DEAL_AMOUNT"
			colType="number" editable="false" sortable="true" 
			id ="DEAL_AMOUNT_${_pageRef}"  nbFormat="0,###.000"/>
				
		<psjg:gridColumn name="FROM_DATE" title="%{getText('Due_Date_key')}"
			index="FROM_DATE" colType="date" editable="false" sortable="false"
			id="FROM_DATE" align="center" width="80" />
		
		<psjg:gridColumn name="TO_DATE" title="%{getText('Due_Date_key')}"
			index="TO_DATE" colType="date" editable="false" sortable="false"
			id="TO_DATE" align="center" width="80" />
					
		<psjg:gridColumn name="YIELD"
			title="%{getText('Installment_Amount_key')}" index="YIELD"
			colType="number" editable="false" sortable="false" 
			id ="YIELD_${_pageRef}"  nbFormat="0,###.000000"/>
				
	</psjg:grid>
	
</div>

