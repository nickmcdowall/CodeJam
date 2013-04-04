/**
 * Find two items that match exact credit value:
 * http://code.google.com/codejam/contest/351101/dashboard#s=p0
 */

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

def findTwoItemsThatSumTotalCredit = { List<String> inputLines ->
	def credit = inputLines[0].toInteger()
	def itemValues = inputLines[2].asListOfIntegers()
	def itemsThatMakeUpCredit = findCombination(itemValues, credit)
	def indexOfItems =  itemValues.findIndexValues { 
		itemsThatMakeUpCredit.contains(it) 
	}.collect { it + 1 }
	return indexOfItems.join(" ")
}

outputFile.codeJam(inputFile, 3, findTwoItemsThatSumTotalCredit)
