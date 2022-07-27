package com.company.appwarehause.payload;

import lombok.Data;

@Data
public class OutputProductDto {
    private Integer productId;
    private Integer amount;
    private Double price;
    private Integer outputId;
}
