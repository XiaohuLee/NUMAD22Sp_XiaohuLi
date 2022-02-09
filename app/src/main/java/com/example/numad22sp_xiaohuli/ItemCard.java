package com.example.numad22sp_xiaohuli;

public class ItemCard implements ItemClickListener {

    private final String itemName;
    private final String itemDesc;
    private boolean isChecked;

    //Constructor
    public ItemCard(String itemName, String itemDesc,boolean isChecked) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.isChecked = isChecked;
    }

    //Getters for the imageSource, itemName and itemDesc

    public String getItemDesc() {
        return itemDesc;
    }

    public String getItemName() {
        return itemName + (isChecked ? "(checked)" : "");
    }

    public boolean getStatus() {
        return isChecked;
    }


    @Override
    public void onItemClick(int position) {
        isChecked = !isChecked;
    }

    @Override
    public void onCheckBoxClick(int position) {
        isChecked = !isChecked;
    }

}
