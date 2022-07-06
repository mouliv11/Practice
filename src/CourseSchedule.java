import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    private class Node {
        int id;
        List<Node> neighbors;
        int indegree = 0;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
    }

    private Node[] createNodes(int numCourses, int[][] prereq) {
        Node[] nodes = new Node[numCourses];
        for (int id=0; id<numCourses; id++) {
            nodes[id] = new Node(id);
        }

        for (int[] pre : prereq) {
            nodes[pre[1]].neighbors.add(nodes[pre[0]]);
            nodes[pre[0]].indegree++;
        }

        return nodes;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = createNodes(numCourses, prerequisites);
        Queue<Integer> q = new LinkedList<>();
        int courses = 0;
        for (int id=0; id<numCourses; id++) {
            if(nodes[id].indegree == 0)
                q.add(id);
        }

        while (!q.isEmpty()) {
            int id = q.remove();
            courses++;

            for (Node neighbor : nodes[id].neighbors) {
                nodes[neighbor.id].indegree--;
                if(nodes[neighbor.id].indegree == 0)
                    q.add(neighbor.id);
            }
        }
        return courses == numCourses;
    }



    public static void main(String args[]) {
        CourseSchedule c = new CourseSchedule();
        int[][] prereq = new int[][]{{0,1},{0,2},{1,3},{1,4},{3,4}};
        c.canFinish(5,prereq);
    }

}
