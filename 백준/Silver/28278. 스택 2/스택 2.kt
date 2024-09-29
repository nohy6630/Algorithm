fun main() {
    val n = readln().toInt()
    val stack = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(n) {
        val command = readln().split(" ")

        when (command[0]) {
            "1" -> {
                stack.addLast(command[1].toInt())
            }

            "2" -> {
                if (stack.isNotEmpty()) {
                    sb.append(stack.removeLast())
                } else {
                    sb.append(-1)
                }
            }

            "3" -> {
                sb.append(stack.size)
            }

            "4" -> {
                sb.append(if (stack.isEmpty()) 1 else 0)
            }

            "5" -> {
                if (stack.isNotEmpty()) {
                    sb.append(stack[stack.size - 1])
                } else {
                    sb.append(-1)
                }
            }
        }
        if (command[0] != "1")
            sb.append("\n")
    }
    println(sb)
}