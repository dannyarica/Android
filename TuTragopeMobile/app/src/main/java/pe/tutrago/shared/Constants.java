package pe.tutrago.shared;

/**
 * Created by DArica on 21/10/2015.
 */
public class Constants {

    //Validation messages over Login page
    public final static String errorEmailMessage = "Email, cannot be empty or format is invalid";
    public final static String errorPasswordMessage = "Password, must have "+ Constants.minCharactersPassword + " characters at least";


    //Login page max characters for Password
    public final static int minCharactersPassword = 3;

    //Auth Token Generated
    public static String TOKEN_GENERATED = "";
}
