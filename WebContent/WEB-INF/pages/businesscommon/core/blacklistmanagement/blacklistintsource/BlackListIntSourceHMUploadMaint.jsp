<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<table width="100%">
	<tr>
		<td></td>
		<td><h2><u><ps:text name="upload_correct_hm_blacklist_file_key"></ps:text></u></h2></td>
	</tr>
	<tr>
		<td></td>
		<td>
			<ol>
				<li><ps:text name="open_the_key"/>
					<a href="<ps:property value="pthCtrl1VO.HM_WEBSITE" />" target="_new"  >
						<ps:text name="hm_website_key"/>
					</a>
				</li>
				<li><ps:text name="click_excel_format_key"/></li>
				<li><ps:text name="save_excel_file_key"/></li>
				<li><ps:text name="browse_and_process_key"/></li>
			</ol>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<ps:label key="File_Location_key" />
			&nbsp;&nbsp;&nbsp;&nbsp;
			<ps:file id="uploadHMScript" name="fileNameHM" onchange="validateFileName(this);fillAsSource('H','uploadHMScript');"  ></ps:file>		
		</td>
	</tr>
</table>

<ptt:toolBar id="blackListUpload_btnToolbarHM_${_pageRef}">

	<psj:submit button="true" cssClass="fg-button ui-state-default  ui-corner-all fg-button-icon-left"
			onclick="uploadBlackListFile(false)" >
		<ps:label key="Process_key" />
	</psj:submit>
	
</ptt:toolBar>

<script type="text/javascript">
$.struts2_jquery.require("DynFileManagement.js", null, jQuery.contextPath + "/common/js/dynfilemanagement/");
</script>