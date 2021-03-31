package com.vdegree.grampus.admin.modules.system.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 树形结构工具类，如：菜单、部门等
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-23
 */
public class TreeUtils {

	/**
	 * 根据rootId，构建树节点
	 */
	public static <T extends TreeNode> List<T> build(List<T> treeNodes, Long rootId) {

		List<T> treeList = new ArrayList<>();
		for (T treeNode : treeNodes) {
			if (rootId.equals(treeNode.getParentId())) {
				treeList.add(findChildren(treeNodes, treeNode));
			}
		}

		return treeList;
	}

	/**
	 * 查找子节点
	 */
	private static <T extends TreeNode> T findChildren(List<T> treeNodes, T rootNode) {
		for (T treeNode : treeNodes) {
			if (rootNode.getId().equals(treeNode.getParentId())) {
				rootNode.getChildren().add(findChildren(treeNodes, treeNode));
			}
		}
		return rootNode;
	}

	/**
	 * 构建树节点
	 */
	public static <T extends TreeNode> List<T> build(List<T> treeNodes) {
		List<T> result = new ArrayList<>();

		// list转map
		Map<Long, T> nodeMap = new LinkedHashMap<>(treeNodes.size());
		for (T treeNode : treeNodes) {
			nodeMap.put(treeNode.getId(), treeNode);
		}

		for (T node : nodeMap.values()) {
			T parent = nodeMap.get(node.getParentId());
			if (parent != null && !(node.getId().equals(parent.getId()))) {
				parent.getChildren().add(node);
				continue;
			}

			result.add(node);
		}

		return result;
	}

}