package codejam;
/**
 * Reverse words problem:
 * http://code.google.com/codejam/contest/351101/dashboard#s=p1
 */
File inputFile = new File('src/main/resources/reverse_words_input.txt')
File outputFile = new File('reverse_words_output.txt').clear()

def splitReverseAndJoin = { it.split(" ").reverse().join(" ") }

inputFile.eachLine(0) { line, lineNum ->
	if (lineNum > 0) { 
		outputFile << "Case #${lineNum}: ${splitReverseAndJoin(line)}\n" 
	}
}

println outputFile.getText()

