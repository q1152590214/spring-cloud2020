package com.bdqn.chx.springcloud.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    private  int Id;
    private int userId;
    private  int total;
    private  int used;
    private int residue;

}
