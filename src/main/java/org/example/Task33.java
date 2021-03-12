package org.example;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Task33 {

    public static final int WALL_DISTANCE = 1000;

    public static int solution(int[][] map) {
        Graph graph = new Graph(map);
        Dijkstra firstTry = new Dijkstra(graph);
        firstTry.execute();
        int answer = firstTry.getPath().size();
        int firstTryDistance = firstTry.getPathDistance();

        Dijkstra wallTry = new Dijkstra(graph);
        for (Node node : graph.nodes) {
            if (node.type == Type.WALL) {
                int toWallDistance = firstTry.getShortestDistance(node) - (WALL_DISTANCE - 1);
                wallTry.execute(node);
                int wallTryDistance = wallTry.getPathDistance();
                int fromWallDistance = wallTry.getPath().size();
                int newAnswer = toWallDistance + fromWallDistance;
                if (newAnswer < answer && (wallTryDistance - WALL_DISTANCE - 1 + fromWallDistance) < firstTryDistance) {
                    answer = newAnswer;
                }
            }
        }
        return answer;
    }

    static class Dijkstra {
        private final List<Node> nodes;
        private final List<Edge> edges;
        private Set<Node> visitedNodes;
        private Set<Node> unvisitedNodes;
        private Map<Node, Node> predecessors;
        private Map<Node, Integer> distance;

        public Dijkstra(Graph graph) {
            this.nodes = new ArrayList<>(graph.nodes);
            this.edges = new ArrayList<>(graph.edges);
        }

        public void execute() {
            execute(nodes.get(0));
        }

        public void execute(Node source) {
            visitedNodes = new HashSet<>();
            unvisitedNodes = new HashSet<>();
            distance = new HashMap<>();
            predecessors = new HashMap<>();
            distance.put(source, 0);
            unvisitedNodes.add(source);

            while (unvisitedNodes.size() > 0) {
                Node node = getMinimum(unvisitedNodes);
                visitedNodes.add(node);
                unvisitedNodes.remove(node);
                findMinimalDistances(node);
            }
        }

        private void findMinimalDistances(Node node) {
            List<Node> adjacentNodes = getNeighbors(node);
            for (Node target : adjacentNodes) {
                if (getShortestDistance(target) > getShortestDistance(node)
                        + getDistance(node, target)) {
                    distance.put(target, getShortestDistance(node)
                            + getDistance(node, target));
                    predecessors.put(target, node);
                    unvisitedNodes.add(target);
                }
            }
        }

        private int getDistance(Node node, Node target) {
            for (Edge edge : edges) {
                if (edge.source.equals(node)
                        && edge.destination.equals(target)) {
                    return edge.weight;
                }
            }
            throw new RuntimeException("Input nodes are not neighbors");
        }

        private List<Node> getNeighbors(Node node) {
            List<Node> neighbors = new ArrayList<>();
            for (Edge edge : edges) {
                if (edge.source.equals(node)
                        && !isVisited(edge.destination)) {
                    neighbors.add(edge.destination);
                }
            }
            return neighbors;
        }

        private Node getMinimum(Set<Node> nodes) {
            Node minimum = null;
            for (Node node : nodes) {
                if (minimum == null) {
                    minimum = node;
                } else {
                    if (getShortestDistance(node) < getShortestDistance(minimum)) {
                        minimum = node;
                    }
                }
            }
            return minimum;
        }

        private boolean isVisited(Node node) {
            return visitedNodes.contains(node);
        }

        private int getShortestDistance(Node destination) {
            Integer d = distance.get(destination);
            if (d == null) {
                return Integer.MAX_VALUE;
            } else {
                return d;
            }
        }

        public int getPathDistance() {
            LinkedList<Node> nodes = getPath();
            int distance = 1;
            for (int i = 1; i < nodes.size(); i++) {
                Node source = nodes.get(i);
                Node dest = nodes.get(i - 1);
                distance += getDistance(source, dest);
            }
            return distance;
        }

        public LinkedList<Node> getPath() {
            return getPath(nodes.get(nodes.size() - 1));
        }

        public LinkedList<Node> getPath(Node target) {
            LinkedList<Node> path = new LinkedList<>();
            Node step = target;
            if (predecessors.get(step) == null) {
                return null;
            }
            path.add(step);
            while (predecessors.get(step) != null) {
                step = predecessors.get(step);
                path.add(step);
            }
            return path;
        }
    }

    static class Graph {
        final List<Node> nodes = new ArrayList<>();
        final List<Edge> edges = new ArrayList<>();

        public Graph(int[][] matrix) {
            int length = matrix[0].length;
            int id = 1;
            for (int[] ints : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    Type type = ints[j] == 0 ? Type.SPACE : Type.WALL;
                    nodes.add(new Node(id++, type));
                }
            }

            for (int i = 0; i < nodes.size(); i++) {
                Node source = nodes.get(i);
                if (source.id % length != 0) {
                    Node dest = nodes.get(i + 1);
                    addEdges(source, dest);
                }
                if (source.id <= nodes.size() - length) {
                    Node dest = nodes.get(i + length);
                    addEdges(source, dest);
                }
            }
        }

        public void addEdges(Node source, Node dest) {
            int weight = (source.type == Type.SPACE && dest.type == Type.SPACE ? 1 : WALL_DISTANCE);
            edges.add(new Edge(source, dest, weight));
            edges.add(new Edge(dest, source, weight));
        }
    }

    static class Node {
        final private int id;
        final private Type type;

        public Node(int id, Type type) {
            this.id = id;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(id, node.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    static class Edge {
        private final Node source;
        private final Node destination;
        private final int weight;

        public Edge(Node source, Node destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    enum Type {
        SPACE,
        WALL
    }
}
