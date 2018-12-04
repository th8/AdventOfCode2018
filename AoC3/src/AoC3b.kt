import java.awt.Point
import java.nio.file.Files
import java.nio.file.Paths
import java.util.regex.Matcher
import java.util.regex.Pattern

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

    for(claim in allClaims) {
        val claimCoordinates: ArrayList<Point> = getAllCoordinatesFromClaim(claim)
        var hasContestedClaim: Boolean = false;
        for(coordinate in claimCoordinates) {
            if(duplicateCoordinates.contains(coordinate)) {
                hasContestedClaim = true;
            }
        }
        if(!hasContestedClaim) {
            println(claim.id)
        }
    }
}