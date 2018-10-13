package tk.tommy.source.bean;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import tk.tommy.source.vo.Egg;
@Configurable
public class Config03 {

	@Bean
	public Egg egg() {
		return new Egg();
	}
}
