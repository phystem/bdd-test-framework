package com.test.madhan.model;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class OrderData {

    String productName;

    String productQuantity;

    String orderTotal;

}
