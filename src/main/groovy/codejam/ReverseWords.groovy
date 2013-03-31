
import java.io.File;

/**
 * Reverse words problem:
 * http://code.google.com/codejam/contest/351101/dashboard#s=p1
 */
File inputFile = new File('src/main/resources/reverse_words_input.txt')
File outputFile = new File('reverse_words_output.txt').clear()

def splitReverseAndJoin = { List<String> input ->
	input[0].split(" ").reverse().join(" ") 
}

inputFile.codeJam(outputFile, 1, splitReverseAndJoin)

