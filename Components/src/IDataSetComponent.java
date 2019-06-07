
public interface IDataSetComponent {
	public String getDataSource();
	public void setDataSource(String dataSource);
	public String[] requestAttributes();
	public String[][] requestInstances();
	public void readDS();
}
