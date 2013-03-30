package extensions
import static org.junit.Assert.*;

import org.junit.Test;


class CodeJamExtensionsTest {
	
	@Test void shouldCreateListOfIntegersFromString() {
		assert [1, 2, 3] == "1 2 3".asListOfIntegers()
	}
	
	@Test void shouldClearFile() {
		def filePath = "src/test/resources/temp.txt"
		new File(filePath).setText('abc')
		
		assert new File(filePath).getText() == "abc"
		assert new File(filePath).clear().getText() == ""
	}

}
