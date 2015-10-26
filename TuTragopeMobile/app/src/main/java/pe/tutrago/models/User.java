package pe.tutrago.models;

/**
 * Created by DArica on 24/10/2015.
 */
public class User {
    private int _userId;

    public String get_userImageUrl() {
        return _userImageUrl;
    }

    public void set_userImageUrl(String _userImageUrl) {
        this._userImageUrl = _userImageUrl;
    }

    public int get_userId() {
        return _userId;
    }

    public void set_userId(int _userId) {
        this._userId = _userId;
    }

    public String get_userProvider() {
        return _userProvider;
    }

    public void set_userProvider(String _userProvider) {
        this._userProvider = _userProvider;
    }

    public String get_userProviderId() {
        return _userProviderId;
    }

    public void set_userProviderId(String _userProviderId) {
        this._userProviderId = _userProviderId;
    }

    public String get_userFirstname() {
        return _userFirstname;
    }

    public void set_userFirstname(String _userFirstname) {
        this._userFirstname = _userFirstname;
    }

    public String get_userLastname() {
        return _userLastname;
    }

    public void set_userLastname(String _userLastname) {
        this._userLastname = _userLastname;
    }

    public String get_userFullname() {
        return _userFullname;
    }

    public void set_userFullname(String _userFullname) {
        this._userFullname = _userFullname;
    }

    public String get_userEmail() {
        return _userEmail;
    }

    public void set_userEmail(String _userEmail) {
        this._userEmail = _userEmail;
    }

    public String get_userGender() {
        return _userGender;
    }

    public void set_userGender(String _userGender) {
        this._userGender = _userGender;
    }

    public String get_userBirthday() {
        return _userBirthday;
    }

    public void set_userBirthday(String _userBirthday) {
        this._userBirthday = _userBirthday;
    }

    private String _userProvider;
    private String _userProviderId;
    private String _userFirstname;
    private String _userLastname;
    private String _userFullname;
    private String _userEmail;
    private String _userGender;
    private String _userBirthday;
    private String _userImageUrl;

    public User() {
    }
}
