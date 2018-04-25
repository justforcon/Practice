package test.second;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import test.TestBean;

@Service
public class TestService {
	private TestBean testBean;
	
	@Autowired
	public SecondTestBean secondTestBean(@Qualifier("main") TestBean testbean) {
		System.out.println(testbean);
		return new SecondTestBean();
	}
}
