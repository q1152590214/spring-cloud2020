package com.bdqm.chx.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seate implements Serializable {

    private  int id;
    private  int productId;
    private  int total;
    private  int used;
    private int residue;

}
