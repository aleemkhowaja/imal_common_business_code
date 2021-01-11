<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %> 

<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />

<script>   
$.struts2_jquery.require("BlackListLogMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/blacklistmanagement/");
</script>

<script type="text/javascript">

var blackListReason_trans_key = "<ps:text name='blacklistreason_key' />";
var blackListMatchPerc_trans_key = "<ps:text name='nameMatchPerc_key' />";
var details_key = "<ps:text name='details_key' />";
var Black_List_Management_key = "<ps:text name='Black_List_Management_key' />";

</script>

<ps:form id="blackListLogMaintForm_${_pageRef}" useHiddenProps="true" cssStyle="width:100%;">
<ps:url id="urlBlackListLogGrid" action="BlackListLogMaintAction_loadBlackListLogGrid"	namespace="/path/blackList" escapeAmp="false">
<ps:hidden id="blackListLogId_gridUpdate_${_pageRef}" name="blackListLogId_gridUpdate" />

</ps:url>

<div id="blackListLog_${_pageRef}" style="widhth:100%;">
			<psjg:grid id="blackListLogGridTbl_Id_${_pageRef}"
				caption=" " rownumbers="true"
				href="%{urlBlackListLogGrid}" dataType="json"
				hiddengrid="false" pager="true" filter="false" gridModel="gridModel"
				rowNum="5" rowList="5,10,15,20" viewrecords="true" navigator="true"
				height="115" altRows="true" 
				pagerButtons="false" navigatorEdit="false" navigatorSearch="false"
				shrinkToFit="false" autowidth="true"
				navigatorAdd="false"
				navigatorRefresh="true"
				navigatorDelete="false"
				editurl="abc" editinline="true" footerrow="true"
				>
				
				<psjg:gridColumn id="LINE_NO"  name="ctsBlackListLogVO.LINE_NO"  index="LINE_NO"  title="%{getText('line_NO_key')}" colType="text"  
				             sortable="true" search="true" hidden = "true" 	/>
				<psjg:gridColumn id="ENTITY_TYPE"  name="ctsBlackListLogVO.ENTITY_TYPE"  title="%{getText('entity_type_key')}" index="ENTITY_TYPE"  colType="text"  
							 sortable="true" search="true"  hidden="true"	/>
							 
				<psjg:gridColumn id="entityTypeDesc"  name="entityTypeDesc"  index="entityTypeDesc"  title="%{getText('entity_type_key')}" colType="text"  
							 sortable="true" search="true" 	/>
  
		        <psjg:gridColumn id="ENTITY_NO" colType="number"
					name="ctsBlackListLogVO.ENTITY_NO" index="ENTITY_NO"
					title="%{getText('Entity_Code_key')}" editable="false"
					sortable="false" search="true"/>
				
				<psjg:gridColumn id="blackListSourceCode" colType="number"
					name="blackListSourceCode" index="blackListSourceCode"
					title="%{getText('Source_Code_key')}" editable="false"
					sortable="false" search="true"/>
					
				<psjg:gridColumn id="blackListSourceName" colType="text"
					name="blackListSourceName" index="blackListSourceName"
					title="%{getText('bl_source_name_key')}" editable="false"
					sortable="false" search="true"/>
				
				<psjg:gridColumn id="blackListCode" colType="number"
					name="blackListCode" index="blackListCode"
					title="%{getText('BL_Code_key')}" editable="false"
					sortable="false" search="true"/>
					
				<psjg:gridColumn id="blackListName" colType="text"
					name="blackListName" index="blackListName"
					title="%{getText('BL_Name_key')}" editable="false"
					sortable="false" search="true"/>	
					
				<psjg:gridColumn id="nationality" colType="text"
					name="nationality" index="nationality"
					title="%{getText('Nationality_key')}" editable="false"
					sortable="false" search="true"/>		
				
				<psjg:gridColumn id="passportNo" colType="text"
					name="passportNo" index="passportNo"
					title="%{getText('Passport_No_key')}" editable="false"
					sortable="false" search="true"/>
					
				<psjg:gridColumn id="dateOfBirth"  name="dateOfBirth"  index="dateOfBirth"  title="%{getText('DOB_key')}" colType="date"  
				           formatter="date" formatoptions="{srcformat:'Y-m-d H:i:s.u',newformat:'d/m/Y H:i:s:u' }"/>	
				
				<psjg:gridColumn id="cifNameArab" colType="text"
					name="cifNameArab" index="cifNameArab"
					title="%{getText('Long_Description_key')}" editable="false"
					sortable="false" search="true"/>
					
				<psjg:gridColumn id="dateTurnedBlackList"  name="dateTurnedBlackList"  index="dateTurnedBlackList"  title="%{getText('turned_bl_date_key')}" colType="date"  
				           formatter="date" formatoptions="{srcformat:'Y-m-d H:i:s.u',newformat:'d/m/Y H:i:s:u' }"/>	
				           
				<psjg:gridColumn id="documentNbr" colType="number"
					name="documentNbr" index="documentNbr"
					title="%{getText('Document_Nbr._key')}" editable="false"
					sortable="false" search="true"/>           
				
				<psjg:gridColumn id="blacklistDetails_${_pageRef}" colType="text"
					name="blacklistDetails" index="blacklistDetails" title="%{getText('details_key')}"
					editable="false" sortable="false" search="false"
					formatter="blacklistLog_detailsBtn" />
				
				<psjg:gridColumn id="blacklistReason_${_pageRef}" colType="text"
					name="blacklistReason" index="blacklistReason" title="%{getText('black_list_reason_key')}"
					editable="false" sortable="false" search="false"
					formatter="blacklistLog_reasonBtn" />
					
				<psjg:gridColumn id="nameMatchPerc_${_pageRef}" colType="text"
					name="nameMatchPerc" index="nameMatchPerc" title="%{getText('name_match_perc_key')}"
					editable="false" sortable="false" search="false"
					formatter="blacklistLog_matchPercBtn" />
					
				<psjg:gridColumn id="CRITERIA_MATCH_PERCENT"  name="ctsBlackListLogVO.CRITERIA_MATCH_PERCENT"  index="CRITERIA_MATCH_PERCENT"  title="%{getText('criteria_match_perc_key')}" colType="text"  
				 sortable="true" search="true" 	/>			               
				
					<psjg:gridColumn id="ACTION_TYPE_${_pageRef}" name="ctsBlackListLogVO.ACTION_TYPE" index="ACTION_TYPE" title="%{getText('action_type_key')}"
					colType="select" editable="true" edittype="select" formatter="select"
					editoptions="{value:function() {  return loadCombo('${pageContext.request.contextPath}/path/blackList/BlackListLogMaintAction_loadBlackListLogActionList','blackListLogActionList', 'code', 'descValue');}
					,style:'width:100%'}" search="false" sortable="false" hidden="${isAML}" />
				
				<psjg:gridColumn id="REMARK_VALUE"  name="ctsBlackListLogVO.REMARK_VALUE"  index="REMARK_VALUE"  title="%{getText('remark_value_key')}" colType="text"  
				             sortable="true" search="true" editable = "true" editoptions="{ maxlength:'16' }" hidden="${isAML}"	/>
				
				<psjg:gridColumn id="DATE_UPDATED"  name="ctsBlackListLogVO.DATE_UPDATED"  index="DATE_UPDATED"  title="%{getText('date_updated35')}" colType="date"  
				           formatter="date" formatoptions="{srcformat:'Y-m-d H:i:s.u',newformat:'d/m/Y H:i:s:u' }"  hidden="false"  	/>
				           
				<psjg:gridColumn id="SENT_BY_USER_${_pageRef}"  name="ctsBlackListLogVO.SENT_BY_USER"  index="SENT_BY_USER"  title="%{getText('sentByUser')}" colType="text"  
				sortable="true" search="true" editable = "false" editoptions="{ maxlength:'16' }" 	/>
				             
				<psjg:gridColumn id="RECEIVED_BRANCH"  name="ctsBlackListLogVO.RECEIVED_BRANCH"  index="RECEIVED_BRANCH"  title="%{getText('receivedbr_key')}" colType="text"  
				sortable="true" search="true" editable = "false" editoptions="{ maxlength:'16' }" 	/>           
				</psjg:grid>
				


	</div>

<ps:if test='%{isAML == "false"}'>
	<psj:submit id="processBlackListLog_${_pageRef}" button="true" onclick="processBlackListLog()"> <ps:text name="%{getText('process_key')}"></ps:text> </psj:submit>
</ps:if>

</ps:form>
