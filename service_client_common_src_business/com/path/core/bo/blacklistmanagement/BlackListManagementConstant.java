package com.path.core.bo.blacklistmanagement;

import java.math.BigDecimal;

public class BlackListManagementConstant
{
    //cif blacklist types
    public static final BigDecimal SUSPICIOUS		= BigDecimal.ZERO;
    public static final BigDecimal BLACKLISTED   	= BigDecimal.ONE;
    public static final BigDecimal WHITELISTED		= new BigDecimal(2);
    
    //for upload file
    public static final String FILE_CODE_UN		= "#BLKUN#";
    public static final String STRUCT_CODE_UN	= "#BLKUN#";
    
    public static final String FILE_CODE_OFAC	= "#BLKOFAC#";
    public static final String STRUCT_CODE_OFAC	= "#BLKOFAC#";

  //SB170022 - BLACK-LIST UPLOAD CHALLENGES 582050 mfalha
    public static final String FILE_CODE_EU	= "#BLKEU#";
    public static final String STRUCT_CODE_EU	= "#BLKEU#";
    public static final String FILE_CODE_HM	= "#BLKHM#";
    public static final String STRUCT_CODE_HM	= "#BLKHM#";
  //SB170022 - BLACK-LIST UPLOAD CHALLENGES 582050 mfalha
    
    public static final String STRUCT_TYPE		= "2";
    
    public static final String AS_SOURCE_UN		= "U";
    public static final String AS_SOURCE_OFAC		= "O";
    
    //SB170022 - BLACK-LIST UPLOAD CHALLENGES 582050 mfalha
    public static final String AS_SOURCE_EU		= "E";
    public static final String AS_SOURCE_HM		= "H";
    //SB170022 - BLACK-LIST UPLOAD CHALLENGES 582050 mfalha

    
}
