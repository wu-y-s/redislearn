package com.wys.redislearn.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "名称：人", description = "描述")
public class NewTable implements Serializable {
    private int Id;
    private String Name;

    public NewTable(String name) {
        this.Name=name;
    }
}
