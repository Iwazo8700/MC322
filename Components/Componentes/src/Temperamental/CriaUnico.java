package Temperamental;

public class CriaUnico implements IFabricaStress{
    public Estresse FabricaEstresse(){
        return new Unico();
    }
}
