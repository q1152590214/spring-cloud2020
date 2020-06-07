package com.bdqm.chx.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class commonResult<T> {

    private  T data;
    private int coed;
    private String message;
    public commonResult(int coed,String message){
        this(null, coed, message);
    }
}
