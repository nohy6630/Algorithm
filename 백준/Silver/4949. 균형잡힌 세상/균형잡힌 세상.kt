fun main() {
    val sb = StringBuilder()
    while (true) {
        val str = readln()
        if (str == ".")
            break
        sb.append(if (isValid(str)) "yes" else "no").append('\n')
    }
    print(sb)
}

fun isValid(str: String): Boolean {
    val stack = ArrayDeque<Char>()
    for (c in str) {
        when (c) {
            '(' -> stack.addLast(c)
            '[' -> stack.addLast(c)
            ')' -> {
                if (stack.isEmpty() || stack.removeLast() != '(')
                    return false
            }
            ']' -> {
                if (stack.isEmpty() || stack.removeLast() != '[')
                    return false
            }
        }
    }
    return stack.isEmpty()
}