package telran.util;

import java.util.HashMap;

//all methods should be written with complexity o[1]
public class MyArray {
private int value = 0;
private int length;
private HashMap<Integer, Integer> mapIndexValues = new HashMap<>();
	/**
	 * creates MyArray object with a given length
	 * all elements are set in 0
	 * @param length
	 */
	public MyArray(int length) {
		this.length = length;
	}
	/**
	 * sets a given value in all array's elements
	 * @param value
	 */
	public void setValue(int value) {
		mapIndexValues = new HashMap<>();
		this.value = value;
	}
	/**
	 * 
	 * @param index
	 * returns value at a given index value
	 * throws ArrayIndexOutOfBoundsException in the case of wrong index
	 */
	public int getValueAt(int index) {
		
		if (!isValidIndex(index)) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return mapIndexValues.getOrDefault(index, value);
	}
	private boolean isValidIndex(int index) {
		
		return index >= 0 && index < length;
	}
	/**
	 * sets a given value at a given index
	 * @param index
	 * @param value
	 * throws ArrayIndexOutOfBoundsException in the case of wrong index
	 */
	public void setValueAt(int index, int value) {
		
		if (!isValidIndex(index)) {
			throw new ArrayIndexOutOfBoundsException();
		}
		mapIndexValues.put(index, value);
	}
}
