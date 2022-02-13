package uke7;

import java.util.ArrayList;
import java.util.Collection;


public class Folder {

    String name;
    Collection<Folder> folders = new ArrayList<>();
    Folder parent;

    

    public Folder(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
        if (parent != null) parent.addFolder(this);
    }

    private void addFolder(Folder folder) {
        this.folders.add(folder);
    }

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return name + "(" + folders + ")";
    }


    public static void main(String[] args) {
    Folder home = new Folder("home",null);
    Folder andreas = new Folder("andreas",home);
    Folder borgeh = new Folder("borgeh",home);
    Folder carsten = new Folder("carsten",home);
    Folder adiv = new Folder("adiv",andreas);
    Folder bdiv = new Folder("bdiv",borgeh);
    Folder cdiv = new Folder("cdiv",carsten);
    System.out.println(home);
    System.out.println(home.contains(borgeh));    
    System.out.println(borgeh.contains2(home));    
    }

    private boolean contains(Folder destination) {
        System.out.println("Contains sjekker: "+this.name + " mot "+destination.getName());
        if (this == destination) return true;
        for (Folder folder : folders) {
            if (folder.contains(destination)) return true;
        }
        return false;
    }

    private boolean contains2(Folder destination) {
        if (destination != null) System.out.println("Contains2 sjekker "+this.getName() +
        " mot "+destination.getName());
        if (destination == this) return true;
        else if (destination == null) return false;
        else return this.contains2(destination.getParent());
    }
}
