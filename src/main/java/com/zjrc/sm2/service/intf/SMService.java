package com.zjrc.sm2.service.intf;

import com.zjrc.sm2.entity.IpWhite;
import com.zjrc.sm2.vo.R;

public interface SMService {

    R selectByIp(String ip,String token);


}
