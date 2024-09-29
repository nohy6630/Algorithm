fun main() {
    val n = readln().toInt()
    val type = readln().split(" ").map { it.toInt() }
    val data = readln().split(" ").map { it.toInt() }
    var m = readln().toInt()
    val num = readln().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    for (i in n - 1 downTo 0) {
        if (m <= 0)
            break
        if (type[i] == 0) {
            sb.append("${data[i]} ")
            m--
        }
    }
    for (i in num.indices) {
        if (m <= 0)
            break
        sb.append("${num[i]} ")
        m--;
    }
    println(sb)
}