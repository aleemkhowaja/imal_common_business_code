<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %><html>

<script type="text/javascript" 	src="${pageContext.request.contextPath}/businesscommon/js/memo/MemoDtls.js">
 </script>
	
 
	
<body>
  <div>
   <ps:hidden id="iv_crud_${_pageRef}" name="iv_crud"/>	
	<ps:url id="urlMemoDetailsGrid" action="MemoGrid_loadMemoDtlsGrid?_pageRef=${_pageRef}&iv_crud=${iv_crud}"	namespace="/path/memo" escapeAmp="false"></ps:url>			 
	<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />					  
	<psjg:grid id="memoDetailsGrid_Id_${_pageRef}"							
		caption=" "														 				 
		href="%{urlMemoDetailsGrid}" dataType="json"  
		hiddengrid='%{iv_crud== "R"}' pager="true" filter="true"
		sortable="true"
		gridModel="gridModel" rowNum="5" rowList="5,10,15,20"
		viewrecords="true" navigator="true"   altRows="true"
		navigatorRefresh="false" navigatorSearch="true" addfunc ="memoDtls_onAddClicked"
    	navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
		navigatorAdd="false" navigatorDelete="false" navigatorEdit="false" 
		shrinkToFit="false"    ondblclick="onMemoDtlsGridDbClick();"  
		  sortname="TRX_NO" sortorder="desc"    height="110"
		   >
		<psjg:gridColumn id="TRX_NO" colType="number" name="TRX_NO" 
			index="TRX_NO" title="%{getText('Trx_No_key')}"  	
			editable="false" sortable="true" search="true"  
			
			/>
		<psjg:gridColumn id="MEMO_CODE" colType="number" name="MEMO_CODE"
			index="MEMO_CODE"
			title="%{getText('Memo_Code_key')}"
			editable="false" sortable="true" search="true" />
		<psjg:gridColumn id="ENG_COMENT" colType="text"
			name="ENG_COMENT" index="ENG_COMENT"
			title="%{getText('Eng_Comment_key')}"
			editable="false" sortable="true" search="true" />
		<psjg:gridColumn id="ARAB_COMENT" colType="text" name="ARAB_COMENT"
			index="ARAB_COMENT" title="%{getText('Arab_Comment_key')}"
			editable="false" sortable="true" search="true"								
			/>					
		<psjg:gridColumn id="CIF_NO" colType="number" name="CIF_NO"
			index="CIF_NO" title="%{getText('CIF_No_key')}"
			editable="false" sortable="true" search="true"
			
			/>
		<psjg:gridColumn id="ACC_BR" colType="number" name="ACC_BR"
			index="ACC_BR"
			title="%{getText('Acc_Br_key')}"
			editable="false" sortable="true" search="true" />
		<psjg:gridColumn id="ACC_CY" colType="number"
			name="ACC_CY" index="ACC_CY"
			title="%{getText('Acc_Cy_key')}"
			editable="false" sortable="true" search="true" />
		<psjg:gridColumn id="ACC_GL" colType="number"
			name="ACC_GL" index="ACC_GL"
			title="%{getText('Acc_GL_key')}"
			editable="false" sortable="true" search="true" value="" />
		<psjg:gridColumn id="ACC_CIF" colType="number" name="ACC_CIF"
			index="ACC_CIF" title="%{getText('Acc_CIF_key')}"
			editable="false" sortable="true" search="true"								
			/>
		<psjg:gridColumn id="ACC_SL" colType="number" name="ACC_SL"
			index="ACC_SL" title="%{getText('Acc_SL_key')}"
			editable="false" sortable="true" search="true"
			
			/>
		<psjg:gridColumn id="FROM_DATE" colType="date" name="FROM_DATE"
			index="FROM_DATE"
			title="%{getText('From_date_key')}"
			editable="false" sortable="true" search="true" />
		<psjg:gridColumn id="DATE_TO" colType="date"
			name="DATE_TO" index="DATE_TO"
			title="%{getText('To_Date_key')}"
			editable="false" sortable="true" search="true" />
		<psjg:gridColumn id="LAST_REVIEW_NO" colType="number"
			name="LAST_REVIEW_NO" index="LAST_REVIEW_NO"
			title="%{getText('Last_Review_No_key')}"
			editable="false" sortable="true" search="true" value="" />	 
		<psjg:gridColumn id="STATUS" colType="text"
			name="STATUS" index="STATUS"
			title="%{getText('Status_key')}"
			editable="false" sortable="true" search="true" value="" />	 
	 </psjg:grid>
		 <div id="memoDtlsMaint_id_${_pageRef}" style="width:100%;" >
		   <ps:if test='iv_crud == "R"'>   
			<%@include file="MemoDtlsMaint.jsp"%>
			</ps:if>
		</div>
  </div>	
 </body>	
<script  type="text/javascript"> 
$("#gview_memoDetailsGrid_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide()
 

</script>
 	
 
 
</html>
