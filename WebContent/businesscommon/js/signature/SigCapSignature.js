function accounts_openSigCapUrl()
{
	if($("#sigCapUrl_"+_pageRef).val()=="")
	{
		_showErrorMsg(sigCapUrlPthCtrl,error_msg_title);
		$("#signatureDialog_"+_pageRef).remove();
	}
	else
	{
		window.open($("#sigCapUrl_"+_pageRef).val(),'mywindow','width=600,height=600');	
		if($("#acceptSigCapBtn_"+_pageRef).is(':visible'))
		{
			$("#acceptSigCapBtn_"+_pageRef).removeClass('ui-button-disabled ui-state-disabled');
			$("#acceptSigCapBtn_"+_pageRef).attr("disabled",false);
			$("#rejectSigCapBtn_"+_pageRef).removeClass('ui-button-disabled ui-state-disabled');
			$("#rejectSigCapBtn_"+_pageRef).attr("disabled",false);
		}
		else
		{
			$("#signatureDialog_"+_pageRef).remove();
		}
	}
}

function acceptSigCapSignature()
{
	_signCallBackObj.signatureAccepted = true;
	$("#signReturnFlag_"+_pageRef).val("A");
	$("#signatureCancelBtn_"+_pageRef). trigger('click');
	$("#signatureDialog_"+_pageRef).remove();
}

function rejectSigCapSignature()
{
	_signCallBackObj.signatureRejected =  true;
	_signCallBackObj.signatureCancelled = true;//Abdo TP#492450 03/03/2017
	$("#signReturnFlag_"+_pageRef).val("R");
	$("#signatureCancelBtn_"+_pageRef). trigger('click');
}

function sigCapClose()
{
	$("#signatureDialog_"+_pageRef).remove();
}	
	
function sigCap_onLoadFunc()
{
	if(_pageRef=="Q000MT")
	{
		$("#accNo_"+_pageRef).val($("#lookuptxt_acc_add_ref_"+_pageRef).val());
	}
	
}