fun main(args: Array<String>) {
    print("Enter a number here to convert it to word: ")
    val number = readlnOrNull()?.toIntOrNull()
    if (number != null) {
        val words = convertToWords(number)
        print("The Number In Words:--> $words")
    } else {
        print("Please enter valid number!!")
    }
}
fun convertToWords(number: Int): String {
    val units = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val teens = arrayOf("", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    val tens = arrayOf("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

    return when {
        number < 10 -> {
            units[number]
        }
        number in 11..19 -> teens[number - 10]
        number < 100 -> tens[number / 10] + if (number % 10 != 0) " ${units[number % 10]}" else ""
        number < 1000 -> units[number / 100] + " hundred" + if (number % 100 != 0) " and ${convertToWords(number % 100)}" else ""
        number < 1000000 -> {
            val thousands = convertToWords(number / 1000)
            val remainder = if (number % 1000 != 0) " ${convertToWords(number % 1000)}" else ""
            "$thousands thousand$remainder"
        }
        else -> "Number out of range"
    }
}

