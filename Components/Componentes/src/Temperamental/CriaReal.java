package Temperamental;

public class CriaReal implements IFabricaStress{
    public Estresse FabricaEstresse(){
        return new Real();
    }
}
