package cn.mldn.dibmp.vo;

import java.io.Serializable;

public class Critem implements Serializable {
private Long criid;
	private String title;

	@Override
	public String toString() {
		return "Critem [criid=" + criid + ", title=" + title + "]";
	}

	public Long getCriid() {
		return criid;
	}

	public void setCriid(Long criid) {
		this.criid = criid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
