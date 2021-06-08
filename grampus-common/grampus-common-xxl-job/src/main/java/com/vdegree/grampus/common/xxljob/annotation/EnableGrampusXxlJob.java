package com.vdegree.grampus.common.xxljob.annotation;

import com.vdegree.grampus.common.xxljob.config.XxlJobAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * XxlJob启用
 *
 * @author Beck
 * @since 2021-06-08
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({XxlJobAutoConfiguration.class})
public @interface EnableGrampusXxlJob {
}
