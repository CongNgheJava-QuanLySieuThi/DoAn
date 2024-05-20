package gui.bean;

/**
 *
 * @author Yuuta
 */
public class Statistics {

    private Integer count;
    private Double total;

    public Statistics(Integer count, Double total) {
        this.count = count;
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
