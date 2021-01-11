<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<ps:hidden id="fileStruct_${_pageRef}" name="blackListIntSourceCO.dfDataFileVO.STRUCT_CODE" />
<ps:hidden id="fileLink_${_pageRef}" name="blackListIntSourceCO.dfDataFileVO.LINK" />
<ps:hidden id="fileLinkLabel_${_pageRef}" name="blackListIntSourceCO.dfDataFileVO.LINK_LABEL" />
<ps:hidden id="fileType_${_pageRef}" name="blackListIntSourceCO.dfDataFileVO.TYPE" />
<ps:hidden id="fileHeader_${_pageRef}" name="blackListIntSourceCO.dfDataFileVO.HEADER" />
<ps:hidden id="fileDetails_${_pageRef}" name="blackListIntSourceCO.dfDataFileVO.DETAILS" />

<table width="100%">
	
	<tr>
	<td width="7%"></td>
	<td width="13%"></td>
	<td width="25%"></td>
	<td width="55%"></td>
	</tr>
	
	<tr>
		<td><ps:label key="File_Code_key"/></td>
	    <td>
		    <psj:livesearch  name="blackListIntSourceCO.dfDataFileVO.FILE_CODE"				                      
				              id  ="enqFileCode"					                      
				              actionName="${pageContext.request.contextPath}/pathdesktop/BlackListSourceUploadLookup_constructLookup" 
				              searchElement="dfDataFileVO.FILE_CODE"
				              paramList=""  
				              parameter="blackListIntSourceSC.fileCode:lookuptxt_enqFileCode"
								dependencySrc="${pageContext.request.contextPath}/path/blacklistmanagement/BlackListIntSourceUploadMaint_depLookupFileName"
								dependency="lookuptxt_enqFileCode:blackListIntSourceCO.dfDataFileVO.FILE_CODE,fileDesc_${_pageRef}:blackListIntSourceCO.dfDataFileVO.FILE_DESC,
								fileStruct_${_pageRef}:blackListIntSourceCO.dfDataFileVO.STRUCT_CODE,fileLink_${_pageRef}:blackListIntSourceCO.dfDataFileVO.LINK,
								fileLinkLabel_${_pageRef}:blackListIntSourceCO.dfDataFileVO.LINK_LABEL,fileType_${_pageRef}:blackListIntSourceCO.dfDataFileVO.TYPE,
								fileHeader_${_pageRef}:blackListIntSourceCO.dfDataFileVO.HEADER,fileDetails_${_pageRef}:blackListIntSourceCO.dfDataFileVO.DETAILS"	 
								afterDepEvent="fillData();"  
				               >
			 </psj:livesearch>
		</td>
	    <td><ps:textfield id="fileDesc_${_pageRef}"
			name="blackListIntSourceCO.dfDataFileVO.FILE_DESC" readonly="true" tabindex="-1" ></ps:textfield></td>
	</tr>
	
	<tr>
	<td colspan="4">
		<div id="headerBlackList"></div>
	</td>
	</tr>
	
	<tr>
	<td colspan="4">
		<div id="linkBlackList"></div>
	</td>
	</tr>
	
	<tr>
		<td colspan="4">
			<ps:label key="File_Location_key" />:
			&nbsp;&nbsp;&nbsp;&nbsp;
			<ps:file id="uploadScriptDyn" name="fileNameDyn" onchange="validateExt();validateFileName(this);"></ps:file>
		</td>
	</tr>
</table>

<ptt:toolBar id="blackListUpload_btnToolbar_${_pageRef}">
<% /* Commented based on Grace request 20/09/2013 
	<psj:submit button="true" cssClass="fg-button ui-state-default  ui-corner-all fg-button-icon-left">
		<ps:label key='send_alert_key' />
	</psj:submit>
*/ %>
	<psj:submit button="true" cssClass="fg-button ui-state-default  ui-corner-all fg-button-icon-left"
			onclick="uploadBlackListFile(false)" >
		<ps:label key="Process_key" />
	</psj:submit>
	
</ptt:toolBar>

<script type="text/javascript">
var before_link_label_key = "<ps:text name='open_the_key'/>";
var fileNotAllowedKey = "<ps:text name='allowed_file_extension_key'/>";
$.struts2_jquery.require("DynFileManagement.js", null, jQuery.contextPath + "/common/js/dynfilemanagement/");
</script>