package com.turing.entity;

import lombok.Data;

import java.util.List;

@Data
public class EasyUIDataGrid {
    private Integer total;//总数据数
    private List<?> rows;//当前页面数据
}
