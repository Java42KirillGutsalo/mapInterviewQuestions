package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayTests {
private static final int N_ELEMENTS = 1000000000;
private static final int VALUE = 50;
MyArray array;
	@BeforeEach
	void setUp() throws Exception {
		array = new MyArray(N_ELEMENTS);
		array.setValue(VALUE);
	}

	

	@Test
	void testSetValue() {
		int index = (int)(Math.random() * N_ELEMENTS);
		assertEquals(VALUE, array.getValueAt(index));
		int newValue = VALUE - 20;
		array.setValueAt(index, newValue);
		assertEquals(newValue, array.getValueAt(index));
		array.setValue(VALUE);
		assertEquals(VALUE, array.getValueAt(index));
		
	}

	@Test
	void testGetValueAt() {
		//getValueAt with right index is tested in testSetValue
		//here we test getValueAt with wrong index values
		runTestWrongIndex(-10, true);
		runTestWrongIndex(N_ELEMENTS, true);
		
	}

	private void runTestWrongIndex(int index, boolean isGet) {
		boolean flException = false;
		try {
			if (isGet) {
				array.getValueAt(index);
			} else {
				array.setValueAt(index, VALUE);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			flException = true;
		}
		assertTrue(flException);
		
	}



	@Test
	void testSetValueAt() {
		runTestWrongIndex(-10, false);
		runTestWrongIndex(N_ELEMENTS, false);
	}

}
© 2022 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
