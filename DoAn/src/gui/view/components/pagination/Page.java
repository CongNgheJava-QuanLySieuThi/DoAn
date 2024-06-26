package gui.view.components.pagination;

import java.util.List;

/**
 *
 * @author Yuuta
 */
public class Page {

    private int current;
    private boolean previous;
    private boolean next;
    private List<Object> items;
    private int totalPage;

    public Page() {
    }

    public Page(int current, boolean previous, boolean next, List<Object> items, int totalPage) {
        this.current = current;
        this.previous = previous;
        this.next = next;
        this.items = items;
        this.totalPage = totalPage;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean isPrevious() {
        return previous;
    }

    public void setPrevious(boolean previous) {
        this.previous = previous;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "current: " + current + "\n" + previous + " " + items.toString() + " " + next;
    }

    public static class Dots {

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public Dots(int page) {
            this.page = page;
        }

        public Dots() {
        }

        private int page;

        @Override
        public String toString() {
            return "...";
        }
    }
}
