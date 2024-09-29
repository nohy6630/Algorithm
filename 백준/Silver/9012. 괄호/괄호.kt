fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val str = readln()
        sb.append(if (isValid(str)) "YES" else "NO").append('\n')
    }
    print(sb)
}

fun isValid(str: String): Boolean {
    val stack = ArrayDeque<Char>()
    for (c in str) {
        when (c) {
            '(' -> stack.addLast(c)
            ')' -> {
                if (stack.isEmpty())
                    return false
                stack.removeLast()
            }
        }
    }
    return stack.isEmpty()
}