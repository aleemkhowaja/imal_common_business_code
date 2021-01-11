<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %> 

<%
	String pageRefCust1 = (String) request.getAttribute("_pageRef");
	String pageRefCust = pageRefCust1.replace("-","");
	request.setAttribute("pageRefCust",pageRefCust);
%>


<ps:form id="blackListIntSrcFormId_${_pageRef}" namespace="/path/blacklistmanagement" method="post"  enctype="multipart/form-data" >
<ps:hidden id="confirmMsg_${_pageRef}" name="blackListIntSourceCO.confirmMsg" />
<ps:hidden id="asSourceHidd_${_pageRef}" name="_asSource" />
<ps:hidden id="fileHidd_${_pageRef}" />

<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
<table width="100%">
	<tr>
		<td>

	<psj:tabbedpanel id="blckLstIntSrcMaintTabs_${pageRefCust}" sortable="true"
		 >
	
			<psj:tab id="MatchedCIFListTabId_${pageRefCust}" target="MatchedCIFListTab_${_pageRef}" key="matched_cif_key"/>
			<psj:tab id="WhiteListTabId_${pageRefCust}" target="WhiteListTab_${_pageRef}" key="white_list_key"/>
			<psj:tab id="dynUploadMaintTabId_${pageRefCust}" target="uploadDynamicTab_${_pageRef}" key="Upload_key" />
			<ps:if test="CBTab">
				<psj:tab id="CBMaintTabId_${_pageRef}" target="CBMaintTab_${_pageRef}" key="CB_key" />
			</ps:if>
			
			<div id="MatchedCIFListTab_${_pageRef}">
				<%@include file="BlackListMatchedCIFList.jsp"%>
			</div>
			<div id="WhiteListTab_${_pageRef}">
				<%@include file="BlackListWhiteList.jsp"%>
			</div>
			<div id="uploadDynamicTab_${_pageRef}" >
				<%@include file="BlackListIntSourceDynUploadMaint.jsp"%>
			</div>
			<ps:if test="CBTab">
				<div id="CBMaintTab_${_pageRef}">
					<%@include file="BlackListIntSourceCBMaint.jsp"%>
				</div>
			</ps:if>
			
	</psj:tabbedpanel>

		</td>
	</tr>
</table>

</ps:form>
	
<script>
$.struts2_jquery.require("BlackListIntSourceUploadMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/blacklistmanagement/blacklistintsource/");

var _matched_cif_key="<ps:text name='matched_cif_key' />";
var _white_list_key="<ps:text name='white_list_key' />";
var _whiteListed_key = "<ps:text name='whiteListed_key' />";
var _suspicious_key  = "<ps:text name='suspicious_key' />";
var _blackListed_key = "<ps:text name='blackListed_key' />";



</script>