import org.apache.commons.lang3.StringUtils
import java.nio.file.Files
import java.nio.file.Paths

private val fileName: String = "D:\\Users\\Thomas\\Projects\\AoC2\\src\\input.txt";
var doubleLetters: Int = 0
var tripleLetters: Int = 0

fun main(args: Array<String>) {
    Files.lines(Paths.get(fileName)).forEach {
        line ->
        doubleLetters += checkContainsAmountOfTimes(line, 2)
        tripleLetters += checkContainsAmountOfTimes(line, 3)
    }
    println("Checksum is: "+ (doubleLetters * tripleLetters))
}

fun checkContainsAmountOfTimes(input: String, amountOfTimes: Int): Int {
    var contains: Int = 0;
    for(i in input.toHashSet()) {
        if (StringUtils.countMatches(input, i) == amountOfTimes) {
            contains = 1
        }
    }
    return contains;
}