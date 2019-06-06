package Temperamental;

public class CriaPuto implements FabricaStress{
    public Estresse FabricaEstresse(){
        return new Puto();
    }
}
