package dataLayer;

public class DataLayerManager {

	private static DataLayerManager instance;
	private IDataLayer dataLayer;
	
	private void DataLayerManager() {
	}
	
	public static DataLayerManager getInstance() {
		return instance;
	}
	
	public IDataLayer getDataLayer() {
		return dataLayer;
	}
}
