package com.bdqn.chx.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class commonResult<T> {

    private  int code;
    private  String message;
    private T data;
    public commonResult(int code,String massger){
        this(code,massger,null);
    }

}
