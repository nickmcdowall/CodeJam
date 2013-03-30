package extensions

class CodeJamExtensions {

	public static List<Integer> asListOfIntegers(String self) {
		return self.split(" ").collect { it.toInteger() }
	}
	
	public static File clear(File self) {
		self.setText("")
		return self
	}
}
