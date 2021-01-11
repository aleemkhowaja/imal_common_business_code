
package com.path.bo.common.global360view.treasury;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.TreasuryDerivativesCO;
import com.path.vo.common.global360view.TreasurySC;

public interface TreasuryBO {	
	
	 
	public  List<TreasuryDerivativesCO> getTreasuryDerivativesDetails(TreasurySC treasurySC) throws BaseException ;
	
	
	

}
