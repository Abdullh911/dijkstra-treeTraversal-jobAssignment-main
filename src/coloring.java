import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class coloring {
    public coloring() {

        //hash for colours

        String[] colorsmap = {
                "Red", "Green", "Blue", "Yellow", "Purple", "Orange", "Pink", "Brown","Black", "White",
                "Maroon", "Lime", "Teal", "Cyan", "Magenta", "Silver", "Gray", "Olive", "SkyBlue", "Indigo",
                "Beige", "Turquoise", "Salmon", "Violet", "DarkRed", "DarkGreen", "DarkBlue", "DarkCyan", "DarkMagenta",
                "DarkOrange", "DarkSlateGray", "MediumAquamarine", "MediumPurple", "MediumSeaGreen", "MediumSlateBlue",
                "MediumTurquoise", "MediumVioletRed", "SaddleBrown", "SlateBlue", "SlateGray", "SpringGreen", "SteelBlue",
                "Tomato", "Thistle", "Tan", "RoyalBlue", "RosyBrown", "PowderBlue", "Plum", "Peru", "PapayaWhip", "PaleGreen",
                "PaleTurquoise", "PaleVioletRed", "OrangeRed", "NavajoWhite", "Moccasin", "MistyRose", "MediumOrchid",
                "MediumSpringGreen", "MediumBlue", "MediumSlateBlue", "LimeGreen", "LightSteelBlue", "LightSlateGray", "LightSkyBlue",
                "LightSalmon", "LightPink", "LightGreen", "LightGoldenrodYellow", "LightCyan", "LemonChiffon", "LavenderBlush",
                "Khaki", "Ivory", "IndianRed", "HotPink", "Goldenrod", "Gold", "FireBrick", "DarkSlateBlue", "DarkOliveGreen",
                "DarkKhaki", "DarkGoldenrod", "DarkCyan", "Cornsilk", "Chocolate", "Chartreuse", "BurlyWood", "Aquamarine", "AntiqueWhite"
        };

        //getting the input

        Scanner sc = new Scanner(System.in) ;
        System.out.println("welcome to class assignment");
        System.out.println("enter the classes :  // eg: A , B , C");
        String input = sc.nextLine() ;
        input = input.toUpperCase().replace(" ","") ;
        String[] classes = input.split(",") ;
        ArrayList<String> conflicting = new ArrayList<String>() ;
        System.out.println("enter the classes that can not occur simultaneously   // enter done when finished");
        while(!input.equals("done")){
            input = sc.nextLine() ;
            if(input.contains("-")){
                conflicting.add(input.toUpperCase()) ;
            }
        }

        //creating the nodes

        HashMap<String,classnode> nodes = new HashMap<>() ;
        //setting nodes
        for(String i : classes){
            nodes.put(i , new classnode(i,-1,new ArrayList<>())) ;
        }
        //setting neighbours
        for(String i : nodes.keySet()) {
            for (String j : conflicting) {
                if (j.contains(i)) {
                    j = j.replace("-", "");
                    j = j.replace(i, "");
                    if(nodes.containsKey(j)) {
                        nodes.get(i).addNeighbour(nodes.get(j));
                    }
                }
            }
        }
//        System.out.println("//////////");
//        for(String i : nodes.keySet()) {
//            for(classnode j : nodes.get(i).getNeighbours()){
//                System.out.println(i + "   neighbour   " + j.getName());
//            }
//        }
        ArrayList<Integer> colour = new ArrayList<>() ;
        for(String i : nodes.keySet()){
            colour.clear();
            for(classnode j : nodes.get(i).getNeighbours()){
                colour.add(j.colour) ;
            }
            for(int j = 0 ; j < classes.length ; j++){
                if(!colour.contains(j)){
                    nodes.get(i).setColour(j);
                    break;
                }
            }
//            System.out.println("------------------------------------------------------------------");
//            for(String k : nodes.keySet()){
//                System.out.println(k + "\tcolour\t"+nodes.get(k).colour);
//            }
//            System.out.println("------------------------------------------------------------------");
        }
        for(String i : nodes.keySet()){
            System.out.println(i + "\tcolour\t"+colorsmap[nodes.get(i).colour%100]);
        }
    }
}
