fun main() {
    val sb = StringBuilder()
    val n = readln()
    val nums = readln().split(" ").map { it.toInt() }
    val stack = ArrayDeque<Int>()

    var current = 1
    for (n in nums) {
        if (n == current)
            current++
        else
            stack.addLast(n)
        while (stack.isNotEmpty() && stack.last() == current) {
            stack.removeLast()
            current++
        }
    }
    if (stack.isEmpty())
        sb.append("Nice\n")
    else
        sb.append("Sad\n")
    print(sb)
}