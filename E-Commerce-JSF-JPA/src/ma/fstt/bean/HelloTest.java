package ma.fstt.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloBean")
public class HelloTest {
	private String messge ;

	public String getMessge() {
		return messge;
	}

	public void setMessge(String messge) {
		this.messge = messge;
	}
	
	
	@PostConstruct
	private void init() {

		messge = "Hello World!! LSI 2 2021 ";
	}
}
