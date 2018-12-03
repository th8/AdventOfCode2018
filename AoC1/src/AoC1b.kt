import java.io.IOException
import java.nio.file.Paths
import java.util.*
import kotlin.collections.ArrayList

private val fileName: String = "D:\\Users\\Thomas\\Projects\\AoC1\\src\\input.txt"
private var frequency: Int = 0;
private var pastFrequencies: ArrayList<Int> = ArrayList();
private var duplicateFrequencyFound: Boolean = false;


fun main(args: Array<String>) {
    try {
        while(!duplicateFrequencyFound) {
            val scanner: Scanner =  Scanner(Paths.get(fileName))
            while (scanner.hasNextLine()) {
                val input: Int = scanner.nextInt();
                frequency += input;
                if (pastFrequencies.contains(frequency)) {
                    duplicateFrequencyFound = true;
                    break;
                }
                pastFrequencies.add(frequency);
                scanner.nextLine()
            }
        }
    } catch(e: IOException) {
        System.out.println("File not found")
    }
    println("The repeated frequency is: "+frequency);
}
