/**
 * Spelling problem:
 * http://code.google.com/codejam/contest/351101/dashboard#s=p2
 */

File inputFile = new File('src/main/resources/spelling_input.txt')
File outputFile = new File('spelling_output.txt').clear()

Map characterMap = [:]

def putKeyAndGenerateValue = { val, key ->
	characterMap.put(key, val)
	val + val.charAt(0)
}

('a'..'c').inject("2", putKeyAndGenerateValue)
('d'..'f').inject("3", putKeyAndGenerateValue)
('g'..'i').inject("4", putKeyAndGenerateValue)
('j'..'l').inject("5", putKeyAndGenerateValue)
('m'..'o').inject("6", putKeyAndGenerateValue)
('p'..'s').inject("7", putKeyAndGenerateValue)
('t'..'v').inject("8", putKeyAndGenerateValue)
('w'..'z').inject("9", putKeyAndGenerateValue)
(' ').inject("0", putKeyAndGenerateValue)

def tempSeparator = ':'

def insertPauses = { String text ->
	(0..9).each {
		def pattern = /${it}${tempSeparator}${it}/
		def replacement = "$it $it"
		text = text.replaceAll(pattern, 
			replacement).replaceAll(pattern, replacement)
	}
	return text
}

def convert = { List<String> inputLines ->
	String output = inputLines[0]
	characterMap.keySet().each {
		output = output.replaceAll(it, characterMap[it] + tempSeparator)
	}
	return insertPauses(output).replaceAll(tempSeparator, '')
}

inputFile.codeJam(outputFile, 1, convert)