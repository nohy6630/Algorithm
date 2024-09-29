fun main() {
    val n = readln().toInt()
    val queue = ArrayDeque<Int>()
    repeat(n) {
        queue.addLast(it + 1)
    }
    repeat(n - 1) {
        queue.removeFirst()
        queue.addLast(queue.removeFirst())
    }
    print(queue.first())
}