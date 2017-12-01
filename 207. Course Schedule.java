class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);

        for(int i = 0; i < prerequisites.length; i ++) {
            int idx1 = prerequisites[i][0];
            int idx2 = prerequisites[i][1];
            graph.addEdge(idx2, idx1);
        }

        for(int i = 0; i < numCourses; i ++) {
            if(hasCycle(graph, i))return false;
        }

        return true;

    }

    private boolean hasCycle(Graph graph, int index) {
        if(graph.isVisited[index] == true)return false;
        graph.inStack[index] = true;

        for(int i = 0; i < graph.nodeList.get(index).size(); i ++) {
            int neighborIdx = graph.nodeList.get(index).get(i);
            if(graph.inStack[neighborIdx] == true)return true;
            if(hasCycle(graph, neighborIdx) == true)return true;
        }

        graph.inStack[index] = false;
        graph.isVisited[index] = true;
        return false;
    }
}

class Graph {
    public List<List<Integer>> nodeList;
    public boolean[] isVisited;
    public boolean[] inStack;

    public Graph(int n) {
        nodeList = new ArrayList<>(n);
        isVisited = new boolean[n];
        inStack = new boolean[n];

        for(int i = 0; i < n; i ++) {
            nodeList.add(new ArrayList<>());
        }
    }

    public void addEdge(int i, int j) {
        nodeList.get(i).add(j);
    }
}
