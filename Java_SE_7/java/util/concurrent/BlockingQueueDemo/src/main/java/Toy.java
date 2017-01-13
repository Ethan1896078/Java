/**
 * desc:
 * Created by huangzhe on 2017/1/11.
 */
public class Toy{
    private int id;

    public int getId() {
        return id;
    }

    public Toy (int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                '}';
    }
}
