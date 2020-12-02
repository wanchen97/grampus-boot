package com.vdegree.grampus.common.mybatis.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Title: TK.Mybatis配置
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
@Configuration
@MapperScan(basePackages = {"com.vdegree.grampus.**.dao"})
public class MybatisConfig {
}
