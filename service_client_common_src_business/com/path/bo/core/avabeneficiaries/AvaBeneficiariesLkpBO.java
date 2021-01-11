package com.path.bo.core.avabeneficiaries;


import java.util.List;

import com.path.vo.core.avabenef.AvaBeneficiariesDefCO;
import com.path.vo.core.avabenef.AvaBeneficiariesDefSC;
import com.path.lib.common.exception.BaseException;

public interface AvaBeneficiariesLkpBO
{
    public int returnAvaBeneficiariesLookupCount(AvaBeneficiariesDefSC criteria) throws BaseException;

    public List returnAvaBeneficiariesLookupList(AvaBeneficiariesDefSC criteria) throws BaseException;

    public AvaBeneficiariesDefCO dependencyForAvaBeneficiaries(AvaBeneficiariesDefSC criteria) throws BaseException;
}