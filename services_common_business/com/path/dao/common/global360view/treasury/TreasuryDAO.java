package com.path.dao.common.global360view.treasury;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.TreasuryDerivativesCO;
import com.path.vo.common.global360view.TreasurySC;

public interface TreasuryDAO {
	
	public List<TreasuryDerivativesCO> getTreasuryDerivativesDetails(TreasurySC treasurySC) throws DAOException;
		
}
 