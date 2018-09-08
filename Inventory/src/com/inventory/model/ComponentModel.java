package com.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ComponentModel {

	private String cName;
	private String cCode;

	private String rawCode;
	private String rawName;

	private String mouldCode;
	private String mouldName;

	private String componenetName;

	private Long CompPartno;
	@Id
	private String partCode;
	private String hsnCode;
	@Column(nullable = true)
	private Long norm1;
	@Column(nullable = true)
	private Long norm2;
	@Column(nullable = true)
	private Long norm3;
	@Column(nullable = true)
	private Long norm4;

	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date from1;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date from2;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date from3;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date from4;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date to1;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date to2;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date to3;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date to4;
	// @Column(nullable=true)

	/*
	 * private long weight1; private long weight2; private long weight3; private
	 * long weight4;
	 */

	private Long amValue;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date amFrom;

	private Long amQty;

	private Long fettlingRate;
	private String packMode;
	private Long noCavities;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getRawCode() {
		return rawCode;
	}

	public void setRawCode(String rawCode) {
		this.rawCode = rawCode;
	}

	public String getRawName() {
		return rawName;
	}

	public void setRawName(String rawName) {
		this.rawName = rawName;
	}

	public String getMouldCode() {
		return mouldCode;
	}

	public void setMouldCode(String mouldCode) {
		this.mouldCode = mouldCode;
	}

	public String getMouldName() {
		return mouldName;
	}

	public void setMouldName(String mouldName) {
		this.mouldName = mouldName;
	}

	public String getComponenetName() {
		return componenetName;
	}

	public void setComponenetName(String componenetName) {
		this.componenetName = componenetName;
	}

	public Long getCompPartno() {
		return CompPartno;
	}

	public void setCompPartno(Long compPartno) {
		CompPartno = compPartno;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Long getNorm1() {
		return norm1;
	}

	public void setNorm1(Long norm1) {
		this.norm1 = norm1;
	}

	public Long getNorm2() {
		return norm2;
	}

	public void setNorm2(Long norm2) {
		this.norm2 = norm2;
	}

	public Long getNorm3() {
		return norm3;
	}

	public void setNorm3(Long norm3) {
		this.norm3 = norm3;
	}

	public Long getNorm4() {
		return norm4;
	}

	public void setNorm4(Long norm4) {
		this.norm4 = norm4;
	}

	public Date getFrom1() {
		return from1;
	}

	public void setFrom1(Date from1) {
		this.from1 = from1;
	}

	public Date getFrom2() {
		return from2;
	}

	public void setFrom2(Date from2) {
		this.from2 = from2;
	}

	public Date getFrom3() {
		return from3;
	}

	public void setFrom3(Date from3) {
		this.from3 = from3;
	}

	public Date getFrom4() {
		return from4;
	}

	public void setFrom4(Date from4) {
		this.from4 = from4;
	}

	public Date getTo1() {
		return to1;
	}

	public void setTo1(Date to1) {
		this.to1 = to1;
	}

	public Date getTo2() {
		return to2;
	}

	public void setTo2(Date to2) {
		this.to2 = to2;
	}

	public Date getTo3() {
		return to3;
	}

	public void setTo3(Date to3) {
		this.to3 = to3;
	}

	public Date getTo4() {
		return to4;
	}

	public void setTo4(Date to4) {
		this.to4 = to4;
	}

	public Long getAmValue() {
		return amValue;
	}

	public void setAmValue(Long amValue) {
		this.amValue = amValue;
	}

	public Date getAmFrom() {
		return amFrom;
	}

	public void setAmFrom(Date amFrom) {
		this.amFrom = amFrom;
	}

	public Long getAmQty() {
		return amQty;
	}

	public void setAmQty(Long amQty) {
		this.amQty = amQty;
	}

	public Long getFettlingRate() {
		return fettlingRate;
	}

	public void setFettlingRate(Long fettlingRate) {
		this.fettlingRate = fettlingRate;
	}

	public String getPackMode() {
		return packMode;
	}

	public void setPackMode(String packMode) {
		this.packMode = packMode;
	}

	public Long getNoCavities() {
		return noCavities;
	}

	public void setNoCavities(Long noCavities) {
		this.noCavities = noCavities;
	}

}
