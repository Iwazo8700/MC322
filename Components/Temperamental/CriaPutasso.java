package Temperamental;

public class CriaPutasso implements FabricaStress{
    public Estresse FabricaEstresse(){
        return new Putasso();
    }
}
