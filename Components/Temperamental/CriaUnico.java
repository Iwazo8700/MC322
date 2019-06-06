package Temperamental;

public class CriaUnico implements FabricaStress{
    public Estresse FabricaEstresse(){
        return new Unico();
    }
}
