package com.oceancloud.grampus.admin;

import com.oceancloud.grampus.framework.xxljob.annotation.EnableGrampusXxlJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * GrampusBoot后台通用权限管理系统
 *
 * @author Beck
 * @since 2020-11-26
 */
//@EnableGrampusXxlJob
@SpringBootApplication
public class GrampusBootAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrampusBootAdminApplication.class, args);
	}
}
