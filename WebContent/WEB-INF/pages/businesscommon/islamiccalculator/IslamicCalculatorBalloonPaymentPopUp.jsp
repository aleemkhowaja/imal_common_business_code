<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

	<div class="" style=""  width="100%">
				<ps:url id="urlBalloon"
					action=""
					namespace="/path/islamicCalculator" escapeAmp="false">
				</ps:url>
			
				<psjg:grid
					id="BalloonGridTbl_Id_${_pageRef}"		dataType="json" 
					href="%{urlBalloon}"					pager="false" 								filter="false" 				
					gridModel="gridModel"  					rowNum="5" 									rowList="5,10,15,20"
					viewrecords="true" 						navigator="true" 							height="250"
					navigatorRefresh="false" 				navigatorSearch="false"						hiddengrid="true"					
					rownumbers="true"						multiselect="false" 						multiboxonly="false"
					altRows="true" 							navigatorEdit="true" 						shrinkToFit="true" 						
					pagerButtons="false"					userDataOnFooter="true"						footerrow="true"
					
				>
				<psjg:gridColumn name="balloonnumber" cssStyle="font-weight:bold"
					title="%{getText('Balloon_#_key')}" index="balloonnumber"
					colType="text" editable="false" sortable="true" 
					id ="balloonnumber_${_pageRef}" />					
				<psjg:gridColumn name="paymentdate" cssStyle="font-weight:bold" 
					title="%{getText('Payment_Date_key')}" index="paymentdate"
					colType="number" editable="false" sortable="true" 
					id ="paymentdate_${_pageRef}" />
					<psjg:gridColumn name="balloonpayment" cssStyle="font-weight:bold" 
					title="%{getText('Balloon_Payment_key')}" index="balloonpayment"
					colType="number" editable="false" sortable="true" 
					id ="balloonpayment_${_pageRef}" />					
				</psjg:grid>
	</div>
