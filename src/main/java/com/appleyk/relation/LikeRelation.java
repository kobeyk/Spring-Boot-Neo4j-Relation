package com.appleyk.relation;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.appleyk.node.BaseNode;

@RelationshipEntity(type = "Like")
public class LikeRelation {

	@GraphId
	private Long id;

	/**
	 * 定义关系的起始节点 == StartNode
	 */

	@StartNode
	private BaseNode startNode;

	/**
	 * 定义关系的终止节点 == EndNode
	 */

	@EndNode
	private BaseNode endNode;

		
	/**
	 * 定义关系的属性
	 */

	@Property(name = "reason")
	private String  reason;
	@Property(name = "since")
	private Integer since;
	@Property(name = "relationID")
	private Integer relationID;

	public LikeRelation() {
	}
	
	public LikeRelation(BaseNode startNode,BaseNode endNode,String reason,
			Integer since,Integer relationID){
		this.startNode = startNode;
		this.endNode = endNode;
		this.reason = reason;
		this.since = since;
		this.relationID = relationID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseNode getStartNode() {
		return startNode;
	}

	public void setStartNode(BaseNode startNode) {
		this.startNode = startNode;
	}

	public BaseNode getEndNode() {
		return endNode;
	}

	public void setEndNode(BaseNode endNode) {
		this.endNode = endNode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getSince() {
		return since;
	}

	public void setSince(Integer since) {
		this.since = since;
	}

	public Integer getRelationID() {
		return relationID;
	}

	public void setRelationID(Integer relationID) {
		this.relationID = relationID;
	}
	
}
