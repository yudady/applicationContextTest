package tk.tommy.source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.tommy.source.bean.Config01;
import tk.tommy.source.bean.Config02;
import tk.tommy.source.bean.Config03;
import tk.tommy.source.vo.Car;
import tk.tommy.source.vo.Dog;
import tk.tommy.source.vo.Egg;

public class SourceApplication {

	public static void main(String[] args) throws InterruptedException {

		AnnotationConfigApplicationContext parentCtx = new AnnotationConfigApplicationContext(
			Config01.class);// parentCtx is ROOT CTX
		parentCtx.setDisplayName("parentCtx");
		Car car = parentCtx.getBean(Car.class);
		System.out.println(car);

		System.out.println("parentCtx啟動完成，準備加入一個新的AnnotationConfigApplicationContext");
		AnnotationConfigApplicationContext childCtx = new AnnotationConfigApplicationContext();
		childCtx.setDisplayName("childCtx");
		childCtx.registerBean(Config02.class);

		childCtx.setParent(parentCtx); // parent-child
		childCtx.refresh(); //child
		Dog dog = childCtx.getBean(Dog.class);
		System.out.println(dog);
		System.out.println("childCtx啟動完成，準備加入一個新的AnnotationConfigApplicationContext");

		AnnotationConfigApplicationContext childCtx2 = new AnnotationConfigApplicationContext();
		childCtx2.setDisplayName("childCtx2");
		childCtx2.registerBean(Config03.class);
		childCtx2.setParent(childCtx); // parent-child
		childCtx2.refresh(); //child2

		Egg egg = childCtx2.getBean(Egg.class);
		System.out.println(car);
		System.out.println(dog);
		System.out.println(egg);
		System.out.println("----子容器可以看到根容器中定义的beans，反之不行------------");
		//	System.out.println(parentCtx.getBean(Car.class));
		//	System.out.println(parentCtx.getBean(Dog.class));
		//	System.out.println(parentCtx.getBean(Egg.class));
		System.out.println(childCtx2.getBean(Car.class));
		System.out.println(childCtx2.getBean(Dog.class));
		System.out.println(childCtx2.getBean(Egg.class));

		childCtx2.close();
		System.out.println("把childCtx2 destroy 調用childCtx2.close()");
		System.out.println("==============");
		System.out.println(parentCtx.getDisplayName() + parentCtx.isActive());
		System.out.println(childCtx.getDisplayName() + childCtx.isActive());
		System.out.println(childCtx2.getDisplayName() + childCtx2.isActive());
		System.out.println("==============");
		System.out.println(childCtx.getDisplayName());
		System.out.println(childCtx.getBean(Dog.class));
		System.out.println("把childCtx存在Dog");

		childCtx2.close();
		System.out.println("把childCtx2 destroy 調用childCtx2.close()");

		System.out.println(childCtx);
		System.out.println(childCtx.getBean(Dog.class));
		System.out.println("把childCtx存在Dog");

		System.out.println("parentCtx destroy parentCtx.close()");
		parentCtx.close();
		System.out.println("==============");
		System.out.println("parentCtx.isActive()" + " isActive= " + parentCtx.isActive());
		System.out.println("childCtx.isActive()" + " isActive= " + childCtx.isActive());
		System.out.println("childCtx2.isActive()" + " isActive= " + childCtx2.isActive());
		System.out.println("==============");
		System.out.println(childCtx.getBean(Dog.class));
		System.out.println("把childCtx存在Dog");

		childCtx2 = new AnnotationConfigApplicationContext();
		parentCtx.setDisplayName("childCtx2");
		childCtx2.registerBean(Config03.class);
		childCtx2.setParent(childCtx); // parent-child
		childCtx2.refresh(); //child2
		System.out.println("==============");
		System.out.println(parentCtx.getDisplayName() + " isActive= " + parentCtx.isActive());
		System.out.println(childCtx.getDisplayName() + " isActive= " + childCtx.isActive());
		System.out.println(childCtx2.getDisplayName() + " isActive= " + childCtx2.isActive());
		System.out.println("==============");
		System.out.println(childCtx2.getDisplayName());
		System.out.println(childCtx2.getBean(Dog.class));
		System.out.println(childCtx2.getBean(Egg.class));
		System.out.println("把childCtx2存在Egg");

		parentCtx = new AnnotationConfigApplicationContext();
		parentCtx.registerBean(Config01.class);
		parentCtx.setDisplayName("parentCtx");
		parentCtx.setParent(childCtx2);
		parentCtx.refresh();
		System.out.println(parentCtx.getBean(Car.class));
		System.out.println("==============");
		System.out.println(parentCtx.getDisplayName() + " isActive= " + parentCtx.isActive());
		System.out.println(childCtx.getDisplayName() + " isActive= " + childCtx.isActive());
		System.out.println(childCtx2.getDisplayName() + " isActive= " + childCtx2.isActive());
		System.out.println("==============");
	}
}
