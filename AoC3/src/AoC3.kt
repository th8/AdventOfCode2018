import java.awt.Point
import java.nio.file.Files
import java.nio.file.Paths
import java.util.regex.Matcher
import java.util.regex.Pattern

val fileName: String = "D:\\Users\\Thomas\\Projects\\AoC3\\src\\input.txt"

fun main(args: Array<String>) {
    val allClaims: ArrayList<Claim> = getAllClaimsFromFile(fileName)
    val allCoordinates: ArrayList<Point> = getAllCoordinatesFromClaims(allClaims)

    val duplicateCoordinates: HashSet<Point> = HashSet()
    val coordinateSet: HashSet<Point> = HashSet()

    for(coordinate in allCoordinates) {
        if(!coordinateSet.add(coordinate)) {
            duplicateCoordinates.add(coordinate)
        }
    }

    println("The amount of contested inches is: " + duplicateCoordinates.size)

}


fun getAllClaimsFromFile(fileName: String): ArrayList<Claim> {
    val allClaims: ArrayList<Claim> = ArrayList();

    Files.lines(Paths.get(fileName)).forEach {
        line ->
        val claimMatcher: Matcher = Pattern.compile("(#\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)").matcher(line)
        claimMatcher.matches();
        val claim = Claim(claimMatcher.group(1), claimMatcher.group(2).toInt(), claimMatcher.group(3).toInt(), claimMatcher.group(4).toInt(), claimMatcher.group(5).toInt())
        allClaims.add(claim)
    }
    return allClaims;
}

fun getAllCoordinatesFromClaims(allClaims: ArrayList<Claim>): ArrayList<Point> {
    val allCoordinates: ArrayList<Point> = ArrayList()
    for(claim in allClaims) {
        val coordinates: ArrayList<Point> = getAllCoordinatesFromClaim(claim)
        for(coordinate in coordinates) {
            allCoordinates.add(coordinate)
        }
    }
    return allCoordinates
}

fun getAllCoordinatesFromClaim(claim: Claim): ArrayList<Point> {
    val allCoordinatesFromClaim: ArrayList<Point> = ArrayList()

    val firstXCoordinate: Int = claim.offsetLeft + 1
    val lastXCoordinate: Int = claim.offsetLeft + claim.width

    for(x in firstXCoordinate..lastXCoordinate) {
        val firstYCoordinate: Int = claim.offsetTop + 1
        val lastYCoordinate: Int = claim.offsetTop + claim.height
        for(y in firstYCoordinate..lastYCoordinate) {
            val coordinate = Point(x, y)
            allCoordinatesFromClaim.add(coordinate)
        }

    }
    return allCoordinatesFromClaim
}
