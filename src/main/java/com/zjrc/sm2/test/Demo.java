package com.zjrc.sm2.test;

import com.alibaba.fastjson.JSON;

import com.zjrc.sm2.entity.Bank;
import com.zjrc.sm2.entity.Result;
import com.zjrc.sm2.utils.SM2Utils;
import com.zjrc.sm2.utils.Util;


import java.io.IOException;


/**
 * @author xy
 * @version 1.0
 * @date 2020/11/5 20:33
 */
public class Demo {
    private static final String otherPublicKey = "04AE05566CB39C6E1C0BD88AEB5CB147E5C4BE66ACBF2A8A" +
            "2D4FB004281260BDD0DC3ED1A62C8A5DB04B58587A26D4115B9D22E0D2371AC75041D363986FA1C223";
    private static final String otherPrivateKey = "00C16F931961F6372D390BDDCCDEE881C3CBA1BB7FA8A84119BB00FA5C1F78CF73";
    private static final String myPrivateKey = "009A1E7F89CBF5DC99679348B3DBE2C63A74A0C0F5DDA5A174AA824574DB954A6B";

    private static final String myPublicKey = "043389B5912460457FFA2AFFA1A718DEA30F" +
            "8E8ADBC2DE07C6CE382E06EDC77847E80DFC5A2B1EDA7F60B0617F7C6F6A45019CA269A3D83741A9D6BE6804D68BA1";

    public static void main(String[] args) throws IOException {
        String money = "200";

//      byte[] bankBytes = JSON.toJSONString(bank).getBytes();
        String encrypt = SM2Utils.encrypt(Util.hexToByte(myPublicKey), money.getBytes());
        System.out.println("加密后的参数：" + encrypt);
        Bank bank = new Bank("xy",encrypt);
        Result result = new Result(200, "'我传给你了", bank);
        System.out.println(result);


//        byte[] decrypt = SM2Utils.decrypt(Util.hexToByte(myPrivateKey), Util.hexToByte(encrypt));
//        // String s = new String(decrypt);
//        Object parse = JSON.parse(decrypt);
//        System.out.println(parse);



    }
}
