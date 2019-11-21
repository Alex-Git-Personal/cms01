package com.ax.apps.cms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ax.apps.cms.dao")
public class MybatisConfig {

}
