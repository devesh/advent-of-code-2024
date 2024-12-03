fun main() {

    fun isSafe(levels: List<Int>): Int {
        if (levels.get(1) > levels.get(0)) {
            for (i in 1..levels.size-1) {
                val difference = levels.get(i) - levels.get(i - 1)
                if (difference < 1 || difference > 3) {
                    return 0
                }
            }
            return 1
        } else if (levels.get(1) < levels.get(0)) {
            for (i in 1..levels.size-1) {
                val difference = levels.get(i - 1) - levels.get(i)
                if (difference < 1 || difference > 3) {
                    return 0
                }
            }
            return 1
        }
        return 0
    }

    fun part1(input: List<String>): Int {
        return input.map {
            val levels = it.split(" ").map{it.toInt()}
            isSafe(levels)
        }.sum()
    }

    fun part2(input: List<String>): Int {
        return input.map {
            val levels = it.split(" ").map{it.toInt()}
            if (isSafe(levels) == 1) {
                return@map 1
            } else {
                for (i in 0..levels.size-1) {
                    if (isSafe(levels.filterIndexed{index, _ -> index != i}) == 1) {
                        return@map 1
                    }
                }
            }
            0
        }.sum()
    }

    // Or read a large test input
    check(part1(readInput("Day02_test")) == 2)

    // Part 2 test
    check(part2(readInput("Day02_test")) == 4)

    // Read the input
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
