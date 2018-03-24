package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class AccountsMergeTest {
	AccountsMerge acm = new AccountsMerge();
	
	@Test
	void test() {
		List<String> ls = new ArrayList<>();
		ls.add("John");ls.add("john@gmail.com");
		List<String> ls1 = new ArrayList<>();
		ls1.add("JohnCojone");ls1.add("john@gmail.com");ls1.add("john@yahoo.com");ls1.add("john@bagoo.com");
		List<String> ls2 = new ArrayList<>();
		ls2.add("Mary");ls2.add("mary@gmail.com");ls2.add("keerti@gmail.com");
		List<String> ls3 = new ArrayList<>();
		ls3.add("JohnJohnny");ls3.add("maryjane@gmail.com");ls3.add("mary@gmail.com");ls3.add("Johnmary@gmail.com");
		List<String> ls4 = new ArrayList<>();
		ls4.add("JohnDairy");ls4.add("john@gmail.com");ls4.add("Obamy@gmail.com");ls4.add("JohnBarry@gmail.com");
		List<List<String>> lsfilled= new ArrayList<>();
		lsfilled.add(ls);lsfilled.add(ls1);lsfilled.add(ls2);lsfilled.add(ls3);lsfilled.add(ls4);
		acm.accountsMerge(lsfilled);
	}

}
