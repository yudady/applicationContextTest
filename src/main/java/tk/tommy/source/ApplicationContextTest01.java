package tk.tommy.source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.tommy.source.bean.Config01;
import tk.tommy.source.bean.Config02;
import tk.tommy.source.bean.Config03;
import tk.tommy.source.vo.Car;
import tk.tommy.source.vo.Dog;
import tk.tommy.source.vo.Egg;
public class ApplicationContextTest01 {

	public static void main(String[] args) throws InterruptedException {

		AnnotationConfigApplicationContext parentCtx = new AnnotationConfigApplicationContext();
		parentCtx.setDisplayName("parentCtx");
		AnnotationConfigApplicationContext childCtx = new AnnotationConfigApplicationContext();
		childCtx.setDisplayName("childCtx");
		AnnotationConfigApplicationContext childCtx2 = new AnnotationConfigApplicationContext();
		childCtx2.setDisplayName("childCtx2");

		parentCtx.registerBean(Config01.class);
		childCtx.registerBean(Config02.class);
		childCtx2.registerBean(Config03.class);

		// parentCtx is ROOT CTX
		childCtx.setParent(parentCtx); // parent-child
		childCtx2.setParent(childCtx); // parent-child

		parentCtx.refresh(); // parent
		childCtx.refresh(); //child
		childCtx2.refresh(); //child2

		Car car = parentCtx.getBean(Car.class);
		Dog dog = childCtx.getBean(Dog.class);
		Egg egg = childCtx2.getBean(Egg.class);

		System.out.println(car);
		System.out.println(dog);
		System.out.println(egg);
		System.out.println("----子容器可以看到ROOT容器中定义的beans，反之不行------------");
		//	System.out.println(parentCtx.getBean(Car.class));
		//	System.out.println(parentCtx.getBean(Dog.class));
		//	System.out.println(parentCtx.getBean(Egg.class));
		System.out.println(childCtx2.getBean(Car.class));
		System.out.println(childCtx2.getBean(Dog.class));
		System.out.println(childCtx2.getBean(Egg.class));
		childCtx2.close();
	}
}