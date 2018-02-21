package com.serve.message.util;

/*Created by Chandler
 *createDate:2018/2/21
 *createTime:20:32
 *生成随机订单号
 */

import java.util.Random;

public class KeyUtil {
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
