fun convertToColumnLabels(startingNumber: Int, numberOfResults: Int): Array<String> {
    require(startingNumber > 0) { "Starting number must be greater than zero." }
    require(numberOfResults > 0) { "Number of results must be greater than zero." }
    require(startingNumber <= 17576) { "Starting number exceeds the maximum limit of 17576 (ZZZ)." }

    val results = mutableListOf<String>()

    for (i in 0 until numberOfResults) {
        val number = startingNumber + i
        if (number > 17576) {
            throw IllegalArgumentException("Results exceed the maximum limit of 17576 (ZZZ).")
        }
        results.add(numberToColumnLabel(number))
    }

    return results.toTypedArray()
}

fun numberToColumnLabel(number: Int): String {
    var num = number
    val label = StringBuilder()

    while (num > 0) {
        num-- // Adjust for zero-indexed base
        val remainder = num % 26
        label.append((remainder + 'A'.code).toChar())
        num /= 26
    }

    return label.reverse().toString()
}
