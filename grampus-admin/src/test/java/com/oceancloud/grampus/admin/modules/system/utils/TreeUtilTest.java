package com.oceancloud.grampus.admin.modules.system.utils;

import com.google.common.collect.Lists;
import com.oceancloud.grampus.framework.core.utils.tree.TreeNode;
import com.oceancloud.grampus.framework.core.utils.tree.TreeUtil;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 *
 * @author Beck
 * @since 2021-03-31
 */
@Slf4j
public class TreeUtilTest {

	@Test
	public void test() {
		SysMenuEntity s1 = SysMenuEntity.builder().id(1L).parentId(0L).menuName("1").build();
		SysMenuEntity s2 = SysMenuEntity.builder().id(2L).parentId(1L).menuName("2").build();
		SysMenuEntity s3 = SysMenuEntity.builder().id(3L).parentId(1L).menuName("3").build();
		SysMenuEntity s4 = SysMenuEntity.builder().id(4L).parentId(1L).menuName("4").build();
		SysMenuEntity s5 = SysMenuEntity.builder().id(5L).parentId(1L).menuName("5").build();
		SysMenuEntity s6 = SysMenuEntity.builder().id(6L).parentId(1L).menuName("6").build();
		SysMenuEntity s7 = SysMenuEntity.builder().id(7L).parentId(2L).menuName("7").build();
		SysMenuEntity s8 = SysMenuEntity.builder().id(8L).parentId(2L).menuName("8").build();
		SysMenuEntity s9 = SysMenuEntity.builder().id(9L).parentId(7L).menuName("9").build();
		SysMenuEntity s10 = SysMenuEntity.builder().id(10L).parentId(7L).menuName("10").build();
		List<SysMenuEntity> list = Lists.newLinkedList();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		list.add(s7);
		list.add(s8);
		list.add(s9);
		list.add(s10);
//		List<SysMenuEntity> trees = TreeBuildUtils.buildTree(list, 2L);
		List<SysMenuEntity> trees2 = TreeUtil.build(list);
//		log.info("tree:{}", trees);
		log.info("tree2:{}", trees2);
	}

	@Data
	@Builder
	public static class SysMenuEntity extends TreeNode<SysMenuEntity> implements Serializable {
		private static final long serialVersionUID = -6892870255430974795L;

		/**
		 * 数据ID
		 */
		private Long id;

		/**
		 * 父级菜单ID
		 */
		private Long parentId;

		/**
		 * 菜单名
		 */
		private String menuName;
	}
}
