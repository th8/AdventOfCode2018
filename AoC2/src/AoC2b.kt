import org.apache.commons.lang3.StringUtils
import org.apache.commons.text.similarity.LevenshteinDistance
import java.nio.file.Files
import java.nio.file.Paths
import java.util.regex.Pattern

private val fileName: String = "D:\\Users\\Thomas\\Projects\\AoC2\\src\\input.txt";


fun main(args: Array<String>) {
    val IDs: HashSet<String> = HashSet();
    var result: String = "";

    Files.lines(Paths.get(fileName)).forEach {
        line -> IDs.add(line)
    }
    for(ID in IDs) {
        val words: ArrayList<String> = findSimilarWordsWithLevenshtein(ID, IDs)
        if(words.size > 0) {
            result = stripWordsOfNonMatchingCharacters(words.get(0), words.get(1))
            println("The letters the box ID's have in common are: " + result)
            break
        }
    }
}

fun findSimilarWordsWithLevenshtein(wordToCheck: String, setToCheck: HashSet<String>): ArrayList<String> {
    val levenshteinDistance = LevenshteinDistance();
    val words: ArrayList<String> = ArrayList();
    for(IDFromSet in setToCheck) {
        if (levenshteinDistance.apply(wordToCheck, IDFromSet) == 1) {

            words.add(wordToCheck)
            words.add((IDFromSet))
            break
        }
    }
    return words;
}

fun stripWordsOfNonMatchingCharacters(wordToStrip: String, pattern: String): String {
    var result: String = ""
    for(index in wordToStrip.indices) {
        if(wordToStrip[index] == pattern[index]) {
            result += wordToStrip[index]
        }
    }
    return result;
}
