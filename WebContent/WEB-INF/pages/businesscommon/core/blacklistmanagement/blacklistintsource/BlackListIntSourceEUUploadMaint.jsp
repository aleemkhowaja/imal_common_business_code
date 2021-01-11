<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<table width="100%">
	<tr>
		<td></td>
		<td><h2><u><ps:text name="upload_correct_EU_Blacklist_file_key"></ps:text></u></h2></td>
	</tr>
	<tr>
		<td></td>
		<td>
			<ol>
				<li><ps:text name="open_the_key"/>
					<a href="<ps:property value="pthCtrl1VO.EU_WEBSITE" />" target="_new"  >
						<ps:text name="EU_website_key"/>
					</a>
				</li>
				<li><ps:text name="save_SDN_file_key"/></li>
				<li><ps:text name="browse_and_process_key"/></li>
			</ol>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<ps:text name="files_must_saved_under_same_key"></ps:text>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<ps:label key="File_Location_key" />
			&nbsp;&nbsp;&nbsp;&nbsp;
			<ps:file id="uploadEUScript" name="fileNameEU" onchange="validateFileName(this);fillAsSource('E','uploadEUScript');"  ></ps:file>		
		</td>
	</tr>
</table>

<ptt:toolBar id="blackListUpload_btnToolbarEU_${_pageRef}">
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
$.struts2_jquery.require("DynFileManagement.js", null, jQuery.contextPath + "/common/js/dynfilemanagement/");
</script>