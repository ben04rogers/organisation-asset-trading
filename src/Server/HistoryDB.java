package Server;

import Client.TradeHistory;

import java.util.ArrayList;

public interface HistoryDB {

    /**
     * Add a new recorded trade
     * @param trade An instance of the TradeHistory class with details of the trade
     */
    public void addToHistory(TradeHistory trade);

    /**
     * Get the trading history of a specific asset
     * @param assetName The name of the asset
     * @return A list of int arrays, each individual array contains the quantity and credits of the trade
     */
    public ArrayList<int[]> getHistoryOfAsset(String assetName);
}