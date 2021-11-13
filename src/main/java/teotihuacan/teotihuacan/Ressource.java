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