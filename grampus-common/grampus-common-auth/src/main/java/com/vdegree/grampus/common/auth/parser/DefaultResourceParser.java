package com.vdegree.grampus.common.auth.parser;

import org.apache.commons.lang3.StringUtils;

/**
 * Default resource parser.
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
public class DefaultResourceParser implements ResourceParser {
    
    @Override
    public String parseName(Object request) {
        return StringUtils.EMPTY;
    }
}
