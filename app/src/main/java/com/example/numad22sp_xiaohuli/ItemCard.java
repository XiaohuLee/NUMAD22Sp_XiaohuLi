package com.example.numad22sp_xiaohuli;

public class ItemCard implements ItemClickListener {

    private final String itemName;
    private final String itemUrl;
    private boolean isClicked;

    //Constructor
    public ItemCard(String itemName, String itemUrl,boolean isClicked) {
        this.itemName = itemName;
        this.itemUrl = itemUrl;
        this.isClicked = isClicked;
    }

    //Getters for itemName and itemUrl

    public String getItemUrl() {
        return itemUrl;
    }

    public String getItemName() {
        return itemName + (isClicked ? "(clicked)" : "");
    }

    public boolean getStatus() {
        return isClicked;
    }

    @Override
    public void onItemClick(int position) {
        isClicked = !isClicked;// when isClicked is true, open a web browser
    }

}
