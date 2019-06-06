package Temperamental;

public class CriaCalmo implements FabricaStress{
    public Estresse FabricaEstresse(){
        return new Calmo();
    }
}
