package com.zsw.netshop.model.entity.product;

import com.zsw.netshop.model.entity.base.BaseEntity;
import lombok.Data;

@Data
public class ProductDetails extends BaseEntity {

	private Long productId;
	private String imageUrls;

}