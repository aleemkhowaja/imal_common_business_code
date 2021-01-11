<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
 
<html>
	<body><br/>
	
		<div> 
	
			<ps:url id="urlReservedCifGrid" action="FomReservedCifList_loadReservedCifGrid" namespace="/path/fom" escapeAmp="false">
				<ps:param name="criteria.cifType" value="%{cifTypeCode}"/>
			</ps:url>
		    <psjg:grid
		    	id="reservedCifGridTbl_Id_${_pageRef}"  
		    	dataType="json" 
		    	href="%{urlReservedCifGrid}" 
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
		    	<psjg:gridColumn name="CIF_NO" title="%{getText('CIF_No_key')}" index="CIF_NO" colType="number" editable="false" sortable="true" search="true" id="CIF_NO"/>
		    </psjg:grid>
				
		</div>
	</body>
</html>
