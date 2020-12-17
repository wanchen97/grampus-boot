package com.vdegree.grampus.common.core.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title: BeanCopier封装
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-07-03
 */
@Slf4j
public class BeanCopyUtil {

	/*=================================================*/
	/*=================== BeanCopier ===================*/
	/*=================================================*/

	private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>();

	@SneakyThrows
	public static <T> T copy(Object from, Class<T> c) {
		T to = c.newInstance();
		copy(from, to);
		return to;
	}

	public static void copy(Object from, Object to) {
		if (from == null) {
			return;
		}
		String beanKey = generateKey(from.getClass(), to.getClass());
		BeanCopier copier;
		if (BEAN_COPIER_MAP.containsKey(beanKey) && BEAN_COPIER_MAP.get(beanKey) != null) {
			copier = BEAN_COPIER_MAP.get(beanKey);
		} else {
			copier = BeanCopier.create(from.getClass(), to.getClass(), false);
			BEAN_COPIER_MAP.put(beanKey, copier);
		}
		copier.copy(from, to, null);
	}

	public static <T, Y> List<T> copyList(List<Y> from, Class<T> c) {
		if (from == null || from.size() == 0) {
			return null;
		}
		List<T> result = new ArrayList<>();
		for (Y o : from) {
			result.add(copy(o, c));
		}
		return result;
	}

	private static String generateKey(Class<?> class1, Class<?> class2) {
		return class1.toString() + class2.toString();
	}

	/*=================================================*/
	/*==================== BeanUtils ===================*/
	/*=================================================*/

	@SneakyThrows
	public static <T> T copyProperties(Object from, Class<T> c) {
		T to = c.newInstance();
		copyProperties(from, to);
		return to;
	}

	public static void copyProperties(Object from, Object to) {
		if (from == null) {
			return;
		}
		BeanUtils.copyProperties(from, to);
	}

	public static <T, Y> List<T> copyProperties(List<Y> from, Class<T> c) {
		if (from == null || from.size() == 0) {
			return null;
		}
		List<T> result = new ArrayList<>(from.size());
		for (Y o : from) {
			result.add(copyProperties(o, c));
		}
		return result;
	}
}