package cz.lamorak.weather.android.entity;

public class NavigationDrawerItem {

    public static final int TODAY = 1;
    public static final int FORECAST = 2;

    private int id;
    private int iconResource;
    private int textResource;

    public NavigationDrawerItem(int id, int iconResource, int textResource) {
        this.id = id;
        this.iconResource = iconResource;
        this.textResource = textResource;
    }

    public int getId() {
        return id;
    }

    public int getIconResource() {
        return iconResource;
    }

    public int getTextResource() {
        return textResource;
    }
}
