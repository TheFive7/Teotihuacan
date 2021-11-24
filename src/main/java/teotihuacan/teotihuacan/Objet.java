package teotihuacan.teotihuacan;

public abstract class Objet {
    protected String type;

    @Override
    public String toString() {
        return type;
    }
}

class Ouvrier extends Objet {
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

class Plateau extends Objet {
    public Plateau(){
        type = "plateau";
    }
}

class Pion extends Objet {
    public Pion(){
        type = "pion";
    }
}
