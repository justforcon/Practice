package test.second;

import org.springframework.stereotype.Component;

@Component
public class SecondTestBean {
	private String c;
	private String d;
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	@Override
	public String toString() {
		return "SecondTestBean [c=" + c + ", d=" + d + "]";
	}
	
}
