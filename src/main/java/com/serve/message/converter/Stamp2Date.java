package com.serve.message.converter;

/*Created by Chandler
 *createDate:2018/2/23
 *createTime:9:32
 *将时间戳转换为时间格式
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stamp2Date {
    public static String Stamp2Date(String stamp){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long It = new Long(stamp);
        Date date = new Date(It);
        res= simpleDateFormat.format(date);
        return res;
    }
}
