package equipiada;

public class DialogueFactory implements IDialogueFactory {
    public static Dialogue createDialogue(){
        return new Dialogue();
    }
}