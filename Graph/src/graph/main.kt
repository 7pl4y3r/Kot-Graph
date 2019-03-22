package graph

fun main() {

    val pairs = ArrayList<Graph.Pair>()
    val t = Array(5) {0}

    Graph.addPairs(pairs)
    Graph.printPairs(pairs)
    Graph.dijkstra(pairs, 1, t)
    Graph.printWay(t, 1)

}