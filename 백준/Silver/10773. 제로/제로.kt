fun main() {
    val k = readln().toInt()
    val stack = ArrayDeque<Int>()

    repeat(k) {
        val num = readln().toInt()

        if (num == 0)
            stack.removeLast()
        else
            stack.add(num)
    }
    var ans = 0
    while (stack.isNotEmpty())
        ans += stack.removeLast()
    println(ans)
}