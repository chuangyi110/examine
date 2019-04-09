package com.lzdn.examine.utils;




import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String,Object> {
    public R(){
        put("code",0);
        put("msg","success");
    }
    public static R error(){
        return error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public static R error(HttpStatus httpStatus,String msg){
        R r = new R();
        r.put("code",httpStatus.value());
        r.put("msg",msg);
        return r;
    }

    public static R error(HttpStatus httpStatus){
        R r = new R();
        r.put("code",httpStatus.value());
        r.put("msg",httpStatus.getReasonPhrase());
        return r;
    }

    public static R error(int code,String msg){
        R r = new R();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }
    public static R ok(String msg){
        R r = new R();
        r.put("msg",msg);
        return r;
    }
    public static R ok(Map<String,Object> map){
        R r = new R();
        r.putAll(map);
        return r;
    }
    public static R ok(){
        return new R();
    }
    @Override
    public R put(String key ,Object value){
        super.put(key,value);
        return this;
    }


}
