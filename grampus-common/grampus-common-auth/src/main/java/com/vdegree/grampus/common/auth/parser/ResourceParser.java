package com.vdegree.grampus.common.auth.parser;

/**
 * Resource parser.
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
public interface ResourceParser {

	/**
	 * Parse a unique name of the resource from the request.
	 *
	 * @param request where we can find the resource info. Given it may vary from Http request to gRPC request, we use a
	 *                Object type for future accommodation.
	 * @return resource name
	 */
	String parseName(Object request);
}
