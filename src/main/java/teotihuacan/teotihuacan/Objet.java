package teotihuacan.teotihuacan;

public abstract class Objet {
    protected String type;

    @Override
    public String toString() {
        return type;
    }
}

class Ouvrier extends Objet {
    private int force = 1;

    public Ouvrier(){
        type = "ouvrier";
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void augmenterForce(){
        force +=1;
    }

    public void augmenterForceOuvriers(int[] index){
        for (int i : index){
            //ouvriers[i].augmenterForce();
        }
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
