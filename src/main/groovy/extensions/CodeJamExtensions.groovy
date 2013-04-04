package extensions
import groovy.time.*

class CodeJamExtensions {

	public static List<Integer> asListOfIntegers(String self) {
		return self.split(" ").collect { it.toInteger() }
	}

	public static List<BigInteger> asListOfBigIntegers(String self) {
		return self.split(" ").collect { it.toBigInteger() }
	}

	public static List ascending(List self) {
		self.sort()
	}
	
	public static List descending(List self) {
		self.sort().reverse()
	}

	public static TimeDuration elapsedTime(Date self) {
		return TimeCategory.minus(new Date(), self)
	}

	public static File clear(File self) {
		self.setText("")
		return self
	}

	public static void addTestCaseResult(File self, int testNumber, Object result) {
		self << "Case #${testNumber}: ${result}\n"
	}

	public static void codeJam(File self, File inputFile, int linesPerTestCase, Closure givenFunction) {
		def startTime = new Date()
		def allLines = inputFile.readLines()
		allLines.remove(0) //First line just lists the number of test cases.

		def testNum = 1
		allLines.collate(linesPerTestCase).each { List<String> inputLines ->
			self.addTestCaseResult(testNum++, givenFunction(inputLines))
		}
		
		println self.getText()
		println "Done in ${startTime.elapsedTime()}"
	}

}
