package entities;

public class Author {
    private int authorID;
    private String name;
    private String surname;

    public Author(int authorID, String name, String surname) {
        this.authorID = authorID;
        this.name = name;
        this.surname = surname;
    }

    // Getters and Setters
    public int getAuthorID() {
        return authorID;
    }
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
