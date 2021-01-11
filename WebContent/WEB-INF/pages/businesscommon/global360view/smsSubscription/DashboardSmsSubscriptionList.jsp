<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:url id="urlSmsSubscriptionGrid_${_pageRef}" 
        namespace="/path/globalview" escapeAmp="false"
	    action="dashboardSmsSubscriptionListAction">
   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
</ps:url>
  <psjg:grid id="smsSubscriptionListGridTbl_Id_${_pageRef}" 
		caption="%{getText('sms_key')}"
        altRows="true"
    	dataType="json" 
		filter="true"
    	gridModel="gridModel" 
    	href="%{urlSmsSubscriptionGrid_${_pageRef}}"
        navigator="true" 
        navigatorAdd="false"
        navigatorDelete="false"
        navigatorEdit="false"
        navigatorRefresh="false"
        navigatorSearch="true" 
        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
    	pager="true"
    	rowNum="10" 
    	rowList="5,10,15,20"
        shrinkToFit="false"
        sortable="true"
        viewrecords="true">	
    <psjg:gridColumn id="HIDDEN_CODE" 		  name="CODE" colType="number" index="CODE" title="%{getText('code_key')}"
    				 editable="false" sortable="true" search="true" hidden="true" />      
    <psjg:gridColumn id="BRANCH_CODE" name="BRANCH_CODE" colType="number" index="BRANCH_CODE" title="%{getText('branch_code_key')}"
    				 editable="false" sortable="true" search="true" />
    				 
    <psjg:gridColumn id="CODE" 		  name="CODE" colType="number" index="CODE" title="%{getText('code_key')}"
    				 editable="false" sortable="true" search="true" formatter="dashboard_smsBtn" />
    				 
    <psjg:gridColumn id="ACC_BR" 	  name="ACC_BR" colType="number" index="ACC_BR" title="%{getText('Acc_Br_key')}"
    				 editable="false" sortable="true" search="true" />
    				 
    <psjg:gridColumn id="ACC_CY" 	  name="ACC_CY" colType="number" index="ACC_CY" title="%{getText('Acc_Cy_key')}"
    				 editable="false" sortable="true" search="true" />
    				 
    <psjg:gridColumn id="ACC_GL" 	  name="ACC_GL" colType="number" index="ACC_GL" title="%{getText('Acc_GL_key')}"
    				 editable="false" sortable="true" search="true" />
    				 
    <psjg:gridColumn id="ACC_CIF" 	  name="ACC_CIF" colType="number" index="ACC_CIF" title="%{getText('Acc_CIF_key')}"
    				 editable="false" sortable="true" search="true" />
    				 
    <psjg:gridColumn id="ACC_SL" 	  name="ACC_SL" colType="number" index="ACC_SL" title="%{getText('Acc_SL_key')}"
    				 editable="false" sortable="true" search="true" />

    <psjg:gridColumn id="MOBILE_NUM"   name="MOBILE_NUM" colType="text"   index="MOBILE_NUM" title="%{getText('Mobile_No._key')}"
    				 editable="false" sortable="true" search="true" hidden="false"/>
    				 
    <psjg:gridColumn id="smsSubStatus" name="smsSubStatus" colType="text"   index="smsSubStatus" title="%{getText('Status_key')}"
    				 editable="false" sortable="true" search="true" />

    <psjg:gridColumn id="STATUS"       name="STATUS" colType="text"   index="STATUS" title="%{getText('Status_key')}"
    				 editable="false" sortable="true" search="true" hidden="true"/>
     	
</psjg:grid>

 <script type="text/javascript">
  //Setting multi header columns

						
 </script>
