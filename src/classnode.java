import java.util.ArrayList;

public class classnode {
    protected String name ;
    protected int colour ;

    public classnode() {}

    protected ArrayList<classnode> neighbours ;

    public classnode(String name, int colour, ArrayList<classnode> neighbours) {
        this.name = name;
        this.colour = colour;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public ArrayList<classnode> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<classnode> neighbours) {
        this.neighbours = neighbours;
    }
    public void addNeighbour(classnode neighbour){
        this.neighbours.add(neighbour) ;
    }
}

