/**
 * Spelling problem:
 * http://code.google.com/codejam/contest/351101/dashboard#s=p2
 */
def ONE_LINE_AT_A_TIME = 1

File inputFile = new File('src/main/resources/spelling_input.txt')
File outputFile = new File('src/main/resources/spelling_output.txt').clear()

List buttons = [
	(' '),
	'',
	('a'..'c'),
	('d'..'f'),
	('g'..'i'),
	('j'..'l'),
	('m'..'o'),
	('p'..'s'),
	('t'..'v'),
	('w'..'z')
]

def tempSeparator = ':'

def insertPauses = { String text ->
	(0..9).each {
		def pattern = /${it}${tempSeparator}${it}/
		def replacement = "$it $it"
		text = text.replaceAll(pattern, replacement)
						.replaceAll(pattern, replacement)
	}
	return text
}

def repeat = { buttonIndex, buttonPushes ->
	String output = buttonIndex
	buttonPushes.times { output = output + buttonIndex }
	return output
}

def convertToButtonPushes = { List<String> inputLines ->
	String output = inputLines[0]
	buttons.eachWithIndex { characters, buttonIndex ->
		characters.eachWithIndex { character, buttonPushes ->
			String replacement = repeat(buttonIndex, buttonPushes)
			output = output.replaceAll(character, replacement + tempSeparator)
		}
	}
	return insertPauses(output).replaceAll(tempSeparator, '')
}

inputFile.codeJam(outputFile, ONE_LINE_AT_A_TIME, convertToButtonPushes)