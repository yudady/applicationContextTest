package tk.tommy.source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.tommy.source.bean.Config01;
import tk.tommy.source.bean.Config02;
import tk.tommy.source.bean.Config03;
import tk.tommy.source.vo.Car;
import tk.tommy.source.vo.Dog;
import tk.tommy.source.vo.Egg;

public class MarkdownTest01 {
	/**
	 * ## Large headline
	 * ### Smaller headline
	 *
	 * This is a comment that contains `code` parts.
	 *
	 * Code blocks:
	 *
	 * ```java
	 * int foo = 42;
	 * System.out.println(foo);
	 * ```
	 *
	 * Quote blocks:
	 *
	 * > This is a block quote
	 *
	 * lists:
	 *
	 * - first item
	 * - second item
	 * - third item
	 *
	 * This is a text that contains an [external link][link].
	 *
	 * [link]: http://external-link.com/
	 *
	 * @param id the user id
	 * @return the user object with the passed `id` or `null` if no user with this `id` is found
	 */
	public Car thisIsTestMarkdown1(long id) {
		return null;
	}

	/**
	 * # H1
	 * ## H2
	 * ### H3
	 * #### H4
	 * ##### H5
	 * ###### H6
	 *
	 *
	 *
	 *
	 * ## Large headline
	 * ### Smaller headline
	 *
	 * This is a comment that contains `code` parts.
	 *
	 * Code blocks:
	 *
	 * ```java
	 * int foo = 42;
	 * System.out.println(foo);
	 * ```
	 *
	 * Quote blocks:
	 *
	 * > This is a block quote
	 *
	 * lists:
	 *
	 * - first item
	 * - second item
	 * - third item
	 *
	 * This is a text that contains an [external link][link].
	 *
	 * [link]: http://external-link.com/
	 *
	 * @param id the user id
	 * @return the user object with the passed `id` or `null` if no user with this `id` is found
	 */
	public Car thisIsTestMarkdown2(long id) {
		return null;
	}
}
