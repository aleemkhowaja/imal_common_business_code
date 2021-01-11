package com.path.dao.core.avabeneficiaries;



import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.avabenef.AvaBeneficiariesDefCO;
import com.path.vo.core.avabenef.AvaBeneficiariesDefSC;

public interface AvaBeneficiariesLkpDAO 
{
    public int returnAvaBeneficiariesLookupCount(AvaBeneficiariesDefSC criteria) throws DAOException;

    public List returnAvaBeneficiariesLookupList(AvaBeneficiariesDefSC criteria) throws DAOException;

    public AvaBeneficiariesDefCO dependencyForAvaBeneficiaries(AvaBeneficiariesDefSC criteria) throws DAOException;

}
