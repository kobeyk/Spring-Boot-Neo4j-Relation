package com.appleyk.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.appleyk.relation.LikeRelation;

public interface LikeRelationRepository extends GraphRepository<LikeRelation>{

	/**
	 * 查询关系
	 * @param relationName
	 * @return
	 */
	@Query("match p = (n)-[r:Like]-(b) return p")
	List<LikeRelation> getLikes();
	
	
	/**
	 * 为两个已经存在的节点添加关系
	 * @param startNodeID -- 起始节点
	 * @param endNodeID   -- 终止节点
	 * @param rID         -- 关系的ID
	 * @param year        -- 关系的开始年限
	 * @param reason	  -- 关系产生的原因
	 * @return
	 */
	@Query("match(a),(b) where a.uid={0} and b.uid = {1}"
			+ " create p = (a)-[r:Like{relationID:{2},since:{3},reason:{4}}]->(b) return p ")
	List<LikeRelation> createLikes(Long startNodeID,Long endNodeID,
								   Integer rID,Integer year,String reason);
}
