/**
 * Finding the minimum scalar product:
 * http://code.google.com/codejam/contest/32016/dashboard#s=p0
 */

File inputFile = new File('src/main/resources/minimum_scalar_product_input.txt')
File outputFile = new File('minimum_scalar_product_output.txt').clear()

def calculateMinimumScalarProduct = { List<String> input ->
	List<BigInteger> scalar1 = input[1].asListOfBigIntegers().ascending()
	List<BigInteger> scalar2 = input[2].asListOfBigIntegers().descending()
	List<BigInteger> transpose = [scalar1, scalar2].transpose()
	return transpose.sum { it[0].multiply it[1] } 
}

outputFile.codeJam(inputFile, 3, calculateMinimumScalarProduct)
