package teotihuacan.teotihuacan;

public abstract class Ressource {
    protected String type;

    public Ressource(){}

    @Override
    public String toString() {
        return type;
    }
}

class Cacao extends Ressource {
    public Cacao(){type = "cacao";}
}

class Bois extends Ressource {
    public Bois(){type = "bois";}
}

class Pierre extends Ressource {
    public Pierre(){type = "pierre";}
}

class Or extends Ressource {
    public Or(){type = "or";}
}

class Ouvrier extends Ressource {
    private int force;

    public Ouvrier(){
        type = "ouvrier";
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }
}

class Plateau extends Ressource {
    public Plateau(){
        type = "plateau";
    }
}

class Pion extends Ressource {
    public Pion(){
        type = "pion";
    }
}