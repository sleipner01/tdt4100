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
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }

    public void removeFolder(Folder folder) {
        this.folders.remove(folder);
    }

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return name;
    }


    public static void main(String[] args) {
    Folder home = new Folder("home",null);
    Folder andreas = new Folder("andreas",home);
    Folder borgeh = new Folder("borgeh",home);
    Folder carsten = new Folder("carsten",home);
    Folder adiv = new Folder("adiv",andreas);
    Folder bdiv = new Folder("bdiv",borgeh);
    Folder btmp = new Folder("btmp",borgeh);
    Folder cdiv = new Folder("cdiv",carsten);
    System.out.println(home);
    // System.out.println(home.contains(borgeh));    
    // System.out.println(borgeh.contains2(home));
    // cdiv.move(bdiv);
    // File homefile = new File("home.txt", home);
    // home.printTree();
    }
}
