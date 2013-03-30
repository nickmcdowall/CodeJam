
/**
 * Find two items that match exact credit value:
 * http://code.google.com/codejam/contest/351101/dashboard#s=p0
 */
import groovy.time.*

File inputFile = new File('src/main/resources/store_credit_input.txt')
File outputFile = new File('store_credit_output.txt').clear()

def findCombination = { itemValue, credit ->
	def efficientList = itemValue.findAll { it <= credit }
	def head = efficientList.head()
	def tail = efficientList.tail()
	def combination = [head, tail].combinations().find { 
		it.sum() == credit 
	}
	return combination?: call(tail, credit)
}

def testCase = 1
def toOutputFile = { result -> 
	outputFile << "Case #${testCase++}: ${result}\n"
}

def process = { inputLines ->
	def credit = inputLines[0].toInteger()
	def itemValues = inputLines[2].asListOfIntegers()
	def itemsThatMakeUpCredit = findCombination(itemValues, credit)
	def indexOfItems =  itemValues.findIndexValues { 
		itemsThatMakeUpCredit.contains(it) 
	}.collect { it + 1 }
	toOutputFile(indexOfItems.join(" "))
}


def startTime = new Date()

def allLines = inputFile.readLines()
allLines.remove(0)
allLines.collate(3).each { process(it) }

println "Done in ${TimeCategory.minus(new Date(), startTime)}"

