package codejam;

/**
 * Spelling problem:
 * http://code.google.com/codejam/contest/351101/dashboard#s=p2
 */
	
	File inputFile = new File('src/main/resources/spelling_input.txt')
	File outputFile = new File('spelling_output.txt').clear()

	Map characterMap = [:]
	
	def buttons = (0..9)

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
	
	def insertPauses = { text ->
		buttons.each {
			def pattern = /$it:$it/
			def replacement = "$it $it"
			text = text.replaceAll(pattern, 
				replacement).replaceAll(pattern, replacement)
		}
		return text
	}

	def tempSeparator = ':'
	def convert = { line ->
		def output = line
		characterMap.keySet().each {
			output = output.replaceAll(it, characterMap[it] + tempSeparator)
		}
		return insertPauses(output).replaceAll(tempSeparator, '')
	}

	inputFile.eachLine(0) { line, lineNum ->
		if(lineNum > 0){ 
			outputFile << "Case #${lineNum}: ${convert(line)}\n"
		}
	}

	println outputFile.getText()

