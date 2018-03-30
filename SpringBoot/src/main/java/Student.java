
import java.util.List;

public class Student {

    private String name;
    private List<String> sub;
    private List<Integer> mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSub() {
        return sub;
    }

    public void setSub(List<String> sub) {
        this.sub = sub;
    }

    public List<Integer> getMark() {
        return mark;
    }

    public void setMark(List<Integer> mark) {
        this.mark = mark;
    }
}
