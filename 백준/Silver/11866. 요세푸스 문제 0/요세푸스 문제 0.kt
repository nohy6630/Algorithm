fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    val queue = ArrayDeque<Int>()
    sb.append("<")
    repeat(n) {
        queue.add(it + 1)
    }
    repeat(n) {
        repeat(k - 1) {
            queue.addLast(queue.removeFirst())
        }
        sb.append(queue.removeFirst())
        if (it != n - 1)
            sb.append(", ")
    }
    sb.append(">")
    print(sb)
}