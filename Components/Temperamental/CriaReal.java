package Temperamental;

public class CriaReal implements FabricaStress{
    public Estresse FabricaEstresse(){
        return new Real();
    }
}
