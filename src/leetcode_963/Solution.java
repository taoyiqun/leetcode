package leetcode_963;

import java.util.*;

public class Solution {
    class Edge{
        private int[] point1;
        private int[] point2;
        public Edge(int[] point1,int[] point2){
            this.point1 = point1;
            this.point2 = point2;
        }

        public int[] getPoint1() {
            return point1;
        }

        public int[] getPoint2() {
            return point2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return Arrays.equals(getPoint1(), edge.getPoint1()) &&
                    Arrays.equals(getPoint2(), edge.getPoint2());
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(getPoint1());
            result = 31 * result + Arrays.hashCode(getPoint2());
            return result;
        }
    }
    class Point{
        private double x;
        private double y;
        private double length;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.getX(), getX()) == 0 &&
                    Double.compare(point.getY(), getY()) == 0 &&
                    Double.compare(point.getLength(), getLength()) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY(), getLength());
        }

        public Point(double x, double y, double length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getLength() {
            return length;
        }
    }
    public double minAreaFreeRect(int[][] points) {
        Edge edge = null;
        Point point = null;
        double x = 0;
        double y = 0;
        double lengh = 0;
        HashMap<Point, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++){
            for (int j = i+1; j < points.length;j++){
                edge = new Edge(points[i],points[j]);
                x = (double) (points[i][0] + points[j][0])/2;
                y = (double) (points[i][1] + points[j][1])/2;
                lengh = Math.pow(points[i][0] - points[j][0],2) + Math.pow(points[i][1] - points[j][1],2);
                point = new Point(x,y,lengh);
                if(map.containsKey(point)){
                    map.get(point).add(edge);
                }else {
                    map.put(point,new LinkedList<>());
                    map.get(point).add(edge);
                }
            }
        }
        double res = 0;
        double sq = 0;
        for (Point point1 : map.keySet()){
            List<Edge> edges = map.get(point1);
            if(edges.size() > 1){
                for (int i = 0; i < edges.size(); i++){
                    for(int j = i+1; j< edges.size();j++){
                        sq = Math.sqrt(Math.pow(edges.get(i).point1[0] - edges.get(j).point1[0],2) + Math.pow(edges.get(i).point1[1] - edges.get(j).point1[1],2))
                        * Math.sqrt(Math.pow(edges.get(i).point2[0] - edges.get(j).point1[0],2) + Math.pow(edges.get(i).point2[1] - edges.get(j).point1[1],2));
                        if(res == 0 || res > sq){
                            res = sq;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = {{1, 2}, {2, 1}, {1, 0}, {0, 1}};
        double res = solution.minAreaFreeRect(ints);
        System.out.println(res);
    }
}
