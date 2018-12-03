import java.io.IOException
import java.nio.file.Paths
import java.util.*

private val fileName: String = "D:\\Users\\Thomas\\Projects\\AoC1\\src\\input.txt"
private var frequency: Int = 0;


fun main(args: Array<String>) {
    try {
        val scanner: Scanner =  Scanner(Paths.get(fileName))
        while (scanner.hasNextLine()) {
            val input: Int = scanner.nextInt();
            frequency += input;
            scanner.nextLine()
        }
    } catch(e: IOException) {
        System.out.println("File not found")
    }
    println(frequency);
}
