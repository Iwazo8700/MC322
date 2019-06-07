package Temperamental;

public class CriaPutasso implements IFabricaStress{
    public Estresse FabricaEstresse(){
        return new Putasso();
    }
}
