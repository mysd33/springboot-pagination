package com.example.domain.common.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * ユーザクラス
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = -8506834435303865959L;
	
	//@ApiModelProperty(value = "ユーザID")
	private String userId;
	//@JsonIgnore	
    private String password;
	//@ApiModelProperty(value = "ユーザ名")
    private String userName;
	//@ApiModelProperty(value = "誕生日")
    private Date birthday;
	//@ApiModelProperty(value = "ロール")
    private String role;
    
    //TODO: サンプルAPの残骸なのでいずれ削除
	//@JsonIgnore	
	private boolean marriage; //結婚ステータス
	//@JsonIgnore	
    private int age; //年齢
    
}
