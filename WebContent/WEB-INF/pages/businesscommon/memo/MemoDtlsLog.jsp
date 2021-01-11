<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %> 
<html>  
	<body> 			
		<ps:url id="urlMemoLogGrid" action="MemoGrid_loadMemoLogData"  namespace="/path/memo"  escapeAmp="false" />
		    <psjg:grid
		    	id="memoLogGrid"    	
		    	caption="%{getText('Memo_Log_key')}"		    	
    	        href="%{urlMemoLogGrid}" 
                dataType="json"                
		    	pager="true"		    					
		    	gridModel="gridModel" 
		    	rowNum="20" 
		    	rowList="5,10,15,20"
		        viewrecords="true" 
		        navigator="true" 		       
		        altRows="true"		        
		        sortable="true"	
		        filter="true"		      
		        hidegrid="false"
		       	shrinkToFit="false"
		       	navigatorSearch="false"
				navigatorAdd="false"
				navigatorDelete="false" 
				navigatorEdit="false"
				navigatorRefresh="false" 	       	
		       	>	        
	     
	     		<psjg:gridColumn id="USER_ID" 			colType="text"    	name="ctsMemoLogVO.USER_ID"   	index="USER_ID"      	title="%{getText('User_Id_key')}"       							sortable="true"  	search="true" 	/>
		        <psjg:gridColumn id="MEMO_DATE"         colType="date"  	name="ctsMemoLogVO.MEMO_DATE"   index="MEMO_DATE"     	title="%{getText('Date_key')}"                 						sortable="true"  	search="true" 	/>		        				
				<psjg:gridColumn id="CODE"        	   	colType="text"    	name="ctsMemoVO.CODE"           index="CODE"            title="%{getText('Memo_Type_key')}"             					sortable="true"  	search="true" 	/>
				<psjg:gridColumn id="BRIEF_DESC_ENG"    colType="text"    	name="ctsMemoVO.BRIEF_DESC_ENG" index="BRIEF_DESC_ENG"  title="%{getText('Memo_Description_Eng_key')}"  					sortable="true"  	search="true" 	/>
		        <psjg:gridColumn id="CIF_NO"        	colType="text"		name="ctsMemoLogVO.CIF_NO"      index="CIF_NO"          title="%{getText('CIF_key')}"              							sortable="true"  	search="true" 	/>
		        <psjg:gridColumn id="ACC_BR" 			colType="number" 	name="ctsMemoLogVO.ACC_BR"		index="ACC_BR"			title="%{getText('Acc_Br_key')}"				editable="false" 	sortable="true" 	search="true" 	/>
				<psjg:gridColumn id="ACC_CY" 			colType="number"	name="ctsMemoLogVO.ACC_CY" 		index="ACC_CY"			title="%{getText('Acc_Cy_key')}"				editable="false" 	sortable="true" 	search="true" 	/>
				<psjg:gridColumn id="accNo" 			colType="number"	name="accNo" 					index="accNo"			title="%{getText('Acc_key')}"					editable="false" 	sortable="false" 	search="false" 	/>
				<psjg:gridColumn id="ACC_GL" 			colType="number"	name="ctsMemoLogVO.ACC_GL" 		index="ACC_GL"			title="%{getText('Acc_GL_key')}"				editable="false" 	sortable="true" 	search="true" 	value="" />
				<psjg:gridColumn id="ACC_CIF" 			colType="number" 	name="ctsMemoLogVO.ACC_CIF"		index="ACC_CIF" 		title="%{getText('Acc_CIF_key')}"				editable="false" 	sortable="true" 	search="true"	/>
				<psjg:gridColumn id="ACC_SL" 			colType="number" 	name="ctsMemoLogVO.ACC_SL"		index="ACC_SL" 			title="%{getText('Acc_SL_key')}"				editable="false" 	sortable="true" 	search="true"	/>		     
				<psjg:gridColumn id="ENG_COMENT" 		colType="text"   	name="ctsMemoDetVO.ENG_COMENT"  index="ENG_COMENT"      title="%{getText('Memo_Message_key')}"       						sortable="true"  	search="true" 	/>
	 
			</psjg:grid>	  
	</body>
	 
</html>
