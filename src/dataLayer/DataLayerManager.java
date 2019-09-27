package dataLayer;

public class DataLayerManager {

	private static DataLayerManager instance;
	private IDataLayer dataLayer;
	

	public DataLayerManager(IDataLayer dataLayer) {
		super();
		this.dataLayer = dataLayer;
	}

	public static DataLayerManager getInstance() {
		return instance;
	}
	
	public IDataLayer getDataLayer() {
		return dataLayer;
	}
}
