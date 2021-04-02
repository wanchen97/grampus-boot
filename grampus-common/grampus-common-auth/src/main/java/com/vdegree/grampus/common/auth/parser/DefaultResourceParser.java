package com.vdegree.grampus.common.auth.parser;

import com.vdegree.grampus.common.core.utils.chars.StringPool;

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
        return StringPool.EMPTY;
    }
}
