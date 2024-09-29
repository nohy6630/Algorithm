fun main() {
    val n = readln().toInt()
    val queue = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(n) {
        val cmd = readln().split(" ")
        when (cmd[0]) {
            "push" -> queue.addLast(cmd[1].toInt())
            "pop" -> {
                if (queue.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.removeFirst()}\n")
                }
            }

            "size" -> sb.append("${queue.size}\n")
            "empty" -> sb.append(if (queue.isEmpty()) "1\n" else "0\n")
            "front" -> {
                if (queue.isEmpty())
                    sb.append("-1\n")
                else
                    sb.append("${queue.first()}\n")
            }

            "back" -> {
                if (queue.isEmpty())
                    sb.append("-1\n")
                else
                    sb.append("${queue.last()}\n")
            }
        }
    }
    print(sb)
}