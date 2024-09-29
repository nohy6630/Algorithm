fun main() {
    val deque = ArrayDeque<Int>()
    val n = readln().toInt()
    val sb = StringBuilder()
    repeat(n) {
        val cmd = readln().split(" ")
        when (cmd[0].toInt()) {
            1 -> deque.addFirst(cmd[1].toInt())
            2 -> deque.addLast(cmd[1].toInt())
            3 -> sb.append(if (deque.isEmpty()) "-1\n" else "${deque.removeFirst()}\n")
            4 -> sb.append(if (deque.isEmpty()) "-1\n" else "${deque.removeLast()}\n")
            5 -> sb.append("${deque.size}\n")
            6 -> sb.append(if (deque.isEmpty()) "1\n" else "0\n")
            7 -> sb.append(if (deque.isEmpty()) "-1\n" else "${deque.first()}\n")
            8 -> sb.append(if (deque.isEmpty()) "-1\n" else "${deque.last()}\n")
        }
    }
    print(sb)
}