package cn.mldn.dibmp.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class StorageRecord implements Serializable {
	public Long srid ; 
	public Long said ; 
	public Long wid ; 
	public String name ; 
	public Integer num ; 
	public Double price ; 
	public Double weight ; 
	public Integer status ; 
	public String inmid ; 
	public Date redate ;
	public String appmid ;
	public Long getSrid() {
		return srid;
	}
	public void setSrid(Long srid) {
		this.srid = srid;
	}
	public Long getSaid() {
		return said;
	}
	public void setSaid(Long said) {
		this.said = said;
	}
	public Long getWid() {
		return wid;
	}
	public void setWid(Long wid) {
		this.wid = wid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getInmid() {
		return inmid;
	}
	public void setInmid(String inmid) {
		this.inmid = inmid;
	}
	public Date getRedate() {
		return redate;
	}
	public void setRedate(Date redate) {
		this.redate = redate;
	}
	public String getAppmid() {
		return appmid;
	}
	public void setAppmid(String appmid) {
		this.appmid = appmid;
	}
	@Override
	public String toString() {
		return "StorageRecord [srid=" + srid + ", said=" + said + ", wid=" + wid + ", name=" + name + ", num=" + num
				+ ", price=" + price + ", weight=" + weight + ", status=" + status + ", inmid=" + inmid + ", redate="
				+ redate + ", appmid=" + appmid + "]";
	} 
	
}
