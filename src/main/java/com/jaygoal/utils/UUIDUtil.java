package com.jaygoal.utils;

import java.util.UUID;

/**
* 生成UUID
* @author JayGoal
* @date 2020/7/8
*/
public class UUIDUtil {
    /**
     * 创建UUID
     * @return UUID
     */
    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
