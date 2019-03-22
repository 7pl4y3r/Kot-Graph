package graph

class Graph {

    class Pair(val x: Int, val y: Int, val cost: Int)

    companion object {


        const val maxSize = 500


        fun addPairs(pairs: ArrayList<Graph.Pair>) {

            pairs.add(Graph.Pair(0, 0, 500))
            pairs.add(Graph.Pair(1, 2, 2))
            pairs.add(Graph.Pair(1, 3, 1))
            pairs.add(Graph.Pair(2, 4, 2))
            pairs.add(Graph.Pair(3, 4, 1))
            pairs.add(Graph.Pair(4, 5, 500))

        }


        fun printPairs(pairs: ArrayList<Graph.Pair>) {

            for (item in pairs)
                print("${item.x} - ${item.y} : ${item.cost}\n")

        }


        fun dijkstra(pairs: ArrayList<Graph.Pair>, x: Int, t: Array<Int>) {

            var mini = maxSize
            var y = -1

            val n = pairs.size
            val viz = Array(n + 1) {0}
            val c = Array(n + 1) {0}

            viz[x] = 1
            for (i in 1..n) {

                c[i] = findPair(pairs , x, i)
                if (x != i && c[i] < maxSize)
                    t[i] = x

            }


            for (i in 1..(n - 1)) {

                mini = maxSize
                for (j in 1..n) {

                    if (viz[j] == 0 && c[j] < maxSize) {
                        mini = c[j]
                        y = j
                    }

                }


                viz[y] = 1
                for (j in 1..n) {
                    if (viz[j] == 0) {
                        val thisCost = findPair(pairs, y, j)
                        if (c[j] > c[y] + thisCost && thisCost < maxSize) {
                            c[j] = c[y] + thisCost
                            t[j] = y
                        }

                    }

                }

            }

        }


        fun printWay(t: Array<Int>, i: Int) {

            if (t[i] != 0) {
                printWay(t, t[i])
                print("$i ")
            }

        }


        private fun findPair(pairs: ArrayList<Graph.Pair>, x: Int, y: Int): Int {

            for (element in pairs) {
                if (element.x == x && element.y == y)
                    return element.cost
            }

            return maxSize
        }


    }

}