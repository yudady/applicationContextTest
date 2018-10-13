package tk.tommy.source.bean;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import tk.tommy.source.vo.Car;
@Configurable
public class Config01 {


	@Bean
	public Car car(){
		return new Car();
	}
}
