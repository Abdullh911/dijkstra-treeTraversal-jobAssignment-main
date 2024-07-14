import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class dijkstra {
    static ArrayList<Integer>distanceFromSource=new ArrayList<>();
    static ArrayList<Character>nodes=new ArrayList<>();
    static ArrayList<Character>prevNode=new ArrayList<>();
    static ArrayList<Boolean>visited=new ArrayList<>();
    static ArrayList<String>paths=new ArrayList<>();
    public static void dijkstraAlg(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter List of Airports: ");
        String n= sc.nextLine();
        String[] nodesArray = n.replaceAll("\\s", "").split(",");

        for (String s : nodesArray) {
            if (s.length() > 0) {
                nodes.add(s.charAt(0));
            }
            distanceFromSource.add(0);
            visited.add(false);
            prevNode.add('`');
        }
        System.out.println("Enter the flights: ");
        String path= sc.nextLine();
        String[] pairs = path.split(", ");
        for (String pair : pairs) {
            paths.add(pair.trim());
        }
        int map[][]=new int[nodes.size()][nodes.size()];
        for(int[]a:map){
            Arrays.fill(a,0);
        }
        for(int i=0;i<paths.size();i++){
            System.out.print(paths.get(i)+": ");
            int pathLength=sc.nextInt();
            sc.nextLine();
            char nd1=paths.get(i).charAt(0),nd2=paths.get(i).charAt(2);
            map[nodes.indexOf(nd1)][nodes.indexOf(nd2)]=pathLength;
            map[nodes.indexOf(nd2)][nodes.indexOf(nd1)]=pathLength;
        }

        Collections.fill(distanceFromSource,(int)Double.POSITIVE_INFINITY);
        System.out.println("Enter source airport: ");
        char start=sc.next().charAt(0);
        System.out.println("Enter destination airport: ");
        char end=sc.next().charAt(0);
        distanceFromSource.set(nodes.indexOf(start),0);
        for(int i=0;i<nodes.size();i++) {
            int nodInd;
            if (i == 0) {
                nodInd = nodes.indexOf(start);
                visited.set(nodInd, true);
            } else {
                nodInd = selectedNode();
                visited.set(nodInd, true);
            }
            for (int j = 0; j < map[nodInd].length; j++) {
                if (map[nodInd][j] != 0) {
                    if (distanceFromSource.get(j) > distanceFromSource.get(nodInd) + map[nodInd][j]) {
                        distanceFromSource.set(j, distanceFromSource.get(nodInd) + map[nodInd][j]);
                        prevNode.set(j, nodes.get(nodInd));
                    }
                }
            }
        }
        String pathh=""+end;
        char prev=prevNode.get(nodes.indexOf(end));
        while(prev!=start){
            pathh+="-"+prev;
            prev=prevNode.get(nodes.indexOf(prev));
        }
        pathh+="-"+start;
        StringBuilder reversedStringBuilder = new StringBuilder(pathh).reverse();
        pathh=reversedStringBuilder.toString();
        System.out.println("Shortest path from "+start+" to "+end+":"+pathh);
        System.out.println("Total distance: "+distanceFromSource.get(nodes.indexOf(end))+" miles");


    }
    public static int selectedNode(){
        int min=(int)Double.POSITIVE_INFINITY;
        int minInd=-1;
        for(int i=0;i<nodes.size();i++){
            if(distanceFromSource.get(i)<min && !visited.get(i)){
                min=distanceFromSource.get(i);
                minInd=i;
            }
        }
        return minInd;
    }
}
