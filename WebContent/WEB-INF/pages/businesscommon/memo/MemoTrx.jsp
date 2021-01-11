<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<html> 

 
	<body> 
	<div id="memoGridDiv_id_${_pageRef}"  style="width: 690px;">	
			<ps:hidden id="__memo_compCode" name="%{memoSC.compCode}"/>
			
			<ps:url id="urlMemoGrid" action="MemoGrid_loadMemoTrx"  namespace="/path/memo"  escapeAmp="false" >					
					 <ps:param name="forAccOrCif" value="%{memoSC.forAccOrCif}"  ></ps:param>
					 <ps:param name="accCIF" value="%{memoSC.accCIF}"></ps:param>
					 <ps:param name="accSL" value="%{memoSC.accSL}"></ps:param>
					 <ps:param name="accGL" value="%{memoSC.accGL}"></ps:param>
					 <ps:param name="accCY" value="%{memoSC.accCY}"></ps:param>					 
					 <ps:param name="accBR" value="%{memoSC.accBR}"></ps:param>
					 <ps:param name="trxType" value="%{memoSC.trxType}"></ps:param>
					 <ps:param name="cifNo" value="%{memoSC.cifNo}"></ps:param>
					 <ps:param name="appType" value="%{memoSC.appType}"></ps:param>
					 <ps:param name="compCode" value="%{memoSC.compCode}"></ps:param>
					 <ps:param name="memoCode" value="%{memoSC.memoCode}"></ps:param>
			</ps:url>		
				 
		    <psjg:grid
		    	id="memoGridTrxTbl_Id"    	
		    	caption="%{getText('Memo_Details_key')}"		    	
    	        href="%{urlMemoGrid}" 
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
		        multiselect="false"
		         
		        hidegrid="false"		        
		        autowidth="false"	             
		       	shrinkToFit="false"
		       	width="690"
		       	height="110"  
		        >	
		        
			    <psjg:gridColumn id="COMP_CODE" 	hidden="true"   colType="number"  name="ctsmemoDETVO.COMP_CODE"        index="COMP_CODE"       title="%{getText('Company_key')}"         sortable="true"  search="true"  />
		        <psjg:gridColumn id="BRANCH"   		hidden="true"  	colType="number"  name="ctsmemoDETVO.BRANCH_CODE"      index="BRANCH_CODE"     title="%{getText('Branch_key')}"          sortable="true"  search="true"  />		        				
				<psjg:gridColumn id="TRX_NO"    	hidden="true"   colType="number"  name="ctsmemoDETVO.TRX_NO"           index="TRX_NO"          title="%{getText('Trx_No_key')}"          sortable="true"  search="true"/>
		        <psjg:gridColumn id="LAST_REVIEW_NO"  hidden="true"	colType="number"  name="ctsmemoDETVO.LAST_REVIEW_NO"   index="LAST_REVIEW_NO"  title="%{getText('Last_Review_No_key')}"  sortable="true"  search="true"  />		        				
				<psjg:gridColumn id="STATUS"    	hidden="true"	colType="text"    name="ctsmemoDETVO.STATUS"     	   index="STATUS"          title="%{getText('Status_key')}"          sortable="true"  search="true"  />		        				
				<psjg:gridColumn id="CIF_ROLE"  	hidden="true"   colType="number"  name="ctsmemoDETVO.CIF_ROLE"         index="CIF_ROLE"        title="%{getText('Cif_Role_key')}"        sortable="true"  search="true"/>
				<psjg:gridColumn id="TRX_TYPE"  	hidden="true"   colType="number"  name="ctsmemoDETVO.TRX_TYPE"         index="TRX_TYPE"        title="%{getText('Trx_Type_key')}"        sortable="true"  search="true"/>
				<psjg:gridColumn id="TRX_STATUS"    hidden="true"   colType="text"    name="ctsmemoDETVO.TRX_STATUS"       index="TRX_STATUS"      title="%{getText('Trx_Status_key')}"      sortable="true"  search="true"/>
				<psjg:gridColumn id="TRX_LINE_NO"   hidden="true"   colType="number"  name="ctsmemoDETVO.TRX_LINE_NO"      index="TRX_LINE_NO"     title="%{getText('Trx_line_no_key')}"     sortable="true"  search="true"/>
				<psjg:gridColumn id="YIELD"   	    hidden="true" 	colType="text" 	  name="ctsmemoDETVO.YIELD"            index="YIELD"           title="%{getText('Yield_key')}"           sortable="true"  search="true"/>
				<psjg:gridColumn id="VALUE_DATE"    hidden="true"   colType="date" 	  name="ctsmemoDETVO.VALUE_DATE"       index="VALUE_DATE"      title="%{getText('Value_date_key')}"      sortable="true"  search="true"/>
				<psjg:gridColumn id="MATURITY_DATE" hidden="true"   colType="date"    name="ctsmemoDETVO.MATURITY_DATE"    index="MATURITY_DATE"   title="%{getText('Maturity_date_key')}"   sortable="true"  search="true"/>
				
				
				<psjg:gridColumn id="MEMO_CODE"    width="70"  colType="number"  name="ctsmemoDETVO.MEMO_CODE"     index="MEMO_CODE"    title="%{getText('Memo_Code_key')}"         sortable="true"  search="true" />
		        <psjg:gridColumn id="ENG_COMENT"   width="400" colType="text"    name="ctsmemoDETVO.ENG_COMENT"    index="ENG_COMENT"   title="%{getText('Memo_Details_Eng_key')}"  sortable="true"  search="true" />
				<psjg:gridColumn id="ARAB_COMENT"  width="400" colType="text"    name="ctsmemoDETVO.ARAB_COMENT"   index="ARAB_COMENT"  title="%{getText('Memo_Details_Arb_key')}"  sortable="true"  search="true" />
				<psjg:gridColumn id="CIF_NO"       width="100" colType="number"  name="ctsmemoDETVO.CIF_NO"		   index="CIF_NO"		title="%{getText('CIF_No_key')}"        	leadZeros="10"   nbFormat="##########" sortable="false" search="true"/>
				<psjg:gridColumn id="CURRENCY"     width="60"  colType="number"   name="ctsmemoDETVO.CURRENCY"      index="CURRENCY"  	title="%{getText('Currency_key')}" 			 sortable="true"  search="true"/>
				<psjg:gridColumn id="AMOUNT"       width="60"  colType="number"  name="ctsmemoDETVO.AMOUNT"        index="AMOUNT"       title="%{getText('Amount_key')}"            sortable="true"  search="true"/>
				<psjg:gridColumn id="PROD_CLASS"   width="80"  colType="number"  name="ctsmemoDETVO.PROD_CLASS"    index="PROD_CLASS"   title="%{getText('Product_Class_key')}" 	nbFormat="####"	 sortable="true"  search="true"/>
				<psjg:gridColumn id="TRX_REF"      width="60"  colType="number"  name="ctsmemoDETVO.TRX_REF"       index="TRX_REF" 		title="%{getText('Trx_Ref_key')}" 			nbFormat="##########"  sortable="true"  search="true"/>
				<psjg:gridColumn id="APP_NAME"     width="60"  colType="text"    name="ctsmemoDETVO.APP_NAME"      index="APP_NAME"     title="%{getText('APPLICATION_NAME_key')}"  sortable="true"  search="true"/>
 				
			 
			</psjg:grid>			
	  
	 
	    <table align="center">
	    <tr>
		    <td>
		     <psj:submit button="true" onclick="onOkMemo()" freezeOnSubmit="true">
		    	<ps:text name="Ok_key"></ps:text>
		     </psj:submit>
		    </td>
		    
	    	<td>
		        <psj:submit button="true" onclick="onCancelMemo()" freezeOnSubmit="true">
		    		<ps:text name="cancel_key"></ps:text>
		   		</psj:submit>
		    </td>
	    </tr>
	    </table>
	    </div>
	</body>
	<script type="text/javascript">
		$(document).ready(function() 
			{
				$.struts2_jquery.require("MemoTrx.js" ,null,jQuery.contextPath+"/businesscommon/js/memo/");
		 		$("#memoGridTrxTbl_Id").jqGrid('navGrid','#memoGrid_pager',{edit:false,add:false,del:false,search:false,refresh: false})
		 	});
  </script>	
</html>
