// Alan Kim
// LetterInventory keeps track of an inventory of letters of the alphabet.

public class LetterInventory {
	private int[] counter;
	private static final int LETTER_COUNT = 26; 
	private int size;
	
	// Pre: none.
	// Post: Returns the given character in lower case.
	private char lower(char l) {
		return Character.toLowerCase(l);
	}
	
	// Pre: none.
	// Post: Constructs an empty inventory.
	public LetterInventory() {
		this("");
	}
	
	// Pre: A word must be passed in.
	// Post: Constructs an inventory of the alphabetic letters 
	// in the given word.
	public LetterInventory(String data) {
		this.size = 0;
		this.counter = new int[LETTER_COUNT]; 
		for (int i = 0; i < data.length(); i++) {
			char l = lower(data.charAt(i));
			if (l >= 'a' && l <= 'a' + LETTER_COUNT - 1) {
				this.counter[l - 'a']++;
				this.size++;
			}
		}
	}
	
	// Pre: none.
	// Post: Returns the sum of all the counts in this inventory.
	public int size() {
		return this.size;
	}
	
	// Pre: none.
	// Post: Returns true if all counts in this inventory is 0.
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	// Pre: Throws an IllegalArgumentException 
	// if a non-alphabetic letter is given.
	// Post: Returns the number of times the given letter 
	// appears in this inventory. 
	public int get(char letter) {
		char l = lower(letter);
		return this.counter[l - 'a']; 
	}
	
	// Pre: none.
	// Post: Returns a String representation of this inventory.
	public String toString() {
		String s = "[";
		for (int i = 0; i < this.counter.length; i++) {
			int count = this.counter[i];
			if (count > 0) {
				for (int j = 0; j < count; j++) {
					s += (char) ('a' + i);
				}
				
			}
			
		}
		
		return s + "]";		
	}
	
	// Pre: Throws an IllegalArgumentException
	// if a non-alphabetic letter or a negative value is given.
	// Post: Sets the count for the given letter to the given value.
	public void set(char letter, int value) {
		char l = lower(letter);
		this.size -= this.counter[l - 'a'];
		this.counter[l - 'a'] = value;
		this.size += value;
	}
	
	// Pre: none.
	// Post: Returns a new LetterInventory that represents
	// the sum of this inventory and the other given inventory. 
	public LetterInventory add(LetterInventory other) {
		LetterInventory n = new LetterInventory();
		for (int i = 0; i < LETTER_COUNT; i++) {
			int sum = this.counter[i] + other.counter[i];
			n.counter[i] = sum;
			n.size += sum;
		}
		
		return n;
	}
	
	// Pre: none. 
	// Post: Returns a new LetterInventory that represents 
	// the difference of subtracting the given inventory 
	// from this inventory.
	public LetterInventory subtract(LetterInventory other) {
		LetterInventory n = new LetterInventory();
		for (int i = 0; i < LETTER_COUNT; i++) {
			int difference = this.counter[i] - other.counter[i];
			if (difference < 0) {
				return null;
			}
			
			n.counter[i] = difference;
			n.size += difference;
		}
		
		return n;
	}
	
	// Pre: Throws an IllegalArgumentException 
	// if a non-alphabetic character is given.
	// Post: Returns a double representing the percentage
	// of letters in this inventory that match the given character.
	public double getLetterPercentage(char letter) {
		if (!this.isEmpty()) {
			return (double) this.counter[lower(letter) - 'a'] / this.size;
		}
		
		return 0.0;
	}
	
}
