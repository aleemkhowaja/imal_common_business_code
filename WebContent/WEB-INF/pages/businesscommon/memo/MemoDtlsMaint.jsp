<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>

<html> 
<body>
   
 	<ps:form id="memoDtlsForm_${_pageRef}" useHiddenProps="true"  >	
 	    
 	    <ps:hidden id="_recReadOnly_${_pageRef}" value="${_recReadOnly}"/>	
 	    <ps:hidden id="actionType_${_pageRef}"   name="actionType"/>
 	   	<ps:hidden id="is_cif_${_pageRef}"   name="memoDtlCO.ctsMemoVO.CIF_SPECIFIC"/>
 	    <ps:hidden id="is_acc_${_pageRef}"   name="memoDtlCO.ctsMemoVO.ACC_SPECIFIC"/>
 	    <ps:hidden id="is_date_${_pageRef}"  name="memoDtlCO.ctsMemoVO.DATE_INTERVAL"/>
 	    <ps:hidden id="DATE_UPDATED_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.DATE_UPDATED" />
 	    <ps:hidden id="DATE_CREATED_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.DATE_CREATED" />
 	    <ps:hidden id="GL_TYPE_${_pageRef}" value="X" />
 	    <ps:hidden id="GMI_FLAG_${_pageRef}" value="X" />
 	    <ps:hidden id="flag_${_pageRef}" value="CIF1" />
 	    <ps:hidden id="APPROVED_BY_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.APPROVED_BY" />
		<ps:hidden id="TODO_ALERT_REFRESH_DATA_${_pageRef}" name="memoDtlCO.alertsParamCO.shouldRefreshAlert"/>
 	    <ps:hidden id="CREATED_BY_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.CREATED_BY" />
 	    <ps:hidden id="MODIFIED_BY_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.MODIFIED_BY" />  
 	    <ps:hidden id="TOBE_CANCELLED_BY_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.TOBE_CANCELLED_BY" />
 	    <ps:hidden id="TOBE_REACTIVATED_BY_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.TOBE_REACTIVATED_BY" />
 	    <ps:hidden id="TOBE_SUSPENDED_BY_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.TOBE_SUSPENDED_BY" />
 	     
		<table width="100%" border="0">
		  <tr></tr><tr></tr>
		  <tr>
		    <td width="15%"><ps:label key="Trx_No_key" for="trxNo_${_pageRef}"/></td>
		    <td width="10%">
		    <ps:textfield id="trxNo_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.TRX_NO" readonly="true"/></td>
		    <td width="30%">&nbsp;</td>	
		    <td width="10%">&nbsp;</td>
		    <td width="10%">&nbsp;</td>
		    <td width="25%">
			    <table>
					<tr>
						<td><ps:label key="status_key" for="status_${_pageRef}" /></td>
						<td>
						<ps:hidden id="statusId_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.STATUS"></ps:hidden>
						<ps:textfield id="status_${_pageRef}" name="memoDtlCO.statusDesc"  disabled="true" />
						</td>
						<td><ps:hidden id="modifiedDate_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.DATE_MODIFIED" />	</td>
						<td> <psj:a button="true" buttonIcon="ui-icon-triangle-2-s" onclick="showMemoDtlsStatus()"><ps:text name='status_key'/></psj:a></td>
					</tr>    	
			    </table>
		    
		    
		    
		    </td>		    
		  </tr>		  
		  <tr>
		    <td><ps:label id="lbl_memoCode_${_pageRef}" key="Memo_Code_key" for="lookuptxt_memoCode_${_pageRef}"/> </td>
		   <td>
		   		<psj:livesearch mode="number" name="memoDtlCO.ctsMemoDetVO.MEMO_CODE"	 			                      
				                      id  ="memoCode_${_pageRef}"
				                      maxlength="4"
				                      resultList="CODE:memoCode_${_pageRef},BRIEF_DESC_ENG:memoDesc_${_pageRef}"
				                      actionName="${pageContext.request.contextPath}/pathdesktop/MemoLookup_memoLookupDef"
				                      paramList="memoSC.type:type_${_pageRef}"
				                      searchElement="CODE"				                     
				                      readOnlyMode="${_recReadOnly}"				                    
				                      parameter="ctsMemoVO.CODE:lookuptxt_memoCode_${_pageRef}"
				                      dependencySrc="${pageContext.request.contextPath}/path/memo/MemoDtlsMaint_returnMemoById"
				                      dependency="accBr_${_pageRef}:memoDtlCO.ctsMemoDetVO.ACC_BR:memoDtlCO.accReadOnly,lookuptxt_memoCode_${_pageRef}:memoDtlCO.ctsMemoVO.CODE,memoDesc_${_pageRef}:memoDtlCO.ctsMemoVO.BRIEF_DESC_ENG,lookuptxt_cifNo_${_pageRef}:memoDtlCO.ctsMemoDetVO.CIF_NO:memoDtlCO.cifReadOnly,cifDesc_${_pageRef}:memoDtlCO.cifDesc:memoDtlCO.cifReadOnly,fromDate_${_pageRef}:memoDtlCO.ctsMemoDetVO.FROM_DATE:memoDtlCO.dateIntervalReadOnly,toDate_${_pageRef}:memoDtlCO.ctsMemoDetVO.DATE_TO:memoDtlCO.dateIntervalReadOnly,accCy_${_pageRef}:memoDtlCO.ctsMemoDetVO.ACC_CY:memoDtlCO.accReadOnly,accGl_${_pageRef}:memoDtlCO.ctsMemoDetVO.ACC_GL:memoDtlCO.accReadOnly,accCif_${_pageRef}:memoDtlCO.ctsMemoDetVO.ACC_CIF:memoDtlCO.accReadOnly,lookuptxt_accSl_${_pageRef}:memoDtlCO.ctsMemoDetVO.ACC_SL:memoDtlCO.accReadOnly,accDesc_${_pageRef}:memoDtlCO.AC_DESC,lookuptxt_accAddRef_${_pageRef}:memoDtlCO.ctsMemoDetVO.ACC_ADD_REF:memoDtlCO.accReadOnly,is_cif_${_pageRef}:memoDtlCO.ctsMemoVO.CIF_SPECIFIC,is_acc_${_pageRef}:memoDtlCO.ctsMemoVO.ACC_SPECIFIC,is_date_${_pageRef}:memoDtlCO.ctsMemoVO.DATE_INTERVAL,lookuptxt_segmentCode_${_pageRef}:memoDtlCO.ctsMemoDetVO.SEGMENT_CODE:memoDtlCO.segmentReadOnly,segmentDesc_${_pageRef}:memoDtlCO.segmentDesc"
				                      >
				 </psj:livesearch>			
			</td>
		    <td >		        
		    	<ps:textfield id="memoDesc_${_pageRef}" name="memoDtlCO.ctsMemoVO.BRIEF_DESC_ENG" disabled="true"></ps:textfield>			 
			</td>
		  </tr>
		  <tr>
		    <td><ps:label key="Comments_English_key" for="commentsEng_${_pageRef}" id="lbl_commentsEng_${_pageRef}"/></td>
		    <td colspan="2"><ps:textarea  id="commentsEng_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.ENG_COMENT"  maxlength="300" readonly="${_recReadOnly}"></ps:textarea></td>
		  </tr>
		  <tr>
		    <td>&nbsp; <br></td>
		    <td colspan="2"><ps:textarea id="commentsArb_${_pageRef}" name="memoDtlCO.ctsMemoDetVO.ARAB_COMENT"  maxlength="300" dir="rtl" readonly="${_recReadOnly}" cssStyle="direction:rtl"></ps:textarea></td>
		    <td align="right"><ps:label key="Comments_Arab_key" for="commentsArb_${_pageRef}" id="lbl_commentsArb_${_pageRef}"/></td>
		   
		  </tr>
		  <tr>
		    <td><ps:label id="lbl_cifNo_${_pageRef}" key="CIF_key" for="lookuptxt_cifNo_${_pageRef}"/> </td>
		    <td>
		    
		    	  <psj:livesearch mode="number"  name="memoDtlCO.ctsMemoDetVO.CIF_NO"				                      
				                      id="cifNo_${_pageRef}" 
				                      resultList="CIF_NO:lookuptxt_cifNo_${_pageRef},LONG_NAME_ENG:cifDesc_${_pageRef}"
				                      actionName="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructMemoDtlsCifLookup" 
				                      paramList="GL_TYPE:GL_TYPE_${_pageRef},GMI_FLAG:GMI_FLAG_${_pageRef}"
				                      searchElement="CIF_NO"
				                      readOnlyMode="true"
				                      parameter="criteria.GL_TYPE:GL_TYPE_${_pageRef},criteria.GMI_FLAG:GMI_FLAG_${_pageRef},criteria.cif_no:lookuptxt_cifNo_${_pageRef}"
				                      dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByMemoDtlsCif"
				                	  dependency="lookuptxt_cifNo_${_pageRef}:cifVO.CIF_NO,cifDesc_${_pageRef}:cifVO.LONG_NAME_ENG"
				                	  afterDepEvent="afterDepEventMemoDtlsCifNo()"
				   >
				 </psj:livesearch>
		    	  
		     </td>
		    <td>
		    	<ps:textfield  id="cifDesc_${_pageRef}"   name="memoDtlCO.cifDesc" disabled="true"  ></ps:textfield>
		    </td>
		  </tr>	

		  <tr>
		    <td><ps:label id="lbl_segment_code_${_pageRef}" key="segment_code_key" for="lookuptxt_segmentCode_${_pageRef}"/> </td>
		    <td>
		    	  <psj:livesearch mode="number"  name="memoDtlCO.ctsMemoDetVO.SEGMENT_CODE"				                      
				                      id="segmentCode_${_pageRef}" 
				                      resultList="SEGMENT_CODE:lookuptxt_segmentCode_${_pageRef},LONG_NAME_ENG:segmentDesc_${_pageRef}"
				                      actionName="${pageContext.request.contextPath}/pathdesktop/SegmentationCodeLookupAction_constructSegmentationCodeLookup" 
				                      paramList="isSegmentationScore:S"
				                      searchElement="SEGMENT_CODE"
				                      parameter     ="custSegmentationSC.segmentCode:lookuptxt_segmentCode_${_pageRef},custSegmentationSC.isSegmentationScore:S"
				                      dependencySrc ="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyByMainSegmentCode"
				                	  dependency="lookuptxt_segmentCode_${_pageRef}:custSegmentationSC.segmentCode,segmentDesc_${_pageRef}:custSegmentationSC.segmentDesc">
				 </psj:livesearch>
		     </td>
		    <td>
		    	<ps:textfield  id="segmentDesc_${_pageRef}"   name="memoDtlCO.segmentDesc" disabled="true"  ></ps:textfield>
		    </td>
		  </tr>			  
		  
		   <tr>
		    <td><ps:label id="lbl_account_${_pageRef}" key="Account_Number_key" for="tbl_pathAccount_account_${_pageRef}"/></td>
			<td  colspan="2">
			<ps:account
					id            ="account_${_pageRef}"
					inputIds      ="accBr_${_pageRef}~accCy_${_pageRef}~accGl_${_pageRef}~accCif_${_pageRef}~accSl_${_pageRef}~accAddRef_${_pageRef}~accDesc_${_pageRef}"
					inputNames    ="memoDtlCO.ctsMemoDetVO.ACC_BR~memoDtlCO.ctsMemoDetVO.ACC_CY~memoDtlCO.ctsMemoDetVO.ACC_GL~memoDtlCO.ctsMemoDetVO.ACC_CIF~memoDtlCO.ctsMemoDetVO.ACC_SL~memoDtlCO.ctsMemoDetVO.ACC_ADD_REF~memoDtlCO.AC_DESC"
					accountLabel  ="" 
					inputSizes    ="60~60~60~60~80~75~N"
					readOnly      ="${accReadOnlyMode}~${accReadOnlyMode}~${accReadOnlyMode}~${accReadOnlyMode}~${accReadOnlyMode}~${accReadOnlyMode}~true"
					mode          ="number~number~number~number~livesearch~livesearch~text"
					rowLocation   ="1~1~1~1~1~2~3" 
					colSpan       ="1~1~1~1~1~5~5" 
					paramList	  ="N~N~N~N~branchCode:accBr_${_pageRef},currencyCode:accCy_${_pageRef},glCode:accGl_${_pageRef},cifCode:accCif_${_pageRef},_pageRef:pageRef_${_pageRef},slNbr:lookuptxt_accSl_${_pageRef}~N~branchCode:accBr_${_pageRef},currencyCode:accCy_${_pageRef},glCode:accGl_${_pageRef},cifCode:accCif_${_pageRef},_pageRef:pageRef_${_pageRef},slNbr:lookuptxt_accSl_${_pageRef},addRef:lookuptxt_accAddRef_${_pageRef}"
					parameter     ="N
								   ~N
								   ~account.GL_CODE:accGl_${_pageRef}
								   ~cifVO.CIF_NO:accCif_${_pageRef}
								   ~branchCode:accBr_${_pageRef},currencyCode:accCy_${_pageRef},glCode:accGl_${_pageRef},cifCode:accCif_${_pageRef},slNbr:lookuptxt_accSl_${_pageRef},_pageRef:pageRef_${_pageRef}
								   ~accRef:lookuptxt_accAddRef_${_pageRef},_pageRef:pageRef_${_pageRef}
								   ~N"
					onblur	      ="N~N~N~N~N~N~N"
					dependencySrc ="N
								   ~N
								   ~${pageContext.request.contextPath}/pathdesktop/GLDependencyAction_returnGlByCode
								   ~${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByCif?criteria.showMemo=false
								   ~${pageContext.request.contextPath}/pathdesktop/AccountDependencyAction_returnAMFBySrlNbr?criteria.displayMsg=1
								   ~${pageContext.request.contextPath}/path/memo/MemoDtlsMaint_dependencyByAddRef
								   ~N"
					dependency    ="N
								   ~N
								   ~accGl_${_pageRef}:genledger.GL_CODE,accCif_${_pageRef}:cifVO.CIF_NO,lookuptxt_cifNo_${_pageRef}:cifVO.CIF_NO,cifDesc_${_pageRef}:cifVO.LONG_NAME_ENG,lookuptxt_accSl_${_pageRef}:account.SL_NO,lookuptxt_accAddRef_${_pageRef}:account.ADDITIONAL_REFERENCE,accDesc_${_pageRef}:account.BRIEF_NAME_ENG
								   ~accCif_${_pageRef}:cifVO.CIF_NO,lookuptxt_cifNo_${_pageRef}:cifVO.CIF_NO,cifDesc_${_pageRef}:cifVO.LONG_NAME_ENG,lookuptxt_accSl_${_pageRef}:account.SL_NO,lookuptxt_accAddRef_${_pageRef}:account.ADDITIONAL_REFERENCE,accDesc_${_pageRef}:account.BRIEF_NAME_ENG
								   ~lookuptxt_accSl_${_pageRef}:account.SL_NO,lookuptxt_accAddRef_${_pageRef}:account.ADDITIONAL_REFERENCE,accDesc_${_pageRef}:account.BRIEF_NAME_ENG
								   ~accBr_${_pageRef}:account.BRANCH_CODE,accCy_${_pageRef}:account.CURRENCY_CODE,accGl_${_pageRef}:account.GL_CODE,accCif_${_pageRef}:account.CIF_SUB_NO,lookuptxt_accSl_${_pageRef}:account.SL_NO,accDesc_${_pageRef}:account.BRIEF_NAME_ENG,lookuptxt_cifNo_${_pageRef}:account.CIF_SUB_NO,cifDesc_${_pageRef}:account.cifDesc,lookuptxt_accAddRef_${_pageRef}:account.ADDITIONAL_REFERENCE
								   ~N"
					actionName    ="N~N~N~N~${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup~${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup~N" 
					searchElement ="N~N~N~N~amfVO.SL_NO~amfVO.ADDITIONAL_REFERENCE~N"  
					onOk          ="N~N~N~N~setMemoDtlsAccountLookup()~setMemoDtlsAddRefLookup()~N"
					autoSearch    ="N~N~N~N~false~false~N"
                        >
		                        </ps:account>
		                        
		                        
		          
		                        </td>

		  </tr>
		  <tr>
		    <td><ps:label key="From_date_key" for="fromDate_${_pageRef}"/>  </td>
		    <td colspan="2">
		    	<table width="100%;" cellpadding="0" cellspacing="0" > 
		    	  <tr>
		    	    <td width="42%" >
		    	    	<psj:datepicker id="fromDate_${_pageRef}" size="15"
							name="memoDtlCO.ctsMemoDetVO.FROM_DATE" readonly="${dateIntrvlReadOnlyMode}"
							buttonImageOnly="true" onchange="memoDtlsValidateDates(this);"  />
		    	    </td>
		    	    <td  width="22%">
		    	      <ps:label key="To_Date_key" for="toDate_${_pageRef}"/>
		    	    </td>
		    	    <td>
		    	    <psj:datepicker  id="toDate_${_pageRef}" size="15" 
							name="memoDtlCO.ctsMemoDetVO.DATE_TO" readonly="${dateIntrvlReadOnlyMode}"
							buttonImageOnly="true"   onchange="memoDtlsValidateDates(this);"    />
		    	    </td>
		    	    </tr>
		    	 </table>    
			</td>
		  </tr>
		   <tr>
		    <td><ps:label key="Last_Review_No_key" id="lbl_lastReviewNo_${_pageRef}" for="lastReviewNo_${_pageRef}" /></td>
		    <td>
		    	<ps:textfield id="lastReviewNo_${_pageRef}" 	name="memoDtlCO.ctsMemoDetVO.LAST_REVIEW_NO"    mode="number" nbFormat="####"	maxlength="3"  readonly="true"	 />		    
		    </td>
		  </tr>		
		</table> 
		 
		 <pt:toolBar  id="memoToolbar" hideInAlert="true" > 
		 <ps:if test='%{(iv_crud=="R" && (memoDtlCO.ctsMemoDetVO.STATUS==null || memoDtlCO.ctsMemoDetVO.STATUS=="A")) || iv_crud=="UP"}'>		 
			    <psj:submit id="memoDtls_save_${_pageRef}" button="true" freezeOnSubmit="true" progRef="${accessMenu}">
			    	<ps:label key="Save_key" for="memoDtls_save_${_pageRef}"/>
			    </psj:submit>
			 </ps:if>
			 <ps:if test='%{iv_crud=="R" && memoDtlCO.ctsMemoDetVO.STATUS=="A"}'>
			 	<psj:submit id="memoDtls_del_${_pageRef}" button="true" type="button" freezeOnSubmit="true" progRef="M001D" onclick="memoDtlsDelete('delete');"   >
			 	<ps:label key="btn.del" for="memoDtls_del_${_pageRef}"/>
			</psj:submit>
		 	</ps:if>
		 <ps:if test='%{memoDtlCO!=null&&memoDtlCO.ctsMemoDetVO!=null&&memoDtlCO.ctsMemoDetVO.TRX_NO!=null}'>	
		 	<ps:if test='%{iv_crud=="P"}'>
		 		<psj:submit id="memoDtls_approve_${_pageRef}" button="true"  freezeOnSubmit="true" progRef="M001P">
		 		<ps:label key="Approve_key" for="memoDtls_approve_${_pageRef}"/>
		 		</psj:submit>
		 	</ps:if>
		 	<ps:if test='%{iv_crud=="CN"}'>
			 	<psj:submit id="memoDtls_toCancel_${_pageRef}" button="true"  freezeOnSubmit="true" progRef="M001CN">
			 	<ps:label key="toCancel_key" for="memoDtls_toCancel_${_pageRef}"/>
			 	</psj:submit>
		 	</ps:if>
		 	<ps:if test='%{iv_crud=="N"}'>
			 	<psj:submit id="memoDtls_cancel_${_pageRef}" button="true" freezeOnSubmit="true" progRef="M001N">
			 	<ps:label key="Cancel_key" for="memoDtls_cancel_${_pageRef}"/>
			 	</psj:submit>
		 	</ps:if>
		 	<ps:if test='%{iv_crud=="SP"}'>
			 	<psj:submit id="memoDtls_toSuspend_${_pageRef}" button="true" buttonIcon="ui-icon ui-icon-clock" freezeOnSubmit="true" progRef="M001SP" >
			 	<ps:label key="toSuspend_key" for="memoDtls_toSuspend_${_pageRef}"/>
			 	</psj:submit>
		 	</ps:if>
		 	<ps:if test='%{iv_crud=="S"}'>
			 	<psj:submit id="memoDtls_suspend_${_pageRef}" button="true" freezeOnSubmit="true" progRef="M001S" buttonIcon="ui-icon ui-icon-clock">
			 	<ps:label key="suspend_key" for="memoDtls_suspend_${_pageRef}"/>
			 	</psj:submit>
		 	</ps:if>
		 	<ps:if test='%{iv_crud=="RA"}'>
			 	<psj:submit id="memoDtls_toReactivate_${_pageRef}" button="true" buttonIcon="ui-icon ui-icon-arrowreturnthick-1-w" freezeOnSubmit="true" progRef="M001RA">
			 	<ps:label key="toReactivate_key" for="memoDtls_toReactivate_${_pageRef}"/>
			 	</psj:submit>
		 	</ps:if>
		 	<ps:if test='%{iv_crud=="A"}'>
			 	<psj:submit id="memoDtls_reactivate_${_pageRef}" button="true" buttonIcon="ui-icon ui-icon-arrowreturnthick-1-w" freezeOnSubmit="true" progRef="M001A">
			 	<ps:label key="reactivate_key" for="memoDtls_reactivate_${_pageRef}"/>
			 	</psj:submit>
		 	</ps:if>
		 </ps:if>
		 <ps:if test='%{(memoDtlCO.userIsBranchManager!="1")&&(memoDtlCO.currentApplication !="RADM") && (iv_crud=="R" && (memoDtlCO.ctsMemoDetVO.STATUS == "A" || memoDtlCO.ctsMemoDetVO.STATUS == "R" || memoDtlCO.ctsMemoDetVO.STATUS == "T" || memoDtlCO.ctsMemoDetVO.STATUS == "N" ) || iv_crud=="UP") }'>
		<psj:a button="true" onclick="openMemoAlert()">
			<ps:text name="Alerts_key"/>
		</psj:a>
	</ps:if>
		</pt:toolBar>
	 </ps:form>  
	
</body> 
<script type="text/javascript">
$.struts2_jquery.require("MemoDtls.js" ,null,jQuery.contextPath+"/businesscommon/js/memo/");
$(document).ready(function (){
	$("#memoDtlsForm_"+_pageRef).processAfterValid("memoDtls_submitManagement",[]);
})
</script>
</html>

