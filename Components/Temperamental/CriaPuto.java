package Temperamental;

public class CriaPuto implements IFabricaStress{
    public Estresse FabricaEstresse(){
        return new Puto();
    }
}
