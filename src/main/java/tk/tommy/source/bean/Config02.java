package tk.tommy.source.bean;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import tk.tommy.source.vo.Dog;
@Configurable
public class Config02 {

	@Bean public Dog dog() {
		return new Dog();
	}
}
