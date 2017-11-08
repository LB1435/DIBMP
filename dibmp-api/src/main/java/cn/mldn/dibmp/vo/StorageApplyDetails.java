package cn.mldn.dibmp.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StorageApplyDetails implements Serializable {
	public Long sadid ;
	public Long said ; 
	public Long gid ; 
	public String name ; 
	public Integer num ; 
	public Double price ; 
	public Double weight ;
	public Long getSadid() {
		return sadid;
	}
	public void setSadid(Long sadid) {
		this.sadid = sadid;
	}
	public Long getSaid() {
		return said;
	}
	public void setSaid(Long said) {
		this.said = said;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
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
	@Override
	public String toString() {
		return "StorageApplyDetails [sadid=" + sadid + ", said=" + said + ", gid=" + gid + ", name=" + name + ", num="
				+ num + ", price=" + price + ", weight=" + weight + "]";
	} 
	
}
