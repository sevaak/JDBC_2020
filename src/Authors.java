public class Authors {
    private int authorid;
    private String name;
    private String sname;
    private String bookname;

    public Authors() {
    }

    public Authors(int authorid, String name, String sname, String bookname) {
        this.authorid = authorid;
        this.name = name;
        this.sname = sname;
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "authorid=" + authorid +
                ", name='" + name + '\'' +
                ", sname='" + sname + '\'' +
                ", bookname='" + bookname + '\'' +
                '}';
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
