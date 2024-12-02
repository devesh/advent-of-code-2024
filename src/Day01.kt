fun main() {
    val number = Regex("[0-9]+")
    fun part1(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        input.forEach {
            val matches = number.findAll(it)
            list1.add(matches.first().value.toInt())
            list2.add(matches.last().value.toInt())
        }
        list1.sort()
        list2.sort()
        return list1.zip(list2).map{Math.abs(it.first - it.second)}.sum()
    }

    fun part2(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val map2 = mutableMapOf<Int, Int>()
        input.forEach {
            val matches = number.findAll(it)
            list1.add(matches.first().value.toInt())
            val num2 = matches.last().value.toInt()
            map2.put(num2, map2.getOrDefault(num2, 0) + 1)
        }

        return list1.map{ it * map2.getOrDefault(it, 0)}.sum()
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    check(part1(readInput("Day01_test")) == 11)

    // Part 2 test
    check(part2(readInput("Day01_test")) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
