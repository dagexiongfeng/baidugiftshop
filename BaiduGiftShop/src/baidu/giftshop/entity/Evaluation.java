package baidu.giftshop.entity;

import java.util.Date;

/**
 * Evaluation entity. @author MyEclipse Persistence Tools
 */

public class Evaluation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer goodsDetailId;
	private Integer userId;
	private String evaluation;
	private Date data;

	// Constructors

	/** default constructor */
	public Evaluation() {
	}

	/** full constructor */
	public Evaluation(Integer goodsDetailId, Integer userId, String evaluation,
			Date data) {
		this.goodsDetailId = goodsDetailId;
		this.userId = userId;
		this.evaluation = evaluation;
		this.data = data;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsDetailId() {
		return this.goodsDetailId;
	}

	public void setGoodsDetailId(Integer goodsDetailId) {
		this.goodsDetailId = goodsDetailId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}