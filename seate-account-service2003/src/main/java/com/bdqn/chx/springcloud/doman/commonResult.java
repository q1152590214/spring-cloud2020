package com.bdqn.chx.springcloud.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class commonResult<T> {

    private int code;
    private String massage;
    private T ndata;


   public  commonResult(int code,String massage){

        this(code,massage, null);
    }

}
