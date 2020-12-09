package com.vdegree.grampus.common.auth.annotation;

import com.vdegree.grampus.common.auth.parser.DefaultResourceParser;
import com.vdegree.grampus.common.auth.parser.ResourceParser;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation indicating that the annotated request should be authorized.
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Secured {
    
    /**
     * The name of resource related to the request.
     *
     * @return resource name
     */
    String resource() default StringUtils.EMPTY;
    
    /**
     * Resource name parser. Should have lower priority than resource().
     *
     * @return class type of resource parser
     */
    Class<? extends ResourceParser> parser() default DefaultResourceParser.class;
}
