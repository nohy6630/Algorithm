data class Balloon(val index: Int, val value: Int)

fun main() {
    val n = readln().toInt()
    val balloons = readln().split(" ").map { it.toInt() }
    val deque = mutableListOf<Balloon>()
    val sb = StringBuilder()
    for (i in 1..n)
        deque.add(Balloon(i, balloons[i - 1]))
    var move = deque.first().value
    sb.append(deque.removeFirst().index)
    while (deque.isNotEmpty()) {
        if (move > 0) {
            repeat(move - 1) {
                deque.add(deque.removeFirst())
            }
        } else {
            repeat(-move) {
                deque.add(0, deque.removeLast())
            }
        }
        move = deque.first().value
        sb.append(" ${deque.removeFirst().index}")
    }
    print(sb.toString())
}