package com.liuyf.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    // 主键，userid 自动递增
    @TableId(type = IdType.AUTO)
    private Integer userid;
    private String username;
    private String password;
    private String phone;
    private String address;
    private String sex;

}
