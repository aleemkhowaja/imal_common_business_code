package com.path.vo.common.signature;

import java.util.ArrayList;

public class SignatureDetCO
{
    ArrayList<SignatureCO> signaturesCO;
    ArrayList<SignatureCO> documentsCO;
    ArrayList<SignatureCO> photosCO;
    
    public ArrayList<SignatureCO> getSignaturesCO()
    {
        return signaturesCO;
    }
    public void setSignaturesCO(ArrayList<SignatureCO> signaturesCO)
    {
        this.signaturesCO = signaturesCO;
    }
    public ArrayList<SignatureCO> getDocumentsCO()
    {
        return documentsCO;
    }
    public void setDocumentsCO(ArrayList<SignatureCO> documentsCO)
    {
        this.documentsCO = documentsCO;
    }
    public ArrayList<SignatureCO> getPhotosCO()
    {
        return photosCO;
    }
    public void setPhotosCO(ArrayList<SignatureCO> photosCO)
    {
        this.photosCO = photosCO;
    }
}