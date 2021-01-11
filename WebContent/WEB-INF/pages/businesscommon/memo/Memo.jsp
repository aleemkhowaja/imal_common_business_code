<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>



 
	
 
<html> 
	<head> 
	<script type="text/javascript" 	src="${pageContext.request.contextPath}/businesscommon/js/memo/MemoDtls.js"></script>
	</head>
	<body> 
	<ps:hidden id="forAccOrCif" value="%{memoSC.forAccOrCif}" />
	<ps:hidden id="cifNo" value="%{memoSC.cifNo}" />
	<ps:hidden id="accBR" value="%{memoSC.accBR}" />
	<ps:hidden id="accCY" value="%{memoSC.accCY}" />
	<ps:hidden id="accGL" value="%{memoSC.accGL}" />
	<ps:hidden id="accCIF" value="%{memoSC.accCIF}" />
	<ps:hidden id="accSL" value="%{memoSC.accSL}" />
	<ps:hidden id="optRef" value="%{memoSC.optRef}" />
	
	<div style="width: 690px;">	
					
			<ps:url id="urlMemoGrid" action="MemoGrid_loadMemo"  namespace="/path/memo"  escapeAmp="false" >					
					 <ps:param name="forAccOrCif" value="%{memoSC.forAccOrCif}"  ></ps:param>
					 <ps:param name="accCIF" value="%{memoSC.accCIF}"></ps:param>
					 <ps:param name="accSL" value="%{memoSC.accSL}"></ps:param>
					 <ps:param name="accGL" value="%{memoSC.accGL}"></ps:param>
					 <ps:param name="accCY" value="%{memoSC.accCY}"></ps:param>					 
					 <ps:param name="accBR" value="%{memoSC.accBR}"></ps:param>
					 <ps:param name="trxType" value="%{memoSC.trxType}"></ps:param>
					 <ps:param name="cifNo" value="%{memoSC.cifNo}"></ps:param>
					 <ps:param name="appType" value="%{memoSC.appType}"></ps:param>
					 <ps:param name="optRef" value="%{memoSC.optRef}"></ps:param>					  
					<%/* TP- 638896 - Added skipAppName checking for show memo from all application*/%>	
					 <ps:param name="skipAppName" value="%{memoSC.skipAppName}"></ps:param>					  
			</ps:url>		
				
		    <psjg:grid
		    	id="memoGrid"    	
		    	caption="%{getText('Memo_Details_key')}"		    	
    	        href='%{(memoJson == null || memoJson == "") ? #urlMemoGrid : ""}' 
                dataType="json"                
		    	pager="true"		    					
		    	gridModel="gridModel" 
		    	rowNum="5" 
		    	rowList="5,10,15,20"
		        viewrecords="true" 
		        navigator="true" 		       
		        altRows="true"		        
		        sortable="true"	
		        filter="true"
		        multiselect="true"
		        multiboxonly="false"  
		        hidegrid="false"		        
		        autowidth="false"	             
		       	shrinkToFit="false"
		       	width="730"
		       	height="160"   
		        >	
		        
		        	        
		        <psjg:gridColumn id="MEMO_CODE"   width="50" 	   colType="number"  name="MEMO_CODE"     index="MEMO_CODE"     title=""  sortable="false"  search="false" hidden="true"  />		        				
		        <psjg:gridColumn id="BRANCH"   width="50" 	   colType="number"  name="BRANCH_CODE"     index="BRANCH_CODE"     title="%{getText('Branch_key')}"                 sortable="true"  search="true"  />		        				
				<psjg:gridColumn id="TRX_NO"   width="60"        colType="number"  name="TRX_NO"          index="TRX_NO"          title="%{getText('Trx_No_key')}"                 sortable="true"  search="true"/>
				<psjg:gridColumn id="forCifOrAcc"        colType="text"    name="forCifOrAcc"       index="forCifOrAcc"       title="%{getText('entity_type_key')}"          sortable="false" search="false" />
				<psjg:gridColumn id="CIF_ACCNO"        colType="text"    name="CIF_ACCNO"       index="CIF_ACCNO"       title="%{getText('Memo_Specific_key')}"          sortable="false" search="false" />
		        <psjg:gridColumn id="TYPE"      width="70"  	   colType="text"    name="TYPE"            index="TYPE"            title="%{getText('Memo_Type_key')}"              sortable="true"  search="true" />
				<psjg:gridColumn id="MEMO_DETAILS_ENG"   width="400" colType="text"    name="ENG_COMENT"      index="ENG_COMENT"      title="%{getText('Memo_Details_Eng_key')}"       sortable="true"  search="true" />
				<psjg:gridColumn id="MEMO_DETAILS_ARB"  width="400" colType="text"    name="ARAB_COMENT"     index="ARAB_COMENT"     title="%{getText('Memo_Details_Arb_key')}"       sortable="true"  search="true" />
				<psjg:gridColumn id="COMMON_DESC_ENG"  width="400"  colType="text"    name="COMMON_DESC_ENG" index="COMMON_DESC_ENG" title="%{getText('Common_Description_Eng_key')}" sortable="true"  search="true" />
				<psjg:gridColumn id="COMMON_DESC_ARB"   width="400" colType="text"    name="COMMON_DESC_ARAB" index="COMMON_DESC_ARAB" title="%{getText('Common_Description_Arb_key')}" sortable="true"  search="true"/>
				<psjg:gridColumn id="MEMO_DESC_ENG"   width="400"   colType="text"    name="LONG_DESC_ENG"   index="LONG_DESC_ENG"   title="%{getText('Memo_Description_Eng_key')}"   sortable="true"  search="true" />
				<psjg:gridColumn id="MEMO_DESC_ARB"   width="400"  colType="text"    name="LONG_DESC_ARAB"  index="LONG_DESC_ARAB"  title="%{getText('Memo_Description_Arb_key')}"   sortable="true"  search="true" />
				
				<psjg:gridColumn id="condAutomationCode"   hidden="true"  colType="number"  title="" name="condAutomationCode"  index="condAutomationCode"  sortable="false"  search="false" />
				<psjg:gridColumn id="CIF_NO"   hidden="true"  colType="number"  title="" name="CIF_NO"  index="CIF_NO"  sortable="false"  search="false" />
				<psjg:gridColumn id="ACC_BR"   hidden="true"  colType="number"  title="" name="ACC_BR"  index="ACC_BR"  sortable="false"  search="false" />
				<psjg:gridColumn id="ACC_CY"   hidden="true"  colType="number"  title="" name="ACC_CY"  index="ACC_CY"  sortable="false"  search="false" />
				<psjg:gridColumn id="ACC_GL"   hidden="true"  colType="number"  title="" name="ACC_GL"  index="ACC_GL"  sortable="false"  search="false" />
				<psjg:gridColumn id="ACC_CIF"   hidden="true"  colType="number"  title="" name="ACC_CIF"  index="ACC_CIF"  sortable="false"  search="false" />
				<psjg:gridColumn id="ACC_SL"   hidden="true"  colType="number"  title="" name="ACC_SL"  index="ACC_SL"  sortable="false"  search="false" />
				<psjg:gridColumn id="eventType"   hidden="true"  colType="number"  title="" name="eventType"  index="eventType"  sortable="false"  search="false" />
				
			 
			</psjg:grid>			
	  </div>
	</body>
	<script type="text/javascript">
		$(document).ready(function() {	
		 	$("#memoGrid").jqGrid('navGrid','#memoGrid_pager',{edit:false,add:false,del:false,search:false,refresh: false})
		 						.jqGrid ('navButtonAdd', '#memoGrid_pager',
								    { id:"memoReviewBtn_"+_pageRef,
		 							  caption:"<ps:text name='Review_key' />",
									  buttonicon: "ui-icon-check",
									  title: "<ps:text name='Review_key' />",
								      onClickButton: function() {
								         reviewMemo();
								      }});
		 	    /* NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation */
				if('${reviewBtnEnabled}' != 'true')
				{
					$("#memoReviewBtn_" + _pageRef).addClass('ui-state-disabled');
				}
		 	    /* IIAB120195 - iMAL Memo Alert */
		 	    var memoJson = '<ps:property value="memoJson" escapeHtml="false" escapeJavaScript="true"/>';
				if(memoJson != undefined && memoJson != null && memoJson != '')
				{	
					var $table  = $("#memoGrid");
					var gridUrl = jQuery.contextPath+"/path/memo/MemoGrid_loadMemo" ;
					var json = {'memoJson' : memoJson};
				 	$table.jqGrid('setGridParam', {url : gridUrl, datatype : 'json', postData : json}).trigger("reloadGrid");
				}
		 	    
			});
	</script>	
</html>
