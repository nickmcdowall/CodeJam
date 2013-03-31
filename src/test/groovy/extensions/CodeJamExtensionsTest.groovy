package extensions
import static org.junit.Assert.*;

import org.junit.Test;


class CodeJamExtensionsTest {
	
	@Test void shouldCreateListOfIntegersFromString() {
		assert [1, 2, 3] == "1 2 3".asListOfIntegers()
	}
	
	@Test void shouldClearFile() {
		def filePath = "src/test/resources/clear.txt"
		def file = new File(filePath)
		
		file.setText('abc')
		assert file.getText() == "abc"
		assert file.clear().getText() == ""
	}
	
	@Test void shouldAddTestCaseResult() {
		def filePath = "src/test/resources/test_case_output.txt"
		def output = new File(filePath).clear()
		
		output.addTestCaseResult(1, "A result")
		assert output.getText() == "Case #1: A result\n"
	}
	
	@Test void shouldSortAscendingAndDescending() {
		def list = [1,3,2,5,4]
		assert list.ascending() == [1,2,3,4,5]
		assert list.descending() == [5,4,3,2,1]
	}

}
