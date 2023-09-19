package ch.zhaw.ads;

/**
 * AnyServer -- Praktikum Experimentierkasten -- ADS
 *
 */
public class AnyServer implements CommandExecutor {
    //----- Dies implementiert das CommandExecutor Interface.
    @Override
    public String execute(String command) {
        return "Die Eingabe ist \"" + command + "\"\n";
    }
}
