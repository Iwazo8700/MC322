package Temperamental;

public class CriaCalmo implements IFabricaStress{
    public Estresse FabricaEstresse(){
        return new Calmo();
    }
}
