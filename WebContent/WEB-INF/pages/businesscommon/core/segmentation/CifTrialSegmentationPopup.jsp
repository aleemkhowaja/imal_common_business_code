<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>


<html>
	<body>
		<br/>
		<div>
			<ps:url id="urlCifTrialSegmentationGrid" action="CustSegmentationMaintAction_returnCifOfTrialSegmentationProcessPopup" namespace="/path/segmentation" escapeAmp="false">
				<ps:param name="custSegmentationCO.ctsSegmentVO.SEGMENT_CODE" value="%{custSegmentationCO.ctsSegmentVO.SEGMENT_CODE}"/>
			</ps:url>
		    <psjg:grid
		    	id="cifTrialSegmentationGridTbl_Id_${_pageRef}"  
		    	dataType="json" 
		    	href="%{urlCifTrialSegmentationGrid}" 
		    	pager="true" 
		    	pagerPosition="left"
		    	filter="true"
		    	gridModel="gridModel" 
		    	rowNum="5" 
		    	rowList="5,10,15,20"
		        viewrecords="true" 
		        multiselect="false"
		        multiboxonly="false"
		        navigator="false" 
		        navigatorAdd="false"
		        navigatorDelete="false"
		        navigatorEdit="false"
		        navigatorRefresh="false"
		        navigatorSearch="false"
		        navigatorView="false"
		        height="160"
		        altRows="true"
		    >
		    	<psjg:gridColumn name="CIF" title="%{getText('CIF_No_key')}" index="CIF" colType="number" editable="false" sortable="true" search="true" id="CIF"/>
		    	<psjg:gridColumn name="CRITERIA_CODE" title="%{getText(criteria_code_key')}" index="CRITERIA_CODE" colType="number" editable="false" sortable="true" search="true" id="CRITERIA_CODE"/>
		    		
		    </psjg:grid>
		</div>
	</body>
</html>