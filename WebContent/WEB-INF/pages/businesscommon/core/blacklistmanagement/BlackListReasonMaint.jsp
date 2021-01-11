<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %> 

<script>   
$.struts2_jquery.require("BlackListLogMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/blacklistmanagement/");
</script>


<ps:url id="urlBlackListReasonGrid" action="BlackListLogMaintAction_loadBlackListReasonPage"	namespace="/path/blackList" escapeAmp="false">
<ps:param name="blackListLogSC.blckListLogLineNo" value="blackListLogSC.blckListLogLineNo" />
</ps:url>

<div>
			<psjg:grid  id="blackListReasonGrid_Id_${_pageRef}"
				caption=" " rownumbers="true"
				href="%{urlBlackListReasonGrid}" dataType="json"
				hiddengrid="false" pager="true" filter="false" gridModel="gridModel"
				rowNum="5" rowList="5,10,15,20" viewrecords="true" navigator="true"
				height="115" altRows="true" navigatorRefresh="false"
				pagerButtons="false" navigatorEdit="false" navigatorSearch="false"
				shrinkToFit="false" autowidth="false"
				navigatorAdd="false"
				navigatorDelete="false"
				editurl="abc" editinline="true" footerrow="true"
				>
				<psjg:gridColumn id="CRITERIA_VALUE"  name="ctsBlckListReasonLogVO.CRITERIA_VALUE"  index="CRITERIA_VALUE"  title="%{getText('criteria_value_key')}" colType="text"  
							 sortable="true" search="true" 	/>
		          
		        
			</psjg:grid>
</div>

