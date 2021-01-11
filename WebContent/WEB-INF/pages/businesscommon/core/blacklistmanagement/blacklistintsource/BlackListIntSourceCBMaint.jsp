<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<table width="100%">
	<tr>
		<td></td>
		<td><h2><u><ps:text name="upload_correct_CB_Blacklist_file_key"></ps:text></u></h2></td>
	</tr>
	<tr>
		<td></td>
		<td>
			<ol>
				<li><ps:text name="select_file_bls_key"/> </li>
			</ol>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<ps:label key="File_Location_key" />
			&nbsp;&nbsp;&nbsp;&nbsp;
			<ps:file id="uploadScript_${_pageRef}" name="upload" onchange="validateFileName(this);"  ></ps:file>		
		</td>
	</tr>
</table>
