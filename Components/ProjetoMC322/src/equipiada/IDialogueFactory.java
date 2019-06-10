package equipiada;

public interface IDialogueFactory {
    public static Dialogue createDialogue(){
        return new Dialogue();
    }
}
