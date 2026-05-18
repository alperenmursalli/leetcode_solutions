package greedyAlgorithm;
import java.util.*;

public class KruskalAlgorithm {

    static class Edge {
        int u;
        int v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            // Başta herkes kendi grubunun root'u
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // Root bulma + path compression
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        // İki grubu birleştirme
        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            // Zaten aynı gruptalarsa cycle oluşur
            if (rootA == rootB) {
                return false;
            }

            // Union by rank
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            return true;
        }
    }

    public static void kruskal(int n, List<Edge> edges) {
        // 1. Edge'leri ağırlığa göre küçükten büyüğe sırala
        edges.sort((e1, e2) -> e1.weight - e2.weight);

        DSU dsu = new DSU(n);

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        // 2. Küçükten büyüğe edge'leri kontrol et
        for (Edge edge : edges) {
            // Eğer cycle oluşturmuyorsa MST'ye ekle
            if (dsu.union(edge.u, edge.v)) {
                mst.add(edge);
                totalWeight += edge.weight;
            }

            // MST'de n - 1 edge olunca biter
            if (mst.size() == n - 1) {
                break;
            }
        }

        // Sonucu yazdır
        System.out.println("Minimum Spanning Tree edges:");

        for (Edge edge : mst) {
            System.out.println(edge.u + " - " + edge.v + " = " + edge.weight);
        }

        System.out.println("Total weight: " + totalWeight);
    }

    public static void main(String[] args) {
        int n = 5; // node sayısı: 0, 1, 2, 3, 4

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 1)); // A-B
        edges.add(new Edge(1, 2, 2)); // B-C
        edges.add(new Edge(0, 2, 3)); // A-C
        edges.add(new Edge(2, 3, 4)); // C-D
        edges.add(new Edge(1, 3, 5)); // B-D
        edges.add(new Edge(3, 4, 6)); // D-E
        edges.add(new Edge(2, 4, 7)); // C-E

        kruskal(n, edges);
    }
}